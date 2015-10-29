package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import com.codefactoring.jokeprovider.backend.jokeApi.JokeApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

import codefactoring.com.jokeviewer.JokeView;

public class GetJokeAsyncTask extends AsyncTask<Context, Void, String> {

    private static JokeApi jokeApiService = null;

    private Callback callback;

    private Context context;

    public GetJokeAsyncTask(Callback callback) {
        this.callback = callback;
    }

    @Override
    protected String doInBackground(Context... params) {
        if (jokeApiService == null) {
            final JokeApi.Builder builder = new JokeApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            jokeApiService = builder.build();
        }

        context = params[0];

        try {
            return jokeApiService.tellAJoke().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String joke) {
        final Intent intent = JokeView.makeIntent(context, joke);
        context.startActivity(intent);
        callback.done();
    }

    public interface Callback{
        void done();
    }
}

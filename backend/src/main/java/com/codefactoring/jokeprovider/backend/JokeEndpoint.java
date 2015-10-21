/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.codefactoring.jokeprovider.backend;

import com.codefactoring.jokeprovider.JokeFactory;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

/**
 * An endpoint class we are exposing
 */
@Api(
        name = "jokeApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.jokeprovider.codefactoring.com",
                ownerName = "backend.jokeprovider.codefactoring.com",
                packagePath = ""
        )
)
public class JokeEndpoint {

    @ApiMethod(name = "tellAJoke")
    public JokeBean tellAJoke() {
        final JokeBean response = new JokeBean();
        response.setData(new JokeFactory().tellAJoke());
        return response;
    }
}

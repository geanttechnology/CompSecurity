// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.cds;

import android.content.Context;
import com.amazon.clouddrive.auth.AuthenticatedURLConnectionFactory;
import com.amazon.gallery.framework.network.auth.AmazonHttpClientFactory;
import com.amazon.identity.auth.device.api.AuthenticatedURLConnection;
import com.amazon.identity.auth.device.api.AuthenticationMethodFactory;
import com.amazon.identity.auth.device.api.AuthenticationType;
import com.squareup.okhttp.OkUrlFactory;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class MAPAuthenticatedURLConnectionFactory
    implements AuthenticatedURLConnectionFactory
{

    private final AuthenticationMethodFactory methodFactory;
    private final OkUrlFactory okUrlFactory = new OkUrlFactory(AmazonHttpClientFactory.getOkHttpClient());

    public MAPAuthenticatedURLConnectionFactory(Context context, String s)
    {
        methodFactory = new AuthenticationMethodFactory(context, s);
    }

    public HttpURLConnection createHttpURLConnection(URL url)
        throws IOException
    {
        com.amazon.identity.auth.device.api.AuthenticationMethod authenticationmethod = methodFactory.newAuthenticationMethod(AuthenticationType.OAuth);
        return AuthenticatedURLConnection.openConnection(okUrlFactory.open(url), authenticationmethod);
    }
}

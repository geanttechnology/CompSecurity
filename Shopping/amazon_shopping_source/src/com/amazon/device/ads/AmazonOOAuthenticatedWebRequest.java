// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import com.amazon.identity.auth.device.api.AuthenticatedURLConnection;
import com.amazon.identity.auth.device.api.AuthenticationMethod;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

// Referenced classes of package com.amazon.device.ads:
//            HttpURLConnectionWebRequest

class AmazonOOAuthenticatedWebRequest extends HttpURLConnectionWebRequest
{

    private final AuthenticationMethod authMethod;

    public AmazonOOAuthenticatedWebRequest(AuthenticationMethod authenticationmethod)
    {
        authMethod = authenticationmethod;
    }

    protected HttpURLConnection openConnection(URL url)
        throws IOException
    {
        return AuthenticatedURLConnection.openConnection(url, authMethod);
    }
}

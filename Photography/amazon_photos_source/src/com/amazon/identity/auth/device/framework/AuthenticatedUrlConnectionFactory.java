// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.framework;

import com.amazon.identity.auth.device.api.AuthenticationMethod;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

// Referenced classes of package com.amazon.identity.auth.device.framework:
//            AmazonUrlConnectionHelpers

public class AuthenticatedUrlConnectionFactory
{

    public AuthenticatedUrlConnectionFactory()
    {
    }

    public HttpURLConnection openConnection(URL url, AuthenticationMethod authenticationmethod)
        throws IOException
    {
        return AmazonUrlConnectionHelpers.openConnection(url, authenticationmethod);
    }
}

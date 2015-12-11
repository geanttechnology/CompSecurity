// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.framework.security;

import com.amazon.identity.auth.device.utils.EnvironmentUtils;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

// Referenced classes of package com.amazon.identity.auth.device.framework.security:
//            SSLEnhancementHelper

public final class EnhancedURLConnectionFactory
{

    private EnhancedURLConnectionFactory()
    {
    }

    public static URLConnection createURLConnection(URL url)
        throws IOException
    {
        if (url == null)
        {
            throw new IllegalArgumentException("Null url is not allowed");
        }
        url = url.openConnection();
        if (EnvironmentUtils.isCurrentEnvironmentProd())
        {
            SSLEnhancementHelper.enforceEnhancedSSL(url);
        }
        return url;
    }
}

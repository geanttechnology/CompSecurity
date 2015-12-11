// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.framework.security;

import com.amazon.identity.auth.device.utils.MAPLog;
import java.net.URLConnection;
import javax.net.ssl.HttpsURLConnection;
import org.apache.http.conn.ssl.SSLSocketFactory;

// Referenced classes of package com.amazon.identity.auth.device.framework.security:
//            EnhancedSSLSocketFactory

public final class SSLEnhancementHelper
{

    private static final String TAG = com/amazon/identity/auth/device/framework/security/SSLEnhancementHelper.getName();

    private SSLEnhancementHelper()
    {
    }

    public static void enableSSLEnhancementGlobally()
    {
        HttpsURLConnection.setDefaultSSLSocketFactory(getSSLSocketFactory());
        HttpsURLConnection.setDefaultHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
    }

    static void enforceEnhancedSSL(URLConnection urlconnection)
    {
        if (urlconnection instanceof HttpsURLConnection)
        {
            ((HttpsURLConnection)urlconnection).setSSLSocketFactory(getSSLSocketFactory());
            ((HttpsURLConnection)urlconnection).setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
        }
    }

    private static javax.net.ssl.SSLSocketFactory getSSLSocketFactory()
    {
        Object obj = EnhancedSSLSocketFactory.getInstance();
        if (obj == null)
        {
            try
            {
                throw new RuntimeException("Can not get secure SSL context with certificate pinning");
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                MAPLog.e(TAG, "Failed to perform certificate pinning.", ((Throwable) (obj)));
            }
            throw new AssertionError(obj);
        } else
        {
            return ((javax.net.ssl.SSLSocketFactory) (obj));
        }
    }

}

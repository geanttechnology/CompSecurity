// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.framework.security;

import android.net.SSLCertificateSocketFactory;
import com.amazon.identity.auth.device.utils.MAPLog;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import org.apache.http.conn.ssl.AllowAllHostnameVerifier;

public final class SSLConfiguration
{

    private static final HostnameVerifier DEFAULT_HOSTNAME_VERIFIER = HttpsURLConnection.getDefaultHostnameVerifier();
    private static final SSLSocketFactory DEFAULT_SSL_SOCKET_FACTORY = HttpsURLConnection.getDefaultSSLSocketFactory();
    private static final String TAG = com/amazon/identity/auth/device/framework/security/SSLConfiguration.getName();
    private static final HostnameVerifier TRUST_ALL_HOSTNAME_VERIFIER = new AllowAllHostnameVerifier();
    private static final SSLSocketFactory TRUST_ALL_HOSTS_SOCKET_FACTORY = SSLCertificateSocketFactory.getInsecure(0, null);

    private SSLConfiguration()
    {
    }

    public static void toggleTrustSSLHosts(boolean flag)
    {
        MAPLog.w(TAG, String.format("Attempting to toggle trusting all SSL hosts to %s. This should never happen in production devices.", new Object[] {
            Boolean.valueOf(flag)
        }));
        boolean flag1;
        if (flag)
        {
            flag1 = tryChangeDefaults(TRUST_ALL_HOSTNAME_VERIFIER, TRUST_ALL_HOSTS_SOCKET_FACTORY);
        } else
        {
            flag1 = tryChangeDefaults(DEFAULT_HOSTNAME_VERIFIER, DEFAULT_SSL_SOCKET_FACTORY);
        }
        if (flag1)
        {
            MAPLog.w(TAG, String.format("Toggling trust all ssl hosts. New Value: %s", new Object[] {
                Boolean.toString(flag)
            }));
        }
    }

    private static boolean tryChangeDefaults(HostnameVerifier hostnameverifier, SSLSocketFactory sslsocketfactory)
    {
        boolean flag = false;
        if (HttpsURLConnection.getDefaultHostnameVerifier() != hostnameverifier)
        {
            HttpsURLConnection.setDefaultHostnameVerifier(hostnameverifier);
            flag = true;
        }
        if (HttpsURLConnection.getDefaultSSLSocketFactory() != sslsocketfactory)
        {
            HttpsURLConnection.setDefaultSSLSocketFactory(sslsocketfactory);
            flag = true;
        }
        return flag;
    }

}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

public class EasyX509TrustManager
    implements X509TrustManager
{

    private X509TrustManager iY;

    public EasyX509TrustManager(KeyStore keystore)
        throws NoSuchAlgorithmException, KeyStoreException
    {
        iY = null;
        TrustManagerFactory trustmanagerfactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustmanagerfactory.init(keystore);
        keystore = trustmanagerfactory.getTrustManagers();
        if (keystore.length == 0)
        {
            throw new NoSuchAlgorithmException("no trust manager found");
        } else
        {
            iY = (X509TrustManager)keystore[0];
            return;
        }
    }

    public void checkClientTrusted(X509Certificate ax509certificate[], String s)
        throws CertificateException
    {
        iY.checkClientTrusted(ax509certificate, s);
    }

    public void checkServerTrusted(X509Certificate ax509certificate[], String s)
        throws CertificateException
    {
        if (ax509certificate != null && ax509certificate.length == 1)
        {
            ax509certificate[0].checkValidity();
            return;
        } else
        {
            iY.checkServerTrusted(ax509certificate, s);
            return;
        }
    }

    public X509Certificate[] getAcceptedIssuers()
    {
        return iY.getAcceptedIssuers();
    }
}

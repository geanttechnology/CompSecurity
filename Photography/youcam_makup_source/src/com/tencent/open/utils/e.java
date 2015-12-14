// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.open.utils;

import java.io.FileInputStream;
import java.security.KeyStore;
import java.security.cert.X509Certificate;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

public class e
    implements X509TrustManager
{

    X509TrustManager a;

    e()
    {
        Object obj1;
        FileInputStream fileinputstream;
        Object obj;
        try
        {
            obj = KeyStore.getInstance("JKS");
        }
        catch (Exception exception)
        {
            exception = null;
        }
        if (obj == null) goto _L2; else goto _L1
_L1:
        fileinputstream = new FileInputStream("trustedCerts");
        ((KeyStore) (obj)).load(fileinputstream, "passphrase".toCharArray());
        obj1 = TrustManagerFactory.getInstance("SunX509", "SunJSSE");
        ((TrustManagerFactory) (obj1)).init(((KeyStore) (obj)));
        obj = ((TrustManagerFactory) (obj1)).getTrustManagers();
        obj1 = obj;
        if (fileinputstream != null)
        {
            fileinputstream.close();
            obj1 = obj;
        }
        break MISSING_BLOCK_LABEL_64;
        Exception exception1;
        exception1;
        obj1 = null;
_L3:
        if (obj1 != null)
        {
            ((FileInputStream) (obj1)).close();
        }
        throw exception1;
_L2:
        TrustManagerFactory trustmanagerfactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustmanagerfactory.init((KeyStore)null);
        obj1 = trustmanagerfactory.getTrustManagers();
        for (int i = 0; i < obj1.length; i++)
        {
            if (obj1[i] instanceof X509TrustManager)
            {
                a = (X509TrustManager)obj1[i];
                return;
            }
        }

        throw new Exception("Couldn't initialize");
        trustmanagerfactory;
        obj1 = fileinputstream;
          goto _L3
    }

    public void checkClientTrusted(X509Certificate ax509certificate[], String s)
    {
        a.checkClientTrusted(ax509certificate, s);
    }

    public void checkServerTrusted(X509Certificate ax509certificate[], String s)
    {
        a.checkServerTrusted(ax509certificate, s);
    }

    public X509Certificate[] getAcceptedIssuers()
    {
        return a.getAcceptedIssuers();
    }
}

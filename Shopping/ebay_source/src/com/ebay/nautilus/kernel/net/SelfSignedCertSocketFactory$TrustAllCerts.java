// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel.net;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

// Referenced classes of package com.ebay.nautilus.kernel.net:
//            SelfSignedCertSocketFactory

public static class 
    implements X509TrustManager
{

    private static final X509Certificate _acceptedIssuers[] = new X509Certificate[0];

    public void checkClientTrusted(X509Certificate ax509certificate[], String s)
        throws CertificateException
    {
    }

    public void checkServerTrusted(X509Certificate ax509certificate[], String s)
        throws CertificateException
    {
    }

    public X509Certificate[] getAcceptedIssuers()
    {
        return _acceptedIssuers;
    }

    public boolean isClientTrusted(X509Certificate ax509certificate[])
    {
        return true;
    }

    public boolean isServerTrusted(X509Certificate ax509certificate[])
    {
        return true;
    }


    public ()
    {
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package netswipe;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

// Referenced classes of package netswipe:
//            cs, cr

class ct
    implements X509TrustManager
{

    final cr a;
    final cs b;

    ct(cs cs1, cr cr)
    {
        b = cs1;
        a = cr;
        super();
    }

    public void checkClientTrusted(X509Certificate ax509certificate[], String s)
        throws CertificateException
    {
    }

    public void checkServerTrusted(X509Certificate ax509certificate[], String s)
        throws CertificateException
    {
        if (ax509certificate.length < 2)
        {
            throw new CertificateException("SSL Certificate Chain is not sufficient");
        } else
        {
            cs.a(b, ax509certificate[0]);
            return;
        }
    }

    public X509Certificate[] getAcceptedIssuers()
    {
        return null;
    }
}

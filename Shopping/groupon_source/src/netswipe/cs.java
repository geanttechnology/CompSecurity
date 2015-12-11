// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package netswipe;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.KeyFactory;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.X509Certificate;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import org.apache.http.conn.ssl.SSLSocketFactory;

// Referenced classes of package netswipe:
//            ct, cr, dh

class cs extends SSLSocketFactory
{

    SSLContext a;
    final cr b;

    public cs(cr cr1, KeyStore keystore)
        throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException
    {
        b = cr1;
        super(keystore);
        a = SSLContext.getInstance("TLS");
        cr1 = new ct(this, cr1);
        a.init(null, new TrustManager[] {
            cr1
        }, null);
    }

    private void a(X509Certificate x509certificate)
        throws CertificateException
    {
        X509EncodedKeySpec x509encodedkeyspec;
        try
        {
            x509certificate.checkValidity();
        }
        catch (CertificateNotYetValidException certificatenotyetvalidexception)
        {
            try
            {
                dh.c("SSL Certificate is not yet valid");
            }
            // Misplaced declaration of an exception variable
            catch (X509Certificate x509certificate)
            {
                throw new CertificateException("SSL Certificate match error");
            }
        }
        x509encodedkeyspec = new X509EncodedKeySpec(cr.a(b, cr.a()));
        x509certificate.verify(KeyFactory.getInstance("RSA").generatePublic(x509encodedkeyspec));
        if (cr.a(b).length != 0)
        {
            x509certificate = x509certificate.getPublicKey().getEncoded();
            if (!Arrays.equals(cr.a(b), x509certificate))
            {
                throw new Exception("SSL pinning failed!");
            }
        }
    }

    static void a(cs cs1, X509Certificate x509certificate)
        throws CertificateException
    {
        cs1.a(x509certificate);
    }

    public Socket createSocket()
        throws IOException
    {
        return a.getSocketFactory().createSocket();
    }

    public Socket createSocket(Socket socket, String s, int i, boolean flag)
        throws IOException, UnknownHostException
    {
        return a.getSocketFactory().createSocket(socket, s, i, flag);
    }
}

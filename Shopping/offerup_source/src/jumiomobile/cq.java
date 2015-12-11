// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.X509Certificate;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import javax.net.ssl.X509TrustManager;

// Referenced classes of package jumiomobile:
//            ag, ab

public class cq
    implements X509TrustManager
{

    private static final String a;
    private static String c;
    private byte b[];

    public cq(String s)
    {
        b = a(s);
    }

    private void a(X509Certificate x509certificate)
    {
        try
        {
            x509certificate.checkValidity();
        }
        catch (CertificateNotYetValidException certificatenotyetvalidexception)
        {
            try
            {
                ab.e("JumioTrustManager", "SSL Certificate is not yet valid");
            }
            // Misplaced declaration of an exception variable
            catch (X509Certificate x509certificate)
            {
                throw new CertificateException("SSL Certificate match error", x509certificate);
            }
        }
        if (c.length() != 0)
        {
            X509EncodedKeySpec x509encodedkeyspec = new X509EncodedKeySpec(a(c));
            x509certificate.verify(KeyFactory.getInstance("RSA").generatePublic(x509encodedkeyspec));
        }
        if (b != null && b.length % 2 != 0)
        {
            throw new Exception("public key must have a length multiple of 2!");
        }
        if (b != null && b.length != 0 && b.length % 2 == 0)
        {
            x509certificate = x509certificate.getPublicKey().getEncoded();
            if (!Arrays.equals(b, x509certificate))
            {
                throw new Exception("SSL pinning failed!");
            }
        }
        return;
    }

    private byte[] a(String s)
    {
        byte abyte0[] = new byte[s.length() / 2];
        for (int i = 0; i < abyte0.length; i++)
        {
            abyte0[i] = (byte)((Character.digit(s.charAt(i << 1), 16) << 4) + Character.digit(s.charAt((i << 1) + 1), 16));
        }

        return abyte0;
    }

    public void checkClientTrusted(X509Certificate ax509certificate[], String s)
    {
    }

    public void checkServerTrusted(X509Certificate ax509certificate[], String s)
    {
        if (ax509certificate.length < 2)
        {
            throw new CertificateException("SSL Certificate Chain is not sufficient");
        } else
        {
            a(ax509certificate[0]);
            return;
        }
    }

    public X509Certificate[] getAcceptedIssuers()
    {
        return new X509Certificate[0];
    }

    static 
    {
        String s = ag.a(new byte[] {
            -62, 31, 109, 17, -116, 60, -83, 125, 8, 91, 
            -47, 0, -103, 75, 105, 78, 103, -73, 72, -24, 
            -69, -107, -26, -64, 106, -94, -1, -55, -13, -22, 
            -108, 39, -103, -65, -82, -102, -37, -59, 67, -62, 
            -39, 9, -9, 40, 4, 11, -33, 47, 35, -108, 
            -93, -92, -18, -38, -122, 33, -127, 104, -126, 22, 
            -97, -38, 86, -89, 23, 122, 63, 46, 12, -87, 
            77, 58, -28, -100, -59, -24, 55, 80, 28, -66, 
            -33, -69, 119, -22, -34, 46, -47, 92, 92, -58, 
            -88, -111, -54, -96, 33, 34, 49, -9, -124, -20, 
            -69, 15, 74, -104, -32, -30, 48, -127, -3, -115, 
            -27, 43, -49, 39, -55, 57, -12, 30, 75, -14, 
            49, -116, 35, -69, -112, -107, 81, -112, 117, 44, 
            -126, 72, 1, 27, 11, 41, -49, -9, -75, -17, 
            -59, -28, -64, -69, -98, -45, 1, -12, 15, -33, 
            -17, -46, -27, -12, -99, 22, 108, -86, 63, 61, 
            -92, 109, 47, -126, -57, 106, -73, -61, -74, 60, 
            5, 5, -41, 61, -23, 123, 105, -29, -1, 2, 
            127, -106, -31, 36, 51, -26, -32, 104, -115, 28, 
            -27, 123, 119, 71, 115, 52, 30, -101, -40, 78, 
            -39, -105, 85, 97, -116, 97, -3, -22, 1, 50, 
            107, 43, 10, -24, -6, 79, -95, 11, -105, -123, 
            43, 11, -118, -46, -57, -19, -105, 73, 7, 45, 
            -121, -94, -127, -6, 59, 38, 14, -88, 80, -42, 
            -47, 86, -14, -73, 123, -99, 60, -43, -32, 69, 
            -16, -35, -32, -126, 114, 29, 16, 29, 65, -53, 
            -56, 11, -15, -21, 86, 105, 63, -62, -59, -78, 
            -99, 22, 119, 80, 12, 12, 64, 34, 63, 7, 
            74, -91, -56, -98, 97, -16, -3, 15, -17, 59, 
            35, 107, -79, 35, 96, -95, -115, -103, 106, -17, 
            -118, 96, 9, 58, 115, 123, -102, -123, 91, -113, 
            -79, -128, -30, -117, -77, 64, -122, -59, -27, 60, 
            -64, 28, 57, 83, 41, -64, -124, -11, 103, -116, 
            22, -2, 60, -68, 29, -84, 79, -123, 38, 17, 
            -24, 95, -78, -32, 8, 17, -56, -119, -32, 42, 
            83, -85, 108, -4, -93, -4, 75, -12, 103, -74, 
            -102, 29, -42, 8, 4, 102, -43, 50, 5, 1, 
            68, -16, -87, 32, -123, -61, -105, 52, 103, -110, 
            -47, 119, 51, 55, -67, -36, 44, 1, 100, -78, 
            -3, 117, 95, 84, -3, 90, -34, -49, -80, -103, 
            73, 76, 51, -59, -115, -3, -89, 46, -78, 94, 
            13, 40, 123, 57, -114, 50, -113, -87, 60, 36, 
            -89, -67, -52, -73, 121, 27, -80, -93, 12, 120, 
            67, 75, -103, -115, 65, 97, 54, 73, 2, 43, 
            112, 119, 72, -52, -24, -124, 6, 50, -77, 37, 
            48, -81, -123, 109, 42, -21, 108, 35, 102, 121, 
            24, -120, -124, -60, 49, -71, 44, 1, -75, -6, 
            -23, 122, -62, -83, -75, -118, -108, 5, 52, -44, 
            -23, 32, 58, -3, -3, 40, 116, 6, 27, -52, 
            98, -102, 26, 124, 69, -117, -40, 19, 89, 70, 
            68, -89, -15, -123, -8, 104, -100, 116, -48, -115, 
            -54, -73, 15, 91, 71, -36, -105, -81, 101, 39, 
            -7, 116, 106, 51, -111, -89, -107, 6, -39, -36, 
            -104, 66, 55, -66, 81, 92, -8, -33, -102, -2, 
            -120, 110, -104, 108, -29, -35, 57, -60, 96, -115, 
            -121, -92, -87, 79, 123, 42, -47, -116, -97, -20, 
            -55, 19, 108, 56, -63, 3, -18, 9, 62, -4, 
            -5, 89, -61, -11, -119, 44, -43, 45, 68, 2, 
            -73, 85, 85, -118, -101, -128, -17, 4
        }, 0x3802532b80b2a5cbL);
        a = s;
        c = s;
    }
}

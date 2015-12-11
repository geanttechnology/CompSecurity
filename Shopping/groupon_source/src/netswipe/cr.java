// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package netswipe;

import java.security.KeyStore;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.SingleClientConnManager;
import org.apache.http.params.HttpParams;

// Referenced classes of package netswipe:
//            di, cs

public class cr extends DefaultHttpClient
{

    private static final String b = di.a(new byte[] {
        -58, -24, 4, -85, 32, -121, 1, -128, 100, -101, 
        -89, 91, 52, 101, 124, -42, -14, 34, 21, 105, 
        -43, 26, -28, 8, -105, -2, -93, 58, -108, 105, 
        17, 46, -126, 70, 12, 23, 18, 69, 5, 3, 
        -73, -8, -52, -88, 85, -76, 38, -5, -3, 46, 
        57, -110, -128, 84, 32, 60, 36, 50, 64, -76, 
        -74, -127, -8, 17, 104, -90, 65, 64, 120, -78, 
        -96, -99, 58, -72, -107, -8, 21, -29, -77, -60, 
        -119, -34, 42, -44, -89, 54, 55, -117, 33, -8, 
        -16, 92, 59, 67, -94, -73, -55, -46, 33, 82, 
        34, -62, 108, 5, 63, 67, -29, 125, -82, -76, 
        43, -39, -96, -13, 66, 67, 125, 51, -84, -32, 
        111, 63, 54, 12, 58, 59, -32, -78, 47, 46, 
        88, -94, 61, 123, -74, -49, 13, -96, 15, -104, 
        -60, 82, -22, -52, 12, -118, 50, -15, -83, -64, 
        -50, 117, -17, 87, 28, 28, -104, -118, -76, 30, 
        80, -10, 95, -23, 84, -9, -6, -34, 5, -102, 
        -55, 117, -92, 15, -81, -6, 53, -37, -2, -62, 
        -17, -76, 9, 16, -127, -107, 100, -76, 82, 92, 
        0, 88, 18, 81, 38, 91, -108, -72, -70, 106, 
        43, -99, -47, -115, -15, 84, -122, 80, 74, -107, 
        -91, -32, 53, -83, -111, -2, -125, -41, 74, 50, 
        -60, 48, -33, 80, 7, 88, 82, -20, -66, 35, 
        55, -125, -27, 50, 60, -1, 6, 95, -20, -72, 
        37, 121, 25, 114, -59, -120, 13, 116, -12, -82, 
        49, -59, -49, -61, -48, -51, -31, 32, 62, -32, 
        61, 58, -52, -112, 33, 60, 120, -19, 108, 29, 
        79, 95, -91, 92, -108, 30, -38, 124, -13, -76, 
        -5, 119, -14, 93, -19, -78, -1, 78, 116, -53, 
        49, -33, -92, -73, 50, 22, -111, -17, 11, -75, 
        81, -118, 94, -98, -74, -42, 95, 59, 36, -97, 
        -43, -88, 106, -113, -73, 38, 65, 68, -54, -125, 
        -45, 101, 18, 39, 92, -94, 97, -45, 79, 85, 
        -108, -14, -3, 106, 47, 109, 8, 88, 53, -30, 
        111, -117, -43, -57, 45, -62, 67, -37, -98, -35, 
        -68, 72, 15, -52, -45, 75, -2, 87, -43, -104, 
        94, -20, 27, -57, 38, 33, -16, -83, -79, 52, 
        12, -68, -94, -101, 26, 108, -122, 26, -27, -58, 
        40, 127, -3, -66, 118, 16, 124, 77, 91, -76, 
        58, -107, -123, -8, 101, -51, -7, 118, 89, 114, 
        -71, -121, 88, -45, -45, -28, -123, 91, 109, 75, 
        73, -17, 18, 8, 117, 65, 8, -9, 9, 92, 
        72, 74, -44, -40, 34, 15, 31, 114, -97, 57, 
        -128, 6, -111, 117, -88, -71, 7, -6, -92, -22, 
        41, 127, 45, 60, -39, 44, 120, 32, 119, 111, 
        95, -4, -7, -115, -57, -35, 87, 72, -50, -56, 
        90, 80, -70, 113, 60, -102, 107, 2, -1, 3, 
        -95, -31, 45, 68, 66, 8, -98, 38, -127, 31, 
        -107, 47, -54, 50, 123, -19, -25, -31, 110, 61, 
        -96, 87, 127, 120, 76, 41, -126, 77, 80, -46, 
        44, 39, -56, -78, 18, -59, -99, 55, 105, 50, 
        -39, 94, 122, -115, -38, -26, -86, 79, 120, 85, 
        -57, 103, -82, -106, 49, -68, -74, 121, 41, 31, 
        51, 32, -47, 62, -74, 42, 123, -49, -50, 13, 
        -124, 69, -125, 93, 92, -32, 95, 118, -26, -117, 
        -94, -125, -42, -72, 48, -114, -17, -54, -12, -124, 
        -125, -41, 109, -4, -12, 86, -36, 125, 68, 97, 
        88, 87, -44, 14, -43, -49, 97, 57, 31, -59, 
        23, 124, 86, 99, 28, 71, 38, 33
    }, 0x8fc51712ebcb54f2L);
    private byte a[];

    public cr(HttpParams httpparams, String s)
    {
        super(httpparams);
        a = null;
        a = a(s);
    }

    static String a()
    {
        return b;
    }

    private byte[] a(String s)
    {
        byte abyte0[] = new byte[s.length() / 2];
        for (int i = 0; i < abyte0.length; i++)
        {
            abyte0[i] = (byte)((Character.digit(s.charAt(i * 2), 16) << 4) + Character.digit(s.charAt(i * 2 + 1), 16));
        }

        return abyte0;
    }

    static byte[] a(cr cr1)
    {
        return cr1.a;
    }

    static byte[] a(cr cr1, String s)
    {
        return cr1.a(s);
    }

    protected ClientConnectionManager createClientConnectionManager()
    {
        Object obj;
        try
        {
            obj = KeyStore.getInstance(KeyStore.getDefaultType());
            ((KeyStore) (obj)).load(null, null);
            obj = new cs(this, ((KeyStore) (obj)));
            ((SSLSocketFactory) (obj)).setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
            SchemeRegistry schemeregistry = new SchemeRegistry();
            schemeregistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
            schemeregistry.register(new Scheme("https", ((org.apache.http.conn.scheme.SocketFactory) (obj)), 443));
            obj = new SingleClientConnManager(getParams(), schemeregistry);
        }
        catch (Exception exception)
        {
            return null;
        }
        return ((ClientConnectionManager) (obj));
    }

}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.os.AsyncTask;
import com.jumio.mobile.sdk.enums.JumioDataCenter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Stack;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;

// Referenced classes of package jumiomobile:
//            ag, cq, ai

public abstract class cp
{

    private static final String d = ag.a(new byte[] {
        -87, 65, -8, 123, 67, -87, -45, -39, -120, 10, 
        -12, 35, -28, -16, 40, -113, -3, -46, 1, 21, 
        8, 77, 5, 32, 56, -70, -75, -72, -81, 119, 
        48, 80, -119, 64, -17, 53, -128, -5, 19, -111, 
        -83, 79, 38, 122, -88, 86, 98, -9, 23, 66, 
        -79, 64, 75, -2, -104, 70, 57, -128, 109, -92, 
        87, -95, 79, -39, -81, -51, 111, -100, 108, -10, 
        39, 43, -45, 119, -57, 81, 57, 119, 109, 29, 
        -74, 44, -77, -44, -127, -108, 125, -21, -7, 80, 
        -89, 1, -115, 20, 54, 115, 11, 76, 11, -26, 
        -50, 44, 117, 81, -52, 107, -84, 85, 76, -55, 
        -71, -63, -13, -101, -123, 80, 35, -117, -100, 36, 
        2, -41, 72, -75, -31, 43, -85, 67, 10, 67, 
        -117, 92, -110, 23, -26, 82, -43, -105, 114, -5, 
        85, -35, 0, -76, 75, 111, 16, 5, 22, 68, 
        -124, -39, -73, 50, -71, -16, 94, -110, 12, 124, 
        -106, -5, -48, -122, 8, -58, 38, 123, 113, -117, 
        111, 76, -18, -76, -55, -109, 47, -91, -82, -20, 
        -12, 95, -74, 2, -4, 73, 82, 59, -125, -9, 
        -64, 40, 97, 100, 67, -99, 116, -80, 65, -57, 
        92, -30, -63, 106, 106, 90, -72, 85, -46, 113, 
        33, -25, -93, 69, -104, -32, 49, 27, 44, -32, 
        -13, -3, 105, 93, -1, -51, 77, -91, 62, 95, 
        5, 14, -54, 118, 92, -77, 115, 89, 91, -109, 
        -103, 73, 12, 27, 84, 40, 40, 8, 25, 56, 
        -128, 8, -33, 96, 29, -116, 2, 3, 111, -15, 
        84, 65, 34, -52, 35, 116, -48, -65, 49, -14, 
        -101, -120, 0, -111, 101, 56, -106, -79, 30, 72, 
        -47, 42, -97, 114, 39, -93, -80, -51, -54, -99, 
        10, -2, 119, 18, 22, -105, -100, -107, 17, -83, 
        86, -121, -29, -113, 69, -53, 33, -38, 32, 65, 
        -123, -124, 43, 127, 83, -78, -99, 82, -66, 67, 
        -34, -51, -64, 112, -39, 99, -87, 110, 125, 25, 
        -52, -33, 117, -93, 15, 79, 125, -60, 5, -116, 
        33, -28, 100, -68, 41, -59, 43, 96, 99, -1, 
        124, 126, 84, 98, -9, 70, -3, 75, 101, 92, 
        23, 48, -12, -56, 101, -26, 61, 90, -54, -30, 
        107, 54, 3, -62, 92, -24, -50, -10, -97, 15, 
        91, -53, 112, 117, -119, 2, 38, -71, 72, 41, 
        93, 8, -119, 105, 86, 105, -30, -80, -61, 99, 
        -62, -120, 114, -57, -37, -86, -88, 0, -9, 34, 
        -104, 66, 65, -62, 49, -19, -7, -53, -94, -13, 
        119, -51, 101, 9, 28, 33, 43, -39, 5, 6, 
        62, 27, -99, -78, -45, 56, -52, 115, 104, -49, 
        -23, 106, 126, -128, -11, -48, -35, 88, 123, -98, 
        -74, -47, 72, 92, -118, 95, -21, -112, 3, -62, 
        -19, 46, -3, 121, 73, 84, 91, 6, 34, -41, 
        20, 126, 89, -32, -17, 0, 99, -68, -99, -33, 
        50, 19, -106, -78, -69, -62, 16, -121, -98, -84, 
        1, -48, -125, -55, -8, 13, 85, -82, 76, -68, 
        -99, 66, 87, 41, -61, -68, -123, -1, -103, 127, 
        -71, -127, 28, -127, 122, -14, 64, -116, -55, 47, 
        44, -94, -11, 51, 67, -96, 35, 5, 22, -21, 
        -89, -49, 82, 40, -27, -12, -33, -57, -126, 31, 
        -32, -101, -5, -41, -58, 50, 78, 87, -85, 122, 
        -109, -111, 93, 4, -97, 36, 87, -3, -6, 73, 
        -13, 84, 47, 105, 25, 80, 118, -117, 13, 11, 
        -86, -97, 27, -102, 57, 99, 63, 11, 122, -75, 
        11, 106, 70, -1, 109, 44, -82, -7
    }, 0x3f1a52e3f6577e04L);
    private static final String e = ag.a(new byte[] {
        -18, -45, -96, -63, 72, -104, 61, 4, 68, 18, 
        -115, 15, 97, -117, 41, -56, -26, -47, 78, -29, 
        83, 98, -9, 78, 70, -69, 77, -39, -33, -121, 
        -101, -22, -69, -60, 76, 55, -26, 72, -100, 22, 
        50, -90, -8, -80, 3, -81, 25, 65, -63, -20, 
        99, -88, -40, 111, -78, 18, 96, 118, -79, -39, 
        103, 7, -33, 104, 21, 38, 110, 8, 108, -105, 
        114, 115, 45, 4, 7, 80, -51, 26, 28, -34, 
        101, 117, 96, 5, 7, -68, -32, -126, -128, 27, 
        86, -82, 71, -100, 109, -127, -118, 88, -46, -65, 
        -5, -74, 104, -57, 127, -76, 28, 108, 123, -117, 
        38, 77, -56, -85, 71, 104, 13, 8, -96, 59, 
        100, 88, 116, 82, -30, 41, 3, 89, 34, 106, 
        -91, -117, -86, 114, 90, 118, -15, -37, -11, 67, 
        -42, 80, 4, 39, -23, -19, -99, 24, 121, -116, 
        -105, -49, 80, 122, 9, -122, 109, -75, 82, -78, 
        -77, -86, -39, 12, -21, 1, -121, 43, 13, 8, 
        70, -122, 75, 5, -48, 65, -104, -56, -128, 102, 
        -25, 14, 78, 123, 120, 36, 39, 82, 91, -43, 
        4, -34, 42, -104, 112, -119, -43, 45, 34, 35, 
        -76, 116, 72, -1, -115, -41, -90, -6, 18, 74, 
        118, -15, 0, -114, -112, 112, -97, 13, -88, 99, 
        82, -74, 1, 70, -121, 64, -98, -40, 119, 119, 
        -112, -85, -60, 7, 91, 90, 91, 58, -25, -49, 
        69, 66, -51, -58, -113, 122, -121, -70, 42, -43, 
        -86, 83, -96, -31, 62, -51, -38, 7, -37, 122, 
        84, 50, -29, -23, -105, -9, 10, -12, -88, 26, 
        -65, 56, -25, 109, -120, 48, 100, -56, -107, -18, 
        98, -29, -31, -92, -95, -99, 126, 42, -86, -86, 
        -33, -108, -74, 55, 43, -120, 65, 56, -23, -126, 
        -61, 34, -17, -57, -58, 72, -124, 77, 28, -20, 
        -88, -72, -93, -32, 52, -38, -66, -77, 78, 50, 
        -74, -24, 68, 70, -6, -71, -127, -126, 126, -70, 
        50, 72, 114, 55, -101, -40, 90, -94, -59, -57, 
        -78, -17, 2, -121, 2, 119, -59, -54, -83, -43, 
        -99, 25, -80, 85, -25, 42, -57, 114, 89, 7, 
        -7, 58, -13, -35, -37, 71, -47, -54, 33, 49, 
        103, -119, -26, -35, -89, -47, -123, 73, 113, -17, 
        39, 59, -68, -28, 38, 16, 117, -121, 60, 65, 
        88, 125, 73, 23, 56, -104, 5, 110, -22, -76, 
        -39, -36, -64, 94, -115, -15, 109, -66, -84, -3, 
        -71, -37, 50, -97, -87, 12, 93, -25, 108, 90, 
        -35, 40, 43, -36, 117, -67, -53, -99, 103, -112, 
        -40, -3, -73, -87, 27, -7, -40, 101, -44, 97, 
        -22, 13, -13, 93, 4, 80, -64, 78, 41, 108, 
        -49, -58, 41, -49, -77, 78, -44, -105, -64, -114, 
        113, 20, 101, -94, -71, 13, 92, 36, -58, 119, 
        4, 104, 16, -113, 76, 25, 38, 64, -40, 99, 
        -19, 92, -96, 102, 9, 1, -128, -24, 49, -32, 
        -119, -40, -78, -121, 37, 94, -52, -15, -112, -25, 
        55, 115, -27, 3, -56, 100, -75, 100, -102, 31, 
        -89, -49, 28, 0, 2, -1, -105, 48, 7, -41, 
        -13, 14, -42, -14, 23, 109, -10, 100, -82, 98, 
        -115, 59, 61, -128, -59, -42, -95, 118, -15, 107, 
        51, -119, 74, 81, -111, 117, 70, 5, 89, 41, 
        -73, -120, -93, -5, -110, 108, 103, 71, 38, -108, 
        -119, -45, 95, -55, 98, -87, 93, 8, 38, -104, 
        -126, -12, 21, 32, 61, -61, 35, 65, -120, -62, 
        75, 87, 66, -2, 83, -84, 124, -63
    }, 0xb86a0dafdc6def0dL);
    private static String f = d;
    private static String g = e;
    protected Stack a;
    protected ai b;
    protected String c;

    public cp()
    {
        c = null;
        a = new Stack();
    }

    private String a(InputStream inputstream)
    {
        Object obj;
        char ac[];
        if (inputstream == null)
        {
            break MISSING_BLOCK_LABEL_79;
        }
        obj = new StringWriter();
        ac = new char[1024];
        BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(inputstream, "UTF-8"));
_L1:
        int i = bufferedreader.read(ac);
        if (i == -1)
        {
            break MISSING_BLOCK_LABEL_70;
        }
        ((Writer) (obj)).write(ac, 0, i);
          goto _L1
        obj;
        inputstream.close();
        throw obj;
        inputstream.close();
        return obj.toString();
        return null;
    }

    protected String a(HttpURLConnection httpurlconnection)
    {
        if (httpurlconnection.getResponseCode() == 200)
        {
            httpurlconnection = httpurlconnection.getInputStream();
        } else
        {
            httpurlconnection = httpurlconnection.getErrorStream();
        }
        return a(((InputStream) (httpurlconnection)));
    }

    protected HttpURLConnection a(String s, URL url)
    {
        if (!url.toString().contains("https://")) goto _L2; else goto _L1
_L1:
        HttpsURLConnection httpsurlconnection;
        cq cq1;
        cq1 = new cq(e());
        httpsurlconnection = (HttpsURLConnection)url.openConnection();
        if (android.os.Build.VERSION.SDK_INT < 16) goto _L4; else goto _L3
_L3:
        url = SSLContext.getInstance("TLSv1.2");
_L8:
        url.init(null, new TrustManager[] {
            cq1
        }, null);
        ((HttpsURLConnection)httpsurlconnection).setSSLSocketFactory(url.getSocketFactory());
        url = httpsurlconnection;
_L6:
        if (s != null)
        {
            try
            {
                url.setRequestMethod(s);
                if (!url.getRequestMethod().equals(s))
                {
                    throw new AssertionError();
                }
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s.printStackTrace();
                return null;
            }
        }
          goto _L5
_L4:
        url = SSLContext.getInstance("TLS");
        continue; /* Loop/switch isn't completed */
_L2:
        url = (HttpURLConnection)url.openConnection();
          goto _L6
_L5:
        url.setUseCaches(false);
        url.setDoInput(true);
        url.setRequestProperty("Content-type", "application/json");
        url.setRequestProperty("Authorization", (new StringBuilder("Basic ")).append(c).toString());
        url.setRequestProperty("Accept", "application/json");
        url.setConnectTimeout(15000);
        url.setReadTimeout(15000);
        return url;
        if (true) goto _L8; else goto _L7
_L7:
    }

    protected void a(ai ai1)
    {
        ai1.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[] {
            null
        });
    }

    protected void a(ai ai1, boolean flag)
    {
        jumiomobile/cp;
        JVM INSTR monitorenter ;
        Object obj = b();
        obj;
        JVM INSTR monitorenter ;
        if (!flag) goto _L2; else goto _L1
_L1:
        a(ai1);
_L3:
        obj;
        JVM INSTR monitorexit ;
        jumiomobile/cp;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (!a.isEmpty() || b != null)
        {
            break MISSING_BLOCK_LABEL_69;
        }
        b = ai1;
        a(b);
          goto _L3
        ai1;
        obj;
        JVM INSTR monitorexit ;
        throw ai1;
        ai1;
        jumiomobile/cp;
        JVM INSTR monitorexit ;
        throw ai1;
        a.add(ai1);
          goto _L3
    }

    public void a(boolean flag)
    {
        Object obj = b();
        obj;
        JVM INSTR monitorenter ;
        a.clear();
        if (b == null || !flag)
        {
            break MISSING_BLOCK_LABEL_41;
        }
        b.cancel(true);
        b.c();
        b = null;
        obj;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected abstract Object b();

    protected abstract JumioDataCenter c();

    public void d()
    {
        a(true);
    }

    protected final String e()
    {
        if (c() == JumioDataCenter.US)
        {
            return f;
        } else
        {
            return g;
        }
    }

}

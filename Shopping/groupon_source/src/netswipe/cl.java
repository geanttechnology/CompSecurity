// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package netswipe;

import android.content.Context;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Base64;
import com.jumio.netswipe.sdk.core.NetswipeCardInformation;
import com.jumio.netswipe.sdk.enums.ErrorCase;
import com.jumio.netswipe.sdk.environment.Environment;
import java.util.Stack;
import java.util.UUID;
import java.util.concurrent.TimeoutException;
import org.apache.http.HttpHost;
import org.apache.http.client.HttpClient;
import org.apache.http.conn.params.ConnRouteParams;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

// Referenced classes of package netswipe:
//            di, cr, cu, ck, 
//            cq, cn, cm, co, 
//            cp, de

public class cl
{

    private static final String a = di.a(new byte[] {
        -30, -85, 97, -29, -23, 34, -56, 24, 108, -10, 
        -51, -64, -46, 118, 16, 93, 39, 97, 102, 33, 
        -6, -78, -85, 83, 52, 3, -57, 113, 57, 101, 
        80, -25, -96, -17, 122, -46, 69, 67, 61, -122, 
        94, -58, -25, 41, -92, -36, -119, -104, -38, -79, 
        -120, -125, -28
    }, 0x74804e0d21c728b4L);
    private static final String b = di.a(new byte[] {
        -46, 64, -58, 40, 31, -2, 42, 95, 90, 59, 
        51, -37, -114, -92, -56, 62, 17, 67, 10, 70, 
        -7, -37, 103, -72, -83, -125, 75, -41, 41, -66, 
        -59, 71, 74, 15, 65, 44, -123, 100, -101, 23, 
        -67, -17, 116, -2, -108, -61, 79, 78, 35, 74, 
        -45, 127, -73, 67, -24, -16, -41, 68, 84, -71, 
        113, -107, -128, -45, 98, 71, 71, 114, -119, 54, 
        85, 43, -52, -105, -21, -92, 3, -25, 17, 10, 
        26, 40, -124, 76, -113, 43, 91, -112, -19, 46, 
        -3, 72, -19, 0, 53, 95, 18, -25, 17, -3, 
        58, 127, -97, 59, 9, -40, 73, -4, -25, -18, 
        -66, 110, -98, 103, 74, -81, 10, 108, 41, 79, 
        125, 0, 59, -42, 62, -15, -36, 127, -44, 26, 
        78, -86, -106, -122, -80, -33, -91, -90, -126, 72, 
        22, -18, 110, -100, -64, -70, 60, -39, -114, -78, 
        92, -55, 13, -20, -18, 13, -103, -71, -56, -31, 
        57, 13, 103, 42, -105, 80, 27, -46, -53, -38, 
        -3, -102, 112, -25, -84, -117, 7, -1, 14, -83, 
        76, 43, 62, -98, 91, -58, 0, -102, -59, 76, 
        -77, 42, 4, -38, 73, -57, -95, 25, -59, -48, 
        21, 9, -116, -58, 18, 12, 38, 86, -99, -63, 
        -29, 108, -15, 49, 14, -45, 117, -18, -39, -127, 
        -116, 83, 2, 52, -38, 102, -17, 90, 37, -27, 
        -31, -122, -71, -18, 26, 115, 25, -35, 79, -19, 
        67, -37, -118, 106, -94, 35, 43, 26, 44, -100, 
        66, 28, 10, 48, -95, -79, -45, 84, 76, -91, 
        -71, 106, 4, -25, -98, -37, -53, 29, 35, -39, 
        -107, 23, -115, 96, 54, 119, 113, -101, 51, -23, 
        -21, 33, 40, -50, 94, -23, 1, 117, 82, -27, 
        33, -45, 93, 24, 109, -27, 51, -91, -89, 58, 
        -50, 66, 46, -29, 2, 4, 108, 60, -47, 42, 
        15, 55, 85, 22, 2, 36, 79, -54, -107, -106, 
        -32, -115, -4, -40, -42, 3, 86, -23, 43, 3, 
        -14, 116, 63, -25, -90, -98, -102, 49, 78, -10, 
        100, 105, -11, -80, 3, 22, 4, -121, 86, 2, 
        93, -87, 85, 56, -89, -26, -103, 64, -50, -30, 
        -87, 112, -95, -17, -2, 71, -89, 7, 62, 86, 
        -58, -103, -9, -126, 40, 63, -92, -84, -8, -81, 
        91, 22, -128, -55, -98, -105, 0, -84, 25, -57, 
        65, 43, 32, -67, -4, -108, 105, 102, 106, -64, 
        -75, -120, 52, 23, 84, -47, -60, -66, 41, -51, 
        -8, -5, -16, -62, -91, 62, -95, 96, -7, 4, 
        -106, 120, -104, -33, 1, 88, 23, 80, 124, 124, 
        36, 92, -76, 45, 13, -127, -25, -108, -23, 46, 
        86, 69, -127, 18, 16, -11, 12, 123, 113, 17, 
        -85, -53, -81, -26, 14, 83, 61, -128, 80, -70, 
        -106, -72, -27, 99, 102, -119, 104, 109, 123, 118, 
        23, -51, -104, -28, -71, 26, 20, -91, -38, 8, 
        29, -60, -16, 115, 26, 12, 34, 79, 111, -86, 
        -2, -125, -84, 106, 37, -11, -94, -25, -72, -68, 
        -44, -121, 112, 100, 33, 72, -3, 39, -45, 95, 
        -110, 90, -122, -16, 127, 7, -106, 72, 13, -75, 
        -22, 44, -123, -38, 45, 106, 63, 44, -79, 7, 
        78, 64, 20, 105, 28, 56, 98, 81, -3, -46, 
        65, 83, -101, 104, -43, 85, -13, 121, 85, -5, 
        -34, 36, -92, -20, 111, 72, 114, -47, 87, -47, 
        -61, 29, 88, -11, 88, 48, 6, -6, 114, 36, 
        -42, 22, 5, 42, -58, -2, 8, 68, -56, 119, 
        -5, -105, 35, -38, 119, -106, -86, 24
    }, 0x6b9b68da30679cb5L);
    private HttpClient c;
    private Stack d;
    private cu e;
    private String f;
    private Context g;
    private String h;
    private String i;
    private Location j;
    private ck k;

    public cl(Context context, String s, String s1, ck ck1)
    {
        f = null;
        g = null;
        h = "";
        i = "";
        j = null;
        k = null;
        g = context;
        k = ck1;
        f = Base64.encodeToString((new StringBuilder()).append(s).append(":").append(s1).toString().getBytes(), 2);
        d = new Stack();
        s = new BasicHttpParams();
        s.setParameter("http.route.default-proxy", new HttpHost(ConnRouteParams.NO_HOST));
        HttpConnectionParams.setConnectionTimeout(s, 15000);
        HttpConnectionParams.setSoTimeout(s, 15000);
        c = new cr(s, b);
        j = Environment.getBestKnownLocation(context);
        i = Environment.getDeviceId(context);
        h = UUID.randomUUID().toString();
    }

    static String a(cl cl1)
    {
        return cl1.f;
    }

    private void a(Boolean boolean1)
    {
        if (boolean1 != null && !boolean1.booleanValue())
        {
            d.clear();
        }
        if (!d.isEmpty())
        {
            e = (cu)d.remove(0);
            e.execute(new Void[0]);
            return;
        } else
        {
            e = null;
            return;
        }
    }

    private void a(Exception exception, Class class1)
    {
        exception.printStackTrace();
        a();
        NetworkInfo networkinfo = ((ConnectivityManager)g.getSystemService("connectivity")).getActiveNetworkInfo();
        if (networkinfo == null || !networkinfo.isConnected())
        {
            k.a(ErrorCase.DEVICE_IS_OFFLINE);
        } else
        if ((exception instanceof cq) || (exception instanceof TimeoutException))
        {
            if ((exception instanceof cq) && ((cq)exception).b())
            {
                k.a(ErrorCase.AUTH_FAILED);
                return;
            }
            if ((exception instanceof cq) && ((cq)exception).a() != 400 && ((cq)exception).a() != 401)
            {
                k.a(ErrorCase.UNEXPECTED_ERROR);
                return;
            }
            if (class1 == netswipe/cn)
            {
                k.a(ErrorCase.REQUEST_SCANS_FAILED);
                return;
            }
            if (class1 == netswipe/cm)
            {
                k.a(ErrorCase.REQUEST_IMAGE_FAILED);
                return;
            }
            if (class1 == netswipe/co)
            {
                k.a(ErrorCase.REQUEST_RESULT_FAILED);
                return;
            }
            if (class1 != netswipe/cp)
            {
                k.a(ErrorCase.UNEXPECTED_ERROR);
                return;
            }
        } else
        {
            k.a(ErrorCase.UNEXPECTED_ERROR);
            return;
        }
    }

    static void a(cl cl1, Boolean boolean1)
    {
        cl1.a(boolean1);
    }

    static void a(cl cl1, Exception exception, Class class1)
    {
        cl1.a(exception, class1);
    }

    private void a(cu cu1, boolean flag)
    {
        netswipe/cl;
        JVM INSTR monitorenter ;
        if (!flag) goto _L2; else goto _L1
_L1:
        cu1.execute(new Void[0]);
_L3:
        netswipe/cl;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (!d.isEmpty() || e != null)
        {
            break MISSING_BLOCK_LABEL_63;
        }
        e = cu1;
        e.execute(new Void[0]);
          goto _L3
        cu1;
        netswipe/cl;
        JVM INSTR monitorexit ;
        throw cu1;
        d.add(cu1);
          goto _L3
    }

    static Location b(cl cl1)
    {
        return cl1.j;
    }

    static String b()
    {
        return a;
    }

    static String c(cl cl1)
    {
        return cl1.i;
    }

    static String d(cl cl1)
    {
        return cl1.h;
    }

    static HttpClient e(cl cl1)
    {
        return cl1.c;
    }

    static ck f(cl cl1)
    {
        return cl1.k;
    }

    public void a()
    {
        d.clear();
        if (e != null)
        {
            try
            {
                e.cancel(true);
            }
            catch (Exception exception) { }
        }
        e = null;
    }

    public void a(String s)
    {
        a(((cu) (new cn(this, s))), false);
    }

    public void a(String s, NetswipeCardInformation netswipecardinformation, de de, de de1, boolean flag, boolean flag1, boolean flag2)
    {
        StringBuilder stringbuilder = new StringBuilder();
        if (!flag)
        {
            stringbuilder.append("3");
        } else
        if (netswipecardinformation.getSortCode().length == 0 || netswipecardinformation.getAccountNumber().length == 0)
        {
            stringbuilder.append("2");
        } else
        {
            stringbuilder.append("1");
        }
        if (!flag1)
        {
            stringbuilder.append("3");
        } else
        if (netswipecardinformation.getCardHolderName().length == 0)
        {
            stringbuilder.append("2");
        } else
        {
            stringbuilder.append("1");
        }
        if (!flag2)
        {
            stringbuilder.append("3");
        } else
        if (netswipecardinformation.getExpiryDateMonth().length == 0 || netswipecardinformation.getExpiryDateYear().length == 0)
        {
            stringbuilder.append("2");
        } else
        {
            stringbuilder.append("1");
        }
        if (netswipecardinformation.getCardNumber().length == 0)
        {
            stringbuilder.append("2");
        } else
        {
            stringbuilder.append("1");
        }
        a(((cu) (new co(this, s, netswipecardinformation, de, de1, stringbuilder.toString()))), false);
    }

    public void a(String s, byte abyte0[], String s1, String s2, String s3, String s4)
    {
        a(((cu) (new cm(this, s, abyte0, s1, s2, s3, s4))), false);
    }

    public void a(String s, char ac[])
    {
        a(((cu) (new cp(this, s, ac))), false);
    }

}

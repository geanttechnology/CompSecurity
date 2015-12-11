// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.ConditionVariable;
import android.util.Base64;
import com.jumio.mobile.sdk.enums.JumioDataCenter;
import com.jumio.netswipe.sdk.core.InternalCardInformation;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Stack;
import java.util.UUID;
import javax.net.ssl.SSLException;

// Referenced classes of package jumiomobile:
//            cp, am, ag, fx, 
//            ab, ah, dz, fk, 
//            ai, fo, fq, fn, 
//            fr, dl, an, cr, 
//            ay, cs, fm, aa

public class fl extends cp
    implements am
{

    public static final String d = jumiomobile/fl.getName();
    private static final String g = ag.a(new byte[] {
        -12, 32, 57, -6, -80, 71, -65, -91, -61, 114, 
        -106, 29, 83, -23, 127, -81, 108, -121, -83, 49, 
        85, 118, -64, 86, 13, -104, -84, -28, -105, -24, 
        69, -10, 16, -65, -1, 19, -98, -28, -111, -47, 
        -121, 76, 19, 56, -53, -111, -27, 9, -125, 48, 
        -61, 37, 70, 37, -111
    }, 0x5892c446e6ccbd2fL);
    private static final String h = ag.a(new byte[] {
        -127, -21, -24, -105, -55, 112, -93, -38, -96, 25, 
        123, -125, 111, -95, 113, -69, 66, 55, 78, 55, 
        -96, -52, 32, -106, 11, 16, -36, 124, -108, 23, 
        -81, -42, -50, 45, -90, -15, 57, 115, -107, -71, 
        72, -80, -53, 92, 118, -117, 124, -3, -6, -60, 
        90, -99, 111, -104, 42, -109, -104, 63, 41
    }, 0x5fb49bb838f43a57L);
    private static String i = g;
    private static String j = h;
    public UUID e;
    String f;
    private final Object k = new Object();
    private Context l;
    private boolean m;
    private boolean n;
    private boolean o;
    private boolean p;
    private JumioDataCenter q;
    private fk r;
    private boolean s;
    private final Object t = new Object();
    private ConditionVariable u;
    private dz v;

    public fl(Context context, String s1, String s2, JumioDataCenter jumiodatacenter, fk fk1)
    {
        l = null;
        m = true;
        n = false;
        o = false;
        p = false;
        r = null;
        f = "";
        u = new ConditionVariable(false);
        l = context;
        c = a(s1, s2);
        q = jumiodatacenter;
        a(fk1);
    }

    static String a(fl fl1)
    {
        return fl1.l();
    }

    static String a(fl fl1, HttpURLConnection httpurlconnection)
    {
        return fl1.a(httpurlconnection);
    }

    private void a(Exception exception, Class class1)
    {
        fx.a(String.format("task: %s, exception: %s", new Object[] {
            class1.getName(), exception.getMessage()
        }));
        fx.a(fx.d(), exception);
        ab.b("handleException()", exception);
        d();
        v = null;
        if (!(exception instanceof ah) || !((ah)exception).b()) goto _L2; else goto _L1
_L1:
        v = dz.e;
_L4:
        synchronized (k)
        {
            if (r != null && v != null)
            {
                r.a(v);
            }
        }
        return;
_L2:
        if ((exception instanceof ah) && ((ah)exception).a() == 403)
        {
            v = dz.f;
        } else
        if (exception instanceof SSLException)
        {
            v = dz.d;
        }
        if (true) goto _L4; else goto _L3
_L3:
        class1;
        exception;
        JVM INSTR monitorexit ;
        throw class1;
    }

    private void a(ai ai1, Boolean boolean1)
    {
        if (boolean1 != null && !boolean1.booleanValue())
        {
            a.clear();
            m = false;
        }
        if (boolean1 != null)
        {
            fx.a(String.format("task: %s Result: %s", new Object[] {
                ai1.getClass().getName(), boolean1.toString()
            }));
        }
        if (!a.isEmpty())
        {
            b = (ai)a.remove(0);
            a(b);
            return;
        } else
        {
            b = null;
            return;
        }
    }

    static void a(fl fl1, Exception exception, Class class1)
    {
        fl1.a(exception, class1);
    }

    static void a(fl fl1, String s1)
    {
        fl1.b(s1);
    }

    static void a(fl fl1, ai ai1, Boolean boolean1)
    {
        fl1.a(ai1, boolean1);
    }

    static boolean a(fl fl1, boolean flag)
    {
        fl1.m = flag;
        return flag;
    }

    static ConditionVariable b(fl fl1)
    {
        return fl1.u;
    }

    static String b(fl fl1, HttpURLConnection httpurlconnection)
    {
        return fl1.a(httpurlconnection);
    }

    private void b(String s1)
    {
        synchronized (k)
        {
            if (r != null)
            {
                r.b(s1);
            }
        }
        return;
        s1;
        obj;
        JVM INSTR monitorexit ;
        throw s1;
    }

    static void b(fl fl1, String s1)
    {
        fl1.c(s1);
    }

    static boolean b(fl fl1, boolean flag)
    {
        fl1.n = flag;
        return flag;
    }

    static Object c(fl fl1)
    {
        return fl1.k;
    }

    static String c(fl fl1, HttpURLConnection httpurlconnection)
    {
        return fl1.a(httpurlconnection);
    }

    private void c(String s1)
    {
        synchronized (k)
        {
            if (r != null)
            {
                r.c(s1);
            }
        }
        return;
        s1;
        obj;
        JVM INSTR monitorexit ;
        throw s1;
    }

    static boolean c(fl fl1, boolean flag)
    {
        fl1.o = flag;
        return flag;
    }

    static String d(fl fl1, HttpURLConnection httpurlconnection)
    {
        return fl1.a(httpurlconnection);
    }

    static fk d(fl fl1)
    {
        return fl1.r;
    }

    static boolean d(fl fl1, boolean flag)
    {
        fl1.p = flag;
        return flag;
    }

    static dz e(fl fl1)
    {
        return fl1.v;
    }

    static boolean e(fl fl1, boolean flag)
    {
        fl1.s = flag;
        return flag;
    }

    static Context f(fl fl1)
    {
        return fl1.l;
    }

    private String l()
    {
        if (q == JumioDataCenter.US)
        {
            return i;
        } else
        {
            return j;
        }
    }

    protected String a(String s1, String s2)
    {
        return Base64.encodeToString((new StringBuilder()).append(s1).append(":").append(s2).toString().getBytes(), 2);
    }

    protected HttpURLConnection a(String s1, URL url)
    {
        s1 = super.a(s1, url);
        s1.setRequestProperty("User-Agent", "Jumio Netswipe Android SDK JMSDK 1.7.0 (1441790640-34)");
        s1.setRequestProperty("X-TrackingId", e.toString());
        return s1;
    }

    public void a(Context context)
    {
        l = context;
    }

    public void a(String s1)
    {
        a(((ai) (new fo(this, s1))), false);
        s = true;
    }

    public void a(String s1, InternalCardInformation internalcardinformation, aa aa, aa aa1, aa aa2, boolean flag, boolean flag1, 
            boolean flag2)
    {
        if (m)
        {
            StringBuilder stringbuilder = new StringBuilder();
            if (!flag)
            {
                stringbuilder.append("3");
            } else
            if (internalcardinformation.getCardSortCode().length == 0 || internalcardinformation.getCardAccountNumber().length == 0)
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
            if (internalcardinformation.getCardHolderName().length == 0)
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
            if (internalcardinformation.getCardExpiryDateMonth().length == 0 || internalcardinformation.getCardExpiryDateYear().length == 0)
            {
                stringbuilder.append("2");
            } else
            {
                stringbuilder.append("1");
            }
            if (internalcardinformation.getCardNumber().length == 0)
            {
                stringbuilder.append("2");
            } else
            {
                stringbuilder.append("1");
            }
            a(((ai) (new fq(this, s1, internalcardinformation, aa, aa1, aa2, stringbuilder.toString()))), false);
            return;
        } else
        {
            c(s1);
            return;
        }
    }

    public void a(String s1, byte abyte0[], int i1, int j1, String s2, String s3, String s4, 
            String s5)
    {
        if (m)
        {
            a(((ai) (new fn(this, s1, abyte0, i1, j1, s2, s3, s4, s5))), true);
            return;
        } else
        {
            b(s1);
            return;
        }
    }

    public void a(String s1, char ac[], char ac1[], char ac2[])
    {
        if (m)
        {
            a(((ai) (new fr(this, s1, ac, ac1, ac2))), false);
        }
    }

    public void a(fk fk1)
    {
        Object obj = k;
        obj;
        JVM INSTR monitorenter ;
        r = fk1;
        if (fk1 == null)
        {
            break MISSING_BLOCK_LABEL_26;
        }
        u.open();
_L2:
        obj;
        JVM INSTR monitorexit ;
        return;
        u.close();
        if (true) goto _L2; else goto _L1
_L1:
        fk1;
        obj;
        JVM INSTR monitorexit ;
        throw fk1;
    }

    public boolean a()
    {
        return l != null;
    }

    public boolean a(byte abyte0[], int i1, int j1, int k1)
    {
        if (m && q == JumioDataCenter.US)
        {
            cr cr1 = (cr)dl.d().a(l, "ImageDumpService");
            cr1.a(c);
            long l1 = System.currentTimeMillis();
            abyte0 = ay.a(abyte0, i1, j1, android.graphics.Bitmap.CompressFormat.WEBP, 80);
            if (cs.a())
            {
                (new Thread(new fm(this, abyte0), "ImageDumpOnDiskThread")).start();
            }
            ab.d("ImageDumpService", (new StringBuilder("Converting to webp took ")).append(System.currentTimeMillis() - l1).append(" ms").toString());
            return cr1.a(e(), abyte0, f, e.toString(), k1);
        } else
        {
            return false;
        }
    }

    protected Object b()
    {
        return t;
    }

    protected JumioDataCenter c()
    {
        return q;
    }

    public boolean f()
    {
        return m;
    }

    public boolean g()
    {
        return n;
    }

    public boolean h()
    {
        return o;
    }

    public boolean i()
    {
        NetworkInfo networkinfo = ((ConnectivityManager)l.getSystemService("connectivity")).getNetworkInfo(1);
        return networkinfo != null && networkinfo.isConnected();
    }

    public boolean j()
    {
        return p;
    }

    public boolean k()
    {
        boolean flag;
        synchronized (k)
        {
            flag = s;
        }
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

}

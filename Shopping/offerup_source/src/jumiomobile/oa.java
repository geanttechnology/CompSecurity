// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.app.Activity;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Base64;
import com.jumio.mobile.sdk.enums.JumioDataCenter;
import com.jumio.netverify.sdk.core.ModelTemplate;
import com.jumio.netverify.sdk.core.vo.Country;
import com.jumio.netverify.sdk.enums.NVDocumentType;
import com.jumio.netverify.sdk.enums.NVDocumentVariant;
import com.jumio.netverify.sdk.enums.NVScanSide;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Stack;
import java.util.UUID;
import java.util.concurrent.TimeoutException;
import javax.net.ssl.SSLException;

// Referenced classes of package jumiomobile:
//            cp, ag, hu, od, 
//            oc, al, ai, oo, 
//            ab, ok, ht, ba, 
//            ah, oj, oi, of, 
//            oh, cs, og, om, 
//            oe

public class oa extends cp
{

    private static final String f = ag.a(new byte[] {
        79, -92, -46, -54, -111, 39, 68, -59, -117, 113, 
        -125, -115, -123, 114, 39, 116, -88, 69, -105, 9, 
        -12, 91, -19, 4, 123, -91, 113, -92, 95, -122, 
        -24, 103, -52, -74, -118, -48, -89, 30, 27, 42, 
        16, 30, -63, 17, 79, 37, -96, 15, -78
    }, 0x4d1de34f6ec59837L);
    private static final String g = ag.a(new byte[] {
        70, -114, -35, -12, 13, -67, 120, -78, 17, -39, 
        -39, -103, -62, 2, -94, -52, 24, 73, -82, 70, 
        95, 59, -26, 63, 62, -100, -4, 118, -69, 112, 
        108, 63, 103, 115, 22, -30, 3, -31, 9, 85, 
        -120, 41, -54, 19, -83, 25, 49, 68, 116, 40, 
        115, -76, 24
    }, 0xa9e8a6c50c0756e7L);
    private static String h = f;
    private static String i = g;
    protected UUID d;
    protected boolean e;
    private ModelTemplate j;
    private JumioDataCenter k;
    private al l;
    private final Object m = new Object();
    private boolean n;

    public oa(ModelTemplate modeltemplate)
    {
        e = true;
        j = modeltemplate;
        modeltemplate.c = hu.a;
        c = Base64.encodeToString((new StringBuilder()).append(modeltemplate.g).append(":").append(modeltemplate.h).toString().getBytes(), 2);
        k = modeltemplate.O;
    }

    static ModelTemplate a(oa oa1)
    {
        return oa1.j;
    }

    static String a(oa oa1, HttpURLConnection httpurlconnection)
    {
        return oa1.a(httpurlconnection);
    }

    static ai a(oa oa1, ai ai1)
    {
        oa1.b = ai1;
        return ai1;
    }

    private void a(Country country, NVDocumentType nvdocumenttype, NVDocumentVariant nvdocumentvariant)
    {
        a(((ai) (new od(this, country, nvdocumenttype, nvdocumentvariant))), false);
    }

    private void a(NVScanSide nvscanside)
    {
        a(((ai) (new oc(this, nvscanside))), false);
    }

    private void a(Boolean boolean1, hu hu1, hu hu2)
    {
        ModelTemplate modeltemplate = j;
        if (boolean1 == null || !boolean1.booleanValue())
        {
            hu1 = hu2;
        }
        modeltemplate.c = hu1;
        if (l != null)
        {
            l.a(boolean1.booleanValue());
            l = null;
        }
        k();
        jumiomobile/oa;
        JVM INSTR monitorenter ;
        if (boolean1 == null)
        {
            break MISSING_BLOCK_LABEL_103;
        }
        if (!boolean1.booleanValue() || a.isEmpty())
        {
            break MISSING_BLOCK_LABEL_103;
        }
        b = (ai)a.remove(0);
        a(b);
_L2:
        jumiomobile/oa;
        JVM INSTR monitorexit ;
        return;
        a.clear();
        b = null;
        if (true) goto _L2; else goto _L1
_L1:
        boolean1;
        jumiomobile/oa;
        JVM INSTR monitorexit ;
        throw boolean1;
    }

    private void a(Class class1, boolean flag)
    {
        oo.a(String.format(Locale.getDefault(), "task: %s timeout - retry: %s", new Object[] {
            class1.getName(), Boolean.valueOf(flag)
        }));
        ab.c("RemoteManager", "timeout");
        if (flag && !j.f && class1 == jumiomobile/ok)
        {
            a();
            return;
        } else
        {
            a(((Exception) (new TimeoutException("Timeout"))), class1);
            return;
        }
    }

    private void a(Exception exception, Class class1)
    {
        oo.a(String.format(Locale.getDefault(), "task: %s exception: %s", new Object[] {
            class1.getName(), exception.getMessage()
        }));
        oo.a(oo.d(), exception);
        ab.a(exception);
        a(false);
        NetworkInfo networkinfo = ((ConnectivityManager)j.a.getSystemService("connectivity")).getActiveNetworkInfo();
        if (networkinfo == null || !networkinfo.isConnected())
        {
            exception = ht.k;
        } else
        if ((exception instanceof ah) && ((ah)exception).b())
        {
            exception = ht.i;
        } else
        if ((exception instanceof ah) && ((ah)exception).a() == 403)
        {
            exception = ht.j;
        } else
        if (exception instanceof SSLException)
        {
            exception = ht.h;
        } else
        if (class1 == jumiomobile/ok)
        {
            exception = ht.a;
        } else
        if (class1 == jumiomobile/oj)
        {
            exception = ht.b;
        } else
        if (class1 == jumiomobile/od)
        {
            exception = ht.c;
        } else
        if (class1 == jumiomobile/oc)
        {
            exception = ht.d;
        } else
        if (class1 == jumiomobile/oi)
        {
            exception = ht.g;
        } else
        if (class1 == jumiomobile/of)
        {
            exception = ht.e;
        } else
        if (class1 == jumiomobile/oh)
        {
            exception = ht.f;
        } else
        {
            exception = null;
        }
        if (exception != null)
        {
            ab.b("RemoteManager", (new StringBuilder("show error code: ")).append(exception.a()).toString());
        }
        class1 = new Intent("com.jumio.netverify.sdk.ACTION_SHOW_ERROR");
        if (exception != null)
        {
            class1.putExtra("ErrorCase", exception.name());
        }
        ba.a(j.a).a(class1, n);
    }

    private void a(ai ai1, Boolean boolean1)
    {
        if (oo.a())
        {
            cs.a(String.format(Locale.getDefault(), "task: %s, scanref: %s, result: %s", new Object[] {
                ai1.getClass().getName(), j.j, boolean1.toString()
            }));
        }
    }

    static void a(oa oa1, Country country, NVDocumentType nvdocumenttype, NVDocumentVariant nvdocumentvariant)
    {
        oa1.a(country, nvdocumenttype, nvdocumentvariant);
    }

    static void a(oa oa1, NVScanSide nvscanside)
    {
        oa1.a(nvscanside);
    }

    static void a(oa oa1, Boolean boolean1, hu hu1, hu hu2)
    {
        oa1.a(boolean1, hu1, hu2);
    }

    static void a(oa oa1, Class class1, boolean flag)
    {
        oa1.a(class1, flag);
    }

    static void a(oa oa1, Exception exception, Class class1)
    {
        oa1.a(exception, class1);
    }

    static void a(oa oa1, ArrayList arraylist, int i1)
    {
        oa1.b(arraylist, i1);
    }

    static void a(oa oa1, ai ai1, Boolean boolean1)
    {
        oa1.a(ai1, boolean1);
    }

    static void a(oa oa1, ai ai1, boolean flag)
    {
        oa1.a(ai1, flag);
    }

    static String b(oa oa1, HttpURLConnection httpurlconnection)
    {
        return oa1.a(httpurlconnection);
    }

    static Stack b(oa oa1)
    {
        return oa1.a;
    }

    private void b(ArrayList arraylist, int i1)
    {
        a(new of(this, arraylist, i1), false);
    }

    static void b(oa oa1, ai ai1)
    {
        oa1.a(ai1);
    }

    static String c(oa oa1, HttpURLConnection httpurlconnection)
    {
        return oa1.a(httpurlconnection);
    }

    static Stack c(oa oa1)
    {
        return oa1.a;
    }

    static ai c(oa oa1, ai ai1)
    {
        oa1.b = ai1;
        return ai1;
    }

    static String d(oa oa1, HttpURLConnection httpurlconnection)
    {
        return oa1.a(httpurlconnection);
    }

    static ai d(oa oa1)
    {
        return oa1.b;
    }

    static void d(oa oa1, ai ai1)
    {
        oa1.a(ai1);
    }

    static String e(oa oa1, HttpURLConnection httpurlconnection)
    {
        return oa1.a(httpurlconnection);
    }

    static Stack e(oa oa1)
    {
        return oa1.a;
    }

    static ai e(oa oa1, ai ai1)
    {
        oa1.b = ai1;
        return ai1;
    }

    static String f(oa oa1, HttpURLConnection httpurlconnection)
    {
        return oa1.a(httpurlconnection);
    }

    static Stack f(oa oa1)
    {
        return oa1.a;
    }

    static void f(oa oa1, ai ai1)
    {
        oa1.a(ai1);
    }

    static String g(oa oa1, HttpURLConnection httpurlconnection)
    {
        return oa1.a(httpurlconnection);
    }

    static ai g(oa oa1)
    {
        return oa1.b;
    }

    static void h(oa oa1)
    {
        oa1.j();
    }

    private String i()
    {
        if (k == JumioDataCenter.US)
        {
            return h;
        } else
        {
            return i;
        }
    }

    static Stack i(oa oa1)
    {
        return oa1.a;
    }

    static Stack j(oa oa1)
    {
        return oa1.a;
    }

    private void j()
    {
        a(new oi(this, null), false);
    }

    static ai k(oa oa1)
    {
        return oa1.b;
    }

    private void k()
    {
        String s = (new StringBuilder()).append(j.a.getFilesDir()).append(File.separator).append("jumio").append(File.separator).append("tmp_results").toString();
        Object obj;
        obj = new File((new StringBuilder()).append(j.a.getFilesDir()).append(File.separator).append("jumio").toString());
        if (!((File) (obj)).exists())
        {
            ((File) (obj)).mkdirs();
        }
        obj = new File(s);
        if (((File) (obj)).exists())
        {
            ((File) (obj)).delete();
        }
        obj = new BufferedWriter(new FileWriter(s));
        if (j.c != null)
        {
            break MISSING_BLOCK_LABEL_171;
        }
        s = "null";
_L1:
        try
        {
            ((BufferedWriter) (obj)).write(s);
            ((BufferedWriter) (obj)).write(";");
            ((BufferedWriter) (obj)).close();
            return;
        }
        catch (IOException ioexception)
        {
            ab.a(ioexception);
        }
        break MISSING_BLOCK_LABEL_190;
        s = j.c.toString();
          goto _L1
    }

    static String l(oa oa1)
    {
        return oa1.i();
    }

    protected HttpURLConnection a(String s, URL url)
    {
        s = super.a(s, url);
        s.setRequestProperty("User-Agent", "Jumio Netverify Android SDK JMSDK 1.7.0 (1441790640-34)");
        s.setRequestProperty("X-TrackingId", d.toString());
        return s;
    }

    public void a()
    {
        a(((ai) (new ok(this, null))), false);
    }

    public void a(Country country, NVDocumentType nvdocumenttype, byte abyte0[], int i1)
    {
        a(((ai) (new oh(this, country, nvdocumenttype, abyte0, i1))), false);
    }

    public void a(ArrayList arraylist, int i1)
    {
        a(((ai) (new og(this, arraylist, i1))), false);
    }

    public void a(al al1)
    {
        l = al1;
    }

    protected Object b()
    {
        return m;
    }

    public void b(boolean flag)
    {
        n = flag;
    }

    protected JumioDataCenter c()
    {
        return k;
    }

    public void f()
    {
        a(new oj(this, null), false);
    }

    public void g()
    {
        a(new om(this, null), false);
    }

    public void h()
    {
        a(new oe(this, null), false);
    }

}

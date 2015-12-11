// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package netswipe;

import android.content.Context;
import android.graphics.Bitmap;
import com.jumio.netswipe.sdk.enums.ErrorCase;
import com.jumio.netswipe.sdk.environment.Environment;
import com.jumio.ocr.impl.smartEngines.swig.DetectionEngine;
import com.jumio.ocr.impl.smartEngines.swig.DetectionInternalSettingsFactory;
import com.jumio.ocr.impl.smartEngines.swig.DetectionSettings;
import com.jumio.ocr.impl.smartEngines.swig.OcrEngine;
import com.jumio.ocr.impl.smartEngines.swig.OcrException;
import com.jumio.ocr.impl.smartEngines.swig.YuvUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

// Referenced classes of package netswipe:
//            dh, cd, cz, h, 
//            ch, ci, cj, cg, 
//            de, am

public class ce
{

    public static int a = 800;
    public static int b = 600;
    private OcrEngine c;
    private cg d;
    private cd e;
    private ci f;
    private cj g;
    private ch h;
    private boolean i;
    private boolean j;
    private boolean k;
    private Context l;
    private DetectionEngine m;
    private byte n[];
    private de o;
    private long p;
    private h q;
    private cz r;
    private boolean s;
    private boolean t;
    private boolean u;
    private boolean v;

    public ce(Context context, cz cz1, cd cd1)
    {
        c = null;
        d = null;
        e = null;
        f = null;
        g = null;
        h = null;
        i = false;
        j = true;
        k = false;
        l = null;
        n = null;
        o = null;
        p = 0L;
        s = true;
        t = false;
        u = false;
        v = false;
        if (cd1 == null)
        {
            throw new NullPointerException("IOcrCallback must be set!");
        }
        l = context;
        r = cz1;
        e = cd1;
        dh.b("Start Load JNIINTERFACE");
        Environment.loadJniInterfaceLib(context);
        dh.b("End Load JNIINTERFACE");
        e();
        cz1 = new DetectionSettings();
        cz1.setRoiLeftMargin(0.067500000000000004D);
        cz1.setRoiRightMargin(0.067500000000000004D);
        cz1.setRoiTopMargin(0.13800000000000001D);
        cz1.setRoiBottomMargin(0.13800000000000001D);
        cz1.setRoiVerticalDeviation(0.080000000000000002D);
        cz1.setRoiHorizontalDeviation(0.059999999999999998D);
        context = Environment.getCardDetectionSettingsPath(context);
        if (context == null)
        {
            try
            {
                throw new OcrException("Loading detection settings failed!");
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                context.printStackTrace();
            }
            if (cd1 != null)
            {
                cd1.b(ErrorCase.OCR_LOADING_FAILED);
            }
            return;
        }
        m = new DetectionEngine(cz1, DetectionInternalSettingsFactory.createFromFileSystem(context));
        return;
    }

    private int a(byte abyte0[])
    {
        boolean flag = false;
        if (abyte0 != null && abyte0.length % 3 == 0) goto _L2; else goto _L1
_L1:
        int j1 = -1;
_L4:
        return j1;
_L2:
        int i1 = 0;
        do
        {
            j1 = ((flag) ? 1 : 0);
            if (i1 >= abyte0.length / 2)
            {
                continue;
            }
            byte byte0 = abyte0[i1];
            byte byte1 = abyte0[i1 + 1];
            byte byte2 = abyte0[i1 + 2];
            j1 = abyte0.length - 3 - i1;
            abyte0[i1] = abyte0[j1];
            abyte0[i1 + 1] = abyte0[j1 + 1];
            abyte0[i1 + 2] = abyte0[j1 + 2];
            abyte0[j1] = byte0;
            abyte0[j1 + 1] = byte1;
            abyte0[j1 + 2] = byte2;
            i1 += 3;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    static long a(ce ce1, long l1)
    {
        ce1.p = l1;
        return l1;
    }

    static Context a(ce ce1)
    {
        return ce1.l;
    }

    static OcrEngine a(ce ce1, OcrEngine ocrengine)
    {
        ce1.c = ocrengine;
        return ocrengine;
    }

    static cg a(ce ce1, cg cg)
    {
        ce1.d = cg;
        return cg;
    }

    static de a(ce ce1, de de)
    {
        ce1.o = de;
        return de;
    }

    static boolean a(ce ce1, int i1)
    {
        boolean flag = (byte)(ce1.k & i1);
        ce1.k = flag;
        return flag;
    }

    static boolean a(ce ce1, boolean flag)
    {
        ce1.i = flag;
        return flag;
    }

    static byte[] a(ce ce1, byte abyte0[])
    {
        ce1.n = abyte0;
        return abyte0;
    }

    static byte[] a(ce ce1, byte abyte0[], byte abyte1[], int i1, int j1)
    {
        return ce1.a(abyte0, abyte1, i1, j1);
    }

    private byte[] a(byte abyte0[], byte abyte1[], int i1, int j1)
    {
        int k1;
        int l1;
        int i2;
        int j2;
        if (r.e())
        {
            l1 = ((q.a.width - q.b.width) / 2) * (q.c.width / q.a.width);
            j2 = q.c.width - l1 * 2;
            i2 = (int)((float)j2 * 0.75F);
            k1 = (q.c.height - i2) / 2;
        } else
        {
            l1 = ((q.a.height - q.b.height) / 2) * (q.c.height / q.a.height);
            j2 = q.c.height - l1 * 2;
            i2 = (int)((float)j2 / 0.75F);
            k1 = (q.c.width - i2) / 2;
        }
        if (abyte1 == null)
        {
            abyte1 = new byte[i1 * j1 * 3];
        }
        if (r.e())
        {
            i1 = YuvUtils.yuvCutRotateScale2rgb(abyte0, q.c.height, q.c.width, k1, l1, i2, j2, abyte1, i1, j1);
        } else
        {
            i1 = YuvUtils.yuvCutScale2rgb(abyte0, q.c.width, q.c.height, k1, l1, i2, j2, abyte1, i1, j1);
        }
        if (i1 != 0)
        {
            abyte1 = null;
        }
        return abyte1;
    }

    static int b(ce ce1, byte abyte0[])
    {
        return ce1.a(abyte0);
    }

    static cg b(ce ce1)
    {
        return ce1.d;
    }

    static boolean b(ce ce1, boolean flag)
    {
        ce1.k = flag;
        return flag;
    }

    static cd c(ce ce1)
    {
        return ce1.e;
    }

    static boolean c(ce ce1, boolean flag)
    {
        ce1.j = flag;
        return flag;
    }

    static boolean d(ce ce1)
    {
        return ce1.v;
    }

    static cz e(ce ce1)
    {
        return ce1.r;
    }

    static h f(ce ce1)
    {
        return ce1.q;
    }

    static DetectionEngine g(ce ce1)
    {
        return ce1.m;
    }

    static boolean h(ce ce1)
    {
        return ce1.j;
    }

    static OcrEngine i(ce ce1)
    {
        return ce1.c;
    }

    static byte[] j(ce ce1)
    {
        return ce1.n;
    }

    static boolean k(ce ce1)
    {
        return ce1.k;
    }

    static boolean l(ce ce1)
    {
        return ce1.s;
    }

    static boolean m(ce ce1)
    {
        return ce1.u;
    }

    static boolean n(ce ce1)
    {
        return ce1.t;
    }

    static de o(ce ce1)
    {
        return ce1.o;
    }

    static long p(ce ce1)
    {
        return ce1.p;
    }

    public void a()
    {
        if (h != null)
        {
            h.interrupt();
        }
        if (f != null)
        {
            f.interrupt();
        }
        if (g != null)
        {
            g.interrupt();
        }
    }

    public void a(h h1)
    {
        q = h1;
    }

    public void a(boolean flag)
    {
        s = flag;
    }

    public void a(byte abyte0[], int i1, int j1)
    {
        this;
        JVM INSTR monitorenter ;
        if (!j && !v)
        {
            j = true;
            g = new cj(this, abyte0, i1, j1);
            g.start();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        abyte0;
        throw abyte0;
    }

    public void a(byte abyte0[], am am)
    {
        this;
        JVM INSTR monitorenter ;
        if (!i && m != null && !v)
        {
            i = true;
            h = new ch(this, abyte0, am);
            h.start();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        abyte0;
        throw abyte0;
    }

    public void b()
    {
        j = false;
    }

    public void b(boolean flag)
    {
        t = flag;
    }

    public void c(boolean flag)
    {
        u = flag;
    }

    public byte[] c()
    {
        Bitmap bitmap;
        bitmap = Bitmap.createBitmap(320, 240, android.graphics.Bitmap.Config.ARGB_8888);
        for (int i1 = 0; i1 < n.length / 3; i1++)
        {
            bitmap.setPixel(i1 % 320, i1 / 320, 0xff000000 | (n[i1 * 3] & 0xff) << 16 | (n[i1 * 3 + 1] & 0xff) << 8 | (n[i1 * 3 + 2] & 0xff) << 0);
        }

        byte abyte0[];
        ByteArrayOutputStream bytearrayoutputstream;
        bytearrayoutputstream = new ByteArrayOutputStream();
        bitmap.compress(android.graphics.Bitmap.CompressFormat.WEBP, 80, bytearrayoutputstream);
        abyte0 = bytearrayoutputstream.toByteArray();
        bytearrayoutputstream.close();
        return abyte0;
        IOException ioexception;
        ioexception;
        abyte0 = null;
_L2:
        ioexception.printStackTrace();
        return abyte0;
        ioexception;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public de d()
    {
        return o;
    }

    public void d(boolean flag)
    {
        v = flag;
    }

    public void e()
    {
        f = new ci(this, null);
        f.start();
    }

}

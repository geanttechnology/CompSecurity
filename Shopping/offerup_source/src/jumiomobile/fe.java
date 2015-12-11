// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.content.Context;
import android.graphics.PointF;
import com.jumio.mobile.sdk.environment.Environment;
import com.jumio.ocr.impl.smartEngines.swig.OcrCharStringVector;
import com.jumio.ocr.impl.smartEngines.swig.OcrCharVariants;
import com.jumio.ocr.impl.smartEngines.swig.OcrEngine;
import com.jumio.ocr.impl.smartEngines.swig.OcrEngineSession;
import com.jumio.ocr.impl.smartEngines.swig.OcrEngineSettings;
import com.jumio.ocr.impl.smartEngines.swig.OcrPoint;
import com.jumio.ocr.impl.smartEngines.swig.OcrQuadrangle;

// Referenced classes of package jumiomobile:
//            cw, q, aa, cs, 
//            ao, fx, fh, fj, 
//            fi, fd, ea, n, 
//            fg, l

public class fe
{

    private static int a = 320;
    private static int b = 240;
    private boolean A;
    private boolean B;
    private Object C;
    private boolean D;
    private Object E;
    private byte F[];
    private StringBuilder G;
    private int H;
    private boolean I;
    private boolean J;
    private Object K;
    private OcrEngine c;
    private OcrEngineSession d;
    private OcrEngineSettings e;
    private final Object f = new Object();
    private fg g;
    private fd h;
    private fi i;
    private fj j;
    private fh k;
    private boolean l;
    private Object m;
    private boolean n;
    private Object o;
    private boolean p;
    private Context q;
    private byte r[];
    private Object s;
    private aa t;
    private aa u;
    private long v;
    private l w;
    private ao x;
    private boolean y;
    private boolean z;

    public fe(Context context, ao ao1, fd fd1)
    {
        c = null;
        d = null;
        e = null;
        g = null;
        h = null;
        i = null;
        j = null;
        k = null;
        l = false;
        m = new Object();
        n = false;
        o = new Object();
        p = false;
        q = null;
        r = null;
        s = new Object();
        t = null;
        u = null;
        v = 0L;
        y = true;
        z = false;
        A = false;
        B = false;
        C = new Object();
        D = false;
        E = new Object();
        F = null;
        G = null;
        I = false;
        K = new Object();
        if (fd1 == null)
        {
            throw new NullPointerException("IOcrCallback must be set!");
        } else
        {
            q = context;
            x = ao1;
            h = fd1;
            Environment.loadJniInterfaceLib();
            jumiomobile.q.a(new cw());
            d();
            return;
        }
    }

    static int a(fe fe1, int i1)
    {
        fe1.H = i1;
        return i1;
    }

    static long a(fe fe1, long l1)
    {
        fe1.v = l1;
        return l1;
    }

    static Context a(fe fe1)
    {
        return fe1.q;
    }

    private PointF a(OcrPoint ocrpoint, int i1, int j1)
    {
        PointF pointf = new PointF();
        pointf.x = ((float)ocrpoint.getX() * (float)a) / (float)i1;
        pointf.y = ((float)ocrpoint.getY() * (float)b) / (float)j1;
        return pointf;
    }

    static OcrEngine a(fe fe1, OcrEngine ocrengine)
    {
        fe1.c = ocrengine;
        return ocrengine;
    }

    static OcrEngineSession a(fe fe1, OcrEngineSession ocrenginesession)
    {
        fe1.d = ocrenginesession;
        return ocrenginesession;
    }

    static OcrEngineSettings a(fe fe1, OcrEngineSettings ocrenginesettings)
    {
        fe1.e = ocrenginesettings;
        return ocrenginesettings;
    }

    private aa a(PointF pointf)
    {
        aa aa1 = new aa();
        aa1.put("x", pointf.x);
        aa1.put("y", pointf.y);
        return aa1;
    }

    static aa a(fe fe1, aa aa1)
    {
        fe1.t = aa1;
        return aa1;
    }

    static fg a(fe fe1, fg fg)
    {
        fe1.g = fg;
        return fg;
    }

    private void a(PointF pointf, PointF pointf1, PointF pointf2, PointF pointf3)
    {
        pointf.x = (float)Math.floor(pointf.x) - 1.0F;
        pointf.y = (float)Math.floor(pointf.y) - 1.0F;
        pointf1.x = (float)Math.ceil(pointf1.x) + 1.0F;
        pointf1.y = (float)Math.floor(pointf1.y) - 1.0F;
        pointf2.x = (float)Math.floor(pointf2.x) - 1.0F;
        pointf2.y = (float)Math.ceil(pointf2.y) + 1.0F;
        pointf3.x = (float)Math.ceil(pointf3.x) + 1.0F;
        pointf3.y = (float)Math.ceil(pointf3.y) + 1.0F;
    }

    static boolean a(fe fe1, boolean flag)
    {
        fe1.I = flag;
        return flag;
    }

    static byte[] a(fe fe1, byte abyte0[])
    {
        fe1.F = abyte0;
        return abyte0;
    }

    static byte[] a(fe fe1, byte abyte0[], n n1)
    {
        return fe1.a(abyte0, n1);
    }

    private byte[] a(byte abyte0[], n n1)
    {
        StringBuilder stringbuilder = null;
        if (cs.a())
        {
            stringbuilder = new StringBuilder();
        }
        n1 = jumiomobile.q.a(abyte0, x.f(), w, 0.75F, n1, stringbuilder);
        if (cs.a())
        {
            java.io.File file = cs.a(q, "");
            cs.a(abyte0, file, "linefind.yuv");
            cs.a(stringbuilder.toString(), file, "linefind_specs.txt");
            if (n1 != null)
            {
                cs.a(n1, file, "linefind.rgb");
            }
        }
        return n1;
    }

    static Object b(fe fe1)
    {
        return fe1.f;
    }

    static aa b(fe fe1, aa aa1)
    {
        fe1.u = aa1;
        return aa1;
    }

    static boolean b(fe fe1, boolean flag)
    {
        fe1.p = flag;
        return flag;
    }

    static OcrEngineSettings c(fe fe1)
    {
        return fe1.e;
    }

    static boolean c(fe fe1, boolean flag)
    {
        fe1.n = flag;
        return flag;
    }

    static fg d(fe fe1)
    {
        return fe1.g;
    }

    static int e()
    {
        return a;
    }

    static OcrEngine e(fe fe1)
    {
        return fe1.c;
    }

    static int f()
    {
        return b;
    }

    static fd f(fe fe1)
    {
        return fe1.h;
    }

    private boolean g()
    {
        boolean flag;
        synchronized (m)
        {
            flag = l;
        }
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    static byte[] g(fe fe1)
    {
        return fe1.F;
    }

    static l h(fe fe1)
    {
        return fe1.w;
    }

    private boolean h()
    {
        boolean flag;
        synchronized (C)
        {
            flag = B;
        }
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    static StringBuilder i(fe fe1)
    {
        return fe1.G;
    }

    private boolean i()
    {
        boolean flag;
        synchronized (E)
        {
            flag = D;
        }
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private boolean j()
    {
        boolean flag;
        synchronized (K)
        {
            flag = J;
        }
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    static boolean j(fe fe1)
    {
        return fe1.y;
    }

    static boolean k(fe fe1)
    {
        return fe1.z;
    }

    static boolean l(fe fe1)
    {
        return fe1.A;
    }

    static boolean m(fe fe1)
    {
        return fe1.j();
    }

    static OcrEngineSession n(fe fe1)
    {
        return fe1.d;
    }

    static int o(fe fe1)
    {
        int i1 = fe1.H;
        fe1.H = i1 + 1;
        return i1;
    }

    static boolean p(fe fe1)
    {
        return fe1.I;
    }

    static int q(fe fe1)
    {
        return fe1.H;
    }

    static boolean r(fe fe1)
    {
        return fe1.i();
    }

    static Object s(fe fe1)
    {
        return fe1.s;
    }

    static boolean t(fe fe1)
    {
        return fe1.p;
    }

    static byte[] u(fe fe1)
    {
        return fe1.r;
    }

    static aa v(fe fe1)
    {
        return fe1.t;
    }

    static aa w(fe fe1)
    {
        return fe1.u;
    }

    static long x(fe fe1)
    {
        return fe1.v;
    }

    protected aa a(OcrCharStringVector ocrcharstringvector, int i1, int j1, int k1, int l1)
    {
        OcrQuadrangle ocrquadrangle = ocrcharstringvector.get(k1).getQuadrangle();
        OcrQuadrangle ocrquadrangle1 = ocrcharstringvector.get(l1).getQuadrangle();
        PointF pointf = a(ocrquadrangle.getTopLeft(), i1, j1);
        PointF pointf1 = a(ocrquadrangle1.getTopRight(), i1, j1);
        PointF pointf2 = a(ocrquadrangle.getBottomLeft(), i1, j1);
        PointF pointf3 = a(ocrquadrangle1.getBottomRight(), i1, j1);
        a(pointf, pointf1, pointf2, pointf3);
        ocrcharstringvector = new aa();
        ocrcharstringvector.put("topLeft", a(pointf));
        ocrcharstringvector.put("bottomLeft", a(pointf2));
        ocrcharstringvector.put("topRight", a(pointf1));
        ocrcharstringvector.put("bottomRight", a(pointf3));
        if (cs.a() && G != null)
        {
            G.append("Masking Rectangle\r\n");
            G.append("detection:\r\n");
            fx.a(G, "topLeft: ", fx.a(ocrquadrangle.getTopLeft()));
            fx.a(G, "bottomLeft: ", fx.a(ocrquadrangle.getBottomLeft()));
            fx.a(G, "topRight: ", fx.a(ocrquadrangle1.getTopRight()));
            fx.a(G, "bottomRight: ", fx.a(ocrquadrangle1.getBottomRight()));
            G.append("upload:\r\n");
            try
            {
                fx.a(G, "topLeft: ", fx.b(ocrcharstringvector.getJSONObject("topLeft")));
                fx.a(G, "bottomLeft: ", fx.b(ocrcharstringvector.getJSONObject("bottomLeft")));
                fx.a(G, "topRight: ", fx.b(ocrcharstringvector.getJSONObject("topRight")));
                fx.a(G, "bottomRight: ", fx.b(ocrcharstringvector.getJSONObject("bottomRight")));
            }
            catch (Exception exception) { }
            G.append("\r\n");
        }
        return ocrcharstringvector;
    }

    public void a()
    {
        synchronized (m)
        {
            if (k != null)
            {
                k.interrupt();
            }
        }
        synchronized (o)
        {
            if (j != null)
            {
                j.interrupt();
            }
        }
        this;
        JVM INSTR monitorenter ;
        if (i != null)
        {
            i.interrupt();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        exception1;
        obj;
        JVM INSTR monitorexit ;
        throw exception1;
        exception2;
        obj;
        JVM INSTR monitorexit ;
        throw exception2;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void a(StringBuilder stringbuilder)
    {
        G = stringbuilder;
    }

    public void a(l l1)
    {
        w = l1;
    }

    public void a(boolean flag)
    {
        synchronized (m)
        {
            l = flag;
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void a(byte abyte0[], int i1, int j1, byte abyte1[], boolean flag)
    {
        Object obj = o;
        obj;
        JVM INSTR monitorenter ;
        if (n || d == null || abyte0 == null)
        {
            break MISSING_BLOCK_LABEL_139;
        }
        if (h.g() != ea.c)
        {
            break MISSING_BLOCK_LABEL_139;
        }
        n = true;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_74;
        }
        if (!h() || i1 < 1000)
        {
            break MISSING_BLOCK_LABEL_74;
        }
        a = i1;
        b = j1;
        n n1;
        j = new fj(this, abyte0, i1, j1);
        j.start();
        n1 = new n(a, b);
        if (i())
        {
            synchronized (s)
            {
                r = a(abyte1, n1);
            }
        }
        obj;
        JVM INSTR monitorexit ;
        return;
        abyte1;
        abyte0;
        JVM INSTR monitorexit ;
        throw abyte1;
        abyte0;
        obj;
        JVM INSTR monitorexit ;
        throw abyte0;
    }

    public void a(byte abyte0[], boolean flag)
    {
        synchronized (m)
        {
            if (!g() && h.g() == ea.c)
            {
                a(true);
                k = new fh(this, abyte0, flag);
                k.start();
            }
        }
        return;
        abyte0;
        obj;
        JVM INSTR monitorexit ;
        throw abyte0;
    }

    public void b()
    {
        synchronized (o)
        {
            n = false;
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void b(boolean flag)
    {
        y = flag;
    }

    public void c()
    {
        synchronized (s)
        {
            h.a(r, a, b);
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void c(boolean flag)
    {
        z = flag;
    }

    public void d()
    {
        this;
        JVM INSTR monitorenter ;
        i = new fi(this, null);
        i.start();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void d(boolean flag)
    {
        A = flag;
    }

    public void e(boolean flag)
    {
        synchronized (C)
        {
            B = flag;
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void f(boolean flag)
    {
        synchronized (E)
        {
            D = flag;
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void g(boolean flag)
    {
        synchronized (K)
        {
            J = flag;
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

}

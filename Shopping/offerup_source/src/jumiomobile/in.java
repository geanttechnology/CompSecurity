// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.RectF;
import com.jumio.clientlib.impl.livenessAndTM.FaceRect;
import com.jumio.clientlib.impl.livenessAndTM.LivenessDetectorCallback;
import com.jumio.mobile.sdk.environment.Environment;
import com.jumio.netverify.sdk.core.ModelTemplate;
import com.jumio.netverify.sdk.enums.NVDocumentType;
import com.jumio.netverify.sdk.enums.NVScanSide;
import java.util.HashMap;

// Referenced classes of package jumiomobile:
//            id, na, is, ip, 
//            jh, l, n, ir, 
//            io, mr, it, mk, 
//            iq, ao, ii, mt

public class in extends id
{

    public Bitmap h;
    private l i;
    private na j;
    private String k;
    private ir l;
    private LivenessDetectorCallback m;
    private ip n;
    private int o;
    private int p;
    private int q;
    private int r;
    private int s;
    private iq t;
    private HashMap u;
    private jh v;
    private mr w;

    public in(Context context, ModelTemplate modeltemplate, ao ao, ii ii, mt mt)
    {
        super(context, modeltemplate, ao, ii);
        o = 0;
        p = 0;
        q = 0;
        r = 0;
        s = 0;
        h = null;
        j = (na)mt;
        Environment.loadLivenessDetectorAndTemplateMatcherLib();
        m = new is(this);
        k = Environment.getLivenessEngineSettingsPath(context);
        n = new ip(this, 5000L, 100L);
        t = null;
        u = new HashMap();
        a(jh.a);
    }

    private RectF a(FaceRect facerect)
    {
        float f3 = i.b();
        float f1 = (float)(i.a.a - i.b.a) / 2.0F;
        float f5 = (float)(i.a.b - i.b.b) / 2.0F;
        float f6 = (float)facerect.getWidth() * f3;
        float f4 = facerect.getHeight();
        float f2;
        if (i.e == 0)
        {
            f1 = (float)i.a.a - (f1 + (float)facerect.getX() * f3);
            f2 = f1 - f6;
        } else
        {
            f2 = (float)facerect.getX() * f3 - f1;
            f1 = f2 + f6;
        }
        f5 = f3 * (float)facerect.getY() - f5;
        return new RectF(f2, f5, f1, f5 + f4 * f3);
    }

    static RectF a(in in1, FaceRect facerect)
    {
        return in1.a(facerect);
    }

    static iq a(in in1, iq iq)
    {
        in1.t = iq;
        return iq;
    }

    static l a(in in1)
    {
        return in1.i;
    }

    private void a()
    {
        if (l != null)
        {
            l.interrupt();
            l = null;
        }
    }

    static void a(in in1, jh jh1)
    {
        in1.a(jh1);
    }

    private void a(jh jh1)
    {
        v = jh1;
        if (j != null)
        {
            ((Activity)a).runOnUiThread(new io(this));
        }
    }

    static byte[] a(in in1, byte abyte0[])
    {
        return in1.c(abyte0);
    }

    static void b(in in1)
    {
        in1.o();
    }

    static LivenessDetectorCallback c(in in1)
    {
        return in1.m;
    }

    private byte[] c(byte abyte0[])
    {
        byte abyte1[] = new byte[abyte0.length];
        System.arraycopy(abyte0, 0, abyte1, 0, abyte0.length);
        return abyte1;
    }

    static String d(in in1)
    {
        return in1.k;
    }

    static iq e(in in1)
    {
        return in1.t;
    }

    static HashMap f(in in1)
    {
        return in1.u;
    }

    static jh g(in in1)
    {
        return in1.v;
    }

    static ir h(in in1)
    {
        return in1.l;
    }

    static int i(in in1)
    {
        int i1 = in1.p;
        in1.p = i1 + 1;
        return i1;
    }

    static int j(in in1)
    {
        int i1 = in1.r;
        in1.r = i1 + 1;
        return i1;
    }

    static int k(in in1)
    {
        int i1 = in1.q;
        in1.q = i1 + 1;
        return i1;
    }

    private void k()
    {
        if (n != null)
        {
            n.cancel();
            n = null;
        }
    }

    private void l()
    {
        if (u != null)
        {
            u.clear();
            u = null;
            System.gc();
        }
    }

    static void l(in in1)
    {
        in1.m();
    }

    private void m()
    {
        s = 0;
        n.start();
    }

    static void m(in in1)
    {
        in1.l();
    }

    static int n(in in1)
    {
        int i1 = in1.s;
        in1.s = i1 + 1;
        return i1;
    }

    private void n()
    {
        n.cancel();
    }

    static int o(in in1)
    {
        return in1.s;
    }

    private void o()
    {
        n();
        t = null;
        l();
        u = new HashMap();
        r = 0;
        q = 0;
        s = 0;
        if (l != null)
        {
            l.a();
        }
    }

    static mr p(in in1)
    {
        return in1.w;
    }

    private void p()
    {
        if (l == null)
        {
            return;
        }
        l.interrupt();
        a(jh.c);
        n();
        if (w != null)
        {
            w.setVisibility(8);
        }
        (new it(this)).start();
    }

    static na q(in in1)
    {
        return in1.j;
    }

    static void r(in in1)
    {
        in1.p();
    }

    static int s(in in1)
    {
        return in1.q;
    }

    static int t(in in1)
    {
        return in1.r;
    }

    public String a(NVDocumentType nvdocumenttype, NVScanSide nvscanside)
    {
        return mk.a(a, "infobar_camera_view_face_liveness");
    }

    public void a(l l1)
    {
        i = l1;
        o();
    }

    public void a(mr mr1)
    {
        w = mr1;
    }

    public void b()
    {
        a();
        k();
        l();
        h = null;
        t = null;
    }

    public void b(byte abyte0[])
    {
        this;
        JVM INSTR monitorenter ;
        ir ir1 = l;
        if (ir1 != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        o = o + 1;
        l.a(abyte0);
        if (true) goto _L1; else goto _L3
_L3:
        abyte0;
        throw abyte0;
    }

    public void c()
    {
        if (l == null)
        {
            l = new ir(this);
            l.start();
            a(true);
        }
        super.c();
    }

    public void d()
    {
        super.d();
        a();
        a(jh.a);
        o();
    }

    public void e()
    {
    }

    public String j()
    {
        return mk.a(a, "actionbar_title_scan_face");
    }
}

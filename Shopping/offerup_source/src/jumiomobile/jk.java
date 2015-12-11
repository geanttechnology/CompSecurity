// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import android.text.Html;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.jumio.clientlib.impl.livenessAndTM.FrameProcessorTemplateMatcher;
import com.jumio.mobile.sdk.environment.Environment;
import com.jumio.netverify.sdk.core.ModelTemplate;
import com.jumio.netverify.sdk.core.vo.Country;
import com.jumio.netverify.sdk.core.vo.DocumentType;
import com.jumio.netverify.sdk.enums.NVDocumentType;
import com.jumio.netverify.sdk.enums.NVScanSide;
import com.jumio.netverify.sdk.extraction.templatematcher.TemplateInfoWrapper;
import com.jumio.netverify.sdk.gui.view.TemplateMatcherDrawView;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Referenced classes of package jumiomobile:
//            id, jl, ns, jr, 
//            ba, kc, gs, ml, 
//            cs, mr, kd, pw, 
//            os, nl, jn, mk, 
//            jq, mf, bg, mh, 
//            l, n, jm, q, 
//            ii, jo, ab, js, 
//            hh, g, ka, ao, 
//            mt

public class jk extends id
{

    private final BroadcastReceiver A = new jl(this);
    private g B;
    private boolean C;
    private byte D[];
    private byte E[];
    private int h;
    private js i;
    private ExecutorService j;
    private boolean k;
    private final Handler l = new jr(this, null);
    private FrameProcessorTemplateMatcher m;
    private ka n;
    private int o;
    private int p;
    private final Object q = new Object();
    private final Object r = new Object();
    private final Object s = new Object();
    private final Object t = new Object();
    private boolean u;
    private final int v = (int)System.currentTimeMillis();
    private kc w;
    private ml x;
    private NVScanSide y;
    private ns z;

    public jk(Context context, ModelTemplate modeltemplate, ao ao, g g1, ii ii1, mt mt, boolean flag)
    {
        super(context, modeltemplate, ao, ii1);
        h = 10;
        k = true;
        m = null;
        n = null;
        B = g1;
        z = (ns)mt;
        Environment.loadLivenessDetectorAndTemplateMatcherLib();
        j = Executors.newFixedThreadPool(1);
        modeltemplate = new IntentFilter();
        modeltemplate.addAction("com.jumio.netverify.sdk.ACTION_EXTRACTION_FINISHED");
        ba.a(context).a(A, modeltemplate);
        w = new kc(2, 3);
        if (d instanceof gs)
        {
            x = (ml)((gs)d).H();
        }
    }

    static js A(jk jk1)
    {
        return jk1.i;
    }

    static kc B(jk jk1)
    {
        return jk1.w;
    }

    static ao C(jk jk1)
    {
        return jk1.c;
    }

    static ModelTemplate D(jk jk1)
    {
        return jk1.e;
    }

    static ii E(jk jk1)
    {
        return jk1.d;
    }

    static ii F(jk jk1)
    {
        return jk1.d;
    }

    static ao G(jk jk1)
    {
        return jk1.c;
    }

    static ModelTemplate H(jk jk1)
    {
        return jk1.e;
    }

    static ns I(jk jk1)
    {
        return jk1.z;
    }

    static int J(jk jk1)
    {
        int i1 = jk1.p;
        jk1.p = i1 + 1;
        return i1;
    }

    static g K(jk jk1)
    {
        return jk1.B;
    }

    static ModelTemplate L(jk jk1)
    {
        return jk1.e;
    }

    static ModelTemplate M(jk jk1)
    {
        return jk1.e;
    }

    static ModelTemplate N(jk jk1)
    {
        return jk1.e;
    }

    static ao O(jk jk1)
    {
        return jk1.c;
    }

    static int P(jk jk1)
    {
        return jk1.p;
    }

    static ao Q(jk jk1)
    {
        return jk1.c;
    }

    static ao R(jk jk1)
    {
        return jk1.c;
    }

    static ao S(jk jk1)
    {
        return jk1.c;
    }

    static l T(jk jk1)
    {
        return jk1.b;
    }

    static ModelTemplate U(jk jk1)
    {
        return jk1.e;
    }

    static ao V(jk jk1)
    {
        return jk1.c;
    }

    static Context W(jk jk1)
    {
        return jk1.a;
    }

    static ii X(jk jk1)
    {
        return jk1.d;
    }

    static int a(jk jk1)
    {
        return jk1.v;
    }

    static int a(jk jk1, int i1)
    {
        jk1.h = i1;
        return i1;
    }

    static FrameProcessorTemplateMatcher a(jk jk1, FrameProcessorTemplateMatcher frameprocessortemplatematcher)
    {
        jk1.m = frameprocessortemplatematcher;
        return frameprocessortemplatematcher;
    }

    static ka a(jk jk1, ka ka)
    {
        jk1.n = ka;
        return ka;
    }

    static boolean a(jk jk1, boolean flag)
    {
        jk1.C = flag;
        return flag;
    }

    static byte[] a(jk jk1, byte abyte0[])
    {
        jk1.D = abyte0;
        return abyte0;
    }

    static int b(jk jk1, int i1)
    {
        jk1.p = i1;
        return i1;
    }

    static ii b(jk jk1)
    {
        return jk1.d;
    }

    private void b(boolean flag)
    {
        u = flag;
    }

    static boolean b(jk jk1, boolean flag)
    {
        jk1.k = flag;
        return flag;
    }

    static byte[] b(jk jk1, byte abyte0[])
    {
        jk1.E = abyte0;
        return abyte0;
    }

    static byte[] c(jk jk1)
    {
        return jk1.D;
    }

    static ao d(jk jk1)
    {
        return jk1.c;
    }

    static l e(jk jk1)
    {
        return jk1.b;
    }

    static l f(jk jk1)
    {
        return jk1.b;
    }

    static l g(jk jk1)
    {
        return jk1.b;
    }

    static l h(jk jk1)
    {
        return jk1.b;
    }

    static int i(jk jk1)
    {
        int i1 = jk1.o;
        jk1.o = i1 + 1;
        return i1;
    }

    static FrameProcessorTemplateMatcher j(jk jk1)
    {
        return jk1.m;
    }

    static void k(jk jk1)
    {
        jk1.m();
    }

    static Object l(jk jk1)
    {
        return jk1.q;
    }

    private boolean l()
    {
        boolean flag;
        synchronized (t)
        {
            flag = u;
        }
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    static Context m(jk jk1)
    {
        return jk1.a;
    }

    private void m()
    {
        if (cs.a() && i() != null)
        {
            i().a(-1F, -1F);
        }
        w.a(kd.a);
        if (z.getResultView() != null)
        {
            z.getResultView().setPolygon(null, null, null, null, null);
        }
        os.a(new pw(e.j));
        synchronized (q)
        {
            p = 0;
        }
        if (z.getProgressView() != null)
        {
            z.getProgressView().setProgress(0);
            z.getProgressView().setVisibility(8);
        }
        if (x != null)
        {
            x.setText(Html.fromHtml(a(e.v.getId(), ((NVScanSide) (null)))));
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    static int n(jk jk1)
    {
        return jk1.h;
    }

    static Handler o(jk jk1)
    {
        return jk1.l;
    }

    static ka p(jk jk1)
    {
        return jk1.n;
    }

    static ModelTemplate q(jk jk1)
    {
        return jk1.e;
    }

    static Context r(jk jk1)
    {
        return jk1.a;
    }

    static ModelTemplate s(jk jk1)
    {
        return jk1.e;
    }

    static ii t(jk jk1)
    {
        return jk1.d;
    }

    static ExecutorService u(jk jk1)
    {
        return jk1.j;
    }

    static Object v(jk jk1)
    {
        return jk1.s;
    }

    static l w(jk jk1)
    {
        return jk1.b;
    }

    static ao x(jk jk1)
    {
        return jk1.c;
    }

    static ao y(jk jk1)
    {
        return jk1.c;
    }

    static ModelTemplate z(jk jk1)
    {
        return jk1.e;
    }

    public String a(NVDocumentType nvdocumenttype, NVScanSide nvscanside)
    {
        if (nvscanside != null)
        {
            y = nvscanside;
        }
        nvscanside = null;
        jn.a[nvdocumenttype.ordinal()];
        JVM INSTR tableswitch 1 3: default 44
    //                   1 55
    //                   2 62
    //                   3 86;
           goto _L1 _L2 _L3 _L4
_L1:
        nvdocumenttype = nvscanside;
_L6:
        return mk.a(a, nvdocumenttype);
_L2:
        nvdocumenttype = "infobar_camera_view_passport";
        continue; /* Loop/switch isn't completed */
_L3:
        if (y == NVScanSide.FRONT)
        {
            nvdocumenttype = "infobar_camera_view_front_idcard_templatematcher";
        } else
        {
            nvdocumenttype = "infobar_camera_view_back_idcard_templatematcher";
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (y == NVScanSide.FRONT)
        {
            nvdocumenttype = "infobar_camera_view_front_driverlicense_templatematcher";
        } else
        {
            nvdocumenttype = "infobar_camera_view_back_driverlicense_templatematcher";
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    protected void a()
    {
        j.submit(new jq(this, null));
    }

    public void a(Activity activity, ScrollView scrollview, boolean flag)
    {
        TextView textview1 = (TextView)scrollview.findViewById(mf.ag);
        TextView textview = (TextView)scrollview.findViewById(mf.ah);
        ImageView imageview1 = (ImageView)scrollview.findViewById(mf.aj);
        ImageView imageview = (ImageView)scrollview.findViewById(mf.ak);
        activity = (Button)scrollview.findViewById(mf.al);
        bg.a(a, 5F);
        int j1 = (int)bg.a(a, 10F);
        int k1 = (int)bg.a(a, 20F);
        int i1;
        if (flag)
        {
            i1 = mh.ak;
        } else
        {
            i1 = mh.am;
        }
        imageview1.setImageBitmap(mh.a(a.getResources(), i1));
        if (flag)
        {
            i1 = mh.aj;
        } else
        {
            i1 = mh.al;
        }
        imageview.setImageBitmap(mh.a(a.getResources(), i1));
        scrollview.setPadding(0, x.getCurrentHeight(), 0, 0);
        if (flag)
        {
            scrollview = new android.widget.RelativeLayout.LayoutParams(-1, -2);
            scrollview.addRule(3, mf.ae);
            scrollview.topMargin = k1;
            textview1.setLayoutParams(scrollview);
            scrollview = new android.widget.RelativeLayout.LayoutParams(-1, -2);
            scrollview.addRule(3, textview1.getId());
            scrollview.topMargin = j1;
            imageview1.setLayoutParams(scrollview);
            scrollview = new android.widget.RelativeLayout.LayoutParams(-1, -2);
            scrollview.addRule(3, imageview1.getId());
            scrollview.topMargin = j1;
            textview.setLayoutParams(scrollview);
            scrollview = new android.widget.RelativeLayout.LayoutParams(-1, -2);
            scrollview.addRule(3, textview.getId());
            scrollview.topMargin = j1;
            scrollview.bottomMargin = k1 + j1;
            imageview.setLayoutParams(scrollview);
            scrollview = new android.widget.RelativeLayout.LayoutParams(-1, -2);
            scrollview.addRule(3, mf.af);
            scrollview.topMargin = k1 + k1;
            activity.setLayoutParams(scrollview);
            return;
        } else
        {
            scrollview = new android.widget.RelativeLayout.LayoutParams(-2, -2);
            scrollview.topMargin = j1;
            scrollview.leftMargin = k1;
            scrollview.addRule(0, imageview1.getId());
            scrollview.addRule(9);
            scrollview.addRule(3, mf.ae);
            textview1.setLayoutParams(scrollview);
            scrollview = new android.widget.RelativeLayout.LayoutParams(-2, -2);
            scrollview.topMargin = k1;
            scrollview.leftMargin = j1;
            scrollview.rightMargin = k1;
            scrollview.addRule(11);
            imageview1.setLayoutParams(scrollview);
            scrollview = new android.widget.RelativeLayout.LayoutParams(-2, -2);
            scrollview.topMargin = k1;
            scrollview.leftMargin = k1;
            scrollview.addRule(0, imageview.getId());
            scrollview.addRule(9);
            scrollview.addRule(3, imageview1.getId());
            textview.setLayoutParams(scrollview);
            scrollview = new android.widget.RelativeLayout.LayoutParams(-2, -2);
            scrollview.topMargin = k1;
            scrollview.addRule(5, imageview1.getId());
            scrollview.addRule(3, imageview1.getId());
            imageview.setLayoutParams(scrollview);
            ((android.widget.RelativeLayout.LayoutParams)activity.getLayoutParams()).addRule(3, textview.getId());
            return;
        }
    }

    public void a(l l1)
    {
        super.a(l1);
        if (b == null)
        {
            throw new IllegalStateException("previewProperties cannot be null! Spawn this thread after previewProperties have been set!");
        }
        synchronized (t)
        {
            D = new byte[(int)((float)(b.c.a * b.c.b) * b.c())];
            b(true);
        }
        return;
        exception;
        l1;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void a(byte abyte0[], byte abyte1[], int i1, int j1, byte abyte2[], int k1, int l1, 
            TemplateInfoWrapper templateinfowrapper)
    {
        (new Thread(new jm(this, abyte0, templateinfowrapper, abyte2, k1, l1))).start();
        abyte0 = null;
        if (abyte2 != null)
        {
            abyte0 = jumiomobile.q.a(abyte2, k1, l1);
            abyte1 = jumiomobile.q.a(abyte1, i1, j1);
            d.a(abyte1, abyte0, false);
        }
        abyte2 = d;
        float f1 = bg.a(a, 15);
        if (e.F)
        {
            abyte1 = null;
        } else
        {
            abyte1 = new jo(this, abyte0);
        }
        abyte2.a(abyte0, f1, abyte1);
        System.gc();
    }

    public void b()
    {
        ab.c("LifeCycle", "destroy called");
        if (m != null)
        {
            m.clearAllTemplates();
            m.reset();
            m = null;
        }
        n = null;
    }

    public void b(byte abyte0[])
    {
        this;
        JVM INSTR monitorenter ;
        if (l() && !k && C)
        {
            k = true;
            i = new js(this, abyte0);
            i.start();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        abyte0;
        throw abyte0;
    }

    public void c()
    {
        ab.a("Lifecycle", "reinit: cancel()");
        d();
        ab.a("Lifecycle", "reinit: init()");
        e();
        ab.a("Lifecycle", "reinit: entering lifecyclelock()");
        Object obj = r;
        obj;
        JVM INSTR monitorenter ;
        ab.a("Lifecycle", "reinit: delete TM()");
        if (m != null)
        {
            m.delete();
        }
        if (j == null)
        {
            j = Executors.newFixedThreadPool(1);
        }
        synchronized (s)
        {
            C = false;
            a();
            ab.a("Lifecycle", "reinit: waiting to complete loading()");
            s.wait();
            ab.a("Lifecycle", "reinit: loading done()");
            a(true);
        }
_L2:
        obj;
        JVM INSTR monitorexit ;
        return;
        exception1;
        obj1;
        JVM INSTR monitorexit ;
        Exception exception;
        try
        {
            throw exception1;
        }
        catch (InterruptedException interruptedexception) { }
        finally { }
        if (true) goto _L2; else goto _L1
_L1:
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void d()
    {
        Object obj = r;
        obj;
        JVM INSTR monitorenter ;
        js js1;
        super.d();
        js1 = i;
        if (js1 == null)
        {
            break MISSING_BLOCK_LABEL_34;
        }
        Exception exception;
        try
        {
            i.interrupt();
            i.join();
        }
        catch (Exception exception1) { }
        obj;
        JVM INSTR monitorexit ;
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void e()
    {
        synchronized (r)
        {
            o = 0;
            p = 0;
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void k()
    {
        e.b.a((Country)e.d().get(e.w), e.v.getId(), E, v);
    }
}

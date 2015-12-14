// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl;

import android.view.View;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.activity.EditViewActivity;
import com.cyberlink.youcammakeup.jniproxy.aa;
import com.cyberlink.youcammakeup.jniproxy.ab;
import com.cyberlink.youcammakeup.jniproxy.ac;
import com.cyberlink.youcammakeup.jniproxy.ad;
import com.cyberlink.youcammakeup.jniproxy.af;
import com.cyberlink.youcammakeup.jniproxy.ag;
import com.cyberlink.youcammakeup.jniproxy.ah;
import com.cyberlink.youcammakeup.jniproxy.ak;
import com.cyberlink.youcammakeup.jniproxy.c;
import com.cyberlink.youcammakeup.jniproxy.z;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.BeautifierEditCenter;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.i;
import com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ImageViewer;
import com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ae;
import com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.q;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.kernelctrl.status.a;
import com.cyberlink.youcammakeup.kernelctrl.status.x;
import com.cyberlink.youcammakeup.kernelctrl.status.y;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.ViewEngine;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.d;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.o;
import com.cyberlink.youcammakeup.utility.BeautyMode;
import com.cyberlink.youcammakeup.utility.MakeupMode;
import com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl:
//            k, ar, BeautifierTaskInfo

public class j
    implements x, y
{

    public static UUID a = UUID.randomUUID();
    private c b;
    private View c;
    private List d;
    private List e;
    private boolean f;
    private Object g;
    private AtomicBoolean h;

    public j()
    {
        b = Globals.d().a();
        c = null;
        d = null;
        e = null;
        f = false;
        g = new Object();
        h = new AtomicBoolean(false);
    }

    public static z a(z z1)
    {
        z z2 = new z();
        if (z1 != null)
        {
            ah ah1 = new ah();
            ah1.a(z1.b().b());
            ah1.b(z1.b().c());
            ah ah2 = new ah();
            ah2.a(z1.c().b());
            ah2.b(z1.c().c());
            ah ah3 = new ah();
            ah3.a(z1.d().b());
            ah3.b(z1.d().c());
            ah ah4 = new ah();
            ah4.a(z1.e().b());
            ah4.b(z1.e().c());
            z2.a(ah1);
            z2.b(ah2);
            z2.c(ah3);
            z2.d(ah4);
        }
        return z2;
    }

    public static j a()
    {
        return com.cyberlink.youcammakeup.kernelctrl.k.a();
    }

    public static List a(List list)
    {
        if (list == null)
        {
            return null;
        }
        ArrayList arraylist = new ArrayList();
        for (int l = 0; l < list.size(); l++)
        {
            if (list.get(l) != null && ((ar)list.get(l)).c != null)
            {
                ar ar1 = (ar)list.get(l);
                ar ar2 = new ar(ar1.a);
                ar2.b = ar1.b;
                ar2.c = new com.cyberlink.youcammakeup.jniproxy.y();
                ar2.c.a(ar1.c.l());
                ar2.c.a(ar1.c.j());
                ar2.c.a(ar1.c.k());
                ar2.c.a(ar1.c.b());
                ar2.c.b(ar1.c.c());
                ar2.c.a(ar1.c.d());
                ar2.c.b(ar1.c.e());
                ar2.c.a(ar1.c.f());
                ar2.c.b(ar1.c.g());
                ar2.c.b(ar1.c.i());
                ar2.c.a(ar1.c.h());
                ar2.c.a(ar1.c.m());
                ar2.d = ar1.d;
                ar2.e = ar1.e;
                ar2.f = ar1.f;
                ar2.g = ar1.g;
                arraylist.add(ar2);
            }
        }

        return arraylist;
    }

    public void a(View view)
    {
        c = view;
    }

    public void a(com.cyberlink.youcammakeup.jniproxy.y y1, boolean flag)
    {
        if (d == null || c == null || !(c instanceof ImageViewer))
        {
            return;
        }
        Object obj1 = g;
        obj1;
        JVM INSTR monitorenter ;
        Object obj;
        if (((ImageViewer)c).m == null)
        {
            break MISSING_BLOCK_LABEL_92;
        }
        obj = ((ImageViewer)c).m.i;
_L1:
        int l = ((ImageViewer)c).m.j;
        if (l != -1)
        {
            break MISSING_BLOCK_LABEL_97;
        }
        obj1;
        JVM INSTR monitorexit ;
        return;
        y1;
        obj1;
        JVM INSTR monitorexit ;
        throw y1;
        obj = null;
          goto _L1
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_512;
        }
        obj = (ar)((List) (obj)).get(l);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_512;
        }
        Object obj2;
        ((ar) (obj)).c.a(y1.b());
        ((ar) (obj)).c.b(y1.c());
        if (StatusManager.j().s() == BeautyMode.r)
        {
            String s = StatusManager.j().e();
            if (MotionControlHelper.e().b(s))
            {
                MotionControlHelper.e().a(s, false);
                MotionControlHelper.e().a(s, y1.b());
                MotionControlHelper.e().b(s, y1.c());
                BeautifierEditCenter.a().b(false);
                BeautifierEditCenter.a().a(((ar) (obj)).b, y1, false, new BeautifierTaskInfo(false));
            }
        }
        obj2 = Globals.d().t();
        if (StatusManager.j().r() == MakeupMode.a)
        {
            break MISSING_BLOCK_LABEL_263;
        }
        if (obj2 == null)
        {
            break MISSING_BLOCK_LABEL_362;
        }
        if (!((EditViewActivity) (obj2)).p())
        {
            break MISSING_BLOCK_LABEL_362;
        }
        obj2 = StatusManager.j().d();
        if (obj2 == null)
        {
            break MISSING_BLOCK_LABEL_362;
        }
        if (((i) (obj2)).v() != null)
        {
            obj2 = ((i) (obj2)).v();
            if (MotionControlHelper.e().e(((String) (obj2))))
            {
                MotionControlHelper.e().b(((String) (obj2)), false);
                MotionControlHelper.e().c(((String) (obj2)), y1.b());
                MotionControlHelper.e().d(((String) (obj2)), y1.c());
                BeautifierEditCenter.a().b(false);
                BeautifierEditCenter.a().a(((ar) (obj)).b, y1, false, new BeautifierTaskInfo(false));
            }
        }
        ((ar) (obj)).c.a(y1.d());
        ((ar) (obj)).c.b(y1.e());
        ((ar) (obj)).c.a(y1.f());
        ((ar) (obj)).c.b(y1.g());
        ((ar) (obj)).c.a(y1.j());
        ((ar) (obj)).c.a(y1.h());
        ((ar) (obj)).c.b(y1.i());
        ((ar) (obj)).c.a(y1.l());
        ((ar) (obj)).c.a(y1.k());
        ((ar) (obj)).c.a(y1.m());
        ((ImageViewer)c).k();
        ((ImageViewer)c).l();
        ((ImageViewer)c).o();
        ((ImageViewer)c).n();
        obj1;
        JVM INSTR monitorexit ;
    }

    public void a(ae ae1, int l)
    {
        Object obj1 = g;
        obj1;
        JVM INSTR monitorenter ;
        if (l == 1)
        {
            break MISSING_BLOCK_LABEL_18;
        }
        obj1;
        JVM INSTR monitorexit ;
        return;
        if (ae1 == null)
        {
            break MISSING_BLOCK_LABEL_29;
        }
        if (e != null)
        {
            break MISSING_BLOCK_LABEL_39;
        }
        obj1;
        JVM INSTR monitorexit ;
        return;
        ae1;
        obj1;
        JVM INSTR monitorexit ;
        throw ae1;
        l = ((ImageViewer)c).m.j;
        if (l != -1)
        {
            break MISSING_BLOCK_LABEL_62;
        }
        obj1;
        JVM INSTR monitorexit ;
        return;
        com.cyberlink.youcammakeup.jniproxy.y y1 = (com.cyberlink.youcammakeup.jniproxy.y)e.get(l);
        if (((ImageViewer)c).m == null) goto _L2; else goto _L1
_L1:
        Object obj = ((ImageViewer)c).m.i;
_L152:
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_112;
        }
        obj1;
        JVM INSTR monitorexit ;
        return;
        a(true);
        obj = (ar)((List) (obj)).get(l);
        if (y1 == null || obj == null) goto _L4; else goto _L3
_L3:
        Object obj2;
        ac ac1;
        ac ac2;
        ak ak1;
        ak ak2;
        ab ab1;
        ab ab2;
        aa aa1;
        ag ag1;
        af af1;
        z z1;
        z z2;
        ad ad1;
        ah ah1;
        BeautyMode beautymode;
        i i1;
        d d1;
        ac1 = y1.d();
        ac2 = y1.e();
        ab1 = y1.f();
        ab2 = y1.g();
        ak1 = y1.h();
        ak2 = y1.i();
        ag1 = y1.j();
        aa1 = y1.l();
        af1 = y1.k();
        z1 = y1.b();
        z2 = y1.c();
        ad1 = y1.m();
        ah1 = new ah();
        obj2 = new ah();
        beautymode = StatusManager.j().s();
        i1 = StatusManager.j().d();
        long l1 = StatusManager.j().l();
        d1 = ViewEngine.a().a(l1);
        if (d1 != null)
        {
            break MISSING_BLOCK_LABEL_282;
        }
        obj1;
        JVM INSTR monitorexit ;
        return;
        class _cls1
        {

            static final int a[];

            static 
            {
                a = new int[com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.values().length];
                try
                {
                    a[com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.b.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror48) { }
                try
                {
                    a[com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.c.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror47) { }
                try
                {
                    a[com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.d.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror46) { }
                try
                {
                    a[com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.e.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror45) { }
                try
                {
                    a[com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.a.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror44) { }
                try
                {
                    a[com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.g.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror43) { }
                try
                {
                    a[com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.h.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror42) { }
                try
                {
                    a[com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.i.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror41) { }
                try
                {
                    a[com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.j.ordinal()] = 9;
                }
                catch (NoSuchFieldError nosuchfielderror40) { }
                try
                {
                    a[com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.f.ordinal()] = 10;
                }
                catch (NoSuchFieldError nosuchfielderror39) { }
                try
                {
                    a[com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.T.ordinal()] = 11;
                }
                catch (NoSuchFieldError nosuchfielderror38) { }
                try
                {
                    a[com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.U.ordinal()] = 12;
                }
                catch (NoSuchFieldError nosuchfielderror37) { }
                try
                {
                    a[com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.V.ordinal()] = 13;
                }
                catch (NoSuchFieldError nosuchfielderror36) { }
                try
                {
                    a[com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.W.ordinal()] = 14;
                }
                catch (NoSuchFieldError nosuchfielderror35) { }
                try
                {
                    a[com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.P.ordinal()] = 15;
                }
                catch (NoSuchFieldError nosuchfielderror34) { }
                try
                {
                    a[com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.Q.ordinal()] = 16;
                }
                catch (NoSuchFieldError nosuchfielderror33) { }
                try
                {
                    a[com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.R.ordinal()] = 17;
                }
                catch (NoSuchFieldError nosuchfielderror32) { }
                try
                {
                    a[com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.S.ordinal()] = 18;
                }
                catch (NoSuchFieldError nosuchfielderror31) { }
                try
                {
                    a[com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.k.ordinal()] = 19;
                }
                catch (NoSuchFieldError nosuchfielderror30) { }
                try
                {
                    a[com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.l.ordinal()] = 20;
                }
                catch (NoSuchFieldError nosuchfielderror29) { }
                try
                {
                    a[com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.m.ordinal()] = 21;
                }
                catch (NoSuchFieldError nosuchfielderror28) { }
                try
                {
                    a[com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.n.ordinal()] = 22;
                }
                catch (NoSuchFieldError nosuchfielderror27) { }
                try
                {
                    a[com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.o.ordinal()] = 23;
                }
                catch (NoSuchFieldError nosuchfielderror26) { }
                try
                {
                    a[com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.p.ordinal()] = 24;
                }
                catch (NoSuchFieldError nosuchfielderror25) { }
                try
                {
                    a[com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.q.ordinal()] = 25;
                }
                catch (NoSuchFieldError nosuchfielderror24) { }
                try
                {
                    a[com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.r.ordinal()] = 26;
                }
                catch (NoSuchFieldError nosuchfielderror23) { }
                try
                {
                    a[com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.s.ordinal()] = 27;
                }
                catch (NoSuchFieldError nosuchfielderror22) { }
                try
                {
                    a[com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.x.ordinal()] = 28;
                }
                catch (NoSuchFieldError nosuchfielderror21) { }
                try
                {
                    a[com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.y.ordinal()] = 29;
                }
                catch (NoSuchFieldError nosuchfielderror20) { }
                try
                {
                    a[com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.z.ordinal()] = 30;
                }
                catch (NoSuchFieldError nosuchfielderror19) { }
                try
                {
                    a[com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.A.ordinal()] = 31;
                }
                catch (NoSuchFieldError nosuchfielderror18) { }
                try
                {
                    a[com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.B.ordinal()] = 32;
                }
                catch (NoSuchFieldError nosuchfielderror17) { }
                try
                {
                    a[com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.C.ordinal()] = 33;
                }
                catch (NoSuchFieldError nosuchfielderror16) { }
                try
                {
                    a[com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.D.ordinal()] = 34;
                }
                catch (NoSuchFieldError nosuchfielderror15) { }
                try
                {
                    a[com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.E.ordinal()] = 35;
                }
                catch (NoSuchFieldError nosuchfielderror14) { }
                try
                {
                    a[com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.F.ordinal()] = 36;
                }
                catch (NoSuchFieldError nosuchfielderror13) { }
                try
                {
                    a[com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.G.ordinal()] = 37;
                }
                catch (NoSuchFieldError nosuchfielderror12) { }
                try
                {
                    a[com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.H.ordinal()] = 38;
                }
                catch (NoSuchFieldError nosuchfielderror11) { }
                try
                {
                    a[com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.I.ordinal()] = 39;
                }
                catch (NoSuchFieldError nosuchfielderror10) { }
                try
                {
                    a[com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.J.ordinal()] = 40;
                }
                catch (NoSuchFieldError nosuchfielderror9) { }
                try
                {
                    a[com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.K.ordinal()] = 41;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                try
                {
                    a[com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.L.ordinal()] = 42;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    a[com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.M.ordinal()] = 43;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    a[com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.N.ordinal()] = 44;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    a[com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.t.ordinal()] = 45;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    a[com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.v.ordinal()] = 46;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    a[com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.X.ordinal()] = 47;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.Y.ordinal()] = 48;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.Z.ordinal()] = 49;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        com.cyberlink.youcammakeup.kernelctrl._cls1.a[ae1.b.ordinal()];
        JVM INSTR tableswitch 1 49: default 6560
    //                   1 752
    //                   2 952
    //                   3 1152
    //                   4 1352
    //                   5 1552
    //                   6 1752
    //                   7 1952
    //                   8 2152
    //                   9 2352
    //                   10 2552
    //                   11 2752
    //                   12 2844
    //                   13 2936
    //                   14 3028
    //                   15 3120
    //                   16 3212
    //                   17 3304
    //                   18 3396
    //                   19 3488
    //                   20 3541
    //                   21 3594
    //                   22 3647
    //                   23 3700
    //                   24 3753
    //                   25 4000
    //                   26 4247
    //                   27 4494
    //                   28 4741
    //                   29 4988
    //                   30 5041
    //                   31 5094
    //                   32 5147
    //                   33 5200
    //                   34 5253
    //                   35 5306
    //                   36 5359
    //                   37 5412
    //                   38 5465
    //                   39 5518
    //                   40 5571
    //                   41 5624
    //                   42 5677
    //                   43 5730
    //                   44 5783
    //                   45 5836
    //                   46 6083
    //                   47 6330
    //                   48 6383
    //                   49 6436;
           goto _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L19 _L20 _L21 _L22 _L23 _L24 _L25 _L26 _L27 _L28 _L29 _L30 _L31 _L32 _L33 _L34 _L35 _L36 _L37 _L38 _L39 _L40 _L41 _L42 _L43 _L44 _L45 _L46 _L47 _L48 _L49 _L50 _L51 _L52 _L53
_L4:
        if (y1 == null || obj == null) goto _L55; else goto _L54
_L54:
        if (((ar) (obj)).c == null) goto _L55; else goto _L56
_L56:
        y1.a(((ar) (obj)).c.b());
        y1.b(((ar) (obj)).c.c());
        if (StatusManager.j().s() != BeautyMode.r)
        {
            break MISSING_BLOCK_LABEL_595;
        }
        ae1 = StatusManager.j().e();
        if (ae1 == null)
        {
            break MISSING_BLOCK_LABEL_595;
        }
        MotionControlHelper.e().a(ae1, ((ar) (obj)).c.b());
        MotionControlHelper.e().b(ae1, ((ar) (obj)).c.c());
        ae1 = Globals.d().t();
        if (StatusManager.j().r() == MakeupMode.a) goto _L58; else goto _L57
_L57:
        if (ae1 == null) goto _L60; else goto _L59
_L59:
        if (!ae1.p()) goto _L60; else goto _L58
_L58:
        obj2 = StatusManager.j().d();
        if (obj2 != null) goto _L62; else goto _L61
_L61:
        MotionControlHelper.e().c("default_original_looks", ((ar) (obj)).c.b());
        MotionControlHelper.e().d("default_original_looks", ((ar) (obj)).c.c());
_L60:
        if (StatusManager.j().s() == BeautyMode.s)
        {
            MotionControlHelper.e().a(MotionControlHelper.e().a(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.a), false, new BeautifierTaskInfo(false));
        }
        BeautifierEditCenter.a().a(((ar) (obj)).b, y1, true, new BeautifierTaskInfo(true));
        if (ae1 == null) goto _L55; else goto _L63
_L63:
        if (StatusManager.j().r() != MakeupMode.a)
        {
            break MISSING_BLOCK_LABEL_6542;
        }
        ae1.h();
_L55:
        obj1;
        JVM INSTR monitorexit ;
        return;
_L5:
        ah1.a(((ar) (obj)).c.d().b().b());
        ah1.b(((ar) (obj)).c.d().b().c());
        ((ah) (obj2)).a(ah1.b());
        ((ah) (obj2)).b(ah1.c());
        if (i1 == null) goto _L65; else goto _L64
_L64:
        if (i1.j() != -1F) goto _L66; else goto _L65
_L65:
        if (beautymode != BeautyMode.o) goto _L67; else goto _L66
_L66:
        if (beautymode != BeautyMode.o)
        {
            break MISSING_BLOCK_LABEL_909;
        }
        ae1 = Boolean.valueOf(b.a((int)d1.a.a, (int)d1.a.b, MotionControlHelper.e().a(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.a), ac1, ah1, ((ah) (obj2))));
_L68:
        if (ae1.booleanValue());
_L67:
        ac1.a(((ah) (obj2)));
        y1.a(ac1);
          goto _L4
        ae1 = Boolean.valueOf(b.a((int)d1.a.a, (int)d1.a.b, i1.j(), ac1, ah1, ((ah) (obj2))));
          goto _L68
_L6:
        ah1.a(((ar) (obj)).c.d().c().b());
        ah1.b(((ar) (obj)).c.d().c().c());
        ((ah) (obj2)).a(ah1.b());
        ((ah) (obj2)).b(ah1.c());
        if (i1 == null) goto _L70; else goto _L69
_L69:
        if (i1.j() != -1F) goto _L71; else goto _L70
_L70:
        if (beautymode != BeautyMode.o) goto _L72; else goto _L71
_L71:
        if (beautymode != BeautyMode.o)
        {
            break MISSING_BLOCK_LABEL_1109;
        }
        ae1 = Boolean.valueOf(b.a((int)d1.a.a, (int)d1.a.b, MotionControlHelper.e().a(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.a), ac1, ah1, ((ah) (obj2))));
_L73:
        if (ae1.booleanValue());
_L72:
        ac1.b(((ah) (obj2)));
        y1.a(ac1);
          goto _L4
        ae1 = Boolean.valueOf(b.a((int)d1.a.a, (int)d1.a.b, i1.j(), ac1, ah1, ((ah) (obj2))));
          goto _L73
_L7:
        ah1.a(((ar) (obj)).c.d().d().b());
        ah1.b(((ar) (obj)).c.d().d().c());
        ((ah) (obj2)).a(ah1.b());
        ((ah) (obj2)).b(ah1.c());
        if (i1 == null) goto _L75; else goto _L74
_L74:
        if (i1.j() != -1F) goto _L76; else goto _L75
_L75:
        if (beautymode != BeautyMode.o) goto _L77; else goto _L76
_L76:
        if (beautymode != BeautyMode.o)
        {
            break MISSING_BLOCK_LABEL_1309;
        }
        ae1 = Boolean.valueOf(b.a((int)d1.a.a, (int)d1.a.b, MotionControlHelper.e().a(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.a), ac1, ah1, ((ah) (obj2))));
_L78:
        if (ae1.booleanValue());
_L77:
        ac1.c(((ah) (obj2)));
        y1.a(ac1);
          goto _L4
        ae1 = Boolean.valueOf(b.a((int)d1.a.a, (int)d1.a.b, i1.j(), ac1, ah1, ((ah) (obj2))));
          goto _L78
_L8:
        ah1.a(((ar) (obj)).c.d().e().b());
        ah1.b(((ar) (obj)).c.d().e().c());
        ((ah) (obj2)).a(ah1.b());
        ((ah) (obj2)).b(ah1.c());
        if (i1 == null) goto _L80; else goto _L79
_L79:
        if (i1.j() != -1F) goto _L81; else goto _L80
_L80:
        if (beautymode != BeautyMode.o) goto _L82; else goto _L81
_L81:
        if (beautymode != BeautyMode.o)
        {
            break MISSING_BLOCK_LABEL_1509;
        }
        ae1 = Boolean.valueOf(b.a((int)d1.a.a, (int)d1.a.b, MotionControlHelper.e().a(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.a), ac1, ah1, ((ah) (obj2))));
_L83:
        if (ae1.booleanValue());
_L82:
        ac1.d(((ah) (obj2)));
        y1.a(ac1);
          goto _L4
        ae1 = Boolean.valueOf(b.a((int)d1.a.a, (int)d1.a.b, i1.j(), ac1, ah1, ((ah) (obj2))));
          goto _L83
_L9:
        ah1.a(((ar) (obj)).c.d().f().b());
        ah1.b(((ar) (obj)).c.d().f().c());
        ((ah) (obj2)).a(ah1.b());
        ((ah) (obj2)).b(ah1.c());
        if (i1 == null) goto _L85; else goto _L84
_L84:
        if (i1.j() != -1F) goto _L86; else goto _L85
_L85:
        if (beautymode != BeautyMode.o) goto _L87; else goto _L86
_L86:
        if (beautymode != BeautyMode.o)
        {
            break MISSING_BLOCK_LABEL_1709;
        }
        ae1 = Boolean.valueOf(b.a((int)d1.a.a, (int)d1.a.b, MotionControlHelper.e().a(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.a), ac1, ah1, ((ah) (obj2))));
_L88:
        if (ae1.booleanValue());
_L87:
        ac1.e(((ah) (obj2)));
        y1.a(ac1);
          goto _L4
        ae1 = Boolean.valueOf(b.a((int)d1.a.a, (int)d1.a.b, i1.j(), ac1, ah1, ((ah) (obj2))));
          goto _L88
_L10:
        ah1.a(((ar) (obj)).c.e().b().b());
        ah1.b(((ar) (obj)).c.e().b().c());
        ((ah) (obj2)).a(ah1.b());
        ((ah) (obj2)).b(ah1.c());
        if (i1 == null) goto _L90; else goto _L89
_L89:
        if (i1.j() != -1F) goto _L91; else goto _L90
_L90:
        if (beautymode != BeautyMode.o) goto _L92; else goto _L91
_L91:
        if (beautymode != BeautyMode.o)
        {
            break MISSING_BLOCK_LABEL_1909;
        }
        ae1 = Boolean.valueOf(b.a((int)d1.a.a, (int)d1.a.b, MotionControlHelper.e().a(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.a), ac2, ah1, ((ah) (obj2))));
_L93:
        if (ae1.booleanValue());
_L92:
        ac2.a(((ah) (obj2)));
        y1.b(ac2);
          goto _L4
        ae1 = Boolean.valueOf(b.a((int)d1.a.a, (int)d1.a.b, i1.j(), ac2, ah1, ((ah) (obj2))));
          goto _L93
_L11:
        ah1.a(((ar) (obj)).c.e().c().b());
        ah1.b(((ar) (obj)).c.e().c().c());
        ((ah) (obj2)).a(ah1.b());
        ((ah) (obj2)).b(ah1.c());
        if (i1 == null) goto _L95; else goto _L94
_L94:
        if (i1.j() != -1F) goto _L96; else goto _L95
_L95:
        if (beautymode != BeautyMode.o) goto _L97; else goto _L96
_L96:
        if (beautymode != BeautyMode.o)
        {
            break MISSING_BLOCK_LABEL_2109;
        }
        ae1 = Boolean.valueOf(b.a((int)d1.a.a, (int)d1.a.b, MotionControlHelper.e().a(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.a), ac2, ah1, ((ah) (obj2))));
_L98:
        if (ae1.booleanValue());
_L97:
        ac2.b(((ah) (obj2)));
        y1.b(ac2);
          goto _L4
        ae1 = Boolean.valueOf(b.a((int)d1.a.a, (int)d1.a.b, i1.j(), ac2, ah1, ((ah) (obj2))));
          goto _L98
_L12:
        ah1.a(((ar) (obj)).c.e().d().b());
        ah1.b(((ar) (obj)).c.e().d().c());
        ((ah) (obj2)).a(ah1.b());
        ((ah) (obj2)).b(ah1.c());
        if (i1 == null) goto _L100; else goto _L99
_L99:
        if (i1.j() != -1F) goto _L101; else goto _L100
_L100:
        if (beautymode != BeautyMode.o) goto _L102; else goto _L101
_L101:
        if (beautymode != BeautyMode.o)
        {
            break MISSING_BLOCK_LABEL_2309;
        }
        ae1 = Boolean.valueOf(b.a((int)d1.a.a, (int)d1.a.b, MotionControlHelper.e().a(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.a), ac2, ah1, ((ah) (obj2))));
_L103:
        if (ae1.booleanValue());
_L102:
        ac2.c(((ah) (obj2)));
        y1.b(ac2);
          goto _L4
        ae1 = Boolean.valueOf(b.a((int)d1.a.a, (int)d1.a.b, i1.j(), ac2, ah1, ((ah) (obj2))));
          goto _L103
_L13:
        ah1.a(((ar) (obj)).c.e().e().b());
        ah1.b(((ar) (obj)).c.e().e().c());
        ((ah) (obj2)).a(ah1.b());
        ((ah) (obj2)).b(ah1.c());
        if (i1 == null) goto _L105; else goto _L104
_L104:
        if (i1.j() != -1F) goto _L106; else goto _L105
_L105:
        if (beautymode != BeautyMode.o) goto _L107; else goto _L106
_L106:
        if (beautymode != BeautyMode.o)
        {
            break MISSING_BLOCK_LABEL_2509;
        }
        ae1 = Boolean.valueOf(b.a((int)d1.a.a, (int)d1.a.b, MotionControlHelper.e().a(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.a), ac2, ah1, ((ah) (obj2))));
_L108:
        if (ae1.booleanValue());
_L107:
        ac2.d(((ah) (obj2)));
        y1.b(ac2);
          goto _L4
        ae1 = Boolean.valueOf(b.a((int)d1.a.a, (int)d1.a.b, i1.j(), ac2, ah1, ((ah) (obj2))));
          goto _L108
_L14:
        ah1.a(((ar) (obj)).c.e().f().b());
        ah1.b(((ar) (obj)).c.e().f().c());
        ((ah) (obj2)).a(ah1.b());
        ((ah) (obj2)).b(ah1.c());
        if (i1 == null) goto _L110; else goto _L109
_L109:
        if (i1.j() != -1F) goto _L111; else goto _L110
_L110:
        if (beautymode != BeautyMode.o) goto _L112; else goto _L111
_L111:
        if (beautymode != BeautyMode.o)
        {
            break MISSING_BLOCK_LABEL_2709;
        }
        ae1 = Boolean.valueOf(b.a((int)d1.a.a, (int)d1.a.b, MotionControlHelper.e().a(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.a), ac2, ah1, ((ah) (obj2))));
_L113:
        if (ae1.booleanValue());
_L112:
        ac2.e(((ah) (obj2)));
        y1.b(ac2);
          goto _L4
        ae1 = Boolean.valueOf(b.a((int)d1.a.a, (int)d1.a.b, i1.j(), ac2, ah1, ((ah) (obj2))));
          goto _L113
_L15:
        ah1.a(((ar) (obj)).c.b().b().b());
        ah1.b(((ar) (obj)).c.b().b().c());
        ((ah) (obj2)).a(ah1.b());
        ((ah) (obj2)).b(ah1.c());
        z1.b().a(((ah) (obj2)).b());
        z1.b().b(((ah) (obj2)).c());
        y1.a(z1);
          goto _L4
_L16:
        ah1.a(((ar) (obj)).c.b().c().b());
        ah1.b(((ar) (obj)).c.b().c().c());
        ((ah) (obj2)).a(ah1.b());
        ((ah) (obj2)).b(ah1.c());
        z1.c().a(((ah) (obj2)).b());
        z1.c().b(((ah) (obj2)).c());
        y1.a(z1);
          goto _L4
_L17:
        ah1.a(((ar) (obj)).c.b().d().b());
        ah1.b(((ar) (obj)).c.b().d().c());
        ((ah) (obj2)).a(ah1.b());
        ((ah) (obj2)).b(ah1.c());
        z1.d().a(((ah) (obj2)).b());
        z1.d().b(((ah) (obj2)).c());
        y1.a(z1);
          goto _L4
_L18:
        ah1.a(((ar) (obj)).c.b().e().b());
        ah1.b(((ar) (obj)).c.b().e().c());
        ((ah) (obj2)).a(ah1.b());
        ((ah) (obj2)).b(ah1.c());
        z1.e().a(((ah) (obj2)).b());
        z1.e().b(((ah) (obj2)).c());
        y1.a(z1);
          goto _L4
_L19:
        ah1.a(((ar) (obj)).c.c().b().b());
        ah1.b(((ar) (obj)).c.c().b().c());
        ((ah) (obj2)).a(ah1.b());
        ((ah) (obj2)).b(ah1.c());
        z2.b().a(((ah) (obj2)).b());
        z2.b().b(((ah) (obj2)).c());
        y1.b(z2);
          goto _L4
_L20:
        ah1.a(((ar) (obj)).c.c().c().b());
        ah1.b(((ar) (obj)).c.c().c().c());
        ((ah) (obj2)).a(ah1.b());
        ((ah) (obj2)).b(ah1.c());
        z2.c().a(((ah) (obj2)).b());
        z2.c().b(((ah) (obj2)).c());
        y1.b(z2);
          goto _L4
_L21:
        ah1.a(((ar) (obj)).c.c().d().b());
        ah1.b(((ar) (obj)).c.c().d().c());
        ((ah) (obj2)).a(ah1.b());
        ((ah) (obj2)).b(ah1.c());
        z2.d().a(((ah) (obj2)).b());
        z2.d().b(((ah) (obj2)).c());
        y1.b(z2);
          goto _L4
_L22:
        ah1.a(((ar) (obj)).c.c().e().b());
        ah1.b(((ar) (obj)).c.c().e().c());
        ((ah) (obj2)).a(ah1.b());
        ((ah) (obj2)).b(ah1.c());
        z2.e().a(((ah) (obj2)).b());
        z2.e().b(((ah) (obj2)).c());
        y1.b(z2);
          goto _L4
_L23:
        ((ah) (obj2)).a(((ar) (obj)).c.j().c().b());
        ((ah) (obj2)).b(((ar) (obj)).c.j().c().c());
        ag1.b(((ah) (obj2)));
        y1.a(ag1);
          goto _L4
_L24:
        ((ah) (obj2)).a(((ar) (obj)).c.j().d().b());
        ((ah) (obj2)).b(((ar) (obj)).c.j().d().c());
        ag1.c(((ah) (obj2)));
        y1.a(ag1);
          goto _L4
_L25:
        ((ah) (obj2)).a(((ar) (obj)).c.j().e().b());
        ((ah) (obj2)).b(((ar) (obj)).c.j().e().c());
        ag1.d(((ah) (obj2)));
        y1.a(ag1);
          goto _L4
_L26:
        ((ah) (obj2)).a(((ar) (obj)).c.j().b().b());
        ((ah) (obj2)).b(((ar) (obj)).c.j().b().c());
        ag1.a(((ah) (obj2)));
        y1.a(ag1);
          goto _L4
_L27:
        ((ah) (obj2)).a(((ar) (obj)).c.j().f().b());
        ((ah) (obj2)).b(((ar) (obj)).c.j().f().c());
        ag1.e(((ah) (obj2)));
        y1.a(ag1);
          goto _L4
_L28:
        ah1.a(((ar) (obj)).c.h().b().b());
        ah1.b(((ar) (obj)).c.h().b().c());
        ((ah) (obj2)).a(ah1.b());
        ((ah) (obj2)).b(ah1.c());
        if (i1 == null) goto _L115; else goto _L114
_L114:
        if (i1.p() != -1F) goto _L116; else goto _L115
_L115:
        if (beautymode != BeautyMode.h) goto _L117; else goto _L116
_L116:
        if (beautymode != BeautyMode.h)
        {
            break MISSING_BLOCK_LABEL_3943;
        }
        ae1 = Boolean.valueOf(b.a((int)d1.a.a, (int)d1.a.b, MotionControlHelper.e().a(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.a), ac1, ac2, af1, ab1, ab2, ak1, ak2, aa1, ah1, ((ah) (obj2))));
_L118:
        if (ae1.booleanValue());
_L117:
        ak1.b().a(((ah) (obj2)).b());
        ak1.b().b(((ah) (obj2)).c());
        y1.a(ak1);
          goto _L4
        ae1 = Boolean.valueOf(b.a((int)d1.a.a, (int)d1.a.b, i1.p(), ac1, ac2, af1, ab1, ab2, ak1, ak2, aa1, ah1, ((ah) (obj2))));
          goto _L118
_L29:
        ah1.a(((ar) (obj)).c.h().c().b());
        ah1.b(((ar) (obj)).c.h().c().c());
        ((ah) (obj2)).a(ah1.b());
        ((ah) (obj2)).b(ah1.c());
        if (i1 == null) goto _L120; else goto _L119
_L119:
        if (i1.p() != -1F) goto _L121; else goto _L120
_L120:
        if (beautymode != BeautyMode.h) goto _L122; else goto _L121
_L121:
        if (beautymode != BeautyMode.h)
        {
            break MISSING_BLOCK_LABEL_4190;
        }
        ae1 = Boolean.valueOf(b.a((int)d1.a.a, (int)d1.a.b, MotionControlHelper.e().a(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.a), ac1, ac2, af1, ab1, ab2, ak1, ak2, aa1, ah1, ((ah) (obj2))));
_L123:
        if (ae1.booleanValue());
_L122:
        ak1.c().a(((ah) (obj2)).b());
        ak1.c().b(((ah) (obj2)).c());
        y1.a(ak1);
          goto _L4
        ae1 = Boolean.valueOf(b.a((int)d1.a.a, (int)d1.a.b, i1.p(), ac1, ac2, af1, ab1, ab2, ak1, ak2, aa1, ah1, ((ah) (obj2))));
          goto _L123
_L30:
        ah1.a(((ar) (obj)).c.i().b().b());
        ah1.b(((ar) (obj)).c.i().b().c());
        ((ah) (obj2)).a(ah1.b());
        ((ah) (obj2)).b(ah1.c());
        if (i1 == null) goto _L125; else goto _L124
_L124:
        if (i1.p() != -1F) goto _L126; else goto _L125
_L125:
        if (beautymode != BeautyMode.h) goto _L127; else goto _L126
_L126:
        if (beautymode != BeautyMode.h)
        {
            break MISSING_BLOCK_LABEL_4437;
        }
        ae1 = Boolean.valueOf(b.a((int)d1.a.a, (int)d1.a.b, MotionControlHelper.e().a(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.a), ac1, ac2, af1, ab1, ab2, ak1, ak2, aa1, ah1, ((ah) (obj2))));
_L128:
        if (ae1.booleanValue());
_L127:
        ak2.b().a(((ah) (obj2)).b());
        ak2.b().b(((ah) (obj2)).c());
        y1.b(ak2);
          goto _L4
        ae1 = Boolean.valueOf(b.a((int)d1.a.a, (int)d1.a.b, i1.p(), ac1, ac2, af1, ab1, ab2, ak1, ak2, aa1, ah1, ((ah) (obj2))));
          goto _L128
_L31:
        ah1.a(((ar) (obj)).c.i().c().b());
        ah1.b(((ar) (obj)).c.i().c().c());
        ((ah) (obj2)).a(ah1.b());
        ((ah) (obj2)).b(ah1.c());
        if (i1 == null) goto _L130; else goto _L129
_L129:
        if (i1.p() != -1F) goto _L131; else goto _L130
_L130:
        if (beautymode != BeautyMode.h) goto _L132; else goto _L131
_L131:
        if (beautymode != BeautyMode.h)
        {
            break MISSING_BLOCK_LABEL_4684;
        }
        ae1 = Boolean.valueOf(b.a((int)d1.a.a, (int)d1.a.b, MotionControlHelper.e().a(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.a), ac1, ac2, af1, ab1, ab2, ak1, ak2, aa1, ah1, ((ah) (obj2))));
_L133:
        if (ae1.booleanValue());
_L132:
        ak2.c().a(((ah) (obj2)).b());
        ak2.c().b(((ah) (obj2)).c());
        y1.b(ak2);
          goto _L4
        ae1 = Boolean.valueOf(b.a((int)d1.a.a, (int)d1.a.b, i1.p(), ac1, ac2, af1, ab1, ab2, ak1, ak2, aa1, ah1, ((ah) (obj2))));
          goto _L133
_L32:
        ah1.a(((ar) (obj)).c.l().b().b());
        ah1.b(((ar) (obj)).c.l().b().c());
        ((ah) (obj2)).a(ah1.b());
        ((ah) (obj2)).b(ah1.c());
        if (i1 == null) goto _L135; else goto _L134
_L134:
        if (i1.p() != -1F) goto _L136; else goto _L135
_L135:
        if (beautymode != BeautyMode.h) goto _L137; else goto _L136
_L136:
        if (beautymode != BeautyMode.h)
        {
            break MISSING_BLOCK_LABEL_4931;
        }
        ae1 = Boolean.valueOf(b.a((int)d1.a.a, (int)d1.a.b, MotionControlHelper.e().a(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.a), ac1, ac2, af1, ab1, ab2, ak1, ak2, aa1, ah1, ((ah) (obj2))));
_L138:
        if (ae1.booleanValue());
_L137:
        aa1.b().a(((ah) (obj2)).b());
        aa1.b().b(((ah) (obj2)).c());
        y1.a(aa1);
          goto _L4
        ae1 = Boolean.valueOf(b.a((int)d1.a.a, (int)d1.a.b, i1.p(), ac1, ac2, af1, ab1, ab2, ak1, ak2, aa1, ah1, ((ah) (obj2))));
          goto _L138
_L33:
        ((ah) (obj2)).a(((ar) (obj)).c.k().b().b());
        ((ah) (obj2)).b(((ar) (obj)).c.k().b().c());
        af1.a(((ah) (obj2)));
        y1.a(af1);
          goto _L4
_L34:
        ((ah) (obj2)).a(((ar) (obj)).c.k().e().b());
        ((ah) (obj2)).b(((ar) (obj)).c.k().e().c());
        af1.d(((ah) (obj2)));
        y1.a(af1);
          goto _L4
_L35:
        ((ah) (obj2)).a(((ar) (obj)).c.k().c().b());
        ((ah) (obj2)).b(((ar) (obj)).c.k().c().c());
        af1.b(((ah) (obj2)));
        y1.a(af1);
          goto _L4
_L36:
        ((ah) (obj2)).a(((ar) (obj)).c.k().d().b());
        ((ah) (obj2)).b(((ar) (obj)).c.k().d().c());
        af1.c(((ah) (obj2)));
        y1.a(af1);
          goto _L4
_L37:
        ((ah) (obj2)).a(((ar) (obj)).c.k().f().b());
        ((ah) (obj2)).b(((ar) (obj)).c.k().f().c());
        af1.e(((ah) (obj2)));
        y1.a(af1);
          goto _L4
_L38:
        ((ah) (obj2)).a(((ar) (obj)).c.k().g().b());
        ((ah) (obj2)).b(((ar) (obj)).c.k().g().c());
        af1.f(((ah) (obj2)));
        y1.a(af1);
          goto _L4
_L39:
        ((ah) (obj2)).a(((ar) (obj)).c.k().h().b());
        ((ah) (obj2)).b(((ar) (obj)).c.k().h().c());
        af1.g(((ah) (obj2)));
        y1.a(af1);
          goto _L4
_L40:
        ((ah) (obj2)).a(((ar) (obj)).c.k().i().b());
        ((ah) (obj2)).b(((ar) (obj)).c.k().i().c());
        af1.h(((ah) (obj2)));
        y1.a(af1);
          goto _L4
_L41:
        ((ah) (obj2)).a(((ar) (obj)).c.k().j().b());
        ((ah) (obj2)).b(((ar) (obj)).c.k().j().c());
        af1.i(((ah) (obj2)));
        y1.a(af1);
          goto _L4
_L42:
        ((ah) (obj2)).a(((ar) (obj)).c.k().k().b());
        ((ah) (obj2)).b(((ar) (obj)).c.k().k().c());
        af1.j(((ah) (obj2)));
        y1.a(af1);
          goto _L4
_L43:
        ((ah) (obj2)).a(((ar) (obj)).c.k().q().b());
        ((ah) (obj2)).b(((ar) (obj)).c.k().q().c());
        af1.p(((ah) (obj2)));
        y1.a(af1);
          goto _L4
_L44:
        ((ah) (obj2)).a(((ar) (obj)).c.k().p().b());
        ((ah) (obj2)).b(((ar) (obj)).c.k().p().c());
        af1.o(((ah) (obj2)));
        y1.a(af1);
          goto _L4
_L45:
        ((ah) (obj2)).a(((ar) (obj)).c.k().o().b());
        ((ah) (obj2)).b(((ar) (obj)).c.k().o().c());
        af1.n(((ah) (obj2)));
        y1.a(af1);
          goto _L4
_L46:
        ((ah) (obj2)).a(((ar) (obj)).c.k().n().b());
        ((ah) (obj2)).b(((ar) (obj)).c.k().n().c());
        af1.m(((ah) (obj2)));
        y1.a(af1);
          goto _L4
_L47:
        ((ah) (obj2)).a(((ar) (obj)).c.k().m().b());
        ((ah) (obj2)).b(((ar) (obj)).c.k().m().c());
        af1.l(((ah) (obj2)));
        y1.a(af1);
          goto _L4
_L48:
        ((ah) (obj2)).a(((ar) (obj)).c.k().l().b());
        ((ah) (obj2)).b(((ar) (obj)).c.k().l().c());
        af1.k(((ah) (obj2)));
        y1.a(af1);
          goto _L4
_L49:
        ah1.a(((ar) (obj)).c.f().b().b());
        ah1.b(((ar) (obj)).c.f().b().c());
        ((ah) (obj2)).a(ah1.b());
        ((ah) (obj2)).b(ah1.c());
        if (i1 == null) goto _L140; else goto _L139
_L139:
        if (i1.p() != -1F) goto _L141; else goto _L140
_L140:
        if (beautymode != BeautyMode.h) goto _L142; else goto _L141
_L141:
        if (beautymode != BeautyMode.h)
        {
            break MISSING_BLOCK_LABEL_6026;
        }
        ae1 = Boolean.valueOf(b.a((int)d1.a.a, (int)d1.a.b, MotionControlHelper.e().a(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.a), ac1, ac2, af1, ab1, ab2, ak1, ak2, aa1, ah1, ((ah) (obj2))));
_L143:
        if (ae1.booleanValue());
_L142:
        ab1.b().a(((ah) (obj2)).b());
        ab1.b().b(((ah) (obj2)).c());
        y1.a(ab1);
          goto _L4
        ae1 = Boolean.valueOf(b.a((int)d1.a.a, (int)d1.a.b, i1.p(), ac1, ac2, af1, ab1, ab2, ak1, ak2, aa1, ah1, ((ah) (obj2))));
          goto _L143
_L50:
        ah1.a(((ar) (obj)).c.g().b().b());
        ah1.b(((ar) (obj)).c.g().b().c());
        ((ah) (obj2)).a(ah1.b());
        ((ah) (obj2)).b(ah1.c());
        if (i1 == null) goto _L145; else goto _L144
_L144:
        if (i1.p() != -1F) goto _L146; else goto _L145
_L145:
        if (beautymode != BeautyMode.h) goto _L147; else goto _L146
_L146:
        if (beautymode != BeautyMode.h)
        {
            break MISSING_BLOCK_LABEL_6273;
        }
        ae1 = Boolean.valueOf(b.a((int)d1.a.a, (int)d1.a.b, MotionControlHelper.e().a(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.a), ac1, ac2, af1, ab1, ab2, ak1, ak2, aa1, ah1, ((ah) (obj2))));
_L148:
        if (ae1.booleanValue());
_L147:
        ab2.b().a(((ah) (obj2)).b());
        ab2.b().b(((ah) (obj2)).c());
        y1.b(ab2);
          goto _L4
        ae1 = Boolean.valueOf(b.a((int)d1.a.a, (int)d1.a.b, i1.p(), ac1, ac2, af1, ab1, ab2, ak1, ak2, aa1, ah1, ((ah) (obj2))));
          goto _L148
_L51:
        ((ah) (obj2)).a(((ar) (obj)).c.m().b().b());
        ((ah) (obj2)).b(((ar) (obj)).c.m().b().c());
        ad1.a(((ah) (obj2)));
        y1.a(ad1);
          goto _L4
_L52:
        ((ah) (obj2)).a(((ar) (obj)).c.m().c().b());
        ((ah) (obj2)).b(((ar) (obj)).c.m().c().c());
        ad1.b(((ah) (obj2)));
        y1.a(ad1);
          goto _L4
_L53:
        ((ah) (obj2)).a(((ar) (obj)).c.m().d().b());
        ((ah) (obj2)).b(((ar) (obj)).c.m().d().c());
        ad1.c(((ah) (obj2)));
        y1.a(ad1);
          goto _L4
_L62:
        if (obj2 == null) goto _L60; else goto _L149
_L149:
        if (((i) (obj2)).v() == null) goto _L60; else goto _L150
_L150:
        obj2 = ((i) (obj2)).v();
        MotionControlHelper.e().c(((String) (obj2)), ((ar) (obj)).c.b());
        MotionControlHelper.e().d(((String) (obj2)), ((ar) (obj)).c.c());
          goto _L60
        Globals.d().i().b(ae1);
          goto _L55
_L2:
        obj = null;
        if (true) goto _L152; else goto _L151
_L151:
    }

    public void a(com.cyberlink.youcammakeup.kernelctrl.status.d d1)
    {
        ImageViewer imageviewer;
        while (c == null || ((imageviewer = (ImageViewer)c).m == null || imageviewer.m.i == null || d1 == null)) 
        {
            return;
        }
        Object obj1 = g;
        obj1;
        JVM INSTR monitorenter ;
        if (d == null || d.size() <= 0) goto _L2; else goto _L1
_L1:
        Object obj = d1.e();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_82;
        }
        if (((a) (obj)).d() != null)
        {
            break MISSING_BLOCK_LABEL_90;
        }
        obj1;
        JVM INSTR monitorexit ;
        return;
        d1;
        obj1;
        JVM INSTR monitorexit ;
        throw d1;
        int l = ((a) (obj)).e;
        if (l != -1)
        {
            break MISSING_BLOCK_LABEL_105;
        }
        obj1;
        JVM INSTR monitorexit ;
        return;
        if (((a) (obj)).d() == null) goto _L4; else goto _L3
_L3:
        d1 = (ar)((a) (obj)).d().get(l);
_L8:
        if (((a) (obj)).e() == null)
        {
            break MISSING_BLOCK_LABEL_728;
        }
        obj = (ar)((a) (obj)).e().get(l);
_L9:
        ar ar1 = (ar)imageviewer.m.i.get(l);
        if (d1 == null) goto _L2; else goto _L5
_L5:
        if (((ar) (d1)).c == null || obj == null) goto _L2; else goto _L6
_L6:
        if (((ar) (obj)).c == null || d.get(l) == null || ar1 == null) goto _L2; else goto _L7
_L7:
        ((com.cyberlink.youcammakeup.jniproxy.y)d.get(l)).a(((ar) (obj)).c.b());
        ((com.cyberlink.youcammakeup.jniproxy.y)d.get(l)).b(((ar) (obj)).c.c());
        ((com.cyberlink.youcammakeup.jniproxy.y)d.get(l)).a(((ar) (obj)).c.d());
        ((com.cyberlink.youcammakeup.jniproxy.y)d.get(l)).b(((ar) (obj)).c.e());
        ((com.cyberlink.youcammakeup.jniproxy.y)d.get(l)).a(((ar) (obj)).c.f());
        ((com.cyberlink.youcammakeup.jniproxy.y)d.get(l)).b(((ar) (obj)).c.g());
        ((com.cyberlink.youcammakeup.jniproxy.y)d.get(l)).a(((ar) (obj)).c.j());
        ((com.cyberlink.youcammakeup.jniproxy.y)d.get(l)).a(((ar) (obj)).c.h());
        ((com.cyberlink.youcammakeup.jniproxy.y)d.get(l)).b(((ar) (obj)).c.i());
        ((com.cyberlink.youcammakeup.jniproxy.y)d.get(l)).a(((ar) (obj)).c.l());
        ((com.cyberlink.youcammakeup.jniproxy.y)d.get(l)).a(((ar) (obj)).c.k());
        ((com.cyberlink.youcammakeup.jniproxy.y)d.get(l)).a(((ar) (obj)).c.m());
        ar1.c.a(((ar) (d1)).c.b());
        ar1.c.b(((ar) (d1)).c.c());
        ar1.c.a(((ar) (d1)).c.d());
        ar1.c.b(((ar) (d1)).c.e());
        ar1.c.a(((ar) (d1)).c.f());
        ar1.c.b(((ar) (d1)).c.g());
        ar1.c.a(((ar) (d1)).c.j());
        ar1.c.a(((ar) (d1)).c.h());
        ar1.c.b(((ar) (d1)).c.i());
        ar1.c.a(((ar) (d1)).c.l());
        ar1.c.a(((ar) (d1)).c.k());
        ar1.c.a(((ar) (d1)).c.m());
        imageviewer.l();
        imageviewer.o();
        imageviewer.n();
        BeautifierEditCenter.a().a(((ar) (obj)).b, ((ar) (obj)).c, false, new BeautifierTaskInfo(false));
        i();
_L2:
        obj1;
        JVM INSTR monitorexit ;
        return;
_L4:
        d1 = null;
          goto _L8
        obj = null;
          goto _L9
    }

    public void a(boolean flag)
    {
        f = flag;
    }

    public void b()
    {
        Object obj1 = g;
        obj1;
        JVM INSTR monitorenter ;
        if (d != null)
        {
            d.clear();
            d = null;
        }
        if (e != null)
        {
            e.clear();
            e = null;
        }
        d = new ArrayList();
        e = new ArrayList();
        if (((ImageViewer)c).m == null) goto _L2; else goto _L1
_L1:
        Object obj = ((ImageViewer)c).m.i;
_L11:
        if (obj == null) goto _L4; else goto _L3
_L3:
        if (((List) (obj)).size() <= 0) goto _L4; else goto _L5
_L5:
        int l = 0;
_L9:
        if (l >= ((List) (obj)).size()) goto _L4; else goto _L6
_L6:
        ar ar1;
        ar1 = (ar)((List) (obj)).get(l);
        d.add(new com.cyberlink.youcammakeup.jniproxy.y());
        e.add(new com.cyberlink.youcammakeup.jniproxy.y());
        if (ar1 == null) goto _L8; else goto _L7
_L7:
        if (ar1.c != null)
        {
            ((com.cyberlink.youcammakeup.jniproxy.y)d.get(l)).a(ar1.c.b());
            ((com.cyberlink.youcammakeup.jniproxy.y)d.get(l)).b(ar1.c.c());
            ((com.cyberlink.youcammakeup.jniproxy.y)d.get(l)).a(ar1.c.d());
            ((com.cyberlink.youcammakeup.jniproxy.y)d.get(l)).b(ar1.c.e());
            ((com.cyberlink.youcammakeup.jniproxy.y)d.get(l)).a(ar1.c.f());
            ((com.cyberlink.youcammakeup.jniproxy.y)d.get(l)).b(ar1.c.g());
            ((com.cyberlink.youcammakeup.jniproxy.y)d.get(l)).a(ar1.c.j());
            ((com.cyberlink.youcammakeup.jniproxy.y)d.get(l)).a(ar1.c.h());
            ((com.cyberlink.youcammakeup.jniproxy.y)d.get(l)).b(ar1.c.i());
            ((com.cyberlink.youcammakeup.jniproxy.y)d.get(l)).a(ar1.c.l());
            ((com.cyberlink.youcammakeup.jniproxy.y)d.get(l)).a(ar1.c.k());
            ((com.cyberlink.youcammakeup.jniproxy.y)d.get(l)).a(ar1.c.m());
            ((com.cyberlink.youcammakeup.jniproxy.y)e.get(l)).a(ar1.c.b());
            ((com.cyberlink.youcammakeup.jniproxy.y)e.get(l)).b(ar1.c.c());
            ((com.cyberlink.youcammakeup.jniproxy.y)e.get(l)).a(ar1.c.d());
            ((com.cyberlink.youcammakeup.jniproxy.y)e.get(l)).b(ar1.c.e());
            ((com.cyberlink.youcammakeup.jniproxy.y)e.get(l)).a(ar1.c.f());
            ((com.cyberlink.youcammakeup.jniproxy.y)e.get(l)).b(ar1.c.g());
            ((com.cyberlink.youcammakeup.jniproxy.y)e.get(l)).a(ar1.c.j());
            ((com.cyberlink.youcammakeup.jniproxy.y)e.get(l)).a(ar1.c.h());
            ((com.cyberlink.youcammakeup.jniproxy.y)e.get(l)).b(ar1.c.i());
            ((com.cyberlink.youcammakeup.jniproxy.y)e.get(l)).a(ar1.c.l());
            ((com.cyberlink.youcammakeup.jniproxy.y)e.get(l)).a(ar1.c.k());
            ((com.cyberlink.youcammakeup.jniproxy.y)e.get(l)).a(ar1.c.m());
        }
          goto _L8
_L4:
        obj1;
        JVM INSTR monitorexit ;
        StatusManager.j().a(this);
        StatusManager.j().a(this);
        return;
        obj;
        obj1;
        JVM INSTR monitorexit ;
        throw obj;
_L8:
        l++;
        if (true) goto _L9; else goto _L2
_L2:
        obj = null;
        if (true) goto _L11; else goto _L10
_L10:
    }

    public void c()
    {
        StatusManager.j().b(this);
        StatusManager.j().b(this);
        synchronized (g)
        {
            if (d != null)
            {
                d.clear();
                d = null;
            }
            if (e != null)
            {
                e.clear();
                e = null;
            }
        }
        h.set(false);
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void d()
    {
        if (c == null || ((ImageViewer)c).m == null || ((ImageViewer)c).m.i == null)
        {
            return;
        }
        Object obj = g;
        obj;
        JVM INSTR monitorenter ;
        int l;
        if (d == null || d.size() <= 0)
        {
            break MISSING_BLOCK_LABEL_194;
        }
        l = ((ImageViewer)c).m.j;
        if (l != -1)
        {
            break MISSING_BLOCK_LABEL_90;
        }
        obj;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        if (((ImageViewer)c).m.i != null && ((ImageViewer)c).m.i.get(l) != null && d.get(l) != null)
        {
            BeautifierEditCenter.a().a(((ar)((ImageViewer)c).m.i.get(l)).b, (com.cyberlink.youcammakeup.jniproxy.y)d.get(l), false, new BeautifierTaskInfo(false));
        }
        obj;
        JVM INSTR monitorexit ;
    }

    public void e()
    {
        while (d == null || c == null || !(c instanceof ImageViewer) || StatusManager.j().s() != BeautyMode.r) 
        {
            return;
        }
        Object obj2 = g;
        obj2;
        JVM INSTR monitorenter ;
        Object obj;
        if (((ImageViewer)c).m == null)
        {
            break MISSING_BLOCK_LABEL_104;
        }
        obj = ((ImageViewer)c).m.i;
_L1:
        int l = ((ImageViewer)c).m.j;
        if (l != -1)
        {
            break MISSING_BLOCK_LABEL_109;
        }
        obj2;
        JVM INSTR monitorexit ;
        return;
        obj;
        obj2;
        JVM INSTR monitorexit ;
        throw obj;
        obj = null;
          goto _L1
        Object obj1 = StatusManager.j().e();
        if (obj1 != null)
        {
            break MISSING_BLOCK_LABEL_124;
        }
        obj2;
        JVM INSTR monitorexit ;
        return;
        z z1;
        EditViewActivity editviewactivity;
        z1 = MotionControlHelper.e().c(((String) (obj1)));
        obj1 = MotionControlHelper.e().d(((String) (obj1)));
        editviewactivity = Globals.d().t();
        if (StatusManager.j().r() == MakeupMode.a)
        {
            break MISSING_BLOCK_LABEL_173;
        }
        if (editviewactivity == null)
        {
            break MISSING_BLOCK_LABEL_202;
        }
        if (!editviewactivity.p())
        {
            break MISSING_BLOCK_LABEL_202;
        }
        obj1 = StatusManager.j().d();
        z1 = MotionControlHelper.e().f(((i) (obj1)).v());
        obj1 = MotionControlHelper.e().g(((i) (obj1)).v());
        if (obj == null || z1 == null || obj1 == null)
        {
            break MISSING_BLOCK_LABEL_286;
        }
        obj = (ar)((List) (obj)).get(l);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_286;
        }
        ((ar) (obj)).c.a(z1);
        ((ar) (obj)).c.b(((z) (obj1)));
        ((ImageViewer)c).k();
        ((ImageViewer)c).l();
        ((ImageViewer)c).o();
        ((ImageViewer)c).n();
        obj2;
        JVM INSTR monitorexit ;
    }

    public void f()
    {
        while (d == null || c == null || !(c instanceof ImageViewer) || StatusManager.j().r() != MakeupMode.a) 
        {
            return;
        }
        Object obj2 = g;
        obj2;
        JVM INSTR monitorenter ;
        Object obj;
        if (((ImageViewer)c).m == null)
        {
            break MISSING_BLOCK_LABEL_100;
        }
        obj = ((ImageViewer)c).m.i;
_L1:
        int l = ((ImageViewer)c).m.j;
        if (l != -1)
        {
            break MISSING_BLOCK_LABEL_105;
        }
        obj2;
        JVM INSTR monitorexit ;
        return;
        obj;
        obj2;
        JVM INSTR monitorexit ;
        throw obj;
        obj = null;
          goto _L1
        Object obj1 = StatusManager.j().d();
        if (obj1 == null) goto _L3; else goto _L2
_L2:
        obj1 = ((i) (obj1)).v();
_L5:
        if (obj1 != null)
        {
            break MISSING_BLOCK_LABEL_128;
        }
        obj2;
        JVM INSTR monitorexit ;
        return;
        z z1;
        z1 = MotionControlHelper.e().f(((String) (obj1)));
        obj1 = MotionControlHelper.e().g(((String) (obj1)));
        if (obj == null || z1 == null || obj1 == null)
        {
            break MISSING_BLOCK_LABEL_231;
        }
        obj = (ar)((List) (obj)).get(l);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_231;
        }
        ((ar) (obj)).c.a(z1);
        ((ar) (obj)).c.b(((z) (obj1)));
        ((ImageViewer)c).k();
        ((ImageViewer)c).l();
        ((ImageViewer)c).o();
        ((ImageViewer)c).n();
        obj2;
        JVM INSTR monitorexit ;
        return;
_L3:
        obj1 = null;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public List g()
    {
label0:
        {
            synchronized (g)
            {
                if (c != null && ((ImageViewer)c).m != null && ((ImageViewer)c).m.i != null)
                {
                    break label0;
                }
            }
            return null;
        }
        ArrayList arraylist;
        arraylist = new ArrayList();
        if (e == null)
        {
            Globals.d().e("DianaHelper, getFaceDataListForKernel, mModifyFaceInfoList is null !!!");
        }
          goto _L1
_L6:
        int l;
        if (l >= e.size()) goto _L3; else goto _L2
_L2:
        if (e.get(l) != null && ((ImageViewer)c).m.i.get(l) != null)
        {
            ar ar1 = (ar)((ImageViewer)c).m.i.get(l);
            ar ar2 = new ar(ar1.a);
            ar2.b = ar1.b;
            ar2.c = new com.cyberlink.youcammakeup.jniproxy.y();
            ar2.c.a(((com.cyberlink.youcammakeup.jniproxy.y)e.get(l)).l());
            ar2.c.a(((com.cyberlink.youcammakeup.jniproxy.y)e.get(l)).j());
            ar2.c.a(((com.cyberlink.youcammakeup.jniproxy.y)e.get(l)).k());
            ar2.c.a(((com.cyberlink.youcammakeup.jniproxy.y)e.get(l)).b());
            ar2.c.b(((com.cyberlink.youcammakeup.jniproxy.y)e.get(l)).c());
            ar2.c.a(((com.cyberlink.youcammakeup.jniproxy.y)e.get(l)).d());
            ar2.c.b(((com.cyberlink.youcammakeup.jniproxy.y)e.get(l)).e());
            ar2.c.a(((com.cyberlink.youcammakeup.jniproxy.y)e.get(l)).f());
            ar2.c.b(((com.cyberlink.youcammakeup.jniproxy.y)e.get(l)).g());
            ar2.c.b(((com.cyberlink.youcammakeup.jniproxy.y)e.get(l)).i());
            ar2.c.a(((com.cyberlink.youcammakeup.jniproxy.y)e.get(l)).h());
            ar2.c.a(((com.cyberlink.youcammakeup.jniproxy.y)e.get(l)).m());
            ar2.d = ar1.d;
            ar2.e = ar1.e;
            ar2.f = ar1.f;
            ar2.g = ar1.g;
            arraylist.add(ar2);
        }
          goto _L4
_L3:
        obj;
        JVM INSTR monitorexit ;
        return arraylist;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
_L1:
        l = 0;
        continue; /* Loop/switch isn't completed */
_L4:
        l++;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void h()
    {
        Object obj = g;
        obj;
        JVM INSTR monitorenter ;
        if (e == null || d == null) goto _L2; else goto _L1
_L1:
        int i1;
        if (d != null)
        {
            d.clear();
            d = null;
        }
        d = new ArrayList();
        i1 = ((ImageViewer)c).m.j;
        int l = 0;
_L16:
        if (l >= e.size()) goto _L2; else goto _L3
_L3:
        if (e.get(l) == null) goto _L5; else goto _L4
_L4:
        Object obj1;
        Object obj2;
        obj1 = new com.cyberlink.youcammakeup.jniproxy.y();
        ((com.cyberlink.youcammakeup.jniproxy.y) (obj1)).a(((com.cyberlink.youcammakeup.jniproxy.y)e.get(l)).l());
        ((com.cyberlink.youcammakeup.jniproxy.y) (obj1)).a(((com.cyberlink.youcammakeup.jniproxy.y)e.get(l)).j());
        ((com.cyberlink.youcammakeup.jniproxy.y) (obj1)).a(((com.cyberlink.youcammakeup.jniproxy.y)e.get(l)).k());
        obj2 = Globals.d().t();
        if (StatusManager.j().s() != BeautyMode.r) goto _L7; else goto _L6
_L6:
        if (obj2 == null) goto _L9; else goto _L8
_L8:
        if (((EditViewActivity) (obj2)).p()) goto _L7; else goto _L9
_L9:
        Object obj3 = StatusManager.j().e();
        if (obj3 == null)
        {
            break MISSING_BLOCK_LABEL_296;
        }
        obj2 = MotionControlHelper.e().c(((String) (obj3)));
        obj3 = MotionControlHelper.e().d(((String) (obj3)));
        if (obj2 == null || obj3 == null)
        {
            break MISSING_BLOCK_LABEL_296;
        }
        ((com.cyberlink.youcammakeup.jniproxy.y) (obj1)).a(((z) (obj2)));
        ((com.cyberlink.youcammakeup.jniproxy.y) (obj1)).b(((z) (obj3)));
        if (i1 != l)
        {
            break MISSING_BLOCK_LABEL_296;
        }
        ((com.cyberlink.youcammakeup.jniproxy.y)e.get(l)).a(((z) (obj2)));
        ((com.cyberlink.youcammakeup.jniproxy.y)e.get(l)).b(((z) (obj3)));
_L11:
        ((com.cyberlink.youcammakeup.jniproxy.y) (obj1)).a(((com.cyberlink.youcammakeup.jniproxy.y)e.get(l)).d());
        ((com.cyberlink.youcammakeup.jniproxy.y) (obj1)).b(((com.cyberlink.youcammakeup.jniproxy.y)e.get(l)).e());
        ((com.cyberlink.youcammakeup.jniproxy.y) (obj1)).a(((com.cyberlink.youcammakeup.jniproxy.y)e.get(l)).f());
        ((com.cyberlink.youcammakeup.jniproxy.y) (obj1)).b(((com.cyberlink.youcammakeup.jniproxy.y)e.get(l)).g());
        ((com.cyberlink.youcammakeup.jniproxy.y) (obj1)).b(((com.cyberlink.youcammakeup.jniproxy.y)e.get(l)).i());
        ((com.cyberlink.youcammakeup.jniproxy.y) (obj1)).a(((com.cyberlink.youcammakeup.jniproxy.y)e.get(l)).h());
        ((com.cyberlink.youcammakeup.jniproxy.y) (obj1)).a(((com.cyberlink.youcammakeup.jniproxy.y)e.get(l)).m());
        d.add(obj1);
          goto _L5
_L7:
        if (StatusManager.j().r() == MakeupMode.a)
        {
            break MISSING_BLOCK_LABEL_480;
        }
        if (obj2 == null)
        {
            break MISSING_BLOCK_LABEL_595;
        }
        if (!((EditViewActivity) (obj2)).p())
        {
            break MISSING_BLOCK_LABEL_595;
        }
        obj2 = StatusManager.j().d();
        if (obj2 == null) goto _L11; else goto _L10
_L10:
        if (((i) (obj2)).v() == null) goto _L11; else goto _L12
_L12:
        obj3 = ((i) (obj2)).v();
        obj2 = MotionControlHelper.e().f(((String) (obj3)));
        obj3 = MotionControlHelper.e().g(((String) (obj3)));
        if (obj2 == null || obj3 == null) goto _L11; else goto _L13
_L13:
        ((com.cyberlink.youcammakeup.jniproxy.y) (obj1)).a(((z) (obj2)));
        ((com.cyberlink.youcammakeup.jniproxy.y) (obj1)).b(((z) (obj3)));
        if (i1 != l) goto _L11; else goto _L14
_L14:
        ((com.cyberlink.youcammakeup.jniproxy.y)e.get(l)).a(((z) (obj2)));
        ((com.cyberlink.youcammakeup.jniproxy.y)e.get(l)).b(((z) (obj3)));
          goto _L11
        obj1;
        obj;
        JVM INSTR monitorexit ;
        throw obj1;
        ((com.cyberlink.youcammakeup.jniproxy.y) (obj1)).a(((com.cyberlink.youcammakeup.jniproxy.y)e.get(l)).b());
        ((com.cyberlink.youcammakeup.jniproxy.y) (obj1)).b(((com.cyberlink.youcammakeup.jniproxy.y)e.get(l)).c());
          goto _L11
_L2:
        obj;
        JVM INSTR monitorexit ;
        return;
_L5:
        l++;
        if (true) goto _L16; else goto _L15
_L15:
    }

    public void i()
    {
        Object obj = g;
        obj;
        JVM INSTR monitorenter ;
        Globals.d().e("DianaHelper, resetKernelFaceData start 1");
        if (e == null || d == null) goto _L2; else goto _L1
_L1:
        Globals.d().e("DianaHelper, resetKernelFaceData start 2");
        if (e != null)
        {
            e.clear();
            e = null;
        }
        e = new ArrayList();
        int l = 0;
_L6:
        if (l >= d.size()) goto _L2; else goto _L3
_L3:
        if (d.get(l) != null)
        {
            com.cyberlink.youcammakeup.jniproxy.y y1 = new com.cyberlink.youcammakeup.jniproxy.y();
            y1.a(((com.cyberlink.youcammakeup.jniproxy.y)d.get(l)).l());
            y1.a(((com.cyberlink.youcammakeup.jniproxy.y)d.get(l)).j());
            y1.a(((com.cyberlink.youcammakeup.jniproxy.y)d.get(l)).k());
            y1.a(((com.cyberlink.youcammakeup.jniproxy.y)d.get(l)).b());
            y1.b(((com.cyberlink.youcammakeup.jniproxy.y)d.get(l)).c());
            y1.a(((com.cyberlink.youcammakeup.jniproxy.y)d.get(l)).d());
            y1.b(((com.cyberlink.youcammakeup.jniproxy.y)d.get(l)).e());
            y1.a(((com.cyberlink.youcammakeup.jniproxy.y)d.get(l)).f());
            y1.b(((com.cyberlink.youcammakeup.jniproxy.y)d.get(l)).g());
            y1.b(((com.cyberlink.youcammakeup.jniproxy.y)d.get(l)).i());
            y1.a(((com.cyberlink.youcammakeup.jniproxy.y)d.get(l)).h());
            y1.a(((com.cyberlink.youcammakeup.jniproxy.y)d.get(l)).m());
            e.add(y1);
        }
          goto _L4
_L2:
        Globals.d().e("DianaHelper, resetKernelFaceData end");
        obj;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
_L4:
        l++;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public boolean j()
    {
        return f;
    }

}

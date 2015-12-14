// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl;

import android.animation.Animator;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuffXfermode;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.activity.EditViewActivity;
import com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.PanZoomViewer;
import com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.a;
import com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.c;
import com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.q;
import com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.t;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.kernelctrl.status.m;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.ImageBufferWrapper;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.ViewEngine;
import com.cyberlink.youcammakeup.utility.ch;
import com.cyberlink.youcammakeup.utility.o;
import com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper;
import com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.HairDyeToolPanelMenu;
import java.util.LinkedList;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl:
//            s, o, q, r, 
//            VenusHelper, p, a, l, 
//            m, n, ah

public class HairDyeBrushHandler
    implements s, m
{

    private static final int A = Color.rgb(255, 255, 255);
    public static int a[] = {
        13, 17, 33, 57, 79
    };
    private static final int z = Color.rgb(196, 0, 46);
    private View B;
    private android.widget.RelativeLayout.LayoutParams C;
    private ViewGroup D;
    private PorterDuffXfermode E;
    private android.animation.Animator.AnimatorListener F = new ch() {

        final HairDyeBrushHandler a;

        public void onAnimationEnd(Animator animator)
        {
            if (HairDyeBrushHandler.k(a) == null)
            {
                return;
            } else
            {
                HairDyeBrushHandler.k(a).setVisibility(8);
                return;
            }
        }

            
            {
                a = HairDyeBrushHandler.this;
                super();
            }
    };
    private final float b;
    private float c;
    private int d;
    private int e;
    private boolean f;
    private boolean g;
    private View h;
    private BrushMode i;
    private int j;
    private int k;
    private Boolean l;
    private Bitmap m;
    private Canvas n;
    private Paint o;
    private LinkedList p;
    private com.cyberlink.youcammakeup.kernelctrl.q q;
    private p r;
    private Bitmap s;
    private boolean t;
    private l u;
    private com.cyberlink.youcammakeup.kernelctrl.m v;
    private n w;
    private r x;
    private HairDyeToolPanelMenu y;

    private HairDyeBrushHandler()
    {
        b = (float)Globals.d().getResources().getDisplayMetrics().widthPixels / 1080F;
        d = 0;
        e = 0;
        f = false;
        g = true;
        h = null;
        i = com.cyberlink.youcammakeup.kernelctrl.BrushMode.a;
        j = 25;
        k = a[2];
        l = Boolean.valueOf(false);
        p = null;
        q = null;
        r = null;
        s = null;
        t = false;
        x = null;
        E = new PorterDuffXfermode(android.graphics.PorterDuff.Mode.DARKEN);
        o = new Paint();
        o.setFilterBitmap(true);
        o.setStrokeWidth(1.0F);
        o.setAntiAlias(true);
    }


    public static HairDyeBrushHandler a()
    {
        return com.cyberlink.youcammakeup.kernelctrl.o.a();
    }

    static p a(HairDyeBrushHandler hairdyebrushhandler, p p1)
    {
        hairdyebrushhandler.r = p1;
        return p1;
    }

    private c a(float f1, float f2)
    {
        return ((a)h).a(f1, f2, false);
    }

    static com.cyberlink.youcammakeup.kernelctrl.q a(HairDyeBrushHandler hairdyebrushhandler, com.cyberlink.youcammakeup.kernelctrl.q q1)
    {
        hairdyebrushhandler.q = q1;
        return q1;
    }

    static r a(HairDyeBrushHandler hairdyebrushhandler)
    {
        return hairdyebrushhandler.x;
    }

    static Boolean a(HairDyeBrushHandler hairdyebrushhandler, Boolean boolean1)
    {
        hairdyebrushhandler.l = boolean1;
        return boolean1;
    }

    static LinkedList a(HairDyeBrushHandler hairdyebrushhandler, LinkedList linkedlist)
    {
        hairdyebrushhandler.p = linkedlist;
        return linkedlist;
    }

    static void a(HairDyeBrushHandler hairdyebrushhandler, float f1, float f2)
    {
        hairdyebrushhandler.b(f1, f2);
    }

    private void a(com.cyberlink.youcammakeup.kernelctrl.q q1, com.cyberlink.youcammakeup.kernelctrl.q q2)
    {
        if (q2 == null || n == null) goto _L2; else goto _L1
_L1:
        float f1;
        float f2;
        float f3;
        float f4;
        int i1;
        if (q1 == null)
        {
            f1 = q2.a;
            f2 = q2.b;
        } else
        {
            f1 = q1.a;
            f2 = q1.b;
        }
        q1 = q2.c;
        f3 = q2.a;
        f4 = q2.b;
        i1 = q2.d;
        o.setStrokeWidth(i1 * 2);
        if (q1 != com.cyberlink.youcammakeup.kernelctrl.BrushMode.a) goto _L4; else goto _L3
_L3:
        o.setColor(z);
        o.setXfermode(E);
_L6:
        if (f1 != f3 || f2 != f4)
        {
            break; /* Loop/switch isn't completed */
        }
        n.drawCircle(f1, f2, i1, o);
_L2:
        return;
_L4:
        if (q1 == BrushMode.b)
        {
            o.setColor(A);
            o.setXfermode(E);
        }
        if (true) goto _L6; else goto _L5
_L5:
        n.drawLine(f1, f2, f3, f4, o);
        n.drawCircle(f1, f2, i1, o);
        n.drawCircle(f3, f4, i1, o);
        return;
    }

    private void a(Long long1, ImageBufferWrapper imagebufferwrapper)
    {
        if (n != null && m != null)
        {
            synchronized (m)
            {
                n.drawColor(0, android.graphics.PorterDuff.Mode.CLEAR);
            }
        }
        if (x != null)
        {
            if (x.a != null)
            {
                x.a.m();
                x.a = null;
            }
            x = null;
        }
        x = new r(this, long1.longValue(), imagebufferwrapper);
        return;
        long1;
        bitmap;
        JVM INSTR monitorexit ;
        throw long1;
    }

    private void a(LinkedList linkedlist)
    {
        if (linkedlist != null && linkedlist.getFirst() != null)
        {
            Globals.d().i().b(Globals.d().t());
            linkedlist = (com.cyberlink.youcammakeup.kernelctrl.q)linkedlist.getFirst();
            VenusHelper venushelper = com.cyberlink.youcammakeup.kernelctrl.VenusHelper.a();
            boolean flag;
            if (((com.cyberlink.youcammakeup.kernelctrl.q) (linkedlist)).c == com.cyberlink.youcammakeup.kernelctrl.BrushMode.a)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            venushelper.a(flag, ((com.cyberlink.youcammakeup.kernelctrl.q) (linkedlist)).d);
            MotionControlHelper.e().a(null, false);
        }
    }

    static View b(HairDyeBrushHandler hairdyebrushhandler)
    {
        return hairdyebrushhandler.h;
    }

    static c b(HairDyeBrushHandler hairdyebrushhandler, float f1, float f2)
    {
        return hairdyebrushhandler.a(f1, f2);
    }

    private void b(float f1, float f2)
    {
        com.cyberlink.youcammakeup.kernelctrl.q q1;
        q1 = new com.cyberlink.youcammakeup.kernelctrl.q(this);
        if (r == null)
        {
            r = new p(this);
        }
        if (p != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        r.a = f1;
        r.b = f2;
        c c1 = ((a)h).a(f1, f2, false);
        q1.a = c1.a * (float)d;
        q1.b = c1.b * (float)e;
        if (q != null && q1.a == q.a && q1.b == q.b) goto _L1; else goto _L3
_L3:
        q1.c = i;
        f1 = j;
        q1.d = Math.round((c * f1) / ((PanZoomViewer)h).m.q.d);
        p.add(q1);
        if (m != null)
        {
            synchronized (m)
            {
                a(q, q1);
            }
            c();
        }
        if (q == null)
        {
            q = new com.cyberlink.youcammakeup.kernelctrl.q(this);
        }
        q.a = q1.a;
        q.b = q1.b;
        q.c = q1.c;
        q.d = q1.d;
        return;
        exception;
        bitmap;
        JVM INSTR monitorexit ;
        throw exception;
    }

    static void b(HairDyeBrushHandler hairdyebrushhandler, LinkedList linkedlist)
    {
        hairdyebrushhandler.a(linkedlist);
    }

    static HairDyeToolPanelMenu c(HairDyeBrushHandler hairdyebrushhandler)
    {
        return hairdyebrushhandler.y;
    }

    static Bitmap d(HairDyeBrushHandler hairdyebrushhandler)
    {
        return hairdyebrushhandler.m;
    }

    static com.cyberlink.youcammakeup.kernelctrl.q e(HairDyeBrushHandler hairdyebrushhandler)
    {
        return hairdyebrushhandler.q;
    }

    static float f(HairDyeBrushHandler hairdyebrushhandler)
    {
        return hairdyebrushhandler.c;
    }

    static BrushMode g(HairDyeBrushHandler hairdyebrushhandler)
    {
        return hairdyebrushhandler.i;
    }

    static void h(HairDyeBrushHandler hairdyebrushhandler)
    {
        hairdyebrushhandler.o();
    }

    static Boolean i(HairDyeBrushHandler hairdyebrushhandler)
    {
        return hairdyebrushhandler.l;
    }

    private void i()
    {
        g = true;
        t = false;
        l = Boolean.valueOf(false);
    }

    static LinkedList j(HairDyeBrushHandler hairdyebrushhandler)
    {
        return hairdyebrushhandler.p;
    }

    private void j()
    {
        p = null;
        q = null;
        m = null;
        if (d > 0 && e > 0)
        {
            if (n != null)
            {
                n.drawColor(0, android.graphics.PorterDuff.Mode.CLEAR);
                n = null;
            }
            m = Bitmap.createBitmap(d, e, android.graphics.Bitmap.Config.ARGB_4444);
            m.eraseColor(0);
            n = new Canvas(m);
            f = true;
            l();
        }
    }

    static View k(HairDyeBrushHandler hairdyebrushhandler)
    {
        return hairdyebrushhandler.B;
    }

    private void k()
    {
        if (d > 0 && e > 0)
        {
            if (m == null)
            {
                j();
            } else
            {
                m = null;
                m = Bitmap.createBitmap(d, e, android.graphics.Bitmap.Config.ARGB_4444);
            }
            n = null;
            n = new Canvas(m);
        }
    }

    private void l()
    {
        a(Long.valueOf(StatusManager.j().l()), ((ImageBufferWrapper) (null)));
    }

    private void m()
    {
        if (h != null && (h instanceof PanZoomViewer))
        {
            ((PanZoomViewer)h).a(com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ImageLoader.BufferName.c);
        }
    }

    private void n()
    {
        if (h != null && (h instanceof PanZoomViewer) && r != null && s != null)
        {
            ((PanZoomViewer)h).a(com.cyberlink.youcammakeup.kernelctrl.birdview.BirdView.BirdViewMode.b, (int)r.a, (int)r.b, B, C.width, C.height);
        }
    }

    private void o()
    {
        if (h != null && (h instanceof PanZoomViewer))
        {
            ((PanZoomViewer)h).t();
        }
    }

    private void p()
    {
        if (Globals.d().t() == null)
        {
            return;
        }
        if (B == null)
        {
            D = (ViewGroup)Globals.d().t().findViewById(0x7f0c00bf);
            C = new android.widget.RelativeLayout.LayoutParams(-2, -2);
            B = View.inflate(Globals.d().getApplicationContext(), 0x7f030124, null);
            D.addView(B);
        }
        B.setRotation(0.0F);
        B.animate().cancel();
        B.setAlpha(1.0F);
        C.width = j * 2;
        C.height = C.width;
        B.setX((D.getWidth() - C.width) / 2);
        B.setY((D.getHeight() - C.height) / 2);
        B.setLayoutParams(C);
        B.setVisibility(0);
        B.animate().alpha(0.0F).setDuration(200L).setStartDelay(700L).setListener(F);
    }

    public void a(int i1, int j1)
    {
        if (i1 > 4 && j1 > 4)
        {
            c = 0.5F;
        } else
        {
            c = 1.0F;
        }
        d = (int)Math.floor((float)i1 * c);
        e = (int)Math.floor((float)j1 * c);
        if (f)
        {
            k();
        }
    }

    public void a(MotionEvent motionevent, Boolean boolean1)
    {
    }

    public void a(View view)
    {
        h = view;
    }

    public void a(BrushMode brushmode)
    {
        i = brushmode;
    }

    public void a(com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ImageLoader.BufferName buffername, Long long1)
    {
        if (buffername == com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ImageLoader.BufferName.c && f)
        {
            g = true;
            if (r != null)
            {
                n();
            } else
            {
                o();
            }
            if (t)
            {
                m();
                g = false;
                t = false;
            }
        }
    }

    public void a(HairDyeToolPanelMenu hairdyetoolpanelmenu)
    {
        y = hairdyetoolpanelmenu;
    }

    public void a(Boolean boolean1)
    {
    }

    public void a(Integer integer, boolean flag)
    {
        k = integer.intValue();
        j = Math.round((float)k * b);
        if (flag)
        {
            p();
        }
    }

    public void b()
    {
        if (h != null)
        {
            i();
            StatusManager.j().a(this);
            i = com.cyberlink.youcammakeup.kernelctrl.BrushMode.a;
            j();
            if (Globals.d().t() != null)
            {
                j = Math.round((float)k * b);
            }
            s = Globals.d().Q();
        }
        long l1 = StatusManager.j().l();
        ImageBufferWrapper imagebufferwrapper = ViewEngine.a().a(l1, 1.0D, null);
        if (l1 != com.cyberlink.youcammakeup.kernelctrl.a.a().f() && imagebufferwrapper != null)
        {
            com.cyberlink.youcammakeup.kernelctrl.a.a().b();
            com.cyberlink.youcammakeup.kernelctrl.a.a().a(l1, imagebufferwrapper);
        }
    }

    public void c()
    {
        if (h != null)
        {
            t = true;
            if (g)
            {
                m();
                g = false;
                t = false;
            }
        }
    }

    public void d()
    {
        u = new l(this);
        v = new com.cyberlink.youcammakeup.kernelctrl.m(this);
        w = new n(this);
        com.cyberlink.youcammakeup.kernelctrl.ah.a().a(u);
        com.cyberlink.youcammakeup.kernelctrl.ah.a().a(v);
        com.cyberlink.youcammakeup.kernelctrl.ah.a().a(w);
    }

    public void e()
    {
        com.cyberlink.youcammakeup.kernelctrl.ah.a().b(u);
        com.cyberlink.youcammakeup.kernelctrl.ah.a().b(v);
        com.cyberlink.youcammakeup.kernelctrl.ah.a().b(w);
        u = null;
        v = null;
        w = null;
    }

    public Bitmap f()
    {
        return m;
    }

    public float g()
    {
        return c;
    }

    public Boolean h()
    {
        return Boolean.valueOf(f);
    }


    private class BrushMode extends Enum
    {

        public static final BrushMode a;
        public static final BrushMode b;
        private static final BrushMode c[];

        public static BrushMode valueOf(String s1)
        {
            return (BrushMode)Enum.valueOf(com/cyberlink/youcammakeup/kernelctrl/HairDyeBrushHandler$BrushMode, s1);
        }

        public static BrushMode[] values()
        {
            return (BrushMode[])c.clone();
        }

        static 
        {
            a = new BrushMode("ADD_BRUSH_STATE", 0);
            b = new BrushMode("DEL_BRUSH_STATE", 1);
            c = (new BrushMode[] {
                a, b
            });
        }

        private BrushMode(String s1, int i1)
        {
            super(s1, i1);
        }
    }

}

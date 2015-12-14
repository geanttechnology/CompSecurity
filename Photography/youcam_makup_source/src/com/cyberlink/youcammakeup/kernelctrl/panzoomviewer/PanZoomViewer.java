// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.panzoomviewer;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.activity.EditViewActivity;
import com.cyberlink.youcammakeup.database.g;
import com.cyberlink.youcammakeup.flurry.RateOfFeaturePointAdjustment;
import com.cyberlink.youcammakeup.jniproxy.UIImageOrientation;
import com.cyberlink.youcammakeup.jniproxy.af;
import com.cyberlink.youcammakeup.jniproxy.ag;
import com.cyberlink.youcammakeup.jniproxy.ah;
import com.cyberlink.youcammakeup.jniproxy.y;
import com.cyberlink.youcammakeup.kernelctrl.HairDyeBrushHandler;
import com.cyberlink.youcammakeup.kernelctrl.ad;
import com.cyberlink.youcammakeup.kernelctrl.ar;
import com.cyberlink.youcammakeup.kernelctrl.birdview.BirdView;
import com.cyberlink.youcammakeup.kernelctrl.birdview.MovableBirdView;
import com.cyberlink.youcammakeup.kernelctrl.c.b;
import com.cyberlink.youcammakeup.kernelctrl.c.c;
import com.cyberlink.youcammakeup.kernelctrl.featurepoints.samplepanel.FeaturePointGuideView;
import com.cyberlink.youcammakeup.kernelctrl.s;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.utility.aa;
import com.cyberlink.youcammakeup.utility.o;
import com.cyberlink.youcammakeup.utility.r;
import com.pf.common.utility.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Timer;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.panzoomviewer:
//            ImageViewer, z, q, t, 
//            f, o, aj, ad, 
//            ImageLoader, i, ai, ah, 
//            ac, y, g, s, 
//            af, ae, ag, u, 
//            v, ab, m, n

public class PanZoomViewer extends ImageViewer
    implements b
{

    public static UUID L = UUID.randomUUID();
    private ScaleGestureDetector M;
    private ac N;
    private GestureDetector O;
    private com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.y P;
    private boolean Q;
    private String R;
    private ValueAnimator S;
    private boolean T;
    private HashMap U;
    private UUID V;
    private boolean W;
    private PointF aA;
    private PointF aB;
    private volatile ViewerMode aC;
    private int aD;
    private ViewerMode aE;
    private com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ad aF;
    private boolean aa;
    private boolean ab;
    private ValueAnimator ac;
    private boolean ad;
    private float ae;
    private ValueAnimator af;
    private boolean ag;
    private boolean ah;
    private boolean ai;
    private BirdView aj;
    private MovableBirdView ak;
    private FeaturePointGuideView al;
    private ImageView am;
    private int an;
    private StatusManager ao;
    private boolean ap;
    private long aq;
    private Boolean ar;
    private Boolean as;
    private ExecutorService at;
    private com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ag au;
    private z av;
    private ae aw;
    private ae ax;
    private int ay;
    private int az;

    public PanZoomViewer(Context context)
    {
        super(context);
        M = null;
        N = null;
        O = null;
        P = null;
        Q = true;
        R = "PanZoomViewer";
        S = null;
        T = false;
        U = null;
        V = null;
        W = true;
        aa = false;
        ab = true;
        ac = null;
        ad = false;
        ae = 0.0F;
        af = null;
        ag = false;
        ah = false;
        ai = true;
        aj = null;
        ak = null;
        am = null;
        an = 20;
        ao = StatusManager.j();
        ap = false;
        aq = 100L;
        ar = Boolean.valueOf(false);
        as = Boolean.valueOf(false);
        at = Executors.newFixedThreadPool(1);
        au = null;
        av = new z(this);
        aw = null;
        ax = null;
        ay = 20;
        az = -1;
        aA = null;
        aB = null;
        aC = ViewerMode.a;
        aD = 0;
        aE = null;
        aF = null;
        a("[PanZoomViewer]");
        if (!isInEditMode())
        {
            a(context);
        }
    }

    public PanZoomViewer(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        M = null;
        N = null;
        O = null;
        P = null;
        Q = true;
        R = "PanZoomViewer";
        S = null;
        T = false;
        U = null;
        V = null;
        W = true;
        aa = false;
        ab = true;
        ac = null;
        ad = false;
        ae = 0.0F;
        af = null;
        ag = false;
        ah = false;
        ai = true;
        aj = null;
        ak = null;
        am = null;
        an = 20;
        ao = StatusManager.j();
        ap = false;
        aq = 100L;
        ar = Boolean.valueOf(false);
        as = Boolean.valueOf(false);
        at = Executors.newFixedThreadPool(1);
        au = null;
        av = new z(this);
        aw = null;
        ax = null;
        ay = 20;
        az = -1;
        aA = null;
        aB = null;
        aC = ViewerMode.a;
        aD = 0;
        aE = null;
        aF = null;
        a("[PanZoomViewer]");
        if (!isInEditMode())
        {
            a(context);
        }
    }

    public PanZoomViewer(Context context, AttributeSet attributeset, int k)
    {
        super(context, attributeset, k);
        M = null;
        N = null;
        O = null;
        P = null;
        Q = true;
        R = "PanZoomViewer";
        S = null;
        T = false;
        U = null;
        V = null;
        W = true;
        aa = false;
        ab = true;
        ac = null;
        ad = false;
        ae = 0.0F;
        af = null;
        ag = false;
        ah = false;
        ai = true;
        aj = null;
        ak = null;
        am = null;
        an = 20;
        ao = StatusManager.j();
        ap = false;
        aq = 100L;
        ar = Boolean.valueOf(false);
        as = Boolean.valueOf(false);
        at = Executors.newFixedThreadPool(1);
        au = null;
        av = new z(this);
        aw = null;
        ax = null;
        ay = 20;
        az = -1;
        aA = null;
        aB = null;
        aC = ViewerMode.a;
        aD = 0;
        aE = null;
        aF = null;
        a("[PanZoomViewer]");
        if (!isInEditMode())
        {
            a(context);
        }
    }

    private void A()
    {
        ap = true;
        float f1 = a(m.q.e);
        float f2 = b(m.q.e);
        float f3 = getWidth() / 2;
        float f4 = getHeight() / 2;
        if (f1 != 0.0F || f2 != 0.0F)
        {
            T = true;
            ag = true;
            ValueAnimator valueanimator = ValueAnimator.ofFloat(new float[] {
                0.0F, 1.0F
            });
            valueanimator.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener(f1, f2, f3, f4) {

                final float a;
                final float b;
                final float c;
                final float d;
                final PanZoomViewer e;
                private float f;
                private float g;

                public void onAnimationUpdate(ValueAnimator valueanimator1)
                {
                    PanZoomViewer.a(e, ViewerMode.d);
                    float f7 = valueanimator1.getAnimatedFraction();
                    float f6 = a * f7;
                    f7 *= b;
                    valueanimator1 = new PointF(c, d);
                    PointF pointf = new PointF(f6 - f, f7 - g);
                    com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.PanZoomViewer.c(e, valueanimator1, pointf, 1.0F);
                    f = f6;
                    g = f7;
                }

            
            {
                e = PanZoomViewer.this;
                a = f1;
                b = f2;
                c = f3;
                d = f4;
                super();
            }
            });
            valueanimator.addListener(new android.animation.Animator.AnimatorListener(f3, f4) {

                boolean a;
                final float b;
                final float c;
                final PanZoomViewer d;

                public void onAnimationCancel(Animator animator)
                {
                    PanZoomViewer.a(d, ViewerMode.d);
                    float f6 = PanZoomViewer.a(d, d.m.q.e);
                    float f7 = com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.PanZoomViewer.b(d, d.m.q.e);
                    animator = new PointF(b, c);
                    PointF pointf = new PointF(f6, f7);
                    com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.PanZoomViewer.c(d, false);
                    com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.PanZoomViewer.c(d, animator, pointf, 1.0F);
                    PanZoomViewer.a(d, ViewerMode.a);
                    PanZoomViewer.a(d, "Bouncing cancel");
                    com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.PanZoomViewer.c(d, null);
                    com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.PanZoomViewer.b(d, false);
                    a = true;
                    PanZoomViewer.a(d, false);
                    PanZoomViewer.j(d);
                }

                public void onAnimationEnd(Animator animator)
                {
                    if (a)
                    {
                        return;
                    } else
                    {
                        float f6 = PanZoomViewer.a(d, d.m.q.e);
                        float f7 = com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.PanZoomViewer.b(d, d.m.q.e);
                        animator = new PointF(b, c);
                        PointF pointf = new PointF(f6, f7);
                        com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.PanZoomViewer.c(d, false);
                        com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.PanZoomViewer.c(d, animator, pointf, 1.0F);
                        PanZoomViewer.a(d, ViewerMode.a);
                        d.m.q.f = d.b(d.m);
                        animator = new f();
                        animator.a = true;
                        d.b(com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ImageLoader.BufferName.c, animator);
                        PanZoomViewer.a(d, false);
                        PanZoomViewer.a(d, "Bouncing end");
                        com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.PanZoomViewer.c(d, null);
                        com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.PanZoomViewer.b(d, false);
                        PanZoomViewer.j(d);
                        return;
                    }
                }

                public void onAnimationRepeat(Animator animator)
                {
                }

                public void onAnimationStart(Animator animator)
                {
                }

            
            {
                d = PanZoomViewer.this;
                b = f1;
                c = f2;
                super();
                a = false;
            }
            });
            a("Bouncing start");
            valueanimator.start();
            S = valueanimator;
            aC = ViewerMode.d;
            return;
        } else
        {
            m.q.f = b(m);
            f f5 = new f();
            f5.a = true;
            b(com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ImageLoader.BufferName.c, f5);
            ap = false;
            aC = ViewerMode.a;
            return;
        }
    }

    private void B()
    {
        if (S != null)
        {
            S.cancel();
        }
    }

    private void C()
    {
        int k = (int)(aA.x + aB.x);
        int l = (int)(aA.y + aB.y);
        float f1 = m.q.d;
        float af1[] = new float[9];
        m.q.e.getValues(af1);
        float f4 = af1[2] * f1;
        float f5 = af1[5] * f1;
        float f6 = (float)n / 2.0F;
        float f7 = (float)o / 2.0F;
        HashMap hashmap = new HashMap();
        Iterator iterator = m.k.entrySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            if (((com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.o)entry.getValue()).b)
            {
                ArrayList arraylist = new ArrayList();
                PointF pointf = ((com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.o)entry.getValue()).a;
                float f2 = pointf.x;
                float f3 = pointf.y;
                if (Math.abs(f4) > f6)
                {
                    f2 = pointf.x + f4 + f6;
                }
                if (Math.abs(f5) > f7)
                {
                    f3 = pointf.y + f5 + f7;
                }
                arraylist.add(new PointF(f2, f3));
                if (entry.getKey() == com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.O)
                {
                    Object obj = (ar)m.i.get(m.j);
                    PointF pointf1 = new PointF(((ar) (obj)).c.k().b().b(), ((ar) (obj)).c.k().b().c());
                    PointF pointf3 = new PointF(((ar) (obj)).c.k().e().b(), ((ar) (obj)).c.k().e().c());
                    PointF pointf5 = new PointF(((ar) (obj)).c.k().c().b(), ((ar) (obj)).c.k().c().c());
                    obj = new PointF(((ar) (obj)).c.k().g().b(), ((ar) (obj)).c.k().g().c());
                    arraylist.add(pointf1);
                    arraylist.add(pointf3);
                    arraylist.add(pointf5);
                    arraylist.add(obj);
                }
                if (entry.getKey() == com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.k)
                {
                    Object obj1 = (ar)m.i.get(m.j);
                    PointF pointf2 = new PointF(((ar) (obj1)).c.j().b().b(), ((ar) (obj1)).c.j().b().c());
                    PointF pointf4 = new PointF(((ar) (obj1)).c.j().d().b(), ((ar) (obj1)).c.j().d().c());
                    PointF pointf6 = new PointF(((ar) (obj1)).c.j().c().b(), ((ar) (obj1)).c.j().c().c());
                    obj1 = new PointF(((ar) (obj1)).c.j().e().b(), ((ar) (obj1)).c.j().e().c());
                    arraylist.add(pointf2);
                    arraylist.add(pointf4);
                    arraylist.add(pointf6);
                    arraylist.add(obj1);
                }
                hashmap.put(entry.getKey(), arraylist);
            }
        } while (true);
        a(k, l, hashmap);
    }

    private float a(Matrix matrix)
    {
        a("[calculateBouncingTX]");
        float f1 = getWidth() / 2;
        float af1[] = new float[9];
        matrix.getValues(af1);
        float f2 = m.e;
        float f3 = af1[0];
        float f4 = af1[2];
        float f5 = af1[0] * f4;
        f4 = f5 - -f1;
        f1 -= f5 + f2 * f3;
        if (f4 < 0.0F && f1 > 0.0F)
        {
            if (f4 + f1 < 0.0F)
            {
                return f1;
            } else
            {
                return (f1 - f4) / 2.0F;
            }
        }
        if (f4 > 0.0F && f1 < 0.0F)
        {
            if (f4 + f1 < 0.0F)
            {
                return -f4;
            } else
            {
                return -(f4 - f1) / 2.0F;
            }
        }
        if (f4 > 0.0F && f1 > 0.0F)
        {
            return (f1 - f4) / 2.0F;
        } else
        {
            return 0.0F;
        }
    }

    static float a(PanZoomViewer panzoomviewer, Matrix matrix)
    {
        return panzoomviewer.a(matrix);
    }

    private long a(SwitchDirection switchdirection)
    {
        long l1 = -1L;
        a("getTargetImageID");
        long l;
        if (switchdirection == com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.SwitchDirection.c && u.a != -1L)
        {
            l = u.a;
        } else
        {
            l = l1;
            if (switchdirection == com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.SwitchDirection.b)
            {
                l = l1;
                if (t.a != -1L)
                {
                    return t.a;
                }
            }
        }
        return l;
    }

    static long a(PanZoomViewer panzoomviewer)
    {
        return panzoomviewer.aq;
    }

    static ValueAnimator a(PanZoomViewer panzoomviewer, ValueAnimator valueanimator)
    {
        panzoomviewer.af = valueanimator;
        return valueanimator;
    }

    private PointF a(PointF pointf)
    {
        if (pointf.equals(aj.a))
        {
            return new PointF((float)m.e / 2.0F, (float)m.f / 2.0F);
        }
        if (pointf.equals(com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.aj.b))
        {
            pointf = d(m);
            return new PointF(-((RectF) (pointf)).left / m.q.d, -((RectF) (pointf)).top / m.q.d);
        } else
        {
            return new PointF(pointf.x, pointf.y);
        }
    }

    static ViewerMode a(PanZoomViewer panzoomviewer, ViewerMode viewermode)
    {
        panzoomviewer.aC = viewermode;
        return viewermode;
    }

    static com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ad a(PanZoomViewer panzoomviewer, com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ad ad1)
    {
        panzoomviewer.aF = ad1;
        return ad1;
    }

    static Boolean a(PanZoomViewer panzoomviewer, Boolean boolean1)
    {
        panzoomviewer.ar = boolean1;
        return boolean1;
    }

    private void a(long l, SwitchDirection switchdirection)
    {
        T = true;
        ap = true;
        float f3 = m.q.c;
        float f4 = m.q.b;
        float f5 = m.q.d;
        float f6 = (float)m.e * f3;
        float af1[] = new float[9];
        m.q.e.getValues(af1);
        float f7 = af1[0];
        float f1 = af1[2] * f7;
        float f8 = m.e;
        float f2;
        Object obj;
        Object obj1;
        com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ad ad1;
        if (switchdirection == com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.SwitchDirection.b && t.q.e != null)
        {
            float af2[] = new float[9];
            t.q.e.getValues(af2);
            f7 = af2[0] * (float)t.e;
            f8 = ((float)n - f7) / 2.0F;
            float f9 = ((float)n - f6) / 2.0F + f8;
            float f11 = (f5 - f3) / (f4 - f3);
            f2 = -f7 / 2.0F;
            f1 = f1 - (f9 - (f9 - f8) * f11) - f7;
        } else
        if (u.q.e != null)
        {
            obj = new float[9];
            u.q.e.getValues(((float []) (obj)));
            f2 = obj[0] * (float)u.e;
            float f10 = ((float)n - f2) / 2.0F;
            float f12 = ((float)n - f6) / 2.0F + f10;
            float f13 = (f5 - f3) / (f4 - f3);
            f2 = -f2 / 2.0F;
            f1 = (f12 - (f12 - f10) * f13) + (f1 + f8 * f7);
        } else
        {
            f1 = 0.0F;
            f2 = 0.0F;
        }
        f7 = getWidth() / 2;
        f8 = getHeight() / 2;
        ai = true;
        ad1 = new com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ad(this);
        ad1.a = new q(this, m);
        if (switchdirection == com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.SwitchDirection.b)
        {
            obj = new q(this, t);
        } else
        {
            obj = new q(this, u);
        }
        ad1.b = ((q) (obj));
        obj = (i)this.l.b.get(com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ImageLoader.BufferName.c);
        if (!((i) (obj)).c)
        {
            obj = (i)this.l.b.get(ImageLoader.BufferName.a);
        }
        if (switchdirection == com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.SwitchDirection.b)
        {
            obj1 = ImageLoader.BufferName.d;
        } else
        {
            obj1 = ImageLoader.BufferName.e;
        }
        obj1 = (i)this.l.b.get(obj1);
        if (((i) (obj)).c)
        {
            ad1.c = ((i) (obj)).a;
            obj.a = null;
        }
        if (((i) (obj1)).c)
        {
            ad1.d = ((i) (obj1)).a;
            obj1.a = null;
        } else
        {
            ai = false;
        }
        ad1.e = switchdirection;
        obj = ValueAnimator.ofFloat(new float[] {
            0.0F, 1.0F
        });
        ((ValueAnimator) (obj)).setDuration(100L);
        ((ValueAnimator) (obj)).setInterpolator(new LinearInterpolator());
        ((ValueAnimator) (obj)).addUpdateListener(new ai(this, f2 - f1, ad1));
        obj1 = new com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ah(this);
        ((com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ah) (obj1)).a(f5, f3, f4, f6);
        ((com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ah) (obj1)).a(f7, f8);
        ((com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ah) (obj1)).a(l, switchdirection, f2);
        ((com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ah) (obj1)).a(ad1);
        ((ValueAnimator) (obj)).addListener(((android.animation.Animator.AnimatorListener) (obj1)));
        a("SwitchAnimator start");
        ((ValueAnimator) (obj)).start();
        ac = ((ValueAnimator) (obj));
        ag = true;
        b(l, switchdirection);
    }

    private void a(Context context)
    {
        a("[initPanZoomViewer]");
        N = new ac(this);
        M = new ScaleGestureDetector(context, N);
        P = new com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.y(this);
        O = new GestureDetector(context, P);
        U = new HashMap();
    }

    private void a(Canvas canvas, ImageLoader.BufferName buffername, q q1, ViewerMode viewermode)
    {
        a("[renderCacheCanvas]");
        if (!this.l.b.containsKey(buffername))
        {
            a((new StringBuilder()).append("offScreen Canvas didn't contain buffer with bufferName: ").append(buffername.toString()).append(" cancel render task").toString());
            m.e("RENDER", "renderCacheCanvas: !this.mLoader.mOffScreenCanvases.containsKey(bufferName)");
        } else
        {
            i k = (i)this.l.b.get(buffername);
            if (k == null || k.a == null)
            {
                a("offCanvas bitmap is null, cancel this drawing task");
                m.e("RENDER", "renderCacheCanvas: offCanvas == null || offCanvas.mBmp == null");
                return;
            }
            i i1 = (i)this.l.b.get(ImageLoader.BufferName.d);
            i l = (i)this.l.b.get(ImageLoader.BufferName.e);
            RectF rectf = new RectF();
            RectF rectf1 = new RectF();
            Object obj = new RectF();
            if (m.q.e == null)
            {
                a("current transform matrix is null, return!!");
                m.e("RENDER", "renderCacheCanvas: this.mInfo.curView.transform == null");
                return;
            }
            int j1 = getWidth();
            int k1 = getHeight();
            float af3[] = new float[9];
            q1.q.e.getValues(af3);
            float f3 = af3[0];
            float f4 = af3[2] * f3;
            float f5 = af3[5] * f3;
            float f6 = (float)m.e * f3;
            float f7 = m.f;
            float f8 = q1.q.c;
            float f9 = q1.q.b;
            float f10 = q1.q.d;
            float f11 = (float)q1.e * f9;
            float f12 = (float)q1.e * f8;
            float f1;
            float f2;
            if (i1 != null && i1.a != null && t.q.e != null)
            {
                float af2[] = new float[9];
                t.q.e.getValues(af2);
                float f13 = af2[0];
                float f14 = af2[5] * f13;
                float f15 = (float)t.e * f13;
                float f16 = t.f;
                f2 = ((float)n - f15) / 2.0F;
                f1 = f2;
                if (f2 < (float)an)
                {
                    f1 = an;
                }
                f2 = ((float)n - f12) / 2.0F + f1;
                float af1[];
                if ((float)n > f11)
                {
                    f1 = (f11 - f12) / 2.0F;
                } else
                {
                    f1 = f2 - f1;
                }
                rectf1.right = f4 - (f2 - f1 * ((f10 - f8) / (f9 - f8)));
                rectf1.left = rectf1.right - f15;
                rectf1.top = f14;
                rectf1.bottom = f14 + f13 * f16;
            }
            if (l != null && l.a != null && u.q.e != null)
            {
                af1 = new float[9];
                u.q.e.getValues(af1);
                f13 = af1[0];
                f14 = af1[5] * f13;
                f15 = (float)u.e * f13;
                f16 = u.f;
                f2 = ((float)n - f15) / 2.0F;
                f1 = f2;
                if (f2 < (float)an)
                {
                    f1 = an;
                }
                f2 = ((float)n - f12) / 2.0F + f1;
                if ((float)n > f11)
                {
                    f1 = (f11 - f12) / 2.0F;
                } else
                {
                    f1 = f2 - f1;
                }
                obj.left = (f2 - f1 * ((f10 - f8) / (f9 - f8))) + (f4 + f6);
                obj.top = f14;
                obj.right = ((RectF) (obj)).left + f15;
                obj.bottom = f14 + f13 * f16;
            }
            rectf.left = f4;
            rectf.top = f5;
            rectf.right = f6 + f4;
            rectf.bottom = f3 * f7 + f5;
            if (com.cyberlink.youcammakeup.utility.aa.b(r))
            {
                if (q.getXfermode() != a)
                {
                    q.setXfermode(a);
                }
                obj = new Canvas();
                ((Canvas) (obj)).setBitmap(r);
                ((Canvas) (obj)).drawColor(0xff000000, android.graphics.PorterDuff.Mode.SRC_IN);
                ((Canvas) (obj)).translate((float)j1 / 2.0F, (float)k1 / 2.0F);
                ((Canvas) (obj)).drawBitmap(k.a, null, rectf, q);
                ((Canvas) (obj)).setBitmap(null);
                canvas.drawBitmap(r, 0.0F, 0.0F, null);
            }
            canvas.translate((float)j1 / 2.0F, (float)k1 / 2.0F);
            while (false) 
            {
                if (!com.cyberlink.youcammakeup.utility.aa.b(r) && k.a != null && !k.a.isRecycled())
                {
                    canvas.drawBitmap(k.a, null, rectf, q);
                }
                if (viewermode != com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ViewerMode.b)
                {
                    if (viewermode == ViewerMode.f);
                }
                if (B.booleanValue())
                {
                    b(canvas, buffername, q1);
                }
                if (E)
                {
                    q1.q.g = rectf;
                    a(canvas, q1);
                }
                if (F)
                {
                    q1.q.g = rectf;
                    b(canvas, q1);
                    return;
                }
            }
        }
    }

    private void a(Canvas canvas, com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ad ad1)
    {
        Bitmap bitmap;
        Bitmap bitmap1;
        Object obj;
        RectF rectf;
        RectF rectf1;
        q q1;
        SwitchDirection switchdirection;
        if (ad1 == null)
        {
            a("Can't render switch cache since cache is null");
            return;
        }
        q1 = ad1.a;
        obj = ad1.b;
        bitmap = ad1.c;
        bitmap1 = ad1.d;
        switchdirection = ad1.e;
        rectf = new RectF();
        rectf1 = new RectF();
        ad1 = ((com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ad) (p));
        ad1;
        JVM INSTR monitorenter ;
        float af2[];
        int k;
        int l;
        k = getWidth();
        l = getHeight();
        af2 = new float[9];
        q1.q.e.getValues(af2);
        float f1;
        float f2;
        float f3;
        f1 = af2[0];
        f2 = af2[2] * f1;
        f3 = af2[5] * f1;
        float f4;
        float f5;
        float f8;
        float f9;
        float f10;
        float f12;
        float af1[];
        f4 = (float)q1.e * f1;
        f5 = q1.f;
        f8 = q1.q.c;
        f9 = q1.q.b;
        f10 = q1.q.d;
        f12 = q1.e;
        af1 = new float[9];
        ((q) (obj)).q.e.getValues(af1);
        float f6;
        float f11;
        f11 = af1[0];
        f6 = af1[5] * f11;
        float f7;
        f7 = (float)((q) (obj)).e * f11;
        f11 = (float)((q) (obj)).f * f11;
        float f13 = ((float)n - f7) / 2.0F;
        f12 = ((float)n - f12 * f8) / 2.0F + f13;
        f8 = f12 - ((f10 - f8) / (f9 - f8)) * (f12 - f13);
        if (switchdirection != com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.SwitchDirection.b) goto _L2; else goto _L1
_L1:
        rectf1.right = f2 - f8;
        rectf1.left = rectf1.right - f7;
        rectf1.top = f6;
        rectf1.bottom = f6 + f11;
_L5:
        canvas.translate((float)k / 2.0F, (float)l / 2.0F);
        rectf.left = f2;
        rectf.top = f3;
        rectf.right = f4 + f2;
        rectf.bottom = f1 * f5 + f3;
        obj = new Paint();
        ((Paint) (obj)).setColor(0xff000000);
        if (bitmap == null) goto _L4; else goto _L3
_L3:
        canvas.drawBitmap(bitmap, null, rectf, null);
_L6:
        if (bitmap1 == null)
        {
            break MISSING_BLOCK_LABEL_493;
        }
        canvas.drawBitmap(bitmap1, null, rectf1, null);
_L7:
        ad1;
        JVM INSTR monitorexit ;
        return;
        canvas;
        ad1;
        JVM INSTR monitorexit ;
        throw canvas;
_L2:
        rectf1.left = f8 + (f2 + f4);
        rectf1.top = f6;
        rectf1.right = rectf1.left + f7;
        rectf1.bottom = f6 + f11;
          goto _L5
_L4:
        canvas.drawRect(rectf, ((Paint) (obj)));
          goto _L6
        canvas.drawRect(rectf1, ((Paint) (obj)));
          goto _L7
    }

    private void a(Matrix matrix, PointF pointf)
    {
        float af1[] = new float[9];
        matrix.getValues(af1);
        float f1 = af1[0];
        matrix.preScale(1.0F / (f1 * f1), 1.0F / (f1 * f1));
        matrix.preTranslate(pointf.x, pointf.y);
        matrix.preScale(f1 * f1, f1 * f1);
    }

    private void a(PointF pointf, float f1, float f2)
    {
        DisplayMetrics displaymetrics = getResources().getDisplayMetrics();
        float f3 = f1 / displaymetrics.density;
        float f4 = f2 / displaymetrics.density;
        if (Math.abs(f3) >= 500F || Math.abs(f4) >= 500F)
        {
            aC = ViewerMode.a;
            if (!T)
            {
                ap = true;
                pointf = b(pointf, f3, f4);
                if (pointf != SwitchDirection.a)
                {
                    long l1 = a(((SwitchDirection) (pointf)));
                    if (pointf != SwitchDirection.a && l1 != -1L)
                    {
                        a(l1, ((SwitchDirection) (pointf)));
                        return;
                    } else
                    {
                        A();
                        return;
                    }
                }
                int k = (int)(f1 / Math.abs(f1));
                int l = (int)(f2 / Math.abs(f2));
                long l2;
                long l3;
                long l4;
                if (Math.abs(f1) >= 4000F)
                {
                    f1 = k * 4000;
                }
                if (Math.abs(f2) >= 4000F)
                {
                    f2 = l * 4000;
                }
                f3 = d(f1);
                f4 = d(f2);
                l3 = c(f3, f1);
                l4 = c(f4, f2);
                if (l3 > l4)
                {
                    l2 = l3;
                } else
                {
                    l2 = l4;
                }
                aC = ViewerMode.e;
                pointf = ValueAnimator.ofFloat(new float[] {
                    0.0F, 1.0F
                });
                pointf.setDuration(l2);
                pointf.setInterpolator(new LinearInterpolator());
                pointf.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener(f1, f3, f2, f4, l3, l4) {

                    final float a;
                    final float b;
                    final float c;
                    final float d;
                    final long e;
                    final long f;
                    final PanZoomViewer g;
                    private float h;
                    private float i;

                    public void onAnimationUpdate(ValueAnimator valueanimator)
                    {
                        float f6 = 0.0F;
                        long l5 = valueanimator.getCurrentPlayTime();
                        float f5 = a / 1000F;
                        float f7 = l5;
                        f7 = (b * (float)l5 * (float)l5) / 2.0F + f5 * f7;
                        f5 = c / 1000F;
                        float f8 = l5;
                        f8 = (d * (float)l5 * (float)l5) / 2.0F + f5 * f8;
                        PanZoomViewer.a(g, ViewerMode.e);
                        valueanimator = new PointF((float)g.n / 2.0F, (float)g.o / 2.0F);
                        PointF pointf1 = new PointF(f7 - h, f8 - i);
                        if (l5 < e)
                        {
                            f5 = pointf1.x;
                        } else
                        {
                            f5 = 0.0F;
                        }
                        pointf1.x = f5;
                        f5 = f6;
                        if (l5 < f)
                        {
                            f5 = pointf1.y;
                        }
                        pointf1.y = f5;
                        com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.PanZoomViewer.c(g, valueanimator, pointf1, 1.0F);
                        h = f7;
                        i = f8;
                    }

            
            {
                g = PanZoomViewer.this;
                a = f1;
                b = f2;
                c = f3;
                d = f4;
                e = l;
                f = l1;
                super();
                h = 0.0F;
                i = 0.0F;
            }
                });
                pointf.addListener(new android.animation.Animator.AnimatorListener() {

                    final PanZoomViewer a;

                    public void onAnimationCancel(Animator animator)
                    {
                        PanZoomViewer.a(a, ViewerMode.a);
                        PanZoomViewer.a(a, null);
                        PanZoomViewer.a(a, "Fling cancel");
                        PanZoomViewer.a(a, false);
                    }

                    public void onAnimationEnd(Animator animator)
                    {
                        PanZoomViewer.a(a, ViewerMode.a);
                        com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.PanZoomViewer.c(a, false);
                        PanZoomViewer.i(a);
                        PanZoomViewer.a(a, null);
                        PanZoomViewer.a(a, "Fling end");
                    }

                    public void onAnimationRepeat(Animator animator)
                    {
                    }

                    public void onAnimationStart(Animator animator)
                    {
                    }

            
            {
                a = PanZoomViewer.this;
                super();
            }
                });
                a("Fling start");
                pointf.start();
                af = pointf;
                ag = true;
                return;
            }
        }
    }

    static void a(PanZoomViewer panzoomviewer, PointF pointf, float f1, float f2)
    {
        panzoomviewer.a(pointf, f1, f2);
    }

    static void a(PanZoomViewer panzoomviewer, PointF pointf, PointF pointf1, float f1)
    {
        panzoomviewer.c(pointf, pointf1, f1);
    }

    static void a(PanZoomViewer panzoomviewer, ImageLoader.BufferName buffername, q q1, ViewerMode viewermode)
    {
        panzoomviewer.b(buffername, q1, viewermode);
    }

    static void a(PanZoomViewer panzoomviewer, com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ad ad1, PointF pointf)
    {
        panzoomviewer.a(ad1, pointf);
    }

    static void a(PanZoomViewer panzoomviewer, String s1)
    {
        panzoomviewer.a(s1);
    }

    private void a(com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ad ad1, PointF pointf)
    {
        float f1 = ad1.a.q.d;
        Matrix matrix = ad1.a.q.e;
        pointf = new PointF(pointf.x, pointf.y);
        matrix.preScale(1.0F / (f1 * f1), 1.0F / (f1 * f1));
        matrix.preTranslate(pointf.x, pointf.y);
        matrix.preScale(f1 * f1, f1 * f1);
        setSwitchImgTask(ad1);
    }

    private void a(q q1, ViewerMode viewermode)
    {
        ImageLoader.BufferName buffername = com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ImageLoader.BufferName.b;
        i k = (i)this.l.b.get(buffername);
        i l = (i)this.l.b.get(com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ImageLoader.BufferName.c);
        if (k == null)
        {
            return;
        }
        if ((viewermode == ViewerMode.h || viewermode == com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ViewerMode.g) && l.c)
        {
            buffername = com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ImageLoader.BufferName.c;
        } else
        if (!k.c)
        {
            if (l.c && l.d)
            {
                buffername = com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ImageLoader.BufferName.c;
            } else
            {
                buffername = ImageLoader.BufferName.a;
            }
        }
        if (aa || ag)
        {
            b(buffername, new q(this, q1), viewermode);
            return;
        } else
        {
            a(buffername, new q(this, q1), viewermode);
            return;
        }
    }

    private void a(String s1)
    {
        if (!Q);
    }

    static boolean a(PanZoomViewer panzoomviewer, boolean flag)
    {
        panzoomviewer.ap = flag;
        return flag;
    }

    private float b(float f1)
    {
        float f2;
        if (f1 == -2F)
        {
            f2 = m.q.c;
        } else
        {
            f2 = f1;
            if (f1 == -1F)
            {
                return m.q.d;
            }
        }
        return f2;
    }

    private float b(Matrix matrix)
    {
        float f1 = getHeight() / 2;
        float af1[] = new float[9];
        matrix.getValues(af1);
        float f2 = m.f;
        float f3 = af1[0];
        float f4 = af1[5];
        float f5 = af1[0] * f4;
        f4 = f5 - -f1;
        f1 -= f5 + f2 * f3;
        if (f4 < 0.0F && f1 > 0.0F)
        {
            if (f4 + f1 < 0.0F)
            {
                return f1;
            } else
            {
                return (f1 - f4) / 2.0F;
            }
        }
        if (f4 > 0.0F && f1 < 0.0F)
        {
            if (f4 + f1 < 0.0F)
            {
                return -f4;
            } else
            {
                return -(f4 - f1) / 2.0F;
            }
        }
        if (f4 > 0.0F && f1 > 0.0F)
        {
            return (f1 - f4) / 2.0F;
        } else
        {
            return 0.0F;
        }
    }

    static float b(PanZoomViewer panzoomviewer, Matrix matrix)
    {
        return panzoomviewer.b(matrix);
    }

    static ValueAnimator b(PanZoomViewer panzoomviewer, ValueAnimator valueanimator)
    {
        panzoomviewer.ac = valueanimator;
        return valueanimator;
    }

    private SwitchDirection b(PointF pointf, float f1, float f2)
    {
        float f3;
        float f4;
        float f5;
        pointf = new Matrix(m.q.e);
        float af1[] = new float[9];
        pointf.getValues(af1);
        f3 = af1[2] * af1[0];
        f4 = (float)m.e * af1[0];
        f5 = (float)n / 8F;
        pointf = SwitchDirection.a;
        if (!m.q.a && f4 > (float)n) goto _L2; else goto _L1
_L1:
        if (f1 <= 2000F) goto _L4; else goto _L3
_L3:
        pointf = com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.SwitchDirection.b;
_L11:
        f2 = f4 / 2.0F + f3;
        if (f1 <= 0.0F || f2 <= f5) goto _L6; else goto _L5
_L5:
        Object obj = com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.SwitchDirection.b;
_L8:
        return ((SwitchDirection) (obj));
_L4:
        if (f1 < -2000F)
        {
            pointf = com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.SwitchDirection.c;
        }
        continue; /* Loop/switch isn't completed */
_L6:
        obj = pointf;
        if (f1 >= 0.0F) goto _L8; else goto _L7
_L7:
        obj = pointf;
        if (f2 >= -f5) goto _L8; else goto _L9
_L9:
        return com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.SwitchDirection.c;
_L2:
        float f6;
        float f7;
        float f8;
        boolean flag;
        boolean flag1;
        if (f1 < 4000F)
        {
            f2 = f1;
        } else
        {
            f2 = 4000F;
        }
        f6 = -f2 / 1000F / (float)300L;
        f2 /= 1000F;
        f7 = 300L;
        f8 = 300L;
        f2 = f3 + (f2 * f7 + ((float)300L * (f6 * f8)) / 2.0F);
        f6 = (float)(-n) / 2.0F + f5;
        f5 = (float)n / 2.0F - f5;
        if (Math.abs(ae - (float)(-n) / 2.0F) < 3F)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (Math.abs((f4 + ae) - (float)n / 2.0F) < 3F)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (flag && f1 > 0.0F && f2 > f6)
        {
            return com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.SwitchDirection.b;
        }
        if (f1 > 0.0F && f3 > f6)
        {
            return com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.SwitchDirection.b;
        }
        if (flag1 && f1 < 0.0F && f2 + f4 < f5)
        {
            return com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.SwitchDirection.c;
        }
        if (f1 < 0.0F && f3 + f4 < f5)
        {
            return com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.SwitchDirection.c;
        }
        return pointf;
        if (true) goto _L11; else goto _L10
_L10:
    }

    static ViewerMode b(PanZoomViewer panzoomviewer, ViewerMode viewermode)
    {
        panzoomviewer.aE = viewermode;
        return viewermode;
    }

    static HashMap b(PanZoomViewer panzoomviewer)
    {
        return panzoomviewer.U;
    }

    private void b(long l, SwitchDirection switchdirection)
    {
        boolean flag1 = false;
        boolean flag = false;
        this.l.d();
        StatusManager.j().a(l, L);
        ad ad1 = com.cyberlink.youcammakeup.kernelctrl.ad.a();
        if (switchdirection == com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.SwitchDirection.b)
        {
            if (t.a == -2L)
            {
                x();
                return;
            }
            ad1.e();
            l = ad1.c();
            u.a = m.a;
            switchdirection = new com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.g();
            switchdirection.a = m.h.c;
            switchdirection.b = m.h.d;
            switchdirection.c = m.d;
            a(u, switchdirection, m.g);
            u.g = m.g;
            m.a = t.a;
            switchdirection = new com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.g();
            switchdirection.a = t.h.c;
            switchdirection.b = t.h.d;
            switchdirection.c = t.d;
            a(m, switchdirection, t.g);
            m.g = t.g;
            t = new q(this);
            t.a = l;
            if (com.cyberlink.youcammakeup.database.g.a(l))
            {
                a(l, t);
            }
            this.l.b(ImageLoader.BufferName.e);
            switchdirection = new f();
            if (!ai)
            {
                flag = true;
            }
            switchdirection.a = flag;
            b(ImageLoader.BufferName.a, ((f) (switchdirection)));
            if (com.cyberlink.youcammakeup.database.g.a(t.a))
            {
                switchdirection = new f();
                b(ImageLoader.BufferName.d, ((f) (switchdirection)));
            }
            switchdirection = (i)this.l.b.get(ImageLoader.BufferName.e);
            if (com.cyberlink.youcammakeup.database.g.a(u.a) && !((i) (switchdirection)).c)
            {
                switchdirection = new f();
                b(ImageLoader.BufferName.e, ((f) (switchdirection)));
            }
            switchdirection = new f();
            b(com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ImageLoader.BufferName.b, ((f) (switchdirection)));
            switchdirection = new f();
            switchdirection.a = true;
            b(com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ImageLoader.BufferName.c, ((f) (switchdirection)));
            return;
        }
        if (u.a == -2L)
        {
            x();
            return;
        }
        ad1.d();
        l = ad1.b();
        t.a = m.a;
        switchdirection = new com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.g();
        switchdirection.a = m.h.c;
        switchdirection.b = m.h.d;
        switchdirection.c = m.d;
        a(t, switchdirection, m.g);
        t.g = m.g;
        m.a = u.a;
        switchdirection = new com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.g();
        switchdirection.a = u.h.c;
        switchdirection.b = u.h.d;
        switchdirection.c = u.d;
        a(m, switchdirection, u.g);
        m.g = u.g;
        u = new q(this);
        u.a = l;
        if (com.cyberlink.youcammakeup.database.g.a(l))
        {
            a(l, u);
        }
        this.l.b(ImageLoader.BufferName.d);
        switchdirection = new f();
        flag = flag1;
        if (!ai)
        {
            flag = true;
        }
        switchdirection.a = flag;
        b(ImageLoader.BufferName.a, ((f) (switchdirection)));
        switchdirection = (i)this.l.b.get(ImageLoader.BufferName.d);
        if (com.cyberlink.youcammakeup.database.g.a(t.a) && !((i) (switchdirection)).c)
        {
            switchdirection = new f();
            b(ImageLoader.BufferName.d, ((f) (switchdirection)));
        }
        if (com.cyberlink.youcammakeup.database.g.a(u.a))
        {
            switchdirection = new f();
            b(ImageLoader.BufferName.e, ((f) (switchdirection)));
        }
        switchdirection = new f();
        b(com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ImageLoader.BufferName.b, ((f) (switchdirection)));
        switchdirection = new f();
        switchdirection.a = true;
        b(com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ImageLoader.BufferName.c, ((f) (switchdirection)));
    }

    private void b(ImageLoader.BufferName buffername, q q1, ViewerMode viewermode)
    {
        if (ab)
        {
            ab = false;
            a(buffername, q1, viewermode);
        }
    }

    static void b(PanZoomViewer panzoomviewer, PointF pointf, PointF pointf1, float f1)
    {
        panzoomviewer.d(pointf, pointf1, f1);
    }

    static boolean b(PanZoomViewer panzoomviewer, boolean flag)
    {
        panzoomviewer.T = flag;
        return flag;
    }

    private float c(float f1)
    {
        return 0.0F;
    }

    private long c(float f1, float f2)
    {
        if (f1 == 0.0F)
        {
            return 0L;
        } else
        {
            return (long)(-f2 / 1000F / f1);
        }
    }

    static ValueAnimator c(PanZoomViewer panzoomviewer, ValueAnimator valueanimator)
    {
        panzoomviewer.S = valueanimator;
        return valueanimator;
    }

    private ViewerMode c(PointF pointf, float f1)
    {
        if (aw != null)
        {
            return com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ViewerMode.g;
        }
        if (E && aD <= 1)
        {
            return ViewerMode.h;
        } else
        {
            return com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ViewerMode.b;
        }
    }

    static UUID c(PanZoomViewer panzoomviewer)
    {
        return panzoomviewer.V;
    }

    private void c(PointF pointf, PointF pointf1, float f1)
    {
        a("[onGestureChange]");
        if (aC == ViewerMode.a)
        {
            aC = c(pointf1, f1);
        }
        while (!j() || T) 
        {
            return;
        }
        e(pointf, pointf1, f1);
    }

    static void c(PanZoomViewer panzoomviewer, PointF pointf, PointF pointf1, float f1)
    {
        panzoomviewer.e(pointf, pointf1, f1);
    }

    static boolean c(PanZoomViewer panzoomviewer, boolean flag)
    {
        panzoomviewer.ag = flag;
        return flag;
    }

    private float d(float f1)
    {
        if (f1 == 0.0F)
        {
            return 0.0F;
        }
        return f1 <= 0.0F ? 0.003F : -0.003F;
    }

    private com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints d(float f1, float f2)
    {
        float f3;
        float f4;
        float f5;
        float f11;
        float f12;
        float f13;
        float f14;
        float f15;
        com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints featurepoints;
        Iterator iterator;
        if (!B.booleanValue())
        {
            return null;
        }
        if (az < 0)
        {
            DisplayMetrics displaymetrics = getResources().getDisplayMetrics();
            az = (int)TypedValue.applyDimension(1, ay, displaymetrics);
        }
        f11 = m.q.d;
        float af1[] = new float[9];
        m.q.e.getValues(af1);
        f12 = af1[2];
        f13 = af1[5];
        f14 = (float)n / 2.0F;
        f15 = (float)o / 2.0F;
        featurepoints = null;
        f3 = -1F;
        f4 = -1F;
        f5 = -1F;
        iterator = m.k.entrySet().iterator();
_L2:
        if (!iterator.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
        PointF pointf = ((com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.o)entry.getValue()).a;
        if (!((com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.o)entry.getValue()).b)
        {
            continue; /* Loop/switch isn't completed */
        }
        float f9 = pointf.x + f12 * f11 + f14;
        float f16 = pointf.y + f13 * f11 + f15;
        float f6 = Math.abs(f9 - f1);
        float f17 = Math.abs(f16 - f2);
        if (f6 >= (float)az || f17 >= (float)az)
        {
            break MISSING_BLOCK_LABEL_397;
        }
        f6 = (float)(Math.pow(f6, 2D) + Math.pow(f17, 2D));
        if (f3 != -1F && f6 >= f3)
        {
            break MISSING_BLOCK_LABEL_397;
        }
        featurepoints = (com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints)entry.getKey();
        f4 = f16 - f2;
        f3 = f9 - f1;
        f5 = f6;
_L3:
        float f7 = f5;
        f5 = f4;
        f4 = f3;
        f3 = f7;
        if (true) goto _L2; else goto _L1
_L1:
        if (featurepoints != null)
        {
            aB = new PointF(f4, f5);
        }
        a((new StringBuilder()).append("check touch on feature points result: ").append(featurepoints).toString());
        return featurepoints;
        float f8 = f4;
        float f10 = f3;
        f4 = f5;
        f3 = f8;
        f5 = f10;
          goto _L3
    }

    static Boolean d(PanZoomViewer panzoomviewer)
    {
        return panzoomviewer.as;
    }

    private void d(PointF pointf, PointF pointf1, float f1)
    {
        a("[onGestureEnd]");
        pointf = aC;
        aC = ViewerMode.a;
        if (T)
        {
            return;
        }
        if (pointf == com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ViewerMode.b)
        {
            A();
            return;
        }
        if (pointf == com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ViewerMode.c)
        {
            pointf = y();
            long l = a(pointf);
            if (pointf != SwitchDirection.a && l != -1L)
            {
                a(l, pointf);
                return;
            } else
            {
                A();
                return;
            }
        }
        if (pointf == ViewerMode.h)
        {
            pointf = new q(this, m);
            a(com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ImageLoader.BufferName.c, pointf);
            return;
        } else
        {
            a("[onGestureEnd] Error: get unknown state");
            return;
        }
    }

    static boolean d(PanZoomViewer panzoomviewer, boolean flag)
    {
        panzoomviewer.ad = flag;
        return flag;
    }

    private void e(PointF pointf, PointF pointf1, float f1)
    {
        a("[renderCachedImage]");
        if (pointf1.x == 0.0F && pointf1.y == 0.0F && f1 == 1.0F)
        {
            a("[renderCachedImage] No scale and translate, return");
            return;
        }
        pointf = f(pointf, pointf1, f1);
        pointf1 = new float[9];
        ((com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.af) (pointf)).a.getValues(pointf1);
        f1 = pointf1[0];
        int k = (int)((float)m.e * f1);
        int l = (int)((float)m.f * f1);
        int i1 = (int)(pointf1[2] * f1);
        int j1 = (int)(pointf1[5] * f1);
        a((new StringBuilder()).append("transform result: left = ").append(i1).append(" top = ").append(j1).append(" width = ").append(k).append(" height= ").append(l).toString());
        m.q.e = new Matrix(((com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.af) (pointf)).a);
        m.q.d = f1;
        m.q.a = ((com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.af) (pointf)).b;
        m.q.f = b(m);
        o();
        if (aC == com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ViewerMode.g)
        {
            C();
        }
        a(m, aC);
    }

    private void e(q q1)
    {
        q1.q.e = new Matrix();
        q1.q.e.preTranslate(-q1.e / 2, -q1.f / 2);
        q1.q.e.preScale(q1.q.c, q1.q.c);
        float af1[] = new float[9];
        q1.q.e.getValues(af1);
        q1.q.d = af1[0];
    }

    static boolean e(PanZoomViewer panzoomviewer)
    {
        return panzoomviewer.ap;
    }

    static ViewerMode f(PanZoomViewer panzoomviewer)
    {
        return panzoomviewer.aC;
    }

    private com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.af f(PointF pointf, PointF pointf1, float f1)
    {
        a("[_calculateTransformResult]");
        if (pointf1.x == 0.0F && pointf1.y == 0.0F && f1 == 1.0F)
        {
            return new com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.af(this, m.q.e, m.q.a);
        }
        if (aC == ViewerMode.h)
        {
            return i(pointf, pointf1, f1);
        }
        if (aC == com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ViewerMode.b || aC == ViewerMode.e || aC == ViewerMode.f)
        {
            return g(pointf, pointf1, f1);
        }
        if (aC == com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ViewerMode.c)
        {
            return b(pointf, pointf1, f1);
        }
        if (aC == com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ViewerMode.g)
        {
            return h(pointf, pointf1, f1);
        } else
        {
            return a(pointf, pointf1, f1);
        }
    }

    private com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.af g(PointF pointf, PointF pointf1, float f1)
    {
        a("[_calculateTransformResultForImageViewingMode]");
        int l = m.e;
        int k = m.f;
        boolean flag1 = false;
        Object obj = new PointF(pointf1.x, pointf1.y);
        float af1[] = new float[9];
        m.q.e.getValues(af1);
        float f3 = af1[0];
        Matrix matrix = new Matrix(m.q.e);
        matrix.preScale(1.0F / (f3 * f3), 1.0F / (f3 * f3));
        matrix.preTranslate(-pointf.x, -pointf.y);
        matrix.preTranslate(pointf1.x, pointf1.y);
        matrix.preScale(f1, f1);
        matrix.preTranslate(pointf.x, pointf.y);
        matrix.preScale(f3 * f3, f3 * f3);
        float af2[] = new float[9];
        matrix.getValues(af2);
        float f4 = af2[0];
        int i1 = (int)((float)l * f4);
        int j1 = (int)((float)k * f4);
        int i2 = (int)(af2[2] * f4);
        int k1 = (int)(af2[5] * f4);
        int j2 = i2 + i1;
        int l1 = k1 + j1;
        float f2;
        int k2;
        boolean flag;
        if (aC != ViewerMode.f)
        {
            k = n / 8;
        } else
        {
            k = 0;
        }
        if (aC != ViewerMode.f)
        {
            l = o / 8;
        } else
        {
            l = 0;
        }
        if (f4 > m.q.b)
        {
            f2 = m.q.b / m.q.d;
            flag = flag1;
        } else
        if (f4 <= m.q.c)
        {
            f2 = m.q.c / m.q.d;
            flag = true;
        } else
        {
            flag = flag1;
            f2 = f1;
            if (f4 < 1.0F)
            {
                flag = flag1;
                f2 = f1;
                if (m.q.a)
                {
                    flag = true;
                    f2 = f1;
                }
            }
        }
        k2 = -n / 2 + k;
        k = n / 2 - k;
        if (i2 > k2 && pointf1.x > 0.0F)
        {
            pointf1.set((int)Math.floor(pointf1.x + (float)(k2 - i2)), pointf1.y);
            k = 1;
        } else
        if (j2 < k && pointf1.x < 0.0F)
        {
            f1 = pointf1.x;
            pointf1.set((int)Math.floor((float)(k - j2) + f1), pointf1.y);
            k = 1;
        } else
        {
            k = 0;
        }
        i2 = -o / 2 + l;
        l = o / 2 - l;
        if (k1 > i2 && pointf1.y > 0.0F)
        {
            f1 = pointf1.x;
            f4 = pointf1.y;
            pointf1.set(f1, (int)Math.floor((float)(i2 - k1) + f4));
            l = 1;
        } else
        if (l1 < l && pointf1.y < 0.0F)
        {
            f1 = pointf1.x;
            float f5 = pointf1.y;
            pointf1.set(f1, (int)Math.floor((float)(l - l1) + f5));
            l = 1;
        } else
        {
            l = 0;
        }
        if (Math.floor(i1) <= (double)n)
        {
            pointf1.set(0.0F, pointf1.y);
            pointf.set(0.0F, pointf.y);
        }
        if (Math.floor(j1) <= (double)o)
        {
            pointf1.set(pointf1.x, 0.0F);
            pointf.set(pointf.x, 0.0F);
        }
        if (af != null)
        {
            if (flag && k != 0 || !flag && k != 0 && l != 0)
            {
                pointf1.set(0.0F, 0.0F);
                af.cancel();
            } else
            if (k != 0 && ((PointF) (obj)).y == 0.0F)
            {
                pointf1.set(0.0F, 0.0F);
                af.cancel();
            } else
            if (l != 0 && ((PointF) (obj)).x == 0.0F)
            {
                pointf1.set(0.0F, 0.0F);
                af.cancel();
            }
        }
        obj = new Matrix(m.q.e);
        ((Matrix) (obj)).preScale(1.0F / (f3 * f3), 1.0F / (f3 * f3));
        ((Matrix) (obj)).preTranslate(-pointf.x, -pointf.y);
        ((Matrix) (obj)).preTranslate(pointf1.x, pointf1.y);
        ((Matrix) (obj)).preScale(f2, f2);
        ((Matrix) (obj)).preTranslate(pointf.x, pointf.y);
        ((Matrix) (obj)).preScale(f3 * f3, f3 * f3);
        return new com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.af(this, ((Matrix) (obj)), flag);
    }

    static boolean g(PanZoomViewer panzoomviewer)
    {
        return panzoomviewer.T;
    }

    private com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.af h(PointF pointf, PointF pointf1, float f1)
    {
        float f2;
        com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints featurepoints;
        featurepoints = aw.b;
        f2 = m.q.d;
        pointf = new PointF(pointf1.x, pointf1.y);
        f1 = 0.0F;
        if (m.d != UIImageOrientation.g && m.d != UIImageOrientation.f) goto _L2; else goto _L1
_L1:
        f1 = 1.570796F;
_L4:
        if (f1 != 0.0F)
        {
            float f5 = pointf1.x;
            float f3 = pointf1.y;
            pointf.x = (float)((double)f5 * Math.cos(-1F * f1)) - (float)((double)f3 * Math.sin(-1F * f1));
            f5 = (float)((double)f5 * Math.sin(-1F * f1));
            pointf.y = (float)((double)f3 * Math.cos(f1 * -1F)) + f5;
        }
        pointf1 = (PointF)m.l.get(featurepoints);
        f1 = pointf1.x;
        float f4 = pointf.x / f2;
        float f6 = pointf1.y;
        pointf1.set(f1 + f4, pointf.y / f2 + f6);
        m.e("calculateFeaturePoints: engine", ((PointF)m.l.get(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.l)).toString());
        boolean flag = m.q.a;
        return new com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.af(this, new Matrix(m.q.e), flag);
_L2:
        if (m.d == UIImageOrientation.d)
        {
            f1 = 3.141593F;
        } else
        if (m.d == UIImageOrientation.i || m.d == UIImageOrientation.h)
        {
            f1 = 4.712389F;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    static void h(PanZoomViewer panzoomviewer)
    {
        panzoomviewer.B();
    }

    private com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.af i(PointF pointf, PointF pointf1, float f1)
    {
        boolean flag = m.q.a;
        return new com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.af(this, new Matrix(m.q.e), flag);
    }

    static void i(PanZoomViewer panzoomviewer)
    {
        panzoomviewer.A();
    }

    static void j(PanZoomViewer panzoomviewer)
    {
        panzoomviewer.v();
    }

    private void setSwitchImgTask(com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ad ad1)
    {
        a(ad1);
    }

    private void setTouchStatus(boolean flag)
    {
        StatusManager.j().d(flag);
    }

    private void v()
    {
        if (U.containsKey(V))
        {
            O = null;
            P = null;
            M = null;
            N = null;
            ((s)U.get(V)).a(Boolean.valueOf(true));
        }
    }

    private void w()
    {
        if (U.containsKey(V))
        {
            ((s)U.get(V)).a(Boolean.valueOf(false));
            if (au != null)
            {
                au.cancel(true);
                au = null;
            }
        }
    }

    private void x()
    {
        EditViewActivity editviewactivity = Globals.d().t();
        String s1 = editviewactivity.getString(0x7f070066);
        o o1 = Globals.d().i();
        o1.a(new r(editviewactivity) {

            final EditViewActivity a;
            final PanZoomViewer b;

            public void a()
            {
                a.finish();
            }

            
            {
                b = PanZoomViewer.this;
                a = editviewactivity;
                super();
            }
        });
        o1.a(editviewactivity, null, s1, false);
    }

    private SwitchDirection y()
    {
        float f1;
        float f2;
        float f5;
        SwitchDirection switchdirection1;
        a("calculateSwitchDirection");
        float af1[] = new float[9];
        m.q.e.getValues(af1);
        f1 = (float)m.e * af1[0];
        f5 = af1[2] * af1[0];
        f2 = (float)n / 8F;
        switchdirection1 = SwitchDirection.a;
        if (f5 > (float)(-n) / 2.0F) goto _L2; else goto _L1
_L1:
        SwitchDirection switchdirection = switchdirection1;
        if (f5 + f1 >= (float)n / 2.0F) goto _L3; else goto _L2
_L2:
        float f3;
        float f4;
        f3 = f5 - ae;
        f4 = Math.abs(Math.abs(f5) - (float)n / 2.0F);
        f5 = Math.abs(Math.abs(f5 + f1) - (float)n / 2.0F);
        if (f3 <= f2) goto _L5; else goto _L4
_L4:
        if (ae < (float)(-n) / 2.0F) goto _L7; else goto _L6
_L6:
        switchdirection = com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.SwitchDirection.b;
_L3:
        return switchdirection;
_L7:
        switchdirection = switchdirection1;
        if (f4 > f2)
        {
            return com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.SwitchDirection.b;
        }
        continue; /* Loop/switch isn't completed */
_L5:
        switchdirection = switchdirection1;
        if (f3 < -f2)
        {
            if (f1 + ae <= (float)n / 2.0F)
            {
                return com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.SwitchDirection.c;
            }
            switchdirection = switchdirection1;
            if (f5 > f2)
            {
                return com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.SwitchDirection.c;
            }
        }
        if (true) goto _L3; else goto _L8
_L8:
    }

    private void z()
    {
        ab = true;
    }

    public com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.af a(PointF pointf, PointF pointf1, float f1)
    {
        a("[_calculateTransformResultForImageBouncingMode]");
        f1 = m.q.d;
        pointf = new Matrix(m.q.e);
        float af1[] = new float[9];
        pointf.getValues(af1);
        a((new StringBuilder()).append("before translate matrix left: ").append(af1[2] * af1[0]).append(" top: ").append(af1[5] * af1[0]).toString());
        pointf.preScale(1.0F / (f1 * f1), 1.0F / (f1 * f1));
        pointf.preTranslate(pointf1.x, pointf1.y);
        pointf.preScale(f1 * f1, f1 * f1);
        pointf.getValues(af1);
        pointf1 = (new StringBuilder()).append("after translate matrix left: ").append(af1[2] * af1[0]).append(" top: ");
        f1 = af1[5];
        a(pointf1.append(af1[0] * f1).toString());
        return new com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.af(this, pointf, m.q.a);
    }

    public void a()
    {
        if (U != null)
        {
            Iterator iterator = U.keySet().iterator();
            while (iterator.hasNext()) 
            {
                Object obj = (UUID)iterator.next();
                obj = (s)U.get(obj);
                if (obj != null)
                {
                    ((s) (obj)).a(null);
                }
            }
        }
    }

    protected void a(int k, int l)
    {
        float f2 = 0.0F;
        a("[SurfaceTextureChanged]");
        if (n == k && o == l)
        {
            f f6 = new f();
            f6.a = true;
            b(com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ImageLoader.BufferName.c, f6);
            return;
        }
        int i1 = n;
        int j1 = o;
        n = k;
        o = l;
        Object obj = a(m);
        m.q.c = ((u) (obj)).a;
        m.q.b = ((u) (obj)).b;
        if (aC == ViewerMode.d)
        {
            B();
        }
        Object obj1;
        if (k <= i1 && l <= j1)
        {
            if (m.q.a)
            {
                e(m);
                m.q.f = b(m);
            } else
            if (m.q.f != null)
            {
                m.q.f = b(m);
            }
        } else
        if (m.q.a)
        {
            e(m);
            m.q.f = b(m);
        } else
        {
            obj1 = new Matrix(m.q.e);
            float af1[] = new float[9];
            ((Matrix) (obj1)).getValues(af1);
            if (af1[0] <= m.q.c)
            {
                e(m);
                m.q.a = true;
                m.q.f = b(m);
            } else
            {
                float f4 = af1[0];
                float f1 = af1[2] * f4;
                float f3 = af1[5] * f4;
                float f5 = (float)m.e * f4;
                f4 = (float)m.f * f4;
                if (f5 <= (float)n)
                {
                    f1 = 0.0F - (f5 / 2.0F + f1);
                } else
                if (f1 > -((float)n / 2.0F))
                {
                    f1 = -((float)n / 2.0F) - f1;
                } else
                if (f1 + f5 < (float)n / 2.0F)
                {
                    f1 = (float)n / 2.0F - (f1 + f5);
                } else
                {
                    f1 = 0.0F;
                }
                if (f4 <= (float)o)
                {
                    f2 = 0.0F - (f4 / 2.0F + f3);
                } else
                if (f3 > -((float)o / 2.0F))
                {
                    f2 = (float)(-o) / 2.0F - f3;
                } else
                if (f3 + f4 < (float)o / 2.0F)
                {
                    f2 = (float)o / 2.0F - (f3 + f4);
                }
                m.q.e = new Matrix(((Matrix) (obj1)));
                obj1 = m.q.e;
                f1 /= af1[0] * af1[0];
                f3 = af1[0];
                ((Matrix) (obj1)).preTranslate(f1, f2 / (af1[0] * f3));
                af1 = new float[9];
                m.q.e.getValues(af1);
                m.q.d = af1[0];
                m.q.f = b(m);
            }
        }
        if (m.k != null)
        {
            o();
        }
        obj = a(t);
        t.q.c = ((u) (obj)).a;
        t.q.b = ((u) (obj)).b;
        e(t);
        obj = a(u);
        u.q.c = ((u) (obj)).a;
        u.q.b = ((u) (obj)).b;
        e(u);
        obj = (i)this.l.b.get(com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ImageLoader.BufferName.b);
        obj1 = new q(this, m);
        if (!((i) (obj)).c)
        {
            a(ImageLoader.BufferName.a, ((q) (obj1)));
        } else
        {
            a(com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ImageLoader.BufferName.b, ((q) (obj1)));
        }
        obj = new f();
        obj.a = true;
        b(com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ImageLoader.BufferName.c, ((f) (obj)));
    }

    public void a(int k, int l, Map map)
    {
        if (ak == null)
        {
            return;
        }
        synchronized (this.l.g)
        {
            i i1 = (i)this.l.b.get(com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ImageLoader.BufferName.c);
            ak.a(aA, k, l, n, o, i1, m.q.d, m.q.f, m.d, map);
        }
        return;
        map;
        obj;
        JVM INSTR monitorexit ;
        throw map;
    }

    public void a(HairDyeBrushHandler hairdyebrushhandler, com.cyberlink.youcammakeup.kernelctrl.ah ah1, n n)
    {
        super.a(hairdyebrushhandler, ah1, n);
        U.put(com.cyberlink.youcammakeup.kernelctrl.ah.a, ah1);
    }

    public void a(com.cyberlink.youcammakeup.kernelctrl.birdview.BirdView.BirdViewMode birdviewmode, int k, int l, View view, int i1, int j1)
    {
        if (aj == null)
        {
            return;
        }
        synchronized (this.l.g)
        {
            i k1 = (i)this.l.b.get(com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ImageLoader.BufferName.c);
            aj.a(birdviewmode, n, o, k, l, k1, m.q.d, m.q.f, view, i1, j1);
            aj.a(birdviewmode, n, o, k, l);
            invalidate();
        }
        return;
        birdviewmode;
        obj;
        JVM INSTR monitorexit ;
        throw birdviewmode;
    }

    public void a(ImageLoader.BufferName buffername)
    {
        f f1 = new f();
        if (buffername == com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ImageLoader.BufferName.c)
        {
            f1.a = true;
        } else
        {
            f1.a = false;
        }
        c(buffername, f1);
    }

    protected void a(ImageLoader.BufferName buffername, q q1, ViewerMode viewermode)
    {
        v v1 = com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.v.a();
        v1.put(1, buffername);
        v1.put(2, q1);
        v1.put(11, viewermode);
        if ((viewermode == com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ViewerMode.g || viewermode == ViewerMode.h) && buffername == com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ImageLoader.BufferName.c)
        {
            buffername = Message.obtain(G, 1, v1);
        } else
        {
            buffername = Message.obtain(G, 11, v1);
        }
        G.sendMessage(buffername);
    }

    protected void a(com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ad ad1)
    {
        v v1 = com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.v.a();
        v1.put(12, ad1);
        ad1 = Message.obtain(G, 12, v1);
        G.sendMessage(ad1);
    }

    public void a(aj aj1, android.animation.Animator.AnimatorListener animatorlistener)
    {
        boolean flag = false;
        Object obj = a(aj1.a());
        PointF pointf = a(aj1.b());
        float f3 = b(aj1.c());
        float f4 = b(aj1.d());
        c(aj1.e());
        c(aj1.f());
        obj = b(((PointF) (obj)), f3);
        Matrix matrix = b(pointf, f4);
        if (aj1.g())
        {
            a(matrix, new PointF(a(matrix), b(matrix)));
        }
        float af1[] = new float[9];
        matrix.getValues(af1);
        float f1 = af1[2];
        float f2 = af1[5];
        f3 = f4 / f3;
        if (aj1.i() >= 0.0F)
        {
            m.q.e = matrix;
            m.q.d = af1[0];
            aj1 = m.q;
            if (af1[0] <= m.q.c)
            {
                flag = true;
            }
            aj1.a = flag;
            m.q.f = b(m);
            return;
        } else
        {
            ValueAnimator valueanimator = ValueAnimator.ofFloat(new float[] {
                0.0F, 1.0F
            });
            valueanimator.setDuration(aj1.h());
            valueanimator.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener(((Matrix) (obj)), f1, f2, f3) {

                final Matrix a;
                final float b;
                final float c;
                final float d;
                final PanZoomViewer e;
                private Matrix f;

                public void onAnimationUpdate(ValueAnimator valueanimator1)
                {
                    float f5 = valueanimator1.getAnimatedFraction();
                    valueanimator1 = new float[9];
                    a.getValues(valueanimator1);
                    valueanimator1 = new PointF((b - valueanimator1[2]) * f5, (c - valueanimator1[5]) * f5);
                    f.set(a);
                    f.postTranslate(((PointF) (valueanimator1)).x, ((PointF) (valueanimator1)).y);
                    f.preScale((d - 1.0F) * f5 + 1.0F, f5 * (d - 1.0F) + 1.0F);
                    valueanimator1 = new float[9];
                    f.getValues(valueanimator1);
                    f5 = valueanimator1[0];
                    e.m.q.e = new Matrix(f);
                    e.m.q.d = f5;
                    e.m.q.a = false;
                    if (f5 <= e.m.q.c)
                    {
                        e.m.q.a = true;
                    }
                    e.m.q.f = e.b(e.m);
                    e.o();
                    valueanimator1 = com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ImageLoader.BufferName.b;
                    if (!((i)e.l.b.get(valueanimator1)).c)
                    {
                        valueanimator1 = (i)e.l.b.get(com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ImageLoader.BufferName.c);
                        if (((i) (valueanimator1)).c && ((i) (valueanimator1)).d)
                        {
                            valueanimator1 = com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ImageLoader.BufferName.c;
                        } else
                        {
                            valueanimator1 = ImageLoader.BufferName.a;
                        }
                    }
                    PanZoomViewer.a(e, valueanimator1, new q(e, e.m), PanZoomViewer.f(e));
                }

            
            {
                e = PanZoomViewer.this;
                a = matrix;
                b = f1;
                c = f2;
                d = f3;
                super();
                f = new Matrix();
            }
            });
            valueanimator.addListener(new android.animation.Animator.AnimatorListener(animatorlistener) {

                final android.animation.Animator.AnimatorListener a;
                final PanZoomViewer b;

                public void onAnimationCancel(Animator animator)
                {
                }

                public void onAnimationEnd(Animator animator)
                {
                    if (a != null)
                    {
                        a.onAnimationEnd(animator);
                    }
                    PanZoomViewer.a(b, ViewerMode.a);
                    com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.PanZoomViewer.b(b, false);
                    PanZoomViewer.a(b, false);
                    PanZoomViewer.a(b, ViewerMode.a);
                    b.m.q.f = b.b(b.m);
                    animator = new f();
                    animator.a = true;
                    b.b(com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ImageLoader.BufferName.c, animator);
                }

                public void onAnimationRepeat(Animator animator)
                {
                }

                public void onAnimationStart(Animator animator)
                {
                    if (a != null)
                    {
                        a.onAnimationStart(animator);
                    }
                }

            
            {
                b = PanZoomViewer.this;
                a = animatorlistener;
                super();
            }
            });
            ag = true;
            T = true;
            valueanimator.start();
            return;
        }
    }

    public void a(UUID uuid)
    {
        V = uuid;
    }

    public com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.af b(PointF pointf, PointF pointf1, float f1)
    {
        a("[calculateTransformResultForImageSwitchingMode]");
        float f2 = m.q.d;
        pointf = new Matrix(m.q.e);
        PointF pointf2 = new PointF(pointf1.x, pointf1.y);
        float af1[] = new float[9];
        pointf.getValues(af1);
        a((new StringBuilder()).append("before translate matrix left: ").append(af1[2] * af1[0]).append(" top: ").append(af1[5] * af1[0]).toString());
        pointf.preScale(1.0F / (f2 * f2), 1.0F / (f2 * f2));
        pointf.preTranslate(pointf2.x, pointf2.y);
        pointf.preScale(f2 * f2, f2 * f2);
        pointf.getValues(af1);
        float f4 = af1[0];
        float f6 = m.e;
        float f3 = (float)m.f * f4;
        f1 = af1[2] * f4;
        float f7 = f6 * f4 + f1;
        f4 = af1[5] * f4;
        f6 = f4 + f3;
        int l = n / 8;
        int k = -n / 2 + l;
        l = n / 2 - l;
        int i1 = (int)ae;
        int j1 = (int)ae;
        int k1 = (int)((float)m.e * m.q.d);
        pointf = com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.SwitchDirection.b;
        if (f1 < (float)i1)
        {
            pointf = com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.SwitchDirection.c;
        } else
        {
            pointf = com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.SwitchDirection.b;
        }
        if (f1 > (float)k && pointf == com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.SwitchDirection.b && t.a == -1L)
        {
            f1 = pointf2.x + ((float)k - f1);
            if (i1 > k)
            {
                f1 = 0.0F;
            }
            pointf2.set(f1, pointf2.y);
        } else
        if (f7 < (float)l && pointf == com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.SwitchDirection.c && u.a == -1L)
        {
            f1 = pointf2.x + ((float)l - f7);
            if (k1 + j1 < l)
            {
                f1 = 0.0F;
            }
            pointf2.set(f1, pointf2.y);
        }
        l = o / 8;
        k = -o / 2 + l;
        l = o / 2 - l;
        if (f4 > (float)k && pointf1.y > 0.0F)
        {
            f1 = pointf2.x;
            f6 = pointf2.y;
            pointf2.set(f1, (int)Math.floor(((float)k - f4) + f6));
        } else
        if (f6 < (float)l && pointf1.y < 0.0F)
        {
            f1 = pointf2.x;
            float f5 = pointf2.y;
            pointf2.set(f1, (int)Math.floor(((float)l - f6) + f5));
        }
        if (Math.floor(f3) <= (double)o)
        {
            pointf2.set(pointf2.x, 0.0F);
        }
        pointf = new Matrix(m.q.e);
        pointf.preScale(1.0F / (f2 * f2), 1.0F / (f2 * f2));
        pointf.preTranslate(pointf2.x, pointf2.y);
        pointf.preScale(f2 * f2, f2 * f2);
        a((new StringBuilder()).append("after translate matrix left: ").append(af1[2] * af1[0]).append(" top: ").append(af1[5] * af1[0]).toString());
        return new com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.af(this, pointf, m.q.a);
    }

    public void b(long l)
    {
        super.b(l);
        aC = ViewerMode.a;
    }

    protected void c()
    {
        super.c();
        aE = null;
        aF = null;
    }

    public UUID getCurrentBehavior()
    {
        return V;
    }

    public RectF getDrawRectF()
    {
        float af1[] = new float[9];
        m.q.e.getValues(af1);
        float f7 = af1[2];
        float f8 = af1[0];
        float f5 = af1[5];
        float f6 = af1[0];
        float f1 = m.e;
        float f2 = af1[0];
        float f3 = m.f;
        float f4 = af1[0];
        f7 = f7 * f8 + (float)getWidth() / 2.0F;
        f5 = f5 * f6 + (float)getHeight() / 2.0F;
        RectF rectf = new RectF();
        rectf.left = (float)Math.ceil(f7);
        rectf.top = (float)Math.ceil(f5);
        rectf.right = (float)Math.floor(f7 + f1 * f2);
        rectf.bottom = (float)Math.floor(f4 * f3 + f5);
        return rectf;
    }

    protected android.os.Handler.Callback getHandlerCallback()
    {
        return new ab(this);
    }

    public UUID getViewID()
    {
        return L;
    }

    protected void onDraw(Canvas canvas)
    {
        J;
        JVM INSTR lookupswitch 3: default 40
    //                   1: 113
    //                   11: 70
    //                   12: 211;
           goto _L1 _L2 _L3 _L4
_L1:
        H = com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ImageLoader.BufferName.b;
        I = new q(this, m);
        aE = com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ViewerMode.b;
_L3:
        if (H != null && I != null && aE != null)
        {
            a(canvas, H, I, aE);
        } else
        {
            m.e("RENDER", "can't render RENDER_CACHE");
        }
_L6:
        z();
        return;
_L2:
        if (H != null && I != null)
        {
            if (!a(canvas, H, I))
            {
                a(canvas, com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ImageLoader.BufferName.b, I, aE);
            }
        } else
        {
            m.e("RENDER", "can't render RENDER_DISPLAY run renderCacheCanvas");
            a(canvas, com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ImageLoader.BufferName.b, new q(this, m), com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ViewerMode.b);
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (aF != null)
        {
            a(canvas, aF);
        } else
        {
            m.e("RENDER", "can't render RENDER_SWITCH_IMG");
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public boolean onGenericMotionEvent(MotionEvent motionevent)
    {
        if (motionevent.getActionMasked() != 8) goto _L2; else goto _L1
_L1:
        if (!j())
        {
            return false;
        }
        if (aC == com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ViewerMode.c)
        {
            return false;
        }
        if (T)
        {
            return false;
        }
        if (U.containsKey(V) && StatusManager.j().B())
        {
            return false;
        }
        if (aC != ViewerMode.a) goto _L4; else goto _L3
_L3:
        aC = com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ViewerMode.b;
_L5:
        float f1 = motionevent.getX();
        float f2 = motionevent.getY();
        float f3 = motionevent.getAxisValue(9);
        c(new PointF((float)getWidth() / 2.0F - f1, (float)getHeight() / 2.0F - f2), new PointF(0.0F, 0.0F), 1.0F + 0.02F * f3);
        aC = ViewerMode.a;
        A();
        return true;
_L4:
        if (aC == ViewerMode.d)
        {
            B();
        }
        if (true) goto _L5; else goto _L2
_L2:
        if (motionevent.getActionMasked() == 7)
        {
            if (U.containsKey(V))
            {
                ((s)U.get(V)).a(motionevent, Boolean.valueOf(false));
                return true;
            }
        } else
        if (motionevent.getActionMasked() == 10)
        {
            if (U.containsKey(V))
            {
                ((s)U.get(V)).a(motionevent, Boolean.valueOf(false));
                return true;
            }
        } else
        if (motionevent.getActionMasked() == 9 && U.containsKey(V))
        {
            ((s)U.get(V)).a(motionevent, Boolean.valueOf(false));
            return true;
        }
        return false;
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        boolean flag1 = true;
        if (isEnabled()) goto _L2; else goto _L1
_L1:
        boolean flag = false;
_L13:
        return flag;
_L2:
        Object obj;
        int k;
        if (C != null)
        {
            C.cancel();
        }
        if (Globals.d().t() != null && Globals.d().t().b)
        {
            if (aa && P != null)
            {
                aa = false;
                P.b(motionevent);
            }
            return false;
        }
        aD = motionevent.getPointerCount();
        if (B.booleanValue() && motionevent.getActionMasked() == 0 && motionevent.getPointerCount() <= 1)
        {
            obj = d(motionevent.getX(), motionevent.getY());
            if (obj != null)
            {
                aw = new ae(this);
                aw.b = ((com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints) (obj));
                aw.a = motionevent.getPointerId(0);
                aw.c = Bitmap.createBitmap((Bitmap)this.k.get(obj));
                if (aw.c.sameAs(f))
                {
                    this.k.put(obj, i);
                } else
                {
                    this.k.put(obj, j);
                }
                ak.setTouchedPoint(aw.b);
                aA = new PointF(motionevent.getX(), motionevent.getY());
                aC = com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ViewerMode.g;
                C();
                al.setFocusPoint(aw.b);
                if (D.isRunning())
                {
                    D.cancel();
                }
            }
        }
        motionevent.getActionMasked();
        JVM INSTR tableswitch 0 6: default 344
    //                   0 469
    //                   1 590
    //                   2 1331
    //                   3 1301
    //                   4 344
    //                   5 562
    //                   6 595;
           goto _L3 _L4 _L5 _L6 _L7 _L3 _L8 _L9
_L3:
        k = 0;
          goto _L10
_L4:
        aa = true;
        as = Boolean.valueOf(false);
        if (U.containsKey(V))
        {
            w();
            ar = Boolean.valueOf(false);
            au = new com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ag(this);
            au.executeOnExecutor(at, new Void[0]);
        }
        setTouchStatus(true);
        StatusManager.j().a(aw, motionevent.getActionMasked());
        k = 0;
          goto _L10
_L8:
        if (ar.booleanValue()) goto _L3; else goto _L11
_L11:
        as = Boolean.valueOf(true);
        w();
        k = 0;
          goto _L10
_L5:
        aa = false;
_L9:
        int l;
        if (motionevent.getPointerCount() == 1)
        {
            if (aw != null && B.booleanValue())
            {
                k = motionevent.findPointerIndex(aw.a);
                if (k != -1 && motionevent.getPointerCount() > k)
                {
                    obj = new PointF();
                    PointF pointf = new PointF();
                    if (av.a(((PointF) (obj)), pointf))
                    {
                        float f1 = ((PointF) (obj)).x;
                        float f3 = ((PointF) (obj)).y;
                        float f5 = pointf.x;
                        float f7 = pointf.y;
                        a((new StringBuilder()).append("feature points moving x: ").append(f5).append(" y: ").append(f7).toString());
                        obj = new PointF((float)getWidth() / 2.0F - f1, (float)getHeight() / 2.0F - f3);
                        pointf = new PointF(f5, f7);
                        if (getDrawRectF().contains(aB.x + f1, aB.y + f3))
                        {
                            aA.set(f1, f3);
                            c(((PointF) (obj)), pointf, 1.0F);
                        }
                    }
                }
            }
            setTouchStatus(false);
            float f2;
            float f4;
            float f6;
            float f8;
            PointF pointf1;
            if (aC == com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ViewerMode.g && B.booleanValue())
            {
                u();
                p();
                aC = ViewerMode.a;
                obj = new f();
                obj.a = true;
                b(com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ImageLoader.BufferName.c, ((f) (obj)));
                if (aw != null)
                {
                    if (aw.c != null)
                    {
                        this.k.put(aw.b, Bitmap.createBitmap(aw.c));
                        RateOfFeaturePointAdjustment.a(aw.b, Boolean.valueOf(true));
                    }
                    StatusManager.j().a(aw, motionevent.getActionMasked());
                    al.a();
                    k = 1;
                } else
                {
                    if (ax != null && ax.c != null)
                    {
                        this.k.put(ax.b, Bitmap.createBitmap(ax.c));
                        RateOfFeaturePointAdjustment.a(ax.b, Boolean.valueOf(true));
                    }
                    StatusManager.j().a(ax, motionevent.getActionMasked());
                    k = 1;
                }
            } else
            {
                k = 0;
            }
            if (aw != null)
            {
                aw.c = null;
                aw = null;
            }
            if (ax != null)
            {
                ax.c = null;
                ax = null;
            }
            l = k;
        } else
        {
            l = 0;
        }
        if (!ar.booleanValue() && motionevent.getActionMasked() == 1 && U.containsKey(V) && !as.booleanValue())
        {
            ((s)U.get(V)).a(motionevent, Boolean.valueOf(true));
            if (!ap)
            {
                v();
                w();
            }
        }
        k = l;
        if (motionevent.getActionMasked() == 6)
        {
            k = l;
            if (aw != null)
            {
                k = l;
                if (motionevent.getPointerId(motionevent.getActionIndex()) == aw.a)
                {
                    ax = new ae(this);
                    ax.b = aw.b;
                    ax.a = aw.a;
                    ax.c = Bitmap.createBitmap(aw.c);
                    aw = null;
                    aA = null;
                    t();
                    k = l;
                }
            }
        }
          goto _L10
_L7:
        setTouchStatus(false);
        w();
        aw = null;
        aA = null;
        aa = false;
        k = 0;
          goto _L10
_L6:
        if (P != null)
        {
            P.c(motionevent);
        }
        if (aw != null && B.booleanValue())
        {
            k = motionevent.findPointerIndex(aw.a);
            if (k != -1 && motionevent.getPointerCount() > k)
            {
                f2 = motionevent.getX(k);
                f4 = motionevent.getY(k);
                f6 = f2 - aA.x;
                f8 = f4 - aA.y;
                a((new StringBuilder()).append("feature points moving x: ").append(f6).append(" y: ").append(f8).toString());
                obj = new PointF((float)getWidth() / 2.0F - f2, (float)getHeight() / 2.0F - f4);
                pointf1 = new PointF(f6, f8);
                if (getDrawRectF().contains(aB.x + f2, aB.y + f4))
                {
                    av.a(new PointF(f2, f4));
                    aA.set(f2, f4);
                    c(((PointF) (obj)), pointf1, 1.0F);
                }
            }
        }
          goto _L3
_L10:
        if (U.containsKey(V))
        {
            obj = (s)U.get(V);
            if (ar.booleanValue())
            {
                if (ap || aa)
                {
                    ((s) (obj)).a(motionevent, Boolean.valueOf(true));
                    flag = flag1;
                    if (aa)
                    {
                        flag = flag1;
                        if (P != null)
                        {
                            aa = false;
                            P.b(motionevent);
                            return true;
                        }
                    }
                } else
                {
                    ((s) (obj)).a(Boolean.valueOf(true));
                    ((s) (obj)).a(motionevent, Boolean.valueOf(false));
                    return true;
                }
                continue; /* Loop/switch isn't completed */
            }
            if (!ar.booleanValue() && !as.booleanValue())
            {
                ((s) (obj)).a(motionevent, Boolean.valueOf(true));
            }
        }
        if (N == null && M == null && P == null && O == null)
        {
            N = new ac(this);
            M = new ScaleGestureDetector(getContext(), N);
            P = new com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.y(this);
            O = new GestureDetector(getContext(), P);
        }
        if (!j())
        {
            ah = true;
        }
        if (!ah)
        {
            break; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (motionevent.getActionMasked() == 1)
        {
            ah = false;
            return true;
        }
        if (true) goto _L13; else goto _L12
_L12:
        if (aw == null && aC != com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ViewerMode.g && k == 0)
        {
            O.onTouchEvent(motionevent);
            M.onTouchEvent(motionevent);
        }
        switch (motionevent.getActionMasked())
        {
        case 2: // '\002'
        case 4: // '\004'
        case 5: // '\005'
        default:
            return true;

        case 0: // '\0'
            z();
            motionevent = new float[9];
            m.q.e.getValues(motionevent);
            f2 = motionevent[2];
            ae = motionevent[0] * f2;
            flag = flag1;
            if (af != null)
            {
                af.cancel();
                return true;
            }
            break;

        case 1: // '\001'
        case 3: // '\003'
            P.b(motionevent);
            return true;

        case 6: // '\006'
            P.a(motionevent);
            return true;
        }
        if (true) goto _L13; else goto _L14
_L14:
    }

    public c s()
    {
        if (!b().booleanValue())
        {
            return null;
        } else
        {
            q q1 = m;
            com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.m m1 = l.a(q1);
            c c1 = new c();
            c1.a = q1.a;
            c1.b = q1.b;
            c1.c = q1.c;
            c1.d = q1.d;
            c1.e = q1.e;
            c1.f = q1.f;
            c1.g = q1.g;
            c1.h = n;
            c1.i = o;
            c1.j = q1.q.e;
            c1.k = q1.q.f;
            c1.l = m1.c;
            c1.m = m1.a;
            c1.n = m1.b;
            c1.o = y;
            c1.p = z;
            c1.q = A;
            c1.r = q1.h;
            return c1;
        }
    }

    public void setBirdView(BirdView birdview)
    {
        aj = birdview;
    }

    public void setCustomCursorView(ImageView imageview)
    {
        am = imageview;
    }

    public void setFeaturePointGuideView(FeaturePointGuideView featurepointguideview)
    {
        al = featurepointguideview;
    }

    public void setMovableBirdView(MovableBirdView movablebirdview)
    {
        ak = movablebirdview;
    }

    public void t()
    {
        while (aj == null || aj.getVisibility() != 0) 
        {
            return;
        }
        aj.b();
        invalidate();
    }

    public void u()
    {
        if (ak == null)
        {
            return;
        } else
        {
            ak.a();
            invalidate();
            return;
        }
    }


    private class ViewerMode extends Enum
    {

        public static final ViewerMode a;
        public static final ViewerMode b;
        public static final ViewerMode c;
        public static final ViewerMode d;
        public static final ViewerMode e;
        public static final ViewerMode f;
        public static final ViewerMode g;
        public static final ViewerMode h;
        private static final ViewerMode i[];

        public static ViewerMode valueOf(String s1)
        {
            return (ViewerMode)Enum.valueOf(com/cyberlink/youcammakeup/kernelctrl/panzoomviewer/PanZoomViewer$ViewerMode, s1);
        }

        public static ViewerMode[] values()
        {
            return (ViewerMode[])i.clone();
        }

        static 
        {
            a = new ViewerMode("unknown", 0);
            b = new ViewerMode("imageViewing", 1);
            c = new ViewerMode("imageSwitching", 2);
            d = new ViewerMode("imageBouncing", 3);
            e = new ViewerMode("imageFling", 4);
            f = new ViewerMode("imageDoubleTaping", 5);
            g = new ViewerMode("featurePoint", 6);
            h = new ViewerMode("adjustWig", 7);
            i = (new ViewerMode[] {
                a, b, c, d, e, f, g, h
            });
        }

        private ViewerMode(String s1, int k)
        {
            super(s1, k);
        }
    }


    private class SwitchDirection extends Enum
    {

        public static final SwitchDirection a;
        public static final SwitchDirection b;
        public static final SwitchDirection c;
        private static final SwitchDirection d[];

        public static SwitchDirection valueOf(String s1)
        {
            return (SwitchDirection)Enum.valueOf(com/cyberlink/youcammakeup/kernelctrl/panzoomviewer/PanZoomViewer$SwitchDirection, s1);
        }

        public static SwitchDirection[] values()
        {
            return (SwitchDirection[])d.clone();
        }

        static 
        {
            a = new SwitchDirection("currentImage", 0);
            b = new SwitchDirection("previousImage", 1);
            c = new SwitchDirection("nextImage", 2);
            d = (new SwitchDirection[] {
                a, b, c
            });
        }

        private SwitchDirection(String s1, int k)
        {
            super(s1, k);
        }
    }

}

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
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.activity.EditViewActivity;
import com.cyberlink.youcammakeup.e;
import com.cyberlink.youcammakeup.jniproxy.UIImageOrientation;
import com.cyberlink.youcammakeup.jniproxy.aa;
import com.cyberlink.youcammakeup.jniproxy.ab;
import com.cyberlink.youcammakeup.jniproxy.ac;
import com.cyberlink.youcammakeup.jniproxy.ah;
import com.cyberlink.youcammakeup.jniproxy.ai;
import com.cyberlink.youcammakeup.jniproxy.g;
import com.cyberlink.youcammakeup.jniproxy.y;
import com.cyberlink.youcammakeup.kernelctrl.Camera;
import com.cyberlink.youcammakeup.kernelctrl.HairDyeBrushHandler;
import com.cyberlink.youcammakeup.kernelctrl.VenusHelper;
import com.cyberlink.youcammakeup.kernelctrl.ar;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.CmdSetting;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.DevelopSetting;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.u;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.v;
import com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef;
import com.cyberlink.youcammakeup.kernelctrl.j;
import com.cyberlink.youcammakeup.kernelctrl.status.ImageStateChangedEvent;
import com.cyberlink.youcammakeup.kernelctrl.status.SessionState;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.kernelctrl.status.a;
import com.cyberlink.youcammakeup.kernelctrl.status.ad;
import com.cyberlink.youcammakeup.kernelctrl.status.af;
import com.cyberlink.youcammakeup.kernelctrl.status.ag;
import com.cyberlink.youcammakeup.kernelctrl.status.ak;
import com.cyberlink.youcammakeup.kernelctrl.status.m;
import com.cyberlink.youcammakeup.kernelctrl.status.q;
import com.cyberlink.youcammakeup.kernelctrl.status.z;
import com.cyberlink.youcammakeup.kernelctrl.t;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.ImageBufferWrapper;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.ViewEngine;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.i;
import com.cyberlink.youcammakeup.utility.BeautyMode;
import com.cyberlink.youcammakeup.utility.MakeupMode;
import com.cyberlink.youcammakeup.utility.o;
import com.cyberlink.youcammakeup.widgetpool.accessorypreviewview.AccessoryDrawingCtrl;
import com.cyberlink.youcammakeup.widgetpool.accessorypreviewview.AccessoryView;
import com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper;
import com.cyberlink.youcammakeup.widgetpool.wigpreviewview.WigView;
import com.cyberlink.youcammakeup.widgetpool.wigpreviewview.c;
import java.util.ArrayList;
import java.util.Collections;
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
//            a, n, q, o, 
//            g, s, t, r, 
//            ImageLoader, c, u, PanZoomViewer, 
//            v, f, i, w, 
//            b, d, x, p, 
//            e, h

public class ImageViewer extends View
    implements com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.a, ad, af, ag, ak, m, q, z
{

    public static final int K[] = {
        102, 255, 96, 0
    };
    private static final List O = a();
    private static final List P = s();
    protected static final PorterDuffXfermode a;
    protected static final Map e = t();
    protected int A;
    protected Boolean B;
    protected Timer C;
    protected ValueAnimator D;
    boolean E;
    boolean F;
    protected Handler G;
    protected ImageLoader.BufferName H;
    protected com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.q I;
    protected int J;
    private p L;
    private ExecutorService M;
    private int N;
    private String Q;
    private boolean R;
    private com.cyberlink.youcammakeup.kernelctrl.ah S;
    private boolean T;
    private ar U;
    private int V;
    private int W;
    private Boolean aa;
    private boolean ab;
    protected float b;
    protected float c;
    protected float d;
    protected Bitmap f;
    protected Bitmap g;
    protected Bitmap h;
    protected Bitmap i;
    protected Bitmap j;
    protected Map k;
    protected ImageLoader l;
    public com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.q m;
    protected int n;
    protected int o;
    protected Object p;
    protected Paint q;
    protected Bitmap r;
    protected HairDyeBrushHandler s;
    public com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.q t;
    public com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.q u;
    public com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.q v;
    protected n w;
    protected boolean x;
    protected w y;
    protected int z;

    public ImageViewer(Context context)
    {
        super(context);
        L = null;
        M = Executors.newFixedThreadPool(1);
        N = 640;
        b = 0.5F;
        c = 1.0F;
        d = 4F;
        f = null;
        g = null;
        h = null;
        i = null;
        j = null;
        k = null;
        Q = "ImageViewer";
        R = true;
        l = null;
        m = null;
        n = -1;
        o = -1;
        p = new Object();
        q = null;
        r = null;
        s = null;
        S = null;
        t = null;
        u = null;
        v = null;
        w = new n();
        x = true;
        y = null;
        z = -1;
        A = -1;
        T = false;
        B = Boolean.valueOf(false);
        U = null;
        C = null;
        D = null;
        V = 1500;
        W = 300;
        aa = Boolean.valueOf(false);
        E = false;
        F = false;
        H = null;
        I = null;
        J = -1;
        ab = false;
        a("[ImageViewer]");
        if (!isInEditMode())
        {
            u();
        }
    }

    public ImageViewer(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        L = null;
        M = Executors.newFixedThreadPool(1);
        N = 640;
        b = 0.5F;
        c = 1.0F;
        d = 4F;
        f = null;
        g = null;
        h = null;
        i = null;
        j = null;
        k = null;
        Q = "ImageViewer";
        R = true;
        l = null;
        m = null;
        n = -1;
        o = -1;
        p = new Object();
        q = null;
        r = null;
        s = null;
        S = null;
        t = null;
        u = null;
        v = null;
        w = new n();
        x = true;
        y = null;
        z = -1;
        A = -1;
        T = false;
        B = Boolean.valueOf(false);
        U = null;
        C = null;
        D = null;
        V = 1500;
        W = 300;
        aa = Boolean.valueOf(false);
        E = false;
        F = false;
        H = null;
        I = null;
        J = -1;
        ab = false;
        a("[ImageViewer]");
        if (!isInEditMode())
        {
            u();
        }
    }

    public ImageViewer(Context context, AttributeSet attributeset, int i1)
    {
        super(context, attributeset, i1);
        L = null;
        M = Executors.newFixedThreadPool(1);
        N = 640;
        b = 0.5F;
        c = 1.0F;
        d = 4F;
        f = null;
        g = null;
        h = null;
        i = null;
        j = null;
        k = null;
        Q = "ImageViewer";
        R = true;
        l = null;
        m = null;
        n = -1;
        o = -1;
        p = new Object();
        q = null;
        r = null;
        s = null;
        S = null;
        t = null;
        u = null;
        v = null;
        w = new n();
        x = true;
        y = null;
        z = -1;
        A = -1;
        T = false;
        B = Boolean.valueOf(false);
        U = null;
        C = null;
        D = null;
        V = 1500;
        W = 300;
        aa = Boolean.valueOf(false);
        E = false;
        F = false;
        H = null;
        I = null;
        J = -1;
        ab = false;
        a("[ImageViewer]");
        if (!isInEditMode())
        {
            u();
        }
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

    private RectF a(List list)
    {
        float f4 = ((PointF)list.get(0)).x;
        float f6 = ((PointF)list.get(0)).x;
        float f3 = ((PointF)list.get(0)).y;
        float f1 = ((PointF)list.get(0)).y;
        for (list = list.iterator(); list.hasNext();)
        {
            PointF pointf = (PointF)list.next();
            float f2 = f4;
            if (pointf.x < f4)
            {
                f2 = pointf.x;
            }
            f4 = f6;
            if (pointf.x > f6)
            {
                f4 = pointf.x;
            }
            float f5 = f3;
            if (pointf.y < f3)
            {
                f5 = pointf.y;
            }
            if (pointf.y > f1)
            {
                f1 = pointf.y;
            }
            f6 = f4;
            f3 = f5;
            f4 = f2;
        }

        return new RectF(f4, f3, f6, f1);
    }

    private static List a()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(MakeupMode.a);
        arraylist.add(MakeupMode.e);
        return arraylist;
    }

    private void a(float f1, float f2, float f3, Canvas canvas, com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.q q1)
    {
        Paint paint;
        com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints afeaturepoints[];
        com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints afeaturepoints1[];
        paint = new Paint();
        paint.setStyle(android.graphics.Paint.Style.FILL);
        afeaturepoints = new com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints[10];
        afeaturepoints[0] = com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.b;
        afeaturepoints[1] = com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.d;
        afeaturepoints[2] = com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.c;
        afeaturepoints[3] = com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.e;
        afeaturepoints[4] = com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.g;
        afeaturepoints[5] = com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.i;
        afeaturepoints[6] = com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.h;
        afeaturepoints[7] = com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.j;
        afeaturepoints[8] = com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.a;
        afeaturepoints[9] = com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.f;
        afeaturepoints1 = new com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints[2];
        afeaturepoints1[0] = com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.a;
        afeaturepoints1[1] = com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.f;
        if (q1 == null || q1.k == null) goto _L2; else goto _L1
_L1:
        Map map = q1.k;
        map;
        JVM INSTR monitorenter ;
        if (StatusManager.j().s() != BeautyMode.s) goto _L4; else goto _L3
_L3:
        int i1 = 0;
_L14:
        if (i1 >= afeaturepoints1.length) goto _L4; else goto _L5
_L5:
        com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.o o2 = (com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.o)q1.k.get(afeaturepoints1[i1]);
        if (o2 == null) goto _L7; else goto _L6
_L6:
        if (o2.b)
        {
            a(canvas, afeaturepoints1[i1], f1, f2, MotionControlHelper.e().P() * f3, q1);
        }
          goto _L7
_L12:
        if (i1 >= afeaturepoints.length) goto _L9; else goto _L8
_L8:
        com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.o o1 = (com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.o)q1.k.get(afeaturepoints[i1]);
        if (o1 == null) goto _L11; else goto _L10
_L10:
        if (o1.b)
        {
            a(canvas, paint, afeaturepoints[i1], f1, f2, q1, (Bitmap)k.get(afeaturepoints[i1]));
        }
          goto _L11
_L9:
        map;
        JVM INSTR monitorexit ;
        return;
        canvas;
        map;
        JVM INSTR monitorexit ;
        throw canvas;
_L7:
        i1++;
        continue; /* Loop/switch isn't completed */
_L4:
        i1 = 0;
        continue; /* Loop/switch isn't completed */
_L11:
        i1++;
        if (true) goto _L12; else goto _L2
_L2:
        return;
        if (true) goto _L14; else goto _L13
_L13:
    }

    private void a(long l1, SessionState sessionstate)
    {
        sessionstate.a(new e(l1) {

            final long a;
            final ImageViewer b;

            public void a(ImageBufferWrapper imagebufferwrapper)
            {
                while (imagebufferwrapper == null || imagebufferwrapper.j() == null) 
                {
                    return;
                }
                ViewEngine.a().a(a, imagebufferwrapper);
                imagebufferwrapper = new f();
                imagebufferwrapper.a = false;
                b.a(com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ImageLoader.BufferName.a, imagebufferwrapper);
                imagebufferwrapper = new f();
                imagebufferwrapper.a = true;
                b.a(com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ImageLoader.BufferName.c, imagebufferwrapper);
                imagebufferwrapper = new f();
                b.a(ImageLoader.BufferName.b, imagebufferwrapper);
            }

            public volatile void a(Object obj)
            {
                a((ImageBufferWrapper)obj);
            }

            public void a(Void void1)
            {
            }

            public void b(Object obj)
            {
                a((Void)obj);
            }

            public void b(Void void1)
            {
            }

            public void c(Object obj)
            {
                b((Void)obj);
            }

            
            {
                b = ImageViewer.this;
                a = l1;
                super();
            }
        });
    }

    private void a(Canvas canvas, Paint paint, com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints featurepoints, float f1, float f2, com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.q q1, Bitmap bitmap)
    {
        if (bitmap != null && B.booleanValue() && q1.k != null)
        {
            paint = ((com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.o)q1.k.get(featurepoints)).a;
            float f3 = bitmap.getWidth();
            float f4 = bitmap.getHeight();
            f1 = (((PointF) (paint)).x + f1) - f3 / 2.0F;
            f2 = (((PointF) (paint)).y + f2) - f4 / 2.0F;
            paint = new RectF();
            paint.left = f1;
            paint.top = f2;
            paint.right = f3 + f1;
            paint.bottom = f2 + f4;
            featurepoints = new Paint();
            featurepoints.setStyle(android.graphics.Paint.Style.FILL);
            featurepoints.setAlpha(q1.p);
            if (bitmap != null)
            {
                canvas.drawBitmap(bitmap, null, paint, featurepoints);
                return;
            }
        }
    }

    private void a(Canvas canvas, com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints featurepoints, float f1, float f2, float f3, com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.q q1)
    {
        if (!B.booleanValue() || q1.k == null)
        {
            return;
        } else
        {
            featurepoints = ((com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.o)q1.k.get(featurepoints)).a;
            Paint paint = new Paint();
            paint.setStyle(android.graphics.Paint.Style.FILL);
            paint.setColor(Color.argb((int)((float)K[0] * ((float)q1.p / 255F)), K[1], K[2], K[3]));
            canvas.drawCircle(((PointF) (featurepoints)).x + f1, ((PointF) (featurepoints)).y + f2, f3, paint);
            return;
        }
    }

    private void a(DevelopSetting developsetting)
    {
        if (b(developsetting))
        {
            com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.g g1 = new com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.g();
            g1.a = m.h.c;
            g1.b = m.h.d;
            g1.c = m.d;
            a(m, g1, developsetting);
        }
    }

    static void a(ImageViewer imageviewer, String s1)
    {
        imageviewer.a(s1);
    }

    private void a(SessionState sessionstate)
    {
        m.i = sessionstate.a().d();
        if (m.j != sessionstate.a().e)
        {
            m.j = sessionstate.a().e;
        }
    }

    private void a(Boolean boolean1, boolean flag)
    {
        List list = (List)e.get(m.n);
        com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints afeaturepoints[] = new com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints[4];
        afeaturepoints[0] = com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.B;
        afeaturepoints[1] = com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.C;
        afeaturepoints[2] = com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.N;
        afeaturepoints[3] = com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.M;
        List list1 = FeaturePointsDef.a(afeaturepoints, afeaturepoints.length);
        Iterator iterator = m.k.entrySet().iterator();
        do
        {
            if (iterator.hasNext())
            {
                java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
                if (!B.booleanValue())
                {
                    ((com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.o)entry.getValue()).b = false;
                } else
                if (!list.contains(entry.getKey()))
                {
                    ((com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.o)entry.getValue()).b = false;
                } else
                {
                    ((com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.o)entry.getValue()).b = flag;
                }
                if (list1.contains(entry.getKey()) && (boolean1 == null || !boolean1.booleanValue()))
                {
                    ((com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.o)entry.getValue()).b = false;
                }
            } else
            {
                return;
            }
        } while (true);
    }

    private void a(String s1)
    {
        if (!R);
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

    private void b(float f1, float f2, float f3, Canvas canvas, com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.q q1)
    {
        Paint paint;
        com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints afeaturepoints[];
        paint = new Paint();
        paint.setStyle(android.graphics.Paint.Style.FILL);
        afeaturepoints = new com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints[16];
        afeaturepoints[0] = com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.y;
        afeaturepoints[1] = com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.z;
        afeaturepoints[2] = com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.A;
        afeaturepoints[3] = com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.B;
        afeaturepoints[4] = com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.C;
        afeaturepoints[5] = com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.D;
        afeaturepoints[6] = com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.E;
        afeaturepoints[7] = com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.F;
        afeaturepoints[8] = com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.G;
        afeaturepoints[9] = com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.H;
        afeaturepoints[10] = com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.I;
        afeaturepoints[11] = com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.J;
        afeaturepoints[12] = com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.K;
        afeaturepoints[13] = com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.L;
        afeaturepoints[14] = com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.M;
        afeaturepoints[15] = com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.N;
        if (q1 == null || q1.k == null) goto _L2; else goto _L1
_L1:
        Map map = q1.k;
        map;
        JVM INSTR monitorenter ;
        int i1 = 0;
_L3:
        com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.o o1;
        if (i1 >= afeaturepoints.length)
        {
            break MISSING_BLOCK_LABEL_250;
        }
        o1 = (com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.o)q1.k.get(afeaturepoints[i1]);
        if (o1 == null)
        {
            break MISSING_BLOCK_LABEL_262;
        }
        if (o1.b)
        {
            a(canvas, paint, afeaturepoints[i1], f1, f2, q1, (Bitmap)k.get(afeaturepoints[i1]));
        }
        break MISSING_BLOCK_LABEL_262;
        map;
        JVM INSTR monitorexit ;
        return;
        canvas;
        map;
        JVM INSTR monitorexit ;
        throw canvas;
        i1++;
        if (true) goto _L3; else goto _L2
_L2:
    }

    private void b(Canvas canvas, Paint paint, com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints featurepoints, float f1, float f2, com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.q q1, Bitmap bitmap)
    {
        if (bitmap != null && B.booleanValue() && q1.k != null)
        {
            paint = ((com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.o)q1.k.get(featurepoints)).a;
            float f3 = bitmap.getWidth();
            float f4 = bitmap.getHeight();
            f1 = (((PointF) (paint)).x + f1) - f3 / 2.0F;
            f2 = (((PointF) (paint)).y + f2) - f4 / 2.0F;
            paint = new RectF();
            paint.left = f1;
            paint.top = f2;
            paint.right = f3 + f1;
            paint.bottom = f2 + f4;
            featurepoints = new Paint();
            featurepoints.setStyle(android.graphics.Paint.Style.FILL);
            featurepoints.setAlpha(q1.p);
            if (bitmap != null)
            {
                canvas.drawBitmap(bitmap, null, paint, featurepoints);
                return;
            }
        }
    }

    private boolean b(DevelopSetting developsetting)
    {
        if (!m.h.b)
        {
            if (developsetting.containsKey("global") && ((CmdSetting)developsetting.get("global")).containsKey(Integer.valueOf(7)))
            {
                return true;
            }
        } else
        {
            if (!developsetting.containsKey("global") || !((CmdSetting)developsetting.get("global")).containsKey(Integer.valueOf(7)))
            {
                return true;
            }
            developsetting = (g)((CmdSetting)developsetting.get("global")).get(Integer.valueOf(7));
            if ((float)m.h.k != developsetting.h() || m.h.g != developsetting.f() || m.h.h != developsetting.g() || m.h.i != developsetting.d() || m.h.j != developsetting.e())
            {
                return true;
            }
        }
        return false;
    }

    private boolean b(com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.q q1, com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.g g1, DevelopSetting developsetting)
    {
        int i1 = q1.h.c;
        int j1 = q1.h.d;
        q1.h.c = g1.a;
        q1.h.d = g1.b;
        if (q1.a == -5L)
        {
            q1.h.c = i1;
            q1.h.d = j1;
        }
        if (g1.c == UIImageOrientation.g || g1.c == UIImageOrientation.i || g1.c == UIImageOrientation.f || g1.c == UIImageOrientation.h)
        {
            q1.h.e = q1.h.d;
            q1.h.f = q1.h.c;
        } else
        {
            q1.h.e = q1.h.c;
            q1.h.f = q1.h.d;
        }
        if (developsetting.containsKey("global") && ((CmdSetting)developsetting.get("global")).containsKey(Integer.valueOf(7)))
        {
            g1 = (g)((CmdSetting)developsetting.get("global")).get(Integer.valueOf(7));
            q1.h.a = q1.a;
            q1.h.b = true;
            q1.h.k = (int)g1.h();
            q1.h.g = g1.f();
            q1.h.h = g1.g();
            q1.h.i = g1.d();
            q1.h.j = g1.e();
            return true;
        } else
        {
            q1.h.b = false;
            return false;
        }
    }

    private RectF c(ar ar1)
    {
        RectF rectf = new RectF();
        rectf.left = ar1.c.k().b().b();
        rectf.right = ar1.c.k().e().b();
        rectf.top = ar1.c.k().c().c();
        rectf.bottom = ar1.c.k().g().c();
        return rectf;
    }

    private void c(float f1, float f2, float f3, Canvas canvas, com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.q q1)
    {
        Paint paint = new Paint();
        paint.setStyle(android.graphics.Paint.Style.FILL);
        com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints afeaturepoints[] = new com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints[5];
        afeaturepoints[0] = com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.n;
        afeaturepoints[1] = com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.k;
        afeaturepoints[2] = com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.l;
        afeaturepoints[3] = com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.m;
        afeaturepoints[4] = com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.o;
        if (q1 != null && q1.k != null)
        {
            for (int i1 = 0; i1 < afeaturepoints.length; i1++)
            {
                com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.o o1 = (com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.o)q1.k.get(afeaturepoints[i1]);
                if (o1 != null && o1.b)
                {
                    a(canvas, paint, afeaturepoints[i1], f1, f2, q1, (Bitmap)k.get(afeaturepoints[i1]));
                }
            }

        }
    }

    private void c(boolean flag)
    {
        if (O.contains(StatusManager.j().r()) || P.contains(StatusManager.j().s()))
        {
            StatusManager.j().c(flag);
            return;
        } else
        {
            StatusManager.j().c(false);
            return;
        }
    }

    private RectF d(ar ar1)
    {
        PointF pointf = new PointF(ar1.c.e().d().b(), ar1.c.e().d().c());
        PointF pointf1 = new PointF(ar1.c.e().c().b(), ar1.c.e().c().c());
        PointF pointf2 = new PointF(ar1.c.e().e().b(), ar1.c.e().e().c());
        PointF pointf3 = new PointF(ar1.c.d().b().b(), ar1.c.d().b().c());
        PointF pointf4 = new PointF(ar1.c.d().c().b(), ar1.c.d().c().c());
        ar1 = new PointF(ar1.c.d().e().b(), ar1.c.d().e().c());
        RectF rectf = new RectF();
        rectf.left = pointf3.x;
        rectf.right = pointf.x;
        float f1;
        if (pointf4.y < pointf1.y)
        {
            f1 = pointf4.y;
        } else
        {
            f1 = pointf1.y;
        }
        rectf.top = f1;
        if (((PointF) (ar1)).y > pointf2.y)
        {
            f1 = ((PointF) (ar1)).y;
        } else
        {
            f1 = pointf2.y;
        }
        rectf.bottom = f1;
        return rectf;
    }

    private void d(float f1, float f2, float f3, Canvas canvas, com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.q q1)
    {
        Paint paint = new Paint();
        paint.setStyle(android.graphics.Paint.Style.FILL);
        com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints afeaturepoints[] = new com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints[3];
        afeaturepoints[0] = com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.Y;
        afeaturepoints[1] = com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.X;
        afeaturepoints[2] = com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.Z;
        if (q1 != null && q1.k != null)
        {
            for (int i1 = 0; i1 < afeaturepoints.length; i1++)
            {
                com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.o o1 = (com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.o)q1.k.get(afeaturepoints[i1]);
                if (o1 != null && o1.b)
                {
                    a(canvas, paint, afeaturepoints[i1], f1, f2, q1, (Bitmap)k.get(afeaturepoints[i1]));
                }
            }

        }
    }

    private float e(com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.q q1)
    {
        return Math.min(Math.min(1.0F, Math.min((float)N / (float)q1.b, (float)N / (float)q1.c)), Math.min(1.0F, q1.q.c * q1.s.a));
    }

    private RectF e(ar ar1)
    {
        PointF pointf = new PointF(ar1.c.g().b().b(), ar1.c.g().b().c());
        PointF pointf1 = new PointF(ar1.c.e().c().b(), ar1.c.e().c().c());
        PointF pointf2 = new PointF(ar1.c.e().e().b(), ar1.c.e().e().c());
        PointF pointf3 = new PointF(ar1.c.f().b().b(), ar1.c.f().b().c());
        PointF pointf4 = new PointF(ar1.c.d().c().b(), ar1.c.d().c().c());
        ar1 = new PointF(ar1.c.d().e().b(), ar1.c.d().e().c());
        RectF rectf = new RectF();
        rectf.left = pointf3.x;
        rectf.right = pointf.x;
        float f1;
        if (pointf4.y < pointf1.y)
        {
            f1 = pointf4.y;
        } else
        {
            f1 = pointf1.y;
        }
        rectf.top = f1;
        if (((PointF) (ar1)).y > pointf2.y)
        {
            f1 = ((PointF) (ar1)).y;
        } else
        {
            f1 = pointf2.y;
        }
        rectf.bottom = f1;
        return rectf;
    }

    private void e(float f1, float f2, float f3, Canvas canvas, com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.q q1)
    {
        Paint paint;
        com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints afeaturepoints[];
        paint = new Paint();
        paint.setStyle(android.graphics.Paint.Style.FILL);
        afeaturepoints = new com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints[8];
        afeaturepoints[0] = com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.T;
        afeaturepoints[1] = com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.V;
        afeaturepoints[2] = com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.U;
        afeaturepoints[3] = com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.W;
        afeaturepoints[4] = com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.P;
        afeaturepoints[5] = com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.R;
        afeaturepoints[6] = com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.Q;
        afeaturepoints[7] = com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.S;
        if (q1 == null || q1.k == null) goto _L2; else goto _L1
_L1:
        Map map = q1.k;
        map;
        JVM INSTR monitorenter ;
        int i1 = 0;
_L3:
        com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.o o1;
        if (i1 >= afeaturepoints.length)
        {
            break MISSING_BLOCK_LABEL_186;
        }
        o1 = (com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.o)q1.k.get(afeaturepoints[i1]);
        if (o1 == null)
        {
            break MISSING_BLOCK_LABEL_198;
        }
        if (o1.b)
        {
            a(canvas, paint, afeaturepoints[i1], f1, f2, q1, (Bitmap)k.get(afeaturepoints[i1]));
        }
        break MISSING_BLOCK_LABEL_198;
        map;
        JVM INSTR monitorexit ;
        return;
        canvas;
        map;
        JVM INSTR monitorexit ;
        throw canvas;
        i1++;
        if (true) goto _L3; else goto _L2
_L2:
    }

    private RectF f(ar ar1)
    {
        RectF rectf = new RectF(ar1.b.b(), ar1.b.c(), ar1.b.d(), ar1.b.e());
        if (!rectf.contains(ar1.c.l().b().b(), ar1.c.l().b().c()))
        {
            rectf.bottom = ar1.c.l().b().c();
        }
        return rectf;
    }

    private RectF getAccessoryCenterRect()
    {
        return new RectF(0.0F, 0.0F, m.e, m.f);
    }

    private RectF getHairCenterRect()
    {
        return new RectF(0.0F, 0.0F, m.e, m.f);
    }

    private static List s()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(BeautyMode.d);
        arraylist.add(BeautyMode.b);
        arraylist.add(BeautyMode.a);
        arraylist.add(BeautyMode.j);
        arraylist.add(BeautyMode.g);
        arraylist.add(BeautyMode.c);
        return arraylist;
    }

    private static Map t()
    {
        HashMap hashmap = new HashMap();
        hashmap.put(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeatureSets.a, FeaturePointsDef.a());
        hashmap.put(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeatureSets.b, FeaturePointsDef.b());
        hashmap.put(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeatureSets.c, FeaturePointsDef.c());
        hashmap.put(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeatureSets.d, FeaturePointsDef.d());
        hashmap.put(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeatureSets.e, FeaturePointsDef.e());
        hashmap.put(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeatureSets.f, FeaturePointsDef.f());
        hashmap.put(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeatureSets.g, FeaturePointsDef.g());
        hashmap.put(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeatureSets.h, FeaturePointsDef.i());
        hashmap.put(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeatureSets.i, FeaturePointsDef.j());
        hashmap.put(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeatureSets.j, FeaturePointsDef.c());
        hashmap.put(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeatureSets.k, FeaturePointsDef.h());
        hashmap.put(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeatureSets.l, FeaturePointsDef.c());
        return Collections.unmodifiableMap(hashmap);
    }

    private void u()
    {
        a("[initMemberVariable]");
        l = new ImageLoader(this);
        m = new com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.q(this);
        t = new com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.q(this);
        u = new com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.q(this);
        q = new Paint();
        StatusManager statusmanager = StatusManager.j();
        statusmanager.a(this);
        statusmanager.a(this);
        statusmanager.a(this);
        statusmanager.a(this);
        statusmanager.a(this);
        h();
        D = ValueAnimator.ofFloat(new float[] {
            0.0F, 1.0F
        });
        D.setDuration(W);
        D.setInterpolator(new LinearInterpolator());
        D.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() {

            final ImageViewer a;
            private com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.q b;

            public void onAnimationUpdate(ValueAnimator valueanimator)
            {
                float f1 = valueanimator.getAnimatedFraction();
                if (b != null && b.n != a.m.n)
                {
                    b = null;
                }
                if (b == null)
                {
                    b = new com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.q(a, a.m);
                }
                a.m.p = (int)(-255F * f1 + 255F);
                b.p = (int)(f1 * -255F + 255F);
                a.a(com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ImageLoader.BufferName.c, b);
            }

            
            {
                a = ImageViewer.this;
                super();
            }
        });
        D.addListener(new android.animation.Animator.AnimatorListener() {

            final ImageViewer a;
            private boolean b;

            public void onAnimationCancel(Animator animator)
            {
                b = true;
            }

            public void onAnimationEnd(Animator animator)
            {
                a.m.p = 255;
                if (b);
                a.a(com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ImageLoader.BufferName.c, new com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.q(a, a.m));
            }

            public void onAnimationRepeat(Animator animator)
            {
            }

            public void onAnimationStart(Animator animator)
            {
                b = false;
            }

            
            {
                a = ImageViewer.this;
                super();
                b = false;
            }
        });
        G = new Handler(getHandlerCallback());
    }

    private void v()
    {
        a((new StringBuilder()).append("resetNeighborImageID, this.mExtendedOptions.bDisableImageSwitchingMode = ").append(w.b).toString());
        com.cyberlink.youcammakeup.kernelctrl.ad ad1 = com.cyberlink.youcammakeup.kernelctrl.ad.a();
        if (w.b)
        {
            t.a(-1L);
            u.a(-1L);
            return;
        } else
        {
            t.a(ad1.c());
            u.a(ad1.b());
            return;
        }
    }

    private void w()
    {
        if (!w.d)
        {
            (new AsyncTask() {

                final ImageViewer a;

                protected transient Void a(Void avoid[])
                {
                    avoid = ViewEngine.a().a(a.m.a, 1.0D, null);
                    if (avoid != null)
                    {
                        Object obj = Globals.d();
                        if (((Globals) (obj)).n == a.m.a)
                        {
                            a.m.i = ((Globals) (obj)).o;
                            a.m.j = ((Globals) (obj)).p;
                        }
                        obj = com.cyberlink.youcammakeup.kernelctrl.t.a(avoid, StatusManager.j().I());
                        obj = new a(a.m.a, a.m.b, a.m.c, a.m.d, com.cyberlink.youcammakeup.kernelctrl.j.a(a.m.i), com.cyberlink.youcammakeup.kernelctrl.j.a(a.m.i), null, null, a.m.j, ((String) (obj)), new v(BeautyMode.D), "");
                        StatusManager.j().a(((a) (obj)), avoid);
                        avoid.m();
                    }
                    return null;
                }

                protected Object doInBackground(Object aobj[])
                {
                    return a((Void[])aobj);
                }

            
            {
                a = ImageViewer.this;
                super();
            }
            }).executeOnExecutor(M, new Void[0]);
        }
    }

    private void x()
    {
        Iterator iterator = m.k.entrySet().iterator();
_L7:
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
        class _cls5
        {

            static final int a[];
            static final int b[];

            static 
            {
                b = new int[com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.values().length];
                try
                {
                    b[com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.B.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror11) { }
                try
                {
                    b[com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.C.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror10) { }
                try
                {
                    b[com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.N.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror9) { }
                try
                {
                    b[com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.M.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                try
                {
                    b[com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.a.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    b[com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.f.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                a = new int[com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeatureSets.values().length];
                try
                {
                    a[com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeatureSets.d.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    a[com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeatureSets.k.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    a[com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeatureSets.g.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    a[com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeatureSets.f.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeatureSets.j.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeatureSets.l.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls5.b[((com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints)entry.getKey()).ordinal()];
        JVM INSTR tableswitch 1 6: default 92
    //                   1 117
    //                   2 117
    //                   3 117
    //                   4 117
    //                   5 117
    //                   6 117;
           goto _L3 _L4 _L4 _L4 _L4 _L4 _L4
_L3:
        Bitmap bitmap = f;
_L5:
        k.put(entry.getKey(), bitmap);
        continue; /* Loop/switch isn't completed */
_L4:
        bitmap = h;
        if (true) goto _L5; else goto _L2
_L2:
        return;
        if (true) goto _L7; else goto _L6
_L6:
    }

    private void y()
    {
        m.l = null;
        m.m = null;
        U = null;
        f = null;
        h = null;
        i = null;
        j = null;
        m.n = null;
        m.o = false;
        if (k != null)
        {
            k.clear();
        }
    }

    private void z()
    {
        if (U == null)
        {
            a("[restoreFaceData] cached data is null, abord restore function");
            return;
        }
        if (m == null || m.i == null)
        {
            a("[restoreFaceData] mInfo or faceList is null, abord restore function");
            return;
        } else
        {
            ar ar1 = (ar)m.i.get(m.j);
            ar1.c.a(U.c.d());
            ar1.c.b(U.c.e());
            ar1.c.a(U.c.j());
            ar1.c.a(U.c.k());
            ar1.c.a(U.c.h());
            ar1.c.b(U.c.i());
            ar1.c.a(U.c.l());
            ar1.c.a(U.c.f());
            ar1.c.b(U.c.g());
            ar1.c.a(U.c.b());
            ar1.c.b(U.c.c());
            ar1.c.a(U.c.m());
            return;
        }
    }

    protected float a(float f1)
    {
        float f3 = 0.0F;
        float f2 = f3;
        if (f1 == m.q.c)
        {
            f2 = f3;
            if (w.a == FitOption.b)
            {
                f1 = (float)m.f * m.q.c;
                f2 = f3;
                if (f1 > (float)o)
                {
                    f2 = (f1 - (float)o) / 3F;
                }
            }
        }
        return f2;
    }

    Matrix a(PointF pointf, float f1)
    {
        Matrix matrix = new Matrix();
        matrix.preTranslate(pointf.x, pointf.y);
        matrix.preScale(f1, f1);
        return matrix;
    }

    protected ac a(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints featurepoints, com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints featurepoints1, com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints featurepoints2, com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints featurepoints3, com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints featurepoints4)
    {
        ac ac1 = new ac();
        featurepoints = (PointF)m.l.get(featurepoints);
        ac1.f().a(((PointF) (featurepoints)).x);
        ac1.f().b(((PointF) (featurepoints)).y);
        featurepoints = (PointF)m.l.get(featurepoints1);
        ac1.b().a(((PointF) (featurepoints)).x);
        ac1.b().b(((PointF) (featurepoints)).y);
        featurepoints = (PointF)m.l.get(featurepoints2);
        ac1.d().a(((PointF) (featurepoints)).x);
        ac1.d().b(((PointF) (featurepoints)).y);
        featurepoints = (PointF)m.l.get(featurepoints3);
        ac1.c().a(((PointF) (featurepoints)).x);
        ac1.c().b(((PointF) (featurepoints)).y);
        featurepoints = (PointF)m.l.get(featurepoints4);
        ac1.e().a(((PointF) (featurepoints)).x);
        ac1.e().b(((PointF) (featurepoints)).y);
        return ac1;
    }

    protected com.cyberlink.youcammakeup.jniproxy.z a(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints featurepoints, com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints featurepoints1, com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints featurepoints2, com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints featurepoints3)
    {
        com.cyberlink.youcammakeup.jniproxy.z z1 = new com.cyberlink.youcammakeup.jniproxy.z();
        featurepoints = (PointF)m.l.get(featurepoints);
        z1.b().a(((PointF) (featurepoints)).x);
        z1.b().b(((PointF) (featurepoints)).y);
        featurepoints = (PointF)m.l.get(featurepoints1);
        z1.d().a(((PointF) (featurepoints)).x);
        z1.d().b(((PointF) (featurepoints)).y);
        featurepoints = (PointF)m.l.get(featurepoints2);
        z1.c().a(((PointF) (featurepoints)).x);
        z1.c().b(((PointF) (featurepoints)).y);
        featurepoints = (PointF)m.l.get(featurepoints3);
        z1.e().a(((PointF) (featurepoints)).x);
        z1.e().b(((PointF) (featurepoints)).y);
        return z1;
    }

    protected com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.c a(float f1, float f2)
    {
        float f4 = f1;
        float f3 = f2;
        if (m.h.k != 0)
        {
            f3 = m.h.g / 2;
            f4 = m.h.h / 2;
            float f5 = f1 - f3;
            float f6 = f4 - f2;
            f2 = -m.h.k;
            f1 = (float)((double)f5 * Math.cos(((double)f2 * 3.1415926535897931D) / 180D) + (double)f6 * Math.sin(((double)f2 * 3.1415926535897931D) / 180D));
            double d1 = -f5;
            double d2 = Math.sin(((double)f2 * 3.1415926535897931D) / 180D);
            f5 = (float)((double)f6 * Math.cos(((double)f2 * 3.1415926535897931D) / 180D) + d1 * d2);
            f6 = -f3;
            f6 = (float)((double)(-f3) * Math.cos(((double)f2 * 3.1415926535897931D) / 180D) + (double)f4 * Math.sin(((double)f2 * 3.1415926535897931D) / 180D));
            d1 = f3;
            d2 = Math.sin(((double)f2 * 3.1415926535897931D) / 180D);
            f2 = (float)((double)f4 * Math.cos(((double)f2 * 3.1415926535897931D) / 180D) + d1 * d2);
            f4 = f1 - f6;
            f3 = f2 - f5;
        }
        f1 = m.h.i;
        f2 = m.h.j;
        com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.c c1 = new com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.c();
        c1.a = f1 + f4;
        c1.b = f2 + f3;
        return c1;
    }

    public com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.c a(float f1, float f2, boolean flag)
    {
        Object obj;
label0:
        {
            a((new StringBuilder()).append("[viewSpaceToEngineUnitSpace] x: ").append(f1).append(" y:").append(f2).toString());
            float f9 = (float)n / 2.0F;
            float f3 = (float)o / 2.0F;
            double d1;
            float f4;
            float f5;
            float f6;
            float f7;
            float f8;
            float f10;
            float f11;
            float af1[];
            boolean flag1;
            if (flag)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            obj = new Matrix(m.q.e);
            af1 = new float[9];
            ((Matrix) (obj)).getValues(af1);
            f8 = af1[0];
            f7 = (float)m.e * f8;
            f6 = (float)m.f * f8;
            f10 = af1[2];
            f4 = af1[5];
            f11 = f7 / 2.0F;
            f5 = f6 / 2.0F;
            f1 = -(f9 - f1) - (f10 * f8 + f11);
            f4 = -(f3 - f2) - (f4 * f8 + f5);
            if (m.d != UIImageOrientation.c && m.d != UIImageOrientation.f)
            {
                f2 = f1;
                if (m.d != UIImageOrientation.h)
                {
                    break label0;
                }
            }
            f2 = -f1;
        }
        f3 = f4;
        if (m.d == UIImageOrientation.e)
        {
            f3 = -f4;
        }
        f1 = 0.0F;
        if (m.d == UIImageOrientation.g || m.d == UIImageOrientation.f)
        {
            f1 = 1.570796F;
        } else
        if (m.d == UIImageOrientation.d)
        {
            f1 = 3.141593F;
        } else
        if (m.d == UIImageOrientation.i || m.d == UIImageOrientation.h)
        {
            f1 = 4.712389F;
        }
        f5 = f2;
        f4 = f3;
        if (f1 != 0.0F)
        {
            f5 = (float)((double)f2 * Math.cos(-1F * f1));
            f9 = (float)((double)f3 * Math.sin(-1F * f1));
            f2 = (float)((double)f2 * Math.sin(-1F * f1));
            d1 = f3;
            f4 = (float)(Math.cos(-1F * f1) * d1) + f2;
            f7 = (float)m.b * f8;
            f6 = (float)m.c * f8;
            f5 -= f9;
        }
        f1 = f7 / 2.0F;
        f2 = f6 / 2.0F;
        f1 = (f5 + f1) / f8;
        f2 = (f4 + f2) / f8;
        obj = new com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.c();
        obj.a = f1 / (float)m.b;
        obj.b = f2 / (float)m.c;
        if (m.h.b && flag1)
        {
            if (f1 < 0.0F || f1 > (float)m.b || f2 < 0.0F || f2 > (float)m.c)
            {
                obj.a = (0.0F / 0.0F);
                obj.b = (0.0F / 0.0F);
            } else
            {
                com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.c c1 = a(f1, f2);
                f1 = c1.a;
                f2 = c1.b;
                obj.a = f1 / (float)m.h.c;
                obj.b = f2 / (float)m.h.d;
            }
        }
        a((new StringBuilder()).append("[viewSpaceToEngineUnitSpace] engine unit x: ").append(((com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.c) (obj)).a).append(" engine unit y:").append(((com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.c) (obj)).b).toString());
        return ((com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.c) (obj));
    }

    protected com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.u a(com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.q q1)
    {
        a("[calculateMinScale]");
        float f1 = (float)n / (float)q1.e;
        float f2 = (float)o / (float)q1.f;
        q1 = new com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.u();
        if (w.a == FitOption.b)
        {
            f1 = Math.max(f1, f2);
            q1.a = f1;
            q1.b = Math.max(f1, d);
            return q1;
        } else
        {
            f1 = Math.min(f1, f2);
            q1.a = f1;
            q1.b = Math.max(f1, d);
            return q1;
        }
    }

    protected void a(int i1, int j1)
    {
    }

    public void a(long l1)
    {
        a((new StringBuilder()).append("[resetViewerInfo] old imageID = ").append(m.a).append(" ,new imageID= ").append(l1).toString());
        m.a(l1);
        l.b();
    }

    protected void a(long l1, com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.q q1)
    {
        DevelopSetting developsetting = l.a(l1);
        q1.g = developsetting;
        com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.g g1 = new com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.g();
        if (com.cyberlink.youcammakeup.kernelctrl.viewengine.i.a(l1))
        {
            ImageBufferWrapper imagebufferwrapper = ViewEngine.a().a(l1, 1.0D, null);
            if (imagebufferwrapper == null)
            {
                return;
            }
            g1.a = (int)imagebufferwrapper.b();
            g1.b = (int)imagebufferwrapper.c();
            g1.c = UIImageOrientation.b;
        } else
        {
            l.a(l1, g1);
        }
        a((new StringBuilder()).append("Get ImageInfo success image width: ").append(g1.a).append(" image height: ").append(g1.b).toString());
        a(q1, g1, developsetting);
    }

    public void a(long l1, Object obj, UUID uuid)
    {
        if (l1 != m.a && uuid != PanZoomViewer.L)
        {
            b(l1);
            if ((uuid == Camera.a || uuid == EditViewActivity.a) && l1 != -1L)
            {
                f();
            }
        }
    }

    protected void a(Canvas canvas, com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.q q1)
    {
        Object obj = com.cyberlink.youcammakeup.widgetpool.wigpreviewview.c.h();
        ((c) (obj)).a(q1.q);
        obj = ((c) (obj)).n();
        if (obj != null)
        {
            canvas.save();
            canvas.translate((float)(-getWidth()) / 2.0F, (float)(-getHeight()) / 2.0F);
            ((WigView) (obj)).a(canvas, q1.q);
            canvas.restore();
        }
    }

    protected void a(PointF pointf, PointF pointf1, PointF pointf2, PointF pointf3, ar ar1)
    {
        ab ab1 = new ab();
        ab1.b().a(pointf.x);
        ab1.b().b(pointf.y);
        ab1.c().a(pointf1.x);
        ab1.c().b(pointf1.y);
        ar1.c.a(ab1);
        pointf = new ab();
        pointf.b().a(pointf2.x);
        pointf.b().b(pointf2.y);
        pointf.c().a(pointf3.x);
        pointf.c().b(pointf3.y);
        ar1.c.b(pointf);
    }

    protected void a(PointF pointf, PointF pointf1, PointF pointf2, ar ar1)
    {
        com.cyberlink.youcammakeup.jniproxy.ad ad1 = new com.cyberlink.youcammakeup.jniproxy.ad();
        ad1.b().a(pointf.x);
        ad1.b().b(pointf.y);
        ad1.c().a(pointf1.x);
        ad1.c().b(pointf1.y);
        ad1.d().a(pointf2.x);
        ad1.d().b(pointf2.y);
        ar1.c.a(ad1);
    }

    protected void a(PointF pointf, PointF pointf1, ar ar1)
    {
        com.cyberlink.youcammakeup.jniproxy.ak ak1 = new com.cyberlink.youcammakeup.jniproxy.ak();
        ak1.b().a(pointf.x);
        ak1.b().b(pointf.y);
        ak1.c().a(pointf1.x);
        ak1.c().b(pointf1.y);
        ar1.c.a(ak1);
    }

    protected void a(PointF pointf, ar ar1)
    {
        aa aa1 = new aa();
        aa1.b().a(pointf.x);
        aa1.b().b(pointf.y);
        ar1.c.a(aa1);
    }

    public void a(HairDyeBrushHandler hairdyebrushhandler, com.cyberlink.youcammakeup.kernelctrl.ah ah1, n n1)
    {
        w = n1;
        s = hairdyebrushhandler;
        if (s != null)
        {
            s.a(this);
        }
        S = ah1;
        S.a(this);
        l.a(hairdyebrushhandler, ah1, n1);
    }

    protected void a(ar ar1)
    {
        com.cyberlink.youcammakeup.jniproxy.ag ag1 = ar1.c.j();
        PointF pointf = (PointF)m.l.get(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.k);
        ag1.c().a(pointf.x);
        ag1.c().b(pointf.y);
        pointf = (PointF)m.l.get(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.m);
        ag1.e().a(pointf.x);
        ag1.e().b(pointf.y);
        pointf = (PointF)m.l.get(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.n);
        ag1.b().a(pointf.x);
        ag1.b().b(pointf.y);
        pointf = (PointF)m.l.get(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.l);
        ag1.d().a(pointf.x);
        ag1.d().b(pointf.y);
        pointf = (PointF)m.l.get(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.o);
        ag1.f().a(pointf.x);
        ag1.f().b(pointf.y);
        ar1.c.a(ag1);
    }

    public void a(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeatureSets featuresets)
    {
        Object obj;
        if (m.j == -1)
        {
            a("Current face index is unknown, no need to calculate new transform");
            return;
        }
        if (m.i == null || m.i.isEmpty())
        {
            a("Face list is null or empty, no need to calculate new transform");
            return;
        }
        obj = new ArrayList();
        ((List) (obj)).add(m.i.get(m.j));
        obj = (ar)VenusHelper.a(m.b, m.c, ((List) (obj)), m.d).get(0);
        com.cyberlink.youcammakeup.kernelctrl.panzoomviewer._cls5.a[featuresets.ordinal()];
        JVM INSTR tableswitch 1 6: default 172
    //                   1 193
    //                   2 204
    //                   3 215
    //                   4 226
    //                   5 237
    //                   6 246;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L1:
        obj = f(((ar) (obj)));
_L9:
        if (obj == null)
        {
            a("Calculate bounding rectangle for beautifier is failed, abort new transform calculation");
            return;
        }
        break; /* Loop/switch isn't completed */
_L2:
        obj = d(((ar) (obj)));
        continue; /* Loop/switch isn't completed */
_L3:
        obj = f(((ar) (obj)));
        continue; /* Loop/switch isn't completed */
_L4:
        obj = e(((ar) (obj)));
        continue; /* Loop/switch isn't completed */
_L5:
        obj = c(((ar) (obj)));
        continue; /* Loop/switch isn't completed */
_L6:
        obj = getHairCenterRect();
        continue; /* Loop/switch isn't completed */
_L7:
        obj = getAccessoryCenterRect();
        if (true) goto _L9; else goto _L8
_L8:
        float af1[] = new float[9];
        m.q.e.getValues(af1);
        float f1 = 1.2F;
        if (featuresets == com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeatureSets.d || featuresets == com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeatureSets.g)
        {
            f1 = 1.35F;
        }
        if (featuresets == com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeatureSets.f)
        {
            f1 = 2.25F;
        }
        float f3 = ((RectF) (obj)).width() * m.q.c * f1;
        f1 *= ((RectF) (obj)).height() * m.q.c;
        float f5 = n;
        float f6 = (f5 * f1) / f3;
        f1 = Math.max(Math.min(Math.min((f5 / f3) * m.q.c, m.q.b), Math.min((f6 / f1) * m.q.c, m.q.b)), m.q.c);
        f3 = ((RectF) (obj)).left;
        f5 = ((RectF) (obj)).width() / 2.0F;
        f6 = ((RectF) (obj)).top;
        featuresets = new PointF(f3 + f5, ((RectF) (obj)).height() / 2.0F + f6);
        f3 = (float)m.e / 2.0F;
        f5 = ((PointF) (featuresets)).x;
        f6 = (float)m.f / 2.0F;
        float f7 = ((PointF) (featuresets)).y;
        if (f1 > m.q.c)
        {
            m.q.e = new Matrix();
            float f8 = (float)(-m.e) / 2.0F;
            float f9 = (float)(-m.f) / 2.0F;
            m.q.e.preTranslate((f3 - f5) + f8, (f6 - f7) + f9);
            m.q.e.preScale(f1, f1);
            f3 = a(m.q.e);
            f5 = b(m.q.e);
            if (f3 != 0.0F || f5 != 0.0F)
            {
                m.q.e.preScale(1.0F / (f1 * f1), 1.0F / (f1 * f1));
                m.q.e.preTranslate(f3, f5);
                m.q.e.preScale(f1 * f1, f1 * f1);
            }
            featuresets = new float[9];
            m.q.e.getValues(featuresets);
            m.q.d = featuresets[0];
            m.q.f = b(m);
            m.q.a = false;
            return;
        } else
        {
            m.q.e = new Matrix();
            float f2 = (float)(-m.e) / 2.0F;
            float f4 = (float)(-m.f) / 2.0F;
            m.q.e.preTranslate(f2, f4);
            m.q.e.preScale(m.q.c, m.q.c);
            featuresets = new float[9];
            m.q.e.getValues(featuresets);
            m.q.d = featuresets[0];
            m.q.f = b(m);
            m.q.a = true;
            return;
        }
    }

    public void a(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeatureSets featuresets, SessionState sessionstate)
    {
        a(featuresets, false, sessionstate);
    }

    public void a(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeatureSets featuresets, boolean flag, SessionState sessionstate)
    {
        while (sessionstate == null || sessionstate.a().e == -1 || m == null || m.i == null || featuresets == null) 
        {
            return;
        }
        y();
        a(sessionstate);
        setDisplayFeaturePts(Boolean.valueOf(true));
        if (featuresets == com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeatureSets.c || featuresets == com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeatureSets.j || featuresets == com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeatureSets.l)
        {
            setDisplayFeaturePts(Boolean.valueOf(false));
        }
        m.n = featuresets;
        if (flag)
        {
            a(b(featuresets));
        }
        l();
        m();
        n();
        featuresets = new android.graphics.BitmapFactory.Options();
        featuresets.inScaled = true;
        featuresets.inDensity = 480;
        featuresets.inTargetDensity = (int)(getResources().getDisplayMetrics().density * 160F);
        f = Globals.d().x();
        g = f;
        h = Globals.d().y();
        i = Globals.d().z();
        j = Globals.d().A();
        U = new ar((ar)m.i.get(m.j));
        k = new HashMap();
        if (m.k != null)
        {
            x();
        }
        aa = Boolean.valueOf(false);
    }

    public void a(ImageLoader.BufferName buffername, f f1)
    {
        DevelopSetting developsetting = l.a(m.a);
        m.g = developsetting;
        b(buffername, f1);
    }

    protected void a(ImageLoader.BufferName buffername, com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.q q1)
    {
        com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.v v1 = com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.v.a();
        v1.put(1, buffername);
        v1.put(2, q1);
        buffername = Message.obtain(G, 1, v1);
        G.sendMessage(buffername);
    }

    public void a(ImageLoader.BufferName buffername, Long long1)
    {
        if (buffername == com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ImageLoader.BufferName.c)
        {
            a("curView is rendered. It indicates source buffer is ready. Now init session info.");
            StatusManager.j().b(this);
            w();
            Globals.d().i().h(getContext());
        }
    }

    protected void a(com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.q q1, com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.g g1, DevelopSetting developsetting)
    {
        a("[initImageInfo]");
        if (b(q1, g1, developsetting) && x)
        {
            g1.a = q1.h.g;
            g1.b = q1.h.h;
        }
        int i1 = g1.a;
        int j1 = g1.b;
        g1 = g1.c;
        q1.b = i1;
        q1.c = j1;
        q1.d = g1;
        float f1;
        float f2;
        float f3;
        if (g1 == UIImageOrientation.g || g1 == UIImageOrientation.i || g1 == UIImageOrientation.f || g1 == UIImageOrientation.h)
        {
            q1.e = j1;
            q1.f = i1;
        } else
        {
            q1.e = i1;
            q1.f = j1;
        }
        a((new StringBuilder()).append("info imageWidth: ").append(q1.b).append(" imageHeight: ").append(q1.c).toString());
        a((new StringBuilder()).append("info rotatedImageWidth: ").append(q1.e).append(" rotatedImageHeight: ").append(q1.f).toString());
        g1 = a(q1);
        a((new StringBuilder()).append("minScale: ").append(((com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.u) (g1)).a).toString());
        a((new StringBuilder()).append("maxScale: ").append(((com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.u) (g1)).b).toString());
        q1.q.c = ((com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.u) (g1)).a;
        q1.q.b = ((com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.u) (g1)).b;
        q1.q.e = new Matrix();
        f1 = (float)(-q1.e) / 2.0F;
        f2 = (float)(-q1.f) / 2.0F;
        f3 = a(q1.q.c) / q1.q.c;
        q1.q.e.preTranslate(f1, f2 + f3);
        q1.q.e.preScale(((com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.u) (g1)).a, ((com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.u) (g1)).a);
        g1 = new float[9];
        q1.q.e.getValues(g1);
        q1.q.d = g1[0];
        q1.q.f = b(q1);
        q1.q.a = true;
    }

    public void a(ImageStateChangedEvent imagestatechangedevent)
    {
        a(imagestatechangedevent.a(), imagestatechangedevent.b());
    }

    public void a(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.MotionName motionname, boolean flag)
    {
        if (motionname == com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.MotionName.a && B.booleanValue())
        {
            motionname = MotionControlHelper.e().f();
            if (motionname != null)
            {
                a(((Boolean) (motionname)), m.o);
                motionname = new f();
                motionname.a = true;
                b(com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ImageLoader.BufferName.c, motionname);
            }
        }
    }

    protected void a(Boolean boolean1, ar ar1)
    {
        if (boolean1.booleanValue())
        {
            boolean1 = a(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.a, com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.b, com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.d, com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.c, com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.e);
            ar1.c.a(boolean1);
            return;
        } else
        {
            boolean1 = a(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.f, com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.g, com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.i, com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.h, com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.j);
            ar1.c.b(boolean1);
            return;
        }
    }

    public void a(boolean flag)
    {
        setDisplayFeaturePts(Boolean.valueOf(false));
        if (flag)
        {
            z();
        }
        y();
    }

    protected boolean a(Canvas canvas, ImageLoader.BufferName buffername, com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.q q1)
    {
label0:
        {
            synchronized (l.g)
            {
                if (l.b.containsKey(buffername))
                {
                    break label0;
                }
                a((new StringBuilder()).append("offScreen Canvas didn't contain buffer with bufferName: ").append(buffername.toString()).append(" cancel render task").toString());
            }
            return false;
        }
        com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.i i1 = (com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.i)l.b.get(buffername);
        if (i1 == null)
        {
            break MISSING_BLOCK_LABEL_93;
        }
        if (i1.a != null)
        {
            break MISSING_BLOCK_LABEL_111;
        }
        a("offCanvas bitmap is null, cancel this drawing task");
        obj;
        JVM INSTR monitorexit ;
        return false;
        canvas;
        obj;
        JVM INSTR monitorexit ;
        throw canvas;
        Long long1;
        RectF rectf;
        long1 = i1.e;
        rectf = new RectF();
        if (q1.q.e != null)
        {
            break MISSING_BLOCK_LABEL_149;
        }
        a("current transform matrix is null, return!!");
        obj;
        JVM INSTR monitorexit ;
        return false;
        float af1[];
        int j1;
        int k1;
        j1 = getWidth();
        k1 = getHeight();
        af1 = new float[9];
        q1.q.e.getValues(af1);
        float f3;
        float f4;
        float f5;
        f5 = af1[0];
        f4 = af1[2] * f5;
        f3 = af1[5] * f5;
        float f1;
        float f2;
        f2 = (float)m.e * f5;
        f1 = (float)m.f * f5;
        if (buffername != com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ImageLoader.BufferName.c) goto _L2; else goto _L1
_L1:
        Object obj1;
        obj1 = q1.q.f;
        f1 = m.e;
        f2 = m.f;
        if (f1 * f5 <= (float)j1) goto _L4; else goto _L3
_L3:
        if (((w) (obj1)).c() >= (float)j1) goto _L4; else goto _L5
_L5:
        if (((w) (obj1)).a() <= 0.0F) goto _L7; else goto _L6
_L6:
        f1 = -j1 / 2;
_L15:
        if (f2 * f5 <= (float)k1) goto _L9; else goto _L8
_L8:
        if (((w) (obj1)).d() >= (float)k1) goto _L9; else goto _L10
_L10:
        if (((w) (obj1)).b() <= 0.0F) goto _L12; else goto _L11
_L11:
        f2 = -k1 / 2;
_L16:
        float f6;
        f6 = ((w) (obj1)).c();
        f5 = ((w) (obj1)).d();
        f4 = f1;
        f3 = f2;
        f2 = f6;
        f1 = f5;
_L2:
        rectf.left = f4;
        rectf.top = f3;
        rectf.right = f2 + f4;
        rectf.bottom = f1 + f3;
        if (com.cyberlink.youcammakeup.utility.aa.b(r))
        {
            if (q.getXfermode() != a)
            {
                q.setXfermode(a);
            }
            obj1 = new Canvas();
            ((Canvas) (obj1)).setBitmap(r);
            ((Canvas) (obj1)).drawColor(0xff000000, android.graphics.PorterDuff.Mode.SRC_IN);
            ((Canvas) (obj1)).translate((float)j1 / 2.0F, (float)k1 / 2.0F);
            ((Canvas) (obj1)).drawBitmap(i1.a, null, rectf, q);
            ((Canvas) (obj1)).setBitmap(null);
            canvas.drawBitmap(r, 0.0F, 0.0F, null);
        }
        canvas.translate((float)j1 / 2.0F, (float)k1 / 2.0F);
        q.setFilterBitmap(true);
        if (!com.cyberlink.youcammakeup.utility.aa.b(r)) goto _L14; else goto _L13
_L13:
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
        }
        obj;
        JVM INSTR monitorexit ;
        if (!T)
        {
            StatusManager.j().a(buffername, long1);
        }
        return true;
_L7:
        int l1 = -j1;
        f1 = (float)(l1 / 2) + ((float)j1 - ((w) (obj1)).c());
          goto _L15
_L4:
        f1 = -((w) (obj1)).c() / 2.0F;
          goto _L15
_L12:
        f2 = (float)(-k1 / 2) + ((float)k1 - ((w) (obj1)).d());
          goto _L16
_L9:
        f2 = -((w) (obj1)).d() / 2.0F;
          goto _L16
_L14:
        if (i1.a == null) goto _L13; else goto _L17
_L17:
        canvas.drawBitmap(i1.a, null, rectf, q);
          goto _L13
    }

    Matrix b(PointF pointf, float f1)
    {
        return a(new PointF(-pointf.x, -pointf.y), f1);
    }

    public com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeatureSets b(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeatureSets featuresets)
    {
        com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeatureSets featuresets1 = featuresets;
        if (StatusManager.j().r() == MakeupMode.a)
        {
            com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.i i1 = StatusManager.j().d();
            featuresets1 = featuresets;
            if (i1 != null)
            {
                featuresets1 = featuresets;
                if (i1.u() != null)
                {
                    featuresets1 = featuresets;
                    if (i1.u().b() != null)
                    {
                        featuresets1 = featuresets;
                        if (!i1.u().b().equals("default_original_wig"))
                        {
                            featuresets1 = com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeatureSets.j;
                        }
                    }
                }
            }
        }
        return featuresets1;
    }

    protected b b(float f1, float f2)
    {
        float f8 = m.h.i;
        float f7 = m.h.j;
        float f6 = f7;
        float f5 = f8;
        float f4 = f1;
        float f3 = f2;
        if (m.h.k != 0)
        {
            f6 = m.h.c / 2;
            f5 = m.h.d / 2;
            f3 = f1 - f6;
            f2 = f5 - f2;
            f1 = m.h.k;
            f4 = (float)((double)f3 * Math.cos(((double)f1 * 3.1415926535897931D) / 180D) + (double)f2 * Math.sin(((double)f1 * 3.1415926535897931D) / 180D));
            double d1 = -f3;
            double d2 = Math.sin(((double)f1 * 3.1415926535897931D) / 180D);
            f3 = (float)((double)f2 * Math.cos(((double)f1 * 3.1415926535897931D) / 180D) + d1 * d2);
            f2 = f8 - f6;
            f6 = f5 - f7;
            f5 = (float)((double)f2 * Math.cos(((double)f1 * 3.1415926535897931D) / 180D) + (double)f6 * Math.sin(((double)f1 * 3.1415926535897931D) / 180D));
            f6 = (float)((double)(-f2) * Math.sin(((double)f1 * 3.1415926535897931D) / 180D) + (double)f6 * Math.cos(((double)f1 * 3.1415926535897931D) / 180D));
        }
        b b1 = new b();
        b1.a = f4 - f5;
        b1.b = f6 - f3;
        return b1;
    }

    public d b(float f1, float f2, boolean flag)
    {
label0:
        {
            a((new StringBuilder()).append("[engineUnitSpaceToViewSpace] unitX: ").append(f1).append(" unitY:").append(f2).toString());
            float f3;
            float f4;
            float f5;
            float f6;
            float f7;
            float f8;
            float f10;
            Object obj;
            float af1[];
            boolean flag1;
            if (flag)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            obj = new Matrix(m.q.e);
            af1 = new float[9];
            ((Matrix) (obj)).getValues(af1);
            f4 = af1[0];
            f8 = m.e;
            f7 = m.f;
            f5 = af1[2];
            f6 = af1[5];
            if (m.h.b && flag1)
            {
                obj = b((float)m.h.c * f1, m.h.d);
                f3 = ((b) (obj)).a;
                f2 = ((b) (obj)).b;
            } else
            {
                f3 = f1 * (float)m.b;
                f2 = (float)m.c * f2;
            }
            f1 = 0.0F;
            if (m.d == UIImageOrientation.g || m.d == UIImageOrientation.f)
            {
                f1 = 1.570796F;
            } else
            if (m.d == UIImageOrientation.d)
            {
                f1 = 3.141593F;
            } else
            if (m.d == UIImageOrientation.i || m.d == UIImageOrientation.h)
            {
                f1 = 4.712389F;
            }
            f3 = f3 * f4 - ((float)m.b * f4) / 2.0F;
            f2 = f2 * f4 - ((float)m.c * f4) / 2.0F;
            if (f1 != 0.0F)
            {
                float f9 = (float)((double)f3 * Math.cos(f1));
                float f11 = (float)((double)f2 * Math.sin(f1));
                f3 = (float)((double)f3 * Math.sin(f1));
                double d1 = f2;
                f1 = (float)(Math.cos(f1) * d1) + f3;
                f2 = f9 - f11;
            } else
            {
                f1 = f2;
                f2 = f3;
            }
            if (m.d != UIImageOrientation.c && m.d != UIImageOrientation.f)
            {
                f3 = f2;
                if (m.d != UIImageOrientation.h)
                {
                    break label0;
                }
            }
            f3 = -f2;
        }
        f2 = f1;
        if (m.d == UIImageOrientation.e)
        {
            f2 = -f1;
        }
        f1 = (f8 * f4) / 2.0F;
        f7 = (f7 * f4) / 2.0F;
        f8 = (float)n / 2.0F;
        f10 = (float)o / 2.0F;
        obj = new d();
        obj.a = f3 + (f1 + f5 * f4) + f8;
        obj.b = f2 + (f7 + f6 * f4) + f10;
        a((new StringBuilder()).append("[engineUnitSpaceToViewSpace] viewSpaceX: ").append(((d) (obj)).a).append(" viewSpaceY:").append(((d) (obj)).b).toString());
        return ((d) (obj));
    }

    protected w b(com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.q q1)
    {
        a("[calculateCurViewRoi]");
        q1 = new Matrix(m.q.e);
        float af1[] = new float[9];
        q1.getValues(af1);
        float f1 = (float)m.e * af1[0];
        float f2 = (float)m.f * af1[0];
        float f3 = af1[2] * af1[0];
        float f4 = af1[5];
        f4 = af1[0] * f4;
        float f5 = (float)getWidth() / 2.0F;
        float f6 = (float)getHeight() / 2.0F;
        q1 = new w(0.0F, 0.0F, f1, f2);
        if (f3 < -f5)
        {
            q1.a(-f3 - f5);
            q1.c(q1.c() - (-f3 - f5));
        }
        if (f3 + f1 > f5)
        {
            q1.c(q1.c() - ((f1 + f3) - f5));
        }
        if (f4 < -f6)
        {
            q1.b(-f4 - f6);
            q1.d(q1.d() - (-f4 - f6));
        }
        if (f4 + f2 > f6)
        {
            q1.d(q1.d() - ((f4 + f2) - f6));
        }
        a((new StringBuilder()).append("CurView ROI value, left: ").append(q1.a()).append(" top: ").append(q1.b()).append(" width: ").append(q1.c()).append(" height: ").append(q1.d()).toString());
        return q1;
    }

    public Boolean b()
    {
        return Boolean.valueOf(true);
    }

    public void b(long l1)
    {
        a(l1);
        v();
        com.cyberlink.youcammakeup.kernelctrl.ad ad1 = com.cyberlink.youcammakeup.kernelctrl.ad.a();
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("[resetInfo] imageId: ");
        stringbuilder.append(l1);
        stringbuilder.append(", prev: ");
        stringbuilder.append(ad1.c());
        stringbuilder.append(", next: ");
        stringbuilder.append(ad1.b());
        a(stringbuilder.toString());
    }

    public void b(Canvas canvas, ImageLoader.BufferName buffername, com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.q q1)
    {
        if (q1.k != null && k != null)
        {
            float f1 = q1.q.d;
            buffername = new float[9];
            q1.q.e.getValues(buffername);
            float f2 = buffername[2] * f1;
            float f3 = buffername[5] * f1;
            buffername = new Paint();
            buffername.setStyle(android.graphics.Paint.Style.FILL);
            if (q1.k != null)
            {
                a(f2, f3, f1, canvas, q1);
                com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.o o1 = (com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.o)q1.k.get(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.t);
                if (o1 != null && o1.b)
                {
                    b(canvas, ((Paint) (buffername)), com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.t, f2, f3, q1, f);
                }
                o1 = (com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.o)q1.k.get(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.v);
                if (o1 != null && o1.b)
                {
                    b(canvas, ((Paint) (buffername)), com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.v, f2, f3, q1, f);
                }
                o1 = (com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.o)q1.k.get(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.u);
                if (o1 != null && o1.b)
                {
                    b(canvas, ((Paint) (buffername)), com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.u, f2, f3, q1, f);
                }
                o1 = (com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.o)q1.k.get(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.w);
                if (o1 != null && o1.b)
                {
                    b(canvas, ((Paint) (buffername)), com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.w, f2, f3, q1, f);
                }
                b(f2, f3, f1, canvas, q1);
                o1 = (com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.o)q1.k.get(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.p);
                if (o1 != null && o1.b)
                {
                    a(canvas, buffername, com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.p, f2, f3, q1, f);
                }
                o1 = (com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.o)q1.k.get(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.q);
                if (o1 != null && o1.b)
                {
                    a(canvas, buffername, com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.q, f2, f3, q1, f);
                }
                o1 = (com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.o)q1.k.get(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.r);
                if (o1 != null && o1.b)
                {
                    a(canvas, buffername, com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.r, f2, f3, q1, f);
                }
                o1 = (com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.o)q1.k.get(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.s);
                if (o1 != null && o1.b)
                {
                    a(canvas, buffername, com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.s, f2, f3, q1, f);
                }
                o1 = (com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.o)q1.k.get(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.x);
                if (o1 != null && o1.b)
                {
                    a(canvas, buffername, com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.x, f2, f3, q1, f);
                }
                c(f2, f3, f1, canvas, q1);
                e(f2, f3, f1, canvas, q1);
                d(f2, f3, f1, canvas, q1);
                return;
            }
        }
    }

    protected void b(Canvas canvas, com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.q q1)
    {
        AccessoryDrawingCtrl.a(q1.q);
        AccessoryView accessoryview = AccessoryDrawingCtrl.m();
        if (accessoryview != null)
        {
            canvas.save();
            canvas.translate((float)(-getWidth()) / 2.0F, (float)(-getHeight()) / 2.0F);
            accessoryview.a(canvas, q1.q);
            canvas.restore();
        }
    }

    protected void b(PointF pointf, PointF pointf1, ar ar1)
    {
        com.cyberlink.youcammakeup.jniproxy.ak ak1 = new com.cyberlink.youcammakeup.jniproxy.ak();
        ak1.b().a(pointf.x);
        ak1.b().b(pointf.y);
        ak1.c().a(pointf1.x);
        ak1.c().b(pointf1.y);
        ar1.c.b(ak1);
    }

    protected void b(ar ar1)
    {
        com.cyberlink.youcammakeup.jniproxy.af af1 = ar1.c.k();
        PointF pointf = (PointF)m.l.get(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.y);
        af1.b().a(pointf.x);
        af1.b().b(pointf.y);
        pointf = (PointF)m.l.get(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.z);
        af1.e().a(pointf.x);
        af1.e().b(pointf.y);
        pointf = (PointF)m.l.get(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.A);
        af1.c().a(pointf.x);
        af1.c().b(pointf.y);
        pointf = (PointF)m.l.get(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.E);
        af1.h().a(pointf.x);
        af1.h().b(pointf.y);
        pointf = (PointF)m.l.get(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.F);
        af1.i().a(pointf.x);
        af1.i().b(pointf.y);
        pointf = (PointF)m.l.get(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.G);
        af1.j().a(pointf.x);
        af1.j().b(pointf.y);
        pointf = (PointF)m.l.get(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.H);
        af1.k().a(pointf.x);
        af1.k().b(pointf.y);
        pointf = (PointF)m.l.get(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.B);
        af1.d().a(pointf.x);
        af1.d().b(pointf.y);
        pointf = (PointF)m.l.get(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.C);
        af1.f().a(pointf.x);
        af1.f().b(pointf.y);
        pointf = (PointF)m.l.get(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.D);
        af1.g().a(pointf.x);
        af1.g().b(pointf.y);
        pointf = (PointF)m.l.get(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.I);
        af1.q().a(pointf.x);
        af1.q().b(pointf.y);
        pointf = (PointF)m.l.get(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.J);
        af1.p().a(pointf.x);
        af1.p().b(pointf.y);
        pointf = (PointF)m.l.get(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.K);
        af1.o().a(pointf.x);
        af1.o().b(pointf.y);
        pointf = (PointF)m.l.get(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.L);
        af1.n().a(pointf.x);
        af1.n().b(pointf.y);
        pointf = (PointF)m.l.get(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.M);
        af1.m().a(pointf.x);
        af1.m().b(pointf.y);
        pointf = (PointF)m.l.get(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.N);
        af1.l().a(pointf.x);
        af1.l().b(pointf.y);
        ar1.c.a(af1);
    }

    public void b(ImageLoader.BufferName buffername, f f1)
    {
        float f3 = 0.0F;
        a((new StringBuilder()).append("[requestImage] imageID= ").append(m.a).toString());
        long l1 = m.a;
        Object obj = l.a(l1);
        if (obj == null)
        {
            return;
        }
        if (!m.h.b && ((DevelopSetting) (obj)).containsKey("global") && ((CmdSetting)((DevelopSetting) (obj)).get("global")).containsKey(Integer.valueOf(7)))
        {
            com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.g g1 = new com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.g();
            l.a(l1, g1);
            a(m, g1, ((DevelopSetting) (obj)));
        }
        if (m.h.a == m.a)
        {
            a(((DevelopSetting) (obj)));
        }
        if (s != null)
        {
            s.a(m.b, m.c);
        }
        obj = m;
        com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.q q1;
        if (buffername == com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ImageLoader.BufferName.c || ImageLoader.BufferName.d == buffername || com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ImageLoader.BufferName.e == buffername)
        {
            if (ImageLoader.BufferName.d == buffername)
            {
                obj = t;
                ((com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.q) (obj)).s.b = e(((com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.q) (obj)));
            }
            if (com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ImageLoader.BufferName.e == buffername)
            {
                obj = u;
                ((com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.q) (obj)).s.b = e(((com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.q) (obj)));
            }
            q1 = ((com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.q) (obj));
            if (((com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.q) (obj)).q.f == null)
            {
                float f4 = (float)((com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.q) (obj)).e * ((com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.q) (obj)).q.d;
                float f5 = (float)((com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.q) (obj)).f * ((com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.q) (obj)).q.d;
                class a
                    implements h
                {

                    final ImageViewer a;
                    private ImageLoader.BufferName b;
                    private com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.q c;
                    private f d;

                    public void a()
                    {
                        com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ImageViewer.a(a, (new StringBuilder()).append("get image buffer from ViewEngine, buffer name is ").append(b.toString()).append(" bDisplay: ").append(d.a).toString());
                        if (d.a)
                        {
                            a.a(b, c);
                        }
                    }

                    public void a(Exception exception)
                    {
                        com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ImageViewer.a(a, (new StringBuilder()).append("request image buffer failed, reason: ").append(exception.getMessage()).toString());
                    }

            public a(ImageLoader.BufferName buffername, com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.q q1, f f1)
            {
                a = ImageViewer.this;
                super();
                b = null;
                c = null;
                d = null;
                b = buffername;
                c = q1;
                d = f1;
            }
                }

                if (w.a == com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.FitOption.a)
                {
                    ((com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.q) (obj)).q.f = new w(0.0F, 0.0F, f4, f5);
                } else
                {
                    float f7 = n;
                    float f6 = o;
                    float f2;
                    if (f4 < f7)
                    {
                        f2 = 0.0F;
                    } else
                    {
                        f2 = (f4 - f7) / 2.0F;
                    }
                    if (f5 >= f6)
                    {
                        f3 = (f5 - f6) / 2.0F;
                    }
                    if (f4 >= f7)
                    {
                        f4 = f7;
                    }
                    if (f5 >= f6)
                    {
                        f5 = f6;
                    }
                    ((com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.q) (obj)).q.f = new w(f2, f3, f4, f5);
                }
                a((new StringBuilder()).append("CurView ROI value, left: ").append(((com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.q) (obj)).q.f.a()).append(" top: ").append(((com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.q) (obj)).q.f.b()).append(" width: ").append(((com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.q) (obj)).q.f.c()).append(" height: ").append(((com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.q) (obj)).q.f.d()).toString());
                q1 = ((com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.q) (obj));
            }
        } else
        if (buffername == ImageLoader.BufferName.b)
        {
            ((com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.q) (obj)).r.b = Math.min(1.0F, ((com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.q) (obj)).q.c * ((com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.q) (obj)).r.a);
            q1 = ((com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.q) (obj));
        } else
        {
            ((com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.q) (obj)).s.b = e(((com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.q) (obj)));
            q1 = ((com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.q) (obj));
        }
        obj = new com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.q(this, q1);
        l.a(buffername, ((com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.q) (obj)), f1, new a(buffername, ((com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.q) (obj)), f1));
    }

    protected void b(Boolean boolean1, ar ar1)
    {
        if (boolean1.booleanValue())
        {
            boolean1 = a(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.T, com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.V, com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.U, com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.W);
            ar1.c.a(boolean1);
            return;
        } else
        {
            boolean1 = a(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.P, com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.R, com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.Q, com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.S);
            ar1.c.b(boolean1);
            return;
        }
    }

    protected void b(boolean flag)
    {
        if (m != null && m.i != null)
        {
            if (C != null)
            {
                C.cancel();
            }
            if (m.k != null)
            {
                a(MotionControlHelper.e().f(), flag);
                m.o = flag;
                c(flag);
                return;
            }
        }
    }

    protected void c()
    {
        H = null;
        I = null;
    }

    public void c(ImageLoader.BufferName buffername, f f1)
    {
        com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.q q1 = new com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.q(this, m);
        class b
            implements h
        {

            final ImageViewer a;
            private ImageLoader.BufferName b;
            private com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.q c;
            private f d;

            public void a()
            {
label0:
                {
                    com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ImageViewer.a(a, (new StringBuilder()).append("offscreen canvas is prepared, buffer name is ").append(b.toString()).append(" bDisplay: ").append(d.a).toString());
                    if (d.a)
                    {
                        if (b != com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ImageLoader.BufferName.a)
                        {
                            break label0;
                        }
                        com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.i i1 = (com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.i)a.l.b.get(com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ImageLoader.BufferName.c);
                        if (i1 == null || !i1.c)
                        {
                            break label0;
                        }
                        com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ImageViewer.a(a, "curView is prepared, no need to render fastBg now. skip it!");
                    }
                    return;
                }
                a.a(b, c);
            }

            public void a(Exception exception)
            {
                com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ImageViewer.a(a, (new StringBuilder()).append("request image buffer failed, reason: ").append(exception.getMessage()).toString());
            }

            public b(ImageLoader.BufferName buffername, com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.q q1, f f1)
            {
                a = ImageViewer.this;
                super();
                b = null;
                c = null;
                d = null;
                b = buffername;
                c = q1;
                d = f1;
            }
        }

        l.a(buffername, q1, new b(buffername, q1, f1));
    }

    public void c(com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.q q1)
    {
        v = new com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.q(this, q1);
    }

    RectF d(com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.q q1)
    {
        float af1[] = new float[9];
        q1.q.e.getValues(af1);
        float f1 = af1[0];
        float f2 = af1[2] * f1;
        float f3 = af1[5] * f1;
        float f4 = m.e;
        float f5 = m.f;
        q1 = new RectF();
        q1.left = f2;
        q1.top = f3;
        q1.right = f2 + f4 * f1;
        q1.bottom = f3 + f1 * f5;
        return q1;
    }

    protected void d()
    {
        Object obj = com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.v.a();
        obj = Message.obtain(G, 0, obj);
        G.sendMessage(((Message) (obj)));
    }

    public void e()
    {
        a("[unloadImageViewer]");
        T = true;
        l.d();
        l.c();
        StatusManager statusmanager = StatusManager.j();
        statusmanager.b(this);
        statusmanager.b(this);
        statusmanager.b(this);
        statusmanager.b(this);
        statusmanager.b(this);
        i();
        v = null;
    }

    public void f()
    {
        boolean flag1 = false;
        a("[initImageCanvas]");
        Object obj = m.n;
        boolean flag2 = m.o;
        if ((com.cyberlink.youcammakeup.database.g.a(m.a) || com.cyberlink.youcammakeup.kernelctrl.viewengine.i.a(m.a)) && n > 0 && o > 0)
        {
            boolean flag;
            if (v != null && v.a == m.a)
            {
                m = new com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.q(this, v);
                v = null;
                flag = true;
            } else
            {
                a(m.a, m);
                flag = false;
            }
            l.a();
            if (s != null)
            {
                s.a(m.b, m.c);
            }
            if (StatusManager.j().e(m.a))
            {
                a a1 = StatusManager.j().f(m.a);
                if (m.i == null)
                {
                    m.i = a1.d();
                }
                m.j = a1.e;
                StatusManager.j().b(true);
            } else
            if (!w.d)
            {
                Globals.d().i().b(getContext());
                StatusManager.j().a(this);
            }
            if (B.booleanValue())
            {
                m.n = ((com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeatureSets) (obj));
                l();
                m();
                n();
            }
            obj = new f();
            if (!flag)
            {
                flag1 = true;
            }
            obj.a = flag1;
            b(com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ImageLoader.BufferName.a, ((f) (obj)));
            obj = new f();
            obj.a = true;
            b(com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ImageLoader.BufferName.c, ((f) (obj)));
            obj = new f();
            b(ImageLoader.BufferName.b, ((f) (obj)));
            g();
            ab = true;
            StatusManager.j().u();
        }
    }

    public void g()
    {
        if (com.cyberlink.youcammakeup.database.g.a(t.a))
        {
            a(t.a, t);
            f f1 = new f();
            b(ImageLoader.BufferName.d, f1);
        }
        if (com.cyberlink.youcammakeup.database.g.a(u.a))
        {
            a(u.a, u);
            f f2 = new f();
            b(com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ImageLoader.BufferName.e, f2);
        }
    }

    public com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.e getCurEngineROIInfo()
    {
        if (l == null)
        {
            return null;
        } else
        {
            return l.a(com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ImageLoader.BufferName.c);
        }
    }

    public com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.q getCurImageInfo()
    {
        a("[getCurImageInfo]");
        return new com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.q(this, m);
    }

    protected android.os.Handler.Callback getHandlerCallback()
    {
        return new x(this);
    }

    public com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.q getInfo()
    {
        return m;
    }

    public void h()
    {
        if (T)
        {
            return;
        } else
        {
            StatusManager.j().a(this);
            return;
        }
    }

    public void i()
    {
        StatusManager.j().b(this);
    }

    public boolean j()
    {
        return m != null && m.b != -1 && m.c != -1 && m.e != -1 && m.f != -1 && m.g != null && m.q != null && m.q.d != -1F && m.q.e != null && m.q.f != null && m.r != null && m.r.b != -1F && m.s != null && m.s.b != -1F;
    }

    public void k()
    {
        m.l = null;
    }

    public void l()
    {
        if (m.j == -1)
        {
            a("Current face index is unknown, no need to calculate new transform");
        } else
        {
            if (m.i == null || m.i.isEmpty())
            {
                a("Face list is null or empty, no need to calculate new transform");
                return;
            }
            if (m.l == null)
            {
                Object obj = (ar)m.i.get(m.j);
                PointF pointf = new PointF(((ar) (obj)).c.d().f().b(), ((ar) (obj)).c.d().f().c());
                PointF pointf1 = new PointF(((ar) (obj)).c.d().b().b(), ((ar) (obj)).c.d().b().c());
                PointF pointf2 = new PointF(((ar) (obj)).c.d().d().b(), ((ar) (obj)).c.d().d().c());
                PointF pointf3 = new PointF(((ar) (obj)).c.d().c().b(), ((ar) (obj)).c.d().c().c());
                PointF pointf4 = new PointF(((ar) (obj)).c.d().e().b(), ((ar) (obj)).c.d().e().c());
                PointF pointf5 = new PointF(((ar) (obj)).c.e().f().b(), ((ar) (obj)).c.e().f().c());
                PointF pointf6 = new PointF(((ar) (obj)).c.e().b().b(), ((ar) (obj)).c.e().b().c());
                PointF pointf7 = new PointF(((ar) (obj)).c.e().d().b(), ((ar) (obj)).c.e().d().c());
                PointF pointf8 = new PointF(((ar) (obj)).c.e().c().b(), ((ar) (obj)).c.e().c().c());
                PointF pointf9 = new PointF(((ar) (obj)).c.e().e().b(), ((ar) (obj)).c.e().e().c());
                PointF pointf10 = new PointF(((ar) (obj)).c.f().b().b(), ((ar) (obj)).c.f().b().c());
                PointF pointf11 = new PointF(((ar) (obj)).c.f().c().b(), ((ar) (obj)).c.f().c().c());
                PointF pointf12 = new PointF(((ar) (obj)).c.g().b().b(), ((ar) (obj)).c.g().b().c());
                PointF pointf13 = new PointF(((ar) (obj)).c.g().c().b(), ((ar) (obj)).c.g().c().c());
                PointF pointf14 = new PointF(((ar) (obj)).c.j().c().b(), ((ar) (obj)).c.j().c().c());
                PointF pointf15 = new PointF(((ar) (obj)).c.j().b().b(), ((ar) (obj)).c.j().b().c());
                PointF pointf16 = new PointF(((ar) (obj)).c.j().d().b(), ((ar) (obj)).c.j().d().c());
                PointF pointf17 = new PointF(((ar) (obj)).c.j().e().b(), ((ar) (obj)).c.j().e().c());
                PointF pointf18 = new PointF(((ar) (obj)).c.j().f().b(), ((ar) (obj)).c.j().f().c());
                PointF pointf19 = new PointF(((ar) (obj)).c.h().b().b(), ((ar) (obj)).c.h().b().c());
                PointF pointf20 = new PointF(((ar) (obj)).c.h().c().b(), ((ar) (obj)).c.h().c().c());
                PointF pointf21 = new PointF(((ar) (obj)).c.i().b().b(), ((ar) (obj)).c.i().b().c());
                PointF pointf22 = new PointF(((ar) (obj)).c.i().c().b(), ((ar) (obj)).c.i().c().c());
                PointF pointf23 = new PointF(((ar) (obj)).c.l().b().b(), ((ar) (obj)).c.l().b().c());
                Object obj1 = new ArrayList();
                ((List) (obj1)).add(new PointF(((ar) (obj)).c.k().c().b(), ((ar) (obj)).c.k().c().c()));
                ((List) (obj1)).add(new PointF(((ar) (obj)).c.k().g().b(), ((ar) (obj)).c.k().g().c()));
                ((List) (obj1)).add(new PointF(((ar) (obj)).c.k().b().b(), ((ar) (obj)).c.k().b().c()));
                ((List) (obj1)).add(new PointF(((ar) (obj)).c.k().e().b(), ((ar) (obj)).c.k().e().c()));
                float f4 = ((PointF)((List) (obj1)).get(0)).x;
                float f6 = ((PointF)((List) (obj1)).get(0)).x;
                float f3 = ((PointF)((List) (obj1)).get(0)).y;
                float f1 = ((PointF)((List) (obj1)).get(0)).y;
                for (obj1 = ((List) (obj1)).iterator(); ((Iterator) (obj1)).hasNext();)
                {
                    PointF pointf24 = (PointF)((Iterator) (obj1)).next();
                    float f2 = f4;
                    if (pointf24.x < f4)
                    {
                        f2 = pointf24.x;
                    }
                    f4 = f6;
                    if (pointf24.x > f6)
                    {
                        f4 = pointf24.x;
                    }
                    float f5 = f3;
                    if (pointf24.y < f3)
                    {
                        f5 = pointf24.y;
                    }
                    if (pointf24.y > f1)
                    {
                        f1 = pointf24.y;
                    }
                    f6 = f4;
                    f3 = f5;
                    f4 = f2;
                }

                obj1 = new PointF((f6 - f4) / 2.0F + f4, (f1 - f3) / 2.0F + f3);
                PointF pointf25 = new PointF(((ar) (obj)).c.k().b().b(), ((ar) (obj)).c.k().b().c());
                PointF pointf26 = new PointF(((ar) (obj)).c.k().e().b(), ((ar) (obj)).c.k().e().c());
                PointF pointf27 = new PointF(((ar) (obj)).c.k().c().b(), ((ar) (obj)).c.k().c().c());
                PointF pointf28 = new PointF(((ar) (obj)).c.k().d().b(), ((ar) (obj)).c.k().d().c());
                PointF pointf29 = new PointF(((ar) (obj)).c.k().f().b(), ((ar) (obj)).c.k().f().c());
                PointF pointf30 = new PointF(((ar) (obj)).c.k().g().b(), ((ar) (obj)).c.k().g().c());
                PointF pointf31 = new PointF(((ar) (obj)).c.k().h().b(), ((ar) (obj)).c.k().h().c());
                PointF pointf32 = new PointF(((ar) (obj)).c.k().i().b(), ((ar) (obj)).c.k().i().c());
                PointF pointf33 = new PointF(((ar) (obj)).c.k().j().b(), ((ar) (obj)).c.k().j().c());
                PointF pointf34 = new PointF(((ar) (obj)).c.k().k().b(), ((ar) (obj)).c.k().k().c());
                PointF pointf35 = new PointF(((ar) (obj)).c.k().p().b(), ((ar) (obj)).c.k().p().c());
                PointF pointf36 = new PointF(((ar) (obj)).c.k().q().b(), ((ar) (obj)).c.k().q().c());
                PointF pointf37 = new PointF(((ar) (obj)).c.k().n().b(), ((ar) (obj)).c.k().n().c());
                PointF pointf38 = new PointF(((ar) (obj)).c.k().o().b(), ((ar) (obj)).c.k().o().c());
                PointF pointf39 = new PointF(((ar) (obj)).c.k().l().b(), ((ar) (obj)).c.k().l().c());
                PointF pointf40 = new PointF(((ar) (obj)).c.k().m().b(), ((ar) (obj)).c.k().m().c());
                PointF pointf41 = new PointF(((ar) (obj)).c.c().c().b(), ((ar) (obj)).c.c().c().c());
                PointF pointf42 = new PointF(((ar) (obj)).c.c().b().b(), ((ar) (obj)).c.c().b().c());
                PointF pointf43 = new PointF(((ar) (obj)).c.c().e().b(), ((ar) (obj)).c.c().e().c());
                PointF pointf44 = new PointF(((ar) (obj)).c.c().d().b(), ((ar) (obj)).c.c().d().c());
                PointF pointf45 = new PointF(((ar) (obj)).c.b().c().b(), ((ar) (obj)).c.b().c().c());
                PointF pointf46 = new PointF(((ar) (obj)).c.b().b().b(), ((ar) (obj)).c.b().b().c());
                PointF pointf47 = new PointF(((ar) (obj)).c.b().e().b(), ((ar) (obj)).c.b().e().c());
                PointF pointf48 = new PointF(((ar) (obj)).c.b().d().b(), ((ar) (obj)).c.b().d().c());
                PointF pointf49 = new PointF(((ar) (obj)).c.m().b().b(), ((ar) (obj)).c.m().b().c());
                PointF pointf50 = new PointF(((ar) (obj)).c.m().c().b(), ((ar) (obj)).c.m().c().c());
                obj = new PointF(((ar) (obj)).c.m().d().b(), ((ar) (obj)).c.m().d().c());
                if (m.l == null)
                {
                    m.l = new HashMap();
                }
                m.l.clear();
                m.l.put(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.a, pointf);
                m.l.put(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.b, pointf1);
                m.l.put(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.d, pointf2);
                m.l.put(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.c, pointf3);
                m.l.put(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.e, pointf4);
                m.l.put(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.f, pointf5);
                m.l.put(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.g, pointf6);
                m.l.put(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.i, pointf7);
                m.l.put(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.h, pointf8);
                m.l.put(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.j, pointf9);
                m.l.put(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.t, pointf10);
                m.l.put(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.u, pointf11);
                m.l.put(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.v, pointf12);
                m.l.put(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.w, pointf13);
                m.l.put(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.k, pointf14);
                m.l.put(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.n, pointf15);
                m.l.put(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.l, pointf16);
                m.l.put(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.m, pointf17);
                m.l.put(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.o, pointf18);
                m.l.put(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.p, pointf19);
                m.l.put(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.q, pointf20);
                m.l.put(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.r, pointf21);
                m.l.put(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.s, pointf22);
                m.l.put(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.x, pointf23);
                m.l.put(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.O, obj1);
                m.l.put(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.y, pointf25);
                m.l.put(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.z, pointf26);
                m.l.put(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.A, pointf27);
                m.l.put(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.B, pointf28);
                m.l.put(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.C, pointf29);
                m.l.put(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.D, pointf30);
                m.l.put(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.E, pointf31);
                m.l.put(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.F, pointf32);
                m.l.put(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.G, pointf33);
                m.l.put(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.H, pointf34);
                m.l.put(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.J, pointf35);
                m.l.put(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.I, pointf36);
                m.l.put(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.L, pointf37);
                m.l.put(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.K, pointf38);
                m.l.put(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.N, pointf39);
                m.l.put(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.M, pointf40);
                m.l.put(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.P, pointf42);
                m.l.put(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.Q, pointf41);
                m.l.put(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.R, pointf44);
                m.l.put(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.S, pointf43);
                m.l.put(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.T, pointf46);
                m.l.put(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.U, pointf45);
                m.l.put(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.V, pointf48);
                m.l.put(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.W, pointf47);
                m.l.put(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.X, pointf49);
                m.l.put(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.Y, pointf50);
                m.l.put(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.Z, obj);
                return;
            }
        }
    }

    public void m()
    {
        if (m.l != null && B.booleanValue())
        {
            if (m.k == null)
            {
                m.k = new HashMap();
            }
            float f1 = m.q.d;
            float af1[] = new float[9];
            m.q.e.getValues(af1);
            float f2 = af1[2];
            float f3 = af1[5];
            float f4 = (float)(-n) / 2.0F;
            float f5 = (float)(-o) / 2.0F;
            m.k.clear();
            Iterator iterator = m.l.entrySet().iterator();
            while (iterator.hasNext()) 
            {
                com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints featurepoints = (com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints)((java.util.Map.Entry)iterator.next()).getKey();
                Object obj = (PointF)m.l.get(featurepoints);
                obj = b(((PointF) (obj)).x / (float)m.b, ((PointF) (obj)).y / (float)m.c, true);
                com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.o o1 = new com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.o(this);
                o1.a = new PointF((f4 - f2 * f1) + ((d) (obj)).a, ((d) (obj)).b + (f5 - f3 * f1));
                o1.b = true;
                m.k.put(featurepoints, o1);
            }
        }
    }

    public void n()
    {
        while (m == null || m.i == null || m.i.isEmpty() || m.j < 0 || m.j >= m.i.size()) 
        {
            return;
        }
        ar ar1 = (ar)m.i.get(m.j);
        m.m = new HashMap();
        ArrayList arraylist = new ArrayList();
        arraylist.add(new PointF(ar1.c.d().b().b(), ar1.c.d().b().c()));
        arraylist.add(new PointF(ar1.c.d().c().b(), ar1.c.d().c().c()));
        arraylist.add(new PointF(ar1.c.d().d().b(), ar1.c.d().d().c()));
        arraylist.add(new PointF(ar1.c.d().e().b(), ar1.c.d().e().c()));
        m.m.put(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.a, a(arraylist));
        arraylist = new ArrayList();
        arraylist.add(new PointF(ar1.c.e().b().b(), ar1.c.e().b().c()));
        arraylist.add(new PointF(ar1.c.e().c().b(), ar1.c.e().c().c()));
        arraylist.add(new PointF(ar1.c.e().d().b(), ar1.c.e().d().c()));
        arraylist.add(new PointF(ar1.c.e().e().b(), ar1.c.e().e().c()));
        m.m.put(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.f, a(arraylist));
        arraylist = new ArrayList();
        arraylist.add(new PointF(ar1.c.k().c().b(), ar1.c.k().c().c()));
        arraylist.add(new PointF(ar1.c.k().g().b(), ar1.c.k().g().c()));
        arraylist.add(new PointF(ar1.c.k().b().b(), ar1.c.k().b().c()));
        arraylist.add(new PointF(ar1.c.k().e().b(), ar1.c.k().e().c()));
        m.m.put(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.O, a(arraylist));
        arraylist = new ArrayList();
        arraylist.add(new PointF(ar1.c.j().b().b(), ar1.c.j().b().c()));
        arraylist.add(new PointF(ar1.c.j().c().b(), ar1.c.j().c().c()));
        arraylist.add(new PointF(ar1.c.j().d().b(), ar1.c.j().d().c()));
        arraylist.add(new PointF(ar1.c.j().e().b(), ar1.c.j().e().c()));
        m.m.put(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.k, a(arraylist));
    }

    public void o()
    {
        if (m.l != null && B.booleanValue() && m.k != null && m.k.size() != 0)
        {
            float f1 = m.q.d;
            float af1[] = new float[9];
            m.q.e.getValues(af1);
            float f2 = af1[2];
            float f3 = af1[5];
            float f4 = (float)(-n) / 2.0F;
            float f5 = (float)(-o) / 2.0F;
            Iterator iterator = m.l.entrySet().iterator();
            while (iterator.hasNext()) 
            {
                com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints featurepoints = (com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints)((java.util.Map.Entry)iterator.next()).getKey();
                Object obj = (PointF)m.l.get(featurepoints);
                obj = b(((PointF) (obj)).x / (float)m.b, ((PointF) (obj)).y / (float)m.c, true);
                ((com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.o)m.k.get(featurepoints)).a.set((f4 - f2 * f1) + ((d) (obj)).a, ((d) (obj)).b + (f5 - f3 * f1));
            }
        }
    }

    protected void onDraw(Canvas canvas)
    {
        com.pf.common.utility.m.b("RENDER", (new StringBuilder()).append("renderMethod#IV: ").append(J).toString());
        switch (J)
        {
        default:
            com.pf.common.utility.m.e("RENDER", "can't render ImageViewer.");
            return;

        case 1: // '\001'
            break;
        }
        if (H != null && I != null)
        {
            a(canvas, H, I);
            return;
        } else
        {
            com.pf.common.utility.m.e("RENDER", "can't render display canvas.");
            return;
        }
    }

    protected void onLayout(boolean flag, int i1, int j1, int k1, int l1)
    {
        super.onLayout(flag, i1, j1, k1, l1);
        if (flag)
        {
            c();
            d();
        }
    }

    protected void onSizeChanged(int i1, int j1, int k1, int l1)
    {
        super.onSizeChanged(i1, j1, k1, l1);
        if (!ab && i1 > 0 && j1 > 0)
        {
            n = i1;
            o = j1;
            f();
            if (L != null)
            {
                L.a();
            }
        }
        com.pf.common.utility.m.b("RENDER", "onSizeChanged#IV");
        a(i1, j1);
    }

    protected void p()
    {
        if (m == null || m.i == null)
        {
            return;
        } else
        {
            ar ar1 = (ar)m.i.get(m.j);
            a(Boolean.valueOf(true), ar1);
            a(Boolean.valueOf(false), ar1);
            a(ar1);
            b(ar1);
            a((PointF)m.l.get(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.p), (PointF)m.l.get(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.q), ar1);
            b((PointF)m.l.get(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.r), (PointF)m.l.get(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.s), ar1);
            a((PointF)m.l.get(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.x), ar1);
            PointF pointf = (PointF)m.l.get(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.t);
            PointF pointf1 = (PointF)m.l.get(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.v);
            a(pointf, (PointF)m.l.get(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.u), pointf1, (PointF)m.l.get(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.w), ar1);
            b(Boolean.valueOf(true), ar1);
            b(Boolean.valueOf(false), ar1);
            a((PointF)m.l.get(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.X), (PointF)m.l.get(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.Y), (PointF)m.l.get(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.Z), ar1);
            return;
        }
    }

    public void q()
    {
        if (!B.booleanValue() || m.k == null)
        {
            return;
        }
        for (Iterator iterator = m.k.entrySet().iterator(); iterator.hasNext();)
        {
            ((com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.o)((java.util.Map.Entry)iterator.next()).getValue()).b = false;
        }

        m.o = false;
        StatusManager.j().c(false);
        f f1 = new f();
        f1.a = true;
        b(com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ImageLoader.BufferName.c, f1);
    }

    public void r()
    {
        if (C != null)
        {
            C.cancel();
        }
    }

    public void setDisplayFeaturePts(Boolean boolean1)
    {
        B = boolean1;
    }

    public void setEnableAccessoryLocalMode(boolean flag)
    {
        F = flag;
    }

    public void setEnableWigLocalMode(boolean flag)
    {
        E = flag;
    }

    public void setFeaturePtVisibility(boolean flag)
    {
        b(flag);
    }

    public void setImageMask(Bitmap bitmap)
    {
        r = bitmap;
    }

    public void setImagePath(String s1)
    {
        l.d = s1;
        f();
    }

    public void setViewerTextureAvailableCallback(p p1)
    {
        L = p1;
    }

    static 
    {
        a = new PorterDuffXfermode(android.graphics.PorterDuff.Mode.SRC_IN);
    }

    private class FitOption extends Enum
    {

        public static final FitOption a;
        public static final FitOption b;
        private static final FitOption c[];

        public static FitOption valueOf(String s1)
        {
            return (FitOption)Enum.valueOf(com/cyberlink/youcammakeup/kernelctrl/panzoomviewer/ImageViewer$FitOption, s1);
        }

        public static FitOption[] values()
        {
            return (FitOption[])c.clone();
        }

        static 
        {
            a = new FitOption("TouchFromInside", 0);
            b = new FitOption("TouchFromOutside", 1);
            c = (new FitOption[] {
                a, b
            });
        }

        private FitOption(String s1, int i1)
        {
            super(s1, i1);
        }
    }

}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.collages;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.picsart.studio.PicsartContext;
import com.socialin.android.brushlib.input.gesture.a;
import com.socialin.android.brushlib.input.gesture.b;
import com.socialin.android.brushlib.input.gesture.d;
import com.socialin.android.brushlib.input.gesture.e;
import com.socialin.android.brushlib.input.gesture.f;
import com.socialin.android.brushlib.input.gesture.g;
import com.socialin.android.brushlib.input.gesture.h;
import com.socialin.android.brushlib.input.gesture.i;
import com.socialin.android.brushlib.input.gesture.j;
import com.socialin.android.util.Geom;
import com.socialin.android.util.ModernAsyncTask;
import com.socialin.android.util.Utils;
import com.socialin.android.util.l;
import com.socialin.android.util.w;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import myobfuscated.f.m;

// Referenced classes of package com.picsart.collages:
//            b, a, c, ControlPoint, 
//            ControlItem, SPArrow, CollageImage, g, 
//            f

public class CollageCreatorView extends View
{

    private PointF A;
    private PointF B;
    private c C;
    private Bitmap D;
    private RectF E;
    private Rect F;
    private int G;
    private int H;
    private boolean I;
    private boolean J;
    private float K;
    private float L;
    private float M;
    private float N;
    private boolean O;
    private ControlPoint P;
    private com.picsart.collages.g Q;
    private com.picsart.collages.b R;
    private boolean S;
    private int T;
    private int U;
    private int V;
    private PorterDuffXfermode W;
    Paint a;
    private PorterDuffXfermode aa;
    private Drawable ab;
    private int ac;
    private float ad;
    private boolean ae;
    private boolean af;
    private float ag;
    private float ah;
    private int ai;
    private boolean aj;
    private boolean ak;
    ArrayList b;
    int c;
    int d;
    float e;
    float f;
    RectF g;
    RectF h;
    float i;
    boolean j;
    Bitmap k;
    Rect l;
    ArrayList m;
    String n;
    int o;
    boolean p;
    boolean q;
    boolean r;
    HashMap s;
    private Paint t;
    private Paint u;
    private Paint v;
    private d w;
    private PointF x;
    private PointF y;
    private float z;

    public CollageCreatorView(Context context)
    {
        super(context);
        a = null;
        t = new Paint();
        u = new Paint();
        v = new Paint();
        b = new ArrayList();
        w = null;
        x = new PointF();
        y = new PointF();
        z = 0.0F;
        A = new PointF();
        c = 0;
        B = new PointF();
        d = -1;
        e = 0.0F;
        f = 0.0F;
        g = new RectF();
        h = new RectF();
        C = null;
        i = 1.0F;
        D = null;
        j = false;
        E = new RectF();
        F = new Rect();
        G = -1;
        H = 200;
        I = false;
        k = null;
        l = null;
        m = null;
        J = false;
        K = 0.0F;
        L = 0.0F;
        n = null;
        o = 0;
        M = 0.0F;
        p = false;
        N = 0.0F;
        O = false;
        P = null;
        Q = null;
        R = null;
        S = false;
        T = 2048;
        U = 2048;
        V = 0;
        q = false;
        r = false;
        W = null;
        aa = null;
        ab = null;
        ac = 0;
        ad = 0.0F;
        ae = false;
        af = false;
        ag = 0.0F;
        ah = 0.0F;
        ai = 18000;
        aj = false;
        ak = false;
        s = new HashMap();
        f();
    }

    public CollageCreatorView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a = null;
        t = new Paint();
        u = new Paint();
        v = new Paint();
        b = new ArrayList();
        w = null;
        x = new PointF();
        y = new PointF();
        z = 0.0F;
        A = new PointF();
        c = 0;
        B = new PointF();
        d = -1;
        e = 0.0F;
        f = 0.0F;
        g = new RectF();
        h = new RectF();
        C = null;
        i = 1.0F;
        D = null;
        j = false;
        E = new RectF();
        F = new Rect();
        G = -1;
        H = 200;
        I = false;
        k = null;
        l = null;
        m = null;
        J = false;
        K = 0.0F;
        L = 0.0F;
        n = null;
        o = 0;
        M = 0.0F;
        p = false;
        N = 0.0F;
        O = false;
        P = null;
        Q = null;
        R = null;
        S = false;
        T = 2048;
        U = 2048;
        V = 0;
        q = false;
        r = false;
        W = null;
        aa = null;
        ab = null;
        ac = 0;
        ad = 0.0F;
        ae = false;
        af = false;
        ag = 0.0F;
        ah = 0.0F;
        ai = 18000;
        aj = false;
        ak = false;
        s = new HashMap();
        f();
    }

    public CollageCreatorView(Context context, AttributeSet attributeset, int i1)
    {
        super(context, attributeset, i1);
        a = null;
        t = new Paint();
        u = new Paint();
        v = new Paint();
        b = new ArrayList();
        w = null;
        x = new PointF();
        y = new PointF();
        z = 0.0F;
        A = new PointF();
        c = 0;
        B = new PointF();
        d = -1;
        e = 0.0F;
        f = 0.0F;
        g = new RectF();
        h = new RectF();
        C = null;
        i = 1.0F;
        D = null;
        j = false;
        E = new RectF();
        F = new Rect();
        G = -1;
        H = 200;
        I = false;
        k = null;
        l = null;
        m = null;
        J = false;
        K = 0.0F;
        L = 0.0F;
        n = null;
        o = 0;
        M = 0.0F;
        p = false;
        N = 0.0F;
        O = false;
        P = null;
        Q = null;
        R = null;
        S = false;
        T = 2048;
        U = 2048;
        V = 0;
        q = false;
        r = false;
        W = null;
        aa = null;
        ab = null;
        ac = 0;
        ad = 0.0F;
        ae = false;
        af = false;
        ag = 0.0F;
        ah = 0.0F;
        ai = 18000;
        aj = false;
        ak = false;
        s = new HashMap();
        f();
    }

    static PointF A(CollageCreatorView collagecreatorview)
    {
        return collagecreatorview.y;
    }

    static float B(CollageCreatorView collagecreatorview)
    {
        return collagecreatorview.ad;
    }

    static boolean C(CollageCreatorView collagecreatorview)
    {
        return collagecreatorview.ae;
    }

    static float D(CollageCreatorView collagecreatorview)
    {
        return collagecreatorview.z;
    }

    public static c E(CollageCreatorView collagecreatorview)
    {
        return collagecreatorview.C;
    }

    static Bitmap F(CollageCreatorView collagecreatorview)
    {
        return collagecreatorview.k;
    }

    static String G(CollageCreatorView collagecreatorview)
    {
        return collagecreatorview.n;
    }

    static boolean H(CollageCreatorView collagecreatorview)
    {
        return collagecreatorview.q;
    }

    static int I(CollageCreatorView collagecreatorview)
    {
        return collagecreatorview.T;
    }

    static int J(CollageCreatorView collagecreatorview)
    {
        return collagecreatorview.U;
    }

    static float K(CollageCreatorView collagecreatorview)
    {
        return collagecreatorview.i;
    }

    static RectF L(CollageCreatorView collagecreatorview)
    {
        return collagecreatorview.g;
    }

    static Paint M(CollageCreatorView collagecreatorview)
    {
        return collagecreatorview.a;
    }

    static float N(CollageCreatorView collagecreatorview)
    {
        return collagecreatorview.f;
    }

    static float O(CollageCreatorView collagecreatorview)
    {
        return collagecreatorview.e;
    }

    static float a(CollageCreatorView collagecreatorview, float f1)
    {
        collagecreatorview.ag = f1;
        return f1;
    }

    public static int a(CollageCreatorView collagecreatorview, int i1)
    {
        collagecreatorview.G = i1;
        return i1;
    }

    public static Bitmap a(CollageCreatorView collagecreatorview, Bitmap bitmap)
    {
        collagecreatorview.D = bitmap;
        return bitmap;
    }

    static ControlPoint a(CollageCreatorView collagecreatorview, ControlPoint controlpoint)
    {
        collagecreatorview.P = controlpoint;
        return controlpoint;
    }

    public static void a(CollageCreatorView collagecreatorview, float f1, float f2)
    {
        collagecreatorview.j = true;
        if (collagecreatorview.R != null)
        {
            collagecreatorview.R.a();
        }
        int k1 = collagecreatorview.D.getWidth();
        int l1 = collagecreatorview.D.getHeight();
        int i1;
        int j1;
        if (k1 > l1)
        {
            j1 = collagecreatorview.H;
            i1 = (int)((float)l1 * ((float)collagecreatorview.H / (float)k1));
        } else
        {
            i1 = collagecreatorview.H;
            j1 = (int)((float)k1 * ((float)collagecreatorview.H / (float)l1));
        }
        collagecreatorview.E.set(f1 - (float)(j1 / 2) - collagecreatorview.K, f2 - (float)(i1 / 2) - collagecreatorview.L, ((float)(j1 / 2) + f1) - collagecreatorview.K, ((float)(i1 / 2) + f2) - collagecreatorview.L);
        collagecreatorview.F.set(0, 0, k1, l1);
        collagecreatorview.invalidate();
    }

    static boolean a(CollageCreatorView collagecreatorview)
    {
        return collagecreatorview.p;
    }

    static boolean a(CollageCreatorView collagecreatorview, boolean flag)
    {
        collagecreatorview.O = flag;
        return flag;
    }

    static float b(CollageCreatorView collagecreatorview, float f1)
    {
        collagecreatorview.ah = f1;
        return f1;
    }

    public static int b(CollageCreatorView collagecreatorview, int i1)
    {
        collagecreatorview.d = i1;
        return i1;
    }

    static Bitmap b(CollageCreatorView collagecreatorview, Bitmap bitmap)
    {
        collagecreatorview.k = bitmap;
        return bitmap;
    }

    static ArrayList b(CollageCreatorView collagecreatorview)
    {
        return collagecreatorview.m;
    }

    static void b(CollageCreatorView collagecreatorview, float f1, float f2)
    {
        int i1 = collagecreatorview.b.size();
        if (!collagecreatorview.g.contains(f1 - collagecreatorview.K, f2 - collagecreatorview.L)) goto _L2; else goto _L1
_L1:
        i1--;
_L9:
        if (i1 < 0) goto _L4; else goto _L3
_L3:
        if (!((com.picsart.collages.a)collagecreatorview.b.get(i1)).a((int)(f1 - collagecreatorview.K), (int)(f2 - collagecreatorview.L))) goto _L6; else goto _L5
_L5:
        if (((com.picsart.collages.a)collagecreatorview.b.get(i1)).d == null)
        {
            collagecreatorview.d = i1;
            collagecreatorview.C.a();
        } else
        {
            if (collagecreatorview.d == i1)
            {
                i1 = -1;
            }
            collagecreatorview.d = i1;
        }
        collagecreatorview.invalidate();
_L4:
        if (collagecreatorview.R != null)
        {
            if (collagecreatorview.d != -1 && ((com.picsart.collages.a)collagecreatorview.b.get(collagecreatorview.d)).d != null)
            {
                break; /* Loop/switch isn't completed */
            }
            collagecreatorview.R.b();
        }
        return;
_L6:
        i1--;
        continue; /* Loop/switch isn't completed */
_L2:
        collagecreatorview.d = -1;
        collagecreatorview.invalidate();
        if (true) goto _L4; else goto _L7
_L7:
        collagecreatorview.R.a();
        return;
        if (true) goto _L9; else goto _L8
_L8:
    }

    static boolean b(CollageCreatorView collagecreatorview, boolean flag)
    {
        collagecreatorview.aj = flag;
        return flag;
    }

    static float c(CollageCreatorView collagecreatorview, float f1)
    {
        collagecreatorview.z = f1;
        return f1;
    }

    static int c(CollageCreatorView collagecreatorview, int i1)
    {
        collagecreatorview.T = i1;
        return i1;
    }

    static ArrayList c(CollageCreatorView collagecreatorview)
    {
        return collagecreatorview.g();
    }

    static boolean c(CollageCreatorView collagecreatorview, boolean flag)
    {
        collagecreatorview.I = flag;
        return flag;
    }

    public static float d(CollageCreatorView collagecreatorview)
    {
        return collagecreatorview.K;
    }

    static float d(CollageCreatorView collagecreatorview, float f1)
    {
        f1 = collagecreatorview.ad + f1;
        collagecreatorview.ad = f1;
        return f1;
    }

    static int d(CollageCreatorView collagecreatorview, int i1)
    {
        collagecreatorview.U = i1;
        return i1;
    }

    static boolean d(CollageCreatorView collagecreatorview, boolean flag)
    {
        collagecreatorview.J = flag;
        return flag;
    }

    public static float e(CollageCreatorView collagecreatorview)
    {
        return collagecreatorview.L;
    }

    static boolean e(CollageCreatorView collagecreatorview, boolean flag)
    {
        collagecreatorview.ak = flag;
        return flag;
    }

    static float f(CollageCreatorView collagecreatorview)
    {
        return collagecreatorview.N;
    }

    private void f()
    {
        V = getContext().getResources().getColor(0x7f0f008e);
        a = new Paint();
        a.setStrokeWidth(2.0F);
        a.setStrokeCap(android.graphics.Paint.Cap.ROUND);
        a.setStyle(android.graphics.Paint.Style.FILL_AND_STROKE);
        a.setAntiAlias(true);
        a.setFilterBitmap(true);
        a.setColor(-1);
        v.setStyle(android.graphics.Paint.Style.FILL_AND_STROKE);
        v.setColor(0xff000000);
        w = new d();
        w.a(new g(new h() {

            private CollageCreatorView a;

            public final void a(float f1, float f2)
            {
                if (!com.picsart.collages.CollageCreatorView.a(a) || com.picsart.collages.CollageCreatorView.b(a) == null) goto _L2; else goto _L1
_L1:
                ArrayList arraylist;
                int i1;
                int j1;
                arraylist = CollageCreatorView.c(a);
                com.picsart.collages.CollageCreatorView.a(a, false);
                j1 = arraylist.size();
                i1 = 0;
_L7:
                if (i1 >= j1) goto _L2; else goto _L3
_L3:
                PointF pointf = (PointF)arraylist.get(i1);
                if (Math.pow(f1 - com.picsart.collages.CollageCreatorView.d(a) - pointf.x, 2D) + Math.pow(f2 - com.picsart.collages.CollageCreatorView.e(a) - pointf.y, 2D) > (double)com.picsart.collages.CollageCreatorView.f(a)) goto _L5; else goto _L4
_L4:
                com.picsart.collages.CollageCreatorView.a(a, true);
                com.picsart.collages.CollageCreatorView.a(a, (ControlPoint)com.picsart.collages.CollageCreatorView.b(a).get(i1));
_L2:
                com.picsart.collages.CollageCreatorView.b(a, false);
                CollageCreatorView.c(a, true);
                com.picsart.collages.CollageCreatorView.g(a).x = f1;
                com.picsart.collages.CollageCreatorView.g(a).y = f2;
                if (!com.picsart.collages.CollageCreatorView.h(a) && !com.picsart.collages.CollageCreatorView.i(a))
                {
                    com.picsart.collages.CollageCreatorView.d(a, true);
                }
                CollageCreatorView collagecreatorview = a;
                boolean flag;
                if (com.picsart.collages.CollageCreatorView.j(a) == -1)
                {
                    flag = false;
                } else
                {
                    flag = a.e().a((int)(f1 - com.picsart.collages.CollageCreatorView.d(a)), (int)(f2 - com.picsart.collages.CollageCreatorView.e(a)));
                }
                com.picsart.collages.CollageCreatorView.e(collagecreatorview, flag);
                a.invalidate();
                return;
_L5:
                i1++;
                if (true) goto _L7; else goto _L6
_L6:
            }

            public final void b(float f1, float f2)
            {
                CollageCreatorView.c(a, false);
                com.picsart.collages.CollageCreatorView.d(a, false);
                com.picsart.collages.CollageCreatorView.a(a, false);
                a.invalidate();
            }

            public final void c(float f1, float f2)
            {
                float f3;
                float f5;
                int i1;
                i1 = 0;
                f3 = f1 - com.picsart.collages.CollageCreatorView.g(a).x;
                f5 = f2 - com.picsart.collages.CollageCreatorView.g(a).y;
                if (!com.picsart.collages.CollageCreatorView.h(a)) goto _L2; else goto _L1
_L1:
                CollageCreatorView.k(a).set(CollageCreatorView.k(a).left + f3, CollageCreatorView.k(a).top + f5, f3 + CollageCreatorView.k(a).left + CollageCreatorView.k(a).width(), f5 + CollageCreatorView.k(a).top + CollageCreatorView.k(a).height());
                for (int j1 = com.picsart.collages.CollageCreatorView.l(a).size(); i1 < j1; i1++)
                {
                    if (((com.picsart.collages.a)com.picsart.collages.CollageCreatorView.l(a).get(i1)).a((int)(f1 - com.picsart.collages.CollageCreatorView.d(a)), (int)(f2 - com.picsart.collages.CollageCreatorView.e(a))))
                    {
                        com.picsart.collages.CollageCreatorView.a(a, i1);
                    }
                }

                  goto _L3
_L2:
                if (!com.picsart.collages.CollageCreatorView.i(a)) goto _L5; else goto _L4
_L4:
                Object obj = com.picsart.collages.CollageCreatorView.m(a).controlItems;
                Iterator iterator1 = ((ArrayList) (obj)).iterator();
                boolean flag = true;
                while (iterator1.hasNext()) 
                {
                    ControlItem controlitem1 = (ControlItem)iterator1.next();
                    if (flag && ((com.picsart.collages.a)com.picsart.collages.CollageCreatorView.l(a).get(controlitem1.cellIndex)).a(controlitem1.verticeIndex, SPArrow.getInstance().setXY(f3, f5), false))
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                }
                if (flag)
                {
                    if (CollageCreatorView.n(a) != null)
                    {
                        for (Iterator iterator2 = com.picsart.collages.CollageCreatorView.l(a).iterator(); iterator2.hasNext();)
                        {
                            com.picsart.collages.a a2 = (com.picsart.collages.a)iterator2.next();
                            a2.u = a2.u;
                        }

                    }
                    ControlItem controlitem;
                    for (obj = ((ArrayList) (obj)).iterator(); ((Iterator) (obj)).hasNext(); ((com.picsart.collages.a)com.picsart.collages.CollageCreatorView.l(a).get(controlitem.cellIndex)).a(controlitem.verticeIndex, SPArrow.getInstance().setXY(f3, f5), true))
                    {
                        controlitem = (ControlItem)((Iterator) (obj)).next();
                    }

                    if (CollageCreatorView.n(a) != null)
                    {
                        Iterator iterator = com.picsart.collages.CollageCreatorView.l(a).iterator();
                        float f4 = 3.402823E+38F;
                        do
                        {
                            if (!iterator.hasNext())
                            {
                                break;
                            }
                            com.picsart.collages.a a1 = (com.picsart.collages.a)iterator.next();
                            float f6 = a1.d();
                            a1.u = f6;
                            if (f4 > f6)
                            {
                                f4 = f6;
                            }
                        } while (true);
                        CollageCreatorView.n(a).a(f4);
                    }
                }
_L3:
                com.picsart.collages.CollageCreatorView.g(a).x = f1;
                com.picsart.collages.CollageCreatorView.g(a).y = f2;
                a.invalidate();
                com.picsart.collages.CollageCreatorView.w(a);
                return;
_L5:
                if (CollageCreatorView.o(a) && com.picsart.collages.CollageCreatorView.j(a) != -1)
                {
                    boolean flag1;
                    if (!com.picsart.collages.CollageCreatorView.h(a))
                    {
                        flag1 = ((com.picsart.collages.a)com.picsart.collages.CollageCreatorView.l(a).get(com.picsart.collages.CollageCreatorView.j(a))).a(f1 - com.picsart.collages.CollageCreatorView.g(a).x, f2 - com.picsart.collages.CollageCreatorView.g(a).y);
                    } else
                    {
                        flag1 = false;
                    }
                    if (CollageCreatorView.p(a) && !flag1 && !((com.picsart.collages.a)com.picsart.collages.CollageCreatorView.l(a).get(com.picsart.collages.CollageCreatorView.j(a))).a((int)(f1 - com.picsart.collages.CollageCreatorView.d(a)), (int)(f2 - com.picsart.collages.CollageCreatorView.e(a))))
                    {
                        if (!CollageCreatorView.q(a))
                        {
                            com.picsart.collages.CollageCreatorView.f(a, true);
                            com.picsart.collages.CollageCreatorView.a(a, f1);
                            com.picsart.collages.CollageCreatorView.b(a, f2);
                        }
                        if ((float)(Math.pow(f1 - CollageCreatorView.r(a), 2D) + Math.pow(f2 - CollageCreatorView.s(a), 2D)) > (float)CollageCreatorView.t(a) || !CollageCreatorView.u(a))
                        {
                            com.picsart.collages.CollageCreatorView.a(a, ((com.picsart.collages.a)com.picsart.collages.CollageCreatorView.l(a).get(com.picsart.collages.CollageCreatorView.j(a))).d);
                            if (CollageCreatorView.v(a) != null)
                            {
                                com.picsart.collages.CollageCreatorView.a(a, f1, f2);
                            }
                        }
                    } else
                    {
                        com.picsart.collages.CollageCreatorView.f(a, false);
                        if (!CollageCreatorView.u(a))
                        {
                            com.picsart.collages.CollageCreatorView.b(a, flag1);
                        }
                    }
                }
                if (true) goto _L3; else goto _L6
_L6:
            }

            
            {
                a = CollageCreatorView.this;
                super();
            }
        }));
        w.a(new a(new b() {

            private CollageCreatorView a;

            public final void a()
            {
                com.picsart.collages.CollageCreatorView.d(a, false);
                a.invalidate();
            }

            public final void a(float f1, float f2, float f3, float f4)
            {
                if (!com.picsart.collages.CollageCreatorView.h(a))
                {
                    com.socialin.android.util.l.a(f1, f2, f3, f4, CollageCreatorView.x(a));
                    CollageCreatorView.y(a);
                    com.picsart.collages.CollageCreatorView.g(a, false);
                    CollageCreatorView.z(a).x = f1;
                    CollageCreatorView.A(a).x = f3;
                    CollageCreatorView.z(a).y = f2;
                    CollageCreatorView.A(a).y = f4;
                    CollageCreatorView.c(a, Geom.b(f1, f2, f3, f4));
                    if (com.picsart.collages.CollageCreatorView.j(a) == -1)
                    {
                        com.picsart.collages.CollageCreatorView.b(a, CollageCreatorView.x(a).x, CollageCreatorView.x(a).y);
                    }
                    if (com.picsart.collages.CollageCreatorView.j(a) != -1)
                    {
                        com.picsart.collages.CollageCreatorView.d(a, true);
                        a.invalidate();
                        return;
                    }
                }
            }

            public final void b(float f1, float f2, float f3, float f4)
            {
                if (com.picsart.collages.CollageCreatorView.j(a) != -1 && !com.picsart.collages.CollageCreatorView.h(a) && CollageCreatorView.z(a) != null && CollageCreatorView.A(a) != null)
                {
                    PointF pointf = new PointF();
                    pointf.x = f1;
                    pointf.y = f2;
                    PointF pointf1 = new PointF();
                    pointf1.x = f3;
                    pointf1.y = f4;
                    float f5 = (CollageCreatorView.z(a).x + CollageCreatorView.A(a).x) / 2.0F;
                    float f6 = (CollageCreatorView.z(a).y + CollageCreatorView.A(a).y) / 2.0F;
                    float f7 = (pointf.x + pointf1.x) / 2.0F;
                    float f8 = (pointf.y + pointf1.y) / 2.0F;
                    CollageCreatorView.x(a).x = f7;
                    CollageCreatorView.x(a).y = f8;
                    ((com.picsart.collages.a)com.picsart.collages.CollageCreatorView.l(a).get(com.picsart.collages.CollageCreatorView.j(a))).a(f7 - f5, f8 - f6);
                    f5 = com.socialin.android.util.l.a(CollageCreatorView.z(a), CollageCreatorView.A(a), pointf, pointf1);
                    CollageCreatorView.z(a).x = f1;
                    CollageCreatorView.A(a).x = f3;
                    CollageCreatorView.z(a).y = f2;
                    CollageCreatorView.A(a).y = f4;
                    com.picsart.collages.CollageCreatorView.d(a, f5);
                    if (Math.abs(CollageCreatorView.B(a)) > 20F)
                    {
                        com.picsart.collages.CollageCreatorView.g(a, true);
                    }
                    if (CollageCreatorView.C(a))
                    {
                        ((com.picsart.collages.a)com.picsart.collages.CollageCreatorView.l(a).get(com.picsart.collages.CollageCreatorView.j(a))).b(f5, CollageCreatorView.x(a).x - com.picsart.collages.CollageCreatorView.d(a), CollageCreatorView.x(a).y - com.picsart.collages.CollageCreatorView.e(a));
                    }
                    f1 = Geom.a(pointf, pointf1);
                    if (CollageCreatorView.D(a) != 0.0F && f1 / CollageCreatorView.D(a) != (0.0F / 0.0F))
                    {
                        ((com.picsart.collages.a)com.picsart.collages.CollageCreatorView.l(a).get(com.picsart.collages.CollageCreatorView.j(a))).a(f1 / CollageCreatorView.D(a), CollageCreatorView.x(a).x - com.picsart.collages.CollageCreatorView.d(a), CollageCreatorView.x(a).y - com.picsart.collages.CollageCreatorView.e(a));
                        CollageCreatorView.c(a, f1);
                        a.invalidate();
                        return;
                    }
                }
            }

            
            {
                a = CollageCreatorView.this;
                super();
            }
        }));
        w.a(new i(new j() {

            private CollageCreatorView a;

            public final void a_(float f1, float f2)
            {
                if (!com.picsart.collages.CollageCreatorView.i(a))
                {
                    com.picsart.collages.CollageCreatorView.b(a, f1, f2);
                }
            }

            
            {
                a = CollageCreatorView.this;
                super();
            }
        }, 500L));
        w.a(new e(new f(this)));
        l = new Rect(0, 0, 0, 0);
        t.setColor(Color.parseColor("#33b5e5"));
        t.setAntiAlias(true);
        t.setStyle(android.graphics.Paint.Style.STROKE);
        t.setStrokeWidth(Utils.a(4F, getContext()));
        t.setStrokeCap(android.graphics.Paint.Cap.ROUND);
        u.setAlpha(155);
        W = new PorterDuffXfermode(android.graphics.PorterDuff.Mode.CLEAR);
        aa = new PorterDuffXfermode(android.graphics.PorterDuff.Mode.DST_OVER);
        ab = getResources().getDrawable(0x7f020126);
        ac = ab.getIntrinsicWidth();
        H = (int)Utils.a(H, getContext());
        N = (int)Math.pow(Utils.a(20F, getContext()), 2D);
    }

    static boolean f(CollageCreatorView collagecreatorview, boolean flag)
    {
        collagecreatorview.af = flag;
        return flag;
    }

    static PointF g(CollageCreatorView collagecreatorview)
    {
        return collagecreatorview.A;
    }

    private ArrayList g()
    {
        ArrayList arraylist = new ArrayList();
        if (m != null)
        {
            int j1 = m.size();
            for (int i1 = 0; i1 < j1; i1++)
            {
                Object obj = (ControlItem)((ControlPoint)m.get(i1)).controlItems.get(0);
                com.picsart.collages.a a1 = (com.picsart.collages.a)b.get(((ControlItem) (obj)).cellIndex);
                SPArrow sparrow = (SPArrow)a1.a.get(((ControlItem) (obj)).verticeIndex);
                float f1 = sparrow.getX();
                float f2 = sparrow.getY();
                obj = (SPArrow)a1.a.get((((ControlItem) (obj)).verticeIndex + 1) % a1.a.size());
                float f3 = ((SPArrow) (obj)).getX();
                float f4 = ((SPArrow) (obj)).getY();
                arraylist.add(new PointF((f3 + f1) / 2.0F + e + f, (f4 + f2) / 2.0F + e + f));
            }

        }
        return arraylist;
    }

    static boolean g(CollageCreatorView collagecreatorview, boolean flag)
    {
        collagecreatorview.ae = flag;
        return flag;
    }

    static boolean h(CollageCreatorView collagecreatorview)
    {
        return collagecreatorview.j;
    }

    static boolean h(CollageCreatorView collagecreatorview, boolean flag)
    {
        collagecreatorview.S = flag;
        return flag;
    }

    static boolean i(CollageCreatorView collagecreatorview)
    {
        return collagecreatorview.O;
    }

    static int j(CollageCreatorView collagecreatorview)
    {
        return collagecreatorview.d;
    }

    static RectF k(CollageCreatorView collagecreatorview)
    {
        return collagecreatorview.E;
    }

    public static ArrayList l(CollageCreatorView collagecreatorview)
    {
        return collagecreatorview.b;
    }

    static ControlPoint m(CollageCreatorView collagecreatorview)
    {
        return collagecreatorview.P;
    }

    static com.picsart.collages.g n(CollageCreatorView collagecreatorview)
    {
        return collagecreatorview.Q;
    }

    static boolean o(CollageCreatorView collagecreatorview)
    {
        return collagecreatorview.I;
    }

    static boolean p(CollageCreatorView collagecreatorview)
    {
        return collagecreatorview.ak;
    }

    static boolean q(CollageCreatorView collagecreatorview)
    {
        return collagecreatorview.af;
    }

    static float r(CollageCreatorView collagecreatorview)
    {
        return collagecreatorview.ag;
    }

    static float s(CollageCreatorView collagecreatorview)
    {
        return collagecreatorview.ah;
    }

    static int t(CollageCreatorView collagecreatorview)
    {
        return collagecreatorview.ai;
    }

    static boolean u(CollageCreatorView collagecreatorview)
    {
        return collagecreatorview.aj;
    }

    static Bitmap v(CollageCreatorView collagecreatorview)
    {
        return collagecreatorview.D;
    }

    static boolean w(CollageCreatorView collagecreatorview)
    {
        collagecreatorview.r = true;
        return true;
    }

    static PointF x(CollageCreatorView collagecreatorview)
    {
        return collagecreatorview.B;
    }

    static float y(CollageCreatorView collagecreatorview)
    {
        collagecreatorview.ad = 0.0F;
        return 0.0F;
    }

    static PointF z(CollageCreatorView collagecreatorview)
    {
        return collagecreatorview.x;
    }

    public final int a()
    {
        int j1 = PicsartContext.a.getCollageImageMaxSize();
        int i1 = j1;
        if (b.size() > PicsartContext.a.getAddPhotoMaxCount())
        {
            i1 = (j1 * PicsartContext.a.getAddPhotoMaxCount()) / b.size();
        }
        return i1;
    }

    public final com.picsart.collages.a a(int i1)
    {
        return (com.picsart.collages.a)b.get(i1);
    }

    public final com.picsart.collages.a a(ArrayList arraylist)
    {
        float f1 = b();
        arraylist = new com.picsart.collages.a(arraylist, f1, BitmapFactory.decodeResource(getResources(), 0x7f0202f7));
        arraylist.t = this;
        b.add(arraylist);
        g.set(0.0F, 0.0F, f1, f1);
        invalidate();
        f1 = b();
        com.picsart.collages.a a1;
        for (Iterator iterator = b.iterator(); iterator.hasNext(); a1.a(i))
        {
            a1 = (com.picsart.collages.a)iterator.next();
            a1.c(M);
            a1.b(f1);
            a1.d(c);
            a1.p = e;
        }

        return arraylist;
    }

    final void a(int i1, int j1)
    {
        if (i1 == j1 || i1 == -1 || j1 == -1 || i1 > b.size() || j1 > b.size())
        {
            return;
        } else
        {
            Object obj1 = (com.picsart.collages.a)b.get(i1);
            Object obj = (com.picsart.collages.a)b.get(j1);
            Object obj2 = ((com.picsart.collages.a) (obj1)).x;
            Bitmap bitmap = ((com.picsart.collages.a) (obj1)).d;
            int k1 = ((com.picsart.collages.a) (obj1)).e();
            int l1 = ((com.picsart.collages.a) (obj)).e();
            ((com.picsart.collages.a) (obj1)).a(((com.picsart.collages.a) (obj)).d, false, ((com.picsart.collages.a) (obj)).x, true);
            ((com.picsart.collages.a) (obj)).a(bitmap, false, ((CollageImage) (obj2)), true);
            obj2 = ((com.picsart.collages.a) (obj1)).b();
            ((com.picsart.collages.a) (obj1)).b(l1, ((PointF) (obj2)).x, ((PointF) (obj2)).y);
            obj1 = ((com.picsart.collages.a) (obj)).b();
            ((com.picsart.collages.a) (obj)).b(k1, ((PointF) (obj1)).x, ((PointF) (obj1)).y);
            obj = (CollageImage)s.remove(Integer.valueOf(i1));
            obj1 = (CollageImage)s.remove(Integer.valueOf(j1));
            s.put(Integer.valueOf(i1), obj1);
            s.put(Integer.valueOf(j1), obj);
            return;
        }
    }

    public final void a(Activity activity, String s1, com.picsart.collages.f f1)
    {
        (new ModernAsyncTask(s1, activity, f1) {

            private String a;
            private Activity b;
            private com.picsart.collages.f c;
            private CollageCreatorView d;

            private transient Void a()
            {
                CollageCreatorView.c(d, PicsartContext.a.getMaxCollageSaveSize());
                com.picsart.collages.CollageCreatorView.d(d, PicsartContext.a.getMaxCollageSaveSize());
                int j1 = PicsartContext.a.getMaxCollageSaveSize();
                float f3;
                float f4;
                Object obj1;
                Exception exception2;
                Object obj2;
                Object obj3;
                com.picsart.collages.a a2;
                Exception exception3;
                int i1;
                int k1;
                int l1;
                if (CollageCreatorView.F(d) != null && !CollageCreatorView.F(d).isRecycled())
                {
                    CollageCreatorView.F(d).recycle();
                    Object obj = com.socialin.android.util.w.a(CollageCreatorView.G(d));
                    i1 = j1;
                    if (Math.min(((android.graphics.BitmapFactory.Options) (obj)).outWidth, ((android.graphics.BitmapFactory.Options) (obj)).outHeight) < j1)
                    {
                        i1 = Math.min(((android.graphics.BitmapFactory.Options) (obj)).outWidth, ((android.graphics.BitmapFactory.Options) (obj)).outHeight);
                        CollageCreatorView.c(d, i1);
                        com.picsart.collages.CollageCreatorView.d(d, i1);
                    }
                    float f2 = (float)i1 / (float)Math.min(((android.graphics.BitmapFactory.Options) (obj)).outWidth, ((android.graphics.BitmapFactory.Options) (obj)).outHeight);
                    com.picsart.collages.a a1;
                    try
                    {
                        com.picsart.collages.CollageCreatorView.b(d, com.socialin.android.util.w.a(CollageCreatorView.G(d), (int)((float)((android.graphics.BitmapFactory.Options) (obj)).outWidth * f2), (int)(f2 * (float)((android.graphics.BitmapFactory.Options) (obj)).outHeight), ((android.graphics.BitmapFactory.Options) (obj)).outWidth, ((android.graphics.BitmapFactory.Options) (obj)).outHeight, myobfuscated.f.m.d(CollageCreatorView.G(d))));
                    }
                    catch (Exception exception)
                    {
                        exception.printStackTrace();
                    }
                } else
                {
                    i1 = j1;
                }
                if (CollageCreatorView.H(d))
                {
                    obj = com.socialin.android.util.w.a(CollageCreatorView.G(d));
                    CollageCreatorView.c(d, ((android.graphics.BitmapFactory.Options) (obj)).outWidth);
                    com.picsart.collages.CollageCreatorView.d(d, ((android.graphics.BitmapFactory.Options) (obj)).outHeight);
                    i1 = Math.max(CollageCreatorView.I(d), CollageCreatorView.J(d));
                } else
                if (CollageCreatorView.K(d) > 1.0F)
                {
                    com.picsart.collages.CollageCreatorView.d(d, (int)((float)CollageCreatorView.I(d) / CollageCreatorView.K(d)));
                } else
                {
                    CollageCreatorView.c(d, (int)((float)CollageCreatorView.J(d) * CollageCreatorView.K(d)));
                }
                obj = com.picsart.collages.CollageCreatorView.l(d).iterator();
                do
                {
                    if (!((Iterator) (obj)).hasNext())
                    {
                        break;
                    }
                    a1 = (com.picsart.collages.a)((Iterator) (obj)).next();
                    if (a1.d != null && !a1.d.isRecycled())
                    {
                        a1.d.recycle();
                    }
                } while (true);
                f3 = d.b();
                f4 = (float)i1 / f3;
                obj2 = Bitmap.createBitmap(CollageCreatorView.I(d), CollageCreatorView.J(d), android.graphics.Bitmap.Config.ARGB_8888);
                obj3 = new Canvas(((Bitmap) (obj2)));
                if (!CollageCreatorView.H(d))
                {
                    if (CollageCreatorView.F(d) == null || CollageCreatorView.F(d).isRecycled())
                    {
                        ((Canvas) (obj3)).drawRect(new RectF(0.0F, 0.0F, CollageCreatorView.L(d).width() * f4, CollageCreatorView.L(d).height() * f4), CollageCreatorView.M(d));
                    } else
                    {
                        j1 = (CollageCreatorView.I(d) - CollageCreatorView.F(d).getWidth()) / 2;
                        k1 = (CollageCreatorView.J(d) - CollageCreatorView.F(d).getHeight()) / 2;
                        ((Canvas) (obj3)).drawBitmap(CollageCreatorView.F(d), j1, k1, CollageCreatorView.M(d));
                        ((Canvas) (obj3)).save();
                        ((Canvas) (obj3)).scale(f4, f4);
                        ((Canvas) (obj3)).restore();
                        CollageCreatorView.F(d).recycle();
                        j1 = (int)((com.picsart.collages.a)com.picsart.collages.CollageCreatorView.l(d).get(0)).o;
                        try
                        {
                            com.picsart.collages.CollageCreatorView.b(d, com.socialin.android.util.w.a(CollageCreatorView.G(d), j1, j1, myobfuscated.f.m.d(CollageCreatorView.G(d))));
                        }
                        catch (Exception exception1)
                        {
                            exception1.printStackTrace();
                        }
                    }
                }
                ((Canvas) (obj3)).save();
                ((Canvas) (obj3)).scale(f4, f4);
                k1 = com.picsart.collages.CollageCreatorView.l(d).size();
                j1 = 0;
                if (j1 >= k1)
                {
                    break MISSING_BLOCK_LABEL_1062;
                }
                a2 = (com.picsart.collages.a)com.picsart.collages.CollageCreatorView.l(d).get(j1);
                if (a2.x != null)
                {
                    break; /* Loop/switch isn't completed */
                }
                if (CollageCreatorView.H(d))
                {
                    a2.a(((Canvas) (obj3)), CollageCreatorView.N(d) + CollageCreatorView.O(d), CollageCreatorView.N(d) + CollageCreatorView.O(d));
                }
_L4:
                j1++;
                if (true) goto _L2; else goto _L1
_L2:
                break MISSING_BLOCK_LABEL_556;
_L1:
label0:
                {
                    if (a2.x.isFromBuffer() || a2.x.getPath() != null)
                    {
                        break label0;
                    }
                    if (CollageCreatorView.H(d))
                    {
                        a2.a(((Canvas) (obj3)), CollageCreatorView.N(d) + CollageCreatorView.O(d), CollageCreatorView.N(d) + CollageCreatorView.O(d));
                    }
                }
                continue; /* Loop/switch isn't completed */
                if ((a2.e.width() * a2.e.height()) / (float)(i1 * i1) > 0.25F)
                {
                    f3 = 2.0F;
                } else
                {
                    f3 = 1.5F;
                }
                l1 = (int)(f3 * (float)PicsartContext.a.getMaxCollageSaveSize());
                if (!a2.x.isFromBuffer())
                {
                    break MISSING_BLOCK_LABEL_1028;
                }
                obj1 = com.socialin.android.util.w.a(a2.x.getBufferData(), l1, l1, a2.w);
_L5:
                a2.a(((Bitmap) (obj1)), true, a2.x, false);
                a2.a(((Canvas) (obj3)), CollageCreatorView.N(d) + CollageCreatorView.O(d), CollageCreatorView.N(d) + CollageCreatorView.O(d));
                if (a2.d != null)
                {
                    a2.d.recycle();
                }
                if (true) goto _L4; else goto _L3
_L3:
                try
                {
                    obj1 = com.socialin.android.util.w.a(a2.x.getPath(), l1, l1, a2.w);
                }
                // Misplaced declaration of an exception variable
                catch (Exception exception2)
                {
                    exception2.printStackTrace();
                    exception2 = null;
                }
                  goto _L5
                if (true) goto _L4; else goto _L6
_L6:
                ((Canvas) (obj3)).restore();
                if (CollageCreatorView.H(d))
                {
                    new Rect(0, 0, i1, i1);
                    ((Canvas) (obj3)).drawBitmap(CollageCreatorView.F(d), 0.0F, 0.0F, CollageCreatorView.M(d));
                    ((Canvas) (obj3)).save();
                    ((Canvas) (obj3)).scale(f4, f4);
                    ((Canvas) (obj3)).restore();
                    CollageCreatorView.F(d).recycle();
                    i1 = (int)((com.picsart.collages.a)com.picsart.collages.CollageCreatorView.l(d).get(0)).o;
                    try
                    {
                        com.picsart.collages.CollageCreatorView.b(d, com.socialin.android.util.w.a(CollageCreatorView.G(d), i1, i1, 0));
                    }
                    // Misplaced declaration of an exception variable
                    catch (Exception exception2)
                    {
                        exception2.printStackTrace();
                    }
                }
                com.socialin.android.util.w.a(new File(a), ((Bitmap) (obj2)), android.graphics.Bitmap.CompressFormat.JPEG, b);
                ((Bitmap) (obj2)).recycle();
                i1 = 0;
                if (i1 >= k1) goto _L8; else goto _L7
_L7:
                obj2 = (com.picsart.collages.a)com.picsart.collages.CollageCreatorView.l(d).get(i1);
                if (((com.picsart.collages.a) (obj2)).x == null) goto _L10; else goto _L9
_L9:
                obj3 = ((com.picsart.collages.a) (obj2)).x;
                exception2 = ((com.picsart.collages.a) (obj2)).i;
                if (((com.picsart.collages.a) (obj2)).s != null)
                {
                    ((com.picsart.collages.a) (obj2)).s.cancel(true);
                }
                obj2.x = ((CollageImage) (obj3));
                if (exception2 != null)
                {
                    obj2.i = exception2;
                }
                if (obj3 == null) goto _L12; else goto _L11
_L11:
                j1 = ((com.picsart.collages.a) (obj2)).t.a();
                if (!((CollageImage) (obj3)).isFromBuffer()) goto _L14; else goto _L13
_L13:
                exception2 = com.socialin.android.util.w.a(((CollageImage) (obj3)).getBufferData(), j1, j1, ((CollageImage) (obj3)).getDegree());
                (new StringBuilder("loaded size  = ")).append(exception2.getWidth()).append(" ").append(exception2.getHeight());
_L16:
                ((com.picsart.collages.a) (obj2)).a(exception2, true, ((CollageImage) (obj3)), false);
                ((com.picsart.collages.a) (obj2)).c();
                obj2.v = false;
_L10:
                i1++;
                break MISSING_BLOCK_LABEL_1215;
_L14:
                exception2 = com.socialin.android.util.w.a(((CollageImage) (obj3)).getPath(), j1, j1, ((CollageImage) (obj3)).getDegree());
                try
                {
                    (new StringBuilder("loaded size  = ")).append(exception2.getWidth()).append(" ").append(exception2.getHeight());
                }
                // Misplaced declaration of an exception variable
                catch (Exception exception3) { }
                continue; /* Loop/switch isn't completed */
_L12:
                ((com.picsart.collages.a) (obj2)).a(null, true, ((CollageImage) (obj3)), true);
                obj2.v = false;
                if (true) goto _L10; else goto _L8
_L8:
                return null;
                continue; /* Loop/switch isn't completed */
                exception2;
                exception2 = null;
                if (true) goto _L16; else goto _L15
_L15:
            }

            protected final Object doInBackground(Object aobj[])
            {
                return a();
            }

            protected final void onPostExecute(Object obj)
            {
                super.onPostExecute((Void)obj);
                com.picsart.collages.CollageCreatorView.h(d, false);
                d.invalidate();
                if (c != null)
                {
                    c.a(a);
                }
            }

            protected final void onPreExecute()
            {
                com.picsart.collages.CollageCreatorView.h(d, true);
                super.onPreExecute();
            }

            
            {
                d = CollageCreatorView.this;
                a = s1;
                b = activity;
                c = f1;
                super();
            }
        }).execute(new Void[0]);
    }

    public final float b()
    {
        float f7 = getWidth();
        float f8 = getHeight();
        if (o % 180 == 0)
        {
            float f1 = Math.min(f7 / i, f8);
            f1 = Math.max(i * f1, f1);
            float f3;
            float f5;
            if (i >= 1.0F)
            {
                f3 = (1.0F / i) * f1;
                f5 = f1;
            } else
            {
                f5 = i * f1;
                f3 = f1;
            }
            L = Math.abs(f3 - f8) / 2.0F;
            K = Math.abs(f5 - f7) / 2.0F;
            return f1;
        }
        float f2 = Math.min(f8 / i, f7);
        f2 = Math.max(i * f2, f2);
        float f4;
        float f6;
        if (i >= 1.0F)
        {
            f6 = (1.0F / i) * f2;
            f4 = f2;
        } else
        {
            f4 = i * f2;
            f6 = f2;
        }
        L = Math.abs(f4 - f8) / 2.0F;
        K = Math.abs(f6 - f7) / 2.0F;
        return f2;
    }

    public final int[] c()
    {
        int ai1[] = new int[d()];
        int i1 = 0;
        while (i1 < ai1.length) 
        {
            int j1;
            if (s.get(Integer.valueOf(i1)) == null)
            {
                j1 = 0;
            } else
            {
                j1 = ((CollageImage)s.get(Integer.valueOf(i1))).getDegree();
            }
            ai1[i1] = j1;
            i1++;
        }
        return ai1;
    }

    public final int d()
    {
        Iterator iterator = s.keySet().iterator();
        int i1;
        for (i1 = -1; iterator.hasNext(); i1 = Math.max(i1, ((Integer)iterator.next()).intValue())) { }
        return i1 + 1;
    }

    public final com.picsart.collages.a e()
    {
        if (d == -1)
        {
            return null;
        } else
        {
            return (com.picsart.collages.a)b.get(d);
        }
    }

    protected void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
    }

    protected void onDraw(Canvas canvas)
    {
        if (!S) goto _L2; else goto _L1
_L1:
        return;
_L2:
        super.onDraw(canvas);
        canvas.translate(K, L);
        canvas.clipRect(g);
        canvas.drawColor(V);
        int j1 = b.size();
        int i1;
        if (!q)
        {
            if (k == null)
            {
                canvas.drawRect(g, a);
            } else
            {
                a.setXfermode(W);
                canvas.drawRect(g, a);
                a.setXfermode(aa);
                canvas.drawBitmap(k, l, h, a);
                a.setXfermode(null);
            }
        }
        i1 = 0;
        while (i1 < j1) 
        {
            com.picsart.collages.a a1 = (com.picsart.collages.a)b.get(i1);
            float f1 = f;
            float f2 = e;
            float f3 = f;
            float f4 = e;
            boolean flag;
            if (j && i1 == G)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            a1.a(canvas, f2 + f1, f4 + f3, flag);
            i1++;
        }
        if (q)
        {
            canvas.drawBitmap(k, l, g, a);
        }
        if (b.size() > d && d != -1)
        {
            com.picsart.collages.a a2 = (com.picsart.collages.a)b.get(d);
            android.graphics.Path path = a2.n;
            canvas.save();
            canvas.translate(f + e, f + e);
            canvas.rotate(a2.q, a2.a().x, a2.a().y);
            if (J)
            {
                Bitmap bitmap = a2.d;
                if (bitmap != null && !bitmap.isRecycled())
                {
                    canvas.drawBitmap(bitmap, a2.i, u);
                }
            }
            canvas.drawPath(path, t);
            canvas.restore();
        }
        if (j && D != null && !D.isRecycled())
        {
            canvas.drawBitmap(D, F, E, u);
        }
        if (m != null && p)
        {
            Iterator iterator = g().iterator();
            while (iterator.hasNext()) 
            {
                PointF pointf = (PointF)iterator.next();
                ab.setBounds((int)(pointf.x - (float)(ac / 2)), (int)(pointf.y - (float)(ac / 2)), (int)(pointf.x + (float)(ac / 2)), (int)(pointf.y + (float)(ac / 2)));
                ab.draw(canvas);
            }
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        if (b.size() > 0)
        {
            w.a(motionevent);
        }
        motionevent.getAction();
        JVM INSTR tableswitch 0 2: default 48
    //                   0 48
    //                   1 56
    //                   2 48;
           goto _L1 _L1 _L2 _L1
_L1:
        super.onTouchEvent(motionevent);
        return true;
_L2:
        if (j)
        {
            if (d != G && d != -1)
            {
                a(G, d);
                d = G;
            }
            j = false;
            invalidate();
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public void setActiveCellIndex(int i1)
    {
        d = i1;
        if (i1 == -1)
        {
            R.b();
            return;
        } else
        {
            R.a();
            return;
        }
    }

    public void setBackgroundBitmap(Bitmap bitmap, String s1)
    {
label0:
        {
            n = s1;
            if (k != null)
            {
                k.recycle();
            }
            k = bitmap;
            if (bitmap != null)
            {
                l.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
                if ((float)bitmap.getWidth() >= g.width() && (float)bitmap.getHeight() >= g.height())
                {
                    break label0;
                }
                float f2 = Math.max(g.width() / (float)bitmap.getWidth(), g.height() / (float)bitmap.getHeight());
                float f1 = (float)bitmap.getWidth() * f2;
                f2 *= bitmap.getHeight();
                h.set((g.width() - f1) / 2.0F, (g.height() - f2) / 2.0F, (f1 + g.width()) / 2.0F, (f2 + g.height()) / 2.0F);
            }
            return;
        }
        h.set((g.width() - (float)bitmap.getWidth()) / 2.0F, (g.height() - (float)bitmap.getHeight()) / 2.0F, (g.width() + (float)bitmap.getWidth()) / 2.0F, (g.height() + (float)bitmap.getHeight()) / 2.0F);
    }

    public void setBackgroundColor(int i1)
    {
        a.setColor(i1);
    }

    public void setBorderWidth(float f1)
    {
        f = f1;
        f1 = b();
        for (Iterator iterator = b.iterator(); iterator.hasNext(); ((com.picsart.collages.a)iterator.next()).b(f1)) { }
        f1 = b();
        float f2;
        if (i > 1.0F)
        {
            f2 = (1.0F / i) * f1;
        } else
        {
            float f3 = i;
            f2 = f1;
            f1 = f3 * f1;
        }
        if (o % 180 == 0)
        {
            float f4 = f1;
            f1 = f2;
            f2 = f4;
        }
        g.set(0.0F, 0.0F, f2, f1);
        invalidate();
    }

    public void setChanged(boolean flag)
    {
        r = flag;
    }

    public void setCollageAspectRatio(float f1)
    {
        i = f1;
        int j1 = b.size();
        float f2 = b();
        for (Iterator iterator = b.iterator(); iterator.hasNext(); ((com.picsart.collages.a)iterator.next()).b(f2)) { }
        for (int i1 = 0; i1 < j1; i1++)
        {
            ((com.picsart.collages.a)b.get(i1)).a(f1);
        }

        if (b.size() > 0)
        {
            com.picsart.collages.a a1 = (com.picsart.collages.a)b.get(0);
            f1 = a1.k;
            f2 = a1.l;
        } else
        {
            f1 = 0.0F;
            f2 = 0.0F;
        }
        g.set(0.0F, 0.0F, f1 + (e + f) * 2.0F, f2 + (e + f) * 2.0F);
    }

    public void setCollageRotateAngle(int i1)
    {
        o = i1;
        com.picsart.collages.a a2;
        for (Iterator iterator = b.iterator(); iterator.hasNext(); a2.a(i))
        {
            a2 = (com.picsart.collages.a)iterator.next();
            a2.m = i1;
            int k1 = a2.a.size();
            float f1 = (float)Math.toRadians(i1);
            for (int j1 = 0; j1 < k1; j1++)
            {
                a2.b.set(j1, ((SPArrow)a2.b.get(j1)).rotateBy(f1, 0.5F, 0.5F));
            }

        }

        float f2 = b();
        for (Iterator iterator1 = b.iterator(); iterator1.hasNext(); ((com.picsart.collages.a)iterator1.next()).b(f2)) { }
        float f3;
        if (b.size() > 0)
        {
            com.picsart.collages.a a1 = (com.picsart.collages.a)b.get(0);
            f2 = a1.k;
            f3 = a1.l;
        } else
        {
            f2 = 0.0F;
            f3 = 0.0F;
        }
        g.set(0.0F, 0.0F, f2 + (e + f) * 2.0F, f3 + (e + f) * 2.0F);
        invalidate();
    }

    public void setControls(ArrayList arraylist)
    {
        m = arraylist;
    }

    public void setControlsVisible(boolean flag)
    {
        p = flag;
    }

    public void setCornerRadiusPercent(int i1)
    {
        c = i1;
        for (Iterator iterator = b.iterator(); iterator.hasNext(); ((com.picsart.collages.a)iterator.next()).d(i1)) { }
        invalidate();
    }

    public void setImageSelectListener(c c1)
    {
        C = c1;
    }

    public void setImageToCell(CollageImage collageimage, int i1, boolean flag, Matrix matrix, boolean flag1)
    {
        setImageToCell(collageimage, i1, flag, matrix, flag1, null);
    }

    public void setImageToCell(CollageImage collageimage, int i1, boolean flag, Matrix matrix, boolean flag1, myobfuscated.ax.a a1)
    {
        s.put(Integer.valueOf(i1), collageimage);
        if (b != null && b.size() > i1)
        {
            ((com.picsart.collages.a)b.get(i1)).v = true;
            ((com.picsart.collages.a)b.get(i1)).a(collageimage, flag, matrix, flag1, a1);
        }
    }

    public void setIsCollageFrame(boolean flag)
    {
        q = flag;
        invalidate();
    }

    public void setOnCellActivatedListener(com.picsart.collages.b b1)
    {
        R = b1;
    }

    public void setOnCellChangedListener(com.picsart.collages.g g1)
    {
        Q = g1;
    }

    public void setOuterBorderWidth(float f1)
    {
        e = f1;
        float f2 = b();
        com.picsart.collages.a a1;
        for (Iterator iterator = b.iterator(); iterator.hasNext(); a1.b(f2))
        {
            a1 = (com.picsart.collages.a)iterator.next();
            a1.p = f1;
        }

        if (i > 1.0F)
        {
            f1 = (1.0F / i) * f2;
        } else
        {
            float f3 = i * f2;
            f1 = f2;
            f2 = f3;
        }
        if (o % 180 == 0)
        {
            float f4 = f1;
            f1 = f2;
            f2 = f4;
        }
        g.set(0.0F, 0.0F, f1, f2);
        invalidate();
    }

    public void setStrokeWidth(float f1)
    {
        M = f1;
        for (Iterator iterator = b.iterator(); iterator.hasNext(); ((com.picsart.collages.a)iterator.next()).c(f1)) { }
        invalidate();
    }
}

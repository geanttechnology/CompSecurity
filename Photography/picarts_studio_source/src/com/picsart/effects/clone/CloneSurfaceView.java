// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.effects.clone;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.picsart.studio.EditingData;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.util.c;
import java.util.ArrayList;
import myobfuscated.ay.e;
import myobfuscated.bc.b;
import myobfuscated.dc.a;
import org.json.JSONArray;

// Referenced classes of package com.picsart.effects.clone:
//            a, b, f, g, 
//            e, CloneActivity

public class CloneSurfaceView extends SurfaceView
    implements android.os.Handler.Callback, android.view.SurfaceHolder.Callback
{

    private Canvas A;
    private Bitmap B;
    private Canvas C;
    private Bitmap D;
    private Canvas E;
    private Bitmap F;
    private Paint G;
    private Paint H;
    private Paint I;
    private float J;
    private float K;
    private boolean L;
    private boolean M;
    private boolean N;
    private RectF O;
    private Rect P;
    private Path Q;
    private Path R;
    private int S;
    private int T;
    private int U;
    private int V;
    private com.picsart.effects.clone.a W;
    Handler a;
    private float aa;
    private float ab;
    private int ac;
    private int ad;
    private PointF ae;
    private boolean af;
    private PointF ag;
    private f ah;
    private ArrayList ai;
    private boolean aj;
    boolean b;
    boolean c;
    float d;
    int e;
    float f;
    boolean g;
    private boolean h;
    private com.picsart.effects.clone.e i;
    private Bitmap j;
    private Bitmap k;
    private Paint l;
    private int m;
    private HandlerThread n;
    private RectF o;
    private RectF p;
    private RectF q;
    private RectF r;
    private RectF s;
    private boolean t;
    private boolean u;
    private float v;
    private int w;
    private int x;
    private int y;
    private int z;

    public CloneSurfaceView(Context context)
    {
        super(context);
        m = 100;
        o = new RectF();
        p = new RectF();
        q = new RectF();
        r = new RectF();
        s = new RectF();
        t = false;
        u = false;
        b = false;
        c = false;
        v = 1.0F;
        w = 0;
        x = 0;
        L = false;
        M = false;
        N = false;
        O = new RectF();
        P = new Rect();
        Q = new Path();
        R = new Path();
        S = 0;
        T = 0;
        U = 0;
        V = 0;
        aa = -1F;
        ab = -1F;
        ac = 0;
        d = 25F;
        e = 0;
        ad = 50;
        f = 30F;
        g = true;
        ae = new PointF();
        af = false;
        ag = new PointF();
        ai = new ArrayList();
        aj = false;
        a();
    }

    public CloneSurfaceView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        m = 100;
        o = new RectF();
        p = new RectF();
        q = new RectF();
        r = new RectF();
        s = new RectF();
        t = false;
        u = false;
        b = false;
        c = false;
        v = 1.0F;
        w = 0;
        x = 0;
        L = false;
        M = false;
        N = false;
        O = new RectF();
        P = new Rect();
        Q = new Path();
        R = new Path();
        S = 0;
        T = 0;
        U = 0;
        V = 0;
        aa = -1F;
        ab = -1F;
        ac = 0;
        d = 25F;
        e = 0;
        ad = 50;
        f = 30F;
        g = true;
        ae = new PointF();
        af = false;
        ag = new PointF();
        ai = new ArrayList();
        aj = false;
        a();
    }

    public CloneSurfaceView(Context context, AttributeSet attributeset, int i1)
    {
        super(context, attributeset, i1);
        m = 100;
        o = new RectF();
        p = new RectF();
        q = new RectF();
        r = new RectF();
        s = new RectF();
        t = false;
        u = false;
        b = false;
        c = false;
        v = 1.0F;
        w = 0;
        x = 0;
        L = false;
        M = false;
        N = false;
        O = new RectF();
        P = new Rect();
        Q = new Path();
        R = new Path();
        S = 0;
        T = 0;
        U = 0;
        V = 0;
        aa = -1F;
        ab = -1F;
        ac = 0;
        d = 25F;
        e = 0;
        ad = 50;
        f = 30F;
        g = true;
        ae = new PointF();
        af = false;
        ag = new PointF();
        ai = new ArrayList();
        aj = false;
        a();
    }

    private void a()
    {
        getHolder().addCallback(this);
        setFocusable(true);
        l = new Paint();
        l.setFilterBitmap(true);
        l.setDither(true);
        G = new Paint();
        G.setAntiAlias(true);
        G.setDither(true);
        G.setStyle(android.graphics.Paint.Style.STROKE);
        G.setStrokeJoin(android.graphics.Paint.Join.ROUND);
        G.setStrokeCap(android.graphics.Paint.Cap.ROUND);
        G.setStrokeWidth(ad);
        G.setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.CLEAR));
        G.setFilterBitmap(true);
        if (d > 0.0F)
        {
            G.setMaskFilter(new BlurMaskFilter((G.getStrokeWidth() * d) / 100F, android.graphics.BlurMaskFilter.Blur.NORMAL));
        }
        H = new Paint();
        H.setAntiAlias(true);
        H.setDither(true);
        H.setStyle(android.graphics.Paint.Style.STROKE);
        H.setStrokeJoin(android.graphics.Paint.Join.ROUND);
        H.setStrokeCap(android.graphics.Paint.Cap.ROUND);
        H.setStrokeWidth(ad);
        H.setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.DST_OVER));
        H.setFilterBitmap(true);
        H.setColor(0xffff0000);
        I = new Paint();
        I.setAntiAlias(true);
        I.setDither(true);
        I.setStyle(android.graphics.Paint.Style.STROKE);
        I.setStrokeJoin(android.graphics.Paint.Join.ROUND);
        I.setStrokeCap(android.graphics.Paint.Cap.ROUND);
        I.setStrokeWidth(2.0F);
        I.setFilterBitmap(true);
        I.setColor(-1);
        I.setStrokeWidth(TypedValue.applyDimension(1, 1.5F, getContext().getResources().getDisplayMetrics()));
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            m = 30;
        }
    }

    private void a(int i1, float f1)
    {
        G.setStrokeWidth(i1);
        BlurMaskFilter blurmaskfilter = null;
        if (f1 > 0.0F)
        {
            blurmaskfilter = new BlurMaskFilter((G.getStrokeWidth() * f1) / 100F, android.graphics.BlurMaskFilter.Blur.NORMAL);
        }
        G.setMaskFilter(blurmaskfilter);
    }

    private void a(int i1, float f1, float f2)
    {
        i1;
        JVM INSTR tableswitch 0 2: default 28
    //                   0 91
    //                   1 28
    //                   2 122;
           goto _L1 _L2 _L1 _L3
_L1:
        o.set(S, T, U + S, V + T);
        if (W != null && W.d != null)
        {
            c();
        }
        d();
        return;
_L2:
        ag.x = f1 - (float)S;
        ag.y = f2 - (float)T;
        continue; /* Loop/switch isn't completed */
_L3:
        S = (int)(f1 - ag.x);
        T = (int)(f2 - ag.y);
        if (true) goto _L1; else goto _L4
_L4:
    }

    private void a(Canvas canvas, Bitmap bitmap, Canvas canvas1, Bitmap bitmap1, Bitmap bitmap2, float f1)
    {
        canvas.drawBitmap(bitmap2, 0.0F, 0.0F, l);
        canvas1.drawBitmap(bitmap2, 0.0F, 0.0F, l);
        Matrix matrix = new Matrix();
        int i1 = 0;
        while (i1 < ai.size()) 
        {
            Object obj = (com.picsart.effects.clone.b)ai.get(i1);
            int j1 = (int)((float)((com.picsart.effects.clone.b) (obj)).b * f1);
            int k1 = ((com.picsart.effects.clone.b) (obj)).c;
            a(j1, ((com.picsart.effects.clone.b) (obj)).d);
            Path path = ((com.picsart.effects.clone.b) (obj)).a;
            if (f1 > 1.0F)
            {
                matrix.reset();
                matrix.setScale(f1, f1);
                path.transform(matrix);
            }
            if (((com.picsart.effects.clone.b) (obj)).g)
            {
                RectF rectf = ((com.picsart.effects.clone.b) (obj)).f;
                obj = ((com.picsart.effects.clone.b) (obj)).e;
                if (f1 > 1.0F)
                {
                    rectf.left = rectf.left * f1;
                    rectf.right = rectf.right * f1;
                    rectf.top = rectf.top * f1;
                    rectf.bottom = rectf.bottom * f1;
                    obj.left = ((RectF) (obj)).left * f1;
                    obj.right = ((RectF) (obj)).right * f1;
                    obj.top = ((RectF) (obj)).top * f1;
                    obj.bottom = ((RectF) (obj)).bottom * f1;
                }
                canvas.save();
                canvas.clipRect(rectf);
                canvas.drawPath(path, G);
                if (k1 > 0)
                {
                    H.setAlpha(k1);
                    canvas.drawBitmap(bitmap1, 0.0F, 0.0F, H);
                    H.setAlpha(255);
                }
                canvas.drawBitmap(bitmap1, null, ((RectF) (obj)), H);
                canvas.restore();
            } else
            {
                canvas.drawPath(path, G);
                if (k1 > 0)
                {
                    H.setAlpha(k1);
                    canvas.drawBitmap(bitmap1, 0.0F, 0.0F, H);
                    H.setAlpha(255);
                }
                canvas.drawBitmap(bitmap2, 0.0F, 0.0F, H);
            }
            canvas1.drawBitmap(bitmap, 0.0F, 0.0F, l);
            i1++;
        }
        a(ad, d);
    }

    private void a(Rect rect)
    {
        Object obj;
        SurfaceHolder surfaceholder;
        surfaceholder = getHolder();
        obj = null;
        rect = surfaceholder.lockCanvas(rect);
        obj = rect;
        rect.drawBitmap(B, 0.0F, 0.0F, l);
        obj = rect;
        if (!N)
        {
            break MISSING_BLOCK_LABEL_85;
        }
        obj = rect;
        if (L)
        {
            break MISSING_BLOCK_LABEL_85;
        }
        obj = rect;
        if (g)
        {
            break MISSING_BLOCK_LABEL_85;
        }
        obj = rect;
        rect.drawCircle(J, K, ad / 2, I);
        obj = rect;
        if (W == null)
        {
            break MISSING_BLOCK_LABEL_104;
        }
        obj = rect;
        W.a(rect);
        if (rect != null)
        {
            surfaceholder.unlockCanvasAndPost(rect);
        }
_L2:
        return;
        rect;
        if (obj == null) goto _L2; else goto _L1
_L1:
        surfaceholder.unlockCanvasAndPost(((Canvas) (obj)));
        return;
        rect;
        Object obj1;
        obj1 = null;
        obj = rect;
_L4:
        if (obj1 != null)
        {
            surfaceholder.unlockCanvasAndPost(((Canvas) (obj1)));
        }
        throw obj;
        obj;
        obj1 = rect;
        if (true) goto _L4; else goto _L3
_L3:
    }

    static boolean a(CloneSurfaceView clonesurfaceview)
    {
        clonesurfaceview.u = true;
        return true;
    }

    static Handler b(CloneSurfaceView clonesurfaceview)
    {
        return clonesurfaceview.a;
    }

    private void b()
    {
        if (a != null)
        {
            a.removeMessages(13);
            a.removeMessages(14);
            a.removeMessages(15);
            a.removeMessages(12);
            a.removeMessages(4);
        }
    }

    static f c(CloneSurfaceView clonesurfaceview)
    {
        return clonesurfaceview.ah;
    }

    private void c()
    {
        PointF pointf = W.d;
        ae.x = pointf.x * o.width();
        ae.y = pointf.y * o.height();
        r.set(o.left + ae.x, o.top + ae.y, o.right + ae.x, o.bottom + ae.y);
        s.left = Math.max(r.left, o.left);
        s.top = Math.max(r.top, o.top);
        s.right = Math.min(r.right, o.right);
        s.bottom = Math.min(r.bottom, o.bottom);
    }

    private void d()
    {
        Object obj1;
        SurfaceHolder surfaceholder;
        obj1 = null;
        surfaceholder = getHolder();
        Object obj = surfaceholder.lockCanvas(null);
        obj1 = obj;
        A.drawColor(0xff000000);
        obj1 = obj;
        A.drawBitmap(D, null, o, l);
        obj1 = obj;
        ((Canvas) (obj)).drawBitmap(B, 0.0F, 0.0F, l);
        obj1 = obj;
        if (!N)
        {
            break MISSING_BLOCK_LABEL_119;
        }
        obj1 = obj;
        if (L)
        {
            break MISSING_BLOCK_LABEL_119;
        }
        obj1 = obj;
        if (g)
        {
            break MISSING_BLOCK_LABEL_119;
        }
        obj1 = obj;
        ((Canvas) (obj)).drawCircle(J, K, ad / 2, I);
        obj1 = obj;
        if (W == null)
        {
            break MISSING_BLOCK_LABEL_138;
        }
        obj1 = obj;
        W.a(((Canvas) (obj)));
        if (obj != null)
        {
            surfaceholder.unlockCanvasAndPost(((Canvas) (obj)));
        }
_L2:
        return;
        obj;
        if (obj1 == null) goto _L2; else goto _L1
_L1:
        surfaceholder.unlockCanvasAndPost(((Canvas) (obj1)));
        return;
        obj;
        Object obj2;
        obj2 = null;
        obj1 = obj;
_L4:
        if (obj2 != null)
        {
            surfaceholder.unlockCanvasAndPost(((Canvas) (obj2)));
        }
        throw obj1;
        obj1;
        obj2 = obj;
        if (true) goto _L4; else goto _L3
_L3:
    }

    static boolean d(CloneSurfaceView clonesurfaceview)
    {
        return clonesurfaceview.h;
    }

    static Bitmap e(CloneSurfaceView clonesurfaceview)
    {
        return clonesurfaceview.j;
    }

    private void e()
    {
        if (!g) goto _L2; else goto _L1
_L1:
        W.d = null;
        W.f = Color.argb(255, 51, 181, 229);
        a(W.c);
        g = false;
        L = false;
        setBrushDrawMode(0);
        if (ah != null)
        {
            ah.g();
        }
_L4:
        return;
_L2:
        if (L) goto _L4; else goto _L3
_L3:
        if (!N)
        {
            continue; /* Loop/switch isn't completed */
        }
        N = false;
        float f1 = (float)D.getWidth() / o.width();
        Object obj = new Path(Q);
        Matrix matrix = new Matrix();
        matrix.setTranslate(-o.left, -o.top);
        ((Path) (obj)).transform(matrix);
        matrix.setScale(f1, f1);
        ((Path) (obj)).transform(matrix);
        int i1 = (int)((float)ad * f1);
        C.save();
        a(i1, d);
        if (ac == 0)
        {
            RectF rectf = new RectF();
            rectf.left = (r.left - o.left) * f1;
            rectf.top = (r.top - o.top) * f1;
            rectf.right = (r.right - o.left) * f1;
            rectf.bottom = f1 * (r.bottom - o.top);
            RectF rectf1 = new RectF();
            rectf1.left = Math.max(rectf.left, 0.0F);
            rectf1.top = Math.max(rectf.top, 0.0F);
            rectf1.right = Math.min(rectf.right, y);
            rectf1.bottom = Math.min(rectf.bottom, z);
            C.clipRect(rectf1);
            C.drawPath(((Path) (obj)), G);
            if (e > 0)
            {
                H.setAlpha(e);
                C.drawBitmap(F, 0.0F, 0.0F, H);
                H.setAlpha(255);
            }
            C.drawBitmap(F, null, rectf, H);
            obj = new com.picsart.effects.clone.b(((Path) (obj)), i1, e, d, rectf, rectf1, true);
        } else
        {
            C.drawPath(((Path) (obj)), G);
            if (e > 0)
            {
                H.setAlpha(e);
                C.drawBitmap(F, 0.0F, 0.0F, H);
                H.setAlpha(255);
            }
            C.drawBitmap(k, 0.0F, 0.0F, H);
            obj = new com.picsart.effects.clone.b(((Path) (obj)), i1, e, d, null, null, false);
        }
        C.restore();
        E.drawBitmap(D, 0.0F, 0.0F, l);
        ai.add(obj);
        a(ad, d);
        ((Activity)getContext()).runOnUiThread(new Runnable() {

            private CloneSurfaceView a;

            public final void run()
            {
                CloneSurfaceView clonesurfaceview = a;
                if (clonesurfaceview.a != null)
                {
                    Message message = clonesurfaceview.a.obtainMessage();
                    message.what = 2;
                    clonesurfaceview.a(message, false);
                }
            }

            
            {
                a = CloneSurfaceView.this;
                super();
            }
        });
        if (ah != null)
        {
            ah.a(true);
        }
        if (W == null || ac != 0) goto _L4; else goto _L5
_L5:
        W.e = false;
        return;
    }

    public final void a(int i1)
    {
        if (a != null)
        {
            Message message = a.obtainMessage();
            message.what = 7;
            message.arg1 = i1;
            a(message, false);
        }
    }

    public final void a(int i1, int j1)
    {
        if (a != null)
        {
            b();
            Message message = a.obtainMessage();
            message.what = 0;
            message.arg1 = i1;
            message.arg2 = j1;
            a(message, true);
            b();
        }
        if (aa == -1F || ab == -1F)
        {
            aa = (int)TypedValue.applyDimension(1, 30F, getContext().getResources().getDisplayMetrics());
            ab = (int)TypedValue.applyDimension(1, 100F, getContext().getResources().getDisplayMetrics());
            a(30, true);
        }
        if (a != null)
        {
            a.removeMessages(14);
            a.removeMessages(13);
            a.removeMessages(15);
            a.removeMessages(12);
        }
    }

    public final void a(int i1, boolean flag)
    {
        if (a != null)
        {
            f = i1;
            a.removeMessages(4);
            Message message = a.obtainMessage();
            message.what = 4;
            message.arg1 = i1;
            a(message, flag);
        }
    }

    final void a(Message message, boolean flag)
    {
        if (a != null && t && (u || flag))
        {
            a.sendMessage(message);
        }
    }

    public final boolean a(MotionEvent motionevent)
    {
        if (a == null) goto _L2; else goto _L1
_L1:
        Message message;
        a.removeMessages(14);
        message = a.obtainMessage();
        if (a.b == null)
        {
            a.b = new a();
        }
        if (!a.b.a || !myobfuscated.bc.b.a().a(motionevent, q, p, 8F, 0.75F)) goto _L4; else goto _L3
_L3:
        boolean flag;
        a.removeMessages(12);
        message.obj = new g(new RectF(q));
        message.what = 12;
        a(message, false);
        flag = true;
_L11:
        try
        {
            Thread.sleep(m);
        }
        // Misplaced declaration of an exception variable
        catch (MotionEvent motionevent)
        {
            motionevent.printStackTrace();
            return flag;
        }
        return flag;
_L4:
        if (motionevent.getAction() != 0 && motionevent.getAction() != 3 && motionevent.getAction() != 2 && motionevent.getAction() != 1) goto _L2; else goto _L5
_L5:
        message.obj = new g(motionevent.getAction(), motionevent.getX(), motionevent.getY());
        motionevent.getAction();
        JVM INSTR tableswitch 0 2: default 212
    //                   0 245
    //                   1 212
    //                   2 254;
           goto _L6 _L7 _L6 _L8
_L8:
        break MISSING_BLOCK_LABEL_254;
_L6:
        message.what = 15;
_L9:
        a(message, false);
        if (motionevent.getAction() != 1 && motionevent.getAction() != 3)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        continue; /* Loop/switch isn't completed */
_L7:
        message.what = 13;
          goto _L9
        message.what = 14;
          goto _L9
_L2:
        flag = false;
        if (true) goto _L11; else goto _L10
_L10:
    }

    public final void b(int i1)
    {
        if (a != null)
        {
            Message message = a.obtainMessage();
            message.what = 11;
            message.arg1 = i1;
            a(message, false);
        }
    }

    public boolean handleMessage(Message message)
    {
        float f2;
        Object obj;
        int i1;
        int j1;
        int k1;
        int l1;
        f2 = 0.0F;
        i1 = 1;
        j1 = message.arg1;
        k1 = message.arg2;
        obj = message.obj;
        l1 = message.what;
        if (!af || l1 == 1 || l1 == 0) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        l1;
        JVM INSTR tableswitch 0 15: default 128
    //                   0 130
    //                   1 746
    //                   2 740
    //                   3 128
    //                   4 898
    //                   5 2487
    //                   6 2608
    //                   7 2679
    //                   8 2770
    //                   9 2779
    //                   10 2787
    //                   11 3092
    //                   12 918
    //                   13 918
    //                   14 918
    //                   15 918;
           goto _L3 _L4 _L5 _L6 _L3 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L15 _L15 _L15
_L3:
        return false;
_L4:
        if (!af)
        {
            if (C == null || D == null || D.isRecycled())
            {
                D = com.socialin.android.util.c.a(k.getWidth(), k.getHeight(), android.graphics.Bitmap.Config.ARGB_8888);
                C = new Canvas(D);
                C.drawBitmap(k, 0.0F, 0.0F, l);
            }
            if (E == null || F == null || F.isRecycled())
            {
                F = com.socialin.android.util.c.a(k.getWidth(), k.getHeight(), android.graphics.Bitmap.Config.ARGB_8888);
                E = new Canvas(F);
                E.drawBitmap(k, 0.0F, 0.0F, l);
            }
        }
        A = null;
        if (B != null && !B.isRecycled())
        {
            B.recycle();
        }
        float f1;
        float f3;
        float f4;
        Bitmap bitmap;
        Canvas canvas;
        Canvas canvas1;
        long l2;
        boolean flag;
        if (W != null && o != null)
        {
            message = W.a;
            f2 = ((float)((Point) (message)).x - o.left) / o.width();
            f1 = ((float)((Point) (message)).y - o.top) / o.height();
        } else
        {
            f1 = 0.0F;
        }
        B = com.socialin.android.util.c.a(j1, k1, android.graphics.Bitmap.Config.ARGB_8888);
        A = new Canvas(B);
        if (N)
        {
            e();
        }
        v = Math.min((float)j1 / (float)y, (float)k1 / (float)z);
        w = (int)((float)y * v);
        x = (int)((float)z * v);
        U = w;
        V = x;
        S = (j1 - w) / 2;
        T = (k1 - x) / 2;
        o.set(S, T, w + S, x + T);
        q.set(o);
        p.set(o);
        if (W != null && W.d != null)
        {
            c();
        }
        if (W == null)
        {
            W = new com.picsart.effects.clone.a(getContext(), new Point(j1 / 2, k1 / 2), ad / 2);
        } else
        {
            i1 = (int)(f2 * o.width() + o.left);
            j1 = (int)(f1 * o.height() + o.top);
            W.a(i1, j1);
        }
        d();
        M = true;
        N = false;
        ((Activity)getContext()).runOnUiThread(new Runnable() {

            private CloneSurfaceView a;

            public final void run()
            {
                com.picsart.effects.clone.CloneSurfaceView.a(a);
            }

            
            {
                a = CloneSurfaceView.this;
                super();
            }
        });
        return false;
_L6:
        d();
        return false;
_L5:
        A = null;
        if (B != null && !B.isRecycled())
        {
            B.recycle();
        }
        B = null;
        E = null;
        if (F != null && !F.isRecycled())
        {
            F.recycle();
        }
        C = null;
        if (D != null && !D.isRecycled())
        {
            D.recycle();
        }
        D = null;
        if (j != null && !j.isRecycled())
        {
            j.recycle();
        }
        j = null;
        message = getContext();
        if (message != null)
        {
            ((Activity)message).runOnUiThread(new Runnable() {

                private CloneSurfaceView a;

                public final void run()
                {
                    if (com.picsart.effects.clone.CloneSurfaceView.b(a) != null)
                    {
                        Looper looper = com.picsart.effects.clone.CloneSurfaceView.b(a).getLooper();
                        if (looper != null)
                        {
                            looper.quit();
                        }
                    }
                }

            
            {
                a = CloneSurfaceView.this;
                super();
            }
            });
            return false;
        }
        continue; /* Loop/switch isn't completed */
_L7:
        setBrushPercentSize(j1);
        a(W.c);
        return false;
_L15:
        if (obj != null && D != null && !D.isRecycled())
        {
            message = (g)obj;
            if (M)
            {
                if (!((g) (message)).a)
                {
                    switch (((g) (message)).e)
                    {
                    default:
                        return false;

                    case 0: // '\0'
                        if (N)
                        {
                            e();
                        }
                        f1 = ((g) (message)).c;
                        f2 = ((g) (message)).d;
                        if (W != null)
                        {
                            if (g)
                            {
                                W.a((int)f1, (int)f2);
                                a(W.c);
                                return false;
                            }
                            if (!L)
                            {
                                Q.reset();
                                Q.moveTo(f1, f2);
                                R.moveTo(f1, f2);
                                J = f1;
                                K = f2;
                                if (W.d == null)
                                {
                                    message = W.a;
                                    obj = new PointF();
                                    obj.x = (J - (float)((Point) (message)).x) / o.width();
                                    obj.y = (K - (float)((Point) (message)).y) / o.height();
                                    W.d = ((PointF) (obj));
                                    c();
                                }
                                f1 = (float)(ad / 2) + I.getStrokeWidth() * 2.0F;
                                P.left = (int)(J - f1);
                                P.top = (int)(K - f1);
                                P.right = (int)(J + f1);
                                P.bottom = (int)(f1 + K);
                                if (ac == 0)
                                {
                                    W.a((int)(J - ae.x), (int)(K - ae.y));
                                    P.union(W.c);
                                    W.e = true;
                                }
                                N = true;
                                a(P);
                                return false;
                            } else
                            {
                                a(0, f1, f2);
                                return false;
                            }
                        }
                        break;

                    case 2: // '\002'
                        f1 = ((g) (message)).c;
                        f2 = ((g) (message)).d;
                        if (g)
                        {
                            W.a((int)f1, (int)f2);
                            a(W.c);
                        } else
                        if (!L)
                        {
                            if (N)
                            {
                                f3 = Math.abs(f1 - J);
                                f4 = Math.abs(f2 - K);
                                if (Math.abs(Math.sqrt(f3 * f3 + f4 * f4)) >= 4D)
                                {
                                    R.quadTo(J, K, (J + f1) / 2.0F, (K + f2) / 2.0F);
                                    R.computeBounds(O, true);
                                    f3 = ((float)ad * (1.0F + (d * 2.0F) / 100F)) / 2.0F + 1.0F;
                                    message = O;
                                    message.left = ((RectF) (message)).left - f3;
                                    message = O;
                                    message.top = ((RectF) (message)).top - f3;
                                    message = O;
                                    message.right = ((RectF) (message)).right + f3;
                                    message = O;
                                    message.bottom = f3 + ((RectF) (message)).bottom;
                                    P.set((int)O.left, (int)O.top, (int)O.right, (int)O.bottom);
                                    Q.quadTo(J, K, (J + f1) / 2.0F, (K + f2) / 2.0F);
                                    R.reset();
                                    R.moveTo((J + f1) / 2.0F, (K + f2) / 2.0F);
                                    J = f1;
                                    K = f2;
                                    f1 = (float)(ad / 2) + I.getStrokeWidth() * 2.0F;
                                    P.left = (int)Math.min(P.left, J - f1);
                                    P.top = (int)Math.min(P.top, K - f1);
                                    P.right = (int)Math.max(P.right, J + f1);
                                    P.bottom = (int)Math.max(P.bottom, f1 + K);
                                    W.a((int)(J - ae.x), (int)(K - ae.y));
                                    i1 = 1;
                                } else
                                {
                                    i1 = 0;
                                }
                                if (i1 != 0)
                                {
                                    A.drawColor(0xff000000);
                                    A.drawBitmap(D, null, o, l);
                                    A.save();
                                    if (ac == 0)
                                    {
                                        A.clipRect(s);
                                        A.drawPath(Q, G);
                                        if (e > 0)
                                        {
                                            H.setAlpha(e);
                                            A.drawBitmap(D, null, o, H);
                                            H.setAlpha(255);
                                        }
                                        A.drawBitmap(D, null, r, H);
                                    } else
                                    {
                                        A.clipRect(o);
                                        A.drawPath(Q, G);
                                        if (e > 0)
                                        {
                                            H.setAlpha(e);
                                            A.drawBitmap(D, null, o, H);
                                            H.setAlpha(255);
                                        }
                                        A.drawBitmap(k, null, o, H);
                                    }
                                    A.restore();
                                    a(P);
                                    if (ac == 0)
                                    {
                                        a(W.c);
                                    }
                                }
                            }
                        } else
                        {
                            a(2, f1, f2);
                        }
                        if (!g)
                        {
                            flag = true;
                        } else
                        {
                            flag = false;
                        }
                        aj = flag;
                        return false;

                    case 1: // '\001'
                    case 3: // '\003'
                        if (W != null)
                        {
                            message = W;
                            i1 = getWidth();
                            j1 = getHeight();
                            if (i1 > 0 && j1 > 0 && (((com.picsart.effects.clone.a) (message)).a.x < -((com.picsart.effects.clone.a) (message)).b / 3 || ((com.picsart.effects.clone.a) (message)).a.y < -((com.picsart.effects.clone.a) (message)).b / 3 || ((com.picsart.effects.clone.a) (message)).a.x > ((com.picsart.effects.clone.a) (message)).b / 3 + i1 || ((com.picsart.effects.clone.a) (message)).a.y > ((com.picsart.effects.clone.a) (message)).b / 3 + j1))
                            {
                                message.a(i1 / 2, j1 / 2);
                            }
                        }
                        if (i != null)
                        {
                            if (g)
                            {
                                i.a();
                            } else
                            if (!aj)
                            {
                                i.b();
                            } else
                            {
                                i.c();
                            }
                        }
                        aj = false;
                        e();
                        a(((Rect) (null)));
                        return false;
                    }
                } else
                {
                    message = ((g) (message)).b;
                    if (N)
                    {
                        e();
                    }
                    o.set(message);
                    if ((o.width() + 0.5F) / p.width() <= 8F)
                    {
                        U = (int)(o.width() + 0.5F);
                        V = (int)(o.height() + 0.5F);
                        S = (int)(o.left + 0.5F);
                        T = (int)(o.top + 0.5F);
                    }
                    if (W != null && W.d != null)
                    {
                        c();
                    }
                    N = false;
                    d();
                    return false;
                }
            }
        }
        continue; /* Loop/switch isn't completed */
_L8:
        if (ai.size() > 0)
        {
            ai.remove(ai.size() - 1);
            a(C, D, E, F, k, 1.0F);
            d();
            if (ai.size() == 0 && ah != null)
            {
                ah.a(false);
            }
        } else
        if (ah != null)
        {
            ah.a(false);
        }
        if (ah != null)
        {
            ah.e();
            return false;
        }
        continue; /* Loop/switch isn't completed */
_L9:
        ai.clear();
        a(C, D, E, F, k, 1.0F);
        d();
        if (ah != null)
        {
            ah.a(false);
        }
        if (ah != null)
        {
            ah.e();
            return false;
        }
        continue; /* Loop/switch isn't completed */
_L10:
        if (!g)
        {
            if (j1 == -1)
            {
                if (ac != 0)
                {
                    i1 = 0;
                }
            } else
            {
                i1 = j1;
            }
            if (i1 != ac)
            {
                setBrushDrawMode(i1);
                if (ac == 0)
                {
                    if (W != null)
                    {
                        W.a(getWidth() / 2, getHeight() / 2);
                    }
                } else
                {
                    W.e = false;
                }
                d();
                return false;
            }
        }
        continue; /* Loop/switch isn't completed */
_L11:
        setHardness(j1);
        return false;
_L12:
        setStrength(j1);
        return false;
_L13:
        af = true;
        l2 = System.nanoTime();
        E = null;
        if (F != null && !F.isRecycled())
        {
            F.recycle();
        }
        F = null;
        if (k != null && !k.isRecycled())
        {
            k.recycle();
        }
        k = null;
        C = null;
        obj = (Activity)getContext();
        if (j != null)
        {
            break; /* Loop/switch isn't completed */
        }
        message = D;
_L17:
        if (ah != null && message != null)
        {
            ah.a(message);
            ((Activity) (obj)).runOnUiThread(new Runnable(((Activity) (obj)), message, l2) {

                private Activity a;
                private Bitmap b;
                private long c;
                private CloneSurfaceView d;

                public final void run()
                {
                    EditingData editingdata = ((CloneActivity)a).a;
                    String s1 = "";
                    if (editingdata != null)
                    {
                        editingdata.c("clone");
                        s1 = editingdata.a;
                    }
                    com.picsart.effects.clone.CloneSurfaceView.c(d).e();
                    com.picsart.effects.clone.CloneSurfaceView.c(d).f();
                    if (CloneSurfaceView.d(d))
                    {
                        AnalyticUtils.getInstance(a).track(new com.socialin.android.apiv3.events.EventsFactory.EffectDoneEvent("effect_clone"));
                        Activity activity = a;
                        int i2;
                        int j2;
                        if (com.picsart.effects.clone.CloneSurfaceView.e(d) != null)
                        {
                            i2 = com.picsart.effects.clone.CloneSurfaceView.e(d).getWidth();
                        } else
                        {
                            i2 = b.getWidth();
                        }
                        if (com.picsart.effects.clone.CloneSurfaceView.e(d) != null)
                        {
                            j2 = com.picsart.effects.clone.CloneSurfaceView.e(d).getHeight();
                        } else
                        {
                            j2 = b.getHeight();
                        }
                        myobfuscated.ay.e.a(activity, "effect_clone", i2, j2, true, true, (System.nanoTime() - c) / 0xf4240L, false, new JSONArray(), s1);
                    }
                }

            
            {
                d = CloneSurfaceView.this;
                a = activity;
                b = bitmap;
                c = l1;
                super();
            }
            });
            return false;
        }
        if (true) goto _L1; else goto _L16
_L16:
        message = com.socialin.android.util.c.a(j.getWidth(), j.getHeight(), android.graphics.Bitmap.Config.ARGB_8888);
        if (message == null || message.isRecycled())
        {
            message = null;
        } else
        {
            bitmap = com.socialin.android.util.c.a(j.getWidth(), j.getHeight(), android.graphics.Bitmap.Config.ARGB_8888);
            if (bitmap == null || bitmap.isRecycled())
            {
                if (message != null && !message.isRecycled())
                {
                    message.recycle();
                }
                message = null;
            } else
            {
                canvas = new Canvas(message);
                canvas1 = new Canvas(bitmap);
                f1 = (float)j.getWidth() / (float)y;
                a(canvas, message, canvas1, bitmap, j, f1);
                if (bitmap != null && !bitmap.isRecycled())
                {
                    bitmap.recycle();
                }
            }
        }
          goto _L17
          goto _L1
_L14:
        j1;
        JVM INSTR tableswitch 0 2: default 3120
    //                   0 3131
    //                   1 3120
    //                   2 3170;
           goto _L18 _L19 _L18 _L20
_L18:
        L = true;
_L21:
        d();
        return false;
_L19:
        L = false;
        if (W != null)
        {
            W.a(getWidth() / 2, getHeight() / 2);
        }
        L = false;
        if (true) goto _L21; else goto _L20
_L20:
        g = true;
        if (W != null)
        {
            W.d = null;
            W.a(getWidth() / 2, getHeight() / 2);
            W.e = true;
            W.f = -1;
        }
        if (true) goto _L18; else goto _L22
_L22:
    }

    public void setActionsListenerForAnalytics(com.picsart.effects.clone.e e1)
    {
        i = e1;
    }

    public void setBrushDrawMode(int i1)
    {
        ac = i1;
    }

    public void setBrushPercentSize(float f1)
    {
        ad = (int)(aa + ((ab - aa) * f1) / 100F);
        if (W != null)
        {
            com.picsart.effects.clone.a a1 = W;
            int i1 = ad / 2;
            int j1 = a1.b;
            a1.b = i1;
            a1.a(a1.a.x, a1.a.y, j1);
        }
        if (G != null)
        {
            G.setStrokeWidth(ad);
        }
        BlurMaskFilter blurmaskfilter = null;
        if (d > 0.0F)
        {
            blurmaskfilter = new BlurMaskFilter((G.getStrokeWidth() * d) / 100F, android.graphics.BlurMaskFilter.Blur.NORMAL);
        }
        G.setMaskFilter(blurmaskfilter);
    }

    public void setBrushSizeInPercent(float f1)
    {
        f = f1;
    }

    public void setCanInit(boolean flag)
    {
        t = flag;
    }

    public void setCloneSurfaceViewUIActions(f f1)
    {
        ah = f1;
    }

    public void setEnableEffectsAnalytics(boolean flag)
    {
        h = flag;
    }

    public void setFirstSurfaceChanged(boolean flag)
    {
        c = flag;
    }

    public void setHardness(float f1)
    {
        BlurMaskFilter blurmaskfilter = null;
        f1 = 100F - f1;
        if (f1 > 0.0F)
        {
            blurmaskfilter = new BlurMaskFilter((G.getStrokeWidth() * f1) / 100F, android.graphics.BlurMaskFilter.Blur.NORMAL);
        }
        G.setMaskFilter(blurmaskfilter);
        d = f1;
    }

    public void setInited(boolean flag)
    {
        b = flag;
    }

    public void setOrigBitmaps(Bitmap bitmap, Bitmap bitmap1)
    {
        j = bitmap;
        k = bitmap1;
        y = bitmap1.getWidth();
        z = bitmap1.getHeight();
    }

    public void setStrength(int i1)
    {
        e = i1;
    }

    public void surfaceChanged(SurfaceHolder surfaceholder, int i1, int j1, int k1)
    {
        setFirstSurfaceChanged(true);
        u = false;
        if (!t)
        {
            return;
        } else
        {
            b = true;
            a(j1, k1);
            return;
        }
    }

    public void surfaceCreated(SurfaceHolder surfaceholder)
    {
        if (n == null || a == null)
        {
            n = new HandlerThread("CLONE_DRAW_HANDLER_THREAD");
            n.start();
            a = new Handler(n.getLooper(), this);
        }
    }

    public void surfaceDestroyed(SurfaceHolder surfaceholder)
    {
        surfaceholder = getContext();
        if (surfaceholder != null && ((Activity)surfaceholder).isFinishing() && a != null)
        {
            surfaceholder = a.obtainMessage();
            surfaceholder.what = 1;
            a(surfaceholder, false);
        }
    }
}

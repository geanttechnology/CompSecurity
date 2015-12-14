// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.imgop.blending;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import com.socialin.android.util.ScaleRotateGestureDetector;
import com.socialin.android.util.Utils;
import com.socialin.android.util.ad;
import com.socialin.android.util.w;
import java.util.concurrent.ExecutorService;

// Referenced classes of package com.socialin.android.photo.imgop.blending:
//            BlendingActivity, b

final class a extends View
{

    private Paint A;
    private Paint B;
    private Paint C;
    private Matrix D;
    private Matrix E;
    private boolean F;
    private boolean G;
    private float H[];
    private final ad I = new ad() {

        private a a;

        public final void a(float f1)
        {
            a.b(a).set(a.a(a).f);
            a.b(a).mapRect(a.c(a), a.d(a));
            a.e(a).postScale(f1, f1);
        }

        public final void a(float f1, float f2, float f3, float f4)
        {
            if (a.c(a).contains(a.a(f1, f3), a.a(f2, f4)))
            {
                a.a(a).b = true;
                a.a(a).a = true;
                a.a(a).c = true;
                return;
            }
            if (android.os.Build.VERSION.SDK_INT >= 11)
            {
                a.a(a).b = false;
            }
            a.a(a).a = false;
            a.a(a).c = false;
        }

        public final void b()
        {
            a.b(a).set(a.a(a).f);
            a.b(a).mapRect(a.c(a), a.d(a));
            a.f(a);
        }

        public final void c()
        {
            a.b(a).set(a.a(a).f);
            a.b(a).mapRect(a.c(a), a.d(a));
        }

            
            {
                a = a.this;
                super();
            }
    };
    Bitmap a;
    Bitmap b;
    public Bitmap c;
    Matrix d;
    Matrix e;
    RectF f;
    boolean g;
    float h;
    float i;
    ScaleRotateGestureDetector j;
    private Bitmap k;
    private BlendingActivity l;
    private float m;
    private float n;
    private boolean o;
    private int p;
    private int q;
    private final RectF r = new RectF();
    private final RectF s = new RectF();
    private RectF t;
    private RectF u;
    private float v[];
    private PointF w;
    private PointF x;
    private PointF y;
    private PointF z;

    public a(Context context)
    {
        super(context);
        d = new Matrix();
        e = new Matrix();
        m = 150F;
        n = 65F;
        o = true;
        p = 0;
        q = 0;
        f = new RectF();
        t = new RectF();
        u = new RectF();
        v = new float[4];
        w = new PointF(0.0F, 1.0F);
        x = new PointF(1.0F, 1.0F);
        y = new PointF(0.0F, 1.0F);
        z = new PointF(1.0F, 1.0F);
        A = new Paint();
        B = new Paint();
        C = new Paint();
        D = new Matrix();
        E = new Matrix();
        F = false;
        g = false;
        G = false;
        h = 0.3F;
        i = 10F;
        H = new float[2];
        l = (BlendingActivity)context;
        A.setAntiAlias(true);
        A.setDither(true);
        B.setDither(true);
        B.setFilterBitmap(true);
        C.setFilterBitmap(true);
        C.setDither(true);
        C.setAntiAlias(true);
        j = new ScaleRotateGestureDetector(getResources(), 10F, 0.05F, true);
        j.e = true;
        j.g = I;
    }

    static float a(float f1, float f2)
    {
        return (f1 + f2) / 2.0F;
    }

    static ScaleRotateGestureDetector a(a a1)
    {
        return a1.j;
    }

    static Matrix b(a a1)
    {
        return a1.d;
    }

    static RectF c(a a1)
    {
        return a1.s;
    }

    static RectF d(a a1)
    {
        return a1.r;
    }

    static Matrix e(a a1)
    {
        return a1.e;
    }

    static boolean f(a a1)
    {
        a1.G = true;
        return true;
    }

    public final void a(int i1, int j1)
    {
        t.set(0.0F, 0.0F, i1, j1);
        D.setRectToRect(u, t, android.graphics.Matrix.ScaleToFit.CENTER);
        D.invert(E);
        Bitmap bitmap = l.c;
        if (!g)
        {
            RectF rectf = new RectF(r);
            m = (int)Utils.a(220F, getContext());
            if (m > ((float)i1 * 6F) / 7F || m > ((float)j1 * 6F) / 7F)
            {
                m = (int)(((float)Math.min(i1, j1) * 3F) / 5F);
            }
            float f1 = ((float)i1 - m) / 2.0F;
            float f2 = ((float)j1 - m) / 2.0F;
            RectF rectf1 = new RectF(f1, f2, m + f1, m + f2);
            E.mapRect(rectf1);
            d.setRectToRect(rectf, rectf1, android.graphics.Matrix.ScaleToFit.CENTER);
            float af[] = new float[9];
            d.getValues(af);
            e.setScale(af[0], af[4]);
            d.mapRect(s, r);
            f.set(s);
            a(new Matrix());
        }
        j.a(d);
        g = true;
    }

    public final void a(Bitmap bitmap)
    {
        b = bitmap;
        if (b != null)
        {
            r.set(0.0F, 0.0F, b.getWidth(), b.getHeight());
        }
        invalidate();
    }

    public final void a(Matrix matrix)
    {
        Matrix matrix1 = new Matrix();
        matrix.invert(matrix1);
        matrix = new RectF(0.0F, 0.0F, a.getWidth(), a.getHeight());
        matrix1.mapRect(matrix);
        i = Math.max(matrix.width(), matrix.height()) / (float)Math.max(b.getWidth(), b.getHeight());
        n = (int)Utils.a(65F, getContext());
        if (n > m / 2.0F)
        {
            n = m / 2.0F;
        }
        matrix = new RectF(0.0F, 0.0F, n, n);
        E.mapRect(matrix);
        matrix1.mapRect(matrix);
        h = Math.min(matrix.width(), matrix.height()) / (float)Math.min(b.getWidth(), b.getHeight());
        j.a(i, h);
    }

    public final void a(boolean flag)
    {
        boolean flag1 = false;
        d.mapRect(s, r);
        l.b();
        if (!l.d.a)
        {
            l.c();
        } else
        {
            Object obj = l;
            float f1 = Math.round(s.left);
            float f2 = Math.round(s.top);
            obj = ((BlendingActivity) (obj)).d;
            int i1 = (int)f1;
            int j1 = (int)f2;
            obj.f = i1;
            obj.g = j1;
            if (s.right < t.left || s.left > (float)a.getWidth() || s.top > (float)a.getHeight() || s.bottom < t.top)
            {
                Utils.c(l, "Please place the image on background.");
                l.c();
                return;
            }
            e.mapRect(f, r);
            Log.i("ex", (new StringBuilder("width is: ")).append(f.width()).append(" height is: ").append(f.height()).toString());
            obj = com.socialin.android.util.w.a(b, e, (int)f.width(), (int)f.height(), android.graphics.Bitmap.Config.ARGB_8888);
            l.a(((Bitmap) (obj)));
            y.set(w);
            z.set(x);
            v[0] = y.x;
            v[1] = y.y;
            v[2] = z.x;
            v[3] = z.y;
            d.mapPoints(v);
            y.x = v[0];
            y.y = v[1];
            z.x = v[2];
            z.y = v[3];
            obj = l;
            PointF pointf = y;
            PointF pointf1 = z;
            PointF pointf2 = w;
            PointF pointf3 = x;
            p = (int)Math.toDegrees(Math.atan2(pointf2.x - pointf3.x, pointf2.y - pointf3.y));
            q = (int)Math.toDegrees(Math.atan2(pointf.x - pointf1.x, pointf.y - pointf1.y));
            i1 = p;
            j1 = q;
            ((BlendingActivity) (obj)).d.h = 360 - (i1 - j1);
            obj = l;
            if (((BlendingActivity) (obj)).d.g <= ((BlendingActivity) (obj)).d.e)
            {
                flag1 = true;
            }
            if (!flag1)
            {
                ((BlendingActivity) (obj)).c();
                Utils.c(((android.app.Activity) (obj)), "Please place the image on background.");
                return;
            }
            if (((BlendingActivity) (obj)).d.a)
            {
                ((BlendingActivity) (obj)).d.i = flag;
                ((BlendingActivity) (obj)).e.execute(((BlendingActivity) (obj)).d);
                return;
            }
        }
    }

    public final void b(Bitmap bitmap)
    {
        a = bitmap;
        invalidate();
        if (bitmap != null && !F)
        {
            F = true;
            u.set(0.0F, 0.0F, bitmap.getWidth(), bitmap.getHeight());
        }
    }

    public final void c(Bitmap bitmap)
    {
        if (k != null)
        {
            k.recycle();
            k = null;
        }
        if (b == null)
        {
            b = l.b;
        }
        k = bitmap;
        if (c != null)
        {
            c.recycle();
            c = null;
        }
        c = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), android.graphics.Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(c);
        canvas.drawBitmap(bitmap, 0.0F, 0.0F, C);
        B.setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.SRC_ATOP));
        canvas.drawBitmap(b, 0.0F, 0.0F, B);
        B.setXfermode(null);
    }

    protected final void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        canvas.setMatrix(D);
        if (a != null)
        {
            canvas.drawBitmap(a, 0.0F, 0.0F, B);
        }
        if (b != null && c != null)
        {
            canvas.drawBitmap(c, j.f, A);
        }
    }

    protected final void onSizeChanged(int i1, int j1, int k1, int l1)
    {
        super.onSizeChanged(i1, j1, k1, l1);
        a(i1, j1);
        if (o)
        {
            a(false);
            o = false;
        }
    }

    public final boolean onTouchEvent(MotionEvent motionevent)
    {
        super.onTouchEvent(motionevent);
        if (!l.d.a)
        {
            return true;
        }
        int i1 = motionevent.getPointerCount();
        if (android.os.Build.VERSION.SDK_INT > 11)
        {
            motionevent.transform(E);
        } else
        {
            H[0] = Math.round(motionevent.getX());
            H[1] = Math.round(motionevent.getY());
            E.mapPoints(H);
            motionevent.setLocation(H[0], H[1]);
        }
        j.a(motionevent);
        if (i1 == 1)
        {
            float f1;
            float f2;
            int j1;
            if (s.contains(motionevent.getX(), motionevent.getY()))
            {
                if (motionevent.getAction() == 0)
                {
                    j.b = true;
                } else
                {
                    j.c = true;
                }
            } else
            {
                if (android.os.Build.VERSION.SDK_INT >= 11)
                {
                    j.b = false;
                }
                if (b == null)
                {
                    l.a();
                }
            }
            j1 = motionevent.getActionMasked();
            f1 = motionevent.getX();
            f2 = motionevent.getY();
            if (j1 == 1)
            {
                if (b != null && G)
                {
                    a(false);
                }
                G = false;
            } else
            if (j1 == 0 && s.contains(f1, f2))
            {
                l.a();
            }
        }
        invalidate();
        return true;
    }
}

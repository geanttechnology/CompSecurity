// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import com.fotoable.beautyui.pinimageviewtool.PhotoView;
import java.lang.ref.WeakReference;

public class xu
    implements android.view.GestureDetector.OnDoubleTapListener, android.view.View.OnTouchListener, android.view.ViewTreeObserver.OnGlobalLayoutListener, ym
{

    static final boolean a = Log.isLoggable("PhotoViewAttacher", 3);
    private yb A;
    private float b;
    private float c;
    private float d;
    private boolean e;
    private WeakReference f;
    private ViewTreeObserver g;
    private GestureDetector h;
    private yh i;
    private Matrix j;
    private final Matrix k = new Matrix();
    private Matrix l;
    private final RectF m = new RectF();
    private final float n[] = new float[9];
    private xz o;
    private ya p;
    private yc q;
    private android.view.View.OnLongClickListener r;
    private int s;
    private int t;
    private int u;
    private int v;
    private xy w;
    private int x;
    private boolean y;
    private android.widget.ImageView.ScaleType z;

    public xu(ImageView imageview)
    {
        b = 1.0F;
        c = 1.75F;
        d = 3F;
        e = true;
        j = new Matrix();
        l = new Matrix();
        x = 2;
        z = android.widget.ImageView.ScaleType.FIT_CENTER;
        a(imageview);
    }

    private float a(Matrix matrix, int i1)
    {
        matrix.getValues(n);
        return n[i1];
    }

    static android.view.View.OnLongClickListener a(xu xu1)
    {
        return xu1.r;
    }

    private void a(Drawable drawable)
    {
        float f1;
        float f2;
        float f3;
        float f4;
        int i1;
        int j1;
        ImageView imageview = d();
        if (imageview == null || drawable == null)
        {
            return;
        }
        f1 = imageview.getWidth();
        f2 = imageview.getHeight();
        i1 = drawable.getIntrinsicWidth();
        j1 = drawable.getIntrinsicHeight();
        j.reset();
        f3 = f1 / (float)i1;
        f4 = f2 / (float)j1;
        if (z != android.widget.ImageView.ScaleType.CENTER) goto _L2; else goto _L1
_L1:
        j.postTranslate((f1 - (float)i1) / 2.0F, (f2 - (float)j1) / 2.0F);
_L4:
        p();
        return;
_L2:
        if (z == android.widget.ImageView.ScaleType.CENTER_CROP)
        {
            f3 = Math.max(f3, f4);
            j.postScale(f3, f3);
            j.postTranslate((f1 - (float)i1 * f3) / 2.0F, (f2 - (float)j1 * f3) / 2.0F);
            continue; /* Loop/switch isn't completed */
        }
        if (z != android.widget.ImageView.ScaleType.CENTER_INSIDE)
        {
            break; /* Loop/switch isn't completed */
        }
        f3 = Math.min(1.0F, Math.min(f3, f4));
        j.postScale(f3, f3);
        j.postTranslate((f1 - (float)i1 * f3) / 2.0F, (f2 - (float)j1 * f3) / 2.0F);
        if (true) goto _L4; else goto _L3
_L3:
        drawable = new RectF(0.0F, 0.0F, i1, j1);
        RectF rectf = new RectF(0.0F, 0.0F, f1, f2);
        switch (xw.a[z.ordinal()])
        {
        case 2: // '\002'
            j.setRectToRect(drawable, rectf, android.graphics.Matrix.ScaleToFit.START);
            break;

        case 4: // '\004'
            j.setRectToRect(drawable, rectf, android.graphics.Matrix.ScaleToFit.CENTER);
            break;

        case 3: // '\003'
            j.setRectToRect(drawable, rectf, android.graphics.Matrix.ScaleToFit.END);
            break;

        case 5: // '\005'
            j.setRectToRect(drawable, rectf, android.graphics.Matrix.ScaleToFit.FILL);
            break;
        }
        if (true) goto _L4; else goto _L5
_L5:
    }

    private RectF b(Matrix matrix)
    {
        Object obj = d();
        if (obj != null)
        {
            obj = ((ImageView) (obj)).getDrawable();
            if (obj != null)
            {
                m.set(0.0F, 0.0F, ((Drawable) (obj)).getIntrinsicWidth(), ((Drawable) (obj)).getIntrinsicHeight());
                matrix.mapRect(m);
                return m;
            }
        }
        return null;
    }

    static WeakReference b(xu xu1)
    {
        return xu1.f;
    }

    private static boolean b(android.widget.ImageView.ScaleType scaletype)
    {
        if (scaletype == null)
        {
            return false;
        }
        switch (xw.a[scaletype.ordinal()])
        {
        default:
            return true;

        case 1: // '\001'
            throw new IllegalArgumentException((new StringBuilder()).append(scaletype.name()).append(" is not supported in PhotoView").toString());
        }
    }

    private static boolean b(ImageView imageview)
    {
        return imageview != null && imageview.getDrawable() != null;
    }

    static Matrix c(xu xu1)
    {
        return xu1.l;
    }

    private static void c(float f1, float f2, float f3)
    {
        if (f1 >= f2)
        {
            throw new IllegalArgumentException("MinZoom should be less than MidZoom");
        }
        if (f2 >= f3)
        {
            throw new IllegalArgumentException("MidZoom should be less than MaxZoom");
        } else
        {
            return;
        }
    }

    private static void c(ImageView imageview)
    {
        if (imageview == null || (imageview instanceof PhotoView))
        {
            return;
        } else
        {
            imageview.setScaleType(android.widget.ImageView.ScaleType.MATRIX);
            return;
        }
    }

    static void d(xu xu1)
    {
        xu1.m();
    }

    private void l()
    {
        if (w != null)
        {
            w.a();
            w = null;
        }
    }

    private void m()
    {
        o();
        a(k());
    }

    private void n()
    {
        ImageView imageview = d();
        if (imageview != null && !(imageview instanceof PhotoView) && imageview.getScaleType() != android.widget.ImageView.ScaleType.MATRIX)
        {
            throw new IllegalStateException("The ImageView's ScaleType has been changed since attaching a PhotoViewAttacher");
        } else
        {
            return;
        }
    }

    private void o()
    {
        float f2;
        ImageView imageview;
        f2 = 0.0F;
        imageview = d();
        if (imageview != null) goto _L2; else goto _L1
_L1:
        RectF rectf;
        return;
_L2:
        if ((rectf = b(k())) == null) goto _L1; else goto _L3
_L3:
        float f1;
        float f3;
        int i1;
        f1 = rectf.height();
        f3 = rectf.width();
        i1 = imageview.getHeight();
        if (f1 > (float)i1) goto _L5; else goto _L4
_L4:
        xw.a[z.ordinal()];
        JVM INSTR tableswitch 2 3: default 88
    //                   2 182
    //                   3 192;
           goto _L6 _L7 _L8
_L6:
        f1 = ((float)i1 - f1) / 2.0F - rectf.top;
_L12:
        i1 = imageview.getWidth();
        if (f3 > (float)i1)
        {
            break MISSING_BLOCK_LABEL_277;
        }
        xw.a[z.ordinal()];
        JVM INSTR tableswitch 2 3: default 152
    //                   2 252
    //                   3 262;
           goto _L9 _L10 _L11
_L9:
        f2 = ((float)i1 - f3) / 2.0F - rectf.left;
_L13:
        x = 2;
_L14:
        l.postTranslate(f2, f1);
        return;
_L7:
        f1 = -rectf.top;
          goto _L12
_L8:
        f1 = (float)i1 - f1 - rectf.top;
          goto _L12
_L5:
        if (rectf.top > 0.0F)
        {
            f1 = -rectf.top;
        } else
        if (rectf.bottom < (float)i1)
        {
            f1 = (float)i1 - rectf.bottom;
        } else
        {
            f1 = 0.0F;
        }
          goto _L12
_L10:
        f2 = -rectf.left;
          goto _L13
_L11:
        f2 = (float)i1 - f3 - rectf.left;
          goto _L13
        if (rectf.left > 0.0F)
        {
            x = 0;
            f2 = -rectf.left;
        } else
        if (rectf.right < (float)i1)
        {
            f2 = (float)i1 - rectf.right;
            x = 1;
        } else
        {
            x = -1;
        }
          goto _L14
    }

    private void p()
    {
        l.reset();
        a(k());
        o();
    }

    public void a(float f1)
    {
        c(f1, c, d);
        b = f1;
    }

    public final void a(float f1, float f2)
    {
        if (a)
        {
            Log.d("PhotoViewAttacher", String.format("onDrag: dx: %.2f. dy: %.2f", new Object[] {
                Float.valueOf(f1), Float.valueOf(f2)
            }));
        }
        ImageView imageview = d();
        if (imageview != null && b(imageview))
        {
            l.postTranslate(f1, f2);
            m();
            if (e && !i.a() && (x == 2 || x == 0 && f1 >= 1.0F || x == 1 && f1 <= -1F))
            {
                imageview.getParent().requestDisallowInterceptTouchEvent(false);
            }
        }
    }

    public final void a(float f1, float f2, float f3)
    {
        if (a)
        {
            Log.d("PhotoViewAttacher", String.format("onScale: scale: %.2f. fX: %.2f. fY: %.2f", new Object[] {
                Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(f3)
            }));
        }
        if (b(d()) && (h() < d || f1 < 1.0F))
        {
            l.postScale(f1, f1, f2, f3);
            m();
        }
    }

    public final void a(float f1, float f2, float f3, float f4)
    {
        if (a)
        {
            Log.d("PhotoViewAttacher", (new StringBuilder()).append("onFling. sX: ").append(f1).append(" sY: ").append(f2).append(" Vx: ").append(f3).append(" Vy: ").append(f4).toString());
        }
        ImageView imageview = d();
        if (b(imageview))
        {
            w = new xy(this, imageview.getContext());
            w.a(imageview.getWidth(), imageview.getHeight(), (int)f3, (int)f4);
            imageview.post(w);
        }
    }

    public void a(Matrix matrix)
    {
        ImageView imageview = d();
        if (imageview != null)
        {
            n();
            imageview.setImageMatrix(matrix);
            matrix = b(matrix);
            float f1 = (float)imageview.getDrawable().getBounds().width() / matrix.width();
            A.a(matrix);
        }
    }

    public final void a(android.view.View.OnLongClickListener onlongclicklistener)
    {
        r = onlongclicklistener;
    }

    public final void a(android.widget.ImageView.ScaleType scaletype)
    {
        if (b(scaletype) && scaletype != z)
        {
            z = scaletype;
            j();
        }
    }

    public void a(ImageView imageview)
    {
        f = new WeakReference(imageview);
        imageview.setOnTouchListener(this);
        g = imageview.getViewTreeObserver();
        g.addOnGlobalLayoutListener(this);
        c(imageview);
        if (!imageview.isInEditMode())
        {
            i = yh.a(imageview.getContext(), this);
            h = new GestureDetector(imageview.getContext(), new xv(this));
            h.setOnDoubleTapListener(this);
            b(true);
        }
    }

    public final void a(xz xz)
    {
        o = xz;
    }

    public final void a(ya ya1)
    {
        p = ya1;
    }

    public void a(yb yb1)
    {
        A = yb1;
    }

    public final void a(yc yc1)
    {
        q = yc1;
    }

    public void a(boolean flag)
    {
        e = flag;
    }

    public final boolean a()
    {
        return y;
    }

    public final void b()
    {
        if (f != null)
        {
            ((ImageView)f.get()).getViewTreeObserver().removeGlobalOnLayoutListener(this);
        }
        g = null;
        o = null;
        p = null;
        q = null;
        f = null;
    }

    public void b(float f1)
    {
        c(b, f1, d);
        c = f1;
    }

    public final void b(float f1, float f2, float f3)
    {
        ImageView imageview = d();
        if (imageview != null)
        {
            imageview.post(new xx(this, h(), f1, f2, f3));
        }
    }

    public final void b(boolean flag)
    {
        y = flag;
        j();
    }

    public final RectF c()
    {
        o();
        return b(k());
    }

    public void c(float f1)
    {
        c(b, c, f1);
        d = f1;
    }

    public final ImageView d()
    {
        ImageView imageview = null;
        if (f != null)
        {
            imageview = (ImageView)f.get();
        }
        if (imageview == null)
        {
            b();
            throw new IllegalStateException("ImageView no longer exists. You should not use this PhotoViewAttacher any more.");
        } else
        {
            return imageview;
        }
    }

    public float e()
    {
        return b;
    }

    public float f()
    {
        return c;
    }

    public float g()
    {
        return d;
    }

    public final float h()
    {
        return a(l, 0);
    }

    public final android.widget.ImageView.ScaleType i()
    {
        return z;
    }

    public final void j()
    {
label0:
        {
            ImageView imageview = d();
            if (imageview != null)
            {
                if (!y)
                {
                    break label0;
                }
                c(imageview);
                a(imageview.getDrawable());
            }
            return;
        }
        p();
    }

    protected Matrix k()
    {
        k.set(j);
        k.postConcat(l);
        return k;
    }

    public final boolean onDoubleTap(MotionEvent motionevent)
    {
        float f1;
        float f2;
        float f3;
        f1 = h();
        f2 = motionevent.getX();
        f3 = motionevent.getY();
        if (f1 < c)
        {
            b(c, f2, f3);
            break MISSING_BLOCK_LABEL_82;
        }
        if (f1 >= c && f1 < d)
        {
            b(d, f2, f3);
            break MISSING_BLOCK_LABEL_82;
        }
        try
        {
            b(b, f2, f3);
        }
        // Misplaced declaration of an exception variable
        catch (MotionEvent motionevent) { }
        return true;
    }

    public final boolean onDoubleTapEvent(MotionEvent motionevent)
    {
        return false;
    }

    public final void onGlobalLayout()
    {
        ImageView imageview = d();
        if (imageview != null && y)
        {
            int i1 = imageview.getTop();
            int j1 = imageview.getRight();
            int k1 = imageview.getBottom();
            int l1 = imageview.getLeft();
            if (i1 != s || k1 != u || l1 != v || j1 != t)
            {
                a(imageview.getDrawable());
                s = i1;
                t = j1;
                u = k1;
                v = l1;
            }
            A.a(k(), new PointF(d().getWidth(), d().getHeight()));
        }
    }

    public final boolean onSingleTapConfirmed(MotionEvent motionevent)
    {
        ImageView imageview = d();
        if (imageview != null)
        {
            if (p != null)
            {
                RectF rectf = c();
                if (rectf != null)
                {
                    float f2 = motionevent.getX();
                    float f1 = motionevent.getY();
                    if (rectf.contains(f2, f1))
                    {
                        f2 = (f2 - rectf.left) / rectf.width();
                        f1 = (f1 - rectf.top) / rectf.height();
                        p.a(imageview, f2, f1);
                        return true;
                    }
                }
            }
            if (q != null)
            {
                q.a(imageview, motionevent.getX(), motionevent.getY());
            }
        }
        return false;
    }

    public final boolean onTouch(View view, MotionEvent motionevent)
    {
        boolean flag;
        boolean flag1;
        flag = false;
        flag1 = false;
        if (!y) goto _L2; else goto _L1
_L1:
        flag = flag1;
        motionevent.getAction();
        JVM INSTR tableswitch 0 3: default 52
    //                   0 117
    //                   1 138
    //                   2 56
    //                   3 138;
           goto _L3 _L4 _L5 _L6 _L5
_L6:
        break; /* Loop/switch isn't completed */
_L3:
        flag = flag1;
_L8:
        flag1 = flag;
        if (h != null)
        {
            flag1 = flag;
            if (h.onTouchEvent(motionevent))
            {
                flag1 = true;
            }
        }
        flag = flag1;
        if (i != null)
        {
            flag = flag1;
            if (i.a(motionevent))
            {
                flag = true;
            }
        }
_L2:
        return flag;
_L4:
        view.getParent().requestDisallowInterceptTouchEvent(true);
        l();
        flag = flag1;
        continue; /* Loop/switch isn't completed */
_L5:
        flag = flag1;
        if (h() < b)
        {
            RectF rectf = c();
            flag = flag1;
            if (rectf != null)
            {
                view.post(new xx(this, h(), b, rectf.centerX(), rectf.centerY()));
                flag = true;
            }
        }
        if (true) goto _L8; else goto _L7
_L7:
    }

}

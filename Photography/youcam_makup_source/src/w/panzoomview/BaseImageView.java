// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package w.panzoomview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import com.cyberlink.youcammakeup.jniproxy.UIImageOrientation;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package w.panzoomview:
//            h, a, b, c, 
//            i, g, d, j, 
//            f

public class BaseImageView extends View
    implements h
{

    protected float a;
    protected b b;
    protected a c;
    protected float d;
    protected List e;
    protected g f;
    private Paint g;
    private Bitmap h;
    private boolean i;
    private boolean j;

    public BaseImageView(Context context)
    {
        super(context);
        a = 4F;
        b = null;
        g = null;
        c = new a();
        i = false;
        j = false;
        d = 0.0F;
        e = null;
        if (!isInEditMode())
        {
            d();
        }
    }

    public BaseImageView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a = 4F;
        b = null;
        g = null;
        c = new a();
        i = false;
        j = false;
        d = 0.0F;
        e = null;
        if (!isInEditMode())
        {
            d();
        }
    }

    public BaseImageView(Context context, AttributeSet attributeset, int k)
    {
        super(context, attributeset, k);
        a = 4F;
        b = null;
        g = null;
        c = new a();
        i = false;
        j = false;
        d = 0.0F;
        e = null;
        if (!isInEditMode())
        {
            d();
        }
    }

    private void d()
    {
        b = new b(this);
        g = new Paint();
    }

    protected c a(b b1)
    {
        float f1 = (float)getWidth() / (float)b1.d;
        float f2 = (float)getHeight() / (float)b1.e;
        b1 = new c();
        if (c.a == FitOption.b)
        {
            f1 = Math.max(f1, f2);
            b1.a = f1;
            b1.b = Math.max(f1, a);
            return b1;
        } else
        {
            f1 = Math.min(f1, f2);
            b1.a = f1;
            b1.b = Math.max(f1, a);
            return b1;
        }
    }

    public i a(float f1, float f2, boolean flag)
    {
        float f4;
        float f9;
        float f10;
        float f11;
        float f5;
label0:
        {
            float f12 = (float)getWidth() / 2.0F;
            float f3 = (float)getHeight() / 2.0F;
            Matrix matrix = new Matrix(b.j);
            float af[] = new float[9];
            matrix.getValues(af);
            f11 = af[0];
            f10 = (float)b.d * f11;
            f9 = (float)b.e * f11;
            float f14 = af[2];
            f5 = af[5];
            float f15 = f10 / 2.0F;
            float f7 = f9 / 2.0F;
            f1 = -(f12 - f1) - (f14 * f11 + f15);
            f5 = -(f3 - f2) - (f5 * f11 + f7);
            if (b.c != UIImageOrientation.c && b.c != UIImageOrientation.f)
            {
                f2 = f1;
                if (b.c != UIImageOrientation.h)
                {
                    break label0;
                }
            }
            f2 = -f1;
        }
        f4 = f5;
        if (b.c == UIImageOrientation.e)
        {
            f4 = -f5;
        }
        f1 = 0.0F;
        if (b.c != UIImageOrientation.g && b.c != UIImageOrientation.f) goto _L2; else goto _L1
_L1:
        f1 = 1.570796F;
_L4:
        float f8 = f2;
        float f6 = f4;
        if (f1 != 0.0F)
        {
            f8 = (float)((double)f2 * Math.cos(-1F * f1));
            float f13 = (float)((double)f4 * Math.sin(-1F * f1));
            f2 = (float)((double)f2 * Math.sin(-1F * f1));
            f6 = (float)((double)f4 * Math.cos(-1F * f1)) + f2;
            f10 = (float)b.a * f11;
            f9 = (float)b.b * f11;
            f8 -= f13;
        }
        f1 = f10 / 2.0F;
        f2 = f9 / 2.0F;
        f1 = (f8 + f1) / f11;
        f2 = (f6 + f2) / f11;
        i k = new i();
        k.a = f1 / (float)b.a;
        k.b = f2 / (float)b.b;
        return k;
_L2:
        if (b.c == UIImageOrientation.d)
        {
            f1 = 3.141593F;
        } else
        if (b.c == UIImageOrientation.i || b.c == UIImageOrientation.h)
        {
            f1 = 4.712389F;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void a()
    {
        while (h == null || h.isRecycled() || getWidth() <= 0 || getHeight() <= 0) 
        {
            return;
        }
        b(b);
        f = new g(this);
        j = true;
    }

    protected void a(Canvas canvas)
    {
_L2:
        return;
        if (h == null || h.isRecycled() || b.j == null) goto _L2; else goto _L1
_L1:
        int k = getWidth();
        int l = getHeight();
        RectF rectf = d(b);
        canvas.save();
        canvas.translate((float)k / 2.0F, (float)l / 2.0F);
        canvas.rotate(d);
        canvas.drawBitmap(h, null, rectf, g);
        canvas.restore();
        if (e != null)
        {
            Iterator iterator = e.iterator();
            while (iterator.hasNext()) 
            {
                d d1 = (d)iterator.next();
                Rect rect = d1.getBounds();
                if (rect.width() != getWidth() || rect.height() != getHeight())
                {
                    d1.setBounds(0, 0, getWidth(), getHeight());
                }
                canvas.save();
                canvas.translate((float)k / 2.0F, (float)l / 2.0F);
                canvas.translate(rectf.left, rectf.top);
                canvas.scale(b.i, b.i);
                c();
                d1.a(canvas, f);
                canvas.restore();
            }
        }
        if (true) goto _L2; else goto _L3
_L3:
    }

    public j b(float f1, float f2, boolean flag)
    {
label0:
        {
            Object obj = new Matrix(b.j);
            float af[] = new float[9];
            ((Matrix) (obj)).getValues(af);
            float f5 = af[0];
            float f9 = b.d;
            float f8 = b.e;
            float f6 = af[2];
            float f7 = af[5];
            float f4 = b.a;
            float f10 = b.b;
            float f3 = 0.0F;
            if (b.c == UIImageOrientation.g || b.c == UIImageOrientation.f)
            {
                f3 = 1.570796F;
            } else
            if (b.c == UIImageOrientation.d)
            {
                f3 = 3.141593F;
            } else
            if (b.c == UIImageOrientation.i || b.c == UIImageOrientation.h)
            {
                f3 = 4.712389F;
            }
            f4 = f4 * f1 * f5 - ((float)b.a * f5) / 2.0F;
            f1 = f10 * f2 * f5 - (f5 * (float)b.b) / 2.0F;
            if (f3 != 0.0F)
            {
                f2 = (float)((double)f4 * Math.cos(f3));
                float f11 = (float)((double)f1 * Math.sin(f3));
                f4 = (float)((double)f4 * Math.sin(f3));
                double d1 = f1;
                f1 = (float)(Math.cos(f3) * d1) + f4;
                f2 -= f11;
            } else
            {
                f2 = f4;
            }
            if (b.c != UIImageOrientation.c && b.c != UIImageOrientation.f)
            {
                f3 = f2;
                if (b.c != UIImageOrientation.h)
                {
                    break label0;
                }
            }
            f3 = -f2;
        }
        f2 = f1;
        if (b.c == UIImageOrientation.e)
        {
            f2 = -f1;
        }
        f1 = (f9 * f5) / 2.0F;
        f4 = (f8 * f5) / 2.0F;
        f8 = (float)getWidth() / 2.0F;
        f9 = (float)getHeight() / 2.0F;
        obj = new j();
        obj.a = f3 + (f1 + f6 * f5) + f8;
        obj.b = f2 + (f4 + f7 * f5) + f9;
        return ((j) (obj));
    }

    protected void b(b b1)
    {
        b1.a = h.getWidth();
        b1.b = h.getHeight();
        b1.d = h.getWidth();
        b1.e = h.getHeight();
        b1.c = UIImageOrientation.b;
        c c1 = a(b1);
        b1.h = c1.a;
        b1.g = c1.b;
        b1.j = new Matrix();
        float f1 = (float)(-b1.d) / 2.0F;
        float f2 = (float)(-b1.e) / 2.0F;
        b1.j.preTranslate(f1, f2);
        b1.j.preScale(c1.a, c1.a);
        float af[] = new float[9];
        b1.j.getValues(af);
        b1.i = af[0];
        b1.k = c(b1);
        b1.f = true;
    }

    public boolean b()
    {
        return b != null && b.a != -1 && b.b != -1 && b.d != -1 && b.e != -1 && b.i != -1F && b.j != null && b.k != null;
    }

    protected f c(b b1)
    {
        b1 = new Matrix(b.j);
        float af[] = new float[9];
        b1.getValues(af);
        float f1 = (float)b.d * af[0];
        float f2 = (float)b.e * af[0];
        float f3 = af[2] * af[0];
        float f4 = af[5];
        f4 = af[0] * f4;
        float f5 = (float)getWidth() / 2.0F;
        float f6 = (float)getHeight() / 2.0F;
        b1 = new f(0.0F, 0.0F, f1, f2);
        if (f3 < -f5)
        {
            b1.a(-f3 - f5);
            b1.c(b1.a() - (-f3 - f5));
        }
        if (f3 + f1 > f5)
        {
            b1.c(b1.a() - ((f1 + f3) - f5));
        }
        if (f4 < -f6)
        {
            b1.b(-f4 - f6);
            b1.d(b1.b() - (-f4 - f6));
        }
        if (f4 + f2 > f6)
        {
            b1.d(b1.b() - ((f4 + f2) - f6));
        }
        return b1;
    }

    protected void c()
    {
        f.a = b.a;
        f.b = b.b;
        f.c = b.i;
        RectF rectf = d(b);
        float f1 = rectf.width();
        float f2 = rectf.height();
        rectf.left = rectf.left + (float)getWidth() / 2.0F;
        rectf.top = rectf.top + (float)getHeight() / 2.0F;
        rectf.right = f1 + rectf.left;
        rectf.bottom = rectf.top + f2;
        f.d = rectf;
    }

    RectF d(b b1)
    {
        float af[] = new float[9];
        b1.j.getValues(af);
        float f1 = af[0];
        float f2 = af[2] * f1;
        float f3 = af[5] * f1;
        float f4 = b.d;
        float f5 = b.e;
        b1 = new RectF();
        b1.left = f2;
        b1.top = f3;
        b1.right = f2 + f4 * f1;
        b1.bottom = f3 + f1 * f5;
        return b1;
    }

    public b getCurImageInfo()
    {
        return new b(this, b);
    }

    public void invalidateDrawable(Drawable drawable)
    {
        invalidate();
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        a(canvas);
    }

    protected void onLayout(boolean flag, int k, int l, int i1, int j1)
    {
        super.onLayout(flag, k, l, i1, j1);
    }

    protected void onSizeChanged(int k, int l, int i1, int j1)
    {
        super.onSizeChanged(k, l, i1, j1);
        if (!j && k > 0 && l > 0)
        {
            a();
        }
    }

    public void setDrawingImage(Bitmap bitmap)
    {
        h = bitmap;
        a();
        invalidate();
    }

    private class FitOption extends Enum
    {

        public static final FitOption a;
        public static final FitOption b;
        private static final FitOption c[];

        public static FitOption valueOf(String s)
        {
            return (FitOption)Enum.valueOf(w/panzoomview/BaseImageView$FitOption, s);
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

        private FitOption(String s, int k)
        {
            super(s, k);
        }
    }

}

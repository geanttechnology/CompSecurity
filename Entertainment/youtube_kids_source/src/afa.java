// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.NinePatchDrawable;
import android.widget.FrameLayout;
import android.widget.ImageView;

final class afa
    implements Runnable
{

    final aew a;
    private Bitmap b;
    private Bitmap c;

    public afa(aew aew1, Bitmap bitmap)
    {
        a = aew1;
        super();
        b = bitmap;
    }

    public final void a()
    {
        b = null;
        if (c != null)
        {
            c.recycle();
            c = null;
        }
    }

    void b()
    {
        if (!aew.c(a).isAttachedToWindow())
        {
            throw new InterruptedException("Renderer was cancelled since not attached to window.");
        } else
        {
            return;
        }
    }

    public final void run()
    {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj5;
        Object obj6;
        Object obj7;
        Matrix matrix;
        c = null;
        obj3 = null;
        obj5 = null;
        matrix = null;
        obj2 = null;
        obj6 = null;
        obj7 = null;
        obj = null;
        float f;
        Paint paint;
        Point point;
        Point point1;
        int i;
        int j;
        b();
        i = aew.c(a).getResources().getDimensionPixelOffset(0x7f0a00fe);
        j = aew.c(a).getResources().getDimensionPixelOffset(0x7f0a00fd);
        point1 = new Point(aew.c(a).getWidth() + (i << 1), aew.c(a).getHeight() + (j << 1));
        point = new Point(b.getWidth(), b.getHeight());
        paint = new Paint(1);
        f = (float)aew.d(a).getWidth() / (float)aew.d(a).getHeight();
        int k;
        int l;
        k = (int)((double)i * 0.29999999999999999D);
        l = (int)((double)j * 0.29999999999999999D);
        Object obj1;
        Rect rect;
        Rect rect1;
        rect1 = new Rect(i + l, j + k, point1.x - i - l, point1.y - j - k);
        int i1 = point1.x - i - l - (i + l);
        rect = new Rect(i + l, j + k, i + l + i1, j + k + (int)((float)i1 / f));
        c = Bitmap.createBitmap(point1.x, point1.y, android.graphics.Bitmap.Config.ARGB_4444);
        obj1 = new Canvas(c);
        obj3 = obj5;
        obj2 = matrix;
        ((Canvas) (obj1)).save();
        obj3 = obj5;
        obj2 = matrix;
        ((Canvas) (obj1)).rotate(-3F, point1.x / 2, point1.y / 2);
        obj3 = obj5;
        obj2 = matrix;
        NinePatchDrawable ninepatchdrawable = (NinePatchDrawable)aew.c(a).getResources().getDrawable(0x7f02005d);
        obj3 = obj5;
        obj2 = matrix;
        ninepatchdrawable.setBounds(rect1);
        obj3 = obj5;
        obj2 = matrix;
        ninepatchdrawable.setAlpha(112);
        obj3 = obj5;
        obj2 = matrix;
        ninepatchdrawable.draw(((Canvas) (obj1)));
        obj3 = obj5;
        obj2 = matrix;
        i = (int)(((float)point.y - (float)point.x / f) / 2.0F);
        obj3 = obj5;
        obj2 = matrix;
        obj = new Matrix();
        obj3 = obj5;
        obj2 = matrix;
        ((Matrix) (obj)).setScale(1.0F, -1F);
        obj3 = obj5;
        obj2 = matrix;
        b();
        obj3 = obj5;
        obj2 = matrix;
        obj = Bitmap.createBitmap(b, 0, i, point.x, point.y - (i << 1), ((Matrix) (obj)), false);
        obj3 = obj;
        obj2 = obj;
        matrix = new Matrix();
        obj3 = obj;
        obj2 = obj;
        matrix.setRectToRect(new RectF(new Rect(0, 0, ((Bitmap) (obj)).getWidth(), ((Bitmap) (obj)).getHeight())), new RectF(rect), android.graphics.Matrix.ScaleToFit.CENTER);
        obj3 = obj;
        obj2 = obj;
        paint.setAlpha(112);
        obj3 = obj;
        obj2 = obj;
        ((Canvas) (obj1)).drawBitmap(((Bitmap) (obj)), matrix, paint);
        obj3 = obj;
        obj2 = obj;
        ((Canvas) (obj1)).rotate(6F, point1.x / 2, point1.y / 2);
        obj3 = obj;
        obj2 = obj;
        ninepatchdrawable.setAlpha(163);
        obj3 = obj;
        obj2 = obj;
        ninepatchdrawable.draw(((Canvas) (obj1)));
        obj3 = obj;
        obj2 = obj;
        obj5 = new Matrix();
        obj3 = obj;
        obj2 = obj;
        ((Matrix) (obj5)).setScale(-1F, 1.0F);
        obj3 = obj;
        obj2 = obj;
        obj5 = Bitmap.createBitmap(b, 0, i, point.x, point.y - i, ((Matrix) (obj5)), false);
        b = null;
        paint.setAlpha(163);
        ((Canvas) (obj1)).drawBitmap(((Bitmap) (obj5)), matrix, paint);
        obj2 = new BitmapDrawable(aew.c(a).getResources(), c);
        b();
        aew.c(a).post(new afb(this, ((BitmapDrawable) (obj2))));
        if (obj != null)
        {
            ((Bitmap) (obj)).recycle();
        }
        if (obj5 != null)
        {
            ((Bitmap) (obj5)).recycle();
        }
        ((Canvas) (obj1)).restore();
_L2:
        return;
        obj1;
        obj1 = null;
        obj2 = null;
_L7:
        a();
        if (obj2 != null)
        {
            ((Bitmap) (obj2)).recycle();
        }
        if (obj1 != null)
        {
            ((Bitmap) (obj1)).recycle();
        }
        if (obj == null) goto _L2; else goto _L1
_L1:
        ((Canvas) (obj)).restore();
        return;
        obj;
        obj1 = null;
        obj = obj2;
        obj3 = obj7;
_L6:
        if (obj != null)
        {
            ((Bitmap) (obj)).recycle();
        }
        if (obj3 != null)
        {
            ((Bitmap) (obj3)).recycle();
        }
        if (obj1 == null) goto _L2; else goto _L3
_L3:
        ((Canvas) (obj1)).restore();
        return;
        obj2;
        obj1 = null;
        obj = obj3;
        obj5 = obj6;
_L5:
        if (obj != null)
        {
            ((Bitmap) (obj)).recycle();
        }
        if (obj5 != null)
        {
            ((Bitmap) (obj5)).recycle();
        }
        if (obj1 != null)
        {
            ((Canvas) (obj1)).restore();
        }
        throw obj2;
        obj2;
        obj5 = obj6;
        obj = obj3;
        continue; /* Loop/switch isn't completed */
        obj2;
        continue; /* Loop/switch isn't completed */
        Exception exception;
        exception;
        obj5 = obj1;
        obj3 = obj2;
        obj2 = exception;
        obj1 = obj;
        obj = obj3;
        if (true) goto _L5; else goto _L4
_L4:
        obj;
        obj3 = obj7;
        obj = obj2;
          goto _L6
        obj2;
        obj3 = obj5;
          goto _L6
        obj;
        obj = obj1;
        obj1 = null;
        obj2 = null;
          goto _L7
        InterruptedException interruptedexception;
        interruptedexception;
        Object obj4 = null;
        interruptedexception = ((InterruptedException) (obj));
        obj = obj1;
        obj1 = obj4;
          goto _L7
        interruptedexception;
        interruptedexception = ((InterruptedException) (obj));
        obj = obj1;
        obj1 = obj5;
          goto _L7
    }
}

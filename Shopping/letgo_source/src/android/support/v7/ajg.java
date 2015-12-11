// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

// Referenced classes of package android.support.v7:
//            ajf, ajl, ajk, aiv

public class ajg
    implements ajf
{
    public static class a extends Drawable
    {

        protected final float a;
        protected final int b;
        protected final RectF c = new RectF();
        protected final RectF d;
        protected final BitmapShader e;
        protected final Paint f = new Paint();

        public void draw(Canvas canvas)
        {
            canvas.drawRoundRect(c, a, a, f);
        }

        public int getOpacity()
        {
            return -3;
        }

        protected void onBoundsChange(Rect rect)
        {
            super.onBoundsChange(rect);
            c.set(b, b, rect.width() - b, rect.height() - b);
            rect = new Matrix();
            rect.setRectToRect(d, c, android.graphics.Matrix.ScaleToFit.FILL);
            e.setLocalMatrix(rect);
        }

        public void setAlpha(int i)
        {
            f.setAlpha(i);
        }

        public void setColorFilter(ColorFilter colorfilter)
        {
            f.setColorFilter(colorfilter);
        }

        public a(Bitmap bitmap, int i, int j)
        {
            a = i;
            b = j;
            e = new BitmapShader(bitmap, android.graphics.Shader.TileMode.CLAMP, android.graphics.Shader.TileMode.CLAMP);
            d = new RectF(j, j, bitmap.getWidth() - j, bitmap.getHeight() - j);
            f.setAntiAlias(true);
            f.setShader(e);
        }
    }


    protected final int a;
    protected final int b;

    public ajg(int i)
    {
        this(i, 0);
    }

    public ajg(int i, int j)
    {
        a = i;
        b = j;
    }

    public void a(Bitmap bitmap, ajk ajk1, aiv aiv)
    {
        if (!(ajk1 instanceof ajl))
        {
            throw new IllegalArgumentException("ImageAware should wrap ImageView. ImageViewAware is expected.");
        } else
        {
            ajk1.a(new a(bitmap, a, b));
            return;
        }
    }
}

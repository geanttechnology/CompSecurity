// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

public final class blw extends Drawable
{

    private final Paint a = new Paint();
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private Drawable g;

    public blw(Drawable drawable, int i, int j)
    {
        a.setAntiAlias(true);
        a(drawable);
        a(i, j);
    }

    private void b(Drawable drawable)
    {
        if (c <= 0 || d <= 0)
        {
            a.setShader(null);
            return;
        }
        if (drawable == null)
        {
            drawable = null;
        } else
        if (drawable instanceof BitmapDrawable)
        {
            drawable = ((BitmapDrawable)drawable).getBitmap();
        } else
        {
            int i;
            int j;
            if (drawable.getIntrinsicWidth() <= 0)
            {
                i = c;
            } else
            {
                i = drawable.getIntrinsicWidth();
            }
            if (drawable.getIntrinsicHeight() <= 0)
            {
                j = d;
            } else
            {
                j = drawable.getIntrinsicHeight();
            }
            if (j == 0 || i == 0)
            {
                drawable = null;
            } else
            {
                Bitmap bitmap = Bitmap.createBitmap(i, j, android.graphics.Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmap);
                drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
                drawable.draw(canvas);
                drawable = bitmap;
            }
        }
        if (drawable != null && drawable.getHeight() > 0 && drawable.getWidth() > 0)
        {
            drawable = bmd.a(drawable, c, d);
            a.setShader(new BitmapShader(drawable, android.graphics.Shader.TileMode.CLAMP, android.graphics.Shader.TileMode.CLAMP));
            return;
        } else
        {
            a.setShader(null);
            return;
        }
    }

    public final void a(int i, int j)
    {
        if (c == i && d == j)
        {
            return;
        } else
        {
            c = i;
            d = j;
            e = i / 2;
            f = j / 2;
            b = Math.min(e, f);
            b(g);
            return;
        }
    }

    public final void a(Drawable drawable)
    {
        g = drawable;
        b(drawable);
    }

    public final void draw(Canvas canvas)
    {
        if (a.getShader() == null)
        {
            return;
        } else
        {
            canvas.drawCircle(e, f, b, a);
            return;
        }
    }

    public final int getOpacity()
    {
        return -3;
    }

    public final void setAlpha(int i)
    {
        a.setAlpha(i);
    }

    public final void setColorFilter(ColorFilter colorfilter)
    {
        a.setColorFilter(colorfilter);
    }
}

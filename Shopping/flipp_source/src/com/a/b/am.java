// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.b;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.widget.ImageView;

// Referenced classes of package com.a.b:
//            aj

final class am extends Drawable
{

    private static final Paint f = new Paint();
    final BitmapDrawable a;
    Drawable b;
    long c;
    boolean d;
    int e;
    private final boolean g;
    private final float h;
    private final aj i;

    private am(Context context, Drawable drawable, Bitmap bitmap, aj aj1, boolean flag, boolean flag1)
    {
        e = 255;
        context = context.getResources();
        g = flag1;
        h = context.getDisplayMetrics().density;
        i = aj1;
        a = new BitmapDrawable(context, bitmap);
        boolean flag2;
        if (aj1 != aj.a && !flag)
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        if (flag2)
        {
            b = drawable;
            d = true;
            c = SystemClock.uptimeMillis();
        }
    }

    private static Path a(Point point, int j)
    {
        Point point1 = new Point(point.x + j, point.y);
        Point point2 = new Point(point.x, point.y + j);
        Path path = new Path();
        path.moveTo(point.x, point.y);
        path.lineTo(point1.x, point1.y);
        path.lineTo(point2.x, point2.y);
        return path;
    }

    static void a(ImageView imageview, int j, Drawable drawable)
    {
        if (j != 0)
        {
            imageview.setImageResource(j);
        } else
        {
            imageview.setImageDrawable(drawable);
        }
        if (imageview.getDrawable() instanceof AnimationDrawable)
        {
            ((AnimationDrawable)imageview.getDrawable()).start();
        }
    }

    static void a(ImageView imageview, Context context, Bitmap bitmap, aj aj1, boolean flag, boolean flag1)
    {
        Drawable drawable = imageview.getDrawable();
        if (drawable instanceof AnimationDrawable)
        {
            ((AnimationDrawable)drawable).stop();
        }
        imageview.setImageDrawable(new am(context, drawable, bitmap, aj1, flag, flag1));
    }

    public final void draw(Canvas canvas)
    {
        if (!d)
        {
            a.draw(canvas);
        } else
        {
            float f1 = (float)(SystemClock.uptimeMillis() - c) / 200F;
            if (f1 >= 1.0F)
            {
                d = false;
                b = null;
                a.draw(canvas);
            } else
            {
                if (b != null)
                {
                    b.draw(canvas);
                }
                int j = (int)(f1 * (float)e);
                a.setAlpha(j);
                a.draw(canvas);
                a.setAlpha(e);
                invalidateSelf();
            }
        }
        if (g)
        {
            f.setColor(-1);
            canvas.drawPath(a(new Point(0, 0), (int)(16F * h)), f);
            f.setColor(i.d);
            canvas.drawPath(a(new Point(0, 0), (int)(15F * h)), f);
        }
    }

    public final int getIntrinsicHeight()
    {
        return a.getIntrinsicHeight();
    }

    public final int getIntrinsicWidth()
    {
        return a.getIntrinsicWidth();
    }

    public final int getOpacity()
    {
        return a.getOpacity();
    }

    protected final void onBoundsChange(Rect rect)
    {
        super.onBoundsChange(rect);
        a.setBounds(rect);
        if (b != null)
        {
            b.setBounds(rect);
        }
    }

    public final void setAlpha(int j)
    {
        e = j;
        if (b != null)
        {
            b.setAlpha(j);
        }
        a.setAlpha(j);
    }

    public final void setColorFilter(ColorFilter colorfilter)
    {
        if (b != null)
        {
            b.setColorFilter(colorfilter);
        }
        a.setColorFilter(colorfilter);
    }

}

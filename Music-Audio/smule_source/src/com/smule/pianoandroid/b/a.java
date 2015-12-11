// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.b;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import org.xmlpull.v1.XmlPullParser;

// Referenced classes of package com.smule.pianoandroid.b:
//            b

public class a extends Drawable
    implements android.graphics.drawable.Drawable.Callback
{

    private b a;
    private final Rect b;
    private Bitmap c;
    private Canvas d;
    private Paint e;

    a()
    {
        this(((b) (null)), ((Resources) (null)));
    }

    public a(Drawable drawable, int i)
    {
        this(((b) (null)), ((Resources) (null)));
        a.a = drawable;
        a.d = i;
        if (drawable != null)
        {
            drawable.setCallback(this);
        }
        e = new Paint();
        e.setStyle(android.graphics.Paint.Style.FILL);
        e.setFilterBitmap(false);
        e.setColor(-13244);
    }

    private a(b b1, Resources resources)
    {
        b = new Rect();
        a = new b(b1, this, resources);
    }


    public void draw(Canvas canvas)
    {
        if (a.a.getLevel() != 0)
        {
            Rect rect = b;
            Rect rect1 = getBounds();
            int i = getLevel();
            int j = rect1.width();
            int l = rect1.height();
            Gravity.apply(a.d, j, l, rect1, rect);
            if (j > 0 && l > 0)
            {
                canvas.save();
                int k = canvas.saveLayer(0.0F, 0.0F, rect1.width(), rect1.height(), null, 31);
                a.a.draw(canvas);
                if (c == null)
                {
                    c = Bitmap.createBitmap(rect1.width(), rect1.height(), android.graphics.Bitmap.Config.ARGB_8888);
                    d = new Canvas(c);
                } else
                {
                    d.drawColor(0, android.graphics.PorterDuff.Mode.CLEAR);
                }
                i = ((10000 - i) * 360) / 10000;
                if (i > 270)
                {
                    d.drawArc(new RectF(rect1), 0.0F, 270F, true, e);
                    i -= 270;
                    d.drawArc(new RectF(rect1), 360 - i, i, true, e);
                } else
                {
                    d.drawArc(new RectF(rect1), 270 - i, i, true, e);
                }
                e.setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.DST_OUT));
                canvas.drawBitmap(c, rect1, rect1, e);
                e.setXfermode(null);
                canvas.restoreToCount(k);
                canvas.restore();
                return;
            }
        }
    }

    public int getChangingConfigurations()
    {
        return super.getChangingConfigurations() | a.b | a.a.getChangingConfigurations();
    }

    public android.graphics.drawable.Drawable.ConstantState getConstantState()
    {
        if (a.a())
        {
            a.b = getChangingConfigurations();
            return a;
        } else
        {
            return null;
        }
    }

    public int getIntrinsicHeight()
    {
        return a.a.getIntrinsicHeight();
    }

    public int getIntrinsicWidth()
    {
        return a.a.getIntrinsicWidth();
    }

    public int getOpacity()
    {
        return a.a.getOpacity();
    }

    public boolean getPadding(Rect rect)
    {
        return a.a.getPadding(rect);
    }

    public void inflate(Resources resources, XmlPullParser xmlpullparser, AttributeSet attributeset)
    {
        super.inflate(resources, xmlpullparser, attributeset);
    }

    public void invalidateDrawable(Drawable drawable)
    {
        drawable = getCallback();
        if (drawable != null)
        {
            drawable.invalidateDrawable(this);
        }
    }

    public boolean isStateful()
    {
        return a.a.isStateful();
    }

    protected void onBoundsChange(Rect rect)
    {
        a.a.setBounds(rect);
    }

    protected boolean onLevelChange(int i)
    {
        a.a.setLevel(i);
        invalidateSelf();
        return true;
    }

    protected boolean onStateChange(int ai[])
    {
        return a.a.setState(ai);
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long l)
    {
        drawable = getCallback();
        if (drawable != null)
        {
            drawable.scheduleDrawable(this, runnable, l);
        }
    }

    public void setAlpha(int i)
    {
        a.a.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorfilter)
    {
        a.a.setColorFilter(colorfilter);
    }

    public boolean setVisible(boolean flag, boolean flag1)
    {
        a.a.setVisible(flag, flag1);
        return super.setVisible(flag, flag1);
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable)
    {
        drawable = getCallback();
        if (drawable != null)
        {
            drawable.unscheduleDrawable(this, runnable);
        }
    }
}

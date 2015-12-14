// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.request.target;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;

public class SquaringDrawable extends GlideDrawable
{

    private final int side;
    private final GlideDrawable wrapped;

    public SquaringDrawable(GlideDrawable glidedrawable, int i)
    {
        wrapped = glidedrawable;
        side = i;
    }

    public void clearColorFilter()
    {
        wrapped.clearColorFilter();
    }

    public void draw(Canvas canvas)
    {
        wrapped.draw(canvas);
    }

    public int getAlpha()
    {
        return wrapped.getAlpha();
    }

    public android.graphics.drawable.Drawable.Callback getCallback()
    {
        return wrapped.getCallback();
    }

    public int getChangingConfigurations()
    {
        return wrapped.getChangingConfigurations();
    }

    public Drawable getCurrent()
    {
        return wrapped.getCurrent();
    }

    public int getIntrinsicHeight()
    {
        return side;
    }

    public int getIntrinsicWidth()
    {
        return side;
    }

    public int getMinimumHeight()
    {
        return wrapped.getMinimumHeight();
    }

    public int getMinimumWidth()
    {
        return wrapped.getMinimumWidth();
    }

    public int getOpacity()
    {
        return wrapped.getOpacity();
    }

    public boolean getPadding(Rect rect)
    {
        return wrapped.getPadding(rect);
    }

    public void invalidateSelf()
    {
        super.invalidateSelf();
        wrapped.invalidateSelf();
    }

    public boolean isAnimated()
    {
        return wrapped.isAnimated();
    }

    public boolean isRunning()
    {
        return wrapped.isRunning();
    }

    public void scheduleSelf(Runnable runnable, long l)
    {
        super.scheduleSelf(runnable, l);
        wrapped.scheduleSelf(runnable, l);
    }

    public void setAlpha(int i)
    {
        wrapped.setAlpha(i);
    }

    public void setBounds(int i, int j, int k, int l)
    {
        super.setBounds(i, j, k, l);
        wrapped.setBounds(i, j, k, l);
    }

    public void setBounds(Rect rect)
    {
        super.setBounds(rect);
        wrapped.setBounds(rect);
    }

    public void setChangingConfigurations(int i)
    {
        wrapped.setChangingConfigurations(i);
    }

    public void setColorFilter(int i, android.graphics.PorterDuff.Mode mode)
    {
        wrapped.setColorFilter(i, mode);
    }

    public void setColorFilter(ColorFilter colorfilter)
    {
        wrapped.setColorFilter(colorfilter);
    }

    public void setDither(boolean flag)
    {
        wrapped.setDither(flag);
    }

    public void setFilterBitmap(boolean flag)
    {
        wrapped.setFilterBitmap(flag);
    }

    public void setLoopCount(int i)
    {
        wrapped.setLoopCount(i);
    }

    public boolean setVisible(boolean flag, boolean flag1)
    {
        return wrapped.setVisible(flag, flag1);
    }

    public void start()
    {
        wrapped.start();
    }

    public void stop()
    {
        wrapped.stop();
    }

    public void unscheduleSelf(Runnable runnable)
    {
        super.unscheduleSelf(runnable);
        wrapped.unscheduleSelf(runnable);
    }
}

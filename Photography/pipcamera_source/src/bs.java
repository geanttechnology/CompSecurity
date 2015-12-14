// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.DrawableCompat;

class bs extends Drawable
    implements android.graphics.drawable.Drawable.Callback
{

    private final Drawable a;

    public bs(Drawable drawable)
    {
        a = drawable;
        a.setCallback(this);
    }

    public void draw(Canvas canvas)
    {
        a.draw(canvas);
    }

    public int getChangingConfigurations()
    {
        return a.getChangingConfigurations();
    }

    public Drawable getCurrent()
    {
        return a.getCurrent();
    }

    public int getIntrinsicHeight()
    {
        return a.getIntrinsicHeight();
    }

    public int getIntrinsicWidth()
    {
        return a.getIntrinsicWidth();
    }

    public int getMinimumHeight()
    {
        return a.getMinimumHeight();
    }

    public int getMinimumWidth()
    {
        return a.getMinimumWidth();
    }

    public int getOpacity()
    {
        return a.getOpacity();
    }

    public boolean getPadding(Rect rect)
    {
        return a.getPadding(rect);
    }

    public int[] getState()
    {
        return a.getState();
    }

    public Region getTransparentRegion()
    {
        return a.getTransparentRegion();
    }

    public void invalidateDrawable(Drawable drawable)
    {
        invalidateSelf();
    }

    public boolean isAutoMirrored()
    {
        return DrawableCompat.isAutoMirrored(a);
    }

    public boolean isStateful()
    {
        return a.isStateful();
    }

    public void jumpToCurrentState()
    {
        DrawableCompat.jumpToCurrentState(a);
    }

    protected boolean onLevelChange(int i)
    {
        return a.setLevel(i);
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long l)
    {
        scheduleSelf(runnable, l);
    }

    public void setAlpha(int i)
    {
        a.setAlpha(i);
    }

    public void setAutoMirrored(boolean flag)
    {
        DrawableCompat.setAutoMirrored(a, flag);
    }

    public void setBounds(int i, int j, int k, int l)
    {
        super.setBounds(i, j, k, l);
        a.setBounds(i, j, k, l);
    }

    public void setChangingConfigurations(int i)
    {
        a.setChangingConfigurations(i);
    }

    public void setColorFilter(ColorFilter colorfilter)
    {
        a.setColorFilter(colorfilter);
    }

    public void setDither(boolean flag)
    {
        a.setDither(flag);
    }

    public void setFilterBitmap(boolean flag)
    {
        a.setFilterBitmap(flag);
    }

    public void setHotspot(float f, float f1)
    {
        DrawableCompat.setHotspot(a, f, f1);
    }

    public void setHotspotBounds(int i, int j, int k, int l)
    {
        DrawableCompat.setHotspotBounds(a, i, j, k, l);
    }

    public boolean setState(int ai[])
    {
        return a.setState(ai);
    }

    public void setTint(int i)
    {
        DrawableCompat.setTint(a, i);
    }

    public void setTintList(ColorStateList colorstatelist)
    {
        DrawableCompat.setTintList(a, colorstatelist);
    }

    public void setTintMode(android.graphics.PorterDuff.Mode mode)
    {
        DrawableCompat.setTintMode(a, mode);
    }

    public boolean setVisible(boolean flag, boolean flag1)
    {
        return super.setVisible(flag, flag1) || a.setVisible(flag, flag1);
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable)
    {
        unscheduleSelf(runnable);
    }
}

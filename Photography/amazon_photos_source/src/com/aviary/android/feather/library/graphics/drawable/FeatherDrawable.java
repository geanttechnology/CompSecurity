// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.library.graphics.drawable;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;

public interface FeatherDrawable
{

    public abstract void clearColorFilter();

    public abstract Rect copyBounds();

    public abstract void copyBounds(Rect rect);

    public abstract void draw(Canvas canvas);

    public abstract Rect getBounds();

    public abstract int getChangingConfigurations();

    public abstract Drawable getCurrent();

    public abstract float getCurrentHeight();

    public abstract float getCurrentWidth();

    public abstract boolean getHorizontalFlip();

    public abstract boolean getHorizontalFlipEnabled();

    public abstract int getLevel();

    public abstract float getMinHeight();

    public abstract float getMinWidth();

    public abstract int getMinimumHeight();

    public abstract int getMinimumWidth();

    public abstract int getOpacity();

    public abstract boolean getPadding(Rect rect);

    public abstract float getScaleX();

    public abstract int[] getState();

    public abstract Region getTransparentRegion();

    public abstract void invalidateSelf();

    public abstract boolean isStateful();

    public abstract boolean isVisible();

    public abstract Drawable mutate();

    public abstract void scheduleSelf(Runnable runnable, long l);

    public abstract void setAlpha(int i);

    public abstract void setBounds(int i, int j, int k, int l);

    public abstract void setBounds(Rect rect);

    public abstract void setCallback(android.graphics.drawable.Drawable.Callback callback);

    public abstract void setChangingConfigurations(int i);

    public abstract void setColorFilter(int i, android.graphics.PorterDuff.Mode mode);

    public abstract void setColorFilter(ColorFilter colorfilter);

    public abstract void setDither(boolean flag);

    public abstract void setFilterBitmap(boolean flag);

    public abstract void setHorizontalFlip(boolean flag);

    public abstract boolean setLevel(int i);

    public abstract void setMinSize(float f, float f1);

    public abstract void setScaleX(float f);

    public abstract boolean setState(int ai[]);

    public abstract boolean setVisible(boolean flag, boolean flag1);

    public abstract void unscheduleSelf(Runnable runnable);

    public abstract boolean validateSize(RectF rectf);
}

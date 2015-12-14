// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.resource.bitmap;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.Gravity;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;

public class GlideBitmapDrawable extends GlideDrawable
{
    static class BitmapState extends android.graphics.drawable.Drawable.ConstantState
    {

        private static final Paint DEFAULT_PAINT = new Paint(6);
        final Bitmap bitmap;
        Paint paint;
        int targetDensity;

        public int getChangingConfigurations()
        {
            return 0;
        }

        void mutatePaint()
        {
            if (DEFAULT_PAINT == paint)
            {
                paint = new Paint(6);
            }
        }

        public Drawable newDrawable()
        {
            return new GlideBitmapDrawable(null, this);
        }

        public Drawable newDrawable(Resources resources)
        {
            return new GlideBitmapDrawable(resources, this);
        }

        void setAlpha(int i)
        {
            mutatePaint();
            paint.setAlpha(i);
        }

        void setColorFilter(ColorFilter colorfilter)
        {
            mutatePaint();
            paint.setColorFilter(colorfilter);
        }


        public BitmapState(Bitmap bitmap1)
        {
            paint = DEFAULT_PAINT;
            bitmap = bitmap1;
        }

        BitmapState(BitmapState bitmapstate)
        {
            this(bitmapstate.bitmap);
            targetDensity = bitmapstate.targetDensity;
        }
    }


    private boolean applyGravity;
    private final Rect destRect;
    private int height;
    private boolean mutated;
    private BitmapState state;
    private int width;

    public GlideBitmapDrawable(Resources resources, Bitmap bitmap)
    {
        this(resources, new BitmapState(bitmap));
    }

    GlideBitmapDrawable(Resources resources, BitmapState bitmapstate)
    {
        destRect = new Rect();
        if (bitmapstate == null)
        {
            throw new NullPointerException("BitmapState must not be null");
        }
        state = bitmapstate;
        int i;
        if (resources != null)
        {
            i = resources.getDisplayMetrics().densityDpi;
            if (i == 0)
            {
                i = 160;
            }
            bitmapstate.targetDensity = i;
        } else
        {
            i = bitmapstate.targetDensity;
        }
        width = bitmapstate.bitmap.getScaledWidth(i);
        height = bitmapstate.bitmap.getScaledHeight(i);
    }

    public void draw(Canvas canvas)
    {
        if (applyGravity)
        {
            Gravity.apply(119, width, height, getBounds(), destRect);
            applyGravity = false;
        }
        canvas.drawBitmap(state.bitmap, null, destRect, state.paint);
    }

    public Bitmap getBitmap()
    {
        return state.bitmap;
    }

    public android.graphics.drawable.Drawable.ConstantState getConstantState()
    {
        return state;
    }

    public int getIntrinsicHeight()
    {
        return height;
    }

    public int getIntrinsicWidth()
    {
        return width;
    }

    public int getOpacity()
    {
        Bitmap bitmap = state.bitmap;
        return bitmap != null && !bitmap.hasAlpha() && state.paint.getAlpha() >= 255 ? -1 : -3;
    }

    public boolean isAnimated()
    {
        return false;
    }

    public boolean isRunning()
    {
        return false;
    }

    public Drawable mutate()
    {
        if (!mutated && super.mutate() == this)
        {
            state = new BitmapState(state);
            mutated = true;
        }
        return this;
    }

    protected void onBoundsChange(Rect rect)
    {
        super.onBoundsChange(rect);
        applyGravity = true;
    }

    public void setAlpha(int i)
    {
        if (state.paint.getAlpha() != i)
        {
            state.setAlpha(i);
            invalidateSelf();
        }
    }

    public void setColorFilter(ColorFilter colorfilter)
    {
        state.setColorFilter(colorfilter);
        invalidateSelf();
    }

    public void setLoopCount(int i)
    {
    }

    public void start()
    {
    }

    public void stop()
    {
    }
}

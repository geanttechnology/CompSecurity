// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.facebook.common.internal.Preconditions;

// Referenced classes of package com.facebook.drawee.drawable:
//            TransformCallback, TransformAwareDrawable, DrawableProperties, DrawableUtils

public class ArrayDrawable extends Drawable
    implements android.graphics.drawable.Drawable.Callback, TransformCallback, TransformAwareDrawable
{

    private final DrawableProperties mDrawableProperties = new DrawableProperties();
    private boolean mIsMutated;
    private boolean mIsStateful;
    private boolean mIsStatefulCalculated;
    private final Drawable mLayers[];
    private final Rect mTmpRect = new Rect();
    private TransformCallback mTransformCallback;

    public ArrayDrawable(Drawable adrawable[])
    {
        mIsStateful = false;
        mIsStatefulCalculated = false;
        mIsMutated = false;
        Preconditions.checkNotNull(adrawable);
        mLayers = adrawable;
        for (int i = 0; i < mLayers.length; i++)
        {
            DrawableUtils.setCallbacks(mLayers[i], this, this);
        }

    }

    public void draw(Canvas canvas)
    {
        for (int i = 0; i < mLayers.length; i++)
        {
            mLayers[i].draw(canvas);
        }

    }

    public Drawable getDrawable(int i)
    {
        return mLayers[i];
    }

    public int getIntrinsicHeight()
    {
        int j = -1;
        for (int i = 0; i < mLayers.length; i++)
        {
            j = Math.max(j, mLayers[i].getIntrinsicHeight());
        }

        if (j > 0)
        {
            return j;
        } else
        {
            return -1;
        }
    }

    public int getIntrinsicWidth()
    {
        int j = -1;
        for (int i = 0; i < mLayers.length; i++)
        {
            j = Math.max(j, mLayers[i].getIntrinsicWidth());
        }

        if (j > 0)
        {
            return j;
        } else
        {
            return -1;
        }
    }

    public int getNumberOfLayers()
    {
        return mLayers.length;
    }

    public int getOpacity()
    {
        if (mLayers.length != 0) goto _L2; else goto _L1
_L1:
        int k = -2;
_L4:
        return k;
_L2:
        int i = mLayers[0].getOpacity();
        int j = 1;
        do
        {
            k = i;
            if (j >= mLayers.length)
            {
                continue;
            }
            i = Drawable.resolveOpacity(i, mLayers[j].getOpacity());
            j++;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public boolean getPadding(Rect rect)
    {
        rect.left = 0;
        rect.top = 0;
        rect.right = 0;
        rect.bottom = 0;
        Rect rect1 = mTmpRect;
        for (int i = 0; i < mLayers.length; i++)
        {
            mLayers[i].getPadding(rect1);
            rect.left = Math.max(rect.left, rect1.left);
            rect.top = Math.max(rect.top, rect1.top);
            rect.right = Math.max(rect.right, rect1.right);
            rect.bottom = Math.max(rect.bottom, rect1.bottom);
        }

        return true;
    }

    public void getRootBounds(RectF rectf)
    {
        if (mTransformCallback != null)
        {
            mTransformCallback.getRootBounds(rectf);
            return;
        } else
        {
            rectf.set(getBounds());
            return;
        }
    }

    public void getTransform(Matrix matrix)
    {
        if (mTransformCallback != null)
        {
            mTransformCallback.getTransform(matrix);
            return;
        } else
        {
            matrix.reset();
            return;
        }
    }

    public void invalidateDrawable(Drawable drawable)
    {
        invalidateSelf();
    }

    public boolean isStateful()
    {
        if (!mIsStatefulCalculated)
        {
            mIsStateful = false;
            for (int i = 0; i < mLayers.length; i++)
            {
                mIsStateful = mIsStateful | mLayers[i].isStateful();
            }

            mIsStatefulCalculated = true;
        }
        return mIsStateful;
    }

    public Drawable mutate()
    {
        for (int i = 0; i < mLayers.length; i++)
        {
            mLayers[i].mutate();
        }

        mIsMutated = true;
        return this;
    }

    protected void onBoundsChange(Rect rect)
    {
        for (int i = 0; i < mLayers.length; i++)
        {
            mLayers[i].setBounds(rect);
        }

    }

    protected boolean onLevelChange(int i)
    {
        boolean flag = false;
        for (int j = 0; j < mLayers.length; j++)
        {
            if (mLayers[j].setLevel(i))
            {
                flag = true;
            }
        }

        return flag;
    }

    protected boolean onStateChange(int ai[])
    {
        boolean flag = false;
        for (int i = 0; i < mLayers.length; i++)
        {
            if (mLayers[i].setState(ai))
            {
                flag = true;
            }
        }

        return flag;
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long l)
    {
        scheduleSelf(runnable, l);
    }

    public void setAlpha(int i)
    {
        mDrawableProperties.setAlpha(i);
        for (int j = 0; j < mLayers.length; j++)
        {
            mLayers[j].setAlpha(i);
        }

    }

    public void setColorFilter(ColorFilter colorfilter)
    {
        mDrawableProperties.setColorFilter(colorfilter);
        for (int i = 0; i < mLayers.length; i++)
        {
            mLayers[i].setColorFilter(colorfilter);
        }

    }

    public void setDither(boolean flag)
    {
        mDrawableProperties.setDither(flag);
        for (int i = 0; i < mLayers.length; i++)
        {
            mLayers[i].setDither(flag);
        }

    }

    public void setDrawable(int i, Drawable drawable)
    {
        boolean flag1 = true;
        boolean flag;
        if (i >= 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Preconditions.checkArgument(flag);
        if (i < mLayers.length)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        Preconditions.checkArgument(flag);
        if (drawable != mLayers[i])
        {
            Drawable drawable1 = drawable;
            if (mIsMutated)
            {
                drawable1 = drawable.mutate();
            }
            DrawableUtils.setCallbacks(mLayers[i], null, null);
            DrawableUtils.setCallbacks(drawable1, null, null);
            DrawableUtils.setDrawableProperties(drawable1, mDrawableProperties);
            DrawableUtils.copyProperties(drawable1, mLayers[i]);
            DrawableUtils.setCallbacks(drawable1, this, this);
            mIsStatefulCalculated = false;
            mLayers[i] = drawable1;
            invalidateSelf();
        }
    }

    public void setFilterBitmap(boolean flag)
    {
        mDrawableProperties.setFilterBitmap(flag);
        for (int i = 0; i < mLayers.length; i++)
        {
            mLayers[i].setFilterBitmap(flag);
        }

    }

    public void setTransformCallback(TransformCallback transformcallback)
    {
        mTransformCallback = transformcallback;
    }

    public boolean setVisible(boolean flag, boolean flag1)
    {
        boolean flag2 = super.setVisible(flag, flag1);
        for (int i = 0; i < mLayers.length; i++)
        {
            mLayers[i].setVisible(flag, flag1);
        }

        return flag2;
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable)
    {
        unscheduleSelf(runnable);
    }
}

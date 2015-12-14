// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.graphics;

import android.graphics.Bitmap;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.aviary.android.feather.common.log.LoggerFactory;
import com.aviary.android.feather.sdk.utils.UIUtils;

public class GlowDrawable extends Drawable
{
    static class GlowDrawableState
    {

        boolean checked;
        boolean pressed;
        boolean selected;

        public String toString()
        {
            return (new StringBuilder()).append("{ pressed: ").append(pressed).append(", checked: ").append(checked).append(", selected: ").append(selected).append(" }").toString();
        }

        public boolean updateStateSet(int ai[])
        {
            int j = ai.length;
            boolean flag1 = false;
            boolean flag2 = false;
            boolean flag = false;
            int i = 0;
            while (i < j) 
            {
                int k = ai[i];
                boolean flag3 = flag2;
                boolean flag5 = flag1;
                boolean flag6 = flag;
                if (k > 0)
                {
                    if (k == 0x10100a1)
                    {
                        flag6 = true;
                        flag5 = flag1;
                        flag3 = flag2;
                    } else
                    if (k == 0x10100a7)
                    {
                        flag5 = true;
                        flag3 = flag2;
                        flag6 = flag;
                    } else
                    {
                        flag3 = flag2;
                        flag5 = flag1;
                        flag6 = flag;
                        if (k == 0x10100a0)
                        {
                            flag3 = true;
                            flag5 = flag1;
                            flag6 = flag;
                        }
                    }
                }
                i++;
                flag2 = flag3;
                flag1 = flag5;
                flag = flag6;
            }
            boolean flag4;
            if (pressed != flag1 || checked != flag2 || selected != flag)
            {
                flag4 = true;
            } else
            {
                flag4 = false;
            }
            pressed = flag1;
            checked = flag2;
            selected = flag;
            return flag4;
        }

        GlowDrawableState()
        {
        }
    }


    private static com.aviary.android.feather.common.log.LoggerFactory.Logger logger;
    private static int mCount = 0;
    private Bitmap mBackground;
    private int mBlurValue;
    private GlowDrawableState mCurrentStateSet;
    private boolean mDraw;
    protected Drawable mDrawable;
    private Rect mDstRect;
    private int mGlowMode;
    private int mHighlightColorChecked;
    private int mHighlightColorPressed;
    private int mHighlightColorSelected;
    private int mHighlightMode;
    protected Paint mPaint;
    protected Paint mPaintBlur;
    private int mThisCount;
    private Canvas tmpCanvas;

    public GlowDrawable(Drawable drawable, int i, int j, int k, int l, int i1, int j1)
    {
        mDstRect = new Rect();
        tmpCanvas = new Canvas();
        mCurrentStateSet = new GlowDrawableState();
        int k1 = mCount + 1;
        mCount = k1;
        mThisCount = k1;
        mPaint = new Paint();
        mPaint.setDither(true);
        mPaint.setFilterBitmap(true);
        mPaintBlur = new Paint();
        mPaintBlur.setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.DARKEN));
        initialize(i, j, k, l, i1, j1);
        setDrawable(drawable);
    }

    private void initialize(int i, int j, int k, int l, int i1, int j1)
    {
        mHighlightColorChecked = j;
        mHighlightColorPressed = i;
        mHighlightColorSelected = k;
        mBlurValue = l;
        mGlowMode = j1;
        mHighlightMode = i1;
    }

    private void recycleBackground()
    {
        if (mBackground != null && !mBackground.isRecycled())
        {
            mBackground.recycle();
        }
        mBackground = null;
    }

    public static boolean stateSetContains(int ai[], int i)
    {
        int k = ai.length;
        for (int j = 0; j < k; j++)
        {
            int l = ai[j];
            if (l > 0 && l == i)
            {
                return true;
            }
        }

        return false;
    }

    public void draw(Canvas canvas)
    {
        copyBounds(mDstRect);
        if (mDraw && mBackground != null && !mBackground.isRecycled())
        {
            canvas.drawBitmap(mBackground, null, mDstRect, getPaint());
            return;
        } else
        {
            mDrawable.draw(canvas);
            return;
        }
    }

    public Bitmap generateBitmap(Drawable drawable, int i, boolean flag)
    {
        logger.info((new StringBuilder()).append(this).append(", generateBitmap").toString());
        Bitmap bitmap;
        if (drawable instanceof BitmapDrawable)
        {
            bitmap = ((BitmapDrawable)drawable).getBitmap();
        } else
        {
            bitmap = Bitmap.createBitmap(mBackground.getWidth(), mBackground.getHeight(), android.graphics.Bitmap.Config.ARGB_8888);
            tmpCanvas.setBitmap(bitmap);
            drawable.draw(tmpCanvas);
        }
        mBackground.eraseColor(0);
        tmpCanvas.setBitmap(mBackground);
        bitmap = bitmap.extractAlpha();
        drawable.draw(tmpCanvas);
        mPaintBlur.setMaskFilter(null);
        mPaintBlur.setColor(i);
        tmpCanvas.drawBitmap(bitmap, 0.0F, 0.0F, mPaintBlur);
        if (flag)
        {
            drawable = new BlurMaskFilter(mBlurValue, android.graphics.BlurMaskFilter.Blur.NORMAL);
            mPaintBlur.setMaskFilter(drawable);
            mPaintBlur.setAlpha(100);
            tmpCanvas.drawBitmap(bitmap, 0.0F, 0.0F, mPaintBlur);
        }
        return mBackground;
    }

    public int getIntrinsicHeight()
    {
        return mDrawable.getIntrinsicHeight();
    }

    public int getIntrinsicWidth()
    {
        return mDrawable.getIntrinsicWidth();
    }

    public int getMinimumHeight()
    {
        return mDrawable.getMinimumHeight();
    }

    public int getMinimumWidth()
    {
        return mDrawable.getMinimumWidth();
    }

    public int getOpacity()
    {
        return -3;
    }

    public Paint getPaint()
    {
        return mPaint;
    }

    void invalidateBackground(int i, int j)
    {
        logger.info((new StringBuilder()).append(this).append(", invalidateBitmap, current: ").append(mBackground).append(", size: ").append(i).append("x").append(j).toString());
        if (i > 0 && j > 0)
        {
            if (mBackground != null)
            {
                if (mBackground.getWidth() != i || mBackground.getHeight() != j || mBackground.isRecycled())
                {
                    recycleBackground();
                    mBackground = Bitmap.createBitmap(i, j, android.graphics.Bitmap.Config.ARGB_8888);
                }
                return;
            } else
            {
                mBackground = Bitmap.createBitmap(i, j, android.graphics.Bitmap.Config.ARGB_8888);
                return;
            }
        } else
        {
            recycleBackground();
            return;
        }
    }

    public boolean isStateful()
    {
        return true;
    }

    protected void onBoundsChange(Rect rect)
    {
        mDrawable.setBounds(rect);
        super.onBoundsChange(rect);
        invalidateBackground(rect.width(), rect.height());
    }

    protected boolean onStateChange(int ai[])
    {
        boolean flag;
label0:
        {
            flag = mCurrentStateSet.updateStateSet(ai);
            if (flag && mBackground != null)
            {
                logger.log((new StringBuilder()).append(this).append(", onStateChange: ").append(mCurrentStateSet.toString()).append(", changed: ").append(flag).toString());
                if (!mCurrentStateSet.pressed || !UIUtils.checkBits(mHighlightMode, 2))
                {
                    break label0;
                }
                generateBitmap(mDrawable, mHighlightColorPressed, UIUtils.checkBits(mGlowMode, 2));
                mDraw = true;
            }
            return flag;
        }
        if (mCurrentStateSet.checked && UIUtils.checkBits(mHighlightMode, 4))
        {
            generateBitmap(mDrawable, mHighlightColorChecked, UIUtils.checkBits(mGlowMode, 4));
            mDraw = true;
            return flag;
        }
        if (mCurrentStateSet.selected && UIUtils.checkBits(mHighlightMode, 8))
        {
            generateBitmap(mDrawable, mHighlightColorSelected, UIUtils.checkBits(mGlowMode, 8));
            mDraw = true;
            return flag;
        } else
        {
            mDraw = false;
            return flag;
        }
    }

    public void setAlpha(int i)
    {
        mPaint.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorfilter)
    {
        mPaint.setColorFilter(colorfilter);
    }

    public void setDrawable(Drawable drawable)
    {
        mDrawable = drawable;
    }

    public boolean setState(int ai[])
    {
        mDrawable.setState(ai);
        return super.setState(ai);
    }

    public String toString()
    {
        return (new StringBuilder()).append("GlowDrawable(").append(mThisCount).append(")").toString();
    }

    public void update(int i, int j, int k, int l, int i1, int j1)
    {
        initialize(i, j, k, l, i1, j1);
        setState(getState());
    }

    static 
    {
        logger = LoggerFactory.getLogger("glow-drawable", com.aviary.android.feather.common.log.LoggerFactory.LoggerType.ConsoleLoggerType);
    }
}

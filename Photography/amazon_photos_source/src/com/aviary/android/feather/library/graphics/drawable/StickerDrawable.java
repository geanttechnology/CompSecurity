// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.library.graphics.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;

// Referenced classes of package com.aviary.android.feather.library.graphics.drawable:
//            FeatherDrawable

public class StickerDrawable extends BitmapDrawable
    implements FeatherDrawable
{

    BlurMaskFilter mBlurFilter;
    boolean mDrawShadow;
    boolean mFlip;
    Matrix mMirrorMatrix;
    private String mPackIdentifier;
    float mScaleX;
    Bitmap mShadowBitmap;
    private Paint mShadowBitmapPaint;
    Paint mShadowPaint;
    private String mStickerIdentifier;
    Rect mTempRect;
    private float minHeight;
    private float minWidth;

    public StickerDrawable(Resources resources, Bitmap bitmap, String s, String s1)
    {
        super(resources, bitmap);
        minWidth = 0.0F;
        minHeight = 0.0F;
        mDrawShadow = true;
        mTempRect = new Rect();
        mMirrorMatrix = new Matrix();
        mScaleX = 1.0F;
        mStickerIdentifier = s;
        mPackIdentifier = s1;
        mBlurFilter = new BlurMaskFilter(5F, android.graphics.BlurMaskFilter.Blur.OUTER);
        mShadowPaint = new Paint(1);
        mShadowPaint.setMaskFilter(mBlurFilter);
        resources = new int[2];
        mShadowBitmap = getBitmap().extractAlpha(mShadowPaint, resources);
    }

    public StickerDrawable(Resources resources, String s, String s1, String s2)
    {
        super(resources, BitmapFactory.decodeFile(s));
        minWidth = 0.0F;
        minHeight = 0.0F;
        mDrawShadow = true;
        mTempRect = new Rect();
        mMirrorMatrix = new Matrix();
        mScaleX = 1.0F;
        mStickerIdentifier = s1;
        mPackIdentifier = s2;
        mBlurFilter = new BlurMaskFilter(5F, android.graphics.BlurMaskFilter.Blur.OUTER);
        mShadowPaint = new Paint(1);
        mShadowPaint.setMaskFilter(mBlurFilter);
        resources = new int[2];
        mShadowBitmap = getBitmap().extractAlpha(mShadowPaint, resources);
        mShadowBitmapPaint = new Paint(1);
    }

    public void draw(Canvas canvas)
    {
        int i = canvas.save();
        copyBounds(mTempRect);
        mMirrorMatrix.reset();
        mMirrorMatrix.postScale(mScaleX, 1.0F, mTempRect.centerX(), mTempRect.centerY());
        canvas.concat(mMirrorMatrix);
        if (mDrawShadow)
        {
            canvas.drawBitmap(mShadowBitmap, null, mTempRect, mShadowBitmapPaint);
        }
        super.draw(canvas);
        canvas.restoreToCount(i);
    }

    public int getBitmapHeight()
    {
        return getBitmap().getHeight();
    }

    public int getBitmapWidth()
    {
        return getBitmap().getWidth();
    }

    public float getCurrentHeight()
    {
        return (float)getIntrinsicHeight();
    }

    public float getCurrentWidth()
    {
        return (float)getIntrinsicWidth();
    }

    public boolean getHorizontalFlip()
    {
        return mFlip;
    }

    public boolean getHorizontalFlipEnabled()
    {
        return true;
    }

    public String getIdentifier()
    {
        return mStickerIdentifier;
    }

    public float getMinHeight()
    {
        return minHeight;
    }

    public float getMinWidth()
    {
        return minWidth;
    }

    public String getPackIdentifier()
    {
        return mPackIdentifier;
    }

    public float getScaleX()
    {
        return mScaleX;
    }

    public void setAlpha(int i)
    {
        super.setAlpha(i);
        mShadowBitmapPaint.setAlpha(i);
    }

    public void setDropShadow(boolean flag)
    {
        mDrawShadow = flag;
        invalidateSelf();
    }

    public void setHorizontalFlip(boolean flag)
    {
        float f;
        if (flag)
        {
            f = -1F;
        } else
        {
            f = 1.0F;
        }
        mScaleX = f;
        mFlip = flag;
        invalidateSelf();
    }

    public void setMinSize(float f, float f1)
    {
        minWidth = f;
        minHeight = f1;
    }

    public void setScaleX(float f)
    {
        mScaleX = f;
        invalidateSelf();
    }

    public boolean validateSize(RectF rectf)
    {
        return rectf.width() >= minWidth && rectf.height() >= minHeight;
    }
}

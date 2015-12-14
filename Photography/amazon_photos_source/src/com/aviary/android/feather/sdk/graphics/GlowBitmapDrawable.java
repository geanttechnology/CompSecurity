// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.graphics;

import android.graphics.Bitmap;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import com.aviary.android.feather.sdk.utils.UIUtils;
import it.sephiroth.android.library.imagezoom.graphics.FastBitmapDrawable;

public class GlowBitmapDrawable extends FastBitmapDrawable
{

    private static final String LOG_TAG = "glow-drawable";
    private int mBlurValue;
    private boolean mChecked;
    private Bitmap mCheckedBitmap;
    private Bitmap mCurrent;
    private Rect mDstRect;
    private int mGlowMode;
    private int mHighlightColorChecked;
    private int mHighlightColorPressed;
    private int mHighlightColorSelected;
    private int mHighlightMode;
    private boolean mPressed;
    private Bitmap mPressedBitmap;
    private boolean mSelected;
    private Bitmap mSelectedBitmap;

    public GlowBitmapDrawable(Bitmap bitmap, int i, int j, int k, int l, int i1, int j1)
    {
        super(bitmap);
        mDstRect = new Rect();
        init(i, j, k, l, i1, j1);
    }

    public static Bitmap generateBlurBitmap(Bitmap bitmap, int i, int j, android.graphics.PorterDuff.Mode mode, boolean flag, Paint paint)
    {
        int k = bitmap.getWidth();
        int l = bitmap.getHeight();
        Object obj1 = bitmap.getConfig();
        Object obj = obj1;
        if (obj1 == null)
        {
            obj = android.graphics.Bitmap.Config.ARGB_8888;
        }
        obj = Bitmap.createBitmap(k, l, ((android.graphics.Bitmap.Config) (obj)));
        obj1 = new Canvas(((Bitmap) (obj)));
        Bitmap bitmap1 = bitmap.extractAlpha();
        ((Canvas) (obj1)).drawBitmap(bitmap, 0.0F, 0.0F, paint);
        bitmap = new Paint();
        bitmap.setXfermode(new PorterDuffXfermode(mode));
        bitmap.setColor(j);
        ((Canvas) (obj1)).drawBitmap(bitmap1, 0.0F, 0.0F, bitmap);
        if (flag)
        {
            bitmap.setMaskFilter(new BlurMaskFilter(i, android.graphics.BlurMaskFilter.Blur.NORMAL));
            bitmap.setAlpha(100);
            ((Canvas) (obj1)).drawBitmap(bitmap1, 0.0F, 0.0F, bitmap);
        }
        return ((Bitmap) (obj));
    }

    private void init(int i, int j, int k, int l, int i1, int j1)
    {
        mHighlightColorChecked = j;
        mHighlightColorPressed = i;
        mHighlightColorSelected = k;
        mBlurValue = l;
        mGlowMode = j1;
        mHighlightMode = i1;
        mCurrent = getBitmap();
        recycleBitmaps();
    }

    private void recycleBitmaps()
    {
        if (mCheckedBitmap != null)
        {
            mCheckedBitmap.recycle();
            mCheckedBitmap = null;
        }
        if (mPressedBitmap != null)
        {
            mPressedBitmap.recycle();
            mPressedBitmap = null;
        }
        if (mSelectedBitmap != null)
        {
            mSelectedBitmap.recycle();
            mSelectedBitmap = null;
        }
    }

    public void draw(Canvas canvas)
    {
        copyBounds(mDstRect);
        canvas.drawBitmap(mCurrent, null, mDstRect, getPaint());
    }

    public boolean isStateful()
    {
        return true;
    }

    protected boolean onStateChange(int ai[])
    {
        int i;
        boolean flag;
        boolean flag1;
        boolean flag2;
        flag = mChecked;
        flag1 = mPressed;
        flag2 = mSelected;
        mChecked = false;
        mPressed = false;
        mSelected = false;
        i = 0;
_L6:
        if (i >= ai.length)
        {
            break MISSING_BLOCK_LABEL_107;
        }
        ai[i];
        JVM INSTR lookupswitch 3: default 76
    //                   16842912: 91
    //                   16842913: 99
    //                   16842919: 83;
           goto _L1 _L2 _L3 _L4
_L3:
        break MISSING_BLOCK_LABEL_99;
_L1:
        break; /* Loop/switch isn't completed */
_L4:
        break; /* Loop/switch isn't completed */
_L7:
        i++;
        if (true) goto _L6; else goto _L5
_L5:
        mPressed = true;
          goto _L7
_L2:
        mChecked = true;
          goto _L7
        mSelected = true;
          goto _L7
        if (mPressed && UIUtils.checkBits(mHighlightMode, 2))
        {
            if (mPressedBitmap == null)
            {
                mPressedBitmap = generateBlurBitmap(getBitmap(), mBlurValue, mHighlightColorPressed, android.graphics.PorterDuff.Mode.DARKEN, UIUtils.checkBits(mGlowMode, 2), getPaint());
            }
            mCurrent = mPressedBitmap;
        } else
        if (mChecked && UIUtils.checkBits(mHighlightMode, 4))
        {
            if (mCheckedBitmap == null)
            {
                mCheckedBitmap = generateBlurBitmap(getBitmap(), mBlurValue, mHighlightColorChecked, android.graphics.PorterDuff.Mode.DARKEN, UIUtils.checkBits(mGlowMode, 4), getPaint());
            }
            mCurrent = mCheckedBitmap;
        } else
        if (mSelected && UIUtils.checkBits(mHighlightMode, 8))
        {
            if (mSelectedBitmap == null)
            {
                mSelectedBitmap = generateBlurBitmap(getBitmap(), mBlurValue, mHighlightColorSelected, android.graphics.PorterDuff.Mode.DARKEN, UIUtils.checkBits(mGlowMode, 8), getPaint());
            }
            mCurrent = mSelectedBitmap;
        } else
        {
            mCurrent = getBitmap();
        }
        return flag != mChecked || flag1 != mPressed || flag2 != mSelected;
    }

    public void setBitmap(Bitmap bitmap)
    {
        super.setBitmap(bitmap);
        mCurrent = bitmap;
        recycleBitmaps();
    }

    public void updateConfig(int i, int j, int k, int l, int i1, int j1)
    {
        init(i, j, k, l, i1, j1);
        setState(getState());
    }
}

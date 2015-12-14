// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.library.graphics.drawable;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import it.sephiroth.android.library.imagezoom.graphics.FastBitmapDrawable;

public class FakeBitmapDrawable extends FastBitmapDrawable
{

    private int mFakeHeight;
    private int mFakeWidth;
    private Matrix mMatrix;
    private int mRealHeight;
    private int mRealWidth;

    public FakeBitmapDrawable(Bitmap bitmap, int i, int j)
    {
        super(bitmap);
        mFakeWidth = i;
        mFakeHeight = j;
        mRealWidth = bitmap.getWidth();
        mRealHeight = bitmap.getHeight();
        update();
    }

    private void update()
    {
        float f = mFakeWidth;
        float f1 = mFakeHeight;
        float f2 = mRealWidth;
        float f3 = mRealHeight;
        mMatrix = new Matrix();
        mMatrix.postScale(f / f2, f1 / f3);
    }

    public void draw(Canvas canvas)
    {
        canvas.drawBitmap(mBitmap, mMatrix, mPaint);
    }

    public int getIntrinsicHeight()
    {
        return mFakeHeight;
    }

    public int getIntrinsicWidth()
    {
        return mFakeWidth;
    }

    public void updateBitmap(Bitmap bitmap, int i, int j)
    {
        setBitmap(bitmap);
        mFakeWidth = i;
        mFakeHeight = j;
        mRealWidth = bitmap.getWidth();
        mRealHeight = bitmap.getHeight();
        update();
        invalidateSelf();
    }
}

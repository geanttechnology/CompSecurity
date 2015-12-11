// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ant.liao;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;

// Referenced classes of package com.ant.liao:
//            GifDrawable

static final class mRebuildShader extends android.graphics.drawable.r
{

    Bitmap mBitmap;
    int mChangingConfigurations;
    int mGravity;
    Paint mPaint;
    boolean mRebuildShader;
    int mTargetDensity;
    android.graphics.ngingConfigurations mTileModeX;
    android.graphics.ngingConfigurations mTileModeY;

    public int getChangingConfigurations()
    {
        return mChangingConfigurations;
    }

    public Drawable newDrawable()
    {
        return new GifDrawable(this, null, null);
    }

    public Drawable newDrawable(Resources resources)
    {
        return new GifDrawable(this, resources, null);
    }

    nstantState(Bitmap bitmap)
    {
        mGravity = 119;
        mPaint = new Paint(6);
        mTileModeX = null;
        mTileModeY = null;
        mTargetDensity = 160;
        mBitmap = bitmap;
    }

    mBitmap(mBitmap mbitmap)
    {
        this(mbitmap.mBitmap);
        mChangingConfigurations = mbitmap.mChangingConfigurations;
        mGravity = mbitmap.mGravity;
        mTileModeX = mbitmap.mTileModeX;
        mTileModeY = mbitmap.mTileModeY;
        mTargetDensity = mbitmap.mTargetDensity;
        mPaint = new Paint(mbitmap.mPaint);
        mRebuildShader = mbitmap.mRebuildShader;
    }
}

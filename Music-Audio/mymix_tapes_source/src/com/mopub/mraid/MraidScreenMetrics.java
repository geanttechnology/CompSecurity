// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mraid;

import android.content.Context;
import android.graphics.Rect;
import com.mopub.common.util.Dips;

class MraidScreenMetrics
{

    private final Context mContext;
    private final Rect mCurrentAdRect = new Rect();
    private final Rect mCurrentAdRectDips = new Rect();
    private final Rect mDefaultAdRect = new Rect();
    private final Rect mDefaultAdRectDips = new Rect();
    private final float mDensity;
    private final Rect mRootViewRect = new Rect();
    private final Rect mRootViewRectDips = new Rect();
    private final Rect mScreenRect = new Rect();
    private final Rect mScreenRectDips = new Rect();

    MraidScreenMetrics(Context context, float f)
    {
        mContext = context.getApplicationContext();
        mDensity = f;
    }

    private void convertToDips(Rect rect, Rect rect1)
    {
        rect1.set(Dips.pixelsToIntDips(rect.left, mContext), Dips.pixelsToIntDips(rect.top, mContext), Dips.pixelsToIntDips(rect.right, mContext), Dips.pixelsToIntDips(rect.bottom, mContext));
    }

    Rect getCurrentAdRect()
    {
        return mCurrentAdRect;
    }

    Rect getCurrentAdRectDips()
    {
        return mCurrentAdRectDips;
    }

    Rect getDefaultAdRect()
    {
        return mDefaultAdRect;
    }

    Rect getDefaultAdRectDips()
    {
        return mDefaultAdRectDips;
    }

    public float getDensity()
    {
        return mDensity;
    }

    Rect getRootViewRect()
    {
        return mRootViewRect;
    }

    Rect getRootViewRectDips()
    {
        return mRootViewRectDips;
    }

    Rect getScreenRect()
    {
        return mScreenRect;
    }

    Rect getScreenRectDips()
    {
        return mScreenRectDips;
    }

    void setCurrentAdPosition(int i, int j, int k, int l)
    {
        mCurrentAdRect.set(i, j, i + k, j + l);
        convertToDips(mCurrentAdRect, mCurrentAdRectDips);
    }

    void setDefaultAdPosition(int i, int j, int k, int l)
    {
        mDefaultAdRect.set(i, j, i + k, j + l);
        convertToDips(mDefaultAdRect, mDefaultAdRectDips);
    }

    void setRootViewPosition(int i, int j, int k, int l)
    {
        mRootViewRect.set(i, j, i + k, j + l);
        convertToDips(mRootViewRect, mRootViewRectDips);
    }

    void setScreenSize(int i, int j)
    {
        mScreenRect.set(0, 0, i, j);
        convertToDips(mScreenRect, mScreenRectDips);
    }
}

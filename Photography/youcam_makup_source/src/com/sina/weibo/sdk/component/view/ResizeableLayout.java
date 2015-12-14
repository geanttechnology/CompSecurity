// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.component.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public class ResizeableLayout extends RelativeLayout
{

    private int mHeight;
    private SizeChangeListener mSizeChangeListener;
    private int mWidth;

    public ResizeableLayout(Context context)
    {
        super(context);
        mHeight = 0;
        mSizeChangeListener = null;
        mWidth = 0;
    }

    public ResizeableLayout(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mHeight = 0;
        mSizeChangeListener = null;
        mWidth = 0;
    }

    public ResizeableLayout(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mHeight = 0;
        mSizeChangeListener = null;
        mWidth = 0;
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        if (mSizeChangeListener != null)
        {
            mSizeChangeListener.onSizeChanged(getWidth(), getHeight(), mWidth, mHeight);
        }
        mHeight = getHeight();
        mWidth = getWidth();
        super.onLayout(flag, i, j, k, l);
    }

    public void setSizeChangeListener(SizeChangeListener sizechangelistener)
    {
        mSizeChangeListener = sizechangelistener;
    }

    private class SizeChangeListener
    {

        public abstract void onSizeChanged(int i, int j, int k, int l);
    }

}

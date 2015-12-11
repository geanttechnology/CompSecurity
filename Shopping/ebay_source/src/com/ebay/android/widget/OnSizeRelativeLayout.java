// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.android.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public class OnSizeRelativeLayout extends RelativeLayout
{
    public static interface OnSizeChangedListener
    {

        public abstract void onSizeChanged(int i, int j, int k, int l);
    }


    private OnSizeChangedListener onSizeListener;

    public OnSizeRelativeLayout(Context context)
    {
        super(context);
    }

    public OnSizeRelativeLayout(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public OnSizeRelativeLayout(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    protected void onSizeChanged(int i, int j, int k, int l)
    {
        super.onSizeChanged(i, j, k, l);
        if (onSizeListener != null)
        {
            onSizeListener.onSizeChanged(i, j, k, l);
        }
    }

    public void setOnSizeListener(OnSizeChangedListener onsizechangedlistener)
    {
        onSizeListener = onsizechangedlistener;
    }
}

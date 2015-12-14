// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotoproedit.activity.font;

import akv;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public class ResizeFrameLayout extends FrameLayout
{

    private akv mListener;

    public ResizeFrameLayout(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    protected void onSizeChanged(int i, int j, int k, int l)
    {
        super.onSizeChanged(i, j, k, l);
        if (mListener != null)
        {
            mListener.a(i, j, k, l);
        }
    }

    public void setOnResizeRelativeListener(akv akv1)
    {
        mListener = akv1;
    }
}

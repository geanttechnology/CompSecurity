// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.android.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public class MessageBar extends RelativeLayout
{

    private static final int CHECKED_STATE_SET[] = {
        0x10100a0
    };
    private boolean error;

    public MessageBar(Context context)
    {
        super(context);
    }

    public MessageBar(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        context = context.obtainStyledAttributes(attributeset, new int[] {
            0x1010106
        });
        error = context.getBoolean(0, false);
        context.recycle();
    }

    public boolean isError()
    {
        return error;
    }

    protected int[] onCreateDrawableState(int i)
    {
        int ai[] = super.onCreateDrawableState(i + 1);
        if (error)
        {
            mergeDrawableStates(ai, CHECKED_STATE_SET);
        }
        return ai;
    }

    public void setError(boolean flag)
    {
        if (error != flag)
        {
            error = flag;
            refreshDrawableState();
        }
    }

}

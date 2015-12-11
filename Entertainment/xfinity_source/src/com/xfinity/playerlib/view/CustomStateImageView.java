// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

public class CustomStateImageView extends ImageView
{

    private static final int APPEAR_ENABLED_STATE_SET[];
    private boolean appearEnabled;

    public CustomStateImageView(Context context)
    {
        super(context);
        appearEnabled = true;
    }

    public CustomStateImageView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        appearEnabled = true;
    }

    public CustomStateImageView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        appearEnabled = true;
    }

    public boolean appearEnabled()
    {
        return appearEnabled;
    }

    public int[] onCreateDrawableState(int i)
    {
        int ai[] = super.onCreateDrawableState(i + 1);
        if (appearEnabled())
        {
            mergeDrawableStates(ai, APPEAR_ENABLED_STATE_SET);
        }
        return ai;
    }

    public void setAppearEnabled(boolean flag)
    {
        appearEnabled = flag;
        refreshDrawableState();
        invalidate();
    }

    static 
    {
        APPEAR_ENABLED_STATE_SET = (new int[] {
            com.xfinity.playerlib.R.attr.state_appear_enabled
        });
    }
}

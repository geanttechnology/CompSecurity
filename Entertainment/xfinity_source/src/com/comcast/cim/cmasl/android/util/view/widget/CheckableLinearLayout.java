// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.android.util.view.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.Checkable;
import android.widget.LinearLayout;

public class CheckableLinearLayout extends LinearLayout
    implements Checkable
{

    private static final int CHECKED_STATE_SET[] = {
        0x10100a0
    };
    private boolean checked;

    public CheckableLinearLayout(Context context)
    {
        super(context);
        checked = false;
    }

    public CheckableLinearLayout(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        checked = false;
    }

    public CheckableLinearLayout(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        checked = false;
    }

    public boolean isChecked()
    {
        return checked;
    }

    protected int[] onCreateDrawableState(int i)
    {
        int ai[] = super.onCreateDrawableState(i + 1);
        if (isChecked())
        {
            mergeDrawableStates(ai, CHECKED_STATE_SET);
        }
        return ai;
    }

    public void setBackgroundDrawable(Drawable drawable)
    {
        super.setBackgroundDrawable(drawable);
    }

    public void setChecked(boolean flag)
    {
        if (checked != flag)
        {
            checked = flag;
            refreshDrawableState();
        }
    }

    public void toggle()
    {
        boolean flag;
        if (!isChecked())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        setChecked(flag);
    }

}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

public class GrouponCheckBox extends FrameLayout
    implements android.view.View.OnClickListener
{

    private View checkedView;

    public GrouponCheckBox(Context context)
    {
        this(context, null);
    }

    public GrouponCheckBox(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public GrouponCheckBox(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        inflate(getContext(), 0x7f030126, this);
        checkedView = findViewById(0x7f100362);
    }

    public boolean isChecked()
    {
        return checkedView.getVisibility() == 0;
    }

    public void onClick(View view)
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

    public void setChecked(boolean flag)
    {
        View view = checkedView;
        int i;
        if (flag)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        view.setVisibility(i);
    }

    public boolean toggle()
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
        return flag;
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.widget.TextView;
import com.getbase.floatingactionbutton.b;

public class TargetFloatingActionButton extends b
{

    public TargetFloatingActionButton(Context context)
    {
        super(context);
        b();
    }

    public TargetFloatingActionButton(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        b();
    }

    public TargetFloatingActionButton(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        b();
    }

    private void b()
    {
        setColorNormal(getResources().getColor(0x7f0f00eb));
        setColorPressed(getResources().getColor(0x7f0f00eb));
    }

    private TextView getLabelView()
    {
        return (TextView)getTag(0x7f100014);
    }

    public void setTextColor(int i)
    {
        TextView textview = getLabelView();
        if (textview != null)
        {
            textview.setTextColor(getResources().getColor(i));
        }
    }

    public void setTitle(SpannableString spannablestring)
    {
        setTitle(spannablestring.toString());
        TextView textview = getLabelView();
        if (textview != null)
        {
            textview.setText(spannablestring);
        }
    }
}

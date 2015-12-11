// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class ActionButton extends FrameLayout
{

    private final ImageView a;
    private final TextView b;

    public ActionButton(Context context)
    {
        this(context, null);
    }

    public ActionButton(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public ActionButton(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        View.inflate(context, 0x7f030000, this);
        setBackgroundResource(0x7f0200da);
        a = (ImageView)findViewById(0x7f0b001c);
        b = (TextView)findViewById(0x7f0b001d);
        b.setAllCaps(true);
        if (attributeset == null)
        {
            break MISSING_BLOCK_LABEL_124;
        }
        context = context.obtainStyledAttributes(attributeset, new int[] {
            0x1010002, 0x101014f
        }, i, 0);
        i = context.getResourceId(0, 0);
        if (i == 0)
        {
            break MISSING_BLOCK_LABEL_99;
        }
        a.setImageResource(i);
        attributeset = context.getText(1);
        if (!TextUtils.isEmpty(attributeset))
        {
            b.setText(attributeset);
        }
        context.recycle();
        return;
        attributeset;
        context.recycle();
        throw attributeset;
    }

    public CharSequence getLabel()
    {
        return b.getText();
    }

    public void setAllCaps(boolean flag)
    {
        b.setAllCaps(flag);
    }

    public void setIcon(int i)
    {
        if (i == 0)
        {
            a.setImageDrawable(null);
            return;
        } else
        {
            a.setImageResource(i);
            return;
        }
    }

    public void setLabel(int i)
    {
        if (i == 0)
        {
            b.setText(null);
            return;
        } else
        {
            b.setText(i);
            return;
        }
    }

    public void setLabel(CharSequence charsequence)
    {
        b.setText(charsequence);
    }
}

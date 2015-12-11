// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.bbyobjects;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.Button;
import lo;

public class BBYButton extends Button
{

    private Typeface a;
    private Context b;
    private int c;

    public BBYButton(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        c = -1;
        b = context;
        try
        {
            c = a(context.obtainStyledAttributes(attributeset, com.bestbuy.android.R.styleable.BBYTextView).getString(0));
            a = lo.a(context, c, context.getResources());
        }
        // Misplaced declaration of an exception variable
        catch (AttributeSet attributeset)
        {
            a = lo.a(context, 0x7f080021, context.getResources());
        }
        setTypeface(a);
    }

    private int a(String s)
    {
        if (!s.contains(b.getResources().getString(0x7f080021)))
        {
            if (s.contains(b.getResources().getString(0x7f080024)))
            {
                return 0x7f080024;
            }
            if (s.contains(b.getResources().getString(0x7f080022)))
            {
                return 0x7f080022;
            }
            if (!s.contains("Roboto-Black"))
            {
                if (s.contains("Roboto-Regular"))
                {
                    return 0x7f080024;
                }
                if (s.contains("Roboto-LightItalic"))
                {
                    return 0x7f080023;
                }
                return !s.contains("Roboto-Light") ? 0 : 0x7f080022;
            }
        }
        return 0x7f080021;
    }
}

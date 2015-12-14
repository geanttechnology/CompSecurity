// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.widget;

import android.content.Context;
import android.preference.Preference;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class CustomTextPreference extends Preference
{

    private String text;
    private int textColor;
    private int textSize;
    TextView titleView;
    private boolean underline;

    public CustomTextPreference(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0x101008e);
    }

    public CustomTextPreference(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        textColor = -1;
        textSize = -1;
        text = "";
        underline = false;
    }

    private void applyUnderline(TextView textview, String s)
    {
        s = new SpannableString(s);
        s.setSpan(new UnderlineSpan(), 0, s.length(), 0);
        textview.setText(s);
    }

    protected View onCreateView(ViewGroup viewgroup)
    {
        viewgroup = super.onCreateView(viewgroup);
        Object obj = (RelativeLayout)((LinearLayout)viewgroup).getChildAt(1);
        titleView = new TextView(getContext());
        ((RelativeLayout) (obj)).addView(titleView);
        obj = (android.widget.RelativeLayout.LayoutParams)titleView.getLayoutParams();
        ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(15);
        ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(9);
        titleView.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        this;
        JVM INSTR monitorenter ;
        if (textColor != -1)
        {
            titleView.setTextColor(textColor);
        }
        if (textSize != -1)
        {
            titleView.setTextSize(textSize);
        }
        if (!text.isEmpty())
        {
            if (!underline)
            {
                break MISSING_BLOCK_LABEL_146;
            }
            applyUnderline(titleView, text);
        }
_L1:
        this;
        JVM INSTR monitorexit ;
        return viewgroup;
        titleView.setText(text);
          goto _L1
        viewgroup;
        this;
        JVM INSTR monitorexit ;
        throw viewgroup;
    }
}

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
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ProgressBarPreference extends Preference
{

    private String hintText;
    private TextView hintTitle;
    int max;
    int progress;
    ProgressBar progressBar;
    private String secondaryText;
    private int secondaryTextColor;
    private TextView secondaryTitle;
    private boolean underline;

    public ProgressBarPreference(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0x101008e);
    }

    public ProgressBarPreference(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        progress = 0;
        max = 0;
        secondaryTitle = null;
        secondaryTextColor = -1;
        secondaryText = "";
        underline = false;
        hintTitle = null;
        hintText = "";
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
        ((LinearLayout)viewgroup).setPadding(0, 0, 0, 0);
        Object obj = (RelativeLayout)((LinearLayout)viewgroup).getChildAt(1);
        Object obj1 = (android.widget.LinearLayout.LayoutParams)((RelativeLayout) (obj)).getLayoutParams();
        ((android.widget.LinearLayout.LayoutParams) (obj1)).setMargins(((android.widget.LinearLayout.LayoutParams) (obj1)).leftMargin, ((android.widget.LinearLayout.LayoutParams) (obj1)).topMargin, ((android.widget.LinearLayout.LayoutParams) (obj1)).leftMargin, ((android.widget.LinearLayout.LayoutParams) (obj1)).bottomMargin);
        ((RelativeLayout) (obj)).setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj1)));
        ((RelativeLayout) (obj)).setPadding(0, 0, 0, 0);
        obj1 = (TextView)((RelativeLayout) (obj)).findViewById(0x1020016);
        secondaryTitle = new TextView(getContext());
        ((RelativeLayout) (obj)).addView(secondaryTitle);
        android.widget.RelativeLayout.LayoutParams layoutparams = (android.widget.RelativeLayout.LayoutParams)secondaryTitle.getLayoutParams();
        layoutparams.addRule(11);
        layoutparams.addRule(4, ((TextView) (obj1)).getId());
        layoutparams.addRule(6, ((TextView) (obj1)).getId());
        layoutparams.setMargins(layoutparams.topMargin, layoutparams.leftMargin, 0, layoutparams.bottomMargin);
        secondaryTitle.setLayoutParams(layoutparams);
        secondaryTitle.setTextSize(0, ((TextView) (obj1)).getTextSize());
        progressBar = new ProgressBar(getContext(), null, 0x1010078);
        progressBar.setId(0x102000d);
        hintTitle = new TextView(getContext());
        ((RelativeLayout) (obj)).addView(hintTitle);
        obj1 = (TextView)((RelativeLayout) (obj)).findViewById(0x1020010);
        ((RelativeLayout) (obj)).addView(progressBar);
        obj = (android.widget.RelativeLayout.LayoutParams)progressBar.getLayoutParams();
        obj.width = -1;
        ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(3, ((TextView) (obj1)).getId());
        progressBar.setPadding(0, 5, 0, 0);
        progressBar.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        obj = (android.widget.RelativeLayout.LayoutParams)hintTitle.getLayoutParams();
        ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(3, progressBar.getId());
        hintTitle.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        hintTitle.setTextSize(0, ((TextView) (obj1)).getTextSize());
        hintTitle.setTextColor(((TextView) (obj1)).getTextColors());
        hintTitle.setVisibility(8);
        hintTitle.setPadding(0, 16, 0, 0);
        this;
        JVM INSTR monitorenter ;
        progressBar.setMax(max);
        progressBar.setProgress(progress);
        progressBar.setEnabled(false);
        if (secondaryTextColor != -1)
        {
            secondaryTitle.setTextColor(secondaryTextColor);
        }
        if (!secondaryText.isEmpty())
        {
            secondaryTitle.setVisibility(0);
            if (!underline)
            {
                break MISSING_BLOCK_LABEL_493;
            }
            applyUnderline(secondaryTitle, secondaryText);
        }
_L1:
        if (!hintText.isEmpty())
        {
            hintTitle.setVisibility(0);
            hintTitle.setText(hintText);
        }
        this;
        JVM INSTR monitorexit ;
        return viewgroup;
        secondaryTitle.setText(secondaryText);
          goto _L1
        viewgroup;
        this;
        JVM INSTR monitorexit ;
        throw viewgroup;
    }
}

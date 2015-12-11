// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.utils;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Layout;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.style.LeadingMarginSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class TextFlowHelper
{
    private static class MyLeadingMarginSpan2
        implements android.text.style.LeadingMarginSpan.LeadingMarginSpan2
    {

        private int lines;
        private int margin;

        public void drawLeadingMargin(Canvas canvas, Paint paint, int i, int j, int k, int l, int i1, 
                CharSequence charsequence, int j1, int k1, boolean flag, Layout layout)
        {
        }

        public int getLeadingMargin(boolean flag)
        {
            if (flag)
            {
                return margin;
            } else
            {
                return 0;
            }
        }

        public int getLeadingMarginLineCount()
        {
            return lines;
        }

        public MyLeadingMarginSpan2(int i, int j)
        {
            margin = j;
            lines = i;
        }
    }


    public TextFlowHelper()
    {
    }

    private static LeadingMarginSpan getLeadingMarginSpan(int i, int j)
    {
        return new MyLeadingMarginSpan2(j, i);
    }

    public static void tryFlowText(View view, TextView textview, ViewGroup viewgroup)
    {
        android.view.ViewGroup.MarginLayoutParams marginlayoutparams = (android.view.ViewGroup.MarginLayoutParams)view.getLayoutParams();
        view.measure(viewgroup.getMeasuredWidth(), viewgroup.getMeasuredHeight());
        int j = view.getMeasuredHeight();
        int i = view.getMeasuredWidth();
        textview.measure(viewgroup.getMeasuredWidth(), viewgroup.getMeasuredHeight());
        int k = textview.getTotalPaddingTop();
        float f = textview.getPaint().getTextSize();
        j = Math.round((float)(j - k) / f);
        k = marginlayoutparams.leftMargin;
        int l = marginlayoutparams.rightMargin;
        view = new SpannableString(textview.getText());
        view.setSpan(getLeadingMarginSpan(k + i + l, j), 0, view.length(), 0);
        textview.setText(view);
        ((android.widget.RelativeLayout.LayoutParams)textview.getLayoutParams()).getRules()[1] = 0;
    }
}

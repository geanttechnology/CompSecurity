// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.product;

import android.content.Context;
import android.content.res.Resources;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.target.ui.common.b;
import com.target.ui.span.CenteringRelativeSizeSpan;
import com.target.ui.view.a;

public class PlpGridPriceView extends LinearLayout
{
    static class Views extends a
    {

        TextView price;

        public Views(View view)
        {
            super(view);
        }
    }


    private static final float RESIZE_PROPORTION = 0.8F;
    private Views mViews;

    public PlpGridPriceView(Context context)
    {
        super(context);
        a(context);
    }

    public PlpGridPriceView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a(context);
    }

    public PlpGridPriceView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a(context);
    }

    private Spannable a(String s)
    {
        s = new SpannableString(s);
        int i = s.length();
        s.setSpan(new StrikethroughSpan(), 0, i, 33);
        s.setSpan(new ForegroundColorSpan(getResources().getColor(0x7f0f00f6)), 0, i, 33);
        s.setSpan(new CenteringRelativeSizeSpan(0.8F), 0, i, 34);
        return s;
    }

    private void a(Context context)
    {
        setOrientation(0);
        inflate(context, getLayoutResource(), this);
        mViews = new Views(this);
    }

    protected int getLayoutResource()
    {
        return 0x7f0301a7;
    }

    public void setPriceData(b b1)
    {
        if (b1 == null || mViews == null)
        {
            return;
        }
        SpannableStringBuilder spannablestringbuilder = new SpannableStringBuilder();
        if (b1.a())
        {
            spannablestringbuilder.append(b1.e().trim());
        }
        if (b1.b())
        {
            b1 = a(b1.f().trim());
            spannablestringbuilder.append(" ");
            spannablestringbuilder.append(b1);
        }
        mViews.price.setText(spannablestringbuilder, android.widget.TextView.BufferType.SPANNABLE);
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.product;

import android.content.Context;
import android.content.res.Resources;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.StrikethroughSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.a.a.e;
import com.target.mothership.util.o;
import com.target.ui.common.b;
import com.target.ui.util.al;
import com.target.ui.view.a;

public class ProductPriceView extends LinearLayout
{
    static class Views extends a
    {

        TextView price;
        TextView storeInfo;
        TextView strikeThroughPrice;

        Views(View view)
        {
            super(view);
        }
    }


    private Views mViews;

    public ProductPriceView(Context context)
    {
        super(context);
        a();
    }

    public ProductPriceView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a();
    }

    public ProductPriceView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a();
    }

    private void a()
    {
        setOrientation(1);
        inflate(getContext(), 0x7f0301b6, this);
        mViews = new Views(this);
    }

    private void setStrikeThroughPrice(String s)
    {
        if (!o.g(s))
        {
            al.c(mViews.strikeThroughPrice);
            return;
        } else
        {
            SpannableString spannablestring = new SpannableString(s);
            spannablestring.setSpan(new StrikethroughSpan(), s.indexOf(s), s.length(), 33);
            mViews.strikeThroughPrice.setText(spannablestring, android.widget.TextView.BufferType.SPANNABLE);
            al.b(mViews.strikeThroughPrice);
            return;
        }
    }

    public void setPriceData(b b1)
    {
        if (b1 == null)
        {
            return;
        }
        if (b1.a())
        {
            mViews.price.setText(b1.e());
            al.b(mViews.price);
        } else
        {
            al.c(mViews.price);
        }
        if (b1.b())
        {
            setStrikeThroughPrice(b1.f());
        } else
        {
            al.c(mViews.strikeThroughPrice);
        }
        if (b1.j() && b1.i().b())
        {
            b1 = String.format(getResources().getString(0x7f090472), new Object[] {
                b1.i().c()
            });
            mViews.storeInfo.setText(b1);
            al.b(mViews.storeInfo);
            return;
        } else
        {
            al.c(mViews.storeInfo);
            return;
        }
    }
}

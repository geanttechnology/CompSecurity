// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.map;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.target.ui.adapter.b.c;
import com.target.ui.util.al;
import com.target.ui.util.d.b;
import com.target.ui.view.BitmapImageView;
import java.math.BigDecimal;

public class BlackFridayDealProductView extends RelativeLayout
{
    static class Views extends com.target.ui.view.a
    {

        BitmapImageView image;
        TextView price;
        View root;
        TextView title;

        Views(View view)
        {
            super(view);
        }
    }

    public static interface a
    {

        public abstract void a(BitmapImageView bitmapimageview);
    }


    private a mListener;
    private Views mViews;

    public BlackFridayDealProductView(Context context)
    {
        super(context);
        a(context);
    }

    public BlackFridayDealProductView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a(context);
    }

    public BlackFridayDealProductView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a(context);
    }

    static a a(BlackFridayDealProductView blackfridaydealproductview)
    {
        return blackfridaydealproductview.mListener;
    }

    private void a(Context context)
    {
        inflate(context, 0x7f03016a, this);
        mViews = new Views(this);
        mViews.root.setOnClickListener(new android.view.View.OnClickListener() {

            final BlackFridayDealProductView this$0;

            public void onClick(View view)
            {
                if (BlackFridayDealProductView.a(BlackFridayDealProductView.this) == null)
                {
                    return;
                } else
                {
                    BlackFridayDealProductView.a(BlackFridayDealProductView.this).a(com.target.ui.view.map.BlackFridayDealProductView.b(BlackFridayDealProductView.this).image);
                    return;
                }
            }

            
            {
                this$0 = BlackFridayDealProductView.this;
                super();
            }
        });
    }

    static Views b(BlackFridayDealProductView blackfridaydealproductview)
    {
        return blackfridaydealproductview.mViews;
    }

    public void a(String s)
    {
        c.a(getContext(), s, mViews.image);
    }

    public void a(BigDecimal bigdecimal)
    {
        if (bigdecimal == null || bigdecimal.compareTo(BigDecimal.ZERO) == 0)
        {
            al.c(mViews.price);
            return;
        } else
        {
            al.a(mViews.price, com.target.ui.util.d.b.a(bigdecimal));
            return;
        }
    }

    public void b(String s)
    {
        mViews.title.setText(s);
    }

    public void setBlackFridayDealProductViewListener(a a1)
    {
        mListener = a1;
    }
}

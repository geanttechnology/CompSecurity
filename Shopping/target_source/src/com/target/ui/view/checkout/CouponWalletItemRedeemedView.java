// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.checkout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class CouponWalletItemRedeemedView extends RelativeLayout
{
    private class a
    {

        final CouponWalletItemRedeemedView this$0;
        TextView tvCouponWalletSubTitle;
        TextView tvCouponWalletTitle;

        public a(View view)
        {
            this$0 = CouponWalletItemRedeemedView.this;
            super();
            tvCouponWalletTitle = (TextView)view.findViewById(0x7f100394);
            tvCouponWalletSubTitle = (TextView)view.findViewById(0x7f100395);
        }
    }


    private a mViews;

    public CouponWalletItemRedeemedView(Context context)
    {
        super(context);
        a(context);
    }

    public CouponWalletItemRedeemedView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a(context);
    }

    public CouponWalletItemRedeemedView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a(context);
    }

    private void a(Context context)
    {
        inflate(context, 0x7f03012d, this);
        mViews = new a(this);
    }

    public void a(String s)
    {
        mViews.tvCouponWalletTitle.setText(s);
    }

    public void b(String s)
    {
        mViews.tvCouponWalletSubTitle.setText(s);
    }
}

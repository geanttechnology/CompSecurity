// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.checkout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.target.ui.util.al;
import com.target.ui.view.TargetButton;

public class CouponWalletSavedOffersView extends RelativeLayout
{
    static class Views extends com.target.ui.view.a
    {

        TargetButton buttonApply;
        ImageView ivEditCouponWallet;
        TextView tvCouponWalletRowSubTitle;
        TextView tvCouponWalletRowTitle;

        Views(View view)
        {
            super(view);
        }
    }

    public static interface a
    {

        public abstract void a();

        public abstract void b();
    }


    private a mCouponWalletItemViewListener;
    private Views mViews;

    public CouponWalletSavedOffersView(Context context)
    {
        super(context);
        a(context);
    }

    public CouponWalletSavedOffersView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a(context);
    }

    public CouponWalletSavedOffersView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a(context);
    }

    static a a(CouponWalletSavedOffersView couponwalletsavedoffersview)
    {
        return couponwalletsavedoffersview.mCouponWalletItemViewListener;
    }

    private void a(Context context)
    {
        inflate(context, 0x7f03012b, this);
        mViews = new Views(this);
    }

    public void a()
    {
        al.c(mViews.tvCouponWalletRowSubTitle);
    }

    public void a(String s)
    {
        mViews.tvCouponWalletRowTitle.setText(s);
    }

    public void b()
    {
        al.b(mViews.ivEditCouponWallet);
        mViews.ivEditCouponWallet.setOnClickListener(new android.view.View.OnClickListener() {

            final CouponWalletSavedOffersView this$0;

            public void onClick(View view)
            {
                if (CouponWalletSavedOffersView.a(CouponWalletSavedOffersView.this) != null)
                {
                    CouponWalletSavedOffersView.a(CouponWalletSavedOffersView.this).a();
                }
            }

            
            {
                this$0 = CouponWalletSavedOffersView.this;
                super();
            }
        });
    }

    public void b(String s)
    {
        al.b(mViews.tvCouponWalletRowSubTitle);
        mViews.tvCouponWalletRowSubTitle.setText(s);
    }

    public void c()
    {
        mViews.ivEditCouponWallet.setOnClickListener(null);
        al.c(mViews.ivEditCouponWallet);
    }

    public void d()
    {
        al.b(mViews.buttonApply);
        mViews.buttonApply.setOnClickListener(new android.view.View.OnClickListener() {

            final CouponWalletSavedOffersView this$0;

            public void onClick(View view)
            {
                if (CouponWalletSavedOffersView.a(CouponWalletSavedOffersView.this) != null)
                {
                    CouponWalletSavedOffersView.a(CouponWalletSavedOffersView.this).b();
                }
            }

            
            {
                this$0 = CouponWalletSavedOffersView.this;
                super();
            }
        });
    }

    public void e()
    {
        mViews.buttonApply.setOnClickListener(null);
        al.c(mViews.buttonApply);
    }

    public void setCouponWalletItemViewListener(a a1)
    {
        mCouponWalletItemViewListener = a1;
    }
}

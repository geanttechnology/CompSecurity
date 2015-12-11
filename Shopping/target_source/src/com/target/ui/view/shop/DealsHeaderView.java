// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.shop;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.widget.LinearLayout;
import com.target.ui.util.ac;
import com.target.ui.util.al;
import com.target.ui.view.common.TargetErrorView;
import java.util.List;

// Referenced classes of package com.target.ui.view.shop:
//            WeeklyAdView, DealsNoStoreView, DealsCategoryHeaderView

public class DealsHeaderView extends LinearLayout
{
    static class Views extends com.target.ui.view.a
    {

        View cartwheelButton;
        View mobileCouponsButton;
        DealsNoStoreView noStoreView;
        DealsCategoryHeaderView productErrorHeader;
        TargetErrorView productErrorView;
        WeeklyAdView weeklyAdView;

        Views(View view)
        {
            super(view);
        }
    }

    public static interface a
    {

        public abstract void a();

        public abstract void b();

        public abstract void c();
    }


    private a mListener;
    private Views mViews;

    public DealsHeaderView(Context context)
    {
        super(context);
        a();
    }

    public DealsHeaderView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a();
    }

    public DealsHeaderView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a();
    }

    static a a(DealsHeaderView dealsheaderview)
    {
        return dealsheaderview.mListener;
    }

    private void a()
    {
        setOrientation(1);
        inflate(getContext(), 0x7f030153, this);
        mViews = new Views(this);
        mViews.weeklyAdView.setFooterText(getResources().getString(0x7f0902d5));
        mViews.weeklyAdView.setFooterHeight(ac.d(getContext()));
        mViews.weeklyAdView.getLayoutParams().height = ac.a(getContext(), 2);
        mViews.noStoreView.setOnStoreClickListener(new DealsNoStoreView.a() {

            final DealsHeaderView this$0;

            public void a()
            {
                if (DealsHeaderView.a(DealsHeaderView.this) == null)
                {
                    return;
                } else
                {
                    DealsHeaderView.a(DealsHeaderView.this).c();
                    return;
                }
            }

            
            {
                this$0 = DealsHeaderView.this;
                super();
            }
        });
        mViews.cartwheelButton.setOnClickListener(new android.view.View.OnClickListener() {

            final DealsHeaderView this$0;

            public void onClick(View view)
            {
                if (DealsHeaderView.a(DealsHeaderView.this) == null)
                {
                    return;
                } else
                {
                    DealsHeaderView.a(DealsHeaderView.this).a();
                    return;
                }
            }

            
            {
                this$0 = DealsHeaderView.this;
                super();
            }
        });
        mViews.mobileCouponsButton.setOnClickListener(new android.view.View.OnClickListener() {

            final DealsHeaderView this$0;

            public void onClick(View view)
            {
                if (DealsHeaderView.a(DealsHeaderView.this) == null)
                {
                    return;
                } else
                {
                    DealsHeaderView.a(DealsHeaderView.this).b();
                    return;
                }
            }

            
            {
                this$0 = DealsHeaderView.this;
                super();
            }
        });
        mViews.productErrorHeader.a(false);
        mViews.productErrorHeader.setPrimaryText(getResources().getString(0x7f0902d4));
        mViews.productErrorView.a(getResources().getString(0x7f0902dc), getResources().getString(0x7f0902db), false);
    }

    public void a(ViewParent viewparent)
    {
        mViews.weeklyAdView.a(viewparent);
    }

    public void a(boolean flag)
    {
        int i;
        if (flag)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        al.a(i, new View[] {
            mViews.productErrorHeader, mViews.productErrorView
        });
    }

    public void b(boolean flag)
    {
        al.a(mViews.noStoreView, flag);
        WeeklyAdView weeklyadview = mViews.weeklyAdView;
        if (!flag)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        al.a(weeklyadview, flag);
    }

    public void setData(List list)
    {
        mViews.weeklyAdView.setWeeklyAdData(list);
        mViews.weeklyAdView.b();
    }

    public void setOnButtonClickListener(a a1)
    {
        mListener = a1;
    }

    public void setOnWeeklyAdCardViewClickListener(WeeklyAdView.b b1)
    {
        mViews.weeklyAdView.setOnWeeklyAdCardViewClickListener(b1);
    }
}

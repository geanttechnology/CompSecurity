// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.adapter.h;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.a.a.e;
import com.target.mothership.model.coupons.interfaces.AvailableCouponOffer;
import com.target.mothership.model.product.interfaces.ProductDetails;
import com.target.mothership.util.o;
import com.target.ui.model.shop.CompositeDeal;
import com.target.ui.view.product.PlpAvailableCouponOfferView;
import com.target.ui.view.product.PlpFooterView;
import com.target.ui.view.product.PlpListItemView;
import com.target.ui.view.shop.DealsCategoryHeaderView;
import com.target.ui.view.shop.DealsHeaderView;
import com.target.ui.view.shop.WeeklyAdCardView;
import java.util.List;

public class com.target.ui.adapter.h.a extends com.target.ui.adapter.b.a
{
    public static interface a
    {

        public abstract void a();
    }

    public static interface b
    {

        public abstract void a(DealsHeaderView dealsheaderview, WeeklyAdCardView weeklyadcardview);

        public abstract void b();

        public abstract void c();

        public abstract void d();
    }

    public static interface c
    {

        public abstract void a(AvailableCouponOffer availablecouponoffer);

        public abstract void a(AvailableCouponOffer availablecouponoffer, PlpAvailableCouponOfferView plpavailablecouponofferview);

        public abstract void a(ProductDetails productdetails);

        public abstract void a(ProductDetails productdetails, PlpListItemView plplistitemview);

        public abstract void b(ProductDetails productdetails);

        public abstract void c(ProductDetails productdetails);

        public abstract void d(ProductDetails productdetails);

        public abstract void e(ProductDetails productdetails);

        public abstract void f(ProductDetails productdetails);

        public abstract void g(ProductDetails productdetails);
    }


    private List mCompositeDeals;
    private a mOnFooterViewClickListener;
    private b mOnHeaderClickListener;
    private c mOnProductClickListener;
    private boolean mShowFooter;
    private boolean mShowFooterRetry;
    private boolean mShowNoProductsFoundView;
    private boolean mShowNoStoreView;
    private int mSortLabelResource;
    private List mWeeklyAdData;

    public com.target.ui.adapter.h.a(List list, List list1)
    {
        mWeeklyAdData = list;
        mCompositeDeals = list1;
    }

    static b a(com.target.ui.adapter.h.a a1)
    {
        return a1.mOnHeaderClickListener;
    }

    static a b(com.target.ui.adapter.h.a a1)
    {
        return a1.mOnFooterViewClickListener;
    }

    static c c(com.target.ui.adapter.h.a a1)
    {
        return a1.mOnProductClickListener;
    }

    private View e(ViewGroup viewgroup)
    {
        return LayoutInflater.from(viewgroup.getContext()).inflate(0x7f030199, viewgroup, false);
    }

    private View f(ViewGroup viewgroup)
    {
        return LayoutInflater.from(viewgroup.getContext()).inflate(0x7f0301af, viewgroup, false);
    }

    private void h(final android.support.v7.widget.RecyclerView.t view, int j)
    {
        final AvailableCouponOffer offer = (AvailableCouponOffer)((CompositeDeal)mCompositeDeals.get(j)).b().c();
        view = (PlpAvailableCouponOfferView)view.itemView;
        view.setData(offer);
        view.setOnClickListener(new android.view.View.OnClickListener() {

            final com.target.ui.adapter.h.a this$0;
            final AvailableCouponOffer val$offer;
            final PlpAvailableCouponOfferView val$view;

            public void onClick(View view1)
            {
                if (com.target.ui.adapter.h.a.c(com.target.ui.adapter.h.a.this) == null)
                {
                    return;
                } else
                {
                    com.target.ui.adapter.h.a.c(com.target.ui.adapter.h.a.this).a(offer, view);
                    return;
                }
            }

            
            {
                this$0 = com.target.ui.adapter.h.a.this;
                offer = availablecouponoffer;
                view = plpavailablecouponofferview;
                super();
            }
        });
        view.setListener(new com.target.ui.view.product.PlpAvailableCouponOfferView.a() {

            final com.target.ui.adapter.h.a this$0;

            public void a(AvailableCouponOffer availablecouponoffer)
            {
                if (com.target.ui.adapter.h.a.c(com.target.ui.adapter.h.a.this) == null)
                {
                    return;
                } else
                {
                    com.target.ui.adapter.h.a.c(com.target.ui.adapter.h.a.this).a(availablecouponoffer);
                    return;
                }
            }

            
            {
                this$0 = com.target.ui.adapter.h.a.this;
                super();
            }
        });
    }

    private void i(final android.support.v7.widget.RecyclerView.t plpListItemView, int j)
    {
        final ProductDetails productDetails = (ProductDetails)((CompositeDeal)mCompositeDeals.get(j)).c().c();
        plpListItemView = (PlpListItemView)plpListItemView.itemView;
        plpListItemView.setItemData(productDetails);
        plpListItemView.setOnClickListener(new android.view.View.OnClickListener() {

            final com.target.ui.adapter.h.a this$0;
            final PlpListItemView val$plpListItemView;
            final ProductDetails val$productDetails;

            public void onClick(View view)
            {
                if (com.target.ui.adapter.h.a.c(com.target.ui.adapter.h.a.this) == null)
                {
                    return;
                } else
                {
                    com.target.ui.adapter.h.a.c(com.target.ui.adapter.h.a.this).a(productDetails, plpListItemView);
                    return;
                }
            }

            
            {
                this$0 = com.target.ui.adapter.h.a.this;
                productDetails = productdetails;
                plpListItemView = plplistitemview;
                super();
            }
        });
        plpListItemView.setClickListener(new com.target.ui.view.product.PlpListItemView.d() {

            final com.target.ui.adapter.h.a this$0;

            public void a(ProductDetails productdetails)
            {
                if (com.target.ui.adapter.h.a.c(com.target.ui.adapter.h.a.this) == null)
                {
                    return;
                } else
                {
                    com.target.ui.adapter.h.a.c(com.target.ui.adapter.h.a.this).b(productdetails);
                    return;
                }
            }

            public void b(ProductDetails productdetails)
            {
                if (com.target.ui.adapter.h.a.c(com.target.ui.adapter.h.a.this) == null)
                {
                    return;
                } else
                {
                    com.target.ui.adapter.h.a.c(com.target.ui.adapter.h.a.this).e(productdetails);
                    return;
                }
            }

            public void c(ProductDetails productdetails)
            {
                if (com.target.ui.adapter.h.a.c(com.target.ui.adapter.h.a.this) == null)
                {
                    return;
                } else
                {
                    com.target.ui.adapter.h.a.c(com.target.ui.adapter.h.a.this).f(productdetails);
                    return;
                }
            }

            public void d(ProductDetails productdetails)
            {
                if (com.target.ui.adapter.h.a.c(com.target.ui.adapter.h.a.this) == null)
                {
                    return;
                } else
                {
                    com.target.ui.adapter.h.a.c(com.target.ui.adapter.h.a.this).a(productdetails);
                    return;
                }
            }

            public void e(ProductDetails productdetails)
            {
                if (com.target.ui.adapter.h.a.c(com.target.ui.adapter.h.a.this) == null)
                {
                    return;
                } else
                {
                    com.target.ui.adapter.h.a.c(com.target.ui.adapter.h.a.this).c(productdetails);
                    return;
                }
            }

            public void f(ProductDetails productdetails)
            {
                if (com.target.ui.adapter.h.a.c(com.target.ui.adapter.h.a.this) == null)
                {
                    return;
                } else
                {
                    com.target.ui.adapter.h.a.c(com.target.ui.adapter.h.a.this).d(productdetails);
                    return;
                }
            }

            public void g(ProductDetails productdetails)
            {
                if (com.target.ui.adapter.h.a.c(com.target.ui.adapter.h.a.this) == null)
                {
                    return;
                } else
                {
                    com.target.ui.adapter.h.a.c(com.target.ui.adapter.h.a.this).g(productdetails);
                    return;
                }
            }

            
            {
                this$0 = com.target.ui.adapter.h.a.this;
                super();
            }
        });
    }

    protected View a(ViewGroup viewgroup)
    {
        return LayoutInflater.from(viewgroup.getContext()).inflate(0x7f030152, viewgroup, false);
    }

    public void a(a a1)
    {
        mOnFooterViewClickListener = a1;
    }

    public void a(b b1)
    {
        mOnHeaderClickListener = b1;
    }

    public void a(c c1)
    {
        mOnProductClickListener = c1;
    }

    protected View b(ViewGroup viewgroup)
    {
        DealsHeaderView dealsheaderview = (DealsHeaderView)LayoutInflater.from(viewgroup.getContext()).inflate(0x7f030155, viewgroup, false);
        dealsheaderview.a(viewgroup.getParent());
        return dealsheaderview;
    }

    public void b(boolean flag)
    {
        if (mShowNoProductsFoundView == flag)
        {
            return;
        } else
        {
            mShowNoProductsFoundView = flag;
            h();
            return;
        }
    }

    protected View c(ViewGroup viewgroup)
    {
        return LayoutInflater.from(viewgroup.getContext()).inflate(0x7f0301aa, viewgroup, false);
    }

    protected View c(ViewGroup viewgroup, int j)
    {
        switch (j)
        {
        default:
            return f(viewgroup);

        case 1: // '\001'
            return e(viewgroup);
        }
    }

    protected void c(android.support.v7.widget.RecyclerView.t t, int j)
    {
        DealsCategoryHeaderView dealscategoryheaderview = (DealsCategoryHeaderView)t.itemView;
        Context context = dealscategoryheaderview.getContext();
        t = context.getString(mSortLabelResource);
        if (o.g(t))
        {
            t = context.getString(0x7f0902dd, new Object[] {
                t
            });
        } else
        {
            t = null;
        }
        dealscategoryheaderview.setPrimaryText(context.getString(0x7f0902d4));
        dealscategoryheaderview.setSecondaryText(t);
        dealscategoryheaderview.a(false);
    }

    public void c(boolean flag)
    {
        if (mShowNoStoreView == flag)
        {
            return;
        } else
        {
            mShowNoStoreView = flag;
            h();
            return;
        }
    }

    protected void d(final android.support.v7.widget.RecyclerView.t dealsHeaderView, int j)
    {
        dealsHeaderView = (DealsHeaderView)dealsHeaderView.itemView;
        dealsHeaderView.setData(mWeeklyAdData);
        dealsHeaderView.a(mShowNoProductsFoundView);
        dealsHeaderView.b(mShowNoStoreView);
        dealsHeaderView.setOnButtonClickListener(new com.target.ui.view.shop.DealsHeaderView.a() {

            final com.target.ui.adapter.h.a this$0;

            public void a()
            {
                if (com.target.ui.adapter.h.a.a(com.target.ui.adapter.h.a.this) == null)
                {
                    return;
                } else
                {
                    com.target.ui.adapter.h.a.a(com.target.ui.adapter.h.a.this).b();
                    return;
                }
            }

            public void b()
            {
                if (com.target.ui.adapter.h.a.a(com.target.ui.adapter.h.a.this) == null)
                {
                    return;
                } else
                {
                    com.target.ui.adapter.h.a.a(com.target.ui.adapter.h.a.this).c();
                    return;
                }
            }

            public void c()
            {
                if (com.target.ui.adapter.h.a.a(com.target.ui.adapter.h.a.this) == null)
                {
                    return;
                } else
                {
                    com.target.ui.adapter.h.a.a(com.target.ui.adapter.h.a.this).d();
                    return;
                }
            }

            
            {
                this$0 = com.target.ui.adapter.h.a.this;
                super();
            }
        });
        dealsHeaderView.setOnWeeklyAdCardViewClickListener(new com.target.ui.view.shop.WeeklyAdView.b() {

            final com.target.ui.adapter.h.a this$0;
            final DealsHeaderView val$dealsHeaderView;

            public void a(WeeklyAdCardView weeklyadcardview)
            {
                if (com.target.ui.adapter.h.a.a(com.target.ui.adapter.h.a.this) == null)
                {
                    return;
                } else
                {
                    com.target.ui.adapter.h.a.a(com.target.ui.adapter.h.a.this).a(dealsHeaderView, weeklyadcardview);
                    return;
                }
            }

            
            {
                this$0 = com.target.ui.adapter.h.a.this;
                dealsHeaderView = dealsheaderview;
                super();
            }
        });
    }

    public void d(boolean flag)
    {
        if (mShowFooter == flag && !mShowFooterRetry)
        {
            return;
        } else
        {
            mShowFooter = flag;
            mShowFooterRetry = false;
            d();
            return;
        }
    }

    protected void e(android.support.v7.widget.RecyclerView.t t, int j)
    {
        t = (PlpFooterView)t.itemView;
        if (!mShowFooter)
        {
            t.b();
            return;
        } else
        {
            t.a();
            t.a(mShowFooterRetry);
            t.setClickListener(new com.target.ui.view.product.PlpFooterView.a() {

                final com.target.ui.adapter.h.a this$0;

                public void a()
                {
                    if (com.target.ui.adapter.h.a.b(com.target.ui.adapter.h.a.this) == null)
                    {
                        return;
                    } else
                    {
                        com.target.ui.adapter.h.a.b(com.target.ui.adapter.h.a.this).a();
                        return;
                    }
                }

            
            {
                this$0 = com.target.ui.adapter.h.a.this;
                super();
            }
            });
            return;
        }
    }

    public void e(boolean flag)
    {
        if (mShowFooter == flag && mShowFooterRetry)
        {
            return;
        } else
        {
            mShowFooter = flag;
            mShowFooterRetry = true;
            d();
            return;
        }
    }

    protected boolean e()
    {
        return true;
    }

    protected long f(int j)
    {
        return 0L;
    }

    protected void f(android.support.v7.widget.RecyclerView.t t, int j)
    {
        switch (g(j))
        {
        default:
            i(t, j);
            return;

        case 1: // '\001'
            h(t, j);
            break;
        }
    }

    protected boolean f()
    {
        return mShowFooter;
    }

    protected int g()
    {
        return mCompositeDeals.size();
    }

    protected int g(int j)
    {
        return ((CompositeDeal)mCompositeDeals.get(j)).a();
    }

    public void i(int j)
    {
        mSortLabelResource = j;
    }
}

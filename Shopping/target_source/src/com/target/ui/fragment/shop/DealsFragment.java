// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.shop;

import android.app.Activity;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.a.a.e;
import com.k.a.c;
import com.target.mothership.common.a.g;
import com.target.mothership.common.params.ProductSummaryParam;
import com.target.mothership.common.store.StoreIdentifier;
import com.target.mothership.common.weeklyad.PromotionRequest;
import com.target.mothership.model.coupons.interfaces.AvailableCouponOffer;
import com.target.mothership.model.list.interfaces.ListSummary;
import com.target.mothership.model.product.interfaces.ProductDetails;
import com.target.mothership.model.product.interfaces.ProductSummary;
import com.target.mothership.model.product.interfaces.ProductSummaryWrapper;
import com.target.mothership.model.store.interfaces.RelevantStoreSummary;
import com.target.mothership.model.store.interfaces.StoreSummary;
import com.target.ui.analytics.a.aa;
import com.target.ui.analytics.a.ab;
import com.target.ui.analytics.a.az;
import com.target.ui.analytics.a.ba;
import com.target.ui.analytics.a.l;
import com.target.ui.c.a.b;
import com.target.ui.c.d.d;
import com.target.ui.e.f;
import com.target.ui.fragment.common.BaseStoreChooserFragment;
import com.target.ui.fragment.mcoupons.CouponDetailFragment;
import com.target.ui.fragment.product.refine.ProductSummaryRefineFragment;
import com.target.ui.fragment.shop.c.a;
import com.target.ui.fragment.shop.presenter.DealsPresenter;
import com.target.ui.fragment.weekly_ad.WeeklyAdFragment;
import com.target.ui.model.refine.ProductRefineModel;
import com.target.ui.model.shop.AggregateDealsData;
import com.target.ui.model.weekly_ad.WeeklyAdHomepageData;
import com.target.ui.util.ad;
import com.target.ui.util.al;
import com.target.ui.util.j;
import com.target.ui.util.k;
import com.target.ui.util.n;
import com.target.ui.util.q;
import com.target.ui.view.common.TargetErrorView;
import com.target.ui.view.common.h;
import com.target.ui.view.product.PlpAvailableCouponOfferView;
import com.target.ui.view.product.PlpListItemView;
import com.target.ui.view.shop.DealsHeaderView;
import com.target.ui.view.shop.WeeklyAdCardView;
import java.util.ArrayList;
import java.util.List;

public class DealsFragment extends BaseStoreChooserFragment
    implements com.target.ui.adapter.h.a.a, com.target.ui.adapter.h.a.b, com.target.ui.adapter.h.a.c, az, com.target.ui.fragment.account.BaseAccountDialog.f, com.target.ui.fragment.product.dialog.BaseProductDialogFragment.b, com.target.ui.fragment.product.dialog.ProductAddToCartErrorDialog.c, com.target.ui.fragment.product.dialog.ProductAddToListDialogFragment.c, com.target.ui.fragment.product.refine.ProductSummaryRefineFragment.b, com.target.ui.fragment.shop.c.a, com.target.ui.service.k.c
{
    static class Views extends com.target.ui.view.a
    {

        TargetErrorView errorView;
        View progressContainer;
        RecyclerView recyclerView;
        View refineButton;

        Views(View view)
        {
            super(view);
        }
    }

    private class a extends com.target.ui.c.a.e
    {

        final DealsFragment this$0;

        public void a(ProductDetails productdetails)
        {
            com.target.ui.analytics.a.l.a(productdetails, null, 2).e();
        }

        public void a(String s1)
        {
            com.target.ui.fragment.shop.DealsFragment.a(DealsFragment.this).c(s1);
        }

        public void a(boolean flag)
        {
            com.target.ui.fragment.shop.DealsFragment.a(DealsFragment.this, flag);
        }

        private a()
        {
            this$0 = DealsFragment.this;
            super();
        }

    }

    private class b extends com.target.ui.c.b.e
    {

        final DealsFragment this$0;

        public void a(String s1)
        {
            com.target.ui.fragment.shop.DealsFragment.a(DealsFragment.this).c(s1);
        }

        public void a(String s1, ListSummary listsummary)
        {
            ad.a(getActivity(), s1, com.target.ui.fragment.shop.DealsFragment.a(DealsFragment.this), listsummary, m());
        }

        private b()
        {
            this$0 = DealsFragment.this;
            super();
        }

    }


    private static final String ARG_MUTE_VIEW_EVENTS = "muteViewEvents";
    private static final String ARG_WEEKLY_AD_PROMOTION_REQUEST = "weeklyAdRequestParams";
    private static final int FIRST_PRODUCT_POSITION = 1;
    private static final boolean MUTE_VIEW_EVENTS_DEFAULT = true;
    public static final String TAG = com/target/ui/fragment/shop/DealsFragment.getSimpleName();
    private com.target.ui.adapter.h.a mAdapter;
    private com.target.ui.c.a.b mAddToCartDelegate;
    private com.target.ui.c.b.b mAddToListDelegate;
    private List mAvailableCouponOffers;
    private List mCompositeDeals;
    private com.target.ui.c.c.a mNavigateToMapDelegate;
    private com.target.ui.c.d.a mNavigateToPdpDelegate;
    private com.target.ui.fragment.product.refine.ProductSummaryRefineFragment.b mParentRefineListener;
    private DealsPresenter mPresenter;
    private List mProductDetails;
    private f mScrollingTabCoordinator;
    private h mSnackBar;
    private Views mViews;
    private List mWeeklyAdData;
    private PromotionRequest mWeeklyAdPromotionRequest;

    public DealsFragment()
    {
        mAvailableCouponOffers = new ArrayList();
        mCompositeDeals = new ArrayList();
        mProductDetails = new ArrayList();
        mWeeklyAdData = new ArrayList();
        mAddToCartDelegate = new com.target.ui.c.a.b(this, new a());
        mAddToListDelegate = new com.target.ui.c.b.b(this, new b());
        mNavigateToMapDelegate = new com.target.ui.c.c.a(this);
        mNavigateToPdpDelegate = new com.target.ui.c.d.a(this);
    }

    public static DealsFragment a(PromotionRequest promotionrequest)
    {
        DealsFragment dealsfragment = f();
        dealsfragment.getArguments().putParcelable("weeklyAdRequestParams", promotionrequest);
        return dealsfragment;
    }

    static h a(DealsFragment dealsfragment)
    {
        return dealsfragment.mSnackBar;
    }

    private void a(long l1)
    {
        ba.a(l1, this).e();
    }

    private void a(ProductDetails productdetails, com.target.ui.helper.product.b b1)
    {
        mAddToCartDelegate.a(productdetails, b1, o(), g.PICK_UP_IN_STORE);
    }

    static void a(DealsFragment dealsfragment, long l1)
    {
        dealsfragment.a(l1);
    }

    static void a(DealsFragment dealsfragment, boolean flag)
    {
        dealsfragment.o(flag);
    }

    static DealsPresenter b(DealsFragment dealsfragment)
    {
        return dealsfragment.mPresenter;
    }

    static f c(DealsFragment dealsfragment)
    {
        return dealsfragment.mScrollingTabCoordinator;
    }

    static com.target.ui.adapter.h.a d(DealsFragment dealsfragment)
    {
        return dealsfragment.mAdapter;
    }

    public static DealsFragment f()
    {
        DealsFragment dealsfragment = new DealsFragment();
        dealsfragment.setArguments(new Bundle());
        return dealsfragment;
    }

    private void p()
    {
        mViews.errorView.setClickListener(new com.target.ui.view.common.c() {

            final DealsFragment this$0;

            public void A_()
            {
                com.target.ui.fragment.shop.DealsFragment.b(DealsFragment.this).h();
            }

            
            {
                this$0 = DealsFragment.this;
                super();
            }
        });
    }

    private void q()
    {
        al.c(mViews.progressContainer);
    }

    private void r()
    {
        mAdapter = new com.target.ui.adapter.h.a(mWeeklyAdData, mCompositeDeals);
        mAdapter.a(this);
        mAdapter.a(this);
        mAdapter.a(this);
        final c stickyHeadersDecoration = new LinearLayoutManager(getActivity(), 1, false);
        mViews.recyclerView.setAdapter(mAdapter);
        mViews.recyclerView.setLayoutManager(stickyHeadersDecoration);
        mViews.recyclerView.a(new k(getActivity(), 1));
        mViews.recyclerView.setHasFixedSize(true);
        stickyHeadersDecoration = new c(mAdapter);
        mViews.recyclerView.a(stickyHeadersDecoration);
        mAdapter.a(new android.support.v7.widget.RecyclerView.c() {

            final DealsFragment this$0;
            final c val$stickyHeadersDecoration;

            public void a()
            {
                stickyHeadersDecoration.a();
            }

            
            {
                this$0 = DealsFragment.this;
                stickyHeadersDecoration = c1;
                super();
            }
        });
        mViews.recyclerView.setOnScrollListener(new android.support.v7.widget.RecyclerView.k() {

            final DealsFragment this$0;

            public void a(RecyclerView recyclerview, int i1)
            {
                super.a(recyclerview, i1);
                while (com.target.ui.fragment.shop.DealsFragment.c(DealsFragment.this) == null || i1 != 0) 
                {
                    return;
                }
                com.target.ui.fragment.shop.DealsFragment.c(DealsFragment.this).f();
            }

            public void a(RecyclerView recyclerview, int i1, int j1)
            {
                if (com.target.ui.fragment.shop.DealsFragment.c(DealsFragment.this) != null)
                {
                    com.target.ui.fragment.shop.DealsFragment.c(DealsFragment.this).b(j1);
                }
                i1 = recyclerview.d(recyclerview.getChildAt(recyclerview.getChildCount() - 1));
                j1 = com.target.ui.fragment.shop.DealsFragment.d(DealsFragment.this).a();
                com.target.ui.fragment.shop.DealsFragment.b(DealsFragment.this).a(i1, j1 - 1);
            }

            
            {
                this$0 = DealsFragment.this;
                super();
            }
        });
        if (mScrollingTabCoordinator != null)
        {
            mViews.recyclerView.setClipToPadding(false);
            mViews.recyclerView.setPadding(mViews.recyclerView.getPaddingLeft(), mViews.recyclerView.getPaddingTop() + mScrollingTabCoordinator.e(), mViews.recyclerView.getPaddingRight(), mViews.recyclerView.getPaddingBottom());
        }
    }

    private void s()
    {
        mViews.refineButton.setOnClickListener(new android.view.View.OnClickListener() {

            final DealsFragment this$0;

            public void onClick(View view)
            {
                com.target.ui.fragment.shop.DealsFragment.b(DealsFragment.this).g();
            }

            
            {
                this$0 = DealsFragment.this;
                super();
            }
        });
        mSnackBar.a(mViews.refineButton);
    }

    public void J()
    {
    }

    public void a()
    {
        mPresenter.f();
    }

    public void a(int i1)
    {
        aa.a(i1).e();
    }

    public void a(int i1, final AvailableCouponOffer availableCouponOffer)
    {
        mSnackBar.a(getString(i1), getString(0x7f090305), getResources().getColor(0x7f0f00ec), new com.target.ui.view.common.h.b() {

            final DealsFragment this$0;
            final AvailableCouponOffer val$availableCouponOffer;

            public void a()
            {
                com.target.ui.fragment.shop.DealsFragment.b(DealsFragment.this).c(availableCouponOffer);
            }

            public void b()
            {
            }

            
            {
                this$0 = DealsFragment.this;
                availableCouponOffer = availablecouponoffer;
                super();
            }
        });
    }

    public void a(e e1)
    {
        mPresenter.a((RelevantStoreSummary)e1.d());
    }

    public void a(ProductSummaryParam productsummaryparam, ArrayList arraylist)
    {
        mPresenter.a(productsummaryparam, arraylist);
    }

    public void a(AvailableCouponOffer availablecouponoffer)
    {
        mPresenter.b(availablecouponoffer);
    }

    public void a(AvailableCouponOffer availablecouponoffer, PlpAvailableCouponOfferView plpavailablecouponofferview)
    {
        mPresenter.a(availablecouponoffer, plpavailablecouponofferview);
    }

    public void a(ProductDetails productdetails)
    {
        ab.a(1, mProductDetails.indexOf(productdetails)).e();
        mAddToListDelegate.a(productdetails);
    }

    public void a(ProductDetails productdetails, PlpListItemView plplistitemview)
    {
        mPresenter.a(productdetails, plplistitemview);
    }

    public void a(StoreSummary storesummary)
    {
        com.target.ui.service.k.a().a(storesummary.getStoreId());
    }

    public void a(ProductRefineModel productrefinemodel, ProductSummaryParam productsummaryparam)
    {
        if (Z())
        {
            return;
        }
        Object obj;
        if (mParentRefineListener != null)
        {
            obj = mParentRefineListener;
        } else
        {
            obj = this;
        }
        productrefinemodel = ProductSummaryRefineFragment.a(productrefinemodel, productsummaryparam, ((com.target.ui.fragment.product.refine.ProductSummaryRefineFragment.b) (obj)));
        m().a(productrefinemodel, com.target.ui.f.c.a.SLIDE_BOTTOM);
    }

    public void a(AggregateDealsData aggregatedealsdata, int i1)
    {
        mWeeklyAdData.clear();
        mProductDetails.clear();
        mAvailableCouponOffers.clear();
        mCompositeDeals.clear();
        mWeeklyAdData.addAll(aggregatedealsdata.c());
        if (aggregatedealsdata.b().b())
        {
            mProductDetails.addAll(((ProductSummaryWrapper)aggregatedealsdata.b().c()).a().a());
        }
        mAvailableCouponOffers.addAll(aggregatedealsdata.a());
        com.target.ui.util.h.a(mCompositeDeals, mAvailableCouponOffers, mProductDetails);
        mAdapter.i(i1);
        mAdapter.d();
    }

    public void a(com.target.ui.view.common.b.a a1, boolean flag)
    {
        al.a(mViews.errorView, new View[] {
            mViews.recyclerView, mViews.refineButton, mViews.progressContainer
        });
        mViews.errorView.a(a1, flag);
    }

    public void a(DealsHeaderView dealsheaderview, WeeklyAdCardView weeklyadcardview)
    {
        mPresenter.a(dealsheaderview, weeklyadcardview);
    }

    public void a(DealsHeaderView dealsheaderview, WeeklyAdCardView weeklyadcardview, StoreSummary storesummary)
    {
        dealsheaderview = storesummary.getStoreId();
        storesummary = (String)((com.target.ui.view.shop.WeeklyAdCardView.a)weeklyadcardview.getViewModel().c()).c().d();
        Object obj = (WeeklyAdHomepageData)((com.target.ui.view.shop.WeeklyAdCardView.a)weeklyadcardview.getViewModel().c()).d().c();
        if (((WeeklyAdHomepageData) (obj)).b().equals(dealsheaderview))
        {
            dealsheaderview = WeeklyAdFragment.a(((WeeklyAdHomepageData) (obj)));
        } else
        {
            dealsheaderview = WeeklyAdFragment.a(dealsheaderview, ((WeeklyAdHomepageData) (obj)).a());
        }
        if (com.target.ui.util.j.b())
        {
            obj = new com.target.ui.f.b(m());
            weeklyadcardview = new com.target.ui.f.a(getActivity(), this, weeklyadcardview.getBitmapImageView(), "weeklyAdFragmentTransitionTag");
            weeklyadcardview.a(storesummary);
            ((com.target.ui.f.b) (obj)).a(dealsheaderview, weeklyadcardview);
            return;
        } else
        {
            m().d(dealsheaderview);
            return;
        }
    }

    public void a(List list)
    {
        mProductDetails.addAll(list);
        com.target.ui.util.h.a(mCompositeDeals, mAvailableCouponOffers, mProductDetails);
        mAdapter.d();
    }

    public void a(boolean flag)
    {
        getArguments().putBoolean("muteViewEvents", flag);
        if (mPresenter == null)
        {
            return;
        } else
        {
            mPresenter.a(flag);
            return;
        }
    }

    public void b()
    {
        mPresenter.b();
    }

    public void b(int i1)
    {
        mSnackBar.c(getString(i1));
    }

    public void b(Uri uri, String s1)
    {
        if (!com.target.ui.util.deep_link.g.c(uri))
        {
            com.target.ui.util.n.a(getActivity(), uri, s1);
            return;
        }
        s1 = com.target.ui.util.deep_link.g.a(uri, o());
        static class _cls7
        {

            static final int $SwitchMap$com$target$ui$util$deep_link$DeepLinkReport$ReportType[];

            static 
            {
                $SwitchMap$com$target$ui$util$deep_link$DeepLinkReport$ReportType = new int[com.target.ui.util.deep_link.f.b.values().length];
                try
                {
                    $SwitchMap$com$target$ui$util$deep_link$DeepLinkReport$ReportType[com.target.ui.util.deep_link.f.b.FRAGMENT.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror) { }
            }
        }

        switch (_cls7..SwitchMap.com.target.ui.util.deep_link.DeepLinkReport.ReportType[s1.e().ordinal()])
        {
        default:
            com.target.ui.util.q.a(TAG, (new StringBuilder()).append("Unexpected deep link : ").append(uri).toString());
            return;

        case 1: // '\001'
            m().d((Fragment)s1.d().c());
            break;
        }
    }

    public void b(AvailableCouponOffer availablecouponoffer)
    {
        if (Z())
        {
            return;
        } else
        {
            m().d(CouponDetailFragment.a(availablecouponoffer));
            return;
        }
    }

    public void b(ProductDetails productdetails)
    {
        RelevantStoreSummary relevantstoresummary = o();
        if (relevantstoresummary == null)
        {
            com.target.ui.util.q.a(TAG, "No store found when clicking on aisle location.");
            return;
        } else
        {
            mNavigateToMapDelegate.a(productdetails, relevantstoresummary);
            return;
        }
    }

    public void b(ProductDetails productdetails, PlpListItemView plplistitemview)
    {
        productdetails = new d(productdetails);
        productdetails.a(o());
        productdetails.a(plplistitemview.getBitmapImageView());
        mNavigateToPdpDelegate.a(productdetails);
    }

    public void b(com.target.ui.analytics.h h1)
    {
        a(a(h1));
    }

    public void c()
    {
        mPresenter.c();
    }

    public void c(ProductDetails productdetails)
    {
        a(productdetails, com.target.ui.helper.product.b.EMAIL);
    }

    public void c(boolean flag)
    {
        mAdapter.b(flag);
    }

    public void d()
    {
        mPresenter.d();
    }

    public void d(ProductDetails productdetails)
    {
        a(productdetails, com.target.ui.helper.product.b.MAIL);
    }

    public void d(boolean flag)
    {
        mAdapter.c(flag);
    }

    public void e()
    {
        if (mPresenter == null)
        {
            com.target.ui.util.q.a(TAG, "requestViewEventPublish called when presenter is null");
            return;
        } else
        {
            mPresenter.e();
            return;
        }
    }

    public void e(ProductDetails productdetails)
    {
        ab.a(2, mProductDetails.indexOf(productdetails)).e();
        a(productdetails, com.target.ui.helper.product.b.PICK_UP);
    }

    public void e(boolean flag)
    {
        boolean flag2 = true;
        al.a(mViews.errorView, false);
        al.a(mViews.progressContainer, flag);
        Object obj = mViews.recyclerView;
        boolean flag1;
        if (!flag)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        al.a(((View) (obj)), flag1);
        obj = mViews.refineButton;
        if (!flag)
        {
            flag = flag2;
        } else
        {
            flag = false;
        }
        al.a(((View) (obj)), flag);
    }

    public void f(ProductDetails productdetails)
    {
        ab.a(3, mProductDetails.indexOf(productdetails)).e();
        a(productdetails, com.target.ui.helper.product.b.SHIP);
    }

    public void f(boolean flag)
    {
        mAdapter.d(flag);
    }

    public com.target.ui.fragment.store.StoreChooserDialogFragment.d g()
    {
        return com.target.ui.fragment.store.StoreChooserDialogFragment.d.NEARBY_STORES;
    }

    public void g(ProductDetails productdetails)
    {
        a(productdetails, com.target.ui.helper.product.b.SMS);
    }

    public void g(boolean flag)
    {
        mAdapter.e(flag);
    }

    public void h()
    {
        super.h();
    }

    public void i()
    {
        a(new Runnable() {

            final DealsFragment this$0;

            public void run()
            {
                com.target.ui.fragment.shop.DealsFragment.a(DealsFragment.this, 0L);
            }

            
            {
                this$0 = DealsFragment.this;
                super();
            }
        });
    }

    public void j()
    {
        mViews.recyclerView.a_(1);
    }

    public com.target.ui.fragment.product.dialog.ProductAddToCartErrorDialog.b k()
    {
        return mAddToCartDelegate.k();
    }

    public com.target.ui.fragment.account.BaseAccountDialog.c l()
    {
        return mAddToCartDelegate.l();
    }

    public com.target.ui.fragment.account.BaseAccountDialog.e n()
    {
        return mAddToCartDelegate.n();
    }

    public RelevantStoreSummary o()
    {
        return (RelevantStoreSummary)com.target.ui.service.k.a().c().d();
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        a(new com.target.ui.c.a[] {
            mAddToCartDelegate, mAddToListDelegate, mNavigateToMapDelegate, mNavigateToPdpDelegate
        });
        activity = getParentFragment();
        if (activity != null)
        {
            if (activity instanceof com.target.ui.fragment.product.refine.ProductSummaryRefineFragment.b)
            {
                mParentRefineListener = (com.target.ui.fragment.product.refine.ProductSummaryRefineFragment.b)activity;
                if (activity instanceof f)
                {
                    mScrollingTabCoordinator = (f)activity;
                    return;
                }
            } else
            {
                throw new IllegalStateException((new StringBuilder()).append(getParentFragment()).append(" must implement ").append("OnSearchRefineListener and call onRefine on this fragment when it receives ").append("results.").toString());
            }
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        mWeeklyAdPromotionRequest = (PromotionRequest)getArguments().getParcelable("weeklyAdRequestParams");
        boolean flag = getArguments().getBoolean("muteViewEvents", true);
        bundle = new com.target.ui.helper.p.a();
        bundle.a(true);
        mPresenter = new DealsPresenter(bundle, new com.target.ui.service.provider.d(), new com.target.ui.service.provider.g(), (RelevantStoreSummary)com.target.ui.service.k.a().c().d(), mWeeklyAdPromotionRequest, flag, null);
        mSnackBar = new h(getActivity());
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f030059, viewgroup, false);
        mViews = new Views(layoutinflater);
        p();
        q();
        r();
        s();
        com.target.ui.service.k.a().a(this);
        mPresenter.a(this);
        return layoutinflater;
    }

    public void onDestroy()
    {
        super.onDestroy();
        mPresenter.v_();
        mPresenter = null;
        mSnackBar = null;
    }

    public void onDestroyView()
    {
        super.onDestroyView();
        com.target.ui.service.k.a().b(this);
        mPresenter.z_();
        mViews = null;
    }

    public void onDetach()
    {
        super.onDetach();
        mAddToCartDelegate = null;
        mAddToListDelegate = null;
        mNavigateToMapDelegate = null;
        mNavigateToPdpDelegate = null;
        mParentRefineListener = null;
        mScrollingTabCoordinator = null;
    }

    public void onPause()
    {
        super.onPause();
        if (mSnackBar == null)
        {
            return;
        } else
        {
            mSnackBar.a();
            return;
        }
    }

    public com.target.ui.fragment.product.dialog.BaseProductDialogFragment.a r_()
    {
        return mAddToCartDelegate.r_();
    }

    public com.target.ui.fragment.product.dialog.ProductAddToListDialogFragment.b s_()
    {
        return mAddToListDelegate.s_();
    }

}

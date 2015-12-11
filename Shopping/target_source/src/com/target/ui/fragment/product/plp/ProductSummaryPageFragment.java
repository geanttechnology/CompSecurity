// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.product.plp;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.s;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import com.target.mothership.common.params.ProductSummaryParam;
import com.target.mothership.model.guest.interfaces.Guest;
import com.target.mothership.model.list.interfaces.ListSummary;
import com.target.mothership.model.page_item.interfaces.PageItem;
import com.target.mothership.model.product.interfaces.ProductDetails;
import com.target.mothership.model.product.interfaces.ProductEntry;
import com.target.mothership.model.product.interfaces.ProductSummary;
import com.target.mothership.model.store.interfaces.RelevantStoreSummary;
import com.target.mothership.model.store.interfaces.Store;
import com.target.ui.adapter.product.e;
import com.target.ui.adapter.product.f;
import com.target.ui.analytics.a.ah;
import com.target.ui.analytics.a.l;
import com.target.ui.c.a.b;
import com.target.ui.c.d.d;
import com.target.ui.common.ProductErrorHeaderOptions;
import com.target.ui.common.ProductHeaderOptions;
import com.target.ui.f.c;
import com.target.ui.fragment.common.BaseNavigationFragment;
import com.target.ui.fragment.product.common.PageItemHierarchy;
import com.target.ui.fragment.product.plp.a.a;
import com.target.ui.fragment.product.plp.presenter.ProductSummaryPagePresenter;
import com.target.ui.fragment.product.plp.presenter.ProductSummaryPagePresenterParam;
import com.target.ui.fragment.product.refine.ProductSummaryRefineFragment;
import com.target.ui.model.refine.ProductRefineModel;
import com.target.ui.util.ad;
import com.target.ui.util.al;
import com.target.ui.util.deep_link.g;
import com.target.ui.util.k;
import com.target.ui.util.q;
import com.target.ui.util.y;
import com.target.ui.view.BitmapImageView;
import com.target.ui.view.ConfigurableDropShadowView;
import com.target.ui.view.TargetFloatingActionButton;
import com.target.ui.view.ToolbarSpinner;
import com.target.ui.view.common.TargetErrorView;
import com.target.ui.view.common.h;
import com.target.ui.view.product.PlpDvmView;
import com.target.ui.view.product.PlpRefineHeaderView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProductSummaryPageFragment extends BaseNavigationFragment
    implements com.target.ui.fragment.account.BaseAccountDialog.f, com.target.ui.fragment.product.dialog.BaseProductDialogFragment.b, com.target.ui.fragment.product.dialog.ProductAddToCartErrorDialog.c, com.target.ui.fragment.product.dialog.ProductAddToListDialogFragment.c, com.target.ui.fragment.product.plp.a.a, com.target.ui.fragment.product.refine.ProductSummaryRefineFragment.b
{
    static class Views extends com.target.ui.view.a
    {

        View contentContainer;
        TargetErrorView errorContainer;
        RecyclerView mGridRecyclerView;
        RecyclerView mListRecyclerView;
        ConfigurableDropShadowView mockActionBarDropShadow;
        BitmapImageView plpBannerImageView;
        View progressContainer;
        TargetFloatingActionButton refineFloatingActionButton;
        PlpRefineHeaderView refineHeaderView;

        Views(View view)
        {
            super(view);
        }
    }

    private class a extends com.target.ui.c.a.e
    {

        final ProductSummaryPageFragment this$0;

        public void a(ProductDetails productdetails)
        {
            com.target.ui.fragment.product.plp.ProductSummaryPageFragment.d(ProductSummaryPageFragment.this).d(productdetails);
        }

        public void a(String s1)
        {
            com.target.ui.fragment.product.plp.ProductSummaryPageFragment.g(ProductSummaryPageFragment.this).c(s1);
        }

        private a()
        {
            this$0 = ProductSummaryPageFragment.this;
            super();
        }

    }

    private class b extends com.target.ui.c.b.e
    {

        final ProductSummaryPageFragment this$0;

        public void a(String s1)
        {
            com.target.ui.fragment.product.plp.ProductSummaryPageFragment.g(ProductSummaryPageFragment.this).c(s1);
        }

        public void a(String s1, ListSummary listsummary)
        {
            ad.a(getActivity(), s1, com.target.ui.fragment.product.plp.ProductSummaryPageFragment.g(ProductSummaryPageFragment.this), listsummary, m());
        }

        private b()
        {
            this$0 = ProductSummaryPageFragment.this;
            super();
        }

    }

    private class c
        implements com.target.ui.view.common.c
    {

        final ProductSummaryPageFragment this$0;

        public void A_()
        {
            com.target.ui.fragment.product.plp.ProductSummaryPageFragment.d(ProductSummaryPageFragment.this).c();
        }

        private c()
        {
            this$0 = ProductSummaryPageFragment.this;
            super();
        }

    }

    private class d extends android.support.v7.widget.RecyclerView.k
    {

        final ProductSummaryPageFragment this$0;

        public void a(RecyclerView recyclerview, int i1)
        {
            com.target.ui.fragment.product.plp.ProductSummaryPageFragment.d(ProductSummaryPageFragment.this).a(i1);
        }

        public void a(RecyclerView recyclerview, int i1, int j1)
        {
            int k1 = com.target.ui.fragment.product.plp.ProductSummaryPageFragment.b(ProductSummaryPageFragment.this).o();
            int l1 = com.target.ui.fragment.product.plp.ProductSummaryPageFragment.b(ProductSummaryPageFragment.this).w();
            int i2 = com.target.ui.fragment.product.plp.ProductSummaryPageFragment.b(ProductSummaryPageFragment.this).i();
            com.target.ui.fragment.product.plp.ProductSummaryPageFragment.d(ProductSummaryPageFragment.this).a(i2, k1, l1, i1, j1);
        }

        private d()
        {
            this$0 = ProductSummaryPageFragment.this;
            super();
        }

    }

    private class e extends android.support.v7.widget.s.c
    {

        final ProductSummaryPageFragment this$0;

        public int a(int i1)
        {
            while (com.target.ui.fragment.product.plp.ProductSummaryPageFragment.h(ProductSummaryPageFragment.this) == null || i1 >= com.target.ui.fragment.product.plp.ProductSummaryPageFragment.h(ProductSummaryPageFragment.this).a()) 
            {
                return -1;
            }
            switch (com.target.ui.fragment.product.plp.ProductSummaryPageFragment.h(ProductSummaryPageFragment.this).a(i1))
            {
            default:
                return 1;

            case 201: 
            case 1000000000: 
            case 1000000001: 
                return 3;
            }
        }

        private e()
        {
            this$0 = ProductSummaryPageFragment.this;
            super();
        }

    }

    private class f extends android.support.v7.widget.RecyclerView.k
    {

        final ProductSummaryPageFragment this$0;

        public void a(RecyclerView recyclerview, int i1)
        {
            com.target.ui.fragment.product.plp.ProductSummaryPageFragment.d(ProductSummaryPageFragment.this).b(i1);
        }

        public void a(RecyclerView recyclerview, int i1, int j1)
        {
            int k1 = com.target.ui.fragment.product.plp.ProductSummaryPageFragment.e(ProductSummaryPageFragment.this).o();
            int l1 = com.target.ui.fragment.product.plp.ProductSummaryPageFragment.e(ProductSummaryPageFragment.this).w();
            int i2 = com.target.ui.fragment.product.plp.ProductSummaryPageFragment.e(ProductSummaryPageFragment.this).i();
            com.target.ui.fragment.product.plp.ProductSummaryPageFragment.d(ProductSummaryPageFragment.this).b(i2, k1, l1, i1, j1);
        }

        private f()
        {
            this$0 = ProductSummaryPageFragment.this;
            super();
        }

    }

    private class g
        implements com.target.ui.adapter.product.e.a
    {

        final ProductSummaryPageFragment this$0;

        public void a()
        {
            com.target.ui.fragment.product.plp.ProductSummaryPageFragment.d(ProductSummaryPageFragment.this).d();
        }

        public void a(BitmapImageView bitmapimageview, ProductDetails productdetails)
        {
            com.target.ui.fragment.product.plp.ProductSummaryPageFragment.d(ProductSummaryPageFragment.this).a(bitmapimageview, productdetails);
        }

        public void a(PlpDvmView plpdvmview)
        {
            com.target.ui.fragment.product.plp.ProductSummaryPageFragment.d(ProductSummaryPageFragment.this).a(plpdvmview.getDvmContent());
        }

        public void a(String s1)
        {
            com.target.ui.fragment.product.plp.ProductSummaryPageFragment.d(ProductSummaryPageFragment.this).a(s1);
        }

        public void b()
        {
            com.target.ui.fragment.product.plp.ProductSummaryPageFragment.d(ProductSummaryPageFragment.this).c();
        }

        private g()
        {
            this$0 = ProductSummaryPageFragment.this;
            super();
        }

    }

    private class h
        implements com.target.ui.adapter.product.f.a
    {

        final ProductSummaryPageFragment this$0;

        public void a()
        {
            com.target.ui.fragment.product.plp.ProductSummaryPageFragment.d(ProductSummaryPageFragment.this).d();
        }

        public void a(ProductDetails productdetails)
        {
            com.target.ui.fragment.product.plp.ProductSummaryPageFragment.d(ProductSummaryPageFragment.this).a(productdetails);
        }

        public void a(BitmapImageView bitmapimageview, ProductDetails productdetails)
        {
            com.target.ui.fragment.product.plp.ProductSummaryPageFragment.d(ProductSummaryPageFragment.this).a(bitmapimageview, productdetails);
        }

        public void a(PlpDvmView plpdvmview)
        {
            com.target.ui.fragment.product.plp.ProductSummaryPageFragment.d(ProductSummaryPageFragment.this).a(plpdvmview.getDvmContent());
        }

        public void a(String s1)
        {
            com.target.ui.fragment.product.plp.ProductSummaryPageFragment.d(ProductSummaryPageFragment.this).a(s1);
        }

        public void b()
        {
            com.target.ui.fragment.product.plp.ProductSummaryPageFragment.d(ProductSummaryPageFragment.this).c();
        }

        public void b(ProductDetails productdetails)
        {
            com.target.ui.fragment.product.plp.ProductSummaryPageFragment.d(ProductSummaryPageFragment.this).b(productdetails);
        }

        public void c(ProductDetails productdetails)
        {
            com.target.ui.fragment.product.plp.ProductSummaryPageFragment.d(ProductSummaryPageFragment.this).c(productdetails);
        }

        private h()
        {
            this$0 = ProductSummaryPageFragment.this;
            super();
        }

    }

    private class i
        implements android.view.View.OnClickListener
    {

        final ProductSummaryPageFragment this$0;

        public void onClick(View view)
        {
            com.target.ui.fragment.product.plp.ProductSummaryPageFragment.d(ProductSummaryPageFragment.this).f();
        }

        private i()
        {
            this$0 = ProductSummaryPageFragment.this;
            super();
        }

    }

    private static class j extends android.support.v7.widget.RecyclerView.f
    {

        private int mColumns;
        private boolean mEnabled;
        private int mLargeOffset;
        private int mSmallOffset;
        private android.support.v7.widget.s.c mSpanSizeLookup;
        private boolean mUsingHeader;
        private boolean mUsingSmallOffset;

        public int a()
        {
            if (mUsingSmallOffset)
            {
                return mSmallOffset;
            } else
            {
                return mLargeOffset;
            }
        }

        public void a(Rect rect, View view, RecyclerView recyclerview, android.support.v7.widget.RecyclerView.q q1)
        {
            int i1;
            if (mEnabled)
            {
                if (((i1 = recyclerview.d(view)) != 0 || !mUsingHeader) && i1 <= d())
                {
                    rect.set(0, a(), 0, 0);
                    return;
                }
            }
        }

        public void a(android.support.v7.widget.s.c c1)
        {
            mSpanSizeLookup = c1;
        }

        public void a(boolean flag)
        {
            mEnabled = flag;
        }

        public int b()
        {
            return c();
        }

        public void b(boolean flag)
        {
            mUsingSmallOffset = flag;
        }

        public int c()
        {
            return !mUsingHeader ? 0 : 1;
        }

        public void c(boolean flag)
        {
            mUsingHeader = flag;
        }

        public int d()
        {
            if (mSpanSizeLookup != null) goto _L2; else goto _L1
_L1:
            int i2;
            int i1 = b();
            i2 = (mColumns - 1) + i1;
_L4:
            return i2;
_L2:
            int j1;
            int k1;
            int l1;
            j1 = b();
            l1 = 0;
            k1 = j1;
_L6:
            i2 = j1;
            if (k1 >= mColumns + j1) goto _L4; else goto _L3
_L3:
            int j2;
            j2 = mSpanSizeLookup.a(k1);
            i2 = j1;
            if (j2 < 1) goto _L4; else goto _L5
_L5:
            l1 += j2;
            if (l1 >= mColumns)
            {
                return k1;
            }
            k1++;
              goto _L6
        }

        public boolean e()
        {
            return mEnabled;
        }

        public boolean f()
        {
            return mUsingHeader;
        }

        public boolean g()
        {
            return mUsingSmallOffset;
        }

        public j(Context context, int i1)
        {
            mEnabled = true;
            mUsingSmallOffset = true;
            mUsingHeader = false;
            mColumns = i1;
            mSmallOffset = context.getResources().getDimensionPixelSize(0x7f0a027a);
            mLargeOffset = context.getResources().getDimensionPixelSize(0x7f0a0279);
        }
    }

    private class k
        implements com.target.ui.view.ToolbarSpinner.a
    {

        final ProductSummaryPageFragment this$0;

        public void a(int i1)
        {
            com.target.ui.fragment.product.plp.ProductSummaryPageFragment.d(ProductSummaryPageFragment.this).c(i1);
        }

        private k()
        {
            this$0 = ProductSummaryPageFragment.this;
            super();
        }

    }


    private static final String ARG_SAVED_STATE_PRESENTER = "pdpPresenterSavedStateArg";
    private static final String BANNER_ARG = "bannerArg";
    private static final int ENTIRE_GRID_COLUMNS = 3;
    private static final int GRID_NUM_COLUMNS = 3;
    private static final int INVALID_GRID_COLUMNS = -1;
    private static final String PRODUCT_IDENTIFIER_ARG = "productIdentifierArg";
    private static final String PRODUCT_PAGE_ITEM_HIERARCHY = "pageItemHierarchyArg";
    private static final String PRODUCT_PAGE_ITEM_LIST_ARG = "pageItemsListArg";
    private static final String PRODUCT_PARAM_ARG = "productParamArg";
    private static final String SHOW_GRID_VIEW_ARG = "showGridArg";
    private static final int SINGLE_GRID_COLUMNS = 1;
    private static final String STORE_ARG = "storeArg";
    private static final String TITLE_ARG = "titleArg";
    private com.target.ui.c.a.b mAddToCartDelegate;
    private com.target.ui.c.b.b mAddToListDelegate;
    private List mCompositeProductsForGridView;
    private List mCompositeProductsForListView;
    private s mGridLayoutManager;
    private j mGridRefineHeaderSpacerDecoration;
    private com.target.ui.adapter.product.e mGridViewAdapter;
    private LinearLayoutManager mListLayoutManager;
    private j mListRefineHeaderSpacerDecoration;
    private com.target.ui.adapter.product.f mListViewAdapter;
    private com.target.ui.c.c.a mNavigateToMapDelegate;
    private com.target.ui.c.d.a mNavigateToPdpDelegate;
    private ProductSummaryPagePresenter mPresenter;
    private ProductSummaryPagePresenterParam mProductSummaryPagePresenterRequestParam;
    private Parcelable mSavedState;
    private com.target.ui.view.common.h mSnackBar;
    private Views mViews;

    public ProductSummaryPageFragment()
    {
        mCompositeProductsForListView = new ArrayList();
        mCompositeProductsForGridView = new ArrayList();
        mNavigateToMapDelegate = new com.target.ui.c.c.a(this);
        mNavigateToPdpDelegate = new com.target.ui.c.d.a(this);
        mAddToCartDelegate = new com.target.ui.c.a.b(this, new a());
        mAddToListDelegate = new com.target.ui.c.b.b(this, new b());
    }

    private void A()
    {
        mViews.errorContainer.setClickListener(null);
        mViews.refineFloatingActionButton.setOnClickListener(null);
        mListViewAdapter.a(null);
        mGridViewAdapter.a(null);
        mViews.mListRecyclerView.setOnScrollListener(null);
        mViews.mGridRecyclerView.setOnScrollListener(null);
    }

    private Store B()
    {
        return (Store)getArguments().getParcelable("storeArg");
    }

    private PageItemHierarchy C()
    {
        return (PageItemHierarchy)getArguments().getParcelable("pageItemHierarchyArg");
    }

    private List D()
    {
        return getArguments().getParcelableArrayList("pageItemsListArg");
    }

    private List E()
    {
        return getArguments().getParcelableArrayList("productIdentifierArg");
    }

    private ProductSummaryParam F()
    {
        return (ProductSummaryParam)getArguments().getParcelable("productParamArg");
    }

    private boolean G()
    {
        return getArguments().getBoolean("showGridArg", false);
    }

    private String H()
    {
        return getArguments().getString("titleArg", "");
    }

    private String I()
    {
        return getArguments().getString("bannerArg", "");
    }

    static Views a(ProductSummaryPageFragment productsummarypagefragment)
    {
        return productsummarypagefragment.mViews;
    }

    public static ProductSummaryPageFragment a(ProductSummaryParam productsummaryparam, boolean flag)
    {
        return a(productsummaryparam, flag, ((String) (null)), ((String) (null)));
    }

    public static ProductSummaryPageFragment a(ProductSummaryParam productsummaryparam, boolean flag, String s1, String s2)
    {
        ProductSummaryPageFragment productsummarypagefragment = new ProductSummaryPageFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("productParamArg", productsummaryparam);
        bundle.putParcelable("storeArg", productsummaryparam.b());
        bundle.putBoolean("showGridArg", flag);
        bundle.putString("titleArg", s1);
        bundle.putString("bannerArg", s2);
        productsummarypagefragment.setArguments(bundle);
        return productsummarypagefragment;
    }

    public static ProductSummaryPageFragment a(ArrayList arraylist, boolean flag, Store store, String s1, String s2)
    {
        ProductSummaryPageFragment productsummarypagefragment = new ProductSummaryPageFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("storeArg", store);
        bundle.putBoolean("showGridArg", flag);
        bundle.putParcelableArrayList("productIdentifierArg", arraylist);
        bundle.putString("titleArg", s1);
        bundle.putString("bannerArg", s2);
        productsummarypagefragment.setArguments(bundle);
        return productsummarypagefragment;
    }

    private ProductSummaryPagePresenterParam a(ProductSummaryParam productsummaryparam)
    {
        List list = com.target.ui.util.y.a(D());
        return (new com.target.ui.fragment.product.plp.presenter.ProductSummaryPagePresenterParam.a()).a(B()).b(H()).a(I()).a(G()).a(productsummaryparam).b(E()).a(C()).a(list).a();
    }

    private com.target.ui.fragment.product.plp.presenter.a a(LinearLayoutManager linearlayoutmanager, j j1, int i1, int k1)
    {
        int i2 = 0;
        int k2 = j1.a();
        int l2 = j1.b();
        int i3 = linearlayoutmanager.i();
        int j2;
        if (i3 != -1)
        {
            linearlayoutmanager = linearlayoutmanager.c(i3);
            android.support.v7.widget.RecyclerView.i l1 = (android.support.v7.widget.RecyclerView.i)linearlayoutmanager.getLayoutParams();
            j2 = linearlayoutmanager.getBottom() + l1.bottomMargin;
            i2 = linearlayoutmanager.getTop() - l1.topMargin;
        } else
        {
            j2 = 0;
        }
        return (new com.target.ui.fragment.product.plp.presenter.a.a()).b(k2).a(j1.e()).a(i1).c(l2).d(j2).e(i3).f(i2).g(k1).a();
    }

    static com.target.ui.fragment.product.plp.presenter.a a(ProductSummaryPageFragment productsummarypagefragment, LinearLayoutManager linearlayoutmanager, j j1, int i1, int k1)
    {
        return productsummarypagefragment.a(linearlayoutmanager, j1, i1, k1);
    }

    static s b(ProductSummaryPageFragment productsummarypagefragment)
    {
        return productsummarypagefragment.mGridLayoutManager;
    }

    static j c(ProductSummaryPageFragment productsummarypagefragment)
    {
        return productsummarypagefragment.mGridRefineHeaderSpacerDecoration;
    }

    static ProductSummaryPagePresenter d(ProductSummaryPageFragment productsummarypagefragment)
    {
        return productsummarypagefragment.mPresenter;
    }

    static LinearLayoutManager e(ProductSummaryPageFragment productsummarypagefragment)
    {
        return productsummarypagefragment.mListLayoutManager;
    }

    static j f(ProductSummaryPageFragment productsummarypagefragment)
    {
        return productsummarypagefragment.mListRefineHeaderSpacerDecoration;
    }

    static com.target.ui.view.common.h g(ProductSummaryPageFragment productsummarypagefragment)
    {
        return productsummarypagefragment.mSnackBar;
    }

    static com.target.ui.adapter.product.e h(ProductSummaryPageFragment productsummarypagefragment)
    {
        return productsummarypagefragment.mGridViewAdapter;
    }

    private void i(boolean flag)
    {
        if (!mGridViewAdapter.n())
        {
            mGridViewAdapter.b(flag);
        }
        if (mGridRefineHeaderSpacerDecoration.f())
        {
            mGridRefineHeaderSpacerDecoration.c(false);
            mViews.mGridRecyclerView.o();
        }
    }

    private void j(boolean flag)
    {
        if (!mGridViewAdapter.m())
        {
            mGridViewAdapter.b(flag);
        }
        if (mGridRefineHeaderSpacerDecoration.f() != flag)
        {
            mGridRefineHeaderSpacerDecoration.c(flag);
            mViews.mGridRecyclerView.o();
        }
    }

    private void k(boolean flag)
    {
        if (!mListViewAdapter.m())
        {
            mListViewAdapter.b(flag);
        }
        if (mListRefineHeaderSpacerDecoration.f() != flag)
        {
            mListRefineHeaderSpacerDecoration.c(flag);
            mViews.mListRecyclerView.o();
        }
    }

    private void s()
    {
        t();
        v();
        w();
        x();
    }

    private void t()
    {
        u();
        mGridLayoutManager = new s(getActivity(), 3);
        mGridLayoutManager.a(new e());
        mViews.mGridRecyclerView.setLayoutManager(mGridLayoutManager);
        mViews.mGridRecyclerView.setHasFixedSize(true);
        mViews.mGridRecyclerView.setAdapter(mGridViewAdapter);
        mGridRefineHeaderSpacerDecoration = new j(getActivity(), 3);
        mGridRefineHeaderSpacerDecoration.a(new e());
        mViews.mGridRecyclerView.a(mGridRefineHeaderSpacerDecoration);
    }

    private void u()
    {
        mGridViewAdapter = com.target.ui.j.a.a(mCompositeProductsForGridView);
    }

    private void v()
    {
        mListViewAdapter = new com.target.ui.adapter.product.f(mCompositeProductsForListView);
        mListLayoutManager = new LinearLayoutManager(getActivity());
        mListLayoutManager.b(1);
        mViews.mListRecyclerView.a(new com.target.ui.util.k(getActivity(), 1));
        mViews.mListRecyclerView.setHasFixedSize(true);
        mViews.mListRecyclerView.setLayoutManager(mListLayoutManager);
        mViews.mListRecyclerView.setAdapter(mListViewAdapter);
        mListRefineHeaderSpacerDecoration = new j(getActivity(), 1);
        mViews.mListRecyclerView.a(mListRefineHeaderSpacerDecoration);
    }

    private void w()
    {
        mViews.refineHeaderView.setOnItemClickListener(new com.target.ui.view.product.PlpRefineHeaderView.a() {

            final ProductSummaryPageFragment this$0;

            public void a()
            {
                com.target.ui.fragment.product.plp.ProductSummaryPageFragment.d(ProductSummaryPageFragment.this).f();
            }

            public void a(ProductEntry productentry)
            {
                com.target.ui.fragment.product.plp.ProductSummaryPageFragment.d(ProductSummaryPageFragment.this).a(productentry);
            }

            
            {
                this$0 = ProductSummaryPageFragment.this;
                super();
            }
        });
    }

    private void x()
    {
        mSnackBar.a(mViews.refineFloatingActionButton);
    }

    private void y()
    {
        mViews.errorContainer.setClickListener(new c());
        mListViewAdapter.a(new h());
        mGridViewAdapter.a(new g());
        mViews.refineFloatingActionButton.setOnClickListener(new i());
        if (mProductSummaryPagePresenterRequestParam.k())
        {
            return;
        } else
        {
            z();
            return;
        }
    }

    private void z()
    {
        mViews.mListRecyclerView.setOnScrollListener(new f());
        mViews.mGridRecyclerView.setOnScrollListener(new d());
    }

    protected boolean X()
    {
        return true;
    }

    public void a()
    {
        com.target.ui.f.c.f(this);
    }

    public void a(float f1)
    {
        mViews.mockActionBarDropShadow.setStrength(f1);
    }

    public void a(int i1)
    {
        mViews.refineHeaderView.a(i1);
    }

    public void a(final int eventType, final int scrollDeltaY)
    {
        if (eventType == 1)
        {
            (new Handler(Looper.getMainLooper())).post(new Runnable() {

                final ProductSummaryPageFragment this$0;
                final int val$eventType;
                final int val$scrollDeltaY;

                public void run()
                {
                    if (com.target.ui.fragment.product.plp.ProductSummaryPageFragment.a(ProductSummaryPageFragment.this) == null)
                    {
                        return;
                    } else
                    {
                        com.target.ui.fragment.product.plp.ProductSummaryPageFragment.d(ProductSummaryPageFragment.this).a(com.target.ui.fragment.product.plp.ProductSummaryPageFragment.a(ProductSummaryPageFragment.this, com.target.ui.fragment.product.plp.ProductSummaryPageFragment.b(ProductSummaryPageFragment.this), com.target.ui.fragment.product.plp.ProductSummaryPageFragment.c(ProductSummaryPageFragment.this), eventType, scrollDeltaY));
                        return;
                    }
                }

            
            {
                this$0 = ProductSummaryPageFragment.this;
                eventType = i1;
                scrollDeltaY = j1;
                super();
            }
            });
            return;
        } else
        {
            mPresenter.a(a(((LinearLayoutManager) (mGridLayoutManager)), mGridRefineHeaderSpacerDecoration, eventType, scrollDeltaY));
            return;
        }
    }

    public void a(int i1, int j1, boolean flag, boolean flag1)
    {
        mGridViewAdapter.a(new ProductErrorHeaderOptions(getString(i1), getString(j1), flag, flag1));
        i(true);
    }

    public void a(int i1, List list)
    {
        mViews.refineHeaderView.setData(new com.target.ui.view.product.PlpRefineHeaderView.b(i1, list));
        boolean flag = list.isEmpty();
        if (mGridRefineHeaderSpacerDecoration.g() != flag)
        {
            mGridRefineHeaderSpacerDecoration.b(flag);
            mViews.mGridRecyclerView.o();
        }
        if (mListRefineHeaderSpacerDecoration.g() != flag)
        {
            mListRefineHeaderSpacerDecoration.b(flag);
            mViews.mListRecyclerView.o();
        }
    }

    public void a(Uri uri, Store store)
    {
        if (!Z())
        {
            if ((uri = (Fragment)com.target.ui.util.deep_link.g.a(uri, store).d().d()) != null)
            {
                m().d(uri);
                return;
            }
        }
    }

    public void a(Menu menu, MenuInflater menuinflater, int i1)
    {
        menuinflater.inflate(i1, menu);
    }

    public void a(MenuItem menuitem, boolean flag)
    {
        menuitem.setVisible(flag);
    }

    public void a(ProductSummaryParam productsummaryparam, ArrayList arraylist)
    {
        mPresenter.a(productsummaryparam, arraylist);
    }

    public void a(PageItem pageitem, List list, PageItemHierarchy pageitemhierarchy, Store store)
    {
        if (Z())
        {
            return;
        }
        pageitem = com.target.ui.util.y.a(pageitem, store, list, pageitemhierarchy);
        if (pageitem == null)
        {
            com.target.ui.util.q.a(TAG, "Unable to navigate to sibling category");
            return;
        } else
        {
            m().d(pageitem);
            return;
        }
    }

    public void a(ProductDetails productdetails, Store store)
    {
        if (Z())
        {
            return;
        } else
        {
            mNavigateToMapDelegate.a(productdetails, store);
            return;
        }
    }

    public void a(ProductDetails productdetails, PageItemHierarchy pageitemhierarchy)
    {
        com.target.ui.analytics.a.l.a(productdetails, pageitemhierarchy, 4).e();
    }

    public void a(ProductDetails productdetails, com.target.ui.helper.product.b b1, Store store, com.target.mothership.common.a.g g1)
    {
        mAddToCartDelegate.a(productdetails, b1, store, g1);
    }

    public void a(ProductSummary productsummary, long l1)
    {
        com.target.ui.analytics.b.k.a(productsummary, l1).a();
    }

    public void a(ProductSummary productsummary, ProductSummaryParam productsummaryparam, long l1)
    {
        com.target.ui.analytics.b.k.a(productsummary, productsummaryparam, l1).a();
    }

    public void a(ProductSummary productsummary, ProductSummaryParam productsummaryparam, PageItemHierarchy pageitemhierarchy, long l1)
    {
        com.target.ui.analytics.b.k.a(productsummary, productsummaryparam, pageitemhierarchy, l1).a();
    }

    public void a(com.target.ui.analytics.a.ah.a a1)
    {
        ah.a(a1).e();
    }

    public void a(com.target.ui.c.d.d d1)
    {
        if (Z())
        {
            return;
        } else
        {
            mNavigateToPdpDelegate.a(d1);
            return;
        }
    }

    public void a(ProductHeaderOptions productheaderoptions)
    {
        mGridViewAdapter.a(productheaderoptions);
        j(true);
    }

    public void a(PageItemHierarchy pageitemhierarchy)
    {
        getArguments().putParcelable("pageItemHierarchyArg", pageitemhierarchy);
    }

    public void a(ProductRefineModel productrefinemodel, ProductSummaryParam productsummaryparam)
    {
        if (Z())
        {
            return;
        } else
        {
            productrefinemodel = ProductSummaryRefineFragment.a(productrefinemodel, productsummaryparam, this);
            m().a(productrefinemodel, com.target.ui.f.c.a.SLIDE_BOTTOM);
            return;
        }
    }

    protected void a(ToolbarSpinner toolbarspinner)
    {
        mPresenter.a(toolbarspinner);
    }

    public void a(ToolbarSpinner toolbarspinner, List list, PageItemHierarchy pageitemhierarchy)
    {
        ArrayList arraylist = new ArrayList();
        for (Iterator iterator = list.iterator(); iterator.hasNext(); arraylist.add(com.target.ui.util.y.a((PageItem)iterator.next()))) { }
        toolbarspinner.setItems(arraylist);
        toolbarspinner.setSelectedItem(com.target.ui.util.y.a(list, pageitemhierarchy.a()));
        toolbarspinner.setListener(new k());
    }

    public void a(String s1)
    {
        j(s1);
    }

    public void a(String s1, Store store)
    {
        if (Z())
        {
            return;
        } else
        {
            mNavigateToMapDelegate.a(s1, store);
            return;
        }
    }

    public void a(List list)
    {
        if (list == null)
        {
            return;
        } else
        {
            getArguments().putParcelableArrayList("pageItemsListArg", new ArrayList(list));
            return;
        }
    }

    public void a(boolean flag)
    {
        al.a(mViews.refineHeaderView, flag);
        if (mGridRefineHeaderSpacerDecoration.e() != flag)
        {
            mGridRefineHeaderSpacerDecoration.a(flag);
            mViews.mGridRecyclerView.o();
        }
        if (mListRefineHeaderSpacerDecoration.e() != flag)
        {
            mListRefineHeaderSpacerDecoration.a(flag);
            mViews.mListRecyclerView.o();
        }
    }

    protected boolean aa()
    {
        return mPresenter.e();
    }

    public void b()
    {
        al.a(mViews.progressContainer, new View[] {
            mViews.contentContainer, mViews.errorContainer
        });
    }

    public void b(float f1)
    {
        mViews.refineHeaderView.setDropShadowStrength(f1);
    }

    public void b(final int eventType, final int scrollDeltaY)
    {
        if (eventType == 1)
        {
            (new Handler(Looper.getMainLooper())).post(new Runnable() {

                final ProductSummaryPageFragment this$0;
                final int val$eventType;
                final int val$scrollDeltaY;

                public void run()
                {
                    if (com.target.ui.fragment.product.plp.ProductSummaryPageFragment.a(ProductSummaryPageFragment.this) == null)
                    {
                        return;
                    } else
                    {
                        com.target.ui.fragment.product.plp.ProductSummaryPageFragment.d(ProductSummaryPageFragment.this).a(com.target.ui.fragment.product.plp.ProductSummaryPageFragment.a(ProductSummaryPageFragment.this, com.target.ui.fragment.product.plp.ProductSummaryPageFragment.e(ProductSummaryPageFragment.this), com.target.ui.fragment.product.plp.ProductSummaryPageFragment.f(ProductSummaryPageFragment.this), eventType, scrollDeltaY));
                        return;
                    }
                }

            
            {
                this$0 = ProductSummaryPageFragment.this;
                eventType = i1;
                scrollDeltaY = j1;
                super();
            }
            });
            return;
        } else
        {
            mPresenter.a(a(mListLayoutManager, mListRefineHeaderSpacerDecoration, eventType, scrollDeltaY));
            return;
        }
    }

    public void b(ProductHeaderOptions productheaderoptions)
    {
        mListViewAdapter.a(productheaderoptions);
        k(true);
    }

    public void b(String s1)
    {
        al.b(mViews.plpBannerImageView);
        com.target.ui.adapter.b.c.a(getActivity(), s1, mViews.plpBannerImageView);
    }

    public void b(List list)
    {
        mCompositeProductsForListView = list;
        mListViewAdapter.a(mCompositeProductsForListView);
    }

    public void c()
    {
        al.a(mViews.contentContainer, new View[] {
            mViews.progressContainer, mViews.errorContainer
        });
    }

    public void c(float f1)
    {
        mViews.refineHeaderView.setTranslationY(f1);
    }

    public void c(List list)
    {
        mCompositeProductsForGridView = list;
        mGridViewAdapter.a(mCompositeProductsForGridView);
    }

    public void c(boolean flag)
    {
        mListViewAdapter.d(flag);
    }

    public void d()
    {
        al.a(mViews.contentContainer, new View[] {
            mViews.progressContainer, mViews.errorContainer
        });
        al.a(mViews.mGridRecyclerView, new View[] {
            mViews.mListRecyclerView
        });
    }

    public void d(boolean flag)
    {
        mGridViewAdapter.d(flag);
    }

    public void e()
    {
        mViews.errorContainer.a(com.target.ui.view.common.b.a.ERROR_NO_NETWORK, true);
        al.a(mViews.errorContainer, new View[] {
            mViews.progressContainer, mViews.contentContainer
        });
    }

    public void e(boolean flag)
    {
        mListViewAdapter.c(flag);
    }

    public void f()
    {
        if (getActivity() == null)
        {
            return;
        } else
        {
            getActivity().d();
            return;
        }
    }

    public void f(boolean flag)
    {
        mGridViewAdapter.c(flag);
    }

    public void g()
    {
        al.c(mViews.plpBannerImageView);
    }

    public void g(boolean flag)
    {
        mViews.refineHeaderView.a(flag);
    }

    public void h()
    {
        if (Z())
        {
            return;
        } else
        {
            S();
            return;
        }
    }

    public void h(boolean flag)
    {
        n(flag);
    }

    public void i()
    {
        i(false);
    }

    public void j()
    {
        j(false);
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

    public void o()
    {
        k(false);
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        a(new com.target.ui.c.a[] {
            mNavigateToMapDelegate, mNavigateToPdpDelegate, mAddToCartDelegate, mAddToListDelegate
        });
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (bundle != null)
        {
            mSavedState = bundle.getParcelable("pdpPresenterSavedStateArg");
        }
        mProductSummaryPagePresenterRequestParam = a(F());
        mPresenter = new ProductSummaryPagePresenter(new com.target.ui.helper.product.e(new com.target.ui.helper.product.g(), new com.target.ui.helper.g.a()), new com.target.ui.service.provider.e(), new com.target.ui.service.provider.k(), mProductSummaryPagePresenterRequestParam, (Guest)com.target.ui.service.a.a().c().d(), (RelevantStoreSummary)com.target.ui.service.k.a().c().d(), mSavedState);
        mSnackBar = new com.target.ui.view.common.h(getActivity());
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuinflater)
    {
        if (!isAdded())
        {
            return;
        } else
        {
            mPresenter.a(menu, menuinflater);
            super.onCreateOptionsMenu(menu, menuinflater);
            return;
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f030071, viewgroup, false);
        mViews = new Views(layoutinflater);
        s();
        mPresenter.a(this);
        y();
        return layoutinflater;
    }

    public void onDestroy()
    {
        super.onDestroy();
        mPresenter.v_();
        mSnackBar = null;
        mPresenter = null;
        mSavedState = null;
        mGridLayoutManager = null;
        mListLayoutManager = null;
        mGridViewAdapter = null;
        mListViewAdapter = null;
        mCompositeProductsForListView = null;
        mCompositeProductsForGridView = null;
        mProductSummaryPagePresenterRequestParam = null;
    }

    public void onDestroyView()
    {
        super.onDestroyView();
        A();
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
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        return mPresenter.a(menuitem) || super.onOptionsItemSelected(menuitem);
    }

    public void onPrepareOptionsMenu(Menu menu)
    {
        super.onPrepareOptionsMenu(menu);
        mPresenter.a(menu);
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        bundle.putParcelable("pdpPresenterSavedStateArg", mPresenter.g());
        super.onSaveInstanceState(bundle);
    }

    public void p()
    {
        al.a(mViews.mGridRecyclerView, new View[] {
            mViews.mListRecyclerView
        });
    }

    public void q()
    {
        al.a(mViews.mListRecyclerView, new View[] {
            mViews.mGridRecyclerView
        });
    }

    public void r()
    {
        mViews.refineHeaderView.a();
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

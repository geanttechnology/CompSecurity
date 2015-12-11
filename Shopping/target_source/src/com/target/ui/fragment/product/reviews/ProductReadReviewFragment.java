// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.product.reviews;

import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;
import com.target.mothership.model.product.interfaces.Product;
import com.target.ui.adapter.review.ProductReviewAdapter;
import com.target.ui.analytics.a.ba;
import com.target.ui.analytics.h;
import com.target.ui.fragment.product.common.BaseProductReviewFragment;
import com.target.ui.helper.n.a;
import com.target.ui.util.al;
import com.target.ui.view.common.b;
import com.target.ui.view.product.PlpGridFooterView;
import com.target.ui.view.review.ProductReviewHeaderView;
import java.util.ArrayList;
import java.util.List;

public class ProductReadReviewFragment extends BaseProductReviewFragment
{
    static class Views extends com.target.ui.view.a
    {

        com.target.ui.view.common.b errorContainer;
        final PlpGridFooterView footerView;
        final ProductReviewHeaderView headerView;
        ListView listView;

        Views(Context context, View view)
        {
            super(view);
            headerView = new ProductReviewHeaderView(context);
            footerView = new PlpGridFooterView(context);
        }
    }

    private class a
        implements com.target.ui.view.common.c
    {

        final ProductReadReviewFragment this$0;

        public void A_()
        {
            if (com.target.ui.fragment.product.reviews.ProductReadReviewFragment.a(ProductReadReviewFragment.this) == null)
            {
                return;
            } else
            {
                ProductReadReviewFragment.d(ProductReadReviewFragment.this);
                return;
            }
        }

        private a()
        {
            this$0 = ProductReadReviewFragment.this;
            super();
        }

    }

    private class b
        implements com.target.ui.view.product.PlpFooterView.a
    {

        final ProductReadReviewFragment this$0;

        public void a()
        {
            if (com.target.ui.fragment.product.reviews.ProductReadReviewFragment.a(ProductReadReviewFragment.this) == null)
            {
                return;
            } else
            {
                com.target.ui.fragment.product.reviews.ProductReadReviewFragment.a(ProductReadReviewFragment.this).footerView.a(false);
                ProductReadReviewFragment.e(ProductReadReviewFragment.this);
                return;
            }
        }

        private b()
        {
            this$0 = ProductReadReviewFragment.this;
            super();
        }

    }

    private class c
        implements android.widget.AbsListView.OnScrollListener
    {

        final ProductReadReviewFragment this$0;

        public void onScroll(AbsListView abslistview, int i, int j, int k)
        {
            if (!com.target.ui.fragment.product.reviews.ProductReadReviewFragment.a(ProductReadReviewFragment.this, i, j, k)) goto _L2; else goto _L1
_L1:
            if (!com.target.ui.fragment.product.reviews.ProductReadReviewFragment.a(ProductReadReviewFragment.this).footerView.c()) goto _L4; else goto _L3
_L3:
            return;
_L4:
            com.target.ui.fragment.product.reviews.ProductReadReviewFragment.b(ProductReadReviewFragment.this);
            com.target.ui.fragment.product.reviews.ProductReadReviewFragment.a(ProductReadReviewFragment.this).footerView.a();
            return;
_L2:
            if (!ProductReadReviewFragment.c(ProductReadReviewFragment.this))
            {
                com.target.ui.fragment.product.reviews.ProductReadReviewFragment.a(ProductReadReviewFragment.this).footerView.b();
                return;
            }
            if (true) goto _L3; else goto _L5
_L5:
        }

        public void onScrollStateChanged(AbsListView abslistview, int i)
        {
        }

        private c()
        {
            this$0 = ProductReadReviewFragment.this;
            super();
        }

    }


    private static final String PRODUCT_ARG = "productArg";
    public static final String TAG = com/target/ui/fragment/product/reviews/ProductReadReviewFragment.getSimpleName();
    private h mLoadingTimestamp;
    private ProductReviewAdapter mProductReviewAdapter;
    private List mProductReviewList;
    private boolean mRequestSecondaryReviewData;
    private Views mViews;

    public ProductReadReviewFragment()
    {
        mLoadingTimestamp = new h();
    }

    static Views a(ProductReadReviewFragment productreadreviewfragment)
    {
        return productreadreviewfragment.mViews;
    }

    public static ProductReadReviewFragment a(Product product)
    {
        ProductReadReviewFragment productreadreviewfragment = new ProductReadReviewFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("productArg", product);
        productreadreviewfragment.setArguments(bundle);
        return productreadreviewfragment;
    }

    private void a(long l)
    {
        ba.a(l, this).e();
    }

    private boolean a(int i, int j, int k)
    {
        boolean flag1 = true;
        if (n())
        {
            boolean flag;
            if (k - (mViews.listView.getHeaderViewsCount() + mViews.listView.getFooterViewsCount()) < p())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (j > 0 && flag)
            {
                if (i + j >= k - o() / 2)
                {
                    i = 1;
                } else
                {
                    i = 0;
                }
                if (i == 0 || j().b())
                {
                    flag1 = false;
                }
                return flag1;
            }
        }
        return false;
    }

    static boolean a(ProductReadReviewFragment productreadreviewfragment, int i, int j, int k)
    {
        return productreadreviewfragment.a(i, j, k);
    }

    static void b(ProductReadReviewFragment productreadreviewfragment)
    {
        productreadreviewfragment.l();
    }

    private void c(List list)
    {
        if (list != null && !list.isEmpty())
        {
            mViews.headerView.setData(list);
            al.b(mViews.headerView);
            return;
        } else
        {
            mViews.listView.removeHeaderView(mViews.headerView);
            return;
        }
    }

    static boolean c(ProductReadReviewFragment productreadreviewfragment)
    {
        return productreadreviewfragment.n();
    }

    static void d(ProductReadReviewFragment productreadreviewfragment)
    {
        productreadreviewfragment.w();
    }

    static void e(ProductReadReviewFragment productreadreviewfragment)
    {
        productreadreviewfragment.l();
    }

    private void v()
    {
        mViews.listView.addHeaderView(mViews.headerView);
        mViews.listView.addFooterView(mViews.footerView);
        mProductReviewAdapter = new ProductReviewAdapter(getActivity(), new ArrayList());
        mViews.listView.setAdapter(mProductReviewAdapter);
        mViews.errorContainer.a("", getString(0x7f0902fa), true);
    }

    private void w()
    {
        mLoadingTimestamp = new h();
        if (mProductReviewList != null && !mProductReviewList.isEmpty())
        {
            x();
            return;
        } else
        {
            g();
            k();
            return;
        }
    }

    private void x()
    {
        mProductReviewAdapter.a(mProductReviewList);
        i();
    }

    private void y()
    {
        if (mViews == null)
        {
            return;
        } else
        {
            mViews.listView.setOnScrollListener(new c());
            mViews.errorContainer.setClickListener(new a());
            mViews.footerView.setClickListener(new b());
            return;
        }
    }

    private void z()
    {
        if (mViews == null)
        {
            return;
        } else
        {
            mViews.listView.setOnScrollListener(null);
            mViews.errorContainer.setClickListener(null);
            mViews.footerView.setClickListener(null);
            return;
        }
    }

    protected Product a()
    {
        return (Product)getArguments().getParcelable("productArg");
    }

    public void a(View view)
    {
        mViews = new Views(getActivity(), view);
        v();
        y();
    }

    protected void a(List list)
    {
        if (mViews == null)
        {
            return;
        }
        if (mProductReviewList == null)
        {
            mProductReviewList = list;
            x();
        } else
        {
            mProductReviewList.addAll(list);
            mProductReviewAdapter.a(mProductReviewList);
        }
        mViews.footerView.b();
        a(a(mLoadingTimestamp));
    }

    public void b()
    {
        if (mViews == null)
        {
            return;
        } else
        {
            mViews.footerView.a(true);
            return;
        }
    }

    protected void b(List list)
    {
        if (mViews == null)
        {
            return;
        } else
        {
            mRequestSecondaryReviewData = false;
            c(list);
            return;
        }
    }

    protected void c()
    {
        if (mViews == null)
        {
            return;
        } else
        {
            mViews.errorContainer.a(com.target.ui.view.common.b.a.ERROR_NO_NETWORK, true);
            h();
            return;
        }
    }

    protected boolean d()
    {
        return mRequestSecondaryReviewData;
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuinflater)
    {
        if (!isAdded())
        {
            return;
        } else
        {
            super.onCreateOptionsMenu(menu, menuinflater);
            j(getString(0x7f09047f));
            return;
        }
    }

    public void onDestroy()
    {
        super.onDestroy();
        mProductReviewList = null;
    }

    public void onDestroyView()
    {
        super.onDestroyView();
        z();
        mViews = null;
    }

    public void onResume()
    {
        super.onResume();
        if (mProductReviewList != null)
        {
            a(0L);
        }
    }

    public int q()
    {
        return 0x7f030074;
    }

    public int r()
    {
        return 0x7f1001d8;
    }

    public int s()
    {
        return 0x7f1001d6;
    }

    public int t()
    {
        return 0x7f1001d7;
    }

    public void u()
    {
        mRequestSecondaryReviewData = true;
        w();
    }

}

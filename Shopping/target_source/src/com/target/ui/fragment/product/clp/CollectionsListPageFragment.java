// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.product.clp;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.f;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import com.target.mothership.common.product.ProductIdentifier;
import com.target.mothership.model.list.interfaces.ListSummary;
import com.target.mothership.model.product.interfaces.Product;
import com.target.mothership.model.product.interfaces.ProductDetails;
import com.target.mothership.model.product.interfaces.ProductPromotion;
import com.target.mothership.model.store.interfaces.Store;
import com.target.ui.adapter.product.ProductListItemAdapter;
import com.target.ui.c.a.b;
import com.target.ui.c.d.d;
import com.target.ui.f.c;
import com.target.ui.fragment.common.BaseNavigationFragment;
import com.target.ui.fragment.product.clp.a.a;
import com.target.ui.fragment.product.clp.presenter.CollectionListPagePresenter;
import com.target.ui.fragment.product.common.PageItemHierarchy;
import com.target.ui.fragment.product.pdp.ProductPromotionPageFragment;
import com.target.ui.helper.product.g;
import com.target.ui.service.provider.e;
import com.target.ui.util.ad;
import com.target.ui.util.aj;
import com.target.ui.util.al;
import com.target.ui.util.n;
import com.target.ui.view.BitmapImageView;
import com.target.ui.view.common.TargetErrorView;
import com.target.ui.view.common.h;
import com.target.ui.view.product.ProductCollectionHeaderView;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class CollectionsListPageFragment extends BaseNavigationFragment
    implements com.target.ui.fragment.account.BaseAccountDialog.f, com.target.ui.fragment.product.clp.a.a, com.target.ui.fragment.product.dialog.BaseProductDialogFragment.b, com.target.ui.fragment.product.dialog.ProductAddToCartErrorDialog.c, com.target.ui.fragment.product.dialog.ProductAddToListDialogFragment.c
{
    static class Views extends com.target.ui.view.a
    {

        View contentContainer;
        TargetErrorView errorContainer;
        final ProductCollectionHeaderView productClpHeader;
        ListView productListView;
        View progressContainer;

        Views(Context context, View view)
        {
            super(view);
            productClpHeader = new ProductCollectionHeaderView(context);
        }
    }

    private class a extends com.target.ui.c.a.e
    {

        final CollectionsListPageFragment this$0;

        public void a(String s1)
        {
            com.target.ui.fragment.product.clp.CollectionsListPageFragment.a(CollectionsListPageFragment.this).c(s1);
        }

        private a()
        {
            this$0 = CollectionsListPageFragment.this;
            super();
        }

    }

    private class b extends com.target.ui.c.b.e
    {

        final CollectionsListPageFragment this$0;

        public void a(String s1)
        {
            com.target.ui.fragment.product.clp.CollectionsListPageFragment.a(CollectionsListPageFragment.this).c(s1);
        }

        public void a(String s1, ListSummary listsummary)
        {
            ad.a(getActivity(), s1, com.target.ui.fragment.product.clp.CollectionsListPageFragment.a(CollectionsListPageFragment.this), listsummary, m());
        }

        private b()
        {
            this$0 = CollectionsListPageFragment.this;
            super();
        }

    }

    private class c
        implements com.target.ui.view.product.ProductCollectionHeaderView.b
    {

        final CollectionsListPageFragment this$0;

        public void a()
        {
            com.target.ui.fragment.product.clp.CollectionsListPageFragment.b(CollectionsListPageFragment.this).c();
        }

        public void a(ProductPromotion productpromotion)
        {
            com.target.ui.fragment.product.clp.CollectionsListPageFragment.b(CollectionsListPageFragment.this).a(productpromotion);
        }

        public void b()
        {
            com.target.ui.fragment.product.clp.CollectionsListPageFragment.b(CollectionsListPageFragment.this).d();
        }

        private c()
        {
            this$0 = CollectionsListPageFragment.this;
            super();
        }

    }

    private class d
        implements com.target.ui.view.common.c
    {

        final CollectionsListPageFragment this$0;

        public void A_()
        {
            com.target.ui.fragment.product.clp.CollectionsListPageFragment.b(CollectionsListPageFragment.this).c();
        }

        private d()
        {
            this$0 = CollectionsListPageFragment.this;
            super();
        }

    }

    private class e
        implements android.widget.AdapterView.OnItemClickListener
    {

        final CollectionsListPageFragment this$0;

        public void onItemClick(AdapterView adapterview, View view, int i1, long l1)
        {
            adapterview = (ProductDetails)adapterview.getItemAtPosition(i1);
            view = (BitmapImageView)view.findViewById(0x7f1004fd);
            com.target.ui.fragment.product.clp.CollectionsListPageFragment.b(CollectionsListPageFragment.this).a(adapterview, view);
        }

        private e()
        {
            this$0 = CollectionsListPageFragment.this;
            super();
        }

    }

    private class f
        implements com.target.ui.adapter.product.ProductListItemAdapter.b
    {

        final CollectionsListPageFragment this$0;

        public void a(ProductDetails productdetails)
        {
            com.target.ui.fragment.product.clp.CollectionsListPageFragment.b(CollectionsListPageFragment.this).a(productdetails);
        }

        public void b(ProductDetails productdetails)
        {
            com.target.ui.fragment.product.clp.CollectionsListPageFragment.b(CollectionsListPageFragment.this).a(productdetails, com.target.ui.helper.product.b.PICK_UP);
        }

        public void c(ProductDetails productdetails)
        {
            com.target.ui.fragment.product.clp.CollectionsListPageFragment.b(CollectionsListPageFragment.this).a(productdetails, com.target.ui.helper.product.b.SHIP);
        }

        private f()
        {
            this$0 = CollectionsListPageFragment.this;
            super();
        }

    }


    private static final String ARG_CATEGORY_HIERARCHY = "clpCategoryHierarchyArg";
    private static final String ARG_PRODUCT = "clpProductArg";
    private static final String ARG_PRODUCT_IDENTIFIER = "clpProductIdentifierArg";
    private static final String ARG_SAVED_STATE_PRESENTER = "clpPresenterSavedStateArg";
    private static final String ARG_STORE = "clpStoreArg";
    private static final String ARG_THUMBNAIL = "clpThumbnailArg";
    private static final String ARG_THUMBNAIL_URL = "clpThumbnailUrlArg";
    private static final String ARG_TRANSITION_TAG = "clpTransitionTagArg";
    private static final String ARG_VIEW_TYPE = "clpViewTypeArg";
    public static final int CAROUSEL = 2;
    public static final int DEFAULT = 3;
    public static final int FULL = 1;
    public static final String TAG = com/target/ui/fragment/product/clp/CollectionsListPageFragment.getSimpleName();
    private static final String TRANSITION_TAG = "collection_transition_tag";
    private com.target.ui.c.a.b mAddToCartDelegate;
    private com.target.ui.c.b.b mAddToListDelegate;
    private ProductListItemAdapter mListViewAdapter;
    private com.target.ui.c.c.a mNavigateToMapDelegate;
    private com.target.ui.c.d.a mNavigateToPdpDelegate;
    private CollectionListPagePresenter mPresenter;
    private List mProductSummaryList;
    private Parcelable mSavedDataFromHeader;
    private Parcelable mSavedState;
    private h mSnackBar;
    private Views mViews;

    public CollectionsListPageFragment()
    {
        mAddToCartDelegate = new com.target.ui.c.a.b(this, new a());
        mAddToListDelegate = new com.target.ui.c.b.b(this, new b());
        mNavigateToMapDelegate = new com.target.ui.c.c.a(this);
        mNavigateToPdpDelegate = new com.target.ui.c.d.a(this);
        mProductSummaryList = new ArrayList();
    }

    public static CollectionsListPageFragment a(ProductIdentifier productidentifier, int i1, Store store)
    {
        CollectionsListPageFragment collectionslistpagefragment = new CollectionsListPageFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("clpStoreArg", store);
        bundle.putInt("clpViewTypeArg", i1);
        bundle.putParcelable("clpProductIdentifierArg", productidentifier);
        collectionslistpagefragment.setArguments(bundle);
        return collectionslistpagefragment;
    }

    public static CollectionsListPageFragment a(Product product, PageItemHierarchy pageitemhierarchy, Store store)
    {
        CollectionsListPageFragment collectionslistpagefragment = new CollectionsListPageFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("clpStoreArg", store);
        bundle.putInt("clpViewTypeArg", 3);
        bundle.putParcelable("clpProductArg", product);
        bundle.putParcelable("clpCategoryHierarchyArg", pageitemhierarchy);
        collectionslistpagefragment.setArguments(bundle);
        return collectionslistpagefragment;
    }

    static h a(CollectionsListPageFragment collectionslistpagefragment)
    {
        return collectionslistpagefragment.mSnackBar;
    }

    private static void a(View view, boolean flag)
    {
        if (flag)
        {
            aj.f(view);
            return;
        } else
        {
            al.b(view);
            return;
        }
    }

    static CollectionListPagePresenter b(CollectionsListPageFragment collectionslistpagefragment)
    {
        return collectionslistpagefragment.mPresenter;
    }

    private void b(int i1, int j1, URL url)
    {
        Object obj = new StringBuilder();
        ((StringBuilder) (obj)).append(getString(i1));
        ((StringBuilder) (obj)).append(" ");
        ((StringBuilder) (obj)).append(url.toString());
        url = ((StringBuilder) (obj)).toString();
        obj = getString(i1);
        String s1 = getString(j1);
        com.target.ui.util.n.a(getActivity(), ((String) (obj)), url, s1);
    }

    private Store o()
    {
        return (Store)getArguments().getParcelable("clpStoreArg");
    }

    private Product p()
    {
        return (Product)getArguments().getParcelable("clpProductArg");
    }

    private ProductIdentifier q()
    {
        return (ProductIdentifier)getArguments().getParcelable("clpProductIdentifierArg");
    }

    private Bitmap r()
    {
        return (Bitmap)getArguments().getParcelable("clpThumbnailArg");
    }

    private String s()
    {
        return getArguments().getString("clpThumbnailUrlArg");
    }

    private com.target.ui.fragment.product.clp.presenter.a t()
    {
        com.target.ui.fragment.product.clp.presenter.a.a a1 = new com.target.ui.fragment.product.clp.presenter.a.a();
        a1.a(o());
        a1.a(p());
        a1.a(q());
        a1.a(r());
        a1.b(a());
        a1.a(s());
        return a1.a();
    }

    private void u()
    {
        mViews.productListView.addHeaderView(mViews.productClpHeader, null, false);
        mListViewAdapter = ProductListItemAdapter.a(getActivity(), mProductSummaryList);
        mViews.productListView.setAdapter(mListViewAdapter);
    }

    private void v()
    {
        mViews.productListView.setOnItemClickListener(new e());
        mViews.productClpHeader.setClickListener(new c());
        mListViewAdapter.a(new f());
        mViews.errorContainer.setClickListener(new d());
    }

    private void w()
    {
        if (mViews == null)
        {
            return;
        } else
        {
            mViews.productListView.setOnItemClickListener(null);
            mViews.productClpHeader.setClickListener(null);
            mListViewAdapter.a(null);
            mViews.errorContainer.setClickListener(null);
            return;
        }
    }

    public String a()
    {
        if (getArguments().getString("clpTransitionTagArg") == null)
        {
            getArguments().putString("clpTransitionTagArg", (new StringBuilder()).append("collection_transition_tag").append(String.valueOf(hashCode())).toString());
        }
        return getArguments().getString("clpTransitionTagArg");
    }

    public void a(int i1)
    {
        mViews.productClpHeader.setErrorData(getString(i1));
    }

    public void a(int i1, int j1, URL url)
    {
        b(i1, j1, url);
    }

    public void a(int i1, int j1, boolean flag)
    {
        mViews.errorContainer.a(getString(i1), getString(j1), true);
        al.a(mViews.errorContainer, new View[] {
            mViews.progressContainer, mViews.contentContainer
        });
    }

    public void a(Bitmap bitmap, String s1)
    {
        if (getArguments() == null)
        {
            return;
        } else
        {
            getArguments().putParcelable("clpThumbnailArg", bitmap);
            getArguments().putString("clpThumbnailUrlArg", s1);
            return;
        }
    }

    public void a(Bitmap bitmap, String s1, String s2)
    {
        mViews.productClpHeader.a(bitmap, s1, s2);
    }

    public void a(Parcelable parcelable)
    {
        mViews.productClpHeader.onRestoreInstanceState(parcelable);
    }

    public void a(Menu menu, MenuInflater menuinflater, int i1)
    {
        menuinflater.inflate(i1, menu);
    }

    public void a(MenuItem menuitem, boolean flag)
    {
        menuitem.setVisible(flag);
    }

    public void a(ProductDetails productdetails)
    {
        mAddToListDelegate.a(productdetails);
    }

    public void a(ProductDetails productdetails, Store store)
    {
        mNavigateToMapDelegate.a(productdetails, store);
    }

    public void a(ProductDetails productdetails, com.target.ui.helper.product.b b1, Store store, com.target.mothership.common.a.g g1)
    {
        mAddToCartDelegate.a(productdetails, b1, store, g1);
    }

    public void a(ProductPromotion productpromotion)
    {
        if (Z())
        {
            return;
        } else
        {
            m().d(ProductPromotionPageFragment.a(productpromotion));
            return;
        }
    }

    public void a(com.target.ui.c.d.d d1)
    {
        mNavigateToPdpDelegate.a(d1);
    }

    public void a(com.target.ui.common.d d1, boolean flag)
    {
        mViews.productClpHeader.a(d1, flag);
    }

    public void a(String s1)
    {
        j(s1);
    }

    public void a(List list, boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        mProductSummaryList.clear();
        mProductSummaryList.addAll(list);
        this;
        JVM INSTR monitorexit ;
        mListViewAdapter.notifyDataSetChanged();
        a(((View) (mViews.productListView)), flag);
        return;
        list;
        this;
        JVM INSTR monitorexit ;
        throw list;
    }

    public void b()
    {
        com.target.ui.f.c.f(this);
    }

    public void c()
    {
        mSnackBar.a();
    }

    public void d()
    {
        al.a(mViews.progressContainer, new View[] {
            mViews.contentContainer, mViews.errorContainer
        });
    }

    public void e()
    {
        mViews.productClpHeader.a();
    }

    public void f()
    {
        com.target.ui.view.common.b.a a1 = com.target.ui.view.common.b.a.ERROR_NO_NETWORK;
        mViews.errorContainer.a(a1, true);
        al.a(mViews.errorContainer, new View[] {
            mViews.contentContainer, mViews.progressContainer
        });
    }

    public void g()
    {
        com.target.ui.view.common.b.a a1 = com.target.ui.view.common.b.a.ERROR_NO_NETWORK;
        mViews.productClpHeader.setErrorData(a1);
    }

    public void h()
    {
        al.a(mViews.contentContainer, new View[] {
            mViews.progressContainer, mViews.errorContainer
        });
    }

    public void i()
    {
        mViews.productClpHeader.b();
    }

    public void j()
    {
        if (getActivity() == null)
        {
            return;
        } else
        {
            getActivity().invalidateOptionsMenu();
            return;
        }
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

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        a(new com.target.ui.c.a[] {
            mAddToCartDelegate, mAddToListDelegate, mNavigateToMapDelegate, mNavigateToPdpDelegate
        });
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (bundle != null)
        {
            mSavedState = bundle.getParcelable("clpPresenterSavedStateArg");
        }
        mPresenter = new CollectionListPagePresenter(new g(), new com.target.ui.service.provider.e(), t(), mSavedState);
        mSnackBar = new h(getActivity());
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
        layoutinflater = layoutinflater.inflate(0x7f030051, viewgroup, false);
        mViews = new Views(getActivity(), layoutinflater);
        u();
        mPresenter.a(this);
        v();
        return layoutinflater;
    }

    public void onDestroy()
    {
        super.onDestroy();
        mPresenter.v_();
        mSnackBar = null;
        mPresenter = null;
        mSavedState = null;
        mSavedDataFromHeader = null;
    }

    public void onDestroyView()
    {
        super.onDestroyView();
        w();
        mSavedDataFromHeader = mViews.productClpHeader.onSaveInstanceState();
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
        mPresenter.a(mSavedDataFromHeader);
        bundle.putParcelable("clpPresenterSavedStateArg", mPresenter.e());
        super.onSaveInstanceState(bundle);
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

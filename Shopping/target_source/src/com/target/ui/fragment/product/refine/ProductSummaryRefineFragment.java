// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.product.refine;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.h;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.google.a.a.e;
import com.target.mothership.common.params.ProductSummaryParam;
import com.target.mothership.model.product.interfaces.ProductEntry;
import com.target.ui.fragment.common.BaseNavigationFragment;
import com.target.ui.model.refine.ProductRefineModel;
import com.target.ui.model.refine.ProductSortModel;
import com.target.ui.util.aj;
import com.target.ui.util.al;
import com.target.ui.util.f.a;
import com.target.ui.util.z;
import com.target.ui.view.common.TargetBottomButton;
import com.target.ui.view.refine.RefineView;
import java.util.ArrayList;
import java.util.List;

public class ProductSummaryRefineFragment extends BaseNavigationFragment
{
    static class Views extends com.target.ui.view.a
    {

        RefineView refineView;
        TargetBottomButton resetDoneBtn;

        public Views(View view)
        {
            super(view);
        }
    }

    private class a
        implements com.target.ui.view.refine.RefineView.a
    {

        final ProductSummaryRefineFragment this$0;

        public void a(ProductEntry productentry)
        {
            com.target.ui.fragment.product.refine.ProductSummaryRefineFragment.a(ProductSummaryRefineFragment.this).resetDoneBtn.setLeftBtnEnable(true);
            ProductSummaryRefineFragment.f(ProductSummaryRefineFragment.this).add(productentry);
        }

        public void a(com.target.ui.model.refine.ProductSortModel.SortLabel sortlabel)
        {
            com.target.ui.fragment.product.refine.ProductSummaryRefineFragment.e(ProductSummaryRefineFragment.this).b().a(sortlabel);
            com.target.ui.fragment.product.refine.ProductSummaryRefineFragment.a(ProductSummaryRefineFragment.this).resetDoneBtn.setLeftBtnEnable(true);
        }

        public void b(ProductEntry productentry)
        {
            ProductSummaryRefineFragment.f(ProductSummaryRefineFragment.this).remove(productentry);
            if (ProductSummaryRefineFragment.f(ProductSummaryRefineFragment.this).isEmpty())
            {
                com.target.ui.fragment.product.refine.ProductSummaryRefineFragment.a(ProductSummaryRefineFragment.this).resetDoneBtn.setLeftBtnEnable(false);
            }
        }

        public void b(com.target.ui.model.refine.ProductSortModel.SortLabel sortlabel)
        {
            com.target.ui.fragment.product.refine.ProductSummaryRefineFragment.e(ProductSummaryRefineFragment.this).b().a(null);
            com.target.ui.fragment.product.refine.ProductSummaryRefineFragment.a(ProductSummaryRefineFragment.this).resetDoneBtn.setLeftBtnEnable(false);
        }

        private a()
        {
            this$0 = ProductSummaryRefineFragment.this;
            super();
        }

    }

    public static interface b
    {

        public abstract void a(ProductSummaryParam productsummaryparam, ArrayList arraylist);
    }

    private class c
        implements com.target.ui.view.common.TargetBottomButton.b
    {

        final ProductSummaryRefineFragment this$0;

        public void a()
        {
            ProductSummaryRefineFragment.c(ProductSummaryRefineFragment.this);
        }

        public void b()
        {
        }

        public void c()
        {
            ProductSummaryRefineFragment.d(ProductSummaryRefineFragment.this);
        }

        private c()
        {
            this$0 = ProductSummaryRefineFragment.this;
            super();
        }

    }


    private static final String PRODUCT_PARAM_ARG = "productParamArg";
    private static final String PRODUCT_REFINE_MODEL_ARG = "productRefineModelArg";
    public static final String TAG = com/target/ui/fragment/product/refine/ProductSummaryRefineFragment.getSimpleName();
    private com.target.ui.model.refine.ProductSortModel.SortLabel mPrevSelSortType;
    private ProductRefineModel mProductRefineModel;
    private ProductSummaryParam mProductSummaryParam;
    private b mSearchRefineListener;
    private ArrayList mSelectedFacet;
    private Views mViews;

    public ProductSummaryRefineFragment()
    {
        mSelectedFacet = new ArrayList();
    }

    private ProductSummaryParam a()
    {
        return mProductSummaryParam;
    }

    static Views a(ProductSummaryRefineFragment productsummaryrefinefragment)
    {
        return productsummaryrefinefragment.mViews;
    }

    public static ProductSummaryRefineFragment a(ProductRefineModel productrefinemodel, ProductSummaryParam productsummaryparam, b b1)
    {
        ProductSummaryRefineFragment productsummaryrefinefragment = new ProductSummaryRefineFragment();
        a(((Fragment) (productsummaryrefinefragment)), b1);
        b1 = new Bundle();
        b1.putParcelable("productParamArg", productsummaryparam);
        b1.putParcelable("productRefineModelArg", productrefinemodel);
        productsummaryrefinefragment.setArguments(b1);
        return productsummaryrefinefragment;
    }

    protected static void a(Fragment fragment, b b1)
        throws IllegalArgumentException
    {
        if (b1 == null)
        {
            throw new IllegalArgumentException("OnSearchRefineListener cannot be null");
        }
        if (!(b1 instanceof Fragment))
        {
            throw new IllegalArgumentException("Must implement OnSearchRefineListener");
        } else
        {
            fragment.setTargetFragment((Fragment)b1, 0);
            return;
        }
    }

    private void a(View view)
    {
        boolean flag1 = false;
        mViews = new Views(view);
        mSelectedFacet.clear();
        mSelectedFacet.addAll(b().f());
        mViews.resetDoneBtn.setTranslationY(0.0F);
        boolean flag2 = b().b().c().b();
        boolean flag;
        if (!mSelectedFacet.isEmpty())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        view = mViews.resetDoneBtn;
        if (flag2 || flag)
        {
            flag1 = true;
        }
        view.setLeftBtnEnable(flag1);
        al.b(mViews.resetDoneBtn);
        mPrevSelSortType = (com.target.ui.model.refine.ProductSortModel.SortLabel)b().b().c().d();
        c();
    }

    private void a(ProductRefineModel productrefinemodel)
    {
        if (mViews == null)
        {
            return;
        } else
        {
            mViews.refineView.setData(productrefinemodel);
            return;
        }
    }

    private ProductRefineModel b()
    {
        return mProductRefineModel;
    }

    static void b(ProductSummaryRefineFragment productsummaryrefinefragment)
    {
        productsummaryrefinefragment.i();
    }

    private void c()
    {
        mViews.refineView.setClickListener(new a());
        mViews.resetDoneBtn.setClickListener(new c());
    }

    static void c(ProductSummaryRefineFragment productsummaryrefinefragment)
    {
        productsummaryrefinefragment.g();
    }

    private void d()
    {
        if (mViews == null)
        {
            return;
        } else
        {
            mViews.refineView.setClickListener(null);
            mViews.resetDoneBtn.setClickListener(null);
            return;
        }
    }

    static void d(ProductSummaryRefineFragment productsummaryrefinefragment)
    {
        productsummaryrefinefragment.j();
    }

    private ProductSummaryParam e()
    {
        if (a() == null || mSelectedFacet == null)
        {
            return null;
        } else
        {
            return com.target.ui.util.f.a.a(a(), b(), mSelectedFacet);
        }
    }

    static ProductRefineModel e(ProductSummaryRefineFragment productsummaryrefinefragment)
    {
        return productsummaryrefinefragment.b();
    }

    private ArrayList f()
    {
        return mSelectedFacet;
    }

    static ArrayList f(ProductSummaryRefineFragment productsummaryrefinefragment)
    {
        return productsummaryrefinefragment.mSelectedFacet;
    }

    private void g()
    {
        mSelectedFacet.clear();
        a().j().clear();
        h();
        mViews.resetDoneBtn.setLeftBtnEnable(false);
    }

    private void h()
    {
        ProductRefineModel productrefinemodel = b();
        productrefinemodel.a();
        a(productrefinemodel);
    }

    private void i()
    {
        if (mSearchRefineListener != null)
        {
            Object obj = (com.target.ui.model.refine.ProductSortModel.SortLabel)b().b().c().d();
            List list;
            boolean flag;
            if (mPrevSelSortType == null && obj != null || mPrevSelSortType != null && obj == null || obj != null && mPrevSelSortType != null && !mPrevSelSortType.equals(obj))
            {
                flag = false;
            } else
            {
                flag = true;
            }
            obj = a().j();
            list = e().j();
            if (!flag || !((List) (obj)).equals(list))
            {
                mSearchRefineListener.a(e(), f());
                return;
            }
        }
    }

    private void j()
    {
        Animator animator = aj.e(mViews.resetDoneBtn);
        animator.addListener(new AnimatorListenerAdapter() {

            final ProductSummaryRefineFragment this$0;

            public void onAnimationEnd(Animator animator1)
            {
                if (com.target.ui.fragment.product.refine.ProductSummaryRefineFragment.a(ProductSummaryRefineFragment.this) == null || Z())
                {
                    return;
                } else
                {
                    getFragmentManager().d();
                    return;
                }
            }

            public void onAnimationStart(Animator animator1)
            {
                ProductSummaryRefineFragment.b(ProductSummaryRefineFragment.this);
            }

            
            {
                this$0 = ProductSummaryRefineFragment.this;
                super();
            }
        });
        animator.start();
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        if (getTargetFragment() instanceof b)
        {
            mSearchRefineListener = (b)getTargetFragment();
            return;
        } else
        {
            throw new IllegalStateException("Make sure to implement OnSearchRefineListener");
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        mProductRefineModel = (ProductRefineModel)z.a(getArguments().getParcelable("productRefineModelArg"), com/target/ui/model/refine/ProductRefineModel.getClassLoader());
        mProductSummaryParam = (ProductSummaryParam)z.a(getArguments().getParcelable("productParamArg"), com/target/mothership/common/params/ProductSummaryParam.getClassLoader());
    }

    public Animation onCreateAnimation(int k, boolean flag, int l)
    {
        Animation animation1 = super.onCreateAnimation(k, flag, l);
        Animation animation = animation1;
        if (animation1 == null)
        {
            try
            {
                animation = AnimationUtils.loadAnimation(getActivity(), l);
            }
            catch (android.content.res.Resources.NotFoundException notfoundexception)
            {
                return animation1;
            }
        }
        if (animation == null)
        {
            return animation;
        } else
        {
            animation.setAnimationListener(new android.view.animation.Animation.AnimationListener() {

                final ProductSummaryRefineFragment this$0;

                public void onAnimationEnd(Animation animation2)
                {
                    aj.d(com.target.ui.fragment.product.refine.ProductSummaryRefineFragment.a(ProductSummaryRefineFragment.this).resetDoneBtn).start();
                }

                public void onAnimationRepeat(Animation animation2)
                {
                }

                public void onAnimationStart(Animation animation2)
                {
                }

            
            {
                this$0 = ProductSummaryRefineFragment.this;
                super();
            }
            });
            return animation;
        }
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuinflater)
    {
        if (!isAdded())
        {
            return;
        } else
        {
            super.onCreateOptionsMenu(menu, menuinflater);
            j(getString(0x7f09047c));
            return;
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f030072, viewgroup, false);
        a(layoutinflater);
        a(b());
        return layoutinflater;
    }

    public void onDestroy()
    {
        super.onDestroy();
        mSelectedFacet = null;
    }

    public void onDestroyView()
    {
        super.onDestroyView();
        d();
        mViews = null;
        mSelectedFacet.clear();
    }

    public void onDetach()
    {
        super.onDetach();
        mSearchRefineListener = null;
    }

}

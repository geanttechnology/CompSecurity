// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.product.pdp;

import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.target.mothership.common.product.Dpci;
import com.target.mothership.common.product.Tcin;
import com.target.mothership.common.product.Upc;
import com.target.mothership.model.product.interfaces.ProductDetails;
import com.target.mothership.model.store.interfaces.Store;
import com.target.ui.f.c;
import com.target.ui.fragment.common.BaseNavigationFragment;
import com.target.ui.fragment.common.TargetWebFragment;
import com.target.ui.fragment.product.pdp.a.a;
import com.target.ui.helper.product.f;
import com.target.ui.util.al;
import com.target.ui.view.product.ProductAdditionalInfoView;
import com.target.ui.view.product.ProductFeaturesView;
import com.target.ui.view.product.ProductNutritionInfoView;
import com.target.ui.view.product.ProductWarningView;
import java.util.List;

public class ProductDescriptionPageFragment extends BaseNavigationFragment
    implements com.target.ui.fragment.product.pdp.a.a
{
    static class Views extends com.target.ui.view.a
    {

        ProductAdditionalInfoView additionalInfo;
        TextView appleTermsAndCondition;
        ProductWarningView chokingHazard;
        ProductFeaturesView featuresView;
        TextView productDescription;
        ProductNutritionInfoView productNutritionInfoView;

        Views(View view)
        {
            super(view);
        }
    }

    private class a
        implements com.target.ui.view.product.ProductNutritionInfoView.a
    {

        final ProductDescriptionPageFragment this$0;

        public void a()
        {
            com.target.ui.fragment.product.pdp.ProductDescriptionPageFragment.a(ProductDescriptionPageFragment.this).e();
        }

        private a()
        {
            this$0 = ProductDescriptionPageFragment.this;
            super();
        }

    }


    private static final String PRODUCT_DETAIL_ARG = "productDescriptionProductDetailsArg";
    private static final String STORE_ARG = "productDescriptionStoreArg";
    public static final String TAG = com/target/ui/fragment/product/pdp/ProductDescriptionPageFragment.getSimpleName();
    private com.target.ui.fragment.product.pdp.presenter.a mPresenter;
    private Views mViews;

    public ProductDescriptionPageFragment()
    {
    }

    public static ProductDescriptionPageFragment a(ProductDetails productdetails, Store store)
    {
        ProductDescriptionPageFragment productdescriptionpagefragment = new ProductDescriptionPageFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("productDescriptionStoreArg", store);
        bundle.putParcelable("productDescriptionProductDetailsArg", productdetails);
        productdescriptionpagefragment.setArguments(bundle);
        return productdescriptionpagefragment;
    }

    static com.target.ui.fragment.product.pdp.presenter.a a(ProductDescriptionPageFragment productdescriptionpagefragment)
    {
        return productdescriptionpagefragment.mPresenter;
    }

    private ProductDetails g()
    {
        return (ProductDetails)getArguments().getParcelable("productDescriptionProductDetailsArg");
    }

    private void h()
    {
        mViews.productNutritionInfoView.setClickListener(new a());
    }

    private void i()
    {
        mViews.productNutritionInfoView.setClickListener(null);
    }

    public void a()
    {
        al.b(mViews.productNutritionInfoView);
    }

    public void a(int j)
    {
        j(getString(j));
    }

    public void a(int j, String s)
    {
        if (Z())
        {
            return;
        } else
        {
            m().d(TargetWebFragment.a(true, s, getString(j)));
            return;
        }
    }

    public void a(Spanned spanned)
    {
        mViews.productDescription.setText(spanned);
        al.b(mViews.productDescription);
    }

    public void a(Tcin tcin, Dpci dpci, Upc upc)
    {
        mViews.additionalInfo.a(tcin, dpci, upc);
        al.b(mViews.additionalInfo);
    }

    public void a(String s)
    {
        mViews.appleTermsAndCondition.setText(Html.fromHtml(s));
        al.b(mViews.appleTermsAndCondition);
    }

    public void a(List list)
    {
        mViews.chokingHazard.setWarningData(list);
        al.b(mViews.chokingHazard);
    }

    public void b()
    {
        al.c(mViews.productNutritionInfoView);
    }

    public void b(List list)
    {
        mViews.featuresView.setProductFeatures(list);
        al.b(mViews.featuresView);
    }

    public void c()
    {
        al.c(mViews.chokingHazard);
    }

    public void d()
    {
        al.c(mViews.productDescription);
    }

    public void e()
    {
        al.c(mViews.featuresView);
    }

    public void f()
    {
        al.c(mViews.appleTermsAndCondition);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        mPresenter = new com.target.ui.fragment.product.pdp.presenter.a(g(), new f());
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
        layoutinflater = layoutinflater.inflate(0x7f03006e, viewgroup, false);
        mViews = new Views(layoutinflater);
        h();
        mPresenter.a(this);
        return layoutinflater;
    }

    public void onDestroy()
    {
        super.onDestroy();
        mPresenter.v_();
        mPresenter = null;
    }

    public void onDestroyView()
    {
        super.onDestroyView();
        i();
        mPresenter.z_();
        mViews = null;
    }

}

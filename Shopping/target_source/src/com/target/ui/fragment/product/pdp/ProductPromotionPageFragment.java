// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.product.pdp;

import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.target.mothership.model.product.interfaces.ProductPromotion;
import com.target.mothership.util.o;
import com.target.ui.fragment.common.BaseNavigationFragment;
import com.target.ui.fragment.product.pdp.a.c;
import com.target.ui.util.al;
import com.target.ui.view.a;

public class ProductPromotionPageFragment extends BaseNavigationFragment
    implements c
{
    static class Views extends a
    {

        TextView promoDescription;
        TextView promoTitle;

        Views(View view)
        {
            super(view);
        }
    }


    private static final String PRODUCT_PROMOTION_ARG = "promotionDescriptionArg";
    public static final String TAG = com/target/ui/fragment/product/pdp/ProductPromotionPageFragment.getSimpleName();
    private com.target.ui.fragment.product.pdp.presenter.c mPresenter;
    private Views mViews;

    public ProductPromotionPageFragment()
    {
    }

    public static ProductPromotionPageFragment a(ProductPromotion productpromotion)
    {
        ProductPromotionPageFragment productpromotionpagefragment = new ProductPromotionPageFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("promotionDescriptionArg", productpromotion);
        productpromotionpagefragment.setArguments(bundle);
        return productpromotionpagefragment;
    }

    private void c(ProductPromotion productpromotion)
    {
        String s = productpromotion.b();
        productpromotion = productpromotion.a();
        if (!o.g(s) && !o.g(productpromotion))
        {
            al.c(mViews.promoDescription);
            return;
        } else
        {
            mViews.promoTitle.setText(Html.fromHtml(s).toString().trim());
            mViews.promoDescription.setText(Html.fromHtml(productpromotion).toString().trim());
            al.b(mViews.promoDescription);
            return;
        }
    }

    public ProductPromotion a()
    {
        return (ProductPromotion)getArguments().getParcelable("promotionDescriptionArg");
    }

    public void a(int i)
    {
        j(getString(i));
    }

    public void b(ProductPromotion productpromotion)
    {
        c(productpromotion);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        mPresenter = new com.target.ui.fragment.product.pdp.presenter.c(a());
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuinflater)
    {
        if (!isAdded())
        {
            return;
        } else
        {
            super.onCreateOptionsMenu(menu, menuinflater);
            mPresenter.a(menu, menuinflater);
            return;
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f030070, viewgroup, false);
        mViews = new Views(layoutinflater);
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
        mPresenter.z_();
        mViews = null;
    }

}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.product.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.target.mothership.common.product.i;
import com.target.mothership.model.product.interfaces.ProductDetails;
import com.target.mothership.model.product.interfaces.ProductOnlineInfo;
import com.target.mothership.model.store.interfaces.Store;
import com.target.ui.adapter.product.c;
import com.target.ui.helper.product.ProductVariationModelHelper;
import com.target.ui.helper.product.b;
import com.target.ui.model.product.GridItem;
import com.target.ui.model.product.ListItem;
import com.target.ui.model.product.ProductVariationModel;
import com.target.ui.util.al;
import com.target.ui.view.product.ProductDialogPriceView;
import com.target.ui.view.product.ProductDialogWarningView;
import com.target.ui.view.product.ProductVariationView;
import java.util.List;

// Referenced classes of package com.target.ui.fragment.product.dialog:
//            BaseProductDialogFragment

public class ProductShipItDialogFragment extends BaseProductDialogFragment
{
    static class Views extends com.target.ui.view.a
    {

        Button addToCart;
        ProductDialogPriceView priceView;
        final View root;
        TextView title;
        ProductVariationView variationsView;
        ProductDialogWarningView warningContainer;

        Views(View view)
        {
            super(view);
            root = view;
        }
    }

    private class a
        implements android.view.View.OnClickListener
    {

        final ProductShipItDialogFragment this$0;

        public void onClick(View view)
        {
            if (ProductShipItDialogFragment.a(ProductShipItDialogFragment.this) == null || com.target.ui.fragment.product.dialog.ProductShipItDialogFragment.b(ProductShipItDialogFragment.this) == null)
            {
                return;
            }
            if (com.target.ui.fragment.product.dialog.ProductShipItDialogFragment.c(ProductShipItDialogFragment.this).H())
            {
                view = com.target.ui.fragment.product.dialog.ProductShipItDialogFragment.c(ProductShipItDialogFragment.this);
            } else
            {
                view = null;
            }
            ProductShipItDialogFragment.a(ProductShipItDialogFragment.this).a(com.target.ui.fragment.product.dialog.ProductShipItDialogFragment.b(ProductShipItDialogFragment.this), f(), view, ProductShipItDialogFragment.d(ProductShipItDialogFragment.this), null, null);
            getDialog().dismiss();
        }

        private a()
        {
            this$0 = ProductShipItDialogFragment.this;
            super();
        }

    }

    private class b
        implements com.target.ui.view.product.ProductVariationView.b
    {

        final ProductShipItDialogFragment this$0;

        public void a()
        {
            ProductShipItDialogFragment.a(ProductShipItDialogFragment.this, com.target.ui.fragment.product.dialog.ProductShipItDialogFragment.c(ProductShipItDialogFragment.this));
            ProductShipItDialogFragment.e(ProductShipItDialogFragment.this);
            ProductShipItDialogFragment.a(ProductShipItDialogFragment.this, false);
            com.target.ui.fragment.product.dialog.ProductShipItDialogFragment.b(ProductShipItDialogFragment.this, com.target.ui.fragment.product.dialog.ProductShipItDialogFragment.c(ProductShipItDialogFragment.this));
        }

        public void a(GridItem griditem)
        {
            ProductShipItDialogFragment.this.a(griditem);
        }

        public void a(ListItem listitem, GridItem griditem)
        {
            listitem = ProductVariationModelHelper.a(com.target.ui.fragment.product.dialog.ProductShipItDialogFragment.c(ProductShipItDialogFragment.this), ProductShipItDialogFragment.d(ProductShipItDialogFragment.this), f(), listitem, griditem);
            com.target.ui.fragment.product.dialog.ProductShipItDialogFragment.c(ProductShipItDialogFragment.this, listitem);
        }

        private b()
        {
            this$0 = ProductShipItDialogFragment.this;
            super();
        }

    }


    private static final String KEY_ADD_TO_CART_ITEM_TYPE = "itemType";
    private static final String KEY_PRODUCT_DETAILS = "productDetails";
    private static final String KEY_REQUEST_PRODUCT_DETAILS = "requestProductDetails";
    private static final String KEY_STORES = "stores";
    private static final String KEY_VARIATION_MODEL = "productVariationModel";
    public static final String TAG = com/target/ui/fragment/product/dialog/ProductShipItDialogFragment.getSimpleName();
    private ProductDetails mGuestSelectedProductForShipping;
    private com.target.ui.helper.product.b mItemType;
    private BaseProductDialogFragment.a mListener;
    private ProductDetails mProductDetails;
    private ProductVariationModel mProductVariationModel;
    private Views mViews;

    public ProductShipItDialogFragment()
    {
    }

    static ProductDetails a(ProductShipItDialogFragment productshipitdialogfragment, ProductDetails productdetails)
    {
        productshipitdialogfragment.mGuestSelectedProductForShipping = productdetails;
        return productdetails;
    }

    static BaseProductDialogFragment.a a(ProductShipItDialogFragment productshipitdialogfragment)
    {
        return productshipitdialogfragment.mListener;
    }

    public static ProductShipItDialogFragment a(ProductDetails productdetails, ProductVariationModel productvariationmodel, com.target.ui.helper.product.b b1, Store store, BaseProductDialogFragment.b b2)
    {
        ProductShipItDialogFragment productshipitdialogfragment = new ProductShipItDialogFragment();
        a(((android.support.v4.app.DialogFragment) (productshipitdialogfragment)), b2);
        b2 = new Bundle();
        b2.putParcelable("stores", store);
        b2.putParcelable("productDetails", productdetails);
        b2.putParcelable("productVariationModel", productvariationmodel);
        b2.putInt("itemType", b1.ordinal());
        b2.putBoolean("requestProductDetails", true);
        productshipitdialogfragment.setArguments(b2);
        return productshipitdialogfragment;
    }

    private void a(Button button, com.target.ui.helper.product.b b1)
    {
        static class _cls1
        {

            static final int $SwitchMap$com$target$mothership$common$product$InventoryStatus[];
            static final int $SwitchMap$com$target$ui$helper$product$AddToCartItemType[];

            static 
            {
                $SwitchMap$com$target$mothership$common$product$InventoryStatus = new int[i.values().length];
                try
                {
                    $SwitchMap$com$target$mothership$common$product$InventoryStatus[i.OutOfStock.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$product$InventoryStatus[i.UNKNOWN.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                $SwitchMap$com$target$ui$helper$product$AddToCartItemType = new int[com.target.ui.helper.product.b.values().length];
                try
                {
                    $SwitchMap$com$target$ui$helper$product$AddToCartItemType[com.target.ui.helper.product.b.EXPRESS_CHECKOUT.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$target$ui$helper$product$AddToCartItemType[com.target.ui.helper.product.b.SHIP.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$target$ui$helper$product$AddToCartItemType[com.target.ui.helper.product.b.SMS.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$target$ui$helper$product$AddToCartItemType[com.target.ui.helper.product.b.EMAIL.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$target$ui$helper$product$AddToCartItemType[com.target.ui.helper.product.b.MAIL.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1..SwitchMap.com.target.ui.helper.product.AddToCartItemType[b1.ordinal()];
        JVM INSTR tableswitch 1 1: default 28
    //                   1 41;
           goto _L1 _L2
_L1:
        b1 = getString(0x7f0900d3);
_L4:
        button.setText(b1);
        return;
_L2:
        b1 = getString(0x7f0900df);
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void a(ProductDetails productdetails)
    {
        if (j())
        {
            a(((com.target.mothership.model.product.interfaces.Product) (productdetails)));
        }
    }

    static void a(ProductShipItDialogFragment productshipitdialogfragment, boolean flag)
    {
        productshipitdialogfragment.a(flag);
    }

    private void a(boolean flag)
    {
        mViews.addToCart.setEnabled(flag);
    }

    static ProductDetails b(ProductShipItDialogFragment productshipitdialogfragment)
    {
        return productshipitdialogfragment.mGuestSelectedProductForShipping;
    }

    private void b(ProductDetails productdetails)
    {
        com.target.ui.adapter.product.c.a(mViews.priceView, productdetails);
    }

    static void b(ProductShipItDialogFragment productshipitdialogfragment, ProductDetails productdetails)
    {
        productshipitdialogfragment.b(productdetails);
    }

    static ProductDetails c(ProductShipItDialogFragment productshipitdialogfragment)
    {
        return productshipitdialogfragment.mProductDetails;
    }

    private void c(ProductDetails productdetails)
    {
        String s = "";
        if (productdetails == null || !productdetails.c().a()) goto _L2; else goto _L1
_L1:
        _cls1..SwitchMap.com.target.mothership.common.product.InventoryStatus[productdetails.c().c().ordinal()];
        JVM INSTR tableswitch 1 2: default 60
    //                   1 71
    //                   2 102;
           goto _L3 _L4 _L5
_L3:
        al.c(mViews.warningContainer);
        return;
_L4:
        productdetails = getString(0x7f090455);
_L7:
        mViews.warningContainer.a(productdetails, s, true);
        al.b(mViews.warningContainer);
        return;
_L5:
        productdetails = getString(0x7f090454);
        continue; /* Loop/switch isn't completed */
_L2:
        productdetails = getString(0x7f090451);
        s = getString(0x7f09044d);
        if (true) goto _L7; else goto _L6
_L6:
    }

    static void c(ProductShipItDialogFragment productshipitdialogfragment, ProductDetails productdetails)
    {
        productshipitdialogfragment.d(productdetails);
    }

    static ProductVariationModel d(ProductShipItDialogFragment productshipitdialogfragment)
    {
        return productshipitdialogfragment.mProductVariationModel;
    }

    private void d(ProductDetails productdetails)
    {
        mGuestSelectedProductForShipping = productdetails;
        boolean flag = com.target.ui.helper.product.c.a(productdetails);
        if (!flag)
        {
            c(productdetails);
        } else
        {
            p();
        }
        b(mGuestSelectedProductForShipping);
        a(flag);
    }

    static void e(ProductShipItDialogFragment productshipitdialogfragment)
    {
        productshipitdialogfragment.p();
    }

    private boolean j()
    {
        return getArguments().getBoolean("requestProductDetails");
    }

    private void k()
    {
        mViews.addToCart.setOnClickListener(new a(null));
        mViews.variationsView.setClickListener(new b(null));
    }

    private void l()
    {
        mViews.addToCart.setOnClickListener(null);
        mViews.variationsView.setClickListener(null);
    }

    private void m()
    {
        if (mViews == null)
        {
            return;
        } else
        {
            n();
            o();
            b(mProductDetails);
            p();
            return;
        }
    }

    private void n()
    {
        String s = "";
        _cls1..SwitchMap.com.target.ui.helper.product.AddToCartItemType[mItemType.ordinal()];
        JVM INSTR tableswitch 1 5: default 48
    //                   1 80
    //                   2 80
    //                   3 60
    //                   4 70
    //                   5 80;
           goto _L1 _L2 _L2 _L3 _L4 _L2
_L1:
        mViews.title.setText(s);
        return;
_L3:
        s = getString(0x7f090443);
        continue; /* Loop/switch isn't completed */
_L4:
        s = getString(0x7f090434);
        continue; /* Loop/switch isn't completed */
_L2:
        s = getString(0x7f090442);
        if (true) goto _L1; else goto _L5
_L5:
    }

    private void o()
    {
        if (mProductVariationModel == null || mProductVariationModel.a().equals(com.target.ui.model.product.ProductVariationModel.a.NONE))
        {
            al.c(mViews.variationsView);
            return;
        } else
        {
            mViews.variationsView.a(mProductVariationModel);
            al.b(mViews.variationsView);
            return;
        }
    }

    private void p()
    {
        al.c(mViews.warningContainer);
    }

    protected View a(LayoutInflater layoutinflater, ViewGroup viewgroup)
    {
        layoutinflater = layoutinflater.inflate(0x7f0301c6, viewgroup, false);
        mViews = new Views(layoutinflater);
        mViews.priceView.setFulfillmentType(h());
        a(mViews.addToCart, mItemType);
        mViews.addToCart.setEnabled(false);
        a(mProductDetails);
        k();
        m();
        return layoutinflater;
    }

    protected void a(ProductDetails productdetails, ProductVariationModel productvariationmodel)
    {
        if (mViews == null)
        {
            return;
        } else
        {
            mProductDetails = productdetails;
            mProductVariationModel = productvariationmodel;
            o();
            return;
        }
    }

    protected void a(com.target.ui.service.k.a a1)
    {
    }

    protected void a(Boolean boolean1)
    {
    }

    protected void a(List list)
    {
    }

    protected Store b()
    {
        return (Store)getArguments().getParcelable("stores");
    }

    protected void c()
    {
        mProductDetails = (ProductDetails)getArguments().getParcelable("productDetails");
        mProductVariationModel = (ProductVariationModel)getArguments().getParcelable("productVariationModel");
        mItemType = com.target.ui.helper.product.b.values()[getArguments().getInt("itemType")];
    }

    protected BaseProductDialogFragment.a d()
    {
        return mListener;
    }

    protected ProductVariationModel e()
    {
        return mProductVariationModel;
    }

    protected com.target.ui.helper.product.b f()
    {
        return mItemType;
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        if (getTargetFragment() instanceof BaseProductDialogFragment.b)
        {
            mListener = ((BaseProductDialogFragment.b)getTargetFragment()).r_();
            return;
        } else
        {
            throw new IllegalStateException("Make sure to implement ProductDialogStateListenerProvider");
        }
    }

    public void onDestroyView()
    {
        super.onDestroyView();
        l();
        if (mViews != null)
        {
            mViews.variationsView.a();
        }
        mViews = null;
    }

    public void onDetach()
    {
        super.onDetach();
        mListener = null;
    }

}

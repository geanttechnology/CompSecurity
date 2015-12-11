// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.product.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.target.mothership.model.product.interfaces.ProductDetails;
import com.target.ui.common.ProductFulfillmentOptions;
import com.target.ui.fragment.common.BaseFullScreenDialogFragment;
import com.target.ui.helper.product.ProductVariationModelHelper;
import com.target.ui.helper.product.b;
import com.target.ui.view.product.PdpFulfillmentFloatingMenuView;
import java.util.List;

public class ProductFulfillmentFabDialog extends BaseFullScreenDialogFragment
{
    static class Views extends com.target.ui.view.a
    {

        PdpFulfillmentFloatingMenuView floatingMenu;
        final View rootView;

        public Views(View view)
        {
            super(view);
            rootView = view;
        }
    }

    private class a
        implements android.view.View.OnClickListener
    {

        final ProductFulfillmentFabDialog this$0;

        public void onClick(View view)
        {
            ProductFulfillmentFabDialog.a(ProductFulfillmentFabDialog.this);
        }

        private a()
        {
            this$0 = ProductFulfillmentFabDialog.this;
            super();
        }

    }

    public static interface b
    {

        public abstract void a();

        public abstract void a(ProductDetails productdetails);

        public abstract void a(ProductDetails productdetails, com.target.ui.helper.product.b b1);

        public abstract void b();

        public abstract void b(ProductDetails productdetails);
    }

    private class c
        implements com.target.ui.view.product.PdpFulfillmentFloatingMenuView.d
    {

        final ProductFulfillmentFabDialog this$0;

        public void a()
        {
            if (com.target.ui.fragment.product.dialog.ProductFulfillmentFabDialog.b(ProductFulfillmentFabDialog.this) != null)
            {
                com.target.ui.fragment.product.dialog.ProductFulfillmentFabDialog.b(ProductFulfillmentFabDialog.this).a(ProductFulfillmentFabDialog.c(ProductFulfillmentFabDialog.this), com.target.ui.helper.product.b.PICK_UP);
            }
            ProductFulfillmentFabDialog.a(ProductFulfillmentFabDialog.this);
        }

        public void b()
        {
            if (com.target.ui.fragment.product.dialog.ProductFulfillmentFabDialog.b(ProductFulfillmentFabDialog.this) != null)
            {
                com.target.ui.fragment.product.dialog.ProductFulfillmentFabDialog.b(ProductFulfillmentFabDialog.this).a(ProductFulfillmentFabDialog.c(ProductFulfillmentFabDialog.this));
            }
            ProductFulfillmentFabDialog.a(ProductFulfillmentFabDialog.this);
        }

        public void c()
        {
            if (com.target.ui.fragment.product.dialog.ProductFulfillmentFabDialog.b(ProductFulfillmentFabDialog.this) != null)
            {
                com.target.ui.helper.product.b b1 = com.target.ui.helper.product.b.EMAIL;
                com.target.ui.fragment.product.dialog.ProductFulfillmentFabDialog.b(ProductFulfillmentFabDialog.this).a(ProductFulfillmentFabDialog.a(ProductFulfillmentFabDialog.this, b1), b1);
            }
            ProductFulfillmentFabDialog.a(ProductFulfillmentFabDialog.this);
        }

        public void d()
        {
            if (com.target.ui.fragment.product.dialog.ProductFulfillmentFabDialog.b(ProductFulfillmentFabDialog.this) != null)
            {
                com.target.ui.helper.product.b b1 = com.target.ui.helper.product.b.SMS;
                com.target.ui.fragment.product.dialog.ProductFulfillmentFabDialog.b(ProductFulfillmentFabDialog.this).a(ProductFulfillmentFabDialog.a(ProductFulfillmentFabDialog.this, b1), b1);
            }
            ProductFulfillmentFabDialog.a(ProductFulfillmentFabDialog.this);
        }

        public void e()
        {
            if (com.target.ui.fragment.product.dialog.ProductFulfillmentFabDialog.b(ProductFulfillmentFabDialog.this) != null)
            {
                com.target.ui.helper.product.b b1 = com.target.ui.helper.product.b.MAIL;
                com.target.ui.fragment.product.dialog.ProductFulfillmentFabDialog.b(ProductFulfillmentFabDialog.this).a(ProductFulfillmentFabDialog.a(ProductFulfillmentFabDialog.this, b1), b1);
            }
            ProductFulfillmentFabDialog.a(ProductFulfillmentFabDialog.this);
        }

        public void f()
        {
            if (com.target.ui.fragment.product.dialog.ProductFulfillmentFabDialog.b(ProductFulfillmentFabDialog.this) != null)
            {
                com.target.ui.fragment.product.dialog.ProductFulfillmentFabDialog.b(ProductFulfillmentFabDialog.this).a(ProductFulfillmentFabDialog.c(ProductFulfillmentFabDialog.this), com.target.ui.helper.product.b.SHIP);
            }
            ProductFulfillmentFabDialog.a(ProductFulfillmentFabDialog.this);
        }

        public void g()
        {
            if (com.target.ui.fragment.product.dialog.ProductFulfillmentFabDialog.b(ProductFulfillmentFabDialog.this) != null)
            {
                com.target.ui.fragment.product.dialog.ProductFulfillmentFabDialog.b(ProductFulfillmentFabDialog.this).b(ProductFulfillmentFabDialog.d(ProductFulfillmentFabDialog.this));
            }
            ProductFulfillmentFabDialog.a(ProductFulfillmentFabDialog.this);
        }

        public void h()
        {
            if (com.target.ui.fragment.product.dialog.ProductFulfillmentFabDialog.b(ProductFulfillmentFabDialog.this) != null)
            {
                com.target.ui.fragment.product.dialog.ProductFulfillmentFabDialog.b(ProductFulfillmentFabDialog.this).a();
            }
        }

        public void i()
        {
            ProductFulfillmentFabDialog.a(ProductFulfillmentFabDialog.this);
        }

        private c()
        {
            this$0 = ProductFulfillmentFabDialog.this;
            super();
        }

    }

    public static final class d extends Enum
    {

        private static final d $VALUES[];
        public static final d LOAD_PRODUCT_DETAILS;
        public static final d LOAD_PRODUCT_DETAILS_LIST;

        public static d valueOf(String s)
        {
            return (d)Enum.valueOf(com/target/ui/fragment/product/dialog/ProductFulfillmentFabDialog$d, s);
        }

        public static d[] values()
        {
            return (d[])$VALUES.clone();
        }

        static 
        {
            LOAD_PRODUCT_DETAILS = new d("LOAD_PRODUCT_DETAILS", 0);
            LOAD_PRODUCT_DETAILS_LIST = new d("LOAD_PRODUCT_DETAILS_LIST", 1);
            $VALUES = (new d[] {
                LOAD_PRODUCT_DETAILS, LOAD_PRODUCT_DETAILS_LIST
            });
        }

        private d(String s, int i1)
        {
            super(s, i1);
        }
    }


    private static final String ARG_DIALOG_STATE = "dialogState";
    private static final String ARG_PARENT_PRODUCT_DETAILS = "parentProductDetailsList";
    private static final String ARG_PRODUCT_DETAILS = "productDetails";
    private static final String ARG_PRODUCT_DETAILS_LIST = "productDetailsList";
    private static final String ARG_PRODUCT_FULFILLMENT_OPTIONS = "productFulfillmentOptions";
    public static final String TAG = com/target/ui/fragment/product/dialog/ProductFulfillmentFabDialog.getSimpleName();
    private b mListener;
    private Views mViews;

    public ProductFulfillmentFabDialog()
    {
    }

    static ProductDetails a(ProductFulfillmentFabDialog productfulfillmentfabdialog, com.target.ui.helper.product.b b1)
    {
        return productfulfillmentfabdialog.a(b1);
    }

    private ProductDetails a(com.target.ui.helper.product.b b1)
    {
        static class _cls1
        {

            static final int $SwitchMap$com$target$ui$fragment$product$dialog$ProductFulfillmentFabDialog$ViewType[];

            static 
            {
                $SwitchMap$com$target$ui$fragment$product$dialog$ProductFulfillmentFabDialog$ViewType = new int[d.values().length];
                try
                {
                    $SwitchMap$com$target$ui$fragment$product$dialog$ProductFulfillmentFabDialog$ViewType[d.LOAD_PRODUCT_DETAILS_LIST.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$target$ui$fragment$product$dialog$ProductFulfillmentFabDialog$ViewType[d.LOAD_PRODUCT_DETAILS.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.target.ui.fragment.product.dialog.ProductFulfillmentFabDialog.ViewType[f().ordinal()])
        {
        default:
            return h();

        case 1: // '\001'
            return ProductVariationModelHelper.a(b1, a());
        }
    }

    static void a(ProductFulfillmentFabDialog productfulfillmentfabdialog)
    {
        productfulfillmentfabdialog.l();
    }

    static b b(ProductFulfillmentFabDialog productfulfillmentfabdialog)
    {
        return productfulfillmentfabdialog.mListener;
    }

    private void b()
    {
        mViews.rootView.setOnClickListener(new a(null));
        mViews.floatingMenu.setClickListener(new c(null));
    }

    static ProductDetails c(ProductFulfillmentFabDialog productfulfillmentfabdialog)
    {
        return productfulfillmentfabdialog.h();
    }

    private void c()
    {
        if (mViews == null)
        {
            return;
        } else
        {
            mViews.rootView.setOnClickListener(null);
            mViews.floatingMenu.setClickListener(null);
            return;
        }
    }

    static ProductDetails d(ProductFulfillmentFabDialog productfulfillmentfabdialog)
    {
        return productfulfillmentfabdialog.k();
    }

    private d f()
    {
        return d.values()[getArguments().getInt("dialogState")];
    }

    private ProductFulfillmentOptions g()
    {
        return (ProductFulfillmentOptions)getArguments().getParcelable("productFulfillmentOptions");
    }

    private ProductDetails h()
    {
        return (ProductDetails)getArguments().getParcelable("productDetails");
    }

    private ProductDetails i()
    {
        return (ProductDetails)getArguments().getParcelable("parentProductDetailsList");
    }

    private void j()
    {
        mViews.floatingMenu.a(g());
    }

    private ProductDetails k()
    {
        switch (_cls1..SwitchMap.com.target.ui.fragment.product.dialog.ProductFulfillmentFabDialog.ViewType[f().ordinal()])
        {
        default:
            return h();

        case 1: // '\001'
            return i();
        }
    }

    private void l()
    {
        m();
        if (getDialog() == null)
        {
            return;
        } else
        {
            getDialog().dismiss();
            return;
        }
    }

    private void m()
    {
        if (mViews != null)
        {
            mViews.floatingMenu.b();
            if (mListener != null)
            {
                mListener.b();
                return;
            }
        }
    }

    protected List a()
    {
        return getArguments().getParcelableArrayList("productDetailsList");
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        if (getTargetFragment() instanceof b)
        {
            mListener = (b)getTargetFragment();
            return;
        } else
        {
            throw new IllegalStateException("Make sure to implement FloatingActionBarDialogListener");
        }
    }

    public void onCancel(DialogInterface dialoginterface)
    {
        if (mListener == null)
        {
            return;
        } else
        {
            m();
            return;
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f03005d, viewgroup, true);
        mViews = new Views(layoutinflater);
        j();
        b();
        return layoutinflater;
    }

    public void onDestroyView()
    {
        super.onDestroyView();
        c();
    }

    public void onStart()
    {
        super.onStart();
        if (mViews == null)
        {
            return;
        } else
        {
            mViews.floatingMenu.a();
            return;
        }
    }

}

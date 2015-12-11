// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.product.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.target.mothership.model.store.interfaces.Store;
import com.target.mothership.util.o;
import com.target.ui.fragment.common.BaseDialogFragment;
import com.target.ui.helper.product.b;
import com.target.ui.util.al;

public class ProductAddToCartErrorDialog extends BaseDialogFragment
{
    static class Views extends com.target.ui.view.a
    {

        TextView errorSubTitle;
        TextView errorTitle;
        Button greyButton;
        Button okButton;
        Button redButton;

        public Views(View view)
        {
            super(view);
        }
    }

    private class a
        implements android.view.View.OnClickListener
    {

        final ProductAddToCartErrorDialog this$0;

        public void onClick(View view)
        {
            switch (view.getId())
            {
            default:
                return;

            case 2131756335: 
                if (ProductAddToCartErrorDialog.a(ProductAddToCartErrorDialog.this))
                {
                    ProductAddToCartErrorDialog.d(ProductAddToCartErrorDialog.this).b(com.target.ui.fragment.product.dialog.ProductAddToCartErrorDialog.b(ProductAddToCartErrorDialog.this), ProductAddToCartErrorDialog.c(ProductAddToCartErrorDialog.this));
                } else
                {
                    ProductAddToCartErrorDialog.d(ProductAddToCartErrorDialog.this).c(com.target.ui.fragment.product.dialog.ProductAddToCartErrorDialog.b(ProductAddToCartErrorDialog.this), ProductAddToCartErrorDialog.c(ProductAddToCartErrorDialog.this));
                }
                getDialog().dismiss();
                return;

            case 2131756334: 
                getDialog().dismiss();
                return;

            case 2131756336: 
                getDialog().cancel();
                return;
            }
        }

        private a()
        {
            this$0 = ProductAddToCartErrorDialog.this;
            super();
        }

    }

    public static interface b
    {

        public abstract void a(com.target.ui.helper.product.b b1);

        public abstract void b(com.target.ui.helper.product.b b1, Store store);

        public abstract void c(com.target.ui.helper.product.b b1, Store store);
    }

    public static interface c
    {

        public abstract b k();
    }

    private static final class d extends Enum
    {

        private static final d $VALUES[];
        public static final d AGE_RESTRICTED;
        public static final d GENERIC;
        public static final d SPECIFIC_TYPE;

        public static d valueOf(String s)
        {
            return (d)Enum.valueOf(com/target/ui/fragment/product/dialog/ProductAddToCartErrorDialog$d, s);
        }

        public static d[] values()
        {
            return (d[])$VALUES.clone();
        }

        static 
        {
            AGE_RESTRICTED = new d("AGE_RESTRICTED", 0);
            SPECIFIC_TYPE = new d("SPECIFIC_TYPE", 1);
            GENERIC = new d("GENERIC", 2);
            $VALUES = (new d[] {
                AGE_RESTRICTED, SPECIFIC_TYPE, GENERIC
            });
        }

        private d(String s, int i1)
        {
            super(s, i1);
        }
    }


    private static final String DEFAULT_MIN_AGE_RESTRICTION = "17";
    private static final String KEY_ADD_TO_CART_ERROR = "keyAddToCartError";
    private static final String KEY_ITEM_TYPE = "keyItemType";
    private static final String KEY_MIN_AGE_RESTRICTION = "keyAgeRestriction";
    private static final String KEY_STORE = "keyStore";
    public static final String TAG = com/target/ui/fragment/product/dialog/ProductAddToCartErrorDialog.getSimpleName();
    private b mListener;
    private Views mViews;

    public ProductAddToCartErrorDialog()
    {
    }

    private View a(LayoutInflater layoutinflater, ViewGroup viewgroup)
    {
        layoutinflater = layoutinflater.inflate(0x7f0301be, viewgroup, false);
        mViews = new Views(layoutinflater);
        g();
        e();
        return layoutinflater;
    }

    private com.target.mothership.model.cart.interfaces.a.b.a a()
    {
        return com.target.mothership.model.cart.interfaces.a.b.a.values()[getArguments().getInt("keyAddToCartError")];
    }

    public static ProductAddToCartErrorDialog a(com.target.ui.helper.product.b b1, com.target.mothership.model.cart.interfaces.a.b.a a1, String s, Store store, c c1)
    {
        ProductAddToCartErrorDialog productaddtocarterrordialog = new ProductAddToCartErrorDialog();
        a(((DialogFragment) (productaddtocarterrordialog)), c1);
        c1 = new Bundle();
        c1.putInt("keyItemType", b1.ordinal());
        c1.putString("keyAgeRestriction", s);
        c1.putInt("keyAddToCartError", a1.ordinal());
        c1.putParcelable("keyStore", store);
        productaddtocarterrordialog.setArguments(c1);
        return productaddtocarterrordialog;
    }

    private static void a(DialogFragment dialogfragment, c c1)
        throws IllegalArgumentException
    {
        if (c1 == null)
        {
            throw new IllegalArgumentException("ProductAddToCartErrorDialogListenerProvider cannot be null");
        }
        if (!(c1 instanceof Fragment))
        {
            throw new IllegalArgumentException("Must implement ProductAddToCartErrorDialogListenerProvider");
        } else
        {
            dialogfragment.setTargetFragment((Fragment)c1, 0);
            return;
        }
    }

    private void a(String s, String s1)
    {
        if (o.g(s))
        {
            mViews.errorTitle.setText(s);
            al.b(mViews.errorTitle);
        } else
        {
            al.c(mViews.errorTitle);
        }
        mViews.errorSubTitle.setText(s1);
    }

    static boolean a(ProductAddToCartErrorDialog productaddtocarterrordialog)
    {
        return productaddtocarterrordialog.n();
    }

    private com.target.ui.helper.product.b b()
    {
        return com.target.ui.helper.product.b.values()[getArguments().getInt("keyItemType")];
    }

    static com.target.ui.helper.product.b b(ProductAddToCartErrorDialog productaddtocarterrordialog)
    {
        return productaddtocarterrordialog.b();
    }

    private void b(String s, String s1)
    {
        mViews.greyButton.setText(s);
        mViews.redButton.setText(s1);
    }

    static Store c(ProductAddToCartErrorDialog productaddtocarterrordialog)
    {
        return productaddtocarterrordialog.d();
    }

    private String c()
    {
        return getArguments().getString("keyAgeRestriction");
    }

    private Store d()
    {
        return (Store)getArguments().getParcelable("keyStore");
    }

    static b d(ProductAddToCartErrorDialog productaddtocarterrordialog)
    {
        return productaddtocarterrordialog.mListener;
    }

    private void e()
    {
        mViews.greyButton.setOnClickListener(new a());
        mViews.okButton.setOnClickListener(new a());
        mViews.redButton.setOnClickListener(new a());
    }

    private void f()
    {
        mViews.greyButton.setOnClickListener(null);
        mViews.okButton.setOnClickListener(null);
        mViews.redButton.setOnClickListener(null);
    }

    private void g()
    {
        a(h(), i());
        j();
    }

    private String h()
    {
        String s = "";
        if (n())
        {
            s = getString(0x7f090409);
        }
        return s;
    }

    private String i()
    {
        static class _cls1
        {

            static final int $SwitchMap$com$target$mothership$model$cart$interfaces$error$AddToCartFailure$AddToCartFailureReason[];
            static final int $SwitchMap$com$target$ui$fragment$product$dialog$ProductAddToCartErrorDialog$ViewType[];

            static 
            {
                $SwitchMap$com$target$ui$fragment$product$dialog$ProductAddToCartErrorDialog$ViewType = new int[d.values().length];
                try
                {
                    $SwitchMap$com$target$ui$fragment$product$dialog$ProductAddToCartErrorDialog$ViewType[d.AGE_RESTRICTED.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror12) { }
                try
                {
                    $SwitchMap$com$target$ui$fragment$product$dialog$ProductAddToCartErrorDialog$ViewType[d.SPECIFIC_TYPE.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror11) { }
                try
                {
                    $SwitchMap$com$target$ui$fragment$product$dialog$ProductAddToCartErrorDialog$ViewType[d.GENERIC.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror10) { }
                $SwitchMap$com$target$mothership$model$cart$interfaces$error$AddToCartFailure$AddToCartFailureReason = new int[com.target.mothership.model.cart.interfaces.a.b.a.values().length];
                try
                {
                    $SwitchMap$com$target$mothership$model$cart$interfaces$error$AddToCartFailure$AddToCartFailureReason[com.target.mothership.model.cart.interfaces.a.b.a.ERR_CART_AGE_CHECK_FAILURE.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror9) { }
                try
                {
                    $SwitchMap$com$target$mothership$model$cart$interfaces$error$AddToCartFailure$AddToCartFailureReason[com.target.mothership.model.cart.interfaces.a.b.a.ERR_CART_MAX_LINE_ITEMS.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                try
                {
                    $SwitchMap$com$target$mothership$model$cart$interfaces$error$AddToCartFailure$AddToCartFailureReason[com.target.mothership.model.cart.interfaces.a.b.a.ERR_CART_MAX_LENGTH_QUANTITY_REACHED.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    $SwitchMap$com$target$mothership$model$cart$interfaces$error$AddToCartFailure$AddToCartFailureReason[com.target.mothership.model.cart.interfaces.a.b.a.ERR_CART_MAX_LINE_QUANTITY_REACHED.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$com$target$mothership$model$cart$interfaces$error$AddToCartFailure$AddToCartFailureReason[com.target.mothership.model.cart.interfaces.a.b.a.ERR_CART_MAX_STORE_INVENTORY_REACHED.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$target$mothership$model$cart$interfaces$error$AddToCartFailure$AddToCartFailureReason[com.target.mothership.model.cart.interfaces.a.b.a.ERR_CART_INVENTORY_NOT_AVAILABLE.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$target$mothership$model$cart$interfaces$error$AddToCartFailure$AddToCartFailureReason[com.target.mothership.model.cart.interfaces.a.b.a.ERR_CART_MAX_INVENTORY_REACHED.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$target$mothership$model$cart$interfaces$error$AddToCartFailure$AddToCartFailureReason[com.target.mothership.model.cart.interfaces.a.b.a.ERR_CART_LIMITED_QUANTITY_ADD_ERROR.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$target$mothership$model$cart$interfaces$error$AddToCartFailure$AddToCartFailureReason[com.target.mothership.model.cart.interfaces.a.b.a.ERR_TOO_MANY_REQUESTS.ordinal()] = 9;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$target$mothership$model$cart$interfaces$error$AddToCartFailure$AddToCartFailureReason[com.target.mothership.model.cart.interfaces.a.b.a.ERR_CART_UNKNOWN.ordinal()] = 10;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.target.mothership.model.cart.interfaces.error.AddToCartFailure.AddToCartFailureReason[a().ordinal()])
        {
        default:
            return getString(0x7f09040f);

        case 1: // '\001'
            String s1 = c();
            String s = s1;
            if (!o.g(s1))
            {
                s = "17";
            }
            return getString(0x7f090408, new Object[] {
                s, s
            });

        case 2: // '\002'
        case 3: // '\003'
        case 4: // '\004'
            return getString(0x7f090411);

        case 5: // '\005'
        case 6: // '\006'
            return getString(0x7f090413);

        case 7: // '\007'
            return getString(0x7f090410);

        case 8: // '\b'
            return getString(0x7f090412);

        case 9: // '\t'
            return getString(0x7f09027b);
        }
    }

    private void j()
    {
        switch (_cls1..SwitchMap.com.target.ui.fragment.product.dialog.ProductAddToCartErrorDialog.ViewType[m().ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            b(getString(0x7f09040b), getString(0x7f09040e));
            l();
            return;

        case 2: // '\002'
            k();
            return;

        case 3: // '\003'
            b(getString(0x7f09040a), getString(0x7f09040d));
            break;
        }
        l();
    }

    private void k()
    {
        al.a(mViews.okButton, new View[] {
            mViews.greyButton, mViews.redButton
        });
    }

    private void l()
    {
        al.c(mViews.okButton);
        al.b(new View[] {
            mViews.greyButton, mViews.redButton
        });
    }

    private d m()
    {
        switch (_cls1..SwitchMap.com.target.mothership.model.cart.interfaces.error.AddToCartFailure.AddToCartFailureReason[a().ordinal()])
        {
        default:
            return d.SPECIFIC_TYPE;

        case 1: // '\001'
            return d.AGE_RESTRICTED;

        case 10: // '\n'
            return d.GENERIC;
        }
    }

    private boolean n()
    {
        return a().equals(com.target.mothership.model.cart.interfaces.a.b.a.ERR_CART_AGE_CHECK_FAILURE);
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        if (getTargetFragment() instanceof c)
        {
            mListener = ((c)getTargetFragment()).k();
            return;
        } else
        {
            throw new IllegalStateException("Make sure to implement AddToListDialogListener");
        }
    }

    public void onCancel(DialogInterface dialoginterface)
    {
        super.onCancel(dialoginterface);
        mListener.a(b());
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return a(layoutinflater, viewgroup);
    }

    public void onDestroyView()
    {
        super.onDestroyView();
        f();
        mViews = null;
    }

    public void onDetach()
    {
        super.onDetach();
        mListener = null;
    }

}

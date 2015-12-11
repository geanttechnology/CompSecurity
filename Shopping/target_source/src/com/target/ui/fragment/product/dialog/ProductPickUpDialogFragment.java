// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.product.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.target.mothership.common.a.g;
import com.target.mothership.common.product.c;
import com.target.mothership.model.product.interfaces.ProductDetails;
import com.target.mothership.model.store.interfaces.Store;
import com.target.mothership.model.store.interfaces.StoreSummary;
import com.target.mothership.util.o;
import com.target.ui.adapter.product.ProductDialogAdapter;
import com.target.ui.helper.product.ProductVariationModelHelper;
import com.target.ui.helper.product.b;
import com.target.ui.model.product.GridItem;
import com.target.ui.model.product.ListItem;
import com.target.ui.model.product.ProductVariationModel;
import com.target.ui.util.al;
import com.target.ui.view.product.FixedHeightListView;
import com.target.ui.view.product.ProductDialogErrorView;
import com.target.ui.view.product.ProductDialogHeaderView;
import com.target.ui.view.product.ProductDialogZipCodeView;
import com.target.ui.view.product.ProductPickUpDialogHeaderView;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.target.ui.fragment.product.dialog:
//            BaseProductDialogFragment

public class ProductPickUpDialogFragment extends BaseProductDialogFragment
{
    static class Views extends com.target.ui.view.a
    {

        Button addToCart;
        ViewGroup contentContainer;
        ProductDialogErrorView errorContainer;
        final ProductDialogHeaderView headerView;
        FixedHeightListView listView;
        ViewGroup noRelevantStoresContainer;
        ViewGroup progressContainer;
        final View rootView;
        TextView title;
        ProductDialogZipCodeView zipCodeView;

        Views(Context context, View view)
        {
            super(view);
            rootView = view;
            headerView = new ProductPickUpDialogHeaderView(context);
        }
    }

    private class a
        implements android.view.View.OnClickListener
    {

        final ProductPickUpDialogFragment this$0;

        public void onClick(View view)
        {
            if (com.target.ui.fragment.product.dialog.ProductPickUpDialogFragment.b(ProductPickUpDialogFragment.this) == null)
            {
                return;
            }
            static class _cls1
            {

                static final int $SwitchMap$com$target$ui$fragment$product$dialog$ProductPickUpDialogFragment$ViewType[];
                static final int $SwitchMap$com$target$ui$service$RelevantStoreService$ErrorType[];

                static 
                {
                    $SwitchMap$com$target$ui$service$RelevantStoreService$ErrorType = new int[com.target.ui.service.k.a.values().length];
                    try
                    {
                        $SwitchMap$com$target$ui$service$RelevantStoreService$ErrorType[com.target.ui.service.k.a.RELEVANT_STORE_ERROR.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror3) { }
                    try
                    {
                        $SwitchMap$com$target$ui$service$RelevantStoreService$ErrorType[com.target.ui.service.k.a.NO_RELEVANT_STORES.ordinal()] = 2;
                    }
                    catch (NoSuchFieldError nosuchfielderror2) { }
                    $SwitchMap$com$target$ui$fragment$product$dialog$ProductPickUpDialogFragment$ViewType = new int[f.values().length];
                    try
                    {
                        $SwitchMap$com$target$ui$fragment$product$dialog$ProductPickUpDialogFragment$ViewType[f.PICK_UP_PRODUCT.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror1) { }
                    try
                    {
                        $SwitchMap$com$target$ui$fragment$product$dialog$ProductPickUpDialogFragment$ViewType[f.PICK_UP_VARIATIONS.ordinal()] = 2;
                    }
                    catch (NoSuchFieldError nosuchfielderror)
                    {
                        return;
                    }
                }
            }

            _cls1..SwitchMap.com.target.ui.fragment.product.dialog.ProductPickUpDialogFragment.ViewType[com.target.ui.fragment.product.dialog.ProductPickUpDialogFragment.c(ProductPickUpDialogFragment.this).ordinal()];
            JVM INSTR tableswitch 1 2: default 48
        //                       1 126
        //                       2 137;
               goto _L1 _L2 _L3
_L3:
            break MISSING_BLOCK_LABEL_137;
_L1:
            view = null;
_L4:
            ProductDetails productdetails;
            if (ProductPickUpDialogFragment.d(ProductPickUpDialogFragment.this).H())
            {
                productdetails = ProductPickUpDialogFragment.d(ProductPickUpDialogFragment.this);
            } else
            {
                productdetails = null;
            }
            com.target.ui.fragment.product.dialog.ProductPickUpDialogFragment.b(ProductPickUpDialogFragment.this).a(view, f(), productdetails, ProductPickUpDialogFragment.f(ProductPickUpDialogFragment.this), com.target.ui.fragment.product.dialog.ProductPickUpDialogFragment.g(ProductPickUpDialogFragment.this), ProductPickUpDialogFragment.h(ProductPickUpDialogFragment.this));
            getDialog().dismiss();
            return;
_L2:
            view = ProductPickUpDialogFragment.d(ProductPickUpDialogFragment.this);
              goto _L4
            view = ProductPickUpDialogFragment.e(ProductPickUpDialogFragment.this);
              goto _L4
        }

        private a()
        {
            this$0 = ProductPickUpDialogFragment.this;
            super();
        }

    }

    private class b
        implements com.target.ui.view.product.ProductDialogErrorView.b
    {

        final ProductPickUpDialogFragment this$0;

        public void a()
        {
            ProductPickUpDialogFragment.i(ProductPickUpDialogFragment.this);
        }

        public void a(String s1)
        {
            com.target.ui.fragment.product.dialog.ProductPickUpDialogFragment.b(ProductPickUpDialogFragment.this, s1);
            ProductPickUpDialogFragment.k(ProductPickUpDialogFragment.this).zipCodeView.setZipCode(ProductPickUpDialogFragment.j(ProductPickUpDialogFragment.this));
            ProductPickUpDialogFragment.a(ProductPickUpDialogFragment.this, s1);
        }

        private b()
        {
            this$0 = ProductPickUpDialogFragment.this;
            super();
        }

    }

    private class c
        implements com.target.ui.view.product.ProductDialogHeaderView.a
    {

        final ProductPickUpDialogFragment this$0;

        public void a()
        {
            ProductPickUpDialogFragment.a(ProductPickUpDialogFragment.this);
        }

        public void a(GridItem griditem)
        {
            ProductPickUpDialogFragment.this.a(griditem);
        }

        public void a(ListItem listitem, GridItem griditem)
        {
            ProductPickUpDialogFragment.a(ProductPickUpDialogFragment.this, listitem, griditem);
        }

        private c()
        {
            this$0 = ProductPickUpDialogFragment.this;
            super();
        }

    }

    private class d
        implements com.target.ui.adapter.product.ProductDialogAdapter.a
    {

        final ProductPickUpDialogFragment this$0;

        public void a()
        {
        }

        public void a(Store store)
        {
            if (com.target.ui.fragment.product.dialog.ProductPickUpDialogFragment.b(ProductPickUpDialogFragment.this) == null)
            {
                return;
            } else
            {
                com.target.ui.fragment.product.dialog.ProductPickUpDialogFragment.b(ProductPickUpDialogFragment.this).a(store);
                getDialog().dismiss();
                return;
            }
        }

        public void a(com.target.ui.model.a a1, g g1)
        {
            ProductPickUpDialogFragment.a(ProductPickUpDialogFragment.this, a1.a());
            ProductPickUpDialogFragment.a(ProductPickUpDialogFragment.this, g1);
            ProductPickUpDialogFragment.a(ProductPickUpDialogFragment.this, true);
        }

        private d()
        {
            this$0 = ProductPickUpDialogFragment.this;
            super();
        }

    }

    private class e
        implements com.target.ui.view.product.ProductDialogZipCodeView.b
    {

        final ProductPickUpDialogFragment this$0;

        public void a(String s1)
        {
            ProductPickUpDialogFragment.a(ProductPickUpDialogFragment.this, s1);
        }

        private e()
        {
            this$0 = ProductPickUpDialogFragment.this;
            super();
        }

    }

    private static final class f extends Enum
    {

        private static final f $VALUES[];
        public static final f PICK_UP_PRODUCT;
        public static final f PICK_UP_VARIATIONS;

        public static f valueOf(String s1)
        {
            return (f)Enum.valueOf(com/target/ui/fragment/product/dialog/ProductPickUpDialogFragment$f, s1);
        }

        public static f[] values()
        {
            return (f[])$VALUES.clone();
        }

        static 
        {
            PICK_UP_PRODUCT = new f("PICK_UP_PRODUCT", 0);
            PICK_UP_VARIATIONS = new f("PICK_UP_VARIATIONS", 1);
            $VALUES = (new f[] {
                PICK_UP_PRODUCT, PICK_UP_VARIATIONS
            });
        }

        private f(String s1, int i1)
        {
            super(s1, i1);
        }
    }


    private static final String KEY_PRODUCT_DETAILS = "productDetails";
    private static final String KEY_REQUEST_PRODUCT_DETAILS = "requestProductDetails";
    private static final String KEY_STORES = "stores";
    private static final String KEY_VARIATION_MODEL = "productVariationModel";
    public static final String TAG = com/target/ui/fragment/product/dialog/ProductPickUpDialogFragment.getSimpleName();
    private ProductDialogAdapter mAdapter;
    private StoreSummary mGuestSelectedPickUpStore;
    private ProductDetails mGuestSelectedProductToPickUp;
    private String mGuestSelectedZipCode;
    private Boolean mHasStoreOverride;
    private BaseProductDialogFragment.a mListener;
    private g mPickUpItemType;
    private ProductDetails mProductDetails;
    private ProductVariationModel mProductVariationModel;
    private f mViewType;
    private Views mViews;

    public ProductPickUpDialogFragment()
    {
    }

    static g a(ProductPickUpDialogFragment productpickupdialogfragment, g g1)
    {
        productpickupdialogfragment.mPickUpItemType = g1;
        return g1;
    }

    static StoreSummary a(ProductPickUpDialogFragment productpickupdialogfragment, StoreSummary storesummary)
    {
        productpickupdialogfragment.mGuestSelectedPickUpStore = storesummary;
        return storesummary;
    }

    public static ProductPickUpDialogFragment a(ProductDetails productdetails, ProductVariationModel productvariationmodel, Store store, BaseProductDialogFragment.b b1)
    {
        ProductPickUpDialogFragment productpickupdialogfragment = new ProductPickUpDialogFragment();
        a(((android.support.v4.app.DialogFragment) (productpickupdialogfragment)), b1);
        b1 = new Bundle();
        b1.putParcelable("stores", store);
        b1.putParcelable("productDetails", productdetails);
        b1.putParcelable("productVariationModel", productvariationmodel);
        b1.putBoolean("requestProductDetails", true);
        productpickupdialogfragment.setArguments(b1);
        return productpickupdialogfragment;
    }

    private void a(ProductDetails productdetails)
    {
        while (!mViewType.equals(f.PICK_UP_VARIATIONS) || !j()) 
        {
            return;
        }
        a(((com.target.mothership.model.product.interfaces.Product) (productdetails)));
    }

    static void a(ProductPickUpDialogFragment productpickupdialogfragment)
    {
        productpickupdialogfragment.y();
    }

    static void a(ProductPickUpDialogFragment productpickupdialogfragment, ListItem listitem, GridItem griditem)
    {
        productpickupdialogfragment.a(listitem, griditem);
    }

    static void a(ProductPickUpDialogFragment productpickupdialogfragment, String s1)
    {
        productpickupdialogfragment.b(s1);
    }

    static void a(ProductPickUpDialogFragment productpickupdialogfragment, boolean flag)
    {
        productpickupdialogfragment.b(flag);
    }

    private void a(ListItem listitem, GridItem griditem)
    {
        listitem = ProductVariationModelHelper.a(mProductDetails, mProductVariationModel, f(), listitem, griditem);
        if (listitem == null || listitem.i().equals(com.target.mothership.common.product.c.NOT_AVAILABLE) || listitem.i().equals(com.target.mothership.common.product.c.UNKNOWN))
        {
            w();
            return;
        } else
        {
            b(listitem);
            return;
        }
    }

    private void a(String s1, String s2)
    {
        if (com.target.mothership.util.o.g(s1) || com.target.mothership.util.o.g(s2))
        {
            b(s1, s2);
            return;
        } else
        {
            s();
            return;
        }
    }

    private void a(String s1, boolean flag)
    {
        mViews.errorContainer.a(s1, flag);
        al.a(mViews.errorContainer, new View[] {
            mViews.noRelevantStoresContainer, mViews.progressContainer, mViews.contentContainer
        });
    }

    private void a(boolean flag)
    {
        al.a(mViews.zipCodeView, flag);
    }

    static BaseProductDialogFragment.a b(ProductPickUpDialogFragment productpickupdialogfragment)
    {
        return productpickupdialogfragment.mListener;
    }

    static String b(ProductPickUpDialogFragment productpickupdialogfragment, String s1)
    {
        productpickupdialogfragment.mGuestSelectedZipCode = s1;
        return s1;
    }

    private void b(ProductDetails productdetails)
    {
        c(true);
        b(false);
        mGuestSelectedProductToPickUp = productdetails;
        mViews.headerView.a(mGuestSelectedProductToPickUp);
        if (productdetails.l())
        {
            mViews.headerView.c();
            mAdapter.a(true, true);
            if (com.target.mothership.util.o.g(mGuestSelectedZipCode))
            {
                a(productdetails, mGuestSelectedZipCode);
                return;
            } else
            {
                b(((com.target.mothership.model.product.interfaces.Product) (productdetails)));
                return;
            }
        }
        mAdapter.a(true, false);
        if (com.target.mothership.util.o.g(mGuestSelectedZipCode))
        {
            a(productdetails, mGuestSelectedZipCode);
            return;
        } else
        {
            b(((com.target.mothership.model.product.interfaces.Product) (productdetails)));
            return;
        }
    }

    private void b(String s1)
    {
        c(true);
        a(false);
        b(false);
        mGuestSelectedZipCode = s1;
        if (mGuestSelectedProductToPickUp != null)
        {
            a(mGuestSelectedProductToPickUp, s1);
            return;
        } else
        {
            a(s1);
            return;
        }
    }

    private void b(String s1, String s2)
    {
        mViews.headerView.a(s1, s2);
    }

    private void b(boolean flag)
    {
        mViews.addToCart.setEnabled(flag);
    }

    static f c(ProductPickUpDialogFragment productpickupdialogfragment)
    {
        return productpickupdialogfragment.mViewType;
    }

    private void c(boolean flag)
    {
        al.a(mViews.progressContainer, flag);
        if (flag)
        {
            v();
        }
    }

    static ProductDetails d(ProductPickUpDialogFragment productpickupdialogfragment)
    {
        return productpickupdialogfragment.mProductDetails;
    }

    private void d(com.target.ui.service.k.a a1)
    {
        mViews.errorContainer.setZipCode(mGuestSelectedZipCode);
        a(true);
        switch (_cls1..SwitchMap.com.target.ui.service.RelevantStoreService.ErrorType[a1.ordinal()])
        {
        default:
            a(b(a1), c(a1));
            return;

        case 1: // '\001'
        case 2: // '\002'
            u();
            break;
        }
    }

    static ProductDetails e(ProductPickUpDialogFragment productpickupdialogfragment)
    {
        return productpickupdialogfragment.mGuestSelectedProductToPickUp;
    }

    static ProductVariationModel f(ProductPickUpDialogFragment productpickupdialogfragment)
    {
        return productpickupdialogfragment.mProductVariationModel;
    }

    static StoreSummary g(ProductPickUpDialogFragment productpickupdialogfragment)
    {
        return productpickupdialogfragment.mGuestSelectedPickUpStore;
    }

    static g h(ProductPickUpDialogFragment productpickupdialogfragment)
    {
        return productpickupdialogfragment.mPickUpItemType;
    }

    static void i(ProductPickUpDialogFragment productpickupdialogfragment)
    {
        productpickupdialogfragment.z();
    }

    static String j(ProductPickUpDialogFragment productpickupdialogfragment)
    {
        return productpickupdialogfragment.mGuestSelectedZipCode;
    }

    private boolean j()
    {
        return getArguments().getBoolean("requestProductDetails");
    }

    static Views k(ProductPickUpDialogFragment productpickupdialogfragment)
    {
        return productpickupdialogfragment.mViews;
    }

    private void k()
    {
        mAdapter.a(new d(null));
        mViews.addToCart.setOnClickListener(new a(null));
        mViews.zipCodeView.setZipCodeListener(new e(null));
        mViews.errorContainer.setClickListener(new b(null));
    }

    private void l()
    {
        mAdapter.a(null);
        mViews.addToCart.setOnClickListener(null);
        mViews.zipCodeView.setZipCodeListener(null);
        mViews.errorContainer.setClickListener(null);
    }

    private void m()
    {
        mAdapter = new ProductDialogAdapter(getActivity(), new ArrayList(), true);
        mViews.listView.setAdapter(mAdapter);
        mAdapter.a(false);
    }

    private void n()
    {
        if (mViews == null)
        {
            return;
        }
        q();
        m();
        c(true);
        a(true);
        switch (_cls1..SwitchMap.com.target.ui.fragment.product.dialog.ProductPickUpDialogFragment.ViewType[mViewType.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            o();
            return;

        case 2: // '\002'
            p();
            break;
        }
    }

    private void o()
    {
        mGuestSelectedProductToPickUp = mProductDetails;
        mAdapter.a(true, true);
        b(mProductDetails);
    }

    private void p()
    {
        mAdapter.a(false, false);
        i();
    }

    private void q()
    {
        if (!mViewType.equals(f.PICK_UP_PRODUCT))
        {
            mViews.headerView.a(mProductVariationModel);
        }
        mViews.headerView.a(mProductDetails);
        mViews.headerView.setClickListener(new c(null));
        mViews.listView.addHeaderView(mViews.headerView);
    }

    private void r()
    {
        if (mProductVariationModel == null)
        {
            return;
        } else
        {
            mViews.headerView.a(mProductVariationModel);
            mViews.headerView.a(mProductDetails);
            return;
        }
    }

    private void s()
    {
        mViews.headerView.c();
    }

    private void t()
    {
        c(false);
        al.a(mViews.contentContainer, new View[] {
            mViews.errorContainer, mViews.noRelevantStoresContainer
        });
    }

    private void u()
    {
        c(false);
        al.a(mViews.noRelevantStoresContainer, new View[] {
            mViews.errorContainer
        });
    }

    private void v()
    {
        al.a(new View[] {
            mViews.errorContainer, mViews.noRelevantStoresContainer
        });
    }

    private void w()
    {
        mGuestSelectedProductToPickUp = null;
        mViews.headerView.a(mGuestSelectedProductToPickUp);
        x();
    }

    private void x()
    {
        b(false);
        a(false);
        c(false);
        mAdapter.a(new ArrayList());
        a(getString(0x7f090452), getString(0x7f09044e));
    }

    private void y()
    {
        mViews.headerView.a(mProductDetails);
        s();
        b(false);
        c(true);
        mAdapter.a(false, false);
        if (com.target.mothership.util.o.g(mGuestSelectedZipCode))
        {
            a(mGuestSelectedZipCode);
            return;
        } else
        {
            i();
            return;
        }
    }

    private void z()
    {
        c(true);
        b(false);
        switch (_cls1..SwitchMap.com.target.ui.fragment.product.dialog.ProductPickUpDialogFragment.ViewType[mViewType.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            if (com.target.mothership.util.o.g(mGuestSelectedZipCode))
            {
                a(mProductDetails, mGuestSelectedZipCode);
                return;
            } else
            {
                b(mProductDetails);
                return;
            }

        case 2: // '\002'
            break;
        }
        if (mGuestSelectedProductToPickUp == null)
        {
            if (com.target.mothership.util.o.g(mGuestSelectedZipCode))
            {
                a(mGuestSelectedZipCode);
                return;
            } else
            {
                i();
                return;
            }
        }
        if (com.target.mothership.util.o.g(mGuestSelectedZipCode))
        {
            a(mGuestSelectedProductToPickUp, mGuestSelectedZipCode);
            return;
        } else
        {
            b(mGuestSelectedProductToPickUp);
            return;
        }
    }

    protected View a(LayoutInflater layoutinflater, ViewGroup viewgroup)
    {
        layoutinflater = layoutinflater.inflate(0x7f0301c5, viewgroup, false);
        mViews = new Views(getActivity(), layoutinflater);
        n();
        a(mProductDetails);
        k();
        b(false);
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
            r();
            return;
        }
    }

    protected void a(com.target.ui.service.k.a a1)
    {
        if (mViews == null)
        {
            return;
        } else
        {
            d(a1);
            return;
        }
    }

    protected void a(Boolean boolean1)
    {
        if (mViews == null)
        {
            return;
        } else
        {
            mHasStoreOverride = boolean1;
            mAdapter.a(mHasStoreOverride.booleanValue());
            mAdapter.notifyDataSetChanged();
            return;
        }
    }

    protected void a(List list)
    {
        if (mViews == null || list.isEmpty())
        {
            return;
        } else
        {
            mAdapter.a(list);
            a(true);
            t();
            return;
        }
    }

    protected Store b()
    {
        return (Store)getArguments().getParcelable("stores");
    }

    protected void c()
    {
        mProductDetails = (ProductDetails)getArguments().getParcelable("productDetails");
        mProductVariationModel = (ProductVariationModel)getArguments().getParcelable("productVariationModel");
        f f1;
        if (mProductDetails.H())
        {
            f1 = f.PICK_UP_VARIATIONS;
        } else
        {
            f1 = f.PICK_UP_PRODUCT;
        }
        mViewType = f1;
    }

    protected BaseProductDialogFragment.a d()
    {
        return mListener;
    }

    protected ProductVariationModel e()
    {
        if (mViews == null)
        {
            return null;
        } else
        {
            return mViews.headerView.getVariationModel();
        }
    }

    protected com.target.ui.helper.product.b f()
    {
        return com.target.ui.helper.product.b.PICK_UP;
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
            mViews.headerView.b();
        }
        mViews = null;
    }

    public void onDetach()
    {
        super.onDetach();
        mListener = null;
    }

}

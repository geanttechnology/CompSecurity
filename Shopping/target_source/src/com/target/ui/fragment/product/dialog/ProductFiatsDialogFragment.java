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
import android.widget.ListView;
import android.widget.TextView;
import com.target.mothership.common.a.g;
import com.target.mothership.common.product.c;
import com.target.mothership.model.product.interfaces.ProductDetails;
import com.target.mothership.model.store.interfaces.Store;
import com.target.mothership.util.o;
import com.target.ui.adapter.product.ProductDialogAdapter;
import com.target.ui.helper.product.ProductVariationModelHelper;
import com.target.ui.helper.product.b;
import com.target.ui.model.product.GridItem;
import com.target.ui.model.product.ListItem;
import com.target.ui.model.product.ProductVariationModel;
import com.target.ui.util.al;
import com.target.ui.view.common.TargetErrorView;
import com.target.ui.view.product.ProductDialogHeaderView;
import com.target.ui.view.product.ProductDialogZipCodeView;
import com.target.ui.view.product.ProductFiatsDialogHeaderView;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.target.ui.fragment.product.dialog:
//            BaseProductDialogFragment

public class ProductFiatsDialogFragment extends BaseProductDialogFragment
{
    static class Views extends com.target.ui.view.a
    {

        ViewGroup contentContainer;
        TargetErrorView errorContainer;
        final ProductDialogHeaderView headerView;
        ListView listView;
        ViewGroup noRelevantStoresContainer;
        ViewGroup progressContainer;
        TextView title;
        ProductDialogZipCodeView zipCodeChooser;

        Views(Context context, View view)
        {
            super(view);
            headerView = new ProductFiatsDialogHeaderView(context);
        }
    }

    private class a
        implements com.target.ui.view.common.c
    {

        final ProductFiatsDialogFragment this$0;

        public void A_()
        {
            ProductFiatsDialogFragment.f(ProductFiatsDialogFragment.this);
        }

        private a()
        {
            this$0 = ProductFiatsDialogFragment.this;
            super();
        }

    }

    private class b
        implements com.target.ui.view.product.ProductDialogHeaderView.a
    {

        final ProductFiatsDialogFragment this$0;

        public void a()
        {
            ProductFiatsDialogFragment.a(ProductFiatsDialogFragment.this);
        }

        public void a(GridItem griditem)
        {
            ProductFiatsDialogFragment.this.a(griditem);
        }

        public void a(ListItem listitem, GridItem griditem)
        {
            listitem = ProductVariationModelHelper.a(com.target.ui.fragment.product.dialog.ProductFiatsDialogFragment.b(ProductFiatsDialogFragment.this), com.target.ui.fragment.product.dialog.ProductFiatsDialogFragment.c(ProductFiatsDialogFragment.this), f(), listitem, griditem);
            if (listitem == null)
            {
                ProductFiatsDialogFragment.d(ProductFiatsDialogFragment.this);
                return;
            } else
            {
                ProductFiatsDialogFragment.a(ProductFiatsDialogFragment.this, listitem);
                return;
            }
        }

        private b()
        {
            this$0 = ProductFiatsDialogFragment.this;
            super();
        }

    }

    private class c
        implements com.target.ui.adapter.product.ProductDialogAdapter.a
    {

        final ProductFiatsDialogFragment this$0;

        public void a()
        {
        }

        public void a(Store store)
        {
            if (ProductFiatsDialogFragment.e(ProductFiatsDialogFragment.this) == null)
            {
                return;
            } else
            {
                ProductFiatsDialogFragment.e(ProductFiatsDialogFragment.this).a(store);
                getDialog().dismiss();
                return;
            }
        }

        public void a(com.target.ui.model.a a1, g g)
        {
        }

        private c()
        {
            this$0 = ProductFiatsDialogFragment.this;
            super();
        }

    }

    private class d
        implements com.target.ui.view.product.ProductDialogZipCodeView.b
    {

        final ProductFiatsDialogFragment this$0;

        public void a(String s1)
        {
            ProductFiatsDialogFragment.a(ProductFiatsDialogFragment.this, s1);
        }

        private d()
        {
            this$0 = ProductFiatsDialogFragment.this;
            super();
        }

    }

    private static final class e extends Enum
    {

        private static final e $VALUES[];
        public static final e FIND_IN_STORE;
        public static final e FIND_IN_STORE_VARIATIONS;

        public static e valueOf(String s1)
        {
            return (e)Enum.valueOf(com/target/ui/fragment/product/dialog/ProductFiatsDialogFragment$e, s1);
        }

        public static e[] values()
        {
            return (e[])$VALUES.clone();
        }

        static 
        {
            FIND_IN_STORE = new e("FIND_IN_STORE", 0);
            FIND_IN_STORE_VARIATIONS = new e("FIND_IN_STORE_VARIATIONS", 1);
            $VALUES = (new e[] {
                FIND_IN_STORE, FIND_IN_STORE_VARIATIONS
            });
        }

        private e(String s1, int i)
        {
            super(s1, i);
        }
    }


    private static final String KEY_PRODUCT_DETAILS = "productDetails";
    private static final String KEY_REQUEST_PRODUCT_DETAILS = "requestProductDetails";
    private static final String KEY_STORES = "stores";
    private static final String KEY_VARIATION_MODEL = "productVariationModel";
    public static final String TAG = com/target/ui/fragment/product/dialog/ProductFiatsDialogFragment.getSimpleName();
    private ProductDialogAdapter mAdapter;
    private ProductDetails mGuestSelectedProductToFiats;
    private String mGuestSelectedZipCode;
    private Boolean mHasStoreOverride;
    private BaseProductDialogFragment.a mListener;
    private ProductDetails mProductDetails;
    private ProductVariationModel mProductVariationModel;
    private e mViewType;
    private Views mViews;

    public ProductFiatsDialogFragment()
    {
    }

    private void A()
    {
        a(true);
        static class _cls1
        {

            static final int $SwitchMap$com$target$ui$fragment$product$dialog$ProductFiatsDialogFragment$ViewType[];
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
                $SwitchMap$com$target$ui$fragment$product$dialog$ProductFiatsDialogFragment$ViewType = new int[e.values().length];
                try
                {
                    $SwitchMap$com$target$ui$fragment$product$dialog$ProductFiatsDialogFragment$ViewType[e.FIND_IN_STORE.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$target$ui$fragment$product$dialog$ProductFiatsDialogFragment$ViewType[e.FIND_IN_STORE_VARIATIONS.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.target.ui.fragment.product.dialog.ProductFiatsDialogFragment.ViewType[mViewType.ordinal()])
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
        if (mGuestSelectedProductToFiats == null)
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
            a(mGuestSelectedProductToFiats, mGuestSelectedZipCode);
            return;
        } else
        {
            b(mGuestSelectedProductToFiats);
            return;
        }
    }

    public static ProductFiatsDialogFragment a(ProductDetails productdetails, ProductVariationModel productvariationmodel, Store store, BaseProductDialogFragment.b b1)
    {
        ProductFiatsDialogFragment productfiatsdialogfragment = new ProductFiatsDialogFragment();
        a(((android.support.v4.app.DialogFragment) (productfiatsdialogfragment)), b1);
        b1 = new Bundle();
        b1.putParcelable("stores", store);
        b1.putParcelable("productVariationModel", productvariationmodel);
        b1.putParcelable("productDetails", productdetails);
        b1.putBoolean("requestProductDetails", true);
        productfiatsdialogfragment.setArguments(b1);
        return productfiatsdialogfragment;
    }

    private void a(ProductDetails productdetails)
    {
        while (!mViewType.equals(e.FIND_IN_STORE_VARIATIONS) || !j()) 
        {
            return;
        }
        a(((com.target.mothership.model.product.interfaces.Product) (productdetails)));
    }

    private void a(e e1)
    {
        switch (_cls1..SwitchMap.com.target.ui.fragment.product.dialog.ProductFiatsDialogFragment.ViewType[e1.ordinal()])
        {
        default:
            return;

        case 2: // '\002'
            if (x() != null)
            {
                mAdapter.a(true, false);
                return;
            } else
            {
                mAdapter.a(false, false);
                return;
            }

        case 1: // '\001'
            mAdapter.a(true, false);
            return;
        }
    }

    static void a(ProductFiatsDialogFragment productfiatsdialogfragment)
    {
        productfiatsdialogfragment.z();
    }

    static void a(ProductFiatsDialogFragment productfiatsdialogfragment, ProductDetails productdetails)
    {
        productfiatsdialogfragment.b(productdetails);
    }

    static void a(ProductFiatsDialogFragment productfiatsdialogfragment, String s1)
    {
        productfiatsdialogfragment.b(s1);
    }

    private void a(String s1, boolean flag)
    {
        mViews.errorContainer.a("", s1, flag);
        al.a(mViews.errorContainer, new View[] {
            mViews.progressContainer, mViews.contentContainer
        });
    }

    private void a(boolean flag)
    {
        al.a(mViews.progressContainer, flag);
        if (flag)
        {
            w();
        }
    }

    static ProductDetails b(ProductFiatsDialogFragment productfiatsdialogfragment)
    {
        return productfiatsdialogfragment.mProductDetails;
    }

    private void b(ProductDetails productdetails)
    {
        if (productdetails.i().equals(com.target.mothership.common.product.c.ONLINE_ONLY))
        {
            u();
            return;
        }
        v();
        a(true);
        mGuestSelectedProductToFiats = productdetails;
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
        a(true);
        mGuestSelectedZipCode = s1;
        switch (_cls1..SwitchMap.com.target.ui.fragment.product.dialog.ProductFiatsDialogFragment.ViewType[mViewType.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            a(mProductDetails, s1);
            return;

        case 2: // '\002'
            break;
        }
        if (mGuestSelectedProductToFiats == null)
        {
            a(s1);
            return;
        } else
        {
            a(mGuestSelectedProductToFiats, s1);
            return;
        }
    }

    static ProductVariationModel c(ProductFiatsDialogFragment productfiatsdialogfragment)
    {
        return productfiatsdialogfragment.mProductVariationModel;
    }

    static void d(ProductFiatsDialogFragment productfiatsdialogfragment)
    {
        productfiatsdialogfragment.y();
    }

    private void d(com.target.ui.service.k.a a1)
    {
        switch (_cls1..SwitchMap.com.target.ui.service.RelevantStoreService.ErrorType[a1.ordinal()])
        {
        default:
            a(b(a1), c(a1));
            mViews.zipCodeChooser.setZipCode(mGuestSelectedZipCode);
            return;

        case 1: // '\001'
        case 2: // '\002'
            t();
            break;
        }
    }

    static BaseProductDialogFragment.a e(ProductFiatsDialogFragment productfiatsdialogfragment)
    {
        return productfiatsdialogfragment.mListener;
    }

    static void f(ProductFiatsDialogFragment productfiatsdialogfragment)
    {
        productfiatsdialogfragment.A();
    }

    private boolean j()
    {
        return getArguments().getBoolean("requestProductDetails");
    }

    private void k()
    {
        mAdapter.a(new c(null));
        mViews.zipCodeChooser.setZipCodeListener(new d(null));
        mViews.headerView.setClickListener(new b(null));
        mViews.errorContainer.setClickListener(new a(null));
    }

    private void l()
    {
        mAdapter.a(null);
        mViews.zipCodeChooser.setZipCodeListener(null);
        mViews.headerView.setClickListener(null);
        mViews.errorContainer.setClickListener(null);
    }

    private void m()
    {
        q();
        mAdapter = new ProductDialogAdapter(getActivity(), new ArrayList(), false);
        mAdapter.b(true);
        mAdapter.a(false);
        mViews.listView.setAdapter(mAdapter);
    }

    private void n()
    {
        if (mViews == null)
        {
            return;
        }
        switch (_cls1..SwitchMap.com.target.ui.fragment.product.dialog.ProductFiatsDialogFragment.ViewType[mViewType.ordinal()])
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
        a(mViewType);
        a(true);
        b(mProductDetails);
    }

    private void p()
    {
        a(mViewType);
        a(true);
        ProductDetails productdetails = x();
        if (productdetails != null)
        {
            b(productdetails);
            return;
        } else
        {
            i();
            return;
        }
    }

    private void q()
    {
        if (!mViewType.equals(e.FIND_IN_STORE_VARIATIONS))
        {
            return;
        } else
        {
            mViews.headerView.a(mProductVariationModel);
            mViews.headerView.a(mProductDetails);
            mViews.listView.addHeaderView(mViews.headerView);
            return;
        }
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
        a(false);
        al.a(mViews.contentContainer, new View[] {
            mViews.noRelevantStoresContainer, mViews.errorContainer
        });
    }

    private void t()
    {
        a(false);
        al.a(mViews.noRelevantStoresContainer, new View[] {
            mViews.errorContainer
        });
    }

    private void u()
    {
        String s1 = getString(0x7f090452);
        String s2 = getString(0x7f09044e);
        mViews.headerView.a(s1, s2);
        mAdapter.a(new ArrayList());
        al.a(new View[] {
            mViews.zipCodeChooser, mViews.noRelevantStoresContainer
        });
    }

    private void v()
    {
        mViews.headerView.c();
        al.a(mViews.zipCodeChooser, new View[] {
            mViews.noRelevantStoresContainer
        });
    }

    private void w()
    {
        al.a(new View[] {
            mViews.errorContainer, mViews.noRelevantStoresContainer
        });
    }

    private ProductDetails x()
    {
        return ProductVariationModelHelper.a(mProductDetails, mProductVariationModel, f());
    }

    private void y()
    {
        u();
        mGuestSelectedProductToFiats = null;
    }

    private void z()
    {
        mAdapter.a(false, false);
        if (com.target.mothership.util.o.g(mGuestSelectedZipCode))
        {
            a(mGuestSelectedZipCode);
            return;
        } else
        {
            i();
            mGuestSelectedProductToFiats = null;
            return;
        }
    }

    protected View a(LayoutInflater layoutinflater, ViewGroup viewgroup)
    {
        layoutinflater = layoutinflater.inflate(0x7f0301c3, viewgroup, false);
        mViews = new Views(getActivity(), layoutinflater);
        m();
        a(mProductDetails);
        k();
        n();
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
        if (mViews == null)
        {
            return;
        } else
        {
            mAdapter.a(list);
            s();
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
        e e1;
        if (mProductDetails.H())
        {
            e1 = e.FIND_IN_STORE_VARIATIONS;
        } else
        {
            e1 = e.FIND_IN_STORE;
        }
        mViewType = e1;
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
        return com.target.ui.helper.product.b.UNKNOWN;
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
        mViews = null;
    }

    public void onDetach()
    {
        super.onDetach();
        mListener = null;
    }

}

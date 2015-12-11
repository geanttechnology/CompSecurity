// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.product.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import com.target.mothership.model.list.interfaces.ListItem;
import com.target.mothership.model.list.interfaces.ListSummary;
import com.target.mothership.model.product.interfaces.Product;
import com.target.ui.adapter.product.ProductAddToListDialogAdapter;
import com.target.ui.fragment.common.BaseDialogFragment;
import com.target.ui.helper.j.a;
import com.target.ui.helper.j.b;
import com.target.ui.view.product.ProductAddToListFooter;
import java.util.ArrayList;
import java.util.List;

public class ProductAddToListDialogFragment extends BaseDialogFragment
{
    static class Views extends com.target.ui.view.a
    {

        Button cancelBtn;
        Button doneBtn;
        ProductAddToListFooter footer;
        ListView listView;

        public Views(Context context, View view)
        {
            super(view);
            footer = new ProductAddToListFooter(context);
        }
    }

    private class a
        implements com.target.ui.adapter.product.ProductAddToListDialogAdapter.a
    {

        final ProductAddToListDialogFragment this$0;

        public void a(ListSummary listsummary)
        {
            if (ProductAddToListDialogFragment.c(ProductAddToListDialogFragment.this) == null)
            {
                return;
            } else
            {
                com.target.ui.fragment.product.dialog.ProductAddToListDialogFragment.a(ProductAddToListDialogFragment.this, listsummary);
                com.target.ui.fragment.product.dialog.ProductAddToListDialogFragment.a(ProductAddToListDialogFragment.this, true);
                ProductAddToListDialogFragment.c(ProductAddToListDialogFragment.this).footer.a();
                return;
            }
        }

        private a()
        {
            this$0 = ProductAddToListDialogFragment.this;
            super();
        }

    }

    public static interface b
    {

        public abstract void a();

        public abstract void a(ListSummary listsummary);

        public abstract void b();
    }

    public static interface c
    {

        public abstract b s_();
    }

    private class d
        implements com.target.ui.helper.j.b.d
    {

        final ProductAddToListDialogFragment this$0;

        public void a(ListItem listitem, int j, ListSummary listsummary)
        {
        }

        public void a(ListItem listitem, ListSummary listsummary)
        {
            if (ProductAddToListDialogFragment.d(ProductAddToListDialogFragment.this) == null)
            {
                return;
            } else
            {
                com.target.ui.fragment.product.dialog.ProductAddToListDialogFragment.b(ProductAddToListDialogFragment.this, true);
                ProductAddToListDialogFragment.d(ProductAddToListDialogFragment.this).a(listsummary);
                getDialog().dismiss();
                return;
            }
        }

        public void a(com.target.ui.helper.j.b.n n, String s)
        {
            if (ProductAddToListDialogFragment.d(ProductAddToListDialogFragment.this) != null)
            {
                com.target.ui.fragment.product.dialog.ProductAddToListDialogFragment.b(ProductAddToListDialogFragment.this, true);
                ProductAddToListDialogFragment.d(ProductAddToListDialogFragment.this).a();
            }
        }

        private d()
        {
            this$0 = ProductAddToListDialogFragment.this;
            super();
        }

    }

    private class e
        implements android.view.View.OnClickListener
    {

        final ProductAddToListDialogFragment this$0;

        public void onClick(View view)
        {
            getDialog().dismiss();
        }

        private e()
        {
            this$0 = ProductAddToListDialogFragment.this;
            super();
        }

    }

    private class f
        implements android.view.View.OnClickListener
    {

        final ProductAddToListDialogFragment this$0;

        public void onClick(View view)
        {
            com.target.ui.fragment.product.dialog.ProductAddToListDialogFragment.a(ProductAddToListDialogFragment.this);
        }

        private f()
        {
            this$0 = ProductAddToListDialogFragment.this;
            super();
        }

    }

    private class g
        implements com.target.ui.view.product.ProductAddToListFooter.a
    {

        final ProductAddToListDialogFragment this$0;

        public void a()
        {
            com.target.ui.fragment.product.dialog.ProductAddToListDialogFragment.a(ProductAddToListDialogFragment.this, null);
            com.target.ui.fragment.product.dialog.ProductAddToListDialogFragment.b(ProductAddToListDialogFragment.this).b();
        }

        public void a(boolean flag)
        {
            com.target.ui.fragment.product.dialog.ProductAddToListDialogFragment.a(ProductAddToListDialogFragment.this, flag);
        }

        private g()
        {
            this$0 = ProductAddToListDialogFragment.this;
            super();
        }

    }

    private class h
        implements com.target.ui.helper.j.a.b, com.target.ui.helper.j.a.e
    {

        final ProductAddToListDialogFragment this$0;

        public void a(ListSummary listsummary)
        {
            com.target.ui.fragment.product.dialog.ProductAddToListDialogFragment.b(ProductAddToListDialogFragment.this, listsummary);
        }

        public void a(com.target.mothership.model.list.interfaces.a.a a1)
        {
            if (ProductAddToListDialogFragment.d(ProductAddToListDialogFragment.this) != null)
            {
                com.target.ui.fragment.product.dialog.ProductAddToListDialogFragment.b(ProductAddToListDialogFragment.this, true);
                ProductAddToListDialogFragment.d(ProductAddToListDialogFragment.this).a();
            }
        }

        public void a(List list)
        {
            com.target.ui.fragment.product.dialog.ProductAddToListDialogFragment.a(ProductAddToListDialogFragment.this, list);
        }

        private h()
        {
            this$0 = ProductAddToListDialogFragment.this;
            super();
        }

    }

    private static final class i extends Enum
    {

        private static final i $VALUES[];
        public static final i GENERIC_PRODUCT;
        public static final i SPECIFIC_PRODUCT;

        public static i valueOf(String s)
        {
            return (i)Enum.valueOf(com/target/ui/fragment/product/dialog/ProductAddToListDialogFragment$i, s);
        }

        public static i[] values()
        {
            return (i[])$VALUES.clone();
        }

        static 
        {
            SPECIFIC_PRODUCT = new i("SPECIFIC_PRODUCT", 0);
            GENERIC_PRODUCT = new i("GENERIC_PRODUCT", 1);
            $VALUES = (new i[] {
                SPECIFIC_PRODUCT, GENERIC_PRODUCT
            });
        }

        private i(String s, int j)
        {
            super(s, j);
        }
    }


    private static final String KEY_PRODUCT = "product";
    private static final String KEY_TITLE = "title";
    private static final String KEY_VIEW_TYPE = "viewType";
    public static final String TAG = com/target/ui/fragment/product/dialog/ProductAddToListDialogFragment.getSimpleName();
    private ProductAddToListDialogAdapter mAdapter;
    private com.target.ui.helper.j.a mListDataHelper;
    private ListSummary mListSummary;
    private b mListener;
    private Product mProduct;
    private boolean mSkipDismissDialogCallBack;
    private String mTitle;
    private i mViewType;
    private Views mViews;

    public ProductAddToListDialogFragment()
    {
        mSkipDismissDialogCallBack = false;
    }

    private View a(LayoutInflater layoutinflater, ViewGroup viewgroup)
    {
        layoutinflater = layoutinflater.inflate(0x7f03006d, viewgroup, false);
        mViews = new Views(getActivity(), layoutinflater);
        e();
        d();
        f();
        b();
        return layoutinflater;
    }

    static ListSummary a(ProductAddToListDialogFragment productaddtolistdialogfragment, ListSummary listsummary)
    {
        productaddtolistdialogfragment.mListSummary = listsummary;
        return listsummary;
    }

    public static ProductAddToListDialogFragment a(Product product, c c1)
    {
        ProductAddToListDialogFragment productaddtolistdialogfragment = new ProductAddToListDialogFragment();
        a(((DialogFragment) (productaddtolistdialogfragment)), c1);
        c1 = new Bundle();
        c1.putParcelable("product", product);
        c1.putInt("viewType", i.SPECIFIC_PRODUCT.ordinal());
        productaddtolistdialogfragment.setArguments(c1);
        return productaddtolistdialogfragment;
    }

    public static ProductAddToListDialogFragment a(String s, c c1)
    {
        ProductAddToListDialogFragment productaddtolistdialogfragment = new ProductAddToListDialogFragment();
        a(((DialogFragment) (productaddtolistdialogfragment)), c1);
        c1 = new Bundle();
        c1.putString("title", s);
        c1.putInt("viewType", i.GENERIC_PRODUCT.ordinal());
        productaddtolistdialogfragment.setArguments(c1);
        return productaddtolistdialogfragment;
    }

    private void a()
    {
        mProduct = (Product)getArguments().getParcelable("product");
        mTitle = getArguments().getString("title");
        mViewType = i.values()[getArguments().getInt("viewType")];
        mListDataHelper = new com.target.ui.helper.j.a();
        mListSummary = null;
    }

    private static void a(DialogFragment dialogfragment, c c1)
        throws IllegalArgumentException
    {
        if (c1 == null)
        {
            throw new IllegalArgumentException("ProductAddToListDialogFragment listener cannot be null");
        }
        if (!(c1 instanceof Fragment))
        {
            throw new IllegalArgumentException("Must implement AddToListDialogListenerProvider");
        } else
        {
            dialogfragment.setTargetFragment((Fragment)c1, 0);
            return;
        }
    }

    private void a(ListSummary listsummary)
    {
        listsummary = new com.target.ui.helper.j.b(listsummary);
        static class _cls1
        {

            static final int $SwitchMap$com$target$ui$fragment$product$dialog$ProductAddToListDialogFragment$ViewType[];

            static 
            {
                $SwitchMap$com$target$ui$fragment$product$dialog$ProductAddToListDialogFragment$ViewType = new int[i.values().length];
                try
                {
                    $SwitchMap$com$target$ui$fragment$product$dialog$ProductAddToListDialogFragment$ViewType[i.SPECIFIC_PRODUCT.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$target$ui$fragment$product$dialog$ProductAddToListDialogFragment$ViewType[i.GENERIC_PRODUCT.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.target.ui.fragment.product.dialog.ProductAddToListDialogFragment.ViewType[mViewType.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            listsummary.a(mProduct, new d(null));
            return;

        case 2: // '\002'
            listsummary.a(mTitle, new d(null));
            break;
        }
    }

    static void a(ProductAddToListDialogFragment productaddtolistdialogfragment)
    {
        productaddtolistdialogfragment.h();
    }

    static void a(ProductAddToListDialogFragment productaddtolistdialogfragment, List list)
    {
        productaddtolistdialogfragment.a(list);
    }

    static void a(ProductAddToListDialogFragment productaddtolistdialogfragment, boolean flag)
    {
        productaddtolistdialogfragment.a(flag);
    }

    private void a(String s)
    {
        mListDataHelper.a(s, null, null, null, new h(null));
    }

    private void a(List list)
    {
        if (mViews == null || mAdapter == null)
        {
            return;
        } else
        {
            mAdapter.a(list);
            mListSummary = mAdapter.a();
            return;
        }
    }

    private void a(boolean flag)
    {
        mViews.doneBtn.setEnabled(flag);
    }

    static ProductAddToListDialogAdapter b(ProductAddToListDialogFragment productaddtolistdialogfragment)
    {
        return productaddtolistdialogfragment.mAdapter;
    }

    private void b()
    {
        mViews.cancelBtn.setOnClickListener(new e(null));
        mViews.doneBtn.setOnClickListener(new f(null));
        mViews.footer.setClickListener(new g(null));
    }

    static void b(ProductAddToListDialogFragment productaddtolistdialogfragment, ListSummary listsummary)
    {
        productaddtolistdialogfragment.a(listsummary);
    }

    static boolean b(ProductAddToListDialogFragment productaddtolistdialogfragment, boolean flag)
    {
        productaddtolistdialogfragment.mSkipDismissDialogCallBack = flag;
        return flag;
    }

    static Views c(ProductAddToListDialogFragment productaddtolistdialogfragment)
    {
        return productaddtolistdialogfragment.mViews;
    }

    private void c()
    {
        mViews.cancelBtn.setOnClickListener(null);
        mViews.doneBtn.setOnClickListener(null);
        mViews.footer.setClickListener(null);
    }

    static b d(ProductAddToListDialogFragment productaddtolistdialogfragment)
    {
        return productaddtolistdialogfragment.mListener;
    }

    private void d()
    {
        mAdapter = new ProductAddToListDialogAdapter(getActivity(), new ArrayList());
        mAdapter.a(new a(null));
        mViews.listView.setAdapter(mAdapter);
    }

    private void e()
    {
        mViews.listView.addFooterView(mViews.footer);
    }

    private void f()
    {
        if (mListDataHelper == null)
        {
            return;
        } else
        {
            mListDataHelper.a(new h(null));
            return;
        }
    }

    private void g()
    {
        while (mListener == null || mSkipDismissDialogCallBack) 
        {
            return;
        }
        mListener.b();
    }

    private void h()
    {
        if (mViews == null)
        {
            return;
        }
        if (mViews.footer.isSelected())
        {
            a(mViews.footer.getShoppingListTitle());
            return;
        } else
        {
            a(mListSummary);
            return;
        }
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        if (getTargetFragment() instanceof c)
        {
            mListener = ((c)getTargetFragment()).s_();
            return;
        } else
        {
            throw new IllegalStateException("Make sure to implement AddToListDialogListenerProvider");
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        a();
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return a(layoutinflater, viewgroup);
    }

    public void onDestroyView()
    {
        super.onDestroyView();
        c();
        mViews = null;
    }

    public void onDetach()
    {
        super.onDetach();
        mListener = null;
    }

    public void onStop()
    {
        g();
        super.onStop();
    }

}

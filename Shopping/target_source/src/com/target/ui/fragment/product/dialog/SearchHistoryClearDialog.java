// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.product.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.target.ui.fragment.common.BaseDialogFragment;
import com.target.ui.helper.o.c;
import com.target.ui.util.ai;

public class SearchHistoryClearDialog extends BaseDialogFragment
{
    static class Views extends com.target.ui.view.a
    {

        Button cancel;
        Button clearBtn;
        TextView subTitle;
        TextView title;

        public Views(View view)
        {
            super(view);
        }
    }

    private class a
        implements android.view.View.OnClickListener
    {

        final SearchHistoryClearDialog this$0;

        public void onClick(View view)
        {
            view.getId();
            JVM INSTR tableswitch 2131756454 2131756455: default 28
        //                       2131756454 37
        //                       2131756455 29;
               goto _L1 _L2 _L3
_L1:
            return;
_L3:
            a();
            return;
_L2:
            if (getDialog() != null)
            {
                getDialog().cancel();
                return;
            }
            if (true) goto _L1; else goto _L4
_L4:
        }

        private a()
        {
            this$0 = SearchHistoryClearDialog.this;
            super();
        }

    }

    public static interface b
    {

        public abstract void c();
    }

    private class c
        implements com.target.ui.helper.o.c.a
    {

        final SearchHistoryClearDialog this$0;

        public void a()
        {
            if (SearchHistoryClearDialog.a(SearchHistoryClearDialog.this) != null)
            {
                SearchHistoryClearDialog.a(SearchHistoryClearDialog.this).c();
            }
            if (getDialog() == null)
            {
                return;
            } else
            {
                getDialog().dismiss();
                return;
            }
        }

        public void b()
        {
            ai.a(SearchHistoryClearDialog.this, "Unable to clear recent items!");
            if (getDialog() == null)
            {
                return;
            } else
            {
                getDialog().dismiss();
                return;
            }
        }

        private c()
        {
            this$0 = SearchHistoryClearDialog.this;
            super();
        }

    }


    public static final String TAG = com/target/ui/fragment/product/dialog/SearchHistoryClearDialog.getSimpleName();
    private b mListener;
    private com.target.ui.helper.o.c mSearchDataHelper;
    private Views mViews;

    public SearchHistoryClearDialog()
    {
    }

    private View a(LayoutInflater layoutinflater, ViewGroup viewgroup)
    {
        layoutinflater = layoutinflater.inflate(0x7f0301eb, viewgroup, false);
        mViews = new Views(layoutinflater);
        b();
        return layoutinflater;
    }

    static b a(SearchHistoryClearDialog searchhistorycleardialog)
    {
        return searchhistorycleardialog.mListener;
    }

    public static SearchHistoryClearDialog a(b b1)
    {
        SearchHistoryClearDialog searchhistorycleardialog = new SearchHistoryClearDialog();
        a(((DialogFragment) (searchhistorycleardialog)), b1);
        return searchhistorycleardialog;
    }

    private static void a(DialogFragment dialogfragment, b b1)
        throws IllegalArgumentException
    {
        if (b1 == null)
        {
            throw new IllegalArgumentException("SearchHistoryClearDialogListener cannot be null");
        }
        if (!(b1 instanceof Fragment))
        {
            throw new IllegalArgumentException("Must implement SearchHistoryClearDialogListener");
        } else
        {
            dialogfragment.setTargetFragment((Fragment)b1, 0);
            return;
        }
    }

    private void b()
    {
        mViews.clearBtn.setOnClickListener(new a());
        mViews.cancel.setOnClickListener(new a());
    }

    private void c()
    {
        mViews.clearBtn.setOnClickListener(null);
        mViews.cancel.setOnClickListener(null);
    }

    protected void a()
    {
        mSearchDataHelper.a(new c());
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
            throw new IllegalStateException("Make sure to implement AddToListDialogListener");
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        mSearchDataHelper = new com.target.ui.helper.o.c();
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return a(layoutinflater, viewgroup);
    }

    public void onDestroy()
    {
        super.onDestroy();
        mSearchDataHelper = null;
    }

    public void onDestroyView()
    {
        super.onDestroyView();
        c();
        mViews = null;
    }

}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.list;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.target.ui.fragment.common.BaseDialogFragment;

public class ListClearDialogFragment extends BaseDialogFragment
    implements android.widget.RadioGroup.OnCheckedChangeListener
{
    static class Views extends com.target.ui.view.a
    {

        Button cancelBtn;
        RadioButton clearAllRadio;
        Button clearBtn;
        RadioButton clearCompletedRadio;
        TextView messageTV;
        RadioGroup radioGroup;
        TextView titleTV;

        protected Views(View view)
        {
            super(view);
        }
    }

    public static interface a
    {

        public abstract void a(int i);
    }


    private static final String ARG_HAS_COMPLETED_ITEMS = "arg_has_completed_items";
    private static final String ARG_HAS_LIST_ITEMS = "arg_has_list_items";
    public static final String TAG = com/target/ui/fragment/list/ListClearDialogFragment.getSimpleName();
    private int clearType;
    private android.view.View.OnClickListener mClearClickListener;
    private a mListener;

    public ListClearDialogFragment()
    {
        mClearClickListener = new android.view.View.OnClickListener() {

            final ListClearDialogFragment this$0;

            public void onClick(View view)
            {
                if (ListClearDialogFragment.a(ListClearDialogFragment.this) != null)
                {
                    ListClearDialogFragment.a(ListClearDialogFragment.this).a(ListClearDialogFragment.b(ListClearDialogFragment.this));
                }
                dismiss();
            }

            
            {
                this$0 = ListClearDialogFragment.this;
                super();
            }
        };
    }

    static a a(ListClearDialogFragment listcleardialogfragment)
    {
        return listcleardialogfragment.mListener;
    }

    public static ListClearDialogFragment a(Fragment fragment, boolean flag, boolean flag1)
    {
        ListClearDialogFragment listcleardialogfragment = new ListClearDialogFragment();
        listcleardialogfragment.setTargetFragment(fragment, 0);
        fragment = new Bundle();
        fragment.putBoolean("arg_has_list_items", flag);
        fragment.putBoolean("arg_has_completed_items", flag1);
        listcleardialogfragment.setArguments(fragment);
        return listcleardialogfragment;
    }

    static int b(ListClearDialogFragment listcleardialogfragment)
    {
        return listcleardialogfragment.clearType;
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        mListener = (a)getTargetFragment();
    }

    public void onCheckedChanged(RadioGroup radiogroup, int i)
    {
        switch (i)
        {
        default:
            return;

        case 2131755222: 
            clearType = 1;
            return;

        case 2131755223: 
            clearType = 2;
            break;
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f030039, viewgroup, false);
        viewgroup = new Views(layoutinflater);
        boolean flag = getArguments().getBoolean("arg_has_list_items", false);
        boolean flag1 = getArguments().getBoolean("arg_has_completed_items", false);
        ((Views) (viewgroup)).titleTV.setText(0x7f090387);
        if (flag && flag1)
        {
            ((Views) (viewgroup)).messageTV.setText(0x7f090388);
            ((Views) (viewgroup)).radioGroup.setOnCheckedChangeListener(this);
            clearType = 1;
            ((Views) (viewgroup)).clearAllRadio.setChecked(true);
        } else
        if (flag1)
        {
            ((Views) (viewgroup)).messageTV.setText(0x7f090394);
            clearType = 2;
            ((Views) (viewgroup)).radioGroup.setVisibility(8);
        } else
        {
            ((Views) (viewgroup)).messageTV.setText(0x7f090393);
            clearType = 1;
            ((Views) (viewgroup)).radioGroup.setVisibility(8);
        }
        ((Views) (viewgroup)).cancelBtn.setOnClickListener(new android.view.View.OnClickListener() {

            final ListClearDialogFragment this$0;

            public void onClick(View view)
            {
                dismiss();
            }

            
            {
                this$0 = ListClearDialogFragment.this;
                super();
            }
        });
        ((Views) (viewgroup)).clearBtn.setOnClickListener(mClearClickListener);
        return layoutinflater;
    }

    public void onDetach()
    {
        super.onDetach();
        mListener = null;
    }

}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.mcoupons;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import com.target.mothership.util.o;
import com.target.ui.fragment.common.BaseDialogFragment;
import com.target.ui.util.e.a;
import com.target.ui.util.q;

public class CouponOnDemandFragment extends BaseDialogFragment
    implements android.view.View.OnClickListener
{
    public static interface a
    {

        public abstract void a(String s);
    }

    private class b
    {

        Button cancelButton;
        EditText codeInput;
        Button submitButton;
        final CouponOnDemandFragment this$0;

        b(View view)
        {
            this$0 = CouponOnDemandFragment.this;
            super();
            codeInput = (EditText)view.findViewById(0x7f1001a1);
            submitButton = (Button)view.findViewById(0x7f1001a2);
            cancelButton = (Button)view.findViewById(0x7f1001a3);
        }
    }


    public static final String TAG = com/target/ui/fragment/mcoupons/CouponOnDemandFragment.getSimpleName();
    private final TextWatcher mInputTextWatcher = new TextWatcher() {

        final CouponOnDemandFragment this$0;

        public void afterTextChanged(Editable editable)
        {
            if (o.f(editable.toString()))
            {
                com.target.ui.fragment.mcoupons.CouponOnDemandFragment.a(CouponOnDemandFragment.this).submitButton.setEnabled(true);
            }
        }

        public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
        {
        }

        public void onTextChanged(CharSequence charsequence, int i, int j, int k)
        {
        }

            
            {
                this$0 = CouponOnDemandFragment.this;
                super();
            }
    };
    private a mListener;
    private b mViews;

    public CouponOnDemandFragment()
    {
    }

    static b a(CouponOnDemandFragment couponondemandfragment)
    {
        return couponondemandfragment.mViews;
    }

    public static CouponOnDemandFragment a(a a1)
    {
        CouponOnDemandFragment couponondemandfragment = new CouponOnDemandFragment();
        if (a1 == null || !(a1 instanceof Fragment))
        {
            throw new IllegalArgumentException("OnDemandCodeListener must be an instance of Fragment");
        } else
        {
            couponondemandfragment.setTargetFragment((Fragment)a1, 0);
            return couponondemandfragment;
        }
    }

    private void a(String s)
    {
        if (mListener == null)
        {
            dismiss();
            q.a(TAG, "tried to submit coupon code, but listener is null");
            return;
        } else
        {
            mListener.a(s);
            dismiss();
            return;
        }
    }

    public void onAttach(Activity activity)
    {
        Fragment fragment = getTargetFragment();
        if (fragment != null && (fragment instanceof a))
        {
            mListener = (a)fragment;
            super.onAttach(activity);
            return;
        } else
        {
            throw new IllegalStateException("Make sure to implement OnDemandCodeListener");
        }
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
        default:
            return;

        case 2131755426: 
            a(mViews.codeInput.getText().toString());
            return;

        case 2131755427: 
            dismiss();
            break;
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f030068, viewgroup, false);
        mViews = new b(layoutinflater);
        mViews.codeInput.addTextChangedListener(mInputTextWatcher);
        mViews.submitButton.setOnClickListener(this);
        mViews.cancelButton.setOnClickListener(this);
        return layoutinflater;
    }

    public void onDetach()
    {
        super.onDetach();
        mListener = null;
    }

    public void onStart()
    {
        super.onStart();
        com.target.ui.util.e.a.b(mViews.codeInput);
    }

}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.checkout;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.f;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.google.a.a.e;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.target.mothership.model.guest.interfaces.Guest;
import com.target.ui.service.a;
import com.target.ui.util.al;
import com.target.ui.util.q;

public class ThankYouDialogFragment extends DialogFragment
    implements android.view.View.OnClickListener, TraceFieldInterface
{
    static class Views extends com.target.ui.view.a
    {

        TextView continueShopping;
        TextView createAccount;
        View divider;
        TextView orderConfirmationNumber;

        Views(View view)
        {
            super(view);
        }
    }

    public static interface a
    {

        public abstract void p();

        public abstract void q();
    }


    private static final String ARG_ORDER_CONFIRMATION_NUMBER = "OrderConfirmationNumber";
    public static final String TAG = com/target/ui/fragment/checkout/ThankYouDialogFragment.getSimpleName();
    private a mListener;
    private Views mViews;

    public ThankYouDialogFragment()
    {
    }

    private Guest a()
    {
        com.target.ui.service.a a1 = com.target.ui.service.a.a();
        if (a1.c().b())
        {
            return (Guest)a1.c().c();
        } else
        {
            return null;
        }
    }

    public static ThankYouDialogFragment a(String s, a a1)
    {
        ThankYouDialogFragment thankyoudialogfragment = new ThankYouDialogFragment();
        thankyoudialogfragment.setTargetFragment((Fragment)a1, 0);
        a1 = new Bundle();
        a1.putString("OrderConfirmationNumber", s);
        thankyoudialogfragment.setArguments(a1);
        return thankyoudialogfragment;
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
            throw new IllegalStateException("Make sure to implement OnThankYouListener");
        }
    }

    public void onClick(View view)
    {
        if (mListener == null)
        {
            q.a(TAG, "OnThankYouListener is null");
            dismiss();
            return;
        }
        view.getId();
        JVM INSTR tableswitch 2131755565 2131755567: default 52
    //                   2131755565 69
    //                   2131755566 52
    //                   2131755567 57;
           goto _L1 _L2 _L1 _L3
_L1:
        dismiss();
        return;
_L3:
        mListener.p();
        continue; /* Loop/switch isn't completed */
_L2:
        mListener.q();
        if (true) goto _L1; else goto _L4
_L4:
    }

    public Dialog onCreateDialog(Bundle bundle)
    {
        bundle = getActivity();
        View view = getActivity().getLayoutInflater().inflate(0x7f03008b, null);
        mViews = new Views(view);
        mViews.continueShopping.setOnClickListener(this);
        mViews.createAccount.setOnClickListener(this);
        mViews.orderConfirmationNumber.setText(getString(0x7f090266, new Object[] {
            getArguments().getString("OrderConfirmationNumber")
        }));
        return (new android.app.AlertDialog.Builder(bundle)).setView(view).create();
    }

    public void onDestroyView()
    {
        super.onDestroyView();
        mViews = null;
    }

    public void onDetach()
    {
        super.onDetach();
        mListener = null;
    }

    public void onStart()
    {
        ApplicationStateMonitor.getInstance().activityStarted();
        super.onStart();
        getDialog().setCancelable(false);
        Guest guest = a();
        if (guest != null && !guest.isAnonymous() && mViews != null)
        {
            al.a(new View[] {
                mViews.createAccount, mViews.divider
            });
        }
    }

    protected void onStop()
    {
        super.onStop();
        ApplicationStateMonitor.getInstance().activityStopped();
    }

}

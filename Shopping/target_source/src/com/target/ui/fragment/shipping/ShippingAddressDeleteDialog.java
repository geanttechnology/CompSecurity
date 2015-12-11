// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.shipping;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.f;
import android.view.LayoutInflater;
import android.view.View;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.target.ui.fragment.common.BaseNavigationFragment;

public class ShippingAddressDeleteDialog extends DialogFragment
    implements android.view.View.OnClickListener, TraceFieldInterface
{
    public static interface a
    {

        public abstract void a();
    }


    public static final String TAG = com/target/ui/fragment/shipping/ShippingAddressDeleteDialog.getSimpleName();
    private a mListener;

    public ShippingAddressDeleteDialog()
    {
    }

    public static ShippingAddressDeleteDialog a(a a1)
    {
        ShippingAddressDeleteDialog shippingaddressdeletedialog = new ShippingAddressDeleteDialog();
        if (a1 == null || !(a1 instanceof BaseNavigationFragment))
        {
            throw new IllegalArgumentException("OnShippingAddressDeleteListener must be an instance of BaseNavigationFragment");
        } else
        {
            shippingaddressdeletedialog.setTargetFragment((Fragment)a1, 0);
            return shippingaddressdeletedialog;
        }
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        if (getTargetFragment() instanceof a)
        {
            mListener = (a)getTargetFragment();
            return;
        } else
        {
            throw new IllegalStateException("Make sure to implement OnShippingAddressDeleteListener");
        }
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
        default:
            return;

        case 2131756009: 
            if (mListener != null)
            {
                mListener.a();
            }
            dismiss();
            return;

        case 2131755241: 
            dismiss();
            return;
        }
    }

    public Dialog onCreateDialog(Bundle bundle)
    {
        bundle = getActivity();
        View view = getActivity().getLayoutInflater().inflate(0x7f030141, null);
        view.findViewById(0x7f1003e9).setOnClickListener(this);
        view.findViewById(0x7f1000e9).setOnClickListener(this);
        return (new android.app.AlertDialog.Builder(bundle)).setView(view).create();
    }

    public void onDetach()
    {
        super.onDetach();
        mListener = null;
    }

    protected void onStart()
    {
        super.onStart();
        ApplicationStateMonitor.getInstance().activityStarted();
    }

    protected void onStop()
    {
        super.onStop();
        ApplicationStateMonitor.getInstance().activityStopped();
    }

}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.checkout;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import com.google.a.a.e;
import com.target.mothership.model.guest.interfaces.AccountDetails;
import com.target.mothership.model.guest.interfaces.Guest;
import com.target.ui.f.c;
import com.target.ui.fragment.common.BaseNavigationFragment;
import com.target.ui.model.checkout.PickUpPersonDetailsModel;
import com.target.ui.model.checkout.TGTPickUpPersonDetailsModel;
import com.target.ui.service.a;
import com.target.ui.util.al;
import com.target.ui.view.account.b;
import com.target.ui.view.checkout.AltPickUpDetailsView;

public class PickUpDetailsFragment extends BaseNavigationFragment
    implements android.view.View.OnClickListener, b
{
    static class Views extends com.target.ui.view.a
    {

        Button actionDoneButton;
        RadioButton altPickUpButton;
        AltPickUpDetailsView altPickUpDetails;
        RadioButton selfPickUpButton;

        Views(View view)
        {
            super(view);
        }
    }

    public final class a
        implements com.target.ui.view.checkout.AltPickUpDetailsView.a
    {

        public String email;
        public String firstName;
        boolean isValid;
        public String lastName;
        final PickUpDetailsFragment this$0;

        public void a()
        {
            isValid = false;
        }

        public void a(String s, String s1, String s2)
        {
            firstName = s;
            lastName = s1;
            email = s2;
            isValid = true;
        }

        public a()
        {
            this$0 = PickUpDetailsFragment.this;
            super();
        }
    }


    private static final String KEY_RECIPIENT_DETAILS = "recipient_details";
    public static final String TAG = com/target/ui/fragment/checkout/PickUpDetailsFragment.getSimpleName();
    private Guest mGuest;
    private com.target.ui.view.checkout.DeliveryView.a mListener;
    private PickUpPersonDetailsModel mPickUpPersonDetails;
    private Views mViews;

    public PickUpDetailsFragment()
    {
    }

    public static PickUpDetailsFragment a(PickUpPersonDetailsModel pickuppersondetailsmodel, com.target.ui.view.checkout.DeliveryView.a a1)
        throws IllegalArgumentException
    {
        PickUpDetailsFragment pickupdetailsfragment = new PickUpDetailsFragment();
        if (a1 == null || !(a1 instanceof Fragment))
        {
            throw new IllegalArgumentException("DeliveryActionListener must be an instance of Fragment");
        } else
        {
            pickupdetailsfragment.setTargetFragment((Fragment)a1, 0);
            a1 = new Bundle();
            a1.putParcelable("recipient_details", pickuppersondetailsmodel);
            pickupdetailsfragment.setArguments(a1);
            return pickupdetailsfragment;
        }
    }

    private PickUpPersonDetailsModel a(boolean flag, String s, String s1, String s2)
    {
        TGTPickUpPersonDetailsModel tgtpickuppersondetailsmodel = new TGTPickUpPersonDetailsModel();
        tgtpickuppersondetailsmodel.a(flag);
        tgtpickuppersondetailsmodel.b(true);
        tgtpickuppersondetailsmodel.a(s);
        tgtpickuppersondetailsmodel.b(s1);
        tgtpickuppersondetailsmodel.c(s2);
        return tgtpickuppersondetailsmodel;
    }

    private void a()
    {
        mViews.selfPickUpButton.setOnClickListener(this);
        mViews.altPickUpButton.setOnClickListener(this);
        mViews.actionDoneButton.setOnClickListener(this);
    }

    private void a(PickUpPersonDetailsModel pickuppersondetailsmodel)
    {
        if (pickuppersondetailsmodel == null)
        {
            b();
            return;
        }
        if (pickuppersondetailsmodel.a())
        {
            b();
            return;
        } else
        {
            c();
            return;
        }
    }

    private void b()
    {
        mViews.selfPickUpButton.setChecked(true);
        mViews.altPickUpButton.setChecked(false);
        al.c(mViews.altPickUpDetails);
        mViews.actionDoneButton.setEnabled(true);
    }

    private void c()
    {
        mViews.altPickUpButton.setChecked(true);
        mViews.selfPickUpButton.setChecked(false);
        al.b(mViews.altPickUpDetails);
        mViews.actionDoneButton.setEnabled(false);
        mViews.altPickUpDetails.setInputValidationListener(this);
        mViews.altPickUpDetails.a(mPickUpPersonDetails);
    }

    private Guest d()
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

    private void e()
    {
        if (!mViews.selfPickUpButton.isChecked()) goto _L2; else goto _L1
_L1:
        if (mGuest.getAccountDetails().b() && mListener != null)
        {
            Object obj = (AccountDetails)mGuest.getAccountDetails().c();
            obj = a(true, ((AccountDetails) (obj)).getFirstName(), ((AccountDetails) (obj)).getLastName(), null);
            mListener.a(((PickUpPersonDetailsModel) (obj)));
        }
_L6:
        f();
_L4:
        return;
_L2:
        Object obj1;
        obj1 = new a();
        mViews.altPickUpDetails.a(((com.target.ui.view.checkout.AltPickUpDetailsView.a) (obj1)));
        if (!((a) (obj1)).isValid) goto _L4; else goto _L3
_L3:
        obj1 = a(false, ((a) (obj1)).firstName, ((a) (obj1)).lastName, ((a) (obj1)).email);
        mListener.a(((PickUpPersonDetailsModel) (obj1)));
        if (true) goto _L6; else goto _L5
_L5:
    }

    private void f()
    {
        m().b();
    }

    public void a(View view, boolean flag)
    {
        while (mViews == null || view.getId() != mViews.altPickUpDetails.getId()) 
        {
            return;
        }
        mViews.actionDoneButton.setEnabled(flag);
    }

    public void onAttach(Activity activity)
    {
        Fragment fragment = getTargetFragment();
        if (fragment != null && (fragment instanceof com.target.ui.view.checkout.DeliveryView.a))
        {
            mListener = (com.target.ui.view.checkout.DeliveryView.a)fragment;
            super.onAttach(activity);
            return;
        } else
        {
            throw new IllegalStateException("Make sure to implement DeliveryActionListener");
        }
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
        case 2131755347: 
        default:
            return;

        case 2131755348: 
            e();
            return;

        case 2131755345: 
            b();
            return;

        case 2131755346: 
            c();
            return;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (getArguments() != null)
        {
            mPickUpPersonDetails = (PickUpPersonDetailsModel)getArguments().getParcelable("recipient_details");
        }
        j(getResources().getString(0x7f090225));
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f03004d, viewgroup, false);
        mViews = new Views(layoutinflater);
        mGuest = d();
        a(mPickUpPersonDetails);
        a();
        return layoutinflater;
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

}

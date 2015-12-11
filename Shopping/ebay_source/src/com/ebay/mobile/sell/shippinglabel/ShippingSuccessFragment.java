// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell.shippinglabel;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.ebay.nautilus.domain.data.ShippingOption;

// Referenced classes of package com.ebay.mobile.sell.shippinglabel:
//            ShippingLabelBaseFragment, ShippingLabelPreviewFragment, VoidLabelFragment, ShippingLabelActivity

public class ShippingSuccessFragment extends ShippingLabelBaseFragment
    implements android.view.View.OnClickListener
{

    public static final String EXTRA_LABEL_PRINTED = "label_printed";
    public static final String EXTRA_LABEL_VOIDED = "label_voided";
    boolean print;
    boolean voidLabel;

    public ShippingSuccessFragment()
    {
    }

    public boolean isHomeUp()
    {
        return true;
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        bundle = getView();
        bundle.findViewById(0x7f100793).setOnClickListener(this);
        bundle.findViewById(0x7f100794).setOnClickListener(this);
        bundle.findViewById(0x7f100795).setOnClickListener(this);
    }

    public boolean onBackPressed()
    {
        return false;
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
        default:
            return;

        case 2131756947: 
            getActivity().finish();
            return;

        case 2131756948: 
            view = new ShippingLabelPreviewFragment();
            FragmentTransaction fragmenttransaction = getFragmentManager().beginTransaction();
            fragmenttransaction.replace(0x7f100761, view, "label_success_fragment");
            fragmenttransaction.commit();
            return;

        case 2131756949: 
            view = new VoidLabelFragment();
            break;
        }
        FragmentTransaction fragmenttransaction1 = getFragmentManager().beginTransaction();
        fragmenttransaction1.addToBackStack("voidFragment");
        fragmenttransaction1.replace(0x7f100761, view, "label_void_fragment");
        fragmenttransaction1.commit();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        bundle = getArguments();
        if (bundle != null)
        {
            print = bundle.getBoolean("label_printed");
            voidLabel = bundle.getBoolean("label_voided");
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return (ViewGroup)layoutinflater.inflate(0x7f03023b, viewgroup, false);
    }

    public void setActionBarState()
    {
        hideDoneButton();
        if (voidLabel)
        {
            setToolbarTitle(0x7f07087f);
            return;
        } else
        {
            setToolbarTitle(0x7f070836);
            return;
        }
    }

    public void updateUI()
    {
        Object obj = (ShippingLabelActivity)getActivity();
        if (obj != null && !((ShippingLabelActivity) (obj)).isFinishing() && ((ShippingLabelActivity) (obj)).selectedShippingService != null)
        {
            obj = ((ShippingLabelActivity) (obj)).selectedShippingService.shippingKey;
            View view = getView();
            view.setVisibility(0);
            if (voidLabel)
            {
                ((TextView)view.findViewById(0x7f100790)).setText(getString(0x7f07084d));
                ((TextView)view.findViewById(0x7f100791)).setText(getString(0x7f070880));
                view.findViewById(0x7f100792).setVisibility(8);
                view.findViewById(0x7f100794).setVisibility(8);
                view.findViewById(0x7f100795).setVisibility(8);
                return;
            }
            if (print)
            {
                ((TextView)view.findViewById(0x7f100790)).setText(getString(0x7f070863));
            }
            if (((com.ebay.nautilus.domain.data.ShippingOption.ShippingKey) (obj)).carrier.name().equals(com.ebay.nautilus.domain.data.ShippingOption.ShippingCarrierType.FEDEX.name()))
            {
                ((TextView)view.findViewById(0x7f100791)).setText(getString(0x7f07083d));
                view.findViewById(0x7f100792).setVisibility(8);
                view.findViewById(0x7f100795).setVisibility(8);
                return;
            }
            if (((com.ebay.nautilus.domain.data.ShippingOption.ShippingKey) (obj)).carrier.name().equals(com.ebay.nautilus.domain.data.ShippingOption.ShippingCarrierType.USPS.name()))
            {
                view.findViewById(0x7f100792).setVisibility(0);
                view.findViewById(0x7f100795).setVisibility(0);
                return;
            }
        }
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.poshmark.data_model.models.AddressCheckerResults;
import com.poshmark.data_model.models.inner_models.Address;
import com.poshmark.utils.AddressUtils;

// Referenced classes of package com.poshmark.ui.fragments:
//            PMFragment

public class AddressMatchFragment extends PMFragment
{

    private AddressCheckerResults addressCheckerResults;
    private Button addressEnteredButton;
    private android.view.View.OnClickListener addressEnteredListener;
    private Button addressFoundButton;
    private android.view.View.OnClickListener addressFoundListener;
    private android.view.View.OnClickListener nextButtonListener;
    private Address selectedAddress;

    public AddressMatchFragment()
    {
        addressFoundListener = new android.view.View.OnClickListener() {

            final AddressMatchFragment this$0;

            public void onClick(View view)
            {
                selectedAddress = addressCheckerResults.address_found;
                addressFoundButton.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0x7f02007d, 0);
                addressEnteredButton.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            }

            
            {
                this$0 = AddressMatchFragment.this;
                super();
            }
        };
        addressEnteredListener = new android.view.View.OnClickListener() {

            final AddressMatchFragment this$0;

            public void onClick(View view)
            {
                selectedAddress = addressCheckerResults.address_entered;
                addressEnteredButton.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0x7f02007d, 0);
                addressFoundButton.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            }

            
            {
                this$0 = AddressMatchFragment.this;
                super();
            }
        };
        nextButtonListener = new android.view.View.OnClickListener() {

            final AddressMatchFragment this$0;

            public void onClick(View view)
            {
                view = new Intent();
                Bundle bundle = new Bundle();
                bundle.putString("CITY", selectedAddress.getCity());
                bundle.putString("STATE", selectedAddress.getState());
                bundle.putString("STREET", selectedAddress.getStreet());
                bundle.putString("STREET2", selectedAddress.getStreet2());
                bundle.putString("TYPE", selectedAddress.getType());
                bundle.putString("ZIP", selectedAddress.getZip());
                bundle.putString("NAME", addressCheckerResults.address_entered.getName());
                bundle.putString("PHONE", addressCheckerResults.address_entered.getPhone());
                view.putExtras(bundle);
                finishActivityWithResult(-1, view);
            }

            
            {
                this$0 = AddressMatchFragment.this;
                super();
            }
        };
    }

    private void setupView(View view)
    {
        addressFoundButton = (Button)view.findViewById(0x7f0c0051);
        addressEnteredButton = (Button)view.findViewById(0x7f0c0053);
        String s1 = addressCheckerResults.address_entered.getName();
        String s = AddressUtils.addressStringWithoutPhone(addressCheckerResults.address_found);
        view = s;
        if (s1 != null)
        {
            view = (new StringBuilder()).append(s1).append(s).toString();
        }
        addressFoundButton.setText(view);
        addressEnteredButton.setText(AddressUtils.addressStringWithoutPhone(addressCheckerResults.address_entered));
        addressFoundButton.setOnClickListener(addressFoundListener);
        addressEnteredButton.setOnClickListener(addressEnteredListener);
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        addressCheckerResults = (AddressCheckerResults)getFragmentDataOfType(com/poshmark/data_model/models/AddressCheckerResults);
        selectedAddress = addressCheckerResults.address_found;
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        super.onCreateView(layoutinflater, viewgroup, bundle);
        layoutinflater = layoutinflater.inflate(0x7f03000a, viewgroup, false);
        setupView(layoutinflater);
        return layoutinflater;
    }

    public void setViewNameForAnalytics()
    {
        viewNameForAnalytics = "address_confirmation_screen";
    }

    public void setupActionBar()
    {
        super.setupActionBar();
        setTitle("Confirm Address");
        setNextActionButton(getString(0x7f0600bf), nextButtonListener);
    }



/*
    static Address access$002(AddressMatchFragment addressmatchfragment, Address address)
    {
        addressmatchfragment.selectedAddress = address;
        return address;
    }

*/



}

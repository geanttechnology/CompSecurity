// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.inventory;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.location.Address;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StorePickerAutocompleteDialogFragment extends DialogFragment
{
    public static interface StorePickerAutocompleteDialogListener
    {

        public abstract void onAutocompleteItemSelected(DialogFragment dialogfragment);
    }


    static final String LOCATION_LIST = "location_list";
    private static final String LOCATION_NAMES = "location_names";
    private static final String SELECTED_ADDRESS = "selected_address";
    private StorePickerAutocompleteDialogListener listener;
    private String locationNames[];
    private List locations;
    private Address selectedAddress;

    public StorePickerAutocompleteDialogFragment()
    {
        locations = null;
        locationNames = null;
        selectedAddress = null;
    }

    public Address getSelectedAddress()
    {
        return selectedAddress;
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        try
        {
            listener = (StorePickerAutocompleteDialogListener)activity;
            return;
        }
        catch (ClassCastException classcastexception)
        {
            throw new ClassCastException((new StringBuilder()).append(activity.toString()).append(" must implement StorePickerAutocompleteDialogListener").toString());
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (bundle != null)
        {
            locations = bundle.getParcelableArrayList("location_list");
            locationNames = bundle.getStringArray("location_names");
            selectedAddress = (Address)bundle.getParcelable("selected_address");
        }
    }

    public Dialog onCreateDialog(Bundle bundle)
    {
        bundle = new android.support.v7.app.AlertDialog.Builder(getActivity());
        bundle.setTitle(0x7f070b35);
        bundle.setItems(locationNames, new android.content.DialogInterface.OnClickListener() {

            final StorePickerAutocompleteDialogFragment this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                if (locations != null && locations.size() > i)
                {
                    selectedAddress = (Address)locations.get(i);
                }
                listener.onAutocompleteItemSelected(StorePickerAutocompleteDialogFragment.this);
            }

            
            {
                this$0 = StorePickerAutocompleteDialogFragment.this;
                super();
            }
        });
        bundle.setNegativeButton(0x7f0701cc, new android.content.DialogInterface.OnClickListener() {

            final StorePickerAutocompleteDialogFragment this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
            }

            
            {
                this$0 = StorePickerAutocompleteDialogFragment.this;
                super();
            }
        });
        return bundle.create();
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putParcelableArrayList("location_list", new ArrayList(locations));
        bundle.putStringArray("location_names", locationNames);
        bundle.putParcelable("selected_address", selectedAddress);
    }

    public void setArguments(Bundle bundle)
    {
        super.setArguments(bundle);
        locations = bundle.getParcelableArrayList("location_list");
        if (locations != null)
        {
            bundle = new ArrayList();
            for (Iterator iterator = locations.iterator(); iterator.hasNext();)
            {
                Address address = (Address)iterator.next();
                int j = address.getMaxAddressLineIndex() + 1;
                if (j > 0)
                {
                    String as[] = new String[j];
                    for (int i = 0; i < j; i++)
                    {
                        as[i] = address.getAddressLine(i);
                    }

                    bundle.add(TextUtils.join(", ", as));
                } else
                {
                    bundle.add(address.getFeatureName());
                }
            }

            locationNames = (String[])bundle.toArray(new String[bundle.size()]);
        }
    }



/*
    static Address access$102(StorePickerAutocompleteDialogFragment storepickerautocompletedialogfragment, Address address)
    {
        storepickerautocompletedialogfragment.selectedAddress = address;
        return address;
    }

*/

}

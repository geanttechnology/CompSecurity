// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.inventory;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import com.ebay.common.Preferences;
import com.ebay.mobile.MyApp;

public class LocationServicesImproveDialogFragment extends DialogFragment
{

    public LocationServicesImproveDialogFragment()
    {
    }

    public Dialog onCreateDialog(Bundle bundle)
    {
        bundle = new android.support.v7.app.AlertDialog.Builder(getActivity());
        bundle.setTitle(0x7f0705fa);
        bundle.setMessage(0x7f0705f9);
        View view = View.inflate(getActivity(), 0x7f030155, null);
        ((CheckBox)view.findViewById(0x7f10006b)).setOnCheckedChangeListener(new android.widget.CompoundButton.OnCheckedChangeListener() {

            final LocationServicesImproveDialogFragment this$0;

            public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
            {
                compoundbutton = MyApp.getPrefs();
                if (!flag)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                compoundbutton.setShowImproveLocationDialog(flag);
            }

            
            {
                this$0 = LocationServicesImproveDialogFragment.this;
                super();
            }
        });
        bundle.setView(view);
        bundle.setPositiveButton(0x7f0703b5, new android.content.DialogInterface.OnClickListener() {

            final LocationServicesImproveDialogFragment this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
                getActivity().startActivity(dialoginterface);
            }

            
            {
                this$0 = LocationServicesImproveDialogFragment.this;
                super();
            }
        });
        bundle.setNegativeButton(0x7f0701cc, new android.content.DialogInterface.OnClickListener() {

            final LocationServicesImproveDialogFragment this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
            }

            
            {
                this$0 = LocationServicesImproveDialogFragment.this;
                super();
            }
        });
        return bundle.create();
    }
}

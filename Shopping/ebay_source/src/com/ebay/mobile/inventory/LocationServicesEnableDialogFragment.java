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

public class LocationServicesEnableDialogFragment extends DialogFragment
{

    public LocationServicesEnableDialogFragment()
    {
    }

    public Dialog onCreateDialog(Bundle bundle)
    {
        bundle = new android.support.v7.app.AlertDialog.Builder(getActivity());
        bundle.setTitle(0x7f0705f7);
        bundle.setMessage(0x7f0705f6);
        bundle.setPositiveButton(0x7f0703b5, new android.content.DialogInterface.OnClickListener() {

            final LocationServicesEnableDialogFragment this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
                getActivity().startActivity(dialoginterface);
            }

            
            {
                this$0 = LocationServicesEnableDialogFragment.this;
                super();
            }
        });
        bundle.setNegativeButton(0x7f0701cc, new android.content.DialogInterface.OnClickListener() {

            final LocationServicesEnableDialogFragment this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
            }

            
            {
                this$0 = LocationServicesEnableDialogFragment.this;
                super();
            }
        });
        return bundle.create();
    }
}

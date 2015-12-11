// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.inventory;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;
import com.ebay.mobile.dcs.DcsString;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;

public class StorePickerInfoDialogFragment extends DialogFragment
{

    public StorePickerInfoDialogFragment()
    {
    }

    public Dialog onCreateDialog(Bundle bundle)
    {
        bundle = DeviceConfiguration.getAsync();
        android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(getActivity());
        builder.setTitle(0x7f070b3f);
        Resources resources = getResources();
        bundle = bundle.get(DcsString.BopisTermsLink);
        if (!TextUtils.isEmpty(bundle))
        {
            bundle = String.format(resources.getString(0x7f070478), new Object[] {
                bundle, resources.getString(0x7f070b3a)
            });
        } else
        {
            bundle = resources.getString(0x7f070b3a);
        }
        builder.setMessage(Html.fromHtml(String.format(resources.getString(0x7f070b3b), new Object[] {
            bundle
        })));
        builder.setPositiveButton(0x7f070738, new android.content.DialogInterface.OnClickListener() {

            final StorePickerInfoDialogFragment this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
            }

            
            {
                this$0 = StorePickerInfoDialogFragment.this;
                super();
            }
        });
        return builder.create();
    }

    public void onStart()
    {
        super.onStart();
        ((TextView)getDialog().findViewById(0x102000b)).setMovementMethod(LinkMovementMethod.getInstance());
    }
}

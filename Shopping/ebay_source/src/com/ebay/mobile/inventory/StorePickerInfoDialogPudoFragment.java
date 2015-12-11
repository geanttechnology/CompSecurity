// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.inventory;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;
import com.ebay.mobile.dcs.DcsString;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;

public class StorePickerInfoDialogPudoFragment extends DialogFragment
{

    public StorePickerInfoDialogPudoFragment()
    {
    }

    public Dialog onCreateDialog(Bundle bundle)
    {
        Object obj = DeviceConfiguration.getAsync();
        bundle = ((DeviceConfiguration) (obj)).get(DcsString.BopisTermsLink);
        obj = ((DeviceConfiguration) (obj)).get(DcsString.PickupFeatureLink);
        Resources resources = getResources();
        android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(getActivity());
        builder.setTitle(0x7f070b3f);
        if (!TextUtils.isEmpty(bundle))
        {
            bundle = String.format(resources.getString(0x7f070478), new Object[] {
                bundle, resources.getString(0x7f070b3e)
            });
        } else
        {
            bundle = resources.getString(0x7f070b3e);
        }
        if (!TextUtils.isEmpty(((CharSequence) (obj))))
        {
            obj = String.format(resources.getString(0x7f070478), new Object[] {
                obj, resources.getString(0x7f070b3c)
            });
        } else
        {
            obj = resources.getString(0x7f070b3c);
        }
        builder.setMessage(Html.fromHtml(String.format(resources.getString(0x7f070b3d), new Object[] {
            bundle, obj
        })));
        builder.setPositiveButton(0x7f070738, null);
        return builder.create();
    }

    public void onStart()
    {
        super.onStart();
        ((TextView)getDialog().findViewById(0x102000b)).setMovementMethod(LinkMovementMethod.getInstance());
    }
}

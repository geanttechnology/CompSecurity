// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell.shippinglabel;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

// Referenced classes of package com.ebay.mobile.sell.shippinglabel:
//            ShippingLabelActivity

public class FedexEulaDialogFragment extends DialogFragment
{

    public FedexEulaDialogFragment()
    {
    }

    public static FedexEulaDialogFragment newInstance()
    {
        FedexEulaDialogFragment fedexeuladialogfragment = new FedexEulaDialogFragment();
        fedexeuladialogfragment.setArguments(new Bundle());
        return fedexeuladialogfragment;
    }

    public Dialog onCreateDialog(Bundle bundle)
    {
        bundle = LayoutInflater.from(getActivity()).inflate(0x7f0300a6, null);
        TextView textview = (TextView)bundle.findViewById(0x7f1001b3);
        textview.setTextColor(textview.getLinkTextColors().getDefaultColor());
        textview.setOnClickListener(new android.view.View.OnClickListener() {

            final FedexEulaDialogFragment this$0;

            public void onClick(View view)
            {
                ((ShippingLabelActivity)getActivity()).showFedexEula();
            }

            
            {
                this$0 = FedexEulaDialogFragment.this;
                super();
            }
        });
        return (new android.support.v7.app.AlertDialog.Builder(getActivity())).setTitle(getString(0x7f07083b)).setView(bundle).setPositiveButton(0x7f07012f, new android.content.DialogInterface.OnClickListener() {

            final FedexEulaDialogFragment this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dismiss();
                ((ShippingLabelActivity)getActivity()).acceptFedexEula();
            }

            
            {
                this$0 = FedexEulaDialogFragment.this;
                super();
            }
        }).setNegativeButton(0x7f0701cc, new android.content.DialogInterface.OnClickListener() {

            final FedexEulaDialogFragment this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                ((ShippingLabelActivity)getActivity()).declineFedexEula();
            }

            
            {
                this$0 = FedexEulaDialogFragment.this;
                super();
            }
        }).create();
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

// Referenced classes of package com.ebay.mobile.sell:
//            ListingFragmentActivity

public class SellerRegistrationDialogFragment extends DialogFragment
{

    public SellerRegistrationDialogFragment()
    {
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setStyle(1, 0);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return layoutinflater.inflate(0x7f030226, viewgroup, false);
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        view.findViewById(0x7f100721).setOnClickListener(new android.view.View.OnClickListener() {

            final SellerRegistrationDialogFragment this$0;

            public void onClick(View view1)
            {
                ((ListingFragmentActivity)getActivity()).launchSellerRegistration();
                dismiss();
            }

            
            {
                this$0 = SellerRegistrationDialogFragment.this;
                super();
            }
        });
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.ebay.mobile.ui_stuff.Util;
import com.ebay.nautilus.domain.data.LdsOption;
import com.ebay.nautilus.domain.data.ListingDraft;

// Referenced classes of package com.ebay.mobile.sell:
//            PackageDetailsCell

public class PackageDetailsDialogFragment extends DialogFragment
    implements android.view.View.OnClickListener, com.ebay.android.widget.EbaySpinner.OnUserSelectionChanged
{
    public static interface PackageDetailsCallback
    {

        public abstract ListingDraft getListingDraft();

        public abstract void onPackageDetailsResult(com.ebay.nautilus.domain.content.dm.ListingDraftDataManager.PackageDetailFields packagedetailfields);
    }


    private PackageDetailsCallback callback;
    private PackageDetailsCell packageDetails;

    public PackageDetailsDialogFragment()
    {
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        if (callback.getListingDraft() == null)
        {
            dismiss();
        }
    }

    public void onChange(int i, Object obj)
    {
        switch (i)
        {
        default:
            return;

        case 2131756651: 
            packageDetails.weightSelectionChanged((LdsOption)obj);
            break;
        }
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
        default:
            return;

        case 2131755947: 
            Util.hideSoftInput(view.getContext(), view);
            dismiss();
            return;

        case 2131756640: 
            Util.hideSoftInput(view.getContext(), view);
            callback.onPackageDetailsResult(packageDetails.getFields());
            dismiss();
            return;

        case 2131756650: 
            packageDetails.toggleIrregularPackageValue();
            break;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setStyle(1, 0x7f0a0282);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return layoutinflater.inflate(0x7f03020e, viewgroup, false);
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        packageDetails = new PackageDetailsCell(this);
        callback = (PackageDetailsCallback)getTargetFragment();
        if (callback.getListingDraft() != null)
        {
            packageDetails.updateControls(callback.getListingDraft());
        }
        view.findViewById(0x7f100660).setOnClickListener(this);
        ((TextView)view.findViewById(0x7f1003a5)).setText(getString(0x7f070581));
        view.findViewById(0x7f1003ab).setOnClickListener(this);
    }
}

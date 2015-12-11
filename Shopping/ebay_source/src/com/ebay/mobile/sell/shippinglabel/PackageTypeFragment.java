// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell.shippinglabel;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;
import com.ebay.common.util.EbaySettings;
import com.ebay.nautilus.domain.content.dm.ShippingLabelDraftDataManager;
import com.ebay.nautilus.domain.data.ShippingLabelDraft;
import com.ebay.nautilus.domain.data.ShippingOption;
import com.ebay.nautilus.domain.net.ApiSettings;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;

// Referenced classes of package com.ebay.mobile.sell.shippinglabel:
//            ShippingLabelBaseFragment, ShippingLabelActivity, ShippingLabelFragment

public class PackageTypeFragment extends ShippingLabelBaseFragment
    implements android.view.View.OnClickListener
{

    private LayoutInflater inflater;
    private ViewGroup selectedType;

    public PackageTypeFragment()
    {
    }

    public void onClick(View view)
    {
        if (selectedType != null)
        {
            ((RadioButton)selectedType.findViewById(0x7f10075f)).setChecked(false);
        }
        selectedType = (ViewGroup)view;
        ((RadioButton)selectedType.findViewById(0x7f10075f)).setChecked(true);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        inflater = layoutinflater;
        return (ViewGroup)layoutinflater.inflate(0x7f03023e, viewgroup, false);
    }

    public void sendUpdates()
    {
        ShippingLabelDraft shippinglabeldraft = ((ShippingLabelActivity)getActivity()).shippingLabelDraft;
        com.ebay.nautilus.domain.net.api.shippinglabel.UpdateDraftShippingLabelPackageRequest.LabelRequestParams labelrequestparams = new com.ebay.nautilus.domain.net.api.shippinglabel.UpdateDraftShippingLabelPackageRequest.LabelRequestParams(shippinglabeldraft, ((ShippingLabelActivity)getActivity()).selectedShippingService.shippingKey);
        labelrequestparams.shippingKey.packageType = (String)selectedType.getTag();
        labelrequestparams.spec.packageShape = com.ebay.nautilus.domain.data.ShippingLabelPackage.PackageShapeType.REGULAR;
        ((ShippingLabelActivity)getActivity()).shippingLabelDraftDataManager.updateDraftPackage(labelrequestparams, shippinglabeldraft.draftLabelId, ApiSettings.getUrl(EbaySettings.printShippingLabelUrl));
    }

    public void setActionBarState()
    {
        super.setActionBarState();
        setToolbarTitle(0x7f070583);
    }

    public void updateUI()
    {
        Object obj = ((ShippingLabelActivity)getActivity()).selectedShippingService.shippingKey;
        String s = ((com.ebay.nautilus.domain.data.ShippingOption.ShippingKey) (obj)).packageType;
        obj = (ArrayList)((ShippingLabelActivity)getActivity()).fedexServices.get(((com.ebay.nautilus.domain.data.ShippingOption.ShippingKey) (obj)).service);
        ViewGroup viewgroup = (ViewGroup)getView().findViewById(0x7f1007a0);
        viewgroup.removeAllViews();
        Iterator iterator = ((ArrayList) (obj)).iterator();
        while (iterator.hasNext()) 
        {
            Object obj1 = (ShippingOption)iterator.next();
            Object obj2 = ((ShippingOption) (obj1)).shippingKey.packageType;
            boolean flag = ((String) (obj2)).equals(s);
            ViewGroup viewgroup1 = (ViewGroup)inflater.inflate(0x7f030234, viewgroup, false);
            viewgroup1.setOnClickListener(this);
            viewgroup1.setTag(obj2);
            ((RadioButton)viewgroup1.findViewById(0x7f10075f)).setChecked(flag);
            if (flag)
            {
                selectedType = viewgroup1;
            }
            TextView textview = (TextView)viewgroup1.findViewById(0x7f10075e);
            textview.setText(((ShippingOption) (obj1)).attributes.packageName);
            obj1 = ShippingLabelFragment.asPackageTypeImage(((String) (obj2)));
            obj2 = getActivity().getResources();
            if (obj1 == null)
            {
                obj1 = null;
            } else
            {
                obj1 = Integer.valueOf(((ShippingLabelFragment.PackageTypeImages) (obj1)).displayImg);
            }
            textview.setCompoundDrawablesWithIntrinsicBounds(((Resources) (obj2)).getDrawable(((Integer) (obj1)).intValue()), null, null, null);
            textview.setCompoundDrawablePadding(16);
            viewgroup.addView(viewgroup1);
        }
        getView().setVisibility(0);
    }
}

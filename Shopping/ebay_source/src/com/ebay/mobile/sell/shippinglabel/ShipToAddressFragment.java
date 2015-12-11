// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell.shippinglabel;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;
import com.ebay.common.util.EbaySettings;
import com.ebay.mobile.ui_stuff.Util;
import com.ebay.nautilus.domain.content.dm.ShippingLabelDraftDataManager;
import com.ebay.nautilus.domain.data.ShippingLabelContact;
import com.ebay.nautilus.domain.data.ShippingLabelDetails;
import com.ebay.nautilus.domain.data.ShippingLabelDraft;
import com.ebay.nautilus.domain.data.ShippingOption;
import com.ebay.nautilus.domain.net.ApiSettings;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Referenced classes of package com.ebay.mobile.sell.shippinglabel:
//            ShippingLabelBaseFragment, ShippingLabelActivity

public class ShipToAddressFragment extends ShippingLabelBaseFragment
{

    public ShipToAddressFragment()
    {
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return layoutinflater.inflate(0x7f03023c, viewgroup, false);
    }

    public void sendUpdates()
    {
        View view = getView();
        Object obj2 = (TextView)view.findViewById(0x7f100797);
        Object obj1 = (TextView)view.findViewById(0x7f100798);
        TextView textview = (TextView)view.findViewById(0x7f100799);
        TextView textview1 = (TextView)view.findViewById(0x7f10079a);
        TextView textview2 = (TextView)view.findViewById(0x7f10079c);
        Spinner spinner = (Spinner)view.findViewById(0x7f10079b);
        TextView textview3 = (TextView)getView().findViewById(0x7f10079d);
        Object obj = (CheckBox)view.findViewById(0x7f10079e);
        ShippingLabelContact shippinglabelcontact = new ShippingLabelContact();
        shippinglabelcontact.location = new com.ebay.nautilus.domain.data.ShippingLabelContact.ShippingLocation();
        shippinglabelcontact.location.address = new com.ebay.nautilus.domain.data.ShippingLabelContact.ShippingLocation.Address();
        shippinglabelcontact.fullName = ((TextView) (obj2)).getText().toString();
        obj2 = shippinglabelcontact.location;
        if (((CheckBox) (obj)).isChecked())
        {
            obj = com.ebay.nautilus.domain.data.ShippingLabelContact.ShippingLocationType.RESIDENTIAL;
        } else
        {
            obj = com.ebay.nautilus.domain.data.ShippingLabelContact.ShippingLocationType.BUSINESS;
        }
        obj2.locationType = ((com.ebay.nautilus.domain.data.ShippingLabelContact.ShippingLocationType) (obj));
        shippinglabelcontact.location.address.addressLine1 = ((TextView) (obj1)).getText().toString();
        shippinglabelcontact.location.address.addressLine2 = textview.getText().toString();
        shippinglabelcontact.location.address.city = textview1.getText().toString();
        shippinglabelcontact.location.address.country = "US";
        shippinglabelcontact.location.address.postalCode = textview2.getText().toString();
        shippinglabelcontact.location.address.stateOrProvince = (String)spinner.getSelectedItem();
        shippinglabelcontact.phone = textview3.getText().toString();
        shippinglabelcontact.additionalData = new com.ebay.nautilus.domain.data.ShippingLabelContact.AdditionalData();
        shippinglabelcontact.additionalData.entry = new ArrayList();
        obj = new com.ebay.nautilus.domain.data.ShippingLabelContact.AdditionalData.EntryItem();
        obj.key = "AddressChange";
        obj.value = new ArrayList();
        ((com.ebay.nautilus.domain.data.ShippingLabelContact.AdditionalData.EntryItem) (obj)).value.add("true");
        shippinglabelcontact.additionalData.entry.add(obj);
        obj = (ShippingLabelActivity)getActivity();
        obj1 = ((ShippingLabelActivity) (obj)).shippingLabelDraft;
        ((ShippingLabelActivity) (obj)).shippingLabelDraftDataManager.updateDraftAddress(shippinglabelcontact, com.ebay.nautilus.domain.data.ShippingLabelContact.ShippingAddressType.SHIP_TO, ((ShippingLabelDraft) (obj1)).draftLabelId, ApiSettings.getUrl(EbaySettings.printShippingLabelUrl));
        Util.hideSoftInput(getActivity(), view);
    }

    public void setActionBarState()
    {
        super.setActionBarState();
        setToolbarTitle(0x7f070833);
    }

    public void updateUI()
    {
        ShippingLabelActivity shippinglabelactivity = (ShippingLabelActivity)getActivity();
        Object obj1 = shippinglabelactivity.shippingLabelDraft;
        if (obj1 != null)
        {
            getView().setVisibility(0);
        }
        Object obj = (TextView)getView().findViewById(0x7f100797);
        TextView textview = (TextView)getView().findViewById(0x7f100798);
        TextView textview1 = (TextView)getView().findViewById(0x7f100799);
        TextView textview2 = (TextView)getView().findViewById(0x7f10079a);
        TextView textview3 = (TextView)getView().findViewById(0x7f10079c);
        Spinner spinner = (Spinner)getView().findViewById(0x7f10079b);
        TextView textview4 = (TextView)getView().findViewById(0x7f10079d);
        obj1 = ((ShippingLabelDraft) (obj1)).labelDetails.to;
        ((TextView) (obj)).setText(((ShippingLabelContact) (obj1)).fullName);
        textview.setText(((ShippingLabelContact) (obj1)).location.address.addressLine1);
        textview1.setText(((ShippingLabelContact) (obj1)).location.address.addressLine2);
        textview2.setText(((ShippingLabelContact) (obj1)).location.address.city);
        textview3.setText(((ShippingLabelContact) (obj1)).location.address.postalCode);
        spinner.setSelection(Arrays.asList(getResources().getStringArray(0x7f0e0006)).indexOf(((ShippingLabelContact) (obj1)).location.address.stateOrProvince));
        textview4.setText(((ShippingLabelContact) (obj1)).phone);
        obj = (CheckBox)getView().findViewById(0x7f10079e);
        ((CheckBox) (obj)).setChecked(com.ebay.nautilus.domain.data.ShippingLabelContact.ShippingLocationType.RESIDENTIAL.equals(((ShippingLabelContact) (obj1)).location.locationType));
        if (shippinglabelactivity.selectedShippingService != null && com.ebay.nautilus.domain.data.ShippingOption.ShippingCarrierType.FEDEX.name().equals(shippinglabelactivity.selectedShippingService.shippingKey.carrier.name()))
        {
            ((CheckBox) (obj)).setVisibility(0);
            return;
        } else
        {
            ((CheckBox) (obj)).setVisibility(8);
            return;
        }
    }
}

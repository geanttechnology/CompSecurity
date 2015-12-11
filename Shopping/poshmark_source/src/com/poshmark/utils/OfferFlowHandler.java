// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils;

import com.poshmark.data_model.models.BrainTreeInfo;
import com.poshmark.data_model.models.ListingDetails;
import com.poshmark.data_model.models.PMOffer;
import com.poshmark.data_model.models.PMOfferInfo;
import com.poshmark.ui.PMActivity;
import com.poshmark.ui.fragments.MakeOfferFragment;
import com.poshmark.ui.fragments.PMFragment;

// Referenced classes of package com.poshmark.utils:
//            CheckoutFlowHandler

public class OfferFlowHandler extends CheckoutFlowHandler
{

    int MAKE_OFFER_REQUEST_CODE;
    BrainTreeInfo bt_info;

    public OfferFlowHandler(PMFragment pmfragment)
    {
        super(pmfragment);
        MAKE_OFFER_REQUEST_CODE = 1;
        poshmarkOrder = new PMOffer();
    }

    public OfferFlowHandler(PMFragment pmfragment, PMOfferInfo pmofferinfo)
    {
        super(pmfragment);
        MAKE_OFFER_REQUEST_CODE = 1;
        poshmarkOrder = pmofferinfo.data;
        bt_info = pmofferinfo.meta;
    }

    private void showOfferForm()
    {
        PMActivity pmactivity = (PMActivity)callingFragment.getActivity();
        if (pmactivity != null)
        {
            pmactivity.launchFragmentInNewActivityForResult(null, com/poshmark/ui/fragments/MakeOfferFragment, this, callingFragment, MAKE_OFFER_REQUEST_CODE);
        }
    }

    public void beginCheckoutForListing(ListingDetails listingdetails)
    {
        listing = listingdetails;
        showOfferForm();
    }

    public String getEncryptionKey()
    {
        if (bt_info != null)
        {
            return bt_info.bt_public_key;
        } else
        {
            return null;
        }
    }

    public void setOffer(PMOfferInfo pmofferinfo)
    {
        poshmarkOrder = pmofferinfo.data;
        bt_info = pmofferinfo.meta;
    }
}

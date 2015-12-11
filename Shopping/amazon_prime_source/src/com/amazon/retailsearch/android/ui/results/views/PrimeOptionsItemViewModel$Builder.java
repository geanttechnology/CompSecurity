// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.views;

import android.text.TextUtils;
import com.amazon.retailsearch.util.Utils;
import com.amazon.searchapp.retailsearch.model.EditionsPriceInfo;
import com.amazon.searchapp.retailsearch.model.Link;
import com.amazon.searchapp.retailsearch.model.Shipping;
import com.amazon.searchapp.retailsearch.model.ShippingStatus;
import java.util.List;

// Referenced classes of package com.amazon.retailsearch.android.ui.results.views:
//            PrimeOptionsItemViewModel

public static class offersCount
{

    private String asin;
    private EditionsPriceInfo offer;
    private int offersCount;
    private String productGroup;

    public PrimeOptionsItemViewModel build()
    {
        PrimeOptionsItemViewModel primeoptionsitemviewmodel;
        primeoptionsitemviewmodel = new PrimeOptionsItemViewModel();
        if (TextUtils.isEmpty(offer.getAsin()))
        {
            PrimeOptionsItemViewModel.access$000(primeoptionsitemviewmodel, asin);
        } else
        {
            PrimeOptionsItemViewModel.access$000(primeoptionsitemviewmodel, offer.getAsin());
        }
        if (TextUtils.isEmpty(offer.getGroup()))
        {
            PrimeOptionsItemViewModel.access$100(primeoptionsitemviewmodel, productGroup);
        } else
        {
            PrimeOptionsItemViewModel.access$100(primeoptionsitemviewmodel, offer.getGroup());
        }
        PrimeOptionsItemViewModel.access$200(primeoptionsitemviewmodel, offersCount);
        if (offer.getShipping().getPrime() == null) goto _L2; else goto _L1
_L1:
        if (offer.getShipping().getPrime().getHasBadge() && offer.getShipping().getPrime().getBadgeLink() != null)
        {
            PrimeOptionsItemViewModel.access$300(primeoptionsitemviewmodel, offer.getShipping().getPrime().getBadgeAssetId());
            PrimeOptionsItemViewModel.access$400(primeoptionsitemviewmodel, offer.getShipping().getPrime().getBadgeLink().getText());
            PrimeOptionsItemViewModel.access$500(primeoptionsitemviewmodel, offer.getShipping().getPrime().getBadgeLink().getUrl());
        }
_L4:
        return primeoptionsitemviewmodel;
_L2:
        if (offer.getShipping().getAddOn() == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (!offer.getShipping().getAddOn().getHasBadge() || offer.getShipping().getAddOn().getBadgeLink() == null) goto _L4; else goto _L3
_L3:
        PrimeOptionsItemViewModel.access$300(primeoptionsitemviewmodel, offer.getShipping().getAddOn().getBadgeAssetId());
        PrimeOptionsItemViewModel.access$400(primeoptionsitemviewmodel, offer.getShipping().getAddOn().getBadgeLink().getText());
        PrimeOptionsItemViewModel.access$500(primeoptionsitemviewmodel, offer.getShipping().getAddOn().getBadgeLink().getUrl());
        return primeoptionsitemviewmodel;
        if (Utils.isEmpty(offer.getShipping().getAdditionalStatus()) || !((ShippingStatus)offer.getShipping().getAdditionalStatus().get(0)).getHasBadge() || ((ShippingStatus)offer.getShipping().getAdditionalStatus().get(0)).getBadgeLink() == null) goto _L4; else goto _L5
_L5:
        PrimeOptionsItemViewModel.access$300(primeoptionsitemviewmodel, ((ShippingStatus)offer.getShipping().getAdditionalStatus().get(0)).getBadgeAssetId());
        PrimeOptionsItemViewModel.access$400(primeoptionsitemviewmodel, ((ShippingStatus)offer.getShipping().getAdditionalStatus().get(0)).getBadgeLink().getText());
        PrimeOptionsItemViewModel.access$500(primeoptionsitemviewmodel, ((ShippingStatus)offer.getShipping().getAdditionalStatus().get(0)).getBadgeLink().getUrl());
        return primeoptionsitemviewmodel;
    }

    public offer setAsin(String s)
    {
        asin = s;
        return this;
    }

    public asin setOffer(EditionsPriceInfo editionspriceinfo)
    {
        offer = editionspriceinfo;
        return this;
    }

    public offer setOffersCount(int i)
    {
        offersCount = i;
        return this;
    }

    public offersCount setProductGroup(String s)
    {
        productGroup = s;
        return this;
    }

    public ()
    {
        offersCount = 1;
    }
}

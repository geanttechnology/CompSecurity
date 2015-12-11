// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.search;

import android.app.Activity;
import android.text.TextUtils;
import com.ebay.common.net.api.search.SearchParameters;
import com.ebay.common.view.DefaultItemAdapter;
import com.ebay.nautilus.domain.data.EbaySearchListItem;
import com.ebay.nautilus.domain.dcs.DcsNautilusBoolean;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;

public class SearchItemRenderer extends DefaultItemAdapter
{

    private final SearchParameters searchParameters;

    public SearchItemRenderer(Activity activity, boolean flag, boolean flag1, boolean flag2, int i, boolean flag3, SearchParameters searchparameters)
    {
        super(activity, flag, flag1, flag2, i, flag3);
        searchParameters = searchparameters.clone();
    }

    protected boolean showEbayNowLabel(EbaySearchListItem ebaysearchlistitem)
    {
        return ebaysearchlistitem.isEbn && searchParameters.ebnOnly;
    }

    protected boolean showInStorePickupLabel(EbaySearchListItem ebaysearchlistitem)
    {
        return ebaysearchlistitem.isInStorePickup && searchParameters.inStorePickupOnly;
    }

    protected boolean showLocalPickupLabel(EbaySearchListItem ebaysearchlistitem)
    {
        if (!searchParameters.localPickupOnly) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        if (TextUtils.isEmpty(ebaysearchlistitem.shippingType))
        {
            return false;
        }
        if (!ebaysearchlistitem.isFromSaaS)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (TextUtils.isEmpty(ebaysearchlistitem.shipToLocation) && ebaysearchlistitem.shippingType.equals("LocalDelivery")) goto _L1; else goto _L3
_L3:
        return false;
        if (ebaysearchlistitem.shipToLocation != null && ebaysearchlistitem.shippingType.equals("FreePickup") && ebaysearchlistitem.shipToLocation.equals("None")) goto _L1; else goto _L4
_L4:
        return false;
    }

    protected boolean showPickupDropOffLabel(EbaySearchListItem ebaysearchlistitem)
    {
        return DeviceConfiguration.getAsync().get(DcsNautilusBoolean.PUDO) && ebaysearchlistitem.isPickupAndDropOff && searchParameters.inStorePickupOnly;
    }
}

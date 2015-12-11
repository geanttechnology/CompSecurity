// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.shopping;

import com.ebay.common.net.EbayRequestHelper;
import com.ebay.nautilus.domain.data.UserProfile;
import com.ebay.nautilus.domain.net.api.shopping.EbayShoppingApi;
import com.ebay.nautilus.domain.net.api.shopping.GetCategoryInfoRequest;
import com.ebay.nautilus.domain.net.api.shopping.GetCategoryInfoResponse;
import com.ebay.nautilus.domain.net.api.shopping.GetUserProfileRequest;
import com.ebay.nautilus.domain.net.api.shopping.GetUserProfileResponse;
import com.ebay.nautilus.kernel.content.EbayContext;
import java.io.IOException;
import java.util.ArrayList;

public final class EbayShoppingApiHelper
{

    public EbayShoppingApiHelper()
    {
    }

    public static ArrayList getCategoryInfo(EbayContext ebaycontext, EbayShoppingApi ebayshoppingapi, long l, boolean flag)
        throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException, com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException, com.ebay.common.net.EbayRequestHelper.EbayRequestErrorException, com.ebay.nautilus.kernel.net.Connector.HostErrorException, IOException, InterruptedException
    {
        ebayshoppingapi = new GetCategoryInfoRequest(ebayshoppingapi, l);
        if (flag)
        {
            ebayshoppingapi.includeChildCategories = flag;
        }
        return ((GetCategoryInfoResponse)EbayRequestHelper.sendRequest(ebaycontext, ebayshoppingapi)).categories;
    }

    public static UserProfile getUserProfile(EbayContext ebaycontext, EbayShoppingApi ebayshoppingapi, String s)
        throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException, com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException, com.ebay.common.net.EbayRequestHelper.EbayRequestErrorException, com.ebay.nautilus.kernel.net.Connector.HostErrorException, IOException, InterruptedException
    {
        return ((GetUserProfileResponse)EbayRequestHelper.sendRequest(ebaycontext, new GetUserProfileRequest(ebayshoppingapi, s))).result;
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.trading;

import com.ebay.common.model.ClientAlertsAuthToken;
import com.ebay.common.model.UserDetail;
import com.ebay.common.net.EbayRequestHelper;
import com.ebay.nautilus.domain.net.api.trading.EbayTradingApi;
import com.ebay.nautilus.kernel.content.EbayContext;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.ebay.common.net.api.trading:
//            GetNotificationPreferencesRequest, GetNotificationPreferencesResponse, GetClientAlertsAuthTokenRequest, GetClientAlertsAuthTokenResponse, 
//            GetFavoriteSellersRequest, GetFavoriteSellersResponse, GetUserRequest, GetUserResponse, 
//            SetNotificationPreferencesRequest, SetNotificationPreferencesResponse

public final class EbayTradingApiHelper
{

    public EbayTradingApiHelper()
    {
    }

    public static ArrayList getClientAlertsPreferences(EbayContext ebaycontext, EbayTradingApi ebaytradingapi)
        throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException, com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException, com.ebay.common.net.EbayRequestHelper.EbayRequestErrorException, com.ebay.nautilus.kernel.net.Connector.HostErrorException, IOException, InterruptedException
    {
        return ((GetNotificationPreferencesResponse)EbayRequestHelper.sendRequest(ebaycontext, new GetNotificationPreferencesRequest(ebaytradingapi))).getResults();
    }

    public static ClientAlertsAuthToken getClientAlertsToken(EbayContext ebaycontext, EbayTradingApi ebaytradingapi)
        throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException, com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException, com.ebay.common.net.EbayRequestHelper.EbayRequestErrorException, com.ebay.nautilus.kernel.net.Connector.HostErrorException, IOException, InterruptedException
    {
        return ((GetClientAlertsAuthTokenResponse)EbayRequestHelper.sendRequest(ebaycontext, new GetClientAlertsAuthTokenRequest(ebaytradingapi))).caAuthToken;
    }

    public static List getFavoriteSellers(EbayContext ebaycontext, EbayTradingApi ebaytradingapi)
        throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException, com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException, com.ebay.common.net.EbayRequestHelper.EbayRequestErrorException, com.ebay.nautilus.kernel.net.Connector.HostErrorException, IOException, InterruptedException
    {
        return ((GetFavoriteSellersResponse)EbayRequestHelper.sendRequest(ebaycontext, new GetFavoriteSellersRequest(ebaytradingapi))).sellerList;
    }

    public static UserDetail getUser(EbayContext ebaycontext, EbayTradingApi ebaytradingapi)
        throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException, com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException, com.ebay.common.net.EbayRequestHelper.EbayRequestErrorException, com.ebay.nautilus.kernel.net.Connector.HostErrorException, IOException, InterruptedException
    {
        return ((GetUserResponse)EbayRequestHelper.sendRequest(ebaycontext, new GetUserRequest(ebaytradingapi))).detail;
    }

    public static boolean setClientAlertsPreferences(EbayContext ebaycontext, EbayTradingApi ebaytradingapi, List list, String s, String s1)
        throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException, com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException, com.ebay.common.net.EbayRequestHelper.EbayRequestErrorException, com.ebay.nautilus.kernel.net.Connector.HostErrorException, IOException, InterruptedException
    {
        return ((SetNotificationPreferencesResponse)EbayRequestHelper.sendRequest(ebaycontext, new SetNotificationPreferencesRequest(ebaytradingapi, "ClientAlerts", list, s, s1))).ackCode == 1;
    }
}

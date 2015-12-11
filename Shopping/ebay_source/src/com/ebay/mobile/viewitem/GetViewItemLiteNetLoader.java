// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem;

import com.ebay.common.util.EbaySettings;
import com.ebay.nautilus.domain.data.ItemCurrency;
import com.ebay.nautilus.domain.net.ApiSettings;
import com.ebay.nautilus.domain.net.DataRequest;
import com.ebay.nautilus.domain.net.DataResponse;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.util.FwLog;
import com.ebay.nautilus.shell.content.FwNetLoader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.ebay.mobile.viewitem:
//            ItemViewBiddingUpdater

public class GetViewItemLiteNetLoader extends FwNetLoader
{

    public int bidCount;
    public boolean ended;
    public boolean finalized;
    public String highBidder;
    public long id;
    private final String itemId;
    public ItemCurrency minimumToBid;
    public ItemCurrency price;
    private boolean serviceError;

    public GetViewItemLiteNetLoader(EbayContext ebaycontext, String s)
    {
        super(ebaycontext);
        highBidder = null;
        serviceError = false;
        itemId = s;
    }

    protected void doInBackgroundInternal()
        throws IOException, InterruptedException, com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException, com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
    {
        Object obj;
        JSONObject jsonobject;
        JSONObject jsonobject1;
        try
        {
            obj = ((DataResponse)sendRequest(new DataRequest(new URL((new StringBuilder()).append(ApiSettings.get(EbaySettings.viewItemLite)).append("&item=").append(itemId).toString())))).getText();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException(((MalformedURLException) (obj)).getMessage());
        }
        catch (JSONException jsonexception)
        {
            throw new com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException(jsonexception.getMessage());
        }
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_356;
        }
        obj = new JSONObject(((String) (obj)));
        if (ItemViewBiddingUpdater.fwLogItemViewBidding.isLoggable)
        {
            FwLog.println(ItemViewBiddingUpdater.fwLogItemViewBidding, (new StringBuilder()).append("GetViewItemLite json: ").append(obj).toString());
        }
        obj = ((JSONObject) (obj)).getJSONObject("ViewItemLiteResponse");
        if (((JSONObject) (obj)).has("Error"))
        {
            if (ItemViewBiddingUpdater.fwLogItemViewBidding.isLoggable)
            {
                obj = ((JSONObject) (obj)).getJSONArray("Error").getJSONObject(0);
                FwLog.println(ItemViewBiddingUpdater.fwLogItemViewBidding, (new StringBuilder()).append("Error ").append(((JSONObject) (obj)).getString("Id")).toString());
            }
            serviceError = true;
            return;
        }
        obj = ((JSONObject) (obj)).getJSONArray("Item");
        if (((JSONArray) (obj)).length() == 0)
        {
            throw new com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException("JSON request failed");
        }
        obj = ((JSONArray) (obj)).getJSONObject(0);
        ended = ((JSONObject) (obj)).getBoolean("IsEnded");
        finalized = ((JSONObject) (obj)).getBoolean("IsFinalized");
        bidCount = ((JSONObject) (obj)).getInt("BidCount");
        jsonobject = ((JSONObject) (obj)).getJSONObject("CurrentPrice");
        price = new ItemCurrency(jsonobject.getString("CurrencyCode"), jsonobject.getString("Amount"));
        jsonobject1 = ((JSONObject) (obj)).getJSONObject("MinimumToBid");
        minimumToBid = new ItemCurrency(jsonobject.getString("CurrencyCode"), jsonobject1.getString("Amount"));
        id = ((JSONObject) (obj)).getLong("Id");
        if (((JSONObject) (obj)).has("HighBidder"))
        {
            highBidder = ((JSONObject) (obj)).getJSONObject("HighBidder").getString("Name");
            return;
        }
    }

    public boolean isServiceError()
    {
        return serviceError;
    }
}

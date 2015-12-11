// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.cart;

import com.ebay.nautilus.kernel.net.Response;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.ebay.common.net.api.cart:
//            EbayCartRequest, AddItems, EbayCartApi

public static final class requestedQuantity extends EbayCartRequest
{

    final String cartId;
    final int donationAmountId;
    final String isoCurrencyCode;
    final String nonprofitId;
    final int requestedQuantity;

    public byte[] buildRequest()
        throws com.ebay.nautilus.kernel.net.aException
    {
        byte abyte0[];
        try
        {
            JSONObject jsonobject = new JSONObject();
            buildClientContext(jsonobject);
            jsonobject.put("cartIdentifier", cartId);
            JSONObject jsonobject1 = new JSONObject();
            jsonobject1.put("NonprofitId", Integer.parseInt(nonprofitId));
            JSONObject jsonobject2 = new JSONObject();
            jsonobject2.put("DonationAmountId", donationAmountId);
            jsonobject2.put("DonationCurrency", isoCurrencyCode);
            JSONObject jsonobject3 = new JSONObject();
            JSONObject jsonobject4 = new JSONObject();
            jsonobject4.put("domain", "donation");
            jsonobject4.put("baseIdentifier", jsonobject1.toString());
            jsonobject4.put("extendedIdentifier", jsonobject2.toString());
            jsonobject3.put("lineItemIdentifier", jsonobject4);
            jsonobject3.put("requestedQuantity", requestedQuantity);
            jsonobject.put("lineItemInput", jsonobject3);
            jsonobject1 = new JSONObject();
            jsonobject1.put("addItemsRequest", jsonobject);
            abyte0 = jsonobject1.toString().getBytes();
        }
        catch (JSONException jsonexception)
        {
            throw com.ebay.nautilus.kernel.net.aException.create(jsonexception);
        }
        catch (NumberFormatException numberformatexception)
        {
            throw com.ebay.nautilus.kernel.net.aException.create(numberformatexception);
        }
        return abyte0;
    }

    public  getResponse()
    {
        return new ();
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }

    protected (EbayCartApi ebaycartapi, String s, String s1, int i, String s2, int j)
    {
        super(ebaycartapi, "addItems");
        cartId = s;
        nonprofitId = s1;
        donationAmountId = i;
        isoCurrencyCode = s2;
        requestedQuantity = j;
    }
}

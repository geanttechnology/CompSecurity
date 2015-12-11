// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.ecas;

import com.ebay.nautilus.kernel.net.Response;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.ebay.nautilus.domain.net.api.ecas:
//            EcasApiRequest, CheckoutResponse, EcasApiContext

public class CreateCheckoutSessionRequest extends EcasApiRequest
{

    private final Long cartId;
    private final Map clientAttributes;
    private final List shoppingCartLineItemIds;

    public CreateCheckoutSessionRequest(EcasApiContext ecasapicontext, Long long1, List list, Map map)
    {
        super("createCheckoutSession", ecasapicontext);
        cartId = long1;
        shoppingCartLineItemIds = list;
        clientAttributes = map;
        super.dataFormat = "JSON";
        super.soaContentType = "application/json";
    }

    public byte[] buildRequest()
        throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException
    {
        byte abyte0[];
        try
        {
            JSONObject jsonobject = new JSONObject();
            jsonobject.put("shopCartId", cartId);
            jsonobject.put("checkoutFlowIdentifier", "EbayServiceBasedCheckout");
            if (requestVersion.equals("3.00"))
            {
                jsonobject.put("bopisSupported", useBopis);
            }
            jsonobject.put("itemsToCheckout", (new JSONObject()).put("cartLineItemIdentifier", new JSONArray(shoppingCartLineItemIds)));
            if (clientAttributes != null && clientAttributes.size() > 0 && clientAttributes.containsKey("paymentRiskCorrelationId"))
            {
                jsonobject.put("paymentRiskCorrelationId", ((String)clientAttributes.get("paymentRiskCorrelationId")).toString());
            }
            JSONObject jsonobject1 = new JSONObject();
            jsonobject1.put("createCheckoutSessionRequest", jsonobject);
            abyte0 = jsonobject1.toString().getBytes();
        }
        catch (JSONException jsonexception)
        {
            throw com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException.create(jsonexception);
        }
        return abyte0;
    }

    public CheckoutResponse getResponse()
    {
        return new CheckoutResponse();
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }
}

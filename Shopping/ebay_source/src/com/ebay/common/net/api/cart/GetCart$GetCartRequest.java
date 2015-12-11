// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.cart;

import android.text.TextUtils;
import com.ebay.nautilus.kernel.net.IHeaders;
import com.ebay.nautilus.kernel.net.Response;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.ebay.common.net.api.cart:
//            EbayCartRequest, GetCart, EbayCartApi

public static final class outputCurrencyCode extends EbayCartRequest
{

    private final String X_EBAY_SOA_LOCALE_CURRENCY = "x-ebay-soa-locale-currency";
    final String cartId;
    private final String outputCurrencyCode;

    public byte[] buildRequest()
        throws com.ebay.nautilus.kernel.net.ataException
    {
        byte abyte0[];
        try
        {
            JSONObject jsonobject = new JSONObject();
            buildClientContext(jsonobject);
            jsonobject.put("cartIdentifier", cartId);
            JSONObject jsonobject1 = new JSONObject();
            jsonobject1.put("getCartRequest", jsonobject);
            abyte0 = jsonobject1.toString().getBytes();
        }
        catch (JSONException jsonexception)
        {
            throw com.ebay.nautilus.kernel.net.ataException.create(jsonexception);
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

    public void onAddHeaders(IHeaders iheaders)
    {
        super.onAddHeaders(iheaders);
        if (!TextUtils.isEmpty(outputCurrencyCode))
        {
            iheaders.setHeader("x-ebay-soa-locale-currency", outputCurrencyCode);
        }
    }

    protected (EbayCartApi ebaycartapi, String s, String s1)
    {
        super(ebaycartapi, "getCart");
        cartId = s;
        outputCurrencyCode = s1;
    }
}

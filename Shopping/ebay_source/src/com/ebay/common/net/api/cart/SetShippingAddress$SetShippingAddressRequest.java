// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.cart;

import android.text.TextUtils;
import com.ebay.nautilus.domain.data.Address;
import com.ebay.nautilus.domain.datamapping.DataMapperFactory;
import com.ebay.nautilus.kernel.net.Response;
import com.google.gson.Gson;
import org.json.JSONObject;

// Referenced classes of package com.ebay.common.net.api.cart:
//            EbayCartRequest, SetShippingAddress, EbayCartApi

public static final class cartId extends EbayCartRequest
{

    final Address address;
    final String cartId;

    public byte[] buildRequest()
        throws com.ebay.nautilus.kernel.net.cartId
    {
        try
        {
            JSONObject jsonobject = new JSONObject();
            buildClientContext(jsonobject);
            jsonobject.put("cartIdentifier", cartId);
            JSONObject jsonobject2;
            if (address != null)
            {
                if (!TextUtils.isEmpty(address.getAddressId()))
                {
                    JSONObject jsonobject1 = new JSONObject();
                    jsonobject1.put("externalIdentifier", (new StringBuilder()).append("eBay:").append(address.getAddressId()).toString());
                    jsonobject.put("address", jsonobject1);
                } else
                {
                    jsonobject.put("address", DataMapperFactory.getDefaultMapper().toJson(address.addressFields));
                }
            }
            jsonobject2 = new JSONObject();
            jsonobject2.put("setShippingAddressRequest", jsonobject);
            return jsonobject2.toString().getBytes();
        }
        catch (Exception exception)
        {
            throw com.ebay.nautilus.kernel.net.address(exception);
        }
    }

    public  getResponse()
    {
        return new ();
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }

    protected (EbayCartApi ebaycartapi, Address address1, String s)
    {
        super(ebaycartapi, "setShippingAddress");
        address = address1;
        cartId = s;
    }
}

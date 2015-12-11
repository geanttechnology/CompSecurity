// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.cart;

import com.ebay.common.model.cart.Cart;
import com.ebay.common.net.JsonResponse;
import java.io.InputStream;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.ebay.common.net.api.cart:
//            AddItems

public static final class result extends JsonResponse
{

    protected Cart result;

    public Cart getResponseCart()
    {
        return result;
    }

    public void parse(InputStream inputstream)
        throws com.ebay.nautilus.kernel.net.aException
    {
        super.parse(inputstream);
        try
        {
            inputstream = body.getJSONObject("addItemsResponse");
            super.processAck(inputstream);
            result = new Cart(inputstream.getJSONObject("addItemResponse"));
            super.exportErrorsToResponse(result);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            throw com.ebay.nautilus.kernel.net.aException.create(inputstream);
        }
    }

    public aException()
    {
        result = null;
    }
}

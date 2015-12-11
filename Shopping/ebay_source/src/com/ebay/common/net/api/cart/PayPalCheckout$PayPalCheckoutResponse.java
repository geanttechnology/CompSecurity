// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.cart;

import com.ebay.common.model.cart.PayPalCheckoutDetails;
import com.ebay.common.net.JsonResponse;
import java.io.InputStream;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.ebay.common.net.api.cart:
//            PayPalCheckout

public static final class  extends JsonResponse
{

    protected PayPalCheckoutDetails details;

    public PayPalCheckoutDetails getResponseDetails()
    {
        return details;
    }

    public void parse(InputStream inputstream)
        throws com.ebay.nautilus.kernel.net.details
    {
        super.parse(inputstream);
        try
        {
            inputstream = body.getJSONObject("PayPalCheckoutResponse");
            super.processAck(inputstream);
            details = new PayPalCheckoutDetails(inputstream, this);
            super.exportErrorsToResponse(details);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            throw com.ebay.nautilus.kernel.net.reate(inputstream);
        }
    }

    public ()
    {
    }
}

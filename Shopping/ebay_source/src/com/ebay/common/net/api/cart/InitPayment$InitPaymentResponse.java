// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.cart;

import com.ebay.common.model.cart.PaymentSession;
import com.ebay.common.net.JsonResponse;
import java.io.InputStream;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.ebay.common.net.api.cart:
//            InitPayment

public static final class result extends JsonResponse
{

    protected PaymentSession result;

    public PaymentSession getResponsePaymentSession()
    {
        return result;
    }

    public void parse(InputStream inputstream)
        throws com.ebay.nautilus.kernel.net.tion
    {
        super.parse(inputstream);
        try
        {
            inputstream = body.getJSONObject("initPaymentResponse");
            super.processAck(inputstream);
            result = new PaymentSession(inputstream);
            super.exportErrorsToResponse(result);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            throw com.ebay.nautilus.kernel.net.tion.create(inputstream);
        }
    }

    public tion()
    {
        result = null;
    }
}

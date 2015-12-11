// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.cart;

import com.ebay.common.model.cart.Cart;
import com.ebay.common.model.cart.PaymentInstruction;
import com.ebay.common.net.JsonResponse;
import java.io.InputStream;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.ebay.common.net.api.cart:
//            Buy

public static final class paymentAttributes extends JsonResponse
{

    protected Cart cart;
    protected PaymentInstruction paymentAttributes;

    public PaymentInstruction getPaymentInstruction()
    {
        return paymentAttributes;
    }

    public Cart getResponseCart()
    {
        return cart;
    }

    public void parse(InputStream inputstream)
        throws com.ebay.nautilus.kernel.net.esponseDataException
    {
        super.parse(inputstream);
        inputstream = body.getJSONObject("buyResponse");
        super.processAck(inputstream);
        cart = new Cart(inputstream.getJSONObject("cartResponse"));
        if (!inputstream.has("paymentAttributes"))
        {
            break MISSING_BLOCK_LABEL_72;
        }
        paymentAttributes = new PaymentInstruction(inputstream.getJSONObject("paymentAttributes"));
_L1:
        super.exportErrorsToResponse(cart);
        return;
        try
        {
            paymentAttributes = null;
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            throw com.ebay.nautilus.kernel.net.esponseDataException.create(inputstream);
        }
          goto _L1
    }

    public esponseDataException()
    {
        cart = null;
        paymentAttributes = null;
    }
}

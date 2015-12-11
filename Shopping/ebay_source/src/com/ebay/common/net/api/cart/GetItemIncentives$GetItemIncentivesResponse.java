// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.cart;

import com.ebay.common.model.cart.ItemIncentives;
import com.ebay.common.net.JsonResponse;
import java.io.InputStream;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.ebay.common.net.api.cart:
//            GetItemIncentives

public static final class currency extends JsonResponse
{

    protected final String currency;
    protected ItemIncentives incentives;

    public ItemIncentives getItemIncentives()
    {
        return incentives;
    }

    public void parse(InputStream inputstream)
        throws com.ebay.nautilus.kernel.net.incentives
    {
        super.parse(inputstream);
        try
        {
            inputstream = body.getJSONObject("getItemIncentivesResponse");
            super.processAck(inputstream);
            incentives = new ItemIncentives(inputstream, currency);
            super.exportErrorsToResponse(incentives);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            throw com.ebay.nautilus.kernel.net.incentives(inputstream);
        }
    }

    (String s)
    {
        incentives = null;
        currency = s;
    }
}

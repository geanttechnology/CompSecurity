// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.cart;

import com.ebay.common.model.cart.UserIncentives;
import com.ebay.common.net.JsonResponse;
import java.io.InputStream;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.ebay.common.net.api.cart:
//            GetUserIncentives

public static final class incentives extends JsonResponse
{

    private UserIncentives incentives;

    public UserIncentives getUserIncentives()
    {
        return incentives;
    }

    public void parse(InputStream inputstream)
        throws com.ebay.nautilus.kernel.net.incentives
    {
        super.parse(inputstream);
        try
        {
            inputstream = body.optJSONObject("getUserIncentivesResponse");
            super.processAck(inputstream);
            incentives = new UserIncentives(inputstream);
            super.exportErrorsToResponse(incentives);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            throw com.ebay.nautilus.kernel.net.incentives(inputstream);
        }
    }

    public ()
    {
        incentives = null;
    }
}

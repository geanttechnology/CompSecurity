// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model.cart;

import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.ebay.common.model.cart:
//            PayPalCheckoutDetails, JsonModel

public static final class authToken
    implements Serializable
{

    public final String authToken;
    public final String userId;

    (JSONObject jsonobject)
        throws JSONException
    {
        userId = JsonModel.getString(jsonobject, "userIdentifier");
        authToken = JsonModel.getString(jsonobject, "authToken");
    }
}

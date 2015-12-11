// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model.cart;

import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.ebay.common.model.cart:
//            PayPalCheckoutDetails, JsonModel

public static final class uri
    implements Serializable
{

    public final String name;
    public final String uri;

    (JSONObject jsonobject)
        throws JSONException
    {
        String s1 = JsonModel.getString(jsonobject, "name");
        String s = s1;
        if (s1.equals("CFS"))
        {
            s = "Change Funding Source";
        }
        name = s;
        uri = JsonModel.getString(jsonobject, "url");
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model.cart;

import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.ebay.common.model.cart:
//            Cart, JsonModel

public static class tring
    implements Serializable
{

    public final String name;
    public final String value;

    public (JSONObject jsonobject)
        throws JSONException
    {
        name = JsonModel.getString(jsonobject, "@name");
        value = JsonModel.getString(jsonobject, "__value__");
    }
}

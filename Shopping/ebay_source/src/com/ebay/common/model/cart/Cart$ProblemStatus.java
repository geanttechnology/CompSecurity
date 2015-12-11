// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model.cart;

import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.ebay.common.model.cart:
//            Cart, JsonModel

public static final class 
    implements Serializable
{

    public final String details;
    public final String status;
    public final String summary;
    public final String systemId;

    (JSONObject jsonobject)
        throws JSONException
    {
        status = jsonobject.getString("status");
        summary = JsonModel.getString(jsonobject, "summary");
        details = JsonModel.getString(jsonobject, "details");
        systemId = JsonModel.getString(jsonobject, "systemId");
    }
}

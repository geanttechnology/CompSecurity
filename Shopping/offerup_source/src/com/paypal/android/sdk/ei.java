// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.paypal.android.sdk:
//            ep, dd

public final class ei extends ep
{

    final void a(JSONObject jsonobject)
    {
        if (dd.c(null))
        {
            jsonobject.accumulate("invoice_number", null);
        }
        if (dd.c(null))
        {
            jsonobject.accumulate("custom", null);
        }
        if (dd.c(null))
        {
            jsonobject.accumulate("soft_descriptor", null);
        }
    }

    public final String e()
    {
        throw new NullPointerException();
    }

    protected final JSONArray t()
    {
        JSONArray jsonarray = new JSONArray();
        JSONObject jsonobject = new JSONObject();
        jsonobject.accumulate("payer_id", null);
        jsonobject.accumulate("credit_card_id", null);
        JSONObject jsonobject1 = new JSONObject();
        jsonobject1.accumulate("credit_card_token", jsonobject);
        jsonarray.put(jsonobject1);
        return jsonarray;
    }

    protected final String u()
    {
        return "credit_card";
    }
}

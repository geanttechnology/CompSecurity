// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model.cart;

import android.text.TextUtils;
import com.ebay.nautilus.domain.data.CurrencyAmount;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.ebay.common.model.cart:
//            Cart, JsonModel

public static final class appliedStatus
    implements Serializable
{

    public final String appliedStatus;
    public final Map attributeMap = new HashMap();
    public final List attributes = new ArrayList();
    public final String code;
    public final boolean isApplied;
    public final String message;
    public final CurrencyAmount savingsAmount;
    public final String type;

    nt(JSONObject jsonobject)
        throws JSONException
    {
        appliedStatus = JsonModel.getString(jsonobject, "promotionAppliedStatus");
        code = JsonModel.getString(jsonobject, "promotionCode");
        message = JsonModel.getString(jsonobject, "promotionMessage");
        type = JsonModel.getString(jsonobject, "promotionType");
        savingsAmount = JsonModel.getCurrencyAmount(jsonobject, "promotionSavingsAmount");
        jsonobject = jsonobject.optJSONArray("promotionAttribute");
        if (jsonobject != null)
        {
            for (int i = 0; i < jsonobject.length(); i++)
            {
                nt nt = new init>(jsonobject.getJSONObject(i));
                attributes.add(nt);
                attributeMap.put(nt.ame, nt.alue);
            }

        }
        isApplied = TextUtils.equals(appliedStatus, "APPLIED");
    }
}

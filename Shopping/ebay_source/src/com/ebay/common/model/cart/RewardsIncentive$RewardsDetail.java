// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model.cart;

import java.io.Serializable;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.ebay.common.model.cart:
//            JsonModel, RewardsIncentive

public class getString extends JsonModel
    implements Serializable
{

    public final Double promotionAmount;
    public final String promotionDescription;
    public final Date promotionEndDate;
    public final String promotionName;
    public final String promotionType;
    final RewardsIncentive this$0;

    public boolean isBaseOffer()
    {
        return "BaseOffer".equals(promotionType);
    }

    public boolean isBoosterOffer()
    {
        return "BoosterOffer".equals(promotionType);
    }

    (JSONObject jsonobject)
        throws JSONException
    {
        this$0 = RewardsIncentive.this;
        super();
        promotionName = getString(jsonobject, "promotionName");
        promotionDescription = getString(jsonobject, "promotionDescription");
        promotionAmount = getDouble(jsonobject, "promotionAmount");
        promotionEndDate = getDate(jsonobject, "promotionEndDate");
        promotionType = getString(jsonobject, "promotionType");
    }
}

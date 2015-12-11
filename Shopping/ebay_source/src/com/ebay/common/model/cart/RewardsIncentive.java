// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model.cart;

import android.text.TextUtils;
import com.ebay.nautilus.domain.data.CurrencyAmount;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.ebay.common.model.cart:
//            JsonModel

public class RewardsIncentive extends JsonModel
    implements Serializable
{
    public class RewardsDetail extends JsonModel
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

        RewardsDetail(JSONObject jsonobject)
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


    public final CurrencyAmount amount;
    public final Boolean includesBooster;
    public final String itemId;
    public final String payloadIdentifier;
    public final String programCurrencyId;
    public final String programCurrencyIsoCode;
    public final String programName;
    public final String rewardsAmount;
    public final List rewardsDetails = new ArrayList();
    public final String transactionId;
    public final String type;
    public final String variationId;

    public RewardsIncentive(JSONObject jsonobject, String s)
        throws JSONException
    {
        itemId = getString(jsonobject, "itemId");
        transactionId = getString(jsonobject, "transactionId");
        variationId = getString(jsonobject, "itemVariationId");
        type = getString(jsonobject, "entityType");
        jsonobject = getObject(jsonobject, new String[] {
            "rewardsResult"
        });
        includesBooster = getBoolean(jsonobject, "includesBooster");
        payloadIdentifier = getString(jsonobject, "payloadIdentifier");
        s = getObject(jsonobject, new String[] {
            "rewardsAmount"
        });
        rewardsAmount = getString(s, "rewardsAmount");
        programCurrencyIsoCode = getString(s, "programCurrencyIsoCode");
        programCurrencyId = getString(s, "programCurrencyId");
        programName = getString(s, "programName");
        if (programCurrencyIsoCode != null && !"0".equals(programCurrencyIsoCode) && programCurrencyIsoCode.length() == 3 && !TextUtils.isEmpty(rewardsAmount))
        {
            amount = new CurrencyAmount(rewardsAmount, programCurrencyIsoCode);
        } else
        {
            amount = null;
        }
        jsonobject = getArray(jsonobject, new String[] {
            "rewardsDetailList"
        });
        if (jsonobject != null)
        {
            for (int i = 0; i < jsonobject.length(); i++)
            {
                s = jsonobject.getJSONObject(i);
                if (s != null)
                {
                    s = new RewardsDetail(s);
                    rewardsDetails.add(s);
                }
            }

        }
    }

    public boolean isBucks()
    {
        return "EBAY_BUCKS".equals(programName);
    }

    public boolean isNectarPoints()
    {
        return "EBAY_UK_NECTAR".equals(programName);
    }
}

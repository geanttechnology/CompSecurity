// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model.cart;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.ebay.common.model.cart:
//            UserIncentives, RewardsIncentive, Incentive

public final class ItemIncentives extends UserIncentives
    implements Serializable
{

    public final String itemId;
    public List rewards;

    public ItemIncentives(JSONObject jsonobject, String s)
        throws JSONException
    {
        Object obj1 = null;
        Object obj = null;
        rewards = new ArrayList();
        JSONArray jsonarray1 = getArray(jsonobject, new String[] {
            "itemRewardsIncentive", "rewardsIncentiveList", "rewardsIncentive"
        });
        if (jsonarray1 != null)
        {
            for (int i = 0; i < jsonarray1.length(); i++)
            {
                rewards.add(new RewardsIncentive(jsonarray1.getJSONObject(i), s));
            }

        }
        incentives = new ArrayList();
        jsonarray1 = getArray(jsonobject, new String[] {
            "itemCouponIncentive", "itemApplicableIncentives"
        });
        s = obj1;
        if (jsonarray1 != null)
        {
            int j = 0;
            s = obj;
            for (; j < jsonarray1.length(); j++)
            {
                s = getString(jsonobject, "itemId");
                JSONArray jsonarray = getArray(jsonarray1.getJSONObject(j), new String[] {
                    "applicableIncentives"
                });
                if (jsonarray == null)
                {
                    continue;
                }
                for (int l = 0; l < jsonarray.length(); l++)
                {
                    incentives.add(new Incentive(jsonarray.getJSONObject(l)));
                }

            }

        }
        itemId = s;
        campaigns = new ArrayList();
        jsonobject = getArray(jsonobject, new String[] {
            "campaignList", "campaign"
        });
        if (jsonobject != null)
        {
            for (int k = 0; k < jsonobject.length(); k++)
            {
                campaigns.add(new Incentive.Campaign(jsonobject.getJSONObject(k)));
            }

        }
    }
}

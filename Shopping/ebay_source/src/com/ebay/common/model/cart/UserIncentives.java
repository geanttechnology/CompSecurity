// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model.cart;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.ebay.common.model.cart:
//            JsonModel, Incentive

public class UserIncentives extends JsonModel
    implements Serializable
{

    public List campaigns;
    public List incentives;

    protected UserIncentives()
    {
    }

    public UserIncentives(JSONObject jsonobject)
        throws JSONException
    {
        super(jsonobject);
        incentives = new ArrayList();
        JSONArray jsonarray = getArray(jsonobject, new String[] {
            "incentiveList", "incentive"
        });
        if (jsonarray != null)
        {
            for (int i = 0; i < jsonarray.length(); i++)
            {
                incentives.add(new Incentive(jsonarray.getJSONObject(i)));
            }

        }
        campaigns = new ArrayList();
        jsonobject = getArray(jsonobject, new String[] {
            "campaignList", "campaign"
        });
        if (jsonobject != null)
        {
            for (int j = 0; j < jsonobject.length(); j++)
            {
                campaigns.add(new Incentive.Campaign(jsonobject.getJSONObject(j)));
            }

        }
    }

    public void merge(UserIncentives userincentives)
    {
        if (userincentives != null)
        {
            Iterator iterator = userincentives.incentives.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                Incentive incentive = (Incentive)iterator.next();
                boolean flag2 = false;
                Iterator iterator2 = incentives.iterator();
                boolean flag;
                do
                {
                    flag = flag2;
                    if (!iterator2.hasNext())
                    {
                        break;
                    }
                    if (!((Incentive)iterator2.next()).id.equals(incentive.id))
                    {
                        continue;
                    }
                    flag = true;
                    break;
                } while (true);
                if (!flag)
                {
                    incentives.add(incentive);
                }
            } while (true);
            userincentives = userincentives.campaigns.iterator();
            while (userincentives.hasNext()) 
            {
                Incentive.Campaign campaign = (Incentive.Campaign)userincentives.next();
                boolean flag3 = false;
                Iterator iterator1 = campaigns.iterator();
                boolean flag1;
                do
                {
                    flag1 = flag3;
                    if (!iterator1.hasNext())
                    {
                        break;
                    }
                    if (!((Incentive.Campaign)iterator1.next()).campaignId.equals(campaign.campaignId))
                    {
                        continue;
                    }
                    flag1 = true;
                    break;
                } while (true);
                if (!flag1)
                {
                    campaigns.add(campaign);
                }
            }
        }
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.content.Context;
import com.groupon.db.models.Deal;
import com.groupon.db.models.Recommendation;
import com.groupon.models.country.Country;
import com.groupon.service.core.AbTestService;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.util:
//            DealUtils

public class MerchantRecommendationsUtil
{

    AbTestService abTestService;
    Context context;
    CurrentCountryManager currentCountryManager;
    private boolean tipsRecoUGConDDUSCA1014Enabled;

    public MerchantRecommendationsUtil()
    {
    }

    private void init()
    {
        boolean flag;
        if (abTestService.isVariantEnabled("tipsRecoUGConDDUSCA1014", "on") && currentCountryManager.getCurrentCountry().isUSACompatible())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        tipsRecoUGConDDUSCA1014Enabled = flag;
    }

    public Recommendation extractMerchantRecommendation(Deal deal)
    {
        Object obj = null;
        Recommendation recommendation = obj;
        if (tipsRecoUGConDDUSCA1014Enabled)
        {
            recommendation = obj;
            if (deal.channels.isEmpty())
            {
                deal = DealUtils.getDealRecommendations(deal).iterator();
                recommendation = obj;
                if (deal.hasNext())
                {
                    recommendation = (Recommendation)deal.next();
                }
            }
        }
        return recommendation;
    }

    public String generateMerchantRecommendationLabelHtml(Recommendation recommendation)
    {
        Object obj = null;
        String s = obj;
        if (recommendation != null)
        {
            String s1 = recommendation.percentMessage;
            recommendation = recommendation.totalMessage;
            s = obj;
            if (Strings.notEmpty(s1))
            {
                s = obj;
                if (Strings.notEmpty(recommendation))
                {
                    s = context.getString(0x7f080308, new Object[] {
                        s1, recommendation
                    });
                }
            }
        }
        return s;
    }
}

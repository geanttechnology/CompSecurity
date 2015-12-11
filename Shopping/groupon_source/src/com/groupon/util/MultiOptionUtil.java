// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import com.groupon.Channel;
import com.groupon.db.models.Deal;
import com.groupon.models.country.Country;
import com.groupon.models.deal.SharedDealInfo;
import com.groupon.models.deal.SharedDealInfoConverter;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.util:
//            DealUtils

public class MultiOptionUtil
{

    private CurrentCountryManager currentCountryManager;
    private SharedDealInfoConverter sharedDealInfoConverter;

    private MultiOptionUtil()
    {
    }

    private void init()
    {
    }

    public boolean canDisplayExposedMultiOptions(Deal deal, Channel channel, boolean flag)
    {
        return deal != null && canDisplayExposedMultiOptions(sharedDealInfoConverter.convertFrom(deal, channel), flag);
    }

    public boolean canDisplayExposedMultiOptions(SharedDealInfo shareddealinfo, boolean flag)
    {
        boolean flag5 = true;
        if (shareddealinfo != null && !currentCountryManager.getCurrentCountry().isJapan()) goto _L2; else goto _L1
_L1:
        flag = false;
_L4:
        return flag;
_L2:
        boolean flag1;
        boolean flag2;
        boolean flag3;
        boolean flag4;
        boolean flag6;
        boolean flag7;
        if (DealUtils.isG1Deal(shareddealinfo) || DealUtils.isGoodsShoppingDeal(shareddealinfo) || DealUtils.isGetawaysTravelDeal(shareddealinfo) && !shareddealinfo.isTravelBookableDeal)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (shareddealinfo.derivedOptionsCount > 1)
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        flag6 = Strings.equalsIgnoreCase("closed", shareddealinfo.status);
        if (!DealUtils.isGoodsShoppingDeal(shareddealinfo) || shareddealinfo.optionDimensionsCount <= 0)
        {
            flag3 = true;
        } else
        {
            flag3 = false;
        }
        flag7 = shareddealinfo.derivedHasBookableOrSchedulableOptions;
        if (flag || !flag7)
        {
            flag4 = true;
        } else
        {
            flag4 = false;
        }
        if (!flag1 || !flag2 || !flag3 || !flag4 || shareddealinfo.isSoldOut || flag6)
        {
            break; /* Loop/switch isn't completed */
        }
        flag = flag5;
        if (!shareddealinfo.derivedHasHasExternalUrl) goto _L4; else goto _L3
_L3:
        return false;
    }
}

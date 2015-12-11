// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.os.SystemClock;
import com.groupon.db.models.Deal;
import com.groupon.db.models.Option;
import com.groupon.loader.DealLoaderCallbacks;
import com.groupon.models.country.Country;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.BuyUtils;
import com.groupon.util.DealUtils;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.activity:
//            DealDetails, IntentFactory

class cks extends DealLoaderCallbacks
{

    final DealDetails this$0;
    final long val$dealLoaderCallbacksStartTime;

    public void onDealLoaded(Deal deal)
    {
        boolean flag3 = false;
        int i;
        boolean flag2;
        if (!DealDetails.access$1200(DealDetails.this).getCurrentCountry().isJapan())
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        i = deal.optionDimensionsCount(flag2, DealDetails.access$1200(DealDetails.this).getCurrentCountry().isUSACompatible());
        if (isDeepLinked && DealDetails.access$1300(DealDetails.this).showOptionsWithImages(deal, DealDetails.this))
        {
            startActivity(intentFactory.newGoodsMultiOptionIntent(deal.remoteId, channel, i).putExtra("isDeepLinked", isDeepLinked));
            finish();
            return;
        }
        DealDetails.access$1402(DealDetails.this, deal);
        DealDetails.access$1502(DealDetails.this, DealUtils.createOptionsByIdMap(deal));
        DealDetails.access$1600(DealDetails.this);
        DealDetails dealdetails;
        long l;
        if (Strings.notEmpty(DealDetails.access$1700(DealDetails.this)))
        {
            DealDetails.access$1802(DealDetails.this, (Option)DealDetails.access$1500(DealDetails.this).get(DealDetails.access$1700(DealDetails.this)));
        } else
        {
label0:
            {
                if (!Strings.notEmpty(preselectedOptionId))
                {
                    break label0;
                }
                DealDetails.access$1802(DealDetails.this, (Option)DealDetails.access$1500(DealDetails.this).get(preselectedOptionId));
            }
        }
_L2:
label1:
        {
            if (DealDetails.access$1800(DealDetails.this) == null)
            {
                DealDetails.access$1802(DealDetails.this, (Option)DealDetails.access$1500(DealDetails.this).get(deal.defaultOptionId));
            }
            if (DealDetails.access$2000(DealDetails.this) == null && DealDetails.access$1800(DealDetails.this) != null)
            {
                DealDetails.access$2002(DealDetails.this, DealDetails.access$2100(DealDetails.this, deal, DealDetails.access$1800(DealDetails.this)));
            }
            Iterator iterator;
            Option option;
            boolean flag;
            boolean flag1;
            if (Strings.equalsIgnoreCase("closed", deal.status) || DealDetails.access$1800(DealDetails.this) != null && Strings.equalsIgnoreCase("closed", DealDetails.access$1800(DealDetails.this).status))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (deal.isSoldOut() || DealDetails.access$1800(DealDetails.this) != null && DealDetails.access$1800(DealDetails.this).isSoldOut())
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            if (!flag)
            {
                DealDetails.access$2200(DealDetails.this);
            }
            dealdetails = DealDetails.this;
            if (!flag)
            {
                flag2 = flag3;
                if (!flag1)
                {
                    break label1;
                }
            }
            flag2 = true;
        }
        DealDetails.access$2302(dealdetails, flag2);
        if (!DealDetails.access$2400(DealDetails.this))
        {
            DealDetails.access$2500(DealDetails.this, deal);
            DealDetails.access$2402(DealDetails.this, true);
        }
        DealDetails.access$2600(DealDetails.this);
        l = SystemClock.elapsedRealtime();
        logger.logGeneralEvent("deal_performance", "on_deal_detals_loaded", dealId, (int)(l - val$dealLoaderCallbacksStartTime), Logger.NULL_NST_FIELD);
        return;
        iterator = deal.getOptions().iterator();
_L4:
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        option = (Option)iterator.next();
        if (option.isSoldOutOrExpired()) goto _L4; else goto _L3
_L3:
        DealDetails.access$1802(DealDetails.this, option);
        DealDetails.access$1902(DealDetails.this, DealDetails.access$1800(DealDetails.this).remoteId);
          goto _L2
    }

    public void onLoadFinished(Loader loader, Deal deal)
    {
        super.onLoadFinished(loader, deal);
    }

    public volatile void onLoadFinished(Loader loader, Object obj)
    {
        onLoadFinished(loader, (Deal)obj);
    }

    ger(String s, Date date, Date date1, boolean flag, boolean flag1, 
            long l)
    {
        this$0 = final_dealdetails;
        val$dealLoaderCallbacksStartTime = l;
        super(Context.this, s, date, date1, flag, flag1);
    }
}

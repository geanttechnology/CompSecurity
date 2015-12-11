// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.v3.processor;

import android.content.Context;
import com.groupon.db.dao.DaoCouponCategory;
import com.groupon.db.dao.DaoCouponMerchant;
import com.groupon.db.dao.DaoCouponSummary;
import com.groupon.db.models.CouponSummary;
import com.groupon.db.models.DealSubsetAttribute;
import com.groupon.db.models.Pagination;
import com.groupon.v3.processor.pipeline.ProcessingContext;
import com.groupon.v3.view.list_view.CouponSummaryWrapper;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;

// Referenced classes of package com.groupon.v3.processor:
//            BackgroundDataProcessor

public class SingleListCouponLoader extends BackgroundDataProcessor
{

    protected Context context;
    protected DaoCouponCategory daoCouponCategory;
    protected DaoCouponMerchant daoCouponMerchant;
    protected DaoCouponSummary daoCouponSummary;
    protected String dbChannel;
    protected boolean isCouponMerchant;

    public SingleListCouponLoader(Context context1, String s, boolean flag)
    {
        super(true);
        RoboGuice.getInjector(context1).injectMembers(this);
        context = context1;
        dbChannel = s;
        isCouponMerchant = flag;
    }

    public List process(List list, DealSubsetAttribute dealsubsetattribute, Pagination pagination, ProcessingContext processingcontext)
    {
        list = new ArrayList();
        int i;
        try
        {
            dealsubsetattribute = daoCouponSummary.queryForEq("channel", dbChannel);
        }
        // Misplaced declaration of an exception variable
        catch (List list)
        {
            throw new RuntimeException(list);
        }
        i = 0;
        if (i >= dealsubsetattribute.size())
        {
            break; /* Loop/switch isn't completed */
        }
        list.add(new CouponSummaryWrapper(com.groupon.v3.view.list_view.CouponSummaryWrapper.CouponSummaryLocation.COUPON_SUMMARY_ON_SEARCH_RESULT_FRAGMENT, (CouponSummary)dealsubsetattribute.get(i), i));
        i++;
        if (true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_25;
_L1:
        if (!isCouponMerchant)
        {
            break MISSING_BLOCK_LABEL_108;
        }
        dealsubsetattribute = daoCouponMerchant.getFirstCouponMerchant(dbChannel);
        if (dealsubsetattribute == null)
        {
            break MISSING_BLOCK_LABEL_144;
        }
        list.add(dealsubsetattribute);
        return list;
        dealsubsetattribute = daoCouponCategory.getFirstByChannelId(dbChannel);
        if (dealsubsetattribute == null)
        {
            break MISSING_BLOCK_LABEL_144;
        }
        list.add(dealsubsetattribute);
        return list;
        return list;
    }
}

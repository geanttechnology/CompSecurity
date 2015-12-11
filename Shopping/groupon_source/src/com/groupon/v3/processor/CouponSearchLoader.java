// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.v3.processor;

import android.content.Context;
import com.groupon.db.dao.DaoCouponMerchant;
import com.groupon.db.models.CouponMerchant;
import com.groupon.db.models.DealSubsetAttribute;
import com.groupon.db.models.Pagination;
import com.groupon.v3.processor.pipeline.ProcessingContext;
import com.groupon.v3.view.list_view.CouponListItemType;
import com.groupon.v3.view.list_view.CouponMerchantWrapper;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;

// Referenced classes of package com.groupon.v3.processor:
//            BackgroundDataProcessor

public class CouponSearchLoader extends BackgroundDataProcessor
{

    protected DaoCouponMerchant daoCouponMerchant;
    protected String dbChannel;

    public CouponSearchLoader(Context context, String s)
    {
        RoboGuice.getInjector(context).injectMembers(this);
        dbChannel = s;
    }

    public List process(List list, DealSubsetAttribute dealsubsetattribute, Pagination pagination, ProcessingContext processingcontext)
    {
_L2:
        if (i >= dealsubsetattribute.size())
        {
            break MISSING_BLOCK_LABEL_114;
        }
        list.add((new CouponMerchantWrapper(com.groupon.v3.view.list_view.CouponMerchantWrapper.CouponMerchantType.SEARCH_RECOMMENDATION, (CouponMerchant)dealsubsetattribute.get(i))).setVerticalPosition(i));
        i++;
        continue; /* Loop/switch isn't completed */
        return list;
        list = new ArrayList();
        int i;
        try
        {
            dealsubsetattribute = daoCouponMerchant.queryForEq("channel", dbChannel);
            if (!dealsubsetattribute.isEmpty())
            {
                list.add(new CouponListItemType(com.groupon.v3.view.list_view.CouponListItemType.ListItemType.COUPON_LiST_SEARCH_HEADER_MERCHANTS));
            }
        }
        // Misplaced declaration of an exception variable
        catch (List list)
        {
            throw new RuntimeException(list);
        }
        i = 0;
        if (true) goto _L2; else goto _L1
_L1:
    }
}

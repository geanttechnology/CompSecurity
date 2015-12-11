// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.v3.processor;

import android.content.Context;
import com.groupon.Channel;
import com.groupon.db.dao.DaoCouponCategory;
import com.groupon.db.dao.DaoCouponMerchant;
import com.groupon.db.dao.DaoCouponSummary;
import com.groupon.db.models.CouponSummary;
import com.groupon.db.models.DealSubsetAttribute;
import com.groupon.db.models.Pagination;
import com.groupon.v3.processor.pipeline.ProcessingContext;
import com.groupon.v3.view.list_view.CouponListItemType;
import com.groupon.v3.view.list_view.CouponSummaryWrapper;
import com.groupon.v3.view.list_view.CouponTopItemType;
import com.groupon.view.widgetcards.CouponTopItem;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;

// Referenced classes of package com.groupon.v3.processor:
//            BackgroundDataProcessor

public class CouponLoader extends BackgroundDataProcessor
{

    protected DaoCouponCategory daoCouponCategory;
    protected DaoCouponMerchant daoCouponMerchant;
    protected DaoCouponSummary daoCouponSummary;
    protected String dbChannel;
    protected boolean isUnitedStates;
    protected String topDbChannel;

    public CouponLoader(Context context, String s, String s1, boolean flag)
    {
        super(true);
        RoboGuice.getInjector(context).injectMembers(this);
        dbChannel = s;
        topDbChannel = s1;
        isUnitedStates = flag;
    }

    protected List createCombinedCategory(List list, com.groupon.v3.view.list_view.CouponTopItemType.ItemType itemtype)
    {
        ArrayList arraylist = new ArrayList();
        int i = 0;
        CouponTopItemType coupontopitemtype = new CouponTopItemType(itemtype, 0);
        Iterator iterator = list.iterator();
        list = coupontopitemtype;
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            CouponTopItem coupontopitem = (CouponTopItem)iterator.next();
            if (!list.addItem(coupontopitem))
            {
                arraylist.add(list);
                i++;
                list = new CouponTopItemType(itemtype, i);
                list.addItem(coupontopitem);
            }
        } while (true);
        arraylist.add(list);
        return arraylist;
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
        if (dealsubsetattribute == null)
        {
            break MISSING_BLOCK_LABEL_352;
        }
        if (dealsubsetattribute.size() <= 0)
        {
            break MISSING_BLOCK_LABEL_352;
        }
        pagination = daoCouponMerchant.queryForEq("channel", Channel.encodePath(new String[] {
            dbChannel, "NEARBY"
        }));
        if (pagination.size() > 0 && isUnitedStates)
        {
            list.add(new CouponListItemType(com.groupon.v3.view.list_view.CouponListItemType.ListItemType.COUPON_LIST_HEADER_NEARBY_STORES));
            processingcontext = new ArrayList();
            processingcontext.addAll(pagination);
            list.addAll(createCombinedCategory(processingcontext, com.groupon.v3.view.list_view.CouponTopItemType.ItemType.NEARBY));
        }
        if (dealsubsetattribute.size() <= 0) goto _L2; else goto _L1
_L1:
        list.add(new CouponListItemType(com.groupon.v3.view.list_view.CouponListItemType.ListItemType.COUPON_LIST_HEADER_COUPONS));
        i = 0;
_L3:
        if (i >= dealsubsetattribute.size())
        {
            break; /* Loop/switch isn't completed */
        }
        list.add(new CouponSummaryWrapper(com.groupon.v3.view.list_view.CouponSummaryWrapper.CouponSummaryLocation.COUPON_SUMMARY_ON_CAROUSEL, (CouponSummary)dealsubsetattribute.get(i), i));
        i++;
        if (true) goto _L3; else goto _L2
_L2:
        dealsubsetattribute = daoCouponMerchant.queryForEq("channel", topDbChannel);
        if (dealsubsetattribute.size() > 0)
        {
            list.add(new CouponListItemType(com.groupon.v3.view.list_view.CouponListItemType.ListItemType.COUPON_LIST_HEADER_MERCHANTS));
            pagination = new ArrayList();
            pagination.addAll(dealsubsetattribute);
            list.addAll(createCombinedCategory(pagination, com.groupon.v3.view.list_view.CouponTopItemType.ItemType.TOP_MERCHANT));
        }
        dealsubsetattribute = daoCouponCategory.queryForEq("channel", topDbChannel);
        if (dealsubsetattribute.size() > 0)
        {
            list.add(new CouponListItemType(com.groupon.v3.view.list_view.CouponListItemType.ListItemType.COUPON_LIST_HEADER_CATEGORIES));
            pagination = new ArrayList();
            pagination.addAll(dealsubsetattribute);
            list.addAll(createCombinedCategory(pagination, com.groupon.v3.view.list_view.CouponTopItemType.ItemType.TOP_CATEGORY));
        }
        return list;
    }
}

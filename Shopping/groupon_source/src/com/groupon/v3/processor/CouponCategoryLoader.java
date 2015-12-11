// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.v3.processor;

import android.content.Context;
import com.groupon.db.dao.DaoCouponCategory;
import com.groupon.db.models.CouponCategory;
import com.groupon.db.models.DealSubsetAttribute;
import com.groupon.db.models.FauxDealSubsetAttribute;
import com.groupon.db.models.Pagination;
import com.groupon.v3.processor.pipeline.ProcessingContext;
import com.groupon.v3.view.list_view.CouponCategoryWrapper;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.v3.processor:
//            BackgroundDataProcessor

public class CouponCategoryLoader extends BackgroundDataProcessor
{

    protected com.groupon.v3.view.list_view.CouponCategoryWrapper.CouponCategoryType couponCategoryType;
    protected DaoCouponCategory daoCouponCategory;
    protected String dbChannel;
    protected String title;

    public CouponCategoryLoader(Context context, String s, com.groupon.v3.view.list_view.CouponCategoryWrapper.CouponCategoryType couponcategorytype, String s1)
    {
        title = "";
        RoboGuice.getInjector(context).injectMembers(this);
        dbChannel = s;
        couponCategoryType = couponcategorytype;
        title = s1;
    }

    public List process(List list, DealSubsetAttribute dealsubsetattribute, Pagination pagination, ProcessingContext processingcontext)
    {
        int i;
        dealsubsetattribute = list;
        if (list == null)
        {
            dealsubsetattribute = new ArrayList();
        }
        try
        {
            list = daoCouponCategory.queryForEq("channel", dbChannel);
        }
        // Misplaced declaration of an exception variable
        catch (List list)
        {
            throw new RuntimeException(list);
        }
        if (list == null) goto _L2; else goto _L1
_L1:
        if (list.size() <= 0) goto _L2; else goto _L3
_L3:
        if (Strings.notEmpty(title))
        {
            dealsubsetattribute.add(new FauxDealSubsetAttribute(title));
        }
          goto _L4
_L7:
        if (i >= list.size()) goto _L2; else goto _L5
_L5:
        dealsubsetattribute.add(new CouponCategoryWrapper(couponCategoryType, (CouponCategory)list.get(i), i));
        i++;
        continue; /* Loop/switch isn't completed */
_L2:
        return dealsubsetattribute;
_L4:
        i = 0;
        if (true) goto _L7; else goto _L6
_L6:
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.v3.processor;

import android.content.Context;
import com.groupon.db.dao.DaoCouponMerchant;
import com.groupon.db.models.DealSubsetAttribute;
import com.groupon.db.models.Pagination;
import com.groupon.v3.processor.pipeline.ProcessingContext;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;

// Referenced classes of package com.groupon.v3.processor:
//            BackgroundDataProcessor

public class CouponMerchantLoader extends BackgroundDataProcessor
{

    protected DaoCouponMerchant daoCouponMerchant;
    protected String dbChannel;

    public CouponMerchantLoader(Context context, String s)
    {
        RoboGuice.getInjector(context).injectMembers(this);
        dbChannel = s;
    }

    public List process(List list, DealSubsetAttribute dealsubsetattribute, Pagination pagination, ProcessingContext processingcontext)
    {
        list = new ArrayList();
        try
        {
            list.addAll(daoCouponMerchant.queryForEq("channel", dbChannel));
        }
        // Misplaced declaration of an exception variable
        catch (List list)
        {
            throw new RuntimeException(list);
        }
        return list;
    }
}

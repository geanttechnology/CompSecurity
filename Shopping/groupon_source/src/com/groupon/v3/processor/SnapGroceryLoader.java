// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.v3.processor;

import android.content.Context;
import android.content.res.Resources;
import com.groupon.db.dao.DaoSnapGroceryDetails;
import com.groupon.db.models.DealSubsetAttribute;
import com.groupon.db.models.FauxDealSubsetAttribute;
import com.groupon.db.models.Pagination;
import com.groupon.v3.processor.pipeline.ProcessingContext;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;

// Referenced classes of package com.groupon.v3.processor:
//            BackgroundDataProcessor

public class SnapGroceryLoader extends BackgroundDataProcessor
{

    protected Context context;
    protected DaoSnapGroceryDetails daoSnapGroceryDetails;
    protected String dbChannel;
    protected boolean isUnitedStates;
    protected String topDbChannel;

    public SnapGroceryLoader(Context context1, String s, String s1, boolean flag)
    {
        super(true);
        RoboGuice.getInjector(context1).injectMembers(this);
        context = context1;
        dbChannel = s;
        topDbChannel = s1;
        isUnitedStates = flag;
    }

    public List process(List list, DealSubsetAttribute dealsubsetattribute, Pagination pagination, ProcessingContext processingcontext)
    {
        list = new ArrayList();
        try
        {
            dealsubsetattribute = daoSnapGroceryDetails.queryForEq("channel", dbChannel);
        }
        // Misplaced declaration of an exception variable
        catch (List list)
        {
            throw new RuntimeException(list);
        }
        if (dealsubsetattribute == null)
        {
            break MISSING_BLOCK_LABEL_69;
        }
        if (!dealsubsetattribute.isEmpty())
        {
            list.add(new FauxDealSubsetAttribute(context.getResources().getString(0x7f080219)));
            list.addAll(dealsubsetattribute);
        }
        return list;
    }
}

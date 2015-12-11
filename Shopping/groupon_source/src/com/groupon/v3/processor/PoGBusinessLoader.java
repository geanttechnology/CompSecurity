// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.v3.processor;

import android.content.Context;
import com.groupon.db.dao.DaoBusinessSummary;
import com.groupon.db.models.BusinessSummary;
import com.groupon.db.models.DealSubsetAttribute;
import com.groupon.db.models.FauxDealSubsetAttribute;
import com.groupon.db.models.Pagination;
import com.groupon.v3.processor.pipeline.ProcessingContext;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.v3.processor:
//            BackgroundDataProcessor

public class PoGBusinessLoader extends BackgroundDataProcessor
{

    protected DaoBusinessSummary daoBusinessSummary;
    protected String dbChannel;
    protected String header;

    public PoGBusinessLoader(Context context, String s, String s1)
    {
        RoboGuice.getInjector(context).injectMembers(this);
        dbChannel = s;
        header = s1;
    }

    public List process(List list, DealSubsetAttribute dealsubsetattribute, Pagination pagination, ProcessingContext processingcontext)
    {
_L2:
        if (i >= dealsubsetattribute.size())
        {
            break MISSING_BLOCK_LABEL_140;
        }
        pagination = (BusinessSummary)dealsubsetattribute.get(i);
        processingcontext = new com.groupon.db.models.AttrsContainer.AttrsContainerMap();
        processingcontext.put("position", Integer.valueOf(i));
        pagination.setAttrs(processingcontext);
        list.add(pagination);
        i++;
        continue; /* Loop/switch isn't completed */
        return list;
        list = new ArrayList();
        int i;
        try
        {
            dealsubsetattribute = daoBusinessSummary.queryForEq("channel", dbChannel);
            if (!dealsubsetattribute.isEmpty() && Strings.notEmpty(header))
            {
                list.add(new FauxDealSubsetAttribute(header));
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

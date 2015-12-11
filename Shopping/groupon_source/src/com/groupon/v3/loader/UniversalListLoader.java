// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.v3.loader;

import android.content.Context;
import com.groupon.db.dao.DaoDealSubsetAttribute;
import com.groupon.db.dao.DaoPagination;
import com.groupon.db.events.UniversalUpdateEvent;
import com.groupon.db.models.DealSubsetAttribute;
import com.groupon.db.models.Pagination;
import com.groupon.v3.processor.BackgroundDataProcessor;
import com.groupon.v3.processor.pipeline.ProcessingContext;
import commonlib.loader.event.UpdateEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.v3.loader:
//            UniversalListLoadResultData

public class UniversalListLoader extends com.groupon.v3.commonlib.loader.ListLoaderCallbacksV3.ListLoader
{

    protected String dbChannel;
    protected DaoDealSubsetAttribute dealSubsetAttributeDao;
    protected DaoPagination paginationDao;

    public UniversalListLoader(Class class1, Class class2, Context context, String s)
    {
        super(class1, class2, context);
        RoboGuice.getInjector(context).injectMembers(this);
        dbChannel = s;
    }

    public UniversalListLoadResultData loadInBackground()
    {
        Object obj;
        Object obj1;
        Pagination pagination;
        DealSubsetAttribute dealsubsetattribute;
        ProcessingContext processingcontext;
        BackgroundDataProcessor abackgrounddataprocessor[];
        int i;
        int j;
        try
        {
            pagination = (Pagination)paginationDao.queryForFirstEq("channel", dbChannel);
            dealsubsetattribute = (DealSubsetAttribute)dealSubsetAttributeDao.queryForFirstEq("channel", dbChannel);
        }
        catch (SQLException sqlexception)
        {
            throw new RuntimeException(sqlexception);
        }
        obj1 = null;
        obj = null;
        processingcontext = new ProcessingContext();
        processingcontext.putAttr("context", getContext());
        if (backgroundDataProcessors == null) goto _L2; else goto _L1
_L1:
        abackgrounddataprocessor = backgroundDataProcessors;
        j = abackgrounddataprocessor.length;
        i = 0;
_L3:
        obj1 = obj;
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        obj = abackgrounddataprocessor[i].doProcess(((java.util.List) (obj)), dealsubsetattribute, pagination, processingcontext);
        i++;
        if (true) goto _L3; else goto _L2
_L2:
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_140;
        }
        obj = new ArrayList(((java.util.Collection) (obj1)));
_L4:
        obj = new UniversalListLoadResultData(((java.util.List) (obj)), dealsubsetattribute, pagination);
        return ((UniversalListLoadResultData) (obj));
        obj = null;
          goto _L4
    }

    public volatile Object loadInBackground()
    {
        return loadInBackground();
    }

    public void setDbChannel(String s)
    {
        dbChannel = s;
    }

    protected boolean shouldReload(UniversalUpdateEvent universalupdateevent)
    {
        return Strings.equals(universalupdateevent.channel, dbChannel);
    }

    protected volatile boolean shouldReload(UpdateEvent updateevent)
    {
        return shouldReload((UniversalUpdateEvent)updateevent);
    }
}

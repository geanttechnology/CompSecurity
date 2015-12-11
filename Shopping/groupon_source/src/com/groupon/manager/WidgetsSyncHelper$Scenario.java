// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.manager;

import com.groupon.db.dao.DaoWidgetSummary;
import com.groupon.db.models.Relevance;
import com.groupon.db.models.WidgetSummary;
import com.groupon.models.MoreAssets;
import com.groupon.models.MoreAssetsDeals;
import com.groupon.models.Slot;
import com.groupon.models.View;
import com.groupon.models.Widget;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.manager:
//            WidgetsSyncHelper, WidgetSyncManagerContext

protected static class slots
{

    private String id;
    private String requestId;
    private Collection slots;
    private String treatment;

    public void afterJsonDeserializationPostProcessor(String s, WidgetSyncManagerContext widgetsyncmanagercontext, DaoWidgetSummary daowidgetsummary)
    {
        for (Iterator iterator = slots.iterator(); iterator.hasNext();)
        {
            Slot slot = (Slot)iterator.next();
            Iterator iterator1 = slot.widgets.iterator();
            while (iterator1.hasNext()) 
            {
                Widget widget = (Widget)iterator1.next();
                WidgetSummary widgetsummary = widget.widgetSummary;
                widgetsummary.slotId = slot.id;
                widgetsummary.channel = s;
                widgetsummary.requestId = requestId;
                widgetsummary.scenarioId = id;
                widgetsummary.scenarioTreatment = treatment;
                MoreAssetsDeals moreassetsdeals = widget.moreAssets.deals;
                widgetsummary.moreAssetsDealsUrl = moreassetsdeals.url;
                widgetsummary.moreAssetsDealsCount = moreassetsdeals.count;
                if (widget.relevanceService != null)
                {
                    widgetsummary.relevanceServiceContext = widget.relevanceService.context;
                    widgetsummary.relevanceServiceTreatment = widget.relevanceService.treatment;
                }
                widgetsummary.treatment = widget.treatment;
                widgetsummary.displayName = widget.displayName;
                widgetsummary.type = widget.type;
                if (widget.view != null)
                {
                    widgetsummary.viewLayout = widget.view.layout;
                    if (Strings.notEmpty(widget.view.campaign))
                    {
                        widgetsummary.campaign = widget.view.campaign;
                    }
                }
                try
                {
                    daowidgetsummary.update(widgetsummary);
                    widgetsyncmanagercontext.incWidgetCount();
                }
                // Misplaced declaration of an exception variable
                catch (String s)
                {
                    throw new RuntimeException(s);
                }
            }
        }

    }


    protected ()
    {
        requestId = "";
        id = "";
        treatment = "";
        slots = Collections.emptyList();
    }
}

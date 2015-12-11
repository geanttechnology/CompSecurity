// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.adapter.widget;

import android.content.Context;
import com.groupon.Channel;
import com.groupon.db.models.WidgetSummary;
import com.groupon.util.AppStartupImageLoadListener;
import com.groupon.util.GeoPoint;
import com.groupon.util.LoggingUtils;
import com.groupon.view.DealSetCallbacks;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.groupon.adapter.widget:
//            WidgetListAdapter

public class FilterableWidgetListAdapter extends WidgetListAdapter
{

    LinkedHashMap filteredWidgetLists;

    public transient FilterableWidgetListAdapter(Context context, DealSetCallbacks dealsetcallbacks, AppStartupImageLoadListener appstartupimageloadlistener, GeoPoint geopoint, LoggingUtils loggingutils, String s, Channel channel, 
            boolean flag, String as[])
    {
        super(context, dealsetcallbacks, appstartupimageloadlistener, geopoint, loggingutils, s, flag, channel);
        filteredWidgetLists = new LinkedHashMap();
        int j = as.length;
        for (int i = 0; i < j; i++)
        {
            context = as[i];
            filteredWidgetLists.put(context, new ArrayList());
        }

    }

    public transient FilterableWidgetListAdapter(Context context, DealSetCallbacks dealsetcallbacks, AppStartupImageLoadListener appstartupimageloadlistener, GeoPoint geopoint, LoggingUtils loggingutils, String s, Channel channel, 
            String as[])
    {
        this(context, dealsetcallbacks, appstartupimageloadlistener, geopoint, loggingutils, s, channel, false, as);
    }

    public String getDisplayName(int i, String s)
    {
        if (filteredWidgetLists.get(s) != null)
        {
            return ((WidgetSummary)((List)filteredWidgetLists.get(s)).get(i)).displayName;
        } else
        {
            return "";
        }
    }

    public String getLayoutType(int i, String s)
    {
        if (filteredWidgetLists.get(s) != null)
        {
            return ((WidgetSummary)((List)filteredWidgetLists.get(s)).get(i)).viewLayout;
        } else
        {
            return "";
        }
    }

    protected void groupWidgetsBySlots(List list)
    {
        String s;
        for (Iterator iterator = filteredWidgetLists.keySet().iterator(); iterator.hasNext(); filteredWidgetLists.put(s, new ArrayList()))
        {
            s = (String)iterator.next();
        }

        list = list.iterator();
        do
        {
            if (!list.hasNext())
            {
                break;
            }
            WidgetSummary widgetsummary = (WidgetSummary)list.next();
            if (filteredWidgetLists.containsKey(widgetsummary.slotId))
            {
                ((List)filteredWidgetLists.get(widgetsummary.slotId)).add(widgetsummary);
            }
        } while (true);
    }

    public void transform(List list)
    {
        groupWidgetsBySlots(list);
        list = new ArrayList();
        String s;
        for (Iterator iterator = filteredWidgetLists.keySet().iterator(); iterator.hasNext(); list.addAll((Collection)filteredWidgetLists.get(s)))
        {
            s = (String)iterator.next();
        }

        super.transform(list);
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.timeline;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.kindle.timeline.model.ExpandableListAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.amazon.gallery.framework.kindle.timeline:
//            TimelineViewHolder, TimelineMarker, TimelineMarkerContainer

public class TimelineListAdapter extends ExpandableListAdapter
{

    private static final String TAG = com/amazon/gallery/framework/kindle/timeline/TimelineListAdapter.getName();
    private Context context;
    private final float itemHeight;
    protected Map monthIndices;
    protected Map yearIndices;

    public TimelineListAdapter(Context context1)
    {
        yearIndices = new HashMap();
        monthIndices = new HashMap();
        context = context1;
        itemHeight = context1.getResources().getDimension(0x7f0a01e0);
    }

    public static int getUniqueMonthKey(int i, int j)
    {
        return i * 13 + j;
    }

    public void expandYear(int i)
    {
        Integer integer = (Integer)yearIndices.get(Integer.valueOf(i));
        if (integer == null)
        {
            GLogger.w(TAG, "year was invalid in timelineNav moveto: %d", new Object[] {
                Integer.valueOf(i)
            });
            return;
        } else
        {
            expandContainer(integer.intValue());
            return;
        }
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        this;
        JVM INSTR monitorenter ;
        com.amazon.gallery.framework.kindle.timeline.model.ExpandableListComponent expandablelistcomponent = getItem(i);
        if (view != null)
        {
            break MISSING_BLOCK_LABEL_51;
        }
        viewgroup = new TimelineViewHolder(context, itemHeight);
        view = viewgroup.getView();
_L1:
        viewgroup.setup((TimelineMarker)expandablelistcomponent, context);
        this;
        JVM INSTR monitorexit ;
        return view;
        viewgroup = (TimelineViewHolder)view.getTag();
          goto _L1
_L3:
        this;
        JVM INSTR monitorexit ;
        throw view;
        view;
        continue; /* Loop/switch isn't completed */
        view;
        if (true) goto _L3; else goto _L2
_L2:
    }

    public Integer getYearIndex(int i)
    {
        if (!yearIndices.containsKey(Integer.valueOf(i)))
        {
            return null;
        } else
        {
            return Integer.valueOf(containerToListIndex(Integer.valueOf(((Integer)yearIndices.get(Integer.valueOf(i))).intValue())));
        }
    }

    public void highlightDate(int i, int j)
    {
        Integer integer1 = (Integer)yearIndices.get(Integer.valueOf(i));
        Integer integer = integer1;
        if (integer1 == null)
        {
            integer = Integer.valueOf(-1);
        }
        Integer integer2 = (Integer)monthIndices.get(Integer.valueOf(getUniqueMonthKey(i, j)));
        integer1 = integer2;
        if (integer2 == null)
        {
            integer1 = Integer.valueOf(-1);
        }
        highlightElement(integer.intValue(), integer1.intValue());
    }

    public void setData(List list)
    {
        this;
        JVM INSTR monitorenter ;
        TimelineMarkerContainer timelinemarkercontainer;
        timelinemarkercontainer = (TimelineMarkerContainer)activeContainer;
        containers.clear();
        containers.addAll(list);
        activeMarkers.clear();
        activeContainerIndex = -1;
        highlightedMarker = null;
        setupYearMonthIndices(list);
        if (timelinemarkercontainer == null) goto _L2; else goto _L1
_L1:
        expandYear(timelinemarkercontainer.getYear());
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        notifyDataSetChanged();
        if (true) goto _L4; else goto _L3
_L3:
        list;
        throw list;
    }

    public void setupYearMonthIndices(List list)
    {
        yearIndices.clear();
        monthIndices.clear();
        for (int i = 0; i < list.size(); i++)
        {
            TimelineMarkerContainer timelinemarkercontainer = (TimelineMarkerContainer)list.get(i);
            int k = timelinemarkercontainer.getYear();
            yearIndices.put(Integer.valueOf(k), Integer.valueOf(i));
            ArrayList arraylist = new ArrayList();
            arraylist.addAll(timelinemarkercontainer.getSubItems());
            for (int j = 0; j < arraylist.size(); j++)
            {
                int l = ((TimelineMarker)arraylist.get(j)).getMonth();
                monthIndices.put(Integer.valueOf(getUniqueMonthKey(k, l)), Integer.valueOf(j));
            }

        }

    }

}

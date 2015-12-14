// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.timeline.model;

import android.widget.BaseAdapter;
import com.amazon.gallery.foundation.utils.log.GLogger;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.amazon.gallery.framework.kindle.timeline.model:
//            ExpandableContainer, ExpandableListComponent, ContainerItem

public abstract class ExpandableListAdapter extends BaseAdapter
{

    private static final String TAG = com/amazon/gallery/framework/kindle/timeline/model/ExpandableListAdapter.getName();
    protected ExpandableContainer activeContainer;
    protected int activeContainerIndex;
    protected List activeMarkers;
    protected List containers;
    protected ExpandableContainer highlightedContainer;
    protected ContainerItem highlightedMarker;

    public ExpandableListAdapter()
    {
        containers = new ArrayList();
        activeMarkers = new ArrayList();
        activeContainer = null;
        activeContainerIndex = -1;
    }

    public void collapseAll()
    {
        this;
        JVM INSTR monitorenter ;
        activeContainer = null;
        activeContainerIndex = -1;
        activeMarkers.clear();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public int containerToListIndex(Integer integer)
    {
        if (activeContainerIndex < integer.intValue())
        {
            return integer.intValue() + activeMarkers.size();
        } else
        {
            return integer.intValue();
        }
    }

    public void expandContainer(int i)
    {
        this;
        JVM INSTR monitorenter ;
        ExpandableContainer expandablecontainer = (ExpandableContainer)containers.get(i);
        activeContainerIndex = i;
        activeContainer = expandablecontainer;
        activeMarkers.clear();
        activeMarkers.addAll(expandablecontainer.getSubItems());
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public int getActiveContainerIndex()
    {
        return activeContainerIndex;
    }

    public int getCount()
    {
        this;
        JVM INSTR monitorenter ;
        int i;
        int j;
        i = containers.size();
        j = activeMarkers.size();
        this;
        JVM INSTR monitorexit ;
        return i + j;
        Exception exception;
        exception;
        throw exception;
    }

    public ExpandableListComponent getItem(int i)
    {
        this;
        JVM INSTR monitorenter ;
        GLogger.d(TAG, "index: %d,  ActiveContainerIndex: %d,  containerSize: %d,  markerSize: %d", new Object[] {
            Integer.valueOf(i), Integer.valueOf(activeContainerIndex), Integer.valueOf(containers.size()), Integer.valueOf(activeMarkers.size())
        });
        if (activeContainerIndex != -1 && i > activeContainerIndex) goto _L2; else goto _L1
_L1:
        ExpandableListComponent expandablelistcomponent = (ExpandableListComponent)containers.get(i);
_L4:
        this;
        JVM INSTR monitorexit ;
        return expandablelistcomponent;
_L2:
        if (i > activeContainerIndex + activeMarkers.size())
        {
            expandablelistcomponent = (ExpandableListComponent)containers.get(i - activeMarkers.size());
            continue; /* Loop/switch isn't completed */
        }
        expandablelistcomponent = (ExpandableListComponent)activeMarkers.get(i - (activeContainerIndex + 1));
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public volatile Object getItem(int i)
    {
        return getItem(i);
    }

    public long getItemId(int i)
    {
        this;
        JVM INSTR monitorenter ;
        i = getItem(i).hashCode();
        long l = i;
        this;
        JVM INSTR monitorexit ;
        return l;
        Exception exception;
        exception;
        throw exception;
    }

    public void highlightActiveMarker(int i)
    {
        highlightMarker(activeMarkers, i);
    }

    public void highlightContainer(int i)
    {
        if (highlightedContainer != null)
        {
            highlightedContainer.setContainerHighlighted(false);
            highlightedContainer = null;
        }
        if (i != -1)
        {
            highlightedContainer = (ExpandableContainer)containers.get(i);
            highlightedContainer.setContainerHighlighted(true);
        }
        if (highlightedContainer != activeContainer && highlightedContainer != null)
        {
            highlightActiveMarker(-1);
        }
    }

    public void highlightElement(int i, int j)
    {
        if (i == -1)
        {
            highlightMarker(null, j);
        } else
        {
            highlightMarker(((ExpandableContainer)containers.get(i)).getSubItems(), j);
        }
        highlightContainer(i);
        notifyDataSetChanged();
    }

    public void highlightMarker(List list, int i)
    {
        if (highlightedMarker != null)
        {
            highlightedMarker.setLabelHighlighted(false);
        }
        if (list == null || i < 0 || i >= list.size())
        {
            highlightedMarker = null;
            return;
        } else
        {
            list = (ContainerItem)list.get(i);
            list.setLabelHighlighted(true);
            highlightedMarker = list;
            return;
        }
    }

    public void setData(List list)
    {
        containers.clear();
        containers.addAll(list);
        activeMarkers.clear();
        activeContainerIndex = -1;
        notifyDataSetChanged();
    }

}

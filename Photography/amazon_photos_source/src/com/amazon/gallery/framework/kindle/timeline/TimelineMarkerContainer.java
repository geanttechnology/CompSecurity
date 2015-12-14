// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.timeline;

import com.amazon.gallery.framework.kindle.timeline.model.ContainerItem;
import com.amazon.gallery.framework.kindle.timeline.model.ExpandableContainer;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.amazon.gallery.framework.kindle.timeline:
//            TimelineMarker

public class TimelineMarkerContainer extends TimelineMarker
    implements ExpandableContainer
{

    List markers;

    public TimelineMarkerContainer(String s, int i, int j)
    {
        super(s, i, j, 0, -1);
        markers = new ArrayList();
        noDate = true;
    }

    public TimelineMarkerContainer(String s, int i, int j, int k)
    {
        super(s, i, j, k, -1);
        markers = new ArrayList();
    }

    public void addMarker(ContainerItem containeritem)
    {
        this;
        JVM INSTR monitorenter ;
        markers.add(containeritem);
        this;
        JVM INSTR monitorexit ;
        return;
        containeritem;
        throw containeritem;
    }

    public List getSubItems()
    {
        this;
        JVM INSTR monitorenter ;
        List list = markers;
        this;
        JVM INSTR monitorexit ;
        return list;
        Exception exception;
        exception;
        throw exception;
    }
}

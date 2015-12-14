// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.timeline;

import com.amazon.gallery.framework.kindle.timeline.model.ContainerItem;

public class TimelineMarker
    implements ContainerItem
{

    private final int gridIndex;
    private final int index;
    private boolean isContainerHighlighted;
    private boolean isLabelHighlighted;
    private final String label;
    private final int month;
    protected boolean noDate;
    private final int year;

    public TimelineMarker(String s, int i, int j, int k, int l)
    {
        isContainerHighlighted = false;
        isLabelHighlighted = false;
        label = s;
        index = i;
        gridIndex = j;
        year = k;
        month = l;
        noDate = false;
    }

    public int getGridIndex()
    {
        return gridIndex;
    }

    public String getLabel()
    {
        return label;
    }

    public int getMonth()
    {
        return month;
    }

    public Integer getTag()
    {
        return Integer.valueOf(index);
    }

    public int getYear()
    {
        return year;
    }

    public boolean isContainerHighlighted()
    {
        return isContainerHighlighted;
    }

    public boolean isLabelHighlighted()
    {
        return isLabelHighlighted;
    }

    public boolean isNoDate()
    {
        return noDate;
    }

    public void setContainerHighlighted(boolean flag)
    {
        isContainerHighlighted = flag;
    }

    public void setLabelHighlighted(boolean flag)
    {
        isLabelHighlighted = flag;
    }
}

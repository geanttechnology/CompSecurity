// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.browseprograms;

import com.xfinity.playerlib.model.comparator.DibicProgramTitleComparator;
import java.util.Comparator;
import java.util.List;

// Referenced classes of package com.xfinity.playerlib.view.browseprograms:
//            SortPolicy

public class NullSortPolicy extends SortPolicy
{

    protected final DibicProgramTitleComparator titleComparator = new DibicProgramTitleComparator(true);

    public NullSortPolicy()
    {
    }

    public Comparator getComparator(SortPolicy.SortType sorttype)
    {
        return titleComparator;
    }

    public SortPolicy.SortType getCurrentSortType()
    {
        return SortPolicy.SortType.NONE;
    }

    public List getSortTypes()
    {
        return null;
    }

    public void setCurrentSortType(SortPolicy.SortType sorttype)
    {
        if (sorttype != SortPolicy.SortType.NONE)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Unexpected sort type: ").append(sorttype).toString());
        } else
        {
            return;
        }
    }
}

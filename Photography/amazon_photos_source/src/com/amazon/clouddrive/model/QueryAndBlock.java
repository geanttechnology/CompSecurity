// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.model;

import java.util.List;

// Referenced classes of package com.amazon.clouddrive.model:
//            ObjectComparator

public class QueryAndBlock
    implements Comparable
{

    private List filters;

    public QueryAndBlock()
    {
    }

    public int compareTo(QueryAndBlock queryandblock)
    {
        int i;
        if (queryandblock == null)
        {
            i = -1;
        } else
        {
            if (queryandblock == this)
            {
                return 0;
            }
            int j = ObjectComparator.compare(getFilters(), queryandblock.getFilters());
            i = j;
            if (j == 0)
            {
                return 0;
            }
        }
        return i;
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((QueryAndBlock)obj);
    }

    public boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (obj instanceof QueryAndBlock)
            {
                if (compareTo((QueryAndBlock)obj) != 0)
                {
                    return false;
                }
            } else
            {
                return false;
            }
        }
        return true;
    }

    public List getFilters()
    {
        return filters;
    }

    public int hashCode()
    {
        int i;
        if (getFilters() == null)
        {
            i = 0;
        } else
        {
            i = getFilters().hashCode();
        }
        return 1 + i;
    }

    public void setFilters(List list)
    {
        filters = list;
    }
}

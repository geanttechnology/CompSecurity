// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.model;

import java.util.List;

// Referenced classes of package com.amazon.clouddrive.model:
//            ObjectComparator

public class QueryFilter
    implements Comparable
{

    private final String filterType;
    private List values;

    public QueryFilter(String s)
    {
        filterType = s;
    }

    public int compareTo(QueryFilter queryfilter)
    {
        int i;
        if (queryfilter == null)
        {
            i = -1;
        } else
        {
            if (queryfilter == this)
            {
                return 0;
            }
            int j = ObjectComparator.compare(getFilterType(), queryfilter.getFilterType());
            i = j;
            if (j == 0)
            {
                int k = ObjectComparator.compare(getValues(), queryfilter.getValues());
                i = k;
                if (k == 0)
                {
                    return 0;
                }
            }
        }
        return i;
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((QueryFilter)obj);
    }

    public boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (obj instanceof QueryFilter)
            {
                if (compareTo((QueryFilter)obj) != 0)
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

    public String getFilterType()
    {
        return filterType;
    }

    public List getValues()
    {
        return values;
    }

    public int hashCode()
    {
        int j = filterType.hashCode();
        int i;
        if (getValues() == null)
        {
            i = 0;
        } else
        {
            i = getValues().hashCode();
        }
        return j + i;
    }

    public void setValues(List list)
    {
        values = list;
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.model;

import java.util.List;

// Referenced classes of package com.amazon.clouddrive.model:
//            ObjectComparator

public class QueryObject
    implements Comparable
{

    private List excludedIds;
    private List include;

    public QueryObject()
    {
    }

    public int compareTo(QueryObject queryobject)
    {
        int i;
        if (queryobject == null)
        {
            i = -1;
        } else
        {
            if (queryobject == this)
            {
                return 0;
            }
            int j = ObjectComparator.compare(getExcludedIds(), queryobject.getExcludedIds());
            i = j;
            if (j == 0)
            {
                int k = ObjectComparator.compare(getInclude(), queryobject.getInclude());
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
        return compareTo((QueryObject)obj);
    }

    public boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (obj instanceof QueryObject)
            {
                if (compareTo((QueryObject)obj) != 0)
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

    public List getExcludedIds()
    {
        return excludedIds;
    }

    public List getInclude()
    {
        return include;
    }

    public int hashCode()
    {
        int j = 0;
        int i;
        if (getExcludedIds() == null)
        {
            i = 0;
        } else
        {
            i = getExcludedIds().hashCode();
        }
        if (getInclude() != null)
        {
            j = getInclude().hashCode();
        }
        return 1 + i + j;
    }

    public void setExcludedIds(List list)
    {
        excludedIds = list;
    }

    public void setInclude(List list)
    {
        include = list;
    }
}

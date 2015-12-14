// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.model;

import java.util.List;

// Referenced classes of package com.amazon.clouddrive.model:
//            ObjectComparator, QueryObject

public class CollectionProperties
    implements Comparable
{

    private Boolean areCoversDesired;
    private List covers;
    private QueryObject query;

    public CollectionProperties()
    {
    }

    public Boolean areCoversDesired()
    {
        return areCoversDesired;
    }

    public int compareTo(CollectionProperties collectionproperties)
    {
        int i;
        if (collectionproperties == null)
        {
            i = -1;
        } else
        {
            if (collectionproperties == this)
            {
                return 0;
            }
            int j = ObjectComparator.compare(getQuery(), collectionproperties.getQuery());
            i = j;
            if (j == 0)
            {
                int k = ObjectComparator.compare(areCoversDesired(), collectionproperties.areCoversDesired());
                i = k;
                if (k == 0)
                {
                    int l = ObjectComparator.compare(getCovers(), collectionproperties.getCovers());
                    i = l;
                    if (l == 0)
                    {
                        return 0;
                    }
                }
            }
        }
        return i;
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((CollectionProperties)obj);
    }

    public boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (obj instanceof CollectionProperties)
            {
                if (compareTo((CollectionProperties)obj) != 0)
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

    public List getCovers()
    {
        return covers;
    }

    public QueryObject getQuery()
    {
        return query;
    }

    public int hashCode()
    {
        int k = 0;
        int i;
        int j;
        if (getQuery() == null)
        {
            i = 0;
        } else
        {
            i = getQuery().hashCode();
        }
        if (areCoversDesired() == null)
        {
            j = 0;
        } else
        {
            j = areCoversDesired().hashCode();
        }
        if (getCovers() != null)
        {
            k = getCovers().hashCode();
        }
        return 1 + i + j + k;
    }

    public void setCovers(List list)
    {
        covers = list;
    }

    public void setCoversDesired(Boolean boolean1)
    {
        areCoversDesired = boolean1;
    }

    public void setQuery(QueryObject queryobject)
    {
        query = queryobject;
    }
}

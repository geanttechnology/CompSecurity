// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model;

import java.util.ArrayList;
import java.util.Iterator;

public class EbaySuggestedCategory
    implements Comparable
{

    public long id;
    public String name;
    public ArrayList parentIds;
    public ArrayList parentNames;
    public long percentItemFound;

    public EbaySuggestedCategory()
    {
        parentIds = new ArrayList();
        parentNames = new ArrayList();
    }

    public int compareTo(EbaySuggestedCategory ebaysuggestedcategory)
    {
        return getCategoryNamePath().compareTo(ebaysuggestedcategory.getCategoryNamePath());
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((EbaySuggestedCategory)obj);
    }

    public String getCategoryIdPath()
    {
        StringBuilder stringbuilder = new StringBuilder();
        for (Iterator iterator = parentIds.iterator(); iterator.hasNext(); stringbuilder.append((String)iterator.next()).append(":")) { }
        stringbuilder.append(id);
        return stringbuilder.toString();
    }

    public String getCategoryNamePath()
    {
        StringBuilder stringbuilder = new StringBuilder();
        for (Iterator iterator = parentNames.iterator(); iterator.hasNext(); stringbuilder.append((String)iterator.next()).append(":")) { }
        stringbuilder.append(name);
        return stringbuilder.toString();
    }

    public String getDisplayName()
    {
        if (name == null)
        {
            return "";
        } else
        {
            return name;
        }
    }

    public String getPathDisplayFromL2()
    {
        return getPathDisplayFromLevel(1);
    }

    public String getPathDisplayFromLevel(int i)
    {
        StringBuilder stringbuilder = new StringBuilder();
        for (; i < parentNames.size(); i++)
        {
            stringbuilder.append((String)parentNames.get(i));
            stringbuilder.append(" > ");
        }

        stringbuilder.append(getDisplayName());
        return stringbuilder.toString();
    }

    public String toString()
    {
        return name;
    }
}

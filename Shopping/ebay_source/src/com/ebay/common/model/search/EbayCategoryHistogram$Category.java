// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model.search;


// Referenced classes of package com.ebay.common.model.search:
//            EbayCategoryHistogram

public static class isLeaf
{

    public static int UNINITIALIZED_LEVEL = 0x80000000;
    public int count;
    public long id;
    public boolean isLeaf;
    public int level;
    public String name;
    public long parentId;

    public String toString()
    {
        if (count != 0)
        {
            return (new StringBuilder()).append(name).append(" (").append(count).append(')').toString();
        } else
        {
            return name;
        }
    }


    public A()
    {
        id = 0L;
        name = null;
        parentId = 0L;
        count = 0;
        level = UNINITIALIZED_LEVEL;
        isLeaf = false;
    }

    public isLeaf(isLeaf isleaf)
    {
        id = 0L;
        name = null;
        parentId = 0L;
        count = 0;
        level = UNINITIALIZED_LEVEL;
        isLeaf = false;
        id = isleaf.id;
        name = isleaf.name;
        parentId = isleaf.parentId;
        count = isleaf.count;
        level = isleaf.level;
        isLeaf = isleaf.isLeaf;
    }
}

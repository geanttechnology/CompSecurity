// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fanhattan.services.contextualmenu.api;

import java.util.Comparator;

// Referenced classes of package com.fanhattan.services.contextualmenu.api:
//            IContextualMenuElement

public static class <init>
    implements Comparator
{

    private static int compareInteger(int i, int j)
    {
        if (i < j)
        {
            return -1;
        }
        return i <= j ? 0 : 1;
    }

    public int compare(IContextualMenuElement icontextualmenuelement, IContextualMenuElement icontextualmenuelement1)
    {
        int j = compareInteger(icontextualmenuelement.getOrder(), icontextualmenuelement1.getOrder());
        int i = j;
        if (j == 0)
        {
            i = 1;
        }
        return i;
    }

    public volatile int compare(Object obj, Object obj1)
    {
        return compare((IContextualMenuElement)obj, (IContextualMenuElement)obj1);
    }

    private ()
    {
    }

    ( )
    {
        this();
    }
}

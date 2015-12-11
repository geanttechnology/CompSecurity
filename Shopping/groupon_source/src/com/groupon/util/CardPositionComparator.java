// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import java.util.Comparator;

// Referenced classes of package com.groupon.util:
//            SortableCard

public class CardPositionComparator
    implements Comparator
{

    public static final Comparator INSTANCE = new CardPositionComparator();

    public CardPositionComparator()
    {
    }

    public int compare(SortableCard sortablecard, SortableCard sortablecard1)
    {
        if (sortablecard.cardPosition() < sortablecard1.cardPosition())
        {
            return -1;
        }
        return sortablecard.cardPosition() != sortablecard1.cardPosition() ? 1 : 0;
    }

    public volatile int compare(Object obj, Object obj1)
    {
        return compare((SortableCard)obj, (SortableCard)obj1);
    }

}

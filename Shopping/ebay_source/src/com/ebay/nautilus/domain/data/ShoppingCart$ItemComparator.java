// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;

import android.text.TextUtils;
import java.util.Comparator;
import java.util.Date;

// Referenced classes of package com.ebay.nautilus.domain.data:
//            ShoppingCart

public static class SortPriority
    implements Comparator
{
    private static final class SortPriority extends Enum
    {

        private static final SortPriority $VALUES[];
        public static final SortPriority BUYER_CREATED;
        public static final SortPriority LOWEST;
        public static final SortPriority SELLER_CREATED;
        public static final SortPriority UN_BUYABLE;

        public static SortPriority valueOf(String s)
        {
            return (SortPriority)Enum.valueOf(com/ebay/nautilus/domain/data/ShoppingCart$ItemComparator$SortPriority, s);
        }

        public static SortPriority[] values()
        {
            return (SortPriority[])$VALUES.clone();
        }

        static 
        {
            LOWEST = new SortPriority("LOWEST", 0);
            UN_BUYABLE = new SortPriority("UN_BUYABLE", 1);
            SELLER_CREATED = new SortPriority("SELLER_CREATED", 2);
            BUYER_CREATED = new SortPriority("BUYER_CREATED", 3);
            $VALUES = (new SortPriority[] {
                LOWEST, UN_BUYABLE, SELLER_CREATED, BUYER_CREATED
            });
        }

        private SortPriority(String s, int i)
        {
            super(s, i);
        }
    }


    private SortPriority priorityOf(SortPriority sortpriority)
    {
        if (sortpriority.e)
        {
            return SortPriority.UN_BUYABLE;
        }
        if (sortpriority. == null && !TextUtils.isEmpty(sortpriority.))
        {
            return SortPriority.SELLER_CREATED;
        }
        if (sortpriority. != null)
        {
            return SortPriority.BUYER_CREATED;
        } else
        {
            return SortPriority.LOWEST;
        }
    }

    public int compare(SortPriority.LOWEST lowest, SortPriority.LOWEST lowest1)
    {
        SortPriority sortpriority;
        SortPriority sortpriority1;
        int i;
        i = -1;
        if (!TextUtils.equals(lowest.Id, lowest.Id))
        {
            break MISSING_BLOCK_LABEL_108;
        }
        sortpriority = priorityOf(lowest);
        sortpriority1 = priorityOf(lowest1);
        if (sortpriority.ordinal() != sortpriority1.ordinal()) goto _L2; else goto _L1
_L1:
        boolean flag = lowest.ordinal;
        if (flag != lowest1.ordinal) goto _L4; else goto _L3
_L3:
        lowest = lowest.tAt;
        lowest1 = lowest1.tAt;
        if (lowest == null || lowest1 == null) goto _L6; else goto _L5
_L5:
        i = lowest.compareTo(lowest1);
_L8:
        return i;
_L6:
        return 0;
_L4:
        if (flag) goto _L8; else goto _L7
_L7:
        return 1;
_L2:
        if (sortpriority.ordinal() < sortpriority1.ordinal()) goto _L8; else goto _L9
_L9:
        return 1;
        return lowest.Id.compareTo(lowest1.Id);
    }

    public volatile int compare(Object obj, Object obj1)
    {
        return compare((compare)obj, (compare)obj1);
    }

    public SortPriority()
    {
    }
}

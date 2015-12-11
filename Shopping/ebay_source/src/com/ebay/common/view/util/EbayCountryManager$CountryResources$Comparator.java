// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.view.util;

import java.text.Collator;
import java.util.Comparator;

// Referenced classes of package com.ebay.common.view.util:
//            EbayCountryManager

public static class collator
    implements Comparator
{

    private final Collator collator;

    public int compare(collator collator1, collator collator2)
    {
        return collator.compare(collator1.ame(), collator2.ame());
    }

    public volatile int compare(Object obj, Object obj1)
    {
        return compare((compare)obj, (compare)obj1);
    }

    public (Collator collator1)
    {
        collator = collator1;
    }
}

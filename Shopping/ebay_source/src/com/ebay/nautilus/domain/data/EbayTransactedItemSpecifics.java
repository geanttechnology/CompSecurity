// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;

import java.util.List;

// Referenced classes of package com.ebay.nautilus.domain.data:
//            EbayItemIdAndVariationSpecifics

public class EbayTransactedItemSpecifics extends EbayItemIdAndVariationSpecifics
{

    public Long transactionId;

    public EbayTransactedItemSpecifics(long l, Long long1, List list)
    {
        super(l, list);
        transactionId = long1;
        if (long1 != null)
        {
            hash = (new StringBuilder()).append(hash).append(String.valueOf(long1.longValue())).toString();
        }
    }
}

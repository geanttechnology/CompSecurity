// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;

import java.util.Comparator;

// Referenced classes of package com.ebay.nautilus.domain.data:
//            MyEbayListItem

static final class 
    implements Comparator
{

    public int compare(MyEbayListItem myebaylistitem, MyEbayListItem myebaylistitem1)
    {
        if (myebaylistitem.endTimestamp < myebaylistitem1.endTimestamp)
        {
            return 1;
        }
        return myebaylistitem.endTimestamp <= myebaylistitem1.endTimestamp ? 0 : -1;
    }

    public volatile int compare(Object obj, Object obj1)
    {
        return compare((MyEbayListItem)obj, (MyEbayListItem)obj1);
    }

    ()
    {
    }
}

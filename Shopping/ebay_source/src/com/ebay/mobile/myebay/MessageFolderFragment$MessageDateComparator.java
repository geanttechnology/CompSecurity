// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.myebay;

import com.ebay.nautilus.domain.data.EbayMessage;
import java.util.Comparator;
import java.util.Date;

// Referenced classes of package com.ebay.mobile.myebay:
//            MessageFolderFragment

private static class <init>
    implements Comparator
{

    public int compare(EbayMessage ebaymessage, EbayMessage ebaymessage1)
    {
        return ebaymessage.receiveDate.compareTo(ebaymessage1.receiveDate) * -1;
    }

    public volatile int compare(Object obj, Object obj1)
    {
        return compare((EbayMessage)obj, (EbayMessage)obj1);
    }

    private ()
    {
    }

    ( )
    {
        this();
    }
}

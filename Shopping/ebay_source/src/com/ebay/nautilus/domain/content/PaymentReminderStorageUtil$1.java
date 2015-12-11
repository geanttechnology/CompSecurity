// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content;

import java.util.ArrayList;

// Referenced classes of package com.ebay.nautilus.domain.content:
//            PaymentReminderStorageUtil

static final class val.soldIds
    implements Runnable
{

    final ArrayList val$soldIds;

    public void run()
    {
        PaymentReminderStorageUtil.access$000(val$soldIds);
    }

    (ArrayList arraylist)
    {
        val$soldIds = arraylist;
        super();
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common;

import com.ebay.common.net.api.aps.UserActivitySummary;
import java.util.List;

// Referenced classes of package com.ebay.common:
//            UserCache

public static interface _cls9
{

    public abstract void onEbayError(List list);

    public abstract void onRemindersError();

    public abstract void updateMsgRemindersCounts(UserActivitySummary useractivitysummary);
}

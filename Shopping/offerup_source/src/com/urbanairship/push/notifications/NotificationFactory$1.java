// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.push.notifications;

import android.support.v4.app.bh;
import android.support.v4.app.bl;
import android.support.v4.app.bn;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.urbanairship.push.notifications:
//            NotificationFactory

class val.androidActions
    implements bn
{

    final NotificationFactory this$0;
    final List val$androidActions;

    public bl extend(bl bl1)
    {
        for (Iterator iterator = val$androidActions.iterator(); iterator.hasNext(); bl1.a((bh)iterator.next())) { }
        return bl1;
    }

    ()
    {
        this$0 = final_notificationfactory;
        val$androidActions = List.this;
        super();
    }
}

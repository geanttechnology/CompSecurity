// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service;

import com.groupon.db.dao.DaoInAppMessage;
import com.groupon.db.models.InAppMessage;

// Referenced classes of package com.groupon.service:
//            InAppMessageService

class val.inAppMessage
    implements Runnable
{

    final InAppMessageService this$0;
    final InAppMessage val$inAppMessage;

    public void run()
    {
        InAppMessageService.access$700(InAppMessageService.this).replace(val$inAppMessage);
    }

    ()
    {
        this$0 = final_inappmessageservice;
        val$inAppMessage = InAppMessage.this;
        super();
    }
}

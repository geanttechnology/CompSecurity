// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service;

import android.content.Context;
import com.groupon.db.models.InAppMessage;
import com.groupon.http.Http;
import com.groupon.http.synchronous.SyncHttp;

// Referenced classes of package com.groupon.service:
//            InAppMessageService

class val.inAppMessage extends Http
{

    final InAppMessageService this$0;
    final entName val$eventType;
    final InAppMessage val$inAppMessage;

    protected void onException(Exception exception)
    {
    }

    protected volatile void onSuccess(Object obj)
        throws Exception
    {
        onSuccess((Void)obj);
    }

    protected void onSuccess(Void void1)
    {
        if (val$eventType == entName.VIEWED)
        {
            val$inAppMessage.read = true;
            updateInAppMessage(val$inAppMessage);
        }
    }

    entName(entName entname, InAppMessage inappmessage)
    {
        this$0 = final_inappmessageservice;
        val$eventType = entname;
        val$inAppMessage = inappmessage;
        super(final_context, SyncHttp.this);
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service;

import android.content.Context;
import com.groupon.http.Http;
import com.groupon.http.synchronous.SyncHttp;
import com.groupon.models.inappmessage.InAppMessage;

// Referenced classes of package com.groupon.service:
//            InAppMessageService

class val.eventType extends Http
{

    final InAppMessageService this$0;
    final entName val$eventType;
    final InAppMessage val$inAppMessage;

    protected void onException(Exception exception)
    {
        val$inAppMessage.onUpdateFailed(val$eventType);
        updateHistory(val$inAppMessage);
    }

    protected volatile void onSuccess(Object obj)
        throws Exception
    {
        onSuccess((Void)obj);
    }

    protected void onSuccess(Void void1)
    {
        val$inAppMessage.onUpdateSuccess(val$eventType);
        updateHistory(val$inAppMessage);
    }

    entName(InAppMessage inappmessage, entName entname)
    {
        this$0 = final_inappmessageservice;
        val$inAppMessage = inappmessage;
        val$eventType = entname;
        super(final_context, SyncHttp.this);
    }
}

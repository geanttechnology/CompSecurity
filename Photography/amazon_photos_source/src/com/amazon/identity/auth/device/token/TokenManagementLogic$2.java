// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.token;

import android.os.Bundle;
import com.amazon.identity.auth.device.callback.CallbackFuture;
import com.amazon.identity.auth.device.framework.Tracer;

// Referenced classes of package com.amazon.identity.auth.device.token:
//            TokenManagementLogic

class val.tracer
    implements Runnable
{

    final TokenManagementLogic this$0;
    final CallbackFuture val$callbackFuture;
    final String val$directedId;
    final String val$domain;
    final Bundle val$options;
    final Tracer val$tracer;

    public void run()
    {
        if (val$options == null)
        {
            TokenManagementLogic.access$900(TokenManagementLogic.this, val$directedId, val$domain, new Bundle(), val$callbackFuture, val$tracer);
            return;
        } else
        {
            TokenManagementLogic.access$900(TokenManagementLogic.this, val$directedId, val$domain, val$options, val$callbackFuture, val$tracer);
            return;
        }
    }

    ()
    {
        this$0 = final_tokenmanagementlogic;
        val$options = bundle;
        val$directedId = s;
        val$domain = s1;
        val$callbackFuture = callbackfuture;
        val$tracer = Tracer.this;
        super();
    }
}

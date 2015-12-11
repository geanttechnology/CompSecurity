// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.arellomobile.android.push;

import android.content.Context;
import com.arellomobile.android.push.utils.WorkerTask;

// Referenced classes of package com.arellomobile.android.push:
//            PushManager, DeviceRegistrar

class k extends WorkerTask
{

    final PushManager this$0;
    final String val$regId;

    protected void doWork(Context context)
    {
        DeviceRegistrar.registerWithServer(PushManager.access$200(PushManager.this), val$regId);
    }

    (String s)
    {
        this$0 = final_pushmanager;
        val$regId = s;
        super(Context.this);
    }
}

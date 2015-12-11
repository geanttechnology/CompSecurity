// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.service;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

// Referenced classes of package co.vine.android.service:
//            VineServiceConnection

class this._cls0 extends Handler
{

    final VineServiceConnection this$0;

    public void handleMessage(Message message)
    {
        Bundle bundle = message.getData();
        bundle.setClassLoader(VineServiceConnection.access$000(VineServiceConnection.this).getClassLoader());
        VineServiceConnection.access$100(VineServiceConnection.this).handleServiceResponse(message.what, message.arg1, bundle.getString("reason_phrase"), bundle);
    }

    rviceResponseHandler()
    {
        this$0 = VineServiceConnection.this;
        super();
    }
}

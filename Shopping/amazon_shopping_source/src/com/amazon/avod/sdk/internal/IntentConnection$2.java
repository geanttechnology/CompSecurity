// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.avod.sdk.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.amazon.avod.sdk.CallResponse;
import com.amazon.avod.sdk.ResponseHandler;

// Referenced classes of package com.amazon.avod.sdk.internal:
//            IntentConnection

class val.responseHandler extends BroadcastReceiver
{

    final IntentConnection this$0;
    final ResponseHandler val$responseHandler;

    public void onReceive(Context context, Intent intent)
    {
        context = getResultExtras(true);
        if (val$responseHandler != null)
        {
            val$responseHandler.handleResponse(CallResponse.fromBundle(context));
        }
    }

    ()
    {
        this$0 = final_intentconnection;
        val$responseHandler = ResponseHandler.this;
        super();
    }
}

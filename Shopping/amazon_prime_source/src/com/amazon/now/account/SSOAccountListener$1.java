// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.account;

import android.content.Context;
import android.webkit.ValueCallback;
import com.amazon.now.ActivityTerminationReceiver;

// Referenced classes of package com.amazon.now.account:
//            SSOAccountListener

class val.context
    implements ValueCallback
{

    final SSOAccountListener this$0;
    final Context val$context;

    public void onReceiveValue(Boolean boolean1)
    {
        if (boolean1.booleanValue())
        {
            ActivityTerminationReceiver.sendTerminationBroadcast(val$context);
        }
    }

    public volatile void onReceiveValue(Object obj)
    {
        onReceiveValue((Boolean)obj);
    }

    ()
    {
        this$0 = final_ssoaccountlistener;
        val$context = Context.this;
        super();
    }
}

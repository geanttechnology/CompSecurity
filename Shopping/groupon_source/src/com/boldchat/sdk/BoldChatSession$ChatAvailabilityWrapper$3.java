// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.boldchat.sdk;

import com.boldchat.visitor.api.ChatAvailabilityListener;

// Referenced classes of package com.boldchat.sdk:
//            BoldChatSession

class val.message
    implements Runnable
{

    final val.message this$1;
    final int val$failType;
    final String val$message;

    public void run()
    {
        vailabilityListener.onChatAvailabilityFailed(val$failType, val$message);
    }

    ()
    {
        this$1 = final_;
        val$failType = i;
        val$message = String.this;
        super();
    }
}

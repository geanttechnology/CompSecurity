// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.boldchat.sdk;

import com.boldchat.visitor.api.ChatAvailabilityListener;
import com.boldchat.visitor.api.UnavailableReason;

// Referenced classes of package com.boldchat.sdk:
//            BoldChatSession

class val.unavailableReason
    implements Runnable
{

    final val.unavailableReason this$1;
    final UnavailableReason val$unavailableReason;

    public void run()
    {
        vailabilityListener.onChatUnavailable(val$unavailableReason);
    }

    ()
    {
        this$1 = final_;
        val$unavailableReason = UnavailableReason.this;
        super();
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.boldchat.sdk;

import com.boldchat.visitor.api.Message;

// Referenced classes of package com.boldchat.sdk:
//            BoldChatSession

class val.message
    implements Runnable
{

    final val.message this$1;
    final Message val$message;

    public void run()
    {
        BoldChatSession.access$100(_fld0).messageArrived(val$message.getText(), val$message.getName(), val$message.getCreated());
    }

    ner()
    {
        this$1 = final_ner;
        val$message = Message.this;
        super();
    }
}

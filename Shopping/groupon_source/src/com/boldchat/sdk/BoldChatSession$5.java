// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.boldchat.sdk;


// Referenced classes of package com.boldchat.sdk:
//            BoldChatSession

class this._cls0
    implements Runnable
{

    final BoldChatSession this$0;

    public void run()
    {
        BoldChatSession.access$100(BoldChatSession.this).operatorTyping();
    }

    ldChatSessionListener()
    {
        this$0 = BoldChatSession.this;
        super();
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.boldchat.visitor.api;


// Referenced classes of package com.boldchat.visitor.api:
//            Chat

class this._cls0
    implements Runnable
{

    final Chat this$0;

    public void run()
    {
        try
        {
            Thread.sleep(5000L);
        }
        catch (InterruptedException interruptedexception)
        {
            interruptedexception.printStackTrace();
        }
        if (Chat.access$700(Chat.this) == null)
        {
            Chat.access$800(Chat.this);
            Chat.access$702(Chat.this, Chat.access$900(Chat.this));
        }
    }

    ()
    {
        this$0 = Chat.this;
        super();
    }
}

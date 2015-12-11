// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.boldchat.visitor.api.internal;


// Referenced classes of package com.boldchat.visitor.api.internal:
//            VisitorWebSocket

class val.sleep
    implements Runnable
{

    final VisitorWebSocket this$0;
    final long val$sleep;

    public void run()
    {
        try
        {
            Thread.sleep(val$sleep);
        }
        catch (InterruptedException interruptedexception)
        {
            interruptedexception.printStackTrace();
        }
        VisitorWebSocket.access$100(VisitorWebSocket.this);
    }

    ()
    {
        this$0 = final_visitorwebsocket;
        val$sleep = J.this;
        super();
    }
}

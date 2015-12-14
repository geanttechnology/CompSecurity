// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.chat;


// Referenced classes of package com.cyberlink.you.chat:
//            n

class a extends Thread
{

    final n a;

    public void run()
    {
        try
        {
            sleep(10000L);
        }
        catch (InterruptedException interruptedexception)
        {
            interruptedexception.printStackTrace();
        }
        a.a(org.jivesoftware.smack.packet.nce.Type.a);
    }

    on(n n1)
    {
        a = n1;
        super();
    }
}

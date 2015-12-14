// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.chat;


// Referenced classes of package com.cyberlink.you.chat:
//            UnreadCountManager

class g
    implements Runnable
{

    final UnreadCountManager a;
    private UnreadCountManager.OnUnreadCountListner.Type b;

    public g(UnreadCountManager unreadcountmanager, UnreadCountManager.OnUnreadCountListner.Type type)
    {
        a = unreadcountmanager;
        super();
        b = UnreadCountManager.OnUnreadCountListner.Type.c;
        b = type;
    }

    public void run()
    {
        a.a(b);
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.friends;

import java.util.concurrent.ThreadFactory;

// Referenced classes of package com.cyberlink.you.friends:
//            l

class a
    implements ThreadFactory
{

    final l a;

    public Thread newThread(Runnable runnable)
    {
        return new Thread(runnable, (new StringBuilder()).append("FriendsClient (").append(l.a(a)).append(")").toString());
    }

    tory(l l1)
    {
        a = l1;
        super();
    }
}

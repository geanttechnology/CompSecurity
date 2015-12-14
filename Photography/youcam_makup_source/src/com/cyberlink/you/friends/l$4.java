// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.friends;


// Referenced classes of package com.cyberlink.you.friends:
//            l

final class b extends Thread
{

    final String a;
    final String b;

    public void run()
    {
        Thread.currentThread().setName("loadCommandUrlFromServer");
        l.d(a, b);
    }

    (String s, String s1)
    {
        a = s;
        b = s1;
        super();
    }
}

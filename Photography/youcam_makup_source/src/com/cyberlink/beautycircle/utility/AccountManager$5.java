// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.utility;


// Referenced classes of package com.cyberlink.beautycircle.utility:
//            AccountManager, b

final class a
    implements Runnable
{

    final String a;

    public void run()
    {
        if (AccountManager.o().c != null)
        {
            AccountManager.o().c.a(a);
            AccountManager.o().c = null;
        }
    }

    _cls9(String s)
    {
        a = s;
        super();
    }
}

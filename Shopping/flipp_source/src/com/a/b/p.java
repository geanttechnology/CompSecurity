// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.b;

import android.os.Message;

// Referenced classes of package com.a.b:
//            o

final class p
    implements Runnable
{

    final Message a;
    final o b;

    p(o o, Message message)
    {
        b = o;
        a = message;
        super();
    }

    public final void run()
    {
        throw new AssertionError((new StringBuilder("Unknown handler message received: ")).append(a.what).toString());
    }
}

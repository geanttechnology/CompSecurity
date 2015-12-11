// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.g.c;

import android.os.Message;

// Referenced classes of package com.g.c:
//            ab

final class t
    implements Runnable
{

    final Message a;
    final age b;

    public final void run()
    {
        throw new AssertionError((new StringBuilder("Unhandled stats message.")).append(a.what).toString());
    }

    age(age age, Message message)
    {
        b = age;
        a = message;
        super();
    }
}

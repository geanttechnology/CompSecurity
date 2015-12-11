// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.g.c;

import android.os.Message;

// Referenced classes of package com.g.c:
//            i

final class ct
    implements Runnable
{

    final Message a;
    final sage b;

    public final void run()
    {
        throw new AssertionError((new StringBuilder("Unknown handler message received: ")).append(a.what).toString());
    }

    sage(sage sage, Message message)
    {
        b = sage;
        a = message;
        super();
    }
}

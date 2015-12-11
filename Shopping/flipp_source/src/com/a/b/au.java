// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.b;

import android.os.Message;

// Referenced classes of package com.a.b:
//            at

final class au
    implements Runnable
{

    final Message a;
    final at b;

    au(at at, Message message)
    {
        b = at;
        a = message;
        super();
    }

    public final void run()
    {
        throw new AssertionError((new StringBuilder("Unhandled stats message.")).append(a.what).toString());
    }
}

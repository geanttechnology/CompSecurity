// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appnexus.opensdk;

import com.appnexus.opensdk.b.b;

// Referenced classes of package com.appnexus.opensdk:
//            e

private final class <init>
    implements Runnable
{

    final e a;

    public final void run()
    {
        b.a(b.b, b.a(.handler_message_pass));
        a.a.sendEmptyMessage(0);
    }

    private (e e1)
    {
        a = e1;
        super();
    }

    a(e e1, byte byte0)
    {
        this(e1);
    }
}

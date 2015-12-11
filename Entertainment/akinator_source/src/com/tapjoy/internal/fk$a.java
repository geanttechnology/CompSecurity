// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;


// Referenced classes of package com.tapjoy.internal:
//            fk

final class a
    implements Runnable
{

    final Thread a;
    final fk b;

    public final void run()
    {
        fk.f();
        (new StringBuilder("sending interrupt to TID: ")).append(a.getId());
        a.interrupt();
    }

    (fk fk1, Thread thread)
    {
        b = fk1;
        super();
        a = thread;
    }
}

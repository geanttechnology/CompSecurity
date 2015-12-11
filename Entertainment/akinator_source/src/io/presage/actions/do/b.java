// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.actions.do;

import java.util.TimerTask;

// Referenced classes of package io.presage.actions.do:
//            a

final class b extends TimerTask
{

    final a a;

    b(a a1)
    {
        a = a1;
        super();
    }

    public final void run()
    {
        io.presage.actions.do.a.a(a);
        a.run();
    }
}

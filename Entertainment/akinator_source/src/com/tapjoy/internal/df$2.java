// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import java.util.concurrent.Executor;

// Referenced classes of package com.tapjoy.internal:
//            df

final class a
    implements Executor
{

    final df a;

    public final void execute(Runnable runnable)
    {
        (new Thread(runnable, a.h())).start();
    }

    utor(df df1)
    {
        a = df1;
        super();
    }
}

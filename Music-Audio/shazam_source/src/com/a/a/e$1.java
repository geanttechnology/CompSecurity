// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a;

import android.os.Handler;
import java.util.concurrent.Executor;

// Referenced classes of package com.a.a:
//            e

final class ject
    implements Executor
{

    final Handler a;
    final e b;

    public final void execute(Runnable runnable)
    {
        a.post(runnable);
    }

    andler(e e1, Handler handler)
    {
        b = e1;
        a = handler;
        super();
    }
}

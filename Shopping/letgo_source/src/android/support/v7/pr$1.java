// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.os.Handler;
import java.util.concurrent.Executor;

// Referenced classes of package android.support.v7:
//            pr

class a
    implements Executor
{

    final Handler a;
    final pr b;

    public void execute(Runnable runnable)
    {
        a.post(runnable);
    }

    cutor(pr pr1, Handler handler)
    {
        b = pr1;
        a = handler;
        super();
    }
}

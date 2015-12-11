// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.io.File;
import java.util.concurrent.Executor;

// Referenced classes of package android.support.v7:
//            aim, ail, aio, aht

class a
    implements Runnable
{

    final aio a;
    final aim b;

    public void run()
    {
        File file = b.a.o.a(a.a());
        boolean flag;
        if (file != null && file.exists())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        aim.a(b);
        if (flag)
        {
            aim.b(b).execute(a);
            return;
        } else
        {
            aim.c(b).execute(a);
            return;
        }
    }

    utor(aim aim1, aio aio1)
    {
        b = aim1;
        a = aio1;
        super();
    }
}

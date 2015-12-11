// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.b;

import android.os.Handler;
import android.os.Process;
import java.lang.ref.ReferenceQueue;

// Referenced classes of package com.a.b:
//            b, ah

final class ag extends Thread
{

    private final ReferenceQueue a;
    private final Handler b;

    ag(ReferenceQueue referencequeue, Handler handler)
    {
        a = referencequeue;
        b = handler;
        setDaemon(true);
        setName("Picasso-refQueue");
    }

    public final void run()
    {
        Process.setThreadPriority(10);
        try
        {
            do
            {
                b b1 = (b)a.remove();
                b.sendMessage(b.obtainMessage(3, b1.a));
            } while (true);
        }
        catch (InterruptedException interruptedexception)
        {
            return;
        }
        catch (Exception exception)
        {
            b.post(new ah(this, exception));
        }
    }
}

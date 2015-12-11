// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.os.Handler;
import android.os.Process;
import java.lang.ref.ReferenceQueue;

// Referenced classes of package android.support.v7:
//            aky

private static class setName extends Thread
{

    private final ReferenceQueue a;
    private final Handler b;

    public void run()
    {
        Process.setThreadPriority(10);
        try
        {
            do
            {
                setName setname = (eadPriority)a.remove();
                b.sendMessage(b.obtainMessage(3, setname.a));
            } while (true);
        }
        catch (InterruptedException interruptedexception)
        {
            return;
        }
        catch (Exception exception)
        {
            b.post(new Runnable(exception) {

                final Exception a;
                final aky.b b;

                public void run()
                {
                    throw new RuntimeException(a);
                }

            
            {
                b = aky.b.this;
                a = exception;
                super();
            }
            });
        }
    }

    eue(ReferenceQueue referencequeue, Handler handler)
    {
        a = referencequeue;
        b = handler;
        setDaemon(true);
        setName("Picasso-refQueue");
    }
}

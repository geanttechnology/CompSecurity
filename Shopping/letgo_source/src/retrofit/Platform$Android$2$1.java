// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package retrofit;

import android.os.Process;
import java.util.concurrent.ThreadFactory;

// Referenced classes of package retrofit:
//            Platform

class val.r
    implements Runnable
{

    final val.r this$1;
    final Runnable val$r;

    public void run()
    {
        Process.setThreadPriority(10);
        val$r.run();
    }

    is._cls0()
    {
        this$1 = final__pcls0;
        val$r = Runnable.this;
        super();
    }

    // Unreferenced inner class retrofit/Platform$Android$2

/* anonymous class */
    class Platform.Android._cls2
        implements ThreadFactory
    {

        final Platform.Android this$0;

        public Thread newThread(Runnable runnable)
        {
            return new Thread(runnable. new Platform.Android._cls2._cls1(), "Retrofit-Idle");
        }

            
            {
                this$0 = Platform.Android.this;
                super();
            }
    }

}

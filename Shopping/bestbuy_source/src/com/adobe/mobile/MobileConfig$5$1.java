// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adobe.mobile;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;

// Referenced classes of package com.adobe.mobile:
//            MobileConfig, StaticMethods

class this._cls1
    implements Callable
{

    final call this$1;

    public volatile Object call()
    {
        return call();
    }

    public Void call()
    {
        return null;
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/adobe/mobile/MobileConfig$5

/* anonymous class */
    class MobileConfig._cls5
        implements Runnable
    {

        final MobileConfig this$0;

        public void run()
        {
            FutureTask futuretask = new FutureTask(new MobileConfig._cls5._cls1());
            StaticMethods.getMessagesExecutor().execute(futuretask);
            try
            {
                futuretask.get();
                return;
            }
            catch (Exception exception)
            {
                StaticMethods.logErrorFormat("Data Callback - Error waiting for callbacks being loaded (%s)", new Object[] {
                    exception.getMessage()
                });
            }
        }

            
            {
                this$0 = MobileConfig.this;
                super();
            }
    }

}

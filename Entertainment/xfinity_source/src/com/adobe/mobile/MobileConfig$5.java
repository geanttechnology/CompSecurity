// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adobe.mobile;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;

// Referenced classes of package com.adobe.mobile:
//            MobileConfig, StaticMethods

class this._cls0
    implements Runnable
{

    final MobileConfig this$0;

    public void run()
    {
        FutureTask futuretask = new FutureTask(new Callable() {

            final MobileConfig._cls5 this$1;

            public volatile Object call()
                throws Exception
            {
                return call();
            }

            public Void call()
                throws Exception
            {
                return null;
            }

            
            {
                this$1 = MobileConfig._cls5.this;
                super();
            }
        });
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

    _cls1.this._cls1()
    {
        this$0 = MobileConfig.this;
        super();
    }
}

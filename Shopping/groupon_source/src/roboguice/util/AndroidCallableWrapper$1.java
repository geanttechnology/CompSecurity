// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package roboguice.util;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

// Referenced classes of package roboguice.util:
//            AndroidCallableWrapper

class val.latch
    implements Runnable
{

    final AndroidCallableWrapper this$0;
    final Exception val$exceptions[];
    final CountDownLatch val$latch;

    public void run()
    {
        (new Callable() {

            final AndroidCallableWrapper._cls1 this$1;

            public Object call()
                throws Exception
            {
                doOnPreCall();
                return null;
            }

            
            {
                this$1 = AndroidCallableWrapper._cls1.this;
                super();
            }
        }).call();
        val$latch.countDown();
        return;
        Object obj;
        obj;
        val$exceptions[0] = ((Exception) (obj));
        val$latch.countDown();
        return;
        obj;
        val$latch.countDown();
        throw obj;
    }

    _cls1.this._cls1()
    {
        this$0 = final_androidcallablewrapper;
        val$exceptions = aexception;
        val$latch = CountDownLatch.this;
        super();
    }
}

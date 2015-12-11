// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package roboguice.util;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

// Referenced classes of package roboguice.util:
//            AndroidCallableWrapper

class this._cls1
    implements Callable
{

    final PreCall this$1;

    public Object call()
        throws Exception
    {
        doOnPreCall();
        return null;
    }

    l.latch()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class roboguice/util/AndroidCallableWrapper$1

/* anonymous class */
    class AndroidCallableWrapper._cls1
        implements Runnable
    {

        final AndroidCallableWrapper this$0;
        final Exception val$exceptions[];
        final CountDownLatch val$latch;

        public void run()
        {
            (new AndroidCallableWrapper._cls1._cls1()).call();
            latch.countDown();
            return;
            Object obj;
            obj;
            exceptions[0] = ((Exception) (obj));
            latch.countDown();
            return;
            obj;
            latch.countDown();
            throw obj;
        }

            
            {
                this$0 = final_androidcallablewrapper;
                exceptions = aexception;
                latch = CountDownLatch.this;
                super();
            }
    }

}

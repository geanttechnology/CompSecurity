// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.content;

import android.support.v4.os.OperationCanceledException;
import java.util.concurrent.CountDownLatch;

// Referenced classes of package android.support.v4.content:
//            ModernAsyncTask, AsyncTaskLoader

final class this._cls0 extends ModernAsyncTask
    implements Runnable
{

    private final CountDownLatch mDone = new CountDownLatch(1);
    final AsyncTaskLoader this$0;
    boolean waiting;

    protected final volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected final transient Object doInBackground(Void avoid[])
    {
        try
        {
            avoid = ((Void []) (onLoadInBackground()));
        }
        // Misplaced declaration of an exception variable
        catch (Void avoid[])
        {
            if (!isCancelled())
            {
                throw avoid;
            } else
            {
                return null;
            }
        }
        return avoid;
    }

    protected final void onCancelled(Object obj)
    {
        dispatchOnCancelled(this, obj);
        mDone.countDown();
        return;
        obj;
        mDone.countDown();
        throw obj;
    }

    protected final void onPostExecute(Object obj)
    {
        dispatchOnLoadComplete(this, obj);
        mDone.countDown();
        return;
        obj;
        mDone.countDown();
        throw obj;
    }

    public final void run()
    {
        waiting = false;
        executePendingTask();
    }

    public final void waitForLoader()
    {
        try
        {
            mDone.await();
            return;
        }
        catch (InterruptedException interruptedexception)
        {
            return;
        }
    }

    _cls9()
    {
        this$0 = AsyncTaskLoader.this;
        super();
    }
}

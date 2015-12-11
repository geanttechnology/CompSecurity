// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package commonlib.manager;

import android.app.Activity;
import android.os.Handler;
import java.io.IOException;
import java.lang.ref.WeakReference;
import roboguice.util.Ln;

// Referenced classes of package commonlib.manager:
//            SyncManager

class val.cb
    implements Runnable
{

    final bleSyncProgressIndicator this$1;
    final bleSyncProgressIndicator val$cb;

    public void run()
    {
        val$cb.bleSyncProgressIndicator(false);
    }

    is._cls0()
    {
        this$1 = final__pcls0;
        val$cb = val.cb.this;
        super();
    }

    // Unreferenced inner class commonlib/manager/SyncManager$UpdateRunnable$1

/* anonymous class */
    class SyncManager.UpdateRunnable._cls1
        implements Runnable
    {

        final SyncManager.UpdateRunnable this$0;

        public void run()
        {
            final SyncManager.SyncUiCallbacks cb;
            SyncManager syncmanager;
            syncmanager = (SyncManager)syncManagerRef.get();
            if (syncmanager == null)
            {
                return;
            }
            if (SyncManager.UpdateRunnable.access$100(SyncManager.UpdateRunnable.this).get() != null)
            {
                cb = (SyncManager.SyncUiCallbacks)SyncManager.UpdateRunnable.access$100(SyncManager.UpdateRunnable.this).get();
            } else
            {
                cb = SyncManager.NULL_CALLBACKS;
            }
            SyncManager.access$200(syncmanager).post(new SyncManager.UpdateRunnable._cls1._cls1());
            performSync();
            syncmanager.onSuccess(info);
            syncmanager.onFinally(info);
            SyncManager.access$200(syncmanager).post(cb. new SyncManager.UpdateRunnable._cls1._cls3());
            return;
            final Exception e;
            e;
            if (!(e instanceof IOException))
            {
                Ln.e(e);
            }
            syncmanager.onException(info, e);
            if (!cb.equals(SyncManager.NULL_CALLBACKS) && (!(syncmanager.context instanceof Activity) || syncmanager.shouldShowErrorAfterAdd(this)))
            {
                SyncManager.access$200(syncmanager).post(new SyncManager.UpdateRunnable._cls1._cls2());
            }
            syncmanager.onFinally(info);
            SyncManager.access$200(syncmanager).post(cb. new SyncManager.UpdateRunnable._cls1._cls3());
            return;
            e;
            syncmanager.onFinally(info);
            SyncManager.access$200(syncmanager).post(cb. new SyncManager.UpdateRunnable._cls1._cls3());
            throw e;
        }

            
            {
                this$0 = SyncManager.UpdateRunnable.this;
                super();
            }

        // Unreferenced inner class commonlib/manager/SyncManager$UpdateRunnable$1$1

/* anonymous class */
        class SyncManager.UpdateRunnable._cls1._cls1
            implements Runnable
        {

            final SyncManager.UpdateRunnable._cls1 this$1;
            final SyncManager.SyncUiCallbacks val$cb;

            public void run()
            {
                cb.enableSyncProgressIndicator(true);
            }

                    
                    {
                        this$1 = SyncManager.UpdateRunnable._cls1.this;
                        cb = syncuicallbacks;
                        super();
                    }
        }


        // Unreferenced inner class commonlib/manager/SyncManager$UpdateRunnable$1$2

/* anonymous class */
        class SyncManager.UpdateRunnable._cls1._cls2
            implements Runnable
        {

            final SyncManager.UpdateRunnable._cls1 this$1;
            final SyncManager.SyncUiCallbacks val$cb;
            final Exception val$e;

            public void run()
            {
                cb.handleSyncError(this$0, e);
            }

                    
                    {
                        this$1 = SyncManager.UpdateRunnable._cls1.this;
                        cb = syncuicallbacks;
                        e = exception;
                        super();
                    }
        }

    }

}

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

class val.e
    implements Runnable
{

    final val.e this$1;
    final val.e val$cb;
    final Exception val$e;

    public void run()
    {
        val$cb.dleSyncError(_fld0, val$e);
    }

    is._cls0()
    {
        this$1 = final__pcls0;
        val$cb = _pcls0_1;
        val$e = Exception.this;
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
            SyncManager.access$200(syncmanager).post(new SyncManager.UpdateRunnable._cls1._cls3());
            return;
            Object obj;
            obj;
            if (!(obj instanceof IOException))
            {
                Ln.e(((Throwable) (obj)));
            }
            syncmanager.onException(info, ((Exception) (obj)));
            if (!cb.equals(SyncManager.NULL_CALLBACKS) && (!(syncmanager.context instanceof Activity) || syncmanager.shouldShowErrorAfterAdd(this)))
            {
                SyncManager.access$200(syncmanager).post(((SyncManager.UpdateRunnable._cls1._cls2) (obj)). new SyncManager.UpdateRunnable._cls1._cls2());
            }
            syncmanager.onFinally(info);
            SyncManager.access$200(syncmanager).post(new SyncManager.UpdateRunnable._cls1._cls3());
            return;
            obj;
            syncmanager.onFinally(info);
            SyncManager.access$200(syncmanager).post(new SyncManager.UpdateRunnable._cls1._cls3());
            throw obj;
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


        // Unreferenced inner class commonlib/manager/SyncManager$UpdateRunnable$1$3

/* anonymous class */
        class SyncManager.UpdateRunnable._cls1._cls3
            implements Runnable
        {

            final SyncManager.UpdateRunnable._cls1 this$1;
            final SyncManager.SyncUiCallbacks val$cb;

            public void run()
            {
                cb.enableSyncProgressIndicator(false);
            }

                    
                    {
                        this$1 = SyncManager.UpdateRunnable._cls1.this;
                        cb = syncuicallbacks;
                        super();
                    }
        }

    }

}

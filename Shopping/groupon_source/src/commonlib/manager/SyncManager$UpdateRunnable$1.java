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

class this._cls0
    implements Runnable
{

    final _cls3 this$0;

    public void run()
    {
        final this._cls0 cb;
        SyncManager syncmanager;
        syncmanager = (SyncManager)ncManagerRef.get();
        if (syncmanager == null)
        {
            return;
        }
        if (cess._mth100(this._cls0.this).get() != null)
        {
            cb = (this._cls0)cess._mth100(this._cls0.this).get();
        } else
        {
            cb = SyncManager.NULL_CALLBACKS;
        }
        SyncManager.access$200(syncmanager).post(new Runnable() {

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
        });
        rformSync();
        syncmanager.onSuccess(fo);
        syncmanager.onFinally(fo);
        SyncManager.access$200(syncmanager).post(new Runnable() {

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
        });
        return;
        final Exception e;
        e;
        if (!(e instanceof IOException))
        {
            Ln.e(e);
        }
        syncmanager.onException(fo, e);
        if (!cb.equals(SyncManager.NULL_CALLBACKS) && (!(syncmanager.context instanceof Activity) || syncmanager.shouldShowErrorAfterAdd(this)))
        {
            SyncManager.access$200(syncmanager).post(new Runnable() {

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
            });
        }
        syncmanager.onFinally(fo);
        SyncManager.access$200(syncmanager).post(new _cls3());
        return;
        e;
        syncmanager.onFinally(fo);
        SyncManager.access$200(syncmanager).post(new _cls3());
        throw e;
    }

    _cls3.val.cb()
    {
        this$0 = this._cls0.this;
        super();
    }
}

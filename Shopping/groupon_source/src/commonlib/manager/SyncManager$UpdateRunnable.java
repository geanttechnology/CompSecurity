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

public static class syncManagerRef
    implements Runnable
{

    private WeakReference callbacksRef;
    protected Object info;
    protected WeakReference syncManagerRef;

    protected void performSync()
        throws Exception
    {
        SyncManager syncmanager = (SyncManager)syncManagerRef.get();
        if (syncmanager != null)
        {
            syncmanager.doSync(this);
        }
    }

    public void run()
    {
        SyncManager syncmanager = (SyncManager)syncManagerRef.get();
        if (syncmanager == null)
        {
            return;
        } else
        {
            syncmanager.execute(new Runnable() {

                final SyncManager.UpdateRunnable this$0;

                public void run()
                {
                    final SyncManager.SyncUiCallbacks cb;
                    SyncManager syncmanager1;
                    syncmanager1 = (SyncManager)syncManagerRef.get();
                    if (syncmanager1 == null)
                    {
                        return;
                    }
                    if (callbacksRef.get() != null)
                    {
                        cb = (SyncManager.SyncUiCallbacks)callbacksRef.get();
                    } else
                    {
                        cb = SyncManager.NULL_CALLBACKS;
                    }
                    SyncManager.access$200(syncmanager1).post(cb. new Runnable() {

                        final _cls1 this$1;
                        final SyncManager.SyncUiCallbacks val$cb;

                        public void run()
                        {
                            cb.enableSyncProgressIndicator(true);
                        }

            
            {
                this$1 = final__pcls1;
                cb = SyncManager.SyncUiCallbacks.this;
                super();
            }
                    });
                    performSync();
                    syncmanager1.onSuccess(info);
                    syncmanager1.onFinally(info);
                    SyncManager.access$200(syncmanager1).post(cb. new Runnable() {

                        final _cls1 this$1;
                        final SyncManager.SyncUiCallbacks val$cb;

                        public void run()
                        {
                            cb.enableSyncProgressIndicator(false);
                        }

            
            {
                this$1 = final__pcls1;
                cb = SyncManager.SyncUiCallbacks.this;
                super();
            }
                    });
                    return;
                    Object obj;
                    obj;
                    if (!(obj instanceof IOException))
                    {
                        Ln.e(((Throwable) (obj)));
                    }
                    syncmanager1.onException(info, ((Exception) (obj)));
                    if (!cb.equals(SyncManager.NULL_CALLBACKS) && (!(syncmanager1.context instanceof Activity) || syncmanager1.shouldShowErrorAfterAdd(this)))
                    {
                        SyncManager.access$200(syncmanager1).post(((_cls2) (obj)). new Runnable() {

                            final _cls1 this$1;
                            final SyncManager.SyncUiCallbacks val$cb;
                            final Exception val$e;

                            public void run()
                            {
                                cb.handleSyncError(_fld0, e);
                            }

            
            {
                this$1 = final__pcls1;
                cb = syncuicallbacks;
                e = Exception.this;
                super();
            }
                        });
                    }
                    syncmanager1.onFinally(info);
                    SyncManager.access$200(syncmanager1).post(cb. new _cls3());
                    return;
                    obj;
                    syncmanager1.onFinally(info);
                    SyncManager.access$200(syncmanager1).post(cb. new _cls3());
                    throw obj;
                }

            
            {
                this$0 = SyncManager.UpdateRunnable.this;
                super();
            }
            });
            return;
        }
    }


    public ( , Object obj, SyncManager syncmanager)
    {
        info = obj;
        callbacksRef = new WeakReference();
        syncManagerRef = new WeakReference(syncmanager);
    }
}

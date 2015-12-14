// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.syncframework;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.amazon.gallery.foundation.utils.di.BeanAwareApplication;

// Referenced classes of package com.amazon.gallery.thor.syncframework:
//            WhisperUploadSyncAdapter

public class WhisperUploadSyncService extends Service
{

    private static WhisperUploadSyncAdapter syncAdapter = null;
    private static final Object syncAdapterLock = new Object();

    public WhisperUploadSyncService()
    {
    }

    public IBinder onBind(Intent intent)
    {
        return syncAdapter.getSyncAdapterBinder();
    }

    public void onCreate()
    {
        super.onCreate();
        synchronized (syncAdapterLock)
        {
            if (syncAdapter == null)
            {
                BeanAwareApplication beanawareapplication = (BeanAwareApplication)getApplicationContext();
                syncAdapter = new WhisperUploadSyncAdapter(beanawareapplication, beanawareapplication.getBeanFactory(), true);
            }
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void onDestroy()
    {
        super.onDestroy();
    }

}

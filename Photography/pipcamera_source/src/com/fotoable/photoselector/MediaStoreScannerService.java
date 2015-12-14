// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.photoselector;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import mv;
import mw;
import mz;

// Referenced classes of package com.fotoable.photoselector:
//            MediaStorePhotosDB

public class MediaStoreScannerService extends Service
{

    private static ThreadPoolExecutor b = (ThreadPoolExecutor)Executors.newFixedThreadPool(2);
    private WeakReference a;
    private final IBinder c = new mv(this);

    public MediaStoreScannerService()
    {
    }

    public static WeakReference a(MediaStoreScannerService mediastorescannerservice)
    {
        return mediastorescannerservice.a;
    }

    public void a(mz mz)
    {
        MediaStorePhotosDB.a().c();
        if (mz != null)
        {
            try
            {
                a = new WeakReference(mz);
            }
            // Misplaced declaration of an exception variable
            catch (mz mz)
            {
                Log.e("MediaStoreScannerService", mz.getMessage());
            }
        }
        if (MediaStorePhotosDB.a().b().size() > 0)
        {
            (new Handler()).postDelayed(new Runnable() {

                final MediaStoreScannerService a;

                public void run()
                {
                    mz mz1 = (mz)MediaStoreScannerService.a(a).get();
                    if (mz1 != null)
                    {
                        mz1.a_(true);
                    }
                }

            
            {
                a = MediaStoreScannerService.this;
                super();
            }
            }, 100L);
            return;
        } else
        {
            mz = new mw(this);
            mz.a();
            b.execute(mz);
            return;
        }
    }

    public IBinder onBind(Intent intent)
    {
        return c;
    }

    public void onCreate()
    {
    }

    public void onDestroy()
    {
    }

    public int onStartCommand(Intent intent, int i, int j)
    {
        Log.i("LocalService", (new StringBuilder()).append("Received start id ").append(j).append(": ").append(intent).toString());
        return 1;
    }

}

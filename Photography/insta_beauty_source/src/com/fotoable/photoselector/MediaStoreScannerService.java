// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.photoselector;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;
import are;
import arf;
import arg;
import arj;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

// Referenced classes of package com.fotoable.photoselector:
//            MediaStorePhotosDB

public class MediaStoreScannerService extends Service
{

    private static ThreadPoolExecutor b = (ThreadPoolExecutor)Executors.newFixedThreadPool(2);
    private WeakReference a;
    private final IBinder c = new arf(this);

    public MediaStoreScannerService()
    {
    }

    public static WeakReference a(MediaStoreScannerService mediastorescannerservice)
    {
        return mediastorescannerservice.a;
    }

    public void a(arj arj)
    {
        MediaStorePhotosDB.a().c();
        if (arj != null)
        {
            try
            {
                a = new WeakReference(arj);
            }
            // Misplaced declaration of an exception variable
            catch (arj arj)
            {
                Log.e("MediaStoreScannerService", arj.getMessage());
            }
        }
        if (MediaStorePhotosDB.a().b().size() > 0)
        {
            (new Handler()).postDelayed(new are(this), 100L);
            return;
        } else
        {
            arj = new arg(this, null);
            arj.a();
            b.execute(arj);
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

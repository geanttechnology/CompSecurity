// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.gcm;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import com.cyberlink.you.g;
import com.cyberlink.you.utility.ULogUtility;

// Referenced classes of package com.cyberlink.you.gcm:
//            a

public class GcmRegService extends Service
{

    private static a a = null;

    public GcmRegService()
    {
    }

    public IBinder onBind(Intent intent)
    {
        return null;
    }

    public void onCreate()
    {
        super.onCreate();
        Log.d("GcmRegService", "onCreate()");
        ULogUtility.b("onCreate()", "GcmRegService");
    }

    public void onDestroy()
    {
        super.onDestroy();
        Log.d("GcmRegService", "onDestroy()");
        ULogUtility.b("onDestroy()", "GcmRegService");
    }

    public int onStartCommand(Intent intent, int i, int j)
    {
        Log.d("GcmRegService", (new StringBuilder()).append("onStartCommand() ").append(j).toString());
        ULogUtility.b((new StringBuilder()).append("onStartCommand() ").append(j).toString(), "GcmRegService");
        while (!g.a().G() || a != null && a.isAlive()) 
        {
            return 2;
        }
        a = new a();
        a.start();
        return 2;
    }

}

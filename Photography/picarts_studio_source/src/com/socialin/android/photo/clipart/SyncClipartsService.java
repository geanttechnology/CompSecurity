// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.clipart;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.IBinder;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.util.s;

// Referenced classes of package com.socialin.android.photo.clipart:
//            e

public class SyncClipartsService extends Service
{

    private static final String a = com/socialin/android/photo/clipart/SyncClipartsService.getSimpleName();
    private BroadcastReceiver b;

    public SyncClipartsService()
    {
        b = new BroadcastReceiver() {

            public final void onReceive(Context context, Intent intent)
            {
                SyncClipartsService.a();
                if (s.a(context) && s.b(context) && SocialinV3.getInstance().isRegistered())
                {
                    SyncClipartsService.a();
                    intent = context.getSharedPreferences("clipart_sync_pref_name", 0);
                    long l = intent.getLong("last_sync_time", 0L);
                    if (System.currentTimeMillis() - l < 0L)
                    {
                        l = 0x493e1L;
                    } else
                    {
                        l = System.currentTimeMillis() - l;
                    }
                    if (l > 0x493e0L)
                    {
                        SyncClipartsService.a();
                        intent.edit().putLong("last_sync_time", System.currentTimeMillis()).apply();
                        e.a(context);
                    }
                }
            }

        };
    }

    static String a()
    {
        return a;
    }

    public IBinder onBind(Intent intent)
    {
        return null;
    }

    public void onCreate()
    {
        super.onCreate();
        IntentFilter intentfilter = new IntentFilter();
        intentfilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        intentfilter.addAction("picsart.clipart.sync.action");
        registerReceiver(b, intentfilter);
    }

    public void onDestroy()
    {
        super.onDestroy();
        unregisterReceiver(b);
    }

}

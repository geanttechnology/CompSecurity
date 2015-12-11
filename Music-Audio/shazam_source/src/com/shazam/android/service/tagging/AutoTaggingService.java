// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.service.tagging;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.support.v4.a.e;
import com.shazam.android.analytics.TaggingOrigin;
import com.shazam.android.ay.a.n;
import com.shazam.i.b.ar.a;
import com.shazam.i.b.c;
import com.shazam.o.q;

public class AutoTaggingService extends Service
{

    private final Handler a;
    private final e b;
    private final com.shazam.android.ay.a c;
    private final BroadcastReceiver d;
    private final BroadcastReceiver e;
    private final Runnable f;

    public AutoTaggingService()
    {
        this(new Handler(Looper.getMainLooper()), android.support.v4.a.e.a(com.shazam.i.b.c.a()), com.shazam.i.b.ar.a.a());
    }

    public AutoTaggingService(Handler handler, e e1, com.shazam.android.ay.a a1)
    {
        d = new BroadcastReceiver() {

            final AutoTaggingService a;

            public final void onReceive(Context context, Intent intent)
            {
                a.stopSelf();
            }

            
            {
                a = AutoTaggingService.this;
                super();
            }
        };
        e = new BroadcastReceiver() {

            final AutoTaggingService a;

            public final void onReceive(Context context, Intent intent)
            {
                long l = com.shazam.android.service.tagging.AutoTaggingService.a(a).b.a();
                com.shazam.android.service.tagging.AutoTaggingService.c(a).postDelayed(AutoTaggingService.b(a), l);
            }

            
            {
                a = AutoTaggingService.this;
                super();
            }
        };
        f = new Runnable() {

            final AutoTaggingService a;

            public final void run()
            {
                com.shazam.android.ay.a.q q1 = com.shazam.i.b.ar.a.e.a();
                com.shazam.android.analytics.TaggedBeaconData taggedbeacondata = com.shazam.android.analytics.TaggedBeaconData.Builder.taggedBeaconData().withTaggingOrigin(TaggingOrigin.BACKGROUND).build();
                if (q1.d.a() && !q1.a.a())
                {
                    q1.c.a(taggedbeacondata);
                }
            }

            
            {
                a = AutoTaggingService.this;
                super();
            }
        };
        a = handler;
        b = e1;
        c = a1;
    }

    static com.shazam.android.ay.a a(AutoTaggingService autotaggingservice)
    {
        return autotaggingservice.c;
    }

    static Runnable b(AutoTaggingService autotaggingservice)
    {
        return autotaggingservice.f;
    }

    static Handler c(AutoTaggingService autotaggingservice)
    {
        return autotaggingservice.a;
    }

    public IBinder onBind(Intent intent)
    {
        return null;
    }

    public void onCreate()
    {
        super.onCreate();
        b.a(d, new IntentFilter("com.shazam.android.audio.STOP_LISTENING"));
    }

    public void onDestroy()
    {
        super.onDestroy();
        b.a(d);
        a.removeCallbacks(f);
    }

    public int onStartCommand(Intent intent, int i, int j)
    {
        a.post(f);
        return 2;
    }
}

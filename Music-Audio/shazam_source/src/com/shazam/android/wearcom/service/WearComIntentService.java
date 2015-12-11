// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.wearcom.service;

import android.app.IntentService;
import android.content.Intent;
import android.support.v4.a.e;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.o;
import com.shazam.android.wearcom.b.a;
import com.shazam.android.wearcom.b.d;
import java.util.concurrent.TimeUnit;
import org.b.b;
import org.b.c;

// Referenced classes of package com.shazam.android.wearcom.service:
//            a

public class WearComIntentService extends IntentService
{

    private static final b a = org.b.c.a(com/shazam/android/wearcom/service/WearComIntentService);
    private final d b = new d();
    private com.google.android.gms.common.api.c c;
    private e d;

    public WearComIntentService()
    {
        super(com/shazam/android/wearcom/service/WearComIntentService.getSimpleName());
    }

    public void onCreate()
    {
        super.onCreate();
        c = (new com.google.android.gms.common.api.c.a(this)).a(o.l).b();
        d = e.a(this);
    }

    protected void onHandleIntent(Intent intent)
    {
        c.a(TimeUnit.MILLISECONDS);
        if (!c.d()) goto _L2; else goto _L1
_L1:
        com.shazam.android.wearcom.service.a a1 = (com.shazam.android.wearcom.service.a)intent.getSerializableExtra("extraWearAction");
        com.shazam.android.wearcom.b.d._cls1.a[a1.ordinal()];
        JVM INSTR tableswitch 1 2: default 64
    //                   1 74
    //                   2 165;
           goto _L3 _L4 _L5
_L3:
        throw new IllegalArgumentException("ActionType not supported");
_L4:
        Object obj = new a();
_L6:
        obj = ((com.shazam.android.wearcom.b.c) (obj)).a(c, intent);
        a.a("{} completed successfully {}", a1, Boolean.valueOf(((Status) (obj)).b()));
        intent = intent.getStringExtra("extraActionToNotify");
        if (com.shazam.android.wearcom.c.a.b(intent))
        {
            intent = new Intent(intent);
            intent.putExtra("isSuccess", ((Status) (obj)).b());
            d.a(intent);
        }
        c.c();
        return;
_L5:
        obj = new com.shazam.android.wearcom.b.b();
        if (true) goto _L6; else goto _L2
_L2:
        a.b("Failed to deliver Message - Client disconnected from Google Play Services");
        return;
    }

}

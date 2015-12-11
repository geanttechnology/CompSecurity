// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.service.gcm;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Bundle;
import com.shazam.android.ab.a;
import com.shazam.android.aq.q;
import com.shazam.android.k.f.j;
import com.shazam.android.l.g.b;
import com.shazam.android.l.g.c;
import com.shazam.f.e;
import java.util.Random;

// Referenced classes of package com.shazam.android.service.gcm:
//            ShazamGcmBroadcastReceiver, b, a

public class GcmIntentService extends IntentService
{

    private final com.shazam.b.a.a a;
    private final NotificationManager b;
    private final Random c;

    public GcmIntentService()
    {
        this(((com.shazam.b.a.a) (new c(new q(), new b(new j(), new a())))), com.shazam.i.b.c.b(), com.shazam.i.a.a());
    }

    public GcmIntentService(com.shazam.b.a.a a1, NotificationManager notificationmanager, Random random)
    {
        super("GcmIntentService");
        a = a1;
        b = notificationmanager;
        c = random;
    }

    protected void onHandleIntent(Intent intent)
    {
        Bundle bundle;
        String s;
        bundle = intent.getExtras();
        com.google.android.gms.c.b.a(this);
        s = com.google.android.gms.c.b.a(intent);
        if (com.shazam.b.e.a.a(s))
        {
            return;
        }
        if (bundle.isEmpty()) goto _L2; else goto _L1
_L1:
        byte byte0 = -1;
        s.hashCode();
        JVM INSTR lookupswitch 2: default 64
    //                   102161: 109
    //                   814694033: 94;
           goto _L3 _L4 _L5
_L3:
        byte0;
        JVM INSTR tableswitch 0 1: default 88
    //                   0 124
    //                   1 132;
           goto _L2 _L6 _L7
_L2:
        com.shazam.android.service.gcm.ShazamGcmBroadcastReceiver.a(intent);
        return;
_L5:
        if (s.equals("send_error"))
        {
            byte0 = 0;
        }
          goto _L3
_L4:
        if (s.equals("gcm"))
        {
            byte0 = 1;
        }
          goto _L3
_L6:
        bundle.toString();
          goto _L2
_L7:
        com.shazam.android.service.gcm.b b1 = new com.shazam.android.service.gcm.b(this, intent, c);
        try
        {
            Notification notification = (Notification)a.a(b1);
            NotificationManager notificationmanager = b;
            if (b1.d == null)
            {
                b1.d = Integer.valueOf(com.shazam.o.e.a(b1.b.getExtras().getString(com.shazam.android.service.gcm.a.j.l), b1.c.nextInt()));
            }
            notificationmanager.notify(b1.d.intValue(), notification);
        }
        catch (e e1) { }
        catch (RuntimeException runtimeexception) { }
          goto _L2
    }
}

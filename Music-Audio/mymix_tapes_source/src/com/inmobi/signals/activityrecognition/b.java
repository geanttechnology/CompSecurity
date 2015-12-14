// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.signals.activityrecognition;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.inmobi.commons.a.a;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.signals.o;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.inmobi.signals.activityrecognition:
//            ActivityRecognitionManager, a

public class b
{
    static class a extends Handler
    {

        public void handleMessage(Message message)
        {
            message.what;
            JVM INSTR tableswitch 0 0: default 24
        //                       0 25;
               goto _L1 _L2
_L1:
            return;
_L2:
            int j = ActivityRecognitionManager.c();
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b.f(), (new StringBuilder()).append("Polling for ActivityRecognition. Detected activity:").append(j).toString());
            if (j != -1)
            {
                b.g().add(new com.inmobi.signals.activityrecognition.a(j, System.currentTimeMillis()));
            }
            if (b.g().size() < o.a().e().s())
            {
                sendEmptyMessageDelayed(0, o.a().e().r() * 1000);
                return;
            }
            if (true) goto _L1; else goto _L3
_L3:
        }

        a(Looper looper)
        {
            super(looper);
        }
    }


    private static final String a = com/inmobi/signals/activityrecognition/b.getSimpleName();
    private static final Object b = new Object();
    private static volatile b c;
    private static List d;
    private HandlerThread e;
    private Handler f;

    private b()
    {
        d = new ArrayList();
        e = new HandlerThread("ActivityRecognitionSampler");
        e.start();
        f = new a(e.getLooper());
    }

    public static b a()
    {
        Object obj;
        obj = c;
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_45;
        }
        Object obj1 = b;
        obj1;
        JVM INSTR monitorenter ;
        b b1 = c;
        obj = b1;
        if (b1 != null)
        {
            break MISSING_BLOCK_LABEL_36;
        }
        obj = new b();
        c = ((b) (obj));
        obj1;
        JVM INSTR monitorexit ;
        return ((b) (obj));
        obj;
        obj1;
        JVM INSTR monitorexit ;
        throw obj;
        return ((b) (obj));
    }

    static String f()
    {
        return a;
    }

    static List g()
    {
        return d;
    }

    private static boolean h()
    {
        if (com.inmobi.commons.a.a.b().checkCallingOrSelfPermission("com.google.android.gms.permission.ACTIVITY_RECOGNITION") != 0)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "Activity recognition sampling did not work due to missing permission.");
            return false;
        } else
        {
            return true;
        }
    }

    private static boolean i()
    {
        if (com.inmobi.commons.a.a.b().getPackageManager().queryIntentServices(new Intent(com.inmobi.commons.a.a.b(), com/inmobi/signals/activityrecognition/ActivityRecognitionManager), 0x10000).size() > 0)
        {
            return true;
        } else
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "Activity recognition sampling did not work due to missing service in manifest.");
            return false;
        }
    }

    public void b()
    {
        while (!h() || !i() || f.hasMessages(0)) 
        {
            return;
        }
        com.inmobi.signals.activityrecognition.ActivityRecognitionManager.a();
        f.sendEmptyMessage(0);
    }

    public void c()
    {
        while (!h() || !i() || !f.hasMessages(0)) 
        {
            return;
        }
        ActivityRecognitionManager.b();
        f.removeMessages(0);
    }

    public List d()
    {
        return d;
    }

    public void e()
    {
        d = new ArrayList();
    }

}

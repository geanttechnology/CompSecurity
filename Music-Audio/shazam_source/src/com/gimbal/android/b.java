// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gimbal.android;

import android.os.Handler;
import android.os.Message;
import com.gimbal.a.a;
import com.gimbal.internal.c.c;
import com.gimbal.internal.proximity.core.sighting.Sighting;
import com.gimbal.internal.proximity.core.sighting.f;
import com.gimbal.internal.proximity.e;
import com.gimbal.internal.proximity.impl.TransmitterInternal;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.gimbal.android:
//            BeaconSighting, a, Beacon

public class b
{
    public final class a extends Handler
        implements f
    {

        private final WeakReference a;
        private b b;

        public final void a(Sighting sighting, TransmitterInternal transmitterinternal)
        {
            if (com.gimbal.android.b.a(b).get())
            {
                sighting = com.gimbal.internal.proximity.b.a(sighting, transmitterinternal);
                transmitterinternal = Message.obtain();
                transmitterinternal.what = 0;
                transmitterinternal.obj = sighting;
                sendMessage(transmitterinternal);
            }
        }

        public final void handleMessage(Message message)
        {
            if (message.what == 0)
            {
                message = (BeaconSighting)message.obj;
                com.gimbal.android.a a1 = (com.gimbal.android.a)a.get();
                if (a1 != null)
                {
                    com.gimbal.android.b.a();
                    message.getBeacon().getName();
                    message.getBeacon().getIdentifier();
                    message.getRSSI();
                    a1.a(message);
                }
                return;
            } else
            {
                com.gimbal.android.b.a();
                int i = message.what;
                return;
            }
        }

        public a(com.gimbal.android.a a1)
        {
            b = b.this;
            super();
            a = new WeakReference(a1);
        }
    }


    private static final com.gimbal.a.a d = com.gimbal.internal.c.c.e(com/gimbal/android/b.getName());
    public com.gimbal.internal.proximity.a a;
    public AtomicBoolean b;
    public Map c;

    public b()
    {
        c = new WeakHashMap();
        a = e.a().e;
        b = new AtomicBoolean(false);
    }

    static com.gimbal.a.a a()
    {
        return d;
    }

    static AtomicBoolean a(b b1)
    {
        return b1.b;
    }

}

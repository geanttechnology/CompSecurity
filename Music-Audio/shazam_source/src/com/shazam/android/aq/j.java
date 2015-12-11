// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.aq;

import com.gimbal.internal.persistance.ApplicationConfiguration;
import com.gimbal.internal.persistance.a;
import com.gimbal.internal.persistance.b;
import com.gimbal.internal.persistance.f;
import com.shazam.android.ay.a.a.u;
import com.shazam.android.d;
import com.shazam.android.e;
import com.shazam.model.Provider;
import com.shazam.model.configuration.GimbalConfiguration;
import com.shazam.o.k;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class j
    implements Provider
{

    private static com.shazam.android.ay.a.j a;
    private final GimbalConfiguration b;

    public j(GimbalConfiguration gimbalconfiguration)
    {
        b = gimbalconfiguration;
    }

    public final Object a()
    {
        if (a == null && b.a())
        {
            String s = b.b();
            Object obj = k.a("allowKitKat", "true");
            com.gimbal.internal.proximity.e.a((new e()).a());
            com.gimbal.internal.proximity.e e1 = com.gimbal.internal.proximity.e.a();
            e1.c.a(s);
            ApplicationConfiguration applicationconfiguration = new ApplicationConfiguration();
            applicationconfiguration.setAllowKitKat(Boolean.valueOf(true));
            applicationconfiguration.setSmoothingWindow(Integer.valueOf(3));
            Iterator iterator = ((Map) (obj)).entrySet().iterator();
            s = null;
            obj = null;
            while (iterator.hasNext()) 
            {
                java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
                if ("Beacon_Resolve_Base_Url".equals(entry.getKey()))
                {
                    obj = (String)entry.getValue();
                } else
                if ("Broadcast_Receiver_Security_Permission".equals(entry.getKey()))
                {
                    s = (String)entry.getValue();
                } else
                if ("allowKitKat".equals(entry.getKey()))
                {
                    applicationconfiguration.setAllowKitKat(Boolean.valueOf(Boolean.parseBoolean((String)entry.getValue())));
                } else
                if ("smoothingWindow".equals(entry.getKey()))
                {
                    applicationconfiguration.setSmoothingWindow(Integer.valueOf(com.gimbal.internal.proximity.e.a((String)entry.getValue())));
                } else
                {
                    com.gimbal.internal.proximity.e.a.c("Unrecognized gimbal option: {}", new Object[] {
                        entry.getKey()
                    });
                }
            }
            e1.c.a.b("Broadcast_Receiver_Security_Permission", s);
            e1.d.a(applicationconfiguration);
            if (obj != null)
            {
                e1.c.b(((String) (obj)));
            }
            a = new u(new com.gimbal.android.b(), com.shazam.i.b.t.a.a.a());
            return a;
        } else
        {
            return com.shazam.android.ay.a.j.b;
        }
    }
}

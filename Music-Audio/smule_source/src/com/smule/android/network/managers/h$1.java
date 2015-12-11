// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.managers;

import android.content.SharedPreferences;
import com.smule.android.c.aa;
import com.smule.android.f.p;
import com.smule.android.network.a.d;
import com.smule.android.network.core.o;
import java.util.Map;

// Referenced classes of package com.smule.android.network.managers:
//            h

class a
    implements Runnable
{

    final h a;

    public void run()
    {
        Object obj;
        obj = d.a();
        if (!((o) (obj)).a())
        {
            break MISSING_BLOCK_LABEL_129;
        }
        p.a(h.a(a).edit().putString("DEVICE_SETTINGS_JSON", ((o) (obj)).h));
        obj = h.a(a, ((o) (obj)).j);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_119;
        }
        aa.b(h.c(), (new StringBuilder()).append("refreshDeviceSettings - new settings contains ").append(((Map) (obj)).size()).append(" items").toString());
        this;
        JVM INSTR monitorenter ;
        h.a(a, ((Map) (obj)));
        h.a(a, System.currentTimeMillis());
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        aa.e(h.c(), "refreshDeviceSettings - parsing new settings failed");
        return;
        aa.e(h.c(), "refreshDeviceSettings - call to getDeviceSettings did not succeed");
        return;
    }

    r(h h1)
    {
        a = h1;
        super();
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.util.Log;
import com.google.android.gms.location.e;
import com.google.android.gms.location.m;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

// Referenced classes of package android.support.v7:
//            ahf

class > extends TimerTask
{

    final ahf a;

    public void run()
    {
        try
        {
            m.b.a(ahf.a(a), ahf.b(a)).a(5000L, TimeUnit.MILLISECONDS);
        }
        catch (Exception exception) { }
        if (com.kahuna.sdk.m.s())
        {
            Log.d("Kahuna", "Finished requesting for gps updates for geofences.");
        }
        ahf.c(a);
    }

    mmon.api.e(ahf ahf1)
    {
        a = ahf1;
        super();
    }
}

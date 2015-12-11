// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.cast.internal.zzl;
import com.google.android.gms.common.api.Status;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.google.android.gms.cast:
//            CastRemoteDisplayLocalService, CastDevice

static final class zzVL
    implements ServiceConnection
{

    final String zzUS;
    final CastDevice zzVI;
    final tificationSettings zzVJ;
    final Context zzVK;
    final llbacks zzVL;

    public void onServiceConnected(ComponentName componentname, IBinder ibinder)
    {
        componentname = ((a)ibinder).zzmw();
        if (componentname != null && CastRemoteDisplayLocalService.zza(componentname, zzUS, zzVI, zzVJ, zzVK, this, zzVL))
        {
            break MISSING_BLOCK_LABEL_86;
        }
        CastRemoteDisplayLocalService.zzms().zzc("Connected but unable to get the service instance", new Object[0]);
        zzVL.onRemoteDisplaySessionError(new Status(2200));
        CastRemoteDisplayLocalService.zzmt().set(false);
        zzVK.unbindService(this);
        return;
        componentname;
        CastRemoteDisplayLocalService.zzms().zzb("No need to unbind service, already unbound", new Object[0]);
        return;
    }

    public void onServiceDisconnected(ComponentName componentname)
    {
        CastRemoteDisplayLocalService.zzms().zzb("onServiceDisconnected", new Object[0]);
        zzVL.onRemoteDisplaySessionError(new Status(2201, "Service Disconnected"));
        CastRemoteDisplayLocalService.zzmt().set(false);
        try
        {
            zzVK.unbindService(this);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (ComponentName componentname)
        {
            CastRemoteDisplayLocalService.zzms().zzb("No need to unbind service, already unbound", new Object[0]);
        }
    }

    llbacks(String s, CastDevice castdevice, tificationSettings tificationsettings, Context context, llbacks llbacks)
    {
        zzUS = s;
        zzVI = castdevice;
        zzVJ = tificationsettings;
        zzVK = context;
        zzVL = llbacks;
        super();
    }
}

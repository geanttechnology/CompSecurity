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

static final class zzTV
    implements ServiceConnection
{

    final CastDevice zzTS;
    final tificationSettings zzTT;
    final Context zzTU;
    final llbacks zzTV;
    final String zzTe;

    public void onServiceConnected(ComponentName componentname, IBinder ibinder)
    {
        componentname = ((a)ibinder).zzlZ();
        if (componentname != null && CastRemoteDisplayLocalService.zza(componentname, zzTe, zzTS, zzTT, zzTU, this, zzTV))
        {
            break MISSING_BLOCK_LABEL_86;
        }
        CastRemoteDisplayLocalService.zzlV().zzc("Connected but unable to get the service instance", new Object[0]);
        zzTV.onRemoteDisplaySessionError(new Status(2200));
        CastRemoteDisplayLocalService.zzlW().set(false);
        zzTU.unbindService(this);
        return;
        componentname;
        CastRemoteDisplayLocalService.zzlV().zzb("No need to unbind service, already unbound", new Object[0]);
        return;
    }

    public void onServiceDisconnected(ComponentName componentname)
    {
        CastRemoteDisplayLocalService.zzlV().zzb("onServiceDisconnected", new Object[0]);
        zzTV.onRemoteDisplaySessionError(new Status(2201, "Service Disconnected"));
        CastRemoteDisplayLocalService.zzlW().set(false);
        try
        {
            zzTU.unbindService(this);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (ComponentName componentname)
        {
            CastRemoteDisplayLocalService.zzlV().zzb("No need to unbind service, already unbound", new Object[0]);
        }
    }

    llbacks(String s, CastDevice castdevice, tificationSettings tificationsettings, Context context, llbacks llbacks)
    {
        zzTe = s;
        zzTS = castdevice;
        zzTT = tificationsettings;
        zzTU = context;
        zzTV = llbacks;
        super();
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;

// Referenced classes of package com.google.android.gms.common.internal:
//            zzx, zzj

public final class zzafN
    implements ServiceConnection
{

    final zzj zzafK;
    private final int zzafN;

    public final void onServiceConnected(ComponentName componentname, IBinder ibinder)
    {
        zzx.zzb(ibinder, "Expecting a valid IBinder");
        zzj.zza(zzafK, zzaK(ibinder));
        zzafK.zzbF(zzafN);
    }

    public final void onServiceDisconnected(ComponentName componentname)
    {
        zzafK.mHandler.sendMessage(zzafK.mHandler.obtainMessage(4, zzafN, 1));
    }

    public (zzj zzj1, int i)
    {
        zzafK = zzj1;
        super();
        zzafN = i;
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.gcm;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

// Referenced classes of package com.google.android.gms.gcm:
//            TaskParams, GcmTaskService, zzb

class mExtras extends Thread
{

    private final Bundle mExtras;
    private final String mTag;
    private final zzb zzaCq;
    final GcmTaskService zzaCr;

    public void run()
    {
        int i = zzaCr.onRunTask(new TaskParams(mTag, mExtras));
        zzaCq.zzgB(i);
        GcmTaskService.zza(zzaCr, mTag);
        return;
        Object obj;
        obj;
        Log.e("GcmTaskService", (new StringBuilder("Error reporting result of operation to scheduler for ")).append(mTag).toString());
        GcmTaskService.zza(zzaCr, mTag);
        return;
        obj;
        GcmTaskService.zza(zzaCr, mTag);
        throw obj;
    }

    (GcmTaskService gcmtaskservice, String s, IBinder ibinder, Bundle bundle)
    {
        zzaCr = gcmtaskservice;
        super();
        mTag = s;
        zzaCq = zzaCq(ibinder);
        mExtras = bundle;
    }
}

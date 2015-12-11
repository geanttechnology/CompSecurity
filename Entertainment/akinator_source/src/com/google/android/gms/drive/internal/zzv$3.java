// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;

// Referenced classes of package com.google.android.gms.drive.internal:
//            zzv, zzz

class zzakU
    implements ResultCallback
{

    final zzv zzakU;

    public void onResult(Result result)
    {
        zzo((Status)result);
    }

    public void zzo(Status status)
    {
        if (!status.isSuccess())
        {
            zzz.zzz("DriveContentsImpl", "Error discarding contents");
            return;
        } else
        {
            zzz.zzx("DriveContentsImpl", "Contents discarded");
            return;
        }
    }

    back(zzv zzv1)
    {
        zzakU = zzv1;
        super();
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;

// Referenced classes of package com.google.android.gms.drive.internal:
//            zzu, zzy

class zzaiG
    implements ResultCallback
{

    final zzu zzaiG;

    public void onResult(Result result)
    {
        zzr((Status)result);
    }

    public void zzr(Status status)
    {
        if (!status.isSuccess())
        {
            zzy.zzx("DriveContentsImpl", "Error discarding contents");
            return;
        } else
        {
            zzy.zzv("DriveContentsImpl", "Contents discarded");
            return;
        }
    }

    back(zzu zzu1)
    {
        zzaiG = zzu1;
        super();
    }
}

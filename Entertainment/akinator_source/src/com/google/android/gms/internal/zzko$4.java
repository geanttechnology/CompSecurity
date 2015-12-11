// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;

// Referenced classes of package com.google.android.gms.internal:
//            zzko

class zzYa
    implements ResultCallback
{

    final zzko zzXV;
    final long zzYa;

    public void onResult(Result result)
    {
        zzo((Status)result);
    }

    public void zzo(Status status)
    {
        if (!status.isSuccess())
        {
            zzXV.zzb(zzYa, status.getStatusCode());
        }
    }

    s(zzko zzko1, long l)
    {
        zzXV = zzko1;
        zzYa = l;
        super();
    }
}

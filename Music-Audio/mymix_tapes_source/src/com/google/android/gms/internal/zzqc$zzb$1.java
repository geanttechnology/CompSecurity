// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.util.Log;
import com.google.android.gms.common.api.Status;

// Referenced classes of package com.google.android.gms.internal:
//            zzqc

class nit> extends nit>
{

    final a zzaNR;

    public void zzbc(Status status)
    {
        if (a(zzaNR))
        {
            Log.d("SearchAuth", "ClearTokenImpl success");
        }
        zzaNR.a(status);
    }

    ( )
    {
        zzaNR = ;
        super();
    }
}

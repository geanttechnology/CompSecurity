// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.util.Log;
import com.google.android.gms.common.api.Status;

class nit> extends nit>
{

    final b zzaUR;

    public void zzbb(Status status)
    {
        if (a(zzaUR))
        {
            Log.d("SearchAuth", "ClearTokenImpl success");
        }
        zzaUR.b(status);
    }

    ( )
    {
        zzaUR = ;
        super();
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.auth.api.credentials.internal;

import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.api.Status;

// Referenced classes of package com.google.android.gms.auth.api.credentials.internal:
//            zza, zzb

class t> extends zza
{

    final b zzSG;

    public void zza(Status status, Credential credential)
    {
        zzSG.b(new zzb(status, credential));
    }

    public void zzg(Status status)
    {
        zzSG.b(zzb.zzh(status));
    }

    ( )
    {
        zzSG = ;
        super();
    }
}

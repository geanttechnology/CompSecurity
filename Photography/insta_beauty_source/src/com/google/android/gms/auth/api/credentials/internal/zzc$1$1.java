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

    final t> zzPe;

    public void onCredentialResult(Status status, Credential credential)
    {
        zzPe.tResult(new zzb(status, credential));
    }

    ( )
    {
        zzPe = ;
        super();
    }
}

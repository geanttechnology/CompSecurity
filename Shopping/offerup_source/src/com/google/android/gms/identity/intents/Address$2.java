// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.identity.intents;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzoy;

// Referenced classes of package com.google.android.gms.identity.intents:
//            UserAddressRequest

final class a extends a
{

    final UserAddressRequest zzaDf;
    final int zzaDg;

    protected final volatile void zza(com.google.android.gms.common.api.ess._cls2 _pcls2)
    {
        zza((zzoy)_pcls2);
    }

    protected final void zza(zzoy zzoy1)
    {
        zzoy1.zza(zzaDf, zzaDg);
        zzb(Status.zzabb);
    }

    sRequest(GoogleApiClient googleapiclient, UserAddressRequest useraddressrequest, int i)
    {
        zzaDf = useraddressrequest;
        zzaDg = i;
        super(googleapiclient);
    }
}

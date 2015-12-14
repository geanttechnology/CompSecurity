// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.safetynet.AttestationData;

// Referenced classes of package com.google.android.gms.internal:
//            zzps, zzpw

class  extends zzps
{

    final nData zzaNJ;

    public void zza(Status status, AttestationData attestationdata)
    {
        zzaNJ.a(new nit>(status, attestationdata));
    }

    nData(nData ndata)
    {
        zzaNJ = ndata;
        super();
    }
}

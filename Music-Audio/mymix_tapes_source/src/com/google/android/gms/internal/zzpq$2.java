// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.plus.internal.zze;

// Referenced classes of package com.google.android.gms.internal:
//            zzpq

class eApiClient extends a
{

    final zzpq zzaLF;
    final String zzaLG;
    final Uri zzaLH;
    final String zzaLI;
    final String zzaLJ;
    final int zzauY;

    protected volatile void zza(com.google.android.gms.common.api. )
        throws RemoteException
    {
        zza((zze));
    }

    protected void zza(zze zze1)
    {
        zze1.zza(this, zzauY, zzaLG, zzaLH, zzaLI, zzaLJ);
    }

    eApiClient(zzpq zzpq1, GoogleApiClient googleapiclient, int i, String s, Uri uri, String s1, String s2)
    {
        zzaLF = zzpq1;
        zzauY = i;
        zzaLG = s;
        zzaLH = uri;
        zzaLI = s1;
        zzaLJ = s2;
        super(googleapiclient, null);
    }
}

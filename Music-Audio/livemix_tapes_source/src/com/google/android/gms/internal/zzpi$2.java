// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;

// Referenced classes of package com.google.android.gms.internal:
//            zzpi, zzph

class eApiClient extends a
{

    final Uri zzaKy;
    final zzpi zzaKz;

    protected void zza(Context context, zzph zzph)
        throws RemoteException
    {
        zzpi.zzb(context, zzph, new b(this), zzaKy, null);
    }

    eApiClient(zzpi zzpi1, GoogleApiClient googleapiclient, Uri uri)
    {
        zzaKz = zzpi1;
        zzaKy = uri;
        super(googleapiclient);
    }
}

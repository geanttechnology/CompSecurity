// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;

// Referenced classes of package com.google.android.gms.internal:
//            zzpi, zzpg

static final class a extends a
{

    final zzpg zzaKA;
    final Uri zzaKy;
    final Context zzrn;

    public void zza(int i, Bundle bundle, int j, Intent intent)
        throws RemoteException
    {
        zzpi.zzb(zzrn, zzaKy);
        zzaKA.zza(i, bundle, j, intent);
    }

    a(Context context, Uri uri, zzpg zzpg1)
    {
        zzrn = context;
        zzaKy = uri;
        zzaKA = zzpg1;
        super();
    }
}

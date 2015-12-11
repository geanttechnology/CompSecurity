// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.request;

import android.content.Context;
import android.support.v7.nj;
import android.support.v7.nn;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.GooglePlayServicesUtil;

// Referenced classes of package com.google.android.gms.ads.internal.request:
//            zzc, AdRequestInfoParcel

static final class zzrn
    implements b
{

    final Context zzrn;

    public boolean zzd(AdRequestInfoParcel adrequestinfoparcel)
    {
        return adrequestinfoparcel.zzqb.zzIC || GooglePlayServicesUtil.zzag(zzrn) && !((Boolean)nn.B.c()).booleanValue();
    }

    estInfoParcel(Context context)
    {
        zzrn = context;
        super();
    }
}

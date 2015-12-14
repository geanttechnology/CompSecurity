// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.request;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.GooglePlayServicesUtil;

// Referenced classes of package com.google.android.gms.ads.internal.request:
//            zzc, AdRequestInfoParcel

final class zzqV
    implements b
{

    final Context zzqV;

    public boolean zzd(AdRequestInfoParcel adrequestinfoparcel)
    {
        return adrequestinfoparcel.zzpJ.zzGJ || GooglePlayServicesUtil.zzae(zzqV);
    }

    estInfoParcel(Context context)
    {
        zzqV = context;
        super();
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.request;

import android.content.Context;
import com.google.android.gms.internal.zzbr;
import com.google.android.gms.internal.zzbu;
import com.google.android.gms.internal.zzby;
import com.google.android.gms.internal.zzgs;
import com.google.android.gms.internal.zzgt;

// Referenced classes of package com.google.android.gms.ads.internal.request:
//            zzd, AdRequestInfoParcel, zzj

public static final class mContext extends zzd
{

    private final Context mContext;

    public void zzfH()
    {
    }

    public zzj zzfI()
    {
        zzbr zzbr1 = new zzbr((String)zzby.zzul.get());
        return zzgt.zza(mContext, zzbr1, zzgs.zzfQ());
    }

    public tInfoParcel(Context context, AdRequestInfoParcel adrequestinfoparcel, tInfoParcel tinfoparcel)
    {
        super(adrequestinfoparcel, tinfoparcel);
        mContext = context;
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.request;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzj;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.internal.zzfh;

// Referenced classes of package com.google.android.gms.ads.internal.request:
//            AdRequestInfoParcel

public final class zzc
{

    public static zzfh zza(Context context, AdRequestInfoParcel adrequestinfoparcel, zza zza1)
    {
        return zza(context, adrequestinfoparcel, zza1, new zzb() {

            public boolean zzd(AdRequestInfoParcel adrequestinfoparcel1)
            {
                return adrequestinfoparcel1.zzmJ.zzCL;
            }

        });
    }

    static zzfh zza(Context context, AdRequestInfoParcel adrequestinfoparcel, zza zza1, zzb zzb1)
    {
        if (zzb1.zzd(adrequestinfoparcel))
        {
            return zzb(context, adrequestinfoparcel, zza1);
        } else
        {
            return zzc(context, adrequestinfoparcel, zza1);
        }
    }

    private static zzfh zzb(Context context, AdRequestInfoParcel adrequestinfoparcel, zza zza1)
    {
        com.google.android.gms.ads.internal.util.client.zzb.zzaj("Fetching ad response from local ad request service.");
        context = new zzd.zza(context, adrequestinfoparcel, zza1);
        context.zzeW();
        return context;
    }

    private static zzfh zzc(Context context, AdRequestInfoParcel adrequestinfoparcel, zza zza1)
    {
        com.google.android.gms.ads.internal.util.client.zzb.zzaj("Fetching ad response from remote ad request service.");
        if (!zzj.zzbJ().zzD(context))
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzan("Failed to connect to remote ad request service.");
            return null;
        } else
        {
            return new zzd.zzb(context, adrequestinfoparcel, zza1);
        }
    }

    private class zzb
    {

        public abstract boolean zzd(AdRequestInfoParcel adrequestinfoparcel);
    }

}

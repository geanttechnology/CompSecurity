// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzn;

// Referenced classes of package com.google.android.gms.internal:
//            zzgk, zzgh, zzgl, zzbc, 
//            zzge, zzby, zzbu, zzmx, 
//            zziz, zzgj, zzgi, zzan, 
//            zzem, zzcg

public class zzgg
{

    public zzgg()
    {
    }

    public zzgh zza(Context context, zza zza1, zzhs.zza zza2, zzan zzan, zziz zziz1, zzem zzem, zza zza3, 
            zzcg zzcg)
    {
        AdResponseParcel adresponseparcel = zza2.zzHD;
        if (adresponseparcel.zzEK)
        {
            context = new zzgk(context, zza2, zzem, zza3, zzcg);
        } else
        if (adresponseparcel.zzth)
        {
            if (zza1 instanceof zzn)
            {
                context = new zzgl(context, (zzn)zza1, new zzbc(), zza2, zzan, zza3);
            } else
            {
                zza2 = (new StringBuilder()).append("Invalid NativeAdManager type. Found: ");
                if (zza1 != null)
                {
                    context = zza1.getClass().getName();
                } else
                {
                    context = "null";
                }
                throw new IllegalArgumentException(zza2.append(context).append("; Required: NativeAdManager.").toString());
            }
        } else
        if (adresponseparcel.zzEQ)
        {
            context = new zzge(context, zza2, zziz1, zza3);
        } else
        if (((Boolean)zzby.zzvb.get()).booleanValue() && zzmx.zzqB() && !zzmx.isAtLeastL() && zziz1.zzaN().zztf)
        {
            context = new zzgj(context, zza2, zziz1, zza3);
        } else
        {
            context = new zzgi(context, zza2, zziz1, zza3);
        }
        zzb.zzaF((new StringBuilder()).append("AdRenderer: ").append(context.getClass().getName()).toString());
        context.zzfu();
        return context;
    }

    // Unreferenced inner class com/google/android/gms/internal/zzgg$zza
    /* block-local class not found */
    class zza {}

}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzn;

// Referenced classes of package android.support.v7:
//            rx, tl, ry, mr, 
//            rr, nn, nj, vs, 
//            ul, rw, rv, mc, 
//            pz, nt, te

public class ru
{
    public static interface a
    {

        public abstract void zzb(te te);
    }


    public ru()
    {
    }

    public tl a(Context context, zza zza, te.a a1, mc mc, ul ul1, pz pz, a a2, 
            nt nt)
    {
        AdResponseParcel adresponseparcel = a1.b;
        if (adresponseparcel.zzDX)
        {
            context = new rx(context, a1, ul1, pz, a2, nt);
        } else
        if (adresponseparcel.zzsJ)
        {
            if (zza instanceof zzn)
            {
                context = new ry(context, (zzn)zza, new mr(), a1, mc, a2);
            } else
            {
                a1 = (new StringBuilder()).append("Invalid NativeAdManager type. Found: ");
                if (zza != null)
                {
                    context = zza.getClass().getName();
                } else
                {
                    context = "null";
                }
                throw new IllegalArgumentException(a1.append(context).append("; Required: NativeAdManager.").toString());
            }
        } else
        if (adresponseparcel.zzEd)
        {
            context = new rr(context, a1, ul1, a2);
        } else
        if (((Boolean)nn.R.c()).booleanValue() && vs.g() && !vs.i() && ul1.h().zzsH)
        {
            context = new rw(context, a1, ul1, a2);
        } else
        {
            context = new rv(context, a1, ul1, a2);
        }
        zzb.zzaC((new StringBuilder()).append("AdRenderer: ").append(context.getClass().getName()).toString());
        context.zzgo();
        return context;
    }
}

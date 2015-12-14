// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.request;

import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.internal.zzbe;
import com.google.android.gms.internal.zzdl;

// Referenced classes of package com.google.android.gms.ads.internal.request:
//            zzl

class zzDp
    implements com.google.android.gms.internal.
{

    final zzb zzDp;

    public void zzb(zzbe zzbe1)
    {
        try
        {
            zzbe1.zza("AFMA_getAdapterLessMediationAd", zzDp.Dn);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (zzbe zzbe1)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzb("Error requesting an ad url", zzbe1);
        }
        zzl.zzfz().zzV(zzDp.Do);
    }

    public void zzc(Object obj)
    {
        zzb((zzbe)obj);
    }

    _cls9(_cls9 _pcls9)
    {
        zzDp = _pcls9;
        super();
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.ads.internal.client.zzg;
import com.google.android.gms.ads.internal.client.zzo;
import com.google.android.gms.ads.internal.client.zzx;
import com.google.android.gms.ads.internal.util.client.zzb;

// Referenced classes of package com.google.android.gms.ads:
//            AdRequest

public class AdLoader
{

    private final Context mContext;
    private final zzg zznH;
    private final zzo zznI;

    AdLoader(Context context, zzo zzo1)
    {
        this(context, zzo1, zzg.zzcw());
    }

    AdLoader(Context context, zzo zzo1, zzg zzg1)
    {
        mContext = context;
        zznI = zzo1;
        zznH = zzg1;
    }

    private void zza(zzx zzx)
    {
        try
        {
            zznI.zze(zznH.zza(mContext, zzx));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (zzx zzx)
        {
            zzb.zzb("Failed to load ad.", zzx);
        }
    }

    public void loadAd(AdRequest adrequest)
    {
        zza(adrequest.zzaF());
    }

    public void loadAd(PublisherAdRequest publisheradrequest)
    {
        zza(publisheradrequest.zzaF());
    }
}

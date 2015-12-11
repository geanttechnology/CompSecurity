// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzc;
import com.google.android.gms.ads.internal.client.zzd;
import com.google.android.gms.ads.internal.client.zzp;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.internal.zzcz;
import com.google.android.gms.internal.zzda;
import com.google.android.gms.internal.zzee;

// Referenced classes of package com.google.android.gms.ads:
//            AdLoader, AdListener

public static class zd.zza
{

    private final Context mContext;
    private final zzp zznJ;

    public AdLoader build()
    {
        AdLoader adloader;
        try
        {
            adloader = new AdLoader(mContext, zznJ.zzbi());
        }
        catch (RemoteException remoteexception)
        {
            zzb.zzb("Failed to build AdLoader.", remoteexception);
            return null;
        }
        return adloader;
    }

    public stallAdLoadedListener forAppInstallAd(com.google.android.gms.ads.formats.d.OnAppInstallAdLoadedListener onappinstalladloadedlistener)
    {
        try
        {
            zznJ.zza(new zzcz(onappinstalladloadedlistener));
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.ads.formats.d.OnAppInstallAdLoadedListener onappinstalladloadedlistener)
        {
            zzb.zzd("Failed to add app install ad listener", onappinstalladloadedlistener);
            return this;
        }
        return this;
    }

    public dLoadedListener forContentAd(com.google.android.gms.ads.formats.nContentAdLoadedListener ncontentadloadedlistener)
    {
        try
        {
            zznJ.zza(new zzda(ncontentadloadedlistener));
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.ads.formats.nContentAdLoadedListener ncontentadloadedlistener)
        {
            zzb.zzd("Failed to add content ad listener", ncontentadloadedlistener);
            return this;
        }
        return this;
    }

    public ent.zzb.zzd withAdListener(AdListener adlistener)
    {
        try
        {
            zznJ.zzb(new zzc(adlistener));
        }
        // Misplaced declaration of an exception variable
        catch (AdListener adlistener)
        {
            zzb.zzd("Failed to set AdListener.", adlistener);
            return this;
        }
        return this;
    }

    zp(Context context, zzp zzp1)
    {
        mContext = context;
        zznJ = zzp1;
    }

    public zp(Context context, String s)
    {
        this(context, zzd.zza(context, s, new zzee()));
    }
}

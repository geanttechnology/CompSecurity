// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;


// Referenced classes of package com.google.android.gms.internal:
//            zzct, zzcs

public class zzdc extends zzcx.zza
{

    private final com.google.android.gms.ads.formats.NativeContentAd.OnContentAdLoadedListener zzxk;

    public zzdc(com.google.android.gms.ads.formats.NativeContentAd.OnContentAdLoadedListener oncontentadloadedlistener)
    {
        zzxk = oncontentadloadedlistener;
    }

    public void zza(zzcs zzcs)
    {
        zzxk.onContentAdLoaded(zzb(zzcs));
    }

    zzct zzb(zzcs zzcs)
    {
        return new zzct(zzcs);
    }
}

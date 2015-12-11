// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;


// Referenced classes of package com.google.android.gms.internal:
//            zzcv, zzcu

public class zzde extends zzcz.zza
{

    private final com.google.android.gms.ads.formats.NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener zzxm;

    public zzde(com.google.android.gms.ads.formats.NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener oncustomtemplateadloadedlistener)
    {
        zzxm = oncustomtemplateadloadedlistener;
    }

    public void zza(zzcu zzcu)
    {
        zzxm.onCustomTemplateAdLoaded(new zzcv(zzcu));
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;


// Referenced classes of package com.google.android.gms.internal:
//            zzcv, zzcu

public class zzdd extends zzcy.zza
{

    private final com.google.android.gms.ads.formats.NativeCustomTemplateAd.OnCustomClickListener zzxl;

    public zzdd(com.google.android.gms.ads.formats.NativeCustomTemplateAd.OnCustomClickListener oncustomclicklistener)
    {
        zzxl = oncustomclicklistener;
    }

    public void zza(zzcu zzcu, String s)
    {
        zzxl.onCustomClick(new zzcv(zzcu), s);
    }
}

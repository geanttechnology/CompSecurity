// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.IInterface;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.dynamic.zzd;

// Referenced classes of package com.google.android.gms.internal:
//            zzct

public interface zzcs
    extends IInterface
{

    public abstract void destroy();

    public abstract zzd getView();

    public abstract void pause();

    public abstract void resume();

    public abstract void showInterstitial();

    public abstract void zza(zzd zzd, AdRequestParcel adrequestparcel, String s, zzct zzct);

    public abstract void zza(zzd zzd, AdRequestParcel adrequestparcel, String s, String s1, zzct zzct);

    public abstract void zza(zzd zzd, AdSizeParcel adsizeparcel, AdRequestParcel adrequestparcel, String s, zzct zzct);

    public abstract void zza(zzd zzd, AdSizeParcel adsizeparcel, AdRequestParcel adrequestparcel, String s, String s1, zzct zzct);
}

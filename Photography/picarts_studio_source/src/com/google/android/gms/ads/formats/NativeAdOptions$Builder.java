// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.formats;


// Referenced classes of package com.google.android.gms.ads.formats:
//            NativeAdOptions

public final class zznY
{

    private boolean zznW;
    private int zznX;
    private boolean zznY;

    static boolean zza(zznY zzny)
    {
        return zzny.zznW;
    }

    static int zzb(zznW zznw)
    {
        return zznw.zznX;
    }

    static boolean zzc(zznX zznx)
    {
        return zznx.zznY;
    }

    public final NativeAdOptions build()
    {
        return new NativeAdOptions(this, null);
    }

    public final zznY setImageOrientation(int i)
    {
        zznX = i;
        return this;
    }

    public final zznX setRequestMultipleImages(boolean flag)
    {
        zznY = flag;
        return this;
    }

    public final zznY setReturnUrlsForImageAssets(boolean flag)
    {
        zznW = flag;
        return this;
    }

    public ()
    {
        zznW = false;
        zznX = 0;
        zznY = false;
    }
}

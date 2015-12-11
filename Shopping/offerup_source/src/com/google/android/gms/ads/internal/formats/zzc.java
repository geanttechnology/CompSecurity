// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.formats;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;

public class zzc extends com.google.android.gms.internal.zzcm.zza
{

    private final Uri mUri;
    private final Drawable zzwm;
    private final double zzwn;

    public zzc(Drawable drawable, Uri uri, double d)
    {
        zzwm = drawable;
        mUri = uri;
        zzwn = d;
    }

    public double getScale()
    {
        return zzwn;
    }

    public Uri getUri()
    {
        return mUri;
    }

    public zzd zzdv()
    {
        return zze.zzy(zzwm);
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import android.content.Context;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.d;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

// Referenced classes of package com.google.android.gms.d:
//            hh, o, he

public final class hg
{

    public hg()
    {
    }

    public static he a(Context context, AdSizeParcel adsizeparcel, o o, VersionInfoParcel versioninfoparcel, d d)
    {
        return hh.a(context, adsizeparcel, false, false, o, versioninfoparcel, d);
    }

    public static he a(Context context, AdSizeParcel adsizeparcel, boolean flag, boolean flag1, o o, VersionInfoParcel versioninfoparcel)
    {
        return hh.a(context, adsizeparcel, flag, flag1, o, versioninfoparcel, null);
    }
}

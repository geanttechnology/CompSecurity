// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.ads.AdSize;
import com.google.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.zza;
import java.util.Date;
import java.util.HashSet;

public final class zzeu
{

    public static int zza(com.google.ads.AdRequest.ErrorCode errorcode)
    {
    /* anonymous class not found */
    class _anm1 {}

        switch (_cls1.zzzh[errorcode.ordinal()])
        {
        default:
            return 0;

        case 2: // '\002'
            return 1;

        case 3: // '\003'
            return 2;

        case 4: // '\004'
            return 3;
        }
    }

    public static AdSize zzb(AdSizeParcel adsizeparcel)
    {
        int i = 0;
        AdSize aadsize[] = new AdSize[6];
        aadsize[0] = AdSize.SMART_BANNER;
        aadsize[1] = AdSize.BANNER;
        aadsize[2] = AdSize.IAB_MRECT;
        aadsize[3] = AdSize.IAB_BANNER;
        aadsize[4] = AdSize.IAB_LEADERBOARD;
        aadsize[5] = AdSize.IAB_WIDE_SKYSCRAPER;
        for (; i < aadsize.length; i++)
        {
            if (aadsize[i].getWidth() == adsizeparcel.width && aadsize[i].getHeight() == adsizeparcel.height)
            {
                return aadsize[i];
            }
        }

        return new AdSize(com.google.android.gms.ads.zza.zza(adsizeparcel.width, adsizeparcel.height, adsizeparcel.zzsG));
    }

    public static MediationAdRequest zzg(AdRequestParcel adrequestparcel)
    {
        HashSet hashset;
        if (adrequestparcel.zzss != null)
        {
            hashset = new HashSet(adrequestparcel.zzss);
        } else
        {
            hashset = null;
        }
        return new MediationAdRequest(new Date(adrequestparcel.zzsq), zzr(adrequestparcel.zzsr), hashset, adrequestparcel.zzst, adrequestparcel.zzsy);
    }

    public static com.google.ads.AdRequest.Gender zzr(int i)
    {
        switch (i)
        {
        default:
            return com.google.ads.AdRequest.Gender.UNKNOWN;

        case 2: // '\002'
            return com.google.ads.AdRequest.Gender.FEMALE;

        case 1: // '\001'
            return com.google.ads.AdRequest.Gender.MALE;
        }
    }
}

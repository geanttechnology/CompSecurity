// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import com.google.ads.AdSize;
import com.google.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.g;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import java.util.Date;
import java.util.HashSet;

public final class dt
{

    public static int a(com.google.ads.AdRequest.ErrorCode errorcode)
    {
        static final class _cls1
        {

            static final int a[];
            static final int b[];

            static 
            {
                b = new int[com.google.ads.AdRequest.ErrorCode.values().length];
                try
                {
                    b[com.google.ads.AdRequest.ErrorCode.INTERNAL_ERROR.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    b[com.google.ads.AdRequest.ErrorCode.INVALID_REQUEST.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    b[com.google.ads.AdRequest.ErrorCode.NETWORK_ERROR.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    b[com.google.ads.AdRequest.ErrorCode.NO_FILL.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                a = new int[com.google.ads.AdRequest.Gender.values().length];
                try
                {
                    a[com.google.ads.AdRequest.Gender.FEMALE.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[com.google.ads.AdRequest.Gender.MALE.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[com.google.ads.AdRequest.Gender.UNKNOWN.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1.b[errorcode.ordinal()])
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

    public static AdSize a(AdSizeParcel adsizeparcel)
    {
        int i = 0;
        AdSize aadsize[] = new AdSize[6];
        aadsize[0] = AdSize.SMART_BANNER;
        aadsize[1] = AdSize.BANNER;
        aadsize[2] = AdSize.IAB_MRECT;
        aadsize[3] = AdSize.IAB_BANNER;
        aadsize[4] = AdSize.IAB_LEADERBOARD;
        aadsize[5] = AdSize.IAB_WIDE_SKYSCRAPER;
        for (; i < 6; i++)
        {
            if (aadsize[i].getWidth() == adsizeparcel.f && aadsize[i].getHeight() == adsizeparcel.c)
            {
                return aadsize[i];
            }
        }

        return new AdSize(g.a(adsizeparcel.f, adsizeparcel.c, adsizeparcel.b));
    }

    public static MediationAdRequest a(AdRequestParcel adrequestparcel)
    {
        com.google.ads.AdRequest.Gender gender;
        HashSet hashset;
        Date date;
        if (adrequestparcel.e != null)
        {
            hashset = new HashSet(adrequestparcel.e);
        } else
        {
            hashset = null;
        }
        date = new Date(adrequestparcel.b);
        adrequestparcel.d;
        JVM INSTR tableswitch 1 2: default 56
    //                   1 91
    //                   2 84;
           goto _L1 _L2 _L3
_L1:
        gender = com.google.ads.AdRequest.Gender.UNKNOWN;
_L5:
        return new MediationAdRequest(date, gender, hashset, adrequestparcel.f, adrequestparcel.k);
_L3:
        gender = com.google.ads.AdRequest.Gender.FEMALE;
        continue; /* Loop/switch isn't completed */
_L2:
        gender = com.google.ads.AdRequest.Gender.MALE;
        if (true) goto _L5; else goto _L4
_L4:
    }
}

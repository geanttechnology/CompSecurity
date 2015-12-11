// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.ads.AdSize;
import com.google.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.a;
import java.util.Date;
import java.util.HashSet;

// Referenced classes of package com.google.android.gms.internal:
//            ak, ah

public final class by
{

    public static AdSize b(ak ak1)
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
            if (aadsize[i].getWidth() == ak1.width && aadsize[i].getHeight() == ak1.height)
            {
                return aadsize[i];
            }
        }

        return new AdSize(a.a(ak1.width, ak1.height, ak1.lS));
    }

    public static MediationAdRequest e(ah ah1)
    {
        HashSet hashset;
        if (ah1.lJ != null)
        {
            hashset = new HashSet(ah1.lJ);
        } else
        {
            hashset = null;
        }
        return new MediationAdRequest(new Date(ah1.lH), g(ah1.lI), hashset, ah1.lK, ah1.lP);
    }

    public static com.google.ads.AdRequest.Gender g(int i)
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

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sponsorpay.mediation;


public final class SPMediationAdFormat extends Enum
{

    private static final SPMediationAdFormat ENUM$VALUES[];
    public static final SPMediationAdFormat Interstitial;
    public static final SPMediationAdFormat RewardedVideo;

    private SPMediationAdFormat(String s, int i)
    {
        super(s, i);
    }

    public static SPMediationAdFormat valueOf(String s)
    {
        return (SPMediationAdFormat)Enum.valueOf(com/sponsorpay/mediation/SPMediationAdFormat, s);
    }

    public static SPMediationAdFormat[] values()
    {
        SPMediationAdFormat aspmediationadformat[] = ENUM$VALUES;
        int i = aspmediationadformat.length;
        SPMediationAdFormat aspmediationadformat1[] = new SPMediationAdFormat[i];
        System.arraycopy(aspmediationadformat, 0, aspmediationadformat1, 0, i);
        return aspmediationadformat1;
    }

    static 
    {
        RewardedVideo = new SPMediationAdFormat("RewardedVideo", 0);
        Interstitial = new SPMediationAdFormat("Interstitial", 1);
        ENUM$VALUES = (new SPMediationAdFormat[] {
            RewardedVideo, Interstitial
        });
    }
}

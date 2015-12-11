// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sponsorpay.publisher.mbe.mediation;


public final class SPTPNVideoValidationResult extends Enum
{

    private static final SPTPNVideoValidationResult ENUM$VALUES[];
    public static final SPTPNVideoValidationResult SPTPNValidationAdapterNotIntegrated;
    public static final SPTPNVideoValidationResult SPTPNValidationDiskError;
    public static final SPTPNVideoValidationResult SPTPNValidationError;
    public static final SPTPNVideoValidationResult SPTPNValidationNetworkError;
    public static final SPTPNVideoValidationResult SPTPNValidationNoVideoAvailable;
    public static final SPTPNVideoValidationResult SPTPNValidationSuccess;
    public static final SPTPNVideoValidationResult SPTPNValidationTimeout;
    private final String text;

    private SPTPNVideoValidationResult(String s, int i, String s1)
    {
        super(s, i);
        text = s1;
    }

    public static SPTPNVideoValidationResult valueOf(String s)
    {
        return (SPTPNVideoValidationResult)Enum.valueOf(com/sponsorpay/publisher/mbe/mediation/SPTPNVideoValidationResult, s);
    }

    public static SPTPNVideoValidationResult[] values()
    {
        SPTPNVideoValidationResult asptpnvideovalidationresult[] = ENUM$VALUES;
        int i = asptpnvideovalidationresult.length;
        SPTPNVideoValidationResult asptpnvideovalidationresult1[] = new SPTPNVideoValidationResult[i];
        System.arraycopy(asptpnvideovalidationresult, 0, asptpnvideovalidationresult1, 0, i);
        return asptpnvideovalidationresult1;
    }

    public String toString()
    {
        return text;
    }

    static 
    {
        SPTPNValidationAdapterNotIntegrated = new SPTPNVideoValidationResult("SPTPNValidationAdapterNotIntegrated", 0, "no_sdk");
        SPTPNValidationNoVideoAvailable = new SPTPNVideoValidationResult("SPTPNValidationNoVideoAvailable", 1, "no_video");
        SPTPNValidationTimeout = new SPTPNVideoValidationResult("SPTPNValidationTimeout", 2, "timeout");
        SPTPNValidationNetworkError = new SPTPNVideoValidationResult("SPTPNValidationNetworkError", 3, "network_error");
        SPTPNValidationDiskError = new SPTPNVideoValidationResult("SPTPNValidationDiskError", 4, "disk_error");
        SPTPNValidationError = new SPTPNVideoValidationResult("SPTPNValidationError", 5, "error");
        SPTPNValidationSuccess = new SPTPNVideoValidationResult("SPTPNValidationSuccess", 6, "success");
        ENUM$VALUES = (new SPTPNVideoValidationResult[] {
            SPTPNValidationAdapterNotIntegrated, SPTPNValidationNoVideoAvailable, SPTPNValidationTimeout, SPTPNValidationNetworkError, SPTPNValidationDiskError, SPTPNValidationError, SPTPNValidationSuccess
        });
    }
}

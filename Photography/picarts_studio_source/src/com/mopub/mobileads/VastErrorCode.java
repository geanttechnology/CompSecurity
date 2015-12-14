// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import com.mopub.common.Preconditions;

public final class VastErrorCode extends Enum
{

    private static final VastErrorCode $VALUES[];
    public static final VastErrorCode GENERAL_COMPANION_AD_ERROR;
    public static final VastErrorCode GENERAL_LINEAR_AD_ERROR;
    public static final VastErrorCode NO_ADS_VAST_RESPONSE;
    public static final VastErrorCode UNDEFINED_ERROR;
    public static final VastErrorCode WRAPPER_TIMEOUT;
    public static final VastErrorCode XML_PARSING_ERROR;
    private final String mErrorCode;

    private VastErrorCode(String s, int i, String s1)
    {
        super(s, i);
        Preconditions.checkNotNull(s1, "errorCode cannot be null");
        mErrorCode = s1;
    }

    public static VastErrorCode valueOf(String s)
    {
        return (VastErrorCode)Enum.valueOf(com/mopub/mobileads/VastErrorCode, s);
    }

    public static VastErrorCode[] values()
    {
        return (VastErrorCode[])$VALUES.clone();
    }

    final String getErrorCode()
    {
        return mErrorCode;
    }

    static 
    {
        XML_PARSING_ERROR = new VastErrorCode("XML_PARSING_ERROR", 0, "100");
        WRAPPER_TIMEOUT = new VastErrorCode("WRAPPER_TIMEOUT", 1, "301");
        NO_ADS_VAST_RESPONSE = new VastErrorCode("NO_ADS_VAST_RESPONSE", 2, "303");
        GENERAL_LINEAR_AD_ERROR = new VastErrorCode("GENERAL_LINEAR_AD_ERROR", 3, "400");
        GENERAL_COMPANION_AD_ERROR = new VastErrorCode("GENERAL_COMPANION_AD_ERROR", 4, "600");
        UNDEFINED_ERROR = new VastErrorCode("UNDEFINED_ERROR", 5, "900");
        $VALUES = (new VastErrorCode[] {
            XML_PARSING_ERROR, WRAPPER_TIMEOUT, NO_ADS_VAST_RESPONSE, GENERAL_LINEAR_AD_ERROR, GENERAL_COMPANION_AD_ERROR, UNDEFINED_ERROR
        });
    }
}

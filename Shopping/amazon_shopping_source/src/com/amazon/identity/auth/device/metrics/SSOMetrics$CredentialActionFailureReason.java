// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.metrics;


// Referenced classes of package com.amazon.identity.auth.device.metrics:
//            SSOMetrics

public static final class mName extends Enum
{

    private static final UnrecognizedFailure $VALUES[];
    public static final UnrecognizedFailure DidnotReturnAuthToken;
    public static final UnrecognizedFailure RequestTimeOut;
    public static final UnrecognizedFailure UnrecognizedFailure;
    private final String mName;

    public static mName valueOf(String s)
    {
        return (mName)Enum.valueOf(com/amazon/identity/auth/device/metrics/SSOMetrics$CredentialActionFailureReason, s);
    }

    public static mName[] values()
    {
        return (mName[])$VALUES.clone();
    }

    public String getName()
    {
        return mName;
    }

    static 
    {
        RequestTimeOut = new <init>("RequestTimeOut", 0, "RequestTimeOut");
        DidnotReturnAuthToken = new <init>("DidnotReturnAuthToken", 1, "DidnotReturnAuthToken");
        UnrecognizedFailure = new <init>("UnrecognizedFailure", 2, "UnrecognizedFailure");
        $VALUES = (new .VALUES[] {
            RequestTimeOut, DidnotReturnAuthToken, UnrecognizedFailure
        });
    }

    private (String s, int i, String s1)
    {
        super(s, i);
        mName = s1;
    }
}

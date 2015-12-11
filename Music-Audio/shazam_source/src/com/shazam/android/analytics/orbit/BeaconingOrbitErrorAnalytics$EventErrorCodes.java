// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.analytics.orbit;


// Referenced classes of package com.shazam.android.analytics.orbit:
//            BeaconingOrbitErrorAnalytics

public static final class errorCode extends Enum
{

    private static final INTERNAL_SERVER $VALUES[];
    public static final INTERNAL_SERVER BAD_SERVER_RESPONSE;
    public static final INTERNAL_SERVER INTERNAL_SERVER;
    private final String errorCode;

    public static errorCode valueOf(String s)
    {
        return (errorCode)Enum.valueOf(com/shazam/android/analytics/orbit/BeaconingOrbitErrorAnalytics$EventErrorCodes, s);
    }

    public static errorCode[] values()
    {
        return (errorCode[])$VALUES.clone();
    }

    public final String getErrorCode()
    {
        return errorCode;
    }

    static 
    {
        BAD_SERVER_RESPONSE = new <init>("BAD_SERVER_RESPONSE", 0, "badserverresponse");
        INTERNAL_SERVER = new <init>("INTERNAL_SERVER", 1, "internalservererror");
        $VALUES = (new .VALUES[] {
            BAD_SERVER_RESPONSE, INTERNAL_SERVER
        });
    }

    private (String s, int i, String s1)
    {
        super(s, i);
        errorCode = s1;
    }
}

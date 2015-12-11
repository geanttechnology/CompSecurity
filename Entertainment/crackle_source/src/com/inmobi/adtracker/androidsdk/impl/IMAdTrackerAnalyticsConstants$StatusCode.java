// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.adtracker.androidsdk.impl;


// Referenced classes of package com.inmobi.adtracker.androidsdk.impl:
//            IMAdTrackerAnalyticsConstants

public static final class  extends Enum
{

    public static final APP_NOT_CONNECTED APP_ANALYTICS_PREVIOUSLY_UPLOADED;
    public static final APP_NOT_CONNECTED APP_ANALYTICS_UPLOAD_FAILURE;
    public static final APP_NOT_CONNECTED APP_ANALYTICS_UPLOAD_SUCCESS;
    public static final APP_NOT_CONNECTED APP_CONTEXT_NULL;
    public static final APP_NOT_CONNECTED APP_NOT_CONNECTED;
    private static final APP_NOT_CONNECTED ENUM$VALUES[];
    public static final APP_NOT_CONNECTED ODIN1_NULL;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/inmobi/adtracker/androidsdk/impl/IMAdTrackerAnalyticsConstants$StatusCode, s);
    }

    public static [] values()
    {
         a[] = ENUM$VALUES;
        int i = a.length;
         a1[] = new ENUM.VALUES[i];
        System.arraycopy(a, 0, a1, 0, i);
        return a1;
    }

    static 
    {
        APP_ANALYTICS_UPLOAD_SUCCESS = new <init>("APP_ANALYTICS_UPLOAD_SUCCESS", 0);
        APP_CONTEXT_NULL = new <init>("APP_CONTEXT_NULL", 1);
        APP_ANALYTICS_PREVIOUSLY_UPLOADED = new <init>("APP_ANALYTICS_PREVIOUSLY_UPLOADED", 2);
        ODIN1_NULL = new <init>("ODIN1_NULL", 3);
        APP_ANALYTICS_UPLOAD_FAILURE = new <init>("APP_ANALYTICS_UPLOAD_FAILURE", 4);
        APP_NOT_CONNECTED = new <init>("APP_NOT_CONNECTED", 5);
        ENUM$VALUES = (new ENUM.VALUES[] {
            APP_ANALYTICS_UPLOAD_SUCCESS, APP_CONTEXT_NULL, APP_ANALYTICS_PREVIOUSLY_UPLOADED, ODIN1_NULL, APP_ANALYTICS_UPLOAD_FAILURE, APP_NOT_CONNECTED
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}

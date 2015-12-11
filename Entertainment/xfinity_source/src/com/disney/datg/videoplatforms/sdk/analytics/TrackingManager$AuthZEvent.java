// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.disney.datg.videoplatforms.sdk.analytics;


// Referenced classes of package com.disney.datg.videoplatforms.sdk.analytics:
//            TrackingManager

public static final class  extends Enum
{

    private static final AUTH_Z_FAILED $VALUES[];
    public static final AUTH_Z_FAILED AUTH_Z_FAILED;
    public static final AUTH_Z_FAILED AUTH_Z_STARTED;
    public static final AUTH_Z_FAILED AUTH_Z_SUCCESS;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AuthZEvent, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        AUTH_Z_STARTED = new <init>("AUTH_Z_STARTED", 0);
        AUTH_Z_SUCCESS = new <init>("AUTH_Z_SUCCESS", 1);
        AUTH_Z_FAILED = new <init>("AUTH_Z_FAILED", 2);
        $VALUES = (new .VALUES[] {
            AUTH_Z_STARTED, AUTH_Z_SUCCESS, AUTH_Z_FAILED
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}

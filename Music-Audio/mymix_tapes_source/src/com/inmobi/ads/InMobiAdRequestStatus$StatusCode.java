// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.ads;


// Referenced classes of package com.inmobi.ads:
//            InMobiAdRequestStatus

public static final class  extends Enum
{

    private static final EARLY_REFRESH_REQUEST $VALUES[];
    public static final EARLY_REFRESH_REQUEST AD_ACTIVE;
    public static final EARLY_REFRESH_REQUEST EARLY_REFRESH_REQUEST;
    public static final EARLY_REFRESH_REQUEST INTERNAL_ERROR;
    public static final EARLY_REFRESH_REQUEST NETWORK_UNREACHABLE;
    public static final EARLY_REFRESH_REQUEST NO_FILL;
    public static final EARLY_REFRESH_REQUEST REQUEST_INVALID;
    public static final EARLY_REFRESH_REQUEST REQUEST_PENDING;
    public static final EARLY_REFRESH_REQUEST REQUEST_TIMED_OUT;
    public static final EARLY_REFRESH_REQUEST SERVER_ERROR;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/inmobi/ads/InMobiAdRequestStatus$StatusCode, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        NETWORK_UNREACHABLE = new <init>("NETWORK_UNREACHABLE", 0);
        NO_FILL = new <init>("NO_FILL", 1);
        REQUEST_INVALID = new <init>("REQUEST_INVALID", 2);
        REQUEST_PENDING = new <init>("REQUEST_PENDING", 3);
        REQUEST_TIMED_OUT = new <init>("REQUEST_TIMED_OUT", 4);
        INTERNAL_ERROR = new <init>("INTERNAL_ERROR", 5);
        SERVER_ERROR = new <init>("SERVER_ERROR", 6);
        AD_ACTIVE = new <init>("AD_ACTIVE", 7);
        EARLY_REFRESH_REQUEST = new <init>("EARLY_REFRESH_REQUEST", 8);
        $VALUES = (new .VALUES[] {
            NETWORK_UNREACHABLE, NO_FILL, REQUEST_INVALID, REQUEST_PENDING, REQUEST_TIMED_OUT, INTERNAL_ERROR, SERVER_ERROR, AD_ACTIVE, EARLY_REFRESH_REQUEST
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}

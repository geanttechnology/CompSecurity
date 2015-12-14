// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.log;


final class  extends Enum
{

    private static final UNKNOWN $VALUES[];
    public static final UNKNOWN INVALID;
    public static final UNKNOWN UNKNOWN;
    public static final UNKNOWN VALID;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/socialin/android/apiv3/log/EventLoggingService$Result, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        VALID = new <init>("VALID", 0);
        INVALID = new <init>("INVALID", 1);
        UNKNOWN = new <init>("UNKNOWN", 2);
        $VALUES = (new .VALUES[] {
            VALID, INVALID, UNKNOWN
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}

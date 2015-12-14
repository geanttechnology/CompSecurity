// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mixtape.upload;


// Referenced classes of package com.amazon.mixtape.upload:
//            MixtapeBlockers

public static final class  extends Enum
{

    private static final FORBIDDEN $VALUES[];
    public static final FORBIDDEN CONFLICT;
    public static final FORBIDDEN FILE_NOT_FOUND;
    public static final FORBIDDEN FORBIDDEN;
    public static final FORBIDDEN INSUFFICIENT_STORAGE;
    public static final FORBIDDEN INVALID_PARAMETER;
    public static final FORBIDDEN NO_ACTIVE_SUBSCRIPTION_FOUND;
    public static final FORBIDDEN RETRY_LIMIT;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/mixtape/upload/MixtapeBlockers$RequestBlockers, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        FILE_NOT_FOUND = new <init>("FILE_NOT_FOUND", 0);
        CONFLICT = new <init>("CONFLICT", 1);
        RETRY_LIMIT = new <init>("RETRY_LIMIT", 2);
        INSUFFICIENT_STORAGE = new <init>("INSUFFICIENT_STORAGE", 3);
        INVALID_PARAMETER = new <init>("INVALID_PARAMETER", 4);
        NO_ACTIVE_SUBSCRIPTION_FOUND = new <init>("NO_ACTIVE_SUBSCRIPTION_FOUND", 5);
        FORBIDDEN = new <init>("FORBIDDEN", 6);
        $VALUES = (new .VALUES[] {
            FILE_NOT_FOUND, CONFLICT, RETRY_LIMIT, INSUFFICIENT_STORAGE, INVALID_PARAMETER, NO_ACTIVE_SUBSCRIPTION_FOUND, FORBIDDEN
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}

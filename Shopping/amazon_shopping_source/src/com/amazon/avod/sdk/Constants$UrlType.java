// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.avod.sdk;


// Referenced classes of package com.amazon.avod.sdk:
//            Constants

public static final class  extends Enum
{

    private static final CONTENT $VALUES[];
    public static final CONTENT CONTENT;
    public static final CONTENT TRAILER;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/avod/sdk/Constants$UrlType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        TRAILER = new <init>("TRAILER", 0);
        CONTENT = new <init>("CONTENT", 1);
        $VALUES = (new .VALUES[] {
            TRAILER, CONTENT
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}

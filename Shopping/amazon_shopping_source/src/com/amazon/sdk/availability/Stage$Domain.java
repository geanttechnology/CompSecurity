// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.sdk.availability;


// Referenced classes of package com.amazon.sdk.availability:
//            Stage

public static final class  extends Enum
{

    private static final MASTER $VALUES[];
    public static final MASTER MASTER;
    public static final MASTER PROD;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/sdk/availability/Stage$Domain, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        PROD = new <init>("PROD", 0);
        MASTER = new <init>("MASTER", 1);
        $VALUES = (new .VALUES[] {
            PROD, MASTER
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.insights.abtest;


// Referenced classes of package com.amazon.insights.abtest:
//            DefaultVariation

public static final class  extends Enum
{

    private static final DEFAULT $VALUES[];
    public static final DEFAULT CACHE;
    public static final DEFAULT DEFAULT;
    public static final DEFAULT SERVER;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/insights/abtest/DefaultVariation$AllocationSource, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        SERVER = new <init>("SERVER", 0);
        CACHE = new <init>("CACHE", 1);
        DEFAULT = new <init>("DEFAULT", 2);
        $VALUES = (new .VALUES[] {
            SERVER, CACHE, DEFAULT
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}

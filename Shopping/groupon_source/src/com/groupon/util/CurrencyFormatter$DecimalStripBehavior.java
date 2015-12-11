// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;


// Referenced classes of package com.groupon.util:
//            CurrencyFormatter

public static final class  extends Enum
{

    private static final Always $VALUES[];
    public static final Always Always;
    public static final Always Never;
    public static final Always OnlyIfZero;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/groupon/util/CurrencyFormatter$DecimalStripBehavior, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        Never = new <init>("Never", 0);
        OnlyIfZero = new <init>("OnlyIfZero", 1);
        Always = new <init>("Always", 2);
        $VALUES = (new .VALUES[] {
            Never, OnlyIfZero, Always
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data.UnifiedStream;


// Referenced classes of package com.ebay.nautilus.domain.data.UnifiedStream:
//            Category

public static final class  extends Enum
{

    private static final ALLCATEGORIES $VALUES[];
    public static final ALLCATEGORIES ALLCATEGORIES;
    public static final ALLCATEGORIES SRP;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/ebay/nautilus/domain/data/UnifiedStream/Category$Destination, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        SRP = new <init>("SRP", 0);
        ALLCATEGORIES = new <init>("ALLCATEGORIES", 1);
        $VALUES = (new .VALUES[] {
            SRP, ALLCATEGORIES
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}

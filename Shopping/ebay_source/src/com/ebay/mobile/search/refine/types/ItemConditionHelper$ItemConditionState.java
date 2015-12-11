// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.search.refine.types;


// Referenced classes of package com.ebay.mobile.search.refine.types:
//            ItemConditionHelper

public static final class  extends Enum
{

    private static final UNSPECIFIED $VALUES[];
    public static final UNSPECIFIED ANY;
    public static final UNSPECIFIED NEW;
    public static final UNSPECIFIED UNSPECIFIED;
    public static final UNSPECIFIED USED;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/ebay/mobile/search/refine/types/ItemConditionHelper$ItemConditionState, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        ANY = new <init>("ANY", 0);
        NEW = new <init>("NEW", 1);
        USED = new <init>("USED", 2);
        UNSPECIFIED = new <init>("UNSPECIFIED", 3);
        $VALUES = (new .VALUES[] {
            ANY, NEW, USED, UNSPECIFIED
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}

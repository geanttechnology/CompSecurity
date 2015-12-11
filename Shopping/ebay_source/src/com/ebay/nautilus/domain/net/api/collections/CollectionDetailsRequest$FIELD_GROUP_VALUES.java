// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.collections;


// Referenced classes of package com.ebay.nautilus.domain.net.api.collections:
//            CollectionDetailsRequest

public static final class  extends Enum
{

    private static final Medium $VALUES[];
    public static final Medium Full;
    public static final Medium Medium;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/ebay/nautilus/domain/net/api/collections/CollectionDetailsRequest$FIELD_GROUP_VALUES, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        Full = new <init>("Full", 0);
        Medium = new <init>("Medium", 1);
        $VALUES = (new .VALUES[] {
            Full, Medium
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}

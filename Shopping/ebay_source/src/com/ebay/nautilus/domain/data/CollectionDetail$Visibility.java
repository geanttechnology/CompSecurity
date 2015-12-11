// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;


// Referenced classes of package com.ebay.nautilus.domain.data:
//            CollectionDetail

public static final class  extends Enum
{

    private static final PRIVATE $VALUES[];
    public static final PRIVATE PRIVATE;
    public static final PRIVATE PUBLIC;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/ebay/nautilus/domain/data/CollectionDetail$Visibility, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        PUBLIC = new <init>("PUBLIC", 0);
        PRIVATE = new <init>("PRIVATE", 1);
        $VALUES = (new .VALUES[] {
            PUBLIC, PRIVATE
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}

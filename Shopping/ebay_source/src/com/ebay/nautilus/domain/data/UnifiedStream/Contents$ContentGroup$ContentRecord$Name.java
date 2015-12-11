// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data.UnifiedStream;


// Referenced classes of package com.ebay.nautilus.domain.data.UnifiedStream:
//            Contents

public static final class  extends Enum
{

    private static final valet $VALUES[];
    public static final valet listAnItem;
    public static final valet sellingTips;
    public static final valet valet;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/ebay/nautilus/domain/data/UnifiedStream/Contents$ContentGroup$ContentRecord$Name, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        listAnItem = new <init>("listAnItem", 0);
        sellingTips = new <init>("sellingTips", 1);
        valet = new <init>("valet", 2);
        $VALUES = (new .VALUES[] {
            listAnItem, sellingTips, valet
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data.UnifiedStream;


// Referenced classes of package com.ebay.nautilus.domain.data.UnifiedStream:
//            Contents

public static final class  extends Enum
{

    private static final ListingDraft $VALUES[];
    public static final ListingDraft ListingDraft;
    public static final ListingDraft imageListTemplate;
    public static final ListingDraft imageTemplate;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/ebay/nautilus/domain/data/UnifiedStream/Contents$ContentGroup$ContentRecord$Type, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        imageTemplate = new <init>("imageTemplate", 0);
        imageListTemplate = new <init>("imageListTemplate", 1);
        ListingDraft = new <init>("ListingDraft", 2);
        $VALUES = (new .VALUES[] {
            imageTemplate, imageListTemplate, ListingDraft
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}

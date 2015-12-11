// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.common;


// Referenced classes of package com.ebay.mobile.common:
//            PhotoGalleryWidget

public static final class  extends Enum
{

    private static final Standard $VALUES[];
    public static final Standard High;
    public static final Standard Medium;
    public static final Standard Standard;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/ebay/mobile/common/PhotoGalleryWidget$PhotoResolution, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        High = new <init>("High", 0);
        Medium = new <init>("Medium", 1);
        Standard = new <init>("Standard", 2);
        $VALUES = (new .VALUES[] {
            High, Medium, Standard
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}

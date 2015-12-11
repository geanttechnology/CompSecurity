// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.image;


// Referenced classes of package com.ebay.nautilus.domain.net.image:
//            ZoomUriBuilder

public static final class designator extends Enum
{

    private static final BOTTOM $VALUES[];
    public static final BOTTOM BOTTOM;
    public static final BOTTOM CENTER;
    public static final BOTTOM TOP;
    protected final String designator;

    public static designator valueOf(String s)
    {
        return (designator)Enum.valueOf(com/ebay/nautilus/domain/net/image/ZoomUriBuilder$VAlign, s);
    }

    public static designator[] values()
    {
        return (designator[])$VALUES.clone();
    }

    static 
    {
        TOP = new <init>("TOP", 0, "t");
        CENTER = new <init>("CENTER", 1, "c");
        BOTTOM = new <init>("BOTTOM", 2, "b");
        $VALUES = (new .VALUES[] {
            TOP, CENTER, BOTTOM
        });
    }

    private (String s, int i, String s1)
    {
        super(s, i);
        designator = s1;
    }
}

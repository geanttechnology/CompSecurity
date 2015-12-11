// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.image;


// Referenced classes of package com.ebay.nautilus.domain.net.image:
//            ZoomUriBuilder

public static final class designator extends Enum
{

    private static final RIGHT $VALUES[];
    public static final RIGHT CENTER;
    public static final RIGHT LEFT;
    public static final RIGHT RIGHT;
    protected final String designator;

    public static designator valueOf(String s)
    {
        return (designator)Enum.valueOf(com/ebay/nautilus/domain/net/image/ZoomUriBuilder$HAlign, s);
    }

    public static designator[] values()
    {
        return (designator[])$VALUES.clone();
    }

    static 
    {
        LEFT = new <init>("LEFT", 0, "l");
        CENTER = new <init>("CENTER", 1, "c");
        RIGHT = new <init>("RIGHT", 2, "r");
        $VALUES = (new .VALUES[] {
            LEFT, CENTER, RIGHT
        });
    }

    private (String s, int i, String s1)
    {
        super(s, i);
        designator = s1;
    }
}

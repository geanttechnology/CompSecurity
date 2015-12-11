// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.feeds;


// Referenced classes of package com.pointinside.feeds:
//            ZoneImageEntity

public static final class  extends Enum
{

    private static final PNG $VALUES[];
    public static final PNG PNG;
    public static final PNG SVG;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/pointinside/feeds/ZoneImageEntity$MimeType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        SVG = new <init>("SVG", 0);
        PNG = new <init>("PNG", 1);
        $VALUES = (new .VALUES[] {
            SVG, PNG
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}

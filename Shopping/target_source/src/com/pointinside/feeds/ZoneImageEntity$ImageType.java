// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.feeds;


// Referenced classes of package com.pointinside.feeds:
//            ZoneImageEntity

public static final class  extends Enum
{

    private static final PLM_VIEW4 $VALUES[];
    public static final PLM_VIEW4 DEFAULT;
    public static final PLM_VIEW4 DEFAULT4;
    public static final PLM_VIEW4 PLM_VIEW;
    public static final PLM_VIEW4 PLM_VIEW4;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/pointinside/feeds/ZoneImageEntity$ImageType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        DEFAULT = new <init>("DEFAULT", 0);
        PLM_VIEW = new <init>("PLM_VIEW", 1);
        DEFAULT4 = new <init>("DEFAULT4", 2);
        PLM_VIEW4 = new <init>("PLM_VIEW4", 3);
        $VALUES = (new .VALUES[] {
            DEFAULT, PLM_VIEW, DEFAULT4, PLM_VIEW4
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}

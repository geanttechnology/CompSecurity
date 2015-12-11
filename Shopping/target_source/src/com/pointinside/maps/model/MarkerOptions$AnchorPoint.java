// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.maps.model;


// Referenced classes of package com.pointinside.maps.model:
//            MarkerOptions

public static final class  extends Enum
{

    private static final CENTER_BOTTOM $VALUES[];
    public static final CENTER_BOTTOM CENTER;
    public static final CENTER_BOTTOM CENTER_BOTTOM;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/pointinside/maps/model/MarkerOptions$AnchorPoint, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        CENTER = new <init>("CENTER", 0);
        CENTER_BOTTOM = new <init>("CENTER_BOTTOM", 1);
        $VALUES = (new .VALUES[] {
            CENTER, CENTER_BOTTOM
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}

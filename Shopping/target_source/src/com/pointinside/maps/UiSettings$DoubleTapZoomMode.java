// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.maps;


// Referenced classes of package com.pointinside.maps:
//            UiSettings

public static final class id extends Enum
{

    private static final MAPPING_STANDARD $VALUES[];
    public static final MAPPING_STANDARD MAPPING_STANDARD;
    public static final MAPPING_STANDARD POINT_INSIDE;
    final int id;

    public static id valueOf(String s)
    {
        return (id)Enum.valueOf(com/pointinside/maps/UiSettings$DoubleTapZoomMode, s);
    }

    public static id[] values()
    {
        return (id[])$VALUES.clone();
    }

    static 
    {
        POINT_INSIDE = new <init>("POINT_INSIDE", 0, 0);
        MAPPING_STANDARD = new <init>("MAPPING_STANDARD", 1, 1);
        $VALUES = (new .VALUES[] {
            POINT_INSIDE, MAPPING_STANDARD
        });
    }

    private (String s, int i, int j)
    {
        super(s, i);
        id = j;
    }
}

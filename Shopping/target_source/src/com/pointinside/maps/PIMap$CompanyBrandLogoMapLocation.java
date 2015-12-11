// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.maps;


// Referenced classes of package com.pointinside.maps:
//            PIMap

public static final class id extends Enum
{

    private static final BOTTOM_RIGHT $VALUES[];
    public static final BOTTOM_RIGHT BOTTOM_LEFT;
    public static final BOTTOM_RIGHT BOTTOM_RIGHT;
    public static final BOTTOM_RIGHT NONE;
    public static final BOTTOM_RIGHT TOP_LEFT;
    public static final BOTTOM_RIGHT TOP_RIGHT;
    final int id;

    static id fromId(int i)
    {
        id aid[] = values();
        int k = aid.length;
        for (int j = 0; j < k; j++)
        {
            id id1 = aid[j];
            if (id1.id == i)
            {
                return id1;
            }
        }

        return BOTTOM_LEFT;
    }

    public static BOTTOM_LEFT valueOf(String s)
    {
        return (BOTTOM_LEFT)Enum.valueOf(com/pointinside/maps/PIMap$CompanyBrandLogoMapLocation, s);
    }

    public static BOTTOM_LEFT[] values()
    {
        return (BOTTOM_LEFT[])$VALUES.clone();
    }

    static 
    {
        NONE = new <init>("NONE", 0, 0);
        TOP_LEFT = new <init>("TOP_LEFT", 1, 1);
        TOP_RIGHT = new <init>("TOP_RIGHT", 2, 2);
        BOTTOM_LEFT = new <init>("BOTTOM_LEFT", 3, 3);
        BOTTOM_RIGHT = new <init>("BOTTOM_RIGHT", 4, 4);
        $VALUES = (new .VALUES[] {
            NONE, TOP_LEFT, TOP_RIGHT, BOTTOM_LEFT, BOTTOM_RIGHT
        });
    }

    private (String s, int i, int j)
    {
        super(s, i);
        id = j;
    }
}

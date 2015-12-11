// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models;


// Referenced classes of package com.groupon.models:
//            FilterCategory

public static final class  extends Enum
{

    private static final SELECTION $VALUES[];
    public static final SELECTION EVERYTHING;
    public static final SELECTION FAVORITES;
    public static final SELECTION SELECTION;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/groupon/models/FilterCategory$Mode, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        EVERYTHING = new <init>("EVERYTHING", 0);
        FAVORITES = new <init>("FAVORITES", 1);
        SELECTION = new <init>("SELECTION", 2);
        $VALUES = (new .VALUES[] {
            EVERYTHING, FAVORITES, SELECTION
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}

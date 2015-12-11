// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.customviews;


// Referenced classes of package com.poshmark.ui.customviews:
//            CollectionSortWidget

public static final class  extends Enum
{

    private static final Right $VALUES[];
    public static final Right Center;
    public static final Right Left;
    public static final Right Right;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/poshmark/ui/customviews/CollectionSortWidget$SortType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        Left = new <init>("Left", 0);
        Center = new <init>("Center", 1);
        Right = new <init>("Right", 2);
        $VALUES = (new .VALUES[] {
            Left, Center, Right
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}

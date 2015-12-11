// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.map;


// Referenced classes of package com.target.ui.view.map:
//            ZoneSelectionView

public static final class  extends Enum
{

    private static final LOWER $VALUES[];
    public static final LOWER HIGHER;
    public static final LOWER LOWER;
    public static final LOWER NO_CHANGE;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/target/ui/view/map/ZoneSelectionView$b, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        NO_CHANGE = new <init>("NO_CHANGE", 0);
        HIGHER = new <init>("HIGHER", 1);
        LOWER = new <init>("LOWER", 2);
        $VALUES = (new .VALUES[] {
            NO_CHANGE, HIGHER, LOWER
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}

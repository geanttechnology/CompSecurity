// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;


// Referenced classes of package com.groupon.view:
//            FavoriteDealTypeItem

public static final class  extends Enum
{

    private static final InProgress $VALUES[];
    public static final InProgress Gray;
    public static final InProgress InProgress;
    public static final InProgress Off;
    public static final InProgress On;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/groupon/view/FavoriteDealTypeItem$HeartState, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    public String toString()
    {
        switch (p.com.groupon.view.FavoriteDealTypeItem.HeartState[ordinal()])
        {
        default:
            return "No clue!";

        case 1: // '\001'
            return "Gray!";

        case 2: // '\002'
            return "Off!";

        case 3: // '\003'
            return "On!";

        case 4: // '\004'
            return "In Progress!";
        }
    }

    static 
    {
        Gray = new <init>("Gray", 0);
        Off = new <init>("Off", 1);
        On = new <init>("On", 2);
        InProgress = new <init>("InProgress", 3);
        $VALUES = (new .VALUES[] {
            Gray, Off, On, InProgress
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}

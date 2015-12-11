// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;


// Referenced classes of package com.poshmark.ui.fragments:
//            ShowroomFragment

public static final class  extends Enum
{

    private static final PRICE_DROP $VALUES[];
    public static final PRICE_DROP ALL;
    public static final PRICE_DROP JUST_IN;
    public static final PRICE_DROP PRICE_DROP;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/poshmark/ui/fragments/ShowroomFragment$MODE, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        JUST_IN = new <init>("JUST_IN", 0);
        ALL = new <init>("ALL", 1);
        PRICE_DROP = new <init>("PRICE_DROP", 2);
        $VALUES = (new .VALUES[] {
            JUST_IN, ALL, PRICE_DROP
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}

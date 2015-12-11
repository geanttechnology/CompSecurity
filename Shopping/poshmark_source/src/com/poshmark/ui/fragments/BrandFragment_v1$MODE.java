// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;


// Referenced classes of package com.poshmark.ui.fragments:
//            BrandFragment_v1

public static final class  extends Enum
{

    private static final ALL $VALUES[];
    public static final ALL ALL;
    public static final ALL JUST_IN;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/poshmark/ui/fragments/BrandFragment_v1$MODE, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        JUST_IN = new <init>("JUST_IN", 0);
        ALL = new <init>("ALL", 1);
        $VALUES = (new .VALUES[] {
            JUST_IN, ALL
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}

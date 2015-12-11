// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.customviews;


// Referenced classes of package com.poshmark.ui.customviews:
//            UserFollowButtonLayout

public static final class  extends Enum
{

    private static final SINGLE_MODE $VALUES[];
    public static final SINGLE_MODE SINGLE_MODE;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/poshmark/ui/customviews/UserFollowButtonLayout$DisplayMode, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        SINGLE_MODE = new <init>("SINGLE_MODE", 0);
        $VALUES = (new .VALUES[] {
            SINGLE_MODE
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}

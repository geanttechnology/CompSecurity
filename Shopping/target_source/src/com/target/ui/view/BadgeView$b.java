// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view;


// Referenced classes of package com.target.ui.view:
//            BadgeView

public static final class  extends Enum
{

    private static final INVERSE $VALUES[];
    public static final INVERSE ACTIVE;
    public static final INVERSE INACTIVE;
    public static final INVERSE INVERSE;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/target/ui/view/BadgeView$b, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        ACTIVE = new <init>("ACTIVE", 0);
        INACTIVE = new <init>("INACTIVE", 1);
        INVERSE = new <init>("INVERSE", 2);
        $VALUES = (new .VALUES[] {
            ACTIVE, INACTIVE, INVERSE
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}

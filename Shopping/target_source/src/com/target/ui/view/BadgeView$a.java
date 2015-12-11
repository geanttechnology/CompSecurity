// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view;


// Referenced classes of package com.target.ui.view:
//            BadgeView

public static final class  extends Enum
{

    private static final X_LARGE $VALUES[];
    public static final X_LARGE BIG;
    public static final X_LARGE SMALL;
    public static final X_LARGE X_LARGE;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/target/ui/view/BadgeView$a, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        SMALL = new <init>("SMALL", 0);
        BIG = new <init>("BIG", 1);
        X_LARGE = new <init>("X_LARGE", 2);
        $VALUES = (new .VALUES[] {
            SMALL, BIG, X_LARGE
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}

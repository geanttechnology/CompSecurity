// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.androidmotion.layout;


// Referenced classes of package com.amazon.androidmotion.layout:
//            AnimationLayout

public static final class  extends Enum
{

    private static final STACK_BELOW $VALUES[];
    public static final STACK_BELOW STACK_ABOVE;
    public static final STACK_BELOW STACK_BELOW;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/androidmotion/layout/AnimationLayout$DuplicateZIndexes, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        STACK_ABOVE = new <init>("STACK_ABOVE", 0);
        STACK_BELOW = new <init>("STACK_BELOW", 1);
        $VALUES = (new .VALUES[] {
            STACK_ABOVE, STACK_BELOW
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}

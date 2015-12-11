// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.util.validation.a;


// Referenced classes of package com.target.ui.util.validation.a:
//            j

public static final class  extends Enum
{

    private static final STATE_INVALID $VALUES[];
    public static final STATE_INVALID STATE_INVALID;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/target/ui/util/validation/a/j$a, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        STATE_INVALID = new <init>("STATE_INVALID", 0);
        $VALUES = (new .VALUES[] {
            STATE_INVALID
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}

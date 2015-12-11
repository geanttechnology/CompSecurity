// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.common;


// Referenced classes of package com.target.ui.common:
//            g

public static final class  extends Enum
{

    private static final UNKNOWN $VALUES[];
    public static final UNKNOWN BLACK;
    public static final UNKNOWN RED;
    public static final UNKNOWN UNKNOWN;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/target/ui/common/g$a, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        RED = new <init>("RED", 0);
        BLACK = new <init>("BLACK", 1);
        UNKNOWN = new <init>("UNKNOWN", 2);
        $VALUES = (new .VALUES[] {
            RED, BLACK, UNKNOWN
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}

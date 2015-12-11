// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.i.c;


// Referenced classes of package com.target.ui.i.c:
//            c

public static final class  extends Enum
{

    private static final SHORT $VALUES[];
    public static final SHORT REGULAR;
    public static final SHORT SHORT;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/target/ui/i/c/c$a, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        REGULAR = new <init>("REGULAR", 0);
        SHORT = new <init>("SHORT", 1);
        $VALUES = (new .VALUES[] {
            REGULAR, SHORT
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}

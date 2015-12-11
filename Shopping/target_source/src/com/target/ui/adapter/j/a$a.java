// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.adapter.j;


// Referenced classes of package com.target.ui.adapter.j:
//            a

public static final class  extends Enum
{

    private static final SHIP $VALUES[];
    public static final SHIP ADD_TO_LIST;
    public static final SHIP DEFAULT;
    public static final SHIP PICK_UP;
    public static final SHIP SHIP;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/target/ui/adapter/j/a$a, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        DEFAULT = new <init>("DEFAULT", 0);
        ADD_TO_LIST = new <init>("ADD_TO_LIST", 1);
        PICK_UP = new <init>("PICK_UP", 2);
        SHIP = new <init>("SHIP", 3);
        $VALUES = (new .VALUES[] {
            DEFAULT, ADD_TO_LIST, PICK_UP, SHIP
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}

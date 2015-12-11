// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils.sharing;


// Referenced classes of package com.poshmark.utils.sharing:
//            FSMTransition

public static final class  extends Enum
{

    private static final FAIL $VALUES[];
    public static final FAIL FAIL;
    public static final FAIL OK;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/poshmark/utils/sharing/FSMTransition$CONDITION, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        OK = new <init>("OK", 0);
        FAIL = new <init>("FAIL", 1);
        $VALUES = (new .VALUES[] {
            OK, FAIL
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.damnhandy.uri.template.impl;


// Referenced classes of package com.damnhandy.uri.template.impl:
//            VarSpec

public static final class  extends Enum
{

    private static final PAIRS $VALUES[];
    public static final PAIRS ARRAY;
    public static final PAIRS PAIRS;
    public static final PAIRS SINGLE;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/damnhandy/uri/template/impl/VarSpec$VarFormat, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        SINGLE = new <init>("SINGLE", 0);
        ARRAY = new <init>("ARRAY", 1);
        PAIRS = new <init>("PAIRS", 2);
        $VALUES = (new .VALUES[] {
            SINGLE, ARRAY, PAIRS
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}

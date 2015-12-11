// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.supersonicads.sdk.data;


// Referenced classes of package com.supersonicads.sdk.data:
//            SSAEnums

public static final class value extends Enum
{

    private static final MODE_3 $VALUES[];
    public static final MODE_3 MODE_0;
    public static final MODE_3 MODE_1;
    public static final MODE_3 MODE_2;
    public static final MODE_3 MODE_3;
    private int value;

    public static value valueOf(String s)
    {
        return (value)Enum.valueOf(com/supersonicads/sdk/data/SSAEnums$DebugMode, s);
    }

    public static value[] values()
    {
        return (value[])$VALUES.clone();
    }

    public int getValue()
    {
        return value;
    }

    static 
    {
        MODE_0 = new <init>("MODE_0", 0, 0);
        MODE_1 = new <init>("MODE_1", 1, 1);
        MODE_2 = new <init>("MODE_2", 2, 2);
        MODE_3 = new <init>("MODE_3", 3, 3);
        $VALUES = (new .VALUES[] {
            MODE_0, MODE_1, MODE_2, MODE_3
        });
    }

    private (String s, int i, int j)
    {
        super(s, i);
        value = j;
    }
}

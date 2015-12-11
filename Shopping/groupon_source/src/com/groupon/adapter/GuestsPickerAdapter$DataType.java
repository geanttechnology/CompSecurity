// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.adapter;


// Referenced classes of package com.groupon.adapter:
//            GuestsPickerAdapter

public static final class  extends Enum
{

    private static final CHILDREN $VALUES[];
    public static final CHILDREN ADULTS;
    public static final CHILDREN CHILDREN;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/groupon/adapter/GuestsPickerAdapter$DataType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        ADULTS = new <init>("ADULTS", 0);
        CHILDREN = new <init>("CHILDREN", 1);
        $VALUES = (new .VALUES[] {
            ADULTS, CHILDREN
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.photoselector;


final class  extends Enum
{

    private static final Status_Invalid $VALUES[];
    public static final Status_Invalid Status_Create_First;
    public static final Status_Invalid Status_Create_Second;
    public static final Status_Invalid Status_Invalid;
    public static final Status_Invalid Status_Query;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/fotoable/photoselector/PinQueryFragment$PinStatus, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        Status_Create_First = new <init>("Status_Create_First", 0);
        Status_Create_Second = new <init>("Status_Create_Second", 1);
        Status_Query = new <init>("Status_Query", 2);
        Status_Invalid = new <init>("Status_Invalid", 3);
        $VALUES = (new .VALUES[] {
            Status_Create_First, Status_Create_Second, Status_Query, Status_Invalid
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}

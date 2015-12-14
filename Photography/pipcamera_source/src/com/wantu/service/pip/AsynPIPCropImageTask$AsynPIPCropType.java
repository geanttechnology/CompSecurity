// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.service.pip;


public final class  extends Enum
{

    private static final NORMALCROP $VALUES[];
    public static final NORMALCROP NORMALCROP;
    public static final NORMALCROP THUMBNAIL;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/wantu/service/pip/AsynPIPCropImageTask$AsynPIPCropType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        THUMBNAIL = new <init>("THUMBNAIL", 0);
        NORMALCROP = new <init>("NORMALCROP", 1);
        $VALUES = (new .VALUES[] {
            THUMBNAIL, NORMALCROP
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}

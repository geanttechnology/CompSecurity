// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;


// Referenced classes of package com.amazon.device.ads:
//            FileOutputHandler

public static final class _cls9 extends Enum
{

    private static final OVERWRITE $VALUES[];
    public static final OVERWRITE APPEND;
    public static final OVERWRITE OVERWRITE;

    public static _cls9 valueOf(String s)
    {
        return (_cls9)Enum.valueOf(com/amazon/device/ads/FileOutputHandler$WriteMethod, s);
    }

    public static _cls9[] values()
    {
        return (_cls9[])$VALUES.clone();
    }

    static 
    {
        APPEND = new <init>("APPEND", 0);
        OVERWRITE = new <init>("OVERWRITE", 1);
        $VALUES = (new .VALUES[] {
            APPEND, OVERWRITE
        });
    }

    private _cls9(String s, int i)
    {
        super(s, i);
    }
}

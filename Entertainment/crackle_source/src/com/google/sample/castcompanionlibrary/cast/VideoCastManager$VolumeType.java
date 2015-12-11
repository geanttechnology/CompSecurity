// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.sample.castcompanionlibrary.cast;


// Referenced classes of package com.google.sample.castcompanionlibrary.cast:
//            VideoCastManager

public static final class  extends Enum
{

    private static final DEVICE $VALUES[];
    public static final DEVICE DEVICE;
    public static final DEVICE STREAM;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/google/sample/castcompanionlibrary/cast/VideoCastManager$VolumeType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        STREAM = new <init>("STREAM", 0);
        DEVICE = new <init>("DEVICE", 1);
        $VALUES = (new .VALUES[] {
            STREAM, DEVICE
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}

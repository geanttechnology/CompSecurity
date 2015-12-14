// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.photo.gpu;


public final class  extends Enum
{

    private static final ReadPixelsResultTypeBuffer $VALUES[];
    public static final ReadPixelsResultTypeBuffer ReadPixelsResultTypeBitmap;
    public static final ReadPixelsResultTypeBuffer ReadPixelsResultTypeBuffer;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/photo/gpu/GPUImage$ReadPixelsResultType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        ReadPixelsResultTypeBitmap = new <init>("ReadPixelsResultTypeBitmap", 0);
        ReadPixelsResultTypeBuffer = new <init>("ReadPixelsResultTypeBuffer", 1);
        $VALUES = (new .VALUES[] {
            ReadPixelsResultTypeBitmap, ReadPixelsResultTypeBuffer
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}

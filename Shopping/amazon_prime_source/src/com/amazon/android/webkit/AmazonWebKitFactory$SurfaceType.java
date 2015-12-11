// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.android.webkit;


// Referenced classes of package com.amazon.android.webkit:
//            AmazonWebKitFactory

public static final class value extends Enum
{

    private static final TEXTUREVIEW $VALUES[];
    public static final TEXTUREVIEW SURFACEVIEW;
    public static final TEXTUREVIEW TEXTUREVIEW;
    private final int value;

    public static value valueOf(String s)
    {
        return (value)Enum.valueOf(com/amazon/android/webkit/AmazonWebKitFactory$SurfaceType, s);
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
        SURFACEVIEW = new <init>("SURFACEVIEW", 0, 0);
        TEXTUREVIEW = new <init>("TEXTUREVIEW", 1, 1);
        $VALUES = (new .VALUES[] {
            SURFACEVIEW, TEXTUREVIEW
        });
    }

    private (String s, int i, int j)
    {
        super(s, i);
        value = j;
    }
}

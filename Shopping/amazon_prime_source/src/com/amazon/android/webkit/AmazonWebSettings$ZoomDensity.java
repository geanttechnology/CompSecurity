// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.android.webkit;


// Referenced classes of package com.amazon.android.webkit:
//            AmazonWebSettings

public static final class  extends Enum
{

    private static final FAR $VALUES[];
    public static final FAR CLOSE;
    public static final FAR FAR;
    public static final FAR MEDIUM;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/android/webkit/AmazonWebSettings$ZoomDensity, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        CLOSE = new <init>("CLOSE", 0);
        MEDIUM = new <init>("MEDIUM", 1);
        FAR = new <init>("FAR", 2);
        $VALUES = (new .VALUES[] {
            CLOSE, MEDIUM, FAR
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}

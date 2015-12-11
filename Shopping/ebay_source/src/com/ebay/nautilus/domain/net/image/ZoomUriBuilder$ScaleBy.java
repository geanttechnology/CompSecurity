// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.image;


// Referenced classes of package com.ebay.nautilus.domain.net.image:
//            ZoomUriBuilder

public static final class parameterCount extends Enum
{

    private static final LONGEST $VALUES[];
    public static final LONGEST BOTH;
    public static final LONGEST HEIGHT;
    public static final LONGEST LONGEST;
    public static final LONGEST WIDTH;
    protected final String formatString;
    protected final byte parameterCount;

    public static parameterCount valueOf(String s)
    {
        return (parameterCount)Enum.valueOf(com/ebay/nautilus/domain/net/image/ZoomUriBuilder$ScaleBy, s);
    }

    public static parameterCount[] values()
    {
        return (parameterCount[])$VALUES.clone();
    }

    static 
    {
        WIDTH = new <init>("WIDTH", 0, "s-w%1$d", (byte)1);
        HEIGHT = new <init>("HEIGHT", 1, "s-h%1$d", (byte)1);
        BOTH = new <init>("BOTH", 2, "s-b%1$dx%2$d", (byte)2);
        LONGEST = new <init>("LONGEST", 3, "s-l%1$d", (byte)1);
        $VALUES = (new .VALUES[] {
            WIDTH, HEIGHT, BOTH, LONGEST
        });
    }

    private (String s, int i, String s1, byte byte0)
    {
        super(s, i);
        formatString = s1;
        parameterCount = byte0;
    }
}

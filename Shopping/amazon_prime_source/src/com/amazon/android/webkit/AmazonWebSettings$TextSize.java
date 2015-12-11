// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.android.webkit;


// Referenced classes of package com.amazon.android.webkit:
//            AmazonWebSettings

public static final class  extends Enum
{

    private static final SMALLEST $VALUES[];
    public static final SMALLEST LARGER;
    public static final SMALLEST LARGEST;
    public static final SMALLEST NORMAL;
    public static final SMALLEST SMALLER;
    public static final SMALLEST SMALLEST;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/android/webkit/AmazonWebSettings$TextSize, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        LARGER = new <init>("LARGER", 0);
        LARGEST = new <init>("LARGEST", 1);
        NORMAL = new <init>("NORMAL", 2);
        SMALLER = new <init>("SMALLER", 3);
        SMALLEST = new <init>("SMALLEST", 4);
        $VALUES = (new .VALUES[] {
            LARGER, LARGEST, NORMAL, SMALLER, SMALLEST
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.android.webkit;


// Referenced classes of package com.amazon.android.webkit:
//            AmazonWebSettings

public static final class  extends Enum
{

    private static final LOW $VALUES[];
    public static final LOW HIGH;
    public static final LOW LOW;
    public static final LOW NORMAL;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/android/webkit/AmazonWebSettings$RenderPriority, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        HIGH = new <init>("HIGH", 0);
        NORMAL = new <init>("NORMAL", 1);
        LOW = new <init>("LOW", 2);
        $VALUES = (new .VALUES[] {
            HIGH, NORMAL, LOW
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}

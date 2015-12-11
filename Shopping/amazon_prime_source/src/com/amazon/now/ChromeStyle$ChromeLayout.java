// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now;


// Referenced classes of package com.amazon.now:
//            ChromeStyle

public static final class  extends Enum
{

    private static final HEADER $VALUES[];
    public static final HEADER HEADER;
    public static final HEADER LOGO_ONLY;
    public static final HEADER NONE;
    public static final HEADER NORMAL;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/now/ChromeStyle$ChromeLayout, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        NONE = new <init>("NONE", 0);
        NORMAL = new <init>("NORMAL", 1);
        LOGO_ONLY = new <init>("LOGO_ONLY", 2);
        HEADER = new <init>("HEADER", 3);
        $VALUES = (new .VALUES[] {
            NONE, NORMAL, LOGO_ONLY, HEADER
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}

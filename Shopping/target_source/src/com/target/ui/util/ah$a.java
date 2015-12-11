// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.util;


// Referenced classes of package com.target.ui.util:
//            ah

public static final class  extends Enum
{

    private static final REGULAR $VALUES[];
    public static final REGULAR ITALIC;
    public static final REGULAR LIGHT;
    public static final REGULAR LIGHT_ITALIC;
    public static final REGULAR MEDIUM;
    public static final REGULAR REGULAR;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/target/ui/util/ah$a, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        ITALIC = new <init>("ITALIC", 0);
        LIGHT = new <init>("LIGHT", 1);
        LIGHT_ITALIC = new <init>("LIGHT_ITALIC", 2);
        MEDIUM = new <init>("MEDIUM", 3);
        REGULAR = new <init>("REGULAR", 4);
        $VALUES = (new .VALUES[] {
            ITALIC, LIGHT, LIGHT_ITALIC, MEDIUM, REGULAR
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}

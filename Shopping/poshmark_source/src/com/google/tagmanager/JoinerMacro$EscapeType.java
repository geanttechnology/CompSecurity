// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager;


// Referenced classes of package com.google.tagmanager:
//            JoinerMacro

private static final class  extends Enum
{

    private static final BACKSLASH $VALUES[];
    public static final BACKSLASH BACKSLASH;
    public static final BACKSLASH NONE;
    public static final BACKSLASH URL;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/google/tagmanager/JoinerMacro$EscapeType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        NONE = new <init>("NONE", 0);
        URL = new <init>("URL", 1);
        BACKSLASH = new <init>("BACKSLASH", 2);
        $VALUES = (new .VALUES[] {
            NONE, URL, BACKSLASH
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}

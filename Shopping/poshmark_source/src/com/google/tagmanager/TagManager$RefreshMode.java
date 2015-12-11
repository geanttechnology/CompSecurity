// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager;


// Referenced classes of package com.google.tagmanager:
//            TagManager

public static final class  extends Enum
{

    private static final DEFAULT_CONTAINER $VALUES[];
    public static final DEFAULT_CONTAINER DEFAULT_CONTAINER;
    public static final DEFAULT_CONTAINER STANDARD;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/google/tagmanager/TagManager$RefreshMode, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        STANDARD = new <init>("STANDARD", 0);
        DEFAULT_CONTAINER = new <init>("DEFAULT_CONTAINER", 1);
        $VALUES = (new .VALUES[] {
            STANDARD, DEFAULT_CONTAINER
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}

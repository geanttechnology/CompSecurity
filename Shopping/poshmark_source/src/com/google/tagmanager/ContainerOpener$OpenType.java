// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager;


// Referenced classes of package com.google.tagmanager:
//            ContainerOpener

public static final class  extends Enum
{

    private static final PREFER_FRESH $VALUES[];
    public static final PREFER_FRESH PREFER_FRESH;
    public static final PREFER_FRESH PREFER_NON_DEFAULT;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/google/tagmanager/ContainerOpener$OpenType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        PREFER_NON_DEFAULT = new <init>("PREFER_NON_DEFAULT", 0);
        PREFER_FRESH = new <init>("PREFER_FRESH", 1);
        $VALUES = (new .VALUES[] {
            PREFER_NON_DEFAULT, PREFER_FRESH
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}

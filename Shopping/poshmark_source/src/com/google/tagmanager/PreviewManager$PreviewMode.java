// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager;


// Referenced classes of package com.google.tagmanager:
//            PreviewManager

static final class  extends Enum
{

    private static final CONTAINER_DEBUG $VALUES[];
    public static final CONTAINER_DEBUG CONTAINER;
    public static final CONTAINER_DEBUG CONTAINER_DEBUG;
    public static final CONTAINER_DEBUG NONE;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/google/tagmanager/PreviewManager$PreviewMode, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        NONE = new <init>("NONE", 0);
        CONTAINER = new <init>("CONTAINER", 1);
        CONTAINER_DEBUG = new <init>("CONTAINER_DEBUG", 2);
        $VALUES = (new .VALUES[] {
            NONE, CONTAINER, CONTAINER_DEBUG
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}

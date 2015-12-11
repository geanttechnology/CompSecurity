// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view.imagezoom;


// Referenced classes of package com.groupon.view.imagezoom:
//            ImageViewTouchBase

public static final class  extends Enum
{

    private static final FIT_TO_SCREEN $VALUES[];
    public static final FIT_TO_SCREEN FIT_TO_SCREEN;
    public static final FIT_TO_SCREEN NONE;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/groupon/view/imagezoom/ImageViewTouchBase$DisplayType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        NONE = new <init>("NONE", 0);
        FIT_TO_SCREEN = new <init>("FIT_TO_SCREEN", 1);
        $VALUES = (new .VALUES[] {
            NONE, FIT_TO_SCREEN
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}

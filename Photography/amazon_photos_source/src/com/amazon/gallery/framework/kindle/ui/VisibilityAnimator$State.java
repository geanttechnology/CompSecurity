// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.ui;


// Referenced classes of package com.amazon.gallery.framework.kindle.ui:
//            VisibilityAnimator

private static final class  extends Enum
{

    private static final VISIBLE $VALUES[];
    public static final VISIBLE APPEARING;
    public static final VISIBLE DISAPPEARING;
    public static final VISIBLE INVISIBLE;
    public static final VISIBLE VISIBLE;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/gallery/framework/kindle/ui/VisibilityAnimator$State, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        DISAPPEARING = new <init>("DISAPPEARING", 0);
        INVISIBLE = new <init>("INVISIBLE", 1);
        APPEARING = new <init>("APPEARING", 2);
        VISIBLE = new <init>("VISIBLE", 3);
        $VALUES = (new .VALUES[] {
            DISAPPEARING, INVISIBLE, APPEARING, VISIBLE
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}

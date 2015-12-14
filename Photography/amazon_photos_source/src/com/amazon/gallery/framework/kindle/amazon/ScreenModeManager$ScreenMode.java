// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.amazon;


// Referenced classes of package com.amazon.gallery.framework.kindle.amazon:
//            ScreenModeManager

public static final class  extends Enum
{

    private static final GRID_GEN5 $VALUES[];
    public static final GRID_GEN5 FULL_SCREEN;
    public static final GRID_GEN5 GRID_GEN5;
    public static final GRID_GEN5 NORMAL_OPAQUE_UI;
    public static final GRID_GEN5 NORMAL_STABLE;
    public static final GRID_GEN5 NORMAL_STABLE_OPAQUE_UI;
    public static final GRID_GEN5 SUPER_FULL_SCREEN;
    public static final GRID_GEN5 SUPER_FULL_SCREEN_OPAQUE_UI;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/gallery/framework/kindle/amazon/ScreenModeManager$ScreenMode, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        SUPER_FULL_SCREEN = new <init>("SUPER_FULL_SCREEN", 0);
        SUPER_FULL_SCREEN_OPAQUE_UI = new <init>("SUPER_FULL_SCREEN_OPAQUE_UI", 1);
        FULL_SCREEN = new <init>("FULL_SCREEN", 2);
        NORMAL_STABLE = new <init>("NORMAL_STABLE", 3);
        NORMAL_STABLE_OPAQUE_UI = new <init>("NORMAL_STABLE_OPAQUE_UI", 4);
        NORMAL_OPAQUE_UI = new <init>("NORMAL_OPAQUE_UI", 5);
        GRID_GEN5 = new <init>("GRID_GEN5", 6);
        $VALUES = (new .VALUES[] {
            SUPER_FULL_SCREEN, SUPER_FULL_SCREEN_OPAQUE_UI, FULL_SCREEN, NORMAL_STABLE, NORMAL_STABLE_OPAQUE_UI, NORMAL_OPAQUE_UI, GRID_GEN5
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}

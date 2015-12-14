// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.gizmo;


final class  extends Enum
{

    private static final PINCH $VALUES[];
    public static final PINCH DRAG;
    public static final PINCH PINCH;
    public static final PINCH ROTATE;
    public static final PINCH SCALE_B;
    public static final PINCH SCALE_L;
    public static final PINCH SCALE_PROP;
    public static final PINCH SCALE_R;
    public static final PINCH SCALE_T;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/picsart/studio/editor/gizmo/DefaultGizmo$GestureType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        DRAG = new <init>("DRAG", 0);
        SCALE_PROP = new <init>("SCALE_PROP", 1);
        SCALE_L = new <init>("SCALE_L", 2);
        SCALE_T = new <init>("SCALE_T", 3);
        SCALE_R = new <init>("SCALE_R", 4);
        SCALE_B = new <init>("SCALE_B", 5);
        ROTATE = new <init>("ROTATE", 6);
        PINCH = new <init>("PINCH", 7);
        $VALUES = (new .VALUES[] {
            DRAG, SCALE_PROP, SCALE_L, SCALE_T, SCALE_R, SCALE_B, ROTATE, PINCH
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}

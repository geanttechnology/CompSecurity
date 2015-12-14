// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.brushlib.gizmo;


final class  extends Enum
{

    private static final ROTATE $VALUES[];
    public static final ROTATE DRAG;
    public static final ROTATE ROTATE;
    public static final ROTATE SCALE_LB;
    public static final ROTATE SCALE_LT;
    public static final ROTATE SCALE_RB;
    public static final ROTATE SCALE_RT;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/socialin/android/brushlib/gizmo/SimpleTransformGizmo$GestureType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        DRAG = new <init>("DRAG", 0);
        SCALE_LT = new <init>("SCALE_LT", 1);
        SCALE_RT = new <init>("SCALE_RT", 2);
        SCALE_LB = new <init>("SCALE_LB", 3);
        SCALE_RB = new <init>("SCALE_RB", 4);
        ROTATE = new <init>("ROTATE", 5);
        $VALUES = (new .VALUES[] {
            DRAG, SCALE_LT, SCALE_RT, SCALE_LB, SCALE_RB, ROTATE
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}

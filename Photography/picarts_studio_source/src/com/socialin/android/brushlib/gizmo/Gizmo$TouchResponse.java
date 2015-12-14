// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.brushlib.gizmo;


public final class  extends Enum
{

    private static final FOCUS_OUTSIDE $VALUES[];
    public static final FOCUS_OUTSIDE FOCUSED;
    public static final FOCUS_OUTSIDE FOCUS_OUTSIDE;
    public static final FOCUS_OUTSIDE TAP_OUTSIDE;
    public static final FOCUS_OUTSIDE TRANSFORMED;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/socialin/android/brushlib/gizmo/Gizmo$TouchResponse, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        FOCUSED = new <init>("FOCUSED", 0);
        TRANSFORMED = new <init>("TRANSFORMED", 1);
        TAP_OUTSIDE = new <init>("TAP_OUTSIDE", 2);
        FOCUS_OUTSIDE = new <init>("FOCUS_OUTSIDE", 3);
        $VALUES = (new .VALUES[] {
            FOCUSED, TRANSFORMED, TAP_OUTSIDE, FOCUS_OUTSIDE
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}

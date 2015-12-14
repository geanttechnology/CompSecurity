// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.gizmo;


final class  extends Enum
{

    private static final PINCH $VALUES[];
    public static final PINCH DRAG;
    public static final PINCH PINCH;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/picsart/studio/editor/gizmo/FrameBackgroundItemGizmo$GestureType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        DRAG = new <init>("DRAG", 0);
        PINCH = new <init>("PINCH", 1);
        $VALUES = (new .VALUES[] {
            DRAG, PINCH
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}

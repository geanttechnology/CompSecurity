// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.beautyui.newui;


public final class  extends Enum
{

    private static final ZOOM $VALUES[];
    public static final ZOOM DRAG;
    public static final ZOOM NONE;
    public static final ZOOM ZOOM;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/fotoable/beautyui/newui/MNewTouchImageView$TouchState, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        NONE = new <init>("NONE", 0);
        DRAG = new <init>("DRAG", 1);
        ZOOM = new <init>("ZOOM", 2);
        $VALUES = (new .VALUES[] {
            NONE, DRAG, ZOOM
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}

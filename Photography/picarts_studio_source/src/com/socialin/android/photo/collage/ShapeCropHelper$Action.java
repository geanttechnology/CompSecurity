// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.collage;


final class  extends Enum
{

    private static final PINCH_ZOOM $VALUES[];
    public static final PINCH_ZOOM DRAG;
    public static final PINCH_ZOOM HANDLE_ZOOM;
    public static final PINCH_ZOOM NONE;
    public static final PINCH_ZOOM PINCH_ZOOM;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/socialin/android/photo/collage/ShapeCropHelper$Action, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        HANDLE_ZOOM = new <init>("HANDLE_ZOOM", 0);
        DRAG = new <init>("DRAG", 1);
        NONE = new <init>("NONE", 2);
        PINCH_ZOOM = new <init>("PINCH_ZOOM", 3);
        $VALUES = (new .VALUES[] {
            HANDLE_ZOOM, DRAG, NONE, PINCH_ZOOM
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}

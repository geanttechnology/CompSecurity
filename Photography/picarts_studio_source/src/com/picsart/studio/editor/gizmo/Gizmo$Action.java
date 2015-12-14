// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.gizmo;


public final class  extends Enum
{

    private static final IMAGE_ZOOM $VALUES[];
    public static final IMAGE_ZOOM BLENDING_SELECT;
    public static final IMAGE_ZOOM COLOR_CHANGE;
    public static final IMAGE_ZOOM DELETE;
    public static final IMAGE_ZOOM DRAG;
    public static final IMAGE_ZOOM DRAG1;
    public static final IMAGE_ZOOM IMAGE_ZOOM;
    public static final IMAGE_ZOOM OPACITY_SLIDE;
    public static final IMAGE_ZOOM RESIZE_FREE;
    public static final IMAGE_ZOOM RESIZE_PROP;
    public static final IMAGE_ZOOM ROTATE;
    public static final IMAGE_ZOOM SIZE_DRAG;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/picsart/studio/editor/gizmo/Gizmo$Action, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        DRAG1 = new <init>("DRAG1", 0);
        DRAG = new <init>("DRAG", 1);
        SIZE_DRAG = new <init>("SIZE_DRAG", 2);
        ROTATE = new <init>("ROTATE", 3);
        RESIZE_FREE = new <init>("RESIZE_FREE", 4);
        RESIZE_PROP = new <init>("RESIZE_PROP", 5);
        DELETE = new <init>("DELETE", 6);
        OPACITY_SLIDE = new <init>("OPACITY_SLIDE", 7);
        BLENDING_SELECT = new <init>("BLENDING_SELECT", 8);
        COLOR_CHANGE = new <init>("COLOR_CHANGE", 9);
        IMAGE_ZOOM = new <init>("IMAGE_ZOOM", 10);
        $VALUES = (new .VALUES[] {
            DRAG1, DRAG, SIZE_DRAG, ROTATE, RESIZE_FREE, RESIZE_PROP, DELETE, OPACITY_SLIDE, BLENDING_SELECT, COLOR_CHANGE, 
            IMAGE_ZOOM
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor;


public final class Tool extends Enum
{

    private static final Tool $VALUES[];
    public static final Tool ADJUST;
    public static final Tool BORDER;
    public static final Tool CALLOUT;
    public static final Tool CLIPART;
    public static final Tool CLONE;
    public static final Tool CROP;
    public static final Tool CURVES;
    public static final Tool DRAW;
    public static final Tool EFFECT;
    public static final Tool ENHANCE;
    public static final Tool FRAME;
    public static final Tool FRAME_PHOTO;
    public static final Tool FREE_CROP;
    public static final Tool GIFEXPORT;
    public static final Tool LENS_FLARE;
    public static final Tool MASK;
    public static final Tool MOTION;
    public static final Tool PERSPECTIVE;
    public static final Tool PHOTO;
    public static final Tool RESIZE;
    public static final Tool SELECTION;
    public static final Tool SHAPE_CROP;
    public static final Tool SHAPE_MASK;
    public static final Tool SQUARE_FIT;
    public static final Tool STICKER;
    public static final Tool STRETCH;
    public static final Tool TEXT;
    public static final Tool TILT_SHIFT;
    public static final Tool TRANSFORM;
    public static final Tool VIEW;

    private Tool(String s, int i)
    {
        super(s, i);
    }

    public static Tool valueOf(String s)
    {
        return (Tool)Enum.valueOf(com/picsart/studio/editor/Tool, s);
    }

    public static Tool[] values()
    {
        return (Tool[])$VALUES.clone();
    }

    static 
    {
        VIEW = new Tool("VIEW", 0);
        EFFECT = new Tool("EFFECT", 1);
        SQUARE_FIT = new Tool("SQUARE_FIT", 2);
        MASK = new Tool("MASK", 3);
        DRAW = new Tool("DRAW", 4);
        TEXT = new Tool("TEXT", 5);
        CALLOUT = new Tool("CALLOUT", 6);
        LENS_FLARE = new Tool("LENS_FLARE", 7);
        STICKER = new Tool("STICKER", 8);
        CLIPART = new Tool("CLIPART", 9);
        PHOTO = new Tool("PHOTO", 10);
        FRAME = new Tool("FRAME", 11);
        FRAME_PHOTO = new Tool("FRAME_PHOTO", 12);
        SHAPE_MASK = new Tool("SHAPE_MASK", 13);
        BORDER = new Tool("BORDER", 14);
        CROP = new Tool("CROP", 15);
        FREE_CROP = new Tool("FREE_CROP", 16);
        SHAPE_CROP = new Tool("SHAPE_CROP", 17);
        SELECTION = new Tool("SELECTION", 18);
        CLONE = new Tool("CLONE", 19);
        MOTION = new Tool("MOTION", 20);
        STRETCH = new Tool("STRETCH", 21);
        CURVES = new Tool("CURVES", 22);
        ADJUST = new Tool("ADJUST", 23);
        ENHANCE = new Tool("ENHANCE", 24);
        TILT_SHIFT = new Tool("TILT_SHIFT", 25);
        RESIZE = new Tool("RESIZE", 26);
        TRANSFORM = new Tool("TRANSFORM", 27);
        PERSPECTIVE = new Tool("PERSPECTIVE", 28);
        GIFEXPORT = new Tool("GIFEXPORT", 29);
        $VALUES = (new Tool[] {
            VIEW, EFFECT, SQUARE_FIT, MASK, DRAW, TEXT, CALLOUT, LENS_FLARE, STICKER, CLIPART, 
            PHOTO, FRAME, FRAME_PHOTO, SHAPE_MASK, BORDER, CROP, FREE_CROP, SHAPE_CROP, SELECTION, CLONE, 
            MOTION, STRETCH, CURVES, ADJUST, ENHANCE, TILT_SHIFT, RESIZE, TRANSFORM, PERSPECTIVE, GIFEXPORT
        });
    }
}

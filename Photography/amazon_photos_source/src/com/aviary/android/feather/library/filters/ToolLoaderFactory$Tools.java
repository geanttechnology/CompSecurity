// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.library.filters;


// Referenced classes of package com.aviary.android.feather.library.filters:
//            ToolLoaderFactory

public static final class  extends Enum
{

    private static final OVERLAYS $VALUES[];
    public static final OVERLAYS BLEMISH;
    public static final OVERLAYS BLUR;
    public static final OVERLAYS COLOR;
    public static final OVERLAYS CROP;
    public static final OVERLAYS DRAW;
    public static final OVERLAYS EFFECTS;
    public static final OVERLAYS ENHANCE;
    public static final OVERLAYS FOCUS;
    public static final OVERLAYS FRAMES;
    public static final OVERLAYS LIGHTING;
    public static final OVERLAYS MEME;
    public static final OVERLAYS ORIENTATION;
    public static final OVERLAYS OVERLAYS;
    public static final OVERLAYS REDEYE;
    public static final OVERLAYS SHARPNESS;
    public static final OVERLAYS SPLASH;
    public static final OVERLAYS STICKERS;
    public static final OVERLAYS TEXT;
    public static final OVERLAYS VIGNETTE;
    public static final OVERLAYS WHITEN;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/aviary/android/feather/library/filters/ToolLoaderFactory$Tools, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        SHARPNESS = new <init>("SHARPNESS", 0);
        EFFECTS = new <init>("EFFECTS", 1);
        REDEYE = new <init>("REDEYE", 2);
        CROP = new <init>("CROP", 3);
        WHITEN = new <init>("WHITEN", 4);
        DRAW = new <init>("DRAW", 5);
        STICKERS = new <init>("STICKERS", 6);
        TEXT = new <init>("TEXT", 7);
        BLEMISH = new <init>("BLEMISH", 8);
        MEME = new <init>("MEME", 9);
        ORIENTATION = new <init>("ORIENTATION", 10);
        ENHANCE = new <init>("ENHANCE", 11);
        FRAMES = new <init>("FRAMES", 12);
        SPLASH = new <init>("SPLASH", 13);
        FOCUS = new <init>("FOCUS", 14);
        BLUR = new <init>("BLUR", 15);
        VIGNETTE = new <init>("VIGNETTE", 16);
        LIGHTING = new <init>("LIGHTING", 17);
        COLOR = new <init>("COLOR", 18);
        OVERLAYS = new <init>("OVERLAYS", 19);
        $VALUES = (new .VALUES[] {
            SHARPNESS, EFFECTS, REDEYE, CROP, WHITEN, DRAW, STICKERS, TEXT, BLEMISH, MEME, 
            ORIENTATION, ENHANCE, FRAMES, SPLASH, FOCUS, BLUR, VIGNETTE, LIGHTING, COLOR, OVERLAYS
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.activity;

import com.picsart.studio.editor.Tool;

// Referenced classes of package com.picsart.studio.editor.activity:
//            EditorActivity

final class questCode
{

    static final int a[];
    static final int b[];

    static 
    {
        b = new int[questCode.values().length];
        try
        {
            b[questCode.SELECT_TEXT.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror40) { }
        try
        {
            b[questCode.SELECT_CALLOUT.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror39) { }
        try
        {
            b[questCode.SELECT_LENS_FLARE.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror38) { }
        try
        {
            b[questCode.SELECT_CLIPART.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror37) { }
        try
        {
            b[questCode.SELECT_PHOTO.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror36) { }
        try
        {
            b[questCode.SELECT_FRAME.ordinal()] = 6;
        }
        catch (NoSuchFieldError nosuchfielderror35) { }
        try
        {
            b[questCode.SELECT_STICKER.ordinal()] = 7;
        }
        catch (NoSuchFieldError nosuchfielderror34) { }
        try
        {
            b[questCode.OPEN_RESIZE_DIALOG.ordinal()] = 8;
        }
        catch (NoSuchFieldError nosuchfielderror33) { }
        try
        {
            b[questCode.SHARE_PHOTO.ordinal()] = 9;
        }
        catch (NoSuchFieldError nosuchfielderror32) { }
        try
        {
            b[questCode.SAVE_PHOTO.ordinal()] = 10;
        }
        catch (NoSuchFieldError nosuchfielderror31) { }
        try
        {
            b[questCode.CLOSE_CONFIRM.ordinal()] = 11;
        }
        catch (NoSuchFieldError nosuchfielderror30) { }
        a = new int[Tool.values().length];
        try
        {
            a[Tool.VIEW.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror29) { }
        try
        {
            a[Tool.EFFECT.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror28) { }
        try
        {
            a[Tool.SQUARE_FIT.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror27) { }
        try
        {
            a[Tool.MASK.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror26) { }
        try
        {
            a[Tool.DRAW.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror25) { }
        try
        {
            a[Tool.TEXT.ordinal()] = 6;
        }
        catch (NoSuchFieldError nosuchfielderror24) { }
        try
        {
            a[Tool.CALLOUT.ordinal()] = 7;
        }
        catch (NoSuchFieldError nosuchfielderror23) { }
        try
        {
            a[Tool.LENS_FLARE.ordinal()] = 8;
        }
        catch (NoSuchFieldError nosuchfielderror22) { }
        try
        {
            a[Tool.CLIPART.ordinal()] = 9;
        }
        catch (NoSuchFieldError nosuchfielderror21) { }
        try
        {
            a[Tool.PHOTO.ordinal()] = 10;
        }
        catch (NoSuchFieldError nosuchfielderror20) { }
        try
        {
            a[Tool.STICKER.ordinal()] = 11;
        }
        catch (NoSuchFieldError nosuchfielderror19) { }
        try
        {
            a[Tool.FRAME.ordinal()] = 12;
        }
        catch (NoSuchFieldError nosuchfielderror18) { }
        try
        {
            a[Tool.FRAME_PHOTO.ordinal()] = 13;
        }
        catch (NoSuchFieldError nosuchfielderror17) { }
        try
        {
            a[Tool.SHAPE_MASK.ordinal()] = 14;
        }
        catch (NoSuchFieldError nosuchfielderror16) { }
        try
        {
            a[Tool.BORDER.ordinal()] = 15;
        }
        catch (NoSuchFieldError nosuchfielderror15) { }
        try
        {
            a[Tool.CROP.ordinal()] = 16;
        }
        catch (NoSuchFieldError nosuchfielderror14) { }
        try
        {
            a[Tool.FREE_CROP.ordinal()] = 17;
        }
        catch (NoSuchFieldError nosuchfielderror13) { }
        try
        {
            a[Tool.SHAPE_CROP.ordinal()] = 18;
        }
        catch (NoSuchFieldError nosuchfielderror12) { }
        try
        {
            a[Tool.SELECTION.ordinal()] = 19;
        }
        catch (NoSuchFieldError nosuchfielderror11) { }
        try
        {
            a[Tool.CLONE.ordinal()] = 20;
        }
        catch (NoSuchFieldError nosuchfielderror10) { }
        try
        {
            a[Tool.MOTION.ordinal()] = 21;
        }
        catch (NoSuchFieldError nosuchfielderror9) { }
        try
        {
            a[Tool.STRETCH.ordinal()] = 22;
        }
        catch (NoSuchFieldError nosuchfielderror8) { }
        try
        {
            a[Tool.CURVES.ordinal()] = 23;
        }
        catch (NoSuchFieldError nosuchfielderror7) { }
        try
        {
            a[Tool.ADJUST.ordinal()] = 24;
        }
        catch (NoSuchFieldError nosuchfielderror6) { }
        try
        {
            a[Tool.ENHANCE.ordinal()] = 25;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        try
        {
            a[Tool.TILT_SHIFT.ordinal()] = 26;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            a[Tool.RESIZE.ordinal()] = 27;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            a[Tool.TRANSFORM.ordinal()] = 28;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            a[Tool.PERSPECTIVE.ordinal()] = 29;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            a[Tool.GIFEXPORT.ordinal()] = 30;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}

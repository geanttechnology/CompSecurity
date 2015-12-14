// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.draw;


// Referenced classes of package com.socialin.android.photo.draw:
//            DrawingActivity

final class ingMode
{

    static final int a[];
    static final int b[];
    static final int c[];

    static 
    {
        c = new int[uestCode.values().length];
        try
        {
            c[uestCode.EXPORT.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror17) { }
        try
        {
            c[uestCode.SAVE_TO_SD.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror16) { }
        try
        {
            c[uestCode.CANCEL_CONFIRM.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror15) { }
        try
        {
            c[uestCode.SELECT_BRUSH.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror14) { }
        try
        {
            c[uestCode.SELECT_SHAPE.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror13) { }
        try
        {
            c[uestCode.SELECT_CLIPART.ordinal()] = 6;
        }
        catch (NoSuchFieldError nosuchfielderror12) { }
        try
        {
            c[uestCode.SELECT_TEXT.ordinal()] = 7;
        }
        catch (NoSuchFieldError nosuchfielderror11) { }
        try
        {
            c[uestCode.CHOOSE_PIC_FOR_LAYER.ordinal()] = 8;
        }
        catch (NoSuchFieldError nosuchfielderror10) { }
        try
        {
            c[uestCode.CHOOSE_PIC_FOR_ADD_PHOTO.ordinal()] = 9;
        }
        catch (NoSuchFieldError nosuchfielderror9) { }
        try
        {
            c[uestCode.CROP_IMG_FOR_LAYER.ordinal()] = 10;
        }
        catch (NoSuchFieldError nosuchfielderror8) { }
        try
        {
            c[uestCode.CROP_IMAGE_FOR_ADD_PHOTO.ordinal()] = 11;
        }
        catch (NoSuchFieldError nosuchfielderror7) { }
        b = new int[com.socialin.android.brushlib.view.Mode.values().length];
        try
        {
            b[com.socialin.android.brushlib.view.Mode.DRAW.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror6) { }
        try
        {
            b[com.socialin.android.brushlib.view.Mode.ERASE.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        a = new int[com.socialin.android.brushlib.view.Mode.values().length];
        try
        {
            a[com.socialin.android.brushlib.view.Mode.BRUSH.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            a[com.socialin.android.brushlib.view.Mode.PHOTO.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            a[com.socialin.android.brushlib.view.Mode.TEXT.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            a[com.socialin.android.brushlib.view.Mode.SHAPE.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            a[com.socialin.android.brushlib.view.Mode.COLOR_PICKER.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}

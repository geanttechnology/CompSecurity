// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.brushlib.view;

import com.socialin.android.brushlib.input.TouchResponse;

// Referenced classes of package com.socialin.android.brushlib.view:
//            DrawingView

public final class ate
{

    public static final int a[];
    static final int b[];
    public static final int c[];

    static 
    {
        c = new int[itingMode.values().length];
        try
        {
            c[itingMode.TEXT.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror12) { }
        try
        {
            c[itingMode.BRUSH.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror11) { }
        try
        {
            c[itingMode.COLOR_PICKER.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror10) { }
        try
        {
            c[itingMode.PHOTO.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror9) { }
        try
        {
            c[itingMode.SHAPE.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror8) { }
        try
        {
            c[itingMode.CAMERA.ordinal()] = 6;
        }
        catch (NoSuchFieldError nosuchfielderror7) { }
        try
        {
            c[itingMode.LAYER_TRANSFORM.ordinal()] = 7;
        }
        catch (NoSuchFieldError nosuchfielderror6) { }
        b = new int[TouchResponse.values().length];
        try
        {
            b[TouchResponse.REJECT.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        try
        {
            b[TouchResponse.UNDEFINED.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            b[TouchResponse.ACCEPT.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        a = new int[ate.values().length];
        try
        {
            a[ate.INITIALIZED.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            a[ate.INITIALIZING.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            a[ate.UNINITIALIZED.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}

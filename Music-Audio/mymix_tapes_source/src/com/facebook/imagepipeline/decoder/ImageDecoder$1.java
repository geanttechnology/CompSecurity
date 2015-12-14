// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.decoder;

import com.facebook.imageformat.ImageFormat;

// Referenced classes of package com.facebook.imagepipeline.decoder:
//            ImageDecoder

static class 
{

    static final int $SwitchMap$com$facebook$imageformat$ImageFormat[];

    static 
    {
        $SwitchMap$com$facebook$imageformat$ImageFormat = new int[ImageFormat.values().length];
        try
        {
            $SwitchMap$com$facebook$imageformat$ImageFormat[ImageFormat.UNKNOWN.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            $SwitchMap$com$facebook$imageformat$ImageFormat[ImageFormat.JPEG.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$facebook$imageformat$ImageFormat[ImageFormat.GIF.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$facebook$imageformat$ImageFormat[ImageFormat.WEBP_ANIMATED.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}

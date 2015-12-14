// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.producers;

import com.facebook.imageformat.ImageFormat;

// Referenced classes of package com.facebook.imagepipeline.producers:
//            WebpTranscodeProducer

static class 
{

    static final int $SwitchMap$com$facebook$imageformat$ImageFormat[];

    static 
    {
        $SwitchMap$com$facebook$imageformat$ImageFormat = new int[ImageFormat.values().length];
        try
        {
            $SwitchMap$com$facebook$imageformat$ImageFormat[ImageFormat.WEBP_SIMPLE.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            $SwitchMap$com$facebook$imageformat$ImageFormat[ImageFormat.WEBP_LOSSLESS.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            $SwitchMap$com$facebook$imageformat$ImageFormat[ImageFormat.WEBP_EXTENDED.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$facebook$imageformat$ImageFormat[ImageFormat.WEBP_EXTENDED_WITH_ALPHA.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$facebook$imageformat$ImageFormat[ImageFormat.UNKNOWN.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.common;


// Referenced classes of package com.facebook.imagepipeline.common:
//            ImageDecodeOptionsBuilder

public class ImageDecodeOptions
{

    private static final ImageDecodeOptions DEFAULTS = newBuilder().build();
    public final int backgroundColor;
    public final boolean decodeAllFrames;
    public final boolean decodePreviewFrame;
    public final boolean forceOldAnimationCode;
    public final int minDecodeIntervalMs;
    public final boolean useLastFrameForPreview;

    ImageDecodeOptions(ImageDecodeOptionsBuilder imagedecodeoptionsbuilder)
    {
        minDecodeIntervalMs = imagedecodeoptionsbuilder.getMinDecodeIntervalMs();
        backgroundColor = imagedecodeoptionsbuilder.getBackgroundColor();
        forceOldAnimationCode = imagedecodeoptionsbuilder.getForceOldAnimationCode();
        decodePreviewFrame = imagedecodeoptionsbuilder.getDecodePreviewFrame();
        useLastFrameForPreview = imagedecodeoptionsbuilder.getUseLastFrameForPreview();
        decodeAllFrames = imagedecodeoptionsbuilder.getDecodeAllFrames();
    }

    public static ImageDecodeOptions defaults()
    {
        return DEFAULTS;
    }

    public static ImageDecodeOptionsBuilder newBuilder()
    {
        return new ImageDecodeOptionsBuilder();
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null || getClass() != obj.getClass())
            {
                return false;
            }
            obj = (ImageDecodeOptions)obj;
            if (backgroundColor != ((ImageDecodeOptions) (obj)).backgroundColor)
            {
                return false;
            }
            if (forceOldAnimationCode != ((ImageDecodeOptions) (obj)).forceOldAnimationCode)
            {
                return false;
            }
            if (decodePreviewFrame != ((ImageDecodeOptions) (obj)).decodePreviewFrame)
            {
                return false;
            }
            if (useLastFrameForPreview != ((ImageDecodeOptions) (obj)).useLastFrameForPreview)
            {
                return false;
            }
            if (decodeAllFrames != ((ImageDecodeOptions) (obj)).decodeAllFrames)
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        int j = backgroundColor;
        int i;
        if (forceOldAnimationCode)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        return j * 31 + i;
    }

}

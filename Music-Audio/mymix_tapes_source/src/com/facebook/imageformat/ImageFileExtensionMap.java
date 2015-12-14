// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imageformat;


// Referenced classes of package com.facebook.imageformat:
//            ImageFormat

public class ImageFileExtensionMap
{

    private ImageFileExtensionMap()
    {
    }

    public static String getFileExtension(ImageFormat imageformat)
        throws UnsupportedOperationException
    {
        static class _cls1
        {

            static final int $SwitchMap$com$facebook$imageformat$ImageFormat[];

            static 
            {
                $SwitchMap$com$facebook$imageformat$ImageFormat = new int[ImageFormat.values().length];
                try
                {
                    $SwitchMap$com$facebook$imageformat$ImageFormat[ImageFormat.WEBP_SIMPLE.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                try
                {
                    $SwitchMap$com$facebook$imageformat$ImageFormat[ImageFormat.WEBP_LOSSLESS.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    $SwitchMap$com$facebook$imageformat$ImageFormat[ImageFormat.WEBP_EXTENDED.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$com$facebook$imageformat$ImageFormat[ImageFormat.WEBP_EXTENDED_WITH_ALPHA.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$facebook$imageformat$ImageFormat[ImageFormat.WEBP_ANIMATED.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$facebook$imageformat$ImageFormat[ImageFormat.JPEG.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$facebook$imageformat$ImageFormat[ImageFormat.PNG.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$facebook$imageformat$ImageFormat[ImageFormat.GIF.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$facebook$imageformat$ImageFormat[ImageFormat.BMP.ordinal()] = 9;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.facebook.imageformat.ImageFormat[imageformat.ordinal()])
        {
        default:
            throw new UnsupportedOperationException((new StringBuilder()).append("Unknown image format ").append(imageformat.name()).toString());

        case 1: // '\001'
        case 2: // '\002'
        case 3: // '\003'
        case 4: // '\004'
        case 5: // '\005'
            return "webp";

        case 6: // '\006'
            return "jpeg";

        case 7: // '\007'
            return "png";

        case 8: // '\b'
            return "gif";

        case 9: // '\t'
            return "bmp";
        }
    }
}

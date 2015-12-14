// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.decoder;

import com.facebook.common.internal.Closeables;
import com.facebook.common.references.CloseableReference;
import com.facebook.imageformat.GifFormatChecker;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imageformat.ImageFormatChecker;
import com.facebook.imagepipeline.animated.factory.AnimatedImageFactory;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.image.ImmutableQualityInfo;
import com.facebook.imagepipeline.image.QualityInfo;

public class ImageDecoder
{

    private final AnimatedImageFactory mAnimatedImageFactory;
    private final PlatformBitmapFactory mBitmapFactoryWithPool;

    public ImageDecoder(AnimatedImageFactory animatedimagefactory, PlatformBitmapFactory platformbitmapfactory)
    {
        mAnimatedImageFactory = animatedimagefactory;
        mBitmapFactoryWithPool = platformbitmapfactory;
    }

    public CloseableImage decodeAnimatedWebp(EncodedImage encodedimage, ImageDecodeOptions imagedecodeoptions)
    {
        return mAnimatedImageFactory.decodeWebP(encodedimage, imagedecodeoptions);
    }

    public CloseableImage decodeGif(EncodedImage encodedimage, ImageDecodeOptions imagedecodeoptions)
    {
        java.io.InputStream inputstream;
        inputstream = encodedimage.getInputStream();
        if (inputstream == null)
        {
            return null;
        }
        if (!GifFormatChecker.isAnimated(inputstream))
        {
            break MISSING_BLOCK_LABEL_34;
        }
        encodedimage = mAnimatedImageFactory.decodeGif(encodedimage, imagedecodeoptions);
        Closeables.closeQuietly(inputstream);
        return encodedimage;
        encodedimage = decodeStaticImage(encodedimage);
        Closeables.closeQuietly(inputstream);
        return encodedimage;
        encodedimage;
        Closeables.closeQuietly(inputstream);
        throw encodedimage;
    }

    public CloseableImage decodeImage(EncodedImage encodedimage, int i, QualityInfo qualityinfo, ImageDecodeOptions imagedecodeoptions)
    {
        ImageFormat imageformat;
label0:
        {
            ImageFormat imageformat1 = encodedimage.getImageFormat();
            if (imageformat1 != null)
            {
                imageformat = imageformat1;
                if (imageformat1 != ImageFormat.UNKNOWN)
                {
                    break label0;
                }
            }
            imageformat = ImageFormatChecker.getImageFormat_WrapIOException(encodedimage.getInputStream());
        }
        static class _cls1
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

        switch (_cls1..SwitchMap.com.facebook.imageformat.ImageFormat[imageformat.ordinal()])
        {
        default:
            return decodeStaticImage(encodedimage);

        case 1: // '\001'
            throw new IllegalArgumentException("unknown image format");

        case 2: // '\002'
            return decodeJpeg(encodedimage, i, qualityinfo);

        case 3: // '\003'
            return decodeGif(encodedimage, imagedecodeoptions);

        case 4: // '\004'
            return decodeAnimatedWebp(encodedimage, imagedecodeoptions);
        }
    }

    public CloseableStaticBitmap decodeJpeg(EncodedImage encodedimage, int i, QualityInfo qualityinfo)
    {
        CloseableReference closeablereference = mBitmapFactoryWithPool.decodeJPEGFromEncodedImage(encodedimage, i);
        encodedimage = new CloseableStaticBitmap(closeablereference, qualityinfo, encodedimage.getRotationAngle());
        closeablereference.close();
        return encodedimage;
        encodedimage;
        closeablereference.close();
        throw encodedimage;
    }

    public CloseableStaticBitmap decodeStaticImage(EncodedImage encodedimage)
    {
        CloseableReference closeablereference = mBitmapFactoryWithPool.decodeFromEncodedImage(encodedimage);
        encodedimage = new CloseableStaticBitmap(closeablereference, ImmutableQualityInfo.FULL_QUALITY, encodedimage.getRotationAngle());
        closeablereference.close();
        return encodedimage;
        encodedimage;
        closeablereference.close();
        throw encodedimage;
    }
}

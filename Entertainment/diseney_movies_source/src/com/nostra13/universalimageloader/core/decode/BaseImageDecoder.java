// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.core.decode;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.nostra13.universalimageloader.core.download.ImageDownloader;
import com.nostra13.universalimageloader.utils.ImageSizeUtils;
import com.nostra13.universalimageloader.utils.IoUtils;
import com.nostra13.universalimageloader.utils.L;
import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package com.nostra13.universalimageloader.core.decode:
//            ImageDecoder, ImageDecodingInfo

public class BaseImageDecoder
    implements ImageDecoder
{
    protected static class ExifInfo
    {

        final boolean flipHorizontal;
        final int rotation;

        ExifInfo()
        {
            rotation = 0;
            flipHorizontal = false;
        }

        ExifInfo(int i, boolean flag)
        {
            rotation = i;
            flipHorizontal = flag;
        }
    }

    protected static class ImageFileInfo
    {

        final ExifInfo exif;
        final ImageSize imageSize;

        ImageFileInfo(ImageSize imagesize, ExifInfo exifinfo)
        {
            imageSize = imagesize;
            exif = exifinfo;
        }
    }


    protected static final String ERROR_CANT_DECODE_IMAGE = "Image can't be decoded [%s]";
    protected static final String LOG_FLIP_IMAGE = "Flip image horizontally [%s]";
    protected static final String LOG_ROTATE_IMAGE = "Rotate image on %1$d\260 [%2$s]";
    protected static final String LOG_SABSAMPLE_IMAGE = "Subsample original image (%1$s) to %2$s (scale = %3$d) [%4$s]";
    protected static final String LOG_SCALE_IMAGE = "Scale subsampled image (%1$s) to %2$s (scale = %3$.5f) [%4$s]";
    protected boolean loggingEnabled;

    public BaseImageDecoder()
    {
    }

    public BaseImageDecoder(boolean flag)
    {
        loggingEnabled = flag;
    }

    protected Bitmap considerExactScaleAndOrientaiton(Bitmap bitmap, ImageDecodingInfo imagedecodinginfo, int i, boolean flag)
    {
        Matrix matrix = new Matrix();
        ImageScaleType imagescaletype = imagedecodinginfo.getImageScaleType();
        if (imagescaletype == ImageScaleType.EXACTLY || imagescaletype == ImageScaleType.EXACTLY_STRETCHED)
        {
            ImageSize imagesize = new ImageSize(bitmap.getWidth(), bitmap.getHeight(), i);
            ImageSize imagesize1 = imagedecodinginfo.getTargetSize();
            com.nostra13.universalimageloader.core.assist.ViewScaleType viewscaletype = imagedecodinginfo.getViewScaleType();
            float f;
            boolean flag1;
            if (imagescaletype == ImageScaleType.EXACTLY_STRETCHED)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            f = ImageSizeUtils.computeImageScale(imagesize, imagesize1, viewscaletype, flag1);
            if (Float.compare(f, 1.0F) != 0)
            {
                matrix.setScale(f, f);
                if (loggingEnabled)
                {
                    L.i("Scale subsampled image (%1$s) to %2$s (scale = %3$.5f) [%4$s]", new Object[] {
                        imagesize, imagesize.scale(f), Float.valueOf(f), imagedecodinginfo.getImageKey()
                    });
                }
            }
        }
        if (flag)
        {
            matrix.postScale(-1F, 1.0F);
            if (loggingEnabled)
            {
                L.i("Flip image horizontally [%s]", new Object[] {
                    imagedecodinginfo.getImageKey()
                });
            }
        }
        if (i != 0)
        {
            matrix.postRotate(i);
            if (loggingEnabled)
            {
                L.i("Rotate image on %1$d\260 [%2$s]", new Object[] {
                    Integer.valueOf(i), imagedecodinginfo.getImageKey()
                });
            }
        }
        imagedecodinginfo = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        if (imagedecodinginfo != bitmap)
        {
            bitmap.recycle();
        }
        return imagedecodinginfo;
    }

    public Bitmap decode(ImageDecodingInfo imagedecodinginfo)
        throws IOException
    {
        ImageFileInfo imagefileinfo = defineImageSizeAndRotation(getImageStream(imagedecodinginfo), imagedecodinginfo.getImageUri());
        Object obj = prepareDecodingOptions(imagefileinfo.imageSize, imagedecodinginfo);
        obj = decodeStream(getImageStream(imagedecodinginfo), ((android.graphics.BitmapFactory.Options) (obj)));
        if (obj == null)
        {
            L.e("Image can't be decoded [%s]", new Object[] {
                imagedecodinginfo.getImageKey()
            });
            return ((Bitmap) (obj));
        } else
        {
            return considerExactScaleAndOrientaiton(((Bitmap) (obj)), imagedecodinginfo, imagefileinfo.exif.rotation, imagefileinfo.exif.flipHorizontal);
        }
    }

    protected Bitmap decodeStream(InputStream inputstream, android.graphics.BitmapFactory.Options options)
        throws IOException
    {
        options = BitmapFactory.decodeStream(inputstream, null, options);
        IoUtils.closeSilently(inputstream);
        return options;
        options;
        IoUtils.closeSilently(inputstream);
        throw options;
    }

    protected ExifInfo defineExifOrientation(String s, String s1)
    {
        int i;
        boolean flag;
        boolean flag1;
        boolean flag2;
        boolean flag3;
        boolean flag4;
        boolean flag5;
        boolean flag6;
        flag = false;
        flag6 = false;
        flag2 = false;
        flag3 = false;
        flag4 = false;
        flag5 = false;
        flag1 = flag5;
        i = ((flag) ? 1 : 0);
        if (!"image/jpeg".equalsIgnoreCase(s1)) goto _L2; else goto _L1
_L1:
        flag1 = flag5;
        i = ((flag) ? 1 : 0);
        if (com.nostra13.universalimageloader.core.download.ImageDownloader.Scheme.ofUri(s) != com.nostra13.universalimageloader.core.download.ImageDownloader.Scheme.FILE) goto _L2; else goto _L3
_L3:
        i = (new ExifInterface(com.nostra13.universalimageloader.core.download.ImageDownloader.Scheme.FILE.crop(s))).getAttributeInt("Orientation", 1);
        flag1 = flag6;
        i;
        JVM INSTR tableswitch 1 8: default 124
    //                   1 145
    //                   2 142
    //                   3 166
    //                   4 163
    //                   5 177
    //                   6 153
    //                   7 150
    //                   8 180;
           goto _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12
_L4:
        i = ((flag) ? 1 : 0);
        flag1 = flag5;
_L2:
        return new ExifInfo(i, flag1);
_L6:
        flag1 = true;
_L5:
        i = 0;
        continue; /* Loop/switch isn't completed */
_L11:
        flag2 = true;
_L10:
        i = 90;
        flag1 = flag2;
        continue; /* Loop/switch isn't completed */
_L8:
        flag3 = true;
_L7:
        i = 180;
        flag1 = flag3;
        continue; /* Loop/switch isn't completed */
_L9:
        flag4 = true;
_L12:
        i = 270;
        flag1 = flag4;
        continue; /* Loop/switch isn't completed */
        s1;
        L.w("Can't read EXIF tags from file [%s]", new Object[] {
            s
        });
        flag1 = flag5;
        i = ((flag) ? 1 : 0);
        if (true) goto _L2; else goto _L13
_L13:
    }

    protected ImageFileInfo defineImageSizeAndRotation(InputStream inputstream, String s)
        throws IOException
    {
        android.graphics.BitmapFactory.Options options;
        options = new android.graphics.BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(inputstream, null, options);
        IoUtils.closeSilently(inputstream);
        if (android.os.Build.VERSION.SDK_INT >= 5)
        {
            inputstream = defineExifOrientation(s, options.outMimeType);
        } else
        {
            inputstream = new ExifInfo();
        }
        return new ImageFileInfo(new ImageSize(options.outWidth, options.outHeight, ((ExifInfo) (inputstream)).rotation), inputstream);
        s;
        IoUtils.closeSilently(inputstream);
        throw s;
    }

    protected InputStream getImageStream(ImageDecodingInfo imagedecodinginfo)
        throws IOException
    {
        return imagedecodinginfo.getDownloader().getStream(imagedecodinginfo.getImageUri(), imagedecodinginfo.getExtraForDownloader());
    }

    protected android.graphics.BitmapFactory.Options prepareDecodingOptions(ImageSize imagesize, ImageDecodingInfo imagedecodinginfo)
    {
        ImageScaleType imagescaletype = imagedecodinginfo.getImageScaleType();
        ImageSize imagesize1 = imagedecodinginfo.getTargetSize();
        int i = 1;
        if (imagescaletype != ImageScaleType.NONE)
        {
            int j;
            boolean flag;
            if (imagescaletype == ImageScaleType.IN_SAMPLE_POWER_OF_2)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            j = ImageSizeUtils.computeImageSampleSize(imagesize, imagesize1, imagedecodinginfo.getViewScaleType(), flag);
            i = j;
            if (loggingEnabled)
            {
                L.i("Subsample original image (%1$s) to %2$s (scale = %3$d) [%4$s]", new Object[] {
                    imagesize, imagesize.scaleDown(j), Integer.valueOf(j), imagedecodinginfo.getImageKey()
                });
                i = j;
            }
        }
        imagesize = imagedecodinginfo.getDecodingOptions();
        imagesize.inSampleSize = i;
        return imagesize;
    }

    public void setLoggingEnabled(boolean flag)
    {
        loggingEnabled = flag;
    }
}

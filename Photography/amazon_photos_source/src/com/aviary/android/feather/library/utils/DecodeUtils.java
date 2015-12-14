// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.library.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import com.aviary.android.feather.common.log.LoggerFactory;
import com.aviary.android.feather.common.utils.ApiHelper;
import com.aviary.android.feather.common.utils.IOUtils;
import it.sephiroth.android.library.exif2.ExifInterface;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import junit.framework.Assert;

// Referenced classes of package com.aviary.android.feather.library.utils:
//            ImageInfo, ExifUtils, BitmapUtils

public final class DecodeUtils
{

    public static final float MAX_SAMPLE_SIZE_BOUNDS = 1.5F;
    public static final double SAMPLE_SIZE_INCREASE_RATIO = 1.2D;
    static com.aviary.android.feather.common.log.LoggerFactory.Logger logger;

    private DecodeUtils()
    {
    }

    public static int computeSampleSize(int i, int j, int k, int l, int i1, ImageInfo imageinfo)
    {
        double d;
        double d1;
        if (i1 == 0 || i1 == 180)
        {
            d1 = i;
            d = j;
        } else
        {
            d1 = j;
            d = i;
        }
        if (imageinfo != null)
        {
            imageinfo.setOriginalSize((int)d1, (int)d);
        }
        return (int)Math.ceil(Math.max(d1 / (double)k, d / (double)l));
    }

    public static Bitmap decode(Context context, Uri uri, int i, int j, ImageInfo imageinfo)
    {
        logger.info((new StringBuilder()).append("decode: ").append(uri).toString());
        Assert.assertNotNull(imageinfo);
        Object obj = null;
        int ai[] = new int[2];
        imageinfo.setUri(uri);
        InputStream inputstream = openInputStream(context, uri);
        if (inputstream == null)
        {
            return null;
        }
        logger.log("reading exif");
        ExifInterface exifinterface = new ExifInterface();
        int i1;
        boolean flag;
        try
        {
            exifinterface.readExif(inputstream, 63);
            int ai1[] = exifinterface.getImageSize();
            logger.log("(exif) image size: %dx%d", new Object[] {
                Integer.valueOf(ai1[0]), Integer.valueOf(ai1[1])
            });
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
        imageinfo.setExifTagList(exifinterface.getAllTags());
        i1 = ExifUtils.getOrientation(exifinterface);
        imageinfo.setOrientation(i1);
        logger.log("orientation: %d", new Object[] {
            Integer.valueOf(i1)
        });
        IOUtils.closeSilently(inputstream);
        inputstream = openInputStream(context, uri);
        flag = decodeImageBounds(inputstream, ai);
        IOUtils.closeSilently(inputstream);
        if (flag)
        {
            int l = computeSampleSize(ai[0], ai[1], (int)((double)i * 1.2D), (int)((double)j * 1.2D), i1, imageinfo);
            obj = getDefaultOptions();
            float f = i;
            float f1 = j;
            int k = l;
            if ((float)ai[1] < 100F + f * 1.5F)
            {
                k = l;
                if ((float)ai[1] < f1 * 1.5F)
                {
                    logger.info("try to use sample size = 1");
                    k = 1;
                }
            }
            obj.inSampleSize = k;
            context = decodeBitmap(context, uri, ((android.graphics.BitmapFactory.Options) (obj)), i, j, i1, 0);
            obj = context;
            if (context != null)
            {
                obj = context;
                if (imageinfo != null)
                {
                    imageinfo.setDecodedSize(context.getWidth(), context.getHeight());
                    imageinfo.setOrientation(i1);
                    obj = context;
                }
            }
        }
        logger.log("returning bitmap");
        return ((Bitmap) (obj));
    }

    static Bitmap decodeBitmap(Context context, Uri uri, android.graphics.BitmapFactory.Options options, int i, int j, int k, int l)
    {
        Bitmap bitmap;
        InputStream inputstream;
        bitmap = null;
        logger.info((new StringBuilder()).append("decodeBitmap: ").append(options.inSampleSize).append(", maxSize: ").append(i).append("x").append(j).append(", pass: ").append(l).toString());
        if (l > 10)
        {
            return null;
        }
        inputstream = openInputStream(context, uri);
        if (inputstream == null)
        {
            return null;
        }
        logger.warn("opened input stream");
        Bitmap bitmap1 = BitmapFactory.decodeStream(inputstream, null, options);
        bitmap = bitmap1;
        IOUtils.closeSilently(inputstream);
        bitmap = bitmap1;
        if (bitmap1 == null)
        {
            break MISSING_BLOCK_LABEL_254;
        }
        bitmap = bitmap1;
        logger.log((new StringBuilder()).append("loaded bitmap: ").append(bitmap1.getWidth()).append("x").append(bitmap1.getHeight()).toString());
        bitmap = bitmap1;
        Bitmap bitmap2 = BitmapUtils.resizeBitmap(bitmap1, i, j, k);
        bitmap = bitmap1;
        logger.log((new StringBuilder()).append("resized: ").append(bitmap2.getWidth()).append("x").append(bitmap2.getHeight()).toString());
        if (bitmap1 == bitmap2)
        {
            break MISSING_BLOCK_LABEL_250;
        }
        bitmap = bitmap1;
        bitmap1.recycle();
        bitmap = bitmap2;
_L2:
        return bitmap;
        OutOfMemoryError outofmemoryerror;
        outofmemoryerror;
        logger.error(outofmemoryerror.getMessage());
        IOUtils.closeSilently(inputstream);
        if (bitmap != null)
        {
            bitmap.recycle();
        }
        options.inSampleSize = options.inSampleSize + 1;
        bitmap = decodeBitmap(context, uri, options, i, j, k, l + 1);
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static boolean decodeImageBounds(InputStream inputstream, int ai[])
    {
        logger.info("decodeImageBounds");
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(inputstream, null, options);
        if (options.outHeight > 0 && options.outWidth > 0)
        {
            ai[0] = options.outWidth;
            ai[1] = options.outHeight;
            return true;
        } else
        {
            return false;
        }
    }

    static ByteArrayInputStream dup(InputStream inputstream)
        throws IOException
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        IOUtils.copyFile(inputstream, bytearrayoutputstream);
        inputstream = new ByteArrayInputStream(bytearrayoutputstream.toByteArray());
        IOUtils.closeSilently(bytearrayoutputstream);
        return inputstream;
    }

    static android.graphics.BitmapFactory.Options getDefaultOptions()
    {
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inScaled = false;
        options.inPreferredConfig = android.graphics.Bitmap.Config.ARGB_8888;
        options.inDither = false;
        options.inJustDecodeBounds = false;
        options.inPurgeable = false;
        options.inInputShareable = false;
        options.inTempStorage = new byte[16384];
        return options;
    }

    static InputStream openContentInputStream(Context context, Uri uri)
    {
        logger.info("openContentInputStream: %s", new Object[] {
            uri
        });
        if (!ApiHelper.AT_LEAST_19)
        {
            break MISSING_BLOCK_LABEL_42;
        }
        InputStream inputstream = openParcelFileDescriptor(context, uri);
        if (inputstream != null)
        {
            return inputstream;
        }
        break MISSING_BLOCK_LABEL_42;
        FileNotFoundException filenotfoundexception;
        filenotfoundexception;
        filenotfoundexception.printStackTrace();
        InputStream inputstream1;
        try
        {
            inputstream1 = context.getContentResolver().openInputStream(uri);
        }
        catch (FileNotFoundException filenotfoundexception1)
        {
            filenotfoundexception1.printStackTrace();
            context = IOUtils.getRealFilePath(context, uri);
            if (context != null)
            {
                return openFileInputStream(context);
            } else
            {
                return null;
            }
        }
        return inputstream1;
    }

    static InputStream openFileInputStream(String s)
    {
        logger.info("openFileInputStream: %s", new Object[] {
            s
        });
        try
        {
            s = new FileInputStream(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return null;
        }
        return s;
    }

    public static InputStream openInputStream(Context context, Uri uri)
    {
        if (uri != null)
        {
            String s = uri.getScheme();
            if (s == null || "file".equals(s))
            {
                if ("file".equals(s) && uri.getPath().startsWith("/android_asset/"))
                {
                    try
                    {
                        context = context.getAssets().open(uri.getPath().substring("/android_asset/".length()));
                    }
                    // Misplaced declaration of an exception variable
                    catch (Context context)
                    {
                        context.printStackTrace();
                        return null;
                    }
                    return context;
                } else
                {
                    return openFileInputStream(uri.getPath());
                }
            }
            if ("content".equals(s))
            {
                return openContentInputStream(context, uri);
            }
            if ("http".equals(s) || "https".equals(s))
            {
                return openRemoteInputStream(uri);
            }
        }
        return null;
    }

    static InputStream openParcelFileDescriptor(Context context, Uri uri)
        throws FileNotFoundException
    {
        logger.log("openParcelFileDescriptor: %s", new Object[] {
            uri
        });
        context = context.getContentResolver().openFileDescriptor(uri, "r");
        logger.log("parcelFileDescriptor: %s", new Object[] {
            context
        });
        return new android.os.ParcelFileDescriptor.AutoCloseInputStream(context);
    }

    static InputStream openRemoteInputStream(Uri uri)
    {
        HttpURLConnection httpurlconnection;
        int i;
        try
        {
            uri = new URL(uri.toString());
        }
        // Misplaced declaration of an exception variable
        catch (Uri uri)
        {
            uri.printStackTrace();
            return null;
        }
        try
        {
            httpurlconnection = (HttpURLConnection)uri.openConnection();
        }
        // Misplaced declaration of an exception variable
        catch (Uri uri)
        {
            uri.printStackTrace();
            return null;
        }
        httpurlconnection.setInstanceFollowRedirects(false);
        try
        {
            i = httpurlconnection.getResponseCode();
        }
        // Misplaced declaration of an exception variable
        catch (Uri uri)
        {
            uri.printStackTrace();
            return null;
        }
        if (i == 301 || i == 302 || i == 303)
        {
            return openRemoteInputStream(Uri.parse(httpurlconnection.getHeaderField("Location")));
        }
        try
        {
            uri = (InputStream)uri.getContent();
        }
        // Misplaced declaration of an exception variable
        catch (Uri uri)
        {
            uri.printStackTrace();
            return null;
        }
        return uri;
    }

    static 
    {
        logger = LoggerFactory.getLogger("DecodeUtils", com.aviary.android.feather.common.log.LoggerFactory.LoggerType.ConsoleLoggerType);
    }
}

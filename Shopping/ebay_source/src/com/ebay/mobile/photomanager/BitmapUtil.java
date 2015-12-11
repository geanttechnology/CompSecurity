// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.photomanager;

import android.content.ContentResolver;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.view.View;
import com.ebay.nautilus.kernel.util.FwLog;
import com.ebay.nautilus.kernel.util.StreamUtil;

// Referenced classes of package com.ebay.mobile.photomanager:
//            CropPhotoActivity

public final class BitmapUtil
{

    public static final int JPEG_COMPRESSION_LEVEL = 90;
    private static final int LEGACY_MAX_IMAGE_WIDTH_HEIGHT = 1200;
    private static final int MAX_IMAGE_WIDTH_HEIGHT = 1600;

    public BitmapUtil()
    {
    }

    private static int calculateInSampleSize(android.graphics.BitmapFactory.Options options, int i, int j)
    {
        int i1 = options.outHeight;
        int j1 = options.outWidth;
        int l = 1;
        int k = 1;
        if (i1 > j || j1 > i)
        {
            i1 /= 2;
            j1 /= 2;
            do
            {
                l = k;
                if (i1 / k <= j)
                {
                    break;
                }
                l = k;
                if (j1 / k <= i)
                {
                    break;
                }
                k *= 2;
            } while (true);
        }
        return l;
    }

    private static int calculateLegacyInSampleSize(android.graphics.BitmapFactory.Options options, int i)
    {
        int j = 1;
        if (options.outHeight > i || options.outWidth > i)
        {
            j = (int)Math.pow(2D, (int)Math.round(Math.log((double)i / (double)Math.max(options.outHeight, options.outWidth)) / Math.log(0.5D)));
        }
        return j;
    }

    private static android.graphics.BitmapFactory.Options getBoundsOptions(ContentResolver contentresolver, Uri uri)
    {
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        Object obj = null;
        try
        {
            contentresolver = contentresolver.openInputStream(uri);
        }
        // Misplaced declaration of an exception variable
        catch (ContentResolver contentresolver)
        {
            contentresolver = obj;
        }
        if (contentresolver == null)
        {
            return null;
        }
        try
        {
            BitmapFactory.decodeStream(contentresolver, null, options);
        }
        // Misplaced declaration of an exception variable
        catch (Uri uri) { }
        StreamUtil.closeQuietly(contentresolver);
        return options;
    }

    private static Bitmap getLegacyScaledBitmap(ContentResolver contentresolver, Uri uri, android.graphics.BitmapFactory.Options options, int i)
    {
        i = calculateLegacyInSampleSize(options, i);
        if (CropPhotoActivity.log.isLoggable)
        {
            FwLog.println(CropPhotoActivity.log, (new StringBuilder()).append("Falling back to legacy downsample: ").append(i).toString());
        }
        options = null;
        int j;
        try
        {
            uri = contentresolver.openInputStream(uri);
        }
        // Misplaced declaration of an exception variable
        catch (ContentResolver contentresolver)
        {
            uri = options;
        }
        if (uri != null) goto _L2; else goto _L1
_L1:
        uri = null;
_L6:
        return uri;
_L2:
        options = null;
        contentresolver = new android.graphics.BitmapFactory.Options();
        contentresolver.inSampleSize = i;
        contentresolver.inPreferredConfig = android.graphics.Bitmap.Config.RGB_565;
        contentresolver = BitmapFactory.decodeStream(uri, null, contentresolver);
_L4:
        StreamUtil.closeQuietly(uri);
        if (contentresolver == null)
        {
            return null;
        }
        break; /* Loop/switch isn't completed */
        contentresolver;
        contentresolver = options;
        if (CropPhotoActivity.log.isLoggable)
        {
            FwLog.println(CropPhotoActivity.log, "Legacy downsample failed");
            contentresolver = options;
        }
        if (true) goto _L4; else goto _L3
_L3:
        i = contentresolver.getWidth();
        j = contentresolver.getHeight();
        uri = contentresolver;
        if (CropPhotoActivity.log.isLoggable)
        {
            FwLog.println(CropPhotoActivity.log, (new StringBuilder()).append("Downsampled image width: ").append(i).append(" height:").append(j).toString());
            return contentresolver;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    private static int getOrientation(ContentResolver contentresolver, Uri uri)
    {
        boolean flag;
        boolean flag1;
        flag = false;
        flag1 = false;
        if (!"content".equals(uri.getScheme())) goto _L2; else goto _L1
_L1:
        int i;
        try
        {
            contentresolver = contentresolver.query(uri, new String[] {
                "orientation"
            }, null, null, null);
        }
        // Misplaced declaration of an exception variable
        catch (ContentResolver contentresolver)
        {
            i = ((flag) ? 1 : 0);
            if (false)
            {
                throw new NullPointerException();
            }
            continue; /* Loop/switch isn't completed */
        }
        finally
        {
            if (false)
            {
                throw new NullPointerException();
            } else
            {
                throw contentresolver;
            }
        }
        i = ((flag) ? 1 : 0);
        if (contentresolver != null)
        {
            i = ((flag1) ? 1 : 0);
            if (contentresolver.getCount() == 1)
            {
                contentresolver.moveToFirst();
                i = contentresolver.getInt(0);
            }
            contentresolver.close();
        }
_L4:
        return i;
_L2:
        i = ((flag) ? 1 : 0);
        if ("file".equals(uri.getScheme()))
        {
            int j;
            try
            {
                j = (new ExifInterface(uri.getPath())).getAttributeInt("Orientation", 1);
            }
            // Misplaced declaration of an exception variable
            catch (ContentResolver contentresolver)
            {
                return 0;
            }
            if (j == 6)
            {
                return 90;
            }
            if (j == 3)
            {
                return 180;
            }
            i = ((flag) ? 1 : 0);
            if (j == 8)
            {
                return 270;
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private static Bitmap getRotatedBitmap(ContentResolver contentresolver, Uri uri, Bitmap bitmap)
    {
        int i = getOrientation(contentresolver, uri);
        if (i != 0) goto _L2; else goto _L1
_L1:
        return bitmap;
_L2:
        if (CropPhotoActivity.log.isLoggable)
        {
            FwLog.println(CropPhotoActivity.log, (new StringBuilder()).append("Generating rotated bitmap: ").append(i).toString());
        }
        uri = new Matrix();
        uri.postRotate(i);
        contentresolver = null;
        uri = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), uri, true);
        contentresolver = uri;
_L4:
        if (contentresolver != null)
        {
            bitmap.recycle();
            return contentresolver;
        }
        if (true) goto _L1; else goto _L3
_L3:
        uri;
          goto _L4
    }

    private static Bitmap getScaledBitmap(ContentResolver contentresolver, Uri uri, android.graphics.BitmapFactory.Options options, int i)
    {
        if (CropPhotoActivity.log.isLoggable)
        {
            FwLog.println(CropPhotoActivity.log, (new StringBuilder()).append("Original image width: ").append(options.outWidth).append(" height:").append(options.outHeight).toString());
        }
        Object obj = null;
        float f;
        int j;
        int k;
        try
        {
            uri = contentresolver.openInputStream(uri);
        }
        // Misplaced declaration of an exception variable
        catch (ContentResolver contentresolver)
        {
            uri = obj;
        }
        if (uri != null) goto _L2; else goto _L1
_L1:
        uri = null;
_L6:
        return uri;
_L2:
        j = calculateInSampleSize(options, i, i);
        if (CropPhotoActivity.log.isLoggable)
        {
            FwLog.println(CropPhotoActivity.log, (new StringBuilder()).append("Downsampling image by ").append(j).toString());
        }
        options = null;
        contentresolver = new android.graphics.BitmapFactory.Options();
        contentresolver.inSampleSize = j;
        contentresolver.inPreferredConfig = android.graphics.Bitmap.Config.RGB_565;
        contentresolver = BitmapFactory.decodeStream(uri, null, contentresolver);
_L4:
        StreamUtil.closeQuietly(uri);
        if (contentresolver == null)
        {
            return null;
        }
        break; /* Loop/switch isn't completed */
        contentresolver;
        contentresolver = options;
        if (CropPhotoActivity.log.isLoggable)
        {
            FwLog.println(CropPhotoActivity.log, "Downsample failed");
            contentresolver = options;
        }
        if (true) goto _L4; else goto _L3
_L3:
        j = contentresolver.getWidth();
        k = contentresolver.getHeight();
        if (CropPhotoActivity.log.isLoggable)
        {
            FwLog.println(CropPhotoActivity.log, (new StringBuilder()).append("Downsampled image width: ").append(j).append(" height:").append(k).toString());
        }
        if (j > 1600 || k > 1600)
        {
            break; /* Loop/switch isn't completed */
        }
        uri = contentresolver;
        if (CropPhotoActivity.log.isLoggable)
        {
            FwLog.println(CropPhotoActivity.log, (new StringBuilder()).append("Skipping precise scale, image width:").append(j).append(" height:").append(k).toString());
            return contentresolver;
        }
        if (true) goto _L6; else goto _L5
_L5:
        f = (float)j / (float)k;
        j = i;
        k = i;
        if (f > 1.0F)
        {
            k = (int)((float)i / f);
        } else
        {
            j = (int)((float)i * f);
        }
        if (CropPhotoActivity.log.isLoggable)
        {
            FwLog.println(CropPhotoActivity.log, (new StringBuilder()).append("Scaling width:").append(j).append(" height:").append(k).toString());
        }
        uri = Bitmap.createScaledBitmap(contentresolver, j, k, true);
        contentresolver.recycle();
        return uri;
        uri;
        uri = contentresolver;
        if (CropPhotoActivity.log.isLoggable)
        {
            FwLog.println(CropPhotoActivity.log, "Precise resize failed");
            return contentresolver;
        }
        if (true) goto _L6; else goto _L7
_L7:
    }

    public static Bitmap getViewBitmap(View view)
    {
        Bitmap bitmap = null;
        view.clearFocus();
        view.setPressed(false);
        boolean flag = view.willNotCacheDrawing();
        view.setWillNotCacheDrawing(false);
        int i = view.getDrawingCacheBackgroundColor();
        view.setDrawingCacheBackgroundColor(0);
        if (i != 0)
        {
            view.destroyDrawingCache();
        }
        view.buildDrawingCache();
        Bitmap bitmap1 = view.getDrawingCache();
        if (bitmap1 != null)
        {
            bitmap = Bitmap.createBitmap(bitmap1);
        }
        view.destroyDrawingCache();
        view.setWillNotCacheDrawing(flag);
        view.setDrawingCacheBackgroundColor(i);
        return bitmap;
    }

    public static Bitmap loadLargeBitmap(ContentResolver contentresolver, Uri uri)
    {
        android.graphics.BitmapFactory.Options options = getBoundsOptions(contentresolver, uri);
        if (options != null)
        {
            Bitmap bitmap1 = getScaledBitmap(contentresolver, uri, options, 1600);
            Bitmap bitmap = bitmap1;
            if (bitmap1 == null)
            {
                bitmap = getLegacyScaledBitmap(contentresolver, uri, options, 1200);
            }
            if (bitmap != null)
            {
                return getRotatedBitmap(contentresolver, uri, bitmap);
            }
        }
        return null;
    }
}

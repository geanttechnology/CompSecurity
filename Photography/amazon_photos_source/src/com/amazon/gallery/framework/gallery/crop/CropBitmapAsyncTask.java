// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.crop;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.foundation.utils.math.MathUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.RandomStringUtils;

// Referenced classes of package com.amazon.gallery.framework.gallery.crop:
//            CropParameters, CropActivity

public class CropBitmapAsyncTask extends AsyncTask
{
    public static class AsyncCropResult
    {

        public Bitmap bitmap;
        public Uri uri;

        public AsyncCropResult()
        {
        }
    }


    private static final String TAG = com/amazon/gallery/framework/gallery/crop/CropBitmapAsyncTask.getName();
    private final CropActivity activity;
    private final CropParameters cropParams;
    private final RectF cropRect;

    public CropBitmapAsyncTask(CropActivity cropactivity, CropParameters cropparameters, RectF rectf)
    {
        activity = cropactivity;
        cropParams = cropparameters;
        cropRect = rectf;
    }

    private Bitmap downScaleBitmap(Bitmap bitmap)
    {
        GLogger.i(TAG, "Down scaling bitmap to fit into bundle", new Object[0]);
        RectF rectf = MathUtils.scaleToFit(bitmap.getWidth(), bitmap.getHeight(), new RectF(0.0F, 0.0F, 256F, 256F), true);
        return Bitmap.createScaledBitmap(bitmap, (int)rectf.width(), (int)rectf.height(), false);
    }

    protected transient AsyncCropResult doInBackground(Bitmap abitmap[])
    {
        java.io.Closeable closeable;
        Object obj;
        java.io.Closeable closeable1;
        Object obj1;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        Object obj6;
        ByteArrayOutputStream bytearrayoutputstream;
        AsyncCropResult asynccropresult;
        obj2 = null;
        obj4 = null;
        obj3 = null;
        obj5 = null;
        obj6 = null;
        bytearrayoutputstream = null;
        asynccropresult = new AsyncCropResult();
        closeable1 = obj5;
        obj1 = obj2;
        closeable = obj6;
        obj = obj4;
        Object obj7 = new Matrix();
        closeable1 = obj5;
        obj1 = obj2;
        closeable = obj6;
        obj = obj4;
        if (cropParams.getOutputX() <= 0)
        {
            break MISSING_BLOCK_LABEL_149;
        }
        closeable1 = obj5;
        obj1 = obj2;
        closeable = obj6;
        obj = obj4;
        if (cropParams.getOutputY() <= 0)
        {
            break MISSING_BLOCK_LABEL_149;
        }
        closeable1 = obj5;
        obj1 = obj2;
        closeable = obj6;
        obj = obj4;
        ((Matrix) (obj7)).setScale((float)cropParams.getOutputX() / cropRect.width(), (float)cropParams.getOutputY() / cropRect.height());
        closeable1 = obj5;
        obj1 = obj2;
        closeable = obj6;
        obj = obj4;
        abitmap = Bitmap.createBitmap(abitmap[0], (int)cropRect.left, (int)cropRect.top, (int)cropRect.width(), (int)cropRect.height(), ((Matrix) (obj7)), true);
        closeable1 = obj5;
        obj1 = obj2;
        closeable = obj6;
        obj = obj4;
        if (!cropParams.isReturningUri()) goto _L2; else goto _L1
_L1:
        closeable1 = obj5;
        obj1 = obj2;
        closeable = obj6;
        obj = obj4;
        bytearrayoutputstream = new ByteArrayOutputStream();
        closeable1 = obj5;
        obj1 = obj2;
        closeable = obj6;
        obj = obj4;
        obj7 = cropParams.getCompressFormat();
        closeable1 = obj5;
        obj1 = obj2;
        closeable = obj6;
        obj = obj4;
        abitmap.compress(((android.graphics.Bitmap.CompressFormat) (obj7)), 90, bytearrayoutputstream);
        closeable1 = obj5;
        obj1 = obj2;
        closeable = obj6;
        obj = obj4;
        abitmap = cropParams.getOutputUri();
        obj3 = abitmap;
        if (abitmap != null)
        {
            break MISSING_BLOCK_LABEL_396;
        }
        closeable1 = obj5;
        obj1 = obj2;
        closeable = obj6;
        obj = obj4;
        obj3 = Uri.fromFile(new File(activity.getExternalFilesDir(Environment.DIRECTORY_PICTURES), (new StringBuilder()).append(RandomStringUtils.randomAlphabetic(8)).append(".").append(((android.graphics.Bitmap.CompressFormat) (obj7)).name()).toString()));
        closeable1 = obj5;
        obj1 = obj2;
        closeable = obj6;
        obj = obj4;
        abitmap = activity.getContentResolver().openAssetFileDescriptor(((Uri) (obj3)), "rw");
        closeable1 = abitmap;
        obj1 = obj2;
        closeable = abitmap;
        obj = obj4;
        obj2 = abitmap.createOutputStream();
        closeable1 = abitmap;
        obj1 = obj2;
        closeable = abitmap;
        obj = obj2;
        ((FileOutputStream) (obj2)).write(bytearrayoutputstream.toByteArray());
        closeable1 = abitmap;
        obj1 = obj2;
        closeable = abitmap;
        obj = obj2;
        asynccropresult.uri = ((Uri) (obj3));
_L3:
        IOUtils.closeQuietly(((java.io.OutputStream) (obj2)));
        IOUtils.closeQuietly(abitmap);
        return asynccropresult;
_L2:
        closeable1 = obj5;
        obj1 = obj2;
        closeable = obj6;
        obj = obj4;
        if ((long)abitmap.getByteCount() <= 0x40000L)
        {
            break MISSING_BLOCK_LABEL_585;
        }
        closeable1 = obj5;
        obj1 = obj2;
        closeable = obj6;
        obj = obj4;
        asynccropresult.bitmap = downScaleBitmap(abitmap);
        abitmap = bytearrayoutputstream;
        obj2 = obj3;
          goto _L3
        abitmap;
        closeable = closeable1;
        obj = obj1;
        GLogger.ex(TAG, "Failed to crop bitmap", abitmap);
        IOUtils.closeQuietly(((java.io.OutputStream) (obj1)));
        IOUtils.closeQuietly(closeable1);
        return asynccropresult;
        closeable1 = obj5;
        obj1 = obj2;
        closeable = obj6;
        obj = obj4;
        asynccropresult.bitmap = abitmap;
        abitmap = bytearrayoutputstream;
        obj2 = obj3;
          goto _L3
        abitmap;
        IOUtils.closeQuietly(((java.io.OutputStream) (obj)));
        IOUtils.closeQuietly(closeable);
        throw abitmap;
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Bitmap[])aobj);
    }

    protected void onPostExecute(AsyncCropResult asynccropresult)
    {
        if (asynccropresult.uri != null)
        {
            activity.onBitmapCropped(asynccropresult.uri);
            return;
        }
        if (asynccropresult.bitmap != null)
        {
            activity.onBitmapCropped(asynccropresult.bitmap);
            return;
        } else
        {
            activity.onCropFailed();
            return;
        }
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((AsyncCropResult)obj);
    }

}

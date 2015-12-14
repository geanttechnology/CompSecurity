// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.crop;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import com.amazon.gallery.foundation.utils.log.GLogger;
import java.io.FileNotFoundException;
import org.apache.commons.io.IOUtils;

// Referenced classes of package com.amazon.gallery.framework.gallery.crop:
//            CropActivity

public class LoadBitmapAsyncTask extends AsyncTask
{

    private static final String TAG = com/amazon/gallery/framework/gallery/crop/LoadBitmapAsyncTask.getName();
    private final ContentResolver contentResolver;
    private final CropActivity cropActivity;

    public LoadBitmapAsyncTask(ContentResolver contentresolver, CropActivity cropactivity)
    {
        contentResolver = contentresolver;
        cropActivity = cropactivity;
    }

    protected transient Bitmap doInBackground(Uri auri[])
    {
        java.io.InputStream inputstream;
        java.io.InputStream inputstream1;
        inputstream1 = null;
        inputstream = null;
        auri = contentResolver.openInputStream(auri[0]);
        inputstream = auri;
        inputstream1 = auri;
        Bitmap bitmap = BitmapFactory.decodeStream(auri);
        IOUtils.closeQuietly(auri);
        return bitmap;
        auri;
        inputstream1 = inputstream;
        GLogger.ex(TAG, "Failed to load bitmap", auri);
        IOUtils.closeQuietly(inputstream);
        return null;
        auri;
        IOUtils.closeQuietly(inputstream1);
        throw auri;
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Uri[])aobj);
    }

    protected void onPostExecute(Bitmap bitmap)
    {
        cropActivity.onBitmapLoaded(bitmap);
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Bitmap)obj);
    }

}

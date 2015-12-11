// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui.tasks;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.util.Log;
import com.bitstrips.imoji.manager.TemplatesManager;
import com.bitstrips.imoji.models.Imoji;
import com.bitstrips.imoji.ui.ImageLoader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public abstract class GetImojiImageTask extends AsyncTask
{

    private static final String TAG = "GetImojiImageTask";
    private final Activity activity;
    private final ImageLoader imageLoader;
    protected Imoji imoji;
    private final TemplatesManager templatesManager;

    public GetImojiImageTask(Activity activity1, ImageLoader imageloader, TemplatesManager templatesmanager)
    {
        activity = activity1;
        imageLoader = imageloader;
        templatesManager = templatesmanager;
    }

    private File createFile(Bitmap bitmap)
    {
        if (bitmap == null)
        {
            return null;
        }
        File file1 = null;
        File file = null;
        File file2;
        FileOutputStream fileoutputstream;
        try
        {
            file2 = createTempFile();
        }
        // Misplaced declaration of an exception variable
        catch (Bitmap bitmap)
        {
            bitmap.printStackTrace();
            return file;
        }
        // Misplaced declaration of an exception variable
        catch (Bitmap bitmap)
        {
            bitmap.printStackTrace();
            return file1;
        }
        file = file2;
        file1 = file2;
        fileoutputstream = new FileOutputStream(file2);
        file = file2;
        file1 = file2;
        bitmap.compress(android.graphics.Bitmap.CompressFormat.PNG, 90, fileoutputstream);
        file = file2;
        file1 = file2;
        fileoutputstream.close();
        return file2;
    }

    private File createTempFile()
        throws IOException
    {
        File file = File.createTempFile("bitmoji", ".png", activity.getExternalCacheDir());
        if (!file.setReadable(true, false))
        {
            Log.e("GetImojiImageTask", (new StringBuilder()).append("Failed to set file readable [").append(file.getAbsolutePath()).append("]").toString());
        }
        return file;
    }

    private String getAvatarId()
    {
        return activity.getSharedPreferences(activity.getString(0x7f0600bd), 0).getString(activity.getString(0x7f06002a), null);
    }

    protected transient File doInBackground(Imoji aimoji[])
    {
        String s1;
        imoji = aimoji[0];
        aimoji = null;
        String s = getAvatarId();
        s1 = templatesManager.getImageUrlFromImoji(imoji, s);
        Bitmap bitmap = imageLoader.getImage(activity, s1);
        aimoji = bitmap;
_L2:
        return createFile(aimoji);
        IOException ioexception;
        ioexception;
        Log.e("GetImojiImageTask", (new StringBuilder()).append("Failed to load image [").append(s1).append("]").toString(), ioexception);
        if (true) goto _L2; else goto _L1
_L1:
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Imoji[])aobj);
    }

    protected abstract void onPostExecute(File file);

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((File)obj);
    }
}

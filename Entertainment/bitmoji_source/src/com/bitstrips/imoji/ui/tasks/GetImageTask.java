// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui.tasks;

import android.app.Activity;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import com.bitstrips.imoji.ui.ImageLoader;
import java.io.IOException;

public abstract class GetImageTask extends AsyncTask
{

    private static final String TAG = "GetImageTask";
    private final Activity activity;
    private Exception exception;
    private final ImageLoader imageLoader;
    protected String urlString;

    public GetImageTask(Activity activity1, ImageLoader imageloader)
    {
        activity = activity1;
        imageLoader = imageloader;
    }

    protected transient Bitmap doInBackground(String as[])
    {
        urlString = as[0];
        Bitmap bitmap;
        try
        {
            as = Uri.encode(urlString, "@#&=*+-_.,:!?()/~'%");
        }
        // Misplaced declaration of an exception variable
        catch (String as[])
        {
            exception = as;
            Log.e("GetImageTask", (new StringBuilder()).append("Failed to encode URL [").append(urlString).append("]").toString(), as);
            return null;
        }
        try
        {
            bitmap = imageLoader.getImage(activity, as);
        }
        catch (IOException ioexception)
        {
            exception = ioexception;
            Log.e("GetImageTask", (new StringBuilder()).append("Failed to load image [").append(as).append("]").toString(), ioexception);
            return null;
        }
        return bitmap;
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((String[])aobj);
    }
}

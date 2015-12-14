// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import java.net.HttpURLConnection;
import java.net.URL;

class BitmapDownloader extends AsyncTask
{

    private Exception exception;

    BitmapDownloader()
    {
    }

    protected transient Bitmap doInBackground(String as[])
    {
        try
        {
            as = (HttpURLConnection)(new URL(as[0])).openConnection();
            as.setDoInput(true);
            as.connect();
            as = BitmapFactory.decodeStream(as.getInputStream());
        }
        // Misplaced declaration of an exception variable
        catch (String as[])
        {
            return null;
        }
        return as;
    }

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((String[])aobj);
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            HomeActivity

private class mImageView extends AsyncTask
{

    String mFlagUrl;
    ImageView mImageView;
    final HomeActivity this$0;

    protected transient Bitmap doInBackground(Void avoid[])
    {
        return downloadFlag(mFlagUrl);
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    public Bitmap downloadFlag(String s)
    {
        try
        {
            s = (HttpURLConnection)(new URL(s)).openConnection();
            s.setDoInput(true);
            s.connect();
            s = BitmapFactory.decodeStream(s.getInputStream());
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return null;
        }
        return s;
    }

    protected void onPostExecute(Bitmap bitmap)
    {
        try
        {
            mImageView.setImageBitmap(bitmap);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Bitmap bitmap)
        {
            return;
        }
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Bitmap)obj);
    }

    public (String s, ImageView imageview)
    {
        this$0 = HomeActivity.this;
        super();
        mFlagUrl = s;
        mImageView = imageview;
    }
}

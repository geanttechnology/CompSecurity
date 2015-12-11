// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

// Referenced classes of package com.ebay.mobile.activities:
//            RtmThemedSearchActivity

private class <init> extends AsyncTask
{

    final RtmThemedSearchActivity this$0;

    protected transient Bitmap doInBackground(URL aurl[])
    {
        aurl = BitmapFactory.decodeStream((InputStream)aurl[0].getContent());
        return aurl;
        aurl;
        Log.e("RtmThemedSearchActivity", (new StringBuilder()).append("MalformedURLException = ").append(aurl.toString()).toString());
_L2:
        return null;
        aurl;
        Log.e("RtmThemedSearchActivity", (new StringBuilder()).append("IOException = ").append(aurl.toString()).toString());
        if (true) goto _L2; else goto _L1
_L1:
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((URL[])aobj);
    }

    protected void onPostExecute(Bitmap bitmap)
    {
        if (bitmap != null)
        {
            int i = (bitmap.getHeight() * RtmThemedSearchActivity.access$200(RtmThemedSearchActivity.this)) / bitmap.getWidth();
            bitmap = Bitmap.createScaledBitmap(bitmap, RtmThemedSearchActivity.access$200(RtmThemedSearchActivity.this), i, true);
            ImageView imageview = (ImageView)findViewById(0x7f100557);
            imageview.setAdjustViewBounds(false);
            imageview.setScaleType(android.widget.ewById);
            imageview.setImageBitmap(bitmap);
        }
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Bitmap)obj);
    }

    private ()
    {
        this$0 = RtmThemedSearchActivity.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}

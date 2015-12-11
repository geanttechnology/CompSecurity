// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.sample.castcompanionlibrary.cast.player;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;
import android.view.View;
import com.google.sample.castcompanionlibrary.utils.LogUtils;
import java.net.URL;

// Referenced classes of package com.google.sample.castcompanionlibrary.cast.player:
//            VideoCastControllerActivity

class this._cls0 extends AsyncTask
{

    final VideoCastControllerActivity this$0;

    protected transient Bitmap doInBackground(String as[])
    {
        as = as[0];
        Bitmap bitmap;
        try
        {
            bitmap = BitmapFactory.decodeStream((new URL(as)).openStream());
        }
        catch (Exception exception)
        {
            LogUtils.LOGE(VideoCastControllerActivity.access$000(), (new StringBuilder()).append("Failed to load the image with url: ").append(as).toString(), exception);
            return null;
        }
        return bitmap;
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((String[])aobj);
    }

    protected void onPostExecute(Bitmap bitmap)
    {
        if (bitmap != null)
        {
            VideoCastControllerActivity.access$1100(VideoCastControllerActivity.this).setBackgroundDrawable(new BitmapDrawable(getResources(), bitmap));
        }
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Bitmap)obj);
    }

    ()
    {
        this$0 = VideoCastControllerActivity.this;
        super();
    }
}

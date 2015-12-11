// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.renderers.image;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.webkit.URLUtil;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import tv.freewheel.ad.interfaces.IConstants;
import tv.freewheel.utils.Logger;

// Referenced classes of package tv.freewheel.renderers.image:
//            ImageRenderer

private class <init> extends AsyncTask
{

    private String description;
    final ImageRenderer this$0;

    protected transient Bitmap doInBackground(String as[])
    {
        Object obj;
        Bitmap bitmap1;
        Object obj1;
        Object obj2;
        int i;
        as = as[0];
        obj1 = null;
        obj2 = null;
        obj = null;
        bitmap1 = null;
        if (!URLUtil.isValidUrl(as))
        {
            break MISSING_BLOCK_LABEL_296;
        }
        i = 0;
_L6:
        String as1[] = null;
        obj = obj1;
        Bitmap bitmap = obj2;
        String s;
        int j;
        try
        {
            as = (HttpURLConnection)(HttpURLConnection)(new URL(as)).openConnection();
        }
        // Misplaced declaration of an exception variable
        catch (String as[])
        {
            description = as.toString();
            return ((Bitmap) (obj));
        }
        // Misplaced declaration of an exception variable
        catch (String as[])
        {
            description = (new StringBuilder()).append("Failed to get content from creative url.").append(as.toString()).toString();
            obj = bitmap;
            if (as1 != null)
            {
                as1.disconnect();
                return bitmap;
            }
            break MISSING_BLOCK_LABEL_319;
        }
        obj = obj1;
        bitmap = obj2;
        as1 = as;
        as.setInstanceFollowRedirects(false);
        obj = obj1;
        bitmap = obj2;
        as1 = as;
        as.connect();
        obj = obj1;
        bitmap = obj2;
        as1 = as;
        if (as.getResponseCode() == 302) goto _L2; else goto _L1
_L1:
        obj = obj1;
        bitmap = obj2;
        as1 = as;
        bitmap1 = BitmapFactory.decodeStream(as.getInputStream());
        as1 = as;
        as = bitmap1;
_L4:
        obj = as;
        if (i <= 3)
        {
            break MISSING_BLOCK_LABEL_319;
        }
        obj = as;
        bitmap = as;
        description = "redirect too many times";
        return as;
_L2:
        obj = obj1;
        bitmap = obj2;
        as1 = as;
        s = as.getHeaderField("Location");
        j = i + 1;
        obj = obj1;
        bitmap = obj2;
        as1 = as;
        ImageRenderer.access$000(ImageRenderer.this).debug((new StringBuilder()).append("redirect to new location: ").append(s).toString());
        obj = obj1;
        bitmap = obj2;
        as1 = as;
        as.disconnect();
        as1 = null;
        as = s;
        i = j;
        if (j <= 3)
        {
            break; /* Loop/switch isn't completed */
        }
        as = bitmap1;
        i = j;
        if (true) goto _L4; else goto _L3
_L3:
        if (true) goto _L6; else goto _L5
_L5:
        description = (new StringBuilder()).append("Invalid url:").append(as).toString();
        return ((Bitmap) (obj));
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((String[])aobj);
    }

    protected void onPostExecute(Bitmap bitmap)
    {
        ImageRenderer.access$102(ImageRenderer.this, bitmap);
        if (bitmap != null)
        {
            ImageRenderer.access$202(ImageRenderer.this, bitmap.getWidth());
            ImageRenderer.access$302(ImageRenderer.this, bitmap.getHeight());
            ImageRenderer.access$400(ImageRenderer.this);
            return;
        } else
        {
            ImageRenderer.access$600(ImageRenderer.this, ImageRenderer.access$500(ImageRenderer.this).ERROR_IO(), description);
            return;
        }
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Bitmap)obj);
    }

    private ()
    {
        this$0 = ImageRenderer.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}

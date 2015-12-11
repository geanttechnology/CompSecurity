// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.media;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import com.amazon.now.util.ImageUtil;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

// Referenced classes of package com.amazon.now.media:
//            FullScreenGalleryActivity, Gallery, GalleryPanel

class val.panel extends AsyncTask
{

    final FullScreenGalleryActivity this$0;
    final GalleryPanel val$panel;
    final int val$postion;

    protected transient Bitmap doInBackground(String as[])
    {
        Object obj4;
        obj4 = null;
        as = as[0];
        if (as != null) goto _L2; else goto _L1
_L1:
        as = obj4;
_L3:
        return as;
_L2:
        Object obj;
        Object obj2;
        Object obj3;
        obj3 = ImageUtil.getImageUrlReplacingTags(as, FullScreenGalleryActivity.access$600(FullScreenGalleryActivity.this), FullScreenGalleryActivity.access$700(FullScreenGalleryActivity.this));
        obj2 = null;
        as = null;
        obj = null;
        obj3 = (new URL(((String) (obj3)))).openStream();
        obj = obj3;
        obj2 = obj3;
        as = ((String []) (obj3));
        Object obj5 = new android.graphics.();
        obj = obj3;
        obj2 = obj3;
        as = ((String []) (obj3));
        obj5.erredConfig = android.graphics.erredConfig;
        obj = obj3;
        obj2 = obj3;
        as = ((String []) (obj3));
        obj5 = BitmapFactory.decodeStream(((InputStream) (obj3)), null, ((android.graphics.erredConfig) (obj5)));
        obj = obj5;
        as = ((String []) (obj));
        if (obj3 != null)
        {
            try
            {
                ((InputStream) (obj3)).close();
            }
            // Misplaced declaration of an exception variable
            catch (String as[])
            {
                Log.e(FullScreenGalleryActivity.access$800(), "Error closing stream", as);
                return ((Bitmap) (obj));
            }
            return ((Bitmap) (obj));
        }
          goto _L3
        obj2;
        as = ((String []) (obj));
        Log.e(FullScreenGalleryActivity.access$800(), "Failure to download Image", ((Throwable) (obj2)));
        as = obj4;
        if (obj != null)
        {
            try
            {
                ((InputStream) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (String as[])
            {
                Log.e(FullScreenGalleryActivity.access$800(), "Error closing stream", as);
                return null;
            }
            return null;
        }
          goto _L3
        Object obj1;
        obj1;
        as = ((String []) (obj2));
        Log.e(FullScreenGalleryActivity.access$800(), "Out of Memory! Aborting download", ((Throwable) (obj1)));
        as = obj4;
        if (obj2 == null) goto _L3; else goto _L4
_L4:
        try
        {
            ((InputStream) (obj2)).close();
        }
        // Misplaced declaration of an exception variable
        catch (String as[])
        {
            Log.e(FullScreenGalleryActivity.access$800(), "Error closing stream", as);
            return null;
        }
        return null;
        obj1;
        if (as != null)
        {
            try
            {
                as.close();
            }
            // Misplaced declaration of an exception variable
            catch (String as[])
            {
                Log.e(FullScreenGalleryActivity.access$800(), "Error closing stream", as);
            }
        }
        throw obj1;
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((String[])aobj);
    }

    protected void onPostExecute(Bitmap bitmap)
    {
        if (bitmap != null && FullScreenGalleryActivity.access$900(FullScreenGalleryActivity.this))
        {
            FullScreenGalleryActivity.access$500(FullScreenGalleryActivity.this).addImageViewToTheGallery(bitmap, val$postion);
            val$panel.setThumbnail(bitmap, val$postion);
        }
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Bitmap)obj);
    }

    ()
    {
        this$0 = final_fullscreengalleryactivity;
        val$postion = i;
        val$panel = GalleryPanel.this;
        super();
    }
}

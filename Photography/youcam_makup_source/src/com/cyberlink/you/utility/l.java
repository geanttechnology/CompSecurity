// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.utility;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;
import com.cyberlink.you.friends.s;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

// Referenced classes of package com.cyberlink.you.utility:
//            LoadImageUtils

class l extends AsyncTask
{

    private String a;
    private String b;
    private WeakReference c;

    public l(String s1, ImageView imageview, String s2)
    {
        a = s1;
        c = new WeakReference(imageview);
        b = s2;
    }

    static String a(l l1)
    {
        return l1.a;
    }

    public transient Bitmap a(Object aobj[])
    {
        Thread.currentThread().setName("LoadNetworkStickerTask AsyncTask");
        Object obj = null;
        aobj = ((Object []) (obj));
        if (b != null)
        {
            aobj = ((Object []) (obj));
            if ((new File(b)).exists())
            {
                aobj = BitmapFactory.decodeFile(b);
            }
        }
        obj = ((Object) (aobj));
        if (aobj == null)
        {
            try
            {
                obj = BitmapFactory.decodeStream((new URL(a)).openConnection().getInputStream());
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                ((MalformedURLException) (obj)).printStackTrace();
                obj = ((Object) (aobj));
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                ((IOException) (obj)).printStackTrace();
                obj = ((Object) (aobj));
            }
        }
        if (b != null && obj != null)
        {
            try
            {
                aobj = new FileOutputStream(b);
                ((Bitmap) (obj)).compress(android.graphics.Bitmap.CompressFormat.PNG, 100, ((java.io.OutputStream) (aobj)));
                ((FileOutputStream) (aobj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object aobj[])
            {
                ((FileNotFoundException) (aobj)).printStackTrace();
                return ((Bitmap) (obj));
            }
            // Misplaced declaration of an exception variable
            catch (Object aobj[])
            {
                ((IOException) (aobj)).printStackTrace();
                return ((Bitmap) (obj));
            }
            // Misplaced declaration of an exception variable
            catch (Object aobj[])
            {
                ((Exception) (aobj)).printStackTrace();
                return ((Bitmap) (obj));
            }
        }
        return ((Bitmap) (obj));
    }

    protected void a(Bitmap bitmap)
    {
        if (isCancelled())
        {
            bitmap = null;
        }
        if (bitmap == null)
        {
            return;
        }
        if (c != null)
        {
            ImageView imageview = (ImageView)c.get();
            if (this == LoadImageUtils.c(imageview) && imageview != null)
            {
                imageview.setImageBitmap(bitmap);
            }
        }
        LoadImageUtils.b().a(a, bitmap);
    }

    public Object doInBackground(Object aobj[])
    {
        return a(aobj);
    }

    protected void onPostExecute(Object obj)
    {
        a((Bitmap)obj);
    }
}

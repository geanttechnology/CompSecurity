// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.widget.ImageView;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Referenced classes of package com.livemixtapes:
//            MemoryCache, FileCache, Utils

public class ImageLoader
{
    class BitmapDisplayer
        implements Runnable
    {

        Bitmap bitmap;
        PhotoToLoad photoToLoad;
        final ImageLoader this$0;

        public void run()
        {
            if (imageViewReused(photoToLoad))
            {
                return;
            }
            if (bitmap != null)
            {
                photoToLoad.imageView.setImageBitmap(bitmap);
                return;
            } else
            {
                photoToLoad.imageView.setImageResource(0x7f0200ec);
                return;
            }
        }

        public BitmapDisplayer(Bitmap bitmap1, PhotoToLoad phototoload)
        {
            this$0 = ImageLoader.this;
            super();
            bitmap = bitmap1;
            photoToLoad = phototoload;
        }
    }

    private class PhotoToLoad
    {

        public ImageView imageView;
        final ImageLoader this$0;
        public String url;

        public PhotoToLoad(String s, ImageView imageview)
        {
            this$0 = ImageLoader.this;
            super();
            url = s;
            imageView = imageview;
        }
    }

    class PhotosLoader
        implements Runnable
    {

        PhotoToLoad photoToLoad;
        final ImageLoader this$0;

        public void run()
        {
            if (imageViewReused(photoToLoad))
            {
                return;
            }
            try
            {
                Object obj = getBitmap(photoToLoad.url);
                ImageLoader.memoryCache.put(photoToLoad.url, ((Bitmap) (obj)));
                if (!imageViewReused(photoToLoad))
                {
                    obj = new BitmapDisplayer(((Bitmap) (obj)), photoToLoad);
                    handler.post(((Runnable) (obj)));
                    return;
                }
            }
            catch (Throwable throwable)
            {
                throwable.printStackTrace();
            }
            return;
        }

        PhotosLoader(PhotoToLoad phototoload)
        {
            this$0 = ImageLoader.this;
            super();
            photoToLoad = phototoload;
        }
    }


    static MemoryCache memoryCache = new MemoryCache();
    ExecutorService executorService;
    FileCache fileCache;
    Handler handler;
    private Map imageViews;
    final int stub_id = 0x7f0200ec;

    public ImageLoader(Context context)
    {
        imageViews = Collections.synchronizedMap(new WeakHashMap());
        handler = new Handler();
        fileCache = new FileCache(context);
        executorService = Executors.newFixedThreadPool(5);
    }

    private Bitmap decodeFile(File file)
    {
        int j;
        int k;
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        FileInputStream fileinputstream = new FileInputStream(file);
        BitmapFactory.decodeStream(fileinputstream, null, options);
        fileinputstream.close();
        k = options.outWidth;
        j = options.outHeight;
        int i = 1;
_L1:
        Object obj;
        if (k / 2 >= 400 && j / 2 >= 400)
        {
            break MISSING_BLOCK_LABEL_104;
        }
        obj = new android.graphics.BitmapFactory.Options();
        obj.inSampleSize = i;
        file = new FileInputStream(file);
        obj = BitmapFactory.decodeStream(file, null, ((android.graphics.BitmapFactory.Options) (obj)));
        file.close();
        return ((Bitmap) (obj));
        k /= 2;
        j /= 2;
        i *= 2;
          goto _L1
        file;
        file.printStackTrace();
_L3:
        return null;
        file;
        if (true) goto _L3; else goto _L2
_L2:
    }

    private void queuePhoto(String s, ImageView imageview)
    {
        s = new PhotoToLoad(s, imageview);
        executorService.submit(new PhotosLoader(s));
    }

    public void DisplayImage(String s, ImageView imageview)
    {
        imageViews.put(imageview, s);
        Bitmap bitmap = memoryCache.get(s);
        if (bitmap != null)
        {
            imageview.setImageBitmap(bitmap);
            return;
        } else
        {
            queuePhoto(s, imageview);
            imageview.setImageResource(0x7f0200ec);
            return;
        }
    }

    public void DisplayImageWithoutCache(String s, ImageView imageview)
    {
        imageViews.put(imageview, s);
        queuePhoto(s, imageview);
        imageview.setImageResource(0x7f0200ec);
    }

    public void clearCache()
    {
        memoryCache.clear();
        fileCache.clear();
    }

    public Bitmap getBitmap(String s)
    {
        File file = fileCache.getFile(s);
        Bitmap bitmap = decodeFile(file);
        if (bitmap != null)
        {
            return bitmap;
        }
        try
        {
            s = (HttpURLConnection)(new URL(s)).openConnection();
            s.setConnectTimeout(30000);
            s.setReadTimeout(30000);
            s.setInstanceFollowRedirects(true);
            java.io.InputStream inputstream = s.getInputStream();
            FileOutputStream fileoutputstream = new FileOutputStream(file);
            Utils.CopyStream(inputstream, fileoutputstream);
            fileoutputstream.close();
            s.disconnect();
            s = decodeFile(file);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            if (s instanceof OutOfMemoryError)
            {
                memoryCache.clear();
            }
            return null;
        }
        return s;
    }

    boolean imageViewReused(PhotoToLoad phototoload)
    {
        String s = (String)imageViews.get(phototoload.imageView);
        return s == null || !s.equals(phototoload.url);
    }

}

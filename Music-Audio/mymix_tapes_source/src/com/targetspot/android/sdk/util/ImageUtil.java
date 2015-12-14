// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.targetspot.android.sdk.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class ImageUtil
{
    public static abstract class ImageHandler extends Handler
    {

        public static final int ERROR = 0;
        public static final int SUCCESS = 1;

        public abstract void handleError(Throwable throwable);

        public abstract void handleImage(Bitmap bitmap);

        public void handleMessage(Message message)
        {
            if (message.what != 0) goto _L2; else goto _L1
_L1:
            if (message.obj == null) goto _L4; else goto _L3
_L3:
            handleError((Throwable)message.obj);
_L6:
            return;
_L4:
            handleError(new NullPointerException("no error found"));
            return;
_L2:
            if (message.what == 1)
            {
                if (message.obj != null)
                {
                    handleImage((Bitmap)message.obj);
                    return;
                } else
                {
                    handleError(new NullPointerException("no bitmap available"));
                    return;
                }
            }
            if (true) goto _L6; else goto _L5
_L5:
        }

        public ImageHandler()
        {
        }
    }


    private static ExecutorService pool = Executors.newFixedThreadPool(15);

    private ImageUtil()
    {
    }

    public static final void asyncGetImageBitmapFromUrl(String s, ImageHandler imagehandler)
    {
        pool.execute(new Runnable(s, imagehandler) {

            final ImageHandler val$handler;
            final String val$url;

            public void run()
            {
                ImageUtil.getImageBitmapFromURL(url, handler, false);
            }

            
            {
                url = s;
                handler = imagehandler;
                super();
            }
        });
    }

    public static Bitmap getImageBitmapFromURL(String s)
    {
        return getImageBitmapFromURL(s, null, false);
    }

    public static Bitmap getImageBitmapFromURL(String s, ImageHandler imagehandler, boolean flag)
    {
        Object obj1 = null;
        if (s != null) goto _L2; else goto _L1
_L1:
        String s1;
        s1 = obj1;
        try
        {
            throw new NullPointerException("url is null");
        }
        catch (Throwable throwable)
        {
            s = s1;
            if (imagehandler != null)
            {
                Message.obtain(imagehandler, 0, throwable).sendToTarget();
                return null;
            }
        }
          goto _L3
_L2:
        s1 = obj1;
        s = new URL(s);
        s1 = obj1;
        if (!s.getProtocol().equalsIgnoreCase("file")) goto _L5; else goto _L4
_L4:
        s1 = obj1;
        Object obj = new FileInputStream(s.getPath());
_L8:
        s1 = obj1;
        BufferedInputStream bufferedinputstream = new BufferedInputStream(((InputStream) (obj)));
        if (!flag) goto _L7; else goto _L6
_L6:
        s1 = obj1;
        s = new android.graphics.BitmapFactory.Options();
        s1 = obj1;
        s.inSampleSize = 2;
        s1 = obj1;
        s = BitmapFactory.decodeStream(bufferedinputstream, null, s);
_L9:
        s1 = s;
        bufferedinputstream.close();
        s1 = s;
        ((InputStream) (obj)).close();
_L3:
        if (imagehandler != null)
        {
            Message.obtain(imagehandler, 1, s).sendToTarget();
        }
        return s;
_L5:
        s1 = obj1;
        s = s.openConnection();
        s1 = obj1;
        s.connect();
        s1 = obj1;
        obj = s.getInputStream();
          goto _L8
_L7:
        s1 = obj1;
        s = BitmapFactory.decodeStream(bufferedinputstream);
          goto _L9
    }

    public static void getImageFromURL(String s, ImageView imageview)
    {
        asyncGetImageBitmapFromUrl(s, new ImageHandler(imageview) {

            final ImageView val$view;

            public void handleError(Throwable throwable)
            {
                throwable.printStackTrace();
            }

            public void handleImage(Bitmap bitmap)
            {
                if (view != null)
                {
                    view.setImageBitmap(bitmap);
                    view.requestLayout();
                }
            }

            
            {
                view = imageview;
                super();
            }
        });
    }

}

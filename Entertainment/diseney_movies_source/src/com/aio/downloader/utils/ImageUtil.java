// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.v4.util.LruCache;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.security.MessageDigest;

// Referenced classes of package com.aio.downloader.utils:
//            ThreadPoolManager

public class ImageUtil
{
    public static interface ImageCallback
    {

        public abstract void loadImage(Bitmap bitmap, String s);
    }


    private static final String SDCARD_CACHE_IMG_PATH = (new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().getPath()))).append("/DCIM/Camera/").toString();
    public static LruCache cache = new LruCache(6);

    public ImageUtil()
    {
    }

    public static byte[] Bitmap2Bytes(Bitmap bitmap)
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        bitmap.compress(android.graphics.Bitmap.CompressFormat.PNG, 100, bytearrayoutputstream);
        return bytearrayoutputstream.toByteArray();
    }

    public static String byteToHexString(byte abyte0[])
    {
        StringBuffer stringbuffer = new StringBuffer();
        int i = 0;
        do
        {
            if (i >= abyte0.length)
            {
                return stringbuffer.toString();
            }
            String s1 = Integer.toHexString(abyte0[i] & 0xff);
            String s = s1;
            if (s1.length() == 1)
            {
                s = (new StringBuilder(String.valueOf('0'))).append(s1).toString();
            }
            stringbuffer.append(s.toUpperCase());
            i++;
        } while (true);
    }

    public static String getCacheImgPath()
    {
        return SDCARD_CACHE_IMG_PATH;
    }

    public static Bitmap getImageFromLocal(String s)
    {
        File file = new File(s);
        if (file.exists())
        {
            s = BitmapFactory.decodeFile(s);
            file.setLastModified(System.currentTimeMillis());
            return s;
        } else
        {
            return null;
        }
    }

    public static Bitmap loadImage(final String imagePath, final String imgUrl, final ImageCallback callback, final int opInSampleSize)
    {
        Bitmap bitmap = (Bitmap)cache.get(imagePath);
        if (bitmap != null)
        {
            return bitmap;
        }
        bitmap = getImageFromLocal(imagePath);
        if (bitmap != null)
        {
            return bitmap;
        } else
        {
            imagePath = new Runnable() {

                private final Handler val$handler;
                private final String val$imagePath;
                private final String val$imgUrl;
                private final int val$opInSampleSize;

                public void run()
                {
                    try
                    {
                        Object obj = (new URL(imgUrl)).openConnection();
                        ((URLConnection) (obj)).setDoInput(true);
                        ((URLConnection) (obj)).connect();
                        obj = ((URLConnection) (obj)).getInputStream();
                        Object obj1 = new android.graphics.BitmapFactory.Options();
                        obj1.inJustDecodeBounds = false;
                        obj1.inSampleSize = opInSampleSize;
                        obj = BitmapFactory.decodeStream(((java.io.InputStream) (obj)), null, ((android.graphics.BitmapFactory.Options) (obj1)));
                        ImageUtil.cache.put(imagePath, obj);
                        obj1 = handler.obtainMessage();
                        obj1.obj = obj;
                        handler.sendMessage(((Message) (obj1)));
                        return;
                    }
                    catch (IOException ioexception)
                    {
                        ioexception.printStackTrace();
                    }
                }

            
            {
                imgUrl = s;
                opInSampleSize = i;
                imagePath = s1;
                handler = handler1;
                super();
            }
            };
            ThreadPoolManager.getInstance().addTask(imagePath);
            return null;
        }
    }

    public static String md5(String s)
    {
        Object obj;
        try
        {
            obj = MessageDigest.getInstance("MD5");
            ((MessageDigest) (obj)).update(s.getBytes());
            obj = byteToHexString(((MessageDigest) (obj)).digest());
        }
        catch (Exception exception)
        {
            return s;
        }
        return ((String) (obj));
    }

    public static void saveImage(String s, byte abyte0[])
        throws IOException
    {
        File file = new File(s);
        if (file.exists())
        {
            return;
        }
        File file1 = file.getParentFile();
        if (!file1.exists())
        {
            file1.mkdirs();
        }
        file.createNewFile();
        s = new FileOutputStream(s);
        s.write(abyte0);
        s.flush();
        s.close();
    }


    // Unreferenced inner class com/aio/downloader/utils/ImageUtil$1

/* anonymous class */
    class _cls1 extends Handler
    {

        private final ImageCallback val$callback;
        private final String val$imagePath;

        public void handleMessage(Message message)
        {
            if (message.obj == null)
            {
                break MISSING_BLOCK_LABEL_53;
            }
            message = (Bitmap)message.obj;
            callback.loadImage(message, imagePath);
            try
            {
                ImageUtil.saveImage(imagePath, ImageUtil.Bitmap2Bytes(message));
            }
            catch (IOException ioexception)
            {
                ioexception.printStackTrace();
            }
            message = ImageUtil.Bitmap2Bytes(message);
            ImageUtil.saveImage(imagePath, message);
            return;
            message;
            message.printStackTrace();
            return;
        }

            
            {
                callback = imagecallback;
                imagePath = s;
                super();
            }
    }

}

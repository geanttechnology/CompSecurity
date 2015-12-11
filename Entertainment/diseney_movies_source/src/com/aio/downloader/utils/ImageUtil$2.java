// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.utils;

import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.support.v4.util.LruCache;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

// Referenced classes of package com.aio.downloader.utils:
//            ImageUtil

class val.handler
    implements Runnable
{

    private final Handler val$handler;
    private final String val$imagePath;
    private final String val$imgUrl;
    private final int val$opInSampleSize;

    public void run()
    {
        try
        {
            Object obj = (new URL(val$imgUrl)).openConnection();
            ((URLConnection) (obj)).setDoInput(true);
            ((URLConnection) (obj)).connect();
            obj = ((URLConnection) (obj)).getInputStream();
            Object obj1 = new android.graphics.y.Options();
            obj1.inJustDecodeBounds = false;
            obj1.inSampleSize = val$opInSampleSize;
            obj = BitmapFactory.decodeStream(((java.io.InputStream) (obj)), null, ((android.graphics.y.Options) (obj1)));
            ImageUtil.cache.put(val$imagePath, obj);
            obj1 = val$handler.obtainMessage();
            obj1.obj = obj;
            val$handler.sendMessage(((Message) (obj1)));
            return;
        }
        catch (IOException ioexception)
        {
            ioexception.printStackTrace();
        }
    }

    s()
    {
        val$imgUrl = s;
        val$opInSampleSize = i;
        val$imagePath = s1;
        val$handler = handler1;
        super();
    }
}

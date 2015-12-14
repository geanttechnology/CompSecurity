// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes;

import android.os.Handler;

// Referenced classes of package com.livemixtapes:
//            ImageLoader, MemoryCache

class photoToLoad
    implements Runnable
{

    photoToLoad photoToLoad;
    final ImageLoader this$0;

    public void run()
    {
        if (imageViewReused(photoToLoad))
        {
            return;
        }
        try
        {
            Object obj = getBitmap(photoToLoad.rl);
            ImageLoader.memoryCache.put(photoToLoad.rl, ((android.graphics.Bitmap) (obj)));
            if (!imageViewReused(photoToLoad))
            {
                obj = new er(ImageLoader.this, ((android.graphics.Bitmap) (obj)), photoToLoad);
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

    er(er er)
    {
        this$0 = ImageLoader.this;
        super();
        photoToLoad = er;
    }
}

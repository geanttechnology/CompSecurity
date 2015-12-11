// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.images;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import com.google.android.gms.internal.ds;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

// Referenced classes of package com.google.android.gms.common.images:
//            ImageManager, a

private final class mX
    implements Runnable
{

    private final Bitmap mBitmap;
    private final Uri mUri;
    private final CountDownLatch mX;
    final ImageManager ol;
    private boolean oo;

    private void a(ageReceiver agereceiver, boolean flag)
    {
        agereceiver.ok = true;
        ArrayList arraylist = ageReceiver.a(agereceiver);
        int j = arraylist.size();
        int i = 0;
        while (i < j) 
        {
            a a1 = (a)arraylist.get(i);
            if (flag)
            {
                a1.a(ImageManager.a(ol), mBitmap, false);
            } else
            {
                a1.b(ImageManager.a(ol), false);
            }
            if (a1.os != 1)
            {
                ImageManager.c(ol).remove(a1);
            }
            i++;
        }
        agereceiver.ok = false;
    }

    public void run()
    {
        ds.N("OnBitmapLoadedRunnable must be executed in the main thread");
        boolean flag;
        if (mBitmap != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (ImageManager.f(ol) != null)
        {
            if (oo)
            {
                ImageManager.f(ol).evictAll();
                System.gc();
                oo = false;
                ImageManager.e(ol).post(this);
                return;
            }
            if (flag)
            {
                ImageManager.f(ol).put(new put(mUri), mBitmap);
            }
        }
        ageReceiver agereceiver = (ageReceiver)ImageManager.b(ol).remove(mUri);
        if (agereceiver != null)
        {
            a(agereceiver, flag);
        }
        mX.countDown();
        synchronized (ImageManager.aZ())
        {
            ImageManager.bA().remove(mUri);
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public ageReceiver(ImageManager imagemanager, Uri uri, Bitmap bitmap, boolean flag, CountDownLatch countdownlatch)
    {
        ol = imagemanager;
        super();
        mUri = uri;
        mBitmap = bitmap;
        oo = flag;
        mX = countdownlatch;
    }
}

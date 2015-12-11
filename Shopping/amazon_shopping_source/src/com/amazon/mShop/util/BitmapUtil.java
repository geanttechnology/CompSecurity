// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.util;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;
import com.amazon.mShop.net.LRUCache;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class BitmapUtil
{
    private static class DelayedRetryRunnable
        implements Runnable
    {

        private Runnable mRunnable;
        private int mTrySeq;

        public void run()
        {
            try
            {
                mRunnable.run();
                return;
            }
            catch (OutOfMemoryError outofmemoryerror) { }
            if (mTrySeq + 1 < 3)
            {
                BitmapUtil.sScheduledExecSvc.schedule(new DelayedRetryRunnable(mTrySeq + 1, mRunnable), 230L, TimeUnit.MILLISECONDS);
            }
            System.gc();
        }

        public DelayedRetryRunnable(int i, Runnable runnable)
        {
            mTrySeq = 0;
            mTrySeq = i;
            mRunnable = runnable;
        }
    }


    private static ScheduledExecutorService sScheduledExecSvc = Executors.newScheduledThreadPool(3);

    public BitmapUtil()
    {
    }

    public static Bitmap loadImage(Resources resources, int i, boolean flag, boolean flag1, boolean flag2, boolean flag3)
    {
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        if (!flag)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        options.inScaled = flag;
        options.inPurgeable = flag1;
        options.inInputShareable = flag2;
        if (flag3)
        {
            options.inPreferredConfig = android.graphics.Bitmap.Config.ARGB_4444;
        }
        return BitmapFactory.decodeResource(resources, i, options);
    }

    public static void setImageResource(ImageView imageview, int i)
    {
        if (i <= 0 || imageview == null)
        {
            break MISSING_BLOCK_LABEL_13;
        }
        imageview.setImageResource(i);
        return;
        imageview;
        LRUCache.reduceByPercent(50);
        System.gc();
        return;
    }

    public static void tryInCaseOfOutOfMemory(Runnable runnable)
    {
        sScheduledExecSvc.schedule(new DelayedRetryRunnable(0, runnable), 0L, TimeUnit.MILLISECONDS);
    }


}

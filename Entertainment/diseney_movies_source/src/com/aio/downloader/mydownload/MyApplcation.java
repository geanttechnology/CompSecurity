// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.mydownload;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import com.aio.downloader.activity.MyMainActivity;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageLoadingListener;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.assist.SimpleImageLoadingListener;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

// Referenced classes of package com.aio.downloader.mydownload:
//            DownloadMovieItem

public class MyApplcation extends Application
    implements Thread.UncaughtExceptionHandler
{
    private static class AnimateFirstDisplayListener extends SimpleImageLoadingListener
    {

        private static int $SWITCH_TABLE$com$nostra13$universalimageloader$core$assist$FailReason$FailType[];
        static final List displayedImages = Collections.synchronizedList(new LinkedList());

        static int[] $SWITCH_TABLE$com$nostra13$universalimageloader$core$assist$FailReason$FailType()
        {
            int ai[] = $SWITCH_TABLE$com$nostra13$universalimageloader$core$assist$FailReason$FailType;
            if (ai != null)
            {
                return ai;
            }
            ai = new int[com.nostra13.universalimageloader.core.assist.FailReason.FailType.values().length];
            try
            {
                ai[com.nostra13.universalimageloader.core.assist.FailReason.FailType.DECODING_ERROR.ordinal()] = 2;
            }
            catch (NoSuchFieldError nosuchfielderror4) { }
            try
            {
                ai[com.nostra13.universalimageloader.core.assist.FailReason.FailType.IO_ERROR.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror3) { }
            try
            {
                ai[com.nostra13.universalimageloader.core.assist.FailReason.FailType.NETWORK_DENIED.ordinal()] = 3;
            }
            catch (NoSuchFieldError nosuchfielderror2) { }
            try
            {
                ai[com.nostra13.universalimageloader.core.assist.FailReason.FailType.OUT_OF_MEMORY.ordinal()] = 4;
            }
            catch (NoSuchFieldError nosuchfielderror1) { }
            try
            {
                ai[com.nostra13.universalimageloader.core.assist.FailReason.FailType.UNKNOWN.ordinal()] = 5;
            }
            catch (NoSuchFieldError nosuchfielderror) { }
            $SWITCH_TABLE$com$nostra13$universalimageloader$core$assist$FailReason$FailType = ai;
            return ai;
        }

        public void onLoadingComplete(String s, View view, Bitmap bitmap)
        {
            if (bitmap != null)
            {
                view = (ImageView)view;
                boolean flag;
                if (displayedImages.contains(s))
                {
                    flag = false;
                } else
                {
                    flag = true;
                }
                if (flag)
                {
                    FadeInBitmapDisplayer.animate(view, 500);
                    displayedImages.add(s);
                }
            }
        }

        public void onLoadingFailed(String s, View view, FailReason failreason)
        {
            super.onLoadingFailed(s, view, failreason);
            switch ($SWITCH_TABLE$com$nostra13$universalimageloader$core$assist$FailReason$FailType()[failreason.getType().ordinal()])
            {
            case 1: // '\001'
            case 2: // '\002'
            case 3: // '\003'
            case 5: // '\005'
            default:
                return;

            case 4: // '\004'
                Log.e("qwerf", "OUT_OF_MEMORY");
                break;
            }
        }


        private AnimateFirstDisplayListener()
        {
        }

        AnimateFirstDisplayListener(AnimateFirstDisplayListener animatefirstdisplaylistener)
        {
            this();
        }
    }


    public static final boolean DEVELOPER_MODE = false;
    private static final String TAG = com/aio/downloader/mydownload/MyApplcation.getName();
    private ImageLoadingListener animateFirstListener;
    private List downloadItems;
    private DownloadMovieItem downloadSuccess;
    private ImageLoader imageLoader;
    private List list;
    private DisplayImageOptions options;
    private DisplayImageOptions options1;
    private ViewPager pager;
    private DownloadMovieItem startDownloadMovieItem;
    private DownloadMovieItem stopOrStartDownloadMovieItem;

    public MyApplcation()
    {
        downloadItems = new ArrayList();
        options = (new com.nostra13.universalimageloader.core.DisplayImageOptions.Builder()).imageScaleType(ImageScaleType.IN_SAMPLE_INT).bitmapConfig(android.graphics.Bitmap.Config.RGB_565).cacheOnDisc().showStubImage(0x7f0200f9).showImageOnFail(0x7f0200f9).build();
        options1 = (new com.nostra13.universalimageloader.core.DisplayImageOptions.Builder()).imageScaleType(ImageScaleType.IN_SAMPLE_INT).bitmapConfig(android.graphics.Bitmap.Config.RGB_565).cacheOnDisc().showStubImage(0x7f0200f9).build();
        imageLoader = ImageLoader.getInstance();
        animateFirstListener = new AnimateFirstDisplayListener(null);
    }

    public static void initImageLoader(Context context)
    {
        context = (new com.nostra13.universalimageloader.core.ImageLoaderConfiguration.Builder(context)).threadPriority(3).denyCacheImageMultipleSizesInMemory().discCacheFileNameGenerator(new Md5FileNameGenerator()).tasksProcessingOrder(QueueProcessingType.LIFO).enableLogging().build();
        ImageLoader.getInstance().init(context);
    }

    public void asyncLoadImage(String s, ImageView imageview)
    {
        imageLoader.displayImage(s, imageview, options, animateFirstListener);
    }

    public void asyncLoadImage1(String s, ImageView imageview)
    {
        imageLoader.displayImage(s, imageview, options1, animateFirstListener);
    }

    public List getDownloadItems()
    {
        return downloadItems;
    }

    public DownloadMovieItem getDownloadSuccess()
    {
        return downloadSuccess;
    }

    public List getListData()
    {
        return list;
    }

    public ViewPager getPager()
    {
        return pager;
    }

    public DownloadMovieItem getStartDownloadMovieItem()
    {
        return startDownloadMovieItem;
    }

    public DownloadMovieItem getStopOrStartDownloadMovieItem()
    {
        return stopOrStartDownloadMovieItem;
    }

    public void onCreate()
    {
        super.onCreate();
        list = new ArrayList();
        initImageLoader(getApplicationContext());
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    public void setDownloadItems(List list1)
    {
        downloadItems = list1;
    }

    public void setDownloadSuccess(DownloadMovieItem downloadmovieitem)
    {
        downloadSuccess = downloadmovieitem;
    }

    public void setListData(List list1)
    {
        list = list1;
    }

    public void setPager(ViewPager viewpager)
    {
        pager = viewpager;
    }

    public void setStartDownloadMovieItem(DownloadMovieItem downloadmovieitem)
    {
        startDownloadMovieItem = downloadmovieitem;
    }

    public void setStopOrStartDownloadMovieItem(DownloadMovieItem downloadmovieitem)
    {
        stopOrStartDownloadMovieItem = downloadmovieitem;
    }

    public void uncaughtException(Thread thread, Throwable throwable)
    {
        System.out.println("uncaughtException");
        System.exit(0);
        thread = new Intent(this, com/aio/downloader/activity/MyMainActivity);
        thread.addFlags(0x14000000);
        startActivity(thread);
    }

}

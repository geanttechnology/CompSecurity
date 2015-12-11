// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.tsz.afinal;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import net.tsz.afinal.bitmap.core.BitmapDisplayConfig;
import net.tsz.afinal.bitmap.core.BitmapProcess;
import net.tsz.afinal.bitmap.display.Displayer;
import net.tsz.afinal.bitmap.display.SimpleDisplayer;
import net.tsz.afinal.bitmap.download.Downloader;
import net.tsz.afinal.bitmap.download.SimpleHttpDownloader;

// Referenced classes of package net.tsz.afinal:
//            FinalBitmap

private class g.setBitmapWidth
{

    public BitmapProcess bitmapProcess;
    public String cachePath;
    public BitmapDisplayConfig defaultDisplayConfig;
    public int diskCacheSize;
    public Displayer displayer;
    public Downloader downloader;
    public int memCacheSize;
    public float memCacheSizePercent;
    public int originalDiskCacheSize;
    public int poolSize;
    final FinalBitmap this$0;

    public void init()
    {
        if (downloader == null)
        {
            downloader = new SimpleHttpDownloader();
        }
        if (displayer == null)
        {
            displayer = new SimpleDisplayer();
        }
        bitmapProcess = new BitmapProcess(downloader, cachePath, originalDiskCacheSize);
    }

    public g(Context context)
    {
        this$0 = FinalBitmap.this;
        super();
        poolSize = 3;
        originalDiskCacheSize = 0x1e00000;
        defaultDisplayConfig = new BitmapDisplayConfig();
        defaultDisplayConfig.setAnimation(null);
        defaultDisplayConfig.setAnimationType(1);
        int i = (int)Math.floor(context.getResources().getDisplayMetrics().widthPixels / 4);
        defaultDisplayConfig.setBitmapHeight(i);
        defaultDisplayConfig.setBitmapWidth(i);
    }
}

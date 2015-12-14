// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.targetspot.android.sdk.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

public class CacheManager extends BroadcastReceiver
{
    class FileComparator
        implements Comparator
    {

        final CacheManager this$0;

        public int compare(File file, File file1)
        {
            long l = file.lastModified();
            long l1 = file1.lastModified();
            if (l < l1)
            {
                return -1;
            }
            return l <= l1 ? 0 : 1;
        }

        public volatile int compare(Object obj, Object obj1)
        {
            return compare((File)obj, (File)obj1);
        }

        FileComparator()
        {
            this$0 = CacheManager.this;
            super();
        }
    }


    static final int MAX_CACHE_SIZE = 0x300000;
    static final int SMALL_CACHE_SIZE = 0x40000;
    Context appContext;

    CacheManager(Context context)
    {
        appContext = context;
        start();
    }

    public void cleanCache(boolean flag)
    {
        File afile[] = appContext.getCacheDir().listFiles();
        int j = getCacheSize(afile);
        int k = getTargetSize(flag);
        if (j > k)
        {
            Arrays.sort(afile, new FileComparator());
            for (int i = 0; j > k && i < afile.length; i++)
            {
                j = (int)((long)j - afile[i].length());
                Log.d("CacheManager", (new StringBuilder()).append("Removing ").append(afile[i].getName()).toString());
                afile[i].delete();
            }

        }
    }

    int getCacheSize(File afile[])
    {
        int j = 0;
        int l = afile.length;
        for (int i = 0; i < l;)
        {
            File file = afile[i];
            int k = j;
            if (file.isFile())
            {
                k = (int)((long)j + file.length());
            }
            i++;
            j = k;
        }

        Log.d("CacheManager", (new StringBuilder()).append("Current cache size is ").append(j).toString());
        return j;
    }

    int getTargetSize(boolean flag)
    {
        return !flag ? 0x300000 : 0x40000;
    }

    public void onReceive(Context context, Intent intent)
    {
        Log.d("CacheManager", "Device storage low intent received");
        cleanCache(true);
    }

    void start()
    {
        appContext.registerReceiver(this, new IntentFilter("android.intent.action.DEVICE_STORAGE_LOW"));
    }

    public void stopCache()
    {
        appContext.unregisterReceiver(this);
    }
}

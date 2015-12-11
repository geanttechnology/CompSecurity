// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.tsz.afinal.bitmap.core;

import android.app.ActivityManager;
import android.content.Context;
import java.io.File;

// Referenced classes of package net.tsz.afinal.bitmap.core:
//            BitmapCache

public static class diskCacheDir
{

    public boolean clearDiskCacheOnStart;
    public android.graphics.cheParams.getMemoryClass compressFormat;
    public int compressQuality;
    public File diskCacheDir;
    public boolean diskCacheEnabled;
    public int diskCacheSize;
    public boolean initDiskCacheOnCreate;
    public int memCacheSize;
    public boolean memoryCacheEnabled;

    private static int getMemoryClass(Context context)
    {
        return ((ActivityManager)context.getSystemService("activity")).getMemoryClass();
    }

    public void setCompressFormat(android.graphics.cheParams cheparams)
    {
        compressFormat = cheparams;
    }

    public void setDiskCacheSize(int i)
    {
        diskCacheSize = i;
    }

    public void setMemCacheSize(int i)
    {
        memCacheSize = i;
    }

    public void setMemCacheSizePercent(Context context, float f)
    {
        if (f < 0.05F || f > 0.8F)
        {
            throw new IllegalArgumentException("setMemCacheSizePercent - percent must be between 0.05 and 0.8 (inclusive)");
        } else
        {
            memCacheSize = Math.round((float)getMemoryClass(context) * f * 1024F * 1024F);
            return;
        }
    }

    public (File file)
    {
        memCacheSize = 0x800000;
        diskCacheSize = 0x1400000;
        compressFormat = BitmapCache.access$0();
        compressQuality = 70;
        memoryCacheEnabled = true;
        diskCacheEnabled = true;
        clearDiskCacheOnStart = false;
        initDiskCacheOnCreate = false;
        diskCacheDir = file;
    }

    public diskCacheDir(String s)
    {
        memCacheSize = 0x800000;
        diskCacheSize = 0x1400000;
        compressFormat = BitmapCache.access$0();
        compressQuality = 70;
        memoryCacheEnabled = true;
        diskCacheEnabled = true;
        clearDiskCacheOnStart = false;
        initDiskCacheOnCreate = false;
        diskCacheDir = new File(s);
    }
}

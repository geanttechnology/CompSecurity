// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.disney.datg.videoplatforms.sdk.cache;

import android.content.Context;
import java.io.File;

// Referenced classes of package com.disney.datg.videoplatforms.sdk.cache:
//            CacheProperties, DiskCache

public class DiskCacheProperties extends CacheProperties
{

    public static boolean DEFAULT_CLEAR_DISK_CACHE_ON_START = true;
    public static String DEFAULT_DISK_CACHE_DIR = "default";
    public static boolean DEFAULT_INIT_DISK_CACHE_ON_CREATE = true;
    public File diskCacheDir;
    public int diskCacheSize;

    public DiskCacheProperties(Context context)
    {
        diskCacheSize = 0xa00000;
        diskCacheDir = DiskCache.getDiskCacheDir(context, DEFAULT_DISK_CACHE_DIR);
    }

}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.crashmanager;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Debug;
import android.os.Environment;
import android.os.StatFs;
import java.io.File;
import java.util.Map;

final class DeviceDetailsCollector
{

    private DeviceDetailsCollector()
    {
    }

    public static void collect(Context context, Map map)
    {
        map.put("androidVersion", android.os.Build.VERSION.RELEASE);
        map.put("androidBuildVersion", android.os.Build.VERSION.INCREMENTAL);
        map.put("deviceBoard", Build.BOARD);
        map.put("deviceBrand", Build.BRAND);
        map.put("deviceDisplay", Build.DISPLAY);
        map.put("deviceFingerPrint", Build.FINGERPRINT);
        map.put("deviceId", Build.ID);
        map.put("deviceManufacturer", Build.MANUFACTURER);
        map.put("deviceModel", Build.MODEL);
        map.put("deviceProduct", Build.PRODUCT);
        map.put("deviceTags", Build.TAGS);
        map.put("deviceTime", Long.toString(Build.TIME));
        map.put("deviceType", Build.TYPE);
        map.put("deviceUser", Build.USER);
        map.put("totalInternalMemorySize", Long.toString(getTotalInternalMemorySizeInBytes()));
        map.put("availableInternalMemorySize", Long.toString(getAvailableInternalMemorySizeInBytes()));
        if (context != null)
        {
            context = (ActivityManager)context.getSystemService("activity");
            if (context != null)
            {
                android.app.ActivityManager.MemoryInfo memoryinfo = new android.app.ActivityManager.MemoryInfo();
                context.getMemoryInfo(memoryinfo);
                map.put("memAvail", Long.toString(memoryinfo.availMem));
                map.put("memLowFlag", Boolean.toString(memoryinfo.lowMemory));
                map.put("memLowThreshold", Long.toString(memoryinfo.threshold));
            }
        }
        map.put("nativeHeapSize", Long.toString(Debug.getNativeHeapSize()));
        map.put("nativeHeapFreeSize", Long.toString(Debug.getNativeHeapAllocatedSize()));
        map.put("threadAllocCount", Long.toString(Debug.getThreadAllocCount()));
        map.put("threadAllocSize", Long.toString(Debug.getThreadAllocSize()));
        context = new android.os.Debug.MemoryInfo();
        Debug.getMemoryInfo(context);
        map.put("memoryDalvikPrivateDirty", Integer.toString(((android.os.Debug.MemoryInfo) (context)).dalvikPrivateDirty));
        map.put("memoryDalvikPss", Integer.toString(((android.os.Debug.MemoryInfo) (context)).dalvikPss));
        map.put("memoryDalvikSharedDirty", Integer.toString(((android.os.Debug.MemoryInfo) (context)).dalvikSharedDirty));
        map.put("memoryNativePrivateDirty", Integer.toString(((android.os.Debug.MemoryInfo) (context)).nativePrivateDirty));
        map.put("memoryNativePss", Integer.toString(((android.os.Debug.MemoryInfo) (context)).nativePss));
        map.put("memoryNativeSharedDirty", Integer.toString(((android.os.Debug.MemoryInfo) (context)).nativeSharedDirty));
        map.put("memoryOtherPrivateDirty", Integer.toString(((android.os.Debug.MemoryInfo) (context)).otherPrivateDirty));
        map.put("memoryOtherPss", Integer.toString(((android.os.Debug.MemoryInfo) (context)).otherPss));
        map.put("memoryOtherSharedDirty", Integer.toString(((android.os.Debug.MemoryInfo) (context)).otherSharedDirty));
    }

    public static long getAvailableCacheMemorySizeInBytes()
    {
        return getAvailableMemorySizeInBytes(Environment.getDownloadCacheDirectory());
    }

    public static long getAvailableInternalMemorySizeInBytes()
    {
        return getAvailableMemorySizeInBytes(Environment.getDataDirectory());
    }

    private static long getAvailableMemorySizeInBytes(File file)
    {
        file = new StatFs(file.getPath());
        long l = file.getBlockSize();
        return (long)file.getAvailableBlocks() * l;
    }

    public static long getTotalCacheMemorySizeInBytes()
    {
        return getTotalMemorySizeInBytes(Environment.getDownloadCacheDirectory());
    }

    public static long getTotalInternalMemorySizeInBytes()
    {
        return getTotalMemorySizeInBytes(Environment.getDataDirectory());
    }

    private static long getTotalMemorySizeInBytes(File file)
    {
        file = new StatFs(file.getPath());
        long l = file.getBlockSize();
        return (long)file.getBlockCount() * l;
    }
}

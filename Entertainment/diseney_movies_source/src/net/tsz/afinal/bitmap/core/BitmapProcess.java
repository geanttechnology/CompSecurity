// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.tsz.afinal.bitmap.core;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import net.tsz.afinal.bitmap.download.Downloader;

// Referenced classes of package net.tsz.afinal.bitmap.core:
//            LruDiskCache, BitmapCommonUtils, FileNameGenerator, BitmapDisplayConfig, 
//            BitmapDecoder

public class BitmapProcess
{

    private static final int DEFAULT_CACHE_SIZE = 0x1400000;
    private static final int DISK_CACHE_INDEX = 0;
    private static final String TAG = "BitmapProcess";
    private int cacheSize;
    private Downloader downloader;
    private final Object mHttpDiskCacheLock = new Object();
    private boolean mHttpDiskCacheStarting;
    private File mOriginalCacheDir;
    private LruDiskCache mOriginalDiskCache;
    private boolean neverCalculate;

    public BitmapProcess(Downloader downloader1, String s, int i)
    {
        mHttpDiskCacheStarting = true;
        neverCalculate = false;
        mOriginalCacheDir = new File((new StringBuilder(String.valueOf(s))).append("/original").toString());
        downloader = downloader1;
        int j = i;
        if (i <= 0)
        {
            j = 0x1400000;
        }
        cacheSize = j;
    }

    public void clearCacheInternal()
    {
        Object obj = mHttpDiskCacheLock;
        obj;
        JVM INSTR monitorenter ;
        if (mOriginalDiskCache == null) goto _L2; else goto _L1
_L1:
        boolean flag = mOriginalDiskCache.isClosed();
        if (flag) goto _L2; else goto _L3
_L3:
        mOriginalDiskCache.delete();
_L4:
        mOriginalDiskCache = null;
        mHttpDiskCacheStarting = true;
        initHttpDiskCache();
_L2:
        obj;
        JVM INSTR monitorexit ;
        return;
        Object obj1;
        obj1;
        Log.e("BitmapProcess", (new StringBuilder("clearCacheInternal - ")).append(obj1).toString());
          goto _L4
        obj1;
        obj;
        JVM INSTR monitorexit ;
        throw obj1;
    }

    public void closeCacheInternal()
    {
        Object obj = mHttpDiskCacheLock;
        obj;
        JVM INSTR monitorenter ;
        LruDiskCache lrudiskcache = mOriginalDiskCache;
        if (lrudiskcache == null)
        {
            break MISSING_BLOCK_LABEL_38;
        }
        if (!mOriginalDiskCache.isClosed())
        {
            mOriginalDiskCache.close();
            mOriginalDiskCache = null;
        }
_L1:
        obj;
        JVM INSTR monitorexit ;
        return;
        Object obj1;
        obj1;
        Log.e("BitmapProcess", (new StringBuilder("closeCacheInternal - ")).append(obj1).toString());
          goto _L1
        obj1;
        obj;
        JVM INSTR monitorexit ;
        throw obj1;
    }

    public void configCalculateBitmap(boolean flag)
    {
        neverCalculate = flag;
    }

    public void flushCacheInternal()
    {
        Object obj = mHttpDiskCacheLock;
        obj;
        JVM INSTR monitorenter ;
        LruDiskCache lrudiskcache = mOriginalDiskCache;
        if (lrudiskcache == null)
        {
            break MISSING_BLOCK_LABEL_23;
        }
        mOriginalDiskCache.flush();
_L1:
        obj;
        JVM INSTR monitorexit ;
        return;
        Object obj1;
        obj1;
        Log.e("BitmapProcess", (new StringBuilder("flush - ")).append(obj1).toString());
          goto _L1
        obj1;
        obj;
        JVM INSTR monitorexit ;
        throw obj1;
    }

    public void initHttpDiskCache()
    {
        if (!mOriginalCacheDir.exists())
        {
            mOriginalCacheDir.mkdirs();
        }
        Object obj = mHttpDiskCacheLock;
        obj;
        JVM INSTR monitorenter ;
        int i;
        long l;
        l = BitmapCommonUtils.getUsableSpace(mOriginalCacheDir);
        i = cacheSize;
        if (l <= (long)i)
        {
            break MISSING_BLOCK_LABEL_65;
        }
        mOriginalDiskCache = LruDiskCache.open(mOriginalCacheDir, 1, 1, cacheSize);
_L1:
        mHttpDiskCacheStarting = false;
        mHttpDiskCacheLock.notifyAll();
        obj;
        JVM INSTR monitorexit ;
        return;
        Object obj1;
        obj1;
        mOriginalDiskCache = null;
          goto _L1
        obj1;
        obj;
        JVM INSTR monitorexit ;
        throw obj1;
    }

    public Bitmap processBitmap(String s, BitmapDisplayConfig bitmapdisplayconfig)
    {
        Object obj2;
        Object obj4;
        Object obj5;
        Object obj6;
        Object obj7;
        Object obj8;
        Object obj9;
        String s1;
        s1 = FileNameGenerator.generator(s);
        obj4 = null;
        obj9 = null;
        obj2 = null;
        obj5 = null;
        obj6 = null;
        obj7 = null;
        obj8 = null;
        Object obj10 = mHttpDiskCacheLock;
        obj10;
        JVM INSTR monitorenter ;
_L13:
        if (mHttpDiskCacheStarting) goto _L2; else goto _L1
_L1:
        Object obj = mOriginalDiskCache;
        Object obj3 = obj4;
        if (obj == null) goto _L4; else goto _L3
_L3:
        Object obj1;
        obj = obj5;
        obj1 = obj6;
        obj2 = obj7;
        LruDiskCache.Snapshot snapshot = mOriginalDiskCache.get(s1);
        obj3 = snapshot;
        if (snapshot != null) goto _L6; else goto _L5
_L5:
        obj = obj5;
        obj1 = obj6;
        obj2 = obj7;
        obj3 = mOriginalDiskCache.edit(s1);
        if (obj3 == null) goto _L8; else goto _L7
_L7:
        obj = obj5;
        obj1 = obj6;
        obj2 = obj7;
        if (!downloader.downloadToLocalStreamByUrl(s, ((LruDiskCache.Editor) (obj3)).newOutputStream(0))) goto _L10; else goto _L9
_L9:
        obj = obj5;
        obj1 = obj6;
        obj2 = obj7;
        ((LruDiskCache.Editor) (obj3)).commit();
_L8:
        obj = obj5;
        obj1 = obj6;
        obj2 = obj7;
        obj3 = mOriginalDiskCache.get(s1);
_L6:
        s = obj9;
        obj = obj8;
        if (obj3 == null)
        {
            break MISSING_BLOCK_LABEL_237;
        }
        obj = obj5;
        obj1 = obj6;
        obj2 = obj7;
        s = (FileInputStream)((LruDiskCache.Snapshot) (obj3)).getInputStream(0);
        obj = s;
        obj1 = s;
        obj2 = s;
        obj3 = s.getFD();
        obj1 = obj3;
        obj = s;
        s = ((String) (obj1));
        obj3 = s;
        obj2 = obj;
        if (s != null) goto _L4; else goto _L11
_L11:
        obj3 = s;
        obj2 = obj;
        if (obj == null) goto _L4; else goto _L12
_L12:
        ((FileInputStream) (obj)).close();
        obj2 = obj;
        obj3 = s;
_L4:
        obj10;
        JVM INSTR monitorexit ;
        s = null;
        if (obj3 != null)
        {
            if (neverCalculate)
            {
                s = BitmapFactory.decodeFileDescriptor(((java.io.FileDescriptor) (obj3)));
            } else
            {
                s = BitmapDecoder.decodeSampledBitmapFromDescriptor(((java.io.FileDescriptor) (obj3)), bitmapdisplayconfig.getBitmapWidth(), bitmapdisplayconfig.getBitmapHeight());
            }
        }
        IOException ioexception;
        if (obj2 != null)
        {
            try
            {
                ((FileInputStream) (obj2)).close();
            }
            // Misplaced declaration of an exception variable
            catch (BitmapDisplayConfig bitmapdisplayconfig)
            {
                return s;
            }
        }
        return s;
_L2:
        try
        {
            mHttpDiskCacheLock.wait();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj) { }
        finally { }
          goto _L13
_L10:
        obj = obj5;
        obj1 = obj6;
        obj2 = obj7;
        ((LruDiskCache.Editor) (obj3)).abort();
          goto _L8
        s;
        obj2 = obj;
        Log.e("BitmapProcess", (new StringBuilder("processBitmap - ")).append(s).toString());
        obj3 = obj4;
        obj2 = obj;
        if (false) goto _L4; else goto _L14
_L14:
        obj3 = obj4;
        obj2 = obj;
        if (obj == null) goto _L4; else goto _L15
_L15:
        ((FileInputStream) (obj)).close();
        obj3 = obj4;
        obj2 = obj;
          goto _L4
        s;
        obj3 = obj4;
        obj2 = obj;
          goto _L4
        s;
        obj2 = obj1;
        Log.e("BitmapProcess", (new StringBuilder("processBitmap - ")).append(s).toString());
        obj3 = obj4;
        obj2 = obj1;
        if (false) goto _L4; else goto _L16
_L16:
        obj3 = obj4;
        obj2 = obj1;
        if (obj1 == null) goto _L4; else goto _L17
_L17:
        ((FileInputStream) (obj1)).close();
        obj3 = obj4;
        obj2 = obj1;
          goto _L4
        s;
        obj3 = obj4;
        obj2 = obj1;
          goto _L4
        s;
        if (false || obj2 == null)
        {
            break MISSING_BLOCK_LABEL_503;
        }
        try
        {
            ((FileInputStream) (obj2)).close();
        }
        // Misplaced declaration of an exception variable
        catch (BitmapDisplayConfig bitmapdisplayconfig) { }
        throw s;
        obj10;
        JVM INSTR monitorexit ;
        throw s;
        ioexception;
        obj3 = s;
        obj2 = obj;
          goto _L4
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.util.video;

import android.content.Context;
import android.os.StatFs;
import co.vine.android.network.HttpResult;
import co.vine.android.util.CrashUtil;
import co.vine.android.util.UrlResource;
import co.vine.android.util.UrlResourceCache;
import co.vine.android.util.Util;
import com.edisonwang.android.slog.SLog;
import com.vandalsoftware.io.DiskLruCache;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

// Referenced classes of package co.vine.android.util.video:
//            VideoKey, UrlVideo, VideoListener

public class VideoCache extends UrlResourceCache
{

    private static final int AVG_LOCK[] = new int[0];
    private static final String CACHE_NAME = "video_cache";
    private static final int INDEX_TIMESTAMP = 1;
    private static final int INDEX_VIDEO_BYTES = 0;
    private static final int LOCK[] = new int[0];
    private static final int MAX_AVERAGE = 5;
    private static final int MAX_EXTERNAL_DISK_CACHE_SIZE = 0x9600000;
    private static final int MAX_INTERNAL_DISK_CACHE_SIZE = 0x3200000;
    private static final int VALUE_COUNT = 2;
    private static final int VERSION = 2;
    private static int averagePosition = 0;
    private static final int averages[] = new int[5];
    private static int numberRecorded = 0;
    private static DiskLruCache sDiskCache;
    private static boolean sIsCacheInitialized = false;
    private final ArrayList mListeners = new ArrayList();

    public VideoCache(Context context, int i)
    {
        super(context, i);
    }

    public static void evictExpiredEntries(Context context, int i)
    {
        Iterator iterator;
        context = getCacheInstance(context);
        iterator = (new LinkedHashSet(context.getLruEntries().keySet())).iterator();
_L1:
        String s;
        Object obj;
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_129;
            }
            s = (String)iterator.next();
            obj = context.get(s, true);
        } while (obj == null);
        ByteBuffer bytebuffer = ByteBuffer.allocate(8);
        obj = ((com.vandalsoftware.io.DiskLruCache.Snapshot) (obj)).getInputStream(1);
        byte abyte0[] = new byte[8];
        if (((InputStream) (obj)).read(abyte0, 0, 8) > 0)
        {
            bytebuffer.put(abyte0).flip();
            if (System.currentTimeMillis() - bytebuffer.getLong() <= (long)i * 0x36ee80L)
            {
                break MISSING_BLOCK_LABEL_129;
            }
            context.remove(s);
        }
          goto _L1
        context;
    }

    protected static File getCacheDir()
    {
        int ai[] = LOCK;
        ai;
        JVM INSTR monitorenter ;
        File file;
        if (sDiskCache == null)
        {
            break MISSING_BLOCK_LABEL_23;
        }
        file = sDiskCache.getDirectory();
        return file;
        ai;
        JVM INSTR monitorexit ;
        return null;
        Exception exception;
        exception;
        ai;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private static DiskLruCache getCacheInstance(Context context)
    {
        int ai[] = LOCK;
        ai;
        JVM INSTR monitorenter ;
        boolean flag = sIsCacheInitialized;
        Object obj;
        if (flag)
        {
            break MISSING_BLOCK_LABEL_44;
        }
        obj = null;
        File file = Util.getExternalCacheDir(context);
        if (file == null)
        {
            break MISSING_BLOCK_LABEL_52;
        }
        try
        {
            context = prepareCache(file, 0x9600000L, false);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context = obj;
        }
        sDiskCache = context;
        sIsCacheInitialized = true;
        context = sDiskCache;
        ai;
        JVM INSTR monitorexit ;
        return context;
label0:
        {
            if (android.os.Build.VERSION.SDK_INT >= 14)
            {
                break label0;
            }
            context = prepareCache(context.getDir("video_cache", 1), 0x3200000L, false);
        }
        break MISSING_BLOCK_LABEL_36;
        context = prepareCache(context.getCacheDir(), 0x3200000L, false);
        break MISSING_BLOCK_LABEL_36;
        context;
        ai;
        JVM INSTR monitorexit ;
        throw context;
    }

    public static int getCurrentAverageSpeed()
    {
        int ai[] = AVG_LOCK;
        ai;
        JVM INSTR monitorenter ;
        int j = 0;
        if (numberRecorded != 0)
        {
            break MISSING_BLOCK_LABEL_19;
        }
        ai;
        JVM INSTR monitorexit ;
        return 0x7fffffff;
        int k = Math.min(numberRecorded, 5);
        int i = 0;
_L2:
        if (i >= k)
        {
            break; /* Loop/switch isn't completed */
        }
        j += averages[i];
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        i = j / k;
        ai;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        ai;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public static void invalidateCache()
    {
        synchronized (LOCK)
        {
            sDiskCache = null;
            sIsCacheInitialized = false;
        }
        return;
        exception;
        ai;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private static DiskLruCache prepareCache(File file, long l, boolean flag)
        throws IOException
    {
        long l2;
        long l3;
        l3 = -1L;
        l2 = l3;
        StatFs statfs = new StatFs(file.getPath());
        l2 = l3;
        int i = android.os.Build.VERSION.SDK_INT;
        long l1;
        l1 = l3;
        if (i < 18)
        {
            break MISSING_BLOCK_LABEL_71;
        }
        l2 = l3;
        l1 = statfs.getBlockSizeLong();
        l2 = l3;
        long l4 = statfs.getAvailableBlocksLong();
        l1 *= l4;
_L3:
        l2 = l1;
        if (l1 >= 0L)
        {
            break MISSING_BLOCK_LABEL_113;
        }
        l2 = l1;
        l3 = statfs.getBlockSize();
        l2 = l1;
        i = statfs.getAvailableBlocks();
        l2 = l3 * (long)i;
_L1:
        l3 = l2;
        if (l2 < 0L)
        {
            l3 = file.getUsableSpace();
        }
        File file1;
        Exception exception;
        if (l3 > 0L)
        {
            if (l3 > l)
            {
                l1 = l;
            } else
            {
                l1 = l3 / 10L;
            }
        } else
        {
            l1 = l;
        }
        SLog.d("Preparing a DiskLruCache with absMax={}, available={}, maxSize={}", Long.valueOf(l), Long.valueOf(l3), Long.valueOf(l1));
        file1 = file;
        if (flag)
        {
            file1 = new File(file, "video_cache");
        }
        return DiskLruCache.open(file1, 2, 2, l1);
        exception;
        CrashUtil.log("Failed to statf, but it is ok, we will get the aval size in other ways on this phone.");
          goto _L1
        NoSuchMethodError nosuchmethoderror;
        nosuchmethoderror;
        l1 = l3;
        if (true) goto _L3; else goto _L2
_L2:
    }

    private static void reportAverageSpeed(int i)
    {
        synchronized (AVG_LOCK)
        {
            SLog.d("Latest download speed: {}", Integer.valueOf(i));
            int j = averagePosition % 5;
            averages[j] = i;
            averagePosition = (j + 1) % 5;
            numberRecorded++;
        }
        return;
        exception;
        ai;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public static void resetAverageSpeed()
    {
        synchronized (AVG_LOCK)
        {
            averagePosition = 0;
            numberRecorded = 0;
        }
        return;
        exception;
        ai;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void addListener(VideoListener videolistener)
    {
        mListeners.add(videolistener);
    }

    public UrlVideo get(long l, VideoKey videokey)
    {
        return (UrlVideo)super.get(l, videokey, videokey.url, true);
    }

    public String getFile(long l, VideoKey videokey, boolean flag)
    {
        videokey = (UrlVideo)get(l, videokey, videokey.url, true);
        if (videokey != null)
        {
            return ((File)((UrlVideo) (videokey)).value).getAbsolutePath();
        } else
        {
            return null;
        }
    }

    protected volatile UrlResource instantiateResource(Object obj, String s, Object obj1)
    {
        return instantiateResource((VideoKey)obj, s, (File)obj1);
    }

    protected UrlVideo instantiateResource(VideoKey videokey, String s, File file)
    {
        return new UrlVideo(s, file);
    }

    protected volatile UrlResource loadResource(long l, Object obj, String s)
    {
        return loadResource(l, (VideoKey)obj, s);
    }

    protected UrlVideo loadResource(long l, VideoKey videokey, String s)
    {
        Object obj;
        com.vandalsoftware.io.DiskLruCache.Snapshot snapshot;
        com.vandalsoftware.io.DiskLruCache.Snapshot snapshot1;
        obj = Util.md5Digest(s);
        if (obj == null)
        {
            return null;
        }
        snapshot1 = null;
        snapshot = null;
        int ai[] = LOCK;
        ai;
        JVM INSTR monitorenter ;
        DiskLruCache disklrucache = getCacheInstance(mContext);
        if (disklrucache == null)
        {
            break MISSING_BLOCK_LABEL_129;
        }
        boolean flag = disklrucache.isClosed();
        if (flag)
        {
            break MISSING_BLOCK_LABEL_129;
        }
        obj = disklrucache.get(((String) (obj)));
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_84;
        }
        Util.closeSilently(((java.io.Closeable) (obj)));
        ai;
        JVM INSTR monitorexit ;
        return null;
        videokey;
        ai;
        JVM INSTR monitorexit ;
        throw videokey;
        snapshot = ((com.vandalsoftware.io.DiskLruCache.Snapshot) (obj));
        snapshot1 = ((com.vandalsoftware.io.DiskLruCache.Snapshot) (obj));
        videokey = instantiateResource(videokey, s, new File(((com.vandalsoftware.io.DiskLruCache.Snapshot) (obj)).getPath(0)));
        Util.closeSilently(((java.io.Closeable) (obj)));
        ai;
        JVM INSTR monitorexit ;
        return videokey;
        videokey;
        Util.closeSilently(snapshot);
        ai;
        JVM INSTR monitorexit ;
        return null;
        videokey;
        Util.closeSilently(snapshot1);
        throw videokey;
    }

    protected volatile UrlResource obtainResource(Object obj, String s, InputStream inputstream)
    {
        return obtainResource((VideoKey)obj, s, inputstream);
    }

    protected UrlVideo obtainResource(VideoKey videokey, String s, InputStream inputstream)
    {
        Object obj;
        File file;
        File file1;
        file = Util.getCacheDir(mContext);
        if (file == null)
        {
            break MISSING_BLOCK_LABEL_97;
        }
        obj = Util.md5Digest(s);
        videokey = ((VideoKey) (obj));
        if (obj == null)
        {
            videokey = Util.randomString(10);
        }
        file1 = new File(file, videokey);
        obj = null;
        file = null;
        videokey = ((VideoKey) (obj));
        long l = System.currentTimeMillis();
        videokey = ((VideoKey) (obj));
        obj = new FileOutputStream(file1);
        int i = Util.readFullyWriteTo(inputstream, ((OutputStream) (obj)), 4096);
        if (i == 0)
        {
            Util.closeSilently(((java.io.Closeable) (obj)));
            return null;
        }
        break MISSING_BLOCK_LABEL_105;
        SLog.w("cache dir is null.");
        return null;
        l = (System.currentTimeMillis() - l) / 1000L;
        if (i <= 0)
        {
            break MISSING_BLOCK_LABEL_176;
        }
        SLog.d("Download time: {}.", Long.valueOf(l));
        reportAverageSpeed((int)Math.round((double)(i / 1024) / (double)Math.max(1L, l)));
_L1:
        ((FileOutputStream) (obj)).flush();
        Util.closeSilently(((java.io.Closeable) (obj)));
        return new UrlVideo(s, file1);
        SLog.d("Invalid bytesLen or time: {}", Integer.valueOf(i));
          goto _L1
        inputstream;
        s = ((String) (obj));
_L5:
        videokey = s;
        SLog.w("Failed to download file.", inputstream);
        Util.closeSilently(s);
        return null;
        s;
_L3:
        Util.closeSilently(videokey);
        throw s;
        s;
        videokey = ((VideoKey) (obj));
        if (true) goto _L3; else goto _L2
_L2:
        inputstream;
        s = file;
        if (true) goto _L5; else goto _L4
_L4:
    }

    protected void onResourceError(VideoKey videokey, HttpResult httpresult)
    {
        for (int i = mListeners.size() - 1; i >= 0; i--)
        {
            ((VideoListener)mListeners.get(i)).onVideoPathError(this, videokey, httpresult);
        }

    }

    protected volatile void onResourceError(Object obj, HttpResult httpresult)
    {
        onResourceError((VideoKey)obj, httpresult);
    }

    protected void onResourceLoaded(HashMap hashmap)
    {
        for (int i = mListeners.size() - 1; i >= 0; i--)
        {
            ((VideoListener)mListeners.get(i)).onVideoPathObtained(this, hashmap);
        }

    }

    public String peekPath(VideoKey videokey)
    {
        videokey = (UrlVideo)super.peek(videokey);
        if (videokey != null)
        {
            return ((UrlVideo) (videokey)).url;
        } else
        {
            return null;
        }
    }

    public void prepopulateVideoCacheForUrl(long l, VideoKey videokey, String s, InputStream inputstream)
    {
        saveResource(l, videokey, s, inputstream, false);
        instantiateResource(videokey, s, ((File) (null)));
    }

    public void removeListener(VideoListener videolistener)
    {
        mListeners.remove(videolistener);
    }

    protected volatile UrlResource saveResource(long l, Object obj, String s, InputStream inputstream, boolean flag)
    {
        return saveResource(l, (VideoKey)obj, s, inputstream, flag);
    }

    protected UrlVideo saveResource(long l, VideoKey videokey, String s, InputStream inputstream, boolean flag)
    {
        Object obj;
        com.vandalsoftware.io.DiskLruCache.Editor editor;
        Object obj1;
        Object obj2;
        Object obj3;
        String s1;
        s1 = Util.md5Digest(s);
        obj = null;
        editor = null;
        obj2 = null;
        obj1 = null;
        obj3 = null;
        int ai[] = LOCK;
        ai;
        JVM INSTR monitorenter ;
        DiskLruCache disklrucache = getCacheInstance(mContext);
        if (disklrucache == null)
        {
            break MISSING_BLOCK_LABEL_614;
        }
        boolean flag3 = disklrucache.isClosed();
        boolean flag1;
        boolean flag2;
        int i;
        if (flag3)
        {
            break MISSING_BLOCK_LABEL_614;
        }
        i = 0;
        flag1 = false;
        flag2 = i;
        com.vandalsoftware.io.DiskLruCache.Editor editor1 = disklrucache.edit(s1);
        if (editor1 == null)
        {
            break MISSING_BLOCK_LABEL_290;
        }
        editor = editor1;
        obj = editor1;
        flag2 = i;
        l = System.currentTimeMillis();
        editor = editor1;
        obj = editor1;
        flag2 = i;
        i = Util.readFullyWriteTo(inputstream, editor1.newOutputStream(0), 4096);
        ByteBuffer bytebuffer;
        if (i > 0)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        editor = editor1;
        obj = editor1;
        flag2 = flag1;
        l = (System.currentTimeMillis() - l) / 1000L;
        editor = editor1;
        obj = editor1;
        flag2 = flag1;
        SLog.d("Bytes {} Download time: {}.", Integer.valueOf(i), Long.valueOf(l));
        if (i <= 0 || !flag)
        {
            break MISSING_BLOCK_LABEL_224;
        }
        editor = editor1;
        obj = editor1;
        flag2 = flag1;
        reportAverageSpeed((int)Math.round((double)(i / 1024) / (double)Math.max(1L, l)));
        editor = editor1;
        obj = editor1;
        flag2 = flag1;
        bytebuffer = ByteBuffer.allocate(8);
        editor = editor1;
        obj = editor1;
        flag2 = flag1;
        bytebuffer.putLong(System.currentTimeMillis());
        editor = editor1;
        obj = editor1;
        flag2 = flag1;
        editor1.newOutputStream(1).write(bytebuffer.array());
        obj = obj3;
        if (editor1 == null) goto _L2; else goto _L1
_L1:
        if (!flag1) goto _L4; else goto _L3
_L3:
        obj = obj2;
        editor1.commit();
        obj = obj2;
        disklrucache.flush();
        obj = obj2;
        videokey = new UrlVideo(s, new File(disklrucache.get(s1, false).getPath(0)));
        obj = videokey;
_L2:
        ai;
        JVM INSTR monitorexit ;
        return ((UrlVideo) (obj));
_L4:
        obj = obj2;
        editor1.abort();
        obj = obj2;
        videokey = obtainResource(videokey, s, inputstream);
        obj = videokey;
        CrashUtil.log("Failed to save a video to DiskLruCache");
        obj = videokey;
          goto _L2
        videokey;
          goto _L2
        obj;
        obj = obj3;
        if (editor == null) goto _L2; else goto _L5
_L5:
        if (true)
        {
            break MISSING_BLOCK_LABEL_484;
        }
        obj = obj1;
        editor.commit();
        obj = obj1;
        disklrucache.flush();
        obj = obj1;
        videokey = new UrlVideo(s, new File(disklrucache.get(s1, false).getPath(0)));
        obj = videokey;
          goto _L2
        obj = obj1;
        editor.abort();
        obj = obj1;
        videokey = obtainResource(videokey, s, inputstream);
        obj = videokey;
        CrashUtil.log("Failed to save a video to DiskLruCache");
        obj = videokey;
          goto _L2
        videokey;
          goto _L2
        Exception exception;
        exception;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_577;
        }
        if (!flag2)
        {
            break MISSING_BLOCK_LABEL_586;
        }
        try
        {
            ((com.vandalsoftware.io.DiskLruCache.Editor) (obj)).commit();
            disklrucache.flush();
            new UrlVideo(s, new File(disklrucache.get(s1, false).getPath(0)));
        }
        // Misplaced declaration of an exception variable
        catch (VideoKey videokey) { }
        throw exception;
        videokey;
        ai;
        JVM INSTR monitorexit ;
        throw videokey;
        ((com.vandalsoftware.io.DiskLruCache.Editor) (obj)).abort();
        obtainResource(videokey, s, inputstream);
        CrashUtil.log("Failed to save a video to DiskLruCache");
        break MISSING_BLOCK_LABEL_577;
        obj = obtainResource(videokey, s, inputstream);
        CrashUtil.log("Videos DiskLruCache could not be opened");
          goto _L2
    }

}

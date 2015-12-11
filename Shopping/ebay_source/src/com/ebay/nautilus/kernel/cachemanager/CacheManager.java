// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel.cachemanager;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.ebay.nautilus.kernel.NautilusKernel;
import com.ebay.nautilus.kernel.io.CacheStream;
import com.ebay.nautilus.kernel.io.SplitOutputStream;
import com.ebay.nautilus.kernel.util.DelayedAsyncTask;
import com.ebay.nautilus.kernel.util.FileUtil;
import com.ebay.nautilus.kernel.util.StreamUtil;
import com.ebay.nautilus.kernel.util.TimedCacheWallClock;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class CacheManager
{
    public static interface CacheConfig
    {

        public abstract long getDiskLimit();

        public abstract int getFlatMemoryLimit();

        public abstract long getMaxTtl();

        public abstract int getMemoryLimit();
    }

    private static class FileMeta
    {

        public final File file;
        private long fileSize;
        public final long lastModified;
        public MinimalMetaInfo minimalMetaInfo;

        public static FileMeta[] createMeta(File afile[])
        {
            if (afile != null) goto _L2; else goto _L1
_L1:
            FileMeta afilemeta[] = new FileMeta[0];
_L4:
            return afilemeta;
_L2:
            FileMeta afilemeta1[] = new FileMeta[afile.length];
            int i = 0;
            do
            {
                afilemeta = afilemeta1;
                if (i >= afile.length)
                {
                    continue;
                }
                afilemeta1[i] = new FileMeta(afile[i]);
                i++;
            } while (true);
            if (true) goto _L4; else goto _L3
_L3:
        }

        private long getRemainingTtl(long l, long l1)
        {
            if (lastModified == 0L)
            {
                return 0L;
            } else
            {
                return l - (l1 - lastModified);
            }
        }

        public int compareTo(FileMeta filemeta)
        {
            if (filemeta == null)
            {
                throw new IllegalArgumentException("other must not be null");
            } else
            {
                return file.compareTo(filemeta.file);
            }
        }

        public boolean equals(Object obj)
        {
            if (this != obj) goto _L2; else goto _L1
_L1:
            return true;
_L2:
            if (obj == null)
            {
                return false;
            }
            if (getClass() != obj.getClass())
            {
                return false;
            }
            obj = (FileMeta)obj;
            if (file != null)
            {
                continue; /* Loop/switch isn't completed */
            }
            if (((FileMeta) (obj)).file == null) goto _L1; else goto _L3
_L3:
            return false;
            if (file.equals(((FileMeta) (obj)).file)) goto _L1; else goto _L4
_L4:
            return false;
        }

        public boolean exists()
        {
            return file.exists();
        }

        public long getFileSize()
        {
            if (fileSize == -1L)
            {
                fileSize = file.length();
            }
            return fileSize;
        }

        public int hashCode()
        {
            int i;
            if (file == null)
            {
                i = 0;
            } else
            {
                i = file.hashCode();
            }
            return i + 31;
        }

        public boolean isExpired(long l, long l1)
        {
            return getRemainingTtl(l, l1) <= 0L;
        }

        public FileMeta(File file1)
        {
            this(file1, null);
        }

        public FileMeta(File file1, MinimalMetaInfo minimalmetainfo)
        {
            fileSize = -1L;
            file = file1;
            lastModified = file1.lastModified();
            minimalMetaInfo = minimalmetainfo;
        }
    }

    private static class FlatData
    {

        public final byte bytes[];
        public final int itemSize;

        public FlatData(byte abyte0[], int i)
        {
            bytes = abyte0;
            itemSize = i;
        }
    }

    private static class FlatDataTimedCacheWallClock extends TimedCacheWallClock
    {

        protected volatile int sizeOf(Object obj, Object obj1)
        {
            return sizeOf((String)obj, (FlatData)obj1);
        }

        protected int sizeOf(String s, FlatData flatdata)
        {
            return flatdata.itemSize;
        }

        public FlatDataTimedCacheWallClock(int i, long l)
        {
            super(i, l);
        }
    }

    static class MetaInfo extends MinimalMetaInfo
    {

        public final String key;

        public MetaInfo(String s, int i, long l)
        {
            super(i, l);
            key = s;
        }
    }

    private static class MinimalMetaInfo
    {

        public final long expirationTime;
        public final int itemSize;

        public boolean isExpired(long l)
        {
            return l >= expirationTime;
        }

        public long remainingTtl(long l)
        {
            return expirationTime - l;
        }

        protected MinimalMetaInfo(int i, long l)
        {
            itemSize = i;
            expirationTime = l;
        }

        protected MinimalMetaInfo(MinimalMetaInfo minimalmetainfo)
        {
            this(minimalmetainfo.itemSize, minimalmetainfo.expirationTime);
        }
    }

    private final class PeriodicDiskTrimTask extends DelayedAsyncTask
    {

        private final long diskLimit;
        final CacheManager this$0;

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            if (CacheManager.logger.isLoggable)
            {
                log("Starting on disk cache trim.");
            }
            int i;
            synchronized (lock)
            {
                diskTrimTask = null;
                i = trimDiskCache(filesNewestToOldest(), diskLimit, false);
            }
            if (CacheManager.logger.isLoggable)
            {
                log((new StringBuilder()).append("Finished on disk cache trim. Trimmed ").append(i).append(" items.").toString());
            }
            return null;
            exception;
            avoid;
            JVM INSTR monitorexit ;
            throw exception;
        }

        protected PeriodicDiskTrimTask(long l)
        {
            this$0 = CacheManager.this;
            super();
            diskLimit = l;
        }
    }

    public static interface PersitenceMapper
    {

        public abstract void deflateCached(OutputStream outputstream, Object obj)
            throws IOException;

        public abstract Object inflateCached(InputStream inputstream, Class class1)
            throws IOException;
    }

    protected static class SharedInitState
    {

        private volatile boolean anyInstanceInitialized;
        private final Object clearLock = new Object();
        private volatile boolean needClearAllData;

        public void TEST_resetState()
        {
            needClearAllData = false;
            anyInstanceInitialized = false;
        }

        public void clearAllData()
        {
            if (anyInstanceInitialized)
            {
                throw new IllegalStateException("clearAllData() cannot be called after the first instance has been initialized.");
            } else
            {
                needClearAllData = true;
                return;
            }
        }

        public void sharedInit(File file)
        {
            anyInstanceInitialized = true;
            Object obj = clearLock;
            obj;
            JVM INSTR monitorenter ;
            if (needClearAllData)
            {
                needClearAllData = false;
                if (file.isDirectory())
                {
                    break MISSING_BLOCK_LABEL_39;
                }
                file.delete();
            }
_L2:
            return;
            FileUtil.recursiveDelete(file, true);
            if (true) goto _L2; else goto _L1
_L1:
            file;
            obj;
            JVM INSTR monitorexit ;
            throw file;
        }

        protected SharedInitState()
        {
        }
    }

    private static class ValueWithMeta
    {

        public final MetaInfo metaInfo;
        public final Object value;

        public ValueWithMeta(MetaInfo metainfo, Object obj)
        {
            metaInfo = metainfo;
            value = obj;
        }
    }

    private class WrappedTimedCacheWallClock extends TimedCacheWallClock
    {

        final CacheManager this$0;

        protected volatile int sizeOf(Object obj, Object obj1)
        {
            return sizeOf((String)obj, obj1);
        }

        protected int sizeOf(String s, Object obj)
        {
            return CacheManager.this.sizeOf(s, obj);
        }

        public WrappedTimedCacheWallClock(int i, long l)
        {
            this$0 = CacheManager.this;
            super(i, l);
        }
    }


    private static final String DATA_SUFFIX = ".dat";
    public static final String DIR_NAME = "cacheManager";
    private static final long DISK_TRIM_INTERVAL;
    private static final long DISK_TRIM_JITTER;
    private static final int ERR_NO_SPACE = 28;
    private static final int IN_BUFFER_SIZE = 4096;
    private static final Gson META_MAPPER = (new GsonBuilder()).setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").create();
    private static final int META_ONLY_BUFFER_SIZE = 1024;
    private static final int OUT_BUFFER_SIZE = 4096;
    private static final SharedInitState cacheInitState = new SharedInitState();
    private static final Comparator fileMetaDataComparator = new Comparator() {

        public int compare(FileMeta filemeta, FileMeta filemeta1)
        {
            long l = filemeta1.lastModified - filemeta.lastModified;
            if (l > 0L)
            {
                return 1;
            }
            if (l < 0L)
            {
                return -1;
            } else
            {
                return filemeta1.compareTo(filemeta);
            }
        }

        public volatile int compare(Object obj, Object obj1)
        {
            return compare((FileMeta)obj, (FileMeta)obj1);
        }

    };
    static final com.ebay.nautilus.kernel.util.FwLog.LogInfo logger = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("CacheManager", 3, "Log cache manager usage");
    private static volatile boolean preventTrimTask;
    private Map allFiles;
    private final Class clz;
    private File dataDir;
    private final long diskLimit;
    private PeriodicDiskTrimTask diskTrimTask;
    private final boolean fastTrim;
    private final FlatDataTimedCacheWallClock flatMemCache;
    private File instanceDir;
    private final Object lock;
    protected final long maxTtl;
    private final WrappedTimedCacheWallClock memCache;
    private final Object memCacheLock;
    private final String name;
    private boolean needsBackgroundInit;
    private final PersitenceMapper persistenceMapper;

    public CacheManager(Context context, PersitenceMapper persitencemapper, Class class1, String s, int i, int j, long l, long l1, boolean flag)
    {
        this(context, context.getCacheDir(), persitencemapper, class1, s, i, j, l, l1, flag);
    }

    public CacheManager(Context context, PersitenceMapper persitencemapper, Class class1, String s, CacheConfig cacheconfig, boolean flag)
    {
        this(context, context.getCacheDir(), persitencemapper, class1, s, cacheconfig.getMemoryLimit(), cacheconfig.getFlatMemoryLimit(), cacheconfig.getDiskLimit(), cacheconfig.getMaxTtl(), flag);
    }

    protected CacheManager(Context context, File file, PersitenceMapper persitencemapper, Class class1, String s, int i, int j, 
            long l, long l1, boolean flag)
    {
        lock = new Object();
        dataDir = file;
        name = s;
        long l2 = l;
        if (file == null)
        {
            if (logger.isLoggable && l > 0L)
            {
                log("Application data directory was null, not using disk based persistence.");
            }
            l2 = 0L;
        }
        persistenceMapper = persitencemapper;
        clz = class1;
        i = getAdjustedCacheSize(context, i);
        j = getAdjustedCacheSize(context, j);
        maxTtl = Math.min(l1, 0x3fffffffffffffffL);
        if (i <= 0)
        {
            context = null;
        } else
        {
            context = new WrappedTimedCacheWallClock(i, l1);
        }
        memCache = context;
        if (j <= 0)
        {
            context = null;
        } else
        {
            context = new FlatDataTimedCacheWallClock(j, l1);
        }
        flatMemCache = context;
        if (memCache != null)
        {
            context = memCache;
        } else
        {
            context = flatMemCache;
        }
        memCacheLock = context;
        diskLimit = l2;
        if (l2 <= 0L)
        {
            instanceDir = null;
            fastTrim = false;
        } else
        {
            needsBackgroundInit = true;
            fastTrim = flag;
        }
        if (Looper.getMainLooper() != Looper.myLooper())
        {
            ensureInitialized();
        }
    }

    public static void TEST_disableScheduledTrim()
    {
        preventTrimTask = true;
    }

    public static void TEST_resetInitState()
    {
        cacheInitState.TEST_resetState();
    }

    private void addFastTrim(File file, MetaInfo metainfo)
    {
        String s;
label0:
        {
            if (fastTrim)
            {
                s = getFileKey(file);
                FileMeta filemeta = (FileMeta)allFiles.get(s);
                if (filemeta == null)
                {
                    break label0;
                }
                filemeta.minimalMetaInfo = metainfo;
            }
            return;
        }
        file = new FileMeta(file, new MinimalMetaInfo(metainfo));
        allFiles.put(s, file);
    }

    private String buildLogMessage(String s)
    {
        return (new StringBuilder()).append(name).append(": ").append(s).toString();
    }

    public static void clearAllData()
    {
        cacheInitState.clearAllData();
    }

    private void ensureInitialized()
    {
        NautilusKernel.verifyNotMain();
        synchronized (lock)
        {
            if (needsBackgroundInit)
            {
                needsBackgroundInit = false;
                instanceDir = initInstancePath(dataDir);
            }
            if (fastTrim && allFiles == null)
            {
                allFiles = loadAllFileMeta();
            }
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private long expirationTime(long l, long l1)
    {
        return Math.min(l + l1, 0x3fffffffffffffffL);
    }

    private List filesNewestToOldest()
    {
        Object obj;
        if (fastTrim)
        {
            obj = allFiles;
        } else
        {
            obj = loadAllFileMeta();
        }
        obj = new ArrayList(((Map) (obj)).values());
        Collections.sort(((List) (obj)), fileMetaDataComparator);
        return ((List) (obj));
    }

    private int getAdjustedCacheSize(Context context, int i)
    {
        return (int)((float)i * getCacheMemorySizeFactor(context));
    }

    private Integer getErrnoValue(Throwable throwable)
    {
        Object obj = null;
        Integer integer = obj;
        if (throwable == null)
        {
            break MISSING_BLOCK_LABEL_57;
        }
        Class class1;
        try
        {
            class1 = throwable.getClass();
        }
        // Misplaced declaration of an exception variable
        catch (Throwable throwable)
        {
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (Throwable throwable)
        {
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (Throwable throwable)
        {
            return null;
        }
        integer = obj;
        if (!TextUtils.equals(class1.getSimpleName(), "ErrnoException"))
        {
            break MISSING_BLOCK_LABEL_57;
        }
        throwable = ((Throwable) (class1.getField("errno").get(throwable)));
        integer = obj;
        if (throwable instanceof Integer)
        {
            integer = (Integer)throwable;
        }
        return integer;
    }

    private String getFileKey(File file)
    {
        return file.toString();
    }

    private long getRemainingTtl(File file, long l)
    {
        long l1 = file.lastModified();
        if (l1 == 0L)
        {
            return 0L;
        } else
        {
            return maxTtl - (l - l1);
        }
    }

    private ValueWithMeta getValueWithMetaFromFlatMemoryCache(String s)
    {
        String s1;
        ValueWithMeta valuewithmeta;
        Object obj;
        Object obj1;
        Object obj2;
        s1 = null;
        obj = null;
        if (!isFlatMemoryBacked())
        {
            break MISSING_BLOCK_LABEL_107;
        }
        valuewithmeta = null;
        obj1 = null;
        obj2 = null;
        s1 = obj1;
        FlatData flatdata = (FlatData)flatMemCache.get(s);
        s = obj;
        s1 = obj2;
        if (flatdata == null)
        {
            break MISSING_BLOCK_LABEL_101;
        }
        s1 = obj1;
        s = new DataInputStream(new ByteArrayInputStream(flatdata.bytes));
        valuewithmeta = new ValueWithMeta(readMeta(s), persistenceMapper.inflateCached(s, clz));
        s1 = s;
        s = valuewithmeta;
        StreamUtil.closeQuietly(s1);
        s1 = s;
        return s1;
        s;
        s = valuewithmeta;
_L4:
        s1 = s;
        if (!logger.isLoggable)
        {
            break MISSING_BLOCK_LABEL_132;
        }
        s1 = s;
        log("Failed to parse object from flat in memory cache.");
        StreamUtil.closeQuietly(s);
        return null;
        s;
_L2:
        StreamUtil.closeQuietly(s1);
        throw s;
        Exception exception;
        exception;
        s1 = s;
        s = exception;
        if (true) goto _L2; else goto _L1
_L1:
        IOException ioexception;
        ioexception;
        if (true) goto _L4; else goto _L3
_L3:
    }

    private Object inflateBytes(String s, byte abyte0[])
    {
        s = new ByteArrayInputStream(abyte0);
        abyte0 = ((byte []) (persistenceMapper.inflateCached(s, clz)));
        StreamUtil.closeQuietly(s);
        return abyte0;
        abyte0;
        if (logger.isLoggable)
        {
            log("Failed to inflate object.", abyte0);
        }
        StreamUtil.closeQuietly(s);
        return null;
        abyte0;
        StreamUtil.closeQuietly(s);
        throw abyte0;
    }

    private File initInstancePath(File file)
    {
        file = new File(file, getTopLevelDirName());
        if (file.exists() && !file.isDirectory())
        {
            file.delete();
        }
        sharedInit(file);
        File file1 = new File(file, name);
        if (file1.exists() && !file1.isDirectory())
        {
            file1.delete();
        }
        file = file1;
        if (!file1.exists())
        {
            file = file1;
            if (!file1.mkdirs())
            {
                logAsWarning((new StringBuilder()).append("Unable to create persistence instance directory, operating without persistence: ").append(file1.getAbsolutePath()).toString());
                file = null;
            }
        }
        return file;
    }

    private boolean isExpired(File file, long l)
    {
        return getRemainingTtl(file, l) <= 0L;
    }

    private boolean isFastTrimMetaExpired(File file, long l)
    {
        if (fastTrim)
        {
            file = (FileMeta)allFiles.get(getFileKey(file));
            if (file != null)
            {
                file = ((FileMeta) (file)).minimalMetaInfo;
                if (file != null)
                {
                    return file.isExpired(l);
                }
            }
        }
        return false;
    }

    private File keyToDataFile(String s)
    {
        return new File(instanceDir, (new StringBuilder()).append(FileUtil.safeName(s)).append(".dat").toString());
    }

    private Map loadAllFileMeta()
    {
        if (isDiskBacked()) goto _L2; else goto _L1
_L1:
        Object obj = new HashMap();
_L4:
        return ((Map) (obj));
_L2:
        FileMeta afilemeta[] = FileMeta.createMeta(instanceDir.listFiles());
        HashMap hashmap = new HashMap(afilemeta.length);
        int j = afilemeta.length;
        int i = 0;
        do
        {
            obj = hashmap;
            if (i >= j)
            {
                continue;
            }
            obj = afilemeta[i];
            hashmap.put(getFileKey(((FileMeta) (obj)).file), obj);
            i++;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    private DataOutputStream makeDataOutputStream(ByteArrayOutputStream bytearrayoutputstream, FileOutputStream fileoutputstream)
        throws IOException
    {
        if (fileoutputstream != null)
        {
            if (bytearrayoutputstream != null)
            {
                bytearrayoutputstream = new SplitOutputStream(fileoutputstream, bytearrayoutputstream);
            } else
            {
                bytearrayoutputstream = fileoutputstream;
            }
        }
        return new DataOutputStream(new BufferedOutputStream(bytearrayoutputstream, 4096));
    }

    private Object putInternal(String s, Object obj, byte abyte0[], long l)
    {
        ByteArrayOutputStream bytearrayoutputstream;
        Object obj1;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        ByteArrayOutputStream bytearrayoutputstream1;
        ByteArrayOutputStream bytearrayoutputstream2;
        Object obj6;
        Object obj7;
        Object obj8;
        Object obj9;
        Object obj10;
        Object obj15;
        boolean flag;
        int i;
        boolean flag1;
        boolean flag2;
        long l1;
        if (s == null)
        {
            throw new IllegalArgumentException("Key must not be null.");
        }
        if (obj == null && abyte0 == null)
        {
            throw new IllegalArgumentException("Either value or flatValue must be non null.");
        }
        if (abyte0 != null && obj != null)
        {
            throw new IllegalArgumentException("Only one of value or flatValue can be non null.");
        }
        Object obj11;
        Object obj12;
        Object obj13;
        Object obj14;
        int j;
        long l2;
        boolean flag3;
        if (abyte0 != null)
        {
            j = flattenedSizeOf(s, abyte0);
        } else
        {
            j = sizeOf(s, obj);
        }
        l2 = Math.min(l, maxTtl);
        obj8 = obj;
        if (abyte0 != null)
        {
            obj8 = inflateBytes(s, abyte0);
        }
        if (obj8 == null) goto _L2; else goto _L1
_L1:
        obj15 = lock;
        obj15;
        JVM INSTR monitorenter ;
        ensureInitialized();
        bytearrayoutputstream = null;
        obj1 = null;
        flag = false;
        flag1 = false;
        flag3 = isFlatStorage();
        if (!flag3) goto _L4; else goto _L3
_L3:
        l1 = 1L;
_L17:
        flag2 = false;
        flag = false;
        i = 0;
        obj12 = null;
        obj13 = null;
        obj11 = null;
        bytearrayoutputstream = null;
        obj14 = null;
        obj = null;
        obj10 = null;
        obj9 = null;
        obj7 = null;
        obj3 = bytearrayoutputstream;
        bytearrayoutputstream1 = ((ByteArrayOutputStream) (obj1));
        obj6 = obj11;
        obj2 = obj12;
        obj4 = obj14;
        bytearrayoutputstream2 = ((ByteArrayOutputStream) (obj1));
        obj5 = obj13;
        if (!isDiskBacked())
        {
            break MISSING_BLOCK_LABEL_275;
        }
        obj3 = bytearrayoutputstream;
        bytearrayoutputstream1 = ((ByteArrayOutputStream) (obj1));
        obj6 = obj11;
        obj2 = obj12;
        obj4 = obj14;
        bytearrayoutputstream2 = ((ByteArrayOutputStream) (obj1));
        obj5 = obj13;
        obj = keyToDataFile(s);
        obj3 = obj;
        bytearrayoutputstream1 = ((ByteArrayOutputStream) (obj1));
        obj6 = obj11;
        obj2 = obj12;
        obj4 = obj;
        bytearrayoutputstream2 = ((ByteArrayOutputStream) (obj1));
        obj5 = obj13;
        obj7 = new FileOutputStream(((File) (obj)));
        bytearrayoutputstream = ((ByteArrayOutputStream) (obj1));
        obj3 = obj;
        bytearrayoutputstream1 = ((ByteArrayOutputStream) (obj1));
        obj6 = obj11;
        obj2 = obj12;
        obj4 = obj;
        bytearrayoutputstream2 = ((ByteArrayOutputStream) (obj1));
        obj5 = obj13;
        if (!isFlatMemoryBacked())
        {
            break MISSING_BLOCK_LABEL_347;
        }
        obj3 = obj;
        bytearrayoutputstream1 = ((ByteArrayOutputStream) (obj1));
        obj6 = obj11;
        obj2 = obj12;
        obj4 = obj;
        bytearrayoutputstream2 = ((ByteArrayOutputStream) (obj1));
        obj5 = obj13;
        bytearrayoutputstream = new ByteArrayOutputStream();
        obj3 = obj;
        bytearrayoutputstream1 = bytearrayoutputstream;
        obj6 = obj11;
        obj2 = obj12;
        obj4 = obj;
        bytearrayoutputstream2 = bytearrayoutputstream;
        obj5 = obj13;
        obj1 = makeDataOutputStream(bytearrayoutputstream, ((FileOutputStream) (obj7)));
        obj3 = obj;
        bytearrayoutputstream1 = bytearrayoutputstream;
        obj6 = obj1;
        obj2 = obj1;
        obj4 = obj;
        bytearrayoutputstream2 = bytearrayoutputstream;
        obj5 = obj1;
        obj7 = new MetaInfo(s, j, expirationTime(System.currentTimeMillis(), l2));
        writeMeta(((DataOutputStream) (obj1)), ((MetaInfo) (obj7)));
        if (abyte0 == null) goto _L6; else goto _L5
_L5:
        ((DataOutputStream) (obj1)).write(abyte0);
_L11:
        flag = true;
        StreamUtil.closeQuietly(((java.io.Closeable) (obj1)));
        obj1 = obj7;
        l = l1;
        obj3 = obj;
_L12:
        if (!flag) goto _L8; else goto _L7
_L7:
        updateFastTrim(((File) (obj3)), ((MetaInfo) (obj1)));
          goto _L8
_L4:
        if (!isMemoryBacked()) goto _L10; else goto _L9
_L9:
        obj = memCacheLock;
        obj;
        JVM INSTR monitorenter ;
        if (isInflatedMemoryBacked())
        {
            memCache.put(s, obj8, l2);
        }
        if (!isFlatMemoryBacked() || !flag)
        {
            break MISSING_BLOCK_LABEL_554;
        }
        flatMemCache.put(s, new FlatData(bytearrayoutputstream.toByteArray(), j), l2);
        obj;
        JVM INSTR monitorexit ;
_L10:
        obj15;
        JVM INSTR monitorexit ;
_L2:
        return obj8;
_L6:
        persistenceMapper.deflateCached(((OutputStream) (obj1)), obj8);
          goto _L11
        obj2;
        obj5 = obj1;
        obj1 = obj7;
_L16:
        obj2 = obj5;
        reInitialize();
        i = ((flag2) ? 1 : 0);
        if (l1 > 0L)
        {
            i = 1;
        }
        StreamUtil.closeQuietly(((java.io.Closeable) (obj5)));
        l = l1 - 1L;
        obj3 = obj;
        flag = flag1;
          goto _L12
        obj4;
        obj1 = obj6;
        obj = obj10;
        bytearrayoutputstream = bytearrayoutputstream1;
_L15:
        obj2 = obj1;
        if (!logger.isLoggable)
        {
            break MISSING_BLOCK_LABEL_681;
        }
        obj2 = obj1;
        log("Failed to write object to on disk cache.", ((Throwable) (obj4)));
        i = ((flag) ? 1 : 0);
        l = l1;
        if (obj3 == null)
        {
            break MISSING_BLOCK_LABEL_832;
        }
        obj2 = obj1;
        ((File) (obj3)).delete();
        obj2 = obj1;
        removeFastTrim(((File) (obj3)));
        obj2 = obj1;
        obj4 = getErrnoValue(((IOException) (obj4)).getCause());
        i = ((flag) ? 1 : 0);
        l = l1;
        if (obj4 == null)
        {
            break MISSING_BLOCK_LABEL_832;
        }
        i = ((flag) ? 1 : 0);
        l = l1;
        obj2 = obj1;
        if (((Integer) (obj4)).intValue() != 28)
        {
            break MISSING_BLOCK_LABEL_832;
        }
        obj2 = obj1;
        i = trimDiskCacheFull();
        obj2 = obj1;
        if (!logger.isLoggable)
        {
            break MISSING_BLOCK_LABEL_816;
        }
        obj2 = obj1;
        log((new StringBuilder()).append("Disk full, trimmed count: ").append(i).toString());
        l = l1 - 1L;
        if (l1 > 0L)
        {
            i = 1;
        } else
        {
            i = ((flag) ? 1 : 0);
        }
        StreamUtil.closeQuietly(((java.io.Closeable) (obj1)));
        flag = flag1;
        obj1 = obj;
          goto _L12
        s;
        obj15;
        JVM INSTR monitorexit ;
        throw s;
        s;
        obj1 = obj2;
_L14:
        StreamUtil.closeQuietly(((java.io.Closeable) (obj1)));
        throw s;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
        s;
        if (true) goto _L14; else goto _L13
_L13:
        obj4;
        obj3 = obj;
        obj = obj7;
          goto _L15
        obj;
        obj = obj4;
        bytearrayoutputstream = bytearrayoutputstream2;
        obj1 = obj9;
          goto _L16
_L8:
        obj1 = bytearrayoutputstream;
        flag1 = flag;
        l1 = l;
        if (i != 0) goto _L17; else goto _L4
    }

    private void reInitialize()
    {
        needsBackgroundInit = true;
        allFiles = null;
        ensureInitialized();
    }

    private MetaInfo readMeta(DataInputStream datainputstream)
        throws IOException
    {
        byte abyte0[] = new byte[datainputstream.readInt()];
        StreamUtil.streamToBytes(datainputstream, abyte0);
        return (MetaInfo)META_MAPPER.fromJson(new String(abyte0, "UTF-8"), com/ebay/nautilus/kernel/cachemanager/CacheManager$MetaInfo);
    }

    private MetaInfo readMetaOnly(FileMeta filemeta)
    {
        MetaInfo metainfo;
        MetaInfo metainfo1;
        Object obj;
        Object obj1;
        obj = null;
        metainfo1 = null;
        obj1 = null;
        metainfo = null;
        DataInputStream datainputstream = new DataInputStream(new BufferedInputStream(new FileInputStream(filemeta.file), 1024));
        metainfo = obj1;
        metainfo1 = readMeta(datainputstream);
        metainfo = metainfo1;
        filemeta.minimalMetaInfo = metainfo1;
        StreamUtil.closeQuietly(datainputstream);
        return metainfo1;
        filemeta;
        filemeta = metainfo1;
_L4:
        StreamUtil.closeQuietly(filemeta);
        return metainfo;
        Exception exception;
        exception;
        filemeta = obj;
_L2:
        StreamUtil.closeQuietly(filemeta);
        throw exception;
        exception;
        filemeta = datainputstream;
        if (true) goto _L2; else goto _L1
_L1:
        filemeta;
        filemeta = datainputstream;
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void removeFastTrim(File file)
    {
        if (fastTrim)
        {
            allFiles.remove(getFileKey(file));
        }
    }

    private int trimDiskCache(List list, long l, boolean flag)
    {
        int i = 0;
        long l2 = System.currentTimeMillis();
        Iterator iterator = list.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            FileMeta filemeta = (FileMeta)iterator.next();
            boolean flag2 = true;
            boolean flag1 = flag2;
            long l1 = l;
            if (!filemeta.isExpired(maxTtl, l2))
            {
                flag1 = flag2;
                l1 = l;
                if (filemeta.exists())
                {
                    flag1 = flag2;
                    l1 = l;
                    if (l > 0L)
                    {
                        MinimalMetaInfo minimalmetainfo = filemeta.minimalMetaInfo;
                        list = minimalmetainfo;
                        if (minimalmetainfo == null)
                        {
                            list = readMetaOnly(filemeta);
                        }
                        flag1 = flag2;
                        l1 = l;
                        if (list != null)
                        {
                            flag1 = flag2;
                            l1 = l;
                            if (!list.isExpired(l2))
                            {
                                if (flag)
                                {
                                    l1 = filemeta.getFileSize();
                                } else
                                {
                                    l1 = ((MinimalMetaInfo) (list)).itemSize;
                                }
                                l -= l1;
                                flag1 = flag2;
                                l1 = l;
                                if (l >= 0L)
                                {
                                    flag1 = false;
                                    l1 = l;
                                }
                            }
                        }
                    }
                }
            }
            l = l1;
            if (flag1)
            {
                filemeta.file.delete();
                removeFastTrim(filemeta.file);
                i++;
                l = l1;
            }
        } while (true);
        return i;
    }

    private int trimDiskCacheFull()
    {
        long l = 0L;
        List list = filesNewestToOldest();
        for (Iterator iterator = list.iterator(); iterator.hasNext();)
        {
            FileMeta filemeta = (FileMeta)iterator.next();
            if (filemeta.exists())
            {
                l += filemeta.getFileSize();
            } else
            {
                removeFastTrim(filemeta.file);
                iterator.remove();
            }
        }

        return trimDiskCache(list, l / 2L, true);
    }

    private void updateFastTrim(File file, MetaInfo metainfo)
    {
        if (fastTrim)
        {
            file = new FileMeta(file, new MinimalMetaInfo(metainfo));
            allFiles.put(getFileKey(((FileMeta) (file)).file), file);
        }
        scheduleDiskTrim();
    }

    private void writeMeta(DataOutputStream dataoutputstream, MetaInfo metainfo)
        throws IOException
    {
        metainfo = META_MAPPER.toJson(metainfo).getBytes();
        dataoutputstream.writeInt(metainfo.length);
        dataoutputstream.write(metainfo);
    }

    public Object TEST_getFlatInMemory(String s)
    {
        return getFromFlatMemoryCache(s);
    }

    public final Object TEST_getInflatedInMemory(String s)
    {
        return getFromInflatedMemoryCache(s);
    }

    public File TEST_getInstanceDir()
    {
        return instanceDir;
    }

    public void clear()
    {
        Object obj = lock;
        obj;
        JVM INSTR monitorenter ;
        ensureInitialized();
        if (isMemoryBacked())
        {
            synchronized (memCacheLock)
            {
                if (isInflatedMemoryBacked())
                {
                    memCache.clear();
                }
                if (isFlatMemoryBacked())
                {
                    flatMemCache.clear();
                }
            }
        }
        if (isDiskBacked())
        {
            FileUtil.recursiveDelete(instanceDir, false);
            reInitialize();
        }
        obj;
        JVM INSTR monitorexit ;
        return;
        exception1;
        obj1;
        JVM INSTR monitorexit ;
        throw exception1;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public int flattenedSizeOf(String s, byte abyte0[])
    {
        return 1;
    }

    public Object get(String s)
    {
        Object obj11 = lock;
        obj11;
        JVM INSTR monitorenter ;
        ensureInitialized();
        Object obj2;
        Object obj4;
        Object obj6;
        Object obj7;
        Object obj8;
        Object obj9;
        Object obj10;
        File file;
        obj6 = null;
        obj7 = null;
        obj8 = null;
        obj9 = null;
        obj2 = null;
        file = null;
        obj10 = null;
        obj4 = null;
        Object obj3;
        long l;
        l = System.currentTimeMillis();
        obj3 = getFromInflatedMemoryCache(s);
        Object obj;
        Object obj1;
        obj = obj2;
        obj1 = obj3;
        if (obj3 != null)
        {
            break MISSING_BLOCK_LABEL_90;
        }
        Object obj5 = getValueWithMetaFromFlatMemoryCache(s);
        obj = obj2;
        obj1 = obj3;
        if (obj5 == null)
        {
            break MISSING_BLOCK_LABEL_90;
        }
        obj1 = ((ValueWithMeta) (obj5)).value;
        obj = ((ValueWithMeta) (obj5)).metaInfo;
        obj2 = file;
        obj3 = obj;
        obj5 = obj1;
        if (obj1 != null) goto _L2; else goto _L1
_L1:
        obj2 = file;
        obj3 = obj;
        obj5 = obj1;
        if (!isDiskBacked()) goto _L2; else goto _L3
_L3:
        int i;
        boolean flag;
        flag = false;
        i = 0;
        file = keyToDataFile(s);
        obj3 = obj7;
        boolean flag1 = isExpired(file, l);
        if (!flag1) goto _L5; else goto _L4
_L4:
        i = 1;
        obj2 = obj9;
_L9:
        StreamUtil.closeQuietly(((java.io.Closeable) (obj2)));
_L10:
        obj2 = obj4;
        obj3 = obj;
        obj5 = obj1;
        if (i == 0) goto _L2; else goto _L6
_L6:
        file.delete();
        removeFastTrim(file);
        obj5 = obj1;
        obj3 = obj;
        obj2 = obj4;
_L2:
        if (!isMemoryBacked() || obj5 == null || obj3 == null) goto _L8; else goto _L7
_L7:
        obj = memCacheLock;
        obj;
        JVM INSTR monitorenter ;
        l = ((MetaInfo) (obj3)).remainingTtl(l);
        if (isInflatedMemoryBacked())
        {
            memCache.put(s, obj5, l);
        }
        if (obj2 == null)
        {
            break MISSING_BLOCK_LABEL_294;
        }
        i = sizeOf(s, obj5);
        flatMemCache.put(s, new FlatData(((ByteArrayOutputStream) (obj2)).toByteArray(), i), l);
        obj;
        JVM INSTR monitorexit ;
_L8:
        obj11;
        JVM INSTR monitorexit ;
        return obj5;
_L5:
        obj3 = obj7;
        obj5 = new FileInputStream(file);
        obj2 = obj5;
        obj4 = obj10;
        obj3 = obj7;
        if (!isFlatMemoryBacked())
        {
            break MISSING_BLOCK_LABEL_362;
        }
        obj3 = obj7;
        obj4 = new ByteArrayOutputStream();
        obj2 = new CacheStream(((InputStream) (obj5)), ((OutputStream) (obj4)));
        obj3 = obj7;
        obj2 = new DataInputStream(new BufferedInputStream(((InputStream) (obj2)), 4096));
        obj3 = obj;
        if (!isFastTrimMetaExpired(file, l))
        {
            break MISSING_BLOCK_LABEL_407;
        }
        i = 1;
          goto _L9
        obj3 = obj;
        obj = readMeta(((DataInputStream) (obj2)));
        obj3 = obj;
        if (!((MetaInfo) (obj)).isExpired(l))
        {
            break MISSING_BLOCK_LABEL_435;
        }
        i = 1;
          goto _L9
        obj3 = obj;
        addFastTrim(file, ((MetaInfo) (obj)));
        obj3 = obj;
        obj5 = persistenceMapper.inflateCached(((InputStream) (obj2)), clz);
        obj1 = obj5;
          goto _L9
        obj2;
        obj4 = obj6;
_L13:
        obj5 = null;
        obj3 = obj4;
        if (!logger.isLoggable)
        {
            break MISSING_BLOCK_LABEL_506;
        }
        obj3 = obj4;
        log("Failed to read object from on disk cache.", ((Throwable) (obj2)));
        StreamUtil.closeQuietly(((java.io.Closeable) (obj4)));
        obj4 = obj5;
        i = ((flag) ? 1 : 0);
          goto _L10
        s;
        obj11;
        JVM INSTR monitorexit ;
        throw s;
        s;
_L12:
        StreamUtil.closeQuietly(((java.io.Closeable) (obj3)));
        throw s;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
        s;
        obj3 = obj8;
        continue; /* Loop/switch isn't completed */
        s;
        obj3 = obj2;
        if (true) goto _L12; else goto _L11
_L11:
        obj2;
        obj4 = obj6;
          goto _L13
        IOException ioexception;
        ioexception;
        obj4 = obj2;
        obj2 = ioexception;
        ioexception = ((IOException) (obj3));
          goto _L13
    }

    protected float getCacheMemorySizeFactor(Context context)
    {
        return 1.0F;
    }

    protected long getDiskTrimInterval()
    {
        long l = (long)(Math.random() * (double)DISK_TRIM_JITTER);
        return DISK_TRIM_INTERVAL + l;
    }

    protected Object getFromFlatMemoryCache(String s)
    {
        Object obj;
        obj = null;
        if (!isFlatMemoryBacked())
        {
            break MISSING_BLOCK_LABEL_79;
        }
        Object obj2 = memCacheLock;
        obj2;
        JVM INSTR monitorenter ;
        ValueWithMeta valuewithmeta = getValueWithMetaFromFlatMemoryCache(s);
        if (valuewithmeta == null)
        {
            break MISSING_BLOCK_LABEL_68;
        }
        Object obj1 = valuewithmeta.value;
        obj = obj1;
        if (!isInflatedMemoryBacked())
        {
            break MISSING_BLOCK_LABEL_68;
        }
        memCache.put(s, obj1, valuewithmeta.metaInfo.remainingTtl(System.currentTimeMillis()));
        obj = obj1;
        obj2;
        JVM INSTR monitorexit ;
        return obj;
        s;
        obj2;
        JVM INSTR monitorexit ;
        throw s;
        return null;
    }

    protected Object getFromInflatedMemoryCache(String s)
    {
        if (isInflatedMemoryBacked())
        {
            synchronized (memCacheLock)
            {
                s = ((String) (memCache.get(s)));
            }
            return s;
        } else
        {
            return null;
        }
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    public Object getInMemory(String s)
    {
        if (!isMemoryBacked())
        {
            break MISSING_BLOCK_LABEL_45;
        }
        Object obj2 = memCacheLock;
        obj2;
        JVM INSTR monitorenter ;
        Object obj1 = getFromInflatedMemoryCache(s);
        Object obj;
        obj = obj1;
        if (obj1 != null)
        {
            break MISSING_BLOCK_LABEL_34;
        }
        obj = getFromFlatMemoryCache(s);
        obj2;
        JVM INSTR monitorexit ;
        return obj;
        s;
        obj2;
        JVM INSTR monitorexit ;
        throw s;
        return null;
    }

    protected String getTopLevelDirName()
    {
        return "cacheManager";
    }

    public boolean isDiskBacked()
    {
        return instanceDir != null;
    }

    public boolean isFlatMemoryBacked()
    {
        return flatMemCache != null;
    }

    public boolean isFlatStorage()
    {
        return isFlatMemoryBacked() || isDiskBacked();
    }

    public boolean isInflatedMemoryBacked()
    {
        return memCache != null;
    }

    public boolean isMemoryBacked()
    {
        return isInflatedMemoryBacked() || isFlatMemoryBacked();
    }

    protected void log(String s)
    {
        logger.log(buildLogMessage(s));
    }

    protected void log(String s, Throwable throwable)
    {
        logger.log(buildLogMessage(s), throwable);
    }

    protected void logAsWarning(String s)
    {
        logger.logAsWarning(buildLogMessage(s));
    }

    public Object put(String s, Object obj)
    {
        return put(s, obj, maxTtl);
    }

    public Object put(String s, Object obj, long l)
    {
        return putInternal(s, obj, null, l);
    }

    public Object putFlattenedBytes(String s, byte abyte0[])
    {
        return putFlattenedBytes(s, abyte0, maxTtl);
    }

    public Object putFlattenedBytes(String s, byte abyte0[], long l)
    {
        return putInternal(s, null, abyte0, l);
    }

    public Object remove(String s)
    {
        Object obj;
        Object obj1;
        if (s == null)
        {
            throw new IllegalArgumentException("key must not be null");
        }
        obj = null;
        obj1 = null;
        Object obj2 = lock;
        obj2;
        JVM INSTR monitorenter ;
        ensureInitialized();
        if (!isMemoryBacked()) goto _L2; else goto _L1
_L1:
        Object obj3 = memCacheLock;
        obj3;
        JVM INSTR monitorenter ;
        obj = obj1;
        if (isInflatedMemoryBacked())
        {
            obj = memCache.remove(s);
        }
        if (isFlatMemoryBacked())
        {
            flatMemCache.remove(s);
        }
        obj3;
        JVM INSTR monitorexit ;
_L2:
        if (isDiskBacked())
        {
            s = keyToDataFile(s);
            s.delete();
            removeFastTrim(s);
        }
        obj2;
        JVM INSTR monitorexit ;
        return obj;
        s;
        obj3;
        JVM INSTR monitorexit ;
        throw s;
        s;
        obj2;
        JVM INSTR monitorexit ;
        throw s;
    }

    protected void scheduleDiskTrim()
    {
        if (isDiskBacked() && diskTrimTask == null && !preventTrimTask)
        {
            diskTrimTask = new PeriodicDiskTrimTask(diskLimit);
            diskTrimTask.executeDelayedTask(getDiskTrimInterval(), new Void[0]);
        }
    }

    protected void sharedInit(File file)
    {
        cacheInitState.sharedInit(file);
    }

    public int sizeOf(String s, Object obj)
    {
        return 1;
    }

    public final void trim()
    {
        Object obj = lock;
        obj;
        JVM INSTR monitorenter ;
        ensureInitialized();
        if (isMemoryBacked())
        {
            synchronized (memCacheLock)
            {
                if (isInflatedMemoryBacked())
                {
                    memCache.trimExpired();
                }
                if (isFlatMemoryBacked())
                {
                    flatMemCache.trimExpired();
                }
            }
        }
        if (isDiskBacked())
        {
            trimDiskCache(filesNewestToOldest(), diskLimit, false);
        }
        obj;
        JVM INSTR monitorexit ;
        return;
        exception1;
        obj1;
        JVM INSTR monitorexit ;
        throw exception1;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    static 
    {
        DISK_TRIM_INTERVAL = TimeUnit.MINUTES.toMillis(5L);
        DISK_TRIM_JITTER = TimeUnit.SECONDS.toMillis(90L);
    }



/*
    static PeriodicDiskTrimTask access$102(CacheManager cachemanager, PeriodicDiskTrimTask periodicdisktrimtask)
    {
        cachemanager.diskTrimTask = periodicdisktrimtask;
        return periodicdisktrimtask;
    }

*/


}

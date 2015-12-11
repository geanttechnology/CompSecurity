// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.net;

import android.app.Application;
import android.util.Log;
import com.amazon.mShop.debug.DebugSettings;
import com.amazon.mShop.platform.Platform;
import com.amazon.mShop.util.Util;
import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.amazon.mShop.net:
//            SimpleLruMap, MShopHttpHeaderHelper, MShopDiskCache

public class MShopDiskCachePolicy
{
    public static class FileLruInf
    {

        public static final Comparator COMPARATOR = new Comparator() {

            public int compare(FileLruInf filelruinf, FileLruInf filelruinf1)
            {
                if (filelruinf.mLastModifiedTime == filelruinf1.mLastModifiedTime)
                {
                    return 0;
                }
                return filelruinf.mLastModifiedTime <= filelruinf1.mLastModifiedTime ? -1 : 1;
            }

            public volatile int compare(Object obj, Object obj1)
            {
                return compare((FileLruInf)obj, (FileLruInf)obj1);
            }

        };
        public String mCanonicalPath;
        public File mFile;
        public String mFileName;
        public String mInfFile;
        public long mLastModifiedTime;


        public FileLruInf(File file, String s)
        {
            mFileName = file.getName();
            mFile = file;
            mLastModifiedTime = file.lastModified();
            mCanonicalPath = s;
            mInfFile = (new StringBuilder()).append(mCanonicalPath).append(".inf").toString();
        }
    }

    public static final class ResidencePriority extends Enum
    {

        private static final ResidencePriority $VALUES[];
        public static final ResidencePriority RESIDENCE_PRIORITY_0;
        public static final ResidencePriority RESIDENCE_PRIORITY_1;

        public static ResidencePriority valueOf(String s)
        {
            return (ResidencePriority)Enum.valueOf(com/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority, s);
        }

        public static ResidencePriority[] values()
        {
            return (ResidencePriority[])$VALUES.clone();
        }

        static 
        {
            RESIDENCE_PRIORITY_0 = new ResidencePriority("RESIDENCE_PRIORITY_0", 0);
            RESIDENCE_PRIORITY_1 = new ResidencePriority("RESIDENCE_PRIORITY_1", 1);
            $VALUES = (new ResidencePriority[] {
                RESIDENCE_PRIORITY_0, RESIDENCE_PRIORITY_1
            });
        }

        private ResidencePriority(String s, int i)
        {
            super(s, i);
        }
    }


    private static final String CACHE_BASE_DIR = prepareCacheDir();
    private static final SimpleLruMap.DataProcessor CACHE_FILE_PROCESSOR;
    private static final boolean DEBUG = DebugSettings.isDebugEnabled();
    private static final String DIRNAME_RESIDENCE_PRIORITY_0;
    private static final String DIRNAME_RESIDENCE_PRIORITY_1;
    private static final File DIR_RESIDENCE_PRIORITY_0;
    private static final File DIR_RESIDENCE_PRIORITY_1;
    private static boolean sCachedFilesHaveBeenPopulated = false;
    private static final SimpleLruMap sLruPriority0;
    private static final SimpleLruMap sLruPriority1;

    public MShopDiskCachePolicy()
    {
    }

    public static boolean addFileJournal(String s, FileLruInf filelruinf, ResidencePriority residencepriority)
    {
        if (residencepriority.equals(ResidencePriority.RESIDENCE_PRIORITY_0))
        {
            return sLruPriority0.addItem(s, filelruinf);
        }
        if (residencepriority.equals(ResidencePriority.RESIDENCE_PRIORITY_1))
        {
            return sLruPriority1.addItem(s, filelruinf);
        } else
        {
            return false;
        }
    }

    public static boolean addFileJournal(String s, File file, ResidencePriority residencepriority)
    {
        file = new FileLruInf(file, (new StringBuilder()).append(getDirNameForResidence(residencepriority)).append(file.getName()).toString());
        if (residencepriority.equals(ResidencePriority.RESIDENCE_PRIORITY_0))
        {
            return sLruPriority0.addItem(s, file);
        }
        if (residencepriority.equals(ResidencePriority.RESIDENCE_PRIORITY_1))
        {
            return sLruPriority1.addItem(s, file);
        } else
        {
            return false;
        }
    }

    static long calculateAge(Map map)
    {
        long l1 = MShopHttpHeaderHelper.parseHeaderDate(map, "date");
        long l4 = MShopHttpHeaderHelper.parseLong(map, "age");
        long l2 = MShopHttpHeaderHelper.parseLong(map, "mshop-cache-sent-time");
        long l3 = MShopHttpHeaderHelper.parseLong(map, "mshop-cache-received-time");
        long l = 0L;
        if (l1 != -1L)
        {
            l = Math.max(0L, l3 - l1);
        }
        l1 = l;
        if (l4 != -1L)
        {
            l1 = Math.max(l, TimeUnit.SECONDS.toMillis(l4));
        }
        return l1 + (l3 - l2) + (System.currentTimeMillis() - l3);
    }

    static long calculateFreshnessLife(Map map)
    {
        long l1 = -1L;
        String s = MShopHttpHeaderHelper.parseHeaderDirectiveValue(map, "cache-control", "max-age");
        if (!Util.isEmpty(s))
        {
            l1 = Long.parseLong(s);
        }
        long l6 = MShopHttpHeaderHelper.parseHeaderDate(map, "expires");
        long l = MShopHttpHeaderHelper.parseHeaderDate(map, "date");
        long l7 = MShopHttpHeaderHelper.parseHeaderDate(map, "last-modified");
        long l4 = MShopHttpHeaderHelper.parseLong(map, "mshop-cache-sent-time");
        long l5 = MShopHttpHeaderHelper.parseLong(map, "mshop-cache-received-time");
        if (l1 != -1L)
        {
            return TimeUnit.SECONDS.toMillis(l1);
        }
        if (l6 != -1L)
        {
            long l2 = l5;
            if (l != -1L)
            {
                l2 = l;
            }
            if (l6 > l2)
            {
                return l6 - l2;
            }
        } else
        if (l7 != -1L)
        {
            long l3 = l4;
            if (l != -1L)
            {
                l3 = l;
            }
            if (l3 > l7)
            {
                return (l3 - l7) / 10L;
            }
        }
        return 0L;
    }

    public static File getDirForResidence(ResidencePriority residencepriority)
    {
        if (ResidencePriority.RESIDENCE_PRIORITY_0.equals(residencepriority))
        {
            return DIR_RESIDENCE_PRIORITY_0;
        }
        if (ResidencePriority.RESIDENCE_PRIORITY_1.equals(residencepriority))
        {
            return DIR_RESIDENCE_PRIORITY_1;
        } else
        {
            return null;
        }
    }

    public static String getDirNameForResidence(ResidencePriority residencepriority)
    {
        if (ResidencePriority.RESIDENCE_PRIORITY_0.equals(residencepriority))
        {
            return DIRNAME_RESIDENCE_PRIORITY_0;
        }
        if (ResidencePriority.RESIDENCE_PRIORITY_1.equals(residencepriority))
        {
            return DIRNAME_RESIDENCE_PRIORITY_1;
        } else
        {
            return null;
        }
    }

    public static FileLruInf getFileJournal(String s, ResidencePriority residencepriority)
    {
        if (residencepriority.equals(ResidencePriority.RESIDENCE_PRIORITY_0))
        {
            return (FileLruInf)sLruPriority0.getItem(s);
        }
        if (residencepriority.equals(ResidencePriority.RESIDENCE_PRIORITY_1))
        {
            return (FileLruInf)sLruPriority1.getItem(s);
        } else
        {
            return null;
        }
    }

    public static boolean isCacheDirReady()
    {
        if (CACHE_BASE_DIR != null)
        {
            return true;
        }
        if (DEBUG)
        {
            Log.d("MShopHttpCachePolicy", "Cache dir is not ready!");
        }
        return false;
    }

    static boolean isExpired(Map map)
    {
        return calculateAge(map) >= calculateFreshnessLife(map);
    }

    private static long populateCachedFiles(ResidencePriority residencepriority)
    {
        Object obj;
        long l2;
        l2 = 0L;
        obj = getDirForResidence(residencepriority);
        if (((File) (obj)).exists()) goto _L2; else goto _L1
_L1:
        return l2;
_L2:
        if (((File) (obj)).isDirectory())
        {
            break; /* Loop/switch isn't completed */
        }
        if (DEBUG)
        {
            Log.d("MShopHttpCachePolicy", "Failed to get cache directory!");
            return 0L;
        }
        if (true) goto _L1; else goto _L3
_L3:
        long l;
        long l1;
        l1 = 0L;
        l = l1;
        String s = (new StringBuilder()).append(((File) (obj)).getCanonicalPath()).append("/").toString();
        l = l1;
        String as[] = ((File) (obj)).list();
        l = l1;
        obj = new ArrayList(as.length);
        int i = 0;
_L7:
        l = l1;
        if (i >= as.length)
        {
            break MISSING_BLOCK_LABEL_208;
        }
        String s1;
        s1 = as[i];
        l = l1;
        String s2 = (new StringBuilder()).append(s).append(s1).toString();
        l = l1;
        File file = new File(s2);
        l = l1;
        l1 += file.length();
        l = l1;
        if (s1.endsWith(".inf"))
        {
            break MISSING_BLOCK_LABEL_321;
        }
        l = l1;
        FileLruInf filelruinf;
        try
        {
            ((List) (obj)).add(new FileLruInf(file, s2));
            break MISSING_BLOCK_LABEL_321;
        }
        // Misplaced declaration of an exception variable
        catch (ResidencePriority residencepriority)
        {
            l2 = l;
            if (DEBUG)
            {
                Log.d("MShopHttpCachePolicy", residencepriority.toString());
                return l;
            }
        }
          goto _L1
        l2 = l1;
        l = l1;
        if (((List) (obj)).size() <= 0) goto _L1; else goto _L4
_L4:
        l = l1;
        Collections.sort(((List) (obj)), FileLruInf.COMPARATOR);
        i = 0;
_L6:
        l2 = l1;
        l = l1;
        if (i >= ((List) (obj)).size()) goto _L1; else goto _L5
_L5:
        l = l1;
        filelruinf = (FileLruInf)((List) (obj)).get(i);
        l = l1;
        addFileJournal(filelruinf.mFileName, filelruinf, residencepriority);
        i++;
          goto _L6
        i++;
          goto _L7
    }

    public static void populateCachedFiles()
    {
        com/amazon/mShop/net/MShopDiskCachePolicy;
        JVM INSTR monitorenter ;
        boolean flag = sCachedFilesHaveBeenPopulated;
        if (!flag) goto _L2; else goto _L1
_L1:
        com/amazon/mShop/net/MShopDiskCachePolicy;
        JVM INSTR monitorexit ;
        return;
_L2:
        populateCachedFiles(ResidencePriority.RESIDENCE_PRIORITY_1);
        populateCachedFiles(ResidencePriority.RESIDENCE_PRIORITY_0);
        sCachedFilesHaveBeenPopulated = true;
        if (true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    private static String prepareCacheDir()
    {
        Object obj = new File(((Application)com.amazon.mShop.platform.Platform.Factory.getInstance().getApplicationContext()).getCacheDir(), "mShopCache");
        if (((File) (obj)).exists() || ((File) (obj)).mkdir()) goto _L2; else goto _L1
_L1:
        if (DEBUG)
        {
            Log.d("MShopHttpCachePolicy", "Failed to create cache dir!");
        }
_L4:
        return null;
_L2:
        obj = (new StringBuilder()).append(((File) (obj)).getCanonicalPath()).append("/").toString();
        return ((String) (obj));
        IOException ioexception;
        ioexception;
        if (DEBUG)
        {
            Log.d("MShopHttpCachePolicy", ioexception.toString());
            return null;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private static File prepareDirForResidence(ResidencePriority residencepriority)
    {
        residencepriority = new File((new StringBuilder()).append(prepareCacheDir()).append(residencepriority.toString()).toString());
        if (!residencepriority.exists())
        {
            residencepriority.mkdir();
        }
        return residencepriority;
    }

    private static String prepareDirNameForResidence(ResidencePriority residencepriority)
    {
        Object obj;
        obj = new File((new StringBuilder()).append(prepareCacheDir()).append(residencepriority.toString()).toString());
        if (!((File) (obj)).exists())
        {
            ((File) (obj)).mkdir();
        }
        residencepriority = null;
        obj = (new StringBuilder()).append(((File) (obj)).getCanonicalPath()).append("/").toString();
        residencepriority = ((ResidencePriority) (obj));
_L2:
        return residencepriority;
        IOException ioexception;
        ioexception;
        if (DEBUG)
        {
            Log.d("MShopHttpCachePolicy", ioexception.toString());
            return null;
        }
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static String uriStrToKey(String s)
    {
        Object obj = null;
        try
        {
            s = MShopHttpHeaderHelper.convertBytesToHexString(MessageDigest.getInstance("MD5").digest(s.getBytes("UTF-8")));
        }
        catch (Exception exception)
        {
            s = obj;
            if (DEBUG)
            {
                Log.d("MShopHttpCachePolicy", exception.toString());
                return null;
            }
        }
        return s;
    }

    static 
    {
        CACHE_FILE_PROCESSOR = new SimpleLruMap.DataProcessor() {

            public int evict(FileLruInf filelruinf)
            {
                return MShopDiskCache.deleteCachedFile(filelruinf);
            }

            public volatile int evict(Object obj)
            {
                return evict((FileLruInf)obj);
            }

            public int getSize(FileLruInf filelruinf)
            {
                return MShopDiskCache.getFileUsedSize(filelruinf);
            }

            public volatile int getSize(Object obj)
            {
                return getSize((FileLruInf)obj);
            }

            public void setAccessTime(FileLruInf filelruinf, long l)
            {
                filelruinf.mFile.setLastModified(l);
                filelruinf.mLastModifiedTime = l;
            }

            public volatile void setAccessTime(Object obj, long l)
            {
                setAccessTime((FileLruInf)obj, l);
            }

        };
        sLruPriority0 = new SimpleLruMap(0x100000, 0x20000, CACHE_FILE_PROCESSOR);
        sLruPriority1 = new SimpleLruMap(8, CACHE_FILE_PROCESSOR);
        DIR_RESIDENCE_PRIORITY_0 = prepareDirForResidence(ResidencePriority.RESIDENCE_PRIORITY_0);
        DIR_RESIDENCE_PRIORITY_1 = prepareDirForResidence(ResidencePriority.RESIDENCE_PRIORITY_1);
        DIRNAME_RESIDENCE_PRIORITY_0 = prepareDirNameForResidence(ResidencePriority.RESIDENCE_PRIORITY_0);
        DIRNAME_RESIDENCE_PRIORITY_1 = prepareDirNameForResidence(ResidencePriority.RESIDENCE_PRIORITY_1);
    }
}

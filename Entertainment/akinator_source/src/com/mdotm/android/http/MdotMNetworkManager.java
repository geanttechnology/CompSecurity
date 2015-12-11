// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mdotm.android.http;

import android.content.Context;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.os.StatFs;
import com.mdotm.android.database.MdotMCacheHandler;
import com.mdotm.android.listener.MdotMNetworkListener;
import com.mdotm.android.model.MdotMAdRequest;
import com.mdotm.android.utils.MdotMLogger;
import com.mdotm.android.utils.MdotMRequestBuilder;
import java.io.File;
import java.net.HttpURLConnection;
import java.util.Arrays;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MdotMNetworkManager
{

    public static String MdotM_Banner_Temp = "BannerTemp";
    public static String MdotM_CACHE_FOLDER = "MdotMTempCache";
    public static String MdotM_Interstitial_Temp = "InterstitialTemp";
    public static String MdotM_PermanentCaching = "PermanentCache";
    private static int cacheLocation;
    private static boolean enableCaching = false;
    public static int gifImageResource = 4;
    public static int htmlResource = 3;
    public static int imageResource = 1;
    private static boolean isSDCardExist = false;
    private static MdotMNetworkManager mManager = null;
    public static int videoResource = 2;
    private final int CORE_POOL_SIZE = 1;
    private final int HTTP_RESPONSE_OK = 200;
    private final int HTTP_RESPONSE_OK1 = 201;
    private final int KEEP_ALIVE_TIME_IN_SEC = 30;
    private final int MAX_POOL_SIZE = 1;
    private int adCacheSizeInternal;
    private int adCacheSizeSDCard;
    private ThreadPoolExecutor executor;
    private boolean isCompanion;
    private Context mContext;
    private Handler mHandler;
    private long minMemorySize;
    MdotMNetworkListener networkListener;
    private int temporaryCacheSize;
    HttpURLConnection urlConnection;
    private BlockingQueue worksQueue;

    private MdotMNetworkManager(Context context, Handler handler)
    {
        temporaryCacheSize = 10;
        minMemorySize = 0x13f1407L;
        adCacheSizeSDCard = 0x7ed147;
        adCacheSizeInternal = 0x4f83e7;
        worksQueue = new ArrayBlockingQueue(1);
        isCompanion = false;
        urlConnection = null;
        mHandler = handler;
        mContext = context;
        setThreadPool();
    }

    private boolean checkAvailableMemory(int i)
    {
        long l;
        if (i == 2)
        {
            l = getAvailableInternalMemorySize();
        } else
        {
            l = getAvailableExternalMemorySize();
        }
        return l > minMemorySize;
    }

    private void checkCacheStatus(MdotMAdRequest mdotmadrequest)
    {
        isSDCardExist = checkSDCardState();
        if (!enableCaching) goto _L2; else goto _L1
_L1:
        Object obj;
        cacheLocation = MdotMCacheHandler.getInstance(mContext).getCacheLocation();
        MdotMLogger.i(this, (new StringBuilder("cache location is ")).append(cacheLocation).toString());
        Object obj1 = null;
        obj = obj1;
        if (cacheLocation != 0)
        {
            manageCacheSize();
            boolean flag;
            if (cacheLocation == 2)
            {
                obj = (new StringBuilder(String.valueOf(mContext.getCacheDir().getAbsolutePath()))).append("/").append(MdotM_CACHE_FOLDER).append("/").append(MdotM_PermanentCaching).toString();
                verifyCache(((String) (obj)));
            } else
            if (isSDCardExist)
            {
                obj = (new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().getAbsolutePath()))).append("/").append(MdotM_CACHE_FOLDER).append("/").append(MdotM_PermanentCaching).toString();
                verifyCache(((String) (obj)));
            } else
            {
                MdotMLogger.i(this, (new StringBuilder("sd card exist is ")).append(isSDCardExist).append(" clearing tables").toString());
                MdotMCacheHandler.getInstance(mContext).clearAllTable(mContext);
                cacheLocation = 0;
                obj = obj1;
            }
        }
        if (cacheLocation == 0) goto _L4; else goto _L3
_L3:
        if (cacheLocation != 1) goto _L6; else goto _L5
_L5:
        flag = checkAvailableMemory(cacheLocation);
        MdotMLogger.i(this, (new StringBuilder("location is sd card calculating available memory is available ")).append(flag).toString());
        if (flag) goto _L8; else goto _L7
_L7:
        obj = new File(((String) (obj)));
        if (((File) (obj)).exists()) goto _L10; else goto _L9
_L9:
        MdotMLogger.i(this, "Cache folder doesn't exist on sd card");
        MdotMCacheHandler.getInstance(mContext).clearAllTable(mContext);
        if (!checkAvailableMemory(cacheLocation))
        {
            cacheLocation = 2;
            if (!checkAvailableMemory(cacheLocation))
            {
                cacheLocation = 0;
            }
        }
_L8:
        if (cacheLocation == 0) goto _L12; else goto _L11
_L11:
        boolean flag1;
        if (cacheLocation == 2)
        {
            mdotmadrequest = new File((new StringBuilder(String.valueOf(mContext.getCacheDir().getAbsolutePath()))).append("/").append(MdotM_CACHE_FOLDER).append("/").append(MdotM_PermanentCaching).toString());
        } else
        {
            mdotmadrequest = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().getAbsolutePath()))).append("/").append(MdotM_CACHE_FOLDER).append("/").append(MdotM_PermanentCaching).toString());
        }
        obj = mdotmadrequest;
        if (!mdotmadrequest.mkdirs())
        {
            if (!mdotmadrequest.exists())
            {
                obj = mdotmadrequest;
                if (cacheLocation == 1)
                {
                    cacheLocation = 2;
                    obj = new File((new StringBuilder(String.valueOf(mContext.getCacheDir().getAbsolutePath()))).append("/").append(MdotM_CACHE_FOLDER).append("/").append(MdotM_PermanentCaching).toString());
                    MdotMLogger.i(this, "unable to create folder on sd card so creating on internal memory");
                    ((File) (obj)).mkdirs();
                }
            } else
            {
                MdotMLogger.i(this, "File created ");
                obj = mdotmadrequest;
            }
        }
        if (!((File) (obj)).exists()) goto _L14; else goto _L13
_L13:
        if (cacheLocation != 2) goto _L16; else goto _L15
_L15:
        MdotMCacheHandler.getInstance(mContext).insertCacheLocation(2);
_L14:
        MdotMLogger.i(this, (new StringBuilder("enabled cache location is ")).append(cacheLocation).append(" file path ").append(((File) (obj)).getAbsolutePath()).toString());
        return;
_L10:
        clearCahe(((File) (obj)).listFiles());
        MdotMCacheHandler.getInstance(mContext).clearAllTable(mContext);
        if (!checkAvailableMemory(cacheLocation))
        {
            cacheLocation = 2;
            if (!checkAvailableMemory(cacheLocation))
            {
                cacheLocation = 0;
            }
        }
        continue; /* Loop/switch isn't completed */
_L6:
        if (cacheLocation == 2)
        {
            flag1 = checkAvailableMemory(cacheLocation);
            MdotMLogger.i(this, (new StringBuilder("location is internal calculating available memory is available ")).append(flag1).toString());
            if (!flag1)
            {
                obj = new File(((String) (obj)));
                if (!((File) (obj)).exists())
                {
                    MdotMLogger.i(this, "Cache folder doesn't exist on sd card");
                    MdotMCacheHandler.getInstance(mContext).clearAllTable(mContext);
                    if (!checkAvailableMemory(cacheLocation))
                    {
                        cacheLocation = 0;
                    }
                } else
                {
                    clearCahe(((File) (obj)).listFiles());
                    MdotMCacheHandler.getInstance(mContext).clearAllTable(mContext);
                    if (!checkAvailableMemory(cacheLocation))
                    {
                        cacheLocation = 0;
                    }
                }
            }
        }
        continue; /* Loop/switch isn't completed */
_L4:
        MdotMLogger.i(this, "Cache is not there initializing the cache");
        if (isSDCardExist)
        {
            MdotMLogger.i(this, (new StringBuilder("sd card exist is ")).append(isSDCardExist).toString());
            flag1 = checkAvailableMemory(1);
            MdotMLogger.i(this, (new StringBuilder("location is sd card calculating available memory is available ")).append(flag1).toString());
            if (flag1)
            {
                cacheLocation = 1;
            } else
            {
                flag1 = checkAvailableMemory(2);
                MdotMLogger.i(this, (new StringBuilder("memory is not available on sd card checking on internal memory. is available ")).append(flag1).toString());
                if (flag1)
                {
                    cacheLocation = 2;
                } else
                {
                    cacheLocation = 0;
                }
            }
        } else
        {
            flag1 = checkAvailableMemory(2);
            MdotMLogger.i(this, (new StringBuilder(" sd card not there checking on internal memory. is available ")).append(flag1).toString());
            if (flag1)
            {
                cacheLocation = 2;
            } else
            {
                cacheLocation = 0;
            }
        }
        continue; /* Loop/switch isn't completed */
_L16:
        if (cacheLocation == 1)
        {
            MdotMCacheHandler.getInstance(mContext).insertCacheLocation(1);
        }
        if (true) goto _L14; else goto _L12
_L12:
        createTemporaryCache(mdotmadrequest);
        mdotmadrequest.setEnableCaching(false);
        return;
_L2:
        createTemporaryCache(mdotmadrequest);
        return;
        if (true) goto _L8; else goto _L17
_L17:
    }

    private boolean checkSDCardState()
    {
        String s = Environment.getExternalStorageState();
        if ("mounted".equals(s))
        {
            boolean flag = checkWriteExternalPermission();
            if (flag)
            {
                MdotMLogger.i(this, "SD card exist and writable");
                return flag;
            } else
            {
                MdotMLogger.i(this, "SD card exist and not permission");
                return flag;
            }
        }
        if ("mounted_ro".equals(s))
        {
            MdotMLogger.i(this, "SD card exist but not writable");
            return false;
        } else
        {
            MdotMLogger.i(this, "SD card not exist");
            return false;
        }
    }

    private boolean checkWriteExternalPermission()
    {
        return mContext.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0;
    }

    private void clearCahe(File afile[])
    {
        MdotMLogger.i(this, "Clearing cached file");
        if (afile == null) goto _L2; else goto _L1
_L1:
        int i;
        int j;
        j = afile.length;
        i = 0;
_L5:
        if (i < j) goto _L3; else goto _L2
_L2:
        return;
_L3:
        File file = afile[i];
        if (file.isDirectory())
        {
            clearCahe(file.listFiles());
            file.delete();
        } else
        {
            file.delete();
        }
        i++;
        if (true) goto _L5; else goto _L4
_L4:
    }

    private void createTemporaryCache(MdotMAdRequest mdotmadrequest)
    {
        Object obj;
        if (isSDCardExist)
        {
            mdotmadrequest = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().getAbsolutePath()))).append("/").append(MdotM_CACHE_FOLDER).append("/").append(MdotM_Interstitial_Temp).toString());
            cacheLocation = 1;
        } else
        {
            mdotmadrequest = new File((new StringBuilder()).append(mContext.getCacheDir()).append("/").append(MdotM_CACHE_FOLDER).append("/").append(MdotM_Interstitial_Temp).toString());
            cacheLocation = 2;
        }
        obj = mdotmadrequest;
        if (!mdotmadrequest.mkdirs())
        {
            if (!mdotmadrequest.exists())
            {
                obj = mdotmadrequest;
                if (cacheLocation == 1)
                {
                    cacheLocation = 2;
                    obj = new File((new StringBuilder(String.valueOf(mContext.getCacheDir().getAbsolutePath()))).append("/").append(MdotM_CACHE_FOLDER).append("/").append(MdotM_Interstitial_Temp).toString());
                    MdotMLogger.i(this, "unable to create folder on sd card so creating on internal memory");
                    ((File) (obj)).mkdirs();
                }
            } else
            {
                MdotMLogger.i(this, "File created ");
                obj = mdotmadrequest;
            }
        }
        if (((File) (obj)).exists())
        {
            manageTemporaryCache(((File) (obj)));
        }
        MdotMLogger.i(this, (new StringBuilder("temp cache location is ")).append(cacheLocation).append(" file path ").append(((File) (obj)).getAbsolutePath()).toString());
    }

    private boolean deleteLeastRecentlyUsedCache()
    {
        return MdotMCacheHandler.getInstance(mContext).deleteCache(mContext, cacheLocation);
    }

    private long getAvailableExternalMemorySize()
    {
        if (isSDCardExist)
        {
            StatFs statfs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            long l;
            long l1;
            if (android.os.Build.VERSION.SDK_INT >= 18)
            {
                l1 = statfs.getBlockSizeLong();
                l = statfs.getAvailableBlocksLong();
            } else
            {
                l1 = statfs.getBlockSize();
                l = statfs.getAvailableBlocks();
            }
            return l * l1;
        } else
        {
            return 0L;
        }
    }

    private long getAvailableInternalMemorySize()
    {
        StatFs statfs = new StatFs(Environment.getDownloadCacheDirectory().getPath());
        long l;
        long l1;
        if (android.os.Build.VERSION.SDK_INT >= 18)
        {
            l1 = statfs.getBlockSizeLong();
            l = statfs.getAvailableBlocksLong();
        } else
        {
            l1 = statfs.getBlockSize();
            l = statfs.getAvailableBlocks();
        }
        return l * l1;
    }

    public static MdotMNetworkManager getInstance(Context context, Handler handler)
    {
        if (mManager == null)
        {
            MdotMLogger.i("", "**Creating new manager");
            mManager = new MdotMNetworkManager(context, handler);
        } else
        {
            MdotMLogger.i("", "**Using existing manager");
        }
        return mManager;
    }

    private int getSize(File file, int i)
    {
        int j;
        if (file == null)
        {
            return i;
        }
        if (!file.exists())
        {
            return i;
        }
        j = i;
        if (!file.isDirectory()) goto _L2; else goto _L1
_L1:
        String as[];
        as = file.list();
        j = i;
        if (as == null) goto _L2; else goto _L3
_L3:
        j = 0;
_L7:
        if (j < as.length) goto _L5; else goto _L4
_L4:
        j = i;
_L2:
        return j;
_L5:
        File file1 = new File(file, as[j]);
        if (file1.isDirectory())
        {
            i = getSize(file1, i);
        } else
        {
            i = (int)((long)i + file1.length());
        }
        j++;
        if (true) goto _L7; else goto _L6
_L6:
    }

    private void manageCacheSize()
    {
        MdotMLogger.i(this, "manage cache");
        if (cacheLocation != 0)
        {
            int i;
            int j;
            if (cacheLocation == 2)
            {
                i = getSize(new File((new StringBuilder(String.valueOf(mContext.getCacheDir().getAbsolutePath()))).append("/").append(MdotM_CACHE_FOLDER).append("/").append(MdotM_PermanentCaching).toString()), 0);
                j = adCacheSizeInternal;
                MdotMLogger.i(this, (new StringBuilder("cache size is ")).append(i).append(" path ").append(mContext.getCacheDir().getAbsolutePath()).append("/").append(MdotM_CACHE_FOLDER).append("/").append(MdotM_PermanentCaching).toString());
            } else
            {
                i = getSize(new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().getAbsolutePath()))).append("/").append(MdotM_CACHE_FOLDER).append("/").append(MdotM_PermanentCaching).toString()), 0);
                j = adCacheSizeSDCard;
                MdotMLogger.i(this, (new StringBuilder(" manage cache size is ")).append(i).append(" path ").append(Environment.getExternalStorageDirectory().getAbsolutePath()).append("/").append(MdotM_CACHE_FOLDER).append("/").append(MdotM_PermanentCaching).append(" max cache size").append(j).toString());
            }
            if (i > j)
            {
                if (deleteLeastRecentlyUsedCache())
                {
                    manageCacheSize();
                }
                MdotMLogger.i(this, "manage cache loop");
            }
        }
    }

    private void manageTemporaryCache(File file)
    {
        boolean flag;
        flag = false;
        MdotMLogger.i(this, (new StringBuilder("file count ")).append(file.list().length).toString());
        if (file.list().length < temporaryCacheSize) goto _L2; else goto _L1
_L1:
        long al[];
        int i;
        file = file.listFiles();
        al = new long[file.length];
        i = 0;
_L6:
        if (i < file.length) goto _L4; else goto _L3
_L3:
        Object obj;
        Exception exception;
        int j;
        try
        {
            Arrays.sort(al);
            j = file.length;
        }
        // Misplaced declaration of an exception variable
        catch (File file)
        {
            file.printStackTrace();
            return;
        }
        i = ((flag) ? 1 : 0);
_L7:
        if (i < j) goto _L5; else goto _L2
_L2:
        return;
_L4:
        obj = file[i].getName();
        try
        {
            al[i] = Long.parseLong(((String) (obj)).substring(((String) (obj)).lastIndexOf("-") + 1));
        }
        // Misplaced declaration of an exception variable
        catch (Exception exception)
        {
            exception.printStackTrace();
            MdotMLogger.e(this, (new StringBuilder("Exception while checking file cached time ")).append(exception.getMessage()).toString());
        }
        i++;
          goto _L6
_L5:
        exception = file[i];
        MdotMLogger.i(this, (new StringBuilder("searching file name ")).append(exception.getName()).toString());
        if (exception.getName().endsWith((new StringBuilder()).append(al[0]).toString()))
        {
            MdotMLogger.i(this, (new StringBuilder("deleting file ")).append(exception.getAbsolutePath()).toString());
            exception.delete();
            return;
        }
        i++;
          goto _L7
    }

    private void setThreadPool()
    {
        executor = new ThreadPoolExecutor(1, 1, 30L, TimeUnit.SECONDS, worksQueue);
    }

    private boolean verifyCache(String s)
    {
        String as[];
        File afile[];
        File file = new File(s);
        if (!file.exists())
        {
            MdotMCacheHandler.getInstance(mContext).clearAllTable(mContext);
            cacheLocation = 0;
            return false;
        }
        as = MdotMCacheHandler.getInstance(mContext).getAllFileFromCacheTable();
        s = MdotMCacheHandler.getInstance(mContext).getAllFilesfromResourceTable();
        afile = file.listFiles();
        if (as == null || afile == null) goto _L2; else goto _L1
_L1:
        int i;
        i = 0;
        if (as != null)
        {
            i = 0 + as.length;
        }
        int j = i;
        if (s != null)
        {
            j = i + s.length;
        }
        if (j != afile.length)
        {
            MdotMCacheHandler.getInstance(mContext).clearAllTable(mContext);
            MdotMLogger.i(this, "file count missmatch clearing");
            clearCahe(afile);
            cacheLocation = 0;
            return false;
        }
        int l;
        int j1;
        if (cacheLocation == 2)
        {
            s = (new StringBuilder(String.valueOf(mContext.getCacheDir().getAbsolutePath()))).append("/").append(MdotM_CACHE_FOLDER).append("/").append(MdotM_PermanentCaching).append("/").toString();
        } else
        {
            s = (new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().getAbsolutePath()))).append("/").append(MdotM_CACHE_FOLDER).append("/").append(MdotM_PermanentCaching).append("/").toString();
        }
        if (as == null) goto _L4; else goto _L3
_L3:
        l = as.length;
        i = 0;
_L22:
        if (i < l) goto _L5; else goto _L4
_L4:
        as = MdotMCacheHandler.getInstance(mContext).getAllFilesfromResourceTable();
        if (as == null) goto _L7; else goto _L6
_L6:
        j1 = as.length;
        i = 0;
_L18:
        if (i < j1) goto _L8; else goto _L7
_L7:
        return true;
_L5:
        afile = as[i];
        if ((new File((new StringBuilder(String.valueOf(s))).append(afile).toString())).exists()) goto _L10; else goto _L9
_L9:
        String as1[];
        MdotMCacheHandler.getInstance(mContext).deleteFileFromCacheTable(afile);
        as1 = MdotMCacheHandler.getInstance(mContext).getRelatedResources(afile);
        if (as1 == null) goto _L10; else goto _L11
_L11:
        int k;
        int k1;
        k1 = as1.length;
        k = 0;
_L13:
        if (k < k1) goto _L12; else goto _L10
_L10:
        i++;
        continue; /* Loop/switch isn't completed */
_L12:
        String s2 = as1[k];
        try
        {
            MdotMCacheHandler.getInstance(mContext).clearCachedResource(s2, mContext, cacheLocation, afile);
        }
        catch (Exception exception)
        {
            MdotMLogger.i(this, "Exception while delting the resources");
        }
        k++;
        if (true) goto _L13; else goto _L8
_L8:
        afile = as[i];
        if ((new File((new StringBuilder(String.valueOf(s))).append(afile).toString())).exists()) goto _L15; else goto _L14
_L14:
        afile = MdotMCacheHandler.getInstance(mContext).getResourceParents(afile);
        if (afile == null) goto _L15; else goto _L16
_L16:
        int l1;
        l1 = afile.length;
        k = 0;
_L19:
        if (k < l1) goto _L17; else goto _L15
_L15:
        i++;
          goto _L18
_L17:
        String s1;
        String as2[];
        int i1;
        int i2;
        s1 = afile[k];
        File file1 = new File((new StringBuilder(String.valueOf(s))).append(s1).toString());
        if (file1.exists())
        {
            file1.delete();
        }
        MdotMCacheHandler.getInstance(mContext).deleteFileFromCacheTable(s1);
        as2 = MdotMCacheHandler.getInstance(mContext).getRelatedResources(s1);
        i2 = as2.length;
        i1 = 0;
_L20:
label0:
        {
            if (i1 < i2)
            {
                break label0;
            }
            k++;
        }
          goto _L19
        String s3 = as2[i1];
        try
        {
            MdotMCacheHandler.getInstance(mContext).clearCachedResource(s3, mContext, cacheLocation, s1);
        }
        catch (Exception exception1)
        {
            MdotMLogger.i(this, "Exception while delting the resources");
        }
        i1++;
          goto _L20
_L2:
        MdotMCacheHandler.getInstance(mContext).clearAllTable(mContext);
        clearCahe(afile);
        cacheLocation = 0;
        return false;
        if (true) goto _L22; else goto _L21
_L21:
    }

    public void sendRequest(MdotMAdRequest mdotmadrequest, long l)
    {
        MdotMLogger.i(this, "** Send request");
        if (mdotmadrequest == null)
        {
            break MISSING_BLOCK_LABEL_62;
        }
        enableCaching = mdotmadrequest.isEnableCaching();
        checkCacheStatus(mdotmadrequest);
    /* block-local class not found */
    class Requests {}

        if (executor != null)
        {
            executor.execute(new Requests((new MdotMRequestBuilder(mContext)).buildRequest(mdotmadrequest), mdotmadrequest, l));
        }
        return;
        mdotmadrequest;
        MdotMLogger.i(this, "**Reject Exception");
        mdotmadrequest = new Message();
        mdotmadrequest.obj = Long.valueOf(l);
        mHandler.sendMessage(mdotmadrequest);
        return;
        mdotmadrequest;
        MdotMLogger.e(this, mdotmadrequest.getMessage());
        mdotmadrequest = new Message();
        mdotmadrequest.obj = Long.valueOf(l);
        mHandler.sendMessage(mdotmadrequest);
        return;
    }

    public void setAdNetworkListener(MdotMNetworkListener mdotmnetworklistener)
    {
        networkListener = mdotmnetworklistener;
    }






}

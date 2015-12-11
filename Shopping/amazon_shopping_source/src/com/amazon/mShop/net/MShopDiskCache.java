// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.net;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import com.amazon.mShop.debug.DebugSettings;
import com.amazon.mShop.util.Util;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

// Referenced classes of package com.amazon.mShop.net:
//            MShopDiskCachePolicy, MShopHttpHeaderHelper, LRUCache

public abstract class MShopDiskCache
{
    public static class FileCacheInf
    {

        public Map mHeaderFields;
        public MShopDiskCachePolicy.FileLruInf mLruInf;

        public FileCacheInf(MShopDiskCachePolicy.FileLruInf filelruinf, Map map)
        {
            mLruInf = filelruinf;
            mHeaderFields = map;
        }
    }


    private static final boolean DEBUG = DebugSettings.isDebugEnabled();
    private static final Executor sWriter = Executors.newSingleThreadExecutor();

    public MShopDiskCache()
    {
    }

    static int deleteCachedFile(MShopDiskCachePolicy.FileLruInf filelruinf)
    {
        int i;
        if (filelruinf == null || filelruinf.mFile == null)
        {
            i = 0;
        } else
        {
            File file = filelruinf.mFile;
            int k = (int)((long)0 + file.length());
            file.delete();
            filelruinf = newInfFile(filelruinf);
            i = k;
            if (filelruinf != null)
            {
                i = k;
                if (filelruinf.exists())
                {
                    int j = (int)((long)k + filelruinf.length());
                    filelruinf.delete();
                    return j;
                }
            }
        }
        return i;
    }

    public static FileCacheInf getFileCacheInf(String s, MShopDiskCachePolicy.ResidencePriority residencepriority)
    {
        MShopDiskCachePolicy.FileLruInf filelruinf = MShopDiskCachePolicy.getFileJournal(s, residencepriority);
        s = MShopHttpHeaderHelper.readHeaderInf(s, residencepriority);
        if (filelruinf == null || s == null)
        {
            deleteCachedFile(filelruinf);
            return null;
        } else
        {
            return new FileCacheInf(filelruinf, s);
        }
    }

    static int getFileUsedSize(MShopDiskCachePolicy.FileLruInf filelruinf)
    {
        int j = (int)filelruinf.mFile.length();
        filelruinf = newInfFile(filelruinf);
        int i = j;
        if (filelruinf != null)
        {
            i = j;
            if (filelruinf.exists())
            {
                i = (int)((long)j + filelruinf.length());
            }
        }
        return i;
    }

    private static File newInfFile(MShopDiskCachePolicy.FileLruInf filelruinf)
    {
        Object obj = null;
        String s = filelruinf.mInfFile;
        filelruinf = obj;
        if (!Util.isEmpty(s))
        {
            filelruinf = new File(s);
        }
        return filelruinf;
    }

    static File newInfFile(String s, MShopDiskCachePolicy.ResidencePriority residencepriority)
    {
        residencepriority = MShopDiskCachePolicy.getDirNameForResidence(residencepriority);
        StringBuilder stringbuilder = new StringBuilder(residencepriority.length() + s.length() + 3);
        stringbuilder.append(residencepriority);
        stringbuilder.append(s);
        stringbuilder.append(".inf");
        return new File(stringbuilder.toString());
    }

    public static Bitmap readBitmap(String s, MShopDiskCachePolicy.ResidencePriority residencepriority, int i)
    {
        android.graphics.BitmapFactory.Options options;
        int j;
        options = new android.graphics.BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile((new StringBuilder()).append(MShopDiskCachePolicy.getDirNameForResidence(residencepriority)).append(s).toString(), options);
        if (options.outHeight < options.outWidth)
        {
            break MISSING_BLOCK_LABEL_112;
        }
        j = options.outHeight;
_L1:
        options = new android.graphics.BitmapFactory.Options();
        if (i <= 0)
        {
            break MISSING_BLOCK_LABEL_76;
        }
        options.inSampleSize = j / i;
        options.inPurgeable = true;
        options.inInputShareable = true;
        return BitmapFactory.decodeFile((new StringBuilder()).append(MShopDiskCachePolicy.getDirNameForResidence(residencepriority)).append(s).toString(), options);
        j = options.outWidth;
          goto _L1
        s;
        LRUCache.reduceByPercent(50);
        System.gc();
        if (Util.isEmpty(s.getMessage()))
        {
            s = "MShopDiskCache";
        } else
        {
            s = s.getMessage();
        }
        Log.e("MShopDiskCache", s);
        return null;
    }

    public static void updateHeaderInf(String s, HttpURLConnection httpurlconnection, MShopDiskCachePolicy.ResidencePriority residencepriority, long l, long l1)
    {
        if (!MShopDiskCachePolicy.isCacheDirReady())
        {
            return;
        } else
        {
            httpurlconnection = httpurlconnection.getHeaderFields();
            sWriter.execute(new Runnable(s, httpurlconnection, residencepriority, l, l1) {

                final Map val$header;
                final String val$key;
                final long val$receiveTimeMillis;
                final MShopDiskCachePolicy.ResidencePriority val$residencePriority;
                final long val$sendTimeMillis;

                public void run()
                {
                    MShopHttpHeaderHelper.writeHeaderInf(key, header, residencePriority, sendTimeMillis, receiveTimeMillis, false);
                }

            
            {
                key = s;
                header = map;
                residencePriority = residencepriority;
                sendTimeMillis = l;
                receiveTimeMillis = l1;
                super();
            }
            });
            return;
        }
    }

    public static void writeCacheFile(String s, byte abyte0[], HttpURLConnection httpurlconnection, MShopDiskCachePolicy.ResidencePriority residencepriority, long l, long l1)
    {
        if (!MShopDiskCachePolicy.isCacheDirReady())
        {
            return;
        } else
        {
            String s1 = httpurlconnection.getContentType();
            httpurlconnection = httpurlconnection.getHeaderFields();
            sWriter.execute(new Runnable(s, httpurlconnection, residencepriority, l, l1, abyte0, s1) {

                final String val$contentType;
                final Map val$header;
                final String val$key;
                final long val$receiveTimeMillis;
                final MShopDiskCachePolicy.ResidencePriority val$residencePriority;
                final long val$sendTimeMillis;
                final byte val$value[];

                public void run()
                {
                    if (MShopHttpHeaderHelper.writeHeaderInf(key, header, residencePriority, sendTimeMillis, receiveTimeMillis))
                    {
                        File file = MShopDiskCache.writeFileContent(key, value, contentType, residencePriority);
                        if (file != null)
                        {
                            MShopDiskCachePolicy.addFileJournal(key, file, residencePriority);
                        }
                    }
                    System.gc();
                }

            
            {
                key = s;
                header = map;
                residencePriority = residencepriority;
                sendTimeMillis = l;
                receiveTimeMillis = l1;
                value = abyte0;
                contentType = s1;
                super();
            }
            });
            return;
        }
    }

    static File writeFileContent(String s, byte abyte0[], String s1, MShopDiskCachePolicy.ResidencePriority residencepriority)
    {
        Object obj;
        Object obj1;
        Object obj2;
        Object obj3;
        Object obj4;
        obj3 = null;
        obj2 = null;
        obj1 = null;
        s1 = null;
        obj4 = null;
        obj = null;
        s = new File((new StringBuilder()).append(MShopDiskCachePolicy.getDirNameForResidence(residencepriority)).append(s).toString());
        s1 = new BufferedOutputStream(new FileOutputStream(s));
        s1.write(abyte0);
        s1.flush();
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_306;
        }
        try
        {
            s1.close();
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            abyte0.printStackTrace();
            if (DEBUG)
            {
                Log.d("MShopDiskCache", abyte0.toString());
            }
            return s;
        }
        abyte0 = s;
_L2:
        return abyte0;
        abyte0;
        residencepriority = obj;
        s = obj2;
_L11:
        s1 = residencepriority;
        if (!DEBUG)
        {
            break MISSING_BLOCK_LABEL_133;
        }
        s1 = residencepriority;
        Log.d("MShopDiskCache", abyte0.toString());
        abyte0 = s;
        if (residencepriority == null) goto _L2; else goto _L1
_L1:
        residencepriority.close();
        return s;
        s1;
        s1.printStackTrace();
        abyte0 = s;
        if (!DEBUG) goto _L2; else goto _L3
_L3:
        Log.d("MShopDiskCache", s1.toString());
        return s;
        abyte0;
        residencepriority = obj1;
        s = obj3;
_L10:
        s1 = residencepriority;
        if (!DEBUG)
        {
            break MISSING_BLOCK_LABEL_197;
        }
        s1 = residencepriority;
        Log.d("MShopDiskCache", abyte0.toString());
        abyte0 = s;
        if (residencepriority == null) goto _L2; else goto _L4
_L4:
        residencepriority.close();
        return s;
        s1;
        s1.printStackTrace();
        abyte0 = s;
        if (!DEBUG) goto _L2; else goto _L5
_L5:
        Log.d("MShopDiskCache", s1.toString());
        return s;
        s;
_L9:
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_243;
        }
        s1.close();
_L7:
        throw s;
        abyte0;
        abyte0.printStackTrace();
        if (DEBUG)
        {
            Log.d("MShopDiskCache", abyte0.toString());
        }
        if (true) goto _L7; else goto _L6
_L6:
        s;
        s1 = obj4;
        continue; /* Loop/switch isn't completed */
        s;
        if (true) goto _L9; else goto _L8
_L8:
        abyte0;
        residencepriority = obj1;
          goto _L10
        abyte0;
        residencepriority = s1;
          goto _L10
        abyte0;
        residencepriority = obj;
          goto _L11
        abyte0;
        residencepriority = s1;
          goto _L11
        return s;
    }

}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.disney.datg.videoplatforms.sdk.cache;

import android.content.Context;
import com.disney.datg.videoplatforms.sdk.utils.LogUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.Date;

// Referenced classes of package com.disney.datg.videoplatforms.sdk.cache:
//            DiskCache, DiskCacheProperties, Data, DiskLruCache

public class DiskLRUCacheImpl extends DiskCache
{

    private static final String TAG = LogUtils.makeLogTag(com/disney/datg/videoplatforms/sdk/cache/DiskLRUCacheImpl);
    protected DiskCacheProperties mCacheParams;
    protected final Object mDiskCacheLock = new Object();
    protected boolean mDiskCacheStarting;
    protected DiskLruCache mDiskLruCache;

    public DiskLRUCacheImpl(Context context)
    {
        mDiskCacheStarting = true;
        init(new DiskCacheProperties(context));
    }

    private void init(DiskCacheProperties diskcacheproperties)
    {
        mCacheParams = diskcacheproperties;
        diskcacheproperties = mCacheParams;
        if (DiskCacheProperties.DEFAULT_INIT_DISK_CACHE_ON_CREATE)
        {
            initDiskCache();
        }
    }

    private boolean writeDataToFile(Data data, DiskLruCache.Editor editor)
        throws IOException, FileNotFoundException
    {
        Object obj1;
        Object obj2;
        obj2 = null;
        obj1 = null;
        if (data == null) goto _L2; else goto _L1
_L1:
        Object obj = obj2;
        Object obj3 = data.getValue();
        if (obj3 != null) goto _L3; else goto _L2
_L2:
        if (false)
        {
            throw new NullPointerException();
        }
_L5:
        return false;
_L3:
        obj = obj2;
        editor = new BufferedOutputStream(editor.newOutputStream(0), 8192);
        (new ObjectOutputStream(editor)).writeObject(data);
        if (editor != null)
        {
            editor.close();
        }
        return true;
        editor;
        data = obj1;
_L8:
        obj = data;
        LogUtils.logException(editor);
        obj = data;
        editor.printStackTrace();
        obj = data;
        LogUtils.LOGE(TAG, editor.getMessage());
        if (data == null) goto _L5; else goto _L4
_L4:
        data.close();
        return false;
        data;
_L7:
        if (obj != null)
        {
            ((OutputStream) (obj)).close();
        }
        throw data;
        data;
        obj = editor;
        if (true) goto _L7; else goto _L6
_L6:
        IOException ioexception;
        ioexception;
        data = editor;
        editor = ioexception;
          goto _L8
    }

    public void flush()
    {
        Object obj = mDiskCacheLock;
        obj;
        JVM INSTR monitorenter ;
        DiskLruCache disklrucache = mDiskLruCache;
        if (disklrucache == null)
        {
            break MISSING_BLOCK_LABEL_31;
        }
        mDiskLruCache.flush();
        LogUtils.LOGD(TAG, "Disk cache flushed");
_L1:
        obj;
        JVM INSTR monitorexit ;
        return;
        Object obj1;
        obj1;
        LogUtils.logException(((Exception) (obj1)));
        LogUtils.LOGE(TAG, (new StringBuilder()).append("flush - ").append(obj1).toString());
          goto _L1
        obj1;
        obj;
        JVM INSTR monitorexit ;
        throw obj1;
    }

    public void initDiskCache()
    {
        Object obj = mDiskCacheLock;
        obj;
        JVM INSTR monitorenter ;
        File file;
        if (mDiskLruCache != null && !mDiskLruCache.isClosed())
        {
            break MISSING_BLOCK_LABEL_96;
        }
        file = mCacheParams.diskCacheDir;
        if (file == null)
        {
            break MISSING_BLOCK_LABEL_96;
        }
        int i;
        long l;
        if (!file.exists())
        {
            file.mkdirs();
        }
        l = getUsableSpace(file);
        i = mCacheParams.diskCacheSize;
        if (l <= (long)i)
        {
            break MISSING_BLOCK_LABEL_96;
        }
        mDiskLruCache = DiskLruCache.open(file, 1, 1, mCacheParams.diskCacheSize);
        LogUtils.LOGD(TAG, "Disk cache initialized");
_L1:
        mDiskCacheStarting = false;
        mDiskCacheLock.notifyAll();
        obj;
        JVM INSTR monitorexit ;
        return;
        Object obj1;
        obj1;
        LogUtils.logException(((Exception) (obj1)));
        mCacheParams.diskCacheDir = null;
        LogUtils.LOGE(TAG, (new StringBuilder()).append("initDiskCache - ").append(obj1).toString());
          goto _L1
        obj1;
        obj;
        JVM INSTR monitorexit ;
        throw obj1;
    }

    public boolean isEmpty()
    {
        return mDiskLruCache == null || mDiskLruCache.size() == 0L;
    }

    public Data readFromFile(Object obj)
        throws FileNotFoundException
    {
        Object obj3;
        Data data;
        Object obj5;
        ObjectInputStream objectinputstream;
        Object obj6;
        String s;
        s = processKey(obj);
        obj3 = null;
        obj5 = null;
        obj6 = null;
        data = null;
        objectinputstream = null;
        Object obj8 = mDiskCacheLock;
        obj8;
        JVM INSTR monitorenter ;
_L1:
        boolean flag = mDiskCacheStarting;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_66;
        }
        mDiskCacheLock.wait();
          goto _L1
        obj;
        LogUtils.logException(((Exception) (obj)));
          goto _L1
        obj;
        obj8;
        JVM INSTR monitorexit ;
        throw obj;
        obj = mDiskLruCache;
        if (obj == null) goto _L3; else goto _L2
_L2:
        Object obj2;
        Object obj4;
        InputStream inputstream;
        Object obj7;
        inputstream = null;
        obj7 = null;
        obj4 = null;
        obj = obj6;
        obj2 = inputstream;
        obj3 = obj7;
        DiskLruCache.Snapshot snapshot = mDiskLruCache.get(s);
        Object obj1;
        obj1 = objectinputstream;
        if (snapshot == null)
        {
            break MISSING_BLOCK_LABEL_341;
        }
        obj = obj6;
        obj2 = inputstream;
        obj3 = obj7;
        LogUtils.LOGD(TAG, "Disk cache hit");
        obj = obj6;
        obj2 = inputstream;
        obj3 = obj7;
        inputstream = snapshot.getInputStream(0);
        obj1 = objectinputstream;
        obj4 = inputstream;
        if (inputstream == null)
        {
            break MISSING_BLOCK_LABEL_341;
        }
        obj = obj6;
        obj2 = inputstream;
        obj3 = inputstream;
        objectinputstream = new ObjectInputStream(new BufferedInputStream(inputstream, 8192));
        obj1 = obj5;
        obj4 = data;
        data = (Data)objectinputstream.readObject();
        obj1 = data;
        obj4 = data;
        int i = data.getTtl();
        if (i <= 0)
        {
            break MISSING_BLOCK_LABEL_317;
        }
        obj1 = data;
        obj4 = data;
        obj = new Date();
        obj1 = data;
        obj4 = data;
        obj2 = data.getAccessTime();
        obj1 = data;
        obj4 = data;
        if ((long)i >= (((Date) (obj)).getTime() - ((Date) (obj2)).getTime()) / 1000L)
        {
            break MISSING_BLOCK_LABEL_317;
        }
        obj1 = data;
        obj4 = data;
        LogUtils.LOGD(TAG, "item has expired, removing from disk cache");
        obj1 = data;
        obj4 = data;
        mDiskLruCache.remove(s);
        obj = data;
        obj2 = inputstream;
        obj3 = inputstream;
        objectinputstream.close();
        obj4 = inputstream;
        obj1 = data;
_L5:
        if (snapshot == null)
        {
            break MISSING_BLOCK_LABEL_360;
        }
        obj = obj1;
        obj2 = obj4;
        obj3 = obj4;
        snapshot.close();
        obj3 = obj1;
        if (obj4 == null) goto _L3; else goto _L4
_L4:
        ((InputStream) (obj4)).close();
        obj3 = obj1;
_L3:
        obj8;
        JVM INSTR monitorexit ;
        return ((Data) (obj3));
        obj;
        obj4 = obj1;
        LogUtils.logException(((Exception) (obj)));
        obj4 = obj1;
        LogUtils.LOGE(TAG, (new StringBuilder()).append("readFromFile - ").append(obj).toString());
        obj = obj1;
        obj2 = inputstream;
        obj3 = inputstream;
        objectinputstream.close();
        obj4 = inputstream;
          goto _L5
_L7:
        LogUtils.logException(((Exception) (obj1)));
        obj3 = obj2;
        LogUtils.LOGE(TAG, (new StringBuilder()).append("readFromFile - ").append(obj1).toString());
        obj3 = obj;
        if (obj2 == null) goto _L3; else goto _L6
_L6:
        ((InputStream) (obj2)).close();
        obj3 = obj;
          goto _L3
        obj1;
        LogUtils.logException(((Exception) (obj1)));
        obj3 = obj;
          goto _L3
        obj1;
        obj = obj4;
        obj2 = inputstream;
        obj3 = inputstream;
        objectinputstream.close();
        obj = obj4;
        obj2 = inputstream;
        obj3 = inputstream;
        try
        {
            throw obj1;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            obj3 = obj2;
        }
        finally
        {
            if (obj3 == null) goto _L8; else goto _L0
        }
          goto _L7
        ((InputStream) (obj3)).close();
_L8:
        throw obj;
        obj;
        LogUtils.logException(((Exception) (obj)));
        obj3 = obj1;
          goto _L3
        IOException ioexception;
        ioexception;
        LogUtils.logException(ioexception);
          goto _L8
    }

    public void writeToFile(Object obj, Object obj1, int i)
        throws IOException, FileNotFoundException
    {
        if (obj != null && obj1 != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Data data;
        String s;
        s = processKey(obj);
        Object obj2 = null;
        data = new Data();
        data.setKey(obj);
        data.setValue(obj1);
        data.setTtl(i);
        data.setAccessTime(new Date());
        obj = obj2;
        obj1 = mDiskLruCache.edit(s);
        if (obj1 == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        obj = obj1;
        if (!writeDataToFile(data, ((DiskLruCache.Editor) (obj1))))
        {
            break; /* Loop/switch isn't completed */
        }
        obj = obj1;
        flush();
        obj = obj1;
        try
        {
            ((DiskLruCache.Editor) (obj1)).commit();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1) { }
        if (obj != null)
        {
            try
            {
                ((DiskLruCache.Editor) (obj)).abort();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                LogUtils.logException(((Exception) (obj)));
            }
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
        obj = obj1;
        ((DiskLruCache.Editor) (obj1)).abort();
        return;
    }

}

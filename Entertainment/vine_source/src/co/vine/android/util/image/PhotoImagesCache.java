// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.util.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v8.renderscript.RSRuntimeException;
import co.vine.android.network.HttpResult;
import co.vine.android.util.CrashUtil;
import co.vine.android.util.PipingInputStream;
import co.vine.android.util.UrlResource;
import co.vine.android.util.UrlResourceCache;
import co.vine.android.util.Util;
import com.edisonwang.android.slog.SLog;
import com.vandalsoftware.io.DiskLruCache;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

// Referenced classes of package co.vine.android.util.image:
//            UrlImage, ImageKey, ImageUtils, PhotoImagesListener

public class PhotoImagesCache extends UrlResourceCache
{

    private static final String DISK_CACHE_NAME = "photos";
    private static final int INDEX_IMAGE_BYTES = 0;
    private static final int LOCK[] = new int[0];
    private static final int MAX_EXTERNAL_DISK_CACHE_SIZE = 0x6400000;
    private static final int MAX_INTERNAL_DISK_CACHE_SIZE = 0xa00000;
    private static final int VALUE_COUNT = 1;
    private static final int VERSION = 2;
    private static DiskLruCache sDiskCache;
    private static boolean sIsCacheInitialized = false;
    private final ArrayList mListeners = new ArrayList();
    private final int mMaxImageSize;

    public PhotoImagesCache(Context context, int i, int j)
    {
        super(context, j);
        mMaxImageSize = i;
    }

    static File getCacheDir()
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

    private static DiskLruCache getDiskLruCache(Context context)
    {
        int ai[] = LOCK;
        ai;
        JVM INSTR monitorenter ;
        boolean flag = sIsCacheInitialized;
        Object obj;
        if (flag)
        {
            break MISSING_BLOCK_LABEL_54;
        }
        obj = null;
        File file = Util.getExternalCacheDir(context);
        if (file == null)
        {
            break MISSING_BLOCK_LABEL_62;
        }
        try
        {
            context = DiskLruCache.open(new File(file, "photos"), 2, 1, 0x6400000L);
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
        context = DiskLruCache.open(new File(context.getCacheDir(), "photos"), 2, 1, 0xa00000L);
        break MISSING_BLOCK_LABEL_46;
        context;
        ai;
        JVM INSTR monitorexit ;
        throw context;
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

    public void addListener(PhotoImagesListener photoimageslistener)
    {
        mListeners.add(photoimageslistener);
    }

    public void clearMemory()
    {
        int ai[] = LOCK;
        ai;
        JVM INSTR monitorenter ;
        Object obj = new ArrayList(snapShot().values());
        clear();
        obj = ((Collection) (obj)).iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            UrlImage urlimage = (UrlImage)((Iterator) (obj)).next();
            if (urlimage.bitmap != null)
            {
                urlimage.bitmap.recycle();
                urlimage.bitmap = null;
            }
        } while (true);
        break MISSING_BLOCK_LABEL_80;
        Exception exception;
        exception;
        ai;
        JVM INSTR monitorexit ;
        throw exception;
        ai;
        JVM INSTR monitorexit ;
    }

    public UrlImage get(long l, ImageKey imagekey)
    {
        return (UrlImage)super.get(l, imagekey, imagekey.url, true);
    }

    public Bitmap getBitmap(long l, ImageKey imagekey)
    {
        imagekey = (UrlImage)get(l, imagekey, imagekey.url, true);
        if (imagekey != null)
        {
            return ((UrlImage) (imagekey)).bitmap;
        } else
        {
            return null;
        }
    }

    protected volatile UrlResource instantiateResource(Object obj, String s, Object obj1)
    {
        return instantiateResource((ImageKey)obj, s, (ImageUtils.BitmapInfo)obj1);
    }

    protected UrlImage instantiateResource(ImageKey imagekey, String s, ImageUtils.BitmapInfo bitmapinfo)
    {
        return new UrlImage(s, bitmapinfo);
    }

    protected volatile UrlResource loadResource(long l, Object obj, String s)
    {
        return loadResource(l, (ImageKey)obj, s);
    }

    protected UrlImage loadResource(long l, ImageKey imagekey, String s)
    {
        Object obj;
        InputStream inputstream;
        com.vandalsoftware.io.DiskLruCache.Snapshot snapshot;
        com.vandalsoftware.io.DiskLruCache.Snapshot snapshot1;
        BufferedInputStream bufferedinputstream;
        Object obj1;
        Object obj2;
        obj = Util.md5Digest(s);
        if (obj == null)
        {
            return null;
        }
        snapshot = null;
        snapshot1 = null;
        bufferedinputstream = null;
        inputstream = null;
        obj2 = null;
        obj1 = null;
        int ai[] = LOCK;
        ai;
        JVM INSTR monitorenter ;
        DiskLruCache disklrucache = getDiskLruCache(mContext);
        if (disklrucache == null) goto _L2; else goto _L1
_L1:
        boolean flag = disklrucache.isClosed();
        if (flag) goto _L2; else goto _L3
_L3:
        InputStream inputstream1;
        InputStream inputstream2;
        inputstream1 = inputstream;
        inputstream2 = bufferedinputstream;
        obj = disklrucache.get(((String) (obj)));
        if (obj != null) goto _L5; else goto _L4
_L4:
        Util.closeSilently(((java.io.Closeable) (obj)));
        Util.closeSilently(null);
        Util.closeSilently(null);
        ai;
        JVM INSTR monitorexit ;
        return null;
_L6:
        ai;
        JVM INSTR monitorexit ;
        throw imagekey;
_L5:
        inputstream1 = inputstream;
        snapshot1 = ((com.vandalsoftware.io.DiskLruCache.Snapshot) (obj));
        inputstream2 = bufferedinputstream;
        snapshot = ((com.vandalsoftware.io.DiskLruCache.Snapshot) (obj));
        inputstream = ((com.vandalsoftware.io.DiskLruCache.Snapshot) (obj)).getInputStream(0);
        if (inputstream != null)
        {
            break MISSING_BLOCK_LABEL_159;
        }
        Util.closeSilently(((java.io.Closeable) (obj)));
        Util.closeSilently(inputstream);
        Util.closeSilently(null);
        ai;
        JVM INSTR monitorexit ;
        return null;
        inputstream1 = inputstream;
        snapshot1 = ((com.vandalsoftware.io.DiskLruCache.Snapshot) (obj));
        inputstream2 = inputstream;
        snapshot = ((com.vandalsoftware.io.DiskLruCache.Snapshot) (obj));
        bufferedinputstream = new BufferedInputStream(inputstream, 4096);
        imagekey = obtainResource(imagekey, s, bufferedinputstream);
        Util.closeSilently(((java.io.Closeable) (obj)));
        Util.closeSilently(inputstream);
        Util.closeSilently(bufferedinputstream);
        ai;
        JVM INSTR monitorexit ;
        return imagekey;
        imagekey;
          goto _L6
        imagekey;
        obj = snapshot1;
        inputstream = inputstream1;
        imagekey = obj1;
_L8:
        Util.closeSilently(((java.io.Closeable) (obj)));
        Util.closeSilently(inputstream);
        Util.closeSilently(imagekey);
_L2:
        ai;
        JVM INSTR monitorexit ;
        return null;
_L7:
        Util.closeSilently(((java.io.Closeable) (obj)));
        Util.closeSilently(inputstream);
        Util.closeSilently(imagekey);
        throw s;
        s;
        imagekey = bufferedinputstream;
          goto _L7
        imagekey;
        imagekey = bufferedinputstream;
          goto _L8
        imagekey;
          goto _L6
        s;
        imagekey = obj2;
        inputstream = inputstream2;
        obj = snapshot;
          goto _L7
    }

    protected volatile UrlResource obtainResource(Object obj, String s, InputStream inputstream)
    {
        return obtainResource((ImageKey)obj, s, inputstream);
    }

    protected UrlImage obtainResource(ImageKey imagekey, String s, InputStream inputstream)
    {
        Object obj;
        Object obj1;
        Object obj2;
        boolean flag1;
        boolean flag2;
        boolean flag;
        int i;
        int j;
        int k;
        int l;
        int i1;
        if (imagekey.requestResize)
        {
            j = imagekey.width;
            i = imagekey.height;
        } else
        {
            j = mMaxImageSize;
            i = mMaxImageSize;
        }
        flag = false;
        try
        {
            obj = ImageUtils.resizeBitmap(mContext, inputstream, j, i);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            flag = true;
            obj = null;
        }
        flag2 = flag;
        obj2 = obj;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_297;
        }
        flag2 = flag;
        obj2 = obj;
        if (((ImageUtils.BitmapInfo) (obj)).bitmap == null)
        {
            break MISSING_BLOCK_LABEL_297;
        }
        l = ((ImageUtils.BitmapInfo) (obj)).bitmap.getWidth();
        i1 = ((ImageUtils.BitmapInfo) (obj)).bitmap.getHeight();
        if (l < i1)
        {
            k = l;
        } else
        {
            k = i1;
        }
        flag1 = flag;
        obj1 = obj;
        if (!imagekey.circularCropped)
        {
            break MISSING_BLOCK_LABEL_140;
        }
        obj1 = new ImageUtils.BitmapInfo(ImageUtils.getCroppedBitmap(((ImageUtils.BitmapInfo) (obj)).bitmap, k), k, l, i1);
        flag1 = flag;
_L1:
        flag2 = flag1;
        obj2 = obj1;
        if (!imagekey.blurred)
        {
            break MISSING_BLOCK_LABEL_297;
        }
        obj = new ImageUtils.BitmapInfo(ImageUtils.getBlurredBitmap(mContext, ((ImageUtils.BitmapInfo) (obj1)).bitmap, imagekey.blurRadius, imagekey.desaturated), k, l, i1);
_L2:
        obj = instantiateResource(imagekey, s, ((ImageUtils.BitmapInfo) (obj)));
        if (flag1)
        {
            SLog.e("Decoding error!!! Memory Low? Clear all bitmaps now!");
            clearMemory();
            try
            {
                obj = instantiateResource(imagekey, s, ImageUtils.resizeBitmap(mContext, inputstream, j, i));
            }
            // Misplaced declaration of an exception variable
            catch (InputStream inputstream)
            {
                return instantiateResource(imagekey, s, ((ImageUtils.BitmapInfo) (null)));
            }
        }
        return ((UrlImage) (obj));
        obj1;
        flag1 = true;
        obj1 = obj;
          goto _L1
        obj;
        CrashUtil.logException(((Throwable) (obj)));
        obj2 = obj1;
        flag2 = flag1;
        obj = obj2;
        flag1 = flag2;
          goto _L2
    }

    protected void onResourceError(ImageKey imagekey, HttpResult httpresult)
    {
        for (int i = mListeners.size() - 1; i >= 0; i--)
        {
            ((PhotoImagesListener)mListeners.get(i)).onPhotoImageError(this, imagekey, httpresult);
        }

    }

    protected volatile void onResourceError(Object obj, HttpResult httpresult)
    {
        onResourceError((ImageKey)obj, httpresult);
    }

    protected void onResourceLoaded(HashMap hashmap)
    {
        for (int i = mListeners.size() - 1; i >= 0; i--)
        {
            ((PhotoImagesListener)mListeners.get(i)).onPhotoImageLoaded(this, hashmap);
        }

    }

    public Bitmap peekBitmap(ImageKey imagekey)
    {
        imagekey = (UrlImage)super.peek(imagekey);
        if (imagekey != null)
        {
            return ((UrlImage) (imagekey)).bitmap;
        } else
        {
            return null;
        }
    }

    public void prepopulateThumbnailCacheForUrl(long l, ImageKey imagekey, String s, FileInputStream fileinputstream)
    {
        saveResource(l, imagekey, s, fileinputstream, false);
    }

    public void removeListener(PhotoImagesListener photoimageslistener)
    {
        mListeners.remove(photoimageslistener);
    }

    protected volatile UrlResource saveResource(long l, Object obj, String s, InputStream inputstream, boolean flag)
    {
        return saveResource(l, (ImageKey)obj, s, inputstream, flag);
    }

    protected UrlImage saveResource(long l, ImageKey imagekey, String s, InputStream inputstream, boolean flag)
    {
        Object obj;
        Object obj1;
        Object obj2;
        Object obj4;
        Object obj5;
        obj = Util.md5Digest(s);
        if (obj == null)
        {
            return obtainResource(imagekey, s, inputstream);
        }
        obj2 = null;
        obj1 = null;
        obj4 = null;
        obj5 = null;
        int ai[] = LOCK;
        ai;
        JVM INSTR monitorenter ;
        DiskLruCache disklrucache = getDiskLruCache(mContext);
        if (disklrucache == null) goto _L2; else goto _L1
_L1:
        flag = disklrucache.isClosed();
        if (flag) goto _L2; else goto _L3
_L3:
        boolean flag1;
        flag1 = false;
        flag = false;
        obj = disklrucache.edit(((String) (obj)));
        if (obj == null) goto _L5; else goto _L4
_L4:
        obj1 = obj;
        obj2 = obj;
        Object obj3 = new BufferedOutputStream(((com.vandalsoftware.io.DiskLruCache.Editor) (obj)).newOutputStream(0), 4096);
        flag = flag1;
        obj1 = obtainResource(imagekey, s, new PipingInputStream(inputstream, ((java.io.OutputStream) (obj3))));
        flag = flag1;
        flag1 = ((UrlImage) (obj1)).isValid();
        if (!flag1) goto _L7; else goto _L6
_L6:
        flag = flag1;
        ((BufferedOutputStream) (obj3)).flush();
        flag = flag1;
        ((BufferedOutputStream) (obj3)).close();
        imagekey = null;
_L16:
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_194;
        }
        if (!flag1)
        {
            break MISSING_BLOCK_LABEL_210;
        }
        try
        {
            ((com.vandalsoftware.io.DiskLruCache.Editor) (obj)).commit();
            disklrucache.flush();
        }
        // Misplaced declaration of an exception variable
        catch (String s) { }
        Util.closeSilently(imagekey);
        ai;
        JVM INSTR monitorexit ;
        return ((UrlImage) (obj1));
        imagekey;
        ai;
        JVM INSTR monitorexit ;
        throw imagekey;
        ((com.vandalsoftware.io.DiskLruCache.Editor) (obj)).abort();
        break MISSING_BLOCK_LABEL_194;
_L5:
        obj1 = obj;
        obj2 = obj;
        obj3 = obtainResource(imagekey, s, inputstream);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_261;
        }
        if (true)
        {
            break MISSING_BLOCK_LABEL_271;
        }
        try
        {
            ((com.vandalsoftware.io.DiskLruCache.Editor) (obj)).commit();
            disklrucache.flush();
        }
        // Misplaced declaration of an exception variable
        catch (ImageKey imagekey) { }
        Util.closeSilently(null);
        ai;
        JVM INSTR monitorexit ;
        return ((UrlImage) (obj3));
        ((com.vandalsoftware.io.DiskLruCache.Editor) (obj)).abort();
        break MISSING_BLOCK_LABEL_261;
        obj;
        obj = obj5;
_L14:
        if (obj1 == null) goto _L9; else goto _L8
_L8:
        if (true) goto _L11; else goto _L10
_L10:
        try
        {
            ((com.vandalsoftware.io.DiskLruCache.Editor) (obj1)).commit();
            disklrucache.flush();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1) { }
_L9:
        Util.closeSilently(((java.io.Closeable) (obj)));
_L2:
        ai;
        JVM INSTR monitorexit ;
        return obtainResource(imagekey, s, inputstream);
_L11:
        ((com.vandalsoftware.io.DiskLruCache.Editor) (obj1)).abort();
          goto _L9
        s;
        imagekey = obj4;
        obj = obj2;
_L13:
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_368;
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_375;
        }
        try
        {
            ((com.vandalsoftware.io.DiskLruCache.Editor) (obj)).commit();
            disklrucache.flush();
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream) { }
        Util.closeSilently(imagekey);
        throw s;
        ((com.vandalsoftware.io.DiskLruCache.Editor) (obj)).abort();
        break MISSING_BLOCK_LABEL_368;
        s;
        imagekey = ((ImageKey) (obj3));
        if (true) goto _L13; else goto _L12
_L12:
        IOException ioexception;
        ioexception;
        ioexception = ((IOException) (obj));
        obj = obj3;
        if (true) goto _L14; else goto _L7
_L7:
        imagekey = ((ImageKey) (obj3));
        if (true) goto _L16; else goto _L15
_L15:
    }

}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.brushlib.util;

import android.graphics.Bitmap;
import com.socialin.android.d;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.Serializable;
import java.nio.channels.FileChannel;
import junit.framework.Assert;

public class CacheableBitmap
    implements Serializable
{

    private static final String TAG = com/socialin/android/brushlib/util/CacheableBitmap.getSimpleName();
    private static final long serialVersionUID = 0x34d71c19cd20ba48L;
    private transient Bitmap bitmap;
    private final android.graphics.Bitmap.Config bitmapConfig;
    private final int bitmapHeight;
    private final int bitmapSizeInBytes;
    private final int bitmapWidth;
    private boolean cached;
    private final String path;

    public CacheableBitmap(Bitmap bitmap1, String s)
    {
        Assert.assertNotNull(bitmap1);
        Assert.assertNotNull(s);
        bitmap = bitmap1;
        path = s;
        bitmapWidth = bitmap1.getWidth();
        bitmapHeight = bitmap1.getHeight();
        bitmapSizeInBytes = bitmapWidth * bitmapHeight * 4;
        s = bitmap1.getConfig();
        bitmap1 = s;
        if (s == null)
        {
            bitmap1 = android.graphics.Bitmap.Config.ARGB_8888;
        }
        bitmapConfig = bitmap1;
    }

    public void cache()
    {
        Object obj = null;
        Object obj2 = null;
        this;
        JVM INSTR monitorenter ;
        boolean flag = cached;
        if (!flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        Object obj1 = new RandomAccessFile(new File(path), "rw");
        obj = ((RandomAccessFile) (obj1)).getChannel().map(java.nio.channels.FileChannel.MapMode.READ_WRITE, 0L, bitmapSizeInBytes);
        bitmap.copyPixelsToBuffer(((java.nio.Buffer) (obj)));
        ((RandomAccessFile) (obj1)).close();
_L4:
        bitmap.recycle();
        bitmap = null;
        cached = true;
        if (true) goto _L1; else goto _L3
_L3:
        obj;
        throw obj;
        obj;
        d.b(TAG, new Object[] {
            (new StringBuilder("Got unexpected exception: ")).append(((IOException) (obj)).getMessage()).toString()
        });
          goto _L4
        obj;
        obj1 = obj2;
        obj2 = obj;
_L9:
        obj = obj1;
        d.b(TAG, new Object[] {
            (new StringBuilder("Got unexpected exception: ")).append(((IOException) (obj2)).getMessage()).toString()
        });
        if (obj1 == null) goto _L4; else goto _L5
_L5:
        ((RandomAccessFile) (obj1)).close();
          goto _L4
        obj;
        d.b(TAG, new Object[] {
            (new StringBuilder("Got unexpected exception: ")).append(((IOException) (obj)).getMessage()).toString()
        });
          goto _L4
        Exception exception;
        exception;
        obj1 = obj;
        obj = exception;
_L8:
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_233;
        }
        ((RandomAccessFile) (obj1)).close();
_L6:
        throw obj;
        IOException ioexception;
        ioexception;
        d.b(TAG, new Object[] {
            (new StringBuilder("Got unexpected exception: ")).append(ioexception.getMessage()).toString()
        });
          goto _L6
        obj;
        if (true) goto _L8; else goto _L7
_L7:
        exception;
          goto _L9
    }

    public Bitmap get()
    {
        this;
        JVM INSTR monitorenter ;
        Bitmap bitmap1;
        if (cached || bitmap == null || bitmap.isRecycled())
        {
            restore();
        }
        bitmap1 = bitmap;
        this;
        JVM INSTR monitorexit ;
        return bitmap1;
        Exception exception;
        exception;
        throw exception;
    }

    public int getHeight()
    {
        return bitmapHeight;
    }

    public int getWidth()
    {
        return bitmapWidth;
    }

    public void restore()
    {
        this;
        JVM INSTR monitorenter ;
        if (!cached)
        {
            throw new RuntimeException("Bitmap is not cached!");
        }
        break MISSING_BLOCK_LABEL_24;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        Object obj;
        Object obj2;
        obj = null;
        obj2 = null;
        Object obj1 = new RandomAccessFile(new File(path), "r");
        obj = ((RandomAccessFile) (obj1)).getChannel().map(java.nio.channels.FileChannel.MapMode.READ_ONLY, 0L, bitmapSizeInBytes);
        bitmap = Bitmap.createBitmap(bitmapWidth, bitmapHeight, bitmapConfig);
        bitmap.copyPixelsFromBuffer(((java.nio.Buffer) (obj)));
        ((RandomAccessFile) (obj1)).close();
_L1:
        cached = false;
        this;
        JVM INSTR monitorexit ;
        return;
        obj;
        d.b(TAG, new Object[] {
            (new StringBuilder("Got unexpected exception: ")).append(((IOException) (obj)).getMessage()).toString()
        });
          goto _L1
        obj;
        obj1 = obj2;
        obj2 = obj;
_L6:
        obj = obj1;
        d.b(TAG, new Object[] {
            (new StringBuilder("Got unexpected exception: ")).append(((IOException) (obj2)).getMessage()).toString()
        });
        if (obj1 == null) goto _L1; else goto _L2
_L2:
        ((RandomAccessFile) (obj1)).close();
          goto _L1
        obj;
        d.b(TAG, new Object[] {
            (new StringBuilder("Got unexpected exception: ")).append(((IOException) (obj)).getMessage()).toString()
        });
          goto _L1
        Exception exception1;
        exception1;
        obj1 = obj;
        obj = exception1;
_L5:
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_243;
        }
        ((RandomAccessFile) (obj1)).close();
_L3:
        throw obj;
        IOException ioexception;
        ioexception;
        d.b(TAG, new Object[] {
            (new StringBuilder("Got unexpected exception: ")).append(ioexception.getMessage()).toString()
        });
          goto _L3
        obj;
        if (true) goto _L5; else goto _L4
_L4:
        exception1;
          goto _L6
    }

}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.util;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.Log;
import com.socialin.android.d;
import com.socialin.android.photo.imgop.ImageOpCommon;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class c
{

    public static boolean a = false;
    private static String b = com/socialin/android/util/c.getSimpleName();
    private static boolean c;
    private static int d = 0;
    private static ConcurrentHashMap e = new ConcurrentHashMap();
    private static final Object f = new Object();
    private static boolean g = true;

    public c()
    {
    }

    public static Bitmap a(int i, int j, android.graphics.Bitmap.Config config)
    {
        return a(i, j, config, ((String) (null)));
    }

    public static Bitmap a(int i, int j, android.graphics.Bitmap.Config config, String s)
    {
        Object obj = null;
        Bitmap bitmap = Bitmap.createBitmap(i, j, config);
        config = bitmap;
_L2:
        if (config != null)
        {
            a(config.getRowBytes() * config.getHeight());
            if (c)
            {
                (new StringBuilder("creating bitmap width:")).append(config.getWidth()).append(" height:").append(config.getHeight()).append(" config:").append(config.getConfig()).append(" memoryKB: ").append((float)d / 1024F);
            }
            b(config, s);
        }
        a();
        return config;
        OutOfMemoryError outofmemoryerror;
        outofmemoryerror;
        Log.e(b, "OOM while creating bitmap");
        System.gc();
        try
        {
            config = Bitmap.createBitmap(i, j, config);
        }
        catch (OutOfMemoryError outofmemoryerror1)
        {
            Log.e(b, "OOM while creating bitmap 2");
            config = obj;
            if (a)
            {
                a = false;
                throw new OutOfMemoryError(outofmemoryerror1.getMessage());
            }
        }
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static Bitmap a(Resources resources, int i)
    {
        return a(resources, i, ((android.graphics.BitmapFactory.Options) (null)), ((String) (null)));
    }

    public static Bitmap a(Resources resources, int i, android.graphics.BitmapFactory.Options options)
    {
        return a(resources, i, options, ((String) (null)));
    }

    public static Bitmap a(Resources resources, int i, android.graphics.BitmapFactory.Options options, String s)
    {
        Object obj = null;
        Bitmap bitmap = BitmapFactory.decodeResource(resources, i, options);
        resources = bitmap;
_L1:
        if (resources != null && (options == null || !options.inJustDecodeBounds))
        {
            a(resources.getRowBytes() * resources.getHeight());
            OutOfMemoryError outofmemoryerror;
            if (c)
            {
                if (options == null)
                {
                    (new StringBuilder("decodeResource from stream width:")).append(resources.getWidth()).append(" height:").append(resources.getHeight()).append(" memoryKB: ").append((float)d / 1024F);
                } else
                {
                    (new StringBuilder("decodeResource from stream width:")).append(resources.getWidth()).append(" height:").append(resources.getHeight()).append(" memoryKB: ").append((float)d / 1024F).append(a(options));
                }
            }
            b(resources, s);
        }
        a();
        return resources;
        outofmemoryerror;
        Log.e(b, (new StringBuilder("OOM while loading bitmap from resource , total allocated memory == ")).append((float)d / 1024F).toString());
        System.gc();
        try
        {
            resources = BitmapFactory.decodeResource(resources, i, options);
        }
        // Misplaced declaration of an exception variable
        catch (OutOfMemoryError outofmemoryerror)
        {
            Log.e(b, "OOM while creating bitmap 2");
            resources = obj;
            if (a)
            {
                a = false;
                throw new OutOfMemoryError(outofmemoryerror.getMessage());
            }
        }
          goto _L1
    }

    public static Bitmap a(Bitmap bitmap, int i, int j, int k, int l)
    {
        return a(bitmap, i, j, k, l, null, false);
    }

    public static Bitmap a(Bitmap bitmap, int i, int j, int k, int l, Matrix matrix, boolean flag)
    {
        return b(bitmap, i, j, k, l, matrix, flag);
    }

    public static Bitmap a(Bitmap bitmap, int i, int j, boolean flag)
    {
        return b(bitmap, i, j, flag);
    }

    public static Bitmap a(Bitmap bitmap, android.graphics.Bitmap.Config config)
    {
        return a(bitmap, config, true);
    }

    private static Bitmap a(Bitmap bitmap, android.graphics.Bitmap.Config config, boolean flag)
    {
        Bitmap bitmap1 = bitmap.copy(config, true);
        bitmap = bitmap1;
_L2:
        if (bitmap != null)
        {
            a(bitmap.getRowBytes() * bitmap.getHeight());
            if (c)
            {
                (new StringBuilder("copying bitmap width:")).append(bitmap.getWidth()).append(" height:").append(bitmap.getHeight()).append(" config:").append(bitmap.getConfig()).append(" memoryKB: ").append((float)d / 1024F);
            }
            b(bitmap, ((String) (null)));
        }
        a();
        return bitmap;
        OutOfMemoryError outofmemoryerror;
        outofmemoryerror;
        Log.e(b, "OOM while copying bitmap");
        System.gc();
        try
        {
            bitmap = bitmap.copy(config, true);
        }
        // Misplaced declaration of an exception variable
        catch (Bitmap bitmap)
        {
            Log.e(b, "OOM while creating bitmap 2");
            if (a)
            {
                a = false;
                throw new OutOfMemoryError(bitmap.getMessage());
            }
            bitmap = null;
        }
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static Bitmap a(InputStream inputstream)
    {
        return a(inputstream, ((Rect) (null)), ((android.graphics.BitmapFactory.Options) (null)), ((String) (null)));
    }

    public static Bitmap a(InputStream inputstream, Rect rect, android.graphics.BitmapFactory.Options options, String s)
    {
        rect = null;
        options = BitmapFactory.decodeStream(inputstream, null, null);
        inputstream = options;
_L2:
        if (inputstream != null)
        {
            a(inputstream.getRowBytes() * inputstream.getHeight());
            if (c)
            {
                (new StringBuilder("decodeStream from stream width:")).append(inputstream.getWidth()).append(" height:").append(inputstream.getHeight()).append(" memoryKB: ").append((float)d / 1024F);
            }
            b(inputstream, s);
        }
        a();
        return inputstream;
        options;
        Log.e(b, (new StringBuilder("OOM while decoding bitmap from stream memoryKB: ")).append((float)d / 1024F).toString());
        System.gc();
        try
        {
            inputstream = BitmapFactory.decodeStream(inputstream, null, null);
        }
        // Misplaced declaration of an exception variable
        catch (android.graphics.BitmapFactory.Options options)
        {
            Log.e(b, "OOM while creating bitmap 2");
            inputstream = rect;
            if (a)
            {
                a = false;
                throw new OutOfMemoryError(options.getMessage());
            }
        }
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static Bitmap a(String s)
    {
        return a(s, ((android.graphics.BitmapFactory.Options) (null)), ((String) (null)));
    }

    public static Bitmap a(String s, android.graphics.BitmapFactory.Options options)
    {
        return a(s, options, ((String) (null)));
    }

    public static Bitmap a(String s, android.graphics.BitmapFactory.Options options, String s1)
    {
        Bitmap bitmap = null;
        Bitmap bitmap1 = BitmapFactory.decodeFile(s, options);
        bitmap = bitmap1;
_L2:
        if (bitmap != null && (options == null || !options.inJustDecodeBounds))
        {
            a(bitmap.getRowBytes() * bitmap.getHeight());
            if (c)
            {
                (new StringBuilder("loadBitmap from path: ")).append(s).append(" width: ").append(bitmap.getWidth()).append(" memoryKB: ").append((float)d / 1024F).append(" height: ").append(bitmap.getHeight()).append(a(options));
            }
            b(bitmap, s1);
        }
        a();
        return bitmap;
        OutOfMemoryError outofmemoryerror;
        outofmemoryerror;
        Log.e(b, (new StringBuilder("OOM while loading bitmap path: ")).append(s).toString());
        System.gc();
        outofmemoryerror = BitmapFactory.decodeFile(s, options);
        bitmap = outofmemoryerror;
        continue; /* Loop/switch isn't completed */
        outofmemoryerror;
        Log.e(b, "OOM while creating bitmap 2");
        if (a)
        {
            a = false;
            throw new OutOfMemoryError(outofmemoryerror.getMessage());
        }
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static Bitmap a(byte abyte0[], int i)
    {
        return a(abyte0, 0, i, ((android.graphics.BitmapFactory.Options) (null)));
    }

    public static Bitmap a(byte abyte0[], int i, int j, android.graphics.BitmapFactory.Options options)
    {
        return a(abyte0, 0, j, options, ((String) (null)));
    }

    public static Bitmap a(byte abyte0[], int i, int j, android.graphics.BitmapFactory.Options options, String s)
    {
        Object obj = null;
        Bitmap bitmap = BitmapFactory.decodeByteArray(abyte0, i, j, options);
        abyte0 = bitmap;
_L2:
        if (abyte0 != null && (options == null || !options.inJustDecodeBounds))
        {
            a(abyte0.getRowBytes() * abyte0.getHeight());
            if (c)
            {
                (new StringBuilder("loadBitmap from byte array width: ")).append(abyte0.getWidth()).append(" memoryKB: ").append((float)d / 1024F).append(" height: ").append(abyte0.getHeight()).append(a(options));
            }
            b(abyte0, s);
        }
        a();
        return abyte0;
        OutOfMemoryError outofmemoryerror;
        outofmemoryerror;
        Log.e(b, "OOM while loading bitmap from bytearray");
        System.gc();
        try
        {
            abyte0 = BitmapFactory.decodeByteArray(abyte0, i, j, options);
        }
        catch (OutOfMemoryError outofmemoryerror1)
        {
            Log.e(b, "OOM while creating bitmap 2");
            abyte0 = obj;
            if (a)
            {
                a = false;
                throw new OutOfMemoryError(outofmemoryerror1.getMessage());
            }
        }
        if (true) goto _L2; else goto _L1
_L1:
    }

    private static String a(android.graphics.BitmapFactory.Options options)
    {
        String s = " opts is null";
        if (options != null)
        {
            s = (new StringBuilder(" inSampleSize:")).append(options.inSampleSize).append(" outWidth:").append(options.outWidth).append(" outHeight:").append(options.outHeight).append(" inDither:").append(options.inDither).append(" inJustDecodeBounds:").append(options.inJustDecodeBounds).append(" inPurgeable:").append(options.inPurgeable).append(" inPreferredConfig:").append(options.inPreferredConfig).append(" mCancel:").append(options.mCancel).toString();
        }
        return s;
    }

    public static void a()
    {
        if (android.os.Build.VERSION.SDK_INT < 10 && g)
        {
            ImageOpCommon.deallocMemory(c);
        }
    }

    private static void a(int i)
    {
        synchronized (f)
        {
            d += i;
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public static void a(Bitmap bitmap, String s, boolean flag)
    {
        if (bitmap == null)
        {
            break MISSING_BLOCK_LABEL_101;
        }
        Object obj = f;
        obj;
        JVM INSTR monitorenter ;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_88;
        }
        a(bitmap.getRowBytes() * bitmap.getHeight());
        if (c)
        {
            (new StringBuilder("creating bitmap width:")).append(bitmap.getWidth()).append(" height:").append(bitmap.getHeight()).append(" config:").append(bitmap.getConfig()).append(" memoryKB: ").append((float)d / 1024F);
        }
        b(bitmap, s);
        obj;
        JVM INSTR monitorexit ;
        return;
        bitmap;
        obj;
        JVM INSTR monitorexit ;
        throw bitmap;
    }

    public static boolean a(Bitmap bitmap)
    {
        return a(bitmap, ((String) (null)));
    }

    public static boolean a(Bitmap bitmap, String s)
    {
        if (bitmap == null)
        {
            if (!c);
        } else
        if (bitmap.isRecycled())
        {
            if (c)
            {
                return false;
            }
        } else
        {
            a(-(bitmap.getRowBytes() * bitmap.getHeight()));
            if (c)
            {
                (new StringBuilder("bmp is recycled width: ")).append(bitmap.getWidth()).append(" height: ").append(bitmap.getHeight()).append(" memoryKB: ").append((float)d / 1024F).append(" tag: ").append(s);
            }
            bitmap.recycle();
            return true;
        }
        return false;
    }

    private static Bitmap b(Bitmap bitmap, int i, int j, int k, int l, Matrix matrix, boolean flag)
    {
        Bitmap bitmap1 = Bitmap.createBitmap(bitmap, i, j, k, l, matrix, flag);
        bitmap = bitmap1;
_L2:
        if (bitmap != null)
        {
            a(bitmap.getRowBytes() * bitmap.getHeight());
            if (c)
            {
                (new StringBuilder("creating bitmap width:")).append(bitmap.getWidth()).append(" height:").append(bitmap.getHeight()).append(" config:").append(bitmap.getConfig()).append(" memoryKB: ").append((float)d / 1024F);
            }
            b(bitmap, ((String) (null)));
        }
        a();
        return bitmap;
        OutOfMemoryError outofmemoryerror;
        outofmemoryerror;
        Log.e(b, "OOM while creating bitmap");
        System.gc();
        try
        {
            bitmap = Bitmap.createBitmap(bitmap, i, j, k, l, matrix, flag);
        }
        // Misplaced declaration of an exception variable
        catch (Bitmap bitmap)
        {
            Log.e(b, "OOM while creating bitmap 2");
            if (a)
            {
                a = false;
                throw new OutOfMemoryError(bitmap.getMessage());
            }
            bitmap = null;
        }
        if (true) goto _L2; else goto _L1
_L1:
    }

    private static Bitmap b(Bitmap bitmap, int i, int j, boolean flag)
    {
        Bitmap bitmap1 = Bitmap.createScaledBitmap(bitmap, i, j, flag);
        bitmap = bitmap1;
_L2:
        if (bitmap != null)
        {
            a(bitmap.getRowBytes() * bitmap.getHeight());
            if (c)
            {
                (new StringBuilder("creating bitmap width:")).append(bitmap.getWidth()).append(" height:").append(bitmap.getHeight()).append(" config:").append(bitmap.getConfig()).append(" memoryKB: ").append((float)d / 1024F);
            }
            b(bitmap, ((String) (null)));
        }
        a();
        return bitmap;
        OutOfMemoryError outofmemoryerror;
        outofmemoryerror;
        Log.e(b, "OOM while creating bitmap");
        System.gc();
        try
        {
            bitmap = Bitmap.createScaledBitmap(bitmap, i, j, flag);
        }
        // Misplaced declaration of an exception variable
        catch (Bitmap bitmap)
        {
            Log.e(b, "OOM while creating bitmap 2");
            if (a)
            {
                a = false;
                throw new OutOfMemoryError(bitmap.getMessage());
            }
            bitmap = null;
        }
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static Bitmap b(Bitmap bitmap, android.graphics.Bitmap.Config config)
    {
        return a(bitmap, config, true);
    }

    private static void b(Bitmap bitmap, String s)
    {
label0:
        {
            if (s != null)
            {
                ArrayList arraylist = (ArrayList)e.get(s);
                if (arraylist == null)
                {
                    break label0;
                }
                arraylist.add(new WeakReference(bitmap));
            }
            return;
        }
        ArrayList arraylist1 = new ArrayList();
        arraylist1.add(new WeakReference(bitmap));
        e.put(s, arraylist1);
    }

    public static void b(String s)
    {
        Object obj = (ArrayList)e.get(s);
        if (obj != null)
        {
            if (c)
            {
                (new StringBuilder("recycleByTag , bitmaps size:")).append(((ArrayList) (obj)).size());
            }
            obj = ((ArrayList) (obj)).iterator();
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break;
                }
                WeakReference weakreference = (WeakReference)((Iterator) (obj)).next();
                if (weakreference != null)
                {
                    a((Bitmap)weakreference.get(), s);
                }
            } while (true);
            e.remove(s);
        }
    }

    static 
    {
        c = d.b;
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.DisplayMetrics;
import android.util.Log;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.c;
import com.bumptech.glide.load.e;
import com.bumptech.glide.load.engine.ad;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Queue;
import java.util.Set;
import myobfuscated.aj.j;
import myobfuscated.f.m;
import myobfuscated.s.g;

// Referenced classes of package com.bumptech.glide.load.resource.bitmap:
//            DownsampleStrategy, ImageHeaderParser, q, z, 
//            e

public final class p
{

    public static final c a;
    public static final c b;
    static final q c = new q() {

        public final void a()
        {
        }

        public final void a(g g1, Bitmap bitmap)
        {
        }

    };
    private static final Set d;
    private static final Queue e = j.a(0);
    private final g f;
    private final DisplayMetrics g;
    private final myobfuscated.s.j h;

    public p(DisplayMetrics displaymetrics, g g1, myobfuscated.s.j j1)
    {
        g = (DisplayMetrics)m.a(displaymetrics, "Argument must not be null");
        f = (g)m.a(g1, "Argument must not be null");
        h = (myobfuscated.s.j)m.a(j1, "Argument must not be null");
    }

    private int a(InputStream inputstream)
    {
        inputstream.mark(0x500000);
        int i = (new ImageHeaderParser(inputstream, h)).b();
        inputstream.reset();
        return i;
        Object obj;
        obj;
        Log.isLoggable("Downsampler", 3);
        inputstream.reset();
        return -1;
        obj;
        inputstream.reset();
        throw obj;
    }

    private android.graphics.Bitmap.Config a(InputStream inputstream, DecodeFormat decodeformat)
    {
        boolean flag;
        if (decodeformat == DecodeFormat.PREFER_ARGB_8888 || android.os.Build.VERSION.SDK_INT == 16)
        {
            return android.graphics.Bitmap.Config.ARGB_8888;
        }
        flag = false;
        inputstream.mark(0x500000);
        boolean flag1 = (new ImageHeaderParser(inputstream, h)).a().hasAlpha();
        flag = flag1;
        inputstream.reset();
_L1:
        IOException ioexception;
        if (flag)
        {
            return android.graphics.Bitmap.Config.ARGB_8888;
        } else
        {
            return android.graphics.Bitmap.Config.RGB_565;
        }
        ioexception;
        if (Log.isLoggable("Downsampler", 3))
        {
            (new StringBuilder("Cannot determine whether the image has alpha or not from header, format ")).append(decodeformat);
        }
        inputstream.reset();
          goto _L1
        decodeformat;
        inputstream.reset();
        throw decodeformat;
    }

    private static Bitmap a(InputStream inputstream, android.graphics.BitmapFactory.Options options, q q1)
    {
        Bitmap bitmap;
        int i;
        int k;
        if (options.inJustDecodeBounds)
        {
            inputstream.mark(0x500000);
        } else
        {
            q1.a();
        }
        i = options.outWidth;
        k = options.outHeight;
        q1 = options.outMimeType;
        try
        {
            bitmap = BitmapFactory.decodeStream(inputstream, null, options);
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            throw new IOException((new StringBuilder("Exception decoding bitmap, outWidth: ")).append(i).append(", outHeight: ").append(k).append(", outMimeType: ").append(q1).append(", inBitmap: ").append(b(options)).toString(), inputstream);
        }
        if (options.inJustDecodeBounds)
        {
            inputstream.reset();
        }
        return bitmap;
    }

    private static String a(Bitmap bitmap)
    {
        if (bitmap == null)
        {
            return null;
        }
        String s;
        if (android.os.Build.VERSION.SDK_INT >= 19)
        {
            s = (new StringBuilder(" (")).append(bitmap.getAllocationByteCount()).append(")").toString();
        } else
        {
            s = "";
        }
        return (new StringBuilder("[")).append(bitmap.getWidth()).append("x").append(bitmap.getHeight()).append("] ").append(bitmap.getConfig()).append(s).toString();
    }

    public static boolean a()
    {
        return true;
    }

    private static boolean a(android.graphics.BitmapFactory.Options options)
    {
        return options.inTargetDensity > 0 && options.inDensity > 0 && options.inTargetDensity != options.inDensity;
    }

    private static String b(android.graphics.BitmapFactory.Options options)
    {
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            return a(options.inBitmap);
        } else
        {
            return null;
        }
    }

    public static boolean b()
    {
        return true;
    }

    private boolean b(InputStream inputstream)
    {
        if (android.os.Build.VERSION.SDK_INT >= 19)
        {
            return true;
        }
        inputstream.mark(0x500000);
        boolean flag;
        ImageHeaderParser.ImageType imagetype = (new ImageHeaderParser(inputstream, h)).a();
        flag = d.contains(imagetype);
        inputstream.reset();
        return flag;
        Object obj;
        obj;
        Log.isLoggable("Downsampler", 3);
        inputstream.reset();
        return false;
        obj;
        inputstream.reset();
        throw obj;
    }

    private static android.graphics.BitmapFactory.Options c()
    {
        com/bumptech/glide/load/resource/bitmap/p;
        JVM INSTR monitorenter ;
        android.graphics.BitmapFactory.Options options;
        synchronized (e)
        {
            options = (android.graphics.BitmapFactory.Options)e.poll();
        }
        obj = options;
        if (options != null)
        {
            break MISSING_BLOCK_LABEL_41;
        }
        obj = new android.graphics.BitmapFactory.Options();
        d(((android.graphics.BitmapFactory.Options) (obj)));
        com/bumptech/glide/load/resource/bitmap/p;
        JVM INSTR monitorexit ;
        return ((android.graphics.BitmapFactory.Options) (obj));
        exception1;
        obj;
        JVM INSTR monitorexit ;
        throw exception1;
        Exception exception;
        exception;
        com/bumptech/glide/load/resource/bitmap/p;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private static void c(android.graphics.BitmapFactory.Options options)
    {
        d(options);
        synchronized (e)
        {
            e.offer(options);
        }
        return;
        options;
        queue;
        JVM INSTR monitorexit ;
        throw options;
    }

    private static void d(android.graphics.BitmapFactory.Options options)
    {
        options.inTempStorage = null;
        options.inDither = false;
        options.inScaled = false;
        options.inSampleSize = 1;
        options.inPreferredConfig = null;
        options.inJustDecodeBounds = false;
        options.inDensity = 0;
        options.inTargetDensity = 0;
        options.outWidth = 0;
        options.outHeight = 0;
        options.outMimeType = null;
        if (11 <= android.os.Build.VERSION.SDK_INT)
        {
            options.inBitmap = null;
            options.inMutable = true;
        }
    }

    public final ad a(InputStream inputstream, int i, int k, e e1, q q1)
    {
        byte abyte0[];
        android.graphics.BitmapFactory.Options options;
        Object obj;
        Object obj1;
        if (!inputstream.markSupported())
        {
            throw new IllegalArgumentException("You must provide an InputStream that supports mark()");
        }
        abyte0 = h.a(0x10000);
        options = c();
        options.inTempStorage = abyte0;
        obj = (DecodeFormat)e1.a(a);
        obj1 = (DownsampleStrategy)e1.a(b);
        options.inJustDecodeBounds = true;
        a(inputstream, options, q1);
        options.inJustDecodeBounds = false;
        e1 = new int[2];
        e1[0] = options.outWidth;
        e1[1] = options.outHeight;
        int l1;
        int i2;
        l1 = e1[0];
        i2 = e1[1];
        int k1;
        int k2;
        e1 = options.outMimeType;
        k2 = a(inputstream);
        k1 = z.a(a(inputstream));
        options.inPreferredConfig = a(inputstream, ((DecodeFormat) (obj)));
        if (options.inPreferredConfig != android.graphics.Bitmap.Config.ARGB_8888)
        {
            options.inDither = true;
        }
          goto _L1
_L13:
        obj = f;
        if (options.inSampleSize != 1 && 19 > android.os.Build.VERSION.SDK_INT || !b(inputstream)) goto _L3; else goto _L2
_L2:
        if (!a(options)) goto _L5; else goto _L4
_L4:
        float f1 = (float)options.inTargetDensity / (float)options.inDensity;
_L12:
        int j1;
        int l = options.inSampleSize;
        k1 = (int)Math.ceil((float)l1 / (float)l);
        j1 = (int)Math.ceil((float)i2 / (float)l);
        k1 = Math.round((float)k1 * f1);
        j1 = Math.round((float)j1 * f1);
        if (Log.isLoggable("Downsampler", 2))
        {
            (new StringBuilder("Calculated target [")).append(k1).append("x").append(j1).append("] for source [").append(l1).append("x").append(i2).append("], sampleSize: ").append(l).append(", targetDensity: ").append(options.inTargetDensity).append(", density: ").append(options.inDensity).append(", density multiplier: ").append(f1);
        }
        if (k1 <= 0 || j1 <= 0) goto _L3; else goto _L6
_L6:
        obj1 = options.inPreferredConfig;
        if (11 <= android.os.Build.VERSION.SDK_INT)
        {
            options.inBitmap = ((g) (obj)).b(k1, j1, ((android.graphics.Bitmap.Config) (obj1)));
        }
_L3:
        obj = a(inputstream, options, q1);
        q1.a(f, ((Bitmap) (obj)));
        if (Log.isLoggable("Downsampler", 2))
        {
            (new StringBuilder("Decoded ")).append(a(((Bitmap) (obj)))).append(" from [").append(l1).append("x").append(i2).append("] ").append(e1).append(" with inBitmap ").append(b(options)).append(" for [").append(i).append("x").append(k).append("], sample size: ").append(options.inSampleSize).append(", density: ").append(options.inDensity).append(", target density: ").append(options.inTargetDensity).append(", thread: ").append(Thread.currentThread().getName());
        }
        inputstream = null;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_671;
        }
        ((Bitmap) (obj)).setDensity(g.densityDpi);
        e1 = z.a(f, ((Bitmap) (obj)), k2);
        inputstream = e1;
        if (obj.equals(e1))
        {
            break MISSING_BLOCK_LABEL_671;
        }
        f.a(((Bitmap) (obj)));
        inputstream = e1;
        inputstream = com.bumptech.glide.load.resource.bitmap.e.a(inputstream, f);
        c(options);
        h.a(abyte0);
        return inputstream;
_L14:
        int i1;
        if (k == 0x80000000)
        {
            i1 = i2;
        } else
        {
            i1 = k;
        }
        if (i == 0x80000000)
        {
            j1 = l1;
        } else
        {
            j1 = i;
        }
        if (k1 != 90 && k1 != 270)
        {
            break MISSING_BLOCK_LABEL_821;
        }
        f1 = ((DownsampleStrategy) (obj1)).a(i2, l1, j1, i1);
_L7:
        if (f1 > 0.0F)
        {
            break MISSING_BLOCK_LABEL_839;
        }
        throw new IllegalArgumentException((new StringBuilder("Cannot scale with factor: ")).append(f1).append(" from: ").append(obj1).toString());
        inputstream;
        c(options);
        h.a(abyte0);
        throw inputstream;
        f1 = ((DownsampleStrategy) (obj1)).a(l1, i2, j1, i1);
          goto _L7
        obj = ((DownsampleStrategy) (obj1)).a();
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_862;
        }
        throw new IllegalArgumentException("Cannot round with null rounding");
        int j2;
        j2 = (int)((float)l1 * f1 + 0.5F);
        k1 = (int)((float)i2 * f1 + 0.5F);
        j2 = l1 / j2;
        k1 = i2 / k1;
        if (obj != DownsampleStrategy.SampleSizeRounding.MEMORY) goto _L9; else goto _L8
_L8:
        k1 = Math.max(j2, k1);
_L10:
        j2 = Math.max(1, Integer.highestOneBit(k1));
        k1 = j2;
        if (obj != DownsampleStrategy.SampleSizeRounding.MEMORY)
        {
            break MISSING_BLOCK_LABEL_963;
        }
        k1 = j2;
        if ((float)j2 < 1.0F / f1)
        {
            k1 = j2 << 1;
        }
        float f2 = (float)k1 * f1;
        options.inSampleSize = k1;
        if (android.os.Build.VERSION.SDK_INT >= 19)
        {
            options.inTargetDensity = (int)(1000F * f2 + 0.5F);
            options.inDensity = 1000;
        }
        if (!a(options))
        {
            break MISSING_BLOCK_LABEL_1156;
        }
        options.inScaled = true;
_L11:
        if (!Log.isLoggable("Downsampler", 2))
        {
            break; /* Loop/switch isn't completed */
        }
        (new StringBuilder("Calculate scaling, source: [")).append(l1).append("x").append(i2).append("], target: [").append(j1).append("x").append(i1).append("], exact scale factor: ").append(f1).append(", power of 2 sample size: ").append(k1).append(", adjusted scale factor: ").append(f2).append(", target density: ").append(options.inTargetDensity).append(", density: ").append(options.inDensity);
        break; /* Loop/switch isn't completed */
_L9:
        k1 = Math.min(j2, k1);
          goto _L10
        options.inTargetDensity = 0;
        options.inDensity = 0;
          goto _L11
_L5:
        f1 = 1.0F;
          goto _L12
_L1:
        if (l1 > 0 && i2 > 0) goto _L14; else goto _L13
    }

    static 
    {
        a = com.bumptech.glide.load.c.a("com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeFormat", DecodeFormat.DEFAULT);
        b = com.bumptech.glide.load.c.a("com.bumptech.glide.load.resource.bitmap.Downsampler.DownsampleStrategy", com.bumptech.glide.load.resource.bitmap.DownsampleStrategy.c);
        d = Collections.unmodifiableSet(EnumSet.of(ImageHeaderParser.ImageType.JPEG, ImageHeaderParser.ImageType.PNG_A, ImageHeaderParser.ImageType.PNG));
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.ByteArrayPool;
import com.bumptech.glide.util.ExceptionCatchingInputStream;
import com.bumptech.glide.util.MarkEnforcingInputStream;
import com.bumptech.glide.util.Util;
import java.io.IOException;
import java.io.InputStream;
import java.util.EnumSet;
import java.util.Queue;
import java.util.Set;

// Referenced classes of package com.bumptech.glide.load.resource.bitmap:
//            BitmapDecoder, RecyclableBufferedInputStream, ImageHeaderParser, TransformationUtils

public abstract class Downsampler
    implements BitmapDecoder
{

    public static final Downsampler AT_LEAST = new Downsampler() {

        public String getId()
        {
            return "AT_LEAST.com.bumptech.glide.load.data.bitmap";
        }

        protected int getSampleSize(int i, int j, int k, int l)
        {
            return Math.min(j / l, i / k);
        }

    };
    public static final Downsampler AT_MOST = new Downsampler() {

        public String getId()
        {
            return "AT_MOST.com.bumptech.glide.load.data.bitmap";
        }

        protected int getSampleSize(int i, int j, int k, int l)
        {
            return Math.max(j / l, i / k);
        }

    };
    public static final Downsampler NONE = new Downsampler() {

        public String getId()
        {
            return "NONE.com.bumptech.glide.load.data.bitmap";
        }

        protected int getSampleSize(int i, int j, int k, int l)
        {
            return 0;
        }

    };
    private static final Queue OPTIONS_QUEUE = Util.createQueue(0);
    private static final Set TYPES_THAT_USE_POOL;

    public Downsampler()
    {
    }

    private static Bitmap decodeStream(MarkEnforcingInputStream markenforcinginputstream, RecyclableBufferedInputStream recyclablebufferedinputstream, android.graphics.BitmapFactory.Options options)
    {
        if (options.inJustDecodeBounds)
        {
            markenforcinginputstream.mark(0x500000);
        } else
        {
            recyclablebufferedinputstream.fixMarkLimit();
        }
        recyclablebufferedinputstream = BitmapFactory.decodeStream(markenforcinginputstream, null, options);
        try
        {
            if (options.inJustDecodeBounds)
            {
                markenforcinginputstream.reset();
            }
        }
        // Misplaced declaration of an exception variable
        catch (MarkEnforcingInputStream markenforcinginputstream)
        {
            if (Log.isLoggable("Downsampler", 6))
            {
                Log.e("Downsampler", (new StringBuilder()).append("Exception loading inDecodeBounds=").append(options.inJustDecodeBounds).append(" sample=").append(options.inSampleSize).toString(), markenforcinginputstream);
                return recyclablebufferedinputstream;
            }
        }
        return recyclablebufferedinputstream;
    }

    private Bitmap downsampleWithSize(MarkEnforcingInputStream markenforcinginputstream, RecyclableBufferedInputStream recyclablebufferedinputstream, android.graphics.BitmapFactory.Options options, BitmapPool bitmappool, int i, int j, int k, 
            DecodeFormat decodeformat)
    {
        decodeformat = getConfig(markenforcinginputstream, decodeformat);
        options.inSampleSize = k;
        options.inPreferredConfig = decodeformat;
        if ((options.inSampleSize == 1 || 19 <= android.os.Build.VERSION.SDK_INT) && shouldUsePool(markenforcinginputstream))
        {
            setInBitmap(options, bitmappool.getDirty((int)Math.ceil((double)i / (double)k), (int)Math.ceil((double)j / (double)k), decodeformat));
        }
        return decodeStream(markenforcinginputstream, recyclablebufferedinputstream, options);
    }

    private static android.graphics.Bitmap.Config getConfig(InputStream inputstream, DecodeFormat decodeformat)
    {
        boolean flag1;
        if (decodeformat == DecodeFormat.ALWAYS_ARGB_8888 || decodeformat == DecodeFormat.PREFER_ARGB_8888 || android.os.Build.VERSION.SDK_INT == 16)
        {
            return android.graphics.Bitmap.Config.ARGB_8888;
        }
        flag1 = false;
        inputstream.mark(1024);
        boolean flag = (new ImageHeaderParser(inputstream)).hasAlpha();
        flag1 = flag;
        inputstream.reset();
        flag = flag1;
_L1:
        IOException ioexception;
        if (flag)
        {
            return android.graphics.Bitmap.Config.ARGB_8888;
        } else
        {
            return android.graphics.Bitmap.Config.RGB_565;
        }
        inputstream;
        flag = flag1;
        if (Log.isLoggable("Downsampler", 5))
        {
            Log.w("Downsampler", "Cannot reset the input stream", inputstream);
            flag = flag1;
        }
          goto _L1
        ioexception;
        if (Log.isLoggable("Downsampler", 5))
        {
            Log.w("Downsampler", (new StringBuilder()).append("Cannot determine whether the image has alpha or not from header for format ").append(decodeformat).toString(), ioexception);
        }
        inputstream.reset();
        flag = flag1;
          goto _L1
        inputstream;
        flag = flag1;
        if (Log.isLoggable("Downsampler", 5))
        {
            Log.w("Downsampler", "Cannot reset the input stream", inputstream);
            flag = flag1;
        }
          goto _L1
        decodeformat;
        inputstream.reset();
_L3:
        throw decodeformat;
        inputstream;
        if (Log.isLoggable("Downsampler", 5))
        {
            Log.w("Downsampler", "Cannot reset the input stream", inputstream);
        }
        if (true) goto _L3; else goto _L2
_L2:
    }

    private static android.graphics.BitmapFactory.Options getDefaultOptions()
    {
        com/bumptech/glide/load/resource/bitmap/Downsampler;
        JVM INSTR monitorenter ;
        android.graphics.BitmapFactory.Options options;
        synchronized (OPTIONS_QUEUE)
        {
            options = (android.graphics.BitmapFactory.Options)OPTIONS_QUEUE.poll();
        }
        obj = options;
        if (options != null)
        {
            break MISSING_BLOCK_LABEL_41;
        }
        obj = new android.graphics.BitmapFactory.Options();
        resetOptions(((android.graphics.BitmapFactory.Options) (obj)));
        com/bumptech/glide/load/resource/bitmap/Downsampler;
        JVM INSTR monitorexit ;
        return ((android.graphics.BitmapFactory.Options) (obj));
        exception1;
        obj;
        JVM INSTR monitorexit ;
        throw exception1;
        Exception exception;
        exception;
        com/bumptech/glide/load/resource/bitmap/Downsampler;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private int getRoundedSampleSize(int i, int j, int k, int l, int i1)
    {
        if (i1 == 0x80000000)
        {
            i1 = k;
        }
        if (l == 0x80000000)
        {
            l = j;
        }
        if (i == 90 || i == 270)
        {
            i = getSampleSize(k, j, l, i1);
        } else
        {
            i = getSampleSize(j, k, l, i1);
        }
        if (i == 0)
        {
            i = 0;
        } else
        {
            i = Integer.highestOneBit(i);
        }
        return Math.max(1, i);
    }

    private static void releaseOptions(android.graphics.BitmapFactory.Options options)
    {
        resetOptions(options);
        synchronized (OPTIONS_QUEUE)
        {
            OPTIONS_QUEUE.offer(options);
        }
        return;
        options;
        queue;
        JVM INSTR monitorexit ;
        throw options;
    }

    private static void resetOptions(android.graphics.BitmapFactory.Options options)
    {
        options.inTempStorage = null;
        options.inDither = false;
        options.inScaled = false;
        options.inSampleSize = 1;
        options.inPreferredConfig = null;
        options.inJustDecodeBounds = false;
        options.outWidth = 0;
        options.outHeight = 0;
        options.outMimeType = null;
        if (11 <= android.os.Build.VERSION.SDK_INT)
        {
            options.inBitmap = null;
            options.inMutable = true;
        }
    }

    private static void setInBitmap(android.graphics.BitmapFactory.Options options, Bitmap bitmap)
    {
        if (11 <= android.os.Build.VERSION.SDK_INT)
        {
            options.inBitmap = bitmap;
        }
    }

    private static boolean shouldUsePool(InputStream inputstream)
    {
        if (19 > android.os.Build.VERSION.SDK_INT) goto _L2; else goto _L1
_L1:
        boolean flag = true;
_L4:
        return flag;
_L2:
        inputstream.mark(1024);
        boolean flag1;
        ImageHeaderParser.ImageType imagetype = (new ImageHeaderParser(inputstream)).getType();
        flag1 = TYPES_THAT_USE_POOL.contains(imagetype);
        inputstream.reset();
        return flag1;
        inputstream;
        flag = flag1;
        if (Log.isLoggable("Downsampler", 5))
        {
            Log.w("Downsampler", "Cannot reset the input stream", inputstream);
            return flag1;
        }
        if (true) goto _L4; else goto _L3
_L3:
        Object obj;
        obj;
        if (Log.isLoggable("Downsampler", 5))
        {
            Log.w("Downsampler", "Cannot determine the image type from header", ((Throwable) (obj)));
        }
        inputstream.reset();
_L6:
        return false;
        inputstream;
        if (Log.isLoggable("Downsampler", 5))
        {
            Log.w("Downsampler", "Cannot reset the input stream", inputstream);
        }
        if (true) goto _L6; else goto _L5
_L5:
        obj;
        inputstream.reset();
_L8:
        throw obj;
        inputstream;
        if (Log.isLoggable("Downsampler", 5))
        {
            Log.w("Downsampler", "Cannot reset the input stream", inputstream);
        }
        if (true) goto _L8; else goto _L7
_L7:
    }

    public Bitmap decode(InputStream inputstream, BitmapPool bitmappool, int i, int j, DecodeFormat decodeformat)
    {
        ByteArrayPool bytearraypool;
        byte abyte0[];
        byte abyte1[];
        android.graphics.BitmapFactory.Options options;
        ExceptionCatchingInputStream exceptioncatchinginputstream;
        Object obj;
        bytearraypool = ByteArrayPool.get();
        abyte0 = bytearraypool.getBytes();
        abyte1 = bytearraypool.getBytes();
        options = getDefaultOptions();
        inputstream = new RecyclableBufferedInputStream(inputstream, abyte1);
        exceptioncatchinginputstream = ExceptionCatchingInputStream.obtain(inputstream);
        obj = new MarkEnforcingInputStream(exceptioncatchinginputstream);
        exceptioncatchinginputstream.mark(0x500000);
        int l = 0;
        int k = (new ImageHeaderParser(exceptioncatchinginputstream)).getOrientation();
        l = k;
        exceptioncatchinginputstream.reset();
        k = l;
_L2:
        int ai[];
        options.inTempStorage = abyte0;
        ai = getDimensions(((MarkEnforcingInputStream) (obj)), inputstream, options);
        int i1;
        l = ai[0];
        i1 = ai[1];
        obj = downsampleWithSize(((MarkEnforcingInputStream) (obj)), inputstream, options, bitmappool, l, i1, getRoundedSampleSize(TransformationUtils.getExifOrientationDegrees(k), l, i1, i, j), decodeformat);
        inputstream = exceptioncatchinginputstream.getException();
        if (inputstream == null)
        {
            break; /* Loop/switch isn't completed */
        }
        throw new RuntimeException(inputstream);
        inputstream;
        bytearraypool.releaseBytes(abyte0);
        bytearraypool.releaseBytes(abyte1);
        exceptioncatchinginputstream.release();
        releaseOptions(options);
        throw inputstream;
        IOException ioexception;
        ioexception;
        k = l;
        if (!Log.isLoggable("Downsampler", 5))
        {
            continue; /* Loop/switch isn't completed */
        }
        Log.w("Downsampler", "Cannot reset the input stream", ioexception);
        k = l;
        continue; /* Loop/switch isn't completed */
        ioexception;
        if (Log.isLoggable("Downsampler", 5))
        {
            Log.w("Downsampler", "Cannot determine the image orientation from header", ioexception);
        }
        exceptioncatchinginputstream.reset();
        k = l;
        continue; /* Loop/switch isn't completed */
        ioexception;
        k = l;
        if (!Log.isLoggable("Downsampler", 5))
        {
            continue; /* Loop/switch isn't completed */
        }
        Log.w("Downsampler", "Cannot reset the input stream", ioexception);
        k = l;
        if (true) goto _L2; else goto _L1
        inputstream;
        exceptioncatchinginputstream.reset();
_L4:
        throw inputstream;
        bitmappool;
        if (!Log.isLoggable("Downsampler", 5)) goto _L4; else goto _L3
_L3:
        Log.w("Downsampler", "Cannot reset the input stream", bitmappool);
          goto _L4
_L1:
        inputstream = null;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_381;
        }
        decodeformat = TransformationUtils.rotateImageExif(((Bitmap) (obj)), bitmappool, k);
        inputstream = decodeformat;
        if (obj.equals(decodeformat))
        {
            break MISSING_BLOCK_LABEL_381;
        }
        inputstream = decodeformat;
        if (bitmappool.put(((Bitmap) (obj))))
        {
            break MISSING_BLOCK_LABEL_381;
        }
        ((Bitmap) (obj)).recycle();
        inputstream = decodeformat;
        bytearraypool.releaseBytes(abyte0);
        bytearraypool.releaseBytes(abyte1);
        exceptioncatchinginputstream.release();
        releaseOptions(options);
        return inputstream;
    }

    public int[] getDimensions(MarkEnforcingInputStream markenforcinginputstream, RecyclableBufferedInputStream recyclablebufferedinputstream, android.graphics.BitmapFactory.Options options)
    {
        options.inJustDecodeBounds = true;
        decodeStream(markenforcinginputstream, recyclablebufferedinputstream, options);
        options.inJustDecodeBounds = false;
        return (new int[] {
            options.outWidth, options.outHeight
        });
    }

    protected abstract int getSampleSize(int i, int j, int k, int l);

    static 
    {
        TYPES_THAT_USE_POOL = EnumSet.of(ImageHeaderParser.ImageType.JPEG, ImageHeaderParser.ImageType.PNG_A, ImageHeaderParser.ImageType.PNG);
    }
}

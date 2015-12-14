// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.aj;

import android.graphics.Bitmap;
import android.os.Looper;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

public final class j
{

    private static final char a[] = "0123456789abcdef".toCharArray();
    private static final char b[] = new char[64];

    public static int a(int i, int k, android.graphics.Bitmap.Config config)
    {
        android.graphics.Bitmap.Config config1;
        config1 = config;
        if (config == null)
        {
            config1 = android.graphics.Bitmap.Config.ARGB_8888;
        }
        final class _cls1
        {

            static final int a[];

            static 
            {
                a = new int[android.graphics.Bitmap.Config.values().length];
                try
                {
                    a[android.graphics.Bitmap.Config.ALPHA_8.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    a[android.graphics.Bitmap.Config.RGB_565.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[android.graphics.Bitmap.Config.ARGB_4444.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[android.graphics.Bitmap.Config.ARGB_8888.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1.a[config1.ordinal()];
        JVM INSTR tableswitch 1 3: default 44
    //                   1 54
    //                   2 60
    //                   3 60;
           goto _L1 _L2 _L3 _L3
_L1:
        byte byte0 = 4;
_L5:
        return byte0 * (i * k);
_L2:
        byte0 = 1;
        continue; /* Loop/switch isn't completed */
_L3:
        byte0 = 2;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public static int a(Bitmap bitmap)
    {
        if (bitmap.isRecycled())
        {
            throw new IllegalStateException((new StringBuilder("Cannot obtain size for recycled Bitmap: ")).append(bitmap).append("[").append(bitmap.getWidth()).append("x").append(bitmap.getHeight()).append("] ").append(bitmap.getConfig()).toString());
        }
        if (android.os.Build.VERSION.SDK_INT < 19)
        {
            break MISSING_BLOCK_LABEL_83;
        }
        int i = bitmap.getAllocationByteCount();
        return i;
        NullPointerException nullpointerexception;
        nullpointerexception;
        return bitmap.getHeight() * bitmap.getRowBytes();
    }

    public static String a(byte abyte0[])
    {
        char ac[] = b;
        ac;
        JVM INSTR monitorenter ;
        char ac1[] = b;
        int i = 0;
_L2:
        if (i >= abyte0.length)
        {
            break; /* Loop/switch isn't completed */
        }
        int k = abyte0[i] & 0xff;
        ac1[i * 2] = a[k >>> 4];
        ac1[i * 2 + 1] = a[k & 0xf];
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        abyte0 = new String(ac1);
        ac;
        JVM INSTR monitorexit ;
        return abyte0;
        abyte0;
        ac;
        JVM INSTR monitorexit ;
        throw abyte0;
    }

    public static List a(Collection collection)
    {
        ArrayList arraylist = new ArrayList(collection.size());
        for (collection = collection.iterator(); collection.hasNext(); arraylist.add(collection.next())) { }
        return arraylist;
    }

    public static Queue a(int i)
    {
        return new ArrayDeque(i);
    }

    public static void a()
    {
        if (!b())
        {
            throw new IllegalArgumentException("You must call this method on the main thread");
        } else
        {
            return;
        }
    }

    public static boolean a(int i, int k)
    {
        return b(i) && b(k);
    }

    public static boolean b()
    {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    private static boolean b(int i)
    {
        return i > 0 || i == 0x80000000;
    }

    public static boolean c()
    {
        return !b();
    }

}

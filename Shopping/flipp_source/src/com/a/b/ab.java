// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.b;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.NetworkInfo;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package com.a.b:
//            d, ao, y, s, 
//            t, aj, ba, ad, 
//            n, h, as, a

final class ab extends d
{

    int o;
    private final s p;

    public ab(ad ad, n n, h h, as as, a a1, s s1)
    {
        super(ad, n, h, as, a1);
        p = s1;
        o = 2;
    }

    private static Bitmap a(InputStream inputstream, ao ao1)
    {
        if (inputstream != null) goto _L2; else goto _L1
_L1:
        return null;
_L2:
        Bitmap bitmap;
        bitmap = (Bitmap)ao1.l.get();
        if (android.os.Build.VERSION.SDK_INT < 11 || bitmap == null)
        {
            break MISSING_BLOCK_LABEL_165;
        }
        if (ao1.n != ao1.o.get()) goto _L1; else goto _L3
_L3:
        synchronized (ao1.o)
        {
            if (ao1.n == ao1.o.get())
            {
                break MISSING_BLOCK_LABEL_73;
            }
        }
        return null;
        inputstream;
        atomicinteger;
        JVM INSTR monitorexit ;
        throw inputstream;
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        a(bitmap.getWidth(), bitmap.getHeight(), options);
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            options.inBitmap = bitmap;
            options.inMutable = true;
            options.inPreferredConfig = bitmap.getConfig();
            if (android.os.Build.VERSION.SDK_INT <= 19)
            {
                options.inSampleSize = 1;
            }
        }
        options.inTempStorage = (byte[])ao1.m.get();
        inputstream = BitmapFactory.decodeStream(inputstream, null, options);
        atomicinteger;
        JVM INSTR monitorexit ;
        return inputstream;
        y y1 = new y(inputstream);
        long l = y1.a(0x10000);
        if (ao1.a())
        {
            inputstream = new android.graphics.BitmapFactory.Options();
            inputstream.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(y1, null, inputstream);
            a(ao1.d, ao1.e, ((android.graphics.BitmapFactory.Options) (inputstream)));
            y1.a(l);
        } else
        {
            inputstream = null;
        }
        return BitmapFactory.decodeStream(y1, null, inputstream);
    }

    final Bitmap a(ao ao1)
    {
        Object obj;
        t t1;
        boolean flag;
        if (o == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        t1 = p.a(ao1.a, flag);
        if (t1.c)
        {
            obj = aj.b;
        } else
        {
            obj = aj.c;
        }
        l = ((aj) (obj));
        obj = t1.b;
        if (obj != null)
        {
            return ((Bitmap) (obj));
        }
        obj = t1.a;
        ao1 = a(((InputStream) (obj)), ao1);
        ba.a(((InputStream) (obj)));
        return ao1;
        ao1;
        ba.a(((InputStream) (obj)));
        throw ao1;
    }

    final boolean a(NetworkInfo networkinfo)
    {
        boolean flag;
        if (o > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            o = o - 1;
            if (networkinfo == null || networkinfo.isConnectedOrConnecting())
            {
                return true;
            }
        }
        return false;
    }
}

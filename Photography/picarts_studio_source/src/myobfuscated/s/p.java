// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.s;

import android.graphics.Bitmap;
import android.util.Log;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

// Referenced classes of package myobfuscated.s:
//            g, t, c, q, 
//            r

public final class p
    implements g
{

    private static final android.graphics.Bitmap.Config a;
    private final r b;
    private final Set c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;

    public p(int j)
    {
        Object obj;
        HashSet hashset;
        if (android.os.Build.VERSION.SDK_INT >= 19)
        {
            obj = new t();
        } else
        {
            obj = new c();
        }
        hashset = new HashSet();
        hashset.addAll(Arrays.asList(android.graphics.Bitmap.Config.values()));
        if (android.os.Build.VERSION.SDK_INT >= 19)
        {
            hashset.add(null);
        }
        this(j, ((r) (obj)), Collections.unmodifiableSet(hashset));
    }

    private p(int j, r r1, Set set)
    {
        d = j;
        b = r1;
        c = set;
        new q((byte)0);
    }

    private void b()
    {
        if (Log.isLoggable("LruBitmapPool", 2))
        {
            c();
        }
    }

    private void b(int j)
    {
        this;
        JVM INSTR monitorenter ;
_L2:
        Bitmap bitmap;
        if (e <= j)
        {
            break MISSING_BLOCK_LABEL_50;
        }
        bitmap = b.a();
        if (bitmap != null)
        {
            break MISSING_BLOCK_LABEL_53;
        }
        if (Log.isLoggable("LruBitmapPool", 5))
        {
            Log.w("LruBitmapPool", "Size mismatch, resetting");
            c();
        }
        e = 0;
        this;
        JVM INSTR monitorexit ;
        return;
        e = e - b.c(bitmap);
        i = i + 1;
        if (Log.isLoggable("LruBitmapPool", 3))
        {
            (new StringBuilder("Evicting bitmap=")).append(b.b(bitmap));
        }
        b();
        bitmap.recycle();
        if (true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        throw exception;
    }

    private Bitmap c(int j, int k, android.graphics.Bitmap.Config config)
    {
        this;
        JVM INSTR monitorenter ;
        r r1 = b;
        if (config == null) goto _L2; else goto _L1
_L1:
        Object obj = config;
_L7:
        obj = r1.a(j, k, ((android.graphics.Bitmap.Config) (obj)));
        if (obj != null) goto _L4; else goto _L3
_L3:
        if (Log.isLoggable("LruBitmapPool", 3))
        {
            (new StringBuilder("Missing bitmap=")).append(b.b(j, k, config));
        }
        g = g + 1;
_L5:
        if (Log.isLoggable("LruBitmapPool", 2))
        {
            (new StringBuilder("Get bitmap=")).append(b.b(j, k, config));
        }
        b();
        this;
        JVM INSTR monitorexit ;
        return ((Bitmap) (obj));
_L2:
        obj = a;
        continue; /* Loop/switch isn't completed */
_L4:
        f = f + 1;
        e = e - b.c(((Bitmap) (obj)));
        if (android.os.Build.VERSION.SDK_INT >= 12)
        {
            ((Bitmap) (obj)).setHasAlpha(true);
        }
        if (android.os.Build.VERSION.SDK_INT >= 19)
        {
            ((Bitmap) (obj)).setPremultiplied(true);
        }
          goto _L5
        config;
        throw config;
        if (true) goto _L7; else goto _L6
_L6:
    }

    private void c()
    {
        (new StringBuilder("Hits=")).append(f).append(", misses=").append(g).append(", puts=").append(h).append(", evictions=").append(i).append(", currentSize=").append(e).append(", maxSize=").append(d).append("\nStrategy=").append(b);
    }

    public final Bitmap a(int j, int k, android.graphics.Bitmap.Config config)
    {
        Bitmap bitmap = c(j, k, config);
        if (bitmap != null)
        {
            bitmap.eraseColor(0);
            return bitmap;
        } else
        {
            return Bitmap.createBitmap(j, k, config);
        }
    }

    public final void a()
    {
        Log.isLoggable("LruBitmapPool", 3);
        b(0);
    }

    public final void a(int j)
    {
        if (!Log.isLoggable("LruBitmapPool", 3));
        if (j >= 40)
        {
            a();
        } else
        if (j >= 20)
        {
            b(d / 2);
            return;
        }
    }

    public final void a(Bitmap bitmap)
    {
        this;
        JVM INSTR monitorenter ;
        if (bitmap != null)
        {
            break MISSING_BLOCK_LABEL_21;
        }
        throw new NullPointerException("Bitmap must not be null");
        bitmap;
        this;
        JVM INSTR monitorexit ;
        throw bitmap;
        if (bitmap.isRecycled())
        {
            throw new IllegalStateException("Cannot pool recycled bitmap");
        }
        if (bitmap.isMutable() && b.c(bitmap) <= d && c.contains(bitmap.getConfig()))
        {
            break MISSING_BLOCK_LABEL_150;
        }
        if (Log.isLoggable("LruBitmapPool", 2))
        {
            (new StringBuilder("Reject bitmap from pool, bitmap: ")).append(b.b(bitmap)).append(", is mutable: ").append(bitmap.isMutable()).append(", is allowed config: ").append(c.contains(bitmap.getConfig()));
        }
        bitmap.recycle();
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
        int j = b.c(bitmap);
        b.a(bitmap);
        h = h + 1;
        e = j + e;
        if (Log.isLoggable("LruBitmapPool", 2))
        {
            (new StringBuilder("Put bitmap in pool=")).append(b.b(bitmap));
        }
        b();
        b(d);
          goto _L1
    }

    public final Bitmap b(int j, int k, android.graphics.Bitmap.Config config)
    {
        Bitmap bitmap1 = c(j, k, config);
        Bitmap bitmap = bitmap1;
        if (bitmap1 == null)
        {
            bitmap = Bitmap.createBitmap(j, k, config);
        }
        return bitmap;
    }

    static 
    {
        a = android.graphics.Bitmap.Config.ARGB_8888;
    }
}

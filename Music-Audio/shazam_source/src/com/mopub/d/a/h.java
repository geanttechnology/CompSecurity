// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.d.a;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.mopub.d.d;
import com.mopub.d.i;
import com.mopub.d.k;
import com.mopub.d.l;
import com.mopub.d.n;
import com.mopub.d.t;

// Referenced classes of package com.mopub.d.a:
//            d

public final class h extends l
{

    private static final Object p = new Object();
    private final com.mopub.d.n.b l;
    private final android.graphics.Bitmap.Config m;
    private final int n;
    private final int o = 0;

    public h(String s, com.mopub.d.n.b b1, int j, android.graphics.Bitmap.Config config, com.mopub.d.n.a a1)
    {
        super(0, s, a1);
        super.j = new d(1000, 2, 2.0F);
        l = b1;
        m = config;
        n = j;
    }

    private static int a(int j, int i1, int j1, int k1)
    {
        int l1;
        if (j == 0 && i1 == 0)
        {
            l1 = j1;
        } else
        {
            if (j == 0)
            {
                return (int)(((double)i1 / (double)k1) * (double)j1);
            }
            l1 = j;
            if (i1 != 0)
            {
                double d1 = (double)k1 / (double)j1;
                l1 = j;
                if ((double)j * d1 > (double)i1)
                {
                    return (int)((double)i1 / d1);
                }
            }
        }
        return l1;
    }

    private static int b(int j, int i1, int j1, int k1)
    {
        double d1 = Math.min((double)j / (double)j1, (double)i1 / (double)k1);
        float f;
        for (f = 1.0F; (double)(f * 2.0F) <= d1; f *= 2.0F) { }
        return (int)f;
    }

    protected final n a(i j)
    {
        Object obj2 = p;
        obj2;
        JVM INSTR monitorenter ;
        Object obj;
        Object obj1;
        obj = j.b;
        obj1 = new android.graphics.BitmapFactory.Options();
        if (n != 0 || o != 0) goto _L2; else goto _L1
_L1:
        obj1.inPreferredConfig = m;
        obj = BitmapFactory.decodeByteArray(((byte []) (obj)), 0, obj.length, ((android.graphics.BitmapFactory.Options) (obj1)));
_L6:
        if (obj != null) goto _L4; else goto _L3
_L3:
        obj = com.mopub.d.n.a(new k(j));
        j = ((i) (obj));
_L8:
        obj2;
        JVM INSTR monitorexit ;
        return j;
_L2:
        int k1;
        int l1;
        obj1.inJustDecodeBounds = true;
        BitmapFactory.decodeByteArray(((byte []) (obj)), 0, obj.length, ((android.graphics.BitmapFactory.Options) (obj1)));
        int i1 = ((android.graphics.BitmapFactory.Options) (obj1)).outWidth;
        int j1 = ((android.graphics.BitmapFactory.Options) (obj1)).outHeight;
        k1 = a(n, o, i1, j1);
        l1 = a(o, n, j1, i1);
        obj1.inJustDecodeBounds = false;
        obj1.inSampleSize = b(i1, j1, k1, l1);
        obj = BitmapFactory.decodeByteArray(((byte []) (obj)), 0, obj.length, ((android.graphics.BitmapFactory.Options) (obj1)));
        if (obj == null) goto _L6; else goto _L5
_L5:
        if (((Bitmap) (obj)).getWidth() <= k1 && ((Bitmap) (obj)).getHeight() <= l1) goto _L6; else goto _L7
_L7:
        obj1 = Bitmap.createScaledBitmap(((Bitmap) (obj)), k1, l1, true);
        ((Bitmap) (obj)).recycle();
        obj = obj1;
          goto _L6
        obj;
        t.c("Caught OOM for %d byte image, url=%s", new Object[] {
            Integer.valueOf(j.b.length), super.b
        });
        j = com.mopub.d.n.a(new k(((Throwable) (obj))));
        obj2;
        JVM INSTR monitorexit ;
        return j;
        j;
        obj2;
        JVM INSTR monitorexit ;
        throw j;
_L4:
        obj = com.mopub.d.n.a(obj, com.mopub.d.a.d.a(j));
        j = ((i) (obj));
          goto _L8
    }

    protected final volatile void a(Object obj)
    {
        obj = (Bitmap)obj;
        l.a(obj);
    }

    public final com.mopub.d.l.a d()
    {
        return com.mopub.d.l.a.a;
    }

}

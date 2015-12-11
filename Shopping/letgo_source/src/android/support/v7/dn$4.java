// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.graphics.Bitmap;

// Referenced classes of package android.support.v7:
//            dn, ig, aqo, da

class c
    implements Runnable
{

    final Bitmap a;
    final int b;
    final nit> c;
    final dn d;

    public void run()
    {
        Bitmap bitmap = ig.a(a, b);
        if (a != null)
        {
            c.b(bitmap);
            return;
        }
        try
        {
            aqo.d("Could not rotate the bitmap", new Object[0]);
            c.b(new Exception());
            return;
        }
        catch (OutOfMemoryError outofmemoryerror)
        {
            aqo.b(outofmemoryerror, "Could not rotate the bitmap, 'cos an out of memory", new Object[0]);
        }
        c.b(new da());
        return;
    }

    or(dn dn1, Bitmap bitmap, int i, or or)
    {
        d = dn1;
        a = bitmap;
        b = i;
        c = or;
        super();
    }
}

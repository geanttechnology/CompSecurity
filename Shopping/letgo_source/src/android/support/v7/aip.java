// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.graphics.Bitmap;
import android.os.Handler;

// Referenced classes of package android.support.v7:
//            ain, ajt, aii, aij, 
//            ajq, aiv, aio, aim

final class aip
    implements Runnable
{

    private final aim a;
    private final Bitmap b;
    private final ain c;
    private final Handler d;

    public aip(aim aim, Bitmap bitmap, ain ain1, Handler handler)
    {
        a = aim;
        b = bitmap;
        c = ain1;
        d = handler;
    }

    public void run()
    {
        ajt.a("PostProcess image before displaying [%s]", new Object[] {
            c.b
        });
        aio.a(new aii(c.e.p().a(b), c, a, aiv.c), c.e.s(), d, a);
    }
}

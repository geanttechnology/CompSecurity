// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.core;

import android.graphics.Bitmap;
import android.os.Handler;
import com.nostra13.universalimageloader.b.d;
import com.nostra13.universalimageloader.core.assist.LoadedFrom;
import com.nostra13.universalimageloader.core.e.a;

// Referenced classes of package com.nostra13.universalimageloader.core:
//            m, c, d, LoadAndDisplayImageTask, 
//            l

final class n
    implements Runnable
{

    private final l a;
    private final Bitmap b;
    private final m c;
    private final Handler d;

    public n(l l, Bitmap bitmap, m m1, Handler handler)
    {
        a = l;
        b = bitmap;
        c = m1;
        d = handler;
    }

    public void run()
    {
        com.nostra13.universalimageloader.b.d.a("PostProcess image before displaying [%s]", new Object[] {
            c.b
        });
        com.nostra13.universalimageloader.core.LoadAndDisplayImageTask.a(new c(c.e.p().a(b), c, a, LoadedFrom.c), c.e.s(), d, a);
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.b;

import android.graphics.Bitmap;
import java.lang.ref.WeakReference;

// Referenced classes of package com.a.b:
//            a, aw, ad, ao, 
//            aj

public final class ax extends a
{

    public ax(ad ad, aw aw1, ao ao, boolean flag, String s)
    {
        super(ad, aw1, ao, flag, false, 0, null, s);
    }

    final void a()
    {
        aw aw1 = (aw)super.c.get();
        if (aw1 != null)
        {
            aw1.b();
        }
    }

    final void a(Bitmap bitmap, aj aj)
    {
        if (bitmap == null)
        {
            throw new AssertionError(String.format("Attempted to complete action with no result!\n%s", new Object[] {
                this
            }));
        }
        aj = (aw)super.c.get();
        if (aj != null)
        {
            aj.a();
            if (bitmap.isRecycled())
            {
                throw new IllegalStateException("Target callback must not recycle bitmap!");
            }
        }
    }
}

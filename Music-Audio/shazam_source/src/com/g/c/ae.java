// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.g.c;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

// Referenced classes of package com.g.c:
//            a, ad, u, x

final class ae extends a
{

    ae(u u1, ad ad1, x x, int i, int j, Drawable drawable, String s, 
            Object obj, int k)
    {
        super(u1, ad1, x, i, j, k, drawable, s, obj, false);
    }

    final void a()
    {
        ad ad1;
label0:
        {
            ad1 = (ad)c();
            if (ad1 != null)
            {
                if (g == 0)
                {
                    break label0;
                }
                a.e.getResources().getDrawable(g);
                ad1.a();
            }
            return;
        }
        ad1.a();
    }

    final void a(Bitmap bitmap, u.d d)
    {
        if (bitmap == null)
        {
            throw new AssertionError(String.format("Attempted to complete action with no result!\n%s", new Object[] {
                this
            }));
        }
        d = (ad)c();
        if (d != null)
        {
            d.a(bitmap);
            if (bitmap.isRecycled())
            {
                throw new IllegalStateException("Target callback must not recycle bitmap!");
            }
        }
    }
}

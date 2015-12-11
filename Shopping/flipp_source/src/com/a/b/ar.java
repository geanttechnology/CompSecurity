// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

// Referenced classes of package com.a.b:
//            d, ao, aj, ad, 
//            n, h, as, a

final class ar extends d
{

    private final Context o;

    ar(Context context, ad ad, n n, h h, as as, a a1)
    {
        super(ad, n, h, as, a1);
        o = context;
    }

    final Bitmap a(ao ao1)
    {
        android.content.res.Resources resources = o.getResources();
        int i = ao1.b;
        android.graphics.BitmapFactory.Options options = null;
        if (ao1.a())
        {
            options = new android.graphics.BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeResource(resources, i, options);
            a(ao1.d, ao1.e, options);
        }
        return BitmapFactory.decodeResource(resources, i, options);
    }

    final aj a()
    {
        return aj.b;
    }
}

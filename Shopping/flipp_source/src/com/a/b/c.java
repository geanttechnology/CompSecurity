// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.b;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;

// Referenced classes of package com.a.b:
//            d, ao, ba, aj, 
//            ad, n, h, as, 
//            a

final class c extends d
{

    private AssetManager o;

    public c(Context context, ad ad, n n, h h, as as, a a1)
    {
        super(ad, n, h, as, a1);
        o = context.getAssets();
    }

    private Bitmap a(String s)
    {
        Object obj = null;
        if (!g.a()) goto _L2; else goto _L1
_L1:
        android.graphics.BitmapFactory.Options options;
        options = new android.graphics.BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        java.io.InputStream inputstream = o.open(s);
        obj = inputstream;
        BitmapFactory.decodeStream(inputstream, null, options);
        ba.a(inputstream);
        a(g.d, g.e, options);
        obj = options;
_L4:
        s = o.open(s);
        obj = BitmapFactory.decodeStream(s, null, ((android.graphics.BitmapFactory.Options) (obj)));
        ba.a(s);
        return ((Bitmap) (obj));
        s;
        ba.a(((java.io.InputStream) (obj)));
        throw s;
        obj;
        ba.a(s);
        throw obj;
_L2:
        obj = null;
        if (true) goto _L4; else goto _L3
_L3:
    }

    final Bitmap a(ao ao1)
    {
        return a(ao1.a.toString().substring(a));
    }

    final aj a()
    {
        return aj.b;
    }
}

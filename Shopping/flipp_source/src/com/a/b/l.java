// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.b;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

// Referenced classes of package com.a.b:
//            d, ao, ba, aj, 
//            ad, n, h, as, 
//            a

class l extends d
{

    final Context o;

    l(Context context, ad ad, n n, h h, as as, a a1)
    {
        super(ad, n, h, as, a1);
        o = context;
    }

    private Bitmap b(ao ao1)
    {
        Object obj;
        ContentResolver contentresolver;
        obj = null;
        contentresolver = o.getContentResolver();
        if (!ao1.a()) goto _L2; else goto _L1
_L1:
        android.graphics.BitmapFactory.Options options;
        options = new android.graphics.BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        java.io.InputStream inputstream = contentresolver.openInputStream(ao1.a);
        obj = inputstream;
        BitmapFactory.decodeStream(inputstream, null, options);
        ba.a(inputstream);
        a(ao1.d, ao1.e, options);
        obj = options;
_L4:
        ao1 = contentresolver.openInputStream(ao1.a);
        obj = BitmapFactory.decodeStream(ao1, null, ((android.graphics.BitmapFactory.Options) (obj)));
        ba.a(ao1);
        return ((Bitmap) (obj));
        ao1;
        ba.a(((java.io.InputStream) (obj)));
        throw ao1;
        obj;
        ba.a(ao1);
        throw obj;
_L2:
        obj = null;
        if (true) goto _L4; else goto _L3
_L3:
    }

    Bitmap a(ao ao1)
    {
        return b(ao1);
    }

    final aj a()
    {
        return aj.b;
    }
}

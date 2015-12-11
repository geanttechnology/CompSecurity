// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.b;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;

// Referenced classes of package com.a.b:
//            l, ao, d, aa, 
//            ad, n, h, as, 
//            a

final class z extends l
{

    private static final String p[] = {
        "orientation"
    };

    z(Context context, ad ad, n n, h h, as as, a a1)
    {
        super(context, ad, n, h, as, a1);
    }

    private static int a(ContentResolver contentresolver, Uri uri)
    {
        contentresolver = contentresolver.query(uri, p, null, null, null);
        if (contentresolver == null) goto _L2; else goto _L1
_L1:
        boolean flag = contentresolver.moveToFirst();
        if (flag) goto _L3; else goto _L2
_L2:
        int i;
        if (contentresolver != null)
        {
            contentresolver.close();
        }
        i = 0;
_L5:
        return i;
_L3:
        int j = contentresolver.getInt(0);
        i = j;
        if (contentresolver == null) goto _L5; else goto _L4
_L4:
        contentresolver.close();
        return j;
        contentresolver;
        contentresolver = null;
_L9:
        if (contentresolver != null)
        {
            contentresolver.close();
        }
        return 0;
        uri;
        contentresolver = null;
_L7:
        if (contentresolver != null)
        {
            contentresolver.close();
        }
        throw uri;
        uri;
        if (true) goto _L7; else goto _L6
_L6:
        uri;
        if (true) goto _L9; else goto _L8
_L8:
    }

    final Bitmap a(ao ao1)
    {
        Object obj1;
        obj1 = o.getContentResolver();
        super.n = a(((ContentResolver) (obj1)), ao1.a);
        if (!ao1.a()) goto _L2; else goto _L1
_L1:
        Object obj;
        int i = ao1.d;
        int j = ao1.e;
        if (i <= aa.a.e && j <= aa.a.f)
        {
            obj = aa.a;
        } else
        if (i <= aa.b.e && j <= aa.b.f)
        {
            obj = aa.b;
        } else
        {
            obj = aa.c;
        }
        if (obj != aa.c) goto _L4; else goto _L3
_L3:
        obj = super.a(ao1);
_L5:
        return ((Bitmap) (obj));
_L4:
        long l1 = ContentUris.parseId(ao1.a);
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        a(ao1.d, ao1.e, ((aa) (obj)).e, ((aa) (obj)).f, options);
        obj1 = android.provider.MediaStore.Images.Thumbnails.getThumbnail(((ContentResolver) (obj1)), l1, ((aa) (obj)).d, options);
        obj = obj1;
        if (obj1 != null) goto _L5; else goto _L2
_L2:
        return super.a(ao1);
    }

}

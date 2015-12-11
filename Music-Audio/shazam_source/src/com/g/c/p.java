// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.g.c;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

// Referenced classes of package com.g.c:
//            g, x

final class p extends g
{
    static final class a extends Enum
    {

        public static final a a;
        public static final a b;
        public static final a c;
        private static final a g[];
        final int d;
        final int e;
        final int f;

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/g/c/p$a, s);
        }

        public static a[] values()
        {
            return (a[])g.clone();
        }

        static 
        {
            a = new a("MICRO", 0, 3, 96, 96);
            b = new a("MINI", 1, 1, 512, 384);
            c = new a("FULL", 2, 2, -1, -1);
            g = (new a[] {
                a, b, c
            });
        }

        private a(String s, int i, int j, int k, int l)
        {
            super(s, i);
            d = j;
            e = k;
            f = l;
        }
    }


    private static final String b[] = {
        "orientation"
    };

    p(Context context)
    {
        super(context);
    }

    private static int a(ContentResolver contentresolver, Uri uri)
    {
        contentresolver = contentresolver.query(uri, b, null, null, null);
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

    public final boolean a(x x1)
    {
        x1 = x1.d;
        return "content".equals(x1.getScheme()) && "media".equals(x1.getAuthority());
    }

    public final z.a b(x x1)
    {
        boolean flag1 = true;
        ContentResolver contentresolver = a.getContentResolver();
        int j = a(contentresolver, x1.d);
        String s = contentresolver.getType(x1.d);
        boolean flag;
        if (s != null && s.startsWith("video/"))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (x1.c())
        {
            int k = x1.h;
            int l = x1.i;
            Object obj;
            if (k <= a.a.e && l <= a.a.f)
            {
                obj = a.a;
            } else
            if (k <= a.b.e && l <= a.b.f)
            {
                obj = a.b;
            } else
            {
                obj = a.c;
            }
            if (!flag && obj == a.c)
            {
                return new z.a(null, c(x1), u.d.b, j);
            }
            long l1 = ContentUris.parseId(x1.d);
            android.graphics.BitmapFactory.Options options = d(x1);
            options.inJustDecodeBounds = true;
            a(x1.h, x1.i, ((a) (obj)).e, ((a) (obj)).f, options, x1);
            if (flag)
            {
                int i;
                if (obj == a.c)
                {
                    i = ((flag1) ? 1 : 0);
                } else
                {
                    i = ((a) (obj)).d;
                }
                obj = android.provider.MediaStore.Video.Thumbnails.getThumbnail(contentresolver, l1, i, options);
            } else
            {
                obj = android.provider.MediaStore.Images.Thumbnails.getThumbnail(contentresolver, l1, ((a) (obj)).d, options);
            }
            if (obj != null)
            {
                return new z.a(((android.graphics.Bitmap) (obj)), null, u.d.b, j);
            }
        }
        return new z.a(null, c(x1), u.d.b, j);
    }

}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import java.io.IOException;

// Referenced classes of package android.support.v7:
//            akl, alb

class akt extends akl
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
            return (a)Enum.valueOf(android/support/v7/akt$a, s);
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

    akt(Context context)
    {
        super(context);
    }

    static int a(ContentResolver contentresolver, Uri uri)
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

    static a a(int i, int j)
    {
        if (i <= a.a.e && j <= a.a.f)
        {
            return a.a;
        }
        if (i <= a.b.e && j <= a.b.f)
        {
            return a.b;
        } else
        {
            return a.c;
        }
    }

    public ald.a a(alb alb1, int i)
        throws IOException
    {
        Object obj = a.getContentResolver();
        int j = a(((ContentResolver) (obj)), alb1.d);
        String s = ((ContentResolver) (obj)).getType(alb1.d);
        if (s != null && s.startsWith("video/"))
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (alb1.d())
        {
            a a1 = a(alb1.h, alb1.i);
            if (i == 0 && a1 == a.c)
            {
                return new ald.a(null, b(alb1), aky.d.b, j);
            }
            long l = ContentUris.parseId(alb1.d);
            android.graphics.BitmapFactory.Options options = c(alb1);
            options.inJustDecodeBounds = true;
            a(alb1.h, alb1.i, a1.e, a1.f, options, alb1);
            if (i != 0)
            {
                if (a1 == a.c)
                {
                    i = 1;
                } else
                {
                    i = a1.d;
                }
                obj = android.provider.MediaStore.Video.Thumbnails.getThumbnail(((ContentResolver) (obj)), l, i, options);
            } else
            {
                obj = android.provider.MediaStore.Images.Thumbnails.getThumbnail(((ContentResolver) (obj)), l, a1.d, options);
            }
            if (obj != null)
            {
                return new ald.a(((android.graphics.Bitmap) (obj)), null, aky.d.b, j);
            }
        }
        return new ald.a(null, b(alb1), aky.d.b, j);
    }

    public boolean a(alb alb1)
    {
        alb1 = alb1.d;
        return "content".equals(alb1.getScheme()) && "media".equals(alb1.getAuthority());
    }

}

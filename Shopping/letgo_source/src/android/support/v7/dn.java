// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.text.TextUtils;
import com.abtnprojects.ambatana.b;
import com.abtnprojects.ambatana.c;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.Executor;

// Referenced classes of package android.support.v7:
//            cv, cu, ct, aqo, 
//            ig, im, da

public class dn
{

    private Executor a;

    public dn()
    {
        a = cv.a();
    }

    private cu a(Context context, Uri uri)
    {
        cu.a a1 = cu.a();
        a.execute(new Runnable(context, uri, a1) {

            final Context a;
            final Uri b;
            final cu.a c;
            final dn d;

            public void run()
            {
                Bitmap bitmap;
                String s;
                s = im.a(a, b);
                bitmap = null;
                if (s == null)
                {
                    break MISSING_BLOCK_LABEL_37;
                }
                bitmap = BitmapFactory.decodeStream(new FileInputStream(new File(s)));
                if (bitmap == null)
                {
                    break MISSING_BLOCK_LABEL_65;
                }
                if (!TextUtils.isEmpty(s))
                {
                    c.b(new c(bitmap, s));
                    return;
                }
                aqo.d("Could not retrieve the bitmap", new Object[0]);
                c.b(new Exception());
                return;
                Object obj;
                obj;
_L2:
                c.b(((Exception) (obj)));
                android.support.v7.aqo.b(((Throwable) (obj)), "Could not retrieve the bitmap", new Object[0]);
                return;
                obj;
                if (true) goto _L2; else goto _L1
_L1:
            }

            
            {
                d = dn.this;
                a = context;
                b = uri;
                c = a1;
                super();
            }
        });
        return a1.a();
    }

    private cu a(Bitmap bitmap, int i)
    {
        cu.a a1 = cu.a();
        a.execute(new Runnable(bitmap, i, a1) {

            final Bitmap a;
            final int b;
            final cu.a c;
            final dn d;

            public void run()
            {
                Bitmap bitmap1 = ig.a(a, b);
                if (a != null)
                {
                    c.b(bitmap1);
                    return;
                }
                try
                {
                    aqo.d("Could not rotate the bitmap", new Object[0]);
                    c.b(new Exception());
                    return;
                }
                catch (OutOfMemoryError outofmemoryerror)
                {
                    android.support.v7.aqo.b(outofmemoryerror, "Could not rotate the bitmap, 'cos an out of memory", new Object[0]);
                }
                c.b(new da());
                return;
            }

            
            {
                d = dn.this;
                a = bitmap;
                b = i;
                c = a1;
                super();
            }
        });
        return a1.a();
    }

    private cu a(Bitmap bitmap, int i, int j, int k)
    {
        cu.a a1 = cu.a();
        a.execute(new Runnable(bitmap, i, j, a1, k) {

            final Bitmap a;
            final int b;
            final int c;
            final cu.a d;
            final int e;
            final dn f;

            public void run()
            {
                Bitmap bitmap1 = ThumbnailUtils.extractThumbnail(a, b, c);
                if (bitmap1 != null)
                {
                    d.b(new b(bitmap1, e));
                    return;
                } else
                {
                    aqo.d("Could not generate the bitmap", new Object[0]);
                    d.b(new da());
                    return;
                }
            }

            
            {
                f = dn.this;
                a = bitmap;
                b = i;
                c = j;
                d = a1;
                e = k;
                super();
            }
        });
        return a1.a();
    }

    static cu a(dn dn1, Bitmap bitmap, int i)
    {
        return dn1.a(bitmap, i);
    }

    static cu a(dn dn1, Bitmap bitmap, int i, int j, int k)
    {
        return dn1.a(bitmap, i, j, k);
    }

    public cu a(Context context, Uri uri, int i, int j)
    {
        return a(context, uri).d(new ct(i, j) {

            final int a;
            final int b;
            final dn c;

            public cu a(cu cu1)
                throws Exception
            {
                aqo.a("Bitmap retrieved, will rotate", new Object[0]);
                Bitmap bitmap = ((c)cu1.e()).a;
                int k = android.support.v7.ig.b(((c)cu1.e()).b);
                return dn.a(c, bitmap, a, b, k);
            }

            public Object then(cu cu1)
                throws Exception
            {
                return a(cu1);
            }

            
            {
                c = dn.this;
                a = i;
                b = j;
                super();
            }
        }).d(new ct() {

            final dn a;

            public cu a(cu cu1)
                throws Exception
            {
                aqo.a("Bitmap rotated, will generate thumbnail", new Object[0]);
                Bitmap bitmap = ((b)cu1.e()).a;
                int k = ((b)cu1.e()).b;
                return dn.a(a, bitmap, k);
            }

            public Object then(cu cu1)
                throws Exception
            {
                return a(cu1);
            }

            
            {
                a = dn.this;
                super();
            }
        });
    }
}

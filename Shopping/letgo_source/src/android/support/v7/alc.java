// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package android.support.v7:
//            aky, alb, alj, akz, 
//            akm, aku, akj, akq, 
//            alh

public class alc
{

    private static final AtomicInteger a = new AtomicInteger();
    private final aky b;
    private final alb.a c;
    private boolean d;
    private boolean e;
    private boolean f;
    private int g;
    private int h;
    private int i;
    private int j;
    private Drawable k;
    private Drawable l;
    private Object m;

    alc()
    {
        f = true;
        b = null;
        c = new alb.a(null, 0, null);
    }

    alc(aky aky1, Uri uri, int i1)
    {
        f = true;
        if (aky1.m)
        {
            throw new IllegalStateException("Picasso instance already shut down. Cannot submit new requests.");
        } else
        {
            b = aky1;
            c = new alb.a(uri, i1, aky1.j);
            return;
        }
    }

    private alb a(long l1)
    {
        int i1 = a.getAndIncrement();
        alb alb1 = c.d();
        alb1.a = i1;
        alb1.b = l1;
        boolean flag = b.l;
        if (flag)
        {
            alj.a("Main", "created", alb1.b(), alb1.toString());
        }
        alb alb2 = b.a(alb1);
        if (alb2 != alb1)
        {
            alb2.a = i1;
            alb2.b = l1;
            if (flag)
            {
                alj.a("Main", "changed", alb2.a(), (new StringBuilder()).append("into ").append(alb2).toString());
            }
        }
        return alb2;
    }

    private Drawable d()
    {
        if (g != 0)
        {
            return b.c.getResources().getDrawable(g);
        } else
        {
            return k;
        }
    }

    public alc a()
    {
        e = true;
        return this;
    }

    public alc a(int i1, int j1)
    {
        c.a(i1, j1);
        return this;
    }

    public alc a(alh alh)
    {
        c.a(alh);
        return this;
    }

    public void a(ImageView imageview)
    {
        a(imageview, ((akj) (null)));
    }

    public void a(ImageView imageview, akj akj1)
    {
        long l1;
        l1 = System.nanoTime();
        alj.a();
        if (imageview == null)
        {
            throw new IllegalArgumentException("Target must not be null.");
        }
        if (c.a()) goto _L2; else goto _L1
_L1:
        b.a(imageview);
        if (f)
        {
            akz.a(imageview, d());
        }
_L4:
        return;
_L2:
        alb alb1;
        String s;
        if (e)
        {
            if (c.b())
            {
                throw new IllegalStateException("Fit cannot be used with resize.");
            }
            int i1 = imageview.getWidth();
            int j1 = imageview.getHeight();
            if (i1 == 0 || j1 == 0)
            {
                if (f)
                {
                    akz.a(imageview, d());
                }
                b.a(imageview, new akm(this, imageview, akj1));
                return;
            }
            c.a(i1, j1);
        }
        alb1 = a(l1);
        s = alj.a(alb1);
        if (!aku.a(i))
        {
            break; /* Loop/switch isn't completed */
        }
        android.graphics.Bitmap bitmap = b.b(s);
        if (bitmap == null)
        {
            break; /* Loop/switch isn't completed */
        }
        b.a(imageview);
        akz.a(imageview, b.c, bitmap, aky.d.a, d, b.k);
        if (b.l)
        {
            alj.a("Main", "completed", alb1.b(), (new StringBuilder()).append("from ").append(aky.d.a).toString());
        }
        if (akj1 != null)
        {
            akj1.a();
            return;
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (f)
        {
            akz.a(imageview, d());
        }
        imageview = new akq(b, imageview, alb1, i, j, h, l, s, m, akj1, d);
        b.a(imageview);
        return;
    }

    alc b()
    {
        e = false;
        return this;
    }

    public alc c()
    {
        c.c();
        return this;
    }

}

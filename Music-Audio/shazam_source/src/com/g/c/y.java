// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.g.c;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package com.g.c:
//            u, x, ah, af, 
//            k, v, h, q, 
//            e, m, ad, ae

public final class y
{

    private static final AtomicInteger i = new AtomicInteger();
    public final x.a a;
    public boolean b;
    public boolean c;
    public boolean d;
    public int e;
    public int f;
    public Drawable g;
    public Drawable h;
    private final u j;
    private int k;
    private int l;
    private Object m;

    y()
    {
        d = true;
        j = null;
        a = new x.a(null, null);
    }

    y(u u1, Uri uri)
    {
        d = true;
        if (u1.o)
        {
            throw new IllegalStateException("Picasso instance already shut down. Cannot submit new requests.");
        } else
        {
            j = u1;
            a = new x.a(uri, u1.l);
            return;
        }
    }

    private x a(long l1)
    {
        int i1 = i.getAndIncrement();
        Object obj = a;
        if (((x.a) (obj)).g && ((x.a) (obj)).f)
        {
            throw new IllegalStateException("Center crop and center inside can not be used together.");
        }
        if (((x.a) (obj)).f && ((x.a) (obj)).d == 0 && ((x.a) (obj)).e == 0)
        {
            throw new IllegalStateException("Center crop requires calling resize with positive width and height.");
        }
        if (((x.a) (obj)).g && ((x.a) (obj)).d == 0 && ((x.a) (obj)).e == 0)
        {
            throw new IllegalStateException("Center inside requires calling resize with positive width and height.");
        }
        if (((x.a) (obj)).o == null)
        {
            obj.o = u.e.b;
        }
        obj = new x(((x.a) (obj)).a, ((x.a) (obj)).b, ((x.a) (obj)).c, ((x.a) (obj)).m, ((x.a) (obj)).d, ((x.a) (obj)).e, ((x.a) (obj)).f, ((x.a) (obj)).g, ((x.a) (obj)).h, ((x.a) (obj)).i, ((x.a) (obj)).j, ((x.a) (obj)).k, ((x.a) (obj)).l, ((x.a) (obj)).n, ((x.a) (obj)).o, (byte)0);
        obj.a = i1;
        obj.b = l1;
        boolean flag = j.n;
        if (flag)
        {
            ah.a("Main", "created", ((x) (obj)).b(), ((x) (obj)).toString());
        }
        u u1 = j;
        x x1 = u1.c.a(((x) (obj)));
        if (x1 == null)
        {
            throw new IllegalStateException((new StringBuilder("Request transformer ")).append(u1.c.getClass().getCanonicalName()).append(" returned null for ").append(obj).toString());
        }
        if (x1 != obj)
        {
            x1.a = i1;
            x1.b = l1;
            if (flag)
            {
                ah.a("Main", "changed", x1.a(), (new StringBuilder("into ")).append(x1).toString());
            }
        }
        return x1;
    }

    private Drawable b()
    {
        if (e != 0)
        {
            return j.e.getResources().getDrawable(e);
        } else
        {
            return g;
        }
    }

    public final y a(int i1, int j1)
    {
        a.a(i1, j1);
        return this;
    }

    public final y a(af af1)
    {
        x.a a1 = a;
        if (af1 == null)
        {
            throw new IllegalArgumentException("Transformation must not be null.");
        }
        if (af1.a() == null)
        {
            throw new IllegalArgumentException("Transformation key must not be null.");
        }
        if (a1.m == null)
        {
            a1.m = new ArrayList(2);
        }
        a1.m.add(af1);
        return this;
    }

    public final void a()
    {
        Object obj;
        String s;
label0:
        {
            long l1 = System.nanoTime();
            if (c)
            {
                throw new IllegalStateException("Fit cannot be used with fetch.");
            }
            if (a.a())
            {
                boolean flag;
                if (a.o != null)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (!flag)
                {
                    x.a a1 = a;
                    u.e e1 = u.e.a;
                    if (e1 == null)
                    {
                        throw new IllegalArgumentException("Priority invalid.");
                    }
                    if (a1.o != null)
                    {
                        throw new IllegalStateException("Priority already set.");
                    }
                    a1.o = e1;
                }
                obj = a(l1);
                s = ah.a(((x) (obj)), new StringBuilder());
                if (j.b(s) == null)
                {
                    break label0;
                }
                if (j.n)
                {
                    ah.a("Main", "completed", ((x) (obj)).b(), (new StringBuilder("from ")).append(u.d.a).toString());
                }
            }
            return;
        }
        obj = new k(j, ((x) (obj)), k, l, m, s);
        j.b(((a) (obj)));
    }

    public final void a(ImageView imageview, e e1)
    {
        long l1;
        l1 = System.nanoTime();
        ah.a();
        if (imageview == null)
        {
            throw new IllegalArgumentException("Target must not be null.");
        }
        if (a.a()) goto _L2; else goto _L1
_L1:
        j.a(imageview);
        if (d)
        {
            v.a(imageview, b());
        }
_L4:
        return;
_L2:
        x x1;
        String s;
        if (c)
        {
            x.a a1 = a;
            boolean flag;
            if (a1.d != 0 || a1.e != 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                throw new IllegalStateException("Fit cannot be used with resize.");
            }
            int i1 = imageview.getWidth();
            int j1 = imageview.getHeight();
            if (i1 == 0 || j1 == 0)
            {
                if (d)
                {
                    v.a(imageview, b());
                }
                u u1 = j;
                e1 = new h(this, imageview, e1);
                u1.j.put(imageview, e1);
                return;
            }
            a.a(i1, j1);
        }
        x1 = a(l1);
        s = ah.a(x1);
        if (!q.a(k))
        {
            break; /* Loop/switch isn't completed */
        }
        android.graphics.Bitmap bitmap = j.b(s);
        if (bitmap == null)
        {
            break; /* Loop/switch isn't completed */
        }
        j.a(imageview);
        v.a(imageview, j.e, bitmap, u.d.a, b, j.m);
        if (j.n)
        {
            ah.a("Main", "completed", x1.b(), (new StringBuilder("from ")).append(u.d.a).toString());
        }
        if (e1 != null)
        {
            e1.a();
            return;
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (d)
        {
            v.a(imageview, b());
        }
        imageview = new m(j, imageview, x1, k, l, f, h, s, m, e1, b);
        j.a(imageview);
        return;
    }

    public final void a(ad ad1)
    {
        long l1 = System.nanoTime();
        ah.a();
        if (ad1 == null)
        {
            throw new IllegalArgumentException("Target must not be null.");
        }
        if (c)
        {
            throw new IllegalStateException("Fit cannot be used with a Target.");
        }
        if (!a.a())
        {
            j.a(ad1);
            if (d)
            {
                b();
            }
            return;
        }
        Object obj = a(l1);
        String s = ah.a(((x) (obj)));
        if (q.a(k))
        {
            android.graphics.Bitmap bitmap = j.b(s);
            if (bitmap != null)
            {
                j.a(ad1);
                obj = u.d.a;
                ad1.a(bitmap);
                return;
            }
        }
        if (d)
        {
            b();
        }
        ad1 = new ae(j, ad1, ((x) (obj)), k, l, h, s, m, f);
        j.a(ad1);
    }

}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bumptech.glide.load.engine.l;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.load.resource.bitmap.i;
import com.bumptech.glide.load.resource.bitmap.r;
import com.bumptech.glide.request.SingleRequest;
import com.bumptech.glide.request.a;
import com.bumptech.glide.request.c;
import com.bumptech.glide.request.d;
import com.bumptech.glide.request.e;
import com.bumptech.glide.request.g;
import java.util.List;
import java.util.Map;
import java.util.Set;
import myobfuscated.ad.n;
import myobfuscated.ad.q;
import myobfuscated.ag.b;
import myobfuscated.ag.h;
import myobfuscated.f.m;

// Referenced classes of package com.bumptech.glide:
//            a, Priority, d, k, 
//            m

public final class j
    implements Cloneable
{

    private static final com.bumptech.glide.m c = new com.bumptech.glide.a();
    public d a;
    public j b;
    private final com.bumptech.glide.d d;
    private final k e;
    private final Class f;
    private final a g;
    private a h;
    private com.bumptech.glide.m i;
    private Object j;
    private Float k;
    private boolean l;
    private boolean m;

    j(com.bumptech.glide.d d1, k k1, Class class1)
    {
        i = c;
        e = k1;
        d = (com.bumptech.glide.d)myobfuscated.f.m.a(d1, "Argument must not be null");
        f = class1;
        g = k1.e;
        h = g;
    }

    private Priority a(Priority priority)
    {
        final class _cls1
        {

            static final int a[];
            static final int b[];

            static 
            {
                b = new int[Priority.values().length];
                try
                {
                    b[Priority.LOW.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    b[Priority.NORMAL.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    b[Priority.HIGH.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    b[Priority.IMMEDIATE.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                a = new int[android.widget.ImageView.ScaleType.values().length];
                try
                {
                    a[android.widget.ImageView.ScaleType.CENTER_CROP.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    a[android.widget.ImageView.ScaleType.FIT_CENTER.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[android.widget.ImageView.ScaleType.FIT_START.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[android.widget.ImageView.ScaleType.FIT_END.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (com.bumptech.glide._cls1.b[priority.ordinal()])
        {
        default:
            throw new IllegalArgumentException((new StringBuilder("unknown priority: ")).append(h.d).toString());

        case 1: // '\001'
            return Priority.NORMAL;

        case 2: // '\002'
            return Priority.HIGH;

        case 3: // '\003'
        case 4: // '\004'
            return Priority.IMMEDIATE;
        }
    }

    private com.bumptech.glide.request.b a(h h1, a a1, c c1, com.bumptech.glide.m m1, Priority priority, int i1, int j1)
    {
        a1.t = true;
        return SingleRequest.a(d, j, f, a1, i1, j1, priority, h1, a, c1, d.c, m1.a);
    }

    private com.bumptech.glide.request.b a(h h1, g g1, com.bumptech.glide.m m1, Priority priority, int i1, int j1)
    {
        if (b != null)
        {
            if (m)
            {
                throw new IllegalStateException("You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()");
            }
            com.bumptech.glide.m m2 = b.i;
            if (c.equals(m2))
            {
                m2 = m1;
            }
            Priority priority1;
            int k1;
            int l1;
            if (b.h.c(8))
            {
                priority1 = b.h.d;
            } else
            {
                priority1 = a(priority);
            }
            l1 = b.h.k;
            k1 = b.h.j;
            if (myobfuscated.aj.j.a(i1, j1))
            {
                a a1 = b.h;
                if (!myobfuscated.aj.j.a(a1.k, a1.j))
                {
                    l1 = h.k;
                    k1 = h.j;
                }
            }
            g1 = new g(g1);
            m1 = a(h1, h, ((c) (g1)), m1, priority, i1, j1);
            m = true;
            h1 = b.a(h1, g1, m2, priority1, l1, k1);
            m = false;
            g1.a(m1, h1);
            return g1;
        }
        if (k != null)
        {
            g1 = new g(g1);
            g1.a(a(h1, h, ((c) (g1)), m1, priority, i1, j1), a(h1, h.a().a(k.floatValue()), ((c) (g1)), m1, a(priority), i1, j1));
            return g1;
        } else
        {
            return a(h1, h, ((c) (g1)), m1, priority, i1, j1);
        }
    }

    public final j a()
    {
        j j1;
        try
        {
            j1 = (j)super.clone();
            j1.h = j1.h.a();
            j1.i = j1.i.b();
        }
        catch (CloneNotSupportedException clonenotsupportedexception)
        {
            throw new RuntimeException(clonenotsupportedexception);
        }
        return j1;
    }

    public final j a(float f1)
    {
        if (f1 < 0.0F || f1 > 1.0F)
        {
            throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
        } else
        {
            k = Float.valueOf(f1);
            return this;
        }
    }

    public final j a(com.bumptech.glide.m m1)
    {
        i = (com.bumptech.glide.m)myobfuscated.f.m.a(m1, "Argument must not be null");
        return this;
    }

    public final j a(a a1)
    {
        myobfuscated.f.m.a(a1, "Argument must not be null");
        a a2;
        if (g == h)
        {
            a2 = h.a();
        } else
        {
            a2 = h;
        }
        for (; a2.v; a2 = a2.a()) { }
        if (com.bumptech.glide.request.a.b(a1.a, 2))
        {
            a2.b = a1.b;
        }
        if (com.bumptech.glide.request.a.b(a1.a, 4))
        {
            a2.c = a1.c;
        }
        if (com.bumptech.glide.request.a.b(a1.a, 8))
        {
            a2.d = a1.d;
        }
        if (com.bumptech.glide.request.a.b(a1.a, 16))
        {
            a2.e = a1.e;
        }
        if (com.bumptech.glide.request.a.b(a1.a, 32))
        {
            a2.f = a1.f;
        }
        if (com.bumptech.glide.request.a.b(a1.a, 64))
        {
            a2.g = a1.g;
        }
        if (com.bumptech.glide.request.a.b(a1.a, 128))
        {
            a2.h = a1.h;
        }
        if (com.bumptech.glide.request.a.b(a1.a, 256))
        {
            a2.i = a1.i;
        }
        if (com.bumptech.glide.request.a.b(a1.a, 512))
        {
            a2.k = a1.k;
            a2.j = a1.j;
        }
        if (com.bumptech.glide.request.a.b(a1.a, 1024))
        {
            a2.l = a1.l;
        }
        if (com.bumptech.glide.request.a.b(a1.a, 4096))
        {
            a2.s = a1.s;
        }
        if (com.bumptech.glide.request.a.b(a1.a, 8192))
        {
            a2.o = a1.o;
        }
        if (com.bumptech.glide.request.a.b(a1.a, 16384))
        {
            a2.p = a1.p;
        }
        if (com.bumptech.glide.request.a.b(a1.a, 32768))
        {
            a2.u = a1.u;
        }
        if (com.bumptech.glide.request.a.b(a1.a, 0x10000))
        {
            a2.n = a1.n;
        }
        if (com.bumptech.glide.request.a.b(a1.a, 0x20000))
        {
            a2.m = a1.m;
        }
        if (com.bumptech.glide.request.a.b(a1.a, 2048))
        {
            a2.r.putAll(a1.r);
        }
        if (!a2.n)
        {
            a2.r.clear();
            a2.a = a2.a & 0xfffff7ff;
            a2.m = false;
            a2.a = a2.a & 0xfffdffff;
        }
        a2.a = a2.a | a1.a;
        a2.q.a(a1.q);
        h = a2.d();
        return this;
    }

    public final j a(Object obj)
    {
        j = obj;
        l = true;
        return this;
    }

    public final h a(ImageView imageview)
    {
        myobfuscated.aj.j.a();
        myobfuscated.f.m.a(imageview, "Argument must not be null");
        if (h.c(2048) || !h.n || imageview.getScaleType() == null) goto _L2; else goto _L1
_L1:
        if (h.t)
        {
            h = h.a();
        }
        com.bumptech.glide._cls1.a[imageview.getScaleType().ordinal()];
        JVM INSTR tableswitch 1 4: default 104
    //                   1 134
    //                   2 164
    //                   3 164
    //                   4 164;
           goto _L2 _L3 _L4 _L4 _L4
_L2:
        Object obj = f;
        if (!android/graphics/Bitmap.equals(obj)) goto _L6; else goto _L5
_L5:
        imageview = new myobfuscated.ag.a(imageview);
_L8:
        return a(((h) (imageview)));
_L3:
        obj = h;
        com.bumptech.glide.d d1 = d;
        ((a) (obj)).a(d1, DownsampleStrategy.b, new i(d1));
        continue; /* Loop/switch isn't completed */
_L4:
        obj = h;
        com.bumptech.glide.d d2 = d;
        ((a) (obj)).a(d2, DownsampleStrategy.a, new r(d2));
        continue; /* Loop/switch isn't completed */
_L6:
        if (!android/graphics/drawable/Drawable.isAssignableFrom(((Class) (obj))))
        {
            break; /* Loop/switch isn't completed */
        }
        imageview = new b(imageview);
        if (true) goto _L8; else goto _L7
_L7:
        throw new IllegalArgumentException((new StringBuilder("Unhandled class: ")).append(obj).append(", try .as*(Class).transcode(ResourceTranscoder)").toString());
        if (true) goto _L2; else goto _L9
_L9:
    }

    public final h a(h h1)
    {
        myobfuscated.aj.j.a();
        myobfuscated.f.m.a(h1, "Argument must not be null");
        if (!l)
        {
            throw new IllegalArgumentException("You must call #load() before calling #into()");
        }
        if (h1.b() != null)
        {
            e.a(h1);
        }
        h.t = true;
        com.bumptech.glide.request.b b1 = a(h1, null, i, h.d, h.k, h.j);
        h1.a(b1);
        Object obj = e;
        ((k) (obj)).d.a.add(h1);
        obj = ((k) (obj)).b;
        ((n) (obj)).a.add(b1);
        if (!((n) (obj)).c)
        {
            b1.a();
            return h1;
        } else
        {
            ((n) (obj)).b.add(b1);
            return h1;
        }
    }

    public final h b()
    {
        return a(new myobfuscated.ag.e(e, 0x80000000, 0x80000000));
    }

    public final Object clone()
    {
        return a();
    }

    static 
    {
        ((e)((e)(new e()).a(l.c)).a(Priority.LOW)).a(true);
    }
}

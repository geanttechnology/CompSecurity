// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pf.common.a;

import android.graphics.Bitmap;
import com.pf.common.utility.d;
import com.pf.common.utility.l;
import com.pf.common.utility.m;
import com.pf.common.utility.r;
import java.io.File;
import java.lang.ref.ReferenceQueue;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.pf.common.a:
//            m, i, k, l, 
//            h, f, d

public final class c
{

    static boolean a = false;
    private static final d b;
    private static final com.pf.common.a.m c = new com.pf.common.a.m();
    private final File d;
    private final int e;
    private h f;
    private final d g;
    private final long h;
    private final r i;
    private ReferenceQueue j;
    private final Set k;

    public c(File file, int i1)
    {
        this(file, i1, b);
    }

    public c(File file, int i1, d d1)
    {
        i = new r();
        k = Collections.newSetFromMap(new IdentityHashMap());
        d = file;
        e = i1;
        g = d1;
        a();
        h = c.a(this, d);
    }

    static ReferenceQueue a(c c1)
    {
        return c1.j;
    }

    static void a(int i1)
    {
        b(i1);
    }

    static Set b(c c1)
    {
        return c1.k;
    }

    private static void b(int i1)
    {
        try
        {
            TimeUnit.SECONDS.sleep(i1);
            return;
        }
        catch (InterruptedException interruptedexception)
        {
            m.b("BitmapSwap", "Unexpected interruption.", interruptedexception);
        }
    }

    static h c(c c1)
    {
        return c1.f;
    }

    static File d(c c1)
    {
        return c1.d;
    }

    static d e(c c1)
    {
        return c1.g;
    }

    public i a(Bitmap bitmap, String s)
    {
        s = a(s);
        s.b(bitmap);
        return s;
    }

    public i a(String s)
    {
        return new k(this, new com.pf.common.a.l(this, s));
    }

    public String a(Object obj)
    {
        return i.b(obj);
    }

    public void a()
    {
        b();
        j = new ReferenceQueue();
        f = new h(this, e);
    }

    void b()
    {
        l.a(d);
    }

    public void c()
    {
        do
        {
            f f1 = (f)j.poll();
            if (f1 != null)
            {
                f1.a.b();
                k.remove(f1);
            } else
            {
                return;
            }
        } while (true);
    }

    protected void finalize()
    {
        l.a((File)c.a(h));
        super.finalize();
        return;
        Exception exception;
        exception;
        super.finalize();
        throw exception;
    }

    static 
    {
        b = d.j;
    }
}

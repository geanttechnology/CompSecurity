// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.view;

import android.support.v4.view.ba;
import android.support.v4.view.be;
import android.support.v4.view.bf;
import android.view.View;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Iterator;

public class f
{

    private final ArrayList a = new ArrayList();
    private long b;
    private Interpolator c;
    private be d;
    private boolean e;
    private final bf f = new bf() {

        final f a;
        private boolean b;
        private int c;

        void a()
        {
            c = 0;
            b = false;
            f.b(a);
        }

        public void a(View view)
        {
            if (!b)
            {
                b = true;
                if (f.a(a) != null)
                {
                    f.a(a).a(null);
                    return;
                }
            }
        }

        public void b(View view)
        {
            int i = c + 1;
            c = i;
            if (i == f.c(a).size())
            {
                if (f.a(a) != null)
                {
                    f.a(a).b(null);
                }
                a();
            }
        }

            
            {
                a = f.this;
                super();
                b = false;
                c = 0;
            }
    };

    public f()
    {
        b = -1L;
    }

    static be a(f f1)
    {
        return f1.d;
    }

    static void b(f f1)
    {
        f1.c();
    }

    static ArrayList c(f f1)
    {
        return f1.a;
    }

    private void c()
    {
        e = false;
    }

    public f a(long l)
    {
        if (!e)
        {
            b = l;
        }
        return this;
    }

    public f a(ba ba1)
    {
        if (!e)
        {
            a.add(ba1);
        }
        return this;
    }

    public f a(be be)
    {
        if (!e)
        {
            d = be;
        }
        return this;
    }

    public f a(Interpolator interpolator)
    {
        if (!e)
        {
            c = interpolator;
        }
        return this;
    }

    public void a()
    {
        if (e)
        {
            return;
        }
        ba ba1;
        for (Iterator iterator = a.iterator(); iterator.hasNext(); ba1.b())
        {
            ba1 = (ba)iterator.next();
            if (b >= 0L)
            {
                ba1.a(b);
            }
            if (c != null)
            {
                ba1.a(c);
            }
            if (d != null)
            {
                ba1.a(f);
            }
        }

        e = true;
    }

    public void b()
    {
        if (!e)
        {
            return;
        }
        for (Iterator iterator = a.iterator(); iterator.hasNext(); ((ba)iterator.next()).a()) { }
        e = false;
    }
}

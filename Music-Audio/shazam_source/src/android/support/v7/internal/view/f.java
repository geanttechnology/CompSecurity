// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.view;

import android.support.v4.view.ad;
import android.support.v4.view.ah;
import android.support.v4.view.ai;
import android.view.View;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Iterator;

public final class f
{

    final ArrayList a = new ArrayList();
    ah b;
    boolean c;
    private long d;
    private Interpolator e;
    private final ai f = new ai() {

        final f a;
        private boolean b;
        private int c;

        public final void a(View view)
        {
            if (!b)
            {
                b = true;
                if (a.b != null)
                {
                    a.b.a(null);
                    return;
                }
            }
        }

        public final void b(View view)
        {
            int i = c + 1;
            c = i;
            if (i == a.a.size())
            {
                if (a.b != null)
                {
                    a.b.b(null);
                }
                c = 0;
                b = false;
                a.c = false;
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
        d = -1L;
    }

    public final f a(ad ad1)
    {
        if (!c)
        {
            a.add(ad1);
        }
        return this;
    }

    public final f a(ah ah)
    {
        if (!c)
        {
            b = ah;
        }
        return this;
    }

    public final f a(Interpolator interpolator)
    {
        if (!c)
        {
            e = interpolator;
        }
        return this;
    }

    public final void a()
    {
        if (c)
        {
            return;
        }
        ad ad1;
        for (Iterator iterator = a.iterator(); iterator.hasNext(); ad1.b())
        {
            ad1 = (ad)iterator.next();
            if (d >= 0L)
            {
                ad1.a(d);
            }
            if (e != null)
            {
                ad1.a(e);
            }
            if (b != null)
            {
                ad1.a(f);
            }
        }

        c = true;
    }

    public final void b()
    {
        if (!c)
        {
            return;
        }
        for (Iterator iterator = a.iterator(); iterator.hasNext(); ((ad)iterator.next()).a()) { }
        c = false;
    }

    public final f c()
    {
        if (!c)
        {
            d = 250L;
        }
        return this;
    }
}

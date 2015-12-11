// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.support.v4.view.ay;
import android.support.v4.view.bc;
import android.support.v4.view.bd;
import android.view.View;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Iterator;

public class cf
{

    private final ArrayList a = new ArrayList();
    private long b;
    private Interpolator c;
    private bc d;
    private boolean e;
    private final bd f = new bd() {

        final cf a;
        private boolean b;
        private int c;

        void a()
        {
            c = 0;
            b = false;
            cf.b(a);
        }

        public void onAnimationEnd(View view)
        {
            int i = c + 1;
            c = i;
            if (i == cf.c(a).size())
            {
                if (cf.a(a) != null)
                {
                    cf.a(a).onAnimationEnd(null);
                }
                a();
            }
        }

        public void onAnimationStart(View view)
        {
            if (!b)
            {
                b = true;
                if (cf.a(a) != null)
                {
                    cf.a(a).onAnimationStart(null);
                    return;
                }
            }
        }

            
            {
                a = cf.this;
                super();
                b = false;
                c = 0;
            }
    };

    public cf()
    {
        b = -1L;
    }

    static bc a(cf cf1)
    {
        return cf1.d;
    }

    static void b(cf cf1)
    {
        cf1.c();
    }

    static ArrayList c(cf cf1)
    {
        return cf1.a;
    }

    private void c()
    {
        e = false;
    }

    public cf a(long l)
    {
        if (!e)
        {
            b = l;
        }
        return this;
    }

    public cf a(ay ay1)
    {
        if (!e)
        {
            a.add(ay1);
        }
        return this;
    }

    public cf a(bc bc)
    {
        if (!e)
        {
            d = bc;
        }
        return this;
    }

    public cf a(Interpolator interpolator)
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
        ay ay1;
        for (Iterator iterator = a.iterator(); iterator.hasNext(); ay1.b())
        {
            ay1 = (ay)iterator.next();
            if (b >= 0L)
            {
                ay1.a(b);
            }
            if (c != null)
            {
                ay1.a(c);
            }
            if (d != null)
            {
                ay1.a(f);
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
        for (Iterator iterator = a.iterator(); iterator.hasNext(); ((ay)iterator.next()).a()) { }
        e = false;
    }
}

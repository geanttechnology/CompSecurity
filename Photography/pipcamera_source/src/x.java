// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.view.View;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Iterator;

public class x
{

    private final ArrayList a = new ArrayList();
    private long b;
    private Interpolator c;
    private ViewPropertyAnimatorListener d;
    private boolean e;
    private final ViewPropertyAnimatorListenerAdapter f = new ViewPropertyAnimatorListenerAdapter() {

        final x a;
        private boolean b;
        private int c;

        void a()
        {
            c = 0;
            b = false;
            x.b(a);
        }

        public void onAnimationEnd(View view)
        {
            int i = c + 1;
            c = i;
            if (i == x.c(a).size())
            {
                if (x.a(a) != null)
                {
                    x.a(a).onAnimationEnd(null);
                }
                a();
            }
        }

        public void onAnimationStart(View view)
        {
            if (!b)
            {
                b = true;
                if (x.a(a) != null)
                {
                    x.a(a).onAnimationStart(null);
                    return;
                }
            }
        }

            
            {
                a = x.this;
                super();
                b = false;
                c = 0;
            }
    };

    public x()
    {
        b = -1L;
    }

    static ViewPropertyAnimatorListener a(x x1)
    {
        return x1.d;
    }

    static void b(x x1)
    {
        x1.c();
    }

    static ArrayList c(x x1)
    {
        return x1.a;
    }

    private void c()
    {
        e = false;
    }

    public x a(long l)
    {
        if (!e)
        {
            b = l;
        }
        return this;
    }

    public x a(ViewPropertyAnimatorCompat viewpropertyanimatorcompat)
    {
        if (!e)
        {
            a.add(viewpropertyanimatorcompat);
        }
        return this;
    }

    public x a(ViewPropertyAnimatorListener viewpropertyanimatorlistener)
    {
        if (!e)
        {
            d = viewpropertyanimatorlistener;
        }
        return this;
    }

    public x a(Interpolator interpolator)
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
        ViewPropertyAnimatorCompat viewpropertyanimatorcompat;
        for (Iterator iterator = a.iterator(); iterator.hasNext(); viewpropertyanimatorcompat.start())
        {
            viewpropertyanimatorcompat = (ViewPropertyAnimatorCompat)iterator.next();
            if (b >= 0L)
            {
                viewpropertyanimatorcompat.setDuration(b);
            }
            if (c != null)
            {
                viewpropertyanimatorcompat.setInterpolator(c);
            }
            if (d != null)
            {
                viewpropertyanimatorcompat.setListener(f);
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
        for (Iterator iterator = a.iterator(); iterator.hasNext(); ((ViewPropertyAnimatorCompat)iterator.next()).cancel()) { }
        e = false;
    }
}

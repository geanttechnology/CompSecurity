// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Iterator;

public class as
{

    private final ArrayList a = new ArrayList();
    private long b;
    private Interpolator c;
    private ViewPropertyAnimatorListener d;
    private boolean e;
    private final ViewPropertyAnimatorListenerAdapter f = new at(this);

    public as()
    {
        b = -1L;
    }

    static ViewPropertyAnimatorListener a(as as1)
    {
        return as1.d;
    }

    static void b(as as1)
    {
        as1.c();
    }

    static ArrayList c(as as1)
    {
        return as1.a;
    }

    private void c()
    {
        e = false;
    }

    public as a(long l)
    {
        if (!e)
        {
            b = l;
        }
        return this;
    }

    public as a(ViewPropertyAnimatorCompat viewpropertyanimatorcompat)
    {
        if (!e)
        {
            a.add(viewpropertyanimatorcompat);
        }
        return this;
    }

    public as a(ViewPropertyAnimatorListener viewpropertyanimatorlistener)
    {
        if (!e)
        {
            d = viewpropertyanimatorlistener;
        }
        return this;
    }

    public as a(Interpolator interpolator)
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

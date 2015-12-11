// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import java.util.Collections;
import java.util.Date;
import java.util.Map;
import java.util.Set;

public final class tz
{

    public static final String a = aca.a("emulator");
    private final Date b;
    private final String c;
    private final int d;
    private final Set e;
    private final Location f;
    private final boolean g;
    private final Bundle h;
    private final Map i;
    private final String j;
    private final pj k;
    private final int l;
    private final Set m;

    public tz(ua ua1)
    {
        this(ua1, null);
    }

    public tz(ua ua1, pj pj)
    {
        b = ua.a(ua1);
        c = ua.b(ua1);
        d = ua.c(ua1);
        e = Collections.unmodifiableSet(ua.d(ua1));
        f = ua.e(ua1);
        g = ua.f(ua1);
        h = ua.g(ua1);
        i = Collections.unmodifiableMap(ua.h(ua1));
        j = ua.i(ua1);
        k = pj;
        l = ua.j(ua1);
        m = Collections.unmodifiableSet(ua.k(ua1));
    }

    public Bundle a(Class class1)
    {
        return h.getBundle(class1.getName());
    }

    public Date a()
    {
        return b;
    }

    public boolean a(Context context)
    {
        return m.contains(aca.a(context));
    }

    public String b()
    {
        return c;
    }

    public int c()
    {
        return d;
    }

    public Set d()
    {
        return e;
    }

    public Location e()
    {
        return f;
    }

    public boolean f()
    {
        return g;
    }

    public String g()
    {
        return j;
    }

    public pj h()
    {
        return k;
    }

    public Map i()
    {
        return i;
    }

    public Bundle j()
    {
        return h;
    }

    public int k()
    {
        return l;
    }

}

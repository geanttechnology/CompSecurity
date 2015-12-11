// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.location.Location;
import android.os.Bundle;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;

public final class ua
{

    private final HashSet a = new HashSet();
    private final Bundle b = new Bundle();
    private final HashMap c = new HashMap();
    private final HashSet d = new HashSet();
    private Date e;
    private String f;
    private int g;
    private Location h;
    private boolean i;
    private String j;
    private int k;

    public ua()
    {
        g = -1;
        i = false;
        k = -1;
    }

    static Date a(ua ua1)
    {
        return ua1.e;
    }

    static String b(ua ua1)
    {
        return ua1.f;
    }

    static int c(ua ua1)
    {
        return ua1.g;
    }

    static HashSet d(ua ua1)
    {
        return ua1.a;
    }

    static Location e(ua ua1)
    {
        return ua1.h;
    }

    static boolean f(ua ua1)
    {
        return ua1.i;
    }

    static Bundle g(ua ua1)
    {
        return ua1.b;
    }

    static HashMap h(ua ua1)
    {
        return ua1.c;
    }

    static String i(ua ua1)
    {
        return ua1.j;
    }

    static int j(ua ua1)
    {
        return ua1.k;
    }

    static HashSet k(ua ua1)
    {
        return ua1.d;
    }

    public void a(int l)
    {
        g = l;
    }

    public void a(Location location)
    {
        h = location;
    }

    public void a(Class class1, Bundle bundle)
    {
        b.putBundle(class1.getName(), bundle);
    }

    public void a(String s)
    {
        a.add(s);
    }

    public void a(Date date)
    {
        e = date;
    }

    public void a(boolean flag)
    {
        int l;
        if (flag)
        {
            l = 1;
        } else
        {
            l = 0;
        }
        k = l;
    }

    public void b(String s)
    {
        d.add(s);
    }
}

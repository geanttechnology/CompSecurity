// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;

public final class uh extends uk
{

    private final aho a;
    private final String b;
    private final String c;

    public uh(aho aho1, String s, String s1)
    {
        a = aho1;
        b = s;
        c = s1;
    }

    public String a()
    {
        return b;
    }

    public void a(ry ry)
    {
        if (ry == null)
        {
            return;
        } else
        {
            a.a((View)sb.a(ry));
            return;
        }
    }

    public String b()
    {
        return c;
    }

    public void c()
    {
        a.u();
    }

    public void d()
    {
        a.v();
    }
}

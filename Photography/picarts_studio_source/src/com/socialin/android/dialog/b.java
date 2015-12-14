// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.dialog;


// Referenced classes of package com.socialin.android.dialog:
//            a, c

public class b
{

    public String a;
    public String b;
    public String c;
    public String d;
    public int e;
    public int f;
    public boolean g;
    public boolean h;
    public boolean i;
    public boolean j;
    public android.view.View.OnClickListener k;
    public android.view.View.OnClickListener l;
    public android.content.DialogInterface.OnCancelListener m;
    public int n;
    public int o;
    public c p;

    public b()
    {
        a = null;
        b = null;
        c = null;
        d = null;
        e = 0;
        g = true;
        h = true;
        i = true;
        j = false;
        k = null;
        l = null;
        n = 0x7f0c0181;
        o = 1;
        p = null;
    }

    public final a a()
    {
        return new a(a, e, b, f, g, h, k, l, m, o, n, p, d, c, i, j);
    }

    public final b a(int i1, int j1)
    {
        o = i1;
        n = j1;
        return this;
    }

    public final b a(android.view.View.OnClickListener onclicklistener)
    {
        k = onclicklistener;
        g = true;
        return this;
    }

    public final b a(String s)
    {
        if (s != null)
        {
            c = s;
        }
        return this;
    }

    public final b a(String s, android.view.View.OnClickListener onclicklistener)
    {
        k = onclicklistener;
        g = true;
        if (s != null)
        {
            c = s;
        }
        return this;
    }

    public final b b(android.view.View.OnClickListener onclicklistener)
    {
        l = onclicklistener;
        h = true;
        return this;
    }

    public final b b(String s)
    {
        if (s != null)
        {
            d = s;
        }
        return this;
    }
}

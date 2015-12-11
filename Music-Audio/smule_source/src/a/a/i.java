// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package a.a;

import org.apache.http.util.CharArrayBuffer;

// Referenced classes of package a.a:
//            g, m, t, j

public final class i extends g
{

    private j d;
    private int e;
    private int f;

    public i(j j1, int k)
    {
        super(j1);
        f = 0;
        d = j1;
        e = k;
    }

    public final boolean a(int k)
    {
        if (f < e + 2)
        {
            if (k == -1)
            {
                super.a.b(a());
                super.a.a(t.d);
                return true;
            }
            c = c + 1;
            k = (char)k;
            f = f + 1;
            if (f > e)
            {
                if (k == 10)
                {
                    d.b(a());
                    super.a.a(d);
                    return true;
                }
                if (f == e + 2 && k != 10)
                {
                    super.a.a(t.d);
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean a(CharArrayBuffer chararraybuffer)
    {
        return true;
    }

    public final g b()
    {
        return d;
    }

    public final g c()
    {
        return null;
    }

    protected final int d()
    {
        return 0;
    }

    protected final int e()
    {
        return 0;
    }

    public final void f()
    {
        super.a.b(a());
        super.a.a(t.d);
    }
}

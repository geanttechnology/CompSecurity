// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package a.a;

import org.apache.http.util.CharArrayBuffer;

// Referenced classes of package a.a:
//            g, t, m

public final class h extends g
{

    private int d;
    private int e;

    public h(g g1, int i)
    {
        super(g1);
        e = 0;
        d = i;
    }

    public final boolean a(int i)
    {
        if (i == -1)
        {
            super.a.a(t.d);
            return true;
        }
        e = e + 1;
        c = c + 1;
        if (e == d)
        {
            super.a.b(a());
            g g1 = super.a.b();
            super.a.a(g1);
            return true;
        } else
        {
            return false;
        }
    }

    public final boolean a(CharArrayBuffer chararraybuffer)
    {
        return true;
    }

    public final int b(byte abyte0[], int i, int j)
    {
        if (j == -1)
        {
            super.a.a(t.d);
            return -1;
        }
        if (e + j < d)
        {
            e = e + j;
            c = c + j;
            return j;
        } else
        {
            i = d - e;
            c = c + i;
            super.a.b(a());
            super.a.a(super.a.b());
            return i;
        }
    }

    public final g b()
    {
        return t.d;
    }

    public final g c()
    {
        return t.d;
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

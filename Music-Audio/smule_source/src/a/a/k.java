// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package a.a;

import org.apache.http.util.CharArrayBuffer;

// Referenced classes of package a.a:
//            g, m, t

public final class k extends g
{

    public k(g g1)
    {
        super(g1);
    }

    public final boolean a(int i)
    {
        if (i == -1)
        {
            super.a.b(a());
            super.a.a(t.d);
            return true;
        } else
        {
            c = c + 1;
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
            super.a.b(a());
            super.a.a(t.d);
            return -1;
        } else
        {
            c = c + j;
            return j;
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
        return 0x7fffffff;
    }

    public final void f()
    {
        super.a.b(a());
        super.a.a(t.d);
    }
}

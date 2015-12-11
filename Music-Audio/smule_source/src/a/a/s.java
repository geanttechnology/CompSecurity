// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package a.a;

import org.apache.http.util.CharArrayBuffer;

// Referenced classes of package a.a:
//            g, t, m

public final class s extends g
{

    private g d;

    public s(g g1)
    {
        super(g1);
        d = g1;
    }

    public final boolean a(int i)
    {
        if (i == -1)
        {
            super.a.a(t.d);
            return true;
        }
        c = c + 1;
        if ((char)i == '\n')
        {
            d.b(a());
            super.a.a(d);
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

    public final g b()
    {
        return this;
    }

    public final g c()
    {
        return this;
    }

    protected final int d()
    {
        return 0;
    }

    protected final int e()
    {
        return 0;
    }
}

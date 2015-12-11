// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package a.a;

import org.apache.http.util.CharArrayBuffer;

// Referenced classes of package a.a:
//            g, m, s

public final class r extends g
{

    private boolean d;

    public r(g g1)
    {
        super(g1);
        d = false;
    }

    public final boolean a(CharArrayBuffer chararraybuffer)
    {
        boolean flag = false;
        if (chararraybuffer.substringTrimmed(0, chararraybuffer.length()).length() == 0)
        {
            flag = true;
        }
        d = flag;
        return true;
    }

    public final g b()
    {
        if (d)
        {
            super.a.b(a());
            return super.a.b();
        } else
        {
            super.b.clear();
            return this;
        }
    }

    public final g c()
    {
        super.b.clear();
        return new s(this);
    }

    protected final int d()
    {
        return 8;
    }

    protected final int e()
    {
        return 128;
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package a.a;

import org.apache.http.util.CharArrayBuffer;

// Referenced classes of package a.a:
//            g, r, i, t, 
//            m

public final class j extends g
{

    private int d;

    public j(g g1)
    {
        super(g1);
        d = -1;
    }

    public final boolean a(CharArrayBuffer chararraybuffer)
    {
        int k = chararraybuffer.indexOf(59);
        int l = chararraybuffer.length();
        if (k <= 0)
        {
            k = l;
        }
        try
        {
            d = Integer.parseInt(chararraybuffer.substringTrimmed(0, k), 16);
        }
        // Misplaced declaration of an exception variable
        catch (CharArrayBuffer chararraybuffer)
        {
            return false;
        }
        return true;
    }

    public final g b()
    {
        int k = d;
        if (d == 0)
        {
            return new r(this);
        } else
        {
            super.b.clear();
            return new i(this, d);
        }
    }

    public final g c()
    {
        return t.d;
    }

    protected final int d()
    {
        return 16;
    }

    protected final int e()
    {
        return 256;
    }

    public final void f()
    {
        super.a.b(a());
        super.a.a(t.d);
    }
}

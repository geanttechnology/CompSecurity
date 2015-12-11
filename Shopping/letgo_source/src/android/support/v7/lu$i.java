// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.io.IOException;

// Referenced classes of package android.support.v7:
//            xv, lu, xu, xz

public static final class a extends xv
{

    public d a[];
    public d b;
    public String c;

    public a a()
    {
        a = a();
        b = null;
        c = "";
        r = null;
        s = -1;
        return this;
    }

    public void a(xu xu1)
        throws IOException
    {
        if (a != null && a.length > 0)
        {
            for (int j = 0; j < a.length; j++)
            {
                s s = a[j];
                if (s != null)
                {
                    xu1.a(1, s);
                }
            }

        }
        if (b != null)
        {
            xu1.a(2, b);
        }
        if (!c.equals(""))
        {
            xu1.a(3, c);
        }
        super.a(xu1);
    }

    protected int b()
    {
        int j = super.b();
        int k = j;
        if (a != null)
        {
            k = j;
            if (a.length > 0)
            {
                int l = 0;
                do
                {
                    k = j;
                    if (l >= a.length)
                    {
                        break;
                    }
                    c c1 = a[l];
                    k = j;
                    if (c1 != null)
                    {
                        k = j + xu.c(1, c1);
                    }
                    l++;
                    j = k;
                } while (true);
            }
        }
        j = k;
        if (b != null)
        {
            j = k + xu.c(2, b);
        }
        k = j;
        if (!c.equals(""))
        {
            k = j + xu.b(3, c);
        }
        return k;
    }

    public boolean equals(Object obj)
    {
        boolean flag1 = false;
        if (obj != this) goto _L2; else goto _L1
_L1:
        boolean flag = true;
_L4:
        return flag;
_L2:
        flag = flag1;
        if (!(obj instanceof c)) goto _L4; else goto _L3
_L3:
        obj = (c)obj;
        flag = flag1;
        if (!xz.a(a, ((a) (obj)).a)) goto _L4; else goto _L5
_L5:
        if (b != null) goto _L7; else goto _L6
_L6:
        flag = flag1;
        if (((b) (obj)).b != null) goto _L4; else goto _L8
_L8:
        if (c != null)
        {
            break MISSING_BLOCK_LABEL_95;
        }
        flag = flag1;
        if (((c) (obj)).c != null) goto _L4; else goto _L9
_L9:
        return a(((xv) (obj)));
_L7:
        if (!b.equals(((equals) (obj)).b))
        {
            return false;
        }
          goto _L8
        if (!c.equals(((c) (obj)).c))
        {
            return false;
        }
          goto _L9
    }

    public int hashCode()
    {
        int k = 0;
        int l = xz.a(a);
        int j;
        if (b == null)
        {
            j = 0;
        } else
        {
            j = b.hashCode();
        }
        if (c != null)
        {
            k = c.hashCode();
        }
        return ((j + (l + 527) * 31) * 31 + k) * 31 + d();
    }

    public ()
    {
        a();
    }
}

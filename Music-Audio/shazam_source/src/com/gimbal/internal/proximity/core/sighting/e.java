// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gimbal.internal.proximity.core.sighting;

import java.util.Date;

public final class e
{

    String a;
    int b;
    Date c;
    String d;
    String e;
    String f;
    String g;
    String h;
    String i;
    Long j;
    Byte k;
    int l;
    int m;
    Byte n;
    String o;
    String p;

    public e()
    {
    }

    public final boolean equals(Object obj)
    {
        if (this != obj) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        obj = (e)obj;
        if (h == null)
        {
            if (((e) (obj)).h != null)
            {
                return false;
            }
        } else
        if (!h.equals(((e) (obj)).h))
        {
            return false;
        }
        if (m != ((e) (obj)).m)
        {
            return false;
        }
        if (c == null)
        {
            if (((e) (obj)).c != null)
            {
                return false;
            }
        } else
        if (!c.equals(((e) (obj)).c))
        {
            return false;
        }
        if (i == null)
        {
            if (((e) (obj)).i != null)
            {
                return false;
            }
        } else
        if (!i.equals(((e) (obj)).i))
        {
            return false;
        }
        if (f == null)
        {
            if (((e) (obj)).f != null)
            {
                return false;
            }
        } else
        if (!f.equals(((e) (obj)).f))
        {
            return false;
        }
        if (g == null)
        {
            if (((e) (obj)).g != null)
            {
                return false;
            }
        } else
        if (!g.equals(((e) (obj)).g))
        {
            return false;
        }
        if (a == null)
        {
            if (((e) (obj)).a != null)
            {
                return false;
            }
        } else
        if (!a.equals(((e) (obj)).a))
        {
            return false;
        }
        if (b != ((e) (obj)).b)
        {
            return false;
        }
        if (j == null)
        {
            if (((e) (obj)).j != null)
            {
                return false;
            }
        } else
        if (!j.equals(((e) (obj)).j))
        {
            return false;
        }
        if (d == null)
        {
            if (((e) (obj)).d != null)
            {
                return false;
            }
        } else
        if (!d.equals(((e) (obj)).d))
        {
            return false;
        }
        if (l != ((e) (obj)).l)
        {
            return false;
        }
        if (e == null)
        {
            if (((e) (obj)).e != null)
            {
                return false;
            }
        } else
        if (!e.equals(((e) (obj)).e))
        {
            return false;
        }
        if (k != null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (((e) (obj)).k == null) goto _L1; else goto _L3
_L3:
        return false;
        if (k.equals(((e) (obj)).k)) goto _L1; else goto _L4
_L4:
        return false;
    }

    public final int hashCode()
    {
        int j3 = 0;
        int i1;
        int j1;
        int k1;
        int l1;
        int i2;
        int j2;
        int k2;
        int l2;
        int i3;
        int k3;
        int l3;
        int i4;
        if (h == null)
        {
            i1 = 0;
        } else
        {
            i1 = h.hashCode();
        }
        k3 = m;
        if (c == null)
        {
            j1 = 0;
        } else
        {
            j1 = c.hashCode();
        }
        if (i == null)
        {
            k1 = 0;
        } else
        {
            k1 = i.hashCode();
        }
        if (f == null)
        {
            l1 = 0;
        } else
        {
            l1 = f.hashCode();
        }
        if (g == null)
        {
            i2 = 0;
        } else
        {
            i2 = g.hashCode();
        }
        if (a == null)
        {
            j2 = 0;
        } else
        {
            j2 = a.hashCode();
        }
        l3 = b;
        if (j == null)
        {
            k2 = 0;
        } else
        {
            k2 = j.hashCode();
        }
        if (d == null)
        {
            l2 = 0;
        } else
        {
            l2 = d.hashCode();
        }
        i4 = l;
        if (e == null)
        {
            i3 = 0;
        } else
        {
            i3 = e.hashCode();
        }
        if (k != null)
        {
            j3 = k.hashCode();
        }
        return (i3 + ((l2 + (k2 + ((j2 + (i2 + (l1 + (k1 + (j1 + ((i1 + 31) * 31 + k3) * 31) * 31) * 31) * 31) * 31) * 31 + l3) * 31) * 31) * 31 + i4) * 31) * 31 + j3;
    }
}

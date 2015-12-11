// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import java.util.List;

// Referenced classes of package com.google.android.gms.d:
//            lc, la, ky, kz, 
//            ku, lg, le, kv

public abstract class kw extends lc
{

    protected ky r;

    public kw()
    {
    }

    private kw b()
    {
        kw kw1 = (kw)super.d();
        la.a(this, kw1);
        return kw1;
    }

    protected int a()
    {
        int j = 0;
        int k;
        if (r != null)
        {
            int i = 0;
            do
            {
                k = i;
                if (j >= r.b())
                {
                    break;
                }
                i += r.a(j).a();
                j++;
            } while (true);
        } else
        {
            k = 0;
        }
        return k;
    }

    public void a(kv kv)
    {
        if (r != null)
        {
            int i = 0;
            while (i < r.b()) 
            {
                r.a(i).a(kv);
                i++;
            }
        }
    }

    protected final boolean a(ku ku1, int i)
    {
        int j = ku1.i();
        if (!ku1.b(i))
        {
            return false;
        }
        int i1 = lg.b(i);
        int j1 = ku1.i() - j;
        Object obj;
        le le1;
        if (j1 == 0)
        {
            ku1 = lg.h;
        } else
        {
            obj = new byte[j1];
            int k1 = ku1.b;
            System.arraycopy(ku1.a, j + k1, obj, 0, j1);
            ku1 = ((ku) (obj));
        }
        le1 = new le(i, ku1);
        if (r == null)
        {
            r = new ky();
            ku1 = null;
        } else
        {
            ku1 = r;
            i = ku1.c(i1);
            if (i < 0 || ((ky) (ku1)).d[i] == ky.a)
            {
                ku1 = null;
            } else
            {
                ku1 = ((ky) (ku1)).d[i];
            }
        }
        obj = ku1;
        if (ku1 == null)
        {
            ku1 = new kz();
            obj = r;
            i = ((ky) (obj)).c(i1);
            if (i >= 0)
            {
                ((ky) (obj)).d[i] = ku1;
                obj = ku1;
            } else
            {
                int k = ~i;
                if (k < ((ky) (obj)).e && ((ky) (obj)).d[k] == ky.a)
                {
                    ((ky) (obj)).c[k] = i1;
                    ((ky) (obj)).d[k] = ku1;
                    obj = ku1;
                } else
                {
                    i = k;
                    if (((ky) (obj)).b)
                    {
                        i = k;
                        if (((ky) (obj)).e >= ((ky) (obj)).c.length)
                        {
                            ((ky) (obj)).a();
                            i = ~((ky) (obj)).c(i1);
                        }
                    }
                    if (((ky) (obj)).e >= ((ky) (obj)).c.length)
                    {
                        int l = ky.b(((ky) (obj)).e + 1);
                        int ai[] = new int[l];
                        kz akz[] = new kz[l];
                        System.arraycopy(((ky) (obj)).c, 0, ai, 0, ((ky) (obj)).c.length);
                        System.arraycopy(((ky) (obj)).d, 0, akz, 0, ((ky) (obj)).d.length);
                        obj.c = ai;
                        obj.d = akz;
                    }
                    if (((ky) (obj)).e - i != 0)
                    {
                        System.arraycopy(((ky) (obj)).c, i, ((ky) (obj)).c, i + 1, ((ky) (obj)).e - i);
                        System.arraycopy(((ky) (obj)).d, i, ((ky) (obj)).d, i + 1, ((ky) (obj)).e - i);
                    }
                    ((ky) (obj)).c[i] = i1;
                    ((ky) (obj)).d[i] = ku1;
                    obj.e = ((ky) (obj)).e + 1;
                    obj = ku1;
                }
            }
        }
        ((kz) (obj)).a.add(le1);
        return true;
    }

    protected final boolean a(kw kw1)
    {
        if (r == null || r.c())
        {
            return kw1.r == null || kw1.r.c();
        } else
        {
            return r.equals(kw1.r);
        }
    }

    protected final int c()
    {
        if (r == null || r.c())
        {
            return 0;
        } else
        {
            return r.hashCode();
        }
    }

    public Object clone()
    {
        return b();
    }

    public final lc d()
    {
        return b();
    }
}

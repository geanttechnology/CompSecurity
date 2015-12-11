// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.f;


// Referenced classes of package android.support.v4.f:
//            b

public final class i
    implements Cloneable
{

    public static final Object a = new Object();
    public boolean b;
    public int c[];
    public Object d[];
    public int e;

    public i()
    {
        this((byte)0);
    }

    private i(byte byte0)
    {
        b = false;
        byte0 = android.support.v4.f.b.a(10);
        c = new int[byte0];
        d = new Object[byte0];
        e = 0;
    }

    private i c()
    {
        Object obj;
        try
        {
            obj = (i)super.clone();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            return null;
        }
        try
        {
            obj.c = (int[])c.clone();
            obj.d = (Object[])((Object []) (d)).clone();
        }
        catch (CloneNotSupportedException clonenotsupportedexception)
        {
            return ((i) (obj));
        }
        return ((i) (obj));
    }

    private void d()
    {
        int i1 = e;
        int ai[] = c;
        Object aobj[] = d;
        int j = 0;
        int k;
        int l;
        for (k = 0; j < i1; k = l)
        {
            Object obj = aobj[j];
            l = k;
            if (obj != a)
            {
                if (j != k)
                {
                    ai[k] = ai[j];
                    aobj[k] = obj;
                    aobj[j] = null;
                }
                l = k + 1;
            }
            j++;
        }

        b = false;
        e = k;
    }

    public final int a()
    {
        if (b)
        {
            d();
        }
        return e;
    }

    public final Object a(int j)
    {
        j = android.support.v4.f.b.a(c, e, j);
        if (j < 0 || d[j] == a)
        {
            return null;
        } else
        {
            return d[j];
        }
    }

    public final void a(int j, Object obj)
    {
        int k = android.support.v4.f.b.a(c, e, j);
        if (k >= 0)
        {
            d[k] = obj;
            return;
        }
        int l = ~k;
        if (l < e && d[l] == a)
        {
            c[l] = j;
            d[l] = obj;
            return;
        }
        k = l;
        if (b)
        {
            k = l;
            if (e >= c.length)
            {
                d();
                k = ~android.support.v4.f.b.a(c, e, j);
            }
        }
        if (e >= c.length)
        {
            int i1 = android.support.v4.f.b.a(e + 1);
            int ai[] = new int[i1];
            Object aobj[] = new Object[i1];
            System.arraycopy(c, 0, ai, 0, c.length);
            System.arraycopy(((Object) (d)), 0, ((Object) (aobj)), 0, d.length);
            c = ai;
            d = aobj;
        }
        if (e - k != 0)
        {
            System.arraycopy(c, k, c, k + 1, e - k);
            System.arraycopy(((Object) (d)), k, ((Object) (d)), k + 1, e - k);
        }
        c[k] = j;
        d[k] = obj;
        e = e + 1;
    }

    public final void b()
    {
        int k = e;
        Object aobj[] = d;
        for (int j = 0; j < k; j++)
        {
            aobj[j] = null;
        }

        e = 0;
        b = false;
    }

    public final void b(int j)
    {
        if (d[j] != a)
        {
            d[j] = a;
            b = true;
        }
    }

    public final int c(int j)
    {
        if (b)
        {
            d();
        }
        return c[j];
    }

    public final Object clone()
    {
        return c();
    }

    public final Object d(int j)
    {
        if (b)
        {
            d();
        }
        return d[j];
    }

    public final int e(int j)
    {
        if (b)
        {
            d();
        }
        return android.support.v4.f.b.a(c, e, j);
    }

    public final String toString()
    {
        if (a() <= 0)
        {
            return "{}";
        }
        StringBuilder stringbuilder = new StringBuilder(e * 28);
        stringbuilder.append('{');
        int j = 0;
        while (j < e) 
        {
            if (j > 0)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append(c(j));
            stringbuilder.append('=');
            Object obj = d(j);
            if (obj != this)
            {
                stringbuilder.append(obj);
            } else
            {
                stringbuilder.append("(this Map)");
            }
            j++;
        }
        stringbuilder.append('}');
        return stringbuilder.toString();
    }

}

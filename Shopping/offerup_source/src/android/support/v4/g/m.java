// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.g;


// Referenced classes of package android.support.v4.g:
//            c

public final class m
    implements Cloneable
{

    private static final Object a = new Object();
    private boolean b;
    private int c[];
    private Object d[];
    private int e;

    public m()
    {
        this(10);
    }

    private m(int i)
    {
        b = false;
        i = android.support.v4.g.c.a(10);
        c = new int[i];
        d = new Object[i];
        e = 0;
    }

    private m c()
    {
        Object obj;
        try
        {
            obj = (m)super.clone();
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
            return ((m) (obj));
        }
        return ((m) (obj));
    }

    public final int a()
    {
        return e;
    }

    public final int a(int i)
    {
        return c[i];
    }

    public final Object b(int i)
    {
        return d[i];
    }

    public final void b()
    {
        int j = e;
        Object aobj[] = d;
        for (int i = 0; i < j; i++)
        {
            aobj[i] = null;
        }

        e = 0;
        b = false;
    }

    public final Object clone()
    {
        return c();
    }

    public final String toString()
    {
        if (e <= 0)
        {
            return "{}";
        }
        StringBuilder stringbuilder = new StringBuilder(e * 28);
        stringbuilder.append('{');
        int i = 0;
        while (i < e) 
        {
            if (i > 0)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append(c[i]);
            stringbuilder.append('=');
            Object obj = d[i];
            if (obj != this)
            {
                stringbuilder.append(obj);
            } else
            {
                stringbuilder.append("(this Map)");
            }
            i++;
        }
        stringbuilder.append('}');
        return stringbuilder.toString();
    }

}

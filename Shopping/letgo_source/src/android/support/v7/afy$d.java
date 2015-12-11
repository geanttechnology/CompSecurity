// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;


// Referenced classes of package android.support.v7:
//            afy

static final class e
    implements java.util.try
{

    oString a;
    oString b;
    oString c;
    oString d;
    oString e;
    final Object f;
    Object g;
    int h;

    public e a()
    {
        e e1 = b;
        e e2 = this;
        e e3;
        for (; e1 != null; e1 = e3)
        {
            e3 = e1.b;
            e2 = e1;
        }

        return e2;
    }

    public b b()
    {
        b b1 = c;
        b b2 = this;
        b b3;
        for (; b1 != null; b1 = b3)
        {
            b3 = b1.c;
            b2 = b1;
        }

        return b2;
    }

    public boolean equals(Object obj)
    {
        boolean flag;
        boolean flag1;
        flag1 = false;
        flag = flag1;
        if (!(obj instanceof java.util.try)) goto _L2; else goto _L1
_L1:
        obj = (java.util.try)obj;
        if (f != null) goto _L4; else goto _L3
_L3:
        flag = flag1;
        if (((java.util.try) (obj)).getKey() != null) goto _L2; else goto _L5
_L5:
        if (g != null) goto _L7; else goto _L6
_L6:
        flag = flag1;
        if (((java.util.try) (obj)).getValue() != null) goto _L2; else goto _L8
_L8:
        flag = true;
_L2:
        return flag;
_L4:
        flag = flag1;
        if (!f.equals(((java.util.try) (obj)).getKey())) goto _L2; else goto _L5
_L7:
        flag = flag1;
        if (!g.equals(((java.util.try) (obj)).getValue())) goto _L2; else goto _L8
    }

    public Object getKey()
    {
        return f;
    }

    public Object getValue()
    {
        return g;
    }

    public int hashCode()
    {
        int j = 0;
        int i;
        if (f == null)
        {
            i = 0;
        } else
        {
            i = f.hashCode();
        }
        if (g != null)
        {
            j = g.hashCode();
        }
        return i ^ j;
    }

    public Object setValue(Object obj)
    {
        Object obj1 = g;
        g = obj;
        return obj1;
    }

    public String toString()
    {
        return (new StringBuilder()).append(f).append("=").append(g).toString();
    }

    ()
    {
        f = null;
        e = this;
        d = this;
    }

    d(d d1, Object obj, d d2, d d3)
    {
        a = d1;
        f = obj;
        h = 1;
        d = d2;
        e = d3;
        d3.d = this;
        d2.e = this;
    }
}

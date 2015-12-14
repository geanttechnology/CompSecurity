// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;


// Referenced classes of package com.flurry.sdk:
//            dw

public class eb
    implements Comparable
{

    private final String a;
    private final String b;

    public eb(String s, String s1)
    {
        a = s;
        b = s1;
    }

    public int a(eb eb1)
    {
        int i = a.compareTo(eb1.a);
        if (i != 0)
        {
            return i;
        } else
        {
            return b.compareTo(eb1.b);
        }
    }

    public String a()
    {
        return dw.a(a).concat("=").concat(dw.a(b));
    }

    public int compareTo(Object obj)
    {
        return a((eb)obj);
    }

    public boolean equals(Object obj)
    {
        if (obj != null)
        {
            if (obj == this)
            {
                return true;
            }
            if (obj instanceof eb)
            {
                obj = (eb)obj;
                if (((eb) (obj)).a.equals(a) && ((eb) (obj)).b.equals(b))
                {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode()
    {
        return a.hashCode() + b.hashCode();
    }
}

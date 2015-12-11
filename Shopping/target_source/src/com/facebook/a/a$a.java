// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.a;

import com.facebook.AccessToken;
import com.facebook.i;
import com.facebook.internal.o;
import java.io.Serializable;

// Referenced classes of package com.facebook.a:
//            a

private static class b
    implements Serializable
{

    private final String a;
    private final String b;

    String a()
    {
        return a;
    }

    String b()
    {
        return b;
    }

    public boolean equals(Object obj)
    {
        if (obj instanceof b)
        {
            if (o.a(((al.o.a) (obj = (al.o.a)obj)).a, a) && o.a(((al.o.a) (obj)).b, b))
            {
                return true;
            }
        }
        return false;
    }

    public int hashCode()
    {
        int k = 0;
        int j;
        if (a == null)
        {
            j = 0;
        } else
        {
            j = a.hashCode();
        }
        if (b != null)
        {
            k = b.hashCode();
        }
        return j ^ k;
    }

    Token(AccessToken accesstoken)
    {
        this(accesstoken.b(), i.i());
    }

    Token.b(String s, String s1)
    {
        String s2 = s;
        if (o.a(s))
        {
            s2 = null;
        }
        a = s2;
        b = s1;
    }
}

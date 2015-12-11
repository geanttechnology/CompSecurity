// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import com.facebook.AccessToken;
import com.facebook.k;
import java.io.Serializable;

// Referenced classes of package android.support.v7:
//            jg, kb

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
            if (kb.a(((b) (obj = (b)obj)).a, a) && kb.a(((a) (obj)).b, b))
            {
                return true;
            }
        }
        return false;
    }

    public int hashCode()
    {
        int j = 0;
        int i;
        if (a == null)
        {
            i = 0;
        } else
        {
            i = a.hashCode();
        }
        if (b != null)
        {
            j = b.hashCode();
        }
        return i ^ j;
    }

    (AccessToken accesstoken)
    {
        this(accesstoken.b(), k.i());
    }

    .b(String s, String s1)
    {
        String s2 = s;
        if (kb.a(s))
        {
            s2 = null;
        }
        a = s2;
        b = s1;
    }
}

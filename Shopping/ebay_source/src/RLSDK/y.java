// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package RLSDK;

import java.util.Enumeration;
import java.util.Hashtable;

// Referenced classes of package RLSDK:
//            z, aa, n

public final class y
{

    private final String a;
    private final byte b[];
    private aa c[];
    private final n d;
    private Hashtable e;
    private final long f;

    public y(String s, byte abyte0[], aa aaa[], n n)
    {
        this(s, abyte0, aaa, n, System.currentTimeMillis());
    }

    private y(String s, byte abyte0[], aa aaa[], n n, long l)
    {
        if (s == null && abyte0 == null)
        {
            throw new IllegalArgumentException("Text and bytes are null");
        } else
        {
            a = s;
            b = abyte0;
            c = aaa;
            d = n;
            e = null;
            f = l;
            return;
        }
    }

    public final String a()
    {
        return a;
    }

    public final void a(z z1, Object obj)
    {
        if (e == null)
        {
            e = new Hashtable(3);
        }
        e.put(z1, obj);
    }

    public final void a(Hashtable hashtable)
    {
        if (hashtable != null)
        {
            if (e == null)
            {
                e = hashtable;
            } else
            {
                Enumeration enumeration = hashtable.keys();
                while (enumeration.hasMoreElements()) 
                {
                    z z1 = (z)enumeration.nextElement();
                    Object obj = hashtable.get(z1);
                    e.put(z1, obj);
                }
            }
        }
    }

    public final void a(aa aaa[])
    {
        if (c == null)
        {
            c = aaa;
        } else
        if (aaa != null && aaa.length > 0)
        {
            aa aaa1[] = new aa[c.length + aaa.length];
            System.arraycopy(c, 0, aaa1, 0, c.length);
            System.arraycopy(aaa, 0, aaa1, c.length, aaa.length);
            c = aaa1;
            return;
        }
    }

    public final aa[] b()
    {
        return c;
    }

    public final n c()
    {
        return d;
    }

    public final Hashtable d()
    {
        return e;
    }

    public final String toString()
    {
        if (a == null)
        {
            return (new StringBuilder("[")).append(b.length).append(" bytes]").toString();
        } else
        {
            return a;
        }
    }
}

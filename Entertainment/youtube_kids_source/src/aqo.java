// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;

public final class aqo
{

    public final long a;
    public final long b;
    private final Uri c;
    private final String d;
    private int e;

    public aqo(Uri uri, String s, long l, long l1)
    {
        boolean flag;
        if (uri != null || s != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        a.a(flag);
        c = uri;
        d = s;
        a = l;
        b = l1;
    }

    public final Uri a()
    {
        return atp.a(c, d);
    }

    public final aqo a(aqo aqo1)
    {
        long l = -1L;
        if (aqo1 != null && a().equals(aqo1.a()))
        {
            if (b != -1L && a + b == aqo1.a)
            {
                Uri uri = c;
                String s = d;
                long l1 = a;
                if (aqo1.b != -1L)
                {
                    l = b + aqo1.b;
                }
                return new aqo(uri, s, l1, l);
            }
            if (aqo1.b != -1L && aqo1.a + aqo1.b == a)
            {
                Uri uri1 = c;
                String s1 = d;
                long l2 = aqo1.a;
                if (b != -1L)
                {
                    l = aqo1.b + b;
                }
                return new aqo(uri1, s1, l2, l);
            }
        }
        return null;
    }

    public final boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null || getClass() != obj.getClass())
            {
                return false;
            }
            obj = (aqo)obj;
            if (a != ((aqo) (obj)).a || b != ((aqo) (obj)).b || !a().equals(((aqo) (obj)).a()))
            {
                return false;
            }
        }
        return true;
    }

    public final int hashCode()
    {
        if (e == 0)
        {
            e = (((int)a + 527) * 31 + (int)b) * 31 + a().hashCode();
        }
        return e;
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Arrays;

public final class alw
{

    public static final alw f = (new alx()).a();
    public final String a;
    public final int b;
    final cxu c;
    public final String d;
    public final int e;

    alw(alx alx1)
    {
        a = alx1.a;
        b = alx1.b;
        c = alx1.c;
        d = alx1.d;
        e = alx1.e;
    }

    public final boolean a()
    {
        return !"".equals(a);
    }

    public final boolean a(String s)
    {
        if (s == null)
        {
            return false;
        } else
        {
            return a.equals(s);
        }
    }

    public final boolean b(String s)
    {
        if (s == null)
        {
            return false;
        } else
        {
            return chv.a(d, s);
        }
    }

    public final boolean equals(Object obj)
    {
        if (obj != null && (obj instanceof alw))
        {
            if (a(((alw) (obj = (alw)obj)).a) && b(((alw) (obj)).d) && e == ((alw) (obj)).e)
            {
                return true;
            }
        }
        return false;
    }

    public final int hashCode()
    {
        return Arrays.hashCode(new Object[] {
            a, d, Integer.valueOf(e)
        });
    }

    public final String toString()
    {
        return String.format("MdxPlaybackDescriptor:\n  VideoId:%s\n  PlaylistId:%s\n  Index:%d", new Object[] {
            a, d, Integer.valueOf(e)
        });
    }

}

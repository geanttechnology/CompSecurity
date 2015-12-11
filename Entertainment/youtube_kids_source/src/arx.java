// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;

public final class arx
{

    public final Uri a;
    public final boolean b;
    public final long c;
    public final long d;
    public final long e;
    public final String f;

    public arx(Uri uri)
    {
        this(uri, 0L, -1L, null);
    }

    public arx(Uri uri, long l, long l1, String s)
    {
        this(uri, l, l1, s, l, true);
    }

    public arx(Uri uri, long l, long l1, String s, long l2)
    {
        this(uri, l, l1, s, l2, false);
    }

    public arx(Uri uri, long l, long l1, String s, long l2, boolean flag)
    {
label0:
        {
            boolean flag2 = false;
            super();
            boolean flag1;
            if (l >= 0L)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            a.a(flag1);
            if (l2 >= 0L)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            a.a(flag1);
            if (l1 > 0L || l1 == -1L)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            a.a(flag1);
            if (l != l2)
            {
                flag1 = flag2;
                if (flag)
                {
                    break label0;
                }
            }
            flag1 = true;
        }
        a.a(flag1);
        a = uri;
        b = flag;
        c = l;
        d = l2;
        e = l1;
        f = s;
    }

    public final String toString()
    {
        String s = String.valueOf(a);
        boolean flag = b;
        long l = c;
        long l1 = d;
        long l2 = e;
        String s1 = f;
        return (new StringBuilder(String.valueOf(s).length() + 85 + String.valueOf(s1).length())).append("DataSpec[").append(s).append(", ").append(flag).append(", ").append(l).append(", ").append(l1).append(", ").append(l2).append(", ").append(s1).append("]").toString();
    }
}

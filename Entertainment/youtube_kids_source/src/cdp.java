// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.text.TextUtils;

public final class cdp
{

    public final String a;
    public final String b;
    public final String c;
    public final String d;

    public cdp(String s, String s1, String s2, String s3)
    {
        a = s;
        b = s1;
        c = s2;
        d = s3;
    }

    public final boolean equals(Object obj)
    {
        if (obj instanceof cdp)
        {
            cdp cdp1 = (cdp)obj;
            return obj == this || TextUtils.equals(a, cdp1.a) && TextUtils.equals(b, cdp1.b) && TextUtils.equals(c, cdp1.c) && TextUtils.equals(d, cdp1.d);
        } else
        {
            return false;
        }
    }

    public final int hashCode()
    {
        int l = 0;
        int i;
        int j;
        int k;
        if (a != null)
        {
            i = a.hashCode();
        } else
        {
            i = 0;
        }
        if (b != null)
        {
            j = b.hashCode();
        } else
        {
            j = 0;
        }
        if (c != null)
        {
            k = c.hashCode();
        } else
        {
            k = 0;
        }
        if (d != null)
        {
            l = d.hashCode();
        }
        return (k + (j + (i - 629) * 37) * 37) * 37 + l;
    }

    public final String toString()
    {
        String s = a;
        String s1 = b;
        String s2 = c;
        String s3 = d;
        return (new StringBuilder(String.valueOf(s).length() + 41 + String.valueOf(s1).length() + String.valueOf(s2).length() + String.valueOf(s3).length())).append("{domain:").append(s).append(",code:").append(s1).append(",location:").append(s2).append(",internalReason:").append(s3).append("}").toString();
    }
}

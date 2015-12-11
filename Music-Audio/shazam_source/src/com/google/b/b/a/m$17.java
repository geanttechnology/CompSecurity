// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.b.b.a;

import com.google.b.d.a;
import com.google.b.d.b;
import com.google.b.d.c;
import com.google.b.x;
import java.util.Locale;
import java.util.StringTokenizer;

// Referenced classes of package com.google.b.b.a:
//            m

static final class zer extends x
{

    public final Object a(a a1)
    {
        if (a1.f() == b.i)
        {
            a1.k();
            return null;
        }
        Object obj = new StringTokenizer(a1.i(), "_");
        String s;
        if (((StringTokenizer) (obj)).hasMoreElements())
        {
            a1 = ((StringTokenizer) (obj)).nextToken();
        } else
        {
            a1 = null;
        }
        if (((StringTokenizer) (obj)).hasMoreElements())
        {
            s = ((StringTokenizer) (obj)).nextToken();
        } else
        {
            s = null;
        }
        if (((StringTokenizer) (obj)).hasMoreElements())
        {
            obj = ((StringTokenizer) (obj)).nextToken();
        } else
        {
            obj = null;
        }
        if (s == null && obj == null)
        {
            return new Locale(a1);
        }
        if (obj == null)
        {
            return new Locale(a1, s);
        } else
        {
            return new Locale(a1, s, ((String) (obj)));
        }
    }

    public final void a(c c1, Object obj)
    {
        obj = (Locale)obj;
        if (obj == null)
        {
            obj = null;
        } else
        {
            obj = ((Locale) (obj)).toString();
        }
        c1.b(((String) (obj)));
    }

    zer()
    {
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import java.util.Locale;
import java.util.StringTokenizer;

// Referenced classes of package com.flurry.sdk:
//            ir, jv, jx, jy, 
//            jz

final class izer extends ir
{

    public Locale a(jx jx1)
    {
        if (jx1.f() == jy.i)
        {
            jx1.j();
            return null;
        }
        Object obj = new StringTokenizer(jx1.h(), "_");
        String s;
        if (((StringTokenizer) (obj)).hasMoreElements())
        {
            jx1 = ((StringTokenizer) (obj)).nextToken();
        } else
        {
            jx1 = null;
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
            return new Locale(jx1);
        }
        if (obj == null)
        {
            return new Locale(jx1, s);
        } else
        {
            return new Locale(jx1, s, ((String) (obj)));
        }
    }

    public volatile void a(jz jz1, Object obj)
    {
        a(jz1, (Locale)obj);
    }

    public void a(jz jz1, Locale locale)
    {
        if (locale == null)
        {
            locale = null;
        } else
        {
            locale = locale.toString();
        }
        jz1.b(locale);
    }

    public Object b(jx jx1)
    {
        return a(jx1);
    }

    izer()
    {
    }
}

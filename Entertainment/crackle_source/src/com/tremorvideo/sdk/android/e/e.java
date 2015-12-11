// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.e;

import java.util.Map;

// Referenced classes of package com.tremorvideo.sdk.android.e:
//            p

abstract class e
{

    protected Map a;
    protected p b;

    e(Map map, p p)
    {
        a = map;
        b = p;
    }

    protected int a(String s)
    {
        s = (String)a.get(s);
        if (s == null)
        {
            return -1;
        }
        int i;
        try
        {
            i = Integer.parseInt(s, 10);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return -1;
        }
        return i;
    }

    abstract void a();

    protected String b(String s)
    {
        return (String)a.get(s);
    }

    protected boolean c(String s)
    {
        return "true".equals(a.get(s));
    }
}

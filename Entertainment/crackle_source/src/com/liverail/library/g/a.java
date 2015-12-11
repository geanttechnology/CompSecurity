// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.liverail.library.g;

import java.util.HashMap;
import java.util.Locale;

// Referenced classes of package com.liverail.library.g:
//            b

public class a
{

    public final int a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public b i;
    public int j;
    public String k;
    public String l;
    public String m;
    public String n;
    public HashMap o;

    public a(int i1)
    {
        o = new HashMap();
        a = i1;
    }

    public String toString()
    {
        Locale locale = Locale.US;
        String s;
        if (a == 1)
        {
            s = "in";
        } else
        {
            s = "ov";
        }
        return String.format(locale, "[Ad type=%s adapter=%s cid=%s oid=%s nid=%s coid=%s ss=%s nr=%s title=%s]", new Object[] {
            s, b, g, h, c, d, e, f, k
        });
    }
}

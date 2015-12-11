// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Referenced classes of package android.support.v7:
//            xh, lt, ado

public static class <init>
{

    private final List a;
    private final Map b;
    private String c;
    private int d;

    public <init> a()
    {
        return new <init>(a, b, c, d, null);
    }

    public d a(int i)
    {
        d = i;
        return this;
    }

    public d a(d d1)
    {
        String s = ado.a(()d1.b().get(lt.bk.toString()));
        List list = (List)b.get(s);
        Object obj = list;
        if (list == null)
        {
            obj = new ArrayList();
            b.put(s, obj);
        }
        ((List) (obj)).add(d1);
        return this;
    }

    public b a(b b1)
    {
        a.add(b1);
        return this;
    }

    public a a(String s)
    {
        c = s;
        return this;
    }

    private ()
    {
        a = new ArrayList();
        b = new HashMap();
        c = "";
        d = 0;
    }

    d(d d1)
    {
        this();
    }
}

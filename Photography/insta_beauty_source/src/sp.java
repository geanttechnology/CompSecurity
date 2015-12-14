// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.HashMap;

class sp
    implements kk
{

    final int a;
    final so b;

    sp(so so1, int i)
    {
        b = so1;
        a = i;
        super();
    }

    public void a()
    {
        if (b.c != null)
        {
            b.c.a(true, (String)((HashMap)b.b.get(a)).get("itemIdStr"));
        }
        ((HashMap)b.b.get(a)).put("itemIsChecked", Boolean.valueOf(true));
        pt.a((String)((HashMap)b.b.get(a)).get("itemIdStr"), b.a, true);
    }

    public void b()
    {
        if (b.c != null)
        {
            b.c.a(false, (String)((HashMap)b.b.get(a)).get("itemIdStr"));
        }
        ((HashMap)b.b.get(a)).put("itemIsChecked", Boolean.valueOf(false));
        pt.a((String)((HashMap)b.b.get(a)).get("itemIdStr"), b.a, false);
    }
}

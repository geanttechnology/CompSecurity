// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.h;

import com.shazam.h.c.a;
import com.shazam.h.c.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.shazam.h:
//            e, n

public static final class <init>
{

    public int a;
    public int b;
    public boolean c;
    public boolean d;
    Map e;
    final List f = new ArrayList();
    public a g;
    public String h;

    public final <init> a(n n)
    {
        f.add(n);
        return this;
    }

    public final e a()
    {
        return new e(this, (byte)0);
    }

    public st()
    {
        e = new HashMap();
        g = new b();
    }
}

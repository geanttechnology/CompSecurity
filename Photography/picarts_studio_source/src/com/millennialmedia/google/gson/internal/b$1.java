// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.google.gson.internal;

import com.millennialmedia.google.gson.b;
import com.millennialmedia.google.gson.i;
import com.millennialmedia.google.gson.j;
import com.millennialmedia.google.gson.stream.a;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.millennialmedia.google.gson.internal:
//            b

final class e extends i
{

    private i a;
    private boolean b;
    private boolean c;
    private b d;
    private myobfuscated.ap.a e;
    private com.millennialmedia.google.gson.internal.b f;

    private i a()
    {
        Object obj = a;
        if (obj != null)
        {
            return ((i) (obj));
        }
        obj = d;
        com.millennialmedia.google.gson.internal.b b1 = f;
        myobfuscated.ap.a a1 = e;
        Iterator iterator = ((b) (obj)).a.iterator();
        boolean flag = false;
        while (iterator.hasNext()) 
        {
            Object obj1 = (j)iterator.next();
            if (!flag)
            {
                if (obj1 == b1)
                {
                    flag = true;
                }
            } else
            {
                obj1 = ((j) (obj1)).a(((b) (obj)), a1);
                if (obj1 != null)
                {
                    a = ((i) (obj1));
                    return ((i) (obj1));
                }
            }
        }
        throw new IllegalArgumentException((new StringBuilder("GSON cannot serialize ")).append(a1).toString());
    }

    public final Object a(a a1)
    {
        if (b)
        {
            a1.o();
            return null;
        } else
        {
            return a().a(a1);
        }
    }

    public final void a(com.millennialmedia.google.gson.stream.b b1, Object obj)
    {
        if (c)
        {
            b1.e();
            return;
        } else
        {
            a().a(b1, obj);
            return;
        }
    }

    (com.millennialmedia.google.gson.internal.b b1, boolean flag, boolean flag1, b b2, myobfuscated.ap.a a1)
    {
        f = b1;
        b = flag;
        c = flag1;
        d = b2;
        e = a1;
        super();
    }
}

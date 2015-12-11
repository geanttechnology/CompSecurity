// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.apigee.f.a;

import com.google.b.l;
import com.google.b.s;
import com.google.b.t;
import java.lang.reflect.Type;

// Referenced classes of package com.target.mothership.services.apigee.f.a:
//            b

public static class 
    implements t
{

    public l a(b b1, Type type, s s)
    {
        if (b.a(b1) == 1)
        {
            return b.b(b1);
        } else
        {
            return b.c(b1);
        }
    }

    public l serialize(Object obj, Type type, s s)
    {
        return a((b)obj, type, s);
    }

    public ()
    {
    }
}

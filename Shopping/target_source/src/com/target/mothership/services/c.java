// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services;

import com.google.b.f;
import com.target.mothership.b;

// Referenced classes of package com.target.mothership.services:
//            aa, v

public final class c
    implements aa
{

    private Class classOfR;

    public c(Class class1)
    {
        classOfR = class1;
    }

    public Object a(v v1)
    {
        if (v1 == null || v1.a() == null)
        {
            return null;
        } else
        {
            return b.a().k().a(v1.a(), classOfR);
        }
    }

    public volatile Object a(Object obj)
    {
        return a((v)obj);
    }
}

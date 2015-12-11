// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.c;

import java.util.Collection;
import java.util.Set;

// Referenced classes of package com.google.a.c:
//            s

public abstract class u extends s
    implements Set
{

    public u()
    {
    }

    public Collection a()
    {
        return c();
    }

    public Object b()
    {
        return c();
    }

    public abstract Set c();

    public boolean equals(Object obj)
    {
        return obj == this || c().equals(obj);
    }

    public int hashCode()
    {
        return c().hashCode();
    }
}

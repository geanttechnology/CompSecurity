// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.c;

import java.util.AbstractCollection;

// Referenced classes of package com.google.a.c:
//            as, ar

static abstract class llection extends AbstractCollection
{

    abstract ar a();

    public void clear()
    {
        a().c();
    }

    public boolean contains(Object obj)
    {
        if (obj instanceof java.util.ntry)
        {
            obj = (java.util.ntry)obj;
            return a().b(((java.util.ntry) (obj)).getKey(), ((java.util.ntry) (obj)).getValue());
        } else
        {
            return false;
        }
    }

    public boolean remove(Object obj)
    {
        if (obj instanceof java.util.ntry)
        {
            obj = (java.util.ntry)obj;
            return a().c(((java.util.ntry) (obj)).getKey(), ((java.util.ntry) (obj)).getValue());
        } else
        {
            return false;
        }
    }

    public int size()
    {
        return a().b();
    }

    llection()
    {
    }
}

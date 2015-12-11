// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import java.util.AbstractSet;
import java.util.Iterator;

// Referenced classes of package com.flurry.sdk:
//            je

class t extends AbstractSet
{

    final je a;

    public void clear()
    {
        a.clear();
    }

    public boolean contains(Object obj)
    {
        return (obj instanceof java.util.ntry) && a.a((java.util.ntry)obj) != null;
    }

    public Iterator iterator()
    {
        return new je.c() {

            final je.a a;

            public java.util.Map.Entry a()
            {
                return b();
            }

            public Object next()
            {
                return a();
            }

            
            {
                a = je.a.this;
                super(je.a.this.a, null);
            }
        };
    }

    public boolean remove(Object obj)
    {
        if (obj instanceof java.util.ntry)
        {
            if ((obj = a.a((java.util.ntry)obj)) != null)
            {
                a.a(((a) (obj)), true);
                return true;
            }
        }
        return false;
    }

    public int size()
    {
        return a.c;
    }

    a(je je1)
    {
        a = je1;
        super();
    }
}

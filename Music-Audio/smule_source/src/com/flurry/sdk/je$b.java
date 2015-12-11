// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import java.util.AbstractSet;
import java.util.Iterator;

// Referenced classes of package com.flurry.sdk:
//            je

final class t extends AbstractSet
{

    final je a;

    public void clear()
    {
        a.clear();
    }

    public boolean contains(Object obj)
    {
        return a.containsKey(obj);
    }

    public Iterator iterator()
    {
        return new je.c() {

            final je.b a;

            public Object next()
            {
                return b().f;
            }

            
            {
                a = je.b.this;
                super(je.b.this.a, null);
            }
        };
    }

    public boolean remove(Object obj)
    {
        return a.b(obj) != null;
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

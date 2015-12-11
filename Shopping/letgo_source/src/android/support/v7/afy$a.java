// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.util.AbstractSet;
import java.util.Iterator;

// Referenced classes of package android.support.v7:
//            afy

class it> extends AbstractSet
{

    final afy a;

    public void clear()
    {
        a.clear();
    }

    public boolean contains(Object obj)
    {
        return (obj instanceof java.util.try) && a.a((java.util.try)obj) != null;
    }

    public Iterator iterator()
    {
        return new afy.c() {

            final afy.a a;

            public java.util.Map.Entry a()
            {
                return b();
            }

            public Object next()
            {
                return a();
            }

            
            {
                a = afy.a.this;
                super(afy.a.this.a, null);
            }
        };
    }

    public boolean remove(Object obj)
    {
        if (obj instanceof java.util.try)
        {
            if ((obj = a.a((java.util.try)obj)) != null)
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

    a(afy afy1)
    {
        a = afy1;
        super();
    }
}

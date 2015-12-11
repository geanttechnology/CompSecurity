// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.util.AbstractSet;
import java.util.Iterator;

// Referenced classes of package android.support.v7:
//            afy

final class it> extends AbstractSet
{

    final afy a;

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
        return new afy.c() {

            final afy.b a;

            public Object next()
            {
                return b().f;
            }

            
            {
                a = afy.b.this;
                super(afy.b.this.a, null);
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

    a(afy afy1)
    {
        a = afy1;
        super();
    }
}

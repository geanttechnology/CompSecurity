// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.api.a.g;

import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.NoSuchElementException;

// Referenced classes of package com.google.api.a.g:
//            ac

static final class a
    implements Iterable
{

    final Object a;

    public final Iterator iterator()
    {
        return new Iterator() {

            final int a;
            int b;
            final ac._cls1 c;

            public final boolean hasNext()
            {
                return b < a;
            }

            public final Object next()
            {
                if (!hasNext())
                {
                    throw new NoSuchElementException();
                } else
                {
                    Object obj = c.a;
                    int i = b;
                    b = i + 1;
                    return Array.get(obj, i);
                }
            }

            public final void remove()
            {
                throw new UnsupportedOperationException();
            }

            
            {
                c = ac._cls1.this;
                super();
                a = Array.getLength(c.a);
                b = 0;
            }
        };
    }

    _cls1.b(Object obj)
    {
        a = obj;
        super();
    }
}

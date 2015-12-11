// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import java.util.AbstractQueue;
import java.util.Iterator;

// Referenced classes of package com.tapjoy.internal:
//            bd

public abstract class az extends AbstractQueue
    implements bd
{

    public az()
    {
    }

    public Iterator iterator()
    {
        return new Iterator() {

            final az a;
            private int b;

            public final boolean hasNext()
            {
                return b < a.size();
            }

            public final Object next()
            {
                az az1 = a;
                int i = b;
                b = i + 1;
                return az1.a(i);
            }

            public final void remove()
            {
                if (b == 1)
                {
                    a.b(1);
                    b = 0;
                    return;
                } else
                {
                    throw new UnsupportedOperationException("For the first element only");
                }
            }

            
            {
                a = az.this;
                super();
                b = 0;
            }
        };
    }
}

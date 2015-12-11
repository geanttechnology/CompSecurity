// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.c;

import com.google.a.a.h;
import java.util.Iterator;

// Referenced classes of package com.google.a.c:
//            b, ap

static final class it> extends b
{

    final Iterator b;
    final h c;

    protected final Object a()
    {
        while (b.hasNext()) 
        {
            Object obj = b.next();
            if (c.a(obj))
            {
                return obj;
            }
        }
        super.a = ;
        return null;
    }

    (Iterator iterator, h h1)
    {
        b = iterator;
        c = h1;
        super();
    }
}

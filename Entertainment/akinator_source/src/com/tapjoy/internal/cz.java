// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import java.util.Iterator;
import java.util.NoSuchElementException;

// Referenced classes of package com.tapjoy.internal:
//            dc

public final class cz
{

    static final dc a = new dc() {

        public final boolean hasNext()
        {
            return false;
        }

        public final Object next()
        {
            throw new NoSuchElementException();
        }

    };
    private static final Iterator b = new Iterator() {

        public final boolean hasNext()
        {
            return false;
        }

        public final Object next()
        {
            throw new NoSuchElementException();
        }

        public final void remove()
        {
            throw new IllegalStateException();
        }

    };

    public static Object a(Iterator iterator)
    {
        if (iterator.hasNext())
        {
            return iterator.next();
        } else
        {
            return null;
        }
    }

}

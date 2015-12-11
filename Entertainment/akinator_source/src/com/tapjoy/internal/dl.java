// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Collection;
import java.util.Iterator;

// Referenced classes of package com.tapjoy.internal:
//            dx, dq, dv

public abstract class dl
    implements dx
{
    public static abstract class a
        implements dx.a
    {

        private static void a(Iterable iterable)
        {
            for (iterable = iterable.iterator(); iterable.hasNext();)
            {
                if (iterable.next() == null)
                {
                    throw new NullPointerException();
                }
            }

        }

        public static void a(Iterable iterable, Collection collection)
        {
            if (iterable instanceof dv)
            {
                a(((Iterable) (((dv)iterable).a())));
                collection.addAll((Collection)iterable);
            } else
            {
                if (iterable instanceof Collection)
                {
                    a(iterable);
                    collection.addAll((Collection)iterable);
                    return;
                }
                iterable = iterable.iterator();
                while (iterable.hasNext()) 
                {
                    Object obj = iterable.next();
                    if (obj == null)
                    {
                        throw new NullPointerException();
                    }
                    collection.add(obj);
                }
            }
        }

        public abstract a a();

        public Object clone()
        {
            return a();
        }

        public a()
        {
        }
    }


    protected int a;

    public dl()
    {
        a = 0;
    }

    public final void a(OutputStream outputstream)
    {
        int i = 4096;
        int j = b();
        if (j <= 4096)
        {
            i = j;
        }
        outputstream = dq.a(outputstream, i);
        a(((dq) (outputstream)));
        outputstream.a();
    }

    public final byte[] a()
    {
        Object obj;
        obj = new byte[b()];
        dq dq1 = new dq(((byte []) (obj)), obj.length);
        a(dq1);
        if (dq1.c == null)
        {
            if (dq1.a - dq1.b != 0)
            {
                throw new IllegalStateException("Did not write as much data as expected.");
            }
            break MISSING_BLOCK_LABEL_74;
        }
        try
        {
            throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array.");
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", ((Throwable) (obj)));
        }
        return ((byte []) (obj));
    }
}

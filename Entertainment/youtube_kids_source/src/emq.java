// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.Closeable;
import java.io.IOException;
import java.util.LinkedList;

public final class emq
    implements Closeable
{

    private static final emt a;
    private emt b;
    private final LinkedList c = new LinkedList();
    private Throwable d;

    private emq(emt emt1)
    {
        b = (emt)f.b(emt1);
    }

    public static emq a()
    {
        return new emq(a);
    }

    public final Closeable a(Closeable closeable)
    {
        c.addFirst(closeable);
        return closeable;
    }

    public final RuntimeException a(Throwable throwable)
    {
        d = throwable;
        a.b(throwable, java/io/IOException);
        throw a.b(throwable);
    }

    public final void close()
    {
        Throwable throwable = d;
        while (!c.isEmpty()) 
        {
            Closeable closeable = (Closeable)c.removeFirst();
            try
            {
                closeable.close();
            }
            catch (Throwable throwable1)
            {
                if (throwable == null)
                {
                    throwable = throwable1;
                } else
                {
                    b.a(closeable, throwable, throwable1);
                }
            }
        }
        if (d == null && throwable != null)
        {
            a.b(throwable, java/io/IOException);
            throw new AssertionError(throwable);
        } else
        {
            return;
        }
    }

    static 
    {
        Object obj;
        if (ems.a())
        {
            obj = ems.a;
        } else
        {
            obj = emr.a;
        }
        a = ((emt) (obj));
    }
}

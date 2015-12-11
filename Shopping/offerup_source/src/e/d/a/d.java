// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package e.d.a;

import e.c.b;
import e.j;
import java.util.Iterator;

// Referenced classes of package e.d.a:
//            e

public class d
    implements b
{

    private Iterable a;

    public d(Iterable iterable)
    {
        if (iterable == null)
        {
            throw new NullPointerException("iterable must not be null");
        } else
        {
            a = iterable;
            return;
        }
    }

    public final void call(Object obj)
    {
        obj = (j)obj;
        Iterator iterator = a.iterator();
        if (!iterator.hasNext() && !((j) (obj)).c())
        {
            ((j) (obj)).a();
            return;
        } else
        {
            ((j) (obj)).a(new e(((j) (obj)), iterator, (byte)0));
            return;
        }
    }
}

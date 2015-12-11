// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Iterator;

final class ega extends efy
{

    private efy b;

    ega(efy efy1, efy efy2)
    {
        b = efy1;
        super(efy2);
    }

    public final Appendable a(Appendable appendable, Iterator iterator)
    {
        f.b(appendable, "appendable");
        f.b(iterator, "parts");
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Object obj = iterator.next();
            if (obj == null)
            {
                continue;
            }
            appendable.append(b.a(obj));
            break;
        } while (true);
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Object obj1 = iterator.next();
            if (obj1 != null)
            {
                appendable.append(b.a);
                appendable.append(b.a(obj1));
            }
        } while (true);
        return appendable;
    }

    public final efy b(String s)
    {
        f.b(s);
        throw new UnsupportedOperationException("already specified skipNulls");
    }

    public final egc c(String s)
    {
        f.b(s);
        throw new UnsupportedOperationException("can't use .skipNulls() with maps");
    }
}

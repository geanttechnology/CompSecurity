// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.Serializable;

final class ejz extends ekb
    implements Serializable
{

    static final ejz a = new ejz();
    private static final long serialVersionUID = 0L;

    private ejz()
    {
    }

    private Object readResolve()
    {
        return a;
    }

    public final int compare(Object obj, Object obj1)
    {
        obj = (Comparable)obj;
        obj1 = (Comparable)obj1;
        f.b(obj);
        f.b(obj1);
        if (obj == obj1)
        {
            return 0;
        } else
        {
            return ((Comparable) (obj)).compareTo(obj1);
        }
    }

    public final String toString()
    {
        return "Ordering.natural()";
    }

}

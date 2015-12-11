// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package b.a.b;

import b.a.c.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

// Referenced classes of package b.a.b:
//            d

public final class e
    implements d
{

    private final Collection a;

    public e(Collection collection)
    {
        a = new ArrayList(collection);
    }

    public transient e(d ad[])
    {
        this(((Collection) (Arrays.asList(ad))));
    }

    public final boolean a(a a1)
    {
        for (Iterator iterator = a.iterator(); iterator.hasNext();)
        {
            if (((d)iterator.next()).a(a1))
            {
                return true;
            }
        }

        return false;
    }
}

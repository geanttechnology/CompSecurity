// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.base;

import java.io.IOException;
import java.util.Iterator;

// Referenced classes of package com.google.common.base:
//            p, e

public final class g
{

    private final e a;
    private final String b;

    public g(e e1, String s)
    {
        a = e1;
        b = (String)p.a(s);
    }

    public final StringBuilder a(StringBuilder stringbuilder, Iterator iterator)
    {
        try
        {
            p.a(stringbuilder);
            if (iterator.hasNext())
            {
                java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
                stringbuilder.append(a.a(entry.getKey()));
                stringbuilder.append(b);
                stringbuilder.append(a.a(entry.getValue()));
                java.util.Map.Entry entry1;
                for (; iterator.hasNext(); stringbuilder.append(a.a(entry1.getValue())))
                {
                    stringbuilder.append(a.a);
                    entry1 = (java.util.Map.Entry)iterator.next();
                    stringbuilder.append(a.a(entry1.getKey()));
                    stringbuilder.append(b);
                }

            }
        }
        // Misplaced declaration of an exception variable
        catch (StringBuilder stringbuilder)
        {
            throw new AssertionError(stringbuilder);
        }
        return stringbuilder;
    }
}

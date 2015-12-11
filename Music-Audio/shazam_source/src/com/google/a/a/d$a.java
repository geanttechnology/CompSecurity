// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.a;

import java.io.IOException;
import java.util.Iterator;

// Referenced classes of package com.google.a.a:
//            d, g

public static final class <init>
{

    private final d a;
    private final String b;

    public final StringBuilder a(StringBuilder stringbuilder, Iterator iterator)
    {
        try
        {
            g.a(stringbuilder);
            if (iterator.hasNext())
            {
                java.util.Entry entry = (java.util.Entry)iterator.next();
                stringbuilder.append(a.a(entry.getKey()));
                stringbuilder.append(b);
                stringbuilder.append(a.a(entry.getValue()));
                java.util.Entry entry1;
                for (; iterator.hasNext(); stringbuilder.append(a.a(entry1.getValue())))
                {
                    stringbuilder.append(a.a);
                    entry1 = (java.util.Entry)iterator.next();
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

    private (d d1, String s)
    {
        a = d1;
        b = (String)g.a(s);
    }

    public b(d d1, String s, byte byte0)
    {
        this(d1, s);
    }
}

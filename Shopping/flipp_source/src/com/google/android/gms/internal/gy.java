// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.google.android.gms.internal:
//            ha

public final class gy
{

    private final List a;
    private final Object b;

    private gy(Object obj)
    {
        b = ha.a(obj);
        a = new ArrayList();
    }

    gy(Object obj, byte byte0)
    {
        this(obj);
    }

    public final gy a(String s, Object obj)
    {
        a.add((new StringBuilder()).append((String)ha.a(s)).append("=").append(String.valueOf(obj)).toString());
        return this;
    }

    public final String toString()
    {
        StringBuilder stringbuilder = (new StringBuilder(100)).append(b.getClass().getSimpleName()).append('{');
        int j = a.size();
        for (int i = 0; i < j; i++)
        {
            stringbuilder.append((String)a.get(i));
            if (i < j - 1)
            {
                stringbuilder.append(", ");
            }
        }

        return stringbuilder.append('}').toString();
    }
}

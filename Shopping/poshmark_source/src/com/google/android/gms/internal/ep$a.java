// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.google.android.gms.internal:
//            ep, er

public static final class <init>
{

    private final List Ce;
    private final Object Cf;

    public <init> a(String s, Object obj)
    {
        Ce.add((new StringBuilder()).append((String)er.f(s)).append("=").append(String.valueOf(obj)).toString());
        return this;
    }

    public String toString()
    {
        StringBuilder stringbuilder = (new StringBuilder(100)).append(Cf.getClass().getSimpleName()).append('{');
        int j = Ce.size();
        for (int i = 0; i < j; i++)
        {
            stringbuilder.append((String)Ce.get(i));
            if (i < j - 1)
            {
                stringbuilder.append(", ");
            }
        }

        return stringbuilder.append('}').toString();
    }

    private (Object obj)
    {
        Cf = er.f(obj);
        Ce = new ArrayList();
    }

    Ce(Object obj, Ce ce)
    {
        this(obj);
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.List;

public final class adw
{

    private final List a;
    private final Object b;

    private adw(Object obj)
    {
        b = ady.a(obj);
        a = new ArrayList();
    }

    adw(Object obj, adv._cls1 _pcls1)
    {
        this(obj);
    }

    public adw a(String s, Object obj)
    {
        a.add((new StringBuilder()).append((String)ady.a(s)).append("=").append(String.valueOf(obj)).toString());
        return this;
    }

    public String toString()
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

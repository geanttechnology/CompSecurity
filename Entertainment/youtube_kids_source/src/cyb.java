// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.List;

public final class cyb
    implements cpu
{

    private final List a = new ArrayList();
    private final List b = new ArrayList();

    public cyb()
    {
        a(0, cxy.a);
    }

    public final cya a()
    {
        return new cya(a, b);
    }

    public final cyb a(int i, cxy cxy1)
    {
        if (!a.isEmpty() && i < ((Integer)a.get(a.size() - 1)).intValue())
        {
            bmo.c("subtitle settings are not given in non-decreasing start time order");
        }
        a.add(Integer.valueOf(i));
        b.add(cxy1);
        return this;
    }

    public final Object b()
    {
        return a();
    }
}

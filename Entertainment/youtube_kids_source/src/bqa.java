// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.List;

public class bqa
    implements cpu
{

    private final List a = new ArrayList();

    public bqa()
    {
    }

    public final bqa a(bvj bvj)
    {
        a.add(bvj);
        return this;
    }

    public final List a()
    {
        return new ArrayList(a);
    }

    public final Object b()
    {
        return a();
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.List;

class beu
    implements cpu
{

    public final int a;
    final List b = new ArrayList();

    public beu(int i)
    {
        a = i;
    }

    public final List a()
    {
        return new ArrayList(b);
    }

    public final Object b()
    {
        return a();
    }
}

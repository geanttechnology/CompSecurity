// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;

public abstract class asz extends aso
{

    protected ArrayList a;

    public asz()
    {
        a = new ArrayList(5);
    }

    public abstract String a();

    public void a(aso aso1)
    {
        a.add(aso1);
    }

    public final ArrayList i()
    {
        return a;
    }
}

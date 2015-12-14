// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;

public abstract class nt extends nl
{

    protected ArrayList a;

    public nt()
    {
        a = new ArrayList(5);
    }

    public abstract String a();

    public void a(nl nl1)
    {
        a.add(nl1);
    }

    public final ArrayList i()
    {
        return a;
    }
}

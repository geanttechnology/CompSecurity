// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Vector;

public final class ay extends c
{
    public final class a extends c.a
    {

        public a()
        {
        }
    }


    public ay()
    {
        super(0);
    }

    private ay(int i)
    {
        super(i);
    }

    public final a d()
    {
        return new a();
    }

    public final ay e()
    {
        ay ay1 = new ay(c());
        for (a a1 = d(); a1.a(); ay1.a(a1.b())) { }
        return ay1;
    }

    public final Vector f()
    {
        Vector vector = new Vector(c());
        for (a a1 = d(); a1.a(); vector.addElement(a1.b())) { }
        return vector;
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.Serializable;

public class cdk
    implements cpu, Serializable
{

    public Object a;
    public int b;

    public cdk()
    {
    }

    public final cdj a()
    {
        return new cdj(a, b);
    }

    public final Object b()
    {
        return a();
    }
}

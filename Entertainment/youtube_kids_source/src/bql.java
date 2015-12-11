// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class bql
{

    public final ddn a;
    private btk b;

    public bql(ddn ddn1)
    {
        a = (ddn)b.a(ddn1);
    }

    public final btk a()
    {
        ddm ddm1 = a.c;
        if (b == null && ddm1 != null && ddm1.a != null)
        {
            b = new btk(ddm1.a);
        }
        return b;
    }
}

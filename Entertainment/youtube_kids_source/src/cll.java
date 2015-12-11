// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


final class cll extends cre
{

    private final mj j;

    public cll(String s, mj mj1)
    {
        super(1, s, mj1);
        j = mj1;
    }

    protected final mi a(mb mb1)
    {
        try
        {
            mb1 = mi.a(mb1.b, null);
        }
        // Misplaced declaration of an exception variable
        catch (mb mb1)
        {
            return mi.a(new md(mb1));
        }
        return mb1;
    }

    protected final void a(Object obj)
    {
        obj = (byte[])obj;
        j.a(obj);
    }

    public final mg i()
    {
        return mg.b;
    }
}

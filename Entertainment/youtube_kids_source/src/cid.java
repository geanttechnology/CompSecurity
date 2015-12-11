// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.ByteArrayInputStream;
import java.util.Map;

final class cid extends cre
{

    private final String j;
    private final mj k;
    private cic l;

    public cid(cic cic1, String s, mj mj1, String s1)
    {
        l = cic1;
        super(0, s, mj1);
        j = s1;
        k = mj1;
    }

    protected final mi a(mb mb1)
    {
        try
        {
            String s = a.a(mb1.c);
            ByteArrayInputStream bytearrayinputstream = new ByteArrayInputStream(mb1.b);
            mb1 = mi.a(l.b.a(bytearrayinputstream, s, j, null), a.a(mb1));
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
        obj = (aql)obj;
        k.a(obj);
    }

    public final Map c()
    {
        return l.a;
    }

    public final mg i()
    {
        return mg.b;
    }
}

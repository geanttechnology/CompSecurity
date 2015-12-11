// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Executor;

public final class crq extends ctx
{

    private final qs c;
    private final crt d;

    public crq()
    {
        c = null;
        d = null;
    }

    public crq(bje bje, bpa bpa, qs qs1, crt crt1, Executor executor, List list)
    {
        super(bje, bpa, executor, list);
        c = (qs)b.a(qs1);
        d = (crt)b.a(crt1);
    }

    private bxb b(String s, bxb bxb1)
    {
        Object obj;
        Object obj1 = null;
        crp crp1;
        long l;
        if (bxb1 == null)
        {
            s = null;
        } else
        {
            s = bxb1.d;
        }
        obj = bxb1;
        if (s == null) goto _L2; else goto _L1
_L1:
        if (!c.a()) goto _L4; else goto _L3
_L3:
        obj = d;
        c.b();
        obj = ((crt) (obj)).a();
_L6:
        l = ((bww) (s)).h;
        crp1 = ((crs) (obj)).a();
        if (crp1.c == null)
        {
            s = new LinkedList();
            if (crp1.a != null)
            {
                s.add(crp1.a);
            }
            if (crp1.b != null)
            {
                s.add(crp1.b);
            }
            crp1.c = s;
        }
        obj = bxb1;
        if (crp1.c.isEmpty()) goto _L2; else goto _L5
_L5:
        if (crp1.a == null || !crp1.a.h())
        {
            break MISSING_BLOCK_LABEL_222;
        }
        s = crp1.a.f();
_L7:
        obj = obj1;
        if (crp1.b == null)
        {
            break MISSING_BLOCK_LABEL_194;
        }
        obj = obj1;
        if (crp1.b.h())
        {
            obj = crp1.b.f();
        }
        obj = bxb1.a(s, ((bwb) (obj)));
_L2:
        return ((bxb) (obj));
_L4:
        try
        {
            obj = d.b();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return bxb1;
        }
          goto _L6
        s = null;
          goto _L7
    }

    protected final bxb a(String s, bxb bxb1)
    {
        return b(s, super.a(s, bxb1));
    }
}

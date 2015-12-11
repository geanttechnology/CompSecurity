// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;

public class cho
{

    final qs a;
    final bnx b;
    final bje c;
    final Executor d;
    final chq e;

    public cho(qs qs1, bnx bnx1, bje bje1, Executor executor, chq chq1)
    {
        a = (qs)b.a(qs1);
        b = (bnx)b.a(bnx1);
        c = (bje)b.a(bje1);
        d = (Executor)b.a(executor);
        e = (chq)b.a(chq1);
    }

    public String a()
    {
        if (!c())
        {
            chq chq1 = e;
            return null;
        }
        Object obj;
        obj = (bnz)b.b(a.b().b).get();
        if (!((bnz) (obj)).a())
        {
            break MISSING_BLOCK_LABEL_73;
        }
        if (!((bnz) (obj)).a())
        {
            throw new IllegalStateException("Cannot call getAuthenticationToken on an unsuccessful fetch.");
        }
        obj = ((bnz) (obj)).a;
        return ((String) (obj));
        return null;
        Object obj1;
        obj1;
        break MISSING_BLOCK_LABEL_80;
        obj1;
        return null;
    }

    public void a(bhv bhv1)
    {
        if (!c())
        {
            chq chq1 = e;
            bhv1.a(null, null);
            return;
        } else
        {
            d.execute(new chp(this, bhv1));
            return;
        }
    }

    public String b()
    {
        if (!c())
        {
            return null;
        } else
        {
            return a.b().b.d();
        }
    }

    public boolean c()
    {
        return a.a();
    }

    public void onSignInEvent$5efadcfb(a a1)
    {
        c.d(chn.a);
    }

    public void onSignOutEvent$75e9c194(a a1)
    {
        c.d(chn.a);
    }
}

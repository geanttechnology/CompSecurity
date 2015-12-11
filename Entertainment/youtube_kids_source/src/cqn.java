// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.concurrent.Executor;

public class cqn
    implements crb
{

    final cou a;
    final Executor b;
    private final crb c;
    private final cot d;

    protected cqn(cot cot1, cou cou)
    {
        c = null;
        d = cot1;
        a = cou;
        b = null;
    }

    private cqn(crb crb1, cot cot1, cou cou, Executor executor)
    {
        c = (crb)b.a(crb1);
        d = null;
        a = cou;
        b = executor;
    }

    public static crb a(crb crb1, cou cou, Executor executor)
    {
        b.a(cou);
        b.a(cou);
        return new cqn(crb1, null, cou, executor);
    }

    public final void a(Object obj, bhv bhv1)
    {
        Object obj1;
        if (d == null)
        {
            break MISSING_BLOCK_LABEL_35;
        }
        obj1 = d.a(obj);
_L1:
        b(obj1, new cqo(this, obj, obj1, bhv1));
        return;
        obj1 = obj;
          goto _L1
        bnn bnn1;
        bnn1;
        a(obj, null, bhv1, ((Exception) (bnn1)));
        return;
    }

    protected void a(Object obj, Object obj1, bhv bhv1, Exception exception)
    {
        bhv1.a(obj, exception);
    }

    protected void b(Object obj, bhv bhv1)
    {
        b.a(c);
        c.a(obj, bhv1);
    }
}

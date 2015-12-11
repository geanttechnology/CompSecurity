// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

final class ty extends tv
{

    private tu b;

    public ty(tu tu1, int i)
    {
        b = tu1;
        super(tu1, i);
    }

    static void a(ty ty1, bum bum1)
    {
        if (!ty1.a)
        {
            ty1.b.i = bum1;
            ty1.b.a(cts.e);
        }
    }

    protected final void a(int i)
    {
        if (!b(i)) goto _L2; else goto _L1
_L1:
        Object obj;
        Object obj3;
        Object obj4;
        Object obj5;
        List list1;
        obj3 = ((ced)b.t.get(i)).b;
        b.d.c(new csv());
        if (b.m.c())
        {
            break MISSING_BLOCK_LABEL_253;
        }
        obj4 = crf.a();
        obj5 = b.b;
        int j;
        if (b.v())
        {
            obj = b.r;
        } else
        {
            obj = "";
        }
        if (b.v())
        {
            j = i;
        } else
        {
            j = -1;
        }
        ((cud) (obj5)).a(((String) (obj3)), ((String) (obj)), j, "", b.o, ((mj) (obj4)));
        obj3 = (bum)((crf) (obj4)).get(3L, TimeUnit.SECONDS);
        obj4 = b.a;
        obj5 = b.s;
        list1 = b.t;
        b.a(obj3);
        b.a(obj4);
        obj = obj3;
        if (obj5 != null)
        {
            if (list1 != null)
            {
                break MISSING_BLOCK_LABEL_226;
            }
            obj = obj3;
        }
_L3:
        b.p.execute(new tz(this, ((bum) (obj))));
_L2:
        return;
        obj = new bum(a.a(((android.content.Context) (obj4)), ((bum) (obj3)).a, ((cdu) (obj5)), list1, i, true));
          goto _L3
        Object obj1;
        obj1;
_L5:
        Object obj2;
        if (b.v())
        {
            obj2 = b.a;
            cdu cdu1 = b.s;
            List list = b.t;
            b.a(obj2);
            b.a(cdu1);
            b.a(list);
            b.a(obj2);
            b.a(cdu1);
            b.a(list);
            i = Math.max(0, Math.min(list.size() - 1, i));
            ced ced2 = (ced)list.get(i);
            obj2 = new bum(a.a(((android.content.Context) (obj2)), a.a(((android.content.Context) (obj2)), a.a(ced2.b, cdu1.a, i, true), ced2), cdu1, list, i, true));
        } else
        {
            obj2 = b.a;
            ced ced1 = (ced)b.t.get(0);
            b.a(obj2);
            b.a(ced1);
            obj2 = new bum(a.a(((android.content.Context) (obj2)), a.a(ced1.b, null, -1), ced1));
        }
        b.p.execute(new ua(this, ((bum) (obj2))));
        return;
        obj2;
        continue; /* Loop/switch isn't completed */
        obj2;
        if (true) goto _L5; else goto _L4
_L4:
    }
}

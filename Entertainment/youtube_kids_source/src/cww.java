// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import android.os.Looper;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.concurrent.Executor;

public final class cww
    implements cwv
{

    long a;
    private final cpz b;
    private final bkn c;
    private final cnf d;
    private final bjp e;
    private final PriorityQueue f;
    private final String g;
    private final Executor h;

    protected cww(cpz cpz1, bkn bkn1, cnf cnf1, bjp bjp1, List list, String s, Executor executor)
    {
        b = (cpz)b.a(cpz1);
        c = (bkn)b.a(bkn1);
        d = (cnf)b.a(cnf1);
        e = (bjp)b.a(bjp1);
        f = new PriorityQueue((Collection)b.a(list));
        g = (String)b.a(s);
        h = (Executor)b.a(executor);
    }

    public final cxa a()
    {
        this;
        JVM INSTR monitorenter ;
        cxa cxa1 = new cxa(f, g);
        this;
        JVM INSTR monitorexit ;
        return cxa1;
        Exception exception;
        exception;
        throw exception;
    }

    void a(btv btv1, long l)
    {
        Object obj = bnf.a(Uri.parse(btv1.b));
        btv1 = btv1.c.iterator();
label0:
        do
        {
            Object obj1;
label1:
            {
                if (!btv1.hasNext())
                {
                    break label0;
                }
                obj1 = (btx)btv1.next();
                b.b();
                switch (cwy.a[((btx) (obj1)).ordinal()])
                {
                default:
                    break;

                case 1: // '\001'
                    d.a(((bnf) (obj)));
                    break;

                case 2: // '\002'
                    ((bnf) (obj)).a("cpn", g);
                    break;

                case 3: // '\003'
                    ((bnf) (obj)).a("conn", c.g());
                    break;

                case 4: // '\004'
                    ((bnf) (obj)).a("cmt", String.valueOf(l / 1000L));
                    break;

                case 5: // '\005'
                    obj1 = ((Map)e.b_()).entrySet().iterator();
                    break label1;
                }
                if (false)
                {
                    break label0;
                }
                continue;
            }
            while (((Iterator) (obj1)).hasNext()) 
            {
                java.util.Map.Entry entry = (java.util.Map.Entry)((Iterator) (obj1)).next();
                ((bnf) (obj)).a((String)entry.getKey(), (String)entry.getValue());
            }
        } while (true);
        btv1 = ((bnf) (obj)).a.build();
        obj = String.valueOf(btv1);
        bmo.e((new StringBuilder(String.valueOf(obj).length() + 8)).append("Pinging ").append(((String) (obj))).toString());
        obj = b;
        obj = cpz.a("remarketing", 0x323467f);
        ((cqd) (obj)).a(btv1);
        obj.d = true;
        b.a(((cqd) (obj)), cni.a);
    }

    public final void a(cte cte1)
    {
        this;
        JVM INSTR monitorenter ;
        if (!cte1.d)
        {
            break MISSING_BLOCK_LABEL_140;
        }
        a = cte1.a;
_L1:
        long l;
        if (f.size() <= 0)
        {
            break MISSING_BLOCK_LABEL_140;
        }
        cte1 = (btv)f.peek();
        l = a;
        boolean flag;
        if (((btv) (cte1)).b.length() > 0 && ((btv) (cte1)).d >= 0 && (long)(((btv) (cte1)).d * 1000) <= l)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_140;
        }
        if (Looper.myLooper() != Looper.getMainLooper())
        {
            break MISSING_BLOCK_LABEL_128;
        }
        h.execute(new cwx(this, cte1));
_L2:
        f.remove();
          goto _L1
        cte1;
        throw cte1;
        a(((btv) (cte1)), a);
          goto _L2
        this;
        JVM INSTR monitorexit ;
    }

    public final void b()
    {
    }
}

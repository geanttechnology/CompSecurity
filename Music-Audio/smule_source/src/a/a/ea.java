// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package a.a;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;

// Referenced classes of package a.a:
//            ed, ay, dt, ec, 
//            dw, eb, v, dq

public final class ea
{

    private Context a;
    private List b;

    public ea(Context context)
    {
        a = context;
        b = new ArrayList();
    }

    public final void a()
    {
        Object obj = new ArrayList();
        for (Iterator iterator = b.iterator(); iterator.hasNext(); ((ArrayList) (obj)).add(new Thread((ed)iterator.next()))) { }
        for (Iterator iterator1 = ((ArrayList) (obj)).iterator(); iterator1.hasNext(); ((Thread)iterator1.next()).start()) { }
        for (obj = ((ArrayList) (obj)).iterator(); ((Iterator) (obj)).hasNext(); ((Thread)((Iterator) (obj)).next()).join()) { }
    }

    public final void a(ay ay1, dt dt1, String s, String s1, String s2, v v, dq dq)
    {
        this;
        JVM INSTR monitorenter ;
        if (ay1.b() > 0)
        {
            ay ay2 = ay1.a(a);
            dt1 = dt1.a(ay2, ay1, s2, a, v);
            ay1 = new ec(ay2, ay1, v, (new dw(s, s1)).a(), dt1, dq);
            b.add(ay1);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        ay1;
        throw ay1;
    }

    public final void a(eb eb1, ExecutorService executorservice)
    {
        Iterator iterator = b.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            ed ed1 = (ed)iterator.next();
            if (!eb1.a(ed1))
            {
                executorservice.execute(ed1);
            }
        } while (true);
    }
}

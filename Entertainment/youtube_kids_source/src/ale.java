// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

final class ale
    implements bhv
{

    private akx a;

    ale(akx akx1)
    {
        a = akx1;
        super();
    }

    public final void a(Object obj, Exception exception)
    {
        bmo.a("Error loading available screens", exception);
    }

    public final void a(Object obj, Object obj1)
    {
        boolean flag1;
        flag1 = false;
        obj1 = (List)obj1;
        obj = a.b;
        if (((CopyOnWriteArrayList) (obj)).size() == ((List) (obj1)).size()) goto _L2; else goto _L1
_L1:
        boolean flag = flag1;
_L7:
        if (flag) goto _L4; else goto _L3
_L3:
        obj = a;
        obj;
        JVM INSTR monitorenter ;
        Iterator iterator = a.b.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            ame ame1 = (ame)iterator.next();
            if (!((List) (obj1)).contains(ame1))
            {
                a.c(ame1.e());
            }
        } while (true);
          goto _L5
        obj1;
        obj;
        JVM INSTR monitorexit ;
        throw obj1;
_L2:
        int i = 0;
_L8:
        if (i >= ((CopyOnWriteArrayList) (obj)).size())
        {
            break MISSING_BLOCK_LABEL_155;
        }
        flag = flag1;
        if (!((ame)((CopyOnWriteArrayList) (obj)).get(i)).equals(((List) (obj1)).get(i))) goto _L7; else goto _L6
_L6:
        i++;
          goto _L8
        flag = true;
          goto _L7
_L5:
        obj1 = ((List) (obj1)).iterator();
_L9:
        akx akx1;
        Object obj2;
        do
        {
            if (!((Iterator) (obj1)).hasNext())
            {
                break MISSING_BLOCK_LABEL_348;
            }
            obj2 = (ame)((Iterator) (obj1)).next();
            akx1 = a;
            obj2 = ((ame) (obj2)).e();
        } while (akx1.a.contains(obj2));
        Iterator iterator1 = akx1.b.iterator();
        do
        {
            if (!iterator1.hasNext())
            {
                break;
            }
            alq alq1 = (alq)(ame)iterator1.next();
            if (alq1.a.c.equals(((alq) (obj2)).a.c))
            {
                Object obj3 = akx1.l;
                obj3 = String.valueOf(alq1);
                (new StringBuilder(String.valueOf(obj3).length() + 26)).append("Removing duplicate screen ").append(((String) (obj3)));
                akx1.c(alq1);
            }
        } while (true);
        akx1.b.add(obj2);
        akx1.a.add(obj2);
        akx1.a(((ame) (obj2)));
          goto _L9
        obj;
        JVM INSTR monitorexit ;
_L4:
    }
}

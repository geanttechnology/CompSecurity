// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

// Referenced classes of package jumiomobile:
//            ox, po, or, pv, 
//            pw, py, pz

public class oz
    implements ox
{

    protected int a;
    protected int b;
    protected int c;
    protected double d;

    public oz()
    {
    }

    public Class a()
    {
        return jumiomobile/po;
    }

    public pz a(ConcurrentLinkedQueue concurrentlinkedqueue)
    {
        ArrayList arraylist;
        int i;
        concurrentlinkedqueue = new ArrayList(concurrentlinkedqueue);
        arraylist = new ArrayList();
        a = 0;
        b = 0;
        c = 0;
        d = 0.0D;
        i = 0;
_L3:
        if (i >= concurrentlinkedqueue.size()) goto _L2; else goto _L1
_L1:
        int j;
        for (; i < concurrentlinkedqueue.size() && !((or)concurrentlinkedqueue.get(i) instanceof pv); i++) { }
        j = i;
_L4:
        boolean flag;
        if (j >= concurrentlinkedqueue.size())
        {
            break MISSING_BLOCK_LABEL_270;
        }
        or or1 = (or)concurrentlinkedqueue.get(j);
        if ((or1 instanceof pw) && j > 0 && !(concurrentlinkedqueue.get(j - 1) instanceof pw))
        {
            b = b + (j - i);
            a = a + 1;
            flag = false;
        } else
        {
label0:
            {
                if (!(or1 instanceof po))
                {
                    break label0;
                }
                c = c + 1;
                flag = true;
            }
        }
_L5:
        if (flag)
        {
            or1 = (or)concurrentlinkedqueue.get(i);
            arraylist.add(Long.valueOf(((or)concurrentlinkedqueue.get(j)).a() - or1.a()));
        }
        i = j;
          goto _L3
        j++;
          goto _L4
_L2:
        d = (double)c / (double)(c + a);
        return new py(arraylist, "Final result after");
        flag = false;
          goto _L5
    }
}

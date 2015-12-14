// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.brushlib.util;

import java.util.Iterator;
import java.util.LinkedList;

// Referenced classes of package com.socialin.android.brushlib.util:
//            f

public abstract class e
{

    public LinkedList a;
    private int b;

    public e(int i)
    {
        a = new LinkedList();
        b = i;
    }

    public void a(Object obj)
    {
    }

    public abstract Object b(Object obj);

    public final Object c(Object obj)
    {
        Object obj1;
        int i;
        boolean flag;
        flag = false;
        obj1 = a.iterator();
        i = 0;
_L8:
        if (!((Iterator) (obj1)).hasNext())
        {
            break MISSING_BLOCK_LABEL_100;
        }
        if (!((f)((Iterator) (obj1)).next()).a.equals(obj)) goto _L2; else goto _L1
_L1:
        Iterator iterator;
        if (i == -1)
        {
            obj1 = b(obj);
        } else
        {
            obj1 = ((f)a.remove(i)).b;
        }
        iterator = a.iterator();
        for (i = ((flag) ? 1 : 0); iterator.hasNext(); i++)
        {
            iterator.next();
        }

        break MISSING_BLOCK_LABEL_125;
_L2:
        i++;
        continue; /* Loop/switch isn't completed */
        i = -1;
          goto _L1
        i++;
        if (i > b) goto _L4; else goto _L3
_L3:
        a.addFirst(new f(obj, obj1));
_L6:
        return obj1;
_L4:
        f f1 = (f)a.getLast();
        if (i - 1 > b) goto _L6; else goto _L5
_L5:
        a.removeLast();
        a(f1.b);
        a.addFirst(new f(obj, obj1));
        return obj1;
        if (true) goto _L8; else goto _L7
_L7:
    }
}

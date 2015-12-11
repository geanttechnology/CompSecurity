// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

public final class cya
    implements Serializable
{

    final List a;
    private final List b;

    cya(List list, List list1)
    {
        b.a(list);
        b.a(list1);
        boolean flag;
        if (list.size() == list1.size())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        b.b(flag, "startTimes and settings differ in size");
        a = Collections.unmodifiableList(list);
        b = Collections.unmodifiableList(list1);
    }

    public final cxy a(int i)
    {
        this;
        JVM INSTR monitorenter ;
        i = Collections.binarySearch(a, Integer.valueOf(i));
        if (i < 0) goto _L2; else goto _L1
_L1:
        cxy cxy1 = (cxy)b.get(i);
_L4:
        this;
        JVM INSTR monitorexit ;
        return cxy1;
_L2:
        i = -i - 2;
        if (i < 0)
        {
            break MISSING_BLOCK_LABEL_62;
        }
        cxy1 = (cxy)b.get(i);
        continue; /* Loop/switch isn't completed */
        cxy1 = null;
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public final String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        for (int i = 0; i < a.size(); i++)
        {
            stringbuilder.append("[").append(a.get(i)).append(": ").append(b.get(i)).append("]");
        }

        return stringbuilder.toString();
    }
}

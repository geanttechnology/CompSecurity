// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

public final class cye
    implements Serializable
{

    final List a;
    final List b;
    final List c;

    cye(List list, List list1, List list2)
    {
        boolean flag1 = true;
        super();
        b.a(list);
        b.a(list1);
        b.a(list2);
        boolean flag;
        if (list.size() == list1.size())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        b.b(flag, "startTimes and endTimes differ in size");
        if (list.size() == list2.size())
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        b.b(flag, "startTimes and lines differ in size");
        a = Collections.unmodifiableList(list);
        b = Collections.unmodifiableList(list1);
        c = Collections.unmodifiableList(list2);
    }

    int a(int i, boolean flag)
    {
        int j;
        int k;
        k = Collections.binarySearch(a, Integer.valueOf(i));
        j = k;
        if (k >= 0) goto _L2; else goto _L1
_L1:
        j = -k - 2;
        if (j < 0 || i >= ((Integer)b.get(j)).intValue()) goto _L3; else goto _L2
_L2:
        int l;
        if (flag)
        {
            k = j - 1;
        } else
        {
            k = j + 1;
        }
        l = k;
        k = j;
        j = l;
_L9:
        l = k;
        if (j >= a.size()) goto _L5; else goto _L4
_L4:
        l = k;
        if (j < 0) goto _L5; else goto _L6
_L6:
        l = k;
        if (((Integer)a.get(j)).intValue() > i) goto _L5; else goto _L7
_L7:
        l = k;
        if (((Integer)b.get(j)).intValue() <= i) goto _L5; else goto _L8
_L8:
        if (flag)
        {
            k = j - 1;
        } else
        {
            k = j + 1;
        }
        l = j;
        j = k;
        k = l;
        if (true) goto _L9; else goto _L5
_L3:
        l = -1;
_L5:
        return l;
    }

    public final String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        for (int i = 0; i < a.size(); i++)
        {
            stringbuilder.append("[").append(a.get(i)).append(" - ").append(b.get(i)).append(": ").append((String)c.get(i)).append("]");
        }

        return stringbuilder.toString();
    }
}

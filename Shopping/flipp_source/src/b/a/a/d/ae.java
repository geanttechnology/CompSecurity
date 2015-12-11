// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package b.a.a.d;

import java.util.ArrayList;
import java.util.List;

// Referenced classes of package b.a.a.d:
//            al, am

final class ae
    implements al, am
{

    private final am a[];
    private final al b[];

    ae(List list)
    {
        ArrayList arraylist = new ArrayList();
        ArrayList arraylist1 = new ArrayList();
        a(list, arraylist, arraylist1);
        if (arraylist.size() <= 0)
        {
            a = null;
        } else
        {
            a = (am[])arraylist.toArray(new am[arraylist.size()]);
        }
        if (arraylist1.size() <= 0)
        {
            b = null;
            return;
        } else
        {
            b = (al[])arraylist1.toArray(new al[arraylist1.size()]);
            return;
        }
    }

    private static void a(List list, List list1, List list2)
    {
        int j = list.size();
        int i = 0;
        while (i < j) 
        {
            Object obj = list.get(i);
            if (obj instanceof am)
            {
                if (obj instanceof ae)
                {
                    a(list1, ((Object []) (((ae)obj).a)));
                } else
                {
                    list1.add(obj);
                }
            }
            obj = list.get(i + 1);
            if (obj instanceof al)
            {
                if (obj instanceof ae)
                {
                    a(list2, ((Object []) (((ae)obj).b)));
                } else
                {
                    list2.add(obj);
                }
            }
            i += 2;
        }
    }

    private static void a(List list, Object aobj[])
    {
        if (aobj != null)
        {
            for (int i = 0; i < aobj.length; i++)
            {
                list.add(aobj[i]);
            }

        }
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.c;

import android.os.AsyncTask;
import android.widget.ListView;
import com.cyberlink.you.database.o;
import com.cyberlink.you.e;
import com.cyberlink.you.friends.Friend;
import com.cyberlink.you.friends.l;
import com.cyberlink.you.g;
import com.cyberlink.you.p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.cyberlink.you.c:
//            e, f

class i extends AsyncTask
{

    final com.cyberlink.you.c.e a;

    private i(com.cyberlink.you.c.e e1)
    {
        a = e1;
        super();
    }

    i(com.cyberlink.you.c.e e1, e._cls1 _pcls1)
    {
        this(e1);
    }

    private List a(List list, List list1)
    {
        ArrayList arraylist;
        arraylist = new ArrayList();
        list = list.iterator();
_L2:
        Long long1;
        boolean flag;
        if (!list.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        long1 = (Long)list.next();
        Iterator iterator = list1.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_99;
            }
        } while (!long1.equals(Long.valueOf(((Friend)iterator.next()).a)));
        flag = true;
_L3:
        if (!flag)
        {
            arraylist.add(long1);
        }
        if (true) goto _L2; else goto _L1
_L1:
        return arraylist;
        flag = false;
          goto _L3
    }

    private void b(List list)
    {
        list.remove(Long.valueOf(g.a().g().longValue()));
    }

    protected transient List a(Void avoid[])
    {
        List list = e.l().a();
        b(list);
        avoid = e.g().a(list);
        if (list.size() != avoid.size())
        {
            list = a(list, ((List) (avoid)));
            avoid.addAll(e.c(a).a(list));
        }
        return avoid;
    }

    protected void a(List list)
    {
        e.d(a).addAll(list);
        e.a(a, new f(a, a.getActivity(), p.u_view_item_firend_group_create, e.d(a)));
        e.a(a).a(e.c(a));
        com.cyberlink.you.c.e.e(a).setAdapter(e.a(a));
        com.cyberlink.you.c.e.e(a).setOnItemClickListener(e.f(a));
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    protected void onPostExecute(Object obj)
    {
        a((List)obj);
    }
}

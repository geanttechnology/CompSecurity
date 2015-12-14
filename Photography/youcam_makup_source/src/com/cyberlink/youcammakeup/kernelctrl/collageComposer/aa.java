// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.collageComposer;

import com.pf.common.utility.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.collageComposer:
//            p, s, w

class aa
{

    List a;
    List b;
    HashMap c;
    final w d;

    aa(w w1, ArrayList arraylist, List list)
    {
        d = w1;
        super();
        a = null;
        b = null;
        c = new HashMap();
        a = new ArrayList();
        w1 = arraylist.iterator();
        do
        {
            if (!w1.hasNext())
            {
                break;
            }
            arraylist = (p)w1.next();
            if (arraylist instanceof s)
            {
                a.add(arraylist);
            }
        } while (true);
        b = new ArrayList(list);
    }

    public Long a(p p1)
    {
        return (Long)c.get(p1);
    }

    public boolean a()
    {
        int i = 0;
        if (a == null || b == null)
        {
            return false;
        }
        if (a.size() != b.size())
        {
            m.e(w.c(d), "analyze(), error. mItems.size() != mImageList.size()");
            return false;
        }
        for (; i < a.size(); i++)
        {
            c.put(a.get(i), b.get(i));
        }

        return true;
    }
}

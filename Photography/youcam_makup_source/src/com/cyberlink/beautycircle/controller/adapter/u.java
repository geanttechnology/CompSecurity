// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.adapter;

import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.cyberlink.beautycircle.controller.adapter:
//            t

class u
    implements android.view.View.OnClickListener
{

    final t a;
    private Map b;

    private u(t t)
    {
        a = t;
        super();
        b = new HashMap();
    }

    u(t t, t._cls1 _pcls1)
    {
        this(t);
    }

    public void a()
    {
        b.clear();
    }

    public boolean a(com.cyberlink.beautycircle.model.UModel.UGroup ugroup)
    {
        ugroup = (Boolean)b.get(ugroup);
        if (ugroup != null)
        {
            return ugroup.booleanValue();
        } else
        {
            return false;
        }
    }

    public List b()
    {
        ArrayList arraylist = new ArrayList();
        Iterator iterator = b.entrySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            if (((Boolean)entry.getValue()).booleanValue() && (entry.getKey() instanceof com.cyberlink.beautycircle.model.UModel.UGroup))
            {
                arraylist.add((com.cyberlink.beautycircle.model.UModel.UGroup)entry.getKey());
            }
        } while (true);
        return arraylist;
    }

    public void onClick(View view)
    {
        Object obj = view.getTag();
        boolean flag;
        if (!view.isSelected())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        view.setSelected(flag);
        b.put(obj, Boolean.valueOf(flag));
    }
}

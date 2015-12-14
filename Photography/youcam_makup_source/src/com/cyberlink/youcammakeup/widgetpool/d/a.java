// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.d;

import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.clflurry.YMKFeatures;
import com.cyberlink.youcammakeup.clflurry.ag;
import com.cyberlink.youcammakeup.clflurry.b;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.utility.BeautyMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.d:
//            c, b

public class a extends BaseAdapter
{

    protected List a;
    protected List b;
    protected ConcurrentHashMap c;
    private BeautyMode d;

    public a(List list)
    {
        d = null;
        b = new ArrayList();
        b.add(new c(Globals.d().getString(0x7f0703cf), new String(), new String()));
        a = new ArrayList();
        c = new ConcurrentHashMap();
        d = StatusManager.j().s();
        if (list != null)
        {
            Pair pair;
            for (list = list.iterator(); list.hasNext(); a.add(new c((String)pair.first, new String(), (String)pair.second)))
            {
                pair = (Pair)list.next();
            }

        }
    }

    public c a(int i)
    {
        if (i < 0)
        {
            return (c)b.get(0);
        }
        if (i >= 0 && i < b.size())
        {
            return (c)b.get(i);
        } else
        {
            int j = b.size();
            return (c)a.get(i - j);
        }
    }

    public void a()
    {
        HashMap hashmap = new HashMap();
        HashMap hashmap1 = new HashMap();
        c c1 = (c)b.get(0);
        if (c.containsKey(c1))
        {
            Object obj;
            java.util.Map.Entry entry;
            if (getCount() > 1)
            {
                obj = a(1);
            } else
            {
                obj = c1;
            }
            if (c.containsKey(obj))
            {
                obj = (Integer)c.get(obj);
            } else
            {
                obj = (Integer)c.get(c1);
            }
            c.put(c1, obj);
        }
        for (obj = c.entrySet().iterator(); ((Iterator) (obj)).hasNext();)
        {
            entry = (java.util.Map.Entry)((Iterator) (obj)).next();
            c1 = (c)entry.getKey();
            Integer integer = (Integer)entry.getValue();
            if (c1.b() != null && !c1.b().isEmpty())
            {
                hashmap.put(c1.b(), integer);
            } else
            {
                hashmap1.put(c1.a(), integer);
            }
        }

        if (!hashmap.isEmpty() || !hashmap1.isEmpty())
        {
            com.cyberlink.youcammakeup.clflurry.b.a(new ag(hashmap, hashmap1, YMKFeatures.a(d)));
        }
        c.clear();
    }

    public int getCount()
    {
        return b.size() + a.size();
    }

    public Object getItem(int i)
    {
        return a(i);
    }

    public long getItemId(int i)
    {
        return -1L;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        if (view != null)
        {
            view = (com.cyberlink.youcammakeup.widgetpool.d.b)view;
        } else
        {
            view = new com.cyberlink.youcammakeup.widgetpool.d.b(viewgroup.getContext());
        }
        viewgroup = view.findViewById(0x7f0c08de);
        if (viewgroup != null && (viewgroup instanceof TextView))
        {
            String s = a(i).a();
            ((TextView)viewgroup).setText(s);
        }
        viewgroup = view.findViewById(0x7f0c08df);
        if (viewgroup != null)
        {
            int j;
            if (i < getCount() - 1)
            {
                j = 0;
            } else
            {
                j = 8;
            }
            viewgroup.setVisibility(j);
        }
        viewgroup = a(i);
        if (c.containsKey(viewgroup))
        {
            c.put(viewgroup, Integer.valueOf(((Integer)c.get(viewgroup)).intValue() + 1));
            return view;
        } else
        {
            c.put(viewgroup, Integer.valueOf(1));
            return view;
        }
    }
}

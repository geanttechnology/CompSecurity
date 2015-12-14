// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.clflurry.YMKFeatures;
import com.cyberlink.youcammakeup.clflurry.ag;
import com.cyberlink.youcammakeup.clflurry.b;
import com.cyberlink.youcammakeup.utility.BeautyMode;
import com.cyberlink.youcammakeup.widgetpool.d.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel:
//            f

public class e extends BaseAdapter
{

    protected ConcurrentHashMap a;
    private List b;
    private List c;

    public e()
    {
        b = null;
        c = null;
        b = new ArrayList();
        c = new ArrayList();
        c.add(new c(Globals.d().getString(0x7f0703cf), new String(), new String()));
        a = new ConcurrentHashMap();
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
            return (c)c.get(i - j);
        }
    }

    public void a()
    {
        Object obj = null;
        if (b == null || c == null)
        {
            return;
        }
        HashMap hashmap = new HashMap();
        HashMap hashmap1 = new HashMap();
        c c1;
        Object obj1;
        if (b.size() > 0)
        {
            c1 = (c)b.get(0);
        } else
        {
            c1 = null;
        }
        if (c.size() > 0)
        {
            obj = (c)c.get(0);
        }
        if (c1 != null && a.containsKey(c1))
        {
            if (getCount() > 1)
            {
                obj1 = a(1);
            } else
            {
                obj1 = obj;
            }
            if (a.containsKey(obj1))
            {
                obj = (Integer)a.get(obj1);
            } else
            {
                obj = (Integer)a.get(obj);
            }
            if (obj == null)
            {
                a.remove(c1);
            } else
            {
                a.put(c1, obj);
            }
        }
        for (obj = a.entrySet().iterator(); ((Iterator) (obj)).hasNext();)
        {
            obj1 = (java.util.Map.Entry)((Iterator) (obj)).next();
            c1 = (c)((java.util.Map.Entry) (obj1)).getKey();
            obj1 = (Integer)((java.util.Map.Entry) (obj1)).getValue();
            if (c1.b() != null && !c1.b().isEmpty())
            {
                hashmap.put(c1.b(), obj1);
            } else
            {
                hashmap1.put(c1.a(), obj1);
            }
        }

        if (!hashmap.isEmpty() || !hashmap1.isEmpty())
        {
            com.cyberlink.youcammakeup.clflurry.b.a(new ag(hashmap, hashmap1, YMKFeatures.a(BeautyMode.n)));
        }
        a.clear();
    }

    public void a(List list)
    {
        b.clear();
        b.addAll(list);
    }

    public void b()
    {
        if (a != null)
        {
            a.clear();
        }
    }

    public int getCount()
    {
        return b.size() + c.size();
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
        String s;
        if (view != null)
        {
            view = (f)view;
        } else
        {
            view = new f(viewgroup.getContext());
        }
        viewgroup = (TextView)view.findViewById(0x7f0c0897);
        s = a(i).a();
        if (s != null)
        {
            view.setTag(s);
            viewgroup.setText(s);
        }
        viewgroup = a(i);
        if (a.containsKey(viewgroup))
        {
            a.put(viewgroup, Integer.valueOf(((Integer)a.get(viewgroup)).intValue() + 1));
            return view;
        } else
        {
            a.put(viewgroup, Integer.valueOf(1));
            return view;
        }
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.c;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import com.cyberlink.you.friends.Friend;
import com.cyberlink.you.friends.l;
import com.cyberlink.you.o;
import com.cyberlink.you.p;
import com.cyberlink.you.utility.LoadImageUtils;
import com.cyberlink.you.widgetpool.common.CircleImageView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.cyberlink.you.c:
//            g, h, e

class f extends ArrayAdapter
    implements Filterable
{

    final e a;
    private List b;
    private List c;
    private g d;
    private l e;
    private Map f;

    public f(e e1, Context context, int i, List list)
    {
        a = e1;
        super(context, i, list);
        f = new HashMap();
        b = list;
        c = list;
        for (e1 = b.iterator(); e1.hasNext(); f.put(Long.valueOf(((Friend) (context)).a), Boolean.valueOf(false)))
        {
            context = (Friend)e1.next();
        }

    }

    static List a(f f1)
    {
        return f1.b;
    }

    static List a(f f1, List list)
    {
        f1.c = list;
        return list;
    }

    static l b(f f1)
    {
        return f1.e;
    }

    static List c(f f1)
    {
        return f1.c;
    }

    public Friend a(int i)
    {
        return (Friend)c.get(i);
    }

    public List a()
    {
        ArrayList arraylist = new ArrayList();
        Iterator iterator = f.entrySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            if (((Boolean)entry.getValue()).booleanValue())
            {
                arraylist.add(entry.getKey());
            }
        } while (true);
        return arraylist;
    }

    public void a(long l, boolean flag)
    {
        f.put(Long.valueOf(l), Boolean.valueOf(flag));
    }

    public void a(l l)
    {
        e = l;
    }

    public boolean a(long l)
    {
        Boolean boolean1 = (Boolean)f.get(Long.valueOf(l));
        if (boolean1 == null)
        {
            return false;
        } else
        {
            return boolean1.booleanValue();
        }
    }

    public int getCount()
    {
        return c.size();
    }

    public Filter getFilter()
    {
        if (d == null)
        {
            d = new g(this, e);
        }
        return d;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        Friend friend;
        if (view == null)
        {
            view = ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(p.u_view_item_firend_group_create, viewgroup, false);
            viewgroup = new h(this, null);
            viewgroup.b = (TextView)view.findViewById(o.GroupCreateMemberName);
            viewgroup.a = (CircleImageView)view.findViewById(o.GroupCreateImageView);
            viewgroup.c = (CheckBox)view.findViewById(o.GroupCreateMemberCheckBox);
            view.setTag(viewgroup);
        } else
        {
            viewgroup = (h)view.getTag();
        }
        friend = (Friend)c.get(i);
        if (friend.b() != null)
        {
            ((h) (viewgroup)).b.setText(friend.b());
        }
        if (friend.b != null)
        {
            LoadImageUtils.a(getContext(), friend, ((h) (viewgroup)).a);
        }
        ((h) (viewgroup)).c.setChecked(a(friend.a));
        return view;
    }
}

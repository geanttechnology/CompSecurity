// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import com.cyberlink.you.friends.Friend;
import com.cyberlink.you.o;
import com.cyberlink.you.p;
import com.cyberlink.you.utility.LoadImageUtils;
import com.cyberlink.you.widgetpool.common.CircleImageView;
import java.util.List;

// Referenced classes of package com.cyberlink.you.activity:
//            r, s, SelectUsersActivity

class q extends BaseAdapter
    implements Filterable
{

    final SelectUsersActivity a;
    private Context b;
    private List c;
    private List d;
    private r e;

    public q(SelectUsersActivity selectusersactivity, Context context, List list)
    {
        a = selectusersactivity;
        super();
        b = context;
        c = list;
        d = list;
    }

    static List a(q q1)
    {
        return q1.c;
    }

    static List a(q q1, List list)
    {
        q1.d = list;
        return list;
    }

    static List b(q q1)
    {
        return q1.d;
    }

    public Friend a(int i)
    {
        return (Friend)d.get(i);
    }

    public int getCount()
    {
        return d.size();
    }

    public Filter getFilter()
    {
        if (e == null)
        {
            e = new r(this, null);
        }
        return e;
    }

    public Object getItem(int i)
    {
        return a(i);
    }

    public long getItemId(int i)
    {
        return 0L;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        boolean flag = true;
        Friend friend;
        boolean flag1;
        if (view == null)
        {
            view = ((LayoutInflater)b.getSystemService("layout_inflater")).inflate(p.u_view_item_firend_group_create, viewgroup, false);
            viewgroup = new s(a, null);
            viewgroup.b = (TextView)view.findViewById(o.GroupCreateMemberName);
            viewgroup.a = (CircleImageView)view.findViewById(o.GroupCreateImageView);
            viewgroup.c = (CheckBox)view.findViewById(o.GroupCreateMemberCheckBox);
            view.setTag(viewgroup);
        } else
        {
            viewgroup = (s)view.getTag();
        }
        friend = (Friend)d.get(i);
        if (friend.b() != null)
        {
            ((s) (viewgroup)).b.setText(friend.b());
        }
        if (friend.b != null)
        {
            LoadImageUtils.a(b, friend, ((s) (viewgroup)).a);
        }
        flag1 = SelectUsersActivity.a(a, friend.a);
        ((s) (viewgroup)).c.setChecked(flag1);
        if (SelectUsersActivity.a(a) != null && SelectUsersActivity.a(a).contains(friend))
        {
            i = 1;
        } else
        {
            i = 0;
        }
        viewgroup = ((s) (viewgroup)).c;
        if (i != 0)
        {
            flag = false;
        }
        viewgroup.setEnabled(flag);
        return view;
    }
}

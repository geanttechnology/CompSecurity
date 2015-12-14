// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.cyberlink.you.friends.Friend;
import com.cyberlink.you.g;
import com.cyberlink.you.o;
import com.cyberlink.you.p;
import com.cyberlink.you.utility.LoadImageUtils;
import com.cyberlink.you.widgetpool.common.CircleImageView;
import java.util.List;

// Referenced classes of package com.cyberlink.you.activity:
//            o, MessageSettingActivity

class n extends ArrayAdapter
{

    final MessageSettingActivity a;
    private android.view.View.OnClickListener b;

    public n(MessageSettingActivity messagesettingactivity, Context context, int i, List list)
    {
        a = messagesettingactivity;
        super(context, i, list);
        b = new android.view.View.OnClickListener() {

            final n a;

            public void onClick(View view)
            {
                if (view.getTag() instanceof Friend)
                {
                    view = (Friend)view.getTag();
                    MessageSettingActivity.c(a.a, view);
                }
            }

            
            {
                a = n.this;
                super();
            }
        };
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        Friend friend;
        if (view == null)
        {
            view = ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(p.u_view_item_group_member, viewgroup, false);
            viewgroup = new com.cyberlink.you.activity.o(this, null);
            viewgroup.b = (TextView)view.findViewById(o.displayName);
            viewgroup.a = (CircleImageView)view.findViewById(o.avatar);
            viewgroup.c = view.findViewById(o.blockBtn);
            ((com.cyberlink.you.activity.o) (viewgroup)).c.setOnClickListener(b);
            view.setTag(viewgroup);
        } else
        {
            viewgroup = (com.cyberlink.you.activity.o)view.getTag();
        }
        friend = (Friend)getItem(i);
        if (friend.b() != null)
        {
            ((com.cyberlink.you.activity.o) (viewgroup)).b.setText(friend.b());
        }
        if (friend.b != null)
        {
            LoadImageUtils.a(getContext(), friend, ((com.cyberlink.you.activity.o) (viewgroup)).a);
        }
        if (friend.a == g.a().g().longValue())
        {
            ((com.cyberlink.you.activity.o) (viewgroup)).c.setVisibility(8);
        } else
        if (friend.d)
        {
            ((com.cyberlink.you.activity.o) (viewgroup)).c.setVisibility(8);
        } else
        {
            ((com.cyberlink.you.activity.o) (viewgroup)).c.setVisibility(0);
        }
        ((com.cyberlink.you.activity.o) (viewgroup)).c.setTag(friend);
        return view;
    }
}

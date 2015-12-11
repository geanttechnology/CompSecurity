// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.b.a.a.g;
import com.b.a.a.j;
import com.offerup.android.activities.a;
import com.offerup.android.dto.FollowProfile;
import com.offerup.android.dto.Message;
import com.offerup.android.dto.Person;
import com.offerup.android.utils.aq;
import com.offerup.android.utils.m;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

// Referenced classes of package com.offerup.android.a:
//            m, l, j, n, 
//            k

public final class i extends BaseAdapter
{

    Context a;
    a b;
    private List c;
    private LayoutInflater d;

    public i(Context context, List list, a a1)
    {
        d = LayoutInflater.from(context);
        a = context;
        c = list;
        b = a1;
    }

    public final void a()
    {
        c.clear();
    }

    public final int getCount()
    {
        if (c != null)
        {
            return c.size();
        } else
        {
            return 0;
        }
    }

    public final Object getItem(int i1)
    {
        return c.get(i1);
    }

    public final long getItemId(int i1)
    {
        return (long)i1;
    }

    public final int getItemViewType(int i1)
    {
        if (c == null)
        {
            g.a(this, new Throwable("List of messages is null"));
            return -1;
        }
        if (i1 >= c.size())
        {
            g.a(this, new Throwable("Position index is out of message list bounds"));
            return -1;
        }
        return ((Message)c.get(i1)).getMessageType() != 1 ? 0 : 1;
    }

    public final View getView(int i1, View view, ViewGroup viewgroup)
    {
        Message message = (Message)c.get(i1);
        Object obj;
        if (getItemViewType(i1) == 0)
        {
            if (view == null)
            {
                view = d.inflate(0x7f04006c, viewgroup, false);
                viewgroup = new com.offerup.android.a.m(this);
                viewgroup.b = (TextView)view.findViewById(0x7f100156);
                viewgroup.a = (TextView)view.findViewById(0x7f10009b);
                viewgroup.d = (ImageView)view.findViewById(0x7f1001bd);
                viewgroup.e = (ImageView)view.findViewById(0x7f1001be);
                view.setTag(viewgroup);
            } else
            {
                viewgroup = (com.offerup.android.a.m)view.getTag();
            }
            if (message.getSender().getId() == j.a().n())
            {
                viewgroup.c = ((com.offerup.android.a.m) (viewgroup)).e;
                ((com.offerup.android.a.m) (viewgroup)).b.setGravity(5);
                ((com.offerup.android.a.m) (viewgroup)).a.setGravity(5);
                ((com.offerup.android.a.m) (viewgroup)).d.setVisibility(4);
                ((com.offerup.android.a.m) (viewgroup)).e.setVisibility(0);
            } else
            {
                viewgroup.c = ((com.offerup.android.a.m) (viewgroup)).d;
                ((com.offerup.android.a.m) (viewgroup)).b.setGravity(3);
                ((com.offerup.android.a.m) (viewgroup)).a.setGravity(3);
                ((com.offerup.android.a.m) (viewgroup)).d.setVisibility(0);
                ((com.offerup.android.a.m) (viewgroup)).e.setVisibility(4);
                ((com.offerup.android.a.m) (viewgroup)).d.setOnTouchListener(new l(this, ((com.offerup.android.a.m) (viewgroup)).d));
                ((com.offerup.android.a.m) (viewgroup)).d.setOnClickListener(new com.offerup.android.a.j(this, message));
            }
            ((com.offerup.android.a.m) (viewgroup)).a.setText(message.getMessage());
            obj = m.a(message.getSendDate());
            if (StringUtils.isEmpty(((CharSequence) (obj))))
            {
                ((com.offerup.android.a.m) (viewgroup)).b.setText("");
            } else
            {
                ((com.offerup.android.a.m) (viewgroup)).b.setText((new StringBuilder("Sent ")).append(((String) (obj))).toString());
            }
            Picasso.with(a).load(message.getSender().getGetProfile().getAvatarSquare()).error(0x7f02018e).into(((com.offerup.android.a.m) (viewgroup)).c);
            obj = view;
        } else
        {
            obj = view;
            if (getItemViewType(i1) == 1)
            {
                View view1;
                if (view == null)
                {
                    view1 = d.inflate(0x7f0400c6, viewgroup, false);
                    view = new n(this);
                    view.a = (TextView)view1.findViewById(0x7f1002b7);
                    view.b = (TextView)view1.findViewById(0x7f1002b8);
                    view.c = (TextView)view1.findViewById(0x7f1002b6);
                    view.d = (TextView)view1.findViewById(0x7f1002b8);
                    view1.setTag(view);
                    viewgroup = view;
                } else
                {
                    viewgroup = (n)view.getTag();
                    view1 = view;
                }
                ((n) (viewgroup)).a.setText(message.getMessage());
                ((n) (viewgroup)).c.setText(message.getMessageTitle());
                ((n) (viewgroup)).d.setText(message.getMessageButtonText());
                ((n) (viewgroup)).b.setOnClickListener(new k(this, message));
                return view1;
            }
        }
        return ((View) (obj));
    }

    public final int getViewTypeCount()
    {
        int ai[] = aq.a;
        return 2;
    }

    public final boolean isEnabled(int i1)
    {
        return false;
    }
}

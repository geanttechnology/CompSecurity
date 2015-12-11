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
import com.offerup.android.dto.FollowProfile;
import com.offerup.android.dto.NoticeType;
import com.offerup.android.dto.Notification;
import com.offerup.android.dto.NotificationData;
import com.offerup.android.dto.Person;
import com.offerup.android.utils.m;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

// Referenced classes of package com.offerup.android.a:
//            d, c, b

public final class a extends BaseAdapter
{

    Context a;
    private List b;
    private LayoutInflater c;

    public a(Context context, List list)
    {
        c = LayoutInflater.from(context);
        a = context;
        b = list;
    }

    public final int getCount()
    {
        if (b != null)
        {
            return b.size();
        } else
        {
            return 0;
        }
    }

    public final Object getItem(int i)
    {
        return b.get(i);
    }

    public final long getItemId(int i)
    {
        return (long)i;
    }

    public final View getView(int i, View view, ViewGroup viewgroup)
    {
        Notification notification;
        String s;
        if (view == null)
        {
            view = c.inflate(0x7f040042, null);
            viewgroup = new d();
            viewgroup.b = (TextView)view.findViewById(0x7f100156);
            viewgroup.a = (TextView)view.findViewById(0x7f100155);
            viewgroup.c = (ImageView)view.findViewById(0x7f100153);
            viewgroup.d = (ImageView)view.findViewById(0x7f100154);
            view.setTag(viewgroup);
        } else
        {
            viewgroup = (d)view.getTag();
        }
        notification = (Notification)b.get(i);
        s = m.a(notification.getAdded());
        if (notification.getData() != null)
        {
            ((d) (viewgroup)).a.setText(notification.getData().getNotificationText());
            if (StringUtils.isEmpty(s))
            {
                ((d) (viewgroup)).b.setText("");
            } else
            {
                ((d) (viewgroup)).b.setText((new StringBuilder("Sent ")).append(s).toString());
            }
        }
        if (notification.getSender() != null && notification.getSender().getGetProfile() != null && notification.getSender().getGetProfile().getAvatarSquare() != null)
        {
            Picasso.with(a).load(notification.getSender().getGetProfile().getAvatarSquare()).error(0x7f02018e).into(((d) (viewgroup)).c);
        }
        if (notification.getNoticeType().getId() == 7)
        {
            ((d) (viewgroup)).d.setVisibility(0);
        } else
        {
            ((d) (viewgroup)).d.setVisibility(8);
        }
        ((d) (viewgroup)).c.setOnTouchListener(new c(this, ((d) (viewgroup)).c));
        ((d) (viewgroup)).c.setOnClickListener(new b(this, notification));
        return view;
    }
}

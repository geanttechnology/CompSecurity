// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.a;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.b.a.a.g;
import com.offerup.android.dto.BuyRequest;
import com.offerup.android.dto.Discussion;
import com.offerup.android.dto.FollowProfile;
import com.offerup.android.dto.Message;
import com.offerup.android.dto.Person;
import com.offerup.android.views.DynamicHeightImageView;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import java.util.List;

// Referenced classes of package com.offerup.android.a:
//            p

public final class o extends BaseAdapter
{

    private String a;
    private LayoutInflater b;
    private Context c;
    private List d;

    public o(Context context, List list)
    {
        a = "DiscussionsAdapter";
        b = LayoutInflater.from(context);
        c = context;
        d = list;
    }

    public final int getCount()
    {
        if (d != null)
        {
            return d.size();
        } else
        {
            return 0;
        }
    }

    public final Object getItem(int i)
    {
        return Integer.valueOf(i);
    }

    public final long getItemId(int i)
    {
        return (long)i;
    }

    public final View getView(int i, View view, ViewGroup viewgroup)
    {
        Object obj = null;
        p p1;
        String s;
        Discussion discussion;
        BuyRequest buyrequest;
        Person person;
        if (view == null)
        {
            viewgroup = b.inflate(0x7f04007b, null);
            p1 = new p();
            p1.a = (DynamicHeightImageView)viewgroup.findViewById(0x7f100153);
            p1.b = (TextView)viewgroup.findViewById(0x7f1001cd);
            p1.c = (TextView)viewgroup.findViewById(0x7f10009b);
            viewgroup.findViewById(0x7f100153);
            p1.d = (TextView)viewgroup.findViewById(0x7f1001d0);
            p1.e = viewgroup.findViewById(0x7f1001ce);
            p1.f = viewgroup.findViewById(0x7f1001d1);
            viewgroup.setTag(p1);
        } else
        {
            p1 = (p)view.getTag();
            viewgroup = view;
        }
        discussion = (Discussion)d.get(i);
        buyrequest = discussion.getCurrentBuyRequest();
        discussion.getItem();
        person = discussion.getLastMessage().getSender();
        if (discussion.getLastMessage() == null)
        {
            view = "Last message is missing";
        } else
        if (discussion.getMessageCount() == 1)
        {
            view = "1 message";
        } else
        {
            view = (new StringBuilder()).append(String.valueOf(discussion.getMessageCount())).append(" messages").toString();
        }
        if (person == null)
        {
            s = "Unknown";
        } else
        {
            s = person.getFirstName();
        }
        if (discussion.getCurrentBuyRequest() != null)
        {
            obj = (new StringBuilder("$")).append(discussion.getCurrentBuyRequest().getOffer()).toString();
        }
        p1.b.setText((new StringBuilder()).append(s).append(" - ").append(discussion.getLastPostDateAgo()).append(" ago").toString());
        p1.c.setText(view);
        p1.d.setText(((CharSequence) (obj)));
        if (obj == null)
        {
            p1.e.setVisibility(4);
        } else
        {
            p1.e.setVisibility(0);
        }
        if (buyrequest != null && buyrequest.isRequirePayments())
        {
            p1.f.setVisibility(0);
        } else
        {
            p1.f.setVisibility(8);
        }
        if (person != null && person.getGetProfile() != null)
        {
            view = person.getGetProfile().getAvatarSquare();
            p1.a.setHeightRatio(1.0D);
            try
            {
                Picasso.with(c).load(view).placeholder(0x7f02018e).error(0x7f02018e).into(p1.a);
            }
            // Misplaced declaration of an exception variable
            catch (View view)
            {
                g.c(a, Log.getStackTraceString(view));
                return viewgroup;
            }
        }
        return viewgroup;
    }
}

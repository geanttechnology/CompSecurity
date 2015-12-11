// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.a;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.offerup.android.dto.FollowProfile;
import com.offerup.android.dto.Person;
import com.offerup.android.h.a;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

// Referenced classes of package com.offerup.android.a:
//            ao, am, an

public final class al extends android.support.v7.widget.RecyclerView.Adapter
{

    private List a;
    private Context b;
    private a c;

    public al(Context context, a a1, List list)
    {
        b = context;
        c = a1;
        a = list;
    }

    static a a(al al1)
    {
        return al1.c;
    }

    public final Person a(int i)
    {
        if (i >= 0 && i < a.size())
        {
            return (Person)a.get(i);
        } else
        {
            return null;
        }
    }

    public final void a(List list)
    {
        if (list != null)
        {
            a.clear();
            a.addAll(list);
        }
    }

    public final int getItemCount()
    {
        return a.size();
    }

    public final void onBindViewHolder(android.support.v7.widget.RecyclerView.ViewHolder viewholder, int i)
    {
        viewholder = (ao)viewholder;
        if (a != null && a.size() > 0)
        {
            Person person = (Person)a.get(i);
            Picasso.with(b).load(person.getGetProfile().getAvatarNormal()).into(((ao) (viewholder)).a);
            ((ao) (viewholder)).b.setText(person.getFirstName());
            if (StringUtils.isNotEmpty(person.getGetProfile().getPublicLocationName()))
            {
                ((ao) (viewholder)).c.setText(person.getGetProfile().getPublicLocationName());
            } else
            {
                ((ao) (viewholder)).c.setText("");
            }
            ((ao) (viewholder)).d.setOnClickListener(new am(this, i));
            ((ao) (viewholder)).e.setOnClickListener(new an(this, viewholder));
        }
    }

    public final android.support.v7.widget.RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewgroup, int i)
    {
        viewgroup = LayoutInflater.from(viewgroup.getContext()).inflate(0x7f0400c9, viewgroup, false);
        ao ao1 = new ao(this, viewgroup);
        ao1.a = (ImageView)viewgroup.findViewById(0x7f1002bb);
        ao1.b = (TextView)viewgroup.findViewById(0x7f1002bd);
        ao1.c = (TextView)viewgroup.findViewById(0x7f1002be);
        ao1.d = (CardView)viewgroup.findViewById(0x7f1002bc);
        viewgroup.setTag(ao1);
        return ao1;
    }
}

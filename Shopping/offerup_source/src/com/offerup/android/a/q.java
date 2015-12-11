// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.offerup.android.activities.ExploreActivity;
import com.offerup.android.dto.ItemList;
import com.offerup.android.utils.w;
import com.offerup.android.views.DynamicHeightImageView;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import java.util.ArrayList;

// Referenced classes of package com.offerup.android.a:
//            ah, s, r

public final class q extends ah
{

    private ExploreActivity a;

    public q(ExploreActivity exploreactivity, ArrayList arraylist)
    {
        super(exploreactivity, arraylist);
        a = exploreactivity;
    }

    static ExploreActivity a(q q1)
    {
        return q1.a;
    }

    public final void onBindViewHolder(android.support.v7.widget.RecyclerView.ViewHolder viewholder, int i)
    {
        viewholder = (s)viewholder;
        Object obj = (ItemList)a(i);
        ((s) (viewholder)).b.setText(((ItemList) (obj)).getName());
        double d = (double)((ItemList) (obj)).getImage_medium_height() / (double)((ItemList) (obj)).getImage_medium_width();
        ((s) (viewholder)).a.setHeightRatio(d);
        obj = ((ItemList) (obj)).getImage_medium_url();
        Picasso.with(b).load(((android.net.Uri) (obj))).placeholder(w.a(i)).into(((s) (viewholder)).a);
        ((s) (viewholder)).c.setOnClickListener(new r(this, i));
    }

    public final android.support.v7.widget.RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewgroup, int i)
    {
        viewgroup = LayoutInflater.from(b).inflate(0x7f04007e, null);
        s s1 = new s(viewgroup);
        s1.a = (DynamicHeightImageView)viewgroup.findViewById(0x7f1001d6);
        s1.b = (TextView)viewgroup.findViewById(0x7f1001d7);
        viewgroup.setTag(s1);
        return s1;
    }
}

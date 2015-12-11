// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.a;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.offerup.android.dto.Discussion;
import com.offerup.android.dto.Item;
import com.offerup.android.tracker.a;
import com.offerup.android.utils.w;
import com.offerup.android.views.DynamicHeightImageView;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import java.util.List;

// Referenced classes of package com.offerup.android.a:
//            ah, w, v

public final class u extends ah
{

    protected com.offerup.android.h.a a;

    public u(com.offerup.android.h.a a1, Context context, List list)
    {
        super(context, list);
        a = a1;
    }

    private void a(TextView textview, String s, int i)
    {
        textview.setVisibility(0);
        textview.setText(s);
        textview.setBackgroundColor(b.getResources().getColor(i));
    }

    public final void onBindViewHolder(android.support.v7.widget.RecyclerView.ViewHolder viewholder, int i)
    {
        Item item;
        int j;
        viewholder = (com.offerup.android.a.w)viewholder;
        item = ((Discussion)a(i)).getItem();
        ((com.offerup.android.a.w) (viewholder)).b.setVisibility(8);
        j = item.getState();
        if (j != 2) goto _L2; else goto _L1
_L1:
        a(((com.offerup.android.a.w) (viewholder)).b, "UNLISTED", 0x7f0e00e8);
_L4:
        if (((com.offerup.android.a.w) (viewholder)).a != null)
        {
            double d = (double)item.getGetImgMediumHeight() / (double)item.getGetImgMediumWidth();
            ((com.offerup.android.a.w) (viewholder)).a.setHeightRatio(d);
            android.net.Uri uri = item.getGetImgPermalinkSmall();
            Picasso.with(b).load(uri).placeholder(w.a(i)).into(((com.offerup.android.a.w) (viewholder)).a);
            com.offerup.android.tracker.a.a(this, item.getGetImgPermalinkLarge(), "https://offerupnow.com/", item.getId());
        }
        ((com.offerup.android.a.w) (viewholder)).c.setOnClickListener(new v(this, i));
        return;
_L2:
        if (j == 4)
        {
            if (item.getOrderId() > 0L)
            {
                a(((com.offerup.android.a.w) (viewholder)).b, "PAID", 0x7f0e00e7);
            } else
            {
                a(((com.offerup.android.a.w) (viewholder)).b, "SOLD", 0x7f0e00e7);
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public final android.support.v7.widget.RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewgroup, int i)
    {
        viewgroup = LayoutInflater.from(b).inflate(0x7f0400aa, null);
        com.offerup.android.a.w w1 = new com.offerup.android.a.w(viewgroup);
        w1.a = (DynamicHeightImageView)viewgroup.findViewById(0x7f1000e3);
        w1.b = (TextView)viewgroup.findViewById(0x7f10028a);
        viewgroup.setTag(w1);
        return w1;
    }
}

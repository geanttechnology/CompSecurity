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
import com.offerup.android.dto.Item;
import com.offerup.android.tracker.a;
import com.offerup.android.utils.w;
import com.offerup.android.views.DynamicHeightImageView;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import java.util.List;

// Referenced classes of package com.offerup.android.a:
//            ah, ac, ab

public final class aa extends ah
{

    private com.offerup.android.h.a a;
    private Context e;

    public aa(com.offerup.android.h.a a1, Context context, List list)
    {
        super(context, list);
        e = context;
        a = a1;
    }

    static com.offerup.android.h.a a(aa aa1)
    {
        return aa1.a;
    }

    public final void onBindViewHolder(android.support.v7.widget.RecyclerView.ViewHolder viewholder, int i)
    {
        viewholder = (ac)viewholder;
        Item item = (Item)a(i);
        int j = item.getState();
        if (j == 2)
        {
            ((ac) (viewholder)).b.setVisibility(0);
            ((ac) (viewholder)).b.setText("UNLISTED");
            ((ac) (viewholder)).b.setBackgroundColor(e.getResources().getColor(0x7f0e00e8));
        } else
        if (j == 4)
        {
            ((ac) (viewholder)).b.setVisibility(0);
            ((ac) (viewholder)).b.setText("SOLD");
            ((ac) (viewholder)).b.setBackgroundColor(e.getResources().getColor(0x7f0e00e7));
        } else
        {
            ((ac) (viewholder)).b.setVisibility(8);
        }
        if (((ac) (viewholder)).a != null)
        {
            double d = (double)item.getGetImgMediumHeight() / (double)item.getGetImgMediumWidth();
            ((ac) (viewholder)).a.setHeightRatio(d);
            android.net.Uri uri = item.getGetImgPermalinkSmall();
            Picasso.with(e).load(uri).placeholder(w.a(i)).into(((ac) (viewholder)).a);
            com.offerup.android.tracker.a.a(this, item.getGetImgPermalinkLarge(), "https://offerupnow.com/", item.getId());
        }
        ((ac) (viewholder)).c.setOnClickListener(new ab(this, i));
    }

    public final android.support.v7.widget.RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewgroup, int i)
    {
        viewgroup = LayoutInflater.from(b).inflate(0x7f0400ab, null);
        ac ac1 = new ac(viewgroup);
        ac1.a = (DynamicHeightImageView)viewgroup.findViewById(0x7f1000e3);
        ac1.b = (TextView)viewgroup.findViewById(0x7f10028a);
        viewgroup.setTag(ac1);
        return ac1;
    }
}

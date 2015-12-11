// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.b.a.a.g;
import com.offerup.android.activities.UserDetailActivity;
import com.offerup.android.dto.Item;
import com.offerup.android.tracker.a;
import com.offerup.android.utils.w;
import com.offerup.android.views.DynamicHeightImageView;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import java.util.List;

// Referenced classes of package com.offerup.android.a:
//            ah, aw, av

public final class au extends ah
{

    protected UserDetailActivity a;

    public au(UserDetailActivity userdetailactivity, List list)
    {
        super(userdetailactivity, list);
        a = userdetailactivity;
    }

    public final void onBindViewHolder(android.support.v7.widget.RecyclerView.ViewHolder viewholder, int i)
    {
        viewholder = (aw)viewholder;
        if (i != 0 || viewholder.getItemViewType() != 0x80000000 || !c())
        {
            if (i == getItemCount())
            {
                if (viewholder.getItemViewType() != 0x80000001);
            }
            Item item = (Item)a(i);
            if (item.getState() == 4)
            {
                ((aw) (viewholder)).b.setVisibility(0);
                ((aw) (viewholder)).c.setVisibility(0);
                ((aw) (viewholder)).b.setText(a.getString(0x7f090216));
            } else
            {
                ((aw) (viewholder)).b.setVisibility(8);
                ((aw) (viewholder)).c.setVisibility(8);
            }
            if (((aw) (viewholder)).a != null)
            {
                double d = (double)item.getGetImgMediumHeight() / (double)item.getGetImgMediumWidth();
                ((aw) (viewholder)).a.setHeightRatio(d);
                android.net.Uri uri = item.getGetImgPermalinkSmall();
                Picasso.with(b).load(uri).placeholder(w.a(i)).into(((aw) (viewholder)).a);
                com.offerup.android.tracker.a.a(this, item.getGetImgPermalinkLarge(), "https://offerupnow.com/", item.getId());
            } else
            {
                g.c("UserDetailItemGridAdapter", "imageView was null, so not loading image");
            }
            ((aw) (viewholder)).d.setOnClickListener(new av(this, i));
            return;
        } else
        {
            ((android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams)((aw) (viewholder)).d.getLayoutParams()).setFullSpan(true);
            return;
        }
    }

    public final android.support.v7.widget.RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewgroup, int i)
    {
        c = i;
        if (i == 0x80000000 && c() && d != null)
        {
            viewgroup = new aw(d);
            d.setTag(viewgroup);
            return viewgroup;
        } else
        {
            viewgroup = LayoutInflater.from(b).inflate(0x7f0400c7, null);
            aw aw1 = new aw(viewgroup);
            aw1.a = (DynamicHeightImageView)viewgroup.findViewById(0x7f1000e3);
            aw1.b = (TextView)viewgroup.findViewById(0x7f10020d);
            aw1.c = (ImageView)viewgroup.findViewById(0x7f1002b9);
            viewgroup.setTag(aw1);
            return aw1;
        }
    }
}

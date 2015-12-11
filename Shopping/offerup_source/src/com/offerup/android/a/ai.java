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
import com.offerup.android.activities.SearchActivity;
import com.offerup.android.dto.Item;
import com.offerup.android.tracker.a;
import com.offerup.android.utils.w;
import com.offerup.android.views.DynamicHeightImageView;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import java.util.List;

// Referenced classes of package com.offerup.android.a:
//            ah, ak, aj

public final class ai extends ah
{

    protected SearchActivity a;

    public ai(SearchActivity searchactivity, List list)
    {
        super(searchactivity, list);
        a = searchactivity;
    }

    public final void onBindViewHolder(android.support.v7.widget.RecyclerView.ViewHolder viewholder, int i)
    {
        viewholder = (ak)viewholder;
        if (i != 0 || viewholder.getItemViewType() != 0x80000000 || !c())
        {
            if (i == getItemCount())
            {
                if (viewholder.getItemViewType() != 0x80000001);
            }
            Item item = (Item)a(i);
            int j;
            if (item.getState() == 4)
            {
                ((ak) (viewholder)).b.setVisibility(0);
                ((ak) (viewholder)).c.setVisibility(0);
                ((ak) (viewholder)).b.setText("sold");
            } else
            {
                ((ak) (viewholder)).b.setVisibility(8);
                ((ak) (viewholder)).c.setVisibility(8);
            }
            if (((ak) (viewholder)).a != null)
            {
                double d = (double)item.getGetImgSmallHeight() / (double)item.getGetImgSmallWidth();
                ((ak) (viewholder)).a.setHeightRatio(d);
                android.net.Uri uri = item.getGetImgPermalinkSmall();
                Picasso.with(b).load(uri).placeholder(w.a(i)).into(((ak) (viewholder)).a);
                com.offerup.android.tracker.a.a(this, item.getGetImgPermalinkLarge(), "https://offerupnow.com/", item.getId());
            } else
            {
                g.c("UserDetailItemGridAdapter", "imageView was null, so not loading image");
            }
            j = getItemCount();
            if (i == j - 25 && i != 0 && j < b())
            {
                a.m();
            }
            ((ak) (viewholder)).d.setOnClickListener(new aj(this, i));
            return;
        } else
        {
            ((android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams)((ak) (viewholder)).d.getLayoutParams()).setFullSpan(true);
            return;
        }
    }

    public final android.support.v7.widget.RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewgroup, int i)
    {
        c = i;
        if (i == 0x80000000 && c() && d != null)
        {
            viewgroup = new ak(d);
            d.setTag(viewgroup);
            return viewgroup;
        } else
        {
            viewgroup = LayoutInflater.from(b).inflate(0x7f0400c7, null);
            ak ak1 = new ak(viewgroup);
            ak1.a = (DynamicHeightImageView)viewgroup.findViewById(0x7f1000e3);
            ak1.b = (TextView)viewgroup.findViewById(0x7f10020d);
            ak1.c = (ImageView)viewgroup.findViewById(0x7f1002b9);
            viewgroup.setTag(ak1);
            return ak1;
        }
    }
}

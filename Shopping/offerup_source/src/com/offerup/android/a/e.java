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
import com.b.a.a.g;
import com.offerup.android.activities.MyArchivedOffersActivity;
import com.offerup.android.dto.Item;
import com.offerup.android.utils.w;
import com.offerup.android.views.DynamicHeightImageView;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import java.util.List;

// Referenced classes of package com.offerup.android.a:
//            ah, g, f

public final class e extends ah
{

    protected MyArchivedOffersActivity a;
    private final String e = getClass().getSimpleName();

    public e(MyArchivedOffersActivity myarchivedoffersactivity, List list)
    {
        super(myarchivedoffersactivity, list);
        a = myarchivedoffersactivity;
    }

    public final void onBindViewHolder(android.support.v7.widget.RecyclerView.ViewHolder viewholder, int i)
    {
        viewholder = (com.offerup.android.a.g)viewholder;
        if (i != 0 || viewholder.getItemViewType() != 0x80000000 || !c())
        {
            if (i == getItemCount())
            {
                if (viewholder.getItemViewType() != 0x80000001);
            }
            Item item = (Item)a(i);
            if (((com.offerup.android.a.g) (viewholder)).a != null && item != null)
            {
                double d = (double)item.getGetImgSmallHeight() / (double)item.getGetImgSmallWidth();
                ((com.offerup.android.a.g) (viewholder)).a.setHeightRatio(d);
                android.net.Uri uri = item.getGetImgPermalinkSmall();
                Picasso.with(b).load(uri).placeholder(w.a(i)).into(((com.offerup.android.a.g) (viewholder)).a);
                ((com.offerup.android.a.g) (viewholder)).c.setOnClickListener(new f(this, i));
            } else
            {
                g.c(e, "imageView or item was null, so not loading image");
            }
            i = item.getState();
            if (i == 2)
            {
                ((com.offerup.android.a.g) (viewholder)).b.setVisibility(0);
                ((com.offerup.android.a.g) (viewholder)).b.setText("UNLISTED");
                ((com.offerup.android.a.g) (viewholder)).b.setBackgroundColor(b.getResources().getColor(0x7f0e00e8));
                return;
            }
        } else
        {
            ((android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams)((com.offerup.android.a.g) (viewholder)).c.getLayoutParams()).setFullSpan(true);
            return;
        }
        if (i == 4)
        {
            ((com.offerup.android.a.g) (viewholder)).b.setVisibility(0);
            ((com.offerup.android.a.g) (viewholder)).b.setText("SOLD");
            ((com.offerup.android.a.g) (viewholder)).b.setBackgroundColor(b.getResources().getColor(0x7f0e00e7));
            return;
        } else
        {
            ((com.offerup.android.a.g) (viewholder)).b.setVisibility(8);
            return;
        }
    }

    public final android.support.v7.widget.RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewgroup, int i)
    {
        if (i == 0x80000000 && c() && d != null)
        {
            viewgroup = new com.offerup.android.a.g(d);
            d.setTag(viewgroup);
            return viewgroup;
        } else
        {
            viewgroup = LayoutInflater.from(b).inflate(0x7f04005c, null);
            com.offerup.android.a.g g1 = new com.offerup.android.a.g(viewgroup);
            g1.a = (DynamicHeightImageView)viewgroup.findViewById(0x7f100196);
            g1.b = (TextView)viewgroup.findViewById(0x7f100197);
            viewgroup.setTag(g1);
            return g1;
        }
    }
}

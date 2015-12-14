// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.shop;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.b;
import com.bumptech.glide.j;
import com.bumptech.glide.load.engine.l;
import com.bumptech.glide.request.e;
import com.socialin.android.util.Utils;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.picsart.shop:
//            ShopRecyclerViewBaseAdapter, l, a, c, 
//            v

public final class k extends ShopRecyclerViewBaseAdapter
{

    public c a;
    private e h;

    public k(Context context)
    {
        super(context);
        a = null;
        h = (e)((e)e.b(l.e).a(0x7f0201f8)).b(0x7f0201f8);
        e = b.b(context.getApplicationContext()).i().a(0.1F);
        f = b.b(context.getApplicationContext());
        f.i().b = e;
    }

    public final volatile j a(Object obj)
    {
        obj = (com.socialin.android.apiv3.model.ShopItemsListResponse.ShopItem)obj;
        return f.a(obj);
    }

    public final List a(int i)
    {
        return g.subList(i, i + 1);
    }

    public final boolean a(com.socialin.android.apiv3.model.ShopItemsListResponse.ShopItem shopitem)
    {
        if (getItemCount() == 0)
        {
            return false;
        }
        for (Iterator iterator = b().iterator(); iterator.hasNext();)
        {
            if (((com.socialin.android.apiv3.model.ShopItemsListResponse.ShopItem)iterator.next()).data.shopItemUid.equalsIgnoreCase(shopitem.data.shopItemUid))
            {
                return true;
            }
        }

        return false;
    }

    public final void onBindViewHolder(android.support.v7.widget.RecyclerView.ViewHolder viewholder, int i)
    {
        com.picsart.shop.l l1 = (com.picsart.shop.l)viewholder;
        super.onBindViewHolder(l1, i);
        com.socialin.android.apiv3.model.ShopItemsListResponse.ShopItem shopitem = (com.socialin.android.apiv3.model.ShopItemsListResponse.ShopItem)b(l1.getPosition());
        l1.h.setPaintFlags(l1.h.getPaintFlags() & 0xffffffef);
        viewholder = com.picsart.shop.a.c(shopitem);
        String s = com.picsart.shop.a.b(shopitem, 1);
        String s1 = com.picsart.shop.a.b(shopitem, 2);
        String s2 = com.picsart.shop.a.b(shopitem, 3);
        String s3 = com.picsart.shop.a.b(shopitem, 4);
        l1.j.setVisibility(8);
        l1.itemView.setOnClickListener(new android.view.View.OnClickListener(l1) {

            private com.picsart.shop.l a;
            private k b;

            public final void onClick(View view)
            {
                if (b.c != null)
                {
                    b.c.a(a.getPosition());
                }
            }

            
            {
                b = k.this;
                a = l1;
                super();
            }
        });
        if (shopitem.data.miniDescription != null)
        {
            l1.g.setText(shopitem.data.miniDescription);
        }
        ImageView imageview = l1.k;
        if (shopitem.isNew)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        imageview.setVisibility(i);
        if (shopitem.data.previewCount == 0)
        {
            l1.b.setVisibility(4);
            l1.c.setVisibility(4);
            l1.d.setVisibility(4);
            if (l1.e != null)
            {
                l1.e.setVisibility(4);
            }
        } else
        {
            l1.b.setVisibility(0);
            l1.c.setVisibility(0);
            l1.d.setVisibility(0);
            if (l1.e != null)
            {
                l1.e.setVisibility(0);
            }
            f.a(l1.b);
            f.a(l1.c);
            f.a(l1.d);
            f.a(s).a(h).a(l1.b);
            f.a(s1).a(h).a(l1.c);
            f.a(s2).a(h).a(l1.d);
            if (l1.e != null)
            {
                f.a(l1.e);
                f.a(s3).a(h).a(l1.e);
            }
        }
        f.a(viewholder).a(e.b(l.e)).a(l1.a);
        l1.f.setText(shopitem.data.name);
        if (shopitem.data.price > 0)
        {
            if (TextUtils.isEmpty(shopitem.data.priceString))
            {
                l1.h.setText((new StringBuilder("$ ")).append(shopitem.getPrice()).toString());
            } else
            {
                l1.h.setText(shopitem.data.priceString);
            }
        } else
        {
            l1.h.setText(0x7f080072);
        }
        l1.i.setOnClickListener(new android.view.View.OnClickListener(shopitem) {

            private com.socialin.android.apiv3.model.ShopItemsListResponse.ShopItem a;
            private k b;

            public final void onClick(View view)
            {
                if (b.a != null)
                {
                    b.a.a(a);
                }
            }

            
            {
                b = k.this;
                a = shopitem;
                super();
            }
        });
        Utils.f(b);
        if (shopitem.installed || shopitem.installing)
        {
            l1.h.setText(0x7f0802e4);
            l1.i.setBackgroundDrawable(null);
            l1.i.setOnClickListener(null);
            return;
        }
        if (shopitem.owned)
        {
            l1.h.setText(0x7f0802e3);
            l1.i.setBackgroundResource(0x7f020650);
            return;
        }
        if (shopitem.data.price > 0)
        {
            viewholder = Utils.f(b);
            if (viewholder != null && shopitem.promoted)
            {
                i = 1;
                f.a(com.picsart.shop.a.a(shopitem, viewholder)).a(e.b(l.e)).a(l1.j);
            } else
            {
                i = 0;
            }
            if (shopitem.data.priceString == null || "".equals(shopitem.data.priceString))
            {
                viewholder = (new StringBuilder("$")).append(shopitem.getPrice()).toString();
            } else
            {
                viewholder = shopitem.data.priceString;
            }
            l1.h.setText(viewholder);
            if (i == 0)
            {
                if (l1.e != null && shopitem.data.previewCount >= 4)
                {
                    l1.e.setVisibility(0);
                    l1.d.setVisibility(0);
                }
                l1.j.setVisibility(8);
                l1.i.setBackgroundResource(0x7f020650);
                return;
            } else
            {
                l1.h.setPaintFlags(l1.h.getPaintFlags() | 0x10);
                l1.j.setVisibility(0);
                l1.j.setOnClickListener(new android.view.View.OnClickListener(shopitem) {

                    private com.socialin.android.apiv3.model.ShopItemsListResponse.ShopItem a;
                    private k b;

                    public final void onClick(View view)
                    {
                        if (b.a != null)
                        {
                            b.a.a(a);
                        }
                    }

            
            {
                b = k.this;
                a = shopitem;
                super();
            }
                });
                l1.i.setBackgroundDrawable(null);
                return;
            }
        } else
        {
            l1.h.setText(0x7f080072);
            l1.i.setBackgroundResource(0x7f020650);
            return;
        }
    }

    public final android.support.v7.widget.RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewgroup, int i)
    {
        return new com.picsart.shop.l(LayoutInflater.from(b).inflate(0x7f0301d9, viewgroup, false));
    }
}

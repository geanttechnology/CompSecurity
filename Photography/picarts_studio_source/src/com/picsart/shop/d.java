// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.shop;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.socialin.android.adapter.RecyclerViewAdapter;

// Referenced classes of package com.picsart.shop:
//            e, ShopItemsListActivity

public final class d extends RecyclerViewAdapter
{

    public d(Context context)
    {
        super(context);
    }

    static Context a(d d1)
    {
        return d1.context;
    }

    static Context b(d d1)
    {
        return d1.context;
    }

    public final void onBindViewHolder(android.support.v7.widget.RecyclerView.ViewHolder viewholder, int i)
    {
        viewholder = (e)viewholder;
        super.onBindViewHolder(viewholder, i);
        String s = (String)getItem(i);
        ((e) (viewholder)).a.setText(s);
    }

    public final android.support.v7.widget.RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewgroup, int i)
    {
        viewgroup = LayoutInflater.from(context).inflate(0x7f0301d0, viewgroup, false);
        viewgroup.setOnClickListener(new android.view.View.OnClickListener() {

            private d a;

            public final void onClick(View view)
            {
                Intent intent = new Intent(d.a(a), com/picsart/shop/ShopItemsListActivity);
                intent.putExtra("selectedTag", ((TextView)view).getText().toString());
                intent.putExtra("fromSource", "shopCategories");
                d.b(a).startActivity(intent);
            }

            
            {
                a = d.this;
                super();
            }
        });
        return new e(viewgroup);
    }
}

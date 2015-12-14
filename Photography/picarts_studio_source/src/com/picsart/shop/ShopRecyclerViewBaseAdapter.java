// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.shop;

import android.content.Context;
import com.bumptech.glide.f;
import com.bumptech.glide.j;
import com.bumptech.glide.k;
import com.picsart.studio.view.e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.picsart.shop:
//            v

public abstract class ShopRecyclerViewBaseAdapter extends android.support.v7.widget.RecyclerView.Adapter
    implements f
{

    protected Context b;
    protected v c;
    e d;
    protected j e;
    protected k f;
    protected List g;

    public ShopRecyclerViewBaseAdapter(Context context)
    {
        this(context, (byte)0);
    }

    private ShopRecyclerViewBaseAdapter(Context context, byte byte0)
    {
        b = context;
        c = null;
        g = new ArrayList();
    }

    public final void a()
    {
        g.clear();
        notifyDataSetChanged();
    }

    public final void a(v v)
    {
        c = v;
    }

    public final Object b(int i)
    {
        return g.get(i);
    }

    public final List b()
    {
        return Collections.unmodifiableList(g);
    }

    public final void b(Object obj)
    {
        g.add(obj);
        notifyItemInserted(g.size() - 1);
    }

    public final boolean c()
    {
        return g.isEmpty();
    }

    public int getItemCount()
    {
        return g.size();
    }

    public void onBindViewHolder(android.support.v7.widget.RecyclerView.ViewHolder viewholder, int i)
    {
        if (i == g.size() - 1 && d != null)
        {
            d.a();
        }
    }
}

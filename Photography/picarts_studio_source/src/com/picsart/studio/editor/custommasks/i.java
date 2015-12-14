// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.custommasks;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.picsart.studio.editor.custommasks:
//            h, l, k, j

public final class i extends android.support.v7.widget.RecyclerView.Adapter
{

    public h a;
    public l b;
    private List c;

    public i(List list)
    {
        c = list;
        a(0);
    }

    static List a(i i1)
    {
        return i1.c;
    }

    public final int a(h h1)
    {
        return c.indexOf(h1);
    }

    public final void a(int i1)
    {
        b((h)c.get(i1));
    }

    public final void b(h h1)
    {
        for (Iterator iterator = c.iterator(); iterator.hasNext();)
        {
            ((h)iterator.next()).d = false;
        }

        if (a != null)
        {
            notifyItemChanged(c.indexOf(a));
        }
        a = h1;
        a.d = true;
        notifyItemChanged(c.indexOf(a));
        if (b != null)
        {
            b.a(h1);
        }
    }

    public final int getItemCount()
    {
        return c.size();
    }

    public final int getItemViewType(int i1)
    {
        if (c.size() == 0)
        {
            return 42;
        } else
        {
            return super.getItemViewType(i1);
        }
    }

    public final void onBindViewHolder(android.support.v7.widget.RecyclerView.ViewHolder viewholder, int i1)
    {
        if (!(viewholder instanceof k))
        {
            return;
        } else
        {
            h h1 = (h)c.get(i1);
            viewholder = (k)viewholder;
            ((k) (viewholder)).a.setText(h1.toString());
            ((k) (viewholder)).itemView.setActivated(h1.d);
            return;
        }
    }

    public final android.support.v7.widget.RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewgroup, int i1)
    {
        if (i1 == 42)
        {
            viewgroup = new TextView(viewgroup.getContext());
            viewgroup.setTextSize(20F);
            viewgroup.setTextColor(0xffffff);
            viewgroup.setGravity(17);
            viewgroup.setText("No items");
            return new j(viewgroup);
        } else
        {
            return new k(this, LayoutInflater.from(viewgroup.getContext()).inflate(0x7f030158, viewgroup, false));
        }
    }
}

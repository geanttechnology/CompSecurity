// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.custommasks;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.picsart.studio.editor.custommasks:
//            o, Mask, g, h, 
//            f, e, p

public final class d extends android.support.v7.widget.RecyclerView.Adapter
{

    public final o a;
    public List b;
    public Mask c;
    public g d;
    public boolean e;
    private Context f;

    public d(Context context, Activity activity, p p)
    {
        f = context;
        a = new o(activity, p);
        b = new ArrayList();
        c = null;
        e = false;
    }

    static boolean a(d d1)
    {
        return d1.e;
    }

    static Context b(d d1)
    {
        return d1.f;
    }

    static List c(d d1)
    {
        return d1.b;
    }

    static o d(d d1)
    {
        return d1.a;
    }

    public final Mask a(int i)
    {
        if (i < 0 || i > b.size() - 1)
        {
            return null;
        } else
        {
            return (Mask)b.get(i);
        }
    }

    public final void a(Mask mask)
    {
        if (mask != c)
        {
            if (c != null)
            {
                c.b(false);
            }
            c = mask;
            c.b(true);
            notifyDataSetChanged();
            if (d != null)
            {
                d.a(mask);
                return;
            }
        }
    }

    public final void a(h h1)
    {
        b = h1.c;
        notifyDataSetChanged();
    }

    public final int getItemCount()
    {
        return b.size();
    }

    public final int getItemViewType(int i)
    {
        if (b.size() == 0)
        {
            return 42;
        } else
        {
            return super.getItemViewType(i);
        }
    }

    public final void onBindViewHolder(android.support.v7.widget.RecyclerView.ViewHolder viewholder, int i)
    {
        if (!(viewholder instanceof f))
        {
            return;
        }
        viewholder = (f)viewholder;
        Mask mask = (Mask)b.get(i);
        com.picsart.studio.editor.custommasks.f.a(viewholder).setText(mask.b);
        android.graphics.Bitmap bitmap = mask.a(f);
        if (bitmap != null)
        {
            com.picsart.studio.editor.custommasks.f.b(viewholder).setImageBitmap(bitmap);
        }
        com.picsart.studio.editor.custommasks.f.b(viewholder).setActivated(mask.k);
    }

    public final android.support.v7.widget.RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewgroup, int i)
    {
        if (i == 42)
        {
            viewgroup = new TextView(viewgroup.getContext());
            viewgroup.setTextSize(20F);
            viewgroup.setTextColor(0xffffff);
            viewgroup.setGravity(17);
            viewgroup.setText("No items");
            return new e(viewgroup);
        } else
        {
            return new f(this, LayoutInflater.from(viewgroup.getContext()).inflate(0x7f030157, viewgroup, false));
        }
    }
}

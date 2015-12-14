// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.view.widgetpool.common;

import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.cyberlink.beautycircle.i;
import com.cyberlink.beautycircle.j;
import com.cyberlink.beautycircle.k;
import com.cyberlink.beautycircle.m;
import com.cyberlink.beautycircle.model.CircleBasic;
import com.perfectcorp.utility.e;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

// Referenced classes of package com.cyberlink.beautycircle.view.widgetpool.common:
//            CircleList, UICImageView, g

public class f
    implements ListAdapter
{

    final CircleList a;
    private HashSet b;

    protected f(CircleList circlelist)
    {
        a = circlelist;
        super();
        b = new HashSet();
    }

    public void a()
    {
        HashSet hashset = b;
        hashset;
        JVM INSTR monitorenter ;
        for (Iterator iterator = b.iterator(); iterator.hasNext(); ((DataSetObserver)iterator.next()).onChanged()) { }
        break MISSING_BLOCK_LABEL_44;
        Exception exception;
        exception;
        hashset;
        JVM INSTR monitorexit ;
        throw exception;
        hashset;
        JVM INSTR monitorexit ;
    }

    public boolean areAllItemsEnabled()
    {
        return true;
    }

    public int getCount()
    {
        return CircleList.c(a).size() + 1;
    }

    public Object getItem(int l)
    {
        if (l < CircleList.c(a).size())
        {
            return CircleList.c(a).get(l);
        } else
        {
            return null;
        }
    }

    public long getItemId(int l)
    {
        if (l < CircleList.c(a).size())
        {
            return ((CircleBasic)CircleList.c(a).get(l)).id.longValue();
        } else
        {
            return -1L;
        }
    }

    public int getItemViewType(int l)
    {
        return 0;
    }

    public View getView(int l, View view, ViewGroup viewgroup)
    {
        View view1 = view;
        if (view == null)
        {
            view1 = LayoutInflater.from(a.getContext()).inflate(k.bc_view_item_category_list, viewgroup, false);
        }
        view1.setVisibility(0);
        view1.setSelected(a.isItemChecked(l));
        viewgroup = (UICImageView)view1.findViewById(j.sharein_category_icon);
        TextView textview = (TextView)view1.findViewById(j.sharein_category_text);
        if (l == CircleList.c(a).size())
        {
            view1.setTag(null);
            view1.setOnClickListener(new android.view.View.OnClickListener() {

                final f a;

                public void onClick(View view2)
                {
                    if (com.cyberlink.beautycircle.view.widgetpool.common.CircleList.e(a.a) != null)
                    {
                        com.cyberlink.beautycircle.view.widgetpool.common.CircleList.e(a.a).a();
                    }
                }

            
            {
                a = f.this;
                super();
            }
            });
            viewgroup.setImageResource(i.bc_circle_create_ico);
            textview.setText(m.bc_me_create_circle);
            return view1;
        }
        if (l < CircleList.c(a).size())
        {
            view = (CircleBasic)CircleList.c(a).get(l);
        } else
        {
            view = null;
        }
        if (view == null)
        {
            e.e(new Object[] {
                "No circle at position(", Integer.valueOf(l), "), circle list size(", Integer.valueOf(CircleList.c(a).size()), ")"
            });
            view1.setVisibility(8);
            view1.setTag(null);
            view1.setOnClickListener(null);
            return view1;
        } else
        {
            view1.setTag(view);
            view1.setOnClickListener(new android.view.View.OnClickListener() {

                final f a;

                public void onClick(View view2)
                {
                    CircleList.a(a.a, (CircleBasic)view2.getTag());
                }

            
            {
                a = f.this;
                super();
            }
            });
            CircleList.a(viewgroup, view);
            textview.setText(((CircleBasic) (view)).circleName);
            return view1;
        }
    }

    public int getViewTypeCount()
    {
        return 1;
    }

    public boolean hasStableIds()
    {
        return true;
    }

    public boolean isEmpty()
    {
        return getCount() == 0;
    }

    public boolean isEnabled(int l)
    {
        return true;
    }

    public void registerDataSetObserver(DataSetObserver datasetobserver)
    {
        synchronized (b)
        {
            b.add(datasetobserver);
        }
        return;
        datasetobserver;
        hashset;
        JVM INSTR monitorexit ;
        throw datasetobserver;
    }

    public void unregisterDataSetObserver(DataSetObserver datasetobserver)
    {
        synchronized (b)
        {
            b.remove(datasetobserver);
        }
        return;
        datasetobserver;
        hashset;
        JVM INSTR monitorexit ;
        throw datasetobserver;
    }
}

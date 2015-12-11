// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.v3.adapter;

import android.content.Context;
import android.view.ViewGroup;
import com.groupon.util.AppStartupImageLoadListener;
import com.groupon.v3.adapter.mapping.Mapping;
import com.groupon.v3.adapter.mapping.VersionableCard;
import com.groupon.view.dealcards.DealCardBase;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class UniversalListAdapter extends android.support.v7.widget.RecyclerView.Adapter
{

    protected Context context;
    protected List dataMappingList;
    protected HashMap extras;
    protected AppStartupImageLoadListener imageLoadListener;
    protected List list;

    public UniversalListAdapter()
    {
        extras = new HashMap();
        dataMappingList = new ArrayList();
    }

    private void init()
    {
        list = Collections.EMPTY_LIST;
    }

    public boolean getColumnSpanAllColumns(int i)
    {
        return i < getItemCount() && ((Mapping)dataMappingList.get(getItemViewType(i))).getSpanAllColumns();
    }

    public Context getContext()
    {
        return context;
    }

    public Object getExtrasByKey(String s)
    {
        if (extras != null)
        {
            return extras.get(s);
        } else
        {
            return null;
        }
    }

    public AppStartupImageLoadListener getImageLoadListener()
    {
        return imageLoadListener;
    }

    public Object getItem(int i)
    {
        return list.get(i);
    }

    public int getItemCount()
    {
        return list.size();
    }

    public int getItemViewType(int i)
    {
        Object obj = getItem(i);
        i = getItemViewType(obj);
        if (i == -1)
        {
            throw new RuntimeException((new StringBuilder()).append("Unknown data class.  Add an entry to dataMappingList : Missing ").append(obj.getClass()).toString());
        } else
        {
            return i;
        }
    }

    public int getItemViewType(Object obj)
    {
        int j;
label0:
        {
            for (int i = 0; i < dataMappingList.size(); i++)
            {
                Mapping mapping = (Mapping)dataMappingList.get(i);
                if (!mapping.getClazz().equals(obj.getClass()))
                {
                    continue;
                }
                j = i;
                if (!(mapping instanceof VersionableCard))
                {
                    break label0;
                }
                j = i;
                if (((VersionableCard)mapping).isSupported(obj))
                {
                    break label0;
                }
            }

            j = -1;
        }
        return j;
    }

    public List getList()
    {
        return list;
    }

    public Mapping getMapping(int i)
    {
        return (Mapping)dataMappingList.get(i);
    }

    public void onBindViewHolder(android.support.v7.widget.RecyclerView.ViewHolder viewholder, int i)
    {
        getMapping(viewholder.getItemViewType()).bindView(i, viewholder, this);
    }

    public android.support.v7.widget.RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewgroup, int i)
    {
        viewgroup = viewgroup.getContext();
        return getMapping(i).createViewHolder(viewgroup, this);
    }

    public void onViewAttachedToWindow(android.support.v7.widget.RecyclerView.ViewHolder viewholder)
    {
        if (imageLoadListener != null && (viewholder.itemView instanceof DealCardBase))
        {
            imageLoadListener.assignToViews((DealCardBase)viewholder.itemView);
        }
    }

    public void putExtras(String s, Object obj)
    {
        extras.put(s, obj);
    }

    public void registerOverrideMapping(Mapping mapping)
    {
        dataMappingList.add(mapping);
    }

    public void setExtras(HashMap hashmap)
    {
        if (hashmap != null)
        {
            extras = hashmap;
        }
    }

    public void setImageLoadListener(AppStartupImageLoadListener appstartupimageloadlistener)
    {
        imageLoadListener = appstartupimageloadlistener;
    }

    public void setList(List list1)
    {
        list = list1;
        notifyDataSetChanged();
    }
}

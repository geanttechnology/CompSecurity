// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.common.view;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.LinearLayoutManager;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.ebay.nautilus.domain.analytics.DeviceInfoUtil;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.ebay.mobile.common.view:
//            ViewModel, ViewHolder

public abstract class RecyclerContentAdapter extends android.support.v7.widget.RecyclerView.Adapter
{
    static class ViewHolderClassToModelMapping
    {

        private final WeakReference contextReference;
        private final SparseArray holderClasses;

        public ViewHolder createViewHolder(ViewGroup viewgroup, int i)
        {
            Context context = (Context)contextReference.get();
            if (context == null)
            {
                return null;
            } else
            {
                return ((HolderClassInfo)holderClasses.get(i)).createViewHolder(viewgroup, LayoutInflater.from(context));
            }
        }

        public void put(int i, Class class1, int j)
        {
            holderClasses.put(i, new HolderClassInfo(class1, j));
        }

        private ViewHolderClassToModelMapping(Context context)
        {
            holderClasses = new SparseArray();
            contextReference = new WeakReference(context);
        }

    }

    static class ViewHolderClassToModelMapping.HolderClassInfo
    {

        private final Constructor constructor;
        private final int layoutResourceId;

        public ViewHolder createViewHolder(ViewGroup viewgroup, LayoutInflater layoutinflater)
        {
            viewgroup = layoutinflater.inflate(layoutResourceId, viewgroup, false);
            try
            {
                viewgroup = (ViewHolder)constructor.newInstance(new Object[] {
                    viewgroup
                });
            }
            // Misplaced declaration of an exception variable
            catch (ViewGroup viewgroup)
            {
                viewgroup.printStackTrace();
                return null;
            }
            return viewgroup;
        }

        public ViewHolderClassToModelMapping.HolderClassInfo(Class class1, int i)
        {
            layoutResourceId = i;
            Object obj = null;
            try
            {
                class1 = class1.getDeclaredConstructor(new Class[] {
                    android/view/View
                });
            }
            // Misplaced declaration of an exception variable
            catch (Class class1)
            {
                class1.printStackTrace();
                class1 = obj;
            }
            constructor = class1;
        }
    }


    protected static boolean isLandscape;
    protected static boolean isTablet;
    protected final WeakReference contextReference;
    protected final List dataSet = new ArrayList();
    private ViewModel.OnClickListener defaultListener;
    private SparseArray listeners;
    private final ViewHolderClassToModelMapping viewHolderClassToModelMapping;

    public RecyclerContentAdapter(Context context)
    {
        contextReference = new WeakReference(context);
        viewHolderClassToModelMapping = new ViewHolderClassToModelMapping(context);
        defaultListener = null;
        listeners = new SparseArray();
        isTablet = context.getResources().getBoolean(0x7f0b0006);
        boolean flag;
        if (!DeviceInfoUtil.isPortrait(context))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        isLandscape = flag;
    }

    public void addViewType(int i, Class class1, int j)
    {
        viewHolderClassToModelMapping.put(i, class1, j);
    }

    public transient void clearOnClickListener(int ai[])
    {
        if (ai == null)
        {
            defaultListener = null;
            listeners.clear();
        } else
        {
            int j = ai.length;
            int i = 0;
            while (i < j) 
            {
                int k = ai[i];
                listeners.delete(k);
                i++;
            }
        }
    }

    public android.support.v7.widget.RecyclerView.LayoutManager createLayoutManager()
    {
        return new LinearLayoutManager((Context)contextReference.get(), 1, false);
    }

    public int getItemCount()
    {
        return dataSet.size();
    }

    public int getItemViewType(int i)
    {
        return ((ViewModel)dataSet.get(i)).viewType;
    }

    public int getNumSpans()
    {
        return !isTablet && !isLandscape ? 1 : 2;
    }

    public ViewModel.OnClickListener getOnClickListener(int i)
    {
        return (ViewModel.OnClickListener)listeners.get(i, defaultListener);
    }

    public int getPositionForViewType(int i)
    {
        for (int j = 0; j < dataSet.size(); j++)
        {
            if (getItemViewType(j) == i)
            {
                return j;
            }
        }

        return -1;
    }

    public volatile void onBindViewHolder(android.support.v7.widget.RecyclerView.ViewHolder viewholder, int i)
    {
        onBindViewHolder((ViewHolder)viewholder, i);
    }

    public void onBindViewHolder(ViewHolder viewholder, int i)
    {
        viewholder.bind((ViewModel)dataSet.get(i));
    }

    public volatile android.support.v7.widget.RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewgroup, int i)
    {
        return onCreateViewHolder(viewgroup, i);
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewgroup, int i)
    {
        return viewHolderClassToModelMapping.createViewHolder(viewgroup, i);
    }

    public transient void setOnClickListener(ViewModel.OnClickListener onclicklistener, int ai[])
    {
        if (ai == null || ai.length == 0)
        {
            defaultListener = onclicklistener;
        } else
        {
            int j = ai.length;
            int i = 0;
            while (i < j) 
            {
                int k = ai[i];
                listeners.put(k, onclicklistener);
                i++;
            }
        }
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import roboguice.util.Strings;

public abstract class MergeAdapter extends BaseAdapter
{

    protected Adapter adapters[];
    private int cumulativeViewTypeBases[];
    protected DataSetObserver dataSetObserver;
    private Integer delegateAdapterIds[];
    private Integer delegateAdapterPosition[];
    private int itemCounts[];
    private int totalItemCount;
    private int totalViewTypeCount;

    public transient MergeAdapter(Adapter aadapter[])
    {
        dataSetObserver = new DataSetObserver() {

            final MergeAdapter this$0;

            public void onChanged()
            {
                init();
                notifyDataSetChanged();
            }

            public void onInvalidated()
            {
                init();
                notifyDataSetInvalidated();
            }

            
            {
                this$0 = MergeAdapter.this;
                super();
            }
        };
        adapters = aadapter;
        int j = aadapter.length;
        for (int i = 0; i < j; i++)
        {
            aadapter[i].registerDataSetObserver(dataSetObserver);
        }

        init();
    }

    protected abstract int chooseAdapter(int i);

    public int getCount()
    {
        return totalItemCount;
    }

    protected Adapter getDelegateAdapter(int i)
    {
        return adapters[delegateAdapterIds[i].intValue()];
    }

    protected int getDelegateAdapterPosition(int i)
    {
        return delegateAdapterPosition[i].intValue();
    }

    public Object getItem(int i)
    {
        return getDelegateAdapter(i).getItem(getDelegateAdapterPosition(i));
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public int getItemViewType(int i)
    {
        return cumulativeViewTypeBases[delegateAdapterIds[i].intValue()] + getDelegateAdapter(i).getItemViewType(getDelegateAdapterPosition(i));
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        return getDelegateAdapter(i).getView(getDelegateAdapterPosition(i), view, viewgroup);
    }

    public int getViewTypeCount()
    {
        return totalViewTypeCount;
    }

    public void init()
    {
        int j = 0;
        this;
        JVM INSTR monitorenter ;
        int ai[];
        totalViewTypeCount = 0;
        totalItemCount = 0;
        itemCounts = new int[adapters.length];
        cumulativeViewTypeBases = new int[adapters.length];
        ai = new int[adapters.length];
        int i = 0;
_L2:
        if (i >= adapters.length)
        {
            break; /* Loop/switch isn't completed */
        }
        Adapter adapter = adapters[i];
        itemCounts[i] = adapter.getCount();
        ai[i] = adapter.getViewTypeCount();
        totalViewTypeCount = totalViewTypeCount + ai[i];
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        int ai1[];
        int k;
        ai1 = itemCounts;
        k = ai1.length;
        i = j;
_L4:
        if (i >= k)
        {
            break; /* Loop/switch isn't completed */
        }
        j = ai1[i];
        totalItemCount = totalItemCount + j;
        i++;
        if (true) goto _L4; else goto _L3
_L5:
        if (i >= adapters.length)
        {
            break MISSING_BLOCK_LABEL_197;
        }
        cumulativeViewTypeBases[i] = cumulativeViewTypeBases[i - 1] + ai[i];
        i++;
          goto _L5
        delegateAdapterIds = new Integer[totalItemCount];
        delegateAdapterPosition = new Integer[totalItemCount];
        ai = new int[adapters.length];
        ai1 = new int[adapters.length];
        i = 0;
_L7:
        if (i >= totalItemCount)
        {
            break; /* Loop/switch isn't completed */
        }
        j = chooseAdapter(i);
        ai1[j] = ai1[j] + 1;
        Integer ainteger[];
        delegateAdapterIds[i] = Integer.valueOf(j);
        ainteger = delegateAdapterPosition;
        k = ai[j];
        ai[j] = k + 1;
        ainteger[i] = Integer.valueOf(k);
        i++;
        if (true) goto _L7; else goto _L6
_L8:
        if (i >= adapters.length)
        {
            break MISSING_BLOCK_LABEL_442;
        }
        if (ai1[i] != itemCounts[i])
        {
            throw new RuntimeException(String.format("Observed count (%s) for adapter %s does not match declared count (%s).  Check your chooseAdapter() method for errors.  chooseAdapter() returned %s \n Actual Count is %s \n Observed Count is %s", new Object[] {
                Integer.valueOf(ai1[i]), Integer.valueOf(i), Integer.valueOf(itemCounts[i]), Strings.join(",", delegateAdapterIds), Strings.join(",", intArrayToIntegerArray(itemCounts)), Strings.join(",", intArrayToIntegerArray(ai1))
            }));
        }
        break MISSING_BLOCK_LABEL_433;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        i++;
          goto _L8
        this;
        JVM INSTR monitorexit ;
        return;
_L3:
        i = 1;
          goto _L5
_L6:
        i = 0;
          goto _L8
    }

    public Integer[] intArrayToIntegerArray(int ai[])
    {
        Integer ainteger[] = new Integer[ai.length];
        for (int i = 0; i < ai.length; i++)
        {
            ainteger[i] = Integer.valueOf(ai[i]);
        }

        return ainteger;
    }
}

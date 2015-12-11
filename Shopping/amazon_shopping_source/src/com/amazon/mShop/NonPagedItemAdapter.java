// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;

// Referenced classes of package com.amazon.mShop:
//            ObjectSubscriberAdapter, AmazonActivity

public abstract class NonPagedItemAdapter extends ObjectSubscriberAdapter
    implements android.widget.AdapterView.OnItemClickListener
{

    protected AdapterView mAdapterView;
    protected LayoutInflater mLayoutInflater;
    protected int mRowResId;

    public NonPagedItemAdapter(AmazonActivity amazonactivity, int i)
    {
        super(amazonactivity);
        mLayoutInflater = LayoutInflater.from(amazonactivity);
        mRowResId = i;
    }

    public void forward(int i, View view)
    {
        if (i < 0 || i >= getCount())
        {
            return;
        } else
        {
            getAmazonActivity().forward(makeObjectForForward(i, view));
            return;
        }
    }

    protected int getAdapterViewHeaderViewsCount()
    {
        return 0;
    }

    protected abstract Object makeObjectForForward(int i, View view);

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        int j;
        if (mAdapterView == null)
        {
            j = 0;
        } else
        {
            j = getAdapterViewHeaderViewsCount();
        }
        forward(i - j, view);
    }

    public void setAdapterView(AdapterView adapterview)
    {
        mAdapterView = adapterview;
        adapterview.setAdapter(this);
        adapterview.setOnItemClickListener(this);
    }
}

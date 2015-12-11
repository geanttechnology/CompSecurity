// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.cvsd;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

// Referenced classes of package com.amazon.mShop.cvsd:
//            CVSDMapActivity

private class cation extends BaseAdapter
{

    private final Context mContext;
    private final CharSequence mItems[];
    private final LayoutInflater mLayoutInflater;
    final CVSDMapActivity this$0;

    public int getCount()
    {
        return mItems.length;
    }

    public Object getItem(int i)
    {
        return mItems[i];
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        viewgroup = view;
        if (view == null)
        {
            viewgroup = mLayoutInflater.inflate(com.amazon.mShop.android.lib.Inflater, null);
        }
        view = (TextView)viewgroup.findViewById(com.amazon.mShop.android.lib.Inflater);
        view.setTextSize(0, view.getResources().getDimension(com.amazon.mShop.android.lib.Inflater));
        view.setText(mItems[i]);
        return viewgroup;
    }

    public (Context context)
    {
        this$0 = CVSDMapActivity.this;
        super();
        mContext = context;
        mLayoutInflater = LayoutInflater.from(mContext);
        mItems = (new CharSequence[] {
            mContext.getResources().getString(com.amazon.mShop.android.lib.t), mContext.getResources().getString(com.amazon.mShop.android.lib.t), mContext.getResources().getString(com.amazon.mShop.android.lib.t), mContext.getResources().getString(com.amazon.mShop.android.lib.t)
        });
    }
}

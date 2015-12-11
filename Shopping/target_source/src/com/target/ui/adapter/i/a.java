// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.adapter.i;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;
import com.target.mothership.common.store.StoreIdentifier;
import com.target.mothership.model.common.Address;
import com.target.mothership.model.store.interfaces.RelevantStoreSummary;
import com.target.mothership.model.store.interfaces.StoreSummary;
import com.target.mothership.util.o;
import com.target.ui.adapter.b.e;
import com.target.ui.service.k;
import com.target.ui.util.ae;
import com.target.ui.util.u;
import java.util.List;

public class com.target.ui.adapter.i.a extends e
    implements android.view.View.OnClickListener
{
    public static interface a
    {

        public abstract void a();

        public abstract void a(StoreIdentifier storeidentifier);

        public abstract void a(StoreSummary storesummary);
    }

    public static class b
    {

        public int position;
        public View root;
        public TextView storeAddress;
        public RadioButton storeChoice;
        public ImageButton storeInfo;
        public TextView storeLabels;
        public TextView storeName;

        public b(View view)
        {
            position = -1;
            root = view;
            storeName = (TextView)view.findViewById(0x7f100323);
            storeAddress = (TextView)view.findViewById(0x7f100324);
            storeLabels = (TextView)view.findViewById(0x7f100325);
            storeInfo = (ImageButton)view.findViewById(0x7f100327);
            storeChoice = (RadioButton)view.findViewById(0x7f100322);
        }
    }


    private static final int NULL_INT = -1;
    private boolean mHasStoreOverride;
    private a mListener;
    private int mSelectedPosition;
    private final List mStores;

    public com.target.ui.adapter.i.a(Context context, List list, a a1)
    {
        super(context, list);
        mSelectedPosition = -1;
        mStores = list;
        mListener = a1;
        a();
    }

    private void a()
    {
        mSelectedPosition = -1;
    }

    public void a(boolean flag)
    {
        mHasStoreOverride = flag;
    }

    public int getCount()
    {
        return mStores.size();
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        Object obj = (RelevantStoreSummary)getItem(i);
        String s;
        boolean flag;
        if (view == null)
        {
            view = mInflater.inflate(0x7f030113, null, false);
            viewgroup = new b(view);
            view.setTag(viewgroup);
            view.setOnClickListener(this);
        } else
        {
            viewgroup = (b)view.getTag();
        }
        viewgroup.position = i;
        ((b) (viewgroup)).storeName.setText(((RelevantStoreSummary) (obj)).getName());
        s = ae.a(((RelevantStoreSummary) (obj)), (RelevantStoreSummary)k.a().c().d(), mHasStoreOverride, getContext());
        if (o.g(s))
        {
            ((b) (viewgroup)).storeLabels.setText(s);
            ((b) (viewgroup)).storeLabels.setVisibility(0);
            ((b) (viewgroup)).storeAddress.setVisibility(8);
        } else
        {
            ((b) (viewgroup)).storeAddress.setText((CharSequence)((RelevantStoreSummary) (obj)).getAddress().getAddressLines().get(0));
            ((b) (viewgroup)).storeAddress.setVisibility(0);
            ((b) (viewgroup)).storeLabels.setVisibility(8);
        }
        obj = ((b) (viewgroup)).storeChoice;
        if (i == mSelectedPosition)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        ((RadioButton) (obj)).setChecked(flag);
        ((b) (viewgroup)).storeChoice.setTag(viewgroup);
        ((b) (viewgroup)).storeChoice.setOnClickListener(this);
        ((b) (viewgroup)).storeInfo.setTag(viewgroup);
        ((b) (viewgroup)).storeInfo.setOnClickListener(this);
        return view;
    }

    public void onClick(View view)
    {
        Object obj = (b)u.a(view.getTag(), com/target/ui/adapter/i/a$b);
        if (obj == null)
        {
            mListener.a();
            return;
        }
        int i = ((b) (obj)).position;
        if (i >= 0 && i < mStores.size())
        {
            obj = (StoreSummary)mStores.get(((b) (obj)).position);
        } else
        {
            obj = null;
        }
        if (obj == null)
        {
            mListener.a();
            return;
        }
        if (view.getId() == 0x7f100327)
        {
            mListener.a(((StoreSummary) (obj)).getStoreId());
            return;
        }
        if (mSelectedPosition != i)
        {
            mSelectedPosition = i;
            notifyDataSetInvalidated();
            mListener.a(((StoreSummary) (obj)));
            return;
        } else
        {
            mListener.a();
            return;
        }
    }
}

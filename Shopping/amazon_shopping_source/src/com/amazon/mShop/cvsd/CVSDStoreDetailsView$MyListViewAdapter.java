// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.cvsd;

import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Checkable;
import android.widget.CheckedTextView;
import android.widget.ListAdapter;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.control.cvsd.CVSDReceivedResult;
import com.amazon.mShop.ui.resources.AddressFormat;
import com.amazon.mShop.util.Util;
import com.amazon.rio.j2me.client.services.mShop.Address;
import java.util.List;

// Referenced classes of package com.amazon.mShop.cvsd:
//            CVSDStoreDetailsView

private class <init>
    implements android.widget.dapter, ListAdapter
{

    final CVSDStoreDetailsView this$0;

    public boolean areAllItemsEnabled()
    {
        return true;
    }

    public int getCount()
    {
        return CVSDReceivedResult.receivedAddresss.size();
    }

    public Object getItem(int i)
    {
        return null;
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public int getItemViewType(int i)
    {
        return 0;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        viewgroup = (CheckedTextView)view;
        view = viewgroup;
        if (viewgroup == null)
        {
            view = (CheckedTextView)CVSDStoreDetailsView.access$100(CVSDStoreDetailsView.this).inflate(com.amazon.mShop.android.lib.I, null);
        }
        Address address = (Address)CVSDReceivedResult.receivedAddresss.get(0);
        String s = AddressFormat.formatAddress(address, 2);
        viewgroup = s;
        if (!Util.isEmpty(address.getInformation()))
        {
            viewgroup = (new StringBuilder()).append(s).append("\n").append(address.getInformation()).toString();
        }
        view.setText(viewgroup);
        return view;
    }

    public int getViewTypeCount()
    {
        return 1;
    }

    public boolean hasStableIds()
    {
        return false;
    }

    public boolean isEmpty()
    {
        return getCount() == 0;
    }

    public boolean isEnabled(int i)
    {
        return true;
    }

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        i = 0;
        while (i < adapterview.getChildCount()) 
        {
            View view1 = adapterview.getChildAt(i);
            if (view1 instanceof Checkable)
            {
                Checkable checkable = (Checkable)view1;
                boolean flag;
                if (view1 == view)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                checkable.setChecked(flag);
            }
            i++;
        }
        CVSDStoreDetailsView.access$200(CVSDStoreDetailsView.this).setResult(-1);
        CVSDStoreDetailsView.access$200(CVSDStoreDetailsView.this).finish();
    }

    public void registerDataSetObserver(DataSetObserver datasetobserver)
    {
    }

    public void unregisterDataSetObserver(DataSetObserver datasetobserver)
    {
    }

    private ()
    {
        this$0 = CVSDStoreDetailsView.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.groupon.manager.BusinessTipsSyncManager;
import commonlib.adapter.EndlessAdapter;

// Referenced classes of package com.groupon.fragment:
//            BusinessTipsFragment

private class this._cls0 extends EndlessAdapter
{

    final BusinessTipsFragment this$0;

    protected View createPendingView(ViewGroup viewgroup)
    {
        return LayoutInflater.from(viewgroup.getContext()).inflate(0x7f030201, null);
    }

    public int getCount()
    {
        if (!forceStopAppending && getWrappedAdapter().getCount() == 0)
        {
            return 1;
        } else
        {
            return super.getCount();
        }
    }

    public int getItemViewType(int i)
    {
        if (!forceStopAppending && getWrappedAdapter().getCount() == 0 && i == 0)
        {
            return getWrappedAdapter().getViewTypeCount();
        } else
        {
            return super.getItemViewType(i);
        }
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        if (!forceStopAppending && getWrappedAdapter().getCount() == 0 && i == 0)
        {
            return getPendingView(viewgroup);
        } else
        {
            return super.getView(i, view, viewgroup);
        }
    }

    protected void requestNextPage()
    {
        BusinessTipsFragment.access$200(BusinessTipsFragment.this).requestSyncNextPage(BusinessTipsFragment.this, null);
    }

    public (ListAdapter listadapter)
    {
        this$0 = BusinessTipsFragment.this;
        super(listadapter);
    }
}

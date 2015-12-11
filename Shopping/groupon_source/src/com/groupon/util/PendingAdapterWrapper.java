// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.commonsware.cwac.adapter.AdapterWrapper;
import commonlib.adapter.PendingAdapterInterface;

public class PendingAdapterWrapper extends AdapterWrapper
    implements PendingAdapterInterface
{

    private boolean forceStopAppending;
    private View pendingView;

    public PendingAdapterWrapper(ListAdapter listadapter)
    {
        super(listadapter);
        forceStopAppending = false;
    }

    protected View createPendingView(ViewGroup viewgroup)
    {
        viewgroup = LayoutInflater.from(viewgroup.getContext()).inflate(0x7f030201, null);
        viewgroup.setOnClickListener(new android.view.View.OnClickListener() {

            final PendingAdapterWrapper this$0;

            public void onClick(View view)
            {
            }

            
            {
                this$0 = PendingAdapterWrapper.this;
                super();
            }
        });
        return viewgroup;
    }

    public void enableAppending(boolean flag)
    {
        if (forceStopAppending == flag)
        {
            if (!flag)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            forceStopAppending = flag;
            notifyDataSetChanged();
        }
    }

    public int getCount()
    {
        if (!forceStopAppending && super.getCount() == 0)
        {
            return 1;
        } else
        {
            return super.getCount();
        }
    }

    protected View getPendingView(ViewGroup viewgroup)
    {
        if (pendingView == null)
        {
            pendingView = createPendingView(viewgroup);
        }
        return pendingView;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        if (i >= super.getCount())
        {
            return getPendingView(viewgroup);
        } else
        {
            return super.getView(i, view, viewgroup);
        }
    }
}

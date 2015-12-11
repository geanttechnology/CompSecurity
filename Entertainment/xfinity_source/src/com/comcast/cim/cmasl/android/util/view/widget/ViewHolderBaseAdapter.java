// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.android.util.view.widget;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.comcast.cim.cmasl.utils.CommonUtils;

// Referenced classes of package com.comcast.cim.cmasl.android.util.view.widget:
//            AdapterDelegate

public abstract class ViewHolderBaseAdapter extends BaseAdapter
{

    private AdapterDelegate adapterDelegate;

    public ViewHolderBaseAdapter(LayoutInflater layoutinflater)
    {
        adapterDelegate = new AdapterDelegate(layoutinflater) {

            final ViewHolderBaseAdapter this$0;

            protected void bindItem(Object obj, Object obj1)
            {
                ViewHolderBaseAdapter.this.bindItem(obj, obj1);
            }

            protected Object createViewHolder()
            {
                return ViewHolderBaseAdapter.this.createViewHolder();
            }

            protected Object getItem(int i)
            {
                return CommonUtils.uncheckedCast(ViewHolderBaseAdapter.this.getItem(i));
            }

            protected int getViewLayoutId()
            {
                return ViewHolderBaseAdapter.this.getViewLayoutId();
            }

            protected void initializeViewHolder(View view, ViewGroup viewgroup, Object obj)
            {
                ViewHolderBaseAdapter.this.initializeViewHolder(view, viewgroup, obj);
            }

            
            {
                this$0 = ViewHolderBaseAdapter.this;
                super(layoutinflater);
            }
        };
    }

    protected abstract void bindItem(Object obj, Object obj1);

    protected abstract Object createViewHolder();

    public long getItemId(int i)
    {
        return 0L;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        return adapterDelegate.getView(i, view, viewgroup);
    }

    protected abstract int getViewLayoutId();

    protected abstract void initializeViewHolder(View view, ViewGroup viewgroup, Object obj);
}

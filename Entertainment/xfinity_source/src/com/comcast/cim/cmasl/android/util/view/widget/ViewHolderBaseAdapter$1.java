// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.android.util.view.widget;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.comcast.cim.cmasl.utils.CommonUtils;

// Referenced classes of package com.comcast.cim.cmasl.android.util.view.widget:
//            AdapterDelegate, ViewHolderBaseAdapter

class this._cls0 extends AdapterDelegate
{

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

    (LayoutInflater layoutinflater)
    {
        this$0 = ViewHolderBaseAdapter.this;
        super(layoutinflater);
    }
}

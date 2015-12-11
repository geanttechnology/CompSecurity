// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.android.util.view.widget;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.comcast.cim.cmasl.utils.CommonUtils;

public abstract class AdapterDelegate
{

    private LayoutInflater inflater;

    public AdapterDelegate(LayoutInflater layoutinflater)
    {
        inflater = layoutinflater;
    }

    protected abstract void bindItem(Object obj, Object obj1);

    protected abstract Object createViewHolder();

    protected abstract Object getItem(int i);

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        if (view == null)
        {
            view = inflater.inflate(getViewLayoutId(), viewgroup, false);
            Object obj = createViewHolder();
            initializeViewHolder(view, viewgroup, obj);
            view.setTag(obj);
            viewgroup = ((ViewGroup) (obj));
        } else
        {
            viewgroup = ((ViewGroup) (CommonUtils.uncheckedCast(view.getTag())));
        }
        bindItem(viewgroup, CommonUtils.uncheckedCast(getItem(i)));
        return view;
    }

    protected abstract int getViewLayoutId();

    protected abstract void initializeViewHolder(View view, ViewGroup viewgroup, Object obj);
}

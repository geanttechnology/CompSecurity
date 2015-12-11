// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.goods.shoppingcart.v3;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.groupon.v3.adapter.mapping.Mapping;
import com.groupon.v3.view.holder.GrouponViewHolder;

public abstract class FixedMapping extends Mapping
{

    public FixedMapping(Class class1)
    {
        super(class1);
    }

    public abstract View createView(Context context, ViewGroup viewgroup);

    public android.support.v7.widget.RecyclerView.ViewHolder createViewHolder(Context context, ViewGroup viewgroup)
    {
        return new GrouponViewHolder(createView(context, viewgroup));
    }
}

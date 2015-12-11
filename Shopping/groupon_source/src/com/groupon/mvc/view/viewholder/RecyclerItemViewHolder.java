// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.mvc.view.viewholder;

import android.view.View;
import butterknife.ButterKnife;
import com.groupon.tracking.mobile.sdk.Logger;

public abstract class RecyclerItemViewHolder extends android.support.v7.widget.RecyclerView.ViewHolder
{

    protected Object callback;
    protected Logger logger;
    protected Object model;

    public RecyclerItemViewHolder(View view)
    {
        super(view);
        ButterKnife.bind(this, view);
    }

    public void bind(Object obj, Object obj1)
    {
        model = obj;
        callback = obj1;
    }

    public abstract void populateViews();
}

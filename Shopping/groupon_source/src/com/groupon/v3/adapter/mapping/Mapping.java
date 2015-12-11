// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.v3.adapter.mapping;

import android.content.Context;
import android.view.View;
import com.groupon.v3.adapter.UniversalListAdapter;
import com.groupon.v3.adapter.callback.IViewCallback;
import com.groupon.v3.view.holder.GrouponViewHolder;
import java.util.HashMap;

public abstract class Mapping
{

    protected HashMap callbackMapping;
    protected Class clazz;

    public Mapping(Class class1)
    {
        callbackMapping = new HashMap();
        clazz = class1;
    }

    public void bindView(int i, android.support.v7.widget.RecyclerView.ViewHolder viewholder, UniversalListAdapter universallistadapter)
    {
    }

    public abstract View createView(Context context);

    public android.support.v7.widget.RecyclerView.ViewHolder createViewHolder(Context context, UniversalListAdapter universallistadapter)
    {
        return new GrouponViewHolder(createView(context));
    }

    protected Object getCallback(Class class1)
    {
        return callbackMapping.get(class1);
    }

    public Class getClazz()
    {
        return clazz;
    }

    protected GrouponViewHolder getHolderWithCallback(Context context, UniversalListAdapter universallistadapter)
    {
        return new GrouponViewHolder(createView(context)) {

            final Mapping this$0;

            public void onClick(View view)
            {
                IViewCallback iviewcallback = (IViewCallback)getCallback(com/groupon/v3/adapter/callback/IViewCallback);
                if (iviewcallback != null)
                {
                    iviewcallback.onViewClick(view);
                }
            }

            
            {
                this$0 = Mapping.this;
                super(view);
            }
        };
    }

    public boolean getSpanAllColumns()
    {
        return false;
    }

    public Mapping registerCallback(Class class1, Object obj)
    {
        callbackMapping.put(class1, obj);
        return this;
    }
}
